--
--	@(#) dbcreate/cfbam/oracle/crcrt_secgrpfrm.plsql
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

create or replace procedure cfbam23.crt_secgrpfrm(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argClusId numeric,
	argSecGrpId integer,
	argSecAppId integer,
	argSecFrmId integer )
is
	permissionDenied exception;
	permissionFlag integer;
	argSecGrpFrmId numeric;
begin
	if( argClassCode = 'SGFM' )
	then
		permissionFlag := cfbam23.sp_is_cluster_user( argClusId,
			'CreateSecGroupForm',
			argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

	argSecGrpFrmId := cfbam23.nxt_secgroupformidgen( argClusId );
	insert into cfbam23.secgrpfrm(
		createdby,
		createdat,
		updatedby,
		updatedat,
		ClusId,
		SecGrpFrmId,
		SecGrpId,
		SecAppId,
		SecFrmId,
		revision )
	values (
		argAuditUserId,
		sysdate,
		argAuditUserId,
		sysdate,
		argClusId,
		argSecGrpFrmId,
		argSecGrpId,
		argSecAppId,
		argSecFrmId,
		1 );
	insert into cfbam23.SecGrpFrm_h (
			ClusId,
			SecGrpFrmId,
			revision,
			auditclusterid,
			auditsessionid,
			SecGrpId,
			SecAppId,
			SecFrmId,
			auditaction,
			auditstamp )
		select
			sgfm.ClusId as ClusId,
			sgfm.SecGrpFrmId as SecGrpFrmId,
			sgfm.revision as revision,
			argAuditClusterId,
			argAuditSessionId,
			sgfm.SecGrpId as SecGrpId,
			sgfm.SecAppId as SecAppId,
			sgfm.SecFrmId as SecFrmId,
			1,
			sysdate
		from cfbam23.SecGrpFrm sgfm
		where
			sgfm.ClusId = argClusId
			and sgfm.SecGrpFrmId = argSecGrpFrmId;

	open retCursor for select
			sgfm.createdby,
			to_char( sgfm.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			sgfm.updatedby,
			to_char( sgfm.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			sgfm.ClusId as ClusId,
			sgfm.SecGrpFrmId as SecGrpFrmId,
			sgfm.SecGrpId as SecGrpId,
			sgfm.SecAppId as SecAppId,
			sgfm.SecFrmId as SecFrmId,
		sgfm.revision as revision
	from cfbam23.SecGrpFrm sgfm
	where
		sgfm.ClusId = argClusId
			and sgfm.SecGrpFrmId = argSecGrpFrmId;
end crt_secgrpfrm;
/

show errors procedure cfbam23.crt_secgrpfrm;
/
