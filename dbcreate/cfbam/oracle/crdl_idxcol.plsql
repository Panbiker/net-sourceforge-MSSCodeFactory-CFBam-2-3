--
--	@(#) dbcreate/cfbam/oracle/crdl_idxcol.plsql
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

create or replace procedure cfbam23.dl_idxcol(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argId numeric,
	argRevision int )
is
	varTenantId numeric(22,0);
	varIndexId numeric(22,0);
	prevPrevTenantId numeric(22,0);
	prevPrevId numeric(22,0);
	nextNextTenantId numeric(22,0);
	nextNextId numeric(22,0);
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
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
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

	if( oldTenantId != secTenantId )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	permissionFlag := cfbam23.sp_is_tenant_user( oldTenantId,
		'DeleteIndexCol',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;
	select
		myself.PrevTenantId as prvPrevTenantId,
		myself.PrevId as prvPrevId,
		myself.NextTenantId as nxtNextTenantId,
		myself.NextId as nxtNextId
	into
		prevPrevTenantId,
		prevPrevId,
		nextNextTenantId,
		nextNextId
	from cfbam23.idxcol myself
	where
		myself.TenantId = argTenantId
		and myself.Id = argId;

	if( prevPrevTenantId is not null )
	then
		update cfbam23.idxcol
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			NextTenantId = nextNextTenantId,
			NextId = nextNextId
		where
			TenantId = prevPrevTenantId
			and Id = prevPrevId;

		cfbam23.aud_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			prevPrevTenantId,
			prevPrevId,
			2 );
	end if;

	if( nextNextTenantId is not null )
	then
		update cfbam23.idxcol
		set
			revision = revision + 1,
			updatedby = argAuditUserId,
			updatedat = sysdate,
			PrevTenantId = prevPrevTenantId,
			PrevId = prevPrevId
		where
			TenantId = nextNextTenantId
			and Id = nextNextId;

		cfbam23.aud_idxcol( argAuditClusterId,
			argAuditUserId,
			argAuditSessionId,
			secClusterId,
			secTenantId,
			nextNextTenantId,
			nextNextId,
			2 );
	end if;

	insert into cfbam23.idxcol_h (
			TenantId,
			Id,
			revision,
			auditclusterid,
			auditsessionid,
			IndexId,
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
			auditaction,
			auditstamp )
		select
			idxc.TenantId as TenantId,
			idxc.Id as Id,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			idxc.IndexId as IndexId,
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
			3,
			sysdate
		from cfbam23.idxcol idxc
		where
			idxc.TenantId = argTenantId
			and idxc.Id = argId;

	delete from cfbam23.idxcol
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

	update cfbam23.scopedef
	set revision = revision - 1
	where
		TenantId = varTenantId
		and Id = varIndexId;

end dl_idxcol;
/

show errors procedure cfbam23.dl_idxcol;
/
