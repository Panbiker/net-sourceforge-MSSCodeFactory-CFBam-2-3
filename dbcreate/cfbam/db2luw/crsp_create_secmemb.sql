--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_secmemb.sql
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

create or replace procedure sp_create_secmemb(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argClusterId bigint,	\
	in argSecGroupId integer,	\
	in argSecUserId varchar(36) )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare permissionFlag integer;	\
		declare argSecGroupMemberId bigint;	\
	declare retcursor cursor with return to client for	\
		select	\
				sgmb.createdby as createdby,	\
				to_char( sgmb.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				sgmb.updatedby as updatedby,	\
				to_char( sgmb.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			sgmb.clusterid as clusterid,	\
			sgmb.secgroupmemberid as secgroupmemberid,	\
			sgmb.secgroupid as secgroupid,	\
			sgmb.secuserid as secuserid,	\
			sgmb.revision as revision	\
		from cfbam23.SecMemb as sgmb	\
		where	\
			sgmb.clusterid = argClusterId	\
		and sgmb.secgroupmemberid = argSecGroupMemberId;	\
	begin	\
		if( argClassCode = 'SGMB' )	\
		then	\
			set( permissionFlag ) = ( sp_is_cluster_user( argClusterId,	\
					'CreateSecGroupMember',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20002, 'Permission denied -- User not found in cluster SecGroup for CreateSecGroupMember' );	\
			end if;	\
		end if;	\
	\
		call sp_next_secgroupmemberidgen( argClusterId,	\
			argSecGroupMemberId );	\
		insert into cfbam23.secmemb(	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			clusterid,	\
			secgroupmemberid,	\
			secgroupid,	\
			secuserid,	\
			revision )	\
		values (	\
			argAuditUserId,	\
			current timestamp,	\
			argAuditUserId,	\
			current timestamp,	\
			argClusterId,	\
			argSecGroupMemberId,	\
			argSecGroupId,	\
			argSecUserId,	\
			1 );	\
	\
		insert into cfbam23.secmemb_h (	\
				clusterid,	\
				secgroupmemberid,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				secgroupid,	\
				secuserid,	\
				revision,	\
				auditaction )	\
		select	\
				sgmb.clusterid,	\
				sgmb.secgroupmemberid,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				sgmb.secgroupid,	\
				sgmb.secuserid,	\
				sgmb.revision,	\
				1	\
		from cfbam23.SecMemb as sgmb	\
		where	\
				sgmb.clusterid = argClusterId	\
		and sgmb.secgroupmemberid = argSecGroupMemberId;	\
	\
		open retcursor;	\
	end;	\
end
