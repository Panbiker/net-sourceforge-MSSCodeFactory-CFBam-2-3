--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_secuser.sql
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


create or replace procedure sp_update_secuser(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argSecUserId varchar(36),	\
	in argLoginId varchar(32),	\
	in argEMailAddress varchar(192),	\
	in argEMailConfirmationUuid varchar(36),	\
	in argDefaultDevSecUserId varchar(36),	\
	in argDefaultDevName varchar(127),	\
	in argPasswordHash varchar(256),	\
	in argPasswordResetUuid varchar(36),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldSecUserId varchar(36);	\
	declare oldLoginId varchar(32);	\
	declare oldEMailAddress varchar(192);	\
	declare oldEMailConfirmationUuid varchar(36);	\
	declare oldDefaultDevSecUserId varchar(36);	\
	declare oldDefaultDevName varchar(127);	\
	declare oldPasswordHash varchar(256);	\
	declare oldPasswordResetUuid varchar(36);	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				susr.createdby as createdby,	\
				to_char( susr.createdat, 'YYYY-MM-DD-HH24.MI.SS' ) as createdat,	\
				susr.updatedby as updatedby,	\
				to_char( susr.updatedat, 'YYYY-MM-DD-HH24.MI.SS' ) as updatedat,	\
			susr.secuserid as secuserid,	\
			susr.login_id as login_id,	\
			susr.email_addr as email_addr,	\
			susr.em_confuuid as em_confuuid,	\
			susr.defdevuserid as defdevuserid,	\
			susr.defdevname as defdevname,	\
			susr.pwd_hash as pwd_hash,	\
			susr.pwdrstuuid as pwdrstuuid,	\
			susr.revision as revision	\
		from cfbam23.SecUser as susr	\
		where	\
			susr.secuserid = argSecUserId;	\
	begin	\
		if( argClassCode = 'SUSR' )	\
		then	\
			set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
			if( permissionFlag = 0 )	\
			then	\
				call raise_application_error( -20001, 'Permission denied -- only system user can update SecUser records' );	\
			end if;	\
		end if;	\
	\
		select	\
			SecUserId,	\
			login_id,	\
			email_addr,	\
			em_confuuid,	\
			DefDevUserId,	\
			DefDevName,	\
			pwd_hash,	\
			pwdrstuuid,	\
			revision	\
		into	\
			oldSecUserId,	\
			oldLoginId,	\
			oldEMailAddress,	\
			oldEMailConfirmationUuid,	\
			oldDefaultDevSecUserId,	\
			oldDefaultDevName,	\
			oldPasswordHash,	\
			oldPasswordResetUuid,	\
			oldRevision	\
		from cfbam23.SecUser	\
		where	\
			SecUserId = argSecUserId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_secuser() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.SecUser	\
		set	\
			revision = argRevision + 1,	\
			updatedby = argAuditUserId,	\
			updatedat = current timestamp,	\
			login_id = argLoginId,	\
			email_addr = argEMailAddress,	\
			em_confuuid = argEMailConfirmationUuid,	\
			defdevuserid = argDefaultDevSecUserId,	\
			defdevname = argDefaultDevName,	\
			pwd_hash = argPasswordHash,	\
			pwdrstuuid = argPasswordResetUuid	\
		where	\
			secuserid = argSecUserId	\
		and revision = argRevision;	\
	\
		insert into cfbam23.SecUser_h (	\
				secuserid,	\
			auditclusterid,	\
			auditsessionid,	\
			auditstamp,	\
				login_id,	\
				email_addr,	\
				em_confuuid,	\
				defdevuserid,	\
				defdevname,	\
				pwd_hash,	\
				pwdrstuuid,	\
			revision,	\
			auditaction )	\
		select	\
				susr.secuserid,	\
			argAuditClusterId,	\
			argAuditSessionId,	\
			current timestamp,	\
				susr.login_id,	\
				susr.email_addr,	\
				susr.em_confuuid,	\
				susr.defdevuserid,	\
				susr.defdevname,	\
				susr.pwd_hash,	\
				susr.pwdrstuuid,	\
			susr.revision,	\
			2	\
		from cfbam23.SecUser as susr	\
		where	\
			susr.secuserid = argSecUserId;	\
	\
		open retcursor;	\
	end;	\
end
