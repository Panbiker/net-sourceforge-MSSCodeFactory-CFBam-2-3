--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_schemadef.sql
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

create or replace procedure sp_delete_schemadef(	\
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
	declare oldDomainId bigint;	\
	declare oldName varchar(192);	\
	declare oldDbName varchar(12);	\
	declare oldShortName varchar(16);	\
	declare oldLabel varchar(64);	\
	declare oldShortDescription varchar(128);	\
	declare oldDescription varchar(1023);	\
	declare oldDefaultLicenseTenantId bigint;	\
	declare oldDefaultLicenseId bigint;	\
	declare oldExtendCFCore char(1);	\
	declare oldDataScopeId smallint;	\
	declare oldViewAccessSecurityId smallint;	\
	declare oldEditAccessSecurityId smallint;	\
	declare oldViewAccessFrequencyId smallint;	\
	declare oldEditAccessFrequencyId smallint;	\
	declare oldCopyrightPeriod varchar(10);	\
	declare oldCopyrightHolder varchar(511);	\
	declare oldPublishURI varchar(512);	\
	declare oldJSchemaObjImport clob(2000000);	\
	declare oldJSchemaObjInterface clob(2000000);	\
	declare oldJSchemaObjMembers clob(2000000);	\
	declare oldJSchemaObjImplementation clob(2000000);	\
	declare oldJDb2LUWSchemaObjMembers clob(2000000);	\
	declare oldJDb2LUWSchemaObjImpl clob(2000000);	\
	declare oldJDb2LUWSchemaObjImport clob(2000000);	\
	declare oldJMSSqlSchemaObjMembers clob(2000000);	\
	declare oldJMSSqlSchemaObjImpl clob(2000000);	\
	declare oldJMSSqlSchemaObjImport clob(2000000);	\
	declare oldJMySqlSchemaObjMembers clob(2000000);	\
	declare oldJMySqlSchemaObjImpl clob(2000000);	\
	declare oldJMySqlSchemaObjImport clob(2000000);	\
	declare oldJOracleSchemaObjMembers clob(2000000);	\
	declare oldJOracleSchemaObjImpl clob(2000000);	\
	declare oldJOracleSchemaObjImport clob(2000000);	\
	declare oldJPgSqlSchemaObjMembers clob(2000000);	\
	declare oldJPgSqlSchemaObjImpl clob(2000000);	\
	declare oldJPgSqlSchemaObjImport clob(2000000);	\
	declare oldJSybaseSchemaObjMembers clob(2000000);	\
	declare oldJSybaseSchemaObjImpl clob(2000000);	\
	declare oldJSybaseSchemaObjImport clob(2000000);	\
	declare oldJRamSchemaObjMembers clob(2000000);	\
	declare oldJRamSchemaObjImpl clob(2000000);	\
	declare oldJRamSchemaObjImport clob(2000000);	\
	declare oldJXMsgSchemaImport clob(2000000);	\
	declare oldJXMsgSchemaFormatters clob(2000000);	\
	declare oldJXMsgClientSchemaImport clob(2000000);	\
	declare oldJXMsgClientSchemaBody clob(2000000);	\
	declare oldJXMsgRqstSchemaBody clob(2000000);	\
	declare oldJXMsgRqstSchemaImport clob(2000000);	\
	declare oldJXMsgRqstSchemaWireParsers clob(2000000);	\
	declare oldJXMsgRqstSchemaXsdSpec clob(2000000);	\
	declare oldJXMsgRqstSchemaXsdElementList clob(2000000);	\
	declare oldJXMsgRspnSchemaBody clob(2000000);	\
	declare oldJXMsgRspnSchemaImport clob(2000000);	\
	declare oldJXMsgRspnSchemaWireParsers clob(2000000);	\
	declare oldJXMsgRspnSchemaXsdElementList clob(2000000);	\
	declare oldJXMsgRspnSchemaXsdSpec clob(2000000);	\
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
			Id,	\
			DomainId,	\
			Name,	\
			DbName,	\
			short_name,	\
			Label,	\
			short_descr,	\
			descr,	\
			DefaultLicenseTenantId,	\
			DefLcnId,	\
			ExtendCFCore,	\
			DataScopeId,	\
			VAccSecId,	\
			EAccSecId,	\
			VAccFreqId,	\
			EAccFreqId,	\
			CopyPerd,	\
			CopyHold,	\
			PubURI,	\
			jobj_import,	\
			jobj_xface,	\
			jobj_memb,	\
			jobj_impl,	\
			jdb2_memb,	\
			jdb2_impl,	\
			jdb2_import,	\
			jmssql_memb,	\
			jmssql_impl,	\
			jmssql_import,	\
			jmysql_memb,	\
			jmysql_impl,	\
			jmysql_import,	\
			joracle_memb,	\
			joracle_impl,	\
			joracle_import,	\
			jpgsql_memb,	\
			jpgsql_impl,	\
			jpgsql_import,	\
			jsybase_memb,	\
			jsybase_impl,	\
			jsybase_import,	\
			jram_memb,	\
			jram_impl,	\
			jram_impl,	\
			javaxmsgschimp,	\
			javaxmsgschfmts,	\
			javaxmsgcltschimp,	\
			javaxmsgcltschbdy,	\
			javaxmsgrqstschbdy,	\
			javaxmsgrqstschimp,	\
			javaxmsgrqstschwirep,	\
			javaxmsgrqstschxsdspec,	\
			javaxmsgrqstschxsdeltlst,	\
			javaxmsgrspnschemabody,	\
			javaxmsgrspnschimp,	\
			javaxmsgrspnschwirep,	\
			javaxmsgrspnschxsdeltlst,	\
			javaxmsgrspnschxsdspec	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldDomainId,	\
			oldName,	\
			oldDbName,	\
			oldShortName,	\
			oldLabel,	\
			oldShortDescription,	\
			oldDescription,	\
			oldDefaultLicenseTenantId,	\
			oldDefaultLicenseId,	\
			oldExtendCFCore,	\
			oldDataScopeId,	\
			oldViewAccessSecurityId,	\
			oldEditAccessSecurityId,	\
			oldViewAccessFrequencyId,	\
			oldEditAccessFrequencyId,	\
			oldCopyrightPeriod,	\
			oldCopyrightHolder,	\
			oldPublishURI,	\
			oldJSchemaObjImport,	\
			oldJSchemaObjInterface,	\
			oldJSchemaObjMembers,	\
			oldJSchemaObjImplementation,	\
			oldJDb2LUWSchemaObjMembers,	\
			oldJDb2LUWSchemaObjImpl,	\
			oldJDb2LUWSchemaObjImport,	\
			oldJMSSqlSchemaObjMembers,	\
			oldJMSSqlSchemaObjImpl,	\
			oldJMSSqlSchemaObjImport,	\
			oldJMySqlSchemaObjMembers,	\
			oldJMySqlSchemaObjImpl,	\
			oldJMySqlSchemaObjImport,	\
			oldJOracleSchemaObjMembers,	\
			oldJOracleSchemaObjImpl,	\
			oldJOracleSchemaObjImport,	\
			oldJPgSqlSchemaObjMembers,	\
			oldJPgSqlSchemaObjImpl,	\
			oldJPgSqlSchemaObjImport,	\
			oldJSybaseSchemaObjMembers,	\
			oldJSybaseSchemaObjImpl,	\
			oldJSybaseSchemaObjImport,	\
			oldJRamSchemaObjMembers,	\
			oldJRamSchemaObjImpl,	\
			oldJRamSchemaObjImport,	\
			oldJXMsgSchemaImport,	\
			oldJXMsgSchemaFormatters,	\
			oldJXMsgClientSchemaImport,	\
			oldJXMsgClientSchemaBody,	\
			oldJXMsgRqstSchemaBody,	\
			oldJXMsgRqstSchemaImport,	\
			oldJXMsgRqstSchemaWireParsers,	\
			oldJXMsgRqstSchemaXsdSpec,	\
			oldJXMsgRqstSchemaXsdElementList,	\
			oldJXMsgRspnSchemaBody,	\
			oldJXMsgRspnSchemaImport,	\
			oldJXMsgRspnSchemaWireParsers,	\
			oldJXMsgRspnSchemaXsdElementList,	\
			oldJXMsgRspnSchemaXsdSpec	\
		from cfbam23.schemadef	\
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
				'DeleteSchemaDef',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for DeleteSchemaDef' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_schemadef() Data collision detected' );	\
		end if;	\
	\
		for cur as	\
			select	\
				reld.tenantid as curTenantId,	\
				reld.id as curId	\
			from cfbam23.schemadef as schm	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.SchemaDefId	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.TableId	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
		do	\
			update cfbam23.reldef	\
			set	\
				narrowedtenantid = null,	\
				narrowedid = null	\
			where	\
				tenantid = curTenantId	\
				and id = curId;	\
	\
		end for;	\
	\
		for cur as	\
			select	\
				chn.tenantid as tenantid,	\
				chn.id as id	\
			from cfbam23.schemadef as schm	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.chain_def chn on 	\
					tbld.tenantid = chn.tenantid	\
					and tbld.id = chn.tableid	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
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
			from cfbam23.schemadef as schm	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
				inner join cfbam23.relcol relc on 	\
					reld.tenantid = relc.tenantid	\
					and reld.id = relc.relationid	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
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
			from cfbam23.schemadef as schm	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
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
				tbld.tenantid as tenantid,	\
				tbld.id as id	\
			from cfbam23.schemadef as schm	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
		do	\
			call sp_delete_tbldef_by_ididx( argAuditClusterId,	\
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
			from cfbam23.schemadef as schm	\
				inner join cfbam23.valdef valu on 	\
					schm.tenantid = valu.tenantid	\
					and schm.id = valu.scopeid	\
			where	\
				schm.tenantid = argTenantId	\
				and schm.id = argId	\
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
		if( oldClassCode = 'SCHM' )	\
		then	\
			insert into cfbam23.schemadef_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				domainid,	\
				name,	\
				dbname,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				defaultlicensetenantid,	\
				deflcnid,	\
				extendcfcore,	\
				datascopeid,	\
				vaccsecid,	\
				eaccsecid,	\
				vaccfreqid,	\
				eaccfreqid,	\
				copyperd,	\
				copyhold,	\
				puburi,	\
				jobj_import,	\
				jobj_xface,	\
				jobj_memb,	\
				jobj_impl,	\
				jdb2_memb,	\
				jdb2_impl,	\
				jdb2_import,	\
				jmssql_memb,	\
				jmssql_impl,	\
				jmssql_import,	\
				jmysql_memb,	\
				jmysql_impl,	\
				jmysql_import,	\
				joracle_memb,	\
				joracle_impl,	\
				joracle_import,	\
				jpgsql_memb,	\
				jpgsql_impl,	\
				jpgsql_import,	\
				jsybase_memb,	\
				jsybase_impl,	\
				jsybase_import,	\
				jram_memb,	\
				jram_impl,	\
				jram_impl,	\
				javaxmsgschimp,	\
				javaxmsgschfmts,	\
				javaxmsgcltschimp,	\
				javaxmsgcltschbdy,	\
				javaxmsgrqstschbdy,	\
				javaxmsgrqstschimp,	\
				javaxmsgrqstschwirep,	\
				javaxmsgrqstschxsdspec,	\
				javaxmsgrqstschxsdeltlst,	\
				javaxmsgrspnschemabody,	\
				javaxmsgrspnschimp,	\
				javaxmsgrspnschwirep,	\
				javaxmsgrspnschxsdeltlst,	\
				javaxmsgrspnschxsdspec,	\
				revision,	\
				auditaction )	\
			select	\
				scop.tenantid,	\
				scop.id,	\
				scop.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				schm.domainid,	\
				schm.name,	\
				schm.dbname,	\
				schm.short_name,	\
				schm.label,	\
				schm.short_descr,	\
				schm.descr,	\
				schm.defaultlicensetenantid,	\
				schm.deflcnid,	\
				schm.extendcfcore,	\
				schm.datascopeid,	\
				schm.vaccsecid,	\
				schm.eaccsecid,	\
				schm.vaccfreqid,	\
				schm.eaccfreqid,	\
				schm.copyperd,	\
				schm.copyhold,	\
				schm.puburi,	\
				schm.jobj_import,	\
				schm.jobj_xface,	\
				schm.jobj_memb,	\
				schm.jobj_impl,	\
				schm.jdb2_memb,	\
				schm.jdb2_impl,	\
				schm.jdb2_import,	\
				schm.jmssql_memb,	\
				schm.jmssql_impl,	\
				schm.jmssql_import,	\
				schm.jmysql_memb,	\
				schm.jmysql_impl,	\
				schm.jmysql_import,	\
				schm.joracle_memb,	\
				schm.joracle_impl,	\
				schm.joracle_import,	\
				schm.jpgsql_memb,	\
				schm.jpgsql_impl,	\
				schm.jpgsql_import,	\
				schm.jsybase_memb,	\
				schm.jsybase_impl,	\
				schm.jsybase_import,	\
				schm.jram_memb,	\
				schm.jram_impl,	\
				schm.jram_impl,	\
				schm.javaxmsgschimp,	\
				schm.javaxmsgschfmts,	\
				schm.javaxmsgcltschimp,	\
				schm.javaxmsgcltschbdy,	\
				schm.javaxmsgrqstschbdy,	\
				schm.javaxmsgrqstschimp,	\
				schm.javaxmsgrqstschwirep,	\
				schm.javaxmsgrqstschxsdspec,	\
				schm.javaxmsgrqstschxsdeltlst,	\
				schm.javaxmsgrspnschemabody,	\
				schm.javaxmsgrspnschimp,	\
				schm.javaxmsgrspnschwirep,	\
				schm.javaxmsgrspnschxsdeltlst,	\
				schm.javaxmsgrspnschxsdspec,	\
				scop.revision + 1,	\
				3	\
			from cfbam23.schemadef as schm	\
			inner join cfbam23.scopedef scop on	\
				schm.tenantid = scop.tenantid	\
				and schm.Id = scop.id	\
			where	\
				schm.tenantid = argTenantId	\
		and schm.id = argId;	\
		end if;	\
	\
		delete from cfbam23.schemadef	\
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
