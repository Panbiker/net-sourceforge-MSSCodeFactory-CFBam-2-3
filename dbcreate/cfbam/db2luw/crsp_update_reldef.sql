--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_reldef.sql
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


create or replace procedure sp_update_reldef(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argTableId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argRelationTypeId smallint,	\
	in argDbName varchar(32),	\
	in argSuffix varchar(16),	\
	in argFromIndexId bigint,	\
	in argToTableId bigint,	\
	in argToIndexId bigint,	\
	in argIsRequired char(1),	\
	in argIsAbstract char(1),	\
	in argIsXsdContainer char(1),	\
	in argNarrowedTenantId bigint,	\
	in argNarrowedId bigint,	\
	in argDefaultVisibility char(1),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldRevision int;	\
	declare oldTableId bigint;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldName varchar(192);	\
	declare oldShortName varchar(16);	\
	declare oldLabel varchar(64);	\
	declare oldShortDescription varchar(128);	\
	declare oldDescription varchar(1023);	\
	declare oldRelationTypeId smallint;	\
	declare oldDbName varchar(32);	\
	declare oldSuffix varchar(16);	\
	declare oldFromIndexId bigint;	\
	declare oldToTableId bigint;	\
	declare oldToIndexId bigint;	\
	declare oldIsRequired char(1);	\
	declare oldIsAbstract char(1);	\
	declare oldIsXsdContainer char(1);	\
	declare oldNarrowedTenantId bigint;	\
	declare oldNarrowedId bigint;	\
	declare oldDefaultVisibility char(1);	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				scop.ClassCode,	\
				scop.createdby as createdby,	\
				to_char( scop.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				scop.updatedby as updatedby,	\
				to_char( scop.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			scop.tenantid as tenantid,	\
			scop.id as id,	\
			reld.tableid as tableid,	\
			reld.defschtentid as defschtentid,	\
			reld.defschid as defschid,	\
			reld.name as name,	\
			reld.short_name as short_name,	\
			reld.label as label,	\
			reld.short_descr as short_descr,	\
			reld.descr as descr,	\
			reld.relationtypeid as relationtypeid,	\
			reld.dbname as dbname,	\
			reld.suffix as suffix,	\
			reld.fromindexid as fromindexid,	\
			reld.totableid as totableid,	\
			reld.toindexid as toindexid,	\
			reld.isrequired as isrequired,	\
			reld.isabstract as isabstract,	\
			reld.isxsdcontainer as isxsdcontainer,	\
			reld.narrowedtenantid as narrowedtenantid,	\
			reld.narrowedid as narrowedid,	\
			reld.dflt_vis as dflt_vis,	\
			scop.revision as revision	\
		from cfbam23.reldef as reld	\
			inner join cfbam23.scopedef scop on	\
				reld.tenantid = scop.tenantid	\
				and reld.Id = scop.id	\
		where	\
			reld.tenantid = argTenantId	\
		and reld.id = argId;	\
	begin	\
		if( argClassCode = 'RELD' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateRelation',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateRelation' );	\
			end if;	\
		end if;	\
	\
		select	\
			ClassCode,	\
			TenantId,	\
			Id,	\
			revision	\
		into	\
			oldClassCode,	\
			oldTenantId,	\
			oldId,	\
			oldRevision	\
		from cfbam23.scopedef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			TableId,	\
			Id,	\
			defschtentid,	\
			defschid,	\
			Name,	\
			short_name,	\
			Label,	\
			short_descr,	\
			descr,	\
			RelationTypeId,	\
			DbName,	\
			Suffix,	\
			FromIndexId,	\
			ToTableId,	\
			ToIndexId,	\
			IsRequired,	\
			IsAbstract,	\
			IsXsdContainer,	\
			NarrowedTenantId,	\
			NarrowedId,	\
			dflt_vis	\
		into	\
			oldTenantId,	\
			oldTableId,	\
			oldId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldName,	\
			oldShortName,	\
			oldLabel,	\
			oldShortDescription,	\
			oldDescription,	\
			oldRelationTypeId,	\
			oldDbName,	\
			oldSuffix,	\
			oldFromIndexId,	\
			oldToTableId,	\
			oldToIndexId,	\
			oldIsRequired,	\
			oldIsAbstract,	\
			oldIsXsdContainer,	\
			oldNarrowedTenantId,	\
			oldNarrowedId,	\
			oldDefaultVisibility	\
		from cfbam23.reldef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_reldef() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.reldef	\
		set	\
			tableid = argTableId,	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			name = argName,	\
			short_name = argShortName,	\
			label = argLabel,	\
			short_descr = argShortDescription,	\
			descr = argDescription,	\
			relationtypeid = argRelationTypeId,	\
			dbname = argDbName,	\
			suffix = argSuffix,	\
			fromindexid = argFromIndexId,	\
			totableid = argToTableId,	\
			toindexid = argToIndexId,	\
			isrequired = argIsRequired,	\
			isabstract = argIsAbstract,	\
			isxsdcontainer = argIsXsdContainer,	\
			narrowedtenantid = argNarrowedTenantId,	\
			narrowedid = argNarrowedId,	\
			dflt_vis = argDefaultVisibility	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		if( argClassCode = 'RELD' )	\
		then	\
			insert into cfbam23.reldef_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				tableid,	\
				defschtentid,	\
				defschid,	\
				name,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				relationtypeid,	\
				dbname,	\
				suffix,	\
				fromindexid,	\
				totableid,	\
				toindexid,	\
				isrequired,	\
				isabstract,	\
				isxsdcontainer,	\
				narrowedtenantid,	\
				narrowedid,	\
				dflt_vis,	\
				revision,	\
				auditaction )	\
			select	\
				scop.tenantid,	\
				scop.id,	\
				scop.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				reld.tableid,	\
				reld.defschtentid,	\
				reld.defschid,	\
				reld.name,	\
				reld.short_name,	\
				reld.label,	\
				reld.short_descr,	\
				reld.descr,	\
				reld.relationtypeid,	\
				reld.dbname,	\
				reld.suffix,	\
				reld.fromindexid,	\
				reld.totableid,	\
				reld.toindexid,	\
				reld.isrequired,	\
				reld.isabstract,	\
				reld.isxsdcontainer,	\
				reld.narrowedtenantid,	\
				reld.narrowedid,	\
				reld.dflt_vis,	\
				scop.revision,	\
				2	\
			from cfbam23.reldef as reld	\
			inner join cfbam23.scopedef scop on	\
				reld.tenantid = scop.tenantid	\
				and reld.Id = scop.id	\
			where	\
				reld.tenantid = argTenantId	\
		and reld.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
