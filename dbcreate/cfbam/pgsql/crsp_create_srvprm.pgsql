--
--	@(#) dbcreate/cfbam/pgsql/crsp_create_srvprm.pgsql
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

create or replace function cfbam23.sp_create_srvprm(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argServerMethodId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint,
	argName varchar(192),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argIsNullable boolean,
	argTypeTenantId bigint,
	argTypeId bigint,
	argPrevTenantId bigint,
	argPrevId bigint,
	argNextTenantId bigint,
	argNextId bigint )
returns setof cfbam23.type_srvprm_rec as $$
declare
	permissionFlag boolean;
	argId bigint;
	subret boolean;
	prevPrevTenantId bigint;
	prevPrevId bigint;
begin
	if( argClassCode = 'SPRM' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'CreateParam',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for CreateParam';
		end if;
	end if;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = argTenantId
		and Id = argServerMethodId;

	select
		sprm.TenantId as TenantId,
		sprm.Id as Id
	into
		prevPrevTenantId,
		prevPrevId
	from cfbam23.srvprm sprm
	where
		sprm.TenantId = argTenantId
		and sprm.srvmeth_id = argServerMethodId
		and sprm.NextTenantId is null
		and sprm.NextId is null;

	select cfbam23.sp_next_paramidgen( argTenantId )
	into argId;

	insert into cfbam23.srvprm(
		createdby,
		createdat,
		updatedby,
		updatedat,
		tenantid,
		srvmeth_id,
		id,
		defschtentid,
		defschid,
		name,
		short_descr,
		descr,
		isnullable,
		tptentid,
		tpid,
		prevtenantid,
		previd,
		nexttenantid,
		nextid,
		revision )
	values (
		argAuditUserId,
		now(),
		argAuditUserId,
		now(),
		argTenantId,
		argServerMethodId,
		argId,
		argDefSchemaTenantId,
		argDefSchemaId,
		argName,
		argShortDescription,
		argDescription,
		argIsNullable,
		argTypeTenantId,
		argTypeId,
		prevPrevTenantId,
		prevPrevId,
		null,
		null,
		1 );
	insert into cfbam23.srvprm_h (
			TenantId,
			Id,
			auditclusterid,
			auditsessionid,
			auditstamp,
			srvmeth_id,
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
			revision,
			auditaction )
		select
			sprm.TenantId,
			sprm.Id,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			sprm.srvmeth_id,
			sprm.defschtentid,
			sprm.defschid,
			sprm.Name,
			sprm.short_descr,
			sprm.descr,
			sprm.IsNullable,
			sprm.TpTentId,
			sprm.TpId,
			sprm.PrevTenantId,
			sprm.PrevId,
			sprm.NextTenantId,
			sprm.NextId,
			sprm.revision,
			1
		from cfbam23.srvprm as sprm
		where
			sprm.tenantid = argTenantId
			and sprm.id = argId;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.srvprm
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			NextTenantId = argTenantId,
			NextId = argId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		select cfbam23.sp_audit_srvprm( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevPrevTenantId,
			prevPrevId,
			2 )
		into subret;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argServerMethodId;

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
