--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_tbldef.sql
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


create or replace procedure sp_update_tbldef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argSchemaDefId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argDbName varchar(32),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(50),	\
	in argDescription varchar(100),	\
	in argPrimaryIndexTenantId bigint,	\
	in argPrimaryIndexId bigint,	\
	in argTableClassCode varchar(4),	\
	in argLookupIndexTenantId bigint,	\
	in argLookupIndexId bigint,	\
	in argAltIndexTenantId bigint,	\
	in argAltIndexId bigint,	\
	in argQualifyingTenantId bigint,	\
	in argQualifyingTableId bigint,	\
	in argPolyBase char(1),	\
	in argIsInstantiable char(1),	\
	in argHasHistory char(1),	\
	in argHasAuditColumns char(1),	\
	in argLoaderBehaviourId smallint,	\
	in argDataScopeId smallint,	\
	in argSecurityScopeId smallint,	\
	in argViewAccessSecurityId smallint,	\
	in argEditAccessSecurityId smallint,	\
	in argViewAccessFrequencyId smallint,	\
	in argEditAccessFrequencyId smallint,	\
	in argJObjMembers clob(2000000),	\
	in argJObjInterface clob(2000000),	\
	in argJObjImport clob(2000000),	\
	in argJObjImplementation clob(2000000),	\
	in argJEditObjMembers clob(2000000),	\
	in argJEditObjInterface clob(2000000),	\
	in argJEditObjImport clob(2000000),	\
	in argJEditObjImplementation clob(2000000),	\
	in argJTableImport clob(2000000),	\
	in argJTableMembers clob(2000000),	\
	in argJTableInterface clob(2000000),	\
	in argJTableImplementation clob(2000000),	\
	in argJTableObjImport clob(2000000),	\
	in argJTableObjMembers clob(2000000),	\
	in argJTableObjInterface clob(2000000),	\
	in argJTableObjImplementation clob(2000000),	\
	in argJDb2LUWTableImport clob(2000000),	\
	in argJDb2LUWTableMembers clob(2000000),	\
	in argJDb2LUWTableImplementation clob(2000000),	\
	in argJMSSqlTableImport clob(2000000),	\
	in argJMSSqlTableMembers clob(2000000),	\
	in argJMSSqlTableImplementation clob(2000000),	\
	in argJMySqlTableImport clob(2000000),	\
	in argJMySqlTableMembers clob(2000000),	\
	in argJMySqlTableImplementation clob(2000000),	\
	in argJOracleTableImport clob(2000000),	\
	in argJOracleTableMembers clob(2000000),	\
	in argJOracleTableImplementation clob(2000000),	\
	in argJPgSqlTableImport clob(2000000),	\
	in argJPgSqlTableMembers clob(2000000),	\
	in argJPgSqlTableImplementation clob(2000000),	\
	in argJSybaseTableImport clob(2000000),	\
	in argJSybaseTableMembers clob(2000000),	\
	in argJSybaseTableImplementation clob(2000000),	\
	in argJRamTableImport clob(2000000),	\
	in argJRamTableMembers clob(2000000),	\
	in argJRamTableImplementation clob(2000000),	\
	in argJSaxLoaderImport clob(2000000),	\
	in argJSaxLoaderStartElement clob(2000000),	\
	in argJSaxLoaderEndElement clob(2000000),	\
	in argJXMsgTableImport clob(2000000),	\
	in argJXMsgTableFormatters clob(2000000),	\
	in argJXMsgRqstTableImport clob(2000000),	\
	in argJXMsgRspnTableImport clob(2000000),	\
	in argJXMsgClientTableImport clob(2000000),	\
	in argJXMsgRqstTableBody clob(2000000),	\
	in argJXMsgRspnTableBody clob(2000000),	\
	in argJXMsgClientTableBody clob(2000000),	\
	in argDefaultVisibility char(1),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldRevision int;	\
	declare oldSchemaDefId bigint;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldName varchar(192);	\
	declare oldDbName varchar(32);	\
	declare oldShortName varchar(16);	\
	declare oldLabel varchar(64);	\
	declare oldShortDescription varchar(50);	\
	declare oldDescription varchar(100);	\
	declare oldPrimaryIndexTenantId bigint;	\
	declare oldPrimaryIndexId bigint;	\
	declare oldTableClassCode varchar(4);	\
	declare oldLookupIndexTenantId bigint;	\
	declare oldLookupIndexId bigint;	\
	declare oldAltIndexTenantId bigint;	\
	declare oldAltIndexId bigint;	\
	declare oldQualifyingTenantId bigint;	\
	declare oldQualifyingTableId bigint;	\
	declare oldPolyBase char(1);	\
	declare oldIsInstantiable char(1);	\
	declare oldHasHistory char(1);	\
	declare oldHasAuditColumns char(1);	\
	declare oldLoaderBehaviourId smallint;	\
	declare oldDataScopeId smallint;	\
	declare oldSecurityScopeId smallint;	\
	declare oldViewAccessSecurityId smallint;	\
	declare oldEditAccessSecurityId smallint;	\
	declare oldViewAccessFrequencyId smallint;	\
	declare oldEditAccessFrequencyId smallint;	\
	declare oldJObjMembers clob(2000000);	\
	declare oldJObjInterface clob(2000000);	\
	declare oldJObjImport clob(2000000);	\
	declare oldJObjImplementation clob(2000000);	\
	declare oldJEditObjMembers clob(2000000);	\
	declare oldJEditObjInterface clob(2000000);	\
	declare oldJEditObjImport clob(2000000);	\
	declare oldJEditObjImplementation clob(2000000);	\
	declare oldJTableImport clob(2000000);	\
	declare oldJTableMembers clob(2000000);	\
	declare oldJTableInterface clob(2000000);	\
	declare oldJTableImplementation clob(2000000);	\
	declare oldJTableObjImport clob(2000000);	\
	declare oldJTableObjMembers clob(2000000);	\
	declare oldJTableObjInterface clob(2000000);	\
	declare oldJTableObjImplementation clob(2000000);	\
	declare oldJDb2LUWTableImport clob(2000000);	\
	declare oldJDb2LUWTableMembers clob(2000000);	\
	declare oldJDb2LUWTableImplementation clob(2000000);	\
	declare oldJMSSqlTableImport clob(2000000);	\
	declare oldJMSSqlTableMembers clob(2000000);	\
	declare oldJMSSqlTableImplementation clob(2000000);	\
	declare oldJMySqlTableImport clob(2000000);	\
	declare oldJMySqlTableMembers clob(2000000);	\
	declare oldJMySqlTableImplementation clob(2000000);	\
	declare oldJOracleTableImport clob(2000000);	\
	declare oldJOracleTableMembers clob(2000000);	\
	declare oldJOracleTableImplementation clob(2000000);	\
	declare oldJPgSqlTableImport clob(2000000);	\
	declare oldJPgSqlTableMembers clob(2000000);	\
	declare oldJPgSqlTableImplementation clob(2000000);	\
	declare oldJSybaseTableImport clob(2000000);	\
	declare oldJSybaseTableMembers clob(2000000);	\
	declare oldJSybaseTableImplementation clob(2000000);	\
	declare oldJRamTableImport clob(2000000);	\
	declare oldJRamTableMembers clob(2000000);	\
	declare oldJRamTableImplementation clob(2000000);	\
	declare oldJSaxLoaderImport clob(2000000);	\
	declare oldJSaxLoaderStartElement clob(2000000);	\
	declare oldJSaxLoaderEndElement clob(2000000);	\
	declare oldJXMsgTableImport clob(2000000);	\
	declare oldJXMsgTableFormatters clob(2000000);	\
	declare oldJXMsgRqstTableImport clob(2000000);	\
	declare oldJXMsgRspnTableImport clob(2000000);	\
	declare oldJXMsgClientTableImport clob(2000000);	\
	declare oldJXMsgRqstTableBody clob(2000000);	\
	declare oldJXMsgRspnTableBody clob(2000000);	\
	declare oldJXMsgClientTableBody clob(2000000);	\
	declare oldDefaultVisibility char(1);	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				scop.ClassCode,	\
				scop.createdby as createdby,	\
				to_char( scop.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				scop.updatedby as updatedby,	\
				to_char( scop.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			scop.tenantid as tenantid,	\
			scop.id as id,	\
			tbld.schemadefid as schemadefid,	\
			tbld.defschtentid as defschtentid,	\
			tbld.defschid as defschid,	\
			tbld.name as name,	\
			tbld.dbname as dbname,	\
			tbld.short_name as short_name,	\
			tbld.label as label,	\
			tbld.short_descr as short_descr,	\
			tbld.descr as descr,	\
			tbld.primidxtentid as primidxtentid,	\
			tbld.primidxid as primidxid,	\
			tbld.tblclscd as tblclscd,	\
			tbld.lookidxtentid as lookidxtentid,	\
			tbld.lookidxid as lookidxid,	\
			tbld.altidxtentid as altidxtentid,	\
			tbld.altidxid as altidxid,	\
			tbld.qualtentid as qualtentid,	\
			tbld.qualtblid as qualtblid,	\
			tbld.polybase as polybase,	\
			tbld.isinstantiable as isinstantiable,	\
			tbld.hashistory as hashistory,	\
			tbld.hasauditcolumns as hasauditcolumns,	\
			tbld.loadbehavid as loadbehavid,	\
			tbld.datascopeid as datascopeid,	\
			tbld.secscopeid as secscopeid,	\
			tbld.vasecid as vasecid,	\
			tbld.easecid as easecid,	\
			tbld.vafid as vafid,	\
			tbld.eafid as eafid,	\
			tbld.jobj_memb as jobj_memb,	\
			tbld.jobj_xface as jobj_xface,	\
			tbld.jtbl_objimp as jtbl_objimp,	\
			tbld.jobj_impl as jobj_impl,	\
			tbld.jedt_memb as jedt_memb,	\
			tbld.jedt_xface as jedt_xface,	\
			tbld.jtbl_eobjimp as jtbl_eobjimp,	\
			tbld.jedt_impl as jedt_impl,	\
			tbld.jtbl_imp as jtbl_imp,	\
			tbld.jtbl_memb as jtbl_memb,	\
			tbld.jtbl_xface as jtbl_xface,	\
			tbld.jtbl_impl as jtbl_impl,	\
			tbld.jtbl_objimp as jtbl_objimp,	\
			tbld.jtbl_objmemb as jtbl_objmemb,	\
			tbld.jtbl_objxface as jtbl_objxface,	\
			tbld.jtbl_objimpl as jtbl_objimpl,	\
			tbld.jtbl_db2imp as jtbl_db2imp,	\
			tbld.jdb2_memb as jdb2_memb,	\
			tbld.jdb2_impl as jdb2_impl,	\
			tbld.jtbl_msimp as jtbl_msimp,	\
			tbld.jmssql_memb as jmssql_memb,	\
			tbld.jmssql_impl as jmssql_impl,	\
			tbld.jtbl_myimp as jtbl_myimp,	\
			tbld.jmysql_memb as jmysql_memb,	\
			tbld.jmysql_impl as jmysql_impl,	\
			tbld.jtbl_oraimp as jtbl_oraimp,	\
			tbld.joracle_memb as joracle_memb,	\
			tbld.joracle_impl as joracle_impl,	\
			tbld.jtbl_pgimp as jtbl_pgimp,	\
			tbld.jpgsql_memb as jpgsql_memb,	\
			tbld.jpgsql_impl as jpgsql_impl,	\
			tbld.jtbl_sybaseimp as jtbl_sybaseimp,	\
			tbld.jsybase_memb as jsybase_memb,	\
			tbld.jsybase_impl as jsybase_impl,	\
			tbld.jtbl_ramimp as jtbl_ramimp,	\
			tbld.jram_memb as jram_memb,	\
			tbld.jram_impl as jram_impl,	\
			tbld.jtbl_saxldimp as jtbl_saxldimp,	\
			tbld.jsaxstart_memb as jsaxstart_memb,	\
			tbld.jsaxend_impl as jsaxend_impl,	\
			tbld.jxmtbl_imp as jxmtbl_imp,	\
			tbld.jxmtbl_fmt as jxmtbl_fmt,	\
			tbld.jxmtbl_rqstimp as jxmtbl_rqstimp,	\
			tbld.jxmtbl_rspnimp as jxmtbl_rspnimp,	\
			tbld.jxmtbl_clntimp as jxmtbl_clntimp,	\
			tbld.jxmtbl_rqstbdy as jxmtbl_rqstbdy,	\
			tbld.jxmtbl_rspnbdy as jxmtbl_rspnbdy,	\
			tbld.jxmtbl_clntbdy as jxmtbl_clntbdy,	\
			tbld.dflt_vis as dflt_vis,	\
			scop.revision as revision	\
		from cfbam23.tbldef as tbld	\
			inner join cfbam23.scopedef scop on	\
				tbld.tenantid = scop.tenantid	\
				and tbld.Id = scop.id	\
		where	\
			tbld.tenantid = argTenantId	\
		and tbld.id = argId;	\
	begin	\
		if( argClassCode = 'TBLD' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateTable',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateTable' );	\
			end if;	\
		end if;	\
	\
		select	\
			ClassCode,	\
			TenantId,	\
			Id,	\
			revision	\
		into	\
			oldClassCode,	\
			oldTenantId,	\
			oldId,	\
			oldRevision	\
		from cfbam23.scopedef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			SchemaDefId,	\
			defschtentid,	\
			defschid,	\
			Id,	\
			Name,	\
			DbName,	\
			short_name,	\
			Label,	\
			short_descr,	\
			descr,	\
			PrimIdxTentId,	\
			PrimIdxId,	\
			TblClsCd,	\
			LookIdxTentId,	\
			LookIdxId,	\
			AltIdxTentId,	\
			AltIdxId,	\
			QualTentId,	\
			QualTblId,	\
			PolyBase,	\
			IsInstantiable,	\
			HasHistory,	\
			HasAuditColumns,	\
			LoadBehavId,	\
			DataScopeId,	\
			SecScopeId,	\
			VASecId,	\
			EASecId,	\
			VAFId,	\
			EAFId,	\
			jobj_memb,	\
			jobj_xface,	\
			jtbl_objimp,	\
			jobj_impl,	\
			jedt_memb,	\
			jedt_xface,	\
			jtbl_eobjimp,	\
			jedt_impl,	\
			jtbl_imp,	\
			jtbl_memb,	\
			jtbl_xface,	\
			jtbl_impl,	\
			jtbl_objimp,	\
			jtbl_objmemb,	\
			jtbl_objxface,	\
			jtbl_objimpl,	\
			jtbl_db2imp,	\
			jdb2_memb,	\
			jdb2_impl,	\
			jtbl_msimp,	\
			jmssql_memb,	\
			jmssql_impl,	\
			jtbl_myimp,	\
			jmysql_memb,	\
			jmysql_impl,	\
			jtbl_oraimp,	\
			joracle_memb,	\
			joracle_impl,	\
			jtbl_pgimp,	\
			jpgsql_memb,	\
			jpgsql_impl,	\
			jtbl_sybaseimp,	\
			jsybase_memb,	\
			jsybase_impl,	\
			jtbl_ramimp,	\
			jram_memb,	\
			jram_impl,	\
			jtbl_saxldimp,	\
			jsaxstart_memb,	\
			jsaxend_impl,	\
			jxmtbl_imp,	\
			jxmtbl_fmt,	\
			jxmtbl_rqstimp,	\
			jxmtbl_rspnimp,	\
			jxmtbl_clntimp,	\
			jxmtbl_rqstbdy,	\
			jxmtbl_rspnbdy,	\
			jxmtbl_clntbdy,	\
			dflt_vis	\
		into	\
			oldTenantId,	\
			oldSchemaDefId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldId,	\
			oldName,	\
			oldDbName,	\
			oldShortName,	\
			oldLabel,	\
			oldShortDescription,	\
			oldDescription,	\
			oldPrimaryIndexTenantId,	\
			oldPrimaryIndexId,	\
			oldTableClassCode,	\
			oldLookupIndexTenantId,	\
			oldLookupIndexId,	\
			oldAltIndexTenantId,	\
			oldAltIndexId,	\
			oldQualifyingTenantId,	\
			oldQualifyingTableId,	\
			oldPolyBase,	\
			oldIsInstantiable,	\
			oldHasHistory,	\
			oldHasAuditColumns,	\
			oldLoaderBehaviourId,	\
			oldDataScopeId,	\
			oldSecurityScopeId,	\
			oldViewAccessSecurityId,	\
			oldEditAccessSecurityId,	\
			oldViewAccessFrequencyId,	\
			oldEditAccessFrequencyId,	\
			oldJObjMembers,	\
			oldJObjInterface,	\
			oldJObjImport,	\
			oldJObjImplementation,	\
			oldJEditObjMembers,	\
			oldJEditObjInterface,	\
			oldJEditObjImport,	\
			oldJEditObjImplementation,	\
			oldJTableImport,	\
			oldJTableMembers,	\
			oldJTableInterface,	\
			oldJTableImplementation,	\
			oldJTableObjImport,	\
			oldJTableObjMembers,	\
			oldJTableObjInterface,	\
			oldJTableObjImplementation,	\
			oldJDb2LUWTableImport,	\
			oldJDb2LUWTableMembers,	\
			oldJDb2LUWTableImplementation,	\
			oldJMSSqlTableImport,	\
			oldJMSSqlTableMembers,	\
			oldJMSSqlTableImplementation,	\
			oldJMySqlTableImport,	\
			oldJMySqlTableMembers,	\
			oldJMySqlTableImplementation,	\
			oldJOracleTableImport,	\
			oldJOracleTableMembers,	\
			oldJOracleTableImplementation,	\
			oldJPgSqlTableImport,	\
			oldJPgSqlTableMembers,	\
			oldJPgSqlTableImplementation,	\
			oldJSybaseTableImport,	\
			oldJSybaseTableMembers,	\
			oldJSybaseTableImplementation,	\
			oldJRamTableImport,	\
			oldJRamTableMembers,	\
			oldJRamTableImplementation,	\
			oldJSaxLoaderImport,	\
			oldJSaxLoaderStartElement,	\
			oldJSaxLoaderEndElement,	\
			oldJXMsgTableImport,	\
			oldJXMsgTableFormatters,	\
			oldJXMsgRqstTableImport,	\
			oldJXMsgRspnTableImport,	\
			oldJXMsgClientTableImport,	\
			oldJXMsgRqstTableBody,	\
			oldJXMsgRspnTableBody,	\
			oldJXMsgClientTableBody,	\
			oldDefaultVisibility	\
		from cfbam23.tbldef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_tbldef() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.tbldef	\
		set	\
			schemadefid = argSchemaDefId,	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			name = argName,	\
			dbname = argDbName,	\
			short_name = argShortName,	\
			label = argLabel,	\
			short_descr = argShortDescription,	\
			descr = argDescription,	\
			primidxtentid = argPrimaryIndexTenantId,	\
			primidxid = argPrimaryIndexId,	\
			tblclscd = argTableClassCode,	\
			lookidxtentid = argLookupIndexTenantId,	\
			lookidxid = argLookupIndexId,	\
			altidxtentid = argAltIndexTenantId,	\
			altidxid = argAltIndexId,	\
			qualtentid = argQualifyingTenantId,	\
			qualtblid = argQualifyingTableId,	\
			polybase = argPolyBase,	\
			isinstantiable = argIsInstantiable,	\
			hashistory = argHasHistory,	\
			hasauditcolumns = argHasAuditColumns,	\
			loadbehavid = argLoaderBehaviourId,	\
			datascopeid = argDataScopeId,	\
			secscopeid = argSecurityScopeId,	\
			vasecid = argViewAccessSecurityId,	\
			easecid = argEditAccessSecurityId,	\
			vafid = argViewAccessFrequencyId,	\
			eafid = argEditAccessFrequencyId,	\
			jobj_memb = argJObjMembers,	\
			jobj_xface = argJObjInterface,	\
			jtbl_objimp = argJObjImport,	\
			jobj_impl = argJObjImplementation,	\
			jedt_memb = argJEditObjMembers,	\
			jedt_xface = argJEditObjInterface,	\
			jtbl_eobjimp = argJEditObjImport,	\
			jedt_impl = argJEditObjImplementation,	\
			jtbl_imp = argJTableImport,	\
			jtbl_memb = argJTableMembers,	\
			jtbl_xface = argJTableInterface,	\
			jtbl_impl = argJTableImplementation,	\
			jtbl_objimp = argJTableObjImport,	\
			jtbl_objmemb = argJTableObjMembers,	\
			jtbl_objxface = argJTableObjInterface,	\
			jtbl_objimpl = argJTableObjImplementation,	\
			jtbl_db2imp = argJDb2LUWTableImport,	\
			jdb2_memb = argJDb2LUWTableMembers,	\
			jdb2_impl = argJDb2LUWTableImplementation,	\
			jtbl_msimp = argJMSSqlTableImport,	\
			jmssql_memb = argJMSSqlTableMembers,	\
			jmssql_impl = argJMSSqlTableImplementation,	\
			jtbl_myimp = argJMySqlTableImport,	\
			jmysql_memb = argJMySqlTableMembers,	\
			jmysql_impl = argJMySqlTableImplementation,	\
			jtbl_oraimp = argJOracleTableImport,	\
			joracle_memb = argJOracleTableMembers,	\
			joracle_impl = argJOracleTableImplementation,	\
			jtbl_pgimp = argJPgSqlTableImport,	\
			jpgsql_memb = argJPgSqlTableMembers,	\
			jpgsql_impl = argJPgSqlTableImplementation,	\
			jtbl_sybaseimp = argJSybaseTableImport,	\
			jsybase_memb = argJSybaseTableMembers,	\
			jsybase_impl = argJSybaseTableImplementation,	\
			jtbl_ramimp = argJRamTableImport,	\
			jram_memb = argJRamTableMembers,	\
			jram_impl = argJRamTableImplementation,	\
			jtbl_saxldimp = argJSaxLoaderImport,	\
			jsaxstart_memb = argJSaxLoaderStartElement,	\
			jsaxend_impl = argJSaxLoaderEndElement,	\
			jxmtbl_imp = argJXMsgTableImport,	\
			jxmtbl_fmt = argJXMsgTableFormatters,	\
			jxmtbl_rqstimp = argJXMsgRqstTableImport,	\
			jxmtbl_rspnimp = argJXMsgRspnTableImport,	\
			jxmtbl_clntimp = argJXMsgClientTableImport,	\
			jxmtbl_rqstbdy = argJXMsgRqstTableBody,	\
			jxmtbl_rspnbdy = argJXMsgRspnTableBody,	\
			jxmtbl_clntbdy = argJXMsgClientTableBody,	\
			dflt_vis = argDefaultVisibility	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		if( argClassCode = 'TBLD' )	\
		then	\
			insert into cfbam23.tbldef_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				schemadefid,	\
				defschtentid,	\
				defschid,	\
				name,	\
				dbname,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				primidxtentid,	\
				primidxid,	\
				tblclscd,	\
				lookidxtentid,	\
				lookidxid,	\
				altidxtentid,	\
				altidxid,	\
				qualtentid,	\
				qualtblid,	\
				polybase,	\
				isinstantiable,	\
				hashistory,	\
				hasauditcolumns,	\
				loadbehavid,	\
				datascopeid,	\
				secscopeid,	\
				vasecid,	\
				easecid,	\
				vafid,	\
				eafid,	\
				jobj_memb,	\
				jobj_xface,	\
				jtbl_objimp,	\
				jobj_impl,	\
				jedt_memb,	\
				jedt_xface,	\
				jtbl_eobjimp,	\
				jedt_impl,	\
				jtbl_imp,	\
				jtbl_memb,	\
				jtbl_xface,	\
				jtbl_impl,	\
				jtbl_objimp,	\
				jtbl_objmemb,	\
				jtbl_objxface,	\
				jtbl_objimpl,	\
				jtbl_db2imp,	\
				jdb2_memb,	\
				jdb2_impl,	\
				jtbl_msimp,	\
				jmssql_memb,	\
				jmssql_impl,	\
				jtbl_myimp,	\
				jmysql_memb,	\
				jmysql_impl,	\
				jtbl_oraimp,	\
				joracle_memb,	\
				joracle_impl,	\
				jtbl_pgimp,	\
				jpgsql_memb,	\
				jpgsql_impl,	\
				jtbl_sybaseimp,	\
				jsybase_memb,	\
				jsybase_impl,	\
				jtbl_ramimp,	\
				jram_memb,	\
				jram_impl,	\
				jtbl_saxldimp,	\
				jsaxstart_memb,	\
				jsaxend_impl,	\
				jxmtbl_imp,	\
				jxmtbl_fmt,	\
				jxmtbl_rqstimp,	\
				jxmtbl_rspnimp,	\
				jxmtbl_clntimp,	\
				jxmtbl_rqstbdy,	\
				jxmtbl_rspnbdy,	\
				jxmtbl_clntbdy,	\
				dflt_vis,	\
				revision,	\
				auditaction )	\
			select	\
				scop.tenantid,	\
				scop.id,	\
				scop.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				tbld.schemadefid,	\
				tbld.defschtentid,	\
				tbld.defschid,	\
				tbld.name,	\
				tbld.dbname,	\
				tbld.short_name,	\
				tbld.label,	\
				tbld.short_descr,	\
				tbld.descr,	\
				tbld.primidxtentid,	\
				tbld.primidxid,	\
				tbld.tblclscd,	\
				tbld.lookidxtentid,	\
				tbld.lookidxid,	\
				tbld.altidxtentid,	\
				tbld.altidxid,	\
				tbld.qualtentid,	\
				tbld.qualtblid,	\
				tbld.polybase,	\
				tbld.isinstantiable,	\
				tbld.hashistory,	\
				tbld.hasauditcolumns,	\
				tbld.loadbehavid,	\
				tbld.datascopeid,	\
				tbld.secscopeid,	\
				tbld.vasecid,	\
				tbld.easecid,	\
				tbld.vafid,	\
				tbld.eafid,	\
				tbld.jobj_memb,	\
				tbld.jobj_xface,	\
				tbld.jtbl_objimp,	\
				tbld.jobj_impl,	\
				tbld.jedt_memb,	\
				tbld.jedt_xface,	\
				tbld.jtbl_eobjimp,	\
				tbld.jedt_impl,	\
				tbld.jtbl_imp,	\
				tbld.jtbl_memb,	\
				tbld.jtbl_xface,	\
				tbld.jtbl_impl,	\
				tbld.jtbl_objimp,	\
				tbld.jtbl_objmemb,	\
				tbld.jtbl_objxface,	\
				tbld.jtbl_objimpl,	\
				tbld.jtbl_db2imp,	\
				tbld.jdb2_memb,	\
				tbld.jdb2_impl,	\
				tbld.jtbl_msimp,	\
				tbld.jmssql_memb,	\
				tbld.jmssql_impl,	\
				tbld.jtbl_myimp,	\
				tbld.jmysql_memb,	\
				tbld.jmysql_impl,	\
				tbld.jtbl_oraimp,	\
				tbld.joracle_memb,	\
				tbld.joracle_impl,	\
				tbld.jtbl_pgimp,	\
				tbld.jpgsql_memb,	\
				tbld.jpgsql_impl,	\
				tbld.jtbl_sybaseimp,	\
				tbld.jsybase_memb,	\
				tbld.jsybase_impl,	\
				tbld.jtbl_ramimp,	\
				tbld.jram_memb,	\
				tbld.jram_impl,	\
				tbld.jtbl_saxldimp,	\
				tbld.jsaxstart_memb,	\
				tbld.jsaxend_impl,	\
				tbld.jxmtbl_imp,	\
				tbld.jxmtbl_fmt,	\
				tbld.jxmtbl_rqstimp,	\
				tbld.jxmtbl_rspnimp,	\
				tbld.jxmtbl_clntimp,	\
				tbld.jxmtbl_rqstbdy,	\
				tbld.jxmtbl_rspnbdy,	\
				tbld.jxmtbl_clntbdy,	\
				tbld.dflt_vis,	\
				scop.revision,	\
				2	\
			from cfbam23.tbldef as tbld	\
			inner join cfbam23.scopedef scop on	\
				tbld.tenantid = scop.tenantid	\
				and tbld.Id = scop.id	\
			where	\
				tbld.tenantid = argTenantId	\
		and tbld.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
