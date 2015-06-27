--
--	@(#) dbcreate/cfbam/oracle/crupd_tbldef.plsql
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


create or replace procedure cfbam23.upd_tbldef(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argId numeric,
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
	argdflt_vis char,
	argRevision integer )
is
	oldClassCode varchar2(4);
	oldTenantId numeric(22,0);
	oldId numeric(22,0);
	oldRevision integer;
	oldSchemaDefId numeric(22,0);
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldName varchar2(192);
	oldDbName varchar2(32);
	oldshort_name varchar2(16);
	oldLabel varchar2(64);
	oldshort_descr varchar2(50);
	olddescr varchar2(100);
	oldPrimIdxTentId numeric(22,0);
	oldPrimIdxId numeric(22,0);
	oldTblClsCd varchar2(4);
	oldLookIdxTentId numeric(22,0);
	oldLookIdxId numeric(22,0);
	oldAltIdxTentId numeric(22,0);
	oldAltIdxId numeric(22,0);
	oldQualTentId numeric(22,0);
	oldQualTblId numeric(22,0);
	oldPolyBase char(1);
	oldIsInstantiable char(1);
	oldHasHistory char(1);
	oldHasAuditColumns char(1);
	oldLoadBehavId smallint;
	oldDataScopeId smallint;
	oldSecScopeId smallint;
	oldVASecId smallint;
	oldEASecId smallint;
	oldVAFId smallint;
	oldEAFId smallint;
	oldjobj_memb clob;
	oldjobj_xface clob;
	oldjtbl_objimp clob;
	oldjobj_impl clob;
	oldjedt_memb clob;
	oldjedt_xface clob;
	oldjtbl_eobjimp clob;
	oldjedt_impl clob;
	oldjtbl_imp clob;
	oldjtbl_memb clob;
	oldjtbl_xface clob;
	oldjtbl_impl clob;
	oldjtbl_objimp clob;
	oldjtbl_objmemb clob;
	oldjtbl_objxface clob;
	oldjtbl_objimpl clob;
	oldjtbl_db2imp clob;
	oldjdb2_memb clob;
	oldjdb2_impl clob;
	oldjtbl_msimp clob;
	oldjmssql_memb clob;
	oldjmssql_impl clob;
	oldjtbl_myimp clob;
	oldjmysql_memb clob;
	oldjmysql_impl clob;
	oldjtbl_oraimp clob;
	oldjoracle_memb clob;
	oldjoracle_impl clob;
	oldjtbl_pgimp clob;
	oldjpgsql_memb clob;
	oldjpgsql_impl clob;
	oldjtbl_sybaseimp clob;
	oldjsybase_memb clob;
	oldjsybase_impl clob;
	oldjtbl_ramimp clob;
	oldjram_memb clob;
	oldjram_impl clob;
	oldjtbl_saxldimp clob;
	oldjsaxstart_memb clob;
	oldjsaxend_impl clob;
	oldjxmtbl_imp clob;
	oldjxmtbl_fmt clob;
	oldjxmtbl_rqstimp clob;
	oldjxmtbl_rspnimp clob;
	oldjxmtbl_clntimp clob;
	oldjxmtbl_rqstbdy clob;
	oldjxmtbl_rspnbdy clob;
	oldjxmtbl_clntbdy clob;
	olddflt_vis char(1);
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'TBLD' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateTable',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
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
			dflt_vis
		into
			oldTenantId,
			oldSchemaDefId,
			olddefschtentid,
			olddefschid,
			oldId,
			oldName,
			oldDbName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldPrimIdxTentId,
			oldPrimIdxId,
			oldTblClsCd,
			oldLookIdxTentId,
			oldLookIdxId,
			oldAltIdxTentId,
			oldAltIdxId,
			oldQualTentId,
			oldQualTblId,
			oldPolyBase,
			oldIsInstantiable,
			oldHasHistory,
			oldHasAuditColumns,
			oldLoadBehavId,
			oldDataScopeId,
			oldSecScopeId,
			oldVASecId,
			oldEASecId,
			oldVAFId,
			oldEAFId,
			oldjobj_memb,
			oldjobj_xface,
			oldjtbl_objimp,
			oldjobj_impl,
			oldjedt_memb,
			oldjedt_xface,
			oldjtbl_eobjimp,
			oldjedt_impl,
			oldjtbl_imp,
			oldjtbl_memb,
			oldjtbl_xface,
			oldjtbl_impl,
			oldjtbl_objimp,
			oldjtbl_objmemb,
			oldjtbl_objxface,
			oldjtbl_objimpl,
			oldjtbl_db2imp,
			oldjdb2_memb,
			oldjdb2_impl,
			oldjtbl_msimp,
			oldjmssql_memb,
			oldjmssql_impl,
			oldjtbl_myimp,
			oldjmysql_memb,
			oldjmysql_impl,
			oldjtbl_oraimp,
			oldjoracle_memb,
			oldjoracle_impl,
			oldjtbl_pgimp,
			oldjpgsql_memb,
			oldjpgsql_impl,
			oldjtbl_sybaseimp,
			oldjsybase_memb,
			oldjsybase_impl,
			oldjtbl_ramimp,
			oldjram_memb,
			oldjram_impl,
			oldjtbl_saxldimp,
			oldjsaxstart_memb,
			oldjsaxend_impl,
			oldjxmtbl_imp,
			oldjxmtbl_fmt,
			oldjxmtbl_rqstimp,
			oldjxmtbl_rspnimp,
			oldjxmtbl_clntimp,
			oldjxmtbl_rqstbdy,
			oldjxmtbl_rspnbdy,
			oldjxmtbl_clntbdy,
			olddflt_vis
		from cfbam23.tbldef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;

	update cfbam23.scopedef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = sysdate
	where
		TenantId = argTenantId
		and Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.tbldef
	set
		SchemaDefId = argSchemaDefId,
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		Name = argName,
		DbName = argDbName,
		short_name = argshort_name,
		Label = argLabel,
		short_descr = argshort_descr,
		descr = argdescr,
		PrimIdxTentId = argPrimIdxTentId,
		PrimIdxId = argPrimIdxId,
		TblClsCd = argTblClsCd,
		LookIdxTentId = argLookIdxTentId,
		LookIdxId = argLookIdxId,
		AltIdxTentId = argAltIdxTentId,
		AltIdxId = argAltIdxId,
		QualTentId = argQualTentId,
		QualTblId = argQualTblId,
		PolyBase = argPolyBase,
		IsInstantiable = argIsInstantiable,
		HasHistory = argHasHistory,
		HasAuditColumns = argHasAuditColumns,
		LoadBehavId = argLoadBehavId,
		DataScopeId = argDataScopeId,
		SecScopeId = argSecScopeId,
		VASecId = argVASecId,
		EASecId = argEASecId,
		VAFId = argVAFId,
		EAFId = argEAFId,
		jobj_memb = argjobj_memb,
		jobj_xface = argjobj_xface,
		jtbl_objimp = argjtbl_objimp,
		jobj_impl = argjobj_impl,
		jedt_memb = argjedt_memb,
		jedt_xface = argjedt_xface,
		jtbl_eobjimp = argjtbl_eobjimp,
		jedt_impl = argjedt_impl,
		jtbl_imp = argjtbl_imp,
		jtbl_memb = argjtbl_memb,
		jtbl_xface = argjtbl_xface,
		jtbl_impl = argjtbl_impl,
		jtbl_objimp = argjtbl_objimp,
		jtbl_objmemb = argjtbl_objmemb,
		jtbl_objxface = argjtbl_objxface,
		jtbl_objimpl = argjtbl_objimpl,
		jtbl_db2imp = argjtbl_db2imp,
		jdb2_memb = argjdb2_memb,
		jdb2_impl = argjdb2_impl,
		jtbl_msimp = argjtbl_msimp,
		jmssql_memb = argjmssql_memb,
		jmssql_impl = argjmssql_impl,
		jtbl_myimp = argjtbl_myimp,
		jmysql_memb = argjmysql_memb,
		jmysql_impl = argjmysql_impl,
		jtbl_oraimp = argjtbl_oraimp,
		joracle_memb = argjoracle_memb,
		joracle_impl = argjoracle_impl,
		jtbl_pgimp = argjtbl_pgimp,
		jpgsql_memb = argjpgsql_memb,
		jpgsql_impl = argjpgsql_impl,
		jtbl_sybaseimp = argjtbl_sybaseimp,
		jsybase_memb = argjsybase_memb,
		jsybase_impl = argjsybase_impl,
		jtbl_ramimp = argjtbl_ramimp,
		jram_memb = argjram_memb,
		jram_impl = argjram_impl,
		jtbl_saxldimp = argjtbl_saxldimp,
		jsaxstart_memb = argjsaxstart_memb,
		jsaxend_impl = argjsaxend_impl,
		jxmtbl_imp = argjxmtbl_imp,
		jxmtbl_fmt = argjxmtbl_fmt,
		jxmtbl_rqstimp = argjxmtbl_rqstimp,
		jxmtbl_rspnimp = argjxmtbl_rspnimp,
		jxmtbl_clntimp = argjxmtbl_clntimp,
		jxmtbl_rqstbdy = argjxmtbl_rqstbdy,
		jxmtbl_rspnbdy = argjxmtbl_rspnbdy,
		jxmtbl_clntbdy = argjxmtbl_clntbdy,
		dflt_vis = argdflt_vis
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	if( argClassCode = 'TBLD' )
	then
		insert into cfbam23.tbldef_h (
			TenantId,
			Id,
			classcode,
			revision,
			auditclusterid,
			auditsessionid,
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
			auditaction,
			auditstamp )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
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
			2,
			sysdate
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
end upd_tbldef;

/

show errors procedure cfbam23.upd_tbldef;
/
