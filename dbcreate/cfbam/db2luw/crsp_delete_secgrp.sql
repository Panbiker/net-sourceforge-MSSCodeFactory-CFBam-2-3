--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_secgrp.sql
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

create or replace procedure sp_delete_secgrp(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClusterId bigint,	\
	in argSecGroupId integer,	\
	in argRevision int )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClusterId bigint;	\
	declare oldSecGroupId integer;	\
	declare oldName varchar(64);	\
	declare oldRevision int;	\
	declare subret boolean;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select 1 from sysibm.sysdummy1;	\
	begin	\
		select	\
			ClusterId,	\
			SecGroupId,	\
			Name,	\
			revision	\
		into	\
			oldClusterId,	\
			oldSecGroupId,	\
			oldName,	\
			oldRevision	\
		from cfbam23.SecGrp	\
		where	\
			ClusterId = argClusterId	\
			and SecGroupId = argSecGroupId	\
		for update;	\
	\
		if( oldClusterId != secClusterId )	\
		then	\
			set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20002, 'Permission denied -- Data is not owned by logged in cluster' );	\
			end if;	\
		end if;	\
	\
		set( permissionFlag ) = ( sp_is_cluster_user( oldClusterId,	\
				'DeleteSecGroup',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20002, 'Permission denied -- User not found in cluster SecGroup for DeleteSecGroup' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_secgrp() Data collision detected' );	\
		end if;	\
	\
		for cur as	\
			select	\
				sgfm.clusid as clusid,	\
				sgfm.secgrpfrmid as secgrpfrmid	\
			from cfbam23.SecGrp as sgrp	\
				inner join cfbam23.secgrpfrm sgfm on 	\
					sgrp.clusterid = sgfm.clusid	\
					and sgrp.secgroupid = sgfm.secgrpid	\
			where	\
				sgrp.clusterid = argClusterId	\
				and sgrp.secgroupid = argSecGroupId	\
		do	\
			call sp_delete_secgrpfrm_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					clusid,	\
					secgrpfrmid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sgnc.clusid as clusid,	\
				sgnc.secgrpincid as secgrpincid	\
			from cfbam23.SecGrp as sgrp	\
				inner join cfbam23.secinc sgnc on 	\
					sgrp.clusterid = sgnc.clusid	\
					and sgrp.secgroupid = sgnc.incgrpid	\
			where	\
				sgrp.clusterid = argClusterId	\
				and sgrp.secgroupid = argSecGroupId	\
		do	\
			call sp_delete_secinc_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					clusid,	\
					secgrpincid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sgmb.clusterid as clusterid,	\
				sgmb.secgroupmemberid as secgroupmemberid	\
			from cfbam23.SecGrp as sgrp	\
				inner join cfbam23.secmemb sgmb on 	\
					sgrp.clusterid = sgmb.clusterid	\
					and sgrp.secgroupid = sgmb.secgroupid	\
			where	\
				sgrp.clusterid = argClusterId	\
				and sgrp.secgroupid = argSecGroupId	\
		do	\
			call sp_delete_secmemb_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					clusterid,	\
					secgroupmemberid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sgnc.clusid as clusid,	\
				sgnc.secgrpincid as secgrpincid	\
			from cfbam23.SecGrp as sgrp	\
				inner join cfbam23.secinc sgnc on 	\
					sgrp.clusterid = sgnc.clusid	\
					and sgrp.secgroupid = sgnc.secgrpid	\
			where	\
				sgrp.clusterid = argClusterId	\
				and sgrp.secgroupid = argSecGroupId	\
		do	\
			call sp_delete_secinc_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					clusid,	\
					secgrpincid );	\
		end for;	\
	\
		insert into cfbam23.SecGrp_h (	\
				clusterid,	\
				secgroupid,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				name,	\
			revision,	\
			auditaction )	\
		select	\
				sgrp.clusterid,	\
				sgrp.secgroupid,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				sgrp.name,	\
			sgrp.revision + 1,	\
			3	\
		from cfbam23.SecGrp as sgrp	\
		where	\
			sgrp.clusterid = argClusterId	\
		and sgrp.secgroupid = argSecGroupId;	\
	\
		delete from cfbam23.SecGrp	\
		where	\
			clusterid = argClusterId	\
			and secgroupid = argSecGroupId;	\
	\
		open retcursor;	\
	end;	\
end
