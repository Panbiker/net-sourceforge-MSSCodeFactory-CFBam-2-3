--
--	@(#) dbcreate/cfbam/oracle/crdl_tenant.plsql
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
--	Code manufactured MSS Code Factory
--

create or replace procedure cfbam23.dl_tenant(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argId numeric,
	argRevision int )
is
	oldClusterId numeric(22,0);
	oldId numeric(22,0);
	oldTenantName varchar2(192);
	oldRevision integer;
	cursor cursClearTableRelationNarrowed is
		select
			reld.TenantId,
			reld.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			tent.Id = argId;
	cursor cursDelTableChain is
		select
			chn.TenantId,
			chn.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.chain_def chn on
				tbld.TenantId = chn.TenantId
				and tbld.Id = chn.TableId
		where
			tent.Id = argId;
	cursor cursDelTableRelationCol is
		select
			relc.TenantId,
			relc.Id
		from cfbam23.tenant tent
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
			tent.Id = argId;
	cursor cursDelTableRelation is
		select
			reld.TenantId,
			reld.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			tent.Id = argId;
	cursor cursDelTable is
		select
			tbld.TenantId,
			tbld.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
			inner join cfbam23.tbldef tbld on
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
		where
			tent.Id = argId;
	cursor cursDelTypeDef is
		select
			valu.TenantId,
			valu.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
			inner join cfbam23.valdef valu on
				schm.TenantId = valu.TenantId
				and schm.Id = valu.ScopeId
		where
			tent.Id = argId;
	cursor cursDelSchemaDef is
		select
			schm.TenantId,
			schm.Id
		from cfbam23.tenant tent
			inner join cfbam23.schemadef schm on
				tent.Id = schm.TenantId
		where
			tent.Id = argId;
	cursor cursDelTopDomains is
		select
			tdom.TenantId,
			tdom.Id
		from cfbam23.tenant tent
			inner join cfbam23.tlddef gtld on
				tent.Id = gtld.TenantId
			inner join cfbam23.tdomdef tdom on
				gtld.TenantId = tdom.TenantId
				and gtld.TldId = tdom.TldId
		where
			tent.Id = argId;
	cursor cursDelTlds is
		select
			gtld.TenantId,
			gtld.TldId
		from cfbam23.tenant tent
			inner join cfbam23.tlddef gtld on
				tent.Id = gtld.TenantId
		where
			tent.Id = argId;
	cursor cursDelDomainBase is
		select
			bdom.TenantId,
			bdom.Id
		from cfbam23.tenant tent
			inner join cfbam23.bdomdef bdom on
				tent.Id = bdom.TenantId
		where
			tent.Id = argId;
	cursor cursDelIncludedByGroup is
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.tenant tent
			inner join cfbam23.tsecgrp tgrp on
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecinc tgnc on
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.IncGrpId
		where
			tent.Id = argId;
	cursor cursDelGroupMembers is
		select
			tgmb.TenantId,
			tgmb.TSecGroupMemberId
		from cfbam23.tenant tent
			inner join cfbam23.tsecgrp tgrp on
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecmemb tgmb on
				tgrp.TenantId = tgmb.TenantId
				and tgrp.TSecGroupId = tgmb.TSecGroupId
		where
			tent.Id = argId;
	cursor cursDelGroupIncludes is
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.tenant tent
			inner join cfbam23.tsecgrp tgrp on
				tent.Id = tgrp.TenantId
			inner join cfbam23.tsecinc tgnc on
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.TSecGrpId
		where
			tent.Id = argId;
	cursor cursDelTSecGroups is
		select
			tgrp.TenantId,
			tgrp.TSecGroupId
		from cfbam23.tenant tent
			inner join cfbam23.tsecgrp tgrp on
				tent.Id = tgrp.TenantId
		where
			tent.Id = argId;
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
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

	permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;
	insert into cfbam23.tenant_h (
			Id,
			revision,
			auditclusterid,
			auditsessionid,
			ClusterId,
			TenantName,
			auditaction,
			auditstamp )
		select
			tent.Id as Id,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			tent.ClusterId as ClusterId,
			tent.TenantName as TenantName,
			3,
			sysdate
		from cfbam23.tenant tent
		where
			tent.Id = argId;

	for cur in cursClearTableRelationNarrowed
	loop
		update cfbam23.reldef
		set
			NarrowedTenantId = null,
			NarrowedId = null
		where
			TenantId = cur.TenantId
			and Id = cur.Id;

	end loop;

	for cur in cursDelTableChain
	loop
		cfbam23.dl_chain_defbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTableRelationCol
	loop
		cfbam23.dl_relcolbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTableRelation
	loop
		cfbam23.dl_reldefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTable
	loop
		cfbam23.dl_tbldefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTypeDef
	loop
		cfbam23.dl_valdefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelSchemaDef
	loop
		cfbam23.dl_schemadefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTopDomains
	loop
		cfbam23.dl_tdomdefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelTlds
	loop
		cfbam23.dl_tlddefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TldId );
	end loop;
	for cur in cursDelDomainBase
	loop
		cfbam23.dl_bdomdefbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id );
	end loop;
	for cur in cursDelIncludedByGroup
	loop
		cfbam23.dl_tsecincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGrpIncId );
	end loop;
	for cur in cursDelGroupMembers
	loop
		cfbam23.dl_tsecmembbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupMemberId );
	end loop;
	for cur in cursDelGroupIncludes
	loop
		cfbam23.dl_tsecincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGrpIncId );
	end loop;
	for cur in cursDelTSecGroups
	loop
		cfbam23.dl_tsecgrpbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupId );
	end loop;
	delete from cfbam23.tenant
	where
		Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

end dl_tenant;
/

show errors procedure cfbam23.dl_tenant;
/
