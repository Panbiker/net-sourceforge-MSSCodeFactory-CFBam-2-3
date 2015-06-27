--
--	@(#) dbcreate/cfbam/oracle/crupd_reldef.plsql
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


create or replace procedure cfbam23.upd_reldef(
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
	argRelationTypeId smallint,
	argDbName varchar2,
	argSuffix varchar2,
	argFromIndexId numeric,
	argToTableId numeric,
	argToIndexId numeric,
	argIsRequired char,
	argIsAbstract char,
	argIsXsdContainer char,
	argNarrowedTenantId numeric,
	argNarrowedId numeric,
	argdflt_vis char,
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
	oldRelationTypeId smallint;
	oldDbName varchar2(32);
	oldSuffix varchar2(16);
	oldFromIndexId numeric(22,0);
	oldToTableId numeric(22,0);
	oldToIndexId numeric(22,0);
	oldIsRequired char(1);
	oldIsAbstract char(1);
	oldIsXsdContainer char(1);
	oldNarrowedTenantId numeric(22,0);
	oldNarrowedId numeric(22,0);
	olddflt_vis char(1);
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'RELD' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateRelation',
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
			RelationTypeId,
			DbName,
			Suffix,
			FromIndexId,
			ToTableId,
			ToIndexId,
			IsRequired,
			IsAbstract,
			IsXsdContainer,
			NarrowedTenantId,
			NarrowedId,
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
			oldRelationTypeId,
			oldDbName,
			oldSuffix,
			oldFromIndexId,
			oldToTableId,
			oldToIndexId,
			oldIsRequired,
			oldIsAbstract,
			oldIsXsdContainer,
			oldNarrowedTenantId,
			oldNarrowedId,
			olddflt_vis
		from cfbam23.reldef
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


	update cfbam23.reldef
	set
		TableId = argTableId,
		defschtentid = argdefschtentid,
		defschid = argdefschid,
		Name = argName,
		short_name = argshort_name,
		Label = argLabel,
		short_descr = argshort_descr,
		descr = argdescr,
		RelationTypeId = argRelationTypeId,
		DbName = argDbName,
		Suffix = argSuffix,
		FromIndexId = argFromIndexId,
		ToTableId = argToTableId,
		ToIndexId = argToIndexId,
		IsRequired = argIsRequired,
		IsAbstract = argIsAbstract,
		IsXsdContainer = argIsXsdContainer,
		NarrowedTenantId = argNarrowedTenantId,
		NarrowedId = argNarrowedId,
		dflt_vis = argdflt_vis
	where
		TenantId = argTenantId
		and Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	if( argClassCode = 'RELD' )
	then
		insert into cfbam23.reldef_h (
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
			RelationTypeId,
			DbName,
			Suffix,
			FromIndexId,
			ToTableId,
			ToIndexId,
			IsRequired,
			IsAbstract,
			IsXsdContainer,
			NarrowedTenantId,
			NarrowedId,
			dflt_vis,
			auditaction,
			auditstamp )
		select
			scop.TenantId as TenantId,
			scop.Id as Id,
			scop.classcode,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			reld.TableId as TableId,
			reld.defschtentid as defschtentid,
			reld.defschid as defschid,
			reld.Name as Name,
			reld.short_name as short_name,
			reld.Label as Label,
			reld.short_descr as short_descr,
			reld.descr as descr,
			reld.RelationTypeId as RelationTypeId,
			reld.DbName as DbName,
			reld.Suffix as Suffix,
			reld.FromIndexId as FromIndexId,
			reld.ToTableId as ToTableId,
			reld.ToIndexId as ToIndexId,
			reld.IsRequired as IsRequired,
			reld.IsAbstract as IsAbstract,
			reld.IsXsdContainer as IsXsdContainer,
			reld.NarrowedTenantId as NarrowedTenantId,
			reld.NarrowedId as NarrowedId,
			reld.dflt_vis as dflt_vis,
			2,
			sysdate
		from cfbam23.reldef reld
		inner join cfbam23.scopedef scop on
			reld.TenantId = scop.TenantId
			and reld.Id = scop.Id
		where
			reld.TenantId = argTenantId
			and reld.Id = argId;
	end if;

	open retCursor for select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.TenantId as TenantId,
			scop.Id as Id,
			reld.TableId as TableId,
			reld.defschtentid as defschtentid,
			reld.defschid as defschid,
			reld.Name as Name,
			reld.short_name as short_name,
			reld.Label as Label,
			reld.short_descr as short_descr,
			reld.descr as descr,
			reld.RelationTypeId as RelationTypeId,
			reld.DbName as DbName,
			reld.Suffix as Suffix,
			reld.FromIndexId as FromIndexId,
			reld.ToTableId as ToTableId,
			reld.ToIndexId as ToIndexId,
			reld.IsRequired as IsRequired,
			reld.IsAbstract as IsAbstract,
			reld.IsXsdContainer as IsXsdContainer,
			reld.NarrowedTenantId as NarrowedTenantId,
			reld.NarrowedId as NarrowedId,
			reld.dflt_vis as dflt_vis,
		scop.revision as revision
	from cfbam23.reldef reld
		inner join cfbam23.scopedef scop on
			reld.TenantId = scop.TenantId
			and reld.Id = scop.Id
	where
		reld.TenantId = argTenantId
			and reld.Id = argId;
end upd_reldef;

/

show errors procedure cfbam23.upd_reldef;
/
