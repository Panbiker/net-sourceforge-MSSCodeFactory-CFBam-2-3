--
--	@(#) dbcreate/cfbam/pgsql/crsp_update_idxdef.pgsql
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


create or replace function cfbam23.sp_update_idxdef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argId bigint,
	argTableId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint,
	argName varchar(192),
	argShortName varchar(16),
	argLabel varchar(64),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argDbName varchar(32),
	argSuffix varchar(16),
	argIsUnique boolean,
	argIsDbMapped boolean,
	argDefaultVisibility boolean,
	argRevision integer )
returns setof cfbam23.type_idxdef_rec as $$
declare
	RowsAffected integer;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldId bigint;
	oldRevision int;
	oldTableId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldDbName varchar(32);
	oldSuffix varchar(16);
	oldIsUnique boolean;
	oldIsDbMapped boolean;
	oldDefaultVisibility boolean;
	permissionFlag boolean;
begin
	if( argClassCode = 'IDXD' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateIndex',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateIndex';
		end if;
	end if;

		select
			ClassCode,
			TenantId,
			Id,
			revision
		into
			oldClassCode,
			oldTenantId,
			oldId,
			oldRevision
		from cfbam23.scopedef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			TableId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			DbName,
			Suffix,
			IsUnique,
			IsDbMapped,
			dflt_vis
		into
			oldTenantId,
			oldTableId,
			oldId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldDbName,
			oldSuffix,
			oldIsUnique,
			oldIsDbMapped,
			oldDefaultVisibility
		from cfbam23.idxdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;


	if argRevision != oldRevision
	then
		raise exception 'sp_update_idxdef() Data collision detected';
	end if;


	update cfbam23.scopedef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = now()
	where
		TenantId = argTenantId
			and Id = argId
		and revision = oldRevision;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_idxdef() Expected to affect one scopedef row, not %', RowsAffected;
	end if;

	update cfbam23.idxdef
	set
		tableid = argTableId,
		defschtentid = argDefSchemaTenantId,
		defschid = argDefSchemaId,
		name = argName,
		short_name = argShortName,
		label = argLabel,
		short_descr = argShortDescription,
		descr = argDescription,
		dbname = argDbName,
		suffix = argSuffix,
		isunique = argIsUnique,
		isdbmapped = argIsDbMapped,
		dflt_vis = argDefaultVisibility
	where
		TenantId = argTenantId
			and Id = argId;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_idxdef() Expected to affect one idxdef row, not %', RowsAffected;
	end if;


	if( argClassCode = 'IDXD' )
	then
		insert into cfbam23.idxdef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			TableId,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			DbName,
			Suffix,
			IsUnique,
			IsDbMapped,
			dflt_vis,
			revision,
			auditaction )
		select
			scop.TenantId,
			scop.Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			idxd.TableId,
			idxd.defschtentid,
			idxd.defschid,
			idxd.Name,
			idxd.short_name,
			idxd.Label,
			idxd.short_descr,
			idxd.descr,
			idxd.DbName,
			idxd.Suffix,
			idxd.IsUnique,
			idxd.IsDbMapped,
			idxd.dflt_vis,
			argRevision + 1,
			2
		from cfbam23.idxdef as idxd
		inner join cfbam23.scopedef scop on
			idxd.tenantid = scop.tenantid
			and idxd.Id = scop.id
		where
			idxd.tenantid = argTenantId
			and idxd.id = argId;
	end if;

	return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			idxd.tableid as tableid,
			idxd.defschtentid as defschtentid,
			idxd.defschid as defschid,
			idxd.name as name,
			idxd.short_name as short_name,
			idxd.label as label,
			idxd.short_descr as short_descr,
			idxd.descr as descr,
			idxd.dbname as dbname,
			idxd.suffix as suffix,
			idxd.isunique as isunique,
			idxd.isdbmapped as isdbmapped,
			idxd.dflt_vis as dflt_vis,
		scop.revision as revision
	from cfbam23.idxdef as idxd
		inner join cfbam23.scopedef scop on
			idxd.tenantid = scop.tenantid
			and idxd.Id = scop.id
	where
		idxd.tenantid = argTenantId
			and idxd.id = argId;

	return;
end;
$$ language plpgsql;