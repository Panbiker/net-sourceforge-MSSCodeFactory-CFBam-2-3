--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_tenant.pgsql
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

create or replace function cfbam23.sp_delete_tenant(
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
	oldClusterId bigint;
	oldId bigint;
	oldTenantName varchar(192);
	oldRevision int;
	permissionFlag boolean;
begin
		select
			ClusterId,
			Id,
			TenantName,
			revision
		into
			oldClusterId,
			oldId,
			oldTenantName,
			oldRevision
		from cfbam23.tenant
		where
			Id = argId
		for update;

	select cfbam23.sp_is_system_user( argAuditUserId ) into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- only system user can delete Tenant records';
	end if;

	insert into cfbam23.tenant_h (
			Id,
			auditclusterid,
			auditsessionid,
			auditstamp,
			ClusterId,
			TenantName,
			revision,
			auditaction )
		select
			tent.Id,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			tent.ClusterId,
			tent.TenantName,
			argRevision + 1,
			3
		from cfbam23.tenant as tent
		where
			tent.id = argId;

	for cur in
		select
			reld.TenantId as TenantId,
			reld.Id as Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			tent.Id = argId
	loop
		update cfbam23.reldef
		set
			NarrowedTenantId = null,
			NarrowedId = null
		where
			TenantId = cur.TenantId
			and Id = cur.Id;

	end loop;

	for cur in
		select
			chn.TenantId,
			chn.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.chain_def chn on 
				tbld.TenantId = chn.TenantId
				and tbld.Id = chn.TableId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_chain_def_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			relc.TenantId,
			relc.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
			inner join cfbam23.relcol relc on 
				reld.TenantId = relc.TenantId
				and reld.Id = relc.RelationId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_relcol_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			reld.TenantId,
			reld.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_reldef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			tbld.TenantId,
			tbld.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tbldef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			valu.TenantId,
			valu.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
			inner join cfbam23.valdef valu on 
				schm.TenantId = valu.TenantId
				and schm.Id = valu.ScopeId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_valdef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			schm.TenantId,
			schm.Id
		from cfbam23.tenant as tent
			inner join cfbam23.schemadef schm on 
				tent.Id = schm.TenantId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_schemadef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			tdom.TenantId,
			tdom.Id
		from cfbam23.tenant as tent
			inner join cfbam23.tlddef gtld on 
				tent.Id = gtld.TenantId
			inner join cfbam23.tdomdef tdom on 
				gtld.TenantId = tdom.TenantId
				and gtld.TldId = tdom.TldId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tdomdef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			gtld.TenantId,
			gtld.TldId
		from cfbam23.tenant as tent
			inner join cfbam23.tlddef gtld on 
				tent.Id = gtld.TenantId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tlddef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TldId )
			into subret;
	end loop;

	for cur in
		select
			bdom.TenantId,
			bdom.Id
		from cfbam23.tenant as tent
			inner join cfbam23.bdomdef bdom on 
				tent.Id = bdom.TenantId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_bdomdef_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;

	for cur in
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.tenant as tent
			inner join cfbam23.tsecgrp tgrp on 
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecinc tgnc on 
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.IncGrpId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tsecinc_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupIncludeId )
			into subret;
	end loop;

	for cur in
		select
			tgmb.TenantId,
			tgmb.TSecGroupMemberId
		from cfbam23.tenant as tent
			inner join cfbam23.tsecgrp tgrp on 
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecmemb tgmb on 
				tgrp.TenantId = tgmb.TenantId
				and tgrp.TSecGroupId = tgmb.TSecGroupId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tsecmemb_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupMemberId )
			into subret;
	end loop;

	for cur in
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.tenant as tent
			inner join cfbam23.tsecgrp tgrp on 
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecinc tgnc on 
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.TSecGrpId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tsecinc_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupIncludeId )
			into subret;
	end loop;

	for cur in
		select
			tgrp.TenantId,
			tgrp.TSecGroupId
		from cfbam23.tenant as tent
			inner join cfbam23.tsecgrp tgrp on 
				tent.Id = tgrp.TenantId
		where
			tent.Id = argId
	loop
		select cfbam23.sp_delete_tsecgrp_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupId )
			into subret;
	end loop;


	delete from cfbam23.tenant
	where
		id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_tenant() Expected to affect 1 tenant, not %', RowsAffected;
	end if;

	return true;
end;
$$ language plpgsql;
