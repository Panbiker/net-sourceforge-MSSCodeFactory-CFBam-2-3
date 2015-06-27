--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_tbldef.sql
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

create or replace procedure sp_delete_tbldef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argRevision int )	\
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
	declare subret boolean;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select 1 from sysibm.sysdummy1;	\
	begin	\
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
		if( oldTenantId != secTenantId )	\
		then	\
			set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- Data is not owned by logged in tenant' );	\
			end if;	\
		end if;	\
	\
		set( permissionFlag ) = ( sp_is_tenant_user( oldTenantId,	\
				'DeleteTable',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for DeleteTable' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_tbldef() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.tbldef	\
		set	\
			tenantid = argTenantId,	\
			lookidxtentid = null,	\
			lookidxid = null,	\
			altidxtentid = null,	\
			altidxid = null,	\
			primidxtentid = null,	\
			primidxid = null	\
		where	\
			TenantId = argTenantId	\
			and Id = argId;	\
	\
		for cur as	\
			select	\
				srvm.tenantid as tenantid,	\
				srvm.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.srvmeth srvm on 	\
					tbld.tenantid = srvm.tenantid	\
					and tbld.id = srvm.tableid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_srvmeth_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				chn.tenantid as tenantid,	\
				chn.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.chain_def chn on 	\
					tbld.tenantid = chn.tenantid	\
					and tbld.id = chn.tableid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_chain_def_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				relc.tenantid as tenantid,	\
				relc.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
				inner join cfbam23.relcol relc on 	\
					reld.tenantid = relc.tenantid	\
					and reld.id = relc.relationid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_relcol_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				reld.tenantid as tenantid,	\
				reld.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_reldef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				idxc.tenantid as tenantid,	\
				idxc.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.idxdef idxd on 	\
					tbld.tenantid = idxd.tenantid	\
					and tbld.id = idxd.tableid	\
				inner join cfbam23.idxcol idxc on 	\
					idxd.tenantid = idxc.tenantid	\
					and idxd.id = idxc.indexid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_idxcol_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				idxd.tenantid as tenantid,	\
				idxd.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.idxdef idxd on 	\
					tbld.tenantid = idxd.tenantid	\
					and tbld.id = idxd.tableid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_idxdef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				valu.tenantid as tenantid,	\
				valu.id as id	\
			from cfbam23.tbldef as tbld	\
				inner join cfbam23.valdef valu on 	\
					tbld.tenantid = valu.tenantid	\
					and tbld.id = valu.scopeid	\
			where	\
				tbld.tenantid = argTenantId	\
				and tbld.id = argId	\
		do	\
			call sp_delete_valdef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		if( oldClassCode = 'TBLD' )	\
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
				scop.revision + 1,	\
				3	\
			from cfbam23.tbldef as tbld	\
			inner join cfbam23.scopedef scop on	\
				tbld.tenantid = scop.tenantid	\
				and tbld.Id = scop.id	\
			where	\
				tbld.tenantid = argTenantId	\
		and tbld.id = argId;	\
		end if;	\
	\
		delete from cfbam23.tbldef	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
		delete from cfbam23.scopedef	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
	\
	\
		open retcursor;	\
	end;	\
end
