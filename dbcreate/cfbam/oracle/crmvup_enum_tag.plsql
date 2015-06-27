--
--	@(#) dbcreate/cfbam/oracle/crmvup_enum_tag.plsql
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

create or replace procedure cfbam23.mvup_enum_tag(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argId numeric,
	argRevision integer )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
	expectedToAffectOneRow exception;
	dataCollisionDetected exception;
	varTenantId numeric(22,0);
	varEnumId numeric(22,0);
	gprevTenantId numeric(22,0);
	gprevId numeric(22,0);
	varprevTenantId numeric(22,0);
	varprevId numeric(22,0);
	varnextTenantId numeric(22,0);
	varnextId numeric(22,0);
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
begin
	select
		TenantId,
		EnumId
	into
		varTenantId,
		varEnumId
	from cfbam23.enum_tag
	where
		TenantId = argTenantId
		and Id = argId;

	update cfbam23.valdef
	set revision = revision + 1
	where
		TenantId = varTenantId
		and Id = varEnumId;

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
		raise dataCollisionDetected;
	end if;

	if( oldTenantId != secTenantId )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	permissionFlag := cfbam23.sp_is_tenant_user( oldTenantId,
		'UpdateEnumTag',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	select
		prvetg.PrevTenantId as gprvPrevTenantId,
		prvetg.PrevId as gprvPrevId,
		etg.PrevTenantId as prvPrevTenantId,
		etg.PrevId as prvPrevId,
		etg.NextTenantId as nxtNextTenantId,
		etg.NextId as nxtNextId
	into
		gprevTenantId,
		gprevId,
		varprevTenantId,
		varprevId,
		varnextTenantId,
		varnextId
	from cfbam23.enum_tag etg
		left outer join cfbam23.enum_tag prvetg on
			prvetg.TenantId = etg.PrevTenantId
			and prvetg.Id = etg.PrevId
		left outer join cfbam23.enum_tag nxtetg on
			nxtetg.TenantId = etg.NextTenantId
			and nxtetg.Id = etg.NextId
	where
		etg.TenantId = argTenantId
		and etg.Id = argId;

	if( varprevTenantId is not null )
	then
		if( gprevTenantId is not null )
		then
			update cfbam23.enum_tag
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = sysdate,
				NextTenantId = argTenantId,
				NextId = argId
			where
				TenantId = gprevTenantId
				and Id = gprevId;

			if sql%rowcount != 1 then
				raise expectedToAffectOneRow;
			end if;

			cfbam23.aud_enum_tag( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gprevTenantId,
				gprevId,
				2 );
		end if;

		update cfbam23.enum_tag
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			PrevTenantId = gprevTenantId,
			PrevId = gprevId,
			NextTenantId = varprevTenantId,
			NextId = varprevId
		where
			TenantId = argTenantId
			and Id = argId;

		if sql%rowcount != 1 then
			raise expectedToAffectOneRow;
		end if;

		cfbam23.aud_enum_tag( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			argTenantId,
			argId,
			2 );

		update cfbam23.enum_tag
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			PrevTenantId = argTenantId,
			PrevId = argId,
			NextTenantId = varnextTenantId,
			NextId = varnextId
		where
			TenantId = varprevTenantId
			and Id = varprevId;

		if sql%rowcount != 1 then
			raise expectedToAffectOneRow;
		end if;

		cfbam23.aud_enum_tag( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varprevTenantId,
			varprevId,
			2 );

		if( varnextTenantId is not null )
		then
			update cfbam23.enum_tag
			set
				revision = revision + 1,
				updatedby = argAuditUserId,
				updatedat = sysdate,
				PrevTenantId = varprevTenantId,
				PrevId = varprevId
			where
				TenantId = varnextTenantId
				and Id = varnextId;

			if sql%rowcount != 1 then
				raise expectedToAffectOneRow;
			end if;

			cfbam23.aud_enum_tag( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varnextTenantId,
				varnextId,
				2 );
		end if;
	end if;

	update cfbam23.valdef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varEnumId;

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
end mvup_enum_tag;
/

show errors procedure cfbam23.mvup_enum_tag;
/
