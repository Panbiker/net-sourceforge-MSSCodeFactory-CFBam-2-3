--
--	@(#) dbcreate/cfbam/oracle/crsp_is_tenant_user.plsql
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

create or replace function cfbam23.sp_is_tenant_user(
	argTenantId numeric,
	argSecGroupName varchar,
	argSecUserId varchar )
return integer
is
	retval integer;
	cursor curs is 
			select
				susr.secuserid as secuserid
			from cfbam23.SecUser susr
			where
					susr.secuserid = argSecUserId
				and susr.login_id = 'system'
		union
			select
				smemb1.secuserid as secuserid
			from cfbam23.TSecGrp sgrp1
				inner join cfbam23.TSecMemb smemb1 on
					smemb1.tenantid = sgrp1.tenantid
					and smemb1.tsecgroupid = sgrp1.tsecgroupid
			where
					sgrp1.tenantid = argTenantId
				and sgrp1.name = argSecGroupName
				and smemb1.secuserid = argSecUserId
		union
			select
				smemb2.secuserid as secuserid
			from cfbam23.TSecGrp sgrp2
				inner join cfbam23.TSecInc sinc2a on
					sinc2a.tenantid = sgrp2.tenantid
					and sinc2a.tsecgrpid = sgrp2.tsecgroupid
				inner join cfbam23.TSecMemb smemb2 on
					smemb2.tenantid = sinc2a.tenantid
					and smemb2.tsecgroupid = sinc2a.incgrpid
			where
					sgrp2.tenantid = argTenantId
				and sgrp2.name = argSecGroupName
				and smemb2.secuserid = argSecUserId
		union
			select
				smemb3.secuserid as secuserid
			from cfbam23.TSecGrp sgrp3
				inner join cfbam23.TSecInc sinc3a on
					sinc3a.tenantid = sgrp3.tenantid
					and sinc3a.tsecgrpid = sgrp3.tsecgroupid
				inner join cfbam23.TSecInc sinc3b on
					sinc3b.tenantid = sinc3a.tenantid
					and sinc3b.tsecgrpid = sinc3a.incgrpid
				inner join cfbam23.TSecMemb smemb3 on
					smemb3.tenantid = sinc3b.tenantid
					and smemb3.tsecgroupid = sinc3b.incgrpid
			where
					sgrp3.tenantid = argTenantId
				and sgrp3.name = argSecGroupName
				and smemb3.secuserid = argSecUserId
		union
			select
				smemb4.secuserid as secuserid
			from cfbam23.TSecGrp sgrp4
				inner join cfbam23.TSecInc sinc4a on
					sinc4a.tenantid = sgrp4.tenantid
					and sinc4a.tsecgrpid = sgrp4.tsecgroupid
				inner join cfbam23.TSecInc sinc4b on
					sinc4b.tenantid = sinc4a.tenantid
					and sinc4b.tsecgrpid = sinc4a.incgrpid
				inner join cfbam23.TSecInc sinc4c on
					sinc4c.tenantid = sinc4b.tenantid
					and sinc4c.tsecgrpid = sinc4b.incgrpid
				inner join cfbam23.TSecMemb smemb4 on
					smemb4.tenantid = sinc4c.tenantid
					and smemb4.tsecgroupid = sinc4c.incgrpid
			where
					sgrp4.tenantid = argTenantId
				and sgrp4.name = argSecGroupName
				and smemb4.secuserid = argSecUserId
		union
			select
				smemb5.secuserid as secuserid
			from cfbam23.TSecGrp sgrp5
				inner join cfbam23.TSecInc sinc5a on
					sinc5a.tenantid = sgrp5.tenantid
					and sinc5a.tsecgrpid = sgrp5.tsecgroupid
				inner join cfbam23.TSecInc sinc5b on
					sinc5b.tenantid = sinc5a.tenantid
					and sinc5b.tsecgrpid = sinc5a.incgrpid
				inner join cfbam23.TSecInc sinc5c on
					sinc5c.tenantid = sinc5b.tenantid
					and sinc5c.tsecgrpid = sinc5b.incgrpid
				inner join cfbam23.TSecInc sinc5d on
					sinc5d.tenantid = sinc5c.tenantid
					and sinc5d.tsecgrpid = sinc5c.incgrpid
				inner join cfbam23.TSecMemb smemb5 on
					smemb5.tenantid = sinc5d.tenantid
					and smemb5.tsecgroupid = sinc5d.incgrpid
			where
					sgrp5.tenantid = argTenantId
				and sgrp5.name = argSecGroupName
				and smemb5.secuserid = argSecUserId
		union
			select
				smemb6.secuserid as secuserid
			from cfbam23.TSecGrp sgrp6
				inner join cfbam23.TSecInc sinc6a on
					sinc6a.tenantid = sgrp6.tenantid
					and sinc6a.tsecgrpid = sgrp6.tsecgroupid
				inner join cfbam23.TSecInc sinc6b on
					sinc6b.tenantid = sinc6a.tenantid
					and sinc6b.tsecgrpid = sinc6a.incgrpid
				inner join cfbam23.TSecInc sinc6c on
					sinc6c.tenantid = sinc6b.tenantid
					and sinc6c.tsecgrpid = sinc6b.incgrpid
				inner join cfbam23.TSecInc sinc6d on
					sinc6d.tenantid = sinc6c.tenantid
					and sinc6d.tsecgrpid = sinc6c.incgrpid
				inner join cfbam23.TSecInc sinc6e on
					sinc6e.tenantid = sinc6d.tenantid
					and sinc6e.tsecgrpid = sinc6d.incgrpid
				inner join cfbam23.TSecMemb smemb6 on
					smemb6.tenantid = sinc6e.tenantid
					and smemb6.tsecgroupid = sinc6e.incgrpid
			where
					sgrp6.tenantid = argTenantId
				and sgrp6.name = argSecGroupName
				and smemb6.secuserid = argSecUserId
		union
			select
				smemb7.secuserid as secuserid
			from cfbam23.TSecGrp sgrp7
				inner join cfbam23.TSecInc sinc7a on
					sinc7a.tenantid = sgrp7.tenantid
					and sinc7a.tsecgrpid = sgrp7.tsecgroupid
				inner join cfbam23.TSecInc sinc7b on
					sinc7b.tenantid = sinc7a.tenantid
					and sinc7b.tsecgrpid = sinc7a.incgrpid
				inner join cfbam23.TSecInc sinc7c on
					sinc7c.tenantid = sinc7b.tenantid
					and sinc7c.tsecgrpid = sinc7b.incgrpid
				inner join cfbam23.TSecInc sinc7d on
					sinc7d.tenantid = sinc7c.tenantid
					and sinc7d.tsecgrpid = sinc7c.incgrpid
				inner join cfbam23.TSecInc sinc7e on
					sinc7e.tenantid = sinc7d.tenantid
					and sinc7e.tsecgrpid = sinc7d.incgrpid
				inner join cfbam23.TSecInc sinc7f on
					sinc7f.tenantid = sinc7e.tenantid
					and sinc7f.tsecgrpid = sinc7e.incgrpid
				inner join cfbam23.TSecMemb smemb7 on
					smemb7.tenantid = sinc7f.tenantid
					and smemb7.tsecgroupid = sinc7f.incgrpid
			where
					sgrp7.tenantid = argTenantId
				and sgrp7.name = argSecGroupName
				and smemb7.secuserid = argSecUserId
		union
			select
				smemb8.secuserid as secuserid
			from cfbam23.TSecGrp sgrp8
				inner join cfbam23.TSecInc sinc8a on
					sinc8a.tenantid = sgrp8.tenantid
					and sinc8a.tsecgrpid = sgrp8.tsecgroupid
				inner join cfbam23.TSecInc sinc8b on
					sinc8b.tenantid = sinc8a.tenantid
					and sinc8b.tsecgrpid = sinc8a.incgrpid
				inner join cfbam23.TSecInc sinc8c on
					sinc8c.tenantid = sinc8b.tenantid
					and sinc8c.tsecgrpid = sinc8b.incgrpid
				inner join cfbam23.TSecInc sinc8d on
					sinc8d.tenantid = sinc8c.tenantid
					and sinc8d.tsecgrpid = sinc8c.incgrpid
				inner join cfbam23.TSecInc sinc8e on
					sinc8e.tenantid = sinc8d.tenantid
					and sinc8e.tsecgrpid = sinc8d.incgrpid
				inner join cfbam23.TSecInc sinc8f on
					sinc8f.tenantid = sinc8e.tenantid
					and sinc8f.tsecgrpid = sinc8e.incgrpid
				inner join cfbam23.TSecInc sinc8g on
					sinc8g.tenantid = sinc8f.tenantid
					and sinc8g.tsecgrpid = sinc8f.incgrpid
				inner join cfbam23.TSecMemb smemb8 on
					smemb8.tenantid = sinc8g.tenantid
					and smemb8.tsecgroupid = sinc8g.incgrpid
			where
					sgrp8.tenantid = argTenantId
				and sgrp8.name = argSecGroupName
				and smemb8.secuserid = argSecUserId;
begin
	retval := 0;
	for cur in curs
	loop
		retval := 1;
		exit;
	end loop;
	return retval;
end sp_is_tenant_user;
/

show errors function cfbam23.sp_is_tenant_user;
/
