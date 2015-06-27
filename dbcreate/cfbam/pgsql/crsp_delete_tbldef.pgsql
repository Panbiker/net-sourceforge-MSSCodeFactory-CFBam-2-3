--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_tbldef.pgsql
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

create or replace function cfbam23.sp_delete_tbldef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldId bigint;
	oldRevision int;
	oldSchemaDefId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldDbName varchar(32);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(50);
	oldDescription varchar(100);
	oldPrimaryIndexTenantId bigint;
	oldPrimaryIndexId bigint;
	oldTableClassCode varchar(4);
	oldLookupIndexTenantId bigint;
	oldLookupIndexId bigint;
	oldAltIndexTenantId bigint;
	oldAltIndexId bigint;
	oldQualifyingTenantId bigint;
	oldQualifyingTableId bigint;
	oldPolyBase boolean;
	oldIsInstantiable boolean;
	oldHasHistory boolean;
	oldHasAuditColumns boolean;
	oldLoaderBehaviourId smallint;
	oldDataScopeId smallint;
	oldSecurityScopeId smallint;
	oldViewAccessSecurityId smallint;
	oldEditAccessSecurityId smallint;
	oldViewAccessFrequencyId smallint;
	oldEditAccessFrequencyId smallint;
	oldJObjMembers text;
	oldJObjInterface text;
	oldJObjImport text;
	oldJObjImplementation text;
	oldJEditObjMembers text;
	oldJEditObjInterface text;
	oldJEditObjImport text;
	oldJEditObjImplementation text;
	oldJTableImport text;
	oldJTableMembers text;
	oldJTableInterface text;
	oldJTableImplementation text;
	oldJTableObjImport text;
	oldJTableObjMembers text;
	oldJTableObjInterface text;
	oldJTableObjImplementation text;
	oldJDb2LUWTableImport text;
	oldJDb2LUWTableMembers text;
	oldJDb2LUWTableImplementation text;
	oldJMSSqlTableImport text;
	oldJMSSqlTableMembers text;
	oldJMSSqlTableImplementation text;
	oldJMySqlTableImport text;
	oldJMySqlTableMembers text;
	oldJMySqlTableImplementation text;
	oldJOracleTableImport text;
	oldJOracleTableMembers text;
	oldJOracleTableImplementation text;
	oldJPgSqlTableImport text;
	oldJPgSqlTableMembers text;
	oldJPgSqlTableImplementation text;
	oldJSybaseTableImport text;
	oldJSybaseTableMembers text;
	oldJSybaseTableImplementation text;
	oldJRamTableImport text;
	oldJRamTableMembers text;
	oldJRamTableImplementation text;
	oldJSaxLoaderImport text;
	oldJSaxLoaderStartElement text;
	oldJSaxLoaderEndElement text;
	oldJXMsgTableImport text;
	oldJXMsgTableFormatters text;
	oldJXMsgRqstTableImport text;
	oldJXMsgRspnTableImport text;
	oldJXMsgClientTableImport text;
	oldJXMsgRqstTableBody text;
	oldJXMsgRspnTableBody text;
	oldJXMsgClientTableBody text;
	oldDefaultVisibility boolean;
	permissionFlag boolean;
