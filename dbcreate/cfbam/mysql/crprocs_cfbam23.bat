@echo off
REM
REM	@(#) dbcreate/cfbam/mysql/crprocs_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2014-2015 Mark Sobkow
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
REM **********************************************************************

REM
REM	Manufactured by MSS Code Factory
REM
REM
REM	Initialize locals
REM

SET mysqlpwd=""
SET mysqluser=""
SET logfilename=crprocs_cfbam23.log
SET TK_DUALCASE_IN_CASE_STATEMENTS=true

IF NOT "%1" == "" SET mysqluser=%1
IF NOT "%2" == "" SET mysqlpwd=%2
IF NOT "%3" == "" SET logfilename=%3

REM
REM	Validate parameters
REM

IF "%mysqluser%" == "" (
	ECHO ERROR: MySQL DBA login not specified as argument 1
	PAUSE
	EXIT
)

IF "%mysqlpwd%" == "" (
	ECHO ERROR: Password must be specified as argument 2 >&2
	PAUSE
	EXIT
)

echo crsp_next_servicetypeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_servicetypeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_mimetypeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_mimetypeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_clusteridgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_clusteridgen.mysql >>%logfilename% 2>&1
echo crsp_next_tenantidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_tenantidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secappidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secappidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secformidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secformidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secgroupidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secgroupidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secgroupmemberidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secgroupmemberidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secgroupincludeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secgroupincludeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_secgroupformidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_secgroupformidgen.mysql >>%logfilename% 2>&1
echo crsp_next_serviceidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_serviceidgen.mysql >>%logfilename% 2>&1
echo crsp_next_hostnodeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_hostnodeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_tsecgroupidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_tsecgroupidgen.mysql >>%logfilename% 2>&1
echo crsp_next_tsecgroupmemberidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_tsecgroupmemberidgen.mysql >>%logfilename% 2>&1
echo crsp_next_tsecgroupincludeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_tsecgroupincludeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_tldidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_tldidgen.mysql >>%logfilename% 2>&1
echo crsp_next_domainidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_domainidgen.mysql >>%logfilename% 2>&1
echo crsp_next_scopeidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_scopeidgen.mysql >>%logfilename% 2>&1
echo crsp_next_indexcolidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_indexcolidgen.mysql >>%logfilename% 2>&1
echo crsp_next_licenseidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_licenseidgen.mysql >>%logfilename% 2>&1
echo crsp_next_relationcolidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_relationcolidgen.mysql >>%logfilename% 2>&1
echo crsp_next_valueidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_valueidgen.mysql >>%logfilename% 2>&1
echo crsp_next_enumtagidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_enumtagidgen.mysql >>%logfilename% 2>&1
echo crsp_next_chainidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_chainidgen.mysql >>%logfilename% 2>&1
echo crsp_next_paramidgen.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_next_paramidgen.mysql >>%logfilename% 2>&1
echo crsp_bootstrap.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_bootstrap.mysql >>%logfilename% 2>&1
echo crsp_is_system_user.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_is_system_user.mysql >>%logfilename% 2>&1
echo crsp_is_cluster_user.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_is_cluster_user.mysql >>%logfilename% 2>&1
echo crsp_is_tenant_user.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_is_tenant_user.mysql >>%logfilename% 2>&1
echo crsp_audit_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_audit_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_audit_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_audit_idxcol.mysql >>%logfilename% 2>&1
echo crsp_audit_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_audit_srvprm.mysql >>%logfilename% 2>&1
echo crsp_audit_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_audit_relcol.mysql >>%logfilename% 2>&1
echo crsp_audit_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_audit_valdef.mysql >>%logfilename% 2>&1
echo crsp_create_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_accfreq.mysql >>%logfilename% 2>&1
echo crsp_lock_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_accfreq.mysql >>%logfilename% 2>&1
echo crsp_read_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accfreq.mysql >>%logfilename% 2>&1
echo crsp_read_accfreq_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accfreq_all.mysql >>%logfilename% 2>&1
echo crsp_read_accfreq_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accfreq_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_accfreq_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accfreq_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_accfreq.mysql >>%logfilename% 2>&1
echo crsp_delete_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accfreq.mysql >>%logfilename% 2>&1

echo crsp_create_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_accsec.mysql >>%logfilename% 2>&1
echo crsp_lock_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_accsec.mysql >>%logfilename% 2>&1
echo crsp_read_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accsec.mysql >>%logfilename% 2>&1
echo crsp_read_accsec_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accsec_all.mysql >>%logfilename% 2>&1
echo crsp_read_accsec_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accsec_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_accsec_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_accsec_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_accsec.mysql >>%logfilename% 2>&1
echo crsp_delete_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accsec.mysql >>%logfilename% 2>&1

echo crsp_create_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_atomdef.mysql >>%logfilename% 2>&1
echo crsp_lock_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_atomdef.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_atomdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_atomdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_atomdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_atomdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_atomdef.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef.mysql >>%logfilename% 2>&1

echo crsp_create_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_auditaction.mysql >>%logfilename% 2>&1
echo crsp_lock_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_auditaction.mysql >>%logfilename% 2>&1
echo crsp_read_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_auditaction.mysql >>%logfilename% 2>&1
echo crsp_read_auditaction_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_auditaction_all.mysql >>%logfilename% 2>&1
echo crsp_read_auditaction_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_auditaction_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_auditaction_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_auditaction_by_udescridx.mysql >>%logfilename% 2>&1
echo crsp_update_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_auditaction.mysql >>%logfilename% 2>&1
echo crsp_delete_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_auditaction.mysql >>%logfilename% 2>&1

echo crsp_create_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_blbcol.mysql >>%logfilename% 2>&1
echo crsp_lock_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_blbcol.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_blbcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_blbcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_blbcol.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol.mysql >>%logfilename% 2>&1

echo crsp_create_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_blbdef.mysql >>%logfilename% 2>&1
echo crsp_lock_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_blbdef.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_blbdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_blbdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_blbdef.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef.mysql >>%logfilename% 2>&1

echo crsp_create_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_blbtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_blbtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_blbtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp.mysql >>%logfilename% 2>&1

echo crsp_create_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_boolcol.mysql >>%logfilename% 2>&1
echo crsp_lock_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_boolcol.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_boolcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_boolcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_boolcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_boolcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_boolcol.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol.mysql >>%logfilename% 2>&1

echo crsp_create_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_booldef.mysql >>%logfilename% 2>&1
echo crsp_lock_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_booldef.mysql >>%logfilename% 2>&1
echo crsp_read_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_all.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_booldef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booldef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_booldef.mysql >>%logfilename% 2>&1
echo crsp_moveup_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_booldef.mysql >>%logfilename% 2>&1
echo crsp_movedown_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_booldef.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef.mysql >>%logfilename% 2>&1

echo crsp_create_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_booltyp.mysql >>%logfilename% 2>&1
echo crsp_lock_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_booltyp.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_booltyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_booltyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_booltyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_booltyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_booltyp.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp.mysql >>%logfilename% 2>&1

echo crsp_create_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_chain_def.mysql >>%logfilename% 2>&1
echo crsp_lock_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_chain_def.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_all.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_prevrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_prevrelidx.mysql >>%logfilename% 2>&1
echo crsp_read_chain_def_by_nextrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_chain_def_by_nextrelidx.mysql >>%logfilename% 2>&1
echo crsp_update_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_chain_def.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def.mysql >>%logfilename% 2>&1

echo crsp_create_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clr_dep.mysql >>%logfilename% 2>&1
echo crsp_lock_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clr_dep.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_cc.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_all.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_dep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_dep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clr_dep.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_dep.mysql >>%logfilename% 2>&1

echo crsp_create_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clrsubdep1.mysql >>%logfilename% 2>&1
echo crsp_lock_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clrsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_all.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_by_contcleartopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_by_contcleartopidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep1_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clrsubdep1.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1.mysql >>%logfilename% 2>&1

echo crsp_create_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clrsubdep2.mysql >>%logfilename% 2>&1
echo crsp_lock_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clrsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_all.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_by_contcleardep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_by_contcleardep1idx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep2_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clrsubdep2.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2.mysql >>%logfilename% 2>&1

echo crsp_create_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clrsubdep3.mysql >>%logfilename% 2>&1
echo crsp_lock_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clrsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_all.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_by_contcleardep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_by_contcleardep2idx.mysql >>%logfilename% 2>&1
echo crsp_read_clrsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clrsubdep3_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clrsubdep3.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3.mysql >>%logfilename% 2>&1

echo crsp_create_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clr_topdep.mysql >>%logfilename% 2>&1
echo crsp_lock_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clr_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_all.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_by_conttblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_by_conttblidx.mysql >>%logfilename% 2>&1
echo crsp_read_clr_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clr_topdep_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clr_topdep.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep.mysql >>%logfilename% 2>&1

echo crsp_create_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_clus.mysql >>%logfilename% 2>&1
echo crsp_lock_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_clus.mysql >>%logfilename% 2>&1
echo crsp_read_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clus.mysql >>%logfilename% 2>&1
echo crsp_read_clus_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clus_all.mysql >>%logfilename% 2>&1
echo crsp_read_clus_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clus_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_clus_by_udomainnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clus_by_udomainnameidx.mysql >>%logfilename% 2>&1
echo crsp_read_clus_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_clus_by_udescridx.mysql >>%logfilename% 2>&1
echo crsp_update_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_clus.mysql >>%logfilename% 2>&1
echo crsp_delete_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clus.mysql >>%logfilename% 2>&1

echo crsp_create_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_datascope.mysql >>%logfilename% 2>&1
echo crsp_lock_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_datascope.mysql >>%logfilename% 2>&1
echo crsp_read_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_datascope.mysql >>%logfilename% 2>&1
echo crsp_read_datascope_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_datascope_all.mysql >>%logfilename% 2>&1
echo crsp_read_datascope_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_datascope_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_datascope_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_datascope_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_datascope.mysql >>%logfilename% 2>&1
echo crsp_delete_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_datascope.mysql >>%logfilename% 2>&1

echo crsp_create_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dtcol.mysql >>%logfilename% 2>&1
echo crsp_lock_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dtcol.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dtcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dtcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dtcol.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol.mysql >>%logfilename% 2>&1

echo crsp_create_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dtdef.mysql >>%logfilename% 2>&1
echo crsp_lock_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dtdef.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dtdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dtdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dtdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dtdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dtdef.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef.mysql >>%logfilename% 2>&1

echo crsp_create_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dttyp.mysql >>%logfilename% 2>&1
echo crsp_lock_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dttyp.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dttyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dttyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dttyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dttyp.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp.mysql >>%logfilename% 2>&1

echo crsp_create_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_del_dep.mysql >>%logfilename% 2>&1
echo crsp_lock_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_del_dep.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_cc.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_all.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_dep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_dep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_del_dep.mysql >>%logfilename% 2>&1
echo crsp_delete_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_dep.mysql >>%logfilename% 2>&1

echo crsp_create_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_delsubdep1.mysql >>%logfilename% 2>&1
echo crsp_lock_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_delsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_all.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_contdeltopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_contdeltopidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep1_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_delsubdep1.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1.mysql >>%logfilename% 2>&1

echo crsp_create_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_delsubdep2.mysql >>%logfilename% 2>&1
echo crsp_lock_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_delsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_all.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_contdeldep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_contdeldep1idx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep2_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_delsubdep2.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2.mysql >>%logfilename% 2>&1

echo crsp_create_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_delsubdep3.mysql >>%logfilename% 2>&1
echo crsp_lock_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_delsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_all.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_contdeldep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_contdeldep2idx.mysql >>%logfilename% 2>&1
echo crsp_read_delsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_delsubdep3_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_delsubdep3.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3.mysql >>%logfilename% 2>&1

echo crsp_create_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_del_topdep.mysql >>%logfilename% 2>&1
echo crsp_lock_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_del_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_all.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_conttblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_conttblidx.mysql >>%logfilename% 2>&1
echo crsp_read_del_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_del_topdep_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_del_topdep.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep.mysql >>%logfilename% 2>&1

echo crsp_create_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_domdef.mysql >>%logfilename% 2>&1
echo crsp_lock_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_domdef.mysql >>%logfilename% 2>&1
echo crsp_read_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef.mysql >>%logfilename% 2>&1
echo crsp_read_domdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_domdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_domdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_domdef_by_subdomidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef_by_subdomidx.mysql >>%logfilename% 2>&1
echo crsp_read_domdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_domdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_domdef.mysql >>%logfilename% 2>&1
echo crsp_delete_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_domdef.mysql >>%logfilename% 2>&1

echo crsp_create_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_bdomdef.mysql >>%logfilename% 2>&1
echo crsp_lock_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_bdomdef.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_bdomdef_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bdomdef_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_update_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_bdomdef.mysql >>%logfilename% 2>&1
echo crsp_delete_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bdomdef.mysql >>%logfilename% 2>&1

echo crsp_create_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dblcol.mysql >>%logfilename% 2>&1
echo crsp_lock_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dblcol.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dblcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dblcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dblcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dblcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dblcol.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol.mysql >>%logfilename% 2>&1

echo crsp_create_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dbldef.mysql >>%logfilename% 2>&1
echo crsp_lock_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dbldef.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_all.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbldef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbldef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dbldef.mysql >>%logfilename% 2>&1
echo crsp_moveup_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dbldef.mysql >>%logfilename% 2>&1
echo crsp_movedown_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dbldef.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef.mysql >>%logfilename% 2>&1

echo crsp_create_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_lock_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dbltyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dbltyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dbltyp.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp.mysql >>%logfilename% 2>&1

echo crsp_create_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_enumcol.mysql >>%logfilename% 2>&1
echo crsp_lock_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_enumcol.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_enumcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_enumcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_enumcol.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol.mysql >>%logfilename% 2>&1

echo crsp_create_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_enumdef.mysql >>%logfilename% 2>&1
echo crsp_lock_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_enumdef.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_enumdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_enumdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_enumdef.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef.mysql >>%logfilename% 2>&1

echo crsp_create_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_lock_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_all.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_enumtagtenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_enumtagtenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_enumidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_enumidx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_enumnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_enumnameidx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_enum_tag_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enum_tag_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_update_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_moveup_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_movedown_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_enum_tag.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag.mysql >>%logfilename% 2>&1

echo crsp_create_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_enumtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_enumtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_enumtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp.mysql >>%logfilename% 2>&1

echo crsp_create_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_fltcol.mysql >>%logfilename% 2>&1
echo crsp_lock_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_fltcol.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_fltcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_fltcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_fltcol.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol.mysql >>%logfilename% 2>&1

echo crsp_create_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_fltdef.mysql >>%logfilename% 2>&1
echo crsp_lock_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_fltdef.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_fltdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_fltdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_fltdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_fltdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_fltdef.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef.mysql >>%logfilename% 2>&1

echo crsp_create_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_flttyp.mysql >>%logfilename% 2>&1
echo crsp_lock_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_flttyp.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_flttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_flttyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_flttyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_flttyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_flttyp.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp.mysql >>%logfilename% 2>&1

echo crsp_create_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_hostnode.mysql >>%logfilename% 2>&1
echo crsp_lock_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_hostnode.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode_all.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode_by_udescridx.mysql >>%logfilename% 2>&1
echo crsp_read_hostnode_by_hostnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostnode_by_hostnameidx.mysql >>%logfilename% 2>&1
echo crsp_update_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_hostnode.mysql >>%logfilename% 2>&1
echo crsp_delete_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostnode.mysql >>%logfilename% 2>&1

echo crsp_create_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_iso_cntry.mysql >>%logfilename% 2>&1
echo crsp_lock_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_iso_cntry.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntry.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntry_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntry_all.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntry_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntry_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntry_by_isocodeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntry_by_isocodeidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntry_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntry_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_iso_cntry.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntry.mysql >>%logfilename% 2>&1

echo crsp_create_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crsp_lock_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntryccy_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntryccy_all.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntryccy_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntryccy_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntryccy_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntryccy_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntryccy_by_currencyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntryccy_by_currencyidx.mysql >>%logfilename% 2>&1
echo crsp_update_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntryccy.mysql >>%logfilename% 2>&1

echo crsp_create_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crsp_lock_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntrylng_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntrylng_all.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntrylng_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntrylng_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntrylng_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntrylng_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_cntrylng_by_languageidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_cntrylng_by_languageidx.mysql >>%logfilename% 2>&1
echo crsp_update_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntrylng.mysql >>%logfilename% 2>&1

echo crsp_create_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_iso_ccy.mysql >>%logfilename% 2>&1
echo crsp_lock_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_iso_ccy.mysql >>%logfilename% 2>&1
echo crsp_read_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_ccy.mysql >>%logfilename% 2>&1
echo crsp_read_iso_ccy_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_ccy_all.mysql >>%logfilename% 2>&1
echo crsp_read_iso_ccy_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_ccy_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_ccy_by_ccycdidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_ccy_by_ccycdidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_ccy_by_ccynmidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_ccy_by_ccynmidx.mysql >>%logfilename% 2>&1
echo crsp_update_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_iso_ccy.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_ccy.mysql >>%logfilename% 2>&1

echo crsp_create_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_iso_lang.mysql >>%logfilename% 2>&1
echo crsp_lock_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_iso_lang.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang_all.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang_by_baseidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang_by_baseidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_read_iso_lang_by_codeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_iso_lang_by_codeidx.mysql >>%logfilename% 2>&1
echo crsp_update_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_iso_lang.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_lang.mysql >>%logfilename% 2>&1

echo crsp_create_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_isotz.mysql >>%logfilename% 2>&1
echo crsp_lock_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_isotz.mysql >>%logfilename% 2>&1
echo crsp_read_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz.mysql >>%logfilename% 2>&1
echo crsp_read_isotz_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz_all.mysql >>%logfilename% 2>&1
echo crsp_read_isotz_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_isotz_by_offsetidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz_by_offsetidx.mysql >>%logfilename% 2>&1
echo crsp_read_isotz_by_utznameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz_by_utznameidx.mysql >>%logfilename% 2>&1
echo crsp_read_isotz_by_iso8601idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_isotz_by_iso8601idx.mysql >>%logfilename% 2>&1
echo crsp_update_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_isotz.mysql >>%logfilename% 2>&1
echo crsp_delete_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_isotz.mysql >>%logfilename% 2>&1

echo crsp_create_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idg16.mysql >>%logfilename% 2>&1
echo crsp_lock_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idg16.mysql >>%logfilename% 2>&1
echo crsp_read_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_all.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg16_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg16_by_dispidx.mysql >>%logfilename% 2>&1
echo crsp_update_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idg16.mysql >>%logfilename% 2>&1
echo crsp_moveup_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_idg16.mysql >>%logfilename% 2>&1
echo crsp_movedown_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_idg16.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16.mysql >>%logfilename% 2>&1

echo crsp_create_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idg32.mysql >>%logfilename% 2>&1
echo crsp_lock_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idg32.mysql >>%logfilename% 2>&1
echo crsp_read_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_all.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg32_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg32_by_dispidx.mysql >>%logfilename% 2>&1
echo crsp_update_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idg32.mysql >>%logfilename% 2>&1
echo crsp_moveup_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_idg32.mysql >>%logfilename% 2>&1
echo crsp_movedown_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_idg32.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32.mysql >>%logfilename% 2>&1

echo crsp_create_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idg64.mysql >>%logfilename% 2>&1
echo crsp_lock_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idg64.mysql >>%logfilename% 2>&1
echo crsp_read_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_all.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idg64_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idg64_by_dispidx.mysql >>%logfilename% 2>&1
echo crsp_update_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idg64.mysql >>%logfilename% 2>&1
echo crsp_moveup_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_idg64.mysql >>%logfilename% 2>&1
echo crsp_movedown_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_idg64.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64.mysql >>%logfilename% 2>&1

echo crsp_create_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idxdef.mysql >>%logfilename% 2>&1
echo crsp_lock_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idxdef.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_indextenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_indextenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idxdef.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef.mysql >>%logfilename% 2>&1

echo crsp_create_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idxcol.mysql >>%logfilename% 2>&1
echo crsp_lock_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idxcol.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_idxcoltenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_idxcoltenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_indexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_indexidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_colidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_colidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_idxprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_idxprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_idxcol_by_idxnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idxcol_by_idxnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idxcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_idxcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_idxcol.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol.mysql >>%logfilename% 2>&1

echo crsp_create_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int16col.mysql >>%logfilename% 2>&1
echo crsp_lock_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int16col.mysql >>%logfilename% 2>&1
echo crsp_read_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_all.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int16col.mysql >>%logfilename% 2>&1
echo crsp_moveup_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int16col.mysql >>%logfilename% 2>&1
echo crsp_movedown_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int16col.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col.mysql >>%logfilename% 2>&1

echo crsp_create_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int16def.mysql >>%logfilename% 2>&1
echo crsp_lock_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int16def.mysql >>%logfilename% 2>&1
echo crsp_read_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_all.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int16def.mysql >>%logfilename% 2>&1
echo crsp_moveup_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int16def.mysql >>%logfilename% 2>&1
echo crsp_movedown_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int16def.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def.mysql >>%logfilename% 2>&1

echo crsp_create_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int16typ.mysql >>%logfilename% 2>&1
echo crsp_lock_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int16typ.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int16typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int16typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int16typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int16typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int16typ.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ.mysql >>%logfilename% 2>&1

echo crsp_create_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int32col.mysql >>%logfilename% 2>&1
echo crsp_lock_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int32col.mysql >>%logfilename% 2>&1
echo crsp_read_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_all.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int32col.mysql >>%logfilename% 2>&1
echo crsp_moveup_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int32col.mysql >>%logfilename% 2>&1
echo crsp_movedown_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int32col.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col.mysql >>%logfilename% 2>&1

echo crsp_create_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int32def.mysql >>%logfilename% 2>&1
echo crsp_lock_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int32def.mysql >>%logfilename% 2>&1
echo crsp_read_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_all.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int32def.mysql >>%logfilename% 2>&1
echo crsp_moveup_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int32def.mysql >>%logfilename% 2>&1
echo crsp_movedown_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int32def.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def.mysql >>%logfilename% 2>&1

echo crsp_create_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int32typ.mysql >>%logfilename% 2>&1
echo crsp_lock_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int32typ.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int32typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int32typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int32typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int32typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int32typ.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ.mysql >>%logfilename% 2>&1

echo crsp_create_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int64col.mysql >>%logfilename% 2>&1
echo crsp_lock_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int64col.mysql >>%logfilename% 2>&1
echo crsp_read_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_all.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int64col.mysql >>%logfilename% 2>&1
echo crsp_moveup_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int64col.mysql >>%logfilename% 2>&1
echo crsp_movedown_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int64col.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col.mysql >>%logfilename% 2>&1

echo crsp_create_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int64def.mysql >>%logfilename% 2>&1
echo crsp_lock_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int64def.mysql >>%logfilename% 2>&1
echo crsp_read_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_all.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int64def.mysql >>%logfilename% 2>&1
echo crsp_moveup_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int64def.mysql >>%logfilename% 2>&1
echo crsp_movedown_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int64def.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def.mysql >>%logfilename% 2>&1

echo crsp_create_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_int64typ.mysql >>%logfilename% 2>&1
echo crsp_lock_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_int64typ.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_int64typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_int64typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_int64typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_int64typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_int64typ.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ.mysql >>%logfilename% 2>&1

echo crsp_create_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_licn.mysql >>%logfilename% 2>&1
echo crsp_lock_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_licn.mysql >>%logfilename% 2>&1
echo crsp_read_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn.mysql >>%logfilename% 2>&1
echo crsp_read_licn_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn_all.mysql >>%logfilename% 2>&1
echo crsp_read_licn_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_licn_by_licntenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn_by_licntenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_licn_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_read_licn_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_licn_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_licn.mysql >>%logfilename% 2>&1
echo crsp_delete_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_licn.mysql >>%logfilename% 2>&1

echo crsp_create_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_loadbehav.mysql >>%logfilename% 2>&1
echo crsp_lock_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_loadbehav.mysql >>%logfilename% 2>&1
echo crsp_read_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_loadbehav.mysql >>%logfilename% 2>&1
echo crsp_read_loadbehav_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_loadbehav_all.mysql >>%logfilename% 2>&1
echo crsp_read_loadbehav_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_loadbehav_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_loadbehav_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_loadbehav_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_loadbehav.mysql >>%logfilename% 2>&1
echo crsp_delete_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_loadbehav.mysql >>%logfilename% 2>&1

echo crsp_create_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_mjverdef.mysql >>%logfilename% 2>&1
echo crsp_lock_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_mjverdef.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef_by_pprjidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef_by_pprjidx.mysql >>%logfilename% 2>&1
echo crsp_read_mjverdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mjverdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_mjverdef.mysql >>%logfilename% 2>&1
echo crsp_delete_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mjverdef.mysql >>%logfilename% 2>&1

echo crsp_create_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_mimetype.mysql >>%logfilename% 2>&1
echo crsp_lock_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_mimetype.mysql >>%logfilename% 2>&1
echo crsp_read_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mimetype.mysql >>%logfilename% 2>&1
echo crsp_read_mimetype_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mimetype_all.mysql >>%logfilename% 2>&1
echo crsp_read_mimetype_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mimetype_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_mimetype_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mimetype_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_mimetype.mysql >>%logfilename% 2>&1
echo crsp_delete_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mimetype.mysql >>%logfilename% 2>&1

echo crsp_create_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_mnverdef.mysql >>%logfilename% 2>&1
echo crsp_lock_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_mnverdef.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef_by_majoridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef_by_majoridx.mysql >>%logfilename% 2>&1
echo crsp_read_mnverdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_mnverdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_mnverdef.mysql >>%logfilename% 2>&1
echo crsp_delete_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mnverdef.mysql >>%logfilename% 2>&1

echo crsp_create_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkncol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkncol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtkncol.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol.mysql >>%logfilename% 2>&1

echo crsp_create_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkndef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkndef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtkndef.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef.mysql >>%logfilename% 2>&1

echo crsp_create_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtkntyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtkntyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtkntyp.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp.mysql >>%logfilename% 2>&1

echo crsp_create_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknscol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtknscol.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol.mysql >>%logfilename% 2>&1

echo crsp_create_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknsdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknsdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtknsdef.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef.mysql >>%logfilename% 2>&1

echo crsp_create_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_lock_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_nmtknstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_nmtknstyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_nmtknstyp.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp.mysql >>%logfilename% 2>&1

echo crsp_create_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_numcol.mysql >>%logfilename% 2>&1
echo crsp_lock_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_numcol.mysql >>%logfilename% 2>&1
echo crsp_read_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_numcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_numcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_numcol.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol.mysql >>%logfilename% 2>&1

echo crsp_create_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_numdef.mysql >>%logfilename% 2>&1
echo crsp_lock_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_numdef.mysql >>%logfilename% 2>&1
echo crsp_read_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_numdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_numdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_numdef.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef.mysql >>%logfilename% 2>&1

echo crsp_create_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_numtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_numtyp.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_numtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_numtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_numtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_numtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_numtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp.mysql >>%logfilename% 2>&1

echo crsp_create_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_srvprm.mysql >>%logfilename% 2>&1
echo crsp_lock_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_srvprm.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_servermethodidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_servermethodidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_servertypeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_servertypeidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprm_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprm_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_srvprm.mysql >>%logfilename% 2>&1
echo crsp_moveup_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_srvprm.mysql >>%logfilename% 2>&1
echo crsp_movedown_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_srvprm.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm.mysql >>%logfilename% 2>&1

echo crsp_create_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_pop_dep.mysql >>%logfilename% 2>&1
echo crsp_lock_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_pop_dep.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_cc.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_all.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_dep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_dep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_pop_dep.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_dep.mysql >>%logfilename% 2>&1

echo crsp_create_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_popsubdep1.mysql >>%logfilename% 2>&1
echo crsp_lock_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_popsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_all.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_contpoptopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_contpoptopidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep1_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_popsubdep1.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1.mysql >>%logfilename% 2>&1

echo crsp_create_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_popsubdep2.mysql >>%logfilename% 2>&1
echo crsp_lock_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_popsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_all.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_contpopdep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_contpopdep1idx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep2_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_popsubdep2.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2.mysql >>%logfilename% 2>&1

echo crsp_create_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_popsubdep3.mysql >>%logfilename% 2>&1
echo crsp_lock_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_popsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_all.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_contpopdep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_contpopdep2idx.mysql >>%logfilename% 2>&1
echo crsp_read_popsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_popsubdep3_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_popsubdep3.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3.mysql >>%logfilename% 2>&1

echo crsp_create_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_pop_topdep.mysql >>%logfilename% 2>&1
echo crsp_lock_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_pop_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_all.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_contrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_contrelidx.mysql >>%logfilename% 2>&1
echo crsp_read_pop_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_pop_topdep_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_pop_topdep.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep.mysql >>%logfilename% 2>&1

echo crsp_create_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_bprjdef.mysql >>%logfilename% 2>&1
echo crsp_lock_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_bprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_bprjdef_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_bprjdef_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_update_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_bprjdef.mysql >>%logfilename% 2>&1
echo crsp_delete_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bprjdef.mysql >>%logfilename% 2>&1

echo crsp_create_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_rprjdef.mysql >>%logfilename% 2>&1
echo crsp_lock_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_rprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_rprjdef_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rprjdef_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_update_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_rprjdef.mysql >>%logfilename% 2>&1
echo crsp_delete_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rprjdef.mysql >>%logfilename% 2>&1

echo crsp_create_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_reldef.mysql >>%logfilename% 2>&1
echo crsp_lock_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_reldef.mysql >>%logfilename% 2>&1
echo crsp_read_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_all.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_relntenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_relntenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_rtypekeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_rtypekeyidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_fromkeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_fromkeyidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_totblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_totblidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_tokeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_tokeyidx.mysql >>%logfilename% 2>&1
echo crsp_read_reldef_by_narrowedidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_reldef_by_narrowedidx.mysql >>%logfilename% 2>&1
echo crsp_update_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_reldef.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef.mysql >>%logfilename% 2>&1

echo crsp_create_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_relcol.mysql >>%logfilename% 2>&1
echo crsp_lock_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_relcol.mysql >>%logfilename% 2>&1
echo crsp_read_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_relcoltenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_relcoltenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_fromcolidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_fromcolidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_tocolidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_tocolidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_relprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_relprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_relcol_by_relnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_relcol_by_relnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_relcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_relcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_relcol.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol.mysql >>%logfilename% 2>&1

echo crsp_create_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_rel_type.mysql >>%logfilename% 2>&1
echo crsp_lock_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_rel_type.mysql >>%logfilename% 2>&1
echo crsp_read_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rel_type.mysql >>%logfilename% 2>&1
echo crsp_read_rel_type_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rel_type_all.mysql >>%logfilename% 2>&1
echo crsp_read_rel_type_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rel_type_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_rel_type_by_utagidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_rel_type_by_utagidx.mysql >>%logfilename% 2>&1
echo crsp_update_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_rel_type.mysql >>%logfilename% 2>&1
echo crsp_delete_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rel_type.mysql >>%logfilename% 2>&1

echo crsp_create_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_schemadef.mysql >>%logfilename% 2>&1
echo crsp_lock_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_schemadef.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_all.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_ctenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_ctenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_deflcnidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_deflcnidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_schemadef_by_puburiidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schemadef_by_puburiidx.mysql >>%logfilename% 2>&1
echo crsp_update_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_schemadef.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef.mysql >>%logfilename% 2>&1

echo crsp_create_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_schema_ref.mysql >>%logfilename% 2>&1
echo crsp_lock_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_schema_ref.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_all.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_schema_ref_by_refschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_schema_ref_by_refschemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_schema_ref.mysql >>%logfilename% 2>&1
echo crsp_delete_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref.mysql >>%logfilename% 2>&1

echo crsp_create_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_scopedef.mysql >>%logfilename% 2>&1
echo crsp_lock_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_scopedef.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_all.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_scopedef_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_scopedef_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_update_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_scopedef.mysql >>%logfilename% 2>&1
echo crsp_delete_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_scopedef.mysql >>%logfilename% 2>&1

echo crsp_create_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secapp.mysql >>%logfilename% 2>&1
echo crsp_lock_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secapp.mysql >>%logfilename% 2>&1
echo crsp_read_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secapp.mysql >>%logfilename% 2>&1
echo crsp_read_secapp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secapp_all.mysql >>%logfilename% 2>&1
echo crsp_read_secapp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secapp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secapp_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secapp_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secapp_by_ujeemountidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secapp_by_ujeemountidx.mysql >>%logfilename% 2>&1
echo crsp_update_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secapp.mysql >>%logfilename% 2>&1
echo crsp_delete_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secapp.mysql >>%logfilename% 2>&1

echo crsp_create_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secdev.mysql >>%logfilename% 2>&1
echo crsp_lock_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secdev.mysql >>%logfilename% 2>&1
echo crsp_read_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secdev.mysql >>%logfilename% 2>&1
echo crsp_read_secdev_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secdev_all.mysql >>%logfilename% 2>&1
echo crsp_read_secdev_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secdev_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secdev_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secdev_by_useridx.mysql >>%logfilename% 2>&1
echo crsp_update_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secdev.mysql >>%logfilename% 2>&1
echo crsp_delete_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secdev.mysql >>%logfilename% 2>&1

echo crsp_create_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secform.mysql >>%logfilename% 2>&1
echo crsp_lock_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secform.mysql >>%logfilename% 2>&1
echo crsp_read_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform.mysql >>%logfilename% 2>&1
echo crsp_read_secform_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform_all.mysql >>%logfilename% 2>&1
echo crsp_read_secform_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secform_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secform_by_secappidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform_by_secappidx.mysql >>%logfilename% 2>&1
echo crsp_read_secform_by_ujeeservletidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secform_by_ujeeservletidx.mysql >>%logfilename% 2>&1
echo crsp_update_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secform.mysql >>%logfilename% 2>&1
echo crsp_delete_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secform.mysql >>%logfilename% 2>&1

echo crsp_create_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secgrp.mysql >>%logfilename% 2>&1
echo crsp_lock_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secgrp.mysql >>%logfilename% 2>&1
echo crsp_read_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrp.mysql >>%logfilename% 2>&1
echo crsp_read_secgrp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrp_all.mysql >>%logfilename% 2>&1
echo crsp_read_secgrp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrp_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrp_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secgrp.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrp.mysql >>%logfilename% 2>&1

echo crsp_create_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secgrpfrm.mysql >>%logfilename% 2>&1
echo crsp_lock_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secgrpfrm.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_all.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_appidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_appidx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_formidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_formidx.mysql >>%logfilename% 2>&1
echo crsp_read_secgrpfrm_by_uformidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secgrpfrm_by_uformidx.mysql >>%logfilename% 2>&1
echo crsp_update_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secgrpfrm.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm.mysql >>%logfilename% 2>&1

echo crsp_create_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secinc.mysql >>%logfilename% 2>&1
echo crsp_lock_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secinc.mysql >>%logfilename% 2>&1
echo crsp_read_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_all.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_by_includeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_by_includeidx.mysql >>%logfilename% 2>&1
echo crsp_read_secinc_by_uincludeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secinc_by_uincludeidx.mysql >>%logfilename% 2>&1
echo crsp_update_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secinc.mysql >>%logfilename% 2>&1
echo crsp_delete_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc.mysql >>%logfilename% 2>&1

echo crsp_create_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secmemb.mysql >>%logfilename% 2>&1
echo crsp_lock_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secmemb.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_all.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_by_useridx.mysql >>%logfilename% 2>&1
echo crsp_read_secmemb_by_uuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secmemb_by_uuseridx.mysql >>%logfilename% 2>&1
echo crsp_update_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secmemb.mysql >>%logfilename% 2>&1
echo crsp_delete_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb.mysql >>%logfilename% 2>&1

echo crsp_create_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secsess.mysql >>%logfilename% 2>&1
echo crsp_lock_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secsess.mysql >>%logfilename% 2>&1
echo crsp_read_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_all.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_secuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_secuseridx.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_secdevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_secdevidx.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_startidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_startidx.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_finishidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_finishidx.mysql >>%logfilename% 2>&1
echo crsp_read_secsess_by_secproxyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secsess_by_secproxyidx.mysql >>%logfilename% 2>&1
echo crsp_update_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secsess.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess.mysql >>%logfilename% 2>&1

echo crsp_create_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secuser.mysql >>%logfilename% 2>&1
echo crsp_lock_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secuser.mysql >>%logfilename% 2>&1
echo crsp_read_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_all.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_by_uloginidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_by_uloginidx.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_by_emconfidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_by_emconfidx.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_by_pwdresetidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_by_pwdresetidx.mysql >>%logfilename% 2>&1
echo crsp_read_secuser_by_defdevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secuser_by_defdevidx.mysql >>%logfilename% 2>&1
echo crsp_update_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secuser.mysql >>%logfilename% 2>&1
echo crsp_delete_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser.mysql >>%logfilename% 2>&1

echo crsp_create_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_secscope.mysql >>%logfilename% 2>&1
echo crsp_lock_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_secscope.mysql >>%logfilename% 2>&1
echo crsp_read_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secscope.mysql >>%logfilename% 2>&1
echo crsp_read_secscope_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secscope_all.mysql >>%logfilename% 2>&1
echo crsp_read_secscope_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secscope_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_secscope_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_secscope_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_secscope.mysql >>%logfilename% 2>&1
echo crsp_delete_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secscope.mysql >>%logfilename% 2>&1

echo crsp_create_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_srvlfunc.mysql >>%logfilename% 2>&1
echo crsp_lock_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_srvlfunc.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvlfunc_by_rettblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvlfunc_by_rettblidx.mysql >>%logfilename% 2>&1
echo crsp_update_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_srvlfunc.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc.mysql >>%logfilename% 2>&1

echo crsp_create_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_srvmeth.mysql >>%logfilename% 2>&1
echo crsp_lock_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_srvmeth.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_cc.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvmeth_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvmeth_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_srvmeth.mysql >>%logfilename% 2>&1
echo crsp_delete_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth.mysql >>%logfilename% 2>&1

echo crsp_create_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_srvofunc.mysql >>%logfilename% 2>&1
echo crsp_lock_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_srvofunc.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvofunc_by_rettblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvofunc_by_rettblidx.mysql >>%logfilename% 2>&1
echo crsp_update_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_srvofunc.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc.mysql >>%logfilename% 2>&1

echo crsp_create_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_srvprc.mysql >>%logfilename% 2>&1
echo crsp_lock_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_srvprc.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_all.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_srvprc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_srvprc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_srvprc.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc.mysql >>%logfilename% 2>&1

echo crsp_create_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_hostsvc.mysql >>%logfilename% 2>&1
echo crsp_lock_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_hostsvc.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_all.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_hostidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_hostidx.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_typeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_typeidx.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_utypeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_utypeidx.mysql >>%logfilename% 2>&1
echo crsp_read_hostsvc_by_uhostportidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_hostsvc_by_uhostportidx.mysql >>%logfilename% 2>&1
echo crsp_update_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_hostsvc.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc.mysql >>%logfilename% 2>&1

echo crsp_create_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_svctype.mysql >>%logfilename% 2>&1
echo crsp_lock_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_svctype.mysql >>%logfilename% 2>&1
echo crsp_read_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_svctype.mysql >>%logfilename% 2>&1
echo crsp_read_svctype_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_svctype_all.mysql >>%logfilename% 2>&1
echo crsp_read_svctype_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_svctype_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_svctype_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_svctype_by_udescridx.mysql >>%logfilename% 2>&1
echo crsp_update_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_svctype.mysql >>%logfilename% 2>&1
echo crsp_delete_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_svctype.mysql >>%logfilename% 2>&1

echo crsp_create_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_strcol.mysql >>%logfilename% 2>&1
echo crsp_lock_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_strcol.mysql >>%logfilename% 2>&1
echo crsp_read_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_strcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_strcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_strcol.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol.mysql >>%logfilename% 2>&1

echo crsp_create_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_strdef.mysql >>%logfilename% 2>&1
echo crsp_lock_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_strdef.mysql >>%logfilename% 2>&1
echo crsp_read_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_strdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_strdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_strdef.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef.mysql >>%logfilename% 2>&1

echo crsp_create_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_strtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_strtyp.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_strtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_strtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_strtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_strtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_strtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp.mysql >>%logfilename% 2>&1

echo crsp_create_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_sprjdef.mysql >>%logfilename% 2>&1
echo crsp_lock_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_sprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef_by_parentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef_by_parentidx.mysql >>%logfilename% 2>&1
echo crsp_read_sprjdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sprjdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_sprjdef.mysql >>%logfilename% 2>&1
echo crsp_delete_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sprjdef.mysql >>%logfilename% 2>&1

echo crsp_create_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_sysclus.mysql >>%logfilename% 2>&1
echo crsp_lock_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_sysclus.mysql >>%logfilename% 2>&1
echo crsp_read_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sysclus.mysql >>%logfilename% 2>&1
echo crsp_read_sysclus_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sysclus_all.mysql >>%logfilename% 2>&1
echo crsp_read_sysclus_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sysclus_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_sysclus_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_sysclus_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_update_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_sysclus.mysql >>%logfilename% 2>&1
echo crsp_delete_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sysclus.mysql >>%logfilename% 2>&1

echo crsp_create_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tsecgrp.mysql >>%logfilename% 2>&1
echo crsp_lock_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tsecgrp.mysql >>%logfilename% 2>&1
echo crsp_read_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecgrp.mysql >>%logfilename% 2>&1
echo crsp_read_tsecgrp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecgrp_all.mysql >>%logfilename% 2>&1
echo crsp_read_tsecgrp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecgrp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecgrp_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecgrp_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecgrp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecgrp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tsecgrp.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecgrp.mysql >>%logfilename% 2>&1

echo crsp_create_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tsecinc.mysql >>%logfilename% 2>&1
echo crsp_lock_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tsecinc.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_all.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_by_includeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_by_includeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecinc_by_uincludeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecinc_by_uincludeidx.mysql >>%logfilename% 2>&1
echo crsp_update_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tsecinc.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc.mysql >>%logfilename% 2>&1

echo crsp_create_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tsecmemb.mysql >>%logfilename% 2>&1
echo crsp_lock_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tsecmemb.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_all.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_by_useridx.mysql >>%logfilename% 2>&1
echo crsp_read_tsecmemb_by_uuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsecmemb_by_uuseridx.mysql >>%logfilename% 2>&1
echo crsp_update_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tsecmemb.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb.mysql >>%logfilename% 2>&1

echo crsp_create_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dzcol.mysql >>%logfilename% 2>&1
echo crsp_lock_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dzcol.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dzcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dzcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dzcol.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol.mysql >>%logfilename% 2>&1

echo crsp_create_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dzdef.mysql >>%logfilename% 2>&1
echo crsp_lock_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dzdef.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dzdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dzdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dzdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dzdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dzdef.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef.mysql >>%logfilename% 2>&1

echo crsp_create_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_dztyp.mysql >>%logfilename% 2>&1
echo crsp_lock_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_dztyp.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_dztyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_dztyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_dztyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_dztyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_dztyp.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp.mysql >>%logfilename% 2>&1

echo crsp_create_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_lock_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmzcol.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol.mysql >>%logfilename% 2>&1

echo crsp_create_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_lock_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmzdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmzdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmzdef.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef.mysql >>%logfilename% 2>&1

echo crsp_create_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_lock_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmztyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmztyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmztyp.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp.mysql >>%logfilename% 2>&1

echo crsp_create_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_zscol.mysql >>%logfilename% 2>&1
echo crsp_lock_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_zscol.mysql >>%logfilename% 2>&1
echo crsp_read_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_all.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zscol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_zscol.mysql >>%logfilename% 2>&1
echo crsp_moveup_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_zscol.mysql >>%logfilename% 2>&1
echo crsp_movedown_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_zscol.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol.mysql >>%logfilename% 2>&1

echo crsp_create_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_zsdef.mysql >>%logfilename% 2>&1
echo crsp_lock_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_zsdef.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zsdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zsdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_zsdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_zsdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_zsdef.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef.mysql >>%logfilename% 2>&1

echo crsp_create_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_zstyp.mysql >>%logfilename% 2>&1
echo crsp_lock_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_zstyp.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_zstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_zstyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_zstyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_zstyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_zstyp.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp.mysql >>%logfilename% 2>&1

echo crsp_create_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tbldef.mysql >>%logfilename% 2>&1
echo crsp_lock_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tbldef.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_schemadefidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_schemadefidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_schemacdidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_schemacdidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_primaryindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_primaryindexidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_lookupindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_lookupindexidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_altindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_altindexidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_qualtableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_qualtableidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_loadbehaveidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_loadbehaveidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_secscopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_secscopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tbldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tbldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_update_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tbldef.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef.mysql >>%logfilename% 2>&1

echo crsp_create_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tblcol.mysql >>%logfilename% 2>&1
echo crsp_lock_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tblcol.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_read_tblcol_by_dataidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tblcol_by_dataidx.mysql >>%logfilename% 2>&1
echo crsp_update_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tblcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tblcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tblcol.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol.mysql >>%logfilename% 2>&1

echo crsp_create_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tenant.mysql >>%logfilename% 2>&1
echo crsp_lock_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tenant.mysql >>%logfilename% 2>&1
echo crsp_read_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tenant.mysql >>%logfilename% 2>&1
echo crsp_read_tenant_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tenant_all.mysql >>%logfilename% 2>&1
echo crsp_read_tenant_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tenant_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tenant_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tenant_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_read_tenant_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tenant_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_update_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tenant.mysql >>%logfilename% 2>&1
echo crsp_delete_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tenant.mysql >>%logfilename% 2>&1

echo crsp_create_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_txtcol.mysql >>%logfilename% 2>&1
echo crsp_lock_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_txtcol.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_txtcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_txtcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_txtcol.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol.mysql >>%logfilename% 2>&1

echo crsp_create_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_txtdef.mysql >>%logfilename% 2>&1
echo crsp_lock_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_txtdef.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txtdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txtdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_txtdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_txtdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_txtdef.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef.mysql >>%logfilename% 2>&1

echo crsp_create_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_txttyp.mysql >>%logfilename% 2>&1
echo crsp_lock_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_txttyp.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_txttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_txttyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_txttyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_txttyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_txttyp.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp.mysql >>%logfilename% 2>&1

echo crsp_create_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmcol.mysql >>%logfilename% 2>&1
echo crsp_lock_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmcol.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmcol.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol.mysql >>%logfilename% 2>&1

echo crsp_create_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmdef.mysql >>%logfilename% 2>&1
echo crsp_lock_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmdef.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmdef.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef.mysql >>%logfilename% 2>&1

echo crsp_create_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tmtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tmtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tmtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp.mysql >>%logfilename% 2>&1

echo crsp_create_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tscol.mysql >>%logfilename% 2>&1
echo crsp_lock_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tscol.mysql >>%logfilename% 2>&1
echo crsp_read_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_all.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tscol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tscol.mysql >>%logfilename% 2>&1
echo crsp_moveup_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tscol.mysql >>%logfilename% 2>&1
echo crsp_movedown_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tscol.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol.mysql >>%logfilename% 2>&1

echo crsp_create_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tsdef.mysql >>%logfilename% 2>&1
echo crsp_lock_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tsdef.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tsdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tsdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tsdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tsdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tsdef.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef.mysql >>%logfilename% 2>&1

echo crsp_create_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tstyp.mysql >>%logfilename% 2>&1
echo crsp_lock_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tstyp.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tstyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tstyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tstyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tstyp.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp.mysql >>%logfilename% 2>&1

echo crsp_create_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tlddef.mysql >>%logfilename% 2>&1
echo crsp_lock_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tlddef.mysql >>%logfilename% 2>&1
echo crsp_read_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tlddef.mysql >>%logfilename% 2>&1
echo crsp_read_tlddef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tlddef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tlddef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tlddef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tlddef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tlddef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tlddef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tlddef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tlddef.mysql >>%logfilename% 2>&1
echo crsp_delete_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tlddef.mysql >>%logfilename% 2>&1

echo crsp_create_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tkncol.mysql >>%logfilename% 2>&1
echo crsp_lock_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tkncol.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_all.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkncol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkncol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tkncol.mysql >>%logfilename% 2>&1
echo crsp_moveup_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tkncol.mysql >>%logfilename% 2>&1
echo crsp_movedown_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tkncol.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol.mysql >>%logfilename% 2>&1

echo crsp_create_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tkndef.mysql >>%logfilename% 2>&1
echo crsp_lock_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tkndef.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkndef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkndef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tkndef.mysql >>%logfilename% 2>&1
echo crsp_moveup_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tkndef.mysql >>%logfilename% 2>&1
echo crsp_movedown_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tkndef.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef.mysql >>%logfilename% 2>&1

echo crsp_create_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_lock_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_tkntyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tkntyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_tkntyp.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp.mysql >>%logfilename% 2>&1

echo crsp_create_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tdomdef.mysql >>%logfilename% 2>&1
echo crsp_lock_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tdomdef.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef_by_tldidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef_by_tldidx.mysql >>%logfilename% 2>&1
echo crsp_read_tdomdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tdomdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tdomdef.mysql >>%logfilename% 2>&1
echo crsp_delete_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tdomdef.mysql >>%logfilename% 2>&1

echo crsp_create_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_tprjdef.mysql >>%logfilename% 2>&1
echo crsp_lock_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_tprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_read_tprjdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_tprjdef_by_nameidx.mysql >>%logfilename% 2>&1
echo crsp_update_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_tprjdef.mysql >>%logfilename% 2>&1
echo crsp_delete_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tprjdef.mysql >>%logfilename% 2>&1

echo crsp_create_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint16col.mysql >>%logfilename% 2>&1
echo crsp_lock_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint16col.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint16col.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint16col.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint16col.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col.mysql >>%logfilename% 2>&1

echo crsp_create_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_u16def.mysql >>%logfilename% 2>&1
echo crsp_lock_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_u16def.mysql >>%logfilename% 2>&1
echo crsp_read_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_all.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u16def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u16def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_u16def.mysql >>%logfilename% 2>&1
echo crsp_moveup_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_u16def.mysql >>%logfilename% 2>&1
echo crsp_movedown_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_u16def.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def.mysql >>%logfilename% 2>&1

echo crsp_create_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_lock_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint16typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint16typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint16typ.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ.mysql >>%logfilename% 2>&1

echo crsp_create_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint32col.mysql >>%logfilename% 2>&1
echo crsp_lock_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint32col.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint32col.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint32col.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint32col.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col.mysql >>%logfilename% 2>&1

echo crsp_create_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_u32def.mysql >>%logfilename% 2>&1
echo crsp_lock_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_u32def.mysql >>%logfilename% 2>&1
echo crsp_read_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_all.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u32def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u32def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_u32def.mysql >>%logfilename% 2>&1
echo crsp_moveup_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_u32def.mysql >>%logfilename% 2>&1
echo crsp_movedown_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_u32def.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def.mysql >>%logfilename% 2>&1

echo crsp_create_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_lock_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint32typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint32typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint32typ.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ.mysql >>%logfilename% 2>&1

echo crsp_create_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint64col.mysql >>%logfilename% 2>&1
echo crsp_lock_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint64col.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64col_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint64col.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint64col.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint64col.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col.mysql >>%logfilename% 2>&1

echo crsp_create_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_u64def.mysql >>%logfilename% 2>&1
echo crsp_lock_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_u64def.mysql >>%logfilename% 2>&1
echo crsp_read_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_all.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_u64def_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_u64def_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_u64def.mysql >>%logfilename% 2>&1
echo crsp_moveup_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_u64def.mysql >>%logfilename% 2>&1
echo crsp_movedown_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_u64def.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def.mysql >>%logfilename% 2>&1

echo crsp_create_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_lock_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_all.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uint64typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uint64typ_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_moveup_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_movedown_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uint64typ.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ.mysql >>%logfilename% 2>&1

echo crsp_create_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_urlproto.mysql >>%logfilename% 2>&1
echo crsp_lock_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_urlproto.mysql >>%logfilename% 2>&1
echo crsp_read_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_urlproto.mysql >>%logfilename% 2>&1
echo crsp_read_urlproto_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_urlproto_all.mysql >>%logfilename% 2>&1
echo crsp_read_urlproto_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_urlproto_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_urlproto_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_urlproto_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_urlproto_by_issecureidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_urlproto_by_issecureidx.mysql >>%logfilename% 2>&1
echo crsp_update_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_urlproto.mysql >>%logfilename% 2>&1
echo crsp_delete_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_urlproto.mysql >>%logfilename% 2>&1

echo crsp_create_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_lock_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_all.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_update_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_moveup_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_movedown_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uuidcol.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol.mysql >>%logfilename% 2>&1

echo crsp_create_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_lock_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_all.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuiddef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuiddef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_moveup_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_movedown_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uuiddef.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef.mysql >>%logfilename% 2>&1

echo crsp_create_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_idguuid.mysql >>%logfilename% 2>&1
echo crsp_lock_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_idguuid.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_all.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_idguuid_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_idguuid_by_dispidx.mysql >>%logfilename% 2>&1
echo crsp_update_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_idguuid.mysql >>%logfilename% 2>&1
echo crsp_moveup_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_idguuid.mysql >>%logfilename% 2>&1
echo crsp_movedown_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_idguuid.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid.mysql >>%logfilename% 2>&1

echo crsp_create_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_lock_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_all.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_uuidtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_uuidtyp_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_update_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_moveup_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_movedown_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_uuidtyp.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp.mysql >>%logfilename% 2>&1

echo crsp_create_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_valdef.mysql >>%logfilename% 2>&1
echo crsp_lock_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_valdef.mysql >>%logfilename% 2>&1
echo crsp_read_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_all.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_read_valdef_cc_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_valdef_cc_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_update_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_valdef.mysql >>%logfilename% 2>&1
echo crsp_moveup_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_moveup_valdef.mysql >>%logfilename% 2>&1
echo crsp_movedown_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_movedown_valdef.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef.mysql >>%logfilename% 2>&1

echo crsp_create_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_create_verndef.mysql >>%logfilename% 2>&1
echo crsp_lock_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_lock_verndef.mysql >>%logfilename% 2>&1
echo crsp_read_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_cc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_cc.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_all.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_cc_all.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_cc_all.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_cc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_cc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_read_verndef_cc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_read_verndef_cc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_update_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_update_verndef.mysql >>%logfilename% 2>&1
echo crsp_delete_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_verndef.mysql >>%logfilename% 2>&1

echo crsp_delete_accfreq_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accfreq_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_accfreq_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accfreq_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_accsec_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accsec_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_accsec_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_accsec_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_atomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_atomdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_atomdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_auditaction_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_auditaction_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_auditaction_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_auditaction_by_udescridx.mysql >>%logfilename% 2>&1

echo crsp_delete_blbcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_blbdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_blbtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_blbtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_blbtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_boolcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_boolcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_boolcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_booldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booldef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booldef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_booltyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_booltyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_booltyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_chain_def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_prevrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_prevrelidx.mysql >>%logfilename% 2>&1
echo crsp_delete_chain_def_by_nextrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_chain_def_by_nextrelidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clr_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_dep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_dep_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clrsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep1_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep1_by_contcleartopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1_by_contcleartopidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep1_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clrsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep2_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep2_by_contcleardep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2_by_contcleardep1idx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep2_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clrsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep3_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep3_by_contcleardep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3_by_contcleardep2idx.mysql >>%logfilename% 2>&1
echo crsp_delete_clrsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clrsubdep3_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clr_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_topdep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_topdep_by_conttblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep_by_conttblidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clr_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clr_topdep_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_clus_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clus_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_clus_by_udomainnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clus_by_udomainnameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_clus_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_clus_by_udescridx.mysql >>%logfilename% 2>&1

echo crsp_delete_datascope_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_datascope_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_datascope_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_datascope_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dtcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dtdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dtdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dtdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dttyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_del_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_dep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_dep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_dep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_dep_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_delsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1_by_contdeltopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_contdeltopidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep1_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_delsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2_by_contdeldep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_contdeldep1idx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep2_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_delsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3_by_contdeldep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_contdeldep2idx.mysql >>%logfilename% 2>&1
echo crsp_delete_delsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_delsubdep3_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_del_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep_by_conttblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_conttblidx.mysql >>%logfilename% 2>&1
echo crsp_delete_del_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_del_topdep_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_domdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_domdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_domdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_domdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_domdef_by_subdomidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_domdef_by_subdomidx.mysql >>%logfilename% 2>&1
echo crsp_delete_domdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_domdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_bdomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bdomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_bdomdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bdomdef_by_tenantidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dblcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dblcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dblcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dbldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbldef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbldef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dbltyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dbltyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dbltyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_enumcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_enumdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_enum_tag_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_enumtagtenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_enumtagtenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_enumidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_enumidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_enumnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_enumnameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_enum_tag_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enum_tag_by_nextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_enumtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_enumtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_enumtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_fltcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_fltdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_fltdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_fltdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_flttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_flttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_flttyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_hostnode_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostnode_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostnode_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostnode_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostnode_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostnode_by_udescridx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostnode_by_hostnameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostnode_by_hostnameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_iso_cntry_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntry_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntry_by_isocodeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntry_by_isocodeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntry_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntry_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_iso_cntryccy_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntryccy_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntryccy_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntryccy_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntryccy_by_currencyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntryccy_by_currencyidx.mysql >>%logfilename% 2>&1

echo crsp_delete_iso_cntrylng_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntrylng_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntrylng_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntrylng_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_cntrylng_by_languageidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_cntrylng_by_languageidx.mysql >>%logfilename% 2>&1

echo crsp_delete_iso_ccy_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_ccy_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_ccy_by_ccycdidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_ccy_by_ccycdidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_ccy_by_ccynmidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_ccy_by_ccynmidx.mysql >>%logfilename% 2>&1

echo crsp_delete_iso_lang_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_lang_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_lang_by_baseidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_lang_by_baseidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_lang_by_countryidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_lang_by_countryidx.mysql >>%logfilename% 2>&1
echo crsp_delete_iso_lang_by_codeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_iso_lang_by_codeidx.mysql >>%logfilename% 2>&1

echo crsp_delete_isotz_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_isotz_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_isotz_by_offsetidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_isotz_by_offsetidx.mysql >>%logfilename% 2>&1
echo crsp_delete_isotz_by_utznameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_isotz_by_utznameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_isotz_by_iso8601idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_isotz_by_iso8601idx.mysql >>%logfilename% 2>&1

echo crsp_delete_idg16_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg16_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg16_by_dispidx.mysql >>%logfilename% 2>&1

echo crsp_delete_idg32_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg32_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg32_by_dispidx.mysql >>%logfilename% 2>&1

echo crsp_delete_idg64_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idg64_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idg64_by_dispidx.mysql >>%logfilename% 2>&1

echo crsp_delete_idxdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef_by_indextenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_indextenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxdef_by_defschemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_idxcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_idxcoltenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_idxcoltenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_indexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_indexidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_colidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_colidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_idxprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_idxprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idxcol_by_idxnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idxcol_by_idxnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int16col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int16def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int16typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int16typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int16typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int32col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int32def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int32typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int32typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int32typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int64col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int64def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_int64typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_int64typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_int64typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_licn_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_licn_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_licn_by_licntenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_licn_by_licntenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_licn_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_licn_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_delete_licn_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_licn_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_loadbehav_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_loadbehav_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_loadbehav_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_loadbehav_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_mjverdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mjverdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_mjverdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mjverdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_mjverdef_by_pprjidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mjverdef_by_pprjidx.mysql >>%logfilename% 2>&1
echo crsp_delete_mjverdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mjverdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_mimetype_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mimetype_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_mimetype_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mimetype_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_mnverdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mnverdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_mnverdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mnverdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_mnverdef_by_majoridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mnverdef_by_majoridx.mysql >>%logfilename% 2>&1
echo crsp_delete_mnverdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_mnverdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtkncol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkncol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkncol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtkndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkndef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkndef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtkntyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtkntyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtkntyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtknscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknscol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtknsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknsdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_nmtknstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_nmtknstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_nmtknstyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_numcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_numdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_numtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_numtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_numtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_srvprm_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_servermethodidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_servermethodidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_servertypeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_servertypeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprm_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprm_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_pop_dep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_dep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_dep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_dep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_dep_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_dep_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_dep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_dep_by_defschemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_popsubdep1_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1_by_contpoptopidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_contpoptopidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep1_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep1_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_popsubdep2_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2_by_contpopdep1idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_contpopdep1idx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep2_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep2_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_popsubdep3_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3_by_contpopdep2idx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_contpopdep2idx.mysql >>%logfilename% 2>&1
echo crsp_delete_popsubdep3_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_popsubdep3_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_pop_topdep_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep_by_contrelidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_contrelidx.mysql >>%logfilename% 2>&1
echo crsp_delete_pop_topdep_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_pop_topdep_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_bprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_bprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_bprjdef_by_tenantidx.mysql >>%logfilename% 2>&1

echo crsp_delete_rprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_rprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rprjdef_by_tenantidx.mysql >>%logfilename% 2>&1

echo crsp_delete_reldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_relntenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_relntenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_rtypekeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_rtypekeyidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_fromkeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_fromkeyidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_totblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_totblidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_tokeyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_tokeyidx.mysql >>%logfilename% 2>&1
echo crsp_delete_reldef_by_narrowedidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_reldef_by_narrowedidx.mysql >>%logfilename% 2>&1

echo crsp_delete_relcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_relcoltenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_relcoltenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_relationidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_relationidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_fromcolidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_fromcolidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_tocolidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_tocolidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_relprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_relprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_relcol_by_relnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_relcol_by_relnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_rel_type_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rel_type_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_rel_type_by_utagidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_rel_type_by_utagidx.mysql >>%logfilename% 2>&1

echo crsp_delete_schemadef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_ctenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_ctenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_deflcnidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_deflcnidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schemadef_by_puburiidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schemadef_by_puburiidx.mysql >>%logfilename% 2>&1

echo crsp_delete_schema_ref_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_schema_ref_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schema_ref_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schema_ref_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_schema_ref_by_refschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_schema_ref_by_refschemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_scopedef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_scopedef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_scopedef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_scopedef_by_tenantidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secapp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secapp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secapp_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secapp_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secapp_by_ujeemountidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secapp_by_ujeemountidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secdev_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secdev_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secdev_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secdev_by_useridx.mysql >>%logfilename% 2>&1

echo crsp_delete_secform_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secform_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secform_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secform_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secform_by_secappidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secform_by_secappidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secform_by_ujeeservletidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secform_by_ujeeservletidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secgrp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrp_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrp_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrp_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secgrpfrm_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm_by_appidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_appidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm_by_formidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_formidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secgrpfrm_by_uformidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secgrpfrm_by_uformidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secinc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secinc_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secinc_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secinc_by_includeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc_by_includeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secinc_by_uincludeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secinc_by_uincludeidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secmemb_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secmemb_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secmemb_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secmemb_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb_by_useridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secmemb_by_uuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secmemb_by_uuseridx.mysql >>%logfilename% 2>&1

echo crsp_delete_secsess_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess_by_secuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_secuseridx.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess_by_secdevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_secdevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess_by_startidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_startidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess_by_finishidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_finishidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secsess_by_secproxyidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secsess_by_secproxyidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secuser_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secuser_by_uloginidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser_by_uloginidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secuser_by_emconfidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser_by_emconfidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secuser_by_pwdresetidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser_by_pwdresetidx.mysql >>%logfilename% 2>&1
echo crsp_delete_secuser_by_defdevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secuser_by_defdevidx.mysql >>%logfilename% 2>&1

echo crsp_delete_secscope_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secscope_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_secscope_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_secscope_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_srvlfunc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvlfunc_by_rettblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvlfunc_by_rettblidx.mysql >>%logfilename% 2>&1

echo crsp_delete_srvmeth_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvmeth_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvmeth_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvmeth_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvmeth_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvmeth_by_defschemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_srvofunc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvofunc_by_rettblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvofunc_by_rettblidx.mysql >>%logfilename% 2>&1

echo crsp_delete_srvprc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprc_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprc_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_srvprc_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_srvprc_by_defschemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_hostsvc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc_by_hostidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_hostidx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc_by_typeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_typeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc_by_utypeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_utypeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_hostsvc_by_uhostportidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_hostsvc_by_uhostportidx.mysql >>%logfilename% 2>&1

echo crsp_delete_svctype_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_svctype_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_svctype_by_udescridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_svctype_by_udescridx.mysql >>%logfilename% 2>&1

echo crsp_delete_strcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_strdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_strtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_strtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_strtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_sprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_sprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_sprjdef_by_parentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sprjdef_by_parentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_sprjdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sprjdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_sysclus_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sysclus_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_sysclus_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_sysclus_by_clusteridx.mysql >>%logfilename% 2>&1

echo crsp_delete_tsecgrp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecgrp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecgrp_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecgrp_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecgrp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecgrp_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tsecinc_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecinc_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecinc_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecinc_by_includeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc_by_includeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecinc_by_uincludeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecinc_by_uincludeidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tsecmemb_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecmemb_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecmemb_by_groupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb_by_groupidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecmemb_by_useridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb_by_useridx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsecmemb_by_uuseridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsecmemb_by_uuseridx.mysql >>%logfilename% 2>&1

echo crsp_delete_dzcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dzdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dzdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dzdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_dztyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_dztyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_dztyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmzcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmzdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmzdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmzdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmztyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmztyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmztyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_zscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zscol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_zsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zsdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_zstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_zstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_zstyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tbldef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_schemadefidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_schemadefidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_schemacdidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_schemacdidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_primaryindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_primaryindexidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_lookupindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_lookupindexidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_altindexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_altindexidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_qualtableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_qualtableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_loadbehaveidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_loadbehaveidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_secscopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_secscopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tbldef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tbldef_by_eaccfreqidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tblcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_tableidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tblcol_by_dataidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tblcol_by_dataidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tenant_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tenant_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tenant_by_clusteridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tenant_by_clusteridx.mysql >>%logfilename% 2>&1
echo crsp_delete_tenant_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tenant_by_unameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_txtcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_txtdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txtdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txtdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_txttyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_txttyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_txttyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tmtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tmtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tmtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tscol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tscol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tscol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tsdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tsdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tsdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tstyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tstyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tstyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tlddef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tlddef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tlddef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tlddef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tlddef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tlddef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tkncol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkncol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkncol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tkndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkndef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkndef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tkntyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tkntyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tkntyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tdomdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tdomdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tdomdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tdomdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tdomdef_by_tldidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tdomdef_by_tldidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tdomdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tdomdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_tprjdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tprjdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_tprjdef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tprjdef_by_tenantidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tprjdef_by_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tprjdef_by_domainidx.mysql >>%logfilename% 2>&1
echo crsp_delete_tprjdef_by_nameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_tprjdef_by_nameidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint16col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_u16def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u16def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u16def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint16typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint16typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint16typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint32col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_u32def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u32def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u32def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint32typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint32typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint32typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint64col_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64col_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64col_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_u64def_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_u64def_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_u64def_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uint64typ_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uint64typ_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uint64typ_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_urlproto_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_urlproto_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_urlproto_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_urlproto_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_urlproto_by_issecureidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_urlproto_by_issecureidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uuidcol_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidcol_by_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidcol_by_tableidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uuiddef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuiddef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuiddef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_idguuid_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_schemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_idguuid_by_dispidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_idguuid_by_dispidx.mysql >>%logfilename% 2>&1

echo crsp_delete_uuidtyp_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_contnextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_uuidtyp_by_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_uuidtyp_by_schemaidx.mysql >>%logfilename% 2>&1

echo crsp_delete_valdef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_unameidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_valtentidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_valtentidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_scopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_defschemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_defschemaidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_datascopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_datascopeidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_vaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_vaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_vaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_vaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_eaccsecidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_eaccsecidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_eaccfreqidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_eaccfreqidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_previdx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_previdx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_nextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_nextidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_contprevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_contprevidx.mysql >>%logfilename% 2>&1
echo crsp_delete_valdef_by_contnextidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_valdef_by_contnextidx.mysql >>%logfilename% 2>&1

echo crsp_delete_verndef_by_ididx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_verndef_by_ididx.mysql >>%logfilename% 2>&1
echo crsp_delete_verndef_by_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crsp_delete_verndef_by_tenantidx.mysql >>%logfilename% 2>&1


