--
--	@(#) dbcreate/cfbam/pgsql/crsp_update_int64typ.pgsql
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


create or replace function cfbam23.sp_update_int64typ(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argScopeId bigint,
	argId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint,
	argName varchar(192),
	argShortName varchar(16),
	argLabel varchar(64),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argIsNullable boolean,
	argGenerateId boolean,
	argDataScopeId smallint,
	argViewAccessSecurityId smallint,
	argEditAccessSecurityId smallint,
	argViewAccessFrequencyId smallint,
	argEditAccessFrequencyId smallint,
	argPrevTenantId bigint,
	argPrevId bigint,
	argNextTenantId bigint,
	argNextId bigint,
	argDefaultVisibility boolean,
	argDbName varchar(32),
	argInitValue bigint,
	argDefaultValue bigint,
	argMinValue bigint,
	argMaxValue bigint,
	argNullValue bigint,
	argUnknownValue bigint,
	argSchemaDefId bigint,
	argRevision integer )
returns setof cfbam23.type_int64typ_rec as $$
declare
	RowsAffected integer;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldScopeId bigint;
	oldId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldIsNullable boolean;
	oldGenerateId boolean;
	oldDataScopeId smallint;
	oldViewAccessSecurityId smallint;
	oldEditAccessSecurityId smallint;
	oldViewAccessFrequencyId smallint;
	oldEditAccessFrequencyId smallint;
	oldPrevTenantId bigint;
	oldPrevId bigint;
	oldNextTenantId bigint;
	oldNextId bigint;
	oldDefaultVisibility boolean;
	oldRevision int;
	oldDbName varchar(32);
	oldInitValue bigint;
	oldDefaultValue bigint;
	oldMinValue bigint;
	oldMaxValue bigint;
	oldNullValue bigint;
	oldUnknownValue bigint;
	oldSchemaDefId bigint;
	permissionFlag boolean;
begin
	if( argClassCode = 'I64T' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateInt64Type',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateInt64Type';
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
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldIsNullable,
			oldGenerateId,
			oldDataScopeId,
			oldViewAccessSecurityId,
			oldEditAccessSecurityId,
			oldViewAccessFrequencyId,
			oldEditAccessFrequencyId,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			oldDefaultVisibility,
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
			oldInitValue,
			oldDefaultValue,
			oldMinValue,
			oldMaxValue,
			oldNullValue,
			oldUnknownValue
		from cfbam23.int64def
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
		from cfbam23.int64typ
		where
			TenantId = argTenantId
			and Id = argId
		for update;


	if argRevision != oldRevision
	then
		raise exception 'sp_update_int64typ() Data collision detected';
	end if;


	update cfbam23.valdef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = now(),
		scopeid = argScopeId,
		defschtentid = argDefSchemaTenantId,
		defschid = argDefSchemaId,
		name = argName,
		short_name = argShortName,
		label = argLabel,
		short_descr = argShortDescription,
		descr = argDescription,
		isnullable = argIsNullable,
		generateid = argGenerateId,
		datascopeid = argDataScopeId,
		vasecid = argViewAccessSecurityId,
		easecid = argEditAccessSecurityId,
		vafid = argViewAccessFrequencyId,
		eafid = argEditAccessFrequencyId,
		prevtenantid = argPrevTenantId,
		previd = argPrevId,
		nexttenantid = argNextTenantId,
		nextid = argNextId,
		dflt_vis = argDefaultVisibility
	where
		TenantId = argTenantId
			and Id = argId
		and revision = oldRevision;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_int64typ() Expected to affect one valdef row, not %', RowsAffected;
	end if;

	update cfbam23.atomdef
	set
		dbname = argDbName
	where
		TenantId = argTenantId
			and Id = argId;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_int64typ() Expected to affect one atomdef row, not %', RowsAffected;
	end if;

	update cfbam23.int64def
	set
		initval = argInitValue,
		defval = argDefaultValue,
		minval = argMinValue,
		maxval = argMaxValue,
		nullvalue = argNullValue,
		unknownval = argUnknownValue
	where
		TenantId = argTenantId
			and Id = argId;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_int64typ() Expected to affect one int64def row, not %', RowsAffected;
	end if;

	update cfbam23.int64typ
	set
		schemadefid = argSchemaDefId
	where
		TenantId = argTenantId
			and Id = argId;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_int64typ() Expected to affect one int64typ row, not %', RowsAffected;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argSchemaDefId;


	if( argClassCode = 'I64T' )
	then
		insert into cfbam23.int64typ_h (
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
			SchemaDefId,
			revision,
			auditaction )
		select
			valu.TenantId,
			valu.Id,
			valu.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			valu.ScopeId,
			valu.defschtentid,
			valu.defschid,
			valu.Name,
			valu.short_name,
			valu.Label,
			valu.short_descr,
			valu.descr,
			valu.IsNullable,
			valu.GenerateId,
			valu.DataScopeId,
			valu.VASecId,
			valu.EASecId,
			valu.VAFId,
			valu.EAFId,
			valu.PrevTenantId,
			valu.PrevId,
			valu.NextTenantId,
			valu.NextId,
			valu.dflt_vis,
			atom.DbName,
			i64d.InitVal,
			i64d.DefVal,
			i64d.MinVal,
			i64d.MaxVal,
			i64d.NullValue,
			i64d.UnknownVal,
			i64t.SchemaDefId,
			argRevision + 1,
			2
		from cfbam23.int64typ as i64t
		inner join cfbam23.int64def i64d on
			i64t.tenantid = i64d.tenantid
			and i64t.Id = i64d.id
		inner join cfbam23.atomdef atom on
			i64d.tenantid = atom.tenantid
			and i64d.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
		where
			i64t.tenantid = argTenantId
			and i64t.id = argId;
	end if;

	return query select
			valu.ClassCode,
			valu.createdby,
			to_char( valu.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			valu.updatedby,
			to_char( valu.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			valu.tenantid as tenantid,
			valu.scopeid as scopeid,
			valu.id as id,
			valu.defschtentid as defschtentid,
			valu.defschid as defschid,
			valu.name as name,
			valu.short_name as short_name,
			valu.label as label,
			valu.short_descr as short_descr,
			valu.descr as descr,
			valu.isnullable as isnullable,
			valu.generateid as generateid,
			valu.datascopeid as datascopeid,
			valu.vasecid as vasecid,
			valu.easecid as easecid,
			valu.vafid as vafid,
			valu.eafid as eafid,
			valu.prevtenantid as prevtenantid,
			valu.previd as previd,
			valu.nexttenantid as nexttenantid,
			valu.nextid as nextid,
			valu.dflt_vis as dflt_vis,
			atom.dbname as dbname,
			i64d.initval as initval,
			i64d.defval as defval,
			i64d.minval as minval,
			i64d.maxval as maxval,
			i64d.nullvalue as nullvalue,
			i64d.unknownval as unknownval,
			i64t.schemadefid as schemadefid,
		valu.revision as revision
	from cfbam23.int64typ as i64t
		inner join cfbam23.int64def i64d on
			i64t.tenantid = i64d.tenantid
			and i64t.Id = i64d.id
		inner join cfbam23.atomdef atom on
			i64d.tenantid = atom.tenantid
			and i64d.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
	where
		i64t.tenantid = argTenantId
			and i64t.id = argId;

	return;
end;
$$ language plpgsql;
