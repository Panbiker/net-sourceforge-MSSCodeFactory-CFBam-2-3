--
--	@(#) dbcreate/cfbam/oracle/crcrt_tbldef.plsql
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

create or replace procedure cfbam23.crt_tbldef(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argSchemaDefId numeric,
	argdefschtentid numeric,
	argdefschid numeric,
	argName varchar2,
	argDbName varchar2,
	argshort_name varchar2,
	argLabel varchar2,
	argshort_descr varchar2,
	argdescr varchar2,
	argPrimIdxTentId numeric,
	argPrimIdxId numeric,
	argTblClsCd varchar2,
	argLookIdxTentId numeric,
	argLookIdxId numeric,
	argAltIdxTentId numeric,
	argAltIdxId numeric,
	argQualTentId numeric,
	argQualTblId numeric,
	argPolyBase char,
	argIsInstantiable char,
	argHasHistory char,
	argHasAuditColumns char,
	argLoadBehavId smallint,
	argDataScopeId smallint,
	argSecScopeId smallint,
	argVASecId smallint,
	argEASecId smallint,
	argVAFId smallint,
	argEAFId smallint,
	argjobj_memb clob,
	argjobj_xface clob,
	argjtbl_objimp clob,
	argjobj_impl clob,
	argjedt_memb clob,
	argjedt_xface clob,
	argjtbl_eobjimp clob,
	argjedt_impl clob,
	argjtbl_imp clob,
	argjtbl_memb clob,
	argjtbl_xface clob,
	argjtbl_impl clob,
	argjtbl_objimp clob,
	argjtbl_objmemb clob,
	argjtbl_objxface clob,
	argjtbl_objimpl clob,
	argjtbl_db2imp clob,
	argjdb2_memb clob,
	argjdb2_impl clob,
	argjtbl_msimp clob,
	argjmssql_memb clob,
	argjmssql_impl clob,
	argjtbl_myimp clob,
	argjmysql_memb clob,
	argjmysql_impl clob,
	argjtbl_oraimp clob,
	argjoracle_memb clob,
	argjoracle_impl clob,
	argjtbl_pgimp clob,
	argjpgsql_memb clob,
	argjpgsql_impl clob,
	argjtbl_sybaseimp clob,
	argjsybase_memb clob,
	argjsybase_impl clob,
	argjtbl_ramimp clob,
	argjram_memb clob,
	argjram_impl clob,
	argjtbl_saxldimp clob,
	argjsaxstart_memb clob,
	argjsaxend_impl clob,
	argjxmtbl_imp clob,
	argjxmtbl_fmt clob,
	argjxmtbl_rqstimp clob,
	argjxmtbl_rspnimp clob,
	argjxmtbl_clntimp clob,
	argjxmtbl_rqstbdy clob,
	argjxmtbl_rspnbdy clob,
	argjxmtbl_clntbdy clob,
	argdflt_vis char )
is
	permissionDenied exception;
	permissionFlag integer;
	argId numeric;
begin
	if( argClassCode = 'TBLD' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'CreateTable',
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
	insert into cfbam23.tbldef(
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
		dflt_vis )
	values (
		argTenantId,
		argSchemaDefId,
		argdefschtentid,
		argdefschid,
		argId,
		argName,
		argDbName,
		argshort_name,
		argLabel,
		argshort_descr,
		argdescr,
		argPrimIdxTentId,
		argPrimIdxId,
		argTblClsCd,
		argLookIdxTentId,
		argLookIdxId,
		argAltIdxTentId,
		argAltIdxId,
		argQualTentId,
		argQualTblId,
		argPolyBase,
		argIsInstantiable,
		argHasHistory,
		argHasAuditColumns,
		argLoadBehavId,
		argDataScopeId,
		argSecScopeId,
		argVASecId,
		argEASecId,
		argVAFId,
		argEAFId,
		argjobj_memb,
		argjobj_xface,
		argjtbl_objimp,
		argjobj_impl,
		argjedt_memb,
		argjedt_xface,
		argjtbl_eobjimp,
		argjedt_impl,
		argjtbl_imp,
		argjtbl_memb,
		argjtbl_xface,
		argjtbl_impl,
		argjtbl_objimp,
		argjtbl_objmemb,
		argjtbl_objxface,
		argjtbl_objimpl,
		argjtbl_db2imp,
		argjdb2_memb,
		argjdb2_impl,
		argjtbl_msimp,
		argjmssql_memb,
		argjmssql_impl,
		argjtbl_myimp,
		argjmysql_memb,
		argjmysql_impl,
		argjtbl_oraimp,
		argjoracle_memb,
		argjoracle_impl,
		argjtbl_pgimp,
		argjpgsql_memb,
		argjpgsql_impl,
		argjtbl_sybaseimp,
		argjsybase_memb,
		argjsybase_impl,
		argjtbl_ramimp,
		argjram_memb,
		argjram_impl,
		argjtbl_saxldimp,
		argjsaxstart_memb,
		argjsaxend_impl,
		argjxmtbl_imp,
		argjxmtbl_fmt,
		argjxmtbl_rqstimp,
		argjxmtbl_rspnimp,
		argjxmtbl_clntimp,
		argjxmtbl_rqstbdy,
		argjxmtbl_rspnbdy,
		argjxmtbl_clntbdy,
		argdflt_vis );
	if( argClassCode = 'TBLD' )
	then
		insert into cfbam23.tbldef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			SchemaDefId,
			defschtentid,
			defschid,
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
			dflt_vis,
			revision,
			auditaction )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			sysdate,
			tbld.SchemaDefId as SchemaDefId,
			tbld.defschtentid as defschtentid,
			tbld.defschid as defschid,
			tbld.Name as Name,
			tbld.DbName as DbName,
			tbld.short_name as short_name,
			tbld.Label as Label,
			tbld.short_descr as short_descr,
			tbld.descr as descr,
			tbld.PrimIdxTentId as PrimIdxTentId,
			tbld.PrimIdxId as PrimIdxId,
			tbld.TblClsCd as TblClsCd,
			tbld.LookIdxTentId as LookIdxTentId,
			tbld.LookIdxId as LookIdxId,
			tbld.AltIdxTentId as AltIdxTentId,
			tbld.AltIdxId as AltIdxId,
			tbld.QualTentId as QualTentId,
			tbld.QualTblId as QualTblId,
			tbld.PolyBase as PolyBase,
			tbld.IsInstantiable as IsInstantiable,
			tbld.HasHistory as HasHistory,
			tbld.HasAuditColumns as HasAuditColumns,
			tbld.LoadBehavId as LoadBehavId,
			tbld.DataScopeId as DataScopeId,
			tbld.SecScopeId as SecScopeId,
			tbld.VASecId as VASecId,
			tbld.EASecId as EASecId,
			tbld.VAFId as VAFId,
			tbld.EAFId as EAFId,
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
			scop.revision,
			1
		from cfbam23.tbldef tbld
		inner join cfbam23.scopedef scop on
			tbld.TenantId = scop.TenantId
			and tbld.Id = scop.Id
		where
			tbld.TenantId = argTenantId
			and tbld.Id = argId;
	end if;

	open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			tbld.SchemaDefId as SchemaDefId,
			tbld.defschtentid as defschtentid,
			tbld.defschid as defschid,
			tbld.Name as Name,
			tbld.DbName as DbName,
			tbld.short_name as short_name,
			tbld.Label as Label,
			tbld.short_descr as short_descr,
			tbld.descr as descr,
			tbld.PrimIdxTentId as PrimIdxTentId,
			tbld.PrimIdxId as PrimIdxId,
			tbld.TblClsCd as TblClsCd,
			tbld.LookIdxTentId as LookIdxTentId,
			tbld.LookIdxId as LookIdxId,
			tbld.AltIdxTentId as AltIdxTentId,
			tbld.AltIdxId as AltIdxId,
			tbld.QualTentId as QualTentId,
			tbld.QualTblId as QualTblId,
			tbld.PolyBase as PolyBase,
			tbld.IsInstantiable as IsInstantiable,
			tbld.HasHistory as HasHistory,
			tbld.HasAuditColumns as HasAuditColumns,
			tbld.LoadBehavId as LoadBehavId,
			tbld.DataScopeId as DataScopeId,
			tbld.SecScopeId as SecScopeId,
			tbld.VASecId as VASecId,
			tbld.EASecId as EASecId,
			tbld.VAFId as VAFId,
			tbld.EAFId as EAFId,
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
	from cfbam23.tbldef tbld
		inner join cfbam23.scopedef scop on
			tbld.TenantId = scop.TenantId
			and tbld.Id = scop.Id
	where
		tbld.TenantId = argTenantId
			and tbld.Id = argId;
end crt_tbldef;
/

show errors procedure cfbam23.crt_tbldef;
/