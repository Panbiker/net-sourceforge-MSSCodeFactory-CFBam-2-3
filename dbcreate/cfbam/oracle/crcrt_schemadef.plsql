--
--	@(#) dbcreate/cfbam/oracle/crcrt_schemadef.plsql
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
--	Code manufactured MSS Code Factory
--

create or replace procedure cfbam23.crt_schemadef(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argDomainId numeric,
	argName varchar2,
	argDbName varchar2,
	argshort_name varchar2,
	argLabel varchar2,
	argshort_descr varchar2,
	argdescr varchar2,
	argDefaultLicenseTenantId numeric,
	argDefLcnId numeric,
	argExtendCFCore char,
	argDataScopeId smallint,
	argVAccSecId smallint,
	argEAccSecId smallint,
	argVAccFreqId smallint,
	argEAccFreqId smallint,
	argCopyPerd varchar2,
	argCopyHold varchar2,
	argPubURI varchar2,
	argjobj_import clob,
	argjobj_xface clob,
	argjobj_memb clob,
	argjobj_impl clob,
	argjdb2_memb clob,
	argjdb2_impl clob,
	argjdb2_import clob,
	argjmssql_memb clob,
	argjmssql_impl clob,
	argjmssql_import clob,
	argjmysql_memb clob,
	argjmysql_impl clob,
	argjmysql_import clob,
	argjoracle_memb clob,
	argjoracle_impl clob,
	argjoracle_import clob,
	argjpgsql_memb clob,
	argjpgsql_impl clob,
	argjpgsql_import clob,
	argjsybase_memb clob,
	argjsybase_impl clob,
	argjsybase_import clob,
	argjram_memb clob,
	argjram_impl clob,
	argjram_impl clob,
	argjavaxmsgschimp clob,
	argjavaxmsgschfmts clob,
	argjavaxmsgcltschimp clob,
	argjavaxmsgcltschbdy clob,
	argjavaxmsgrqstschbdy clob,
	argjavaxmsgrqstschimp clob,
	argjavaxmsgrqstschwirep clob,
	argjavaxmsgrqstschxsdspec clob,
	argjavaxmsgrqstschxsdeltlst clob,
	argjavaxmsgrspnschemabody clob,
	argjavaxmsgrspnschimp clob,
	argjavaxmsgrspnschwirep clob,
	argjavaxmsgrspnschxsdeltlst clob,
	argjavaxmsgrspnschxsdspec clob )
is
	permissionDenied exception;
	permissionFlag integer;
	argId numeric;
begin
	if( argClassCode = 'SCHM' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'CreateSchemaDef',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	argId := cfbam23.nxt_scopeidgen( argTenantId );
	insert into cfbam23.scopedef(
		classcode,
		createdby,
		createdat,
		updatedby,
		updatedat,
		TenantId,
		Id,
		revision )
	values (
		argClassCode,
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argTenantId,
		argId,
		1 );
	insert into cfbam23.schemadef(
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
		javaxmsgrspnschxsdspec )
	values (
		argTenantId,
		argId,
		argDomainId,
		argName,
		argDbName,
		argshort_name,
		argLabel,
		argshort_descr,
		argdescr,
		argDefaultLicenseTenantId,
		argDefLcnId,
		argExtendCFCore,
		argDataScopeId,
		argVAccSecId,
		argEAccSecId,
		argVAccFreqId,
		argEAccFreqId,
		argCopyPerd,
		argCopyHold,
		argPubURI,
		argjobj_import,
		argjobj_xface,
		argjobj_memb,
		argjobj_impl,
		argjdb2_memb,
		argjdb2_impl,
		argjdb2_import,
		argjmssql_memb,
		argjmssql_impl,
		argjmssql_import,
		argjmysql_memb,
		argjmysql_impl,
		argjmysql_import,
		argjoracle_memb,
		argjoracle_impl,
		argjoracle_import,
		argjpgsql_memb,
		argjpgsql_impl,
		argjpgsql_import,
		argjsybase_memb,
		argjsybase_impl,
		argjsybase_import,
		argjram_memb,
		argjram_impl,
		argjram_impl,
		argjavaxmsgschimp,
		argjavaxmsgschfmts,
		argjavaxmsgcltschimp,
		argjavaxmsgcltschbdy,
		argjavaxmsgrqstschbdy,
		argjavaxmsgrqstschimp,
		argjavaxmsgrqstschwirep,
		argjavaxmsgrqstschxsdspec,
		argjavaxmsgrqstschxsdeltlst,
		argjavaxmsgrspnschemabody,
		argjavaxmsgrspnschimp,
		argjavaxmsgrspnschwirep,
		argjavaxmsgrspnschxsdeltlst,
		argjavaxmsgrspnschxsdspec );
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
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			sysdate,
			schm.DomainId as DomainId,
			schm.Name as Name,
			schm.DbName as DbName,
			schm.short_name as short_name,
			schm.Label as Label,
			schm.short_descr as short_descr,
			schm.descr as descr,
			schm.DefaultLicenseTenantId as DefaultLicenseTenantId,
			schm.DefLcnId as DefLcnId,
			schm.ExtendCFCore as ExtendCFCore,
			schm.DataScopeId as DataScopeId,
			schm.VAccSecId as VAccSecId,
			schm.EAccSecId as EAccSecId,
			schm.VAccFreqId as VAccFreqId,
			schm.EAccFreqId as EAccFreqId,
			schm.CopyPerd as CopyPerd,
			schm.CopyHold as CopyHold,
			schm.PubURI as PubURI,
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
			scop.revision,
			1
		from cfbam23.schemadef schm
		inner join cfbam23.scopedef scop on
			schm.TenantId = scop.TenantId
			and schm.Id = scop.Id
		where
			schm.TenantId = argTenantId
			and schm.Id = argId;
	end if;

	open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			schm.DomainId as DomainId,
			schm.Name as Name,
			schm.DbName as DbName,
			schm.short_name as short_name,
			schm.Label as Label,
			schm.short_descr as short_descr,
			schm.descr as descr,
			schm.DefaultLicenseTenantId as DefaultLicenseTenantId,
			schm.DefLcnId as DefLcnId,
			schm.ExtendCFCore as ExtendCFCore,
			schm.DataScopeId as DataScopeId,
			schm.VAccSecId as VAccSecId,
			schm.EAccSecId as EAccSecId,
			schm.VAccFreqId as VAccFreqId,
			schm.EAccFreqId as EAccFreqId,
			schm.CopyPerd as CopyPerd,
			schm.CopyHold as CopyHold,
			schm.PubURI as PubURI,
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
	from cfbam23.schemadef schm
		inner join cfbam23.scopedef scop on
			schm.TenantId = scop.TenantId
			and schm.Id = scop.Id
	where
		schm.TenantId = argTenantId
			and schm.Id = argId;
end crt_schemadef;
/

show errors procedure cfbam23.crt_schemadef;
/
