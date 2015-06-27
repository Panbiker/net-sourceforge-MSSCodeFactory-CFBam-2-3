--
--	@(#) dbcreate/cfbam/pgsql/crsp_create_idg16.pgsql
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

create or replace function cfbam23.sp_create_idg16(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argScopeId bigint,
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
	argInitValue smallint,
	argDefaultValue smallint,
	argMinValue smallint,
	argMaxValue smallint,
	argNullValue smallint,
	argUnknownValue smallint,
	argSchemaDefId bigint,
	argDispenserTenantId bigint,
	argDispenserId bigint,
	argSlice smallint,
	argBlockSize smallint )
returns setof cfbam23.type_idg16_rec as $$
declare
	permissionFlag boolean;
	argId bigint;
	subret boolean;
	prevClassCode varchar(4);
	prevPrevTenantId bigint;
	prevPrevId bigint;
begin
	if( argClassCode = 'IG16' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'CreateId16Gen',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for CreateId16Gen';
		end if;
	end if;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = argTenantId
		and Id = argSchemaDefId;

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

	select cfbam23.sp_next_valueidgen( argTenantId )
	into argId;

	insert into cfbam23.valdef(
		classcode,
		createdby,
		createdat,
		updatedby,
		updatedat,
		tenantid,
		scopeid,
		id,
		defschtentid,
		defschid,
		name,
		short_name,
		label,
		short_descr,
		descr,
		isnullable,
		generateid,
		datascopeid,
		vasecid,
		easecid,
		vafid,
		eafid,
		prevtenantid,
		previd,
		nexttenantid,
		nextid,
		dflt_vis,
		revision )
	values (
		argClassCode,
		argAuditUserId,
		now(),
		argAuditUserId,
		now(),
		argTenantId,
		argScopeId,
		argId,
		argDefSchemaTenantId,
		argDefSchemaId,
		argName,
		argShortName,
		argLabel,
		argShortDescription,
		argDescription,
		argIsNullable,
		argGenerateId,
		argDataScopeId,
		argViewAccessSecurityId,
		argEditAccessSecurityId,
		argViewAccessFrequencyId,
		argEditAccessFrequencyId,
		prevPrevTenantId,
		prevPrevId,
		null,
		null,
		argDefaultVisibility,
		1 );

	insert into cfbam23.atomdef(
		tenantid,
		id,
		dbname )
	values (
		argTenantId,
		argId,
		argDbName );

	insert into cfbam23.int16def(
		tenantid,
		id,
		initval,
		defval,
		minval,
		maxval,
		nullvalue,
		unknownval )
	values (
		argTenantId,
		argId,
		argInitValue,
		argDefaultValue,
		argMinValue,
		argMaxValue,
		argNullValue,
		argUnknownValue );

	insert into cfbam23.int16typ(
		tenantid,
		id,
		schemadefid )
	values (
		argTenantId,
		argId,
		argSchemaDefId );

	insert into cfbam23.idg16(
		tenantid,
		id,
		dispensertenantid,
		dispenserid,
		slice,
		blocksize )
	values (
		argTenantId,
		argId,
		argDispenserTenantId,
		argDispenserId,
		argSlice,
		argBlockSize );

	if( argClassCode = 'IG16' )
	then insert into cfbam23.idg16_h (
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
			DispenserTenantId,
			DispenserId,
			Slice,
			BlockSize,
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
			i16d.InitVal,
			i16d.DefVal,
			i16d.MinVal,
			i16d.MaxVal,
			i16d.NullValue,
			i16d.UnknownVal,
			i16t.SchemaDefId,
			ig16.DispenserTenantId,
			ig16.DispenserId,
			ig16.Slice,
			ig16.BlockSize,
			valu.revision,
			1
		from cfbam23.idg16 as ig16
		inner join cfbam23.int16typ i16t on
			ig16.tenantid = i16t.tenantid
			and ig16.Id = i16t.id
		inner join cfbam23.int16def i16d on
			i16t.tenantid = i16d.tenantid
			and i16t.Id = i16d.id
		inner join cfbam23.atomdef atom on
			i16d.tenantid = atom.tenantid
			and i16d.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
		where
			ig16.tenantid = argTenantId
			and ig16.id = argId;
	end if;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			NextTenantId = argTenantId,
			NextId = argId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		select cfbam23.sp_audit_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevClassCode,
			prevPrevTenantId,
			prevPrevId,
			2 )
		into subret;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argSchemaDefId;

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
			i16d.initval as initval,
			i16d.defval as defval,
			i16d.minval as minval,
			i16d.maxval as maxval,
			i16d.nullvalue as nullvalue,
			i16d.unknownval as unknownval,
			i16t.schemadefid as schemadefid,
			ig16.dispensertenantid as dispensertenantid,
			ig16.dispenserid as dispenserid,
			ig16.slice as slice,
			ig16.blocksize as blocksize,
			valu.revision as revision
	from cfbam23.idg16 as ig16
		inner join cfbam23.int16typ i16t on
			ig16.tenantid = i16t.tenantid
			and ig16.Id = i16t.id
		inner join cfbam23.int16def i16d on
			i16t.tenantid = i16d.tenantid
			and i16t.Id = i16d.id
		inner join cfbam23.atomdef atom on
			i16d.tenantid = atom.tenantid
			and i16d.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
	where
			ig16.tenantid = argTenantId
			and ig16.id = argId;

	return;
end;
$$ language plpgsql;
