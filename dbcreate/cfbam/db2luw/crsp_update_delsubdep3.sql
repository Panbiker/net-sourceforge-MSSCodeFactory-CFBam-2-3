--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_delsubdep3.sql
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


create or replace procedure sp_update_delsubdep3(	\
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
	in argRelationTenantId bigint,	\
	in argRelationId bigint,	\
	in argContTenantId bigint,	\
	in argContDelDep2Id bigint,	\
	in argName varchar(192),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldRevision int;	\
	declare oldDefSchemaTenantId bigint;	\
	declare oldDefSchemaId bigint;	\
	declare oldRelationTenantId bigint;	\
	declare oldRelationId bigint;	\
	declare oldContTenantId bigint;	\
	declare oldContDelDep2Id bigint;	\
	declare oldName varchar(192);	\
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
			deld.defschtentid as defschtentid,	\
			deld.defschid as defschid,	\
			deld.relationtenantid as relationtenantid,	\
			deld.relationid as relationid,	\
			del3.conttenantid as conttenantid,	\
			del3.contdeldep2id as contdeldep2id,	\
			del3.name as name,	\
			scop.revision as revision	\
		from cfbam23.delsubdep3 as del3	\
			inner join cfbam23.del_dep deld on	\
				del3.tenantid = deld.tenantid	\
				and del3.Id = deld.id	\
			inner join cfbam23.scopedef scop on	\
				deld.tenantid = scop.tenantid	\
				and deld.Id = scop.id	\
		where	\
			del3.tenantid = argTenantId	\
		and del3.id = argId;	\
	begin	\
		if( argClassCode = 'DEL3' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateDelSubDep3',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateDelSubDep3' );	\
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
			Id,	\
			defschtentid,	\
			defschid,	\
			RelationTenantId,	\
			RelationId	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldDefSchemaTenantId,	\
			oldDefSchemaId,	\
			oldRelationTenantId,	\
			oldRelationId	\
		from cfbam23.del_dep	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id,	\
			ContTenantId,	\
			contdeldep2id,	\
			Name	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldContTenantId,	\
			oldContDelDep2Id,	\
			oldName	\
		from cfbam23.delsubdep3	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_delsubdep3() Data collision detected' );	\
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
		update cfbam23.del_dep	\
		set	\
			defschtentid = argDefSchemaTenantId,	\
			defschid = argDefSchemaId,	\
			relationtenantid = argRelationTenantId,	\
			relationid = argRelationId	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		update cfbam23.delsubdep3	\
		set	\
			conttenantid = argContTenantId,	\
			contdeldep2id = argContDelDep2Id,	\
			name = argName	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		if( argClassCode = 'DEL3' )	\
		then	\
			insert into cfbam23.delsubdep3_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				defschtentid,	\
				defschid,	\
				relationtenantid,	\
				relationid,	\
				conttenantid,	\
				contdeldep2id,	\
				name,	\
				revision,	\
				auditaction )	\
			select	\
				scop.tenantid,	\
				scop.id,	\
				scop.classcode,	\
				argAuditClusterId,	\
				argAuditSessionId,	\
				current timestamp,	\
				deld.defschtentid,	\
				deld.defschid,	\
				deld.relationtenantid,	\
				deld.relationid,	\
				del3.conttenantid,	\
				del3.contdeldep2id,	\
				del3.name,	\
				scop.revision,	\
				2	\
			from cfbam23.delsubdep3 as del3	\
			inner join cfbam23.del_dep deld on	\
				del3.tenantid = deld.tenantid	\
				and del3.Id = deld.id	\
			inner join cfbam23.scopedef scop on	\
				deld.tenantid = scop.tenantid	\
				and deld.Id = scop.id	\
			where	\
				del3.tenantid = argTenantId	\
		and del3.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end