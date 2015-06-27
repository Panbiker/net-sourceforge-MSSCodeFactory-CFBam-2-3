--
--	@(#) dbcreate/cfbam/pgsql/crsp_update_hostnode.pgsql
--
--	CFBam
--
--	Copyright (c) 2014-2015 Mark Sobkow
--	
--	This program is available as free software under the GNU GPL v3, under
--	the Eclipse Public License 1.0, or under a commercial license from Mark
--	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
--	
--	You should have received copies of the complete license text for
--	GPLv3.txt and EPLv1_0.txt, containing the text
--	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
--	
--	Under the terms of the GPL:
--	
--		This program is free software: you can redistribute it and/or modify
--		it under the terms of the GNU General Public License as published by
--		the Free Software Foundation, either version 3 of the License, or
--		(at your option) any later version.
--	  
--		This program is distributed in the hope that it will be useful,
--		but WITHOUT ANY WARRANTY; without even the implied warranty of
--		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--		GNU General Public License for more details.
--	  
--		You should have received a copy of the GNU General Public License
--		along with this program.  If not, see <http://www.gnu.org/licenses/>.
--	
--	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
--	and licensed under the BSD 3-Clause license as written by xfree86.org:
--	
--	Redistribution and use in source and binary forms, with or without
--	modification, are permitted provided that the following conditions are
--	met:
--	
--	    (1) Redistributions of source code must retain the above copyright
--	    notice, this list of conditions and the following disclaimer. 
--	
--	    (2) Redistributions in binary form must reproduce the above copyright
--	    notice, this list of conditions and the following disclaimer in
--	    the documentation and/or other materials provided with the
--	    distribution.  
--	    
--	    (3)The name of the author may not be used to
--	    endorse or promote products derived from this software without
--	    specific prior written permission.
--	
--	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
--	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
--	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
--	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
--	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
--	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
--	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
--	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
--	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
--	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
--	POSSIBILITY OF SUCH DAMAGE.
--	
--
-- **********************************************************************
--
--	Code manufactured by MSS Code Factory
--


create or replace function cfbam23.sp_update_hostnode(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argClusterId bigint,
	argHostNodeId bigint,
	argDescription varchar(255),
	argHostName varchar(192),
	argRevision integer )
returns setof cfbam23.type_hostnode_rec as $$
declare
	RowsAffected integer;
	oldClusterId bigint;
	oldHostNodeId bigint;
	oldDescription varchar(255);
	oldHostName varchar(192);
	oldRevision int;
	permissionFlag boolean;
begin
	if( argClassCode = 'HSND' )
	then
		select cfbam23.sp_is_cluster_user( argClusterId,
			'UpdateHostNode',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in cluster SecGroup for UpdateHostNode';
		end if;
	end if;

		select
			ClusterId,
			HostNodeId,
			Description,
			HostName,
			revision
		into
			oldClusterId,
			oldHostNodeId,
			oldDescription,
			oldHostName,
			oldRevision
		from cfbam23.HostNode
		where
			ClusterId = argClusterId
			and HostNodeId = argHostNodeId
		for update;


	if argRevision != oldRevision
	then
		raise exception 'sp_update_hostnode() Data collision detected';
	end if;


	update cfbam23.HostNode
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = now(),
		description = argDescription,
		hostname = argHostName
	where
		ClusterId = argClusterId
			and HostNodeId = argHostNodeId
		and revision = oldRevision;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_hostnode() Expected to affect one HostNode row, not %', RowsAffected;
	end if;


	insert into cfbam23.HostNode_h (
			ClusterId,
			HostNodeId,
			auditclusterid,
			auditsessionid,
			auditstamp,
			Description,
			HostName,
			revision,
			auditaction )
		select
			hsnd.ClusterId,
			hsnd.HostNodeId,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			hsnd.Description,
			hsnd.HostName,
			argRevision + 1,
			2
		from cfbam23.HostNode as hsnd
		where
			hsnd.clusterid = argClusterId
			and hsnd.hostnodeid = argHostNodeId;
	return query select
			hsnd.createdby,
			to_char( hsnd.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			hsnd.updatedby,
			to_char( hsnd.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			hsnd.clusterid as clusterid,
			hsnd.hostnodeid as hostnodeid,
			hsnd.description as description,
			hsnd.hostname as hostname,
		hsnd.revision as revision
	from cfbam23.HostNode as hsnd
	where
		hsnd.clusterid = argClusterId
			and hsnd.hostnodeid = argHostNodeId;

	return;
end;
$$ language plpgsql;
