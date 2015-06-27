--
--	@(#) dbcreate/cfbam/oracle/crdl_secuser.plsql
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
--	Code manufactured MSS Code Factory
--

create or replace procedure cfbam23.dl_secuser(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argSecUserId varchar2,
	argRevision int )
is
	oldSecUserId varchar2(36);
	oldlogin_id varchar2(32);
	oldemail_addr varchar2(192);
	oldem_confuuid varchar2(36);
	oldDefDevUserId varchar2(36);
	oldDefDevName varchar2(127);
	oldpwd_hash varchar2(256);
	oldpwdrstuuid varchar2(36);
	oldRevision integer;
	cursor cursClearSecUserDefDev is
		select
			susr.SecUserId
		from cfbam23.SecUser susr
		where
			susr.SecUserId = argSecUserId;
	cursor cursDelTSecGroupMembers is
		select
			tgmb.TenantId,
			tgmb.TSecGroupMemberId
		from cfbam23.SecUser susr
			inner join cfbam23.tsecmemb tgmb on
				susr.SecUserId = tgmb.SecUserId
		where
			susr.SecUserId = argSecUserId;
	cursor cursDelSecGroupMembers is
		select
			sgmb.ClusterId,
			sgmb.SecGroupMemberId
		from cfbam23.SecUser susr
			inner join cfbam23.secmemb sgmb on
				susr.SecUserId = sgmb.SecUserId
		where
			susr.SecUserId = argSecUserId;
	cursor cursDelSecSessions is
		select
			sess.SecSessionId
		from cfbam23.SecUser susr
			inner join cfbam23.secsess sess on
				susr.SecUserId = sess.SecUserId
		where
			susr.SecUserId = argSecUserId;
	cursor cursDelSecProxySessions is
		select
			sess.SecSessionId
		from cfbam23.SecUser susr
			inner join cfbam23.secsess sess on
				susr.SecUserId = sess.SecProxyId
		where
			susr.SecUserId = argSecUserId;
	cursor cursDelSecDevices is
		select
			sdev.SecUserId,
			sdev.DevName
		from cfbam23.SecUser susr
			inner join cfbam23.secdev sdev on
				susr.SecUserId = sdev.SecUserId
		where
			susr.SecUserId = argSecUserId;
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
begin
		select
			SecUserId,
			login_id,
			email_addr,
			em_confuuid,
			DefDevUserId,
			DefDevName,
			pwd_hash,
			pwdrstuuid,
			revision
		into
			oldSecUserId,
			oldlogin_id,
			oldemail_addr,
			oldem_confuuid,
			oldDefDevUserId,
			oldDefDevName,
			oldpwd_hash,
			oldpwdrstuuid,
			oldRevision
		from cfbam23.SecUser
		where
			SecUserId = argSecUserId
		for update;

	permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;
	insert into cfbam23.SecUser_h (
			SecUserId,
			revision,
			auditclusterid,
			auditsessionid,
			login_id,
			email_addr,
			em_confuuid,
			DefDevUserId,
			DefDevName,
			pwd_hash,
			pwdrstuuid,
			auditaction,
			auditstamp )
		select
			susr.SecUserId as SecUserId,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			susr.login_id as login_id,
			susr.email_addr as email_addr,
			susr.em_confuuid as em_confuuid,
			susr.DefDevUserId as DefDevUserId,
			susr.DefDevName as DefDevName,
			susr.pwd_hash as pwd_hash,
			susr.pwdrstuuid as pwdrstuuid,
			3,
			sysdate
		from cfbam23.SecUser susr
		where
			susr.SecUserId = argSecUserId;

	for cur in cursClearSecUserDefDev
	loop
		update cfbam23.secuser
		set
			DefDevUserId = null,
			DefDevName = null
		where
			SecUserId = cur.SecUserId;

	end loop;

	update cfbam23.SecUser
	set
		SecUserId = argSecUserId,
		DefDevUserId = null,
		DefDevName = null
	where
		SecUserId = argSecUserId;

	for cur in cursDelTSecGroupMembers
	loop
		cfbam23.dl_tsecmembbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupMemberId );
	end loop;
	for cur in cursDelSecGroupMembers
	loop
		cfbam23.dl_secmembbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupMemberId );
	end loop;
	for cur in cursDelSecSessions
	loop
		cfbam23.dl_secsessbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.SecSessionId );
	end loop;
	for cur in cursDelSecProxySessions
	loop
		cfbam23.dl_secsessbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.SecSessionId );
	end loop;
	for cur in cursDelSecDevices
	loop
		cfbam23.dl_secdevbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.SecUserId,
				cur.DevName );
	end loop;
	delete from cfbam23.SecUser
	where
		SecUserId = argSecUserId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

end dl_secuser;
/

show errors procedure cfbam23.dl_secuser;
/
