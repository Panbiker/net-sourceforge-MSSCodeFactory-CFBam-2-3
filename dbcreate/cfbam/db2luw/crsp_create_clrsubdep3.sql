--
--	@(#) dbcreate/cfbam/db2luw/crsp_create_clrsubdep3.sql
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

create or replace procedure sp_create_clrsubdep3(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argTenantId bigint,	\
	in argRelationId bigint,	\
	in argContClearDep2TenantId bigint,	\
	in argContClearDep2Id bigint,	\
	in argName varchar(192) )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare permissionFlag integer;	\
		declare argId bigint;	\
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
			clr3.contclrdep2tid as contclrdep2tid,	\
			clr3.contclrdep2id as contclrdep2id,	\
			clr3.name as name,	\
			scop.revision as revision	\
		from cfbam23.clrsubdep3 as clr3	\
			inner join cfbam23.clr_dep clrd on	\
				clr3.tenantid = clrd.tenantid	\
				and clr3.Id = clrd.id	\
			inner join cfbam23.scopedef scop on	\
				clrd.tenantid = scop.tenantid	\
				and clrd.Id = scop.id	\
		where	\
			clr3.tenantid = argTenantId	\
		and clr3.id = argId;	\
	begin	\
		if( argClassCode = 'CLR3' )	\
		then	\
			set( permissionFlag ) = ( sp_is_tenant_user( argTenantId,	\
					'CreateClearSubDep3',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20003, 'Permission denied -- User not found in tenant TSecGroup for CreateClearSubDep3' );	\
			end if;	\
		end if;	\
	\
		call sp_next_scopeidgen( argTenantId,	\
			argId );	\
		insert into cfbam23.scopedef(	\
			classcode,	\
			createdby,	\
			createdat,	\
			updatedby,	\
			updatedat,	\
			tenantid,	\
			id,	\
			revision )	\
		values (	\
			argClassCode,	\
		argAuditUserId,	\
			current timestamp,	\
			argAuditUserId,	\
			current timestamp,	\
			argTenantId,	\
			argId,	\
			1 );	\
	\
		insert into cfbam23.clr_dep(	\
			tenantid,	\
			id,	\
			relationid )	\
		values (	\
			argTenantId,	\
			argId,	\
			argRelationId );	\
	\
		insert into cfbam23.clrsubdep3(	\
			tenantid,	\
			id,	\
			contclrdep2tid,	\
			contclrdep2id,	\
			name )	\
		values (	\
			argTenantId,	\
			argId,	\
			argContClearDep2TenantId,	\
			argContClearDep2Id,	\
			argName );	\
	\
		if( argClassCode = 'CLR3' )	\
		then	\
			insert into cfbam23.clrsubdep3_h (	\
				tenantid,	\
				id,	\
				classcode,	\
				auditclusterid,	\
				auditsessionid,	\
				auditstamp,	\
				relationid,	\
				contclrdep2tid,	\
				contclrdep2id,	\
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
				clr3.contclrdep2tid,	\
				clr3.contclrdep2id,	\
				clr3.name,	\
				scop.revision,	\
				1	\
			from cfbam23.clrsubdep3 as clr3	\
			inner join cfbam23.clr_dep clrd on	\
				clr3.tenantid = clrd.tenantid	\
				and clr3.Id = clrd.id	\
			inner join cfbam23.scopedef scop on	\
				clrd.tenantid = scop.tenantid	\
				and clrd.Id = scop.id	\
			where	\
				clr3.tenantid = argTenantId	\
		and clr3.id = argId;	\
		end if;	\
	\
		open retcursor;	\
	end;	\
end
