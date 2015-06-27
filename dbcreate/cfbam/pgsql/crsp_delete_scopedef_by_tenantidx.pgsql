--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_scopedef_by_tenantidx.pgsql
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
--	Code manufactured by MSS Code Factory
--

create or replace function cfbam23.sp_delete_scopedef_by_tenantidx(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	classCode varchar(4);
begin
	select cfbam23.sp_is_system_user( argAuditUserId ) into subret;
	if( subret )
	then
		for cur in
			select
					scop.classcode,
						scop.tenantid as tenantid,
						scop.id as id,
					scop.revision as revision
			from cfbam23.scopedef as scop
			where
					scop.tenantid = argTenantId
		loop
				select cur.classcode into classCode;
				case classCode
				when 'SCOP' then
					select cfbam23.sp_delete_scopedef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SCHM' then
					select cfbam23.sp_delete_schemadef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SCRF' then
					select cfbam23.sp_delete_schema_ref( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TBLD' then
					select cfbam23.sp_delete_tbldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DELD' then
					select cfbam23.sp_delete_del_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DELT' then
					select cfbam23.sp_delete_del_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL1' then
					select cfbam23.sp_delete_delsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL2' then
					select cfbam23.sp_delete_delsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL3' then
					select cfbam23.sp_delete_delsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IDXD' then
					select cfbam23.sp_delete_idxdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'RELD' then
					select cfbam23.sp_delete_reldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVM' then
					select cfbam23.sp_delete_srvmeth( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVP' then
					select cfbam23.sp_delete_srvprc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVO' then
					select cfbam23.sp_delete_srvofunc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVL' then
					select cfbam23.sp_delete_srvlfunc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POPD' then
					select cfbam23.sp_delete_pop_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POPT' then
					select cfbam23.sp_delete_pop_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP1' then
					select cfbam23.sp_delete_popsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP2' then
					select cfbam23.sp_delete_popsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP3' then
					select cfbam23.sp_delete_popsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLRD' then
					select cfbam23.sp_delete_clr_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLRT' then
					select cfbam23.sp_delete_clr_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR1' then
					select cfbam23.sp_delete_clrsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR2' then
					select cfbam23.sp_delete_clrsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR3' then
					select cfbam23.sp_delete_clrsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				else
					raise exception 'sp_delete_scopedef_by_tenantidx() Unrecognized cur.classcode value';
				end case;
		end loop;
	else
		for cur in
			select
					scop.classcode,
						scop.tenantid as tenantid,
						scop.id as id,
					scop.revision as revision
			from cfbam23.scopedef as scop
			where
					scop.tenantid = argTenantId
					and scop.TenantId = secTenantId
		loop
				select cur.classcode into classCode;
				case classCode
				when 'SCOP' then
					select cfbam23.sp_delete_scopedef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SCHM' then
					select cfbam23.sp_delete_schemadef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SCRF' then
					select cfbam23.sp_delete_schema_ref( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TBLD' then
					select cfbam23.sp_delete_tbldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DELD' then
					select cfbam23.sp_delete_del_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DELT' then
					select cfbam23.sp_delete_del_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL1' then
					select cfbam23.sp_delete_delsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL2' then
					select cfbam23.sp_delete_delsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DEL3' then
					select cfbam23.sp_delete_delsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IDXD' then
					select cfbam23.sp_delete_idxdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'RELD' then
					select cfbam23.sp_delete_reldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVM' then
					select cfbam23.sp_delete_srvmeth( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVP' then
					select cfbam23.sp_delete_srvprc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVO' then
					select cfbam23.sp_delete_srvofunc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'SRVL' then
					select cfbam23.sp_delete_srvlfunc( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POPD' then
					select cfbam23.sp_delete_pop_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POPT' then
					select cfbam23.sp_delete_pop_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP1' then
					select cfbam23.sp_delete_popsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP2' then
					select cfbam23.sp_delete_popsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'POP3' then
					select cfbam23.sp_delete_popsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLRD' then
					select cfbam23.sp_delete_clr_dep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLRT' then
					select cfbam23.sp_delete_clr_topdep( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR1' then
					select cfbam23.sp_delete_clrsubdep1( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR2' then
					select cfbam23.sp_delete_clrsubdep2( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'CLR3' then
					select cfbam23.sp_delete_clrsubdep3( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				else
					raise exception 'sp_delete_scopedef_by_tenantidx() Unrecognized cur.classcode value';
				end case;
		end loop;
	end if;
	return true;
end;
$$ language plpgsql;
