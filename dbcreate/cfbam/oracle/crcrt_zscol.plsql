--
--	@(#) dbcreate/cfbam/oracle/crcrt_zscol.plsql
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

create or replace procedure cfbam23.crt_zscol(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argScopeId numeric,
	argdefschtentid numeric,
	argdefschid numeric,
	argName varchar2,
	argshort_name varchar2,
	argLabel varchar2,
	argshort_descr varchar2,
	argdescr varchar2,
	argIsNullable char,
	argGenerateId char,
	argDataScopeId smallint,
	argVASecId smallint,
	argEASecId smallint,
	argVAFId smallint,
	argEAFId smallint,
	argPrevTenantId numeric,
	argPrevId numeric,
	argNextTenantId numeric,
	argNextId numeric,
	argdflt_vis char,
	argDbName varchar2,
	argInitVal timestamp,
	argDefVal timestamp,
	argMinVal timestamp,
	argMaxVal timestamp,
	argNullValue timestamp,
	argUnknownVal timestamp,
	argTableId numeric )
is
	permissionDenied exception;
	permissionFlag integer;
	argId numeric;
	prevClassCode varchar(4);
	prevPrevTenantId numeric(22,0);
	prevPrevId numeric(22,0);
begin
	if( argClassCode = 'ZSTC' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'CreateTZTimestampCol',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = argTenantId
		and Id = argTableId;

	begin
		select
			valu.TenantId as TenantId,
			valu.Id as Id,
			valu.classcode
		into
			prevPrevTenantId,
			prevPrevId,
			prevClassCode
		from cfbam23.valdef valu
		where
			valu.TenantId = argTenantId
			and valu.ScopeId = argScopeId
			and valu.NextTenantId is null
			and valu.NextId is null;
	exception
		when NO_DATA_FOUND then
			prevClassCode := null;
			prevPrevTenantId := null;
			prevPrevId := null;
	end;

	argId := cfbam23.nxt_valueidgen( argTenantId );
	insert into cfbam23.valdef(
		classcode,
		createdby,
		createdat,
		updatedby,
		updatedat,
		TenantId,
		ScopeId,
		Id,
		defschtentid,
		defschid,
		Name,
		short_name,
		Label,
		short_descr,
		descr,
		IsNullable,
		GenerateId,
		DataScopeId,
		VASecId,
		EASecId,
		VAFId,
		EAFId,
		PrevTenantId,
		PrevId,
		NextTenantId,
		NextId,
		dflt_vis,
		revision )
	values (
		argClassCode,
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argTenantId,
		argScopeId,
		argId,
		argdefschtentid,
		argdefschid,
		argName,
		argshort_name,
		argLabel,
		argshort_descr,
		argdescr,
		argIsNullable,
		argGenerateId,
		argDataScopeId,
		argVASecId,
		argEASecId,
		argVAFId,
		argEAFId,
		prevPrevTenantId,
		prevPrevId,
		null,
		null,
		argdflt_vis,
		1 );
	insert into cfbam23.atomdef(
		TenantId,
		Id,
		DbName )
	values (
		argTenantId,
		argId,
		argDbName );
	insert into cfbam23.zsdef(
		TenantId,
		Id,
		InitVal,
		DefVal,
		MinVal,
		MaxVal,
		NullValue,
		UnknownVal )
	values (
		argTenantId,
		argId,
		argInitVal,
		argDefVal,
		argMinVal,
		argMaxVal,
		argNullValue,
		argUnknownVal );
	insert into cfbam23.zscol(
		TenantId,
		Id,
		TableId )
	values (
		argTenantId,
		argId,
		argTableId );
	if( argClassCode = 'ZSTC' )
	then
		insert into cfbam23.zscol_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			ScopeId,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			IsNullable,
			GenerateId,
			DataScopeId,
			VASecId,
			EASecId,
			VAFId,
			EAFId,
			PrevTenantId,
			PrevId,
			NextTenantId,
			NextId,
			dflt_vis,
			DbName,
			InitVal,
			DefVal,
			MinVal,
			MaxVal,
			NullValue,
			UnknownVal,
			TableId,
			revision,
			auditaction )
		select
			valu.TenantId as TenantId,
			valu.Id as Id,
			valu.classcode,
			argAuditClusterId,
			argAuditSessionId,
			sysdate,
			valu.ScopeId as ScopeId,
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
			zstd.InitVal as InitVal,
			zstd.DefVal as DefVal,
			zstd.MinVal as MinVal,
			zstd.MaxVal as MaxVal,
			zstd.NullValue as NullValue,
			zstd.UnknownVal as UnknownVal,
			zstc.TableId as TableId,
			valu.revision,
			1
		from cfbam23.zscol zstc
		inner join cfbam23.zsdef zstd on
			zstc.TenantId = zstd.TenantId
			and zstc.Id = zstd.Id
		inner join cfbam23.atomdef atom on
			zstd.TenantId = atom.TenantId
			and zstd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
		where
			zstc.TenantId = argTenantId
			and zstc.Id = argId;
	end if;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			NextTenantId = argTenantId,
			NextId = argId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		cfbam23.aud_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevClassCode,
			prevPrevTenantId,
			prevPrevId,
			2 );
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argTableId;

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
			to_char( zstd.InitVal, 'YYYY-MM-DD HH24:MI:SS' ) as InitVal,
			to_char( zstd.DefVal, 'YYYY-MM-DD HH24:MI:SS' ) as DefVal,
			to_char( zstd.MinVal, 'YYYY-MM-DD HH24:MI:SS' ) as MinVal,
			to_char( zstd.MaxVal, 'YYYY-MM-DD HH24:MI:SS' ) as MaxVal,
			to_char( zstd.NullValue, 'YYYY-MM-DD HH24:MI:SS' ) as NullValue,
			to_char( zstd.UnknownVal, 'YYYY-MM-DD HH24:MI:SS' ) as UnknownVal,
			zstc.TableId as TableId,
		valu.revision as revision
	from cfbam23.zscol zstc
		inner join cfbam23.zsdef zstd on
			zstc.TenantId = zstd.TenantId
			and zstc.Id = zstd.Id
		inner join cfbam23.atomdef atom on
			zstd.TenantId = atom.TenantId
			and zstd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
	where
		zstc.TenantId = argTenantId
			and zstc.Id = argId;
end crt_zscol;
/

show errors procedure cfbam23.crt_zscol;
/
