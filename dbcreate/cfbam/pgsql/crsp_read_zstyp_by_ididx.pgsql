--
--	@(#) dbcreate/cfbam/pgsql/crsp_read_zstyp_by_ididx.pgsql
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

create or replace function cfbam23.sp_read_zstyp_by_ididx(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint )
returns setof cfbam23.type_zstyp_rec as $$
declare
	permissionFlag boolean;
	isSystemUser boolean;
begin
	select cfbam23.sp_is_tenant_user( secTenantId,
			'ReadTZTimestampType',
			argAuditUserId ),
		cfbam23.sp_is_system_user( argAuditUserId )
	into permissionFlag, isSystemUser;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for ReadTZTimestampType';
	end if;
	if( isSystemUser )
	then
		return query select
			valu.ClassCode,
			valu.createdby,
			to_char( valu.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			valu.updatedby,
			to_char( valu.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			valu.tenantid as tenantid,
			valu.scopeid as scopeid,
			valu.id as id,
			valu.defschtentid as defschtentid,
			valu.defschid as defschid,
			valu.name as name,
			valu.short_name as short_name,
			valu.label as label,
			valu.short_descr as short_descr,
			valu.descr as descr,
			valu.isnullable as isnullable,
			valu.generateid as generateid,
			valu.datascopeid as datascopeid,
			valu.vasecid as vasecid,
			valu.easecid as easecid,
			valu.vafid as vafid,
			valu.eafid as eafid,
			valu.prevtenantid as prevtenantid,
			valu.previd as previd,
			valu.nexttenantid as nexttenantid,
			valu.nextid as nextid,
			valu.dflt_vis as dflt_vis,
			atom.dbname as dbname,
			to_char( zstd.initval, 'YYYY-MM-DD HH24:MI:SS' ) as initval,
			to_char( zstd.defval, 'YYYY-MM-DD HH24:MI:SS' ) as defval,
			to_char( zstd.minval, 'YYYY-MM-DD HH24:MI:SS' ) as minval,
			to_char( zstd.maxval, 'YYYY-MM-DD HH24:MI:SS' ) as maxval,
			to_char( zstd.nullvalue, 'YYYY-MM-DD HH24:MI:SS' ) as nullvalue,
			to_char( zstd.unknownval, 'YYYY-MM-DD HH24:MI:SS' ) as unknownval,
			zstt.schemadefid as schemadefid,
			valu.revision as revision
		from cfbam23.zstyp as zstt
		inner join cfbam23.zsdef zstd on
			zstt.tenantid = zstd.tenantid
			and zstt.Id = zstd.id
		inner join cfbam23.atomdef atom on
			zstd.tenantid = atom.tenantid
			and zstd.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
		where
			valu.tenantid = argTenantId
			and valu.id = argId
			and valu.ClassCode = 'ZSTT';
	else
		return query select
			valu.ClassCode,
			valu.createdby,
			to_char( valu.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			valu.updatedby,
			to_char( valu.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			valu.tenantid as tenantid,
			valu.scopeid as scopeid,
			valu.id as id,
			valu.defschtentid as defschtentid,
			valu.defschid as defschid,
			valu.name as name,
			valu.short_name as short_name,
			valu.label as label,
			valu.short_descr as short_descr,
			valu.descr as descr,
			valu.isnullable as isnullable,
			valu.generateid as generateid,
			valu.datascopeid as datascopeid,
			valu.vasecid as vasecid,
			valu.easecid as easecid,
			valu.vafid as vafid,
			valu.eafid as eafid,
			valu.prevtenantid as prevtenantid,
			valu.previd as previd,
			valu.nexttenantid as nexttenantid,
			valu.nextid as nextid,
			valu.dflt_vis as dflt_vis,
			atom.dbname as dbname,
			to_char( zstd.initval, 'YYYY-MM-DD HH24:MI:SS' ) as initval,
			to_char( zstd.defval, 'YYYY-MM-DD HH24:MI:SS' ) as defval,
			to_char( zstd.minval, 'YYYY-MM-DD HH24:MI:SS' ) as minval,
			to_char( zstd.maxval, 'YYYY-MM-DD HH24:MI:SS' ) as maxval,
			to_char( zstd.nullvalue, 'YYYY-MM-DD HH24:MI:SS' ) as nullvalue,
			to_char( zstd.unknownval, 'YYYY-MM-DD HH24:MI:SS' ) as unknownval,
			zstt.schemadefid as schemadefid,
			valu.revision as revision
		from cfbam23.zstyp as zstt
		inner join cfbam23.zsdef zstd on
			zstt.tenantid = zstd.tenantid
			and zstt.Id = zstd.id
		inner join cfbam23.atomdef atom on
			zstd.tenantid = atom.tenantid
			and zstd.Id = atom.id
		inner join cfbam23.valdef valu on
			atom.tenantid = valu.tenantid
			and atom.Id = valu.id
		where
			valu.tenantid = argTenantId
			and valu.id = argId
			and valu.ClassCode = 'ZSTT'
			and valu.TenantId = secTenantId;
	end if;
	return;
end
$$ language plpgsql;