begin
		select
			ClassCode,
			TenantId,
			Id,
			revision
		into
			oldClassCode,
			oldTenantId,
			oldId,
			oldRevision
		from cfbam23.scopedef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			SchemaDefId,
			defschtentid,
			defschid,
			Id,
			Name,
			DbName,
			short_name,
			Label,
			short_descr,
			descr,
			PrimIdxTentId,
			PrimIdxId,
			TblClsCd,
			LookIdxTentId,
			LookIdxId,
			AltIdxTentId,
			AltIdxId,
			QualTentId,
			QualTblId,
			PolyBase,
			IsInstantiable,
			HasHistory,
			HasAuditColumns,
			LoadBehavId,
			DataScopeId,
			SecScopeId,
			VASecId,
			EASecId,
			VAFId,
			EAFId,
			jobj_memb,
			jobj_xface,
			jtbl_objimp,
			jobj_impl,
			jedt_memb,
			jedt_xface,
			jtbl_eobjimp,
			jedt_impl,
			jtbl_imp,
			jtbl_memb,
			jtbl_xface,
			jtbl_impl,
			jtbl_objimp,
			jtbl_objmemb,
			jtbl_objxface,
			jtbl_objimpl,
			jtbl_db2imp,
			jdb2_memb,
			jdb2_impl,
			jtbl_msimp,
			jmssql_memb,
			jmssql_impl,
			jtbl_myimp,
			jmysql_memb,
			jmysql_impl,
			jtbl_oraimp,
			joracle_memb,
			joracle_impl,
			jtbl_pgimp,
			jpgsql_memb,
			jpgsql_impl,
			jtbl_sybaseimp,
			jsybase_memb,
			jsybase_impl,
			jtbl_ramimp,
			jram_memb,
			jram_impl,
			jtbl_saxldimp,
			jsaxstart_memb,
			jsaxend_impl,
			jxmtbl_imp,
			jxmtbl_fmt,
			jxmtbl_rqstimp,
			jxmtbl_rspnimp,
			jxmtbl_clntimp,
			jxmtbl_rqstbdy,
			jxmtbl_rspnbdy,
			jxmtbl_clntbdy,
			dflt_vis
		into
			oldTenantId,
			oldSchemaDefId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldId,
			oldName,
			oldDbName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldPrimaryIndexTenantId,
			oldPrimaryIndexId,
			oldTableClassCode,
			oldLookupIndexTenantId,
			oldLookupIndexId,
			oldAltIndexTenantId,
			oldAltIndexId,
			oldQualifyingTenantId,
			oldQualifyingTableId,
			oldPolyBase,
			oldIsInstantiable,
			oldHasHistory,
			oldHasAuditColumns,
			oldLoaderBehaviourId,
			oldDataScopeId,
			oldSecurityScopeId,
			oldViewAccessSecurityId,
			oldEditAccessSecurityId,
			oldViewAccessFrequencyId,
			oldEditAccessFrequencyId,
			oldJObjMembers,
			oldJObjInterface,
			oldJObjImport,
			oldJObjImplementation,
			oldJEditObjMembers,
			oldJEditObjInterface,
			oldJEditObjImport,
			oldJEditObjImplementation,
			oldJTableImport,
			oldJTableMembers,
			oldJTableInterface,
			oldJTableImplementation,
			oldJTableObjImport,
			oldJTableObjMembers,
			oldJTableObjInterface,
			oldJTableObjImplementation,
			oldJDb2LUWTableImport,
			oldJDb2LUWTableMembers,
			oldJDb2LUWTableImplementation,
			oldJMSSqlTableImport,
			oldJMSSqlTableMembers,
			oldJMSSqlTableImplementation,
			oldJMySqlTableImport,
			oldJMySqlTableMembers,
			oldJMySqlTableImplementation,
			oldJOracleTableImport,
			oldJOracleTableMembers,
			oldJOracleTableImplementation,
			oldJPgSqlTableImport,
			oldJPgSqlTableMembers,
			oldJPgSqlTableImplementation,
			oldJSybaseTableImport,
			oldJSybaseTableMembers,
			oldJSybaseTableImplementation,
			oldJRamTableImport,
			oldJRamTableMembers,
			oldJRamTableImplementation,
			oldJSaxLoaderImport,
			oldJSaxLoaderStartElement,
			oldJSaxLoaderEndElement,
			oldJXMsgTableImport,
			oldJXMsgTableFormatters,
			oldJXMsgRqstTableImport,
			oldJXMsgRspnTableImport,
			oldJXMsgClientTableImport,
			oldJXMsgRqstTableBody,
			oldJXMsgRspnTableBody,
			oldJXMsgClientTableBody,
			oldDefaultVisibility
		from cfbam23.tbldef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if( oldTenantId != secTenantId )
	then
		select cfbam23.sp_is_system_user( argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- Data is not owned by logged in tenant';
		end if;
	end if;

	select cfbam23.sp_is_tenant_user( oldTenantId,
		'DeleteTable',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteTable';
	end if;

	if( oldClassCode = 'TBLD' )
	then
		insert into cfbam23.tbldef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			SchemaDefId,
			defschtentid,
			defschid,
			Name,
			DbName,
			short_name,
			Label,
			short_descr,
			descr,
			PrimIdxTentId,
			PrimIdxId,
			TblClsCd,
			LookIdxTentId,
			LookIdxId,
			AltIdxTentId,
			AltIdxId,
			QualTentId,
			QualTblId,
			PolyBase,
			IsInstantiable,
			HasHistory,
			HasAuditColumns,
			LoadBehavId,
			DataScopeId,
			SecScopeId,
			VASecId,
			EASecId,
			VAFId,
			EAFId,
			jobj_memb,
			jobj_xface,
			jtbl_objimp,
			jobj_impl,
			jedt_memb,
			jedt_xface,
			jtbl_eobjimp,
			jedt_impl,
			jtbl_imp,
			jtbl_memb,
			jtbl_xface,
			jtbl_impl,
			jtbl_objimp,
			jtbl_objmemb,
			jtbl_objxface,
			jtbl_objimpl,
			jtbl_db2imp,
			jdb2_memb,
			jdb2_impl,
			jtbl_msimp,
			jmssql_memb,
			jmssql_impl,
			jtbl_myimp,
			jmysql_memb,
			jmysql_impl,
			jtbl_oraimp,
			joracle_memb,
			joracle_impl,
			jtbl_pgimp,
			jpgsql_memb,
			jpgsql_impl,
			jtbl_sybaseimp,
			jsybase_memb,
			jsybase_impl,
			jtbl_ramimp,
			jram_memb,
			jram_impl,
			jtbl_saxldimp,
			jsaxstart_memb,
			jsaxend_impl,
			jxmtbl_imp,
			jxmtbl_fmt,
			jxmtbl_rqstimp,
			jxmtbl_rspnimp,
			jxmtbl_clntimp,
			jxmtbl_rqstbdy,
			jxmtbl_rspnbdy,
			jxmtbl_clntbdy,
			dflt_vis,
			revision,
			auditaction )
		select
			scop.TenantId,
			scop.Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			tbld.SchemaDefId,
			tbld.defschtentid,
			tbld.defschid,
			tbld.Name,
			tbld.DbName,
			tbld.short_name,
			tbld.Label,
			tbld.short_descr,
			tbld.descr,
			tbld.PrimIdxTentId,
			tbld.PrimIdxId,
			tbld.TblClsCd,
			tbld.LookIdxTentId,
			tbld.LookIdxId,
			tbld.AltIdxTentId,
			tbld.AltIdxId,
			tbld.QualTentId,
			tbld.QualTblId,
			tbld.PolyBase,
			tbld.IsInstantiable,
			tbld.HasHistory,
			tbld.HasAuditColumns,
			tbld.LoadBehavId,
			tbld.DataScopeId,
			tbld.SecScopeId,
			tbld.VASecId,
			tbld.EASecId,
			tbld.VAFId,
			tbld.EAFId,
			tbld.jobj_memb,
			tbld.jobj_xface,
			tbld.jtbl_objimp,
			tbld.jobj_impl,
			tbld.jedt_memb,
			tbld.jedt_xface,
			tbld.jtbl_eobjimp,
			tbld.jedt_impl,
			tbld.jtbl_imp,
			tbld.jtbl_memb,
			tbld.jtbl_xface,
			tbld.jtbl_impl,
			tbld.jtbl_objimp,
			tbld.jtbl_objmemb,
			tbld.jtbl_objxface,
			tbld.jtbl_objimpl,
			tbld.jtbl_db2imp,
			tbld.jdb2_memb,
			tbld.jdb2_impl,
			tbld.jtbl_msimp,
			tbld.jmssql_memb,
			tbld.jmssql_impl,
			tbld.jtbl_myimp,
			tbld.jmysql_memb,
			tbld.jmysql_impl,
			tbld.jtbl_oraimp,
			tbld.joracle_memb,
			tbld.joracle_impl,
			tbld.jtbl_pgimp,
			tbld.jpgsql_memb,
			tbld.jpgsql_impl,
			tbld.jtbl_sybaseimp,
			tbld.jsybase_memb,
			tbld.jsybase_impl,
			tbld.jtbl_ramimp,
			tbld.jram_memb,
			tbld.jram_impl,
			tbld.jtbl_saxldimp,
			tbld.jsaxstart_memb,
			tbld.jsaxend_impl,
			tbld.jxmtbl_imp,
			tbld.jxmtbl_fmt,
			tbld.jxmtbl_rqstimp,
			tbld.jxmtbl_rspnimp,
			tbld.jxmtbl_clntimp,
			tbld.jxmtbl_rqstbdy,
			tbld.jxmtbl_rspnbdy,
			tbld.jxmtbl_clntbdy,
			tbld.dflt_vis,
			argRevision + 1,
			3
		from cfbam23.tbldef as tbld
		inner join cfbam23.scopedef scop on
			tbld.tenantid = scop.tenantid
			and tbld.Id = scop.id
		where
			tbld.tenantid = argTenantId
			and tbld.id = argId;
	end if;

	update cfbam23.tbldef
	set
		TenantId = argTenantId,
		LookIdxTentId = null,
		LookIdxId = null,
		AltIdxTentId = null,
		AltIdxId = null,
		PrimIdxTentId = null,
		PrimIdxId = null
	where
		TenantId = argTenantId
			and Id = argId;

	for cur in
		select
			srvm.TenantId,
			srvm.Id
		from cfbam23.tbldef as tbld
			inner join cfbam23.srvmeth srvm on 
				tbld.TenantId = srvm.TenantId
				and tbld.Id = srvm.TableId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
	loop
		select cfbam23.sp_delete_srvmeth_by_ididx( argAuditClusterId,
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
			chn.TenantId,
			chn.Id
		from cfbam23.tbldef as tbld
			inner join cfbam23.chain_def chn on 
				tbld.TenantId = chn.TenantId
				and tbld.Id = chn.TableId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
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
		from cfbam23.tbldef as tbld
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
			inner join cfbam23.relcol relc on 
				reld.TenantId = relc.TenantId
				and reld.Id = relc.RelationId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
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
		from cfbam23.tbldef as tbld
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
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
			idxc.TenantId,
			idxc.Id
		from cfbam23.tbldef as tbld
			inner join cfbam23.idxdef idxd on 
				tbld.TenantId = idxd.TenantId
				and tbld.Id = idxd.TableId
			inner join cfbam23.idxcol idxc on 
				idxd.TenantId = idxc.TenantId
				and idxd.Id = idxc.IndexId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
	loop
		select cfbam23.sp_delete_idxcol_by_ididx( argAuditClusterId,
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
			idxd.TenantId,
			idxd.Id
		from cfbam23.tbldef as tbld
			inner join cfbam23.idxdef idxd on 
				tbld.TenantId = idxd.TenantId
				and tbld.Id = idxd.TableId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
	loop
		select cfbam23.sp_delete_idxdef_by_ididx( argAuditClusterId,
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
		from cfbam23.tbldef as tbld
			inner join cfbam23.valdef valu on 
				tbld.TenantId = valu.TenantId
				and tbld.Id = valu.ScopeId
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId
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


	delete from cfbam23.tbldef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_tbldef() Expected to affect 1 tbldef, not %', RowsAffected;
	end if;
	delete from cfbam23.scopedef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_tbldef() Expected to affect 1 scopedef, not %', RowsAffected;
	end if;


	return true;
end;
$$ language plpgsql;
