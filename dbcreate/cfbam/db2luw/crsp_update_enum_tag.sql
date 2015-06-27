--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_enum_tag.sql
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


create or replace procedure sp_update_enum_tag(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argEnumId bigint,	\
	in argEnumCode smallint,	\
	in argName varchar(64),	\
	in argPrevTenantId bigint,	\
	in argPrevId bigint,	\
	in argNextTenantId bigint,	\
	in argNextId bigint,	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldEnumId bigint;	\
	declare oldEnumCode smallint;	\
	declare oldName varchar(64);	\
	declare oldPrevTenantId bigint;	\
	declare oldPrevId bigint;	\
	declare oldNextTenantId bigint;	\
	declare oldNextId bigint;	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				etg.createdby as createdby,	\
				to_char( etg.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				etg.updatedby as updatedby,	\
				to_char( etg.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			etg.tenantid as tenantid,	\
			etg.id as id,	\
			etg.defschtentid as defschtentid,	\
			etg.defschid as defschid,	\
			etg.enumid as enumid,	\
			etg.enumcode as enumcode,	\
			etg.name as name,	\
			etg.prevtenantid as prevtenantid,	\
			etg.previd as previd,	\
			etg.nexttenantid as nexttenantid,	\
			etg.nextid as nextid,	\
			etg.revision as revision	\
		from cfbam23.enum_tag as etg	\
		where	\
			etg.tenantid = argTenantId	\
		and etg.id = argId;	\
	begin	\
		update cfbam23.valdef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argEnumId;	\
	\
		if( argClassCode = 'ETG' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateEnumTag',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateEnumTag' );	\
			end if;	\
		end if;	\
	\
		select	\
			TenantId,	\
			Id,	\
			defschtentid,	\
			defschid,	\
			EnumId,	\
			EnumCode,	\
			Name,	\
			PrevTenantId,	\
			PrevId,	\
			NextTenantId,	\
			NextId,	\
			revision	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldEnumId,	\
			oldEnumCode,	\
			oldName,	\
			oldPrevTenantId,	\
			oldPrevId,	\
			oldNextTenantId,	\
			oldNextId,	\
			oldRevision	\
		from cfbam23.enum_tag	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_enum_tag() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.enum_tag	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			enumid = argEnumId,	\
			enumcode = argEnumCode,	\
			name = argName,	\
			prevtenantid = argPrevTenantId,	\
			previd = argPrevId,	\
			nexttenantid = argNextTenantId,	\
			nextid = argNextId	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.valdef	\
		set revision = revision - 1	\
		where	\
			tenantid = argTenantId	\
			and id = argEnumId;	\
	\
		insert into cfbam23.enum_tag_h (	\
				tenantid,	\
				id,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				defschtentid,	\
				defschid,	\
				enumid,	\
				enumcode,	\
				name,	\
				prevtenantid,	\
				previd,	\
				nexttenantid,	\
				nextid,	\
			revision,	\
			auditaction )	\
		select	\
				etg.tenantid,	\
				etg.id,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				etg.defschtentid,	\
				etg.defschid,	\
				etg.enumid,	\
				etg.enumcode,	\
				etg.name,	\
				etg.prevtenantid,	\
				etg.previd,	\
				etg.nexttenantid,	\
				etg.nextid,	\
			etg.revision,	\
			2	\
		from cfbam23.enum_tag as etg	\
		where	\
			etg.tenantid = argTenantId	\
		and etg.id = argId;	\
	\
		open retcursor;	\
	end;	\
end