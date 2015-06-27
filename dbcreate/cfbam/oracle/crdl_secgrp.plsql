--
--	@(#) dbcreate/cfbam/oracle/crdl_secgrp.plsql
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

create or replace procedure cfbam23.dl_secgrp(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClusterId numeric,
	argSecGroupId integer,
	argRevision int )
is
	oldClusterId numeric(22,0);
	oldSecGroupId integer;
	oldName varchar2(64);
	oldRevision integer;
	cursor cursDelSecGroupForms is
		select
			sgfm.ClusId,
			sgfm.SecGrpFrmId
		from cfbam23.SecGrp sgrp
			inner join cfbam23.secgrpfrm sgfm on
				sgrp.ClusterId = sgfm.ClusId
				and sgrp.SecGroupId = sgfm.SecGrpId
		where
			sgrp.ClusterId = argClusterId
			and sgrp.SecGroupId = argSecGroupId;
	cursor cursDelSecGroupIncludedByGroup is
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.SecGrp sgrp
			inner join cfbam23.secinc sgnc on
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.IncGrpId
		where
			sgrp.ClusterId = argClusterId
			and sgrp.SecGroupId = argSecGroupId;
	cursor cursDelSecGroupMembers is
		select
			sgmb.ClusterId,
			sgmb.SecGroupMemberId
		from cfbam23.SecGrp sgrp
			inner join cfbam23.secmemb sgmb on
				sgrp.ClusterId = sgmb.ClusterId
				and sgrp.SecGroupId = sgmb.SecGroupId
		where
			sgrp.ClusterId = argClusterId
			and sgrp.SecGroupId = argSecGroupId;
	cursor cursDelSecGroupIncludes is
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.SecGrp sgrp
			inner join cfbam23.secinc sgnc on
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.SecGrpId
		where
			sgrp.ClusterId = argClusterId
			and sgrp.SecGroupId = argSecGroupId;
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
begin
		select
			ClusterId,
			SecGroupId,
			Name,
			revision
		into
			oldClusterId,
			oldSecGroupId,
			oldName,
			oldRevision
		from cfbam23.SecGrp
		where
			ClusterId = argClusterId
			and SecGroupId = argSecGroupId
		for update;

	if( oldClusterId != secClusterId )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	permissionFlag := cfbam23.sp_is_cluster_user( oldClusterId,
		'DeleteSecGroup',
		argAuditUserId );
	if( permissionFlag = 0 )
	then
		raise permissionDenied;
	end if;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;
	insert into cfbam23.SecGrp_h (
			ClusterId,
			SecGroupId,
			revision,
			auditclusterid,
			auditsessionid,
			Name,
			auditaction,
			auditstamp )
		select
			sgrp.ClusterId as ClusterId,
			sgrp.SecGroupId as SecGroupId,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			sgrp.Name as Name,
			3,
			sysdate
		from cfbam23.SecGrp sgrp
		where
			sgrp.ClusterId = argClusterId
			and sgrp.SecGroupId = argSecGroupId;

	for cur in cursDelSecGroupForms
	loop
		cfbam23.dl_secgrpfrmbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusId,
				cur.SecGrpFrmId );
	end loop;
	for cur in cursDelSecGroupIncludedByGroup
	loop
		cfbam23.dl_secincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusId,
				cur.SecGrpIncId );
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
	for cur in cursDelSecGroupIncludes
	loop
		cfbam23.dl_secincbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusId,
				cur.SecGrpIncId );
	end loop;
	delete from cfbam23.SecGrp
	where
		ClusterId = argClusterId
		and SecGroupId = argSecGroupId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

end dl_secgrp;
/

show errors procedure cfbam23.dl_secgrp;
/
