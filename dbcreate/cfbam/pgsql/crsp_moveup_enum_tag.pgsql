--
--	@(#) dbcreate/cfbam/pgsql/crsp_moveup_enum_tag.pgsql
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

create or replace function cfbam23.sp_moveup_enum_tag(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns setof cfbam23.type_enum_tag_rec as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	varTenantId bigint;
	varEnumId bigint;
	gprevTenantId bigint;
	gprevId bigint;
	varprevTenantId bigint;
	varprevId bigint;
	varnextTenantId bigint;
	varnextId bigint;
	oldTenantId bigint;
	oldId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldEnumId bigint;
	oldEnumCode smallint;
	oldName varchar(64);
	oldPrevTenantId bigint;
	oldPrevId bigint;
	oldNextTenantId bigint;
	oldNextId bigint;
	oldRevision int;
	permissionFlag boolean;
begin
	select
		TenantId,
		EnumId
	into
		varTenantId,
		varEnumId
	from cfbam23.enum_tag
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.valdef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varEnumId;

		select
			TenantId,
			Id,
			defschtentid,
			defschid,
			EnumId,
			EnumCode,
			Name,
			PrevTenantId,
			PrevId,
			NextTenantId,
			NextId,
			revision
		into
			oldTenantId,
			oldId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldEnumId,
			oldEnumCode,
			oldName,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			oldRevision
		from cfbam23.enum_tag
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise exception 'sp_moveup_enum_tag() Data collision detected';
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
		'UpdateEnumTag',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateEnumTag';
	end if;

	select
		prvetg.PrevTenantId as gprvPrevTenantId,
		prvetg.PrevId as gprvPrevId,
		etg.PrevTenantId as prvPrevTenantId,
		etg.PrevId as prvPrevId,
		etg.NextTenantId as nxtNextTenantId,
		etg.NextId as nxtNextId
	into
		gprevTenantId,
		gprevId,
		varprevTenantId,
		varprevId,
		varnextTenantId,
		varnextId
	from cfbam23.enum_tag etg
		left outer join cfbam23.enum_tag prvetg on
			prvetg.TenantId = etg.PrevTenantId
			and prvetg.Id = etg.PrevId
		left outer join cfbam23.enum_tag nxtetg on
			nxtetg.TenantId = etg.NextTenantId
			and nxtetg.Id = etg.NextId
	where
		etg.TenantId = argTenantId
		and etg.Id = argId;

	if( varprevTenantId is not null )
	then
		if( gprevTenantId is not null )
		then
			update cfbam23.enum_tag
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = now(),
				NextTenantId = argTenantId,
				NextId = argId
			where
				TenantId = gprevTenantId
				and Id = gprevId;

			get diagnostics RowsAffected = row_count;

			if RowsAffected != 1
			then
				raise exception 'sp_moveup_enum_tag() Expected to affect one grandprev row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_enum_tag( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gprevTenantId,
				gprevId,
				2 )
			into subret;
		end if;

		update cfbam23.enum_tag
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = gprevTenantId,
			PrevId = gprevId,
			NextTenantId = varprevTenantId,
			NextId = varprevId
		where
			TenantId = argTenantId
			and Id = argId;

		get diagnostics RowsAffected = row_count;

		if RowsAffected != 1
		then
			raise exception 'sp_moveup_enum_tag() Expected to affect one obj row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_enum_tag( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			argTenantId,
			argId,
			2 )
		into subret;

		update cfbam23.enum_tag
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = argTenantId,
			PrevId = argId,
			NextTenantId = varnextTenantId,
			NextId = varnextId
		where
			TenantId = varprevTenantId
			and Id = varprevId;

		get diagnostics RowsAffected = row_count;

		if RowsAffected != 1
		then
			raise exception 'sp_moveup_enum_tag() Expected to affect one prev row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_enum_tag( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varprevTenantId,
			varprevId,
			2 )
		into subret;

		if( varnextTenantId is not null )
		then
			update cfbam23.enum_tag
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = now(),
				PrevTenantId = varprevTenantId,
				PrevId = varprevId
			where
				TenantId = varnextTenantId
				and Id = varnextId;

			get diagnostics RowsAffected = row_count;

			if RowsAffected != 1
			then
				raise exception 'sp_moveup_enum_tag() Expected to affect one next row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_enum_tag( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varnextTenantId,
				varnextId,
				2 )
			into subret;
		end if;
	end if;

	update cfbam23.valdef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varEnumId;

	return query select
			etg.createdby,
			to_char( etg.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			etg.updatedby,
			to_char( etg.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			etg.tenantid as tenantid,
			etg.id as id,
			etg.defschtentid as defschtentid,
			etg.defschid as defschid,
			etg.enumid as enumid,
			etg.enumcode as enumcode,
			etg.name as name,
			etg.prevtenantid as prevtenantid,
			etg.previd as previd,
			etg.nexttenantid as nexttenantid,
			etg.nextid as nextid,
			etg.revision as revision
	from cfbam23.enum_tag as etg
	where
			etg.tenantid = argTenantId
			and etg.id = argId;

	return;
end;
$$ language plpgsql;
