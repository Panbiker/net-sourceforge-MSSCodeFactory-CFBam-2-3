--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_clus.pgsql
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

create or replace function cfbam23.sp_delete_clus(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argId bigint,
	argRevision int )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	oldId bigint;
	oldFullDomainName varchar(192);
	oldDescription varchar(128);
	oldRevision int;
	permissionFlag boolean;
begin
		select
			Id,
			FullDomainName,
			Description,
			revision
		into
			oldId,
			oldFullDomainName,
			oldDescription,
			oldRevision
		from cfbam23.clus
		where
			Id = argId
		for update;

	select cfbam23.sp_is_system_user( argAuditUserId ) into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- only system user can delete Cluster records';
	end if;

	insert into cfbam23.clus_h (
			Id,
			auditclusterid,
			auditsessionid,
			auditstamp,
			FullDomainName,
			Description,
			revision,
			auditaction )
		select
			clus.Id,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			clus.FullDomainName,
			clus.Description,
			argRevision + 1,
			3
		from cfbam23.clus as clus
		where
			clus.id = argId;

	for cur in
		select
			sgfm.ClusId,
			sgfm.SecGrpFrmId
		from cfbam23.clus as clus
			inner join cfbam23.secgrp sgrp on 
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secgrpfrm sgfm on 
				sgrp.ClusterId = sgfm.ClusId
				and sgrp.SecGroupId = sgfm.SecGrpId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secgrpfrm_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupFormId )
			into subret;
	end loop;

	for cur in
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.clus as clus
			inner join cfbam23.secgrp sgrp on 
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secinc sgnc on 
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.IncGrpId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secinc_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupIncludeId )
			into subret;
	end loop;

	for cur in
		select
			sgmb.ClusterId,
			sgmb.SecGroupMemberId
		from cfbam23.clus as clus
			inner join cfbam23.secgrp sgrp on 
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secmemb sgmb on 
				sgrp.ClusterId = sgmb.ClusterId
				and sgrp.SecGroupId = sgmb.SecGroupId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secmemb_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupMemberId )
			into subret;
	end loop;

	for cur in
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.clus as clus
			inner join cfbam23.secgrp sgrp on 
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secinc sgnc on 
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.SecGrpId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secinc_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupIncludeId )
			into subret;
	end loop;

	for cur in
		select
			sgrp.ClusterId,
			sgrp.SecGroupId
		from cfbam23.clus as clus
			inner join cfbam23.secgrp sgrp on 
				clus.Id = sgrp.ClusterId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secgrp_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupId )
			into subret;
	end loop;

	for cur in
		select
			sfrm.ClusterId,
			sfrm.SecFormId
		from cfbam23.clus as clus
			inner join cfbam23.secapp sapp on 
				clus.Id = sapp.ClusterId
			inner join cfbam23.secform sfrm on 
				sapp.ClusterId = sfrm.ClusterId
				and sapp.SecAppId = sfrm.SecAppId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secform_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecFormId )
			into subret;
	end loop;

	for cur in
		select
			sapp.ClusterId,
			sapp.SecAppId
		from cfbam23.clus as clus
			inner join cfbam23.secapp sapp on 
				clus.Id = sapp.ClusterId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_secapp_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecAppId )
			into subret;
	end loop;

	for cur in
		select
			tent.Id
		from cfbam23.clus as clus
			inner join cfbam23.tenant tent on 
				clus.Id = tent.ClusterId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_tenant_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			hsnd.ClusterId,
			hsnd.HostNodeId
		from cfbam23.clus as clus
			inner join cfbam23.hostnode hsnd on 
				clus.Id = hsnd.ClusterId
		where
			clus.Id = argId
	loop
		select cfbam23.sp_delete_hostnode_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.HostNodeId )
			into subret;
	end loop;


	delete from cfbam23.clus
	where
		id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_clus() Expected to affect 1 clus, not %', RowsAffected;
	end if;

	return true;
end;
$$ language plpgsql;
