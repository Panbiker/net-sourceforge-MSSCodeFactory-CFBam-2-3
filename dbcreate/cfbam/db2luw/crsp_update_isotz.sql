--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_isotz.sql
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


create or replace procedure sp_update_isotz(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argISOTimezoneId smallint,	\
	in argIso8601 varchar(5),	\
	in argTZName varchar(64),	\
	in argTZHourOffset smallint,	\
	in argTZMinOffset smallint,	\
	in argDescription varchar(128),	\
	in argVisible char(1),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldISOTimezoneId smallint;	\
	declare oldIso8601 varchar(5);	\
	declare oldTZName varchar(64);	\
	declare oldTZHourOffset smallint;	\
	declare oldTZMinOffset smallint;	\
	declare oldDescription varchar(128);	\
	declare oldVisible char(1);	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				itzn.createdby as createdby,	\
				to_char( itzn.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				itzn.updatedby as updatedby,	\
				to_char( itzn.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			itzn.isotimezoneid as isotimezoneid,	\
			itzn.iso8601 as iso8601,	\
			itzn.tzname as tzname,	\
			itzn.tzhouroffset as tzhouroffset,	\
			itzn.tzminoffset as tzminoffset,	\
			itzn.description as description,	\
			itzn.visible as visible,	\
			itzn.revision as revision	\
		from cfbam23.ISOTz as itzn	\
		where	\
			itzn.isotimezoneid = argISOTimezoneId;	\
	begin	\
		if( argClassCode = 'ITZN' )	\
		then	\
			set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20001, 'Permission denied -- only system user can update ISOTimezone records' );	\
			end if;	\
		end if;	\
	\
		select	\
			ISOTimezoneId,	\
			Iso8601,	\
			TZName,	\
			TZHourOffset,	\
			TZMinOffset,	\
			Description,	\
			Visible,	\
			revision	\
		into	\
			oldISOTimezoneId,	\
			oldIso8601,	\
			oldTZName,	\
			oldTZHourOffset,	\
			oldTZMinOffset,	\
			oldDescription,	\
			oldVisible,	\
			oldRevision	\
		from cfbam23.ISOTz	\
		where	\
			ISOTimezoneId = argISOTimezoneId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_isotz() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.ISOTz	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			iso8601 = argIso8601,	\
			tzname = argTZName,	\
			tzhouroffset = argTZHourOffset,	\
			tzminoffset = argTZMinOffset,	\
			description = argDescription,	\
			visible = argVisible	\
		where	\
			isotimezoneid = argISOTimezoneId	\
		and revision = argRevision;	\
	\
		insert into cfbam23.ISOTz_h (	\
				isotimezoneid,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				iso8601,	\
				tzname,	\
				tzhouroffset,	\
				tzminoffset,	\
				description,	\
				visible,	\
			revision,	\
			auditaction )	\
		select	\
				itzn.isotimezoneid,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				itzn.iso8601,	\
				itzn.tzname,	\
				itzn.tzhouroffset,	\
				itzn.tzminoffset,	\
				itzn.description,	\
				itzn.visible,	\
			itzn.revision,	\
			2	\
		from cfbam23.ISOTz as itzn	\
		where	\
			itzn.isotimezoneid = argISOTimezoneId;	\
	\
		open retcursor;	\
	end;	\
end
