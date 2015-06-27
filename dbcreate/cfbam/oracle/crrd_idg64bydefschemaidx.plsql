--
--	@(#) dbcreate/cfbam/oracle/crrd_idg64bydefschemaidx.plsql
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

create or replace procedure cfbam23.rd_idg64bydefschemaidx(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argdefschtentid numeric,
	argdefschid numeric )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
begin
	permissionFlag := cfbam23.sp_is_tenant_user( secTenantId,
			'ReadId64Gen',
			argAuditUserId );
	isSystemUser := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;
	if( isSystemUser = 1 )
	then
		open retCursor for select
			valu.ClassCode,
			valu.createdby,
			to_char( valu.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			valu.updatedby,
			to_char( valu.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			valu.TenantId as TenantId,
			valu.ScopeId as ScopeId,
			valu.Id as Id,
			valu.defschtentid as defschtentid,
			valu.defschid as defschid,
			valu.Name as Name,
			valu.short_name as short_name,
			valu.Label as Label,
			valu.short_descr as short_descr,
			valu.descr as descr,
			valu.IsNullable as IsNullable,
			valu.GenerateId as GenerateId,
			valu.DataScopeId as DataScopeId,
			valu.VASecId as VASecId,
			valu.EASecId as EASecId,
			valu.VAFId as VAFId,
			valu.EAFId as EAFId,
			valu.PrevTenantId as PrevTenantId,
			valu.PrevId as PrevId,
			valu.NextTenantId as NextTenantId,
			valu.NextId as NextId,
			valu.dflt_vis as dflt_vis,
			atom.DbName as DbName,
			i64d.InitVal as InitVal,
			i64d.DefVal as DefVal,
			i64d.MinVal as MinVal,
			i64d.MaxVal as MaxVal,
			i64d.NullValue as NullValue,
			i64d.UnknownVal as UnknownVal,
			i64t.SchemaDefId as SchemaDefId,
			ig64.DispenserTenantId as DispenserTenantId,
			ig64.DispenserId as DispenserId,
			ig64.Slice as Slice,
			ig64.BlockSize as BlockSize,
			valu.revision as revision
		from cfbam23.idg64 ig64
		inner join cfbam23.int64typ i64t on
			ig64.TenantId = i64t.TenantId
			and ig64.Id = i64t.Id
		inner join cfbam23.int64def i64d on
			i64t.TenantId = i64d.TenantId
			and i64t.Id = i64d.Id
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
		where
			( ( ( argdefschtentid is null ) and ( valu.defschtentid is null ) )
				or ( ( argdefschtentid is not null ) and ( valu.defschtentid = argdefschtentid ) ) )
			and ( ( ( argdefschid is null ) and ( valu.defschid is null ) )
				or ( ( argdefschid is not null ) and ( valu.defschid = argdefschid ) ) )
			and valu.ClassCode = 'IG64';
	else
		open retCursor for select
			valu.ClassCode,
			valu.createdby,
			to_char( valu.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			valu.updatedby,
			to_char( valu.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			valu.TenantId as TenantId,
			valu.ScopeId as ScopeId,
			valu.Id as Id,
			valu.defschtentid as defschtentid,
			valu.defschid as defschid,
			valu.Name as Name,
			valu.short_name as short_name,
			valu.Label as Label,
			valu.short_descr as short_descr,
			valu.descr as descr,
			valu.IsNullable as IsNullable,
			valu.GenerateId as GenerateId,
			valu.DataScopeId as DataScopeId,
			valu.VASecId as VASecId,
			valu.EASecId as EASecId,
			valu.VAFId as VAFId,
			valu.EAFId as EAFId,
			valu.PrevTenantId as PrevTenantId,
			valu.PrevId as PrevId,
			valu.NextTenantId as NextTenantId,
			valu.NextId as NextId,
			valu.dflt_vis as dflt_vis,
			atom.DbName as DbName,
			i64d.InitVal as InitVal,
			i64d.DefVal as DefVal,
			i64d.MinVal as MinVal,
			i64d.MaxVal as MaxVal,
			i64d.NullValue as NullValue,
			i64d.UnknownVal as UnknownVal,
			i64t.SchemaDefId as SchemaDefId,
			ig64.DispenserTenantId as DispenserTenantId,
			ig64.DispenserId as DispenserId,
			ig64.Slice as Slice,
			ig64.BlockSize as BlockSize,
			valu.revision as revision
		from cfbam23.idg64 ig64
		inner join cfbam23.int64typ i64t on
			ig64.TenantId = i64t.TenantId
			and ig64.Id = i64t.Id
		inner join cfbam23.int64def i64d on
			i64t.TenantId = i64d.TenantId
			and i64t.Id = i64d.Id
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
		where
			( ( ( argdefschtentid is null ) and ( valu.defschtentid is null ) )
				or ( ( argdefschtentid is not null ) and ( valu.defschtentid = argdefschtentid ) ) )
			and ( ( ( argdefschid is null ) and ( valu.defschid is null ) )
				or ( ( argdefschid is not null ) and ( valu.defschid = argdefschid ) ) )
			and valu.ClassCode = 'IG64'
			and valu.TenantId = secTenantId;
	end if;
end rd_idg64bydefschemaidx;
/

show errors procedure cfbam23.rd_idg64bydefschemaidx;
/
