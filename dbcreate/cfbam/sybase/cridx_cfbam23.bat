@ECHO OFF
REM	@(#) dbcreate/cfbam/sybase/cridx_cfbam23.bat
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
SET logfilename=cridx_cfbam23.log
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

%cmdappdb% <cridx_accfreq_xuname.isql >>%logfilename%
%cmdappdb% <cridx_accsec_xuname.isql >>%logfilename%
%cmdappdb% <cridx_auditaction_xudsc.isql >>%logfilename%
%cmdappdb% <cridx_blbcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_blbtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_boolcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_booltyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_chain_xtent.isql >>%logfilename%
%cmdappdb% <cridx_chain_xtbl.isql >>%logfilename%
%cmdappdb% <cridx_chain_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_chain_xuname.isql >>%logfilename%
%cmdappdb% <cridx_chain_xprevrel.isql >>%logfilename%
%cmdappdb% <cridx_chain_xnextrel.isql >>%logfilename%
%cmdappdb% <cridx_clrdep_xrel.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep1_xcdeltopdep.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep1_uname.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep2_xcdeldep1.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep2_uname.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep3_xcdeldep2.isql >>%logfilename%
%cmdappdb% <cridx_clrsubdep3_uname.isql >>%logfilename%
%cmdappdb% <cridx_clrtop_xctbl.isql >>%logfilename%
%cmdappdb% <cridx_clrtopdep_uname.isql >>%logfilename%
%cmdappdb% <cridx_cluster_xufdname.isql >>%logfilename%
%cmdappdb% <cridx_cluster_xudescr.isql >>%logfilename%
%cmdappdb% <cridx_datascope_xuname.isql >>%logfilename%
%cmdappdb% <cridx_dtcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_dttyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_deldep_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_deldep_xrel.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep1_xcdeltopdep.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep1_uname.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep2_xcdeldep1.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep2_uname.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep3_xcdeldep2.isql >>%logfilename%
%cmdappdb% <cridx_delsubdep3_uname.isql >>%logfilename%
%cmdappdb% <cridx_deltop_xctbl.isql >>%logfilename%
%cmdappdb% <cridx_deltop_uname.isql >>%logfilename%
%cmdappdb% <cridx_domdef_subdomidx.isql >>%logfilename%
%cmdappdb% <cridx_domdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_bdomdef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_dblcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_dbltyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_enumcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_xtenant.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_xenum.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_uenumnm.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_xprev.isql >>%logfilename%
%cmdappdb% <cridx_enumtag_xnext.isql >>%logfilename%
%cmdappdb% <cridx_enumtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_fltcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_flttyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_hostnode_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_hostnode_xudsc.isql >>%logfilename%
%cmdappdb% <cridx_hostnode_xhnm.isql >>%logfilename%
%cmdappdb% <cridx_isocountry_xcode.isql >>%logfilename%
%cmdappdb% <cridx_isocountry_xuname.isql >>%logfilename%
%cmdappdb% <cridx_isocountryccy_xcountry.isql >>%logfilename%
%cmdappdb% <cridx_isocountryccy_xccy.isql >>%logfilename%
%cmdappdb% <cridx_isocountrylang_xcountry.isql >>%logfilename%
%cmdappdb% <cridx_isocountrylang_xlang.isql >>%logfilename%
%cmdappdb% <cridx_isocurrency_xcode.isql >>%logfilename%
%cmdappdb% <cridx_isocurrency_xuname.isql >>%logfilename%
%cmdappdb% <cridx_isolang_xbase.isql >>%logfilename%
%cmdappdb% <cridx_isolang_xcntry.isql >>%logfilename%
%cmdappdb% <cridx_isolang_xcode.isql >>%logfilename%
%cmdappdb% <cridx_itz_xoffset.isql >>%logfilename%
%cmdappdb% <cridx_itz_xuname.isql >>%logfilename%
%cmdappdb% <cridx_itz_xiso.isql >>%logfilename%
%cmdappdb% <cridx_idg16_dpk_def.isql >>%logfilename%
%cmdappdb% <cridx_idg32_dpk_def.isql >>%logfilename%
%cmdappdb% <cridx_idg64_dpk_def.isql >>%logfilename%
%cmdappdb% <cridx_idxdef_xuname.isql >>%logfilename%
%cmdappdb% <cridx_idxdef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_idxdef_tableidx.isql >>%logfilename%
%cmdappdb% <cridx_index_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_xuname.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_indexidx.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_col_def.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_xprev.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_xnext.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_xidxprev.isql >>%logfilename%
%cmdappdb% <cridx_idxcol_xidxnext.isql >>%logfilename%
%cmdappdb% <cridx_int16col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_int16typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_int32col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_int32typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_int64col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_int64typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_lic_xtenant.isql >>%logfilename%
%cmdappdb% <cridx_lic_xdom.isql >>%logfilename%
%cmdappdb% <cridx_lic_xuname.isql >>%logfilename%
%cmdappdb% <cridx_loadbehav_xuname.isql >>%logfilename%
%cmdappdb% <cridx_mjverdef_pprjidx.isql >>%logfilename%
%cmdappdb% <cridx_mjverdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_mimetype_xuname.isql >>%logfilename%
%cmdappdb% <cridx_mnverdef_majoridx.isql >>%logfilename%
%cmdappdb% <cridx_mnverdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_nmtkncol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_nmtkntyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_nmtknscol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_nmtknstyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_numcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_numtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_xuname.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_srvmethk.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_typek.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_xprev.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_xnext.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_xcontprev.isql >>%logfilename%
%cmdappdb% <cridx_srvprm_xcontnext.isql >>%logfilename%
%cmdappdb% <cridx_popdep_xrel.isql >>%logfilename%
%cmdappdb% <cridx_popdep_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep1_xcpoptopdep.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep1_uname.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep2_xcpopdep1.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep2_uname.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep3_xcpopdep2.isql >>%logfilename%
%cmdappdb% <cridx_popsubdep3_uname.isql >>%logfilename%
%cmdappdb% <cridx_poptop_xcrel.isql >>%logfilename%
%cmdappdb% <cridx_poptop_uname.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xuname.isql >>%logfilename%
%cmdappdb% <cridx_reldef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_reldef_tableidx.isql >>%logfilename%
%cmdappdb% <cridx_reldef_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xrtypekey.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xfromkey.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xtotbl.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xtokey.isql >>%logfilename%
%cmdappdb% <cridx_reldef_xnarrowed.isql >>%logfilename%
%cmdappdb% <cridx_relcol_xuname.isql >>%logfilename%
%cmdappdb% <cridx_relcol_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_relcol_relk.isql >>%logfilename%
%cmdappdb% <cridx_relcol_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_relcol_fromk.isql >>%logfilename%
%cmdappdb% <cridx_relcol_tok.isql >>%logfilename%
%cmdappdb% <cridx_relcol_xprev.isql >>%logfilename%
%cmdappdb% <cridx_relcol_xnext.isql >>%logfilename%
%cmdappdb% <cridx_relcol_xrelprev.isql >>%logfilename%
%cmdappdb% <cridx_relcol_xrelnext.isql >>%logfilename%
%cmdappdb% <cridx_rel_type_utagidx.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_ctenantidx.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_domainidx.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xuname.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xdeflcn.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xdatascope.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xviewaccsec.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xviewaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xeditaccsec.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xeditaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_schemadef_xupuburi.isql >>%logfilename%
%cmdappdb% <cridx_schemaref_schk.isql >>%logfilename%
%cmdappdb% <cridx_schemaref_uname.isql >>%logfilename%
%cmdappdb% <cridx_schemaref_rsck.isql >>%logfilename%
%cmdappdb% <cridx_scopedef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_secapp_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secapp_xujeemnt.isql >>%logfilename%
%cmdappdb% <cridx_secdev_usridx.isql >>%logfilename%
%cmdappdb% <cridx_secform_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secform_xsecapp.isql >>%logfilename%
%cmdappdb% <cridx_secform_xujeesvlt.isql >>%logfilename%
%cmdappdb% <cridx_secgroup_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secgroup_xuname.isql >>%logfilename%
%cmdappdb% <cridx_secgroupform_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secgroupform_xgroup.isql >>%logfilename%
%cmdappdb% <cridx_secgroupform_xapp.isql >>%logfilename%
%cmdappdb% <cridx_secgroupform_xform.isql >>%logfilename%
%cmdappdb% <cridx_secgroupform_xuform.isql >>%logfilename%
%cmdappdb% <cridx_secinclude_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secinclude_xgroup.isql >>%logfilename%
%cmdappdb% <cridx_secinclude_xinc.isql >>%logfilename%
%cmdappdb% <cridx_secinclude_xuinc.isql >>%logfilename%
%cmdappdb% <cridx_secmember_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_secmember_xgroup.isql >>%logfilename%
%cmdappdb% <cridx_secmember_xuser.isql >>%logfilename%
%cmdappdb% <cridx_secmember_xuuser.isql >>%logfilename%
%cmdappdb% <cridx_session_xsecuser.isql >>%logfilename%
%cmdappdb% <cridx_session_xsecdev.isql >>%logfilename%
%cmdappdb% <cridx_session_xstart.isql >>%logfilename%
%cmdappdb% <cridx_session_xfnsh.isql >>%logfilename%
%cmdappdb% <cridx_session_xproxy.isql >>%logfilename%
%cmdappdb% <cridx_secuser_xulogin.isql >>%logfilename%
%cmdappdb% <cridx_secuser_xemconf.isql >>%logfilename%
%cmdappdb% <cridx_secuser_xpwdrst.isql >>%logfilename%
%cmdappdb% <cridx_secuser_defdevidx.isql >>%logfilename%
%cmdappdb% <cridx_secscope_xuname.isql >>%logfilename%
%cmdappdb% <cridx_srvlfunc_rettblk.isql >>%logfilename%
%cmdappdb% <cridx_srvmeth_xuname.isql >>%logfilename%
%cmdappdb% <cridx_srvmeth_tableidx.isql >>%logfilename%
%cmdappdb% <cridx_srvmeth_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_srvofunc_rettblk.isql >>%logfilename%
%cmdappdb% <cridx_service_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_service_xhost.isql >>%logfilename%
%cmdappdb% <cridx_service_xtype.isql >>%logfilename%
%cmdappdb% <cridx_service_xutype.isql >>%logfilename%
%cmdappdb% <cridx_service_xuhpt.isql >>%logfilename%
%cmdappdb% <cridx_servicetype_xudsc.isql >>%logfilename%
%cmdappdb% <cridx_strcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_strtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_sprjdef_pprjidx.isql >>%logfilename%
%cmdappdb% <cridx_sprjdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_sysclus_xclus.isql >>%logfilename%
%cmdappdb% <cridx_tsecgroup_xtenant.isql >>%logfilename%
%cmdappdb% <cridx_tsecgroup_xuname.isql >>%logfilename%
%cmdappdb% <cridx_tsecinclude_xtenant.isql >>%logfilename%
%cmdappdb% <cridx_tsecinclude_xgroup.isql >>%logfilename%
%cmdappdb% <cridx_tsecinclude_xinc.isql >>%logfilename%
%cmdappdb% <cridx_tsecinclude_xuinc.isql >>%logfilename%
%cmdappdb% <cridx_tsecmember_xtenant.isql >>%logfilename%
%cmdappdb% <cridx_tsecmember_xgroup.isql >>%logfilename%
%cmdappdb% <cridx_tsecmember_xuser.isql >>%logfilename%
%cmdappdb% <cridx_tsecmember_xuuser.isql >>%logfilename%
%cmdappdb% <cridx_dzcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_dztyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tmzcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_tmztyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_zscol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_zstyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tbldef_schemaidx.isql >>%logfilename%
%cmdappdb% <cridx_tbldef_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_table_xuname.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xscd.isql >>%logfilename%
%cmdappdb% <cridx_def_tbl_xpidx.isql >>%logfilename%
%cmdappdb% <cridx_def_tbl_xlookupidx.isql >>%logfilename%
%cmdappdb% <cridx_def_tbl_xaltidx.isql >>%logfilename%
%cmdappdb% <cridx_def_tbl_xqtblidx.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xloadbehave.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xdatascope.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xsecscope.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xviewaccsec.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xviewaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xeditaccsec.isql >>%logfilename%
%cmdappdb% <cridx_tabledef_xeditaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_tblcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_tablecol_xdata.isql >>%logfilename%
%cmdappdb% <cridx_tenant_xcluster.isql >>%logfilename%
%cmdappdb% <cridx_tenant_xuname.isql >>%logfilename%
%cmdappdb% <cridx_txtcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_txttyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tmcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_tmtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tscol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_tstyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tlddef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_tlddef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_tkncol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_tkntyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_tdomdef_tldidx.isql >>%logfilename%
%cmdappdb% <cridx_tdomdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_tprjdef_domidx.isql >>%logfilename%
%cmdappdb% <cridx_tprjdef_unameidx.isql >>%logfilename%
%cmdappdb% <cridx_uint16col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_uint16typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_uint32col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_uint32typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_uint64col_xtable.isql >>%logfilename%
%cmdappdb% <cridx_uint64typ_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_urlproto_xuname.isql >>%logfilename%
%cmdappdb% <cridx_urlproto_xsecure.isql >>%logfilename%
%cmdappdb% <cridx_uuidcol_xtable.isql >>%logfilename%
%cmdappdb% <cridx_idguuid_dpk_def.isql >>%logfilename%
%cmdappdb% <cridx_uuidtyp_xschemadef.isql >>%logfilename%
%cmdappdb% <cridx_valdef_xuname.isql >>%logfilename%
%cmdappdb% <cridx_valdef_tenantidx.isql >>%logfilename%
%cmdappdb% <cridx_valdef_scopeidx.isql >>%logfilename%
%cmdappdb% <cridx_value_defschidx.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xdatascope.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xviewaccsec.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xviewaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xeditaccsec.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xeditaccfreq.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xprev.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xnext.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xcontprev.isql >>%logfilename%
%cmdappdb% <cridx_valuedef_xcontnext.isql >>%logfilename%

