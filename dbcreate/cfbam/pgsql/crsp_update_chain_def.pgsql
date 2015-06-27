--
--	@(#) dbcreate/cfbam/pgsql/crsp_update_chain_def.pgsql
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


create or replace function cfbam23.sp_update_chain_def(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argClassCode varchar(4),
	argTenantId bigint,
	argId bigint,
	argDefSchemaTenantId bigint,
	argDefSchemaId bigint,
	argName varchar(192),
	argShortName varchar(16),
	argLabel varchar(64),
	argShortDescription varchar(128),
	argDescription varchar(1023),
	argTableId bigint,
	argSuffix varchar(16),
	argPrevRelationTenantId bigint,
	argPrevRelationId bigint,
	argNextRelationTenantId bigint,
	argNextRelationId bigint,
	argDefaultVisibility boolean,
	argRevision integer )
returns setof cfbam23.type_chain_def_rec as $$
declare
	RowsAffected integer;
	oldTenantId bigint;
	oldId bigint;
	oldDefSchemaTenantId bigint;
	oldDefSchemaId bigint;
	oldName varchar(192);
	oldShortName varchar(16);
	oldLabel varchar(64);
	oldShortDescription varchar(128);
	oldDescription varchar(1023);
	oldTableId bigint;
	oldSuffix varchar(16);
	oldPrevRelationTenantId bigint;
	oldPrevRelationId bigint;
	oldNextRelationTenantId bigint;
	oldNextRelationId bigint;
	oldDefaultVisibility boolean;
	oldRevision int;
	permissionFlag boolean;
begin
	if( argClassCode = 'CHN' )
	then
		select cfbam23.sp_is_tenant_user( argTenantId,
			'UpdateChain',
			argAuditUserId )
		into permissionFlag;
		if( permissionFlag = false )
		then
			raise exception 'Permission denied -- User not found in tenant TSecGroup for UpdateChain';
		end if;
	end if;

		select
			TenantId,
			Id,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			TableId,
			Suffix,
			prvreltentid,
			PrevRelationId,
			nxtreltentid,
			NextRelationId,
			dflt_vis,
			revision
		into
			oldTenantId,
			oldId,
			oldDefSchemaTenantId,
			oldDefSchemaId,
			oldName,
			oldShortName,
			oldLabel,
			oldShortDescription,
			oldDescription,
			oldTableId,
			oldSuffix,
			oldPrevRelationTenantId,
			oldPrevRelationId,
			oldNextRelationTenantId,
			oldNextRelationId,
			oldDefaultVisibility,
			oldRevision
		from cfbam23.chain_def
		where
			TenantId = argTenantId
			and Id = argId
		for update;


	if argRevision != oldRevision
	then
		raise exception 'sp_update_chain_def() Data collision detected';
	end if;


	update cfbam23.chain_def
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = now(),
		defschtentid = argDefSchemaTenantId,
		defschid = argDefSchemaId,
		name = argName,
		short_name = argShortName,
		label = argLabel,
		short_descr = argShortDescription,
		descr = argDescription,
		tableid = argTableId,
		suffix = argSuffix,
		prvreltentid = argPrevRelationTenantId,
		prevrelationid = argPrevRelationId,
		nxtreltentid = argNextRelationTenantId,
		nextrelationid = argNextRelationId,
		dflt_vis = argDefaultVisibility
	where
		TenantId = argTenantId
			and Id = argId
		and revision = oldRevision;

	get diagnostics RowsAffected = row_count;

	if RowsAffected != 1
	then
		raise exception 'sp_update_chain_def() Expected to affect one chain_def row, not %', RowsAffected;
	end if;


	insert into cfbam23.chain_def_h (
			TenantId,
			Id,
			auditclusterid,
			auditsessionid,
			auditstamp,
			defschtentid,
			defschid,
			Name,
			short_name,
			Label,
			short_descr,
			descr,
			TableId,
			Suffix,
			prvreltentid,
			PrevRelationId,
			nxtreltentid,
			NextRelationId,
			dflt_vis,
			revision,
			auditaction )
		select
			chn.TenantId,
			chn.Id,
			argAuditClusterId,
			argAuditSessionId,
			now(),
			chn.defschtentid,
			chn.defschid,
			chn.Name,
			chn.short_name,
			chn.Label,
			chn.short_descr,
			chn.descr,
			chn.TableId,
			chn.Suffix,
			chn.prvreltentid,
			chn.PrevRelationId,
			chn.nxtreltentid,
			chn.NextRelationId,
			chn.dflt_vis,
			argRevision + 1,
			2
		from cfbam23.chain_def as chn
		where
			chn.tenantid = argTenantId
			and chn.id = argId;
	return query select
			chn.createdby,
			to_char( chn.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			chn.updatedby,
			to_char( chn.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			chn.tenantid as tenantid,
			chn.id as id,
			chn.defschtentid as defschtentid,
			chn.defschid as defschid,
			chn.name as name,
			chn.short_name as short_name,
			chn.label as label,
			chn.short_descr as short_descr,
			chn.descr as descr,
			chn.tableid as tableid,
			chn.suffix as suffix,
			chn.prvreltentid as prvreltentid,
			chn.prevrelationid as prevrelationid,
			chn.nxtreltentid as nxtreltentid,
			chn.nextrelationid as nextrelationid,
			chn.dflt_vis as dflt_vis,
		chn.revision as revision
	from cfbam23.chain_def as chn
	where
		chn.tenantid = argTenantId
			and chn.id = argId;

	return;
end;
$$ language plpgsql;
