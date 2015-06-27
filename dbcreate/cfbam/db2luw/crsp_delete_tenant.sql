--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_tenant.sql
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

create or replace procedure sp_delete_tenant(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argId bigint,	\
	in argRevision int )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClusterId bigint;	\
	declare oldId bigint;	\
	declare oldTenantName varchar(192);	\
	declare oldRevision int;	\
	declare subret boolean;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select 1 from sysibm.sysdummy1;	\
	begin	\
		select	\
			ClusterId,	\
			Id,	\
			TenantName,	\
			revision	\
		into	\
			oldClusterId,	\
			oldId,	\
			oldTenantName,	\
			oldRevision	\
		from cfbam23.tenant	\
		where	\
			Id = argId	\
		for update;	\
	\
		set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20001, 'Permission denied -- only system user can delete Tenant records' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_tenant() Data collision detected' );	\
		end if;	\
	\
		for cur as	\
			select	\
				reld.tenantid as curTenantId,	\
				reld.id as curId	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.SchemaDefId	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.TableId	\
			where	\
				tent.id = argId	\
		do	\
			update cfbam23.reldef	\
			set	\
				narrowedtenantid = null,	\
				narrowedid = null	\
			where	\
				tenantid = curTenantId	\
				and id = curId;	\
	\
		end for;	\
	\
		for cur as	\
			select	\
				chn.tenantid as tenantid,	\
				chn.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.chain_def chn on 	\
					tbld.tenantid = chn.tenantid	\
					and tbld.id = chn.tableid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_chain_def_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				relc.tenantid as tenantid,	\
				relc.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
				inner join cfbam23.relcol relc on 	\
					reld.tenantid = relc.tenantid	\
					and reld.id = relc.relationid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_relcol_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				reld.tenantid as tenantid,	\
				reld.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
				inner join cfbam23.reldef reld on 	\
					tbld.tenantid = reld.tenantid	\
					and tbld.id = reld.tableid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_reldef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				tbld.tenantid as tenantid,	\
				tbld.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.tbldef tbld on 	\
					schm.tenantid = tbld.tenantid	\
					and schm.id = tbld.schemadefid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tbldef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				valu.tenantid as tenantid,	\
				valu.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
				inner join cfbam23.valdef valu on 	\
					schm.tenantid = valu.tenantid	\
					and schm.id = valu.scopeid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_valdef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				schm.tenantid as tenantid,	\
				schm.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.schemadef schm on 	\
					tent.id = schm.tenantid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_schemadef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				tdom.tenantid as tenantid,	\
				tdom.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tlddef gtld on 	\
					tent.id = gtld.tenantid	\
				inner join cfbam23.tdomdef tdom on 	\
					gtld.tenantid = tdom.tenantid	\
					and gtld.tldid = tdom.tldid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tdomdef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				gtld.tenantid as tenantid,	\
				gtld.tldid as tldid	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tlddef gtld on 	\
					tent.id = gtld.tenantid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tlddef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					tldid );	\
		end for;	\
	\
		for cur as	\
			select	\
				bdom.tenantid as tenantid,	\
				bdom.id as id	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.bdomdef bdom on 	\
					tent.id = bdom.tenantid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_bdomdef_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					id );	\
		end for;	\
	\
		for cur as	\
			select	\
				tgnc.tenantid as tenantid,	\
				tgnc.tsecgrpincid as tsecgrpincid	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tsecgrp tgrp on 	\
					tent.id = tgrp.tenantid	\
				inner join cfbam23.tsecinc tgnc on 	\
					tgrp.tenantid = tgnc.tenantid	\
					and tgrp.tsecgroupid = tgnc.incgrpid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tsecinc_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					tsecgrpincid );	\
		end for;	\
	\
		for cur as	\
			select	\
				tgmb.tenantid as tenantid,	\
				tgmb.tsecgroupmemberid as tsecgroupmemberid	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tsecgrp tgrp on 	\
					tent.id = tgrp.tenantid	\
				inner join cfbam23.tsecmemb tgmb on 	\
					tgrp.tenantid = tgmb.tenantid	\
					and tgrp.tsecgroupid = tgmb.tsecgroupid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tsecmemb_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					tsecgroupmemberid );	\
		end for;	\
	\
		for cur as	\
			select	\
				tgnc.tenantid as tenantid,	\
				tgnc.tsecgrpincid as tsecgrpincid	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tsecgrp tgrp on 	\
					tent.id = tgrp.tenantid	\
				inner join cfbam23.tsecinc tgnc on 	\
					tgrp.tenantid = tgnc.tenantid	\
					and tgrp.tsecgroupid = tgnc.tsecgrpid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tsecinc_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					tsecgrpincid );	\
		end for;	\
	\
		for cur as	\
			select	\
				tgrp.tenantid as tenantid,	\
				tgrp.tsecgroupid as tsecgroupid	\
			from cfbam23.tenant as tent	\
				inner join cfbam23.tsecgrp tgrp on 	\
					tent.id = tgrp.tenantid	\
			where	\
				tent.id = argId	\
		do	\
			call sp_delete_tsecgrp_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					tenantid,	\
					tsecgroupid );	\
		end for;	\
	\
		insert into cfbam23.tenant_h (	\
				id,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				clusterid,	\
				tenantname,	\
			revision,	\
			auditaction )	\
		select	\
				tent.id,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				tent.clusterid,	\
				tent.tenantname,	\
			tent.revision + 1,	\
			3	\
		from cfbam23.tenant as tent	\
		where	\
			tent.id = argId;	\
	\
		delete from cfbam23.tenant	\
		where	\
			id = argId;	\
	\
		open retcursor;	\
	end;	\
end
