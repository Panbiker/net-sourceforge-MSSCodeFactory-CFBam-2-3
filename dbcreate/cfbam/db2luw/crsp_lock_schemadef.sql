--
--	@(#) dbcreate/cfbam/db2luw/crsp_lock_schemadef.sql
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


create or replace procedure sp_lock_schemadef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argTenantId bigint,	\
	in argId bigint )	\
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
	declare permissionFlag integer;	\
	declare isSystemUser integer;	\
	declare syscurs cursor with return to client for	\
		select	\
				scop.ClassCode,	\
				scop.createdby as createdby,	\
				to_char( scop.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				scop.updatedby as updatedby,	\
				to_char( scop.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			scop.tenantid as tenantid,	\
			scop.id as id,	\
			schm.domainid as domainid,	\
			schm.name as name,	\
			schm.dbname as dbname,	\
			schm.short_name as short_name,	\
			schm.label as label,	\
			schm.short_descr as short_descr,	\
			schm.descr as descr,	\
			schm.defaultlicensetenantid as defaultlicensetenantid,	\
			schm.deflcnid as deflcnid,	\
			schm.extendcfcore as extendcfcore,	\
			schm.datascopeid as datascopeid,	\
			schm.vaccsecid as vaccsecid,	\
			schm.eaccsecid as eaccsecid,	\
			schm.vaccfreqid as vaccfreqid,	\
			schm.eaccfreqid as eaccfreqid,	\
			schm.copyperd as copyperd,	\
			schm.copyhold as copyhold,	\
			schm.puburi as puburi,	\
			schm.jobj_import as jobj_import,	\
			schm.jobj_xface as jobj_xface,	\
			schm.jobj_memb as jobj_memb,	\
			schm.jobj_impl as jobj_impl,	\
			schm.jdb2_memb as jdb2_memb,	\
			schm.jdb2_impl as jdb2_impl,	\
			schm.jdb2_import as jdb2_import,	\
			schm.jmssql_memb as jmssql_memb,	\
			schm.jmssql_impl as jmssql_impl,	\
			schm.jmssql_import as jmssql_import,	\
			schm.jmysql_memb as jmysql_memb,	\
			schm.jmysql_impl as jmysql_impl,	\
			schm.jmysql_import as jmysql_import,	\
			schm.joracle_memb as joracle_memb,	\
			schm.joracle_impl as joracle_impl,	\
			schm.joracle_import as joracle_import,	\
			schm.jpgsql_memb as jpgsql_memb,	\
			schm.jpgsql_impl as jpgsql_impl,	\
			schm.jpgsql_import as jpgsql_import,	\
			schm.jsybase_memb as jsybase_memb,	\
			schm.jsybase_impl as jsybase_impl,	\
			schm.jsybase_import as jsybase_import,	\
			schm.jram_memb as jram_memb,	\
			schm.jram_impl as jram_impl,	\
			schm.jram_impl as jram_impl,	\
			schm.javaxmsgschimp as javaxmsgschimp,	\
			schm.javaxmsgschfmts as javaxmsgschfmts,	\
			schm.javaxmsgcltschimp as javaxmsgcltschimp,	\
			schm.javaxmsgcltschbdy as javaxmsgcltschbdy,	\
			schm.javaxmsgrqstschbdy as javaxmsgrqstschbdy,	\
			schm.javaxmsgrqstschimp as javaxmsgrqstschimp,	\
			schm.javaxmsgrqstschwirep as javaxmsgrqstschwirep,	\
			schm.javaxmsgrqstschxsdspec as javaxmsgrqstschxsdspec,	\
			schm.javaxmsgrqstschxsdeltlst as javaxmsgrqstschxsdeltlst,	\
			schm.javaxmsgrspnschemabody as javaxmsgrspnschemabody,	\
			schm.javaxmsgrspnschimp as javaxmsgrspnschimp,	\
			schm.javaxmsgrspnschwirep as javaxmsgrspnschwirep,	\
			schm.javaxmsgrspnschxsdeltlst as javaxmsgrspnschxsdeltlst,	\
			schm.javaxmsgrspnschxsdspec as javaxmsgrspnschxsdspec,	\
			scop.revision as revision	\
		from cfbam23.schemadef as schm	\
			inner join cfbam23.scopedef scop on	\
				schm.tenantid = scop.tenantid	\
				and schm.Id = scop.id	\
		where	\
			schm.tenantid = argTenantId	\
		and schm.id = argId;	\
	declare usercurs cursor with return to client for	\
		select	\
				scop.ClassCode,	\
				scop.createdby as createdby,	\
				to_char( scop.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				scop.updatedby as updatedby,	\
				to_char( scop.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			scop.tenantid as tenantid,	\
			scop.id as id,	\
			schm.domainid as domainid,	\
			schm.name as name,	\
			schm.dbname as dbname,	\
			schm.short_name as short_name,	\
			schm.label as label,	\
			schm.short_descr as short_descr,	\
			schm.descr as descr,	\
			schm.defaultlicensetenantid as defaultlicensetenantid,	\
			schm.deflcnid as deflcnid,	\
			schm.extendcfcore as extendcfcore,	\
			schm.datascopeid as datascopeid,	\
			schm.vaccsecid as vaccsecid,	\
			schm.eaccsecid as eaccsecid,	\
			schm.vaccfreqid as vaccfreqid,	\
			schm.eaccfreqid as eaccfreqid,	\
			schm.copyperd as copyperd,	\
			schm.copyhold as copyhold,	\
			schm.puburi as puburi,	\
			schm.jobj_import as jobj_import,	\
			schm.jobj_xface as jobj_xface,	\
			schm.jobj_memb as jobj_memb,	\
			schm.jobj_impl as jobj_impl,	\
			schm.jdb2_memb as jdb2_memb,	\
			schm.jdb2_impl as jdb2_impl,	\
			schm.jdb2_import as jdb2_import,	\
			schm.jmssql_memb as jmssql_memb,	\
			schm.jmssql_impl as jmssql_impl,	\
			schm.jmssql_import as jmssql_import,	\
			schm.jmysql_memb as jmysql_memb,	\
			schm.jmysql_impl as jmysql_impl,	\
			schm.jmysql_import as jmysql_import,	\
			schm.joracle_memb as joracle_memb,	\
			schm.joracle_impl as joracle_impl,	\
			schm.joracle_import as joracle_import,	\
			schm.jpgsql_memb as jpgsql_memb,	\
			schm.jpgsql_impl as jpgsql_impl,	\
			schm.jpgsql_import as jpgsql_import,	\
			schm.jsybase_memb as jsybase_memb,	\
			schm.jsybase_impl as jsybase_impl,	\
			schm.jsybase_import as jsybase_import,	\
			schm.jram_memb as jram_memb,	\
			schm.jram_impl as jram_impl,	\
			schm.jram_impl as jram_impl,	\
			schm.javaxmsgschimp as javaxmsgschimp,	\
			schm.javaxmsgschfmts as javaxmsgschfmts,	\
			schm.javaxmsgcltschimp as javaxmsgcltschimp,	\
			schm.javaxmsgcltschbdy as javaxmsgcltschbdy,	\
			schm.javaxmsgrqstschbdy as javaxmsgrqstschbdy,	\
			schm.javaxmsgrqstschimp as javaxmsgrqstschimp,	\
			schm.javaxmsgrqstschwirep as javaxmsgrqstschwirep,	\
			schm.javaxmsgrqstschxsdspec as javaxmsgrqstschxsdspec,	\
			schm.javaxmsgrqstschxsdeltlst as javaxmsgrqstschxsdeltlst,	\
			schm.javaxmsgrspnschemabody as javaxmsgrspnschemabody,	\
			schm.javaxmsgrspnschimp as javaxmsgrspnschimp,	\
			schm.javaxmsgrspnschwirep as javaxmsgrspnschwirep,	\
			schm.javaxmsgrspnschxsdeltlst as javaxmsgrspnschxsdeltlst,	\
			schm.javaxmsgrspnschxsdspec as javaxmsgrspnschxsdspec,	\
			scop.revision as revision	\
		from cfbam23.schemadef as schm	\
			inner join cfbam23.scopedef scop on	\
				schm.tenantid = scop.tenantid	\
				and schm.Id = scop.id	\
		where	\
			schm.tenantid = argTenantId	\
		and schm.id = argId	\
			and ( schm.TenantId = secTenantId );	\
	begin	\
		set( permissionFlag ) = ( sp_is_tenant_user( secTenantId,	\
				'UpdateSchemaDef',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateSchemaDef' );	\
		end if;	\
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
		set( isSystemUser ) = ( sp_is_system_user( argAuditUserId ) );	\
		if( isSystemUser = 1 )	\
		then	\
			open syscurs;	\
		else	\
			open usercurs;	\
		end if;	\
	end;	\
end
