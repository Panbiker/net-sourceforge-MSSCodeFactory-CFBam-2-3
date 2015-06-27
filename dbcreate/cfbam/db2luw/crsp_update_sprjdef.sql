--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_sprjdef.sql
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


create or replace procedure sp_update_sprjdef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argDescription varchar(1024),	\
	in argParentProjectId bigint,	\
	in argName varchar(64),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldDescription varchar(1024);	\
	declare oldRevision int;	\
	declare oldParentProjectId bigint;	\
	declare oldName varchar(64);	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				bdom.ClassCode,	\
				bdom.createdby as createdby,	\
				to_char( bdom.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				bdom.updatedby as updatedby,	\
				to_char( bdom.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			bdom.tenantid as tenantid,	\
			bdom.id as id,	\
			bdom.descr as descr,	\
			sprj.pprj_id as pprj_id,	\
			sprj.name as name,	\
			bdom.revision as revision	\
		from cfbam23.sprjdef as sprj	\
			inner join cfbam23.rprjdef rprj on	\
				sprj.tenantid = rprj.tenantid	\
				and sprj.Id = rprj.id	\
			inner join cfbam23.bprjdef bprj on	\
				rprj.tenantid = bprj.tenantid	\
				and rprj.Id = bprj.id	\
			inner join cfbam23.bdomdef bdom on	\
				bprj.tenantid = bdom.tenantid	\
				and bprj.Id = bdom.id	\
		where	\
			sprj.tenantid = argTenantId	\
		and sprj.id = argId;	\
	begin	\
		if( argClassCode = 'SPRJ' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateSubProject',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateSubProject' );	\
			end if;	\
		end if;	\
	\
		select	\
			ClassCode,	\
			TenantId,	\
			Id,	\
			descr,	\
			revision	\
		into	\
			oldClassCode,	\
			oldTenantId,	\
			oldId,	\
			oldDescription,	\
			oldRevision	\
		from cfbam23.bdomdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id	\
		into	\
			oldTenantId,	\
			oldId	\
		from cfbam23.bprjdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id	\
		into	\
			oldTenantId,	\
			oldId	\
		from cfbam23.rprjdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			pprj_id,	\
			Id,	\
			Name	\
		into	\
			oldTenantId,	\
			oldParentProjectId,	\
			oldId,	\
			oldName	\
		from cfbam23.sprjdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_sprjdef() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.bdomdef	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			descr = argDescription	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.sprjdef	\
		set	\
			pprj_id = argParentProjectId,	\
			name = argName	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		if( argClassCode = 'SPRJ' )	\
		then	\
			insert into cfbam23.sprjdef_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				descr,	\
				pprj_id,	\
				name,	\
				revision,	\
				auditaction )	\
			select	\
				bdom.tenantid,	\
				bdom.id,	\
				bdom.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				bdom.descr,	\
				sprj.pprj_id,	\
				sprj.name,	\
				bdom.revision,	\
				2	\
			from cfbam23.sprjdef as sprj	\
			inner join cfbam23.rprjdef rprj on	\
				sprj.tenantid = rprj.tenantid	\
				and sprj.Id = rprj.id	\
			inner join cfbam23.bprjdef bprj on	\
				rprj.tenantid = bprj.tenantid	\
				and rprj.Id = bprj.id	\
			inner join cfbam23.bdomdef bdom on	\
				bprj.tenantid = bdom.tenantid	\
				and bprj.Id = bdom.id	\
			where	\
				sprj.tenantid = argTenantId	\
		and sprj.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end