--
--	@(#) dbcreate/cfbam/oracle/crsp_bootstrap.plsql
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

create or replace procedure cfbam23.sp_bootstrap
is
	curtime timestamp;
	clusid numeric(22,0);
	tenantid numeric(22,0);
begin
	curtime := sysdate;

	insert into cfbam23.AuditAction (
		auditactionid,
		description,
		revision )
	values (
		1,
		'Created',
		1 );

	insert into cfbam23.AuditAction (
		auditactionid,
		description,
		revision )
	values (
		2,
		'Updated',
		1 );

	insert into cfbam23.AuditAction (
		auditactionid,
		description,
		revision )
	values (
		3,
		'Deleted',
		1 );

	insert into cfbam23.SecUser (
		createdat,
		createdby,
		updatedat,
		updatedby,
		secuserid,
		login_id,
		email_addr,
		pwd_hash,
		revision )
	values (
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		'system',
		'root',
		'bootstrap',
		1 );

	select cfbam23.nxt_clusteridgen()
	into clusid
	from dual;

	insert into cfbam23.clus (
		createdat,
		createdby,
		updatedat,
		updatedby,
		id,
		fulldomainname,
		description,
		revision )
	values (
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		clusid,
		'system',
		'system',
		1 );

	select id
	into clusid
	from cfbam23.clus
	where fulldomainname = 'system';

	select cfbam23.nxt_tenantidgen()
	into tenantid
	from dual;

	insert into cfbam23.tenant (
		createdat,
		createdby,
		updatedat,
		updatedby,
		clusterid,
		id,
		tenantname,
		revision )
	select
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		curtime,
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		clusid,
		tenantid,
		'system',
		1
	from dual;

	insert into cfbam23.SecSess(
		secsessionid,
		secuserid,
		start_ts,
		finish_ts,
		revision )
	values (
		'cb56d150-ea1a-11e2-91e2-0800200c9a66',
		'654dbba0-eda7-11e1-aff1-0800200c9a66',
		curtime,
		curtime,
		1 );

	insert into cfbam23.SecUser_h
	select
		secuserid,
		revision,
		clusid,
		'cb56d150-ea1a-11e2-91e2-0800200c9a66',
		login_id,
		email_addr,
		null,
		null,
		null,
		pwd_hash,
		null,
		1,
		curtime
	from
		cfbam23.SecUser
		where login_id = 'system';

	insert into cfbam23.clus_h
	select
		id,
		revision,
		clusid,
		'cb56d150-ea1a-11e2-91e2-0800200c9a66',
		fulldomainname,
		description,
		1,
		curtime
	from cfbam23.clus
	where fulldomainname = 'system';

	insert into cfbam23.tenant_h
	select
		id,
		revision,
		clusid,
		'cb56d150-ea1a-11e2-91e2-0800200c9a66',
		clusterid,
		tenantname,
		1,
		curtime
	from cfbam23.tenant
	where
		clusterid = clusid
		and tenantname = 'system';
end sp_bootstrap;
/

show errors procedure cfbam23.sp_bootstrap;

call cfbam23.sp_bootstrap();

--drop function cfbam23.sp_bootstrap;
--/
