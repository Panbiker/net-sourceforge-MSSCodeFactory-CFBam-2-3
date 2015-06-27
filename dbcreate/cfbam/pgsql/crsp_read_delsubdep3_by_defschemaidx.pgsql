--
--	@(#) dbcreate/cfbam/pgsql/crsp_read_delsubdep3_by_defschemaidx.pgsql
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

create or replace function cfbam23.sp_read_delsubdep3_by_defschemaidx(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint )
returns setof cfbam23.type_delsubdep3_rec as $$
declare
	permissionFlag boolean;
	isSystemUser boolean;
begin
	select cfbam23.sp_is_tenant_user( secTenantId,
			'ReadDelSubDep3',
			argAuditUserId ),
		cfbam23.sp_is_system_user( argAuditUserId )
	into permissionFlag, isSystemUser;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for ReadDelSubDep3';
	end if;
	if( isSystemUser )
	then
		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			deld.defschtentid as defschtentid,
			deld.defschid as defschid,
			deld.relationtenantid as relationtenantid,
			deld.relationid as relationid,
			del3.conttenantid as conttenantid,
			del3.contdeldep2id as contdeldep2id,
			del3.name as name,
			scop.revision as revision
		from cfbam23.delsubdep3 as del3
		inner join cfbam23.del_dep deld on
			del3.tenantid = deld.tenantid
			and del3.Id = deld.id
		inner join cfbam23.scopedef scop on
			deld.tenantid = scop.tenantid
			and deld.Id = scop.id
		where
			( ( ( argDefSchemaTenantId is null ) and ( deld.defschtentid is null ) )
				or ( ( argDefSchemaTenantId is not null ) and ( deld.defschtentid = argDefSchemaTenantId ) ) )
			and ( ( ( argDefSchemaId is null ) and ( deld.defschid is null ) )
				or ( ( argDefSchemaId is not null ) and ( deld.defschid = argDefSchemaId ) ) )
			and scop.ClassCode = 'DEL3';
	else
		return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			deld.defschtentid as defschtentid,
			deld.defschid as defschid,
			deld.relationtenantid as relationtenantid,
			deld.relationid as relationid,
			del3.conttenantid as conttenantid,
			del3.contdeldep2id as contdeldep2id,
			del3.name as name,
			scop.revision as revision
		from cfbam23.delsubdep3 as del3
		inner join cfbam23.del_dep deld on
			del3.tenantid = deld.tenantid
			and del3.Id = deld.id
		inner join cfbam23.scopedef scop on
			deld.tenantid = scop.tenantid
			and deld.Id = scop.id
		where
			( ( ( argDefSchemaTenantId is null ) and ( deld.defschtentid is null ) )
				or ( ( argDefSchemaTenantId is not null ) and ( deld.defschtentid = argDefSchemaTenantId ) ) )
			and ( ( ( argDefSchemaId is null ) and ( deld.defschid is null ) )
				or ( ( argDefSchemaId is not null ) and ( deld.defschid = argDefSchemaId ) ) )
			and scop.ClassCode = 'DEL3'
			and scop.TenantId = secTenantId;
	end if;
	return;
end
$$ language plpgsql;
