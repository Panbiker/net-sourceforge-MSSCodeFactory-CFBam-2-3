@ECHO OFF
REM
REM	@(#) dbcreate/cfbam/sybase/crprocs_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2013 Mark Sobkow
REM	
REM	This program is available as free software under the GNU GPL v3, under
REM	the Eclipse Public License 1.0, or under a commercial license from Mark
REM	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
REM	
REM	You should have received copies of the complete license text for
REM	GPLv3.txt and EPLv1_0.txt, containing the text
REM	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
REM	
REM	Under the terms of the GPL:
REM	
REM		This program is free software: you can redistribute it and/or modify
REM		it under the terms of the GNU General Public License as published by
REM		the Free Software Foundation, either version 3 of the License, or
REM		(at your option) any later version.
REM	  
REM		This program is distributed in the hope that it will be useful,
REM		but WITHOUT ANY WARRANTY; without even the implied warranty of
REM		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
REM		GNU General Public License for more details.
REM	  
REM		You should have received a copy of the GNU General Public License
REM		along with this program.  If not, see <http://www.gnu.org/licenses/>.
REM	
REM	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
REM	and licensed under the BSD 3-Clause license as written by xfree86.org:
REM	
REM	Redistribution and use in source and binary forms, with or without
REM	modification, are permitted provided that the following conditions are
REM	met:
REM	
REM	    (1) Redistributions of source code must retain the above copyright
REM	    notice, this list of conditions and the following disclaimer. 
REM	
REM	    (2) Redistributions in binary form must reproduce the above copyright
REM	    notice, this list of conditions and the following disclaimer in
REM	    the documentation and/or other materials provided with the
REM	    distribution.  
REM	    
REM	    (3)The name of the author may not be used to
REM	    endorse or promote products derived from this software without
REM	    specific prior written permission.
REM	
REM	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
REM	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
REM	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
REM	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
REM	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
REM	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
REM	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
REM	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
REM	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
REM	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
REM	POSSIBILITY OF SUCH DAMAGE.
REM	
REM
@ECHO OFF
REM
REM	Initialize locals
REM
SET sybsrv=""
SET sybdb=""
SET sybuser=""
SET sybpwd=""
SET logfilename=crprocs_cfbam23.log
IF NOT "%1" == "" SET sybsrv=%1
IF NOT "%2" == "" SET sybdb=%2
IF NOT "%3" == "" SET sybuser=%3
IF NOT "%4" == "" SET sybpwd=%4
IF NOT "%5" == "" SET logfilename=%5

IF "%sybsrv%" == "" (
	ECHO "ERROR: Sybase server must be specified as 1st argument"
	PAUSE
	EXIT
)

IF "%sybdb%" == "" (
	ECHO "ERROR: Database must be specified as 2nd argument"
	PAUSE
	EXIT
)

IF "%sybuser%" == "" (
	ECHO "ERROR: User must be specified as 3rd argument"
	PAUSE
	EXIT
)

IF "%sybpwd%" == "" (
	ECHO "ERROR: Password must be specified as 4th argument"
	PAUSE
	EXIT
)

REM
REM	Define commands to use for running scripts
REM
SET cmdappdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D %sybdb% -e 
SET cmdmasterdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D master -e 
SET cmdmodeldb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D model -e 
SET cmdtempdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D tempdb -e 

%cmdappdb% <crsp_is_system_user.isql >>%logfilename%
%cmdappdb% <crsp_is_cluster_user.isql >>%logfilename%
%cmdappdb% <crsp_is_tenant_user.isql >>%logfilename%
%cmdappdb% <crsp_next_servicetypeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_mimetypeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_clusteridgen.isql >>%logfilename%
%cmdappdb% <crsp_next_tenantidgen.isql >>%logfilename%

%cmdappdb% <crsp_next_secappidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_secformidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_secgroupidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_secgroupmemberidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_secgroupincludeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_secgroupformidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_serviceidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_hostnodeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_tsecgroupidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_tsecgroupmemberidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_tsecgroupincludeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_tldidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_domainidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_scopeidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_indexcolidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_licenseidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_relationcolidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_valueidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_enumtagidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_chainidgen.isql >>%logfilename%
%cmdappdb% <crsp_next_paramidgen.isql >>%logfilename%

%cmdappdb% <crsp_bootstrap.isql >>%logfilename%

%cmdappdb% <crsp_audit_enum_tag.isql >>%logfilename%
%cmdappdb% <crsp_audit_idxcol.isql >>%logfilename%
%cmdappdb% <crsp_audit_srvprm.isql >>%logfilename%
%cmdappdb% <crsp_audit_relcol.isql >>%logfilename%
%cmdappdb% <crsp_audit_valdef.isql >>%logfilename%

%cmdappdb% <crsp_create_auditaction.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_auditaction.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_auditaction.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_auditaction_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_auditaction_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_auditaction_by_udescridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_auditaction.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_auditaction.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clus_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clus_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clus_by_udomainnameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clus_by_udescridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clus.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_hostnode.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_hostnode.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode_by_udescridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostnode_by_hostnameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_hostnode.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_hostnode.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secapp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secapp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secapp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secapp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secapp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secapp_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secapp_by_ujeemountidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secapp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secapp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secform.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secform.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform_by_secappidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secform_by_ujeeservletidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secform.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secform.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrp_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secgrp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secgrpfrm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secgrpfrm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_groupidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_appidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_formidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secgrpfrm_by_uformidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secgrpfrm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secgrpfrm.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_by_groupidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_by_includeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secinc_by_uincludeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secinc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_by_groupidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_by_useridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secmemb_by_uuseridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secmemb.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secsess.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secsess.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_secuseridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_secdevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_startidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_finishidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secsess_by_secproxyidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secsess.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secsess.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secuser.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secuser.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_by_uloginidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_by_emconfidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_by_pwdresetidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secuser_by_defdevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secuser.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secuser.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_hostsvc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_hostsvc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_hostidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_typeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_utypeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_hostsvc_by_uhostportidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_hostsvc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_hostsvc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_svctype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_svctype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_svctype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_svctype_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_svctype_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_svctype_by_udescridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_svctype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_svctype.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tenant.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tenant.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tenant.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tenant_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tenant_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tenant_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tenant_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tenant.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tenant.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_delete_auditaction_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_auditaction_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clus_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clus_by_udomainnameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clus_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_hostnode_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_udescridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_hostnameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secapp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secapp_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secapp_by_ujeemountidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secform_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_secappidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_ujeeservletidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secgrp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrp_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrp_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secgrpfrm_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_appidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_formidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_uformidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secinc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_includeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_uincludeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secmemb_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_useridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_uuseridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secsess_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secuseridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secdevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_startidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_finishidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secproxyidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secuser_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_uloginidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_emconfidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_pwdresetidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_defdevidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_hostsvc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_hostidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_typeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_utypeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_uhostportidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_svctype_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_svctype_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tenant_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tenant_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tenant_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_create_tsecgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tsecgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecgrp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecgrp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecgrp_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecgrp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tsecgrp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tsecgrp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tsecinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tsecinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_by_groupidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_by_includeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecinc_by_uincludeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tsecinc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tsecinc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tsecmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tsecmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_by_groupidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_by_useridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsecmemb_by_uuseridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tsecmemb.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tsecmemb.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_delete_tsecgrp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecgrp_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecgrp_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsecinc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_includeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_uincludeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsecmemb_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_useridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_uuseridx.isql >>%logfilename%

%cmdappdb% <crsp_create_iso_cntry.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_iso_cntry.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntry.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntry_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntry_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntry_by_isocodeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntry_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_iso_cntry.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_iso_cntry.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_iso_cntryccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_iso_cntryccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntryccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntryccy_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntryccy_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntryccy_by_countryidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntryccy_by_currencyidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_iso_cntryccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_iso_cntryccy.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_iso_cntrylng.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_iso_cntrylng.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntrylng.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntrylng_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntrylng_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntrylng_by_countryidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_cntrylng_by_languageidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_iso_cntrylng.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_iso_cntrylng.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_iso_ccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_iso_ccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_ccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_ccy_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_ccy_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_ccy_by_ccycdidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_ccy_by_ccynmidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_iso_ccy.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_iso_ccy.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_iso_lang.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_iso_lang.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang_by_baseidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang_by_countryidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_iso_lang_by_codeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_iso_lang.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_iso_lang.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_isotz.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_isotz.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz_by_offsetidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz_by_utznameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_isotz_by_iso8601idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_isotz.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_isotz.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_delete_iso_cntry_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntry_by_isocodeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntry_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_cntryccy_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntryccy_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntryccy_by_currencyidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_cntrylng_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntrylng_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntrylng_by_languageidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_ccy_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_ccy_by_ccycdidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_ccy_by_ccynmidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_lang_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_baseidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_codeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_isotz_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_offsetidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_utznameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_iso8601idx.isql >>%logfilename%

%cmdappdb% <crsp_create_domdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_domdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef_by_subdomidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_domdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_domdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_domdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_bdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_bdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bdomdef_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_bdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_bdomdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_mjverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_mjverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef_by_pprjidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mjverdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_mjverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_mjverdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_mimetype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_mimetype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mimetype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mimetype_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mimetype_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mimetype_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_mimetype.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_mimetype.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_mnverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_mnverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef_by_majoridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_mnverdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_mnverdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_mnverdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_bprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_bprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_bprjdef_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_bprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_bprjdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_rprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_rprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rprjdef_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_rprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_rprjdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_sprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_sprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef_by_parentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sprjdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_sprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_sprjdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tlddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tlddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tlddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tlddef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tlddef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tlddef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tlddef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tlddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tlddef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef_by_tldidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tdomdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tdomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tdomdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef_by_domainidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tprjdef_by_nameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tprjdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tprjdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_urlproto.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_urlproto.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_urlproto.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_urlproto_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_urlproto_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_urlproto_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_urlproto_by_issecureidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_urlproto.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_urlproto.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_verndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_verndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_verndef_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_verndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_verndef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_delete_domdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_subdomidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_bdomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_bdomdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mjverdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_pprjidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mimetype_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mimetype_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mnverdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_majoridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_bprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_bprjdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_rprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_rprjdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_sprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_parentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tlddef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tlddef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tlddef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tdomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_tldidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_urlproto_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_urlproto_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_urlproto_by_issecureidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_verndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_verndef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_create_accfreq.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_accfreq.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accfreq.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accfreq_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accfreq_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accfreq_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_accfreq.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_accfreq.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_accsec.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_accsec.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accsec.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accsec_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accsec_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_accsec_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_accsec.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_accsec.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_atomdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_atomdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_atomdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_lock_blbcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_blbcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_blbcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_blbcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_lock_blbdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_blbdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_blbdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_blbdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_lock_blbtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_blbtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_blbtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_blbtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_blbtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_boolcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_boolcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_boolcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booldef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_booldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_booldef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_booltyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_booltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_booltyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_chain_def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_chain_def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_prevrelidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_chain_def_by_nextrelidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_chain_def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_chain_def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clr_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clr_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_dep_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clr_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clr_dep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clrsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clrsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_by_contcleartopidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep1_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clrsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clrsubdep1.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clrsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clrsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_by_contcleardep1idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep2_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clrsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clrsubdep2.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clrsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clrsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_by_contcleardep2idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clrsubdep3_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clrsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clrsubdep3.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_clr_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_clr_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_by_conttblidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_clr_topdep_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_clr_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_clr_topdep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_datascope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_datascope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_datascope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_datascope_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_datascope_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_datascope_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_datascope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_datascope.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dtcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dtdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dtdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dttyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dttyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_del_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_del_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_dep_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_del_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_del_dep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_delsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_delsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_contdeltopidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep1_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_delsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_delsubdep1.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_delsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_delsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_contdeldep1idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep2_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_delsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_delsubdep2.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_delsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_delsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_contdeldep2idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_delsubdep3_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_delsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_delsubdep3.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_del_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_del_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_conttblidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_del_topdep_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_del_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_del_topdep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dblcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dblcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbldef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dbldef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dbltyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dbltyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dbltyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_enumcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_enumcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_enumdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_enumdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_enumtagtenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_enumidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_enumnameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enum_tag_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_enum_tag.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_enum_tag.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_enumtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_enumtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_enumtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_fltcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_fltcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_fltdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_fltdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_fltdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_flttyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_flttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_flttyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg16_by_dispidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_idg16.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idg16.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg32_by_dispidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_idg32.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idg32.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idg64_by_dispidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_idg64.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idg64.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idxdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idxdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_indextenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idxdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idxdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_idxcoltenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_indexidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_colidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_idxprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idxcol_by_idxnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_idxcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idxcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int16col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int16def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int16typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int16typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int32col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int32def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int32typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int32typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int64col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int64def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_int64typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_int64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_int64typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_licn.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_licn.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn_by_licntenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn_by_domainidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_licn_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_licn.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_licn.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_loadbehav.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_loadbehav.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_loadbehav.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_loadbehav_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_loadbehav_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_loadbehav_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_loadbehav.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_loadbehav.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkncol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtkncol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkndef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtkndef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtkntyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtkntyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknscol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtknscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtknscol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknsdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtknsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtknsdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_nmtknstyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_nmtknstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_nmtknstyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_numcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_numcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_numdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_numdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_numtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_numtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_numtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_servermethodidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_servertypeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprm_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_srvprm.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_srvprm.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_pop_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_pop_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_dep_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_pop_dep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_pop_dep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_popsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_popsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_contpoptopidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep1_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_popsubdep1.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_popsubdep1.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_popsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_popsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_contpopdep1idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep2_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_popsubdep2.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_popsubdep2.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_popsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_popsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_contpopdep2idx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_popsubdep3_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_popsubdep3.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_popsubdep3.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_pop_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_pop_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_contrelidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_pop_topdep_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_pop_topdep.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_pop_topdep.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_reldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_reldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_relntenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_rtypekeyidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_fromkeyidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_totblidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_tokeyidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_reldef_by_narrowedidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_reldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_reldef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_relcoltenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_relationidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_fromcolidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_tocolidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_relprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_relcol_by_relnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_relcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_relcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_rel_type.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_rel_type.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rel_type.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rel_type_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rel_type_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_rel_type_by_utagidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_rel_type.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_rel_type.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_schemadef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_schemadef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_ctenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_domainidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_deflcnidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schemadef_by_puburiidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_schemadef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_schemadef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_schema_ref.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_schema_ref.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_schema_ref_by_refschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_schema_ref.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_schema_ref.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_scopedef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_scopedef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_scopedef_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_scopedef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_scopedef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secdev.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secdev.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secdev.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secdev_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secdev_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secdev_by_useridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secdev.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secdev.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_secscope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_secscope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secscope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secscope_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secscope_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_secscope_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_secscope.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_secscope.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_srvlfunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_srvlfunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvlfunc_by_rettblidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_srvlfunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_srvlfunc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_srvmeth.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_srvmeth.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_cc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvmeth_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_srvmeth.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_srvmeth.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_srvofunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_srvofunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvofunc_by_rettblidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_srvofunc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_srvofunc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_srvprc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_srvprc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_srvprc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_srvprc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_srvprc.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_strcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_strcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_strdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_strdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_strtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_strtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_strtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_sysclus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_sysclus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sysclus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sysclus_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sysclus_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_sysclus_by_clusteridx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_sysclus.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_sysclus.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dzcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dzdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dzdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_dztyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_dztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_dztyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmzcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmzcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmzdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmzdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmzdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmztyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmztyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmztyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zscol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_zscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_zscol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zsdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_zsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_zsdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_zstyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_zstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_zstyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_tenantidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_schemadefidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_schemacdidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_primaryindexidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_lookupindexidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_altindexidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_qualtableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_loadbehaveidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_secscopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tbldef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tbldef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tbldef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tblcol_by_dataidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tblcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tblcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_txtcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_txtcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txtdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_txtdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_txtdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_txttyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_txttyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_txttyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tmtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tmtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tmtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tscol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tscol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tscol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tsdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tsdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tsdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tstyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tstyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tstyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkncol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tkncol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tkncol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkndef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tkndef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tkndef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_tkntyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_tkntyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_tkntyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint16col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint16col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u16def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_u16def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_u16def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint16typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint16typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint16typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint32col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint32col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u32def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_u32def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_u32def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint32typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint32typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint32typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64col_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint64col.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint64col.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_u64def_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_u64def.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_u64def.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uint64typ_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uint64typ.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uint64typ.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidcol_by_tableidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uuidcol.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uuidcol.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuiddef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uuiddef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uuiddef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_idguuid_by_dispidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_idguuid.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_idguuid.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_uuidtyp_by_schemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_uuidtyp.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_uuidtyp.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_create_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_lock_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_all.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_ididx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_unameidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_valtentidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_scopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_defschemaidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_datascopeidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_vaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_vaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_eaccsecidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_eaccfreqidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_previdx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_nextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_contprevidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_read_valdef_cc_by_contnextidx.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_update_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_moveup_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_movedown_valdef.isql >>%logfilename% 2>&1
%cmdappdb% <crsp_delete_valdef.isql >>%logfilename% 2>&1

%cmdappdb% <crsp_delete_accfreq_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_accfreq_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_accsec_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_accsec_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_atomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_boolcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_booldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_booltyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_chain_def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_prevrelidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_nextrelidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clr_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_dep_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_contcleartopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_contcleardep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_contcleardep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clr_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_conttblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_datascope_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_datascope_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dtcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dtdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_del_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_contdeltopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_contdeldep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_contdeldep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_del_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_conttblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dblcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dbldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dbltyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enum_tag_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumtagtenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumnameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_nextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_fltcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_fltdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_flttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg16_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg32_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg64_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idxdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_indextenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idxcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxcoltenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_indexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_colidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_licn_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_licntenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_loadbehav_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_loadbehav_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkncol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkntyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvprm_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_servermethodidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_servertypeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_pop_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_contpoptopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_contpopdep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_contpopdep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_pop_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_contrelidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_reldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_relntenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_rtypekeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_fromkeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_totblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tokeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_narrowedidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_relcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relcoltenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_fromcolidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_tocolidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_rel_type_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_rel_type_by_utagidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_schemadef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_ctenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_deflcnidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_puburiidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_schema_ref_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_refschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_scopedef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_scopedef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secdev_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secdev_by_useridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secscope_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secscope_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvlfunc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_rettblidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvmeth_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvofunc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_rettblidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvprc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_sysclus_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sysclus_by_clusteridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dzcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dzdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dztyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmzcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmzdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmztyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tbldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_schemadefidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_schemacdidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_primaryindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_lookupindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_altindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_qualtableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_loadbehaveidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_secscopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_eaccfreqidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tblcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_dataidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txtcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txtdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkncol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkntyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint16col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u16def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint16typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint32col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u32def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint32typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint64col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u64def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint64typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuidcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuiddef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idguuid_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuidtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_valdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_contnextidx.isql >>%logfilename%


%cmdappdb% <crsp_delete_accfreq_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_accfreq_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_accsec_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_accsec_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_atomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_atomdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_auditaction_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_auditaction_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_blbtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_blbtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_boolcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_boolcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_booldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booldef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_booltyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_booltyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_chain_def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_prevrelidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_chain_def_by_nextrelidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clr_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_dep_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_contcleartopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_contcleardep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clrsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_contcleardep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clrsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clr_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_conttblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clr_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_clus_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clus_by_udomainnameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_clus_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_datascope_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_datascope_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dtcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dtdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dtdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_del_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_dep_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_contdeltopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_contdeldep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_delsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_contdeldep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_delsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_del_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_conttblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_del_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_domdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_subdomidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_domdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_bdomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_bdomdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dblcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dblcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dbldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbldef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dbltyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dbltyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enum_tag_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumtagtenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_enumnameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enum_tag_by_nextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_enumtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_enumtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_fltcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_fltdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_fltdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_flttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_flttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_hostnode_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_udescridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostnode_by_hostnameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_cntry_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntry_by_isocodeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntry_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_cntryccy_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntryccy_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntryccy_by_currencyidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_cntrylng_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntrylng_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_cntrylng_by_languageidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_ccy_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_ccy_by_ccycdidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_ccy_by_ccynmidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_iso_lang_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_baseidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_countryidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_iso_lang_by_codeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_isotz_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_offsetidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_utznameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_isotz_by_iso8601idx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg16_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg16_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg32_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg32_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idg64_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idg64_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idxdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_indextenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxdef_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idxcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxcoltenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_indexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_colidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idxcol_by_idxnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int16typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int16typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int32typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int32typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_int64typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_int64typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_licn_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_licntenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_licn_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_loadbehav_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_loadbehav_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mjverdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_pprjidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mjverdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mimetype_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mimetype_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_mnverdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_majoridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_mnverdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkncol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkncol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkndef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtkntyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtkntyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_nmtknstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_nmtknstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_numtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_numtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvprm_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_servermethodidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_servertypeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprm_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_pop_dep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_dep_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep1_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_contpoptopidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep1_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep2_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_contpopdep1idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep2_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_popsubdep3_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_contpopdep2idx.isql >>%logfilename%
%cmdappdb% <crsp_delete_popsubdep3_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_pop_topdep_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_contrelidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_pop_topdep_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_bprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_bprjdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_rprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_rprjdef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_reldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_relntenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_rtypekeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_fromkeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_totblidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_tokeyidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_reldef_by_narrowedidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_relcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relcoltenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relationidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_fromcolidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_tocolidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_relcol_by_relnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_rel_type_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_rel_type_by_utagidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_schemadef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_ctenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_deflcnidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schemadef_by_puburiidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_schema_ref_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_schema_ref_by_refschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_scopedef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_scopedef_by_tenantidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secapp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secapp_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secapp_by_ujeemountidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secdev_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secdev_by_useridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secform_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_secappidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secform_by_ujeeservletidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secgrp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrp_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrp_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secgrpfrm_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_appidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_formidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secgrpfrm_by_uformidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secinc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_includeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secinc_by_uincludeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secmemb_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_useridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secmemb_by_uuseridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secsess_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secuseridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secdevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_startidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_finishidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secsess_by_secproxyidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secuser_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_uloginidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_emconfidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_pwdresetidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secuser_by_defdevidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_secscope_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_secscope_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvlfunc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvlfunc_by_rettblidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvmeth_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvmeth_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvofunc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvofunc_by_rettblidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_srvprc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_srvprc_by_defschemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_hostsvc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_hostidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_typeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_utypeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_hostsvc_by_uhostportidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_svctype_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_svctype_by_udescridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_strtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_strtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_sprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_parentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sprjdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_sysclus_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_sysclus_by_clusteridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsecgrp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecgrp_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecgrp_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsecinc_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_includeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecinc_by_uincludeidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsecmemb_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_groupidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_useridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsecmemb_by_uuseridx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dzcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dzdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dzdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_dztyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_dztyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmzcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmzdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmzdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmztyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmztyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_zstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_zstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tbldef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_schemadefidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_schemacdidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_primaryindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_lookupindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_altindexidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_qualtableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_loadbehaveidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_secscopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tbldef_by_eaccfreqidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tblcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_tableidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tblcol_by_dataidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tenant_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tenant_by_clusteridx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tenant_by_unameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txtcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txtdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txtdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_txttyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_txttyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tmtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tmtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tscol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tscol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tsdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tsdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tstyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tstyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tlddef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tlddef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tlddef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkncol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkncol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkndef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tkntyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tkntyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tdomdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_tldidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tdomdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_tprjdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_tenantidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_domainidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_tprjdef_by_nameidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint16col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u16def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u16def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint16typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint16typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint32col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u32def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u32def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint32typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint32typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint64col_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64col_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_u64def_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_u64def_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uint64typ_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uint64typ_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_urlproto_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_urlproto_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_urlproto_by_issecureidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuidcol_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidcol_by_tableidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuiddef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuiddef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_idguuid_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_schemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_idguuid_by_dispidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_uuidtyp_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_contnextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_uuidtyp_by_schemaidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_valdef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_unameidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_valtentidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_scopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_defschemaidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_datascopeidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_vaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_vaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_eaccsecidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_eaccfreqidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_previdx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_nextidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_contprevidx.isql >>%logfilename%
%cmdappdb% <crsp_delete_valdef_by_contnextidx.isql >>%logfilename%

%cmdappdb% <crsp_delete_verndef_by_ididx.isql >>%logfilename%
%cmdappdb% <crsp_delete_verndef_by_tenantidx.isql >>%logfilename%


