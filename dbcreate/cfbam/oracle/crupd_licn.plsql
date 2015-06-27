--
--	@(#) dbcreate/cfbam/oracle/crupd_licn.plsql
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


create or replace procedure cfbam23.upd_licn(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argTenantId numeric,
	argId numeric,
	argDomainId numeric,
	argName varchar2,
	argshort_name varchar2,
	argLabel varchar2,
	argshort_descr varchar2,
	argdescr varchar2,
	argEmbeddedText clob,
	argFullTxt varchar2,
	argRevision integer )
is
	oldTenantId numeric(22,0);
	oldId numeric(22,0);
	oldDomainId numeric(22,0);
	oldName varchar2(192);
	oldshort_name varchar2(16);
	oldLabel varchar2(64);
	oldshort_descr varchar2(128);
	olddescr varchar2(1023);
	oldEmbeddedText clob;
	oldFullTxt varchar2(8000);
	oldRevision integer;
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'LIC' )
	then
		permissionFlag := cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateLicense',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

		select
			TenantId,
			Id,
			DomainId,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			EmbeddedText,
			FullTxt,
			revision
		into
			oldTenantId,
			oldId,
			oldDomainId,
			oldName,
			oldshort_name,
			oldLabel,
			oldshort_descr,
			olddescr,
			oldEmbeddedText,
			oldFullTxt,
			oldRevision
		from cfbam23.licn
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;

	update cfbam23.licn
	set
		revision = argRevision + 1,
		DomainId = argDomainId,
		Name = argName,
		short_name = argshort_name,
		Label = argLabel,
		short_descr = argshort_descr,
		descr = argdescr,
		EmbeddedText = argEmbeddedText,
		FullTxt = argFullTxt
	where
		TenantId = argTenantId
		and Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	open retCursor for select
			lic.TenantId as TenantId,
			lic.Id as Id,
			lic.DomainId as DomainId,
			lic.Name as Name,
			lic.short_name as short_name,
			lic.Label as Label,
			lic.short_descr as short_descr,
			lic.descr as descr,
			lic.EmbeddedText as EmbeddedText,
			lic.FullTxt as FullTxt,
		lic.revision as revision
	from cfbam23.licn lic
	where
		lic.TenantId = argTenantId
			and lic.Id = argId;
end upd_licn;

/

show errors procedure cfbam23.upd_licn;
/