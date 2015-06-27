--
--	@(#) dbcreate/cfbam/oracle/crdl_tsecgrp.plsql
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

create or replace procedure cfbam23.dl_tsecgrp(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argTenantId numeric,
	argTSecGroupId integer,
	argRevision int )
is
	oldTenantId numeric(22,0);
	oldTSecGroupId integer;
	oldName varchar2(64);
	oldRevision integer;
	cursor cursDelIncludedByGroup is
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.TSecGrp tgrp
			inner join cfbam23.tsecinc tgnc on
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.IncGrpId
		where
			tgrp.TenantId = argTenantId
			and tgrp.TSecGroupId = argTSecGroupId;
	cursor cursDelGroupMembers is
		select
			tgmb.TenantId,
			tgmb.TSecGroupMemberId
		from cfbam23.TSecGrp tgrp
			inner join cfbam23.tsecmemb tgmb on
				tgrp.TenantId = tgmb.TenantId
				and tgrp.TSecGroupId = tgmb.TSecGroupId
		where
			tgrp.TenantId = argTenantId
			and tgrp.TSecGroupId = argTSecGroupId;
	cursor cursDelGroupIncludes is
		select
			tgnc.TenantId,
			tgnc.TSecGrpIncId
		from cfbam23.TSecGrp tgrp
			inner join cfbam23.tsecinc tgnc on
				tgrp.TenantId = tgnc.TenantId
				and tgrp.TSecGroupId = tgnc.TSecGrpId
		where
			tgrp.TenantId = argTenantId
			and tgrp.TSecGroupId = argTSecGroupId;
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
begin
		select
			TenantId,
			TSecGroupId,
			Name,
			revision
		into
			oldTenantId,
			oldTSecGroupId,
			oldName,
			oldRevision
		from cfbam23.TSecGrp
		where
			TenantId = argTenantId
			and TSecGroupId = argTSecGroupId
		for update;

	if( oldTenantId != secTenantId )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	permissionFlag := cfbam23.sp_is_tenant_user( oldTenantId,
		'DeleteTSecGroup',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;
	insert into cfbam23.TSecGrp_h (
			TenantId,
			TSecGroupId,
			revision,
			auditclusterid,
			auditsessionid,
			Name,
			auditaction,
			auditstamp )
		select
			tgrp.TenantId as TenantId,
			tgrp.TSecGroupId as TSecGroupId,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			tgrp.Name as Name,
			3,
			sysdate
		from cfbam23.TSecGrp tgrp
		where
			tgrp.TenantId = argTenantId
			and tgrp.TSecGroupId = argTSecGroupId;

	for cur in cursDelIncludedByGroup
	loop
		cfbam23.dl_tsecincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGrpIncId );
	end loop;
	for cur in cursDelGroupMembers
	loop
		cfbam23.dl_tsecmembbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGroupMemberId );
	end loop;
	for cur in cursDelGroupIncludes
	loop
		cfbam23.dl_tsecincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.TenantId,
				cur.TSecGrpIncId );
	end loop;
	delete from cfbam23.TSecGrp
	where
		TenantId = argTenantId
		and TSecGroupId = argTSecGroupId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

end dl_tsecgrp;
/

show errors procedure cfbam23.dl_tsecgrp;
/
