--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_idxcol.pgsql
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

create or replace function cfbam23.sp_delete_idxcol(
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
	varIndexId bigint;
	prevPrevTenantId bigint;
	prevPrevId bigint;
	nextNextTenantId bigint;
	nextNextId bigint;
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
		'DeleteIndexCol',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteIndexCol';
	end if;

	select
		myself.PrevTenantId as prvPrevTenantId,
		myself.PrevId as prvPrevId,
		myself.NextTenantId as nxtNextTenantId,
		myself.NextId as nxtNextId
	into
		prevPrevTenantId,
		prevPrevId,
		nextNextTenantId,
		nextNextId
	from cfbam23.idxcol myself
	where
		myself.TenantId = argTenantId
		and myself.Id = argId;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.idxcol
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			NextTenantId = nextNextTenantId,
			NextId = nextNextId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		select cfbam23.sp_audit_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevPrevTenantId,
			prevPrevId,
			2 )
		into subret;
	end if;

	if( nextNextTenantId is not null )
	then
		update cfbam23.idxcol
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = now(),
			PrevTenantId = prevPrevTenantId,
			PrevId = prevPrevId
		where
			TenantId = nextNextTenantId
			and Id = nextNextId;

		select cfbam23.sp_audit_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			nextNextTenantId,
			nextNextId,
			2 )
		into subret;
	end if;

	insert into cfbam23.idxcol_h (
			TenantId,
			Id,
			auditclusterid,
			auditsessionid,
			auditstamp,
			IndexId,
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
			revision,
			auditaction )
		select
			idxc.TenantId,
			idxc.Id,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			idxc.IndexId,
			idxc.defschtentid,
			idxc.defschid,
			idxc.Name,
			idxc.short_name,
			idxc.Label,
			idxc.short_descr,
			idxc.descr,
			idxc.ColumnId,
			idxc.IsAscending,
			idxc.PrevTenantId,
			idxc.PrevId,
			idxc.NextTenantId,
			idxc.NextId,
			idxc.dflt_vis,
			argRevision + 1,
			3
		from cfbam23.idxcol as idxc
		where
			idxc.tenantid = argTenantId
			and idxc.id = argId;


	delete from cfbam23.idxcol
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_idxcol() Expected to affect 1 idxcol, not %', RowsAffected;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varIndexId;

	return true;
end;
$$ language plpgsql;
