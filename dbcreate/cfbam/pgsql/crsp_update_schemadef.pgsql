--
--	@(#) dbcreate/cfbam/pgsql/crsp_update_schemadef.pgsql
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


create or replace function cfbam23.sp_update_schemadef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argId bigint,
	argDomainId bigint,
	argName varchar(192),
	argDbName varchar(12),
	argShortName varchar(16),
	argLabel varchar(64),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argDefaultLicenseTenantId bigint,
	argDefaultLicenseId bigint,
	argExtendCFCore boolean,
	argDataScopeId smallint,
	argViewAccessSecurityId smallint,
	argEditAccessSecurityId smallint,
	argViewAccessFrequencyId smallint,
	argEditAccessFrequencyId smallint,
	argCopyrightPeriod varchar(10),
	argCopyrightHolder varchar(511),
	argPublishURI varchar(512),
	argJSchemaObjImport text,
	argJSchemaObjInterface text,
	argJSchemaObjMembers text,
	argJSchemaObjImplementation text,
	argJDb2LUWSchemaObjMembers text,
	argJDb2LUWSchemaObjImpl text,
	argJDb2LUWSchemaObjImport text,
	argJMSSqlSchemaObjMembers text,
	argJMSSqlSchemaObjImpl text,
	argJMSSqlSchemaObjImport text,
	argJMySqlSchemaObjMembers text,
	argJMySqlSchemaObjImpl text,
	argJMySqlSchemaObjImport text,
	argJOracleSchemaObjMembers text,
	argJOracleSchemaObjImpl text,
	argJOracleSchemaObjImport text,
	argJPgSqlSchemaObjMembers text,
	argJPgSqlSchemaObjImpl text,
	argJPgSqlSchemaObjImport text,
	argJSybaseSchemaObjMembers text,
	argJSybaseSchemaObjImpl text,
	argJSybaseSchemaObjImport text,
	argJRamSchemaObjMembers text,
	argJRamSchemaObjImpl text,
	argJRamSchemaObjImport text,
	argJXMsgSchemaImport text,
	argJXMsgSchemaFormatters text,
	argJXMsgClientSchemaImport text,
	argJXMsgClientSchemaBody text,
	argJXMsgRqstSchemaBody text,
	argJXMsgRqstSchemaImport text,
	argJXMsgRqstSchemaWireParsers text,
	argJXMsgRqstSchemaXsdSpec text,
	argJXMsgRqstSchemaXsdElementList text,
	argJXMsgRspnSchemaBody text,
	argJXMsgRspnSchemaImport text,
	argJXMsgRspnSchemaWireParsers text,
	argJXMsgRspnSchemaXsdElementList text,
	argJXMsgRspnSchemaXsdSpec text,
	argRevision integer )
returns setof cfbam23.type_schemadef_rec as $$
declare
	RowsAffected integer;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldId bigint;
	oldRevision int;
	oldDomainId bigint;
	oldName varchar(192);
	oldDbName varchar(12);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldDefaultLicenseTenantId bigint;
	oldDefaultLicenseId bigint;
	oldExtendCFCore boolean;
	oldDataScopeId smallint;
	oldViewAccessSecurityId smallint;
	oldEditAccessSecurityId smallint;
	oldViewAccessFrequencyId smallint;
	oldEditAccessFrequencyId smallint;
	oldCopyrightPeriod varchar(10);
	oldCopyrightHolder varchar(511);
	oldPublishURI varchar(512);
	oldJSchemaObjImport text;
	oldJSchemaObjInterface text;
	oldJSchemaObjMembers text;
	oldJSchemaObjImplementation text;
	oldJDb2LUWSchemaObjMembers text;
	oldJDb2LUWSchemaObjImpl text;
	oldJDb2LUWSchemaObjImport text;
	oldJMSSqlSchemaObjMembers text;
	oldJMSSqlSchemaObjImpl text;
	oldJMSSqlSchemaObjImport text;
	oldJMySqlSchemaObjMembers text;
	oldJMySqlSchemaObjImpl text;
	oldJMySqlSchemaObjImport text;
	oldJOracleSchemaObjMembers text;
	oldJOracleSchemaObjImpl text;
	oldJOracleSchemaObjImport text;
	oldJPgSqlSchemaObjMembers text;
	oldJPgSqlSchemaObjImpl text;
	oldJPgSqlSchemaObjImport text;
	oldJSybaseSchemaObjMembers text;
	oldJSybaseSchemaObjImpl text;
	oldJSybaseSchemaObjImport text;
	oldJRamSchemaObjMembers text;
	oldJRamSchemaObjImpl text;
	oldJRamSchemaObjImport text;
	oldJXMsgSchemaImport text;
	oldJXMsgSchemaFormatters text;
	oldJXMsgClientSchemaImport text;
	oldJXMsgClientSchemaBody text;
	oldJXMsgRqstSchemaBody text;
	oldJXMsgRqstSchemaImport text;
	oldJXMsgRqstSchemaWireParsers text;
	oldJXMsgRqstSchemaXsdSpec text;
	oldJXMsgRqstSchemaXsdElementList text;
	oldJXMsgRspnSchemaBody text;
	oldJXMsgRspnSchemaImport text;
	oldJXMsgRspnSchemaWireParsers text;
	oldJXMsgRspnSchemaXsdElementList text;
	oldJXMsgRspnSchemaXsdSpec text;
	permissionFlag boolean;
