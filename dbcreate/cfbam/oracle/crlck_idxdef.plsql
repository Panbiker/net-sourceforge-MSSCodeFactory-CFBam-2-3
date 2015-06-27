--
--	@(#) dbcreate/cfbam/oracle/crlck_idxdef.plsql
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


create or replace procedure cfbam23.lck_idxdef(
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
	oldTableId numeric(22,0);
	olddefschtentid numeric(22,0);
	olddefschid numeric(22,0);
	oldName varchar2(192);
	oldshort_name varchar2(16);
	oldLabel varchar2(64);
	oldshort_descr varchar2(128);
	olddescr varchar2(1023);
	oldDbName varchar2(32);
	oldSuffix varchar2(16);
	oldIsUnique char(1);
	oldIsDbMapped char(1);
	olddflt_vis char(1);
begin
	permissionFlag := cfbam23.sp_is_tenant_user( secTenantId,
			'ReadIndex',
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
			TableId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			DbName,
			Suffix,
			IsUnique,
			IsDbMapped,
			dflt_vis
		into
			oldTenantId,
			oldTableId,
			oldId,
			olddefschtentid,
			olddefschid,
			oldName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldDbName,
			oldSuffix,
			oldIsUnique,
			oldIsDbMapped,
			olddflt_vis
		from cfbam23.idxdef
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
			idxd.TableId as TableId,
			idxd.defschtentid as defschtentid,
			idxd.defschid as defschid,
			idxd.Name as Name,
			idxd.short_name as short_name,
			idxd.Label as Label,
			idxd.short_descr as short_descr,
			idxd.descr as descr,
			idxd.DbName as DbName,
			idxd.Suffix as Suffix,
			idxd.IsUnique as IsUnique,
			idxd.IsDbMapped as IsDbMapped,
			idxd.dflt_vis as dflt_vis,
			scop.revision as revision
		from cfbam23.idxdef idxd
		inner join cfbam23.scopedef scop on
			idxd.TenantId = scop.TenantId
			and idxd.Id = scop.Id
		where
			idxd.TenantId = argTenantId
			and idxd.Id = argId;
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
			TableId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			DbName,
			Suffix,
			IsUnique,
			IsDbMapped,
			dflt_vis
		into
			oldTenantId,
			oldTableId,
			oldId,
			olddefschtentid,
			olddefschid,
			oldName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldDbName,
			oldSuffix,
			oldIsUnique,
			oldIsDbMapped,
			olddflt_vis
		from cfbam23.idxdef
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
			idxd.TableId as TableId,
			idxd.defschtentid as defschtentid,
			idxd.defschid as defschid,
			idxd.Name as Name,
			idxd.short_name as short_name,
			idxd.Label as Label,
			idxd.short_descr as short_descr,
			idxd.descr as descr,
			idxd.DbName as DbName,
			idxd.Suffix as Suffix,
			idxd.IsUnique as IsUnique,
			idxd.IsDbMapped as IsDbMapped,
			idxd.dflt_vis as dflt_vis,
			scop.revision as revision
		from cfbam23.idxdef idxd
		inner join cfbam23.scopedef scop on
			idxd.TenantId = scop.TenantId
			and idxd.Id = scop.Id
		where
			idxd.TenantId = argTenantId
			and idxd.Id = argId
			and idxd.TenantId = secTenantId;
	end if;
end lck_idxdef;
/

show errors procedure cfbam23.lck_idxdef;
/