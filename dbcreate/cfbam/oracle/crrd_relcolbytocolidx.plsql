--
--	@(#) dbcreate/cfbam/oracle/crrd_relcolbytocolidx.plsql
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

create or replace procedure cfbam23.rd_relcolbytocolidx(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argToColId numeric )
is
	permissionFlag integer;
	isSystemUser integer;
	permissionDenied exception;
begin
	permissionFlag := cfbam23.sp_is_tenant_user( secTenantId,
			'ReadRelationCol',
			argAuditUserId );
	isSystemUser := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;
	if( isSystemUser = 1 )
	then
		open retCursor for select
			relc.createdby,
			to_char( relc.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			relc.updatedby,
			to_char( relc.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			relc.TenantId as TenantId,
			relc.RelationId as RelationId,
			relc.Id as Id,
			relc.defschtentid as defschtentid,
			relc.defschid as defschid,
			relc.Name as Name,
			relc.short_name as short_name,
			relc.Label as Label,
			relc.short_descr as short_descr,
			relc.descr as descr,
			relc.FromColId as FromColId,
			relc.ToColId as ToColId,
			relc.PrevTenantId as PrevTenantId,
			relc.PrevId as PrevId,
			relc.NextTenantId as NextTenantId,
			relc.NextId as NextId,
			relc.dflt_vis as dflt_vis,
			relc.revision as revision
		from cfbam23.relcol relc
		where
			relc.TenantId = argTenantId
			and relc.ToColId = argToColId;
	else
		open retCursor for select
			relc.createdby,
			to_char( relc.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			relc.updatedby,
			to_char( relc.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			relc.TenantId as TenantId,
			relc.RelationId as RelationId,
			relc.Id as Id,
			relc.defschtentid as defschtentid,
			relc.defschid as defschid,
			relc.Name as Name,
			relc.short_name as short_name,
			relc.Label as Label,
			relc.short_descr as short_descr,
			relc.descr as descr,
			relc.FromColId as FromColId,
			relc.ToColId as ToColId,
			relc.PrevTenantId as PrevTenantId,
			relc.PrevId as PrevId,
			relc.NextTenantId as NextTenantId,
			relc.NextId as NextId,
			relc.dflt_vis as dflt_vis,
			relc.revision as revision
		from cfbam23.relcol relc
		where
			relc.TenantId = argTenantId
			and relc.ToColId = argToColId
			and relc.TenantId = secTenantId;
	end if;
end rd_relcolbytocolidx;
/

show errors procedure cfbam23.rd_relcolbytocolidx;
/
