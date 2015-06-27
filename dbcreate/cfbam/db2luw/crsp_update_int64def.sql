--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_int64def.sql
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


create or replace procedure sp_update_int64def(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argScopeId bigint,	\
	in argId bigint,	\
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
	in argInitValue bigint,	\
	in argDefaultValue bigint,	\
	in argMinValue bigint,	\
	in argMaxValue bigint,	\
	in argNullValue bigint,	\
	in argUnknownValue bigint,	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldScopeId bigint;	\
	declare oldId bigint;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldName varchar(192);	\
	declare oldShortName varchar(16);	\
	declare oldLabel varchar(64);	\
	declare oldShortDescription varchar(128);	\
	declare oldDescription varchar(1023);	\
	declare oldIsNullable char(1);	\
	declare oldGenerateId char(1);	\
	declare oldDataScopeId smallint;	\
	declare oldViewAccessSecurityId smallint;	\
	declare oldEditAccessSecurityId smallint;	\
	declare oldViewAccessFrequencyId smallint;	\
	declare oldEditAccessFrequencyId smallint;	\
	declare oldPrevTenantId bigint;	\
	declare oldPrevId bigint;	\
	declare oldNextTenantId bigint;	\
	declare oldNextId bigint;	\
	declare oldDefaultVisibility char(1);	\
	declare oldRevision int;	\
	declare oldDbName varchar(32);	\
	declare oldInitValue bigint;	\
	declare oldDefaultValue bigint;	\
	declare oldMinValue bigint;	\
	declare oldMaxValue bigint;	\
	declare oldNullValue bigint;	\
	declare oldUnknownValue bigint;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
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
			i64d.initval as initval,	\
			i64d.defval as defval,	\
			i64d.minval as minval,	\
			i64d.maxval as maxval,	\
			i64d.nullvalue as nullvalue,	\
			i64d.unknownval as unknownval,	\
			valu.revision as revision	\
		from cfbam23.int64def as i64d	\
			inner join cfbam23.atomdef atom on	\
				i64d.tenantid = atom.tenantid	\
				and i64d.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
		where	\
			i64d.tenantid = argTenantId	\
		and i64d.id = argId;	\
	begin	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			tenantid = argTenantId	\
			and id = argScopeId;	\
	\
		if( argClassCode = 'I64D' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateInt64Def',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateInt64Def' );	\
			end if;	\
		end if;	\
	\
		select	\
			ClassCode,	\
			TenantId,	\
			ScopeId,	\
			Id,	\
			defschtentid,	\
			defschid,	\
			Name,	\
			short_name,	\
			Label,	\
			short_descr,	\
			descr,	\
			IsNullable,	\
			GenerateId,	\
			DataScopeId,	\
			VASecId,	\
			EASecId,	\
			VAFId,	\
			EAFId,	\
			PrevTenantId,	\
			PrevId,	\
			NextTenantId,	\
			NextId,	\
			dflt_vis,	\
			revision	\
		into	\
			oldClassCode,	\
			oldTenantId,	\
			oldScopeId,	\
			oldId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldName,	\
			oldShortName,	\
			oldLabel,	\
			oldShortDescription,	\
			oldDescription,	\
			oldIsNullable,	\
			oldGenerateId,	\
			oldDataScopeId,	\
			oldViewAccessSecurityId,	\
			oldEditAccessSecurityId,	\
			oldViewAccessFrequencyId,	\
			oldEditAccessFrequencyId,	\
			oldPrevTenantId,	\
			oldPrevId,	\
			oldNextTenantId,	\
			oldNextId,	\
			oldDefaultVisibility,	\
			oldRevision	\
		from cfbam23.valdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id,	\
			DbName	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldDbName	\
		from cfbam23.atomdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id,	\
			InitVal,	\
			DefVal,	\
			MinVal,	\
			MaxVal,	\
			NullValue,	\
			UnknownVal	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldInitValue,	\
			oldDefaultValue,	\
			oldMinValue,	\
			oldMaxValue,	\
			oldNullValue,	\
			oldUnknownValue	\
		from cfbam23.int64def	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_int64def() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.valdef	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			scopeid = argScopeId,	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			name = argName,	\
			short_name = argShortName,	\
			label = argLabel,	\
			short_descr = argShortDescription,	\
			descr = argDescription,	\
			isnullable = argIsNullable,	\
			generateid = argGenerateId,	\
			datascopeid = argDataScopeId,	\
			vasecid = argViewAccessSecurityId,	\
			easecid = argEditAccessSecurityId,	\
			vafid = argViewAccessFrequencyId,	\
			eafid = argEditAccessFrequencyId,	\
			prevtenantid = argPrevTenantId,	\
			previd = argPrevId,	\
			nexttenantid = argNextTenantId,	\
			nextid = argNextId,	\
			dflt_vis = argDefaultVisibility	\
		where	\
			tenantid = argTenantId	\
		and id = argId	\
		and revision = argRevision;	\
	\
		update cfbam23.atomdef	\
		set	\
			dbname = argDbName	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		update cfbam23.int64def	\
		set	\
			initval = argInitValue,	\
			defval = argDefaultValue,	\
			minval = argMinValue,	\
			maxval = argMaxValue,	\
			nullvalue = argNullValue,	\
			unknownval = argUnknownValue	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			tenantid = argTenantId	\
			and id = argScopeId;	\
	\
		if( argClassCode = 'I64D' )	\
		then	\
			insert into cfbam23.int64def_h (	\
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
				initval,	\
				defval,	\
				minval,	\
				maxval,	\
				nullvalue,	\
				unknownval,	\
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
				i64d.initval,	\
				i64d.defval,	\
				i64d.minval,	\
				i64d.maxval,	\
				i64d.nullvalue,	\
				i64d.unknownval,	\
				valu.revision,	\
				2	\
			from cfbam23.int64def as i64d	\
			inner join cfbam23.atomdef atom on	\
				i64d.tenantid = atom.tenantid	\
				and i64d.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
			where	\
				i64d.tenantid = argTenantId	\
		and i64d.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
