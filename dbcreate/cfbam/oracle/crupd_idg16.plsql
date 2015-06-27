--
--	@(#) dbcreate/cfbam/oracle/crupd_idg16.plsql
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


create or replace procedure cfbam23.upd_idg16(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argScopeId numeric,
	argId numeric,
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
	argInitVal smallint,
	argDefVal smallint,
	argMinVal smallint,
	argMaxVal smallint,
	argNullValue smallint,
	argUnknownVal smallint,
	argSchemaDefId numeric,
	argDispenserTenantId numeric,
	argDispenserId numeric,
	argSlice smallint,
	argBlockSize smallint,
	argRevision integer )
is
	oldClassCode varchar2(4);
	oldTenantId numeric(22,0);
	oldScopeId numeric(22,0);
	oldId numeric(22,0);
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldName varchar2(192);
	oldshort_name varchar2(16);
	oldLabel varchar2(64);
	oldshort_descr varchar2(128);
	olddescr varchar2(1023);
	oldIsNullable char(1);
	oldGenerateId char(1);
	oldDataScopeId smallint;
	oldVASecId smallint;
	oldEASecId smallint;
	oldVAFId smallint;
	oldEAFId smallint;
	oldPrevTenantId numeric(22,0);
	oldPrevId numeric(22,0);
	oldNextTenantId numeric(22,0);
	oldNextId numeric(22,0);
	olddflt_vis char(1);
	oldRevision integer;
	oldDbName varchar2(32);
	oldInitVal smallint;
	oldDefVal smallint;
	oldMinVal smallint;
	oldMaxVal smallint;
	oldNullValue smallint;
	oldUnknownVal smallint;
	oldSchemaDefId numeric(22,0);
	oldDispenserTenantId numeric(22,0);
	oldDispenserId numeric(22,0);
	oldSlice smallint;
	oldBlockSize smallint;
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'IG16' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateId16Gen',
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
		and Id = argSchemaDefId;

		select
			ClassCode,
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
			revision
		into
			oldClassCode,
			oldTenantId,
			oldScopeId,
			oldId,
			olddefschtentid,
			olddefschid,
			oldName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldIsNullable,
			oldGenerateId,
			oldDataScopeId,
			oldVASecId,
			oldEASecId,
			oldVAFId,
			oldEAFId,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			olddflt_vis,
			oldRevision
		from cfbam23.valdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			DbName
		into
			oldTenantId,
			oldId,
			oldDbName
		from cfbam23.atomdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			InitVal,
			DefVal,
			MinVal,
			MaxVal,
			NullValue,
			UnknownVal
		into
			oldTenantId,
			oldId,
			oldInitVal,
			oldDefVal,
			oldMinVal,
			oldMaxVal,
			oldNullValue,
			oldUnknownVal
		from cfbam23.int16def
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			SchemaDefId
		into
			oldTenantId,
			oldId,
			oldSchemaDefId
		from cfbam23.int16typ
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			DispenserTenantId,
			DispenserId,
			Slice,
			BlockSize
		into
			oldTenantId,
			oldId,
			oldDispenserTenantId,
			oldDispenserId,
			oldSlice,
			oldBlockSize
		from cfbam23.idg16
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;

	update cfbam23.valdef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = sysdate,
		ScopeId = argScopeId,
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		Name = argName,
		short_name = argshort_name,
		Label = argLabel,
		short_descr = argshort_descr,
		descr = argdescr,
		IsNullable = argIsNullable,
		GenerateId = argGenerateId,
		DataScopeId = argDataScopeId,
		VASecId = argVASecId,
		EASecId = argEASecId,
		VAFId = argVAFId,
		EAFId = argEAFId,
		PrevTenantId = argPrevTenantId,
		PrevId = argPrevId,
		NextTenantId = argNextTenantId,
		NextId = argNextId,
		dflt_vis = argdflt_vis
	where
		TenantId = argTenantId
		and Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.atomdef
	set
		DbName = argDbName
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.int16def
	set
		InitVal = argInitVal,
		DefVal = argDefVal,
		MinVal = argMinVal,
		MaxVal = argMaxVal,
		NullValue = argNullValue,
		UnknownVal = argUnknownVal
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.int16typ
	set
		SchemaDefId = argSchemaDefId
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.idg16
	set
		DispenserTenantId = argDispenserTenantId,
		DispenserId = argDispenserId,
		Slice = argSlice,
		BlockSize = argBlockSize
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argSchemaDefId;

	if( argClassCode = 'IG16' )
	then
		insert into cfbam23.idg16_h (
			TenantId,
			Id,
			classcode,
			revision,
			auditclusterid,
			auditsessionid,
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
			SchemaDefId,
			DispenserTenantId,
			DispenserId,
			Slice,
			BlockSize,
			auditaction,
			auditstamp )
		select
			valu.TenantId as TenantId,
			valu.Id as Id,
			valu.classcode,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
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
			i16d.InitVal as InitVal,
			i16d.DefVal as DefVal,
			i16d.MinVal as MinVal,
			i16d.MaxVal as MaxVal,
			i16d.NullValue as NullValue,
			i16d.UnknownVal as UnknownVal,
			i16t.SchemaDefId as SchemaDefId,
			ig16.DispenserTenantId as DispenserTenantId,
			ig16.DispenserId as DispenserId,
			ig16.Slice as Slice,
			ig16.BlockSize as BlockSize,
			2,
			sysdate
		from cfbam23.idg16 ig16
		inner join cfbam23.int16typ i16t on
			ig16.TenantId = i16t.TenantId
			and ig16.Id = i16t.Id
		inner join cfbam23.int16def i16d on
			i16t.TenantId = i16d.TenantId
			and i16t.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
		where
			ig16.TenantId = argTenantId
			and ig16.Id = argId;
	end if;

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
			i16d.InitVal as InitVal,
			i16d.DefVal as DefVal,
			i16d.MinVal as MinVal,
			i16d.MaxVal as MaxVal,
			i16d.NullValue as NullValue,
			i16d.UnknownVal as UnknownVal,
			i16t.SchemaDefId as SchemaDefId,
			ig16.DispenserTenantId as DispenserTenantId,
			ig16.DispenserId as DispenserId,
			ig16.Slice as Slice,
			ig16.BlockSize as BlockSize,
		valu.revision as revision
	from cfbam23.idg16 ig16
		inner join cfbam23.int16typ i16t on
			ig16.TenantId = i16t.TenantId
			and ig16.Id = i16t.Id
		inner join cfbam23.int16def i16d on
			i16t.TenantId = i16d.TenantId
			and i16t.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
	where
		ig16.TenantId = argTenantId
			and ig16.Id = argId;
end upd_idg16;

/

show errors procedure cfbam23.upd_idg16;
/
