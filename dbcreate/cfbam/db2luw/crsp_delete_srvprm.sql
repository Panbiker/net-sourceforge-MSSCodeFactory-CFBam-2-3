--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_srvprm.sql
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

create or replace procedure sp_delete_srvprm(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argRevision int )	\
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
	declare subret boolean;	\
	declare varTenantId bigint;	\
	declare varServerMethodId bigint;	\
	declare varprevTenantId bigint;	\
	declare varprevId bigint;	\
	declare varnextTenantId bigint;	\
	declare varnextId bigint;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select 1 from sysibm.sysdummy1;	\
	begin	\
		select	\
			TenantId,	\
			srvmeth_id	\
		into	\
			varTenantId,	\
			varServerMethodId	\
		from cfbam23.srvprm	\
		where	\
			TenantId = argTenantId	\
			and Id = argId;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			TenantId = varTenantId	\
		and Id = varServerMethodId;	\
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
		if( oldTenantId != secTenantId )	\
		then	\
			set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- Data is not owned by logged in tenant' );	\
			end if;	\
		end if;	\
	\
		set( permissionFlag ) = ( sp_is_tenant_user( oldTenantId,	\
				'DeleteParam',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for DeleteParam' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_srvprm() Data collision detected' );	\
		end if;	\
	\
		select	\
			sprm.PrevTenantId as prvPrevTenantId,	\
			sprm.PrevId as prvPrevId,	\
			sprm.NextTenantId as nxtNextTenantId,	\
			sprm.NextId as nxtNextId	\
		into	\
			varprevTenantId,	\
			varprevId,	\
			varnextTenantId,	\
			varnextId	\
		from cfbam23.srvprm sprm	\
			left outer join cfbam23.srvprm prvsprm on	\
				prvsprm.TenantId = sprm.PrevTenantId	\
				and prvsprm.Id = sprm.PrevId	\
			left outer join cfbam23.srvprm nxtsprm on	\
				nxtsprm.TenantId = sprm.NextTenantId	\
				and nxtsprm.Id = sprm.NextId	\
		where	\
			sprm.TenantId = argTenantId	\
			and sprm.Id = argId;	\
	\
		if( varprevTenantId is not null )	\
		then	\
			update cfbam23.srvprm	\
			set	\
				revision = revision + 1,	\
				updatedby = argAuditUserId,	\
				updatedat = current timestamp,	\
				NextTenantId = varnextTenantId,	\
				NextId = varnextId	\
			where	\
				TenantId = varprevTenantId	\
				and Id = varprevId;	\
	\
			call sp_audit_srvprm( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				varprevTenantId,	\
				varprevId,	\
				2 );	\
		end if;	\
	\
		if( varnextTenantId is not null )	\
		then	\
			update cfbam23.srvprm	\
			set	\
				revision = revision + 1,	\
				updatedby = argAuditUserId,	\
				updatedat = current timestamp,	\
				PrevTenantId = varprevTenantId,	\
				PrevId = varprevId	\
			where	\
				TenantId = varnextTenantId	\
				and Id = varnextId;	\
	\
			call sp_audit_srvprm( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				varnextTenantId,	\
				varnextId,	\
				2 );	\
		end if;	\
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
			sprm.revision + 1,	\
			3	\
		from cfbam23.srvprm as sprm	\
		where	\
			sprm.tenantid = argTenantId	\
		and sprm.id = argId;	\
	\
		delete from cfbam23.srvprm	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			TenantId = varTenantId	\
		and Id = varServerMethodId;	\
	\
		open retcursor;	\
	end;	\
end