begin
	if( argClassCode = 'SCHM' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateSchemaDef',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateSchemaDef';
		end if;
	end if;

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
			Id,
			DomainId,
			Name,
			DbName,
			short_name,
			Label,
			short_descr,
			descr,
			DefaultLicenseTenantId,
			DefLcnId,
			ExtendCFCore,
			DataScopeId,
			VAccSecId,
			EAccSecId,
			VAccFreqId,
			EAccFreqId,
			CopyPerd,
			CopyHold,
			PubURI,
			jobj_import,
			jobj_xface,
			jobj_memb,
			jobj_impl,
			jdb2_memb,
			jdb2_impl,
			jdb2_import,
			jmssql_memb,
			jmssql_impl,
			jmssql_import,
			jmysql_memb,
			jmysql_impl,
			jmysql_import,
			joracle_memb,
			joracle_impl,
			joracle_import,
			jpgsql_memb,
			jpgsql_impl,
			jpgsql_import,
			jsybase_memb,
			jsybase_impl,
			jsybase_import,
			jram_memb,
			jram_impl,
			jram_impl,
			javaxmsgschimp,
			javaxmsgschfmts,
			javaxmsgcltschimp,
			javaxmsgcltschbdy,
			javaxmsgrqstschbdy,
			javaxmsgrqstschimp,
			javaxmsgrqstschwirep,
			javaxmsgrqstschxsdspec,
			javaxmsgrqstschxsdeltlst,
			javaxmsgrspnschemabody,
			javaxmsgrspnschimp,
			javaxmsgrspnschwirep,
			javaxmsgrspnschxsdeltlst,
			javaxmsgrspnschxsdspec
		into
			oldTenantId,
			oldId,
			oldDomainId,
			oldName,
			oldDbName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldDefaultLicenseTenantId,
			oldDefaultLicenseId,
			oldExtendCFCore,
			oldDataScopeId,
			oldViewAccessSecurityId,
			oldEditAccessSecurityId,
			oldViewAccessFrequencyId,
			oldEditAccessFrequencyId,
			oldCopyrightPeriod,
			oldCopyrightHolder,
			oldPublishURI,
			oldJSchemaObjImport,
			oldJSchemaObjInterface,
			oldJSchemaObjMembers,
			oldJSchemaObjImplementation,
			oldJDb2LUWSchemaObjMembers,
			oldJDb2LUWSchemaObjImpl,
			oldJDb2LUWSchemaObjImport,
			oldJMSSqlSchemaObjMembers,
			oldJMSSqlSchemaObjImpl,
			oldJMSSqlSchemaObjImport,
			oldJMySqlSchemaObjMembers,
			oldJMySqlSchemaObjImpl,
			oldJMySqlSchemaObjImport,
			oldJOracleSchemaObjMembers,
			oldJOracleSchemaObjImpl,
			oldJOracleSchemaObjImport,
			oldJPgSqlSchemaObjMembers,
			oldJPgSqlSchemaObjImpl,
			oldJPgSqlSchemaObjImport,
			oldJSybaseSchemaObjMembers,
			oldJSybaseSchemaObjImpl,
			oldJSybaseSchemaObjImport,
			oldJRamSchemaObjMembers,
			oldJRamSchemaObjImpl,
			oldJRamSchemaObjImport,
			oldJXMsgSchemaImport,
			oldJXMsgSchemaFormatters,
			oldJXMsgClientSchemaImport,
			oldJXMsgClientSchemaBody,
			oldJXMsgRqstSchemaBody,
			oldJXMsgRqstSchemaImport,
			oldJXMsgRqstSchemaWireParsers,
			oldJXMsgRqstSchemaXsdSpec,
			oldJXMsgRqstSchemaXsdElementList,
			oldJXMsgRspnSchemaBody,
			oldJXMsgRspnSchemaImport,
			oldJXMsgRspnSchemaWireParsers,
			oldJXMsgRspnSchemaXsdElementList,
			oldJXMsgRspnSchemaXsdSpec
		from cfbam23.schemadef
		where
			TenantId = argTenantId
			and Id = argId
		for update;


	if argRevision != oldRevision
	then
		raise exception 'sp_update_schemadef() Data collision detected';
	end if;


	update cfbam23.scopedef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = now()
	where
		TenantId = argTenantId
			and Id = argId
		and revision = oldRevision;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_schemadef() Expected to affect one scopedef row, not %', RowsAffected;
	end if;

	update cfbam23.schemadef
	set
		domainid = argDomainId,
		name = argName,
		dbname = argDbName,
		short_name = argShortName,
		label = argLabel,
		short_descr = argShortDescription,
		descr = argDescription,
		defaultlicensetenantid = argDefaultLicenseTenantId,
		deflcnid = argDefaultLicenseId,
		extendcfcore = argExtendCFCore,
		datascopeid = argDataScopeId,
		vaccsecid = argViewAccessSecurityId,
		eaccsecid = argEditAccessSecurityId,
		vaccfreqid = argViewAccessFrequencyId,
		eaccfreqid = argEditAccessFrequencyId,
		copyperd = argCopyrightPeriod,
		copyhold = argCopyrightHolder,
		puburi = argPublishURI,
		jobj_import = argJSchemaObjImport,
		jobj_xface = argJSchemaObjInterface,
		jobj_memb = argJSchemaObjMembers,
		jobj_impl = argJSchemaObjImplementation,
		jdb2_memb = argJDb2LUWSchemaObjMembers,
		jdb2_impl = argJDb2LUWSchemaObjImpl,
		jdb2_import = argJDb2LUWSchemaObjImport,
		jmssql_memb = argJMSSqlSchemaObjMembers,
		jmssql_impl = argJMSSqlSchemaObjImpl,
		jmssql_import = argJMSSqlSchemaObjImport,
		jmysql_memb = argJMySqlSchemaObjMembers,
		jmysql_impl = argJMySqlSchemaObjImpl,
		jmysql_import = argJMySqlSchemaObjImport,
		joracle_memb = argJOracleSchemaObjMembers,
		joracle_impl = argJOracleSchemaObjImpl,
		joracle_import = argJOracleSchemaObjImport,
		jpgsql_memb = argJPgSqlSchemaObjMembers,
		jpgsql_impl = argJPgSqlSchemaObjImpl,
		jpgsql_import = argJPgSqlSchemaObjImport,
		jsybase_memb = argJSybaseSchemaObjMembers,
		jsybase_impl = argJSybaseSchemaObjImpl,
		jsybase_import = argJSybaseSchemaObjImport,
		jram_memb = argJRamSchemaObjMembers,
		jram_impl = argJRamSchemaObjImpl,
		jram_impl = argJRamSchemaObjImport,
		javaxmsgschimp = argJXMsgSchemaImport,
		javaxmsgschfmts = argJXMsgSchemaFormatters,
		javaxmsgcltschimp = argJXMsgClientSchemaImport,
		javaxmsgcltschbdy = argJXMsgClientSchemaBody,
		javaxmsgrqstschbdy = argJXMsgRqstSchemaBody,
		javaxmsgrqstschimp = argJXMsgRqstSchemaImport,
		javaxmsgrqstschwirep = argJXMsgRqstSchemaWireParsers,
		javaxmsgrqstschxsdspec = argJXMsgRqstSchemaXsdSpec,
		javaxmsgrqstschxsdeltlst = argJXMsgRqstSchemaXsdElementList,
		javaxmsgrspnschemabody = argJXMsgRspnSchemaBody,
		javaxmsgrspnschimp = argJXMsgRspnSchemaImport,
		javaxmsgrspnschwirep = argJXMsgRspnSchemaWireParsers,
		javaxmsgrspnschxsdeltlst = argJXMsgRspnSchemaXsdElementList,
		javaxmsgrspnschxsdspec = argJXMsgRspnSchemaXsdSpec
	where
		TenantId = argTenantId
			and Id = argId;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_schemadef() Expected to affect one schemadef row, not %', RowsAffected;
	end if;


	if( argClassCode = 'SCHM' )
	then
		insert into cfbam23.schemadef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			DomainId,
			Name,
			DbName,
			short_name,
			Label,
			short_descr,
			descr,
			DefaultLicenseTenantId,
			DefLcnId,
			ExtendCFCore,
			DataScopeId,
			VAccSecId,
			EAccSecId,
			VAccFreqId,
			EAccFreqId,
			CopyPerd,
			CopyHold,
			PubURI,
			jobj_import,
			jobj_xface,
			jobj_memb,
			jobj_impl,
			jdb2_memb,
			jdb2_impl,
			jdb2_import,
			jmssql_memb,
			jmssql_impl,
			jmssql_import,
			jmysql_memb,
			jmysql_impl,
			jmysql_import,
			joracle_memb,
			joracle_impl,
			joracle_import,
			jpgsql_memb,
			jpgsql_impl,
			jpgsql_import,
			jsybase_memb,
			jsybase_impl,
			jsybase_import,
			jram_memb,
			jram_impl,
			jram_impl,
			javaxmsgschimp,
			javaxmsgschfmts,
			javaxmsgcltschimp,
			javaxmsgcltschbdy,
			javaxmsgrqstschbdy,
			javaxmsgrqstschimp,
			javaxmsgrqstschwirep,
			javaxmsgrqstschxsdspec,
			javaxmsgrqstschxsdeltlst,
			javaxmsgrspnschemabody,
			javaxmsgrspnschimp,
			javaxmsgrspnschwirep,
			javaxmsgrspnschxsdeltlst,
			javaxmsgrspnschxsdspec,
			revision,
			auditaction )
		select
			scop.TenantId,
			scop.Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			schm.DomainId,
			schm.Name,
			schm.DbName,
			schm.short_name,
			schm.Label,
			schm.short_descr,
			schm.descr,
			schm.DefaultLicenseTenantId,
			schm.DefLcnId,
			schm.ExtendCFCore,
			schm.DataScopeId,
			schm.VAccSecId,
			schm.EAccSecId,
			schm.VAccFreqId,
			schm.EAccFreqId,
			schm.CopyPerd,
			schm.CopyHold,
			schm.PubURI,
			schm.jobj_import,
			schm.jobj_xface,
			schm.jobj_memb,
			schm.jobj_impl,
			schm.jdb2_memb,
			schm.jdb2_impl,
			schm.jdb2_import,
			schm.jmssql_memb,
			schm.jmssql_impl,
			schm.jmssql_import,
			schm.jmysql_memb,
			schm.jmysql_impl,
			schm.jmysql_import,
			schm.joracle_memb,
			schm.joracle_impl,
			schm.joracle_import,
			schm.jpgsql_memb,
			schm.jpgsql_impl,
			schm.jpgsql_import,
			schm.jsybase_memb,
			schm.jsybase_impl,
			schm.jsybase_import,
			schm.jram_memb,
			schm.jram_impl,
			schm.jram_impl,
			schm.javaxmsgschimp,
			schm.javaxmsgschfmts,
			schm.javaxmsgcltschimp,
			schm.javaxmsgcltschbdy,
			schm.javaxmsgrqstschbdy,
			schm.javaxmsgrqstschimp,
			schm.javaxmsgrqstschwirep,
			schm.javaxmsgrqstschxsdspec,
			schm.javaxmsgrqstschxsdeltlst,
			schm.javaxmsgrspnschemabody,
			schm.javaxmsgrspnschimp,
			schm.javaxmsgrspnschwirep,
			schm.javaxmsgrspnschxsdeltlst,
			schm.javaxmsgrspnschxsdspec,
			argRevision + 1,
			2
		from cfbam23.schemadef as schm
		inner join cfbam23.scopedef scop on
			schm.tenantid = scop.tenantid
			and schm.Id = scop.id
		where
			schm.tenantid = argTenantId
			and schm.id = argId;
	end if;

	return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			schm.domainid as domainid,
			schm.name as name,
			schm.dbname as dbname,
			schm.short_name as short_name,
			schm.label as label,
			schm.short_descr as short_descr,
			schm.descr as descr,
			schm.defaultlicensetenantid as defaultlicensetenantid,
			schm.deflcnid as deflcnid,
			schm.extendcfcore as extendcfcore,
			schm.datascopeid as datascopeid,
			schm.vaccsecid as vaccsecid,
			schm.eaccsecid as eaccsecid,
			schm.vaccfreqid as vaccfreqid,
			schm.eaccfreqid as eaccfreqid,
			schm.copyperd as copyperd,
			schm.copyhold as copyhold,
			schm.puburi as puburi,
			schm.jobj_import as jobj_import,
			schm.jobj_xface as jobj_xface,
			schm.jobj_memb as jobj_memb,
			schm.jobj_impl as jobj_impl,
			schm.jdb2_memb as jdb2_memb,
			schm.jdb2_impl as jdb2_impl,
			schm.jdb2_import as jdb2_import,
			schm.jmssql_memb as jmssql_memb,
			schm.jmssql_impl as jmssql_impl,
			schm.jmssql_import as jmssql_import,
			schm.jmysql_memb as jmysql_memb,
			schm.jmysql_impl as jmysql_impl,
			schm.jmysql_import as jmysql_import,
			schm.joracle_memb as joracle_memb,
			schm.joracle_impl as joracle_impl,
			schm.joracle_import as joracle_import,
			schm.jpgsql_memb as jpgsql_memb,
			schm.jpgsql_impl as jpgsql_impl,
			schm.jpgsql_import as jpgsql_import,
			schm.jsybase_memb as jsybase_memb,
			schm.jsybase_impl as jsybase_impl,
			schm.jsybase_import as jsybase_import,
			schm.jram_memb as jram_memb,
			schm.jram_impl as jram_impl,
			schm.jram_impl as jram_impl,
			schm.javaxmsgschimp as javaxmsgschimp,
			schm.javaxmsgschfmts as javaxmsgschfmts,
			schm.javaxmsgcltschimp as javaxmsgcltschimp,
			schm.javaxmsgcltschbdy as javaxmsgcltschbdy,
			schm.javaxmsgrqstschbdy as javaxmsgrqstschbdy,
			schm.javaxmsgrqstschimp as javaxmsgrqstschimp,
			schm.javaxmsgrqstschwirep as javaxmsgrqstschwirep,
			schm.javaxmsgrqstschxsdspec as javaxmsgrqstschxsdspec,
			schm.javaxmsgrqstschxsdeltlst as javaxmsgrqstschxsdeltlst,
			schm.javaxmsgrspnschemabody as javaxmsgrspnschemabody,
			schm.javaxmsgrspnschimp as javaxmsgrspnschimp,
			schm.javaxmsgrspnschwirep as javaxmsgrspnschwirep,
			schm.javaxmsgrspnschxsdeltlst as javaxmsgrspnschxsdeltlst,
			schm.javaxmsgrspnschxsdspec as javaxmsgrspnschxsdspec,
		scop.revision as revision
	from cfbam23.schemadef as schm
		inner join cfbam23.scopedef scop on
			schm.tenantid = scop.tenantid
			and schm.Id = scop.id
	where
		schm.tenantid = argTenantId
			and schm.id = argId;

	return;
end;
$$ language plpgsql;
