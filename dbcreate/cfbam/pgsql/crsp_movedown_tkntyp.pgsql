--
--	@(#) dbcreate/cfbam/pgsql/crsp_movedown_tkntyp.pgsql
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

create or replace function cfbam23.sp_movedown_tkntyp(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns setof cfbam23.type_tkntyp_rec as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	varTenantId bigint;
	varScopeId bigint;
	varClassCode varchar(4);
	varprevClassCode varchar(4);
	varnextClassCode varchar(4);
	gnextClassCode varchar(4);
	varprevTenantId bigint;
	varprevId bigint;
	varnextTenantId bigint;
	varnextId bigint;
	gnextTenantId bigint;
	gnextId bigint;
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
	oldMaxLen integer;
	oldInitValue varchar(64);
	oldDefaultValue varchar(64);
	oldNullValue varchar(64);
	oldUnknownValue varchar(64);
	oldShowLines smallint;
	oldSchemaDefId bigint;
	permissionFlag boolean;
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
			oldInitValue,
			oldDefaultValue,
			oldNullValue,
			oldUnknownValue,
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
		raise exception 'sp_movedown_tkntyp() Data collision detected';
	end if;

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
		'UpdateTokenType',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateTokenType';
	end if;

	select
		valu.classcode as thisclasscode,
		prvvalu.classcode as prvclasscode,
		valu.PrevTenantId as prvPrevTenantId,
		valu.PrevId as prvPrevId,
		nxtvalu.classcode as nxtclasscode,
		valu.NextTenantId as nxtNextTenantId,
		valu.NextId as nxtNextId,
		gnxtvalu.classcode as gnxtclasscode,
		nxtvalu.NextTenantId as gnxtNextTenantId,
		nxtvalu.NextId as gnxtNextId
	into
		varClassCode,
		varprevClassCode,
		varprevTenantId,
		varprevId,
		varnextClassCode,
		varnextTenantId,
		varnextId,
		gnextClassCode,
		gnextTenantId,
		gnextId
	from cfbam23.valdef valu
		left outer join cfbam23.valdef prvvalu on
			prvvalu.TenantId = valu.PrevTenantId
			and prvvalu.Id = valu.PrevId
		left outer join cfbam23.valdef nxtvalu on
			nxtvalu.TenantId = valu.NextTenantId
			and nxtvalu.Id = valu.NextId
		left outer join cfbam23.valdef gnxtvalu on
			gnxtvalu.TenantId = nxtvalu.NextTenantId
			and gnxtvalu.Id = nxtvalu.NextId
	where
		valu.TenantId = argTenantId
		and valu.Id = argId;

	if( varnextTenantId is not null )
	then
		if( varprevTenantId is not null )
		then
			update cfbam23.valdef
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = now(),
				NextTenantId = varnextTenantId,
				NextId = varnextId
			where
				TenantId = varprevTenantId
				and Id = varprevId;

			get diagnostics RowsAffected = row_count;

			if RowsAffected != 1
			then
				raise exception 'sp_movedown_valdef() Expected to affect one previous row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_valdef( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varprevClassCode,
				varprevTenantId,
				varprevId,
				2 )
			into subret;
		end if;

		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = varprevTenantId,
			PrevId = varprevId,
			NextTenantId = argTenantId,
			NextId = argId
		where
			TenantId = varnextTenantId
			and Id = varnextId;

		get diagnostics RowsAffected = row_count;

		if RowsAffected != 1
		then
			raise exception 'sp_movedown_valdef() Expected to affect one next row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varnextClassCode,
			varnextTenantId,
			varnextId,
			2 )
		into subret;

		update cfbam23.valdef
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = varnextTenantId,
			PrevId = varnextId,
			NextTenantId = gnextTenantId,
			NextId = gnextId
		where
			TenantId = argTenantId
			and Id = argId;

		get diagnostics RowsAffected = row_count;

		if RowsAffected != 1
		then
			raise exception 'sp_movedown_valdef() Expected to affect one obj row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_valdef( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varClassCode,
			argTenantId,
			argId,
			2 )
		into subret;

		if( gnextTenantId is not null )
		then
			update cfbam23.valdef
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = now(),
				PrevTenantId = argTenantId,
				PrevId = argId
			where
				TenantId = gnextTenantId
				and Id = gnextId;

			get diagnostics RowsAffected = row_count;

			if RowsAffected != 1
			then
				raise exception 'sp_movedown_valdef() Expected to affect one grandnext row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_valdef( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gnextClassCode,
				gnextTenantId,
				gnextId,
				2 )
			into subret;
		end if;

	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varScopeId;

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
			tknd.maxlen as maxlen,
			tknd.initval as initval,
			tknd.defval as defval,
			tknd.nullvalue as nullvalue,
			tknd.unknownval as unknownval,
			tknd.showlines as showlines,
			tknt.schemadefid as schemadefid,
			valu.revision as revision
	from cfbam23.tkntyp as tknt
		inner join cfbam23.tkndef tknd on
			tknt.tenantid = tknd.tenantid
			and tknt.Id = tknd.id
		inner join cfbam23.atomdef atom on
			tknd.tenantid = atom.tenantid
			and tknd.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
	where
			tknt.tenantid = argTenantId
			and tknt.id = argId;

	return;
end;
$$ language plpgsql;
