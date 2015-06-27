--
--	@(#) dbcreate/cfbam/db2luw/crsp_movedown_enumcol.sql
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


create or replace procedure sp_movedown_enumcol(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argTenantId bigint,	\
	in argId bigint,	\
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
	declare oldInitValue smallint;	\
	declare oldDefaultValue smallint;	\
	declare oldMinValue smallint;	\
	declare oldMaxValue smallint;	\
	declare oldNullValue smallint;	\
	declare oldUnknownValue smallint;	\
	declare oldTableId bigint;	\
	declare permissionFlag integer;	\
	declare isSystemUser integer;	\
	declare varTenantId bigint;	\
	declare varScopeId bigint;	\
	declare varClassCode varchar(4);	\
	declare varprevClassCode varchar(4);	\
	declare varnextClassCode varchar(4);	\
	declare gnextClassCode varchar(4);	\
	declare varprevTenantId bigint;	\
	declare varprevId bigint;	\
	declare varnextTenantId bigint;	\
	declare varnextId bigint;	\
	declare gnextTenantId bigint;	\
	declare gnextId bigint;	\
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
			i16d.initval as initval,	\
			i16d.defval as defval,	\
			i16d.minval as minval,	\
			i16d.maxval as maxval,	\
			i16d.nullvalue as nullvalue,	\
			i16d.unknownval as unknownval,	\
			enmc.tableid as tableid,	\
			valu.revision as revision	\
		from cfbam23.enumcol as enmc	\
			inner join cfbam23.enumdef enmd on	\
				enmc.tenantid = enmd.tenantid	\
				and enmc.Id = enmd.id	\
			inner join cfbam23.int16def i16d on	\
				enmd.tenantid = i16d.tenantid	\
				and enmd.Id = i16d.id	\
			inner join cfbam23.atomdef atom on	\
				i16d.tenantid = atom.tenantid	\
				and i16d.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
		where	\
			enmc.tenantid = argTenantId	\
		and enmc.id = argId;	\
	begin	\
		select	\
			TenantId,	\
			ScopeId	\
		into	\
			varTenantId,	\
			varScopeId	\
		from cfbam23.valdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			TenantId = varTenantId	\
			and Id = varScopeId;	\
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
		from cfbam23.int16def	\
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
		from cfbam23.enumdef	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id,	\
			TableId	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldTableId	\
		from cfbam23.enumcol	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_movedown_enumcol() Data collision detected' );	\
		end if;	\
	\
		set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
				'UpdateEnumCol',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not in TSecGroup for UpdateEnumCol' );	\
		end if;	\
	\
		select	\
			valu.classcode as thisclasscode,	\
			prvvalu.classcode as prvclasscode,	\
			valu.PrevTenantId as prvPrevTenantId,	\
			valu.PrevId as prvPrevId,	\
			nxtvalu.classcode as nxtclasscode,	\
			valu.NextTenantId as nxtNextTenantId,	\
			valu.NextId as nxtNextId,	\
			gnxtvalu.classcode as gnxtclasscode,	\
			nxtvalu.NextTenantId as gnxtNextTenantId,	\
			nxtvalu.NextId as gnxtNextId	\
		into	\
			varClassCode,	\
			varprevClassCode,	\
			varprevTenantId,	\
			varprevId,	\
			varnextClassCode,	\
			varnextTenantId,	\
			varnextId,	\
			gnextClassCode,	\
			gnextTenantId,	\
			gnextId	\
		from cfbam23.valdef valu	\
			left outer join cfbam23.valdef prvvalu on	\
				prvvalu.TenantId = valu.PrevTenantId	\
				and prvvalu.Id = valu.PrevId	\
			left outer join cfbam23.valdef nxtvalu on	\
				nxtvalu.TenantId = valu.NextTenantId	\
				and nxtvalu.Id = valu.NextId	\
			left outer join cfbam23.valdef gnxtvalu on	\
				gnxtvalu.TenantId = nxtvalu.NextTenantId	\
				and gnxtvalu.Id = nxtvalu.NextId	\
		where	\
			valu.TenantId = argTenantId	\
			and valu.Id = argId;	\
	\
		if( varnextTenantId is not null )	\
		then	\
			if( varprevTenantId is not null )	\
			then	\
				update cfbam23.valdef	\
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
				call sp_audit_valdef( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					varprevClassCode,	\
					varprevTenantId,	\
					varprevId,	\
					2 );	\
			end if;	\
	\
			update cfbam23.valdef	\
			set	\
				revision = revision + 1,	\
				updatedby = argAuditUserId,	\
				updatedat = current timestamp,	\
				PrevTenantId = varprevTenantId,	\
				PrevId = varprevId,	\
				NextTenantId = argTenantId,	\
				NextId = argId	\
			where	\
				TenantId = varnextTenantId	\
				and Id = varnextId;	\
	\
			call sp_audit_valdef( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				varnextClassCode,	\
				varnextTenantId,	\
				varnextId,	\
				2 );	\
	\
			update cfbam23.valdef	\
			set	\
				revision = revision + 1,	\
				updatedby = argAuditUserId,	\
				updatedat = current timestamp,	\
				PrevTenantId = varnextTenantId,	\
				PrevId = varnextId,	\
				NextTenantId = gnextTenantId,	\
				NextId = gnextId	\
			where	\
				TenantId = argTenantId	\
				and Id = argId;	\
	\
			call sp_audit_valdef( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				varClassCode,	\
				argTenantId,	\
				argId,	\
				2 );	\
	\
			if( gnextTenantId is not null )	\
			then	\
				update cfbam23.valdef	\
				set	\
					revision = revision + 1,	\
					updatedby = argAuditUserId,	\
					updatedat = current timestamp,	\
					PrevTenantId = argTenantId,	\
					PrevId = argId	\
				where	\
					TenantId = gnextTenantId	\
					and Id = gnextId;	\
	\
				call sp_audit_valdef( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					gnextClassCode,	\
					gnextTenantId,	\
					gnextId,	\
					2 );	\
			end if;	\
	\
		end if;	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			TenantId = varTenantId	\
			and Id = varScopeId;	\
	\
		open retcursor;	\
	end;	\
end
