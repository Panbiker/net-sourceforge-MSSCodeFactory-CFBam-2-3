--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_relcol.sql
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

create or replace procedure sp_create_relcol(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argRelationId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argFromColId bigint,	\
	in argToColId bigint,	\
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
				relc.createdby as createdby,	\
				to_char( relc.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				relc.updatedby as updatedby,	\
				to_char( relc.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			relc.tenantid as tenantid,	\
			relc.relationid as relationid,	\
			relc.id as id,	\
			relc.defschtentid as defschtentid,	\
			relc.defschid as defschid,	\
			relc.name as name,	\
			relc.short_name as short_name,	\
			relc.label as label,	\
			relc.short_descr as short_descr,	\
			relc.descr as descr,	\
			relc.fromcolid as fromcolid,	\
			relc.tocolid as tocolid,	\
			relc.prevtenantid as prevtenantid,	\
			relc.previd as previd,	\
			relc.nexttenantid as nexttenantid,	\
			relc.nextid as nextid,	\
			relc.dflt_vis as dflt_vis,	\
			relc.revision as revision	\
		from cfbam23.relcol as relc	\
		where	\
			relc.tenantid = argTenantId	\
		and relc.id = argId;	\
	begin	\
		if( argClassCode = 'RELC' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'CreateRelationCol',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateRelationCol' );	\
			end if;	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argRelationId;	\
	\
		select	\
			relc.tenantid as tenantid,	\
			relc.id as id	\
		into	\
			prevPrevTenantId,	\
			prevPrevId	\
		from cfbam23.relcol relc	\
		where	\
			relc.tenantid = argTenantId	\
			and relc.relationid = argRelationId	\
			and relc.nexttenantid is null	\
			and relc.nextid is null;	\
	\
		call sp_next_relationcolidgen( argTenantId,	\
			argId );	\
		insert into cfbam23.relcol(	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			tenantid,	\
			relationid,	\
			id,	\
			defschtentid,	\
			defschid,	\
			name,	\
			short_name,	\
			label,	\
			short_descr,	\
			descr,	\
			fromcolid,	\
			tocolid,	\
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
			argRelationId,	\
			argId,	\
			argDefSchemaTenantId,	\
			argDefSchemaId,	\
			argName,	\
			argShortName,	\
			argLabel,	\
			argShortDescription,	\
			argDescription,	\
			argFromColId,	\
			argToColId,	\
			prevPrevTenantId,	\
			prevPrevId,	\
			null,	\
			null,	\
			argDefaultVisibility,	\
			1 );	\
	\
		insert into cfbam23.relcol_h (	\
				tenantid,	\
				id,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				relationid,	\
				defschtentid,	\
				defschid,	\
				name,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				fromcolid,	\
				tocolid,	\
				prevtenantid,	\
				previd,	\
				nexttenantid,	\
				nextid,	\
				dflt_vis,	\
				revision,	\
				auditaction )	\
		select	\
				relc.tenantid,	\
				relc.id,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				relc.relationid,	\
				relc.defschtentid,	\
				relc.defschid,	\
				relc.name,	\
				relc.short_name,	\
				relc.label,	\
				relc.short_descr,	\
				relc.descr,	\
				relc.fromcolid,	\
				relc.tocolid,	\
				relc.prevtenantid,	\
				relc.previd,	\
				relc.nexttenantid,	\
				relc.nextid,	\
				relc.dflt_vis,	\
				relc.revision,	\
				1	\
		from cfbam23.relcol as relc	\
		where	\
				relc.tenantid = argTenantId	\
		and relc.id = argId;	\
	\
		if( prevPrevTenantId is not null )	\
		then	\
			update cfbam23.relcol	\
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
			call sp_audit_relcol( argAuditClusterId,	\
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
			and id = argRelationId;	\
	\
		open retcursor;	\
	end;	\
end
