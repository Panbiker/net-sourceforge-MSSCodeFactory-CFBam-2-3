--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_srvprm.sql
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


create or replace procedure sp_update_srvprm(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argServerMethodId bigint,	\
	in argId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argIsNullable char(1),	\
	in argTypeTenantId bigint,	\
	in argTypeId bigint,	\
	in argPrevTenantId bigint,	\
	in argPrevId bigint,	\
	in argNextTenantId bigint,	\
	in argNextId bigint,	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldTenantId bigint;	\
	declare oldServerMethodId bigint;	\
	declare oldId bigint;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldName varchar(192);	\
	declare oldShortDescription varchar(128);	\
	declare oldDescription varchar(1023);	\
	declare oldIsNullable char(1);	\
	declare oldTypeTenantId bigint;	\
	declare oldTypeId bigint;	\
	declare oldPrevTenantId bigint;	\
	declare oldPrevId bigint;	\
	declare oldNextTenantId bigint;	\
	declare oldNextId bigint;	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				sprm.createdby as createdby,	\
				to_char( sprm.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				sprm.updatedby as updatedby,	\
				to_char( sprm.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			sprm.tenantid as tenantid,	\
			sprm.srvmeth_id as srvmeth_id,	\
			sprm.id as id,	\
			sprm.defschtentid as defschtentid,	\
			sprm.defschid as defschid,	\
			sprm.name as name,	\
			sprm.short_descr as short_descr,	\
			sprm.descr as descr,	\
			sprm.isnullable as isnullable,	\
			sprm.tptentid as tptentid,	\
			sprm.tpid as tpid,	\
			sprm.prevtenantid as prevtenantid,	\
			sprm.previd as previd,	\
			sprm.nexttenantid as nexttenantid,	\
			sprm.nextid as nextid,	\
			sprm.revision as revision	\
		from cfbam23.srvprm as sprm	\
		where	\
			sprm.tenantid = argTenantId	\
		and sprm.id = argId;	\
	begin	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argServerMethodId;	\
	\
		if( argClassCode = 'SPRM' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateParam',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateParam' );	\
			end if;	\
		end if;	\
	\
		select	\
			TenantId,	\
			srvmeth_id,	\
			Id,	\
			defschtentid,	\
			defschid,	\
			Name,	\
			short_descr,	\
			descr,	\
			IsNullable,	\
			TpTentId,	\
			TpId,	\
			PrevTenantId,	\
			PrevId,	\
			NextTenantId,	\
			NextId,	\
			revision	\
		into	\
			oldTenantId,	\
			oldServerMethodId,	\
			oldId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldName,	\
			oldShortDescription,	\
			oldDescription,	\
			oldIsNullable,	\
			oldTypeTenantId,	\
			oldTypeId,	\
			oldPrevTenantId,	\
			oldPrevId,	\
			oldNextTenantId,	\
			oldNextId,	\
			oldRevision	\
		from cfbam23.srvprm	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_srvprm() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.srvprm	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			srvmeth_id = argServerMethodId,	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			name = argName,	\
			short_descr = argShortDescription,	\
			descr = argDescription,	\
			isnullable = argIsNullable,	\
			tptentid = argTypeTenantId,	\
			tpid = argTypeId,	\
			prevtenantid = argPrevTenantId,	\
			previd = argPrevId,	\
			nexttenantid = argNextTenantId,	\
			nextid = argNextId	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			tenantid = argTenantId	\
			and id = argServerMethodId;	\
	\
		insert into cfbam23.srvprm_h (	\
				tenantid,	\
				id,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				srvmeth_id,	\
				defschtentid,	\
				defschid,	\
				name,	\
				short_descr,	\
				descr,	\
				isnullable,	\
				tptentid,	\
				tpid,	\
				prevtenantid,	\
				previd,	\
				nexttenantid,	\
				nextid,	\
			revision,	\
			auditaction )	\
		select	\
				sprm.tenantid,	\
				sprm.id,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				sprm.srvmeth_id,	\
				sprm.defschtentid,	\
				sprm.defschid,	\
				sprm.name,	\
				sprm.short_descr,	\
				sprm.descr,	\
				sprm.isnullable,	\
				sprm.tptentid,	\
				sprm.tpid,	\
				sprm.prevtenantid,	\
				sprm.previd,	\
				sprm.nexttenantid,	\
				sprm.nextid,	\
			sprm.revision,	\
			2	\
		from cfbam23.srvprm as sprm	\
		where	\
			sprm.tenantid = argTenantId	\
		and sprm.id = argId;	\
	\
		open retcursor;	\
	end;	\
end
