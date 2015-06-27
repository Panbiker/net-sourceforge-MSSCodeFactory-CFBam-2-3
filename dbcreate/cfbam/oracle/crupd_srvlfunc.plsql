--
--	@(#) dbcreate/cfbam/oracle/crupd_srvlfunc.plsql
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


create or replace procedure cfbam23.upd_srvlfunc(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argId numeric,
	argTableId numeric,
	argdefschtentid numeric,
	argdefschid numeric,
	argName varchar2,
	argshort_name varchar2,
	argLabel varchar2,
	argshort_descr varchar2,
	argdescr varchar2,
	argSuffix varchar2,
	argdflt_vis char,
	arginst_meth char,
	argjmeth_body clob,
	argrettentid numeric,
	argrettblid numeric,
	argRevision integer )
is
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
	oldSuffix varchar2(16);
	olddflt_vis char(1);
	oldinst_meth char(1);
	oldjmeth_body clob;
	oldrettentid numeric(22,0);
	oldrettblid numeric(22,0);
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'SRVL' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateServerListFunc',
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
			TableId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			Suffix,
			dflt_vis,
			inst_meth,
			jmeth_body
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
			oldSuffix,
			olddflt_vis,
			oldinst_meth,
			oldjmeth_body
		from cfbam23.srvmeth
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id,
			rettentid,
			rettblid
		into
			oldTenantId,
			oldId,
			oldrettentid,
			oldrettblid
		from cfbam23.srvlfunc
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


	update cfbam23.srvmeth
	set
		TableId = argTableId,
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		Name = argName,
		short_name = argshort_name,
		Label = argLabel,
		short_descr = argshort_descr,
		descr = argdescr,
		Suffix = argSuffix,
		dflt_vis = argdflt_vis,
		inst_meth = arginst_meth,
		jmeth_body = argjmeth_body
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	update cfbam23.srvlfunc
	set
		rettentid = argrettentid,
		rettblid = argrettblid
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	if( argClassCode = 'SRVL' )
	then
		insert into cfbam23.srvlfunc_h (
			TenantId,
			Id,
			classcode,
			revision,
			auditclusterid,
			auditsessionid,
			TableId,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			Suffix,
			dflt_vis,
			inst_meth,
			jmeth_body,
			rettentid,
			rettblid,
			auditaction,
			auditstamp )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			srvm.TableId as TableId,
			srvm.defschtentid as defschtentid,
			srvm.defschid as defschid,
			srvm.Name as Name,
			srvm.short_name as short_name,
			srvm.Label as Label,
			srvm.short_descr as short_descr,
			srvm.descr as descr,
			srvm.Suffix as Suffix,
			srvm.dflt_vis as dflt_vis,
			srvm.inst_meth as inst_meth,
			srvm.jmeth_body as jmeth_body,
			srvl.rettentid as rettentid,
			srvl.rettblid as rettblid,
			2,
			sysdate
		from cfbam23.srvlfunc srvl
		inner join cfbam23.srvmeth srvm on
			srvl.TenantId = srvm.TenantId
			and srvl.Id = srvm.Id
		inner join cfbam23.scopedef scop on
			srvm.TenantId = scop.TenantId
			and srvm.Id = scop.Id
		where
			srvl.TenantId = argTenantId
			and srvl.Id = argId;
	end if;

	open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			srvm.TableId as TableId,
			srvm.defschtentid as defschtentid,
			srvm.defschid as defschid,
			srvm.Name as Name,
			srvm.short_name as short_name,
			srvm.Label as Label,
			srvm.short_descr as short_descr,
			srvm.descr as descr,
			srvm.Suffix as Suffix,
			srvm.dflt_vis as dflt_vis,
			srvm.inst_meth as inst_meth,
			srvm.jmeth_body as jmeth_body,
			srvl.rettentid as rettentid,
			srvl.rettblid as rettblid,
		scop.revision as revision
	from cfbam23.srvlfunc srvl
		inner join cfbam23.srvmeth srvm on
			srvl.TenantId = srvm.TenantId
			and srvl.Id = srvm.Id
		inner join cfbam23.scopedef scop on
			srvm.TenantId = scop.TenantId
			and srvm.Id = scop.Id
	where
		srvl.TenantId = argTenantId
			and srvl.Id = argId;
end upd_srvlfunc;

/

show errors procedure cfbam23.upd_srvlfunc;
/
