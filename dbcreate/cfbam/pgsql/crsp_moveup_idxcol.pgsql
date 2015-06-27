--
--	@(#) dbcreate/cfbam/pgsql/crsp_moveup_idxcol.pgsql
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

create or replace function cfbam23.sp_moveup_idxcol(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns setof cfbam23.type_idxcol_rec as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	varTenantId bigint;
	varIndexId bigint;
	gprevTenantId bigint;
	gprevId bigint;
	varprevTenantId bigint;
	varprevId bigint;
	varnextTenantId bigint;
	varnextId bigint;
	oldTenantId bigint;
	oldIndexId bigint;
	oldId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldColumnId bigint;
	oldIsAscending boolean;
	oldPrevTenantId bigint;
	oldPrevId bigint;
	oldNextTenantId bigint;
	oldNextId bigint;
	oldDefaultVisibility boolean;
	oldRevision int;
	permissionFlag boolean;
begin
	select
		TenantId,
		IndexId
	into
		varTenantId,
		varIndexId
	from cfbam23.idxcol
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.scopedef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varIndexId;

		select
			TenantId,
			IndexId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			ColumnId,
			IsAscending,
			PrevTenantId,
			PrevId,
			NextTenantId,
			NextId,
			dflt_vis,
			revision
		into
			oldTenantId,
			oldIndexId,
			oldId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldColumnId,
			oldIsAscending,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			oldDefaultVisibility,
			oldRevision
		from cfbam23.idxcol
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise exception 'sp_moveup_idxcol() Data collision detected';
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
		'UpdateIndexCol',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateIndexCol';
	end if;

	select
		prvidxc.PrevTenantId as gprvPrevTenantId,
		prvidxc.PrevId as gprvPrevId,
		idxc.PrevTenantId as prvPrevTenantId,
		idxc.PrevId as prvPrevId,
		idxc.NextTenantId as nxtNextTenantId,
		idxc.NextId as nxtNextId
	into
		gprevTenantId,
		gprevId,
		varprevTenantId,
		varprevId,
		varnextTenantId,
		varnextId
	from cfbam23.idxcol idxc
		left outer join cfbam23.idxcol prvidxc on
			prvidxc.TenantId = idxc.PrevTenantId
			and prvidxc.Id = idxc.PrevId
		left outer join cfbam23.idxcol nxtidxc on
			nxtidxc.TenantId = idxc.NextTenantId
			and nxtidxc.Id = idxc.NextId
	where
		idxc.TenantId = argTenantId
		and idxc.Id = argId;

	if( varprevTenantId is not null )
	then
		if( gprevTenantId is not null )
		then
			update cfbam23.idxcol
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
				raise exception 'sp_moveup_idxcol() Expected to affect one grandprev row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_idxcol( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gprevTenantId,
				gprevId,
				2 )
			into subret;
		end if;

		update cfbam23.idxcol
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
			raise exception 'sp_moveup_idxcol() Expected to affect one obj row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			argTenantId,
			argId,
			2 )
		into subret;

		update cfbam23.idxcol
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
			raise exception 'sp_moveup_idxcol() Expected to affect one prev row, not %', RowsAffected;
		end if;

		select cfbam23.sp_audit_idxcol( argAuditClusterId,
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
			update cfbam23.idxcol
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
				raise exception 'sp_moveup_idxcol() Expected to affect one next row, not %', RowsAffected;
			end if;

			select cfbam23.sp_audit_idxcol( argAuditClusterId,
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

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varIndexId;

	return query select
			idxc.createdby,
			to_char( idxc.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			idxc.updatedby,
			to_char( idxc.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			idxc.tenantid as tenantid,
			idxc.indexid as indexid,
			idxc.id as id,
			idxc.defschtentid as defschtentid,
			idxc.defschid as defschid,
			idxc.name as name,
			idxc.short_name as short_name,
			idxc.label as label,
			idxc.short_descr as short_descr,
			idxc.descr as descr,
			idxc.columnid as columnid,
			idxc.isascending as isascending,
			idxc.prevtenantid as prevtenantid,
			idxc.previd as previd,
			idxc.nexttenantid as nexttenantid,
			idxc.nextid as nextid,
			idxc.dflt_vis as dflt_vis,
			idxc.revision as revision
	from cfbam23.idxcol as idxc
	where
			idxc.tenantid = argTenantId
			and idxc.id = argId;

	return;
end;
$$ language plpgsql;
