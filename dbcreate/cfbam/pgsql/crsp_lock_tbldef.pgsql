--
--	@(#) dbcreate/cfbam/pgsql/crsp_lock_tbldef.pgsql
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


create or replace function cfbam23.sp_lock_tbldef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint )
returns setof cfbam23.type_tbldef_rec as $$
declare
	permissionFlag boolean;
	isSystemUser boolean;
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
begin
	select cfbam23.sp_is_tenant_user( secTenantId,
			'ReadTable',
			argAuditUserId ),
		cfbam23.sp_is_system_user( argAuditUserId )
	into permissionFlag, isSystemUser;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for ReadTable';
	end if;
	if( isSystemUser )
	then
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

		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			tbld.schemadefid as schemadefid,
			tbld.defschtentid as defschtentid,
			tbld.defschid as defschid,
			tbld.name as name,
			tbld.dbname as dbname,
			tbld.short_name as short_name,
			tbld.label as label,
			tbld.short_descr as short_descr,
			tbld.descr as descr,
			tbld.primidxtentid as primidxtentid,
			tbld.primidxid as primidxid,
			tbld.tblclscd as tblclscd,
			tbld.lookidxtentid as lookidxtentid,
			tbld.lookidxid as lookidxid,
			tbld.altidxtentid as altidxtentid,
			tbld.altidxid as altidxid,
			tbld.qualtentid as qualtentid,
			tbld.qualtblid as qualtblid,
			tbld.polybase as polybase,
			tbld.isinstantiable as isinstantiable,
			tbld.hashistory as hashistory,
			tbld.hasauditcolumns as hasauditcolumns,
			tbld.loadbehavid as loadbehavid,
			tbld.datascopeid as datascopeid,
			tbld.secscopeid as secscopeid,
			tbld.vasecid as vasecid,
			tbld.easecid as easecid,
			tbld.vafid as vafid,
			tbld.eafid as eafid,
			tbld.jobj_memb as jobj_memb,
			tbld.jobj_xface as jobj_xface,
			tbld.jtbl_objimp as jtbl_objimp,
			tbld.jobj_impl as jobj_impl,
			tbld.jedt_memb as jedt_memb,
			tbld.jedt_xface as jedt_xface,
			tbld.jtbl_eobjimp as jtbl_eobjimp,
			tbld.jedt_impl as jedt_impl,
			tbld.jtbl_imp as jtbl_imp,
			tbld.jtbl_memb as jtbl_memb,
			tbld.jtbl_xface as jtbl_xface,
			tbld.jtbl_impl as jtbl_impl,
			tbld.jtbl_objimp as jtbl_objimp,
			tbld.jtbl_objmemb as jtbl_objmemb,
			tbld.jtbl_objxface as jtbl_objxface,
			tbld.jtbl_objimpl as jtbl_objimpl,
			tbld.jtbl_db2imp as jtbl_db2imp,
			tbld.jdb2_memb as jdb2_memb,
			tbld.jdb2_impl as jdb2_impl,
			tbld.jtbl_msimp as jtbl_msimp,
			tbld.jmssql_memb as jmssql_memb,
			tbld.jmssql_impl as jmssql_impl,
			tbld.jtbl_myimp as jtbl_myimp,
			tbld.jmysql_memb as jmysql_memb,
			tbld.jmysql_impl as jmysql_impl,
			tbld.jtbl_oraimp as jtbl_oraimp,
			tbld.joracle_memb as joracle_memb,
			tbld.joracle_impl as joracle_impl,
			tbld.jtbl_pgimp as jtbl_pgimp,
			tbld.jpgsql_memb as jpgsql_memb,
			tbld.jpgsql_impl as jpgsql_impl,
			tbld.jtbl_sybaseimp as jtbl_sybaseimp,
			tbld.jsybase_memb as jsybase_memb,
			tbld.jsybase_impl as jsybase_impl,
			tbld.jtbl_ramimp as jtbl_ramimp,
			tbld.jram_memb as jram_memb,
			tbld.jram_impl as jram_impl,
			tbld.jtbl_saxldimp as jtbl_saxldimp,
			tbld.jsaxstart_memb as jsaxstart_memb,
			tbld.jsaxend_impl as jsaxend_impl,
			tbld.jxmtbl_imp as jxmtbl_imp,
			tbld.jxmtbl_fmt as jxmtbl_fmt,
			tbld.jxmtbl_rqstimp as jxmtbl_rqstimp,
			tbld.jxmtbl_rspnimp as jxmtbl_rspnimp,
			tbld.jxmtbl_clntimp as jxmtbl_clntimp,
			tbld.jxmtbl_rqstbdy as jxmtbl_rqstbdy,
			tbld.jxmtbl_rspnbdy as jxmtbl_rspnbdy,
			tbld.jxmtbl_clntbdy as jxmtbl_clntbdy,
			tbld.dflt_vis as dflt_vis,
			scop.revision as revision
		from cfbam23.tbldef as tbld
		inner join cfbam23.scopedef scop on
			tbld.tenantid = scop.tenantid
			and tbld.Id = scop.id
		where
			tbld.tenantid = argTenantId
			and tbld.id = argId;
	else
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

		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			tbld.schemadefid as schemadefid,
			tbld.defschtentid as defschtentid,
			tbld.defschid as defschid,
			tbld.name as name,
			tbld.dbname as dbname,
			tbld.short_name as short_name,
			tbld.label as label,
			tbld.short_descr as short_descr,
			tbld.descr as descr,
			tbld.primidxtentid as primidxtentid,
			tbld.primidxid as primidxid,
			tbld.tblclscd as tblclscd,
			tbld.lookidxtentid as lookidxtentid,
			tbld.lookidxid as lookidxid,
			tbld.altidxtentid as altidxtentid,
			tbld.altidxid as altidxid,
			tbld.qualtentid as qualtentid,
			tbld.qualtblid as qualtblid,
			tbld.polybase as polybase,
			tbld.isinstantiable as isinstantiable,
			tbld.hashistory as hashistory,
			tbld.hasauditcolumns as hasauditcolumns,
			tbld.loadbehavid as loadbehavid,
			tbld.datascopeid as datascopeid,
			tbld.secscopeid as secscopeid,
			tbld.vasecid as vasecid,
			tbld.easecid as easecid,
			tbld.vafid as vafid,
			tbld.eafid as eafid,
			tbld.jobj_memb as jobj_memb,
			tbld.jobj_xface as jobj_xface,
			tbld.jtbl_objimp as jtbl_objimp,
			tbld.jobj_impl as jobj_impl,
			tbld.jedt_memb as jedt_memb,
			tbld.jedt_xface as jedt_xface,
			tbld.jtbl_eobjimp as jtbl_eobjimp,
			tbld.jedt_impl as jedt_impl,
			tbld.jtbl_imp as jtbl_imp,
			tbld.jtbl_memb as jtbl_memb,
			tbld.jtbl_xface as jtbl_xface,
			tbld.jtbl_impl as jtbl_impl,
			tbld.jtbl_objimp as jtbl_objimp,
			tbld.jtbl_objmemb as jtbl_objmemb,
			tbld.jtbl_objxface as jtbl_objxface,
			tbld.jtbl_objimpl as jtbl_objimpl,
			tbld.jtbl_db2imp as jtbl_db2imp,
			tbld.jdb2_memb as jdb2_memb,
			tbld.jdb2_impl as jdb2_impl,
			tbld.jtbl_msimp as jtbl_msimp,
			tbld.jmssql_memb as jmssql_memb,
			tbld.jmssql_impl as jmssql_impl,
			tbld.jtbl_myimp as jtbl_myimp,
			tbld.jmysql_memb as jmysql_memb,
			tbld.jmysql_impl as jmysql_impl,
			tbld.jtbl_oraimp as jtbl_oraimp,
			tbld.joracle_memb as joracle_memb,
			tbld.joracle_impl as joracle_impl,
			tbld.jtbl_pgimp as jtbl_pgimp,
			tbld.jpgsql_memb as jpgsql_memb,
			tbld.jpgsql_impl as jpgsql_impl,
			tbld.jtbl_sybaseimp as jtbl_sybaseimp,
			tbld.jsybase_memb as jsybase_memb,
			tbld.jsybase_impl as jsybase_impl,
			tbld.jtbl_ramimp as jtbl_ramimp,
			tbld.jram_memb as jram_memb,
			tbld.jram_impl as jram_impl,
			tbld.jtbl_saxldimp as jtbl_saxldimp,
			tbld.jsaxstart_memb as jsaxstart_memb,
			tbld.jsaxend_impl as jsaxend_impl,
			tbld.jxmtbl_imp as jxmtbl_imp,
			tbld.jxmtbl_fmt as jxmtbl_fmt,
			tbld.jxmtbl_rqstimp as jxmtbl_rqstimp,
			tbld.jxmtbl_rspnimp as jxmtbl_rspnimp,
			tbld.jxmtbl_clntimp as jxmtbl_clntimp,
			tbld.jxmtbl_rqstbdy as jxmtbl_rqstbdy,
			tbld.jxmtbl_rspnbdy as jxmtbl_rspnbdy,
			tbld.jxmtbl_clntbdy as jxmtbl_clntbdy,
			tbld.dflt_vis as dflt_vis,
			scop.revision as revision
		from cfbam23.tbldef as tbld
		inner join cfbam23.scopedef scop on
			tbld.tenantid = scop.tenantid
			and tbld.Id = scop.id
		where
			tbld.tenantid = argTenantId
			and tbld.id = argId
			and scop.TenantId = secTenantId;
	end if;
	return;
end;
$$ language plpgsql;
