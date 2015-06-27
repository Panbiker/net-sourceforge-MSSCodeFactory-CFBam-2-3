--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_tbldef.sql
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

create or replace procedure sp_create_tbldef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
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
	in argDefaultVisibility char(1) )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare permissionFlag integer;	\
		declare argId bigint;	\
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
					'CreateTable',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateTable' );	\
			end if;	\
		end if;	\
	\
		call sp_next_scopeidgen( argTenantId,	\
			argId );	\
		insert into cfbam23.scopedef(	\
			classcode,	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			tenantid,	\
			id,	\
			revision )	\
		values (	\
			argClassCode,	\
		argAuditUserId,	\
			current timestamp,	\
			argAuditUserId,	\
			current timestamp,	\
			argTenantId,	\
			argId,	\
			1 );	\
	\
		insert into cfbam23.tbldef(	\
			tenantid,	\
			schemadefid,	\
			defschtentid,	\
			defschid,	\
			id,	\
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
			dflt_vis )	\
		values (	\
			argTenantId,	\
			argSchemaDefId,	\
			argDefSchemaTenantId,	\
			argDefSchemaId,	\
			argId,	\
			argName,	\
			argDbName,	\
			argShortName,	\
			argLabel,	\
			argShortDescription,	\
			argDescription,	\
			argPrimaryIndexTenantId,	\
			argPrimaryIndexId,	\
			argTableClassCode,	\
			argLookupIndexTenantId,	\
			argLookupIndexId,	\
			argAltIndexTenantId,	\
			argAltIndexId,	\
			argQualifyingTenantId,	\
			argQualifyingTableId,	\
			argPolyBase,	\
			argIsInstantiable,	\
			argHasHistory,	\
			argHasAuditColumns,	\
			argLoaderBehaviourId,	\
			argDataScopeId,	\
			argSecurityScopeId,	\
			argViewAccessSecurityId,	\
			argEditAccessSecurityId,	\
			argViewAccessFrequencyId,	\
			argEditAccessFrequencyId,	\
			argJObjMembers,	\
			argJObjInterface,	\
			argJObjImport,	\
			argJObjImplementation,	\
			argJEditObjMembers,	\
			argJEditObjInterface,	\
			argJEditObjImport,	\
			argJEditObjImplementation,	\
			argJTableImport,	\
			argJTableMembers,	\
			argJTableInterface,	\
			argJTableImplementation,	\
			argJTableObjImport,	\
			argJTableObjMembers,	\
			argJTableObjInterface,	\
			argJTableObjImplementation,	\
			argJDb2LUWTableImport,	\
			argJDb2LUWTableMembers,	\
			argJDb2LUWTableImplementation,	\
			argJMSSqlTableImport,	\
			argJMSSqlTableMembers,	\
			argJMSSqlTableImplementation,	\
			argJMySqlTableImport,	\
			argJMySqlTableMembers,	\
			argJMySqlTableImplementation,	\
			argJOracleTableImport,	\
			argJOracleTableMembers,	\
			argJOracleTableImplementation,	\
			argJPgSqlTableImport,	\
			argJPgSqlTableMembers,	\
			argJPgSqlTableImplementation,	\
			argJSybaseTableImport,	\
			argJSybaseTableMembers,	\
			argJSybaseTableImplementation,	\
			argJRamTableImport,	\
			argJRamTableMembers,	\
			argJRamTableImplementation,	\
			argJSaxLoaderImport,	\
			argJSaxLoaderStartElement,	\
			argJSaxLoaderEndElement,	\
			argJXMsgTableImport,	\
			argJXMsgTableFormatters,	\
			argJXMsgRqstTableImport,	\
			argJXMsgRspnTableImport,	\
			argJXMsgClientTableImport,	\
			argJXMsgRqstTableBody,	\
			argJXMsgRspnTableBody,	\
			argJXMsgClientTableBody,	\
			argDefaultVisibility );	\
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
				1	\
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
