--
--	@(#) dbcreate/cfbam/oracle/crrd_tbldefbylookupindexidx.plsql
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

create or replace procedure cfbam23.rd_tbldefbylookupindexidx(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argLookIdxTentId numeric,
	argLookIdxId numeric )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
begin
	permissionFlag := cfbam23.sp_is_tenant_user( secTenantId,
			'ReadTable',
			argAuditUserId );
	isSystemUser := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;
	if( isSystemUser = 1 )
	then
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
			( ( ( argLookIdxTentId is null ) and ( tbld.LookIdxTentId is null ) )
				or ( ( argLookIdxTentId is not null ) and ( tbld.LookIdxTentId = argLookIdxTentId ) ) )
			and ( ( ( argLookIdxId is null ) and ( tbld.LookIdxId is null ) )
				or ( ( argLookIdxId is not null ) and ( tbld.LookIdxId = argLookIdxId ) ) )
			and scop.ClassCode = 'TBLD';
	else
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
			( ( ( argLookIdxTentId is null ) and ( tbld.LookIdxTentId is null ) )
				or ( ( argLookIdxTentId is not null ) and ( tbld.LookIdxTentId = argLookIdxTentId ) ) )
			and ( ( ( argLookIdxId is null ) and ( tbld.LookIdxId is null ) )
				or ( ( argLookIdxId is not null ) and ( tbld.LookIdxId = argLookIdxId ) ) )
			and scop.ClassCode = 'TBLD'
			and scop.TenantId = secTenantId;
	end if;
end rd_tbldefbylookupindexidx;
/

show errors procedure cfbam23.rd_tbldefbylookupindexidx;
/
