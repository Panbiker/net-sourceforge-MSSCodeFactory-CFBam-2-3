--
--	@(#) dbcreate/cfbam/oracle/crmvup_tkntyp.plsql
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

create or replace procedure cfbam23.mvup_tkntyp(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argId numeric,
	argRevision integer )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
	expectedToAffectOneRow exception;
	dataCollisionDetected exception;
	varTenantId numeric(22,0);
	varScopeId numeric(22,0);
	varClassCode varchar(4);
	gprevClassCode varchar(4);
	varprevClassCode varchar(4);
	varnextClassCode varchar(4);
	gprevTenantId numeric(22,0);
	gprevId numeric(22,0);
	varprevTenantId numeric(22,0);
	varprevId numeric(22,0);
	varnextTenantId numeric(22,0);
	varnextId numeric(22,0);
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
	oldMaxLen integer;
	oldInitVal varchar2(64);
	oldDefVal varchar2(64);
	oldNullValue varchar2(64);
	oldUnknownVal varchar2(64);
	oldShowLines smallint;
	oldSchemaDefId numeric(22,0);
begin
	select
		TenantId,
		ScopeId
	into
		varTenantId,
		varScopeId
	from cfbam23.valdef
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varScopeId;

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
			MaxLen,
			InitVal,
			DefVal,
			NullValue,
			UnknownVal,
			ShowLines
		into
			oldTenantId,
			oldId,
			oldMaxLen,
			oldInitVal,
			oldDefVal,
			oldNullValue,
			oldUnknownVal,
			oldShowLines
		from cfbam23.tkndef
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
		from cfbam23.tkntyp
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollisionDetected;
	end if;

	if( oldTenantId != secTenantId )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	permissionFlag := cfbam23.sp_is_tenant_user( oldTenantId,
		'UpdateTokenType',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	select
		valu.classcode as thisclasscode,
		gprvvalu.classcode as gprvclasscode,
		prvvalu.PrevTenantId as gprvPrevTenantId,
		prvvalu.PrevId as gprvPrevId,
		prvvalu.classcode as prvclasscode,
		valu.PrevTenantId as prvPrevTenantId,
		valu.PrevId as prvPrevId,
		nxtvalu.classcode as nxtclasscode,
		valu.NextTenantId as nxtNextTenantId,
		valu.NextId as nxtNextId
	into
		varClassCode,
		gprevClassCode,
		gprevTenantId,
		gprevId,
		varprevClassCode,
		varprevTenantId,
		varprevId,
		varnextClassCode,
		varnextTenantId,
		varnextId
	from cfbam23.valdef valu
		left outer join cfbam23.valdef prvvalu on
			prvvalu.TenantId = valu.PrevTenantId
			and prvvalu.Id = valu.PrevId
		left outer join cfbam23.valdef nxtvalu on
			nxtvalu.TenantId = valu.NextTenantId
			and nxtvalu.Id = valu.NextId
		left outer join cfbam23.valdef gprvvalu on
			gprvvalu.TenantId = prvvalu.PrevTenantId
			and gprvvalu.Id = prvvalu.PrevId
	where
		valu.TenantId = argTenantId
		and valu.Id = argId;

	if( varprevTenantId is not null )
	then
		if( gprevTenantId is not null )
		then
			update cfbam23.valdef
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = sysdate,
				NextTenantId = argTenantId,
				NextId = argId
			where
				TenantId = gprevTenantId
				and Id = gprevId;

			if sql%rowcount != 1 then
				raise expectedToAffectOneRow;
			end if;

			cfbam23.aud_valdef( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gprevClassCode,
				gprevTenantId,
				gprevId,
				2 );
		end if;

		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			PrevTenantId = gprevTenantId,
			PrevId = gprevId,
			NextTenantId = varprevTenantId,
			NextId = varprevId
		where
			TenantId = argTenantId
			and Id = argId;

		if sql%rowcount != 1 then
			raise expectedToAffectOneRow;
		end if;

		cfbam23.aud_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varClassCode,
			argTenantId,
			argId,
			2 );

		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			PrevTenantId = argTenantId,
			PrevId = argId,
			NextTenantId = varnextTenantId,
			NextId = varnextId
		where
			TenantId = varprevTenantId
			and Id = varprevId;

		if sql%rowcount != 1 then
			raise expectedToAffectOneRow;
		end if;

		cfbam23.aud_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varprevClassCode,
			varprevTenantId,
			varprevId,
			2 );

		if( varnextTenantId is not null )
		then
			update cfbam23.valdef
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = sysdate,
				PrevTenantId = varprevTenantId,
				PrevId = varprevId
			where
				TenantId = varnextTenantId
				and Id = varnextId;

			if sql%rowcount != 1 then
				raise expectedToAffectOneRow;
			end if;

			cfbam23.aud_valdef( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varnextClassCode,
				varnextTenantId,
				varnextId,
				2 );
		end if;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varScopeId;

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
			tknd.MaxLen as MaxLen,
			tknd.InitVal as InitVal,
			tknd.DefVal as DefVal,
			tknd.NullValue as NullValue,
			tknd.UnknownVal as UnknownVal,
			tknd.ShowLines as ShowLines,
			tknt.SchemaDefId as SchemaDefId,
		valu.revision as revision
	from cfbam23.tkntyp tknt
		inner join cfbam23.tkndef tknd on
			tknt.TenantId = tknd.TenantId
			and tknt.Id = tknd.Id
		inner join cfbam23.atomdef atom on
			tknd.TenantId = atom.TenantId
			and tknd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
	where
		tknt.TenantId = argTenantId
			and tknt.Id = argId;
end mvup_tkntyp;
/

show errors procedure cfbam23.mvup_tkntyp;
/
