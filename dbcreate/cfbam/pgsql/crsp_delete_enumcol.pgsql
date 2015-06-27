--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_enumcol.pgsql
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

create or replace function cfbam23.sp_delete_enumcol(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	varTenantId bigint;
	varTableId bigint;
	prevClassCode varchar(4);
	nextClassCode varchar(4);
	prevPrevTenantId bigint;
	prevPrevId bigint;
	nextNextTenantId bigint;
	nextNextId bigint;
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
	oldInitValue smallint;
	oldDefaultValue smallint;
	oldMinValue smallint;
	oldMaxValue smallint;
	oldNullValue smallint;
	oldUnknownValue smallint;
	oldTableId bigint;
	permissionFlag boolean;
begin
	select
		TenantId,
		TableId
	into
		varTenantId,
		varTableId
	from cfbam23.enumcol
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varTableId;

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
		from cfbam23.int16def
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id
		into
			oldTenantId,
			oldId
		from cfbam23.enumdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			TableId
		into
			oldTenantId,
			oldId,
			oldTableId
		from cfbam23.enumcol
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if( oldTenantId != secTenantId )
	then
		select cfbam23.sp_is_system_user( argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- Data is not owned by logged in tenant';
		end if;
	end if;

	select cfbam23.sp_is_tenant_user( oldTenantId,
		'DeleteEnumCol',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteEnumCol';
	end if;

	select
		prvvalu.classcode as prvclasscode,
		myself.PrevTenantId as prvPrevTenantId,
		myself.PrevId as prvPrevId,
		nxtvalu.classcode as nxtclasscode,
		myself.NextTenantId as nxtNextTenantId,
		myself.NextId as nxtNextId
	into
		prevClassCode,
		prevPrevTenantId,
		prevPrevId,
		nextClassCode,
		nextNextTenantId,
		nextNextId
	from cfbam23.valdef myself
		left outer join cfbam23.valdef prvvalu on
			prvvalu.TenantId = myself.PrevTenantId
			and prvvalu.Id = myself.PrevId
		left outer join cfbam23.valdef nxtvalu on
			nxtvalu.TenantId = myself.NextTenantId
			and nxtvalu.Id = myself.NextId
	where
		myself.TenantId = argTenantId
		and myself.Id = argId;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			NextTenantId = nextNextTenantId,
			NextId = nextNextId
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

	if( nextNextTenantId is not null )
	then
		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = prevPrevTenantId,
			PrevId = prevPrevId
		where
			TenantId = nextNextTenantId
			and Id = nextNextId;

		select cfbam23.sp_audit_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			nextClassCode,
			nextNextTenantId,
			nextNextId,
			2 )
		into subret;
	end if;

	if( oldClassCode = 'ENMC' )
	then
		insert into cfbam23.enumcol_h (
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
			enmc.TableId,
			argRevision + 1,
			3
		from cfbam23.enumcol as enmc
		inner join cfbam23.enumdef enmd on
			enmc.tenantid = enmd.tenantid
			and enmc.Id = enmd.id
		inner join cfbam23.int16def i16d on
			enmd.tenantid = i16d.tenantid
			and enmd.Id = i16d.id
		inner join cfbam23.atomdef atom on
			i16d.tenantid = atom.tenantid
			and i16d.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
		where
			enmc.tenantid = argTenantId
			and enmc.id = argId;
	end if;

	select cfbam23.sp_delete_enum_tag_by_enumidx( argAuditClusterId,
		argAuditUserId,
		argAuditSessionId,
		secClusterId,
		secTenantId,
		argTenantId,
		argId )
	into subret;


	delete from cfbam23.enumcol
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_enumcol() Expected to affect 1 enumcol, not %', RowsAffected;
	end if;
	delete from cfbam23.enumdef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_enumcol() Expected to affect 1 enumdef, not %', RowsAffected;
	end if;
	delete from cfbam23.int16def
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_enumcol() Expected to affect 1 int16def, not %', RowsAffected;
	end if;
	delete from cfbam23.atomdef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_enumcol() Expected to affect 1 atomdef, not %', RowsAffected;
	end if;
	delete from cfbam23.valdef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_enumcol() Expected to affect 1 valdef, not %', RowsAffected;
	end if;





	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varTableId;

	return true;
end;
$$ language plpgsql;
