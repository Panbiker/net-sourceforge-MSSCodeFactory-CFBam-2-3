--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_verndef.pgsql
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

create or replace function cfbam23.sp_delete_verndef(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argTenantId bigint,
	argId bigint,
	argRevision int )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	oldClassCode varchar(4);
	oldTenantId bigint;
	oldId bigint;
	oldDescription varchar(1024);
	oldRevision int;
	permissionFlag boolean;
begin
		select
			ClassCode,
			TenantId,
			Id,
			descr,
			revision
		into
			oldClassCode,
			oldTenantId,
			oldId,
			oldDescription,
			oldRevision
		from cfbam23.bdomdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id
		into
			oldTenantId,
			oldId
		from cfbam23.bprjdef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

		select
			TenantId,
			Id
		into
			oldTenantId,
			oldId
		from cfbam23.verndef
		where
			TenantId = argTenantId
			and Id = argId
		for update;

	if( oldTenantId != secTenantId )
	then
		select cfbam23.sp_is_system_user( argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- Data is not owned by logged in tenant';
		end if;
	end if;

	select cfbam23.sp_is_tenant_user( oldTenantId,
		'DeleteVersion',
		argAuditUserId )
	into permissionFlag;
	if( permissionFlag = false )
	then
		raise exception 'Permission denied -- User not found in tenant TSecGroup for DeleteVersion';
	end if;

	if( oldClassCode = 'VERN' )
	then
		insert into cfbam23.verndef_h (
			TenantId,
			Id,
			classcode,
			auditclusterid,
			auditsessionid,
			auditstamp,
			descr,
			revision,
			auditaction )
		select
			bdom.TenantId,
			bdom.Id,
			bdom.classcode,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			bdom.descr,
			argRevision + 1,
			3
		from cfbam23.verndef as vern
		inner join cfbam23.bprjdef bprj on
			vern.tenantid = bprj.tenantid
			and vern.Id = bprj.id
		inner join cfbam23.bdomdef bdom on
			bprj.tenantid = bdom.tenantid
			and bprj.Id = bdom.id
		where
			vern.tenantid = argTenantId
			and vern.id = argId;
	end if;

	select cfbam23.sp_delete_schemadef_by_domainidx( argAuditClusterId,
		argAuditUserId,
		argAuditSessionId,
		secClusterId,
		secTenantId,
		argTenantId,
		argId )
	into subret;

	select cfbam23.sp_delete_licn_by_domainidx( argAuditClusterId,
		argAuditUserId,
		argAuditSessionId,
		secClusterId,
		secTenantId,
		argTenantId,
		argId )
	into subret;


	delete from cfbam23.verndef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_verndef() Expected to affect 1 verndef, not %', RowsAffected;
	end if;
	delete from cfbam23.bprjdef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_verndef() Expected to affect 1 bprjdef, not %', RowsAffected;
	end if;
	delete from cfbam23.bdomdef
	where
		tenantid = argTenantId
		and id = argId;

	get diagnostics RowsAffected = row_count;
	if RowsAffected != 1 and RowsAffected != 0
	then
		raise exception 'sp_delete_verndef() Expected to affect 1 bdomdef, not %', RowsAffected;
	end if;



	return true;
end;
$$ language plpgsql;
