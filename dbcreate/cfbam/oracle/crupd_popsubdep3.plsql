--
--	@(#) dbcreate/cfbam/oracle/crupd_popsubdep3.plsql
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


create or replace procedure cfbam23.upd_popsubdep3(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argId numeric,
	argdefschtentid numeric,
	argdefschid numeric,
	argRelationTenantId numeric,
	argRelationId numeric,
	argContTenantId numeric,
	argcontpopdep2id numeric,
	argName varchar2,
	argRevision integer )
is
	oldClassCode varchar2(4);
	oldTenantId numeric(22,0);
	oldId numeric(22,0);
	oldRevision integer;
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldRelationTenantId numeric(22,0);
	oldRelationId numeric(22,0);
	oldContTenantId numeric(22,0);
	oldcontpopdep2id numeric(22,0);
	oldName varchar2(192);
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'POP3' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdatePopSubDep3',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
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
			contpopdep2id,
			Name
		into
			oldTenantId,
			oldId,
			oldContTenantId,
			oldcontpopdep2id,
			oldName
		from cfbam23.popsubdep3
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;

	update cfbam23.scopedef
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = sysdate
	where
		TenantId = argTenantId
		and Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.pop_dep
	set
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		RelationTenantId = argRelationTenantId,
		RelationId = argRelationId
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.popsubdep3
	set
		ContTenantId = argContTenantId,
		contpopdep2id = argcontpopdep2id,
		Name = argName
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	if( argClassCode = 'POP3' )
	then
		insert into cfbam23.popsubdep3_h (
			TenantId,
			Id,
			classcode,
			revision,
			auditclusterid,
			auditsessionid,
			defschtentid,
			defschid,
			RelationTenantId,
			RelationId,
			ContTenantId,
			contpopdep2id,
			Name,
			auditaction,
			auditstamp )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			popd.defschtentid as defschtentid,
			popd.defschid as defschid,
			popd.RelationTenantId as RelationTenantId,
			popd.RelationId as RelationId,
			pop3.ContTenantId as ContTenantId,
			pop3.contpopdep2id as contpopdep2id,
			pop3.Name as Name,
			2,
			sysdate
		from cfbam23.popsubdep3 pop3
		inner join cfbam23.pop_dep popd on
			pop3.TenantId = popd.TenantId
			and pop3.Id = popd.Id
		inner join cfbam23.scopedef scop on
			popd.TenantId = scop.TenantId
			and popd.Id = scop.Id
		where
			pop3.TenantId = argTenantId
			and pop3.Id = argId;
	end if;

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
			pop3.ContTenantId as ContTenantId,
			pop3.contpopdep2id as contpopdep2id,
			pop3.Name as Name,
		scop.revision as revision
	from cfbam23.popsubdep3 pop3
		inner join cfbam23.pop_dep popd on
			pop3.TenantId = popd.TenantId
			and pop3.Id = popd.Id
		inner join cfbam23.scopedef scop on
			popd.TenantId = scop.TenantId
			and popd.Id = scop.Id
	where
		pop3.TenantId = argTenantId
			and pop3.Id = argId;
end upd_popsubdep3;

/

show errors procedure cfbam23.upd_popsubdep3;
/
