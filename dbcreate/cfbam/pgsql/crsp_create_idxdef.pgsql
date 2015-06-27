--
--	@(#) dbcreate/cfbam/pgsql/crsp_create_idxdef.pgsql
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

create or replace function cfbam23.sp_create_idxdef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argTableId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint,
	argName varchar(192),
	argShortName varchar(16),
	argLabel varchar(64),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argDbName varchar(32),
	argSuffix varchar(16),
	argIsUnique boolean,
	argIsDbMapped boolean,
	argDefaultVisibility boolean )
returns setof cfbam23.type_idxdef_rec as $$
declare
	permissionFlag boolean;
	argId bigint;
begin
	if( argClassCode = 'IDXD' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'CreateIndex',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for CreateIndex';
		end if;
	end if;

	select cfbam23.sp_next_scopeidgen( argTenantId )
	into argId;

	insert into cfbam23.scopedef(
		classcode,
		createdby,
		createdat,
		updatedby,
		updatedat,
		tenantid,
		id,
		revision )
	values (
		argClassCode,
		argAuditUserId,
		now(),
		argAuditUserId,
		now(),
		argTenantId,
		argId,
		1 );

	insert into cfbam23.idxdef(
		tenantid,
		tableid,
		id,
		defschtentid,
		defschid,
		name,
		short_name,
		label,
		short_descr,
		descr,
		dbname,
		suffix,
		isunique,
		isdbmapped,
		dflt_vis )
	values (
		argTenantId,
		argTableId,
		argId,
		argDefSchemaTenantId,
		argDefSchemaId,
		argName,
		argShortName,
		argLabel,
		argShortDescription,
		argDescription,
		argDbName,
		argSuffix,
		argIsUnique,
		argIsDbMapped,
		argDefaultVisibility );

	if( argClassCode = 'IDXD' )
	then insert into cfbam23.idxdef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			TableId,
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
			dflt_vis,
			revision,
			auditaction )
		select
			scop.TenantId,
			scop.Id,
			scop.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			idxd.TableId,
			idxd.defschtentid,
			idxd.defschid,
			idxd.Name,
			idxd.short_name,
			idxd.Label,
			idxd.short_descr,
			idxd.descr,
			idxd.DbName,
			idxd.Suffix,
			idxd.IsUnique,
			idxd.IsDbMapped,
			idxd.dflt_vis,
			scop.revision,
			1
		from cfbam23.idxdef as idxd
		inner join cfbam23.scopedef scop on
			idxd.tenantid = scop.tenantid
			and idxd.Id = scop.id
		where
			idxd.tenantid = argTenantId
			and idxd.id = argId;
	end if;

	return query select
			scop.ClassCode,
			scop.createdby,
			to_char( scop.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			scop.updatedby,
			to_char( scop.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			scop.tenantid as tenantid,
			scop.id as id,
			idxd.tableid as tableid,
			idxd.defschtentid as defschtentid,
			idxd.defschid as defschid,
			idxd.name as name,
			idxd.short_name as short_name,
			idxd.label as label,
			idxd.short_descr as short_descr,
			idxd.descr as descr,
			idxd.dbname as dbname,
			idxd.suffix as suffix,
			idxd.isunique as isunique,
			idxd.isdbmapped as isdbmapped,
			idxd.dflt_vis as dflt_vis,
			scop.revision as revision
	from cfbam23.idxdef as idxd
		inner join cfbam23.scopedef scop on
			idxd.tenantid = scop.tenantid
			and idxd.Id = scop.id
	where
			idxd.tenantid = argTenantId
			and idxd.id = argId;

	return;
end;
$$ language plpgsql;
