--
--	@(#) dbcreate/cfbam/oracle/crupd_enum_tag.plsql
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


create or replace procedure cfbam23.upd_enum_tag(
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
	argEnumId numeric,
	argEnumCode smallint,
	argName varchar2,
	argPrevTenantId numeric,
	argPrevId numeric,
	argNextTenantId numeric,
	argNextId numeric,
	argRevision integer )
is
	oldTenantId numeric(22,0);
	oldId numeric(22,0);
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldEnumId numeric(22,0);
	oldEnumCode smallint;
	oldName varchar2(64);
	oldPrevTenantId numeric(22,0);
	oldPrevId numeric(22,0);
	oldNextTenantId numeric(22,0);
	oldNextId numeric(22,0);
	oldRevision integer;
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'ETG' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateEnumTag',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	update cfbam23.valdef
	set revision = revision + 1
	where
		TenantId = argTenantId
		and Id = argEnumId;

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
			olddefschtentid,
			olddefschid,
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
		raise dataCollision;
	end if;

	update cfbam23.enum_tag
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = sysdate,
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		EnumId = argEnumId,
		EnumCode = argEnumCode,
		Name = argName,
		PrevTenantId = argPrevTenantId,
		PrevId = argPrevId,
		NextTenantId = argNextTenantId,
		NextId = argNextId
	where
		TenantId = argTenantId
		and Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.valdef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argEnumId;

	insert into cfbam23.enum_tag_h (
			TenantId,
			Id,
			revision,
			auditclusterid,
			auditsessionid,
			defschtentid,
			defschid,
			EnumId,
			EnumCode,
			Name,
			PrevTenantId,
			PrevId,
			NextTenantId,
			NextId,
			auditaction,
			auditstamp )
		select
			etg.TenantId as TenantId,
			etg.Id as Id,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			etg.defschtentid as defschtentid,
			etg.defschid as defschid,
			etg.EnumId as EnumId,
			etg.EnumCode as EnumCode,
			etg.Name as Name,
			etg.PrevTenantId as PrevTenantId,
			etg.PrevId as PrevId,
			etg.NextTenantId as NextTenantId,
			etg.NextId as NextId,
			2,
			sysdate
		from cfbam23.enum_tag etg
		where
			etg.TenantId = argTenantId
			and etg.Id = argId;

	open retCursor for select
			etg.createdby,
			to_char( etg.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			etg.updatedby,
			to_char( etg.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			etg.TenantId as TenantId,
			etg.Id as Id,
			etg.defschtentid as defschtentid,
			etg.defschid as defschid,
			etg.EnumId as EnumId,
			etg.EnumCode as EnumCode,
			etg.Name as Name,
			etg.PrevTenantId as PrevTenantId,
			etg.PrevId as PrevId,
			etg.NextTenantId as NextTenantId,
			etg.NextId as NextId,
		etg.revision as revision
	from cfbam23.enum_tag etg
	where
		etg.TenantId = argTenantId
			and etg.Id = argId;
end upd_enum_tag;

/

show errors procedure cfbam23.upd_enum_tag;
/
