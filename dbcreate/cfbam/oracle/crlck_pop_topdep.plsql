--
--	@(#) dbcreate/cfbam/oracle/crlck_pop_topdep.plsql
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
--	Code manufactured MSS Code Factory
--


create or replace procedure cfbam23.lck_pop_topdep(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argId numeric )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
	oldClassCode varchar2(4);
	oldTenantId numeric(22,0);
	oldId numeric(22,0);
	oldRevision integer;
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldRelationTenantId numeric(22,0);
	oldRelationId numeric(22,0);
	oldContTenantId numeric(22,0);
	oldContRelationId numeric(22,0);
	oldName varchar2(192);
begin
	permissionFlag := cfbam23.sp_is_tenant_user( secTenantId,
			'ReadPopTopDep',
			argAuditUserId );
	isSystemUser := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;
	if( isSystemUser = 1 )
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
			defschtentid,
			defschid,
			RelationTenantId,
			RelationId
		into
			oldTenantId,
			oldId,
			olddefschtentid,
			olddefschid,
			oldRelationTenantId,
			oldRelationId
		from cfbam23.pop_dep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			ContTenantId,
			ContRelationId,
			Name
		into
			oldTenantId,
			oldId,
			oldContTenantId,
			oldContRelationId,
			oldName
		from cfbam23.pop_topdep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			popd.defschtentid as defschtentid,
			popd.defschid as defschid,
			popd.RelationTenantId as RelationTenantId,
			popd.RelationId as RelationId,
			popt.ContTenantId as ContTenantId,
			popt.ContRelationId as ContRelationId,
			popt.Name as Name,
			scop.revision as revision
		from cfbam23.pop_topdep popt
		inner join cfbam23.pop_dep popd on
			popt.TenantId = popd.TenantId
			and popt.Id = popd.Id
		inner join cfbam23.scopedef scop on
			popd.TenantId = scop.TenantId
			and popd.Id = scop.Id
		where
			popt.TenantId = argTenantId
			and popt.Id = argId;
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
			defschtentid,
			defschid,
			RelationTenantId,
			RelationId
		into
			oldTenantId,
			oldId,
			olddefschtentid,
			olddefschid,
			oldRelationTenantId,
			oldRelationId
		from cfbam23.pop_dep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			ContTenantId,
			ContRelationId,
			Name
		into
			oldTenantId,
			oldId,
			oldContTenantId,
			oldContRelationId,
			oldName
		from cfbam23.pop_topdep
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			popd.defschtentid as defschtentid,
			popd.defschid as defschid,
			popd.RelationTenantId as RelationTenantId,
			popd.RelationId as RelationId,
			popt.ContTenantId as ContTenantId,
			popt.ContRelationId as ContRelationId,
			popt.Name as Name,
			scop.revision as revision
		from cfbam23.pop_topdep popt
		inner join cfbam23.pop_dep popd on
			popt.TenantId = popd.TenantId
			and popt.Id = popd.Id
		inner join cfbam23.scopedef scop on
			popd.TenantId = scop.TenantId
			and popd.Id = scop.Id
		where
			popt.TenantId = argTenantId
			and popt.Id = argId
			and scop.TenantId = secTenantId;
	end if;
end lck_pop_topdep;
/

show errors procedure cfbam23.lck_pop_topdep;
/
