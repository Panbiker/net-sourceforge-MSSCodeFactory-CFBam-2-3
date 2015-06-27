--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_schemadef.sql
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

create or replace procedure sp_create_schemadef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argDomainId bigint,	\
	in argName varchar(192),	\
	in argDbName varchar(12),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argDefaultLicenseTenantId bigint,	\
	in argDefaultLicenseId bigint,	\
	in argExtendCFCore char(1),	\
	in argDataScopeId smallint,	\
	in argViewAccessSecurityId smallint,	\
	in argEditAccessSecurityId smallint,	\
	in argViewAccessFrequencyId smallint,	\
	in argEditAccessFrequencyId smallint,	\
	in argCopyrightPeriod varchar(10),	\
	in argCopyrightHolder varchar(511),	\
	in argPublishURI varchar(512),	\
	in argJSchemaObjImport clob(2000000),	\
	in argJSchemaObjInterface clob(2000000),	\
	in argJSchemaObjMembers clob(2000000),	\
	in argJSchemaObjImplementation clob(2000000),	\
	in argJDb2LUWSchemaObjMembers clob(2000000),	\
	in argJDb2LUWSchemaObjImpl clob(2000000),	\
	in argJDb2LUWSchemaObjImport clob(2000000),	\
	in argJMSSqlSchemaObjMembers clob(2000000),	\
	in argJMSSqlSchemaObjImpl clob(2000000),	\
	in argJMSSqlSchemaObjImport clob(2000000),	\
	in argJMySqlSchemaObjMembers clob(2000000),	\
	in argJMySqlSchemaObjImpl clob(2000000),	\
	in argJMySqlSchemaObjImport clob(2000000),	\
	in argJOracleSchemaObjMembers clob(2000000),	\
	in argJOracleSchemaObjImpl clob(2000000),	\
	in argJOracleSchemaObjImport clob(2000000),	\
	in argJPgSqlSchemaObjMembers clob(2000000),	\
	in argJPgSqlSchemaObjImpl clob(2000000),	\
	in argJPgSqlSchemaObjImport clob(2000000),	\
	in argJSybaseSchemaObjMembers clob(2000000),	\
	in argJSybaseSchemaObjImpl clob(2000000),	\
	in argJSybaseSchemaObjImport clob(2000000),	\
	in argJRamSchemaObjMembers clob(2000000),	\
	in argJRamSchemaObjImpl clob(2000000),	\
	in argJRamSchemaObjImport clob(2000000),	\
	in argJXMsgSchemaImport clob(2000000),	\
	in argJXMsgSchemaFormatters clob(2000000),	\
	in argJXMsgClientSchemaImport clob(2000000),	\
	in argJXMsgClientSchemaBody clob(2000000),	\
	in argJXMsgRqstSchemaBody clob(2000000),	\
	in argJXMsgRqstSchemaImport clob(2000000),	\
	in argJXMsgRqstSchemaWireParsers clob(2000000),	\
	in argJXMsgRqstSchemaXsdSpec clob(2000000),	\
	in argJXMsgRqstSchemaXsdElementList clob(2000000),	\
	in argJXMsgRspnSchemaBody clob(2000000),	\
	in argJXMsgRspnSchemaImport clob(2000000),	\
	in argJXMsgRspnSchemaWireParsers clob(2000000),	\
	in argJXMsgRspnSchemaXsdElementList clob(2000000),	\
	in argJXMsgRspnSchemaXsdSpec clob(2000000) )	\
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
	begin	\
		if( argClassCode = 'SCHM' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'CreateSchemaDef',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateSchemaDef' );	\
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
		insert into cfbam23.schemadef(	\
			tenantid,	\
			id,	\
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
			javaxmsgrspnschxsdspec )	\
		values (	\
			argTenantId,	\
			argId,	\
			argDomainId,	\
			argName,	\
			argDbName,	\
			argShortName,	\
			argLabel,	\
			argShortDescription,	\
			argDescription,	\
			argDefaultLicenseTenantId,	\
			argDefaultLicenseId,	\
			argExtendCFCore,	\
			argDataScopeId,	\
			argViewAccessSecurityId,	\
			argEditAccessSecurityId,	\
			argViewAccessFrequencyId,	\
			argEditAccessFrequencyId,	\
			argCopyrightPeriod,	\
			argCopyrightHolder,	\
			argPublishURI,	\
			argJSchemaObjImport,	\
			argJSchemaObjInterface,	\
			argJSchemaObjMembers,	\
			argJSchemaObjImplementation,	\
			argJDb2LUWSchemaObjMembers,	\
			argJDb2LUWSchemaObjImpl,	\
			argJDb2LUWSchemaObjImport,	\
			argJMSSqlSchemaObjMembers,	\
			argJMSSqlSchemaObjImpl,	\
			argJMSSqlSchemaObjImport,	\
			argJMySqlSchemaObjMembers,	\
			argJMySqlSchemaObjImpl,	\
			argJMySqlSchemaObjImport,	\
			argJOracleSchemaObjMembers,	\
			argJOracleSchemaObjImpl,	\
			argJOracleSchemaObjImport,	\
			argJPgSqlSchemaObjMembers,	\
			argJPgSqlSchemaObjImpl,	\
			argJPgSqlSchemaObjImport,	\
			argJSybaseSchemaObjMembers,	\
			argJSybaseSchemaObjImpl,	\
			argJSybaseSchemaObjImport,	\
			argJRamSchemaObjMembers,	\
			argJRamSchemaObjImpl,	\
			argJRamSchemaObjImport,	\
			argJXMsgSchemaImport,	\
			argJXMsgSchemaFormatters,	\
			argJXMsgClientSchemaImport,	\
			argJXMsgClientSchemaBody,	\
			argJXMsgRqstSchemaBody,	\
			argJXMsgRqstSchemaImport,	\
			argJXMsgRqstSchemaWireParsers,	\
			argJXMsgRqstSchemaXsdSpec,	\
			argJXMsgRqstSchemaXsdElementList,	\
			argJXMsgRspnSchemaBody,	\
			argJXMsgRspnSchemaImport,	\
			argJXMsgRspnSchemaWireParsers,	\
			argJXMsgRspnSchemaXsdElementList,	\
			argJXMsgRspnSchemaXsdSpec );	\
	\
		if( argClassCode = 'SCHM' )	\
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
				scop.revision,	\
				1	\
			from cfbam23.schemadef as schm	\
			inner join cfbam23.scopedef scop on	\
				schm.tenantid = scop.tenantid	\
				and schm.Id = scop.id	\
			where	\
				schm.tenantid = argTenantId	\
		and schm.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
