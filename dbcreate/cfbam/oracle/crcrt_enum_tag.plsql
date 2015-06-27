--
--	@(#) dbcreate/cfbam/oracle/crcrt_enum_tag.plsql
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

create or replace procedure cfbam23.crt_enum_tag(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argdefschtentid numeric,
	argdefschid numeric,
	argEnumId numeric,
	argEnumCode smallint,
	argName varchar2,
	argPrevTenantId numeric,
	argPrevId numeric,
	argNextTenantId numeric,
	argNextId numeric )
is
	permissionDenied exception;
	permissionFlag integer;
	argId numeric;
	prevPrevTenantId numeric(22,0);
	prevPrevId numeric(22,0);
begin
	if( argClassCode = 'ETG' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'CreateEnumTag',
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

	begin
		select
			etg.TenantId as TenantId,
			etg.Id as Id
		into
			prevPrevTenantId,
			prevPrevId
		from cfbam23.enum_tag etg
		where
			etg.TenantId = argTenantId
			and etg.EnumId = argEnumId
			and etg.NextTenantId is null
			and etg.NextId is null;
	exception
		when NO_DATA_FOUND then
			prevPrevTenantId := null;
			prevPrevId := null;
	end;

	argId := cfbam23.nxt_enumtagidgen( argTenantId );
	insert into cfbam23.enum_tag(
		createdby,
		createdat,
		updatedby,
		updatedat,
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
		revision )
	values (
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argTenantId,
		argId,
		argdefschtentid,
		argdefschid,
		argEnumId,
		argEnumCode,
		argName,
		prevPrevTenantId,
		prevPrevId,
		null,
		null,
		1 );
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
			etg.revision as revision,
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
			1,
			sysdate
		from cfbam23.enum_tag etg
		where
			etg.TenantId = argTenantId
			and etg.Id = argId;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.enum_tag
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			NextTenantId = argTenantId,
			NextId = argId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		cfbam23.aud_enum_tag( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevPrevTenantId,
			prevPrevId,
			2 );
	end if;

	update cfbam23.valdef
	set revision = revision - 1
	where
		TenantId = argTenantId
		and Id = argEnumId;

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
end crt_enum_tag;
/

show errors procedure cfbam23.crt_enum_tag;
/
