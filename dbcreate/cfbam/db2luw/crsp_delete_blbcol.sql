--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_blbcol.sql
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

create or replace procedure sp_delete_blbcol(	\
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
	declare oldMaxLen integer;	\
	declare oldInitValue clob(16384);	\
	declare oldDefaultValue clob(16384);	\
	declare oldNullValue clob(16384);	\
	declare oldUnknownValue clob(16384);	\
	declare oldTableId bigint;	\
	declare subret boolean;	\
	declare varTenantId bigint;	\
	declare varTableId bigint;	\
	declare varClassCode varchar(4);	\
	declare varprevClassCode varchar(4);	\
	declare varnextClassCode varchar(4);	\
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
			TableId	\
		into	\
			varTenantId,	\
			varTableId	\
		from cfbam23.blbcol	\
		where	\
			TenantId = argTenantId	\
			and Id = argId;	\
	\
		update cfbam23.scopedef	\
		set revision = revision + 1	\
		where	\
			TenantId = varTenantId	\
		and Id = varTableId;	\
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
			MaxLen,	\
			InitVal,	\
			DefVal,	\
			NullVal,	\
			UnknownVal	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldMaxLen,	\
			oldInitValue,	\
			oldDefaultValue,	\
			oldNullValue,	\
			oldUnknownValue	\
		from cfbam23.blbdef	\
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
		from cfbam23.blbcol	\
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
				'DeleteBlobCol',	\
				argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for DeleteBlobCol' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_blbcol() Data collision detected' );	\
		end if;	\
	\
		select	\
			valu.classcode as thisclasscode,	\
			prvvalu.classcode as prvclasscode,	\
			valu.PrevTenantId as prvPrevTenantId,	\
			valu.PrevId as prvPrevId,	\
			nxtvalu.classcode as nxtclasscode,	\
			valu.NextTenantId as nxtNextTenantId,	\
			valu.NextId as nxtNextId	\
		into	\
			varClassCode,	\
			varprevClassCode,	\
			varprevTenantId,	\
			varprevId,	\
			varnextClassCode,	\
			varnextTenantId,	\
			varnextId	\
		from cfbam23.valdef valu	\
			left outer join cfbam23.valdef prvvalu on	\
				prvvalu.TenantId = valu.PrevTenantId	\
				and prvvalu.Id = valu.PrevId	\
			left outer join cfbam23.valdef nxtvalu on	\
				nxtvalu.TenantId = valu.NextTenantId	\
				and nxtvalu.Id = valu.NextId	\
		where	\
			valu.TenantId = argTenantId	\
			and valu.Id = argId;	\
	\
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
		if( varnextTenantId is not null )	\
		then	\
			update cfbam23.valdef	\
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
			call sp_audit_valdef( argAuditClusterId,	\
				argAuditUserId,	\
				argAuditSessionId,	\
				secClusterId,	\
				secTenantId,	\
				varnextClassCode,	\
				varnextTenantId,	\
				varnextId,	\
				2 );	\
		end if;	\
	\
		if( oldClassCode = 'BLBC' )	\
		then	\
			insert into cfbam23.blbcol_h (	\
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
				initval,	\
				defval,	\
				nullval,	\
				unknownval,	\
				tableid,	\
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
				blbd.maxlen,	\
				blbd.initval,	\
				blbd.defval,	\
				blbd.nullval,	\
				blbd.unknownval,	\
				blbc.tableid,	\
				valu.revision + 1,	\
				3	\
			from cfbam23.blbcol as blbc	\
			inner join cfbam23.blbdef blbd on	\
				blbc.tenantid = blbd.tenantid	\
				and blbc.Id = blbd.id	\
			inner join cfbam23.atomdef atom on	\
				blbd.tenantid = atom.tenantid	\
				and blbd.Id = atom.id	\
			inner join cfbam23.valdef valu on	\
				atom.tenantid = valu.tenantid	\
				and atom.Id = valu.id	\
			where	\
				blbc.tenantid = argTenantId	\
		and blbc.id = argId;	\
		end if;	\
	\
		delete from cfbam23.blbcol	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
		delete from cfbam23.blbdef	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
		delete from cfbam23.atomdef	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
		delete from cfbam23.valdef	\
		where	\
			tenantid = argTenantId	\
			and id = argId;	\
	\
	\
	\
	\
		update cfbam23.scopedef	\
		set revision = revision - 1	\
		where	\
			TenantId = varTenantId	\
		and Id = varTableId;	\
	\
		open retcursor;	\
	end;	\
end
