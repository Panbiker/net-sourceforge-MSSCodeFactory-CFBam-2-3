--
--	@(#) dbcreate/cfbam/oracle/crdl_clus.plsql
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

create or replace procedure cfbam23.dl_clus(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argId numeric,
	argRevision int )
is
	oldId numeric(22,0);
	oldFullDomainName varchar2(192);
	oldDescription varchar2(128);
	oldRevision integer;
	cursor cursDelSecGroupForms is
		select
			sgfm.ClusId,
			sgfm.SecGrpFrmId
		from cfbam23.clus clus
			inner join cfbam23.secgrp sgrp on
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secgrpfrm sgfm on
				sgrp.ClusterId = sgfm.ClusId
				and sgrp.SecGroupId = sgfm.SecGrpId
		where
			clus.Id = argId;
	cursor cursDelSecGroupIncludedByGroup is
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.clus clus
			inner join cfbam23.secgrp sgrp on
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secinc sgnc on
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.IncGrpId
		where
			clus.Id = argId;
	cursor cursDelSecGroupMembers is
		select
			sgmb.ClusterId,
			sgmb.SecGroupMemberId
		from cfbam23.clus clus
			inner join cfbam23.secgrp sgrp on
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secmemb sgmb on
				sgrp.ClusterId = sgmb.ClusterId
				and sgrp.SecGroupId = sgmb.SecGroupId
		where
			clus.Id = argId;
	cursor cursDelSecGroupIncludes is
		select
			sgnc.ClusId,
			sgnc.SecGrpIncId
		from cfbam23.clus clus
			inner join cfbam23.secgrp sgrp on
				clus.Id = sgrp.ClusterId
			inner join cfbam23.secinc sgnc on
				sgrp.ClusterId = sgnc.ClusId
				and sgrp.SecGroupId = sgnc.SecGrpId
		where
			clus.Id = argId;
	cursor cursDelSecGroups is
		select
			sgrp.ClusterId,
			sgrp.SecGroupId
		from cfbam23.clus clus
			inner join cfbam23.secgrp sgrp on
				clus.Id = sgrp.ClusterId
		where
			clus.Id = argId;
	cursor cursDelSecAppForms is
		select
			sfrm.ClusterId,
			sfrm.SecFormId
		from cfbam23.clus clus
			inner join cfbam23.secapp sapp on
				clus.Id = sapp.ClusterId
			inner join cfbam23.secform sfrm on
				sapp.ClusterId = sfrm.ClusterId
				and sapp.SecAppId = sfrm.SecAppId
		where
			clus.Id = argId;
	cursor cursDelSecApps is
		select
			sapp.ClusterId,
			sapp.SecAppId
		from cfbam23.clus clus
			inner join cfbam23.secapp sapp on
				clus.Id = sapp.ClusterId
		where
			clus.Id = argId;
	cursor cursDelTenants is
		select
			tent.Id
		from cfbam23.clus clus
			inner join cfbam23.tenant tent on
				clus.Id = tent.ClusterId
		where
			clus.Id = argId;
	cursor cursDelHostNodes is
		select
			hsnd.ClusterId,
			hsnd.HostNodeId
		from cfbam23.clus clus
			inner join cfbam23.hostnode hsnd on
				clus.Id = hsnd.ClusterId
		where
			clus.Id = argId;
	permissionFlag integer;
	permissionDenied exception;
	dataCollision exception;
	dataUpdateFailed exception;
begin
		select
			Id,
			FullDomainName,
			Description,
			revision
		into
			oldId,
			oldFullDomainName,
			oldDescription,
			oldRevision
		from cfbam23.clus
		where
			Id = argId
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
	insert into cfbam23.clus_h (
			Id,
			revision,
			auditclusterid,
			auditsessionid,
			FullDomainName,
			Description,
			auditaction,
			auditstamp )
		select
			clus.Id as Id,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			clus.FullDomainName as FullDomainName,
			clus.Description as Description,
			3,
			sysdate
		from cfbam23.clus clus
		where
			clus.Id = argId;

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
	for cur in cursDelSecGroups
	loop
		cfbam23.dl_secgrpbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecGroupId );
	end loop;
	for cur in cursDelSecAppForms
	loop
		cfbam23.dl_secformbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecFormId );
	end loop;
	for cur in cursDelSecApps
	loop
		cfbam23.dl_secappbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.SecAppId );
	end loop;
	for cur in cursDelTenants
	loop
		cfbam23.dl_tenantbyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.Id );
	end loop;
	for cur in cursDelHostNodes
	loop
		cfbam23.dl_hostnodebyididx( argAuditClusterId,
				argAuditUserId,
				argAuditSessionId,
				secClusterId,
				secTenantId,
				cur.ClusterId,
				cur.HostNodeId );
	end loop;
	delete from cfbam23.clus
	where
		Id = argId;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;

end dl_clus;
/

show errors procedure cfbam23.dl_clus;
/
