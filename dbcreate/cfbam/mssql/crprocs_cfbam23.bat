@ECHO OFF
REM	@(#) dbcreate/cfbam/mssql/crprocs_cfbam23.bat
REM 
REM 	CFBam
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

REM	Initialize locals
SET mssqlpwd=""
SET mssqlsrv=""
SET mssqluser=""
SET logfilename=crprocs_cfbam23.log

IF NOT "%1" == "" SET mssqlsrv=%1
IF NOT "%2" == "" SET mssqluser=%2
IF NOT "%3" == "" SET mssqlpwd=%3
IF NOT "%4" == "" SET logfilename=%4

IF "%mssqluser%" == "" (
	ECHO "ERROR: User must be specified as second argument"
	PAUSE
	EXIT
)

IF "%mssqlpwd%" == "" (
	ECHO "ERROR: Password must be specified as third argument"
	PAUSE
	EXIT
)

IF "%mssqlsrv%" == "" (
	ECHO "ERROR: Server must be specified as first argument"
	PAUSE
	EXIT
)

SET cmddb=sqlcmd -S %mssqlsrv% -U %mssqluser% -P %mssqlpwd% -e

%cmddb% <crsp_is_system_user.tsql >>%logfilename%
%cmddb% <crsp_is_cluster_user.tsql >>%logfilename%
%cmddb% <crsp_is_tenant_user.tsql >>%logfilename%
%cmddb% <crsp_next_servicetypeidgen.tsql >>%logfilename%
%cmddb% <crsp_next_mimetypeidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clusteridgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenantidgen.tsql >>%logfilename%

%cmddb% <crsp_selnext_servicetypeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_mimetypeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clusteridgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenantidgen.tsql >>%logfilename%
















%cmddb% <crsp_next_clus_secappidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_secformidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_secgroupidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_secgroupmemberidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_secgroupincludeidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_secgroupformidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_serviceidgen.tsql >>%logfilename%
%cmddb% <crsp_next_clus_hostnodeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secappidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secformidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secgroupidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secgroupmemberidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secgroupincludeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_secgroupformidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_serviceidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_clus_hostnodeidgen.tsql >>%logfilename%










































































































%cmddb% <crsp_next_tenant_tsecgroupidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_tsecgroupmemberidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_tsecgroupincludeidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_tldidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_domainidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_scopeidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_indexcolidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_licenseidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_relationcolidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_valueidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_enumtagidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_chainidgen.tsql >>%logfilename%
%cmddb% <crsp_next_tenant_paramidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_tsecgroupidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_tsecgroupmemberidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_tsecgroupincludeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_tldidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_domainidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_scopeidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_indexcolidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_licenseidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_relationcolidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_valueidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_enumtagidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_chainidgen.tsql >>%logfilename%
%cmddb% <crsp_selnext_tenant_paramidgen.tsql >>%logfilename%

































%cmddb% <crsp_bootstrap.tsql >>%logfilename%

%cmddb% <crsp_audit_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_audit_idxcol.tsql >>%logfilename%
%cmddb% <crsp_audit_srvprm.tsql >>%logfilename%
%cmddb% <crsp_audit_relcol.tsql >>%logfilename%
%cmddb% <crsp_audit_valdef.tsql >>%logfilename%

%cmddb% <crsp_create_accfreq.tsql >>%logfilename%
%cmddb% <crsp_lock_accfreq.tsql >>%logfilename%
%cmddb% <crsp_read_accfreq.tsql >>%logfilename%
%cmddb% <crsp_read_accfreq_all.tsql >>%logfilename%
%cmddb% <crsp_read_accfreq_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_accfreq_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_accfreq.tsql >>%logfilename%
%cmddb% <crsp_delete_accfreq.tsql >>%logfilename%

%cmddb% <crsp_create_accsec.tsql >>%logfilename%
%cmddb% <crsp_lock_accsec.tsql >>%logfilename%
%cmddb% <crsp_read_accsec.tsql >>%logfilename%
%cmddb% <crsp_read_accsec_all.tsql >>%logfilename%
%cmddb% <crsp_read_accsec_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_accsec_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_accsec.tsql >>%logfilename%
%cmddb% <crsp_delete_accsec.tsql >>%logfilename%

%cmddb% <crsp_create_atomdef.tsql >>%logfilename%
%cmddb% <crsp_lock_atomdef.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_atomdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_atomdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_atomdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_atomdef.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef.tsql >>%logfilename%

%cmddb% <crsp_create_auditaction.tsql >>%logfilename%
%cmddb% <crsp_lock_auditaction.tsql >>%logfilename%
%cmddb% <crsp_read_auditaction.tsql >>%logfilename%
%cmddb% <crsp_read_auditaction_all.tsql >>%logfilename%
%cmddb% <crsp_read_auditaction_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_auditaction_by_udescridx.tsql >>%logfilename%
%cmddb% <crsp_update_auditaction.tsql >>%logfilename%
%cmddb% <crsp_delete_auditaction.tsql >>%logfilename%

%cmddb% <crsp_lock_blbcol.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_blbcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_blbcol.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol.tsql >>%logfilename%

%cmddb% <crsp_lock_blbdef.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_blbdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_blbdef.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef.tsql >>%logfilename%

%cmddb% <crsp_lock_blbtyp.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_blbtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_blbtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_blbtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp.tsql >>%logfilename%

%cmddb% <crsp_create_boolcol.tsql >>%logfilename%
%cmddb% <crsp_lock_boolcol.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_boolcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_boolcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_boolcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_boolcol.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol.tsql >>%logfilename%

%cmddb% <crsp_create_booldef.tsql >>%logfilename%
%cmddb% <crsp_lock_booldef.tsql >>%logfilename%
%cmddb% <crsp_read_booldef.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_all.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_booldef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_booldef.tsql >>%logfilename%
%cmddb% <crsp_moveup_booldef.tsql >>%logfilename%
%cmddb% <crsp_movedown_booldef.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef.tsql >>%logfilename%

%cmddb% <crsp_create_booltyp.tsql >>%logfilename%
%cmddb% <crsp_lock_booltyp.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_booltyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_booltyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_booltyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_booltyp.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp.tsql >>%logfilename%

%cmddb% <crsp_create_chain_def.tsql >>%logfilename%
%cmddb% <crsp_lock_chain_def.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_all.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_prevrelidx.tsql >>%logfilename%
%cmddb% <crsp_read_chain_def_by_nextrelidx.tsql >>%logfilename%
%cmddb% <crsp_update_chain_def.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def.tsql >>%logfilename%

%cmddb% <crsp_create_clr_dep.tsql >>%logfilename%
%cmddb% <crsp_lock_clr_dep.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_cc.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_all.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_dep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_clr_dep.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_dep.tsql >>%logfilename%

%cmddb% <crsp_create_clrsubdep1.tsql >>%logfilename%
%cmddb% <crsp_lock_clrsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_all.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_by_contcleartopidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep1_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_clrsubdep1.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep1.tsql >>%logfilename%

%cmddb% <crsp_create_clrsubdep2.tsql >>%logfilename%
%cmddb% <crsp_lock_clrsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_all.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_by_contcleardep1idx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep2_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_clrsubdep2.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep2.tsql >>%logfilename%

%cmddb% <crsp_create_clrsubdep3.tsql >>%logfilename%
%cmddb% <crsp_lock_clrsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_all.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_by_contcleardep2idx.tsql >>%logfilename%
%cmddb% <crsp_read_clrsubdep3_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_clrsubdep3.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep3.tsql >>%logfilename%

%cmddb% <crsp_create_clr_topdep.tsql >>%logfilename%
%cmddb% <crsp_lock_clr_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_all.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_by_conttblidx.tsql >>%logfilename%
%cmddb% <crsp_read_clr_topdep_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_clr_topdep.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_topdep.tsql >>%logfilename%

%cmddb% <crsp_create_clus.tsql >>%logfilename%
%cmddb% <crsp_lock_clus.tsql >>%logfilename%
%cmddb% <crsp_read_clus.tsql >>%logfilename%
%cmddb% <crsp_read_clus_all.tsql >>%logfilename%
%cmddb% <crsp_read_clus_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_clus_by_udomainnameidx.tsql >>%logfilename%
%cmddb% <crsp_read_clus_by_udescridx.tsql >>%logfilename%
%cmddb% <crsp_update_clus.tsql >>%logfilename%
%cmddb% <crsp_delete_clus.tsql >>%logfilename%

%cmddb% <crsp_create_datascope.tsql >>%logfilename%
%cmddb% <crsp_lock_datascope.tsql >>%logfilename%
%cmddb% <crsp_read_datascope.tsql >>%logfilename%
%cmddb% <crsp_read_datascope_all.tsql >>%logfilename%
%cmddb% <crsp_read_datascope_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_datascope_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_datascope.tsql >>%logfilename%
%cmddb% <crsp_delete_datascope.tsql >>%logfilename%

%cmddb% <crsp_create_dtcol.tsql >>%logfilename%
%cmddb% <crsp_lock_dtcol.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_dtcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_dtcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_dtcol.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol.tsql >>%logfilename%

%cmddb% <crsp_create_dtdef.tsql >>%logfilename%
%cmddb% <crsp_lock_dtdef.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dtdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_dtdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_dtdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_dtdef.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef.tsql >>%logfilename%

%cmddb% <crsp_create_dttyp.tsql >>%logfilename%
%cmddb% <crsp_lock_dttyp.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dttyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_dttyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_dttyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_dttyp.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp.tsql >>%logfilename%

%cmddb% <crsp_create_del_dep.tsql >>%logfilename%
%cmddb% <crsp_lock_del_dep.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_cc.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_all.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_dep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_del_dep.tsql >>%logfilename%
%cmddb% <crsp_delete_del_dep.tsql >>%logfilename%

%cmddb% <crsp_create_delsubdep1.tsql >>%logfilename%
%cmddb% <crsp_lock_delsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_all.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_contdeltopidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep1_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_delsubdep1.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1.tsql >>%logfilename%

%cmddb% <crsp_create_delsubdep2.tsql >>%logfilename%
%cmddb% <crsp_lock_delsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_all.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_contdeldep1idx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep2_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_delsubdep2.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2.tsql >>%logfilename%

%cmddb% <crsp_create_delsubdep3.tsql >>%logfilename%
%cmddb% <crsp_lock_delsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_all.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_contdeldep2idx.tsql >>%logfilename%
%cmddb% <crsp_read_delsubdep3_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_delsubdep3.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3.tsql >>%logfilename%

%cmddb% <crsp_create_del_topdep.tsql >>%logfilename%
%cmddb% <crsp_lock_del_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_all.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_conttblidx.tsql >>%logfilename%
%cmddb% <crsp_read_del_topdep_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_del_topdep.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep.tsql >>%logfilename%

%cmddb% <crsp_create_domdef.tsql >>%logfilename%
%cmddb% <crsp_lock_domdef.tsql >>%logfilename%
%cmddb% <crsp_read_domdef.tsql >>%logfilename%
%cmddb% <crsp_read_domdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_domdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_domdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_domdef_by_subdomidx.tsql >>%logfilename%
%cmddb% <crsp_read_domdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_domdef.tsql >>%logfilename%
%cmddb% <crsp_delete_domdef.tsql >>%logfilename%

%cmddb% <crsp_create_bdomdef.tsql >>%logfilename%
%cmddb% <crsp_lock_bdomdef.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_bdomdef_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_update_bdomdef.tsql >>%logfilename%
%cmddb% <crsp_delete_bdomdef.tsql >>%logfilename%

%cmddb% <crsp_create_dblcol.tsql >>%logfilename%
%cmddb% <crsp_lock_dblcol.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dblcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_dblcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_dblcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_dblcol.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol.tsql >>%logfilename%

%cmddb% <crsp_create_dbldef.tsql >>%logfilename%
%cmddb% <crsp_lock_dbldef.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_all.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbldef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_dbldef.tsql >>%logfilename%
%cmddb% <crsp_moveup_dbldef.tsql >>%logfilename%
%cmddb% <crsp_movedown_dbldef.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef.tsql >>%logfilename%

%cmddb% <crsp_create_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_lock_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dbltyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_dbltyp.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp.tsql >>%logfilename%

%cmddb% <crsp_create_enumcol.tsql >>%logfilename%
%cmddb% <crsp_lock_enumcol.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_enumcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_enumcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_enumcol.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol.tsql >>%logfilename%

%cmddb% <crsp_create_enumdef.tsql >>%logfilename%
%cmddb% <crsp_lock_enumdef.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_enumdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_enumdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_enumdef.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef.tsql >>%logfilename%

%cmddb% <crsp_create_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_lock_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_all.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_enumtagtenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_enumidx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_enumnameidx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_enum_tag_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_update_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_moveup_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_movedown_enum_tag.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag.tsql >>%logfilename%

%cmddb% <crsp_create_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_lock_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_enumtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_enumtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp.tsql >>%logfilename%

%cmddb% <crsp_create_fltcol.tsql >>%logfilename%
%cmddb% <crsp_lock_fltcol.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_fltcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_fltcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_fltcol.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol.tsql >>%logfilename%

%cmddb% <crsp_create_fltdef.tsql >>%logfilename%
%cmddb% <crsp_lock_fltdef.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_fltdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_fltdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_fltdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_fltdef.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef.tsql >>%logfilename%

%cmddb% <crsp_create_flttyp.tsql >>%logfilename%
%cmddb% <crsp_lock_flttyp.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_flttyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_flttyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_flttyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_flttyp.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp.tsql >>%logfilename%

%cmddb% <crsp_create_hostnode.tsql >>%logfilename%
%cmddb% <crsp_lock_hostnode.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode_all.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode_by_udescridx.tsql >>%logfilename%
%cmddb% <crsp_read_hostnode_by_hostnameidx.tsql >>%logfilename%
%cmddb% <crsp_update_hostnode.tsql >>%logfilename%
%cmddb% <crsp_delete_hostnode.tsql >>%logfilename%

%cmddb% <crsp_create_iso_cntry.tsql >>%logfilename%
%cmddb% <crsp_lock_iso_cntry.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntry.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntry_all.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntry_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntry_by_isocodeidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntry_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_iso_cntry.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntry.tsql >>%logfilename%

%cmddb% <crsp_create_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crsp_lock_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntryccy_all.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntryccy_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntryccy_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntryccy_by_currencyidx.tsql >>%logfilename%
%cmddb% <crsp_update_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntryccy.tsql >>%logfilename%

%cmddb% <crsp_create_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crsp_lock_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntrylng_all.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntrylng_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntrylng_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_cntrylng_by_languageidx.tsql >>%logfilename%
%cmddb% <crsp_update_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntrylng.tsql >>%logfilename%

%cmddb% <crsp_create_iso_ccy.tsql >>%logfilename%
%cmddb% <crsp_lock_iso_ccy.tsql >>%logfilename%
%cmddb% <crsp_read_iso_ccy.tsql >>%logfilename%
%cmddb% <crsp_read_iso_ccy_all.tsql >>%logfilename%
%cmddb% <crsp_read_iso_ccy_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_ccy_by_ccycdidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_ccy_by_ccynmidx.tsql >>%logfilename%
%cmddb% <crsp_update_iso_ccy.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_ccy.tsql >>%logfilename%

%cmddb% <crsp_create_iso_lang.tsql >>%logfilename%
%cmddb% <crsp_lock_iso_lang.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang_all.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang_by_baseidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_read_iso_lang_by_codeidx.tsql >>%logfilename%
%cmddb% <crsp_update_iso_lang.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_lang.tsql >>%logfilename%

%cmddb% <crsp_create_isotz.tsql >>%logfilename%
%cmddb% <crsp_lock_isotz.tsql >>%logfilename%
%cmddb% <crsp_read_isotz.tsql >>%logfilename%
%cmddb% <crsp_read_isotz_all.tsql >>%logfilename%
%cmddb% <crsp_read_isotz_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_isotz_by_offsetidx.tsql >>%logfilename%
%cmddb% <crsp_read_isotz_by_utznameidx.tsql >>%logfilename%
%cmddb% <crsp_read_isotz_by_iso8601idx.tsql >>%logfilename%
%cmddb% <crsp_update_isotz.tsql >>%logfilename%
%cmddb% <crsp_delete_isotz.tsql >>%logfilename%

%cmddb% <crsp_create_idg16.tsql >>%logfilename%
%cmddb% <crsp_lock_idg16.tsql >>%logfilename%
%cmddb% <crsp_read_idg16.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_all.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg16_by_dispidx.tsql >>%logfilename%
%cmddb% <crsp_update_idg16.tsql >>%logfilename%
%cmddb% <crsp_moveup_idg16.tsql >>%logfilename%
%cmddb% <crsp_movedown_idg16.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16.tsql >>%logfilename%

%cmddb% <crsp_create_idg32.tsql >>%logfilename%
%cmddb% <crsp_lock_idg32.tsql >>%logfilename%
%cmddb% <crsp_read_idg32.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_all.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg32_by_dispidx.tsql >>%logfilename%
%cmddb% <crsp_update_idg32.tsql >>%logfilename%
%cmddb% <crsp_moveup_idg32.tsql >>%logfilename%
%cmddb% <crsp_movedown_idg32.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32.tsql >>%logfilename%

%cmddb% <crsp_create_idg64.tsql >>%logfilename%
%cmddb% <crsp_lock_idg64.tsql >>%logfilename%
%cmddb% <crsp_read_idg64.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_all.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idg64_by_dispidx.tsql >>%logfilename%
%cmddb% <crsp_update_idg64.tsql >>%logfilename%
%cmddb% <crsp_moveup_idg64.tsql >>%logfilename%
%cmddb% <crsp_movedown_idg64.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64.tsql >>%logfilename%

%cmddb% <crsp_create_idxdef.tsql >>%logfilename%
%cmddb% <crsp_lock_idxdef.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_indextenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_idxdef.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef.tsql >>%logfilename%

%cmddb% <crsp_create_idxcol.tsql >>%logfilename%
%cmddb% <crsp_lock_idxcol.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_idxcoltenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_indexidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_colidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_idxprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_idxcol_by_idxnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_idxcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_idxcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_idxcol.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol.tsql >>%logfilename%

%cmddb% <crsp_create_int16col.tsql >>%logfilename%
%cmddb% <crsp_lock_int16col.tsql >>%logfilename%
%cmddb% <crsp_read_int16col.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_all.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_int16col.tsql >>%logfilename%
%cmddb% <crsp_moveup_int16col.tsql >>%logfilename%
%cmddb% <crsp_movedown_int16col.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col.tsql >>%logfilename%

%cmddb% <crsp_create_int16def.tsql >>%logfilename%
%cmddb% <crsp_lock_int16def.tsql >>%logfilename%
%cmddb% <crsp_read_int16def.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_all.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_int16def.tsql >>%logfilename%
%cmddb% <crsp_moveup_int16def.tsql >>%logfilename%
%cmddb% <crsp_movedown_int16def.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def.tsql >>%logfilename%

%cmddb% <crsp_create_int16typ.tsql >>%logfilename%
%cmddb% <crsp_lock_int16typ.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int16typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_int16typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_int16typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_int16typ.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ.tsql >>%logfilename%

%cmddb% <crsp_create_int32col.tsql >>%logfilename%
%cmddb% <crsp_lock_int32col.tsql >>%logfilename%
%cmddb% <crsp_read_int32col.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_all.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_int32col.tsql >>%logfilename%
%cmddb% <crsp_moveup_int32col.tsql >>%logfilename%
%cmddb% <crsp_movedown_int32col.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col.tsql >>%logfilename%

%cmddb% <crsp_create_int32def.tsql >>%logfilename%
%cmddb% <crsp_lock_int32def.tsql >>%logfilename%
%cmddb% <crsp_read_int32def.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_all.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_int32def.tsql >>%logfilename%
%cmddb% <crsp_moveup_int32def.tsql >>%logfilename%
%cmddb% <crsp_movedown_int32def.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def.tsql >>%logfilename%

%cmddb% <crsp_create_int32typ.tsql >>%logfilename%
%cmddb% <crsp_lock_int32typ.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int32typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_int32typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_int32typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_int32typ.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ.tsql >>%logfilename%

%cmddb% <crsp_create_int64col.tsql >>%logfilename%
%cmddb% <crsp_lock_int64col.tsql >>%logfilename%
%cmddb% <crsp_read_int64col.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_all.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_int64col.tsql >>%logfilename%
%cmddb% <crsp_moveup_int64col.tsql >>%logfilename%
%cmddb% <crsp_movedown_int64col.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col.tsql >>%logfilename%

%cmddb% <crsp_create_int64def.tsql >>%logfilename%
%cmddb% <crsp_lock_int64def.tsql >>%logfilename%
%cmddb% <crsp_read_int64def.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_all.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_int64def.tsql >>%logfilename%
%cmddb% <crsp_moveup_int64def.tsql >>%logfilename%
%cmddb% <crsp_movedown_int64def.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def.tsql >>%logfilename%

%cmddb% <crsp_create_int64typ.tsql >>%logfilename%
%cmddb% <crsp_lock_int64typ.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_int64typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_int64typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_int64typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_int64typ.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ.tsql >>%logfilename%

%cmddb% <crsp_lock_licn.tsql >>%logfilename%
%cmddb% <crsp_read_licn.tsql >>%logfilename%
%cmddb% <crsp_read_licn_all.tsql >>%logfilename%
%cmddb% <crsp_read_licn_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_licn_by_licntenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_licn_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_read_licn_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_licn.tsql >>%logfilename%

%cmddb% <crsp_create_loadbehav.tsql >>%logfilename%
%cmddb% <crsp_lock_loadbehav.tsql >>%logfilename%
%cmddb% <crsp_read_loadbehav.tsql >>%logfilename%
%cmddb% <crsp_read_loadbehav_all.tsql >>%logfilename%
%cmddb% <crsp_read_loadbehav_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_loadbehav_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_loadbehav.tsql >>%logfilename%
%cmddb% <crsp_delete_loadbehav.tsql >>%logfilename%

%cmddb% <crsp_create_mjverdef.tsql >>%logfilename%
%cmddb% <crsp_lock_mjverdef.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef_by_pprjidx.tsql >>%logfilename%
%cmddb% <crsp_read_mjverdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_mjverdef.tsql >>%logfilename%
%cmddb% <crsp_delete_mjverdef.tsql >>%logfilename%

%cmddb% <crsp_create_mimetype.tsql >>%logfilename%
%cmddb% <crsp_lock_mimetype.tsql >>%logfilename%
%cmddb% <crsp_read_mimetype.tsql >>%logfilename%
%cmddb% <crsp_read_mimetype_all.tsql >>%logfilename%
%cmddb% <crsp_read_mimetype_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_mimetype_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_mimetype.tsql >>%logfilename%
%cmddb% <crsp_delete_mimetype.tsql >>%logfilename%

%cmddb% <crsp_create_mnverdef.tsql >>%logfilename%
%cmddb% <crsp_lock_mnverdef.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef_by_majoridx.tsql >>%logfilename%
%cmddb% <crsp_read_mnverdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_mnverdef.tsql >>%logfilename%
%cmddb% <crsp_delete_mnverdef.tsql >>%logfilename%

%cmddb% <crsp_create_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkncol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtkncol.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol.tsql >>%logfilename%

%cmddb% <crsp_create_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkndef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtkndef.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef.tsql >>%logfilename%

%cmddb% <crsp_create_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtkntyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtkntyp.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp.tsql >>%logfilename%

%cmddb% <crsp_create_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknscol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtknscol.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol.tsql >>%logfilename%

%cmddb% <crsp_create_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknsdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtknsdef.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef.tsql >>%logfilename%

%cmddb% <crsp_create_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_lock_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_nmtknstyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_nmtknstyp.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp.tsql >>%logfilename%

%cmddb% <crsp_create_numcol.tsql >>%logfilename%
%cmddb% <crsp_lock_numcol.tsql >>%logfilename%
%cmddb% <crsp_read_numcol.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_numcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_numcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_numcol.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol.tsql >>%logfilename%

%cmddb% <crsp_create_numdef.tsql >>%logfilename%
%cmddb% <crsp_lock_numdef.tsql >>%logfilename%
%cmddb% <crsp_read_numdef.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_numdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_numdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_numdef.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef.tsql >>%logfilename%

%cmddb% <crsp_create_numtyp.tsql >>%logfilename%
%cmddb% <crsp_lock_numtyp.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_numtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_numtyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_numtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_numtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp.tsql >>%logfilename%

%cmddb% <crsp_create_srvprm.tsql >>%logfilename%
%cmddb% <crsp_lock_srvprm.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_servermethodidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_servertypeidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprm_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_srvprm.tsql >>%logfilename%
%cmddb% <crsp_moveup_srvprm.tsql >>%logfilename%
%cmddb% <crsp_movedown_srvprm.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm.tsql >>%logfilename%

%cmddb% <crsp_create_pop_dep.tsql >>%logfilename%
%cmddb% <crsp_lock_pop_dep.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_cc.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_all.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_dep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_pop_dep.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_dep.tsql >>%logfilename%

%cmddb% <crsp_create_popsubdep1.tsql >>%logfilename%
%cmddb% <crsp_lock_popsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_all.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_contpoptopidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep1_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_popsubdep1.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1.tsql >>%logfilename%

%cmddb% <crsp_create_popsubdep2.tsql >>%logfilename%
%cmddb% <crsp_lock_popsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_all.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_contpopdep1idx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep2_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_popsubdep2.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2.tsql >>%logfilename%

%cmddb% <crsp_create_popsubdep3.tsql >>%logfilename%
%cmddb% <crsp_lock_popsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_all.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_contpopdep2idx.tsql >>%logfilename%
%cmddb% <crsp_read_popsubdep3_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_popsubdep3.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3.tsql >>%logfilename%

%cmddb% <crsp_create_pop_topdep.tsql >>%logfilename%
%cmddb% <crsp_lock_pop_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_all.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_contrelidx.tsql >>%logfilename%
%cmddb% <crsp_read_pop_topdep_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_pop_topdep.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep.tsql >>%logfilename%

%cmddb% <crsp_create_bprjdef.tsql >>%logfilename%
%cmddb% <crsp_lock_bprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_bprjdef_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_update_bprjdef.tsql >>%logfilename%
%cmddb% <crsp_delete_bprjdef.tsql >>%logfilename%

%cmddb% <crsp_create_rprjdef.tsql >>%logfilename%
%cmddb% <crsp_lock_rprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_rprjdef_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_update_rprjdef.tsql >>%logfilename%
%cmddb% <crsp_delete_rprjdef.tsql >>%logfilename%

%cmddb% <crsp_create_reldef.tsql >>%logfilename%
%cmddb% <crsp_lock_reldef.tsql >>%logfilename%
%cmddb% <crsp_read_reldef.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_all.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_relntenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_rtypekeyidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_fromkeyidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_totblidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_tokeyidx.tsql >>%logfilename%
%cmddb% <crsp_read_reldef_by_narrowedidx.tsql >>%logfilename%
%cmddb% <crsp_update_reldef.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef.tsql >>%logfilename%

%cmddb% <crsp_create_relcol.tsql >>%logfilename%
%cmddb% <crsp_lock_relcol.tsql >>%logfilename%
%cmddb% <crsp_read_relcol.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_relcoltenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_fromcolidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_tocolidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_relprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_relcol_by_relnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_relcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_relcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_relcol.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol.tsql >>%logfilename%

%cmddb% <crsp_create_rel_type.tsql >>%logfilename%
%cmddb% <crsp_lock_rel_type.tsql >>%logfilename%
%cmddb% <crsp_read_rel_type.tsql >>%logfilename%
%cmddb% <crsp_read_rel_type_all.tsql >>%logfilename%
%cmddb% <crsp_read_rel_type_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_rel_type_by_utagidx.tsql >>%logfilename%
%cmddb% <crsp_update_rel_type.tsql >>%logfilename%
%cmddb% <crsp_delete_rel_type.tsql >>%logfilename%

%cmddb% <crsp_lock_schemadef.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_all.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_ctenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_deflcnidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_schemadef_by_puburiidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef.tsql >>%logfilename%

%cmddb% <crsp_create_schema_ref.tsql >>%logfilename%
%cmddb% <crsp_lock_schema_ref.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_all.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_schema_ref_by_refschemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_schema_ref.tsql >>%logfilename%
%cmddb% <crsp_delete_schema_ref.tsql >>%logfilename%

%cmddb% <crsp_create_scopedef.tsql >>%logfilename%
%cmddb% <crsp_lock_scopedef.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_all.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_scopedef_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_update_scopedef.tsql >>%logfilename%
%cmddb% <crsp_delete_scopedef.tsql >>%logfilename%

%cmddb% <crsp_create_secapp.tsql >>%logfilename%
%cmddb% <crsp_lock_secapp.tsql >>%logfilename%
%cmddb% <crsp_read_secapp.tsql >>%logfilename%
%cmddb% <crsp_read_secapp_all.tsql >>%logfilename%
%cmddb% <crsp_read_secapp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secapp_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secapp_by_ujeemountidx.tsql >>%logfilename%
%cmddb% <crsp_update_secapp.tsql >>%logfilename%
%cmddb% <crsp_delete_secapp.tsql >>%logfilename%

%cmddb% <crsp_lock_secdev.tsql >>%logfilename%
%cmddb% <crsp_read_secdev.tsql >>%logfilename%
%cmddb% <crsp_read_secdev_all.tsql >>%logfilename%
%cmddb% <crsp_read_secdev_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secdev_by_useridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secdev.tsql >>%logfilename%

%cmddb% <crsp_create_secform.tsql >>%logfilename%
%cmddb% <crsp_lock_secform.tsql >>%logfilename%
%cmddb% <crsp_read_secform.tsql >>%logfilename%
%cmddb% <crsp_read_secform_all.tsql >>%logfilename%
%cmddb% <crsp_read_secform_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secform_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secform_by_secappidx.tsql >>%logfilename%
%cmddb% <crsp_read_secform_by_ujeeservletidx.tsql >>%logfilename%
%cmddb% <crsp_update_secform.tsql >>%logfilename%
%cmddb% <crsp_delete_secform.tsql >>%logfilename%

%cmddb% <crsp_create_secgrp.tsql >>%logfilename%
%cmddb% <crsp_lock_secgrp.tsql >>%logfilename%
%cmddb% <crsp_read_secgrp.tsql >>%logfilename%
%cmddb% <crsp_read_secgrp_all.tsql >>%logfilename%
%cmddb% <crsp_read_secgrp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrp_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_secgrp.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrp.tsql >>%logfilename%

%cmddb% <crsp_create_secgrpfrm.tsql >>%logfilename%
%cmddb% <crsp_lock_secgrpfrm.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_all.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_appidx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_formidx.tsql >>%logfilename%
%cmddb% <crsp_read_secgrpfrm_by_uformidx.tsql >>%logfilename%
%cmddb% <crsp_update_secgrpfrm.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm.tsql >>%logfilename%

%cmddb% <crsp_create_secinc.tsql >>%logfilename%
%cmddb% <crsp_lock_secinc.tsql >>%logfilename%
%cmddb% <crsp_read_secinc.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_all.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_by_includeidx.tsql >>%logfilename%
%cmddb% <crsp_read_secinc_by_uincludeidx.tsql >>%logfilename%
%cmddb% <crsp_update_secinc.tsql >>%logfilename%
%cmddb% <crsp_delete_secinc.tsql >>%logfilename%

%cmddb% <crsp_create_secmemb.tsql >>%logfilename%
%cmddb% <crsp_lock_secmemb.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_all.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_by_useridx.tsql >>%logfilename%
%cmddb% <crsp_read_secmemb_by_uuseridx.tsql >>%logfilename%
%cmddb% <crsp_update_secmemb.tsql >>%logfilename%
%cmddb% <crsp_delete_secmemb.tsql >>%logfilename%

%cmddb% <crsp_create_secsess.tsql >>%logfilename%
%cmddb% <crsp_lock_secsess.tsql >>%logfilename%
%cmddb% <crsp_read_secsess.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_all.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_secuseridx.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_secdevidx.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_startidx.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_finishidx.tsql >>%logfilename%
%cmddb% <crsp_read_secsess_by_secproxyidx.tsql >>%logfilename%
%cmddb% <crsp_update_secsess.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess.tsql >>%logfilename%

%cmddb% <crsp_create_secuser.tsql >>%logfilename%
%cmddb% <crsp_lock_secuser.tsql >>%logfilename%
%cmddb% <crsp_read_secuser.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_all.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_by_uloginidx.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_by_emconfidx.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_by_pwdresetidx.tsql >>%logfilename%
%cmddb% <crsp_read_secuser_by_defdevidx.tsql >>%logfilename%
%cmddb% <crsp_update_secuser.tsql >>%logfilename%
%cmddb% <crsp_delete_secuser.tsql >>%logfilename%

%cmddb% <crsp_create_secscope.tsql >>%logfilename%
%cmddb% <crsp_lock_secscope.tsql >>%logfilename%
%cmddb% <crsp_read_secscope.tsql >>%logfilename%
%cmddb% <crsp_read_secscope_all.tsql >>%logfilename%
%cmddb% <crsp_read_secscope_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_secscope_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_secscope.tsql >>%logfilename%
%cmddb% <crsp_delete_secscope.tsql >>%logfilename%

%cmddb% <crsp_lock_srvlfunc.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvlfunc_by_rettblidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc.tsql >>%logfilename%

%cmddb% <crsp_lock_srvmeth.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_cc.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvmeth_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvmeth.tsql >>%logfilename%

%cmddb% <crsp_lock_srvofunc.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvofunc_by_rettblidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc.tsql >>%logfilename%

%cmddb% <crsp_lock_srvprc.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_all.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_srvprc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprc.tsql >>%logfilename%

%cmddb% <crsp_create_hostsvc.tsql >>%logfilename%
%cmddb% <crsp_lock_hostsvc.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_all.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_hostidx.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_typeidx.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_utypeidx.tsql >>%logfilename%
%cmddb% <crsp_read_hostsvc_by_uhostportidx.tsql >>%logfilename%
%cmddb% <crsp_update_hostsvc.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc.tsql >>%logfilename%

%cmddb% <crsp_create_svctype.tsql >>%logfilename%
%cmddb% <crsp_lock_svctype.tsql >>%logfilename%
%cmddb% <crsp_read_svctype.tsql >>%logfilename%
%cmddb% <crsp_read_svctype_all.tsql >>%logfilename%
%cmddb% <crsp_read_svctype_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_svctype_by_udescridx.tsql >>%logfilename%
%cmddb% <crsp_update_svctype.tsql >>%logfilename%
%cmddb% <crsp_delete_svctype.tsql >>%logfilename%

%cmddb% <crsp_create_strcol.tsql >>%logfilename%
%cmddb% <crsp_lock_strcol.tsql >>%logfilename%
%cmddb% <crsp_read_strcol.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_strcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_strcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_strcol.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol.tsql >>%logfilename%

%cmddb% <crsp_create_strdef.tsql >>%logfilename%
%cmddb% <crsp_lock_strdef.tsql >>%logfilename%
%cmddb% <crsp_read_strdef.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_strdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_strdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_strdef.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef.tsql >>%logfilename%

%cmddb% <crsp_create_strtyp.tsql >>%logfilename%
%cmddb% <crsp_lock_strtyp.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_strtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_strtyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_strtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_strtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp.tsql >>%logfilename%

%cmddb% <crsp_create_sprjdef.tsql >>%logfilename%
%cmddb% <crsp_lock_sprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef_by_parentidx.tsql >>%logfilename%
%cmddb% <crsp_read_sprjdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_sprjdef.tsql >>%logfilename%
%cmddb% <crsp_delete_sprjdef.tsql >>%logfilename%

%cmddb% <crsp_create_sysclus.tsql >>%logfilename%
%cmddb% <crsp_lock_sysclus.tsql >>%logfilename%
%cmddb% <crsp_read_sysclus.tsql >>%logfilename%
%cmddb% <crsp_read_sysclus_all.tsql >>%logfilename%
%cmddb% <crsp_read_sysclus_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_sysclus_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_update_sysclus.tsql >>%logfilename%
%cmddb% <crsp_delete_sysclus.tsql >>%logfilename%

%cmddb% <crsp_create_tsecgrp.tsql >>%logfilename%
%cmddb% <crsp_lock_tsecgrp.tsql >>%logfilename%
%cmddb% <crsp_read_tsecgrp.tsql >>%logfilename%
%cmddb% <crsp_read_tsecgrp_all.tsql >>%logfilename%
%cmddb% <crsp_read_tsecgrp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecgrp_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecgrp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_tsecgrp.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecgrp.tsql >>%logfilename%

%cmddb% <crsp_create_tsecinc.tsql >>%logfilename%
%cmddb% <crsp_lock_tsecinc.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_all.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_by_includeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecinc_by_uincludeidx.tsql >>%logfilename%
%cmddb% <crsp_update_tsecinc.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecinc.tsql >>%logfilename%

%cmddb% <crsp_create_tsecmemb.tsql >>%logfilename%
%cmddb% <crsp_lock_tsecmemb.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_all.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_by_useridx.tsql >>%logfilename%
%cmddb% <crsp_read_tsecmemb_by_uuseridx.tsql >>%logfilename%
%cmddb% <crsp_update_tsecmemb.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecmemb.tsql >>%logfilename%

%cmddb% <crsp_create_dzcol.tsql >>%logfilename%
%cmddb% <crsp_lock_dzcol.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_dzcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_dzcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_dzcol.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol.tsql >>%logfilename%

%cmddb% <crsp_create_dzdef.tsql >>%logfilename%
%cmddb% <crsp_lock_dzdef.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dzdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_dzdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_dzdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_dzdef.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef.tsql >>%logfilename%

%cmddb% <crsp_create_dztyp.tsql >>%logfilename%
%cmddb% <crsp_lock_dztyp.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_dztyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_dztyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_dztyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_dztyp.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp.tsql >>%logfilename%

%cmddb% <crsp_create_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_lock_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmzcol.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol.tsql >>%logfilename%

%cmddb% <crsp_create_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_lock_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmzdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmzdef.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef.tsql >>%logfilename%

%cmddb% <crsp_create_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_lock_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmztyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmztyp.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp.tsql >>%logfilename%

%cmddb% <crsp_create_zscol.tsql >>%logfilename%
%cmddb% <crsp_lock_zscol.tsql >>%logfilename%
%cmddb% <crsp_read_zscol.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_all.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zscol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_zscol.tsql >>%logfilename%
%cmddb% <crsp_moveup_zscol.tsql >>%logfilename%
%cmddb% <crsp_movedown_zscol.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol.tsql >>%logfilename%

%cmddb% <crsp_create_zsdef.tsql >>%logfilename%
%cmddb% <crsp_lock_zsdef.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zsdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_zsdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_zsdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_zsdef.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef.tsql >>%logfilename%

%cmddb% <crsp_create_zstyp.tsql >>%logfilename%
%cmddb% <crsp_lock_zstyp.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_zstyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_zstyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_zstyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_zstyp.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp.tsql >>%logfilename%

%cmddb% <crsp_lock_tbldef.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_schemadefidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_schemacdidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_primaryindexidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_lookupindexidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_altindexidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_qualtableidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_loadbehaveidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_secscopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tbldef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef.tsql >>%logfilename%

%cmddb% <crsp_create_tblcol.tsql >>%logfilename%
%cmddb% <crsp_lock_tblcol.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_read_tblcol_by_dataidx.tsql >>%logfilename%
%cmddb% <crsp_update_tblcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_tblcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_tblcol.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol.tsql >>%logfilename%

%cmddb% <crsp_create_tenant.tsql >>%logfilename%
%cmddb% <crsp_lock_tenant.tsql >>%logfilename%
%cmddb% <crsp_read_tenant.tsql >>%logfilename%
%cmddb% <crsp_read_tenant_all.tsql >>%logfilename%
%cmddb% <crsp_read_tenant_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tenant_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_read_tenant_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_update_tenant.tsql >>%logfilename%
%cmddb% <crsp_delete_tenant.tsql >>%logfilename%

%cmddb% <crsp_lock_txtcol.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_txtcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_txtcol.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol.tsql >>%logfilename%

%cmddb% <crsp_lock_txtdef.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txtdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_txtdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_txtdef.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef.tsql >>%logfilename%

%cmddb% <crsp_lock_txttyp.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_txttyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_moveup_txttyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_txttyp.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp.tsql >>%logfilename%

%cmddb% <crsp_create_tmcol.tsql >>%logfilename%
%cmddb% <crsp_lock_tmcol.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmcol.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol.tsql >>%logfilename%

%cmddb% <crsp_create_tmdef.tsql >>%logfilename%
%cmddb% <crsp_lock_tmdef.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmdef.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef.tsql >>%logfilename%

%cmddb% <crsp_create_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_lock_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tmtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_tmtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp.tsql >>%logfilename%

%cmddb% <crsp_create_tscol.tsql >>%logfilename%
%cmddb% <crsp_lock_tscol.tsql >>%logfilename%
%cmddb% <crsp_read_tscol.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_all.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tscol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_tscol.tsql >>%logfilename%
%cmddb% <crsp_moveup_tscol.tsql >>%logfilename%
%cmddb% <crsp_movedown_tscol.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol.tsql >>%logfilename%

%cmddb% <crsp_create_tsdef.tsql >>%logfilename%
%cmddb% <crsp_lock_tsdef.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tsdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_tsdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_tsdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_tsdef.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef.tsql >>%logfilename%

%cmddb% <crsp_create_tstyp.tsql >>%logfilename%
%cmddb% <crsp_lock_tstyp.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tstyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_tstyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_tstyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_tstyp.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp.tsql >>%logfilename%

%cmddb% <crsp_create_tlddef.tsql >>%logfilename%
%cmddb% <crsp_lock_tlddef.tsql >>%logfilename%
%cmddb% <crsp_read_tlddef.tsql >>%logfilename%
%cmddb% <crsp_read_tlddef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tlddef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tlddef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tlddef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_tlddef.tsql >>%logfilename%
%cmddb% <crsp_delete_tlddef.tsql >>%logfilename%

%cmddb% <crsp_create_tkncol.tsql >>%logfilename%
%cmddb% <crsp_lock_tkncol.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_all.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkncol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_tkncol.tsql >>%logfilename%
%cmddb% <crsp_moveup_tkncol.tsql >>%logfilename%
%cmddb% <crsp_movedown_tkncol.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol.tsql >>%logfilename%

%cmddb% <crsp_create_tkndef.tsql >>%logfilename%
%cmddb% <crsp_lock_tkndef.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkndef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_tkndef.tsql >>%logfilename%
%cmddb% <crsp_moveup_tkndef.tsql >>%logfilename%
%cmddb% <crsp_movedown_tkndef.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef.tsql >>%logfilename%

%cmddb% <crsp_create_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_lock_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_tkntyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_tkntyp.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp.tsql >>%logfilename%

%cmddb% <crsp_create_tdomdef.tsql >>%logfilename%
%cmddb% <crsp_lock_tdomdef.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef_by_tldidx.tsql >>%logfilename%
%cmddb% <crsp_read_tdomdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_tdomdef.tsql >>%logfilename%
%cmddb% <crsp_delete_tdomdef.tsql >>%logfilename%

%cmddb% <crsp_create_tprjdef.tsql >>%logfilename%
%cmddb% <crsp_lock_tprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_read_tprjdef_by_nameidx.tsql >>%logfilename%
%cmddb% <crsp_update_tprjdef.tsql >>%logfilename%
%cmddb% <crsp_delete_tprjdef.tsql >>%logfilename%

%cmddb% <crsp_create_uint16col.tsql >>%logfilename%
%cmddb% <crsp_lock_uint16col.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint16col.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint16col.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint16col.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col.tsql >>%logfilename%

%cmddb% <crsp_create_u16def.tsql >>%logfilename%
%cmddb% <crsp_lock_u16def.tsql >>%logfilename%
%cmddb% <crsp_read_u16def.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_all.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u16def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_u16def.tsql >>%logfilename%
%cmddb% <crsp_moveup_u16def.tsql >>%logfilename%
%cmddb% <crsp_movedown_u16def.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def.tsql >>%logfilename%

%cmddb% <crsp_create_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_lock_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint16typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint16typ.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ.tsql >>%logfilename%

%cmddb% <crsp_create_uint32col.tsql >>%logfilename%
%cmddb% <crsp_lock_uint32col.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint32col.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint32col.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint32col.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col.tsql >>%logfilename%

%cmddb% <crsp_create_u32def.tsql >>%logfilename%
%cmddb% <crsp_lock_u32def.tsql >>%logfilename%
%cmddb% <crsp_read_u32def.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_all.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u32def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_u32def.tsql >>%logfilename%
%cmddb% <crsp_moveup_u32def.tsql >>%logfilename%
%cmddb% <crsp_movedown_u32def.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def.tsql >>%logfilename%

%cmddb% <crsp_create_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_lock_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint32typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint32typ.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ.tsql >>%logfilename%

%cmddb% <crsp_create_uint64col.tsql >>%logfilename%
%cmddb% <crsp_lock_uint64col.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64col_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint64col.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint64col.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint64col.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col.tsql >>%logfilename%

%cmddb% <crsp_create_u64def.tsql >>%logfilename%
%cmddb% <crsp_lock_u64def.tsql >>%logfilename%
%cmddb% <crsp_read_u64def.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_all.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_u64def_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_u64def.tsql >>%logfilename%
%cmddb% <crsp_moveup_u64def.tsql >>%logfilename%
%cmddb% <crsp_movedown_u64def.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def.tsql >>%logfilename%

%cmddb% <crsp_create_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_lock_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_all.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uint64typ_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_moveup_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_movedown_uint64typ.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ.tsql >>%logfilename%

%cmddb% <crsp_create_urlproto.tsql >>%logfilename%
%cmddb% <crsp_lock_urlproto.tsql >>%logfilename%
%cmddb% <crsp_read_urlproto.tsql >>%logfilename%
%cmddb% <crsp_read_urlproto_all.tsql >>%logfilename%
%cmddb% <crsp_read_urlproto_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_urlproto_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_urlproto_by_issecureidx.tsql >>%logfilename%
%cmddb% <crsp_update_urlproto.tsql >>%logfilename%
%cmddb% <crsp_delete_urlproto.tsql >>%logfilename%

%cmddb% <crsp_create_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_lock_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_all.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_update_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_moveup_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_movedown_uuidcol.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol.tsql >>%logfilename%

%cmddb% <crsp_create_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_lock_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_all.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuiddef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_moveup_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_movedown_uuiddef.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef.tsql >>%logfilename%

%cmddb% <crsp_create_idguuid.tsql >>%logfilename%
%cmddb% <crsp_lock_idguuid.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_all.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_idguuid_by_dispidx.tsql >>%logfilename%
%cmddb% <crsp_update_idguuid.tsql >>%logfilename%
%cmddb% <crsp_moveup_idguuid.tsql >>%logfilename%
%cmddb% <crsp_movedown_idguuid.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid.tsql >>%logfilename%

%cmddb% <crsp_create_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_lock_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_all.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_uuidtyp_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_update_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_moveup_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_movedown_uuidtyp.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp.tsql >>%logfilename%

%cmddb% <crsp_create_valdef.tsql >>%logfilename%
%cmddb% <crsp_lock_valdef.tsql >>%logfilename%
%cmddb% <crsp_read_valdef.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_all.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_read_valdef_cc_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_update_valdef.tsql >>%logfilename%
%cmddb% <crsp_moveup_valdef.tsql >>%logfilename%
%cmddb% <crsp_movedown_valdef.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef.tsql >>%logfilename%

%cmddb% <crsp_create_verndef.tsql >>%logfilename%
%cmddb% <crsp_lock_verndef.tsql >>%logfilename%
%cmddb% <crsp_read_verndef.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_cc.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_all.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_cc_all.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_cc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_read_verndef_cc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_update_verndef.tsql >>%logfilename%
%cmddb% <crsp_delete_verndef.tsql >>%logfilename%


%cmddb% <crsp_delete_accfreq_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_accfreq_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_accsec_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_accsec_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_atomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_atomdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_auditaction_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_auditaction_by_udescridx.tsql >>%logfilename%

%cmddb% <crsp_delete_blbcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_blbdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_blbtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_blbtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_boolcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_boolcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_booldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booldef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_booltyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_booltyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_chain_def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_prevrelidx.tsql >>%logfilename%
%cmddb% <crsp_delete_chain_def_by_nextrelidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clr_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_dep_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clrsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep1_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep1_by_contcleartopidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep1_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clrsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep2_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep2_by_contcleardep1idx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep2_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clrsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep3_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep3_by_contcleardep2idx.tsql >>%logfilename%
%cmddb% <crsp_delete_clrsubdep3_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clr_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_topdep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_topdep_by_conttblidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clr_topdep_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_clus_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_clus_by_udomainnameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_clus_by_udescridx.tsql >>%logfilename%

%cmddb% <crsp_delete_datascope_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_datascope_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dtcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dtdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dtdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dttyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_del_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_dep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_dep_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_delsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1_by_contdeltopidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep1_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_delsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2_by_contdeldep1idx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep2_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_delsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3_by_contdeldep2idx.tsql >>%logfilename%
%cmddb% <crsp_delete_delsubdep3_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_del_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep_by_conttblidx.tsql >>%logfilename%
%cmddb% <crsp_delete_del_topdep_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_domdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_domdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_domdef_by_subdomidx.tsql >>%logfilename%
%cmddb% <crsp_delete_domdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_bdomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_bdomdef_by_tenantidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dblcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dblcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dbldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbldef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dbltyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dbltyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_enumcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_enumdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_enum_tag_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_enumtagtenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_enumidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_enumnameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_enum_tag_by_nextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_enumtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_enumtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_fltcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_fltdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_fltdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_flttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_flttyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_hostnode_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostnode_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostnode_by_udescridx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostnode_by_hostnameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_iso_cntry_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntry_by_isocodeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntry_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_iso_cntryccy_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntryccy_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntryccy_by_currencyidx.tsql >>%logfilename%

%cmddb% <crsp_delete_iso_cntrylng_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntrylng_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_cntrylng_by_languageidx.tsql >>%logfilename%

%cmddb% <crsp_delete_iso_ccy_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_ccy_by_ccycdidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_ccy_by_ccynmidx.tsql >>%logfilename%

%cmddb% <crsp_delete_iso_lang_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_lang_by_baseidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_lang_by_countryidx.tsql >>%logfilename%
%cmddb% <crsp_delete_iso_lang_by_codeidx.tsql >>%logfilename%

%cmddb% <crsp_delete_isotz_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_isotz_by_offsetidx.tsql >>%logfilename%
%cmddb% <crsp_delete_isotz_by_utznameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_isotz_by_iso8601idx.tsql >>%logfilename%

%cmddb% <crsp_delete_idg16_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg16_by_dispidx.tsql >>%logfilename%

%cmddb% <crsp_delete_idg32_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg32_by_dispidx.tsql >>%logfilename%

%cmddb% <crsp_delete_idg64_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idg64_by_dispidx.tsql >>%logfilename%

%cmddb% <crsp_delete_idxdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef_by_indextenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxdef_by_defschemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_idxcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_idxcoltenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_indexidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_colidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_idxprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idxcol_by_idxnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int16col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int16def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int16typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int16typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int32col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int32def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int32typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int32typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int64col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int64def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_int64typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_int64typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_licn_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_licn_by_licntenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_licn_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_delete_licn_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_loadbehav_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_loadbehav_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_mjverdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_mjverdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_mjverdef_by_pprjidx.tsql >>%logfilename%
%cmddb% <crsp_delete_mjverdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_mimetype_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_mimetype_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_mnverdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_mnverdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_mnverdef_by_majoridx.tsql >>%logfilename%
%cmddb% <crsp_delete_mnverdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtkncol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkncol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtkndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkndef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtkntyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtkntyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtknscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknscol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtknsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknsdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_nmtknstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_nmtknstyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_numcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_numdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_numtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_numtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_srvprm_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_servermethodidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_servertypeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprm_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_pop_dep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_dep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_dep_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_dep_by_defschemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_popsubdep1_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1_by_contpoptopidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep1_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_popsubdep2_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2_by_contpopdep1idx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep2_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_popsubdep3_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3_by_contpopdep2idx.tsql >>%logfilename%
%cmddb% <crsp_delete_popsubdep3_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_pop_topdep_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep_by_contrelidx.tsql >>%logfilename%
%cmddb% <crsp_delete_pop_topdep_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_bprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_bprjdef_by_tenantidx.tsql >>%logfilename%

%cmddb% <crsp_delete_rprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_rprjdef_by_tenantidx.tsql >>%logfilename%

%cmddb% <crsp_delete_reldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_relntenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_rtypekeyidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_fromkeyidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_totblidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_tokeyidx.tsql >>%logfilename%
%cmddb% <crsp_delete_reldef_by_narrowedidx.tsql >>%logfilename%

%cmddb% <crsp_delete_relcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_relcoltenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_relationidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_fromcolidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_tocolidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_relprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_relcol_by_relnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_rel_type_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_rel_type_by_utagidx.tsql >>%logfilename%

%cmddb% <crsp_delete_schemadef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_ctenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_deflcnidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schemadef_by_puburiidx.tsql >>%logfilename%

%cmddb% <crsp_delete_schema_ref_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_schema_ref_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schema_ref_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schema_ref_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_schema_ref_by_refschemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_scopedef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_scopedef_by_tenantidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secapp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secapp_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secapp_by_ujeemountidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secdev_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secdev_by_useridx.tsql >>%logfilename%

%cmddb% <crsp_delete_secform_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secform_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secform_by_secappidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secform_by_ujeeservletidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secgrp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrp_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrp_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secgrpfrm_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm_by_appidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm_by_formidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secgrpfrm_by_uformidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secinc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secinc_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secinc_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secinc_by_includeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secinc_by_uincludeidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secmemb_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secmemb_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secmemb_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secmemb_by_useridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secmemb_by_uuseridx.tsql >>%logfilename%

%cmddb% <crsp_delete_secsess_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess_by_secuseridx.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess_by_secdevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess_by_startidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess_by_finishidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secsess_by_secproxyidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secuser_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secuser_by_uloginidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secuser_by_emconfidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secuser_by_pwdresetidx.tsql >>%logfilename%
%cmddb% <crsp_delete_secuser_by_defdevidx.tsql >>%logfilename%

%cmddb% <crsp_delete_secscope_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_secscope_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_srvlfunc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvlfunc_by_rettblidx.tsql >>%logfilename%

%cmddb% <crsp_delete_srvmeth_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvmeth_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvmeth_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvmeth_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvmeth_by_defschemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_srvofunc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvofunc_by_rettblidx.tsql >>%logfilename%

%cmddb% <crsp_delete_srvprc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprc_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprc_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_srvprc_by_defschemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_hostsvc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc_by_hostidx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc_by_typeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc_by_utypeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_hostsvc_by_uhostportidx.tsql >>%logfilename%

%cmddb% <crsp_delete_svctype_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_svctype_by_udescridx.tsql >>%logfilename%

%cmddb% <crsp_delete_strcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_strdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_strtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_strtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_sprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_sprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_sprjdef_by_parentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_sprjdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_sysclus_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_sysclus_by_clusteridx.tsql >>%logfilename%

%cmddb% <crsp_delete_tsecgrp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecgrp_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecgrp_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tsecinc_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecinc_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecinc_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecinc_by_includeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecinc_by_uincludeidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tsecmemb_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecmemb_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecmemb_by_groupidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecmemb_by_useridx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsecmemb_by_uuseridx.tsql >>%logfilename%

%cmddb% <crsp_delete_dzcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dzdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dzdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_dztyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_dztyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmzcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmzdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmzdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmztyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmztyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_zscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zscol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_zsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zsdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_zstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_zstyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tbldef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_schemadefidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_schemacdidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_primaryindexidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_lookupindexidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_altindexidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_qualtableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_loadbehaveidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_secscopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tbldef_by_eaccfreqidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tblcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_tableidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tblcol_by_dataidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tenant_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tenant_by_clusteridx.tsql >>%logfilename%
%cmddb% <crsp_delete_tenant_by_unameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_txtcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_txtdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txtdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_txttyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_txttyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tmtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tmtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tscol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tscol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tsdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tsdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tstyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tstyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tlddef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tlddef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tlddef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tkncol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkncol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tkndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkndef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tkntyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tkntyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tdomdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tdomdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tdomdef_by_tldidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tdomdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_tprjdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_tprjdef_by_tenantidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tprjdef_by_domainidx.tsql >>%logfilename%
%cmddb% <crsp_delete_tprjdef_by_nameidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint16col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_u16def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u16def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint16typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint16typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint32col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_u32def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u32def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint32typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint32typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint64col_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64col_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_u64def_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_u64def_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uint64typ_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uint64typ_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_urlproto_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_urlproto_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_urlproto_by_issecureidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uuidcol_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidcol_by_tableidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uuiddef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuiddef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_idguuid_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_schemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_idguuid_by_dispidx.tsql >>%logfilename%

%cmddb% <crsp_delete_uuidtyp_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_contnextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_uuidtyp_by_schemaidx.tsql >>%logfilename%

%cmddb% <crsp_delete_valdef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_unameidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_valtentidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_scopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_defschemaidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_datascopeidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_vaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_vaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_eaccsecidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_eaccfreqidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_previdx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_nextidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_contprevidx.tsql >>%logfilename%
%cmddb% <crsp_delete_valdef_by_contnextidx.tsql >>%logfilename%

%cmddb% <crsp_delete_verndef_by_ididx.tsql >>%logfilename%
%cmddb% <crsp_delete_verndef_by_tenantidx.tsql >>%logfilename%


