--
--	@(#) dbcreate/cfbam/db2luw/crsp_delete_secuser.sql
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

create or replace procedure sp_delete_secuser(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argSecUserId varchar(36),	\
	in argRevision int )	\
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
	declare subret boolean;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select 1 from sysibm.sysdummy1;	\
	begin	\
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
		set( permissionFlag ) = ( sp_is_system_user( argAuditUserId ) );	\
		if( permissionFlag = 0 )	\
		then	\
			call raise_application_error( -20001, 'Permission denied -- only system user can delete SecUser records' );	\
		end if;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20000, 'sp_delete_secuser() Data collision detected' );	\
		end if;	\
	\
		for cur as	\
			select	\
				susr.secuserid as curSecUserId	\
			from cfbam23.SecUser as susr	\
			where	\
				susr.secuserid = argSecUserId	\
		do	\
			update cfbam23.secuser	\
			set	\
				defdevuserid = null,	\
				defdevname = null	\
			where	\
				secuserid = curSecUserId;	\
	\
		end for;	\
	\
		update cfbam23.secuser	\
		set	\
			secuserid = argSecUserId,	\
			defdevuserid = null,	\
			defdevname = null	\
		where	\
			SecUserId = argSecUserId;	\
	\
		for cur as	\
			select	\
				tgmb.tenantid as tenantid,	\
				tgmb.tsecgroupmemberid as tsecgroupmemberid	\
			from cfbam23.SecUser as susr	\
				inner join cfbam23.tsecmemb tgmb on 	\
					susr.secuserid = tgmb.secuserid	\
			where	\
				susr.secuserid = argSecUserId	\
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
				sgmb.clusterid as clusterid,	\
				sgmb.secgroupmemberid as secgroupmemberid	\
			from cfbam23.SecUser as susr	\
				inner join cfbam23.secmemb sgmb on 	\
					susr.secuserid = sgmb.secuserid	\
			where	\
				susr.secuserid = argSecUserId	\
		do	\
			call sp_delete_secmemb_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					clusterid,	\
					secgroupmemberid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sess.secsessionid as secsessionid	\
			from cfbam23.SecUser as susr	\
				inner join cfbam23.secsess sess on 	\
					susr.secuserid = sess.secuserid	\
			where	\
				susr.secuserid = argSecUserId	\
		do	\
			call sp_delete_secsess_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					secsessionid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sess.secsessionid as secsessionid	\
			from cfbam23.SecUser as susr	\
				inner join cfbam23.secsess sess on 	\
					susr.secuserid = sess.secproxyid	\
			where	\
				susr.secuserid = argSecUserId	\
		do	\
			call sp_delete_secsess_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					secsessionid );	\
		end for;	\
	\
		for cur as	\
			select	\
				sdev.secuserid as secuserid,	\
				sdev.devname as devname	\
			from cfbam23.SecUser as susr	\
				inner join cfbam23.secdev sdev on 	\
					susr.secuserid = sdev.secuserid	\
			where	\
				susr.secuserid = argSecUserId	\
		do	\
			call sp_delete_secdev_by_ididx( argAuditClusterId,	\
					argAuditUserId,	\
					argAuditSessionId,	\
					secClusterId,	\
					secTenantId,	\
					secuserid,	\
					devname );	\
		end for;	\
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
			susr.revision + 1,	\
			3	\
		from cfbam23.SecUser as susr	\
		where	\
			susr.secuserid = argSecUserId;	\
	\
		delete from cfbam23.SecUser	\
		where	\
			secuserid = argSecUserId;	\
	\
		open retcursor;	\
	end;	\
end
