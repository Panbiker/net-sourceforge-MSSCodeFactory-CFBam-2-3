--
--	@(#) dbcreate/cfbam/oracle/crcrt_secuser.plsql
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

create or replace procedure cfbam23.crt_secuser(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argSecUserId varchar2,
	arglogin_id varchar2,
	argemail_addr varchar2,
	argem_confuuid varchar2,
	argDefDevUserId varchar2,
	argDefDevName varchar2,
	argpwd_hash varchar2,
	argpwdrstuuid varchar2 )
is
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'SUSR' )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	insert into cfbam23.secuser(
		createdby,
		createdat,
		updatedby,
		updatedat,
		SecUserId,
		login_id,
		email_addr,
		em_confuuid,
		DefDevUserId,
		DefDevName,
		pwd_hash,
		pwdrstuuid,
		revision )
	values (
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argSecUserId,
		arglogin_id,
		argemail_addr,
		argem_confuuid,
		argDefDevUserId,
		argDefDevName,
		argpwd_hash,
		argpwdrstuuid,
		1 );
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
			susr.revision as revision,
			argAuditClusterId,
			argAuditSessionId,
			susr.login_id as login_id,
			susr.email_addr as email_addr,
			susr.em_confuuid as em_confuuid,
			susr.DefDevUserId as DefDevUserId,
			susr.DefDevName as DefDevName,
			susr.pwd_hash as pwd_hash,
			susr.pwdrstuuid as pwdrstuuid,
			1,
			sysdate
		from cfbam23.SecUser susr
		where
			susr.SecUserId = argSecUserId;

	open retCursor for select
			susr.createdby,
			to_char( susr.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			susr.updatedby,
			to_char( susr.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			susr.SecUserId as SecUserId,
			susr.login_id as login_id,
			susr.email_addr as email_addr,
			susr.em_confuuid as em_confuuid,
			susr.DefDevUserId as DefDevUserId,
			susr.DefDevName as DefDevName,
			susr.pwd_hash as pwd_hash,
			susr.pwdrstuuid as pwdrstuuid,
		susr.revision as revision
	from cfbam23.SecUser susr
	where
		susr.SecUserId = argSecUserId;
end crt_secuser;
/

show errors procedure cfbam23.crt_secuser;
/
