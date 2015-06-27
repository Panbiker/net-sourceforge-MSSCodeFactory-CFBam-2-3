--
--	@(#) dbcreate/cfbam/pgsql/crsp_movedown_srvprm.pgsql
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

create or replace function cfbam23.sp_movedown_srvprm(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns setof cfbam23.type_srvprm_rec as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	varTenantId bigint;
	varServerMethodId bigint;
	varprevTenantId bigint;
	varprevId bigint;
	varnextTenantId bigint;
	varnextId bigint;
	gnextTenantId bigint;
	gnextId bigint;
	oldTenantId bigint;
	oldServerMethodId bigint;
	oldId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldIsNullable boolean;
	oldTypeTenantId bigint;
	oldTypeId bigint;
	oldPrevTenantId bigint;
	oldPrevId bigint;
	oldNextTenantId bigint;
	oldNextId bigint;
	oldRevision int;
	permissionFlag boolean;
begin
	select
		TenantId,
		srvmeth_id
	into
		varTenantId,
		varServerMethodId
	from cfbam23.srvprm
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varServerMethodId;

		select
			TenantId,
			srvmeth_id,
			Id,
			defschtentid,
			defschid,
			Name,
			short_descr,
			descr,
			IsNullable,
			TpTentId,
			TpId,
			PrevTenantId,
			PrevId,
			NextTenantId,
			NextId,
			revision
		into
			oldTenantId,
			oldServerMethodId,
			oldId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldName,
			oldShortDescription,
			oldDescription,
			oldIsNullable,
			oldTypeTenantId,
			oldTypeId,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			oldRevision
		from cfbam23.srvprm
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise exception 'sp_movedown_srvprm() Data collision detected';
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
		'UpdateParam',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateParam';
	end if;

	select
		sprm.PrevTenantId as prvPrevTenantId,
		sprm.PrevId as prvPrevId,
		sprm.NextTenantId as nxtNextTenantId,
		sprm.NextId as nxtNextId,
		nxtsprm.NextTenantId as gnxtNextTenantId,
		nxtsprm.NextId as gnxtNextId
	into
		varprevTenantId,
		varprevId,
		varnextTenantId,
		varnextId,
		gnextTenantId,
		gnextId
	from cfbam23.srvprm sprm
		left outer join cfbam23.srvprm prvsprm on
			prvsprm.TenantId = sprm.PrevTenantId
			and prvsprm.Id = sprm.PrevId
		left outer join cfbam23.srvprm nxtsprm on
			nxtsprm.TenantId = sprm.NextTenantId
			and nxtsprm.Id = sprm.NextId
	where
		sprm.TenantId = argTenantId
		and sprm.Id = argId;

	if( varnextTenantId is not null )
	then
		if( varprevTenantId is not null )
		then
			update cfbam23.srvprm
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
				raise exception 'sp_movedown_srvprm() Expected to affect one previous row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_srvprm( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varprevTenantId,
				varprevId,
				2 )
			into subret;
		end if;

		update cfbam23.srvprm
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
			raise exception 'sp_movedown_srvprm() Expected to affect one next row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_srvprm( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varnextTenantId,
			varnextId,
			2 )
		into subret;

		update cfbam23.srvprm
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
			raise exception 'sp_movedown_srvprm() Expected to affect one obj row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_srvprm( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			argTenantId,
			argId,
			2 )
		into subret;

		if( gnextTenantId is not null )
		then
			update cfbam23.srvprm
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
				raise exception 'sp_movedown_srvprm() Expected to affect one grandnext row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_srvprm( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
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
		and Id = varServerMethodId;

	return query select
			sprm.createdby,
			to_char( sprm.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			sprm.updatedby,
			to_char( sprm.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			sprm.tenantid as tenantid,
			sprm.srvmeth_id as srvmeth_id,
			sprm.id as id,
			sprm.defschtentid as defschtentid,
			sprm.defschid as defschid,
			sprm.name as name,
			sprm.short_descr as short_descr,
			sprm.descr as descr,
			sprm.isnullable as isnullable,
			sprm.tptentid as tptentid,
			sprm.tpid as tpid,
			sprm.prevtenantid as prevtenantid,
			sprm.previd as previd,
			sprm.nexttenantid as nexttenantid,
			sprm.nextid as nextid,
			sprm.revision as revision
	from cfbam23.srvprm as sprm
	where
			sprm.tenantid = argTenantId
			and sprm.id = argId;

	return;
end;
$$ language plpgsql;
