--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_clrsubdep1.sql
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


create or replace procedure sp_update_clrsubdep1(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argId bigint,	\
	in argRelationId bigint,	\
	in argContClearTopDepTenantId bigint,	\
	in argContClearTopDepId bigint,	\
	in argName varchar(192),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClassCode varchar(4);	\
	declare oldTenantId bigint;	\
	declare oldId bigint;	\
	declare oldRevision int;	\
	declare oldRelationId bigint;	\
	declare oldContClearTopDepTenantId bigint;	\
	declare oldContClearTopDepId bigint;	\
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
			clrd.relationid as relationid,	\
			clr1.contclrdeptid as contclrdeptid,	\
			clr1.contclrdepid as contclrdepid,	\
			clr1.name as name,	\
			scop.revision as revision	\
		from cfbam23.clrsubdep1 as clr1	\
			inner join cfbam23.clr_dep clrd on	\
				clr1.tenantid = clrd.tenantid	\
				and clr1.Id = clrd.id	\
			inner join cfbam23.scopedef scop on	\
				clrd.tenantid = scop.tenantid	\
				and clrd.Id = scop.id	\
		where	\
			clr1.tenantid = argTenantId	\
		and clr1.id = argId;	\
	begin	\
		if( argClassCode = 'CLR1' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'UpdateClearSubDep1',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for UpdateClearSubDep1' );	\
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
			RelationId	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldRelationId	\
		from cfbam23.clr_dep	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		select	\
			TenantId,	\
			Id,	\
			contclrdeptid,	\
			contclrdepid,	\
			Name	\
		into	\
			oldTenantId,	\
			oldId,	\
			oldContClearTopDepTenantId,	\
			oldContClearTopDepId,	\
			oldName	\
		from cfbam23.clrsubdep1	\
		where	\
			TenantId = argTenantId	\
			and Id = argId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_clrsubdep1() Data collision detected' );	\
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
		update cfbam23.clr_dep	\
		set	\
			relationid = argRelationId	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		update cfbam23.clrsubdep1	\
		set	\
			contclrdeptid = argContClearTopDepTenantId,	\
			contclrdepid = argContClearTopDepId,	\
			name = argName	\
		where	\
			tenantid = argTenantId	\
		and id = argId;	\
	\
		if( argClassCode = 'CLR1' )	\
		then	\
			insert into cfbam23.clrsubdep1_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				relationid,	\
				contclrdeptid,	\
				contclrdepid,	\
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
				clrd.relationid,	\
				clr1.contclrdeptid,	\
				clr1.contclrdepid,	\
				clr1.name,	\
				scop.revision,	\
				2	\
			from cfbam23.clrsubdep1 as clr1	\
			inner join cfbam23.clr_dep clrd on	\
				clr1.tenantid = clrd.tenantid	\
				and clr1.Id = clrd.id	\
			inner join cfbam23.scopedef scop on	\
				clrd.tenantid = scop.tenantid	\
				and clrd.Id = scop.id	\
			where	\
				clr1.tenantid = argTenantId	\
		and clr1.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
