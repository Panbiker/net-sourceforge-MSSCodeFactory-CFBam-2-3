--
--	@(#) dbcreate/cfbam/oracle/crcrt_schema_ref.plsql
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

create or replace procedure cfbam23.crt_schema_ref(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argSchemaId numeric,
	argName varchar2,
	argRefModelName varchar2,
	argIncludeRoot varchar2,
	argRefSchTentId numeric,
	argRefSchId numeric )
is
	permissionDenied exception;
	permissionFlag integer;
	argId numeric;
begin
	if( argClassCode = 'SCRF' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'CreateSchemaRef',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	argId := cfbam23.nxt_scopeidgen( argTenantId );
	insert into cfbam23.scopedef(
		classcode,
		createdby,
		createdat,
		updatedby,
		updatedat,
		TenantId,
		Id,
		revision )
	values (
		argClassCode,
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argTenantId,
		argId,
		1 );
	insert into cfbam23.schema_ref(
		TenantId,
		Id,
		SchemaId,
		Name,
		RefModelName,
		IncludeRoot,
		RefSchTentId,
		RefSchId )
	values (
		argTenantId,
		argId,
		argSchemaId,
		argName,
		argRefModelName,
		argIncludeRoot,
		argRefSchTentId,
		argRefSchId );
	if( argClassCode = 'SCRF' )
	then
		insert into cfbam23.schema_ref_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			SchemaId,
			Name,
			RefModelName,
			IncludeRoot,
			RefSchTentId,
			RefSchId,
			revision,
			auditaction )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			sysdate,
			scrf.SchemaId as SchemaId,
			scrf.Name as Name,
			scrf.RefModelName as RefModelName,
			scrf.IncludeRoot as IncludeRoot,
			scrf.RefSchTentId as RefSchTentId,
			scrf.RefSchId as RefSchId,
			scop.revision,
			1
		from cfbam23.schema_ref scrf
		inner join cfbam23.scopedef scop on
			scrf.TenantId = scop.TenantId
			and scrf.Id = scop.Id
		where
			scrf.TenantId = argTenantId
			and scrf.Id = argId;
	end if;

	open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			scrf.SchemaId as SchemaId,
			scrf.Name as Name,
			scrf.RefModelName as RefModelName,
			scrf.IncludeRoot as IncludeRoot,
			scrf.RefSchTentId as RefSchTentId,
			scrf.RefSchId as RefSchId,
		scop.revision as revision
	from cfbam23.schema_ref scrf
		inner join cfbam23.scopedef scop on
			scrf.TenantId = scop.TenantId
			and scrf.Id = scop.Id
	where
		scrf.TenantId = argTenantId
			and scrf.Id = argId;
end crt_schema_ref;
/

show errors procedure cfbam23.crt_schema_ref;
/
