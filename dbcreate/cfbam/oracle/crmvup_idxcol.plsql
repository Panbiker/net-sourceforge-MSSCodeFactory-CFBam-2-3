--
--	@(#) dbcreate/cfbam/oracle/crmvup_idxcol.plsql
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

create or replace procedure cfbam23.mvup_idxcol(
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
	varIndexId numeric(22,0);
	gprevTenantId numeric(22,0);
	gprevId numeric(22,0);
	varprevTenantId numeric(22,0);
	varprevId numeric(22,0);
	varnextTenantId numeric(22,0);
	varnextId numeric(22,0);
	oldTenantId numeric(22,0);
	oldIndexId numeric(22,0);
	oldId numeric(22,0);
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldName varchar2(192);
	oldshort_name varchar2(16);
	oldLabel varchar2(64);
	oldshort_descr varchar2(128);
	olddescr varchar2(1023);
	oldColumnId numeric(22,0);
	oldIsAscending char(1);
	oldPrevTenantId numeric(22,0);
	oldPrevId numeric(22,0);
	oldNextTenantId numeric(22,0);
	oldNextId numeric(22,0);
	olddflt_vis char(1);
	oldRevision integer;
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
			olddefschtentid,
			olddefschid,
			oldName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldColumnId,
			oldIsAscending,
			oldPrevTenantId,
			oldPrevId,
			oldNextTenantId,
			oldNextId,
			olddflt_vis,
			oldRevision
		from cfbam23.idxcol
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
		'UpdateIndexCol',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	select
		prvidxc.PrevTenantId as gprvPrevTenantId,
		prvidxc.PrevId as gprvPrevId,
		idxc.PrevTenantId as prvPrevTenantId,
		idxc.PrevId as prvPrevId,
		idxc.NextTenantId as nxtNextTenantId,
		idxc.NextId as nxtNextId
	into
		gprevTenantId,
		gprevId,
		varprevTenantId,
		varprevId,
		varnextTenantId,
		varnextId
	from cfbam23.idxcol idxc
		left outer join cfbam23.idxcol prvidxc on
			prvidxc.TenantId = idxc.PrevTenantId
			and prvidxc.Id = idxc.PrevId
		left outer join cfbam23.idxcol nxtidxc on
			nxtidxc.TenantId = idxc.NextTenantId
			and nxtidxc.Id = idxc.NextId
	where
		idxc.TenantId = argTenantId
		and idxc.Id = argId;

	if( varprevTenantId is not null )
	then
		if( gprevTenantId is not null )
		then
			update cfbam23.idxcol
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

			cfbam23.aud_idxcol( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				gprevTenantId,
				gprevId,
				2 );
		end if;

		update cfbam23.idxcol
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

		cfbam23.aud_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			argTenantId,
			argId,
			2 );

		update cfbam23.idxcol
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

		cfbam23.aud_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			varprevTenantId,
			varprevId,
			2 );

		if( varnextTenantId is not null )
		then
			update cfbam23.idxcol
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

			cfbam23.aud_idxcol( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				varnextTenantId,
				varnextId,
				2 );
		end if;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varIndexId;

	open retCursor for select
			idxc.createdby,
			to_char( idxc.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			idxc.updatedby,
			to_char( idxc.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			idxc.TenantId as TenantId,
			idxc.IndexId as IndexId,
			idxc.Id as Id,
			idxc.defschtentid as defschtentid,
			idxc.defschid as defschid,
			idxc.Name as Name,
			idxc.short_name as short_name,
			idxc.Label as Label,
			idxc.short_descr as short_descr,
			idxc.descr as descr,
			idxc.ColumnId as ColumnId,
			idxc.IsAscending as IsAscending,
			idxc.PrevTenantId as PrevTenantId,
			idxc.PrevId as PrevId,
			idxc.NextTenantId as NextTenantId,
			idxc.NextId as NextId,
			idxc.dflt_vis as dflt_vis,
		idxc.revision as revision
	from cfbam23.idxcol idxc
	where
		idxc.TenantId = argTenantId
			and idxc.Id = argId;
end mvup_idxcol;
/

show errors procedure cfbam23.mvup_idxcol;
/
