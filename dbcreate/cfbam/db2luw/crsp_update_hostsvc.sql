--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_hostsvc.sql
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


create or replace procedure sp_update_hostsvc(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argClusterId bigint,	\
	in argServiceId bigint,	\
	in argHostNodeId bigint,	\
	in argServiceTypeId integer,	\
	in argHostPort smallint,	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldClusterId bigint;	\
	declare oldServiceId bigint;	\
	declare oldHostNodeId bigint;	\
	declare oldServiceTypeId integer;	\
	declare oldHostPort smallint;	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				hsvc.createdby as createdby,	\
				to_char( hsvc.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				hsvc.updatedby as updatedby,	\
				to_char( hsvc.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			hsvc.clusterid as clusterid,	\
			hsvc.serviceid as serviceid,	\
			hsvc.hostnodeid as hostnodeid,	\
			hsvc.servicetypeid as servicetypeid,	\
			hsvc.hostport as hostport,	\
			hsvc.revision as revision	\
		from cfbam23.HostSvc as hsvc	\
		where	\
			hsvc.clusterid = argClusterId	\
		and hsvc.serviceid = argServiceId;	\
	begin	\
		if( argClassCode = 'HSVC' )	\
		then	\
			set( permissionFlag ) = ( sp_is_cluster_user( argClusterId,	\
					'UpdateService',	\
					argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20002, 'Permission denied -- User not found in cluster SecGroup for UpdateService' );	\
			end if;	\
		end if;	\
	\
		select	\
			ClusterId,	\
			ServiceId,	\
			HostNodeId,	\
			ServiceTypeId,	\
			HostPort,	\
			revision	\
		into	\
			oldClusterId,	\
			oldServiceId,	\
			oldHostNodeId,	\
			oldServiceTypeId,	\
			oldHostPort,	\
			oldRevision	\
		from cfbam23.HostSvc	\
		where	\
			ClusterId = argClusterId	\
			and ServiceId = argServiceId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_hostsvc() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.HostSvc	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			hostnodeid = argHostNodeId,	\
			servicetypeid = argServiceTypeId,	\
			hostport = argHostPort	\
		where	\
			clusterid = argClusterId	\
		and serviceid = argServiceId	\
		and revision = argRevision;	\
	\
		insert into cfbam23.HostSvc_h (	\
				clusterid,	\
				serviceid,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				hostnodeid,	\
				servicetypeid,	\
				hostport,	\
			revision,	\
			auditaction )	\
		select	\
				hsvc.clusterid,	\
				hsvc.serviceid,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				hsvc.hostnodeid,	\
				hsvc.servicetypeid,	\
				hsvc.hostport,	\
			hsvc.revision,	\
			2	\
		from cfbam23.HostSvc as hsvc	\
		where	\
			hsvc.clusterid = argClusterId	\
		and hsvc.serviceid = argServiceId;	\
	\
		open retcursor;	\
	end;	\
end
