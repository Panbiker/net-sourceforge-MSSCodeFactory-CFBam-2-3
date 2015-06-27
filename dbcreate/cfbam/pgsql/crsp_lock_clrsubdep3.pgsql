--
--	@(#) dbcreate/cfbam/pgsql/crsp_lock_clrsubdep3.pgsql
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


create or replace function cfbam23.sp_lock_clrsubdep3(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint )
returns setof cfbam23.type_clrsubdep3_rec as $$
declare
	permissionFlag boolean;
	isSystemUser boolean;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldId bigint;
	oldRevision int;
	oldRelationId bigint;
	oldContClearDep2TenantId bigint;
	oldContClearDep2Id bigint;
	oldName varchar(192);
begin
	select cfbam23.sp_is_tenant_user( secTenantId,
			'ReadClearSubDep3',
			argAuditUserId ),
		cfbam23.sp_is_system_user( argAuditUserId )
	into permissionFlag, isSystemUser;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for ReadClearSubDep3';
	end if;
	if( isSystemUser )
	then
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
			Id,
			RelationId
		into
			oldTenantId,
			oldId,
			oldRelationId
		from cfbam23.clr_dep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			contclrdep2tid,
			contclrdep2id,
			Name
		into
			oldTenantId,
			oldId,
			oldContClearDep2TenantId,
			oldContClearDep2Id,
			oldName
		from cfbam23.clrsubdep3
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			clrd.relationid as relationid,
			clr3.contclrdep2tid as contclrdep2tid,
			clr3.contclrdep2id as contclrdep2id,
			clr3.name as name,
			scop.revision as revision
		from cfbam23.clrsubdep3 as clr3
		inner join cfbam23.clr_dep clrd on
			clr3.tenantid = clrd.tenantid
			and clr3.Id = clrd.id
		inner join cfbam23.scopedef scop on
			clrd.tenantid = scop.tenantid
			and clrd.Id = scop.id
		where
			clr3.tenantid = argTenantId
			and clr3.id = argId;
	else
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
			Id,
			RelationId
		into
			oldTenantId,
			oldId,
			oldRelationId
		from cfbam23.clr_dep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			contclrdep2tid,
			contclrdep2id,
			Name
		into
			oldTenantId,
			oldId,
			oldContClearDep2TenantId,
			oldContClearDep2Id,
			oldName
		from cfbam23.clrsubdep3
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			clrd.relationid as relationid,
			clr3.contclrdep2tid as contclrdep2tid,
			clr3.contclrdep2id as contclrdep2id,
			clr3.name as name,
			scop.revision as revision
		from cfbam23.clrsubdep3 as clr3
		inner join cfbam23.clr_dep clrd on
			clr3.tenantid = clrd.tenantid
			and clr3.Id = clrd.id
		inner join cfbam23.scopedef scop on
			clrd.tenantid = scop.tenantid
			and clrd.Id = scop.id
		where
			clr3.tenantid = argTenantId
			and clr3.id = argId
			and scop.TenantId = secTenantId;
	end if;
	return;
end;
$$ language plpgsql;