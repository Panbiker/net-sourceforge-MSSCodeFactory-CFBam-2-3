--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_strtyp.sql
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

create or replace procedure sp_create_strtyp(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argScopeId bigint,	\
	in argDefSchemaTenantId bigint,	\
	in argDefSchemaId bigint,	\
	in argName varchar(192),	\
	in argShortName varchar(16),	\
	in argLabel varchar(64),	\
	in argShortDescription varchar(128),	\
	in argDescription varchar(1023),	\
	in argIsNullable char(1),	\
	in argGenerateId char(1),	\
	in argDataScopeId smallint,	\
	in argViewAccessSecurityId smallint,	\
	in argEditAccessSecurityId smallint,	\
	in argViewAccessFrequencyId smallint,	\
	in argEditAccessFrequencyId smallint,	\
	in argPrevTenantId bigint,	\
	in argPrevId bigint,	\
	in argNextTenantId bigint,	\
	in argNextId bigint,	\
	in argDefaultVisibility char(1),	\
	in argDbName varchar(32),	\
	in argMaxLen integer,	\
	in argShowLines smallint,	\
	in argInitValue varchar(500),	\
	in argDefaultValue varchar(500),	\
	in argNullValue varchar(500),	\
	in argUnknownValue varchar(500),	\
	in argSchemaDefId bigint )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare permissionFlag integer;	\
		declare argId bigint;	\
	\
	declare prevClassCode varchar(4);	\
	declare prevPrevTenantId bigint;	\
	declare prevPrevId bigint;	declare retcursor cursor with return to client for	\
		select	\
				valu.ClassCode,	\
				valu.createdby as createdby,	\
				to_char( valu.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				valu.updatedby as updatedby,	\
				to_char( valu.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			valu.tenantid as tenantid,	\
			valu.scopeid as scopeid,	\
			valu.id as id,	\
			valu.defschtentid as defschtentid,	\
			valu.defschid as defschid,	\
			valu.name as name,	\
			valu.short_name as short_name,	\
			valu.label as label,	\
			valu.short_descr as short_descr,	\
			valu.descr as descr,	\
			valu.isnullable as isnullable,	\
			valu.generateid as generateid,	\
			valu.datascopeid as datascopeid,	\
			valu.vasecid as vasecid,	\
			valu.easecid as easecid,	\
			valu.vafid as vafid,	\
			valu.eafid as eafid,	\
			valu.prevtenantid as prevtenantid,	\
			valu.previd as previd,	\
			valu.nexttenantid as nexttenantid,	\
			valu.nextid as nextid,	\
			valu.dflt_vis as dflt_vis,	\
			atom.dbname as dbname,	\
			strd.maxlen as maxlen,	\
			strd.showlines as showlines,	\
			strd.initval as initval,	\
			strd.defval as defval,	\
			strd.nullvalue as nullvalue,	\
			strd.unknownval as unknownval,	\
			strt.schemadefid as schemadefid,	\
			valu.revision as revision	\
		from cfbam23.strtyp as strt	\
			inner join cfbam23.strdef strd on	\
				strt.tenantid = strd.tenantid	\
				and strt.Id = strd.id	\
			inner join cfbam23.atomdef atom on	\
				strd.tenantid = atom.tenantid	\
				and strd.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
		where	\
			strt.tenantid = argTenantId	\
		and strt.id = argId;	\
	begin	\
		if( argClassCode = 'STRT' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'CreateStringType',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateStringType' );	\
			end if;	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argSchemaDefId;	\
	\
		select	\
			valu.tenantid as tenantid,	\
			valu.id as id,	\
			valu.classcode	\
		into	\
			prevPrevTenantId,	\
			prevPrevId,	\
			prevClassCode	\
		from cfbam23.valdef valu	\
		where	\
			valu.tenantid = argTenantId	\
			and valu.scopeid = argScopeId	\
			and valu.nexttenantid is null	\
			and valu.nextid is null;	\
	\
		call sp_next_valueidgen( argTenantId,	\
			argId );	\
		insert into cfbam23.valdef(	\
			classcode,	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			tenantid,	\
			scopeid,	\
			id,	\
			defschtentid,	\
			defschid,	\
			name,	\
			short_name,	\
			label,	\
			short_descr,	\
			descr,	\
			isnullable,	\
			generateid,	\
			datascopeid,	\
			vasecid,	\
			easecid,	\
			vafid,	\
			eafid,	\
			prevtenantid,	\
			previd,	\
			nexttenantid,	\
			nextid,	\
			dflt_vis,	\
			revision )	\
		values (	\
			argClassCode,	\
		argAuditUserId,	\
			current timestamp,	\
			argAuditUserId,	\
			current timestamp,	\
			argTenantId,	\
			argScopeId,	\
			argId,	\
			argDefSchemaTenantId,	\
			argDefSchemaId,	\
			argName,	\
			argShortName,	\
			argLabel,	\
			argShortDescription,	\
			argDescription,	\
			argIsNullable,	\
			argGenerateId,	\
			argDataScopeId,	\
			argViewAccessSecurityId,	\
			argEditAccessSecurityId,	\
			argViewAccessFrequencyId,	\
			argEditAccessFrequencyId,	\
			prevPrevTenantId,	\
			prevPrevId,	\
			null,	\
			null,	\
			argDefaultVisibility,	\
			1 );	\
	\
		insert into cfbam23.atomdef(	\
			tenantid,	\
			id,	\
			dbname )	\
		values (	\
			argTenantId,	\
			argId,	\
			argDbName );	\
	\
		insert into cfbam23.strdef(	\
			tenantid,	\
			id,	\
			maxlen,	\
			showlines,	\
			initval,	\
			defval,	\
			nullvalue,	\
			unknownval )	\
		values (	\
			argTenantId,	\
			argId,	\
			argMaxLen,	\
			argShowLines,	\
			argInitValue,	\
			argDefaultValue,	\
			argNullValue,	\
			argUnknownValue );	\
	\
		insert into cfbam23.strtyp(	\
			tenantid,	\
			id,	\
			schemadefid )	\
		values (	\
			argTenantId,	\
			argId,	\
			argSchemaDefId );	\
	\
		if( argClassCode = 'STRT' )	\
		then	\
			insert into cfbam23.strtyp_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				scopeid,	\
				defschtentid,	\
				defschid,	\
				name,	\
				short_name,	\
				label,	\
				short_descr,	\
				descr,	\
				isnullable,	\
				generateid,	\
				datascopeid,	\
				vasecid,	\
				easecid,	\
				vafid,	\
				eafid,	\
				prevtenantid,	\
				previd,	\
				nexttenantid,	\
				nextid,	\
				dflt_vis,	\
				dbname,	\
				maxlen,	\
				showlines,	\
				initval,	\
				defval,	\
				nullvalue,	\
				unknownval,	\
				schemadefid,	\
				revision,	\
				auditaction )	\
			select	\
				valu.tenantid,	\
				valu.id,	\
				valu.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				valu.scopeid,	\
				valu.defschtentid,	\
				valu.defschid,	\
				valu.name,	\
				valu.short_name,	\
				valu.label,	\
				valu.short_descr,	\
				valu.descr,	\
				valu.isnullable,	\
				valu.generateid,	\
				valu.datascopeid,	\
				valu.vasecid,	\
				valu.easecid,	\
				valu.vafid,	\
				valu.eafid,	\
				valu.prevtenantid,	\
				valu.previd,	\
				valu.nexttenantid,	\
				valu.nextid,	\
				valu.dflt_vis,	\
				atom.dbname,	\
				strd.maxlen,	\
				strd.showlines,	\
				strd.initval,	\
				strd.defval,	\
				strd.nullvalue,	\
				strd.unknownval,	\
				strt.schemadefid,	\
				valu.revision,	\
				1	\
			from cfbam23.strtyp as strt	\
			inner join cfbam23.strdef strd on	\
				strt.tenantid = strd.tenantid	\
				and strt.Id = strd.id	\
			inner join cfbam23.atomdef atom on	\
				strd.tenantid = atom.tenantid	\
				and strd.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
			where	\
				strt.tenantid = argTenantId	\
		and strt.id = argId;	\
		end if;	\
	\
		if( prevPrevTenantId is not null )	\
		then	\
			update cfbam23.valdef	\
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
			call sp_audit_valdef( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				prevClassCode,	\
				prevPrevTenantId,	\
				prevPrevId,	\
				2 );	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			tenantid = argTenantId	\
			and id = argSchemaDefId;	\
	\
		open retcursor;	\
	end;	\
end
