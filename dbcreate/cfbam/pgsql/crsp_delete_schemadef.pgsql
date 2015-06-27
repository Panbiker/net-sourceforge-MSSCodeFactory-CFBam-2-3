--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_schemadef.pgsql
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

create or replace function cfbam23.sp_delete_schemadef(
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
		'DeleteSchemaDef',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteSchemaDef';
	end if;

	if( oldClassCode = 'SCHM' )
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
			3
		from cfbam23.schemadef as schm
		inner join cfbam23.scopedef scop on
			schm.tenantid = scop.tenantid
			and schm.Id = scop.id
		where
			schm.tenantid = argTenantId
			and schm.id = argId;
	end if;

	for cur in
		select
			reld.TenantId as TenantId,
			reld.Id as Id
		from cfbam23.schemadef as schm
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			schm.TenantId = argTenantId
			and schm.Id = argId
	loop
		update cfbam23.reldef
		set
			NarrowedTenantId = null,
			NarrowedId = null
		where
			TenantId = cur.TenantId
			and Id = cur.Id;

	end loop;

	for cur in
		select
			chn.TenantId,
			chn.Id
		from cfbam23.schemadef as schm
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.chain_def chn on 
				tbld.TenantId = chn.TenantId
				and tbld.Id = chn.TableId
		where
			schm.TenantId = argTenantId
			and schm.Id = argId
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
		from cfbam23.schemadef as schm
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
			schm.TenantId = argTenantId
			and schm.Id = argId
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
		from cfbam23.schemadef as schm
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
			inner join cfbam23.reldef reld on 
				tbld.TenantId = reld.TenantId
				and tbld.Id = reld.TableId
		where
			schm.TenantId = argTenantId
			and schm.Id = argId
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
			tbld.TenantId,
			tbld.Id
		from cfbam23.schemadef as schm
			inner join cfbam23.tbldef tbld on 
				schm.TenantId = tbld.TenantId
				and schm.Id = tbld.SchemaDefId
		where
			schm.TenantId = argTenantId
			and schm.Id = argId
	loop
		select cfbam23.sp_delete_tbldef_by_ididx( argAuditClusterId,
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
		from cfbam23.schemadef as schm
			inner join cfbam23.valdef valu on 
				schm.TenantId = valu.TenantId
				and schm.Id = valu.ScopeId
		where
			schm.TenantId = argTenantId
			and schm.Id = argId
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


	delete from cfbam23.schemadef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_schemadef() Expected to affect 1 schemadef, not %', RowsAffected;
	end if;
	delete from cfbam23.scopedef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_schemadef() Expected to affect 1 scopedef, not %', RowsAffected;
	end if;


	return true;
end;
$$ language plpgsql;
