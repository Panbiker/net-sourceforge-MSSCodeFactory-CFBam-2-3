--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_reldef.pgsql
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

create or replace function cfbam23.sp_delete_reldef(
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
	oldRelationTypeId smallint;
	oldDbName varchar(32);
	oldSuffix varchar(16);
	oldFromIndexId bigint;
	oldToTableId bigint;
	oldToIndexId bigint;
	oldIsRequired boolean;
	oldIsAbstract boolean;
	oldIsXsdContainer boolean;
	oldNarrowedTenantId bigint;
	oldNarrowedId bigint;
	oldDefaultVisibility boolean;
	permissionFlag boolean;
begin
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
			RelationTypeId,
			DbName,
			Suffix,
			FromIndexId,
			ToTableId,
			ToIndexId,
			IsRequired,
			IsAbstract,
			IsXsdContainer,
			NarrowedTenantId,
			NarrowedId,
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
			oldRelationTypeId,
			oldDbName,
			oldSuffix,
			oldFromIndexId,
			oldToTableId,
			oldToIndexId,
			oldIsRequired,
			oldIsAbstract,
			oldIsXsdContainer,
			oldNarrowedTenantId,
			oldNarrowedId,
			oldDefaultVisibility
		from cfbam23.reldef
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
		'DeleteRelation',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteRelation';
	end if;

	if( oldClassCode = 'RELD' )
	then
		insert into cfbam23.reldef_h (
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
			RelationTypeId,
			DbName,
			Suffix,
			FromIndexId,
			ToTableId,
			ToIndexId,
			IsRequired,
			IsAbstract,
			IsXsdContainer,
			NarrowedTenantId,
			NarrowedId,
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
			reld.TableId,
			reld.defschtentid,
			reld.defschid,
			reld.Name,
			reld.short_name,
			reld.Label,
			reld.short_descr,
			reld.descr,
			reld.RelationTypeId,
			reld.DbName,
			reld.Suffix,
			reld.FromIndexId,
			reld.ToTableId,
			reld.ToIndexId,
			reld.IsRequired,
			reld.IsAbstract,
			reld.IsXsdContainer,
			reld.NarrowedTenantId,
			reld.NarrowedId,
			reld.dflt_vis,
			argRevision + 1,
			3
		from cfbam23.reldef as reld
		inner join cfbam23.scopedef scop on
			reld.tenantid = scop.tenantid
			and reld.Id = scop.id
		where
			reld.tenantid = argTenantId
			and reld.id = argId;
	end if;

	for cur in
		select
			relc.TenantId,
			relc.Id
		from cfbam23.reldef as reld
			inner join cfbam23.relcol relc on 
				reld.TenantId = relc.TenantId
				and reld.Id = relc.RelationId
		where
			reld.TenantId = argTenantId
			and reld.Id = argId
	loop
		select cfbam23.sp_delete_relcol_by_ididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.Id )
			into subret;
	end loop;


	delete from cfbam23.reldef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_reldef() Expected to affect 1 reldef, not %', RowsAffected;
	end if;
	delete from cfbam23.scopedef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_reldef() Expected to affect 1 scopedef, not %', RowsAffected;
	end if;


	return true;
end;
$$ language plpgsql;
