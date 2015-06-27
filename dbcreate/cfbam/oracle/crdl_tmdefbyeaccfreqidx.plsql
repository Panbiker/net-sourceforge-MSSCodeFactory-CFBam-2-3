--
--	@(#) dbcreate/cfbam/oracle/crdl_tmdefbyeaccfreqidx.plsql
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

create or replace procedure cfbam23.dl_tmdefbyeaccfreqidx(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argEAFId smallint )
is
	classCode varchar(4);
	unrecognizedClassCode exception;
	permissionFlag integer;
	cursor cursSystem is
		select
			valu.classcode,
			valu.TenantId as TenantId,
			valu.Id as Id,
				valu.revision as revision
		from cfbam23.tmdef timd
			inner join cfbam23.atomdef atom on
				timd.tenantid = atom.tenantid
				and timd.Id = atom.id
			inner join cfbam23.valdef valu on
				atom.tenantid = valu.tenantid
				and atom.Id = valu.id
		where
				( ( ( argEAFId is null ) and ( valu.EAFId is null ) )
				or ( ( argEAFId is not null ) and ( valu.EAFId = argEAFId ) ) );
	cursor cursRestrict is
		select
			valu.classcode,
			valu.TenantId as TenantId,
			valu.Id as Id,
				valu.revision as revision
		from cfbam23.tmdef timd
			inner join cfbam23.atomdef atom on
				timd.tenantid = atom.tenantid
				and timd.Id = atom.id
			inner join cfbam23.valdef valu on
				atom.tenantid = valu.tenantid
				and atom.Id = valu.id
		where
				( ( ( argEAFId is null ) and ( valu.EAFId is null ) )
				or ( ( argEAFId is not null ) and ( valu.EAFId = argEAFId ) ) )
				and valu.TenantId = secTenantId;
begin
	permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 1 )
	then
		for cur in cursSystem
		loop
		select cur.classcode into classCode from dual;
		case classCode
		when 'TIMD' then
			cfbam23.dl_tmdef( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		when 'TIMC' then
			cfbam23.dl_tmcol( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		when 'TIMT' then
			cfbam23.dl_tmtyp( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		else
			raise unrecognizedClassCode;
		end case;
		end loop;
	else
		for cur in cursRestrict
		loop
		select cur.classcode into classCode from dual;
		case classCode
		when 'TIMD' then
			cfbam23.dl_tmdef( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		when 'TIMC' then
			cfbam23.dl_tmcol( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		when 'TIMT' then
			cfbam23.dl_tmtyp( argAuditClusterId,
					argAuditUserId,
					argAuditSessionId,
					secClusterId,
					secTenantId,
					cur.tenantid,
					cur.id,
					cur.revision );
		else
			raise unrecognizedClassCode;
		end case;
		end loop;
	end if;
end dl_tmdefbyeaccfreqidx;
/

show errors procedure cfbam23.dl_tmdefbyeaccfreqidx;
/
