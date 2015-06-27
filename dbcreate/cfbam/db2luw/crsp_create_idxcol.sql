--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_idxcol.sql
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

create or replace procedure sp_create_idxcol(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argIndexId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argColumnId bigint,	\
	in argIsAscending char(1),	\
	in argPrevTenantId bigint,	\
	in argPrevId bigint,	\
	in argNextTenantId bigint,	\
	in argNextId bigint,	\
	in argDefaultVisibility char(1) )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare permissionFlag integer;	\
		declare argId bigint;	\
	\
	declare prevPrevTenantId bigint;	\
	declare prevPrevId bigint;	declare retcursor cursor with return to client for	\
		select	\
				idxc.createdby as createdby,	\
				to_char( idxc.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				idxc.updatedby as updatedby,	\
				to_char( idxc.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			idxc.tenantid as tenantid,	\
			idxc.indexid as indexid,	\
			idxc.id as id,	\
			idxc.defschtentid as defschtentid,	\
			idxc.defschid as defschid,	\
			idxc.name as name,	\
			idxc.short_name as short_name,	\
			idxc.label as label,	\
			idxc.short_descr as short_descr,	\
			idxc.descr as descr,	\
			idxc.columnid as columnid,	\
			idxc.isascending as isascending,	\
			idxc.prevtenantid as prevtenantid,	\
			idxc.previd as previd,	\
			idxc.nexttenantid as nexttenantid,	\
			idxc.nextid as nextid,	\
			idxc.dflt_vis as dflt_vis,	\
			idxc.revision as revision	\
		from cfbam23.idxcol as idxc	\
		where	\
			idxc.tenantid = argTenantId	\
		and idxc.id = argId;	\
	begin	\
		if( argClassCode = 'IDXC' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'CreateIndexCol',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateIndexCol' );	\
			end if;	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argIndexId;	\
	\
		select	\
			idxc.tenantid as tenantid,	\
			idxc.id as id	\
		into	\
			prevPrevTenantId,	\
			prevPrevId	\
		from cfbam23.idxcol idxc	\
		where	\
			idxc.tenantid = argTenantId	\
			and idxc.indexid = argIndexId	\
			and idxc.nexttenantid is null	\
			and idxc.nextid is null;	\
	\
		call sp_next_indexcolidgen( argTenantId,	\
			argId );	\
		insert into cfbam23.idxcol(	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			tenantid,	\
			indexid,	\
			id,	\
			defschtentid,	\
			defschid,	\
			name,	\
			short_name,	\
			label,	\
			short_descr,	\
			descr,	\
			columnid,	\
			isascending,	\
			prevtenantid,	\
			previd,	\
			nexttenantid,	\
			nextid,	\
			dflt_vis,	\
			revision )	\
		values (	\
			argAuditUserId,	\
			current timestamp,	\
			argAuditUserId,	\
			current timestamp,	\
			argTenantId,	\
			argIndexId,	\
			argId,	\
			argDefSchemaTenantId,	\
			argDefSchemaId,	\
			argName,	\
			argShortName,	\
			argLabel,	\
			argShortDescription,	\
			argDescription,	\
			argColumnId,	\
			argIsAscending,	\
			prevPrevTenantId,	\
			prevPrevId,	\
			null,	\
			null,	\
			argDefaultVisibility,	\
			1 );	\
	\
		insert into cfbam23.idxcol_h (	\
				tenantid,	\
				id,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				indexid,	\
				defschtentid,	\
				defschid,	\
				name,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				columnid,	\
				isascending,	\
				prevtenantid,	\
				previd,	\
				nexttenantid,	\
				nextid,	\
				dflt_vis,	\
				revision,	\
				auditaction )	\
		select	\
				idxc.tenantid,	\
				idxc.id,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				idxc.indexid,	\
				idxc.defschtentid,	\
				idxc.defschid,	\
				idxc.name,	\
				idxc.short_name,	\
				idxc.label,	\
				idxc.short_descr,	\
				idxc.descr,	\
				idxc.columnid,	\
				idxc.isascending,	\
				idxc.prevtenantid,	\
				idxc.previd,	\
				idxc.nexttenantid,	\
				idxc.nextid,	\
				idxc.dflt_vis,	\
				idxc.revision,	\
				1	\
		from cfbam23.idxcol as idxc	\
		where	\
				idxc.tenantid = argTenantId	\
		and idxc.id = argId;	\
	\
		if( prevPrevTenantId is not null )	\
		then	\
			update cfbam23.idxcol	\
			set	\
				revision = revision + 1,	\
				updatedby = argAuditUserId,	\
				updatedat = current timestamp,	\
				nexttenantid = argTenantId,	\
				nextid = argId	\
			where	\
				tenantid = prevPrevTenantId	\
				and id = prevPrevId;	\
	\
			call sp_audit_idxcol( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				prevPrevTenantId,	\
				prevPrevId,	\
				2 );	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			tenantid = argTenantId	\
			and id = argIndexId;	\
	\
		open retcursor;	\
	end;	\
end
