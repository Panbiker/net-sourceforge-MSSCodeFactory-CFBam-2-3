@ECHO OFF
REM	@(#) dbcreate/cfbam/mssql/cridx_cfbam23.bat
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
SET logfilename=cridx_cfbam23.log

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

%cmddb% <cridx_accfreq_xuname.tsql >>%logfilename%
%cmddb% <cridx_accsec_xuname.tsql >>%logfilename%
%cmddb% <cridx_auditaction_xudsc.tsql >>%logfilename%
%cmddb% <cridx_blbcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_blbtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_boolcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_booltyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_chain_xtent.tsql >>%logfilename%
%cmddb% <cridx_chain_xtbl.tsql >>%logfilename%
%cmddb% <cridx_chain_defschidx.tsql >>%logfilename%
%cmddb% <cridx_chain_xuname.tsql >>%logfilename%
%cmddb% <cridx_chain_xprevrel.tsql >>%logfilename%
%cmddb% <cridx_chain_xnextrel.tsql >>%logfilename%
%cmddb% <cridx_clrdep_xrel.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep1_xcdeltopdep.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep1_uname.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep2_xcdeldep1.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep2_uname.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep3_xcdeldep2.tsql >>%logfilename%
%cmddb% <cridx_clrsubdep3_uname.tsql >>%logfilename%
%cmddb% <cridx_clrtop_xctbl.tsql >>%logfilename%
%cmddb% <cridx_clrtopdep_uname.tsql >>%logfilename%
%cmddb% <cridx_cluster_xufdname.tsql >>%logfilename%
%cmddb% <cridx_cluster_xudescr.tsql >>%logfilename%
%cmddb% <cridx_datascope_xuname.tsql >>%logfilename%
%cmddb% <cridx_dtcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_dttyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_deldep_defschidx.tsql >>%logfilename%
%cmddb% <cridx_deldep_xrel.tsql >>%logfilename%
%cmddb% <cridx_delsubdep1_xcdeltopdep.tsql >>%logfilename%
%cmddb% <cridx_delsubdep1_uname.tsql >>%logfilename%
%cmddb% <cridx_delsubdep2_xcdeldep1.tsql >>%logfilename%
%cmddb% <cridx_delsubdep2_uname.tsql >>%logfilename%
%cmddb% <cridx_delsubdep3_xcdeldep2.tsql >>%logfilename%
%cmddb% <cridx_delsubdep3_uname.tsql >>%logfilename%
%cmddb% <cridx_deltop_xctbl.tsql >>%logfilename%
%cmddb% <cridx_deltop_uname.tsql >>%logfilename%
%cmddb% <cridx_domdef_subdomidx.tsql >>%logfilename%
%cmddb% <cridx_domdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_bdomdef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_dblcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_dbltyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_enumcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_enumtag_xtenant.tsql >>%logfilename%
%cmddb% <cridx_enumtag_xenum.tsql >>%logfilename%
%cmddb% <cridx_enumtag_defschidx.tsql >>%logfilename%
%cmddb% <cridx_enumtag_uenumnm.tsql >>%logfilename%
%cmddb% <cridx_enumtag_xprev.tsql >>%logfilename%
%cmddb% <cridx_enumtag_xnext.tsql >>%logfilename%
%cmddb% <cridx_enumtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_fltcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_flttyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_hostnode_xcluster.tsql >>%logfilename%
%cmddb% <cridx_hostnode_xudsc.tsql >>%logfilename%
%cmddb% <cridx_hostnode_xhnm.tsql >>%logfilename%
%cmddb% <cridx_isocountry_xcode.tsql >>%logfilename%
%cmddb% <cridx_isocountry_xuname.tsql >>%logfilename%
%cmddb% <cridx_isocountryccy_xcountry.tsql >>%logfilename%
%cmddb% <cridx_isocountryccy_xccy.tsql >>%logfilename%
%cmddb% <cridx_isocountrylang_xcountry.tsql >>%logfilename%
%cmddb% <cridx_isocountrylang_xlang.tsql >>%logfilename%
%cmddb% <cridx_isocurrency_xcode.tsql >>%logfilename%
%cmddb% <cridx_isocurrency_xuname.tsql >>%logfilename%
%cmddb% <cridx_isolang_xbase.tsql >>%logfilename%
%cmddb% <cridx_isolang_xcntry.tsql >>%logfilename%
%cmddb% <cridx_isolang_xcode.tsql >>%logfilename%
%cmddb% <cridx_itz_xoffset.tsql >>%logfilename%
%cmddb% <cridx_itz_xuname.tsql >>%logfilename%
%cmddb% <cridx_itz_xiso.tsql >>%logfilename%
%cmddb% <cridx_idg16_dpk_def.tsql >>%logfilename%
%cmddb% <cridx_idg32_dpk_def.tsql >>%logfilename%
%cmddb% <cridx_idg64_dpk_def.tsql >>%logfilename%
%cmddb% <cridx_idxdef_xuname.tsql >>%logfilename%
%cmddb% <cridx_idxdef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_idxdef_tableidx.tsql >>%logfilename%
%cmddb% <cridx_index_defschidx.tsql >>%logfilename%
%cmddb% <cridx_idxcol_xuname.tsql >>%logfilename%
%cmddb% <cridx_idxcol_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_idxcol_indexidx.tsql >>%logfilename%
%cmddb% <cridx_idxcol_defschidx.tsql >>%logfilename%
%cmddb% <cridx_idxcol_col_def.tsql >>%logfilename%
%cmddb% <cridx_idxcol_xprev.tsql >>%logfilename%
%cmddb% <cridx_idxcol_xnext.tsql >>%logfilename%
%cmddb% <cridx_idxcol_xidxprev.tsql >>%logfilename%
%cmddb% <cridx_idxcol_xidxnext.tsql >>%logfilename%
%cmddb% <cridx_int16col_xtable.tsql >>%logfilename%
%cmddb% <cridx_int16typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_int32col_xtable.tsql >>%logfilename%
%cmddb% <cridx_int32typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_int64col_xtable.tsql >>%logfilename%
%cmddb% <cridx_int64typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_lic_xtenant.tsql >>%logfilename%
%cmddb% <cridx_lic_xdom.tsql >>%logfilename%
%cmddb% <cridx_lic_xuname.tsql >>%logfilename%
%cmddb% <cridx_loadbehav_xuname.tsql >>%logfilename%
%cmddb% <cridx_mjverdef_pprjidx.tsql >>%logfilename%
%cmddb% <cridx_mjverdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_mimetype_xuname.tsql >>%logfilename%
%cmddb% <cridx_mnverdef_majoridx.tsql >>%logfilename%
%cmddb% <cridx_mnverdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_nmtkncol_xtable.tsql >>%logfilename%
%cmddb% <cridx_nmtkntyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_nmtknscol_xtable.tsql >>%logfilename%
%cmddb% <cridx_nmtknstyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_numcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_numtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_srvprm_xuname.tsql >>%logfilename%
%cmddb% <cridx_srvprm_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_srvprm_srvmethk.tsql >>%logfilename%
%cmddb% <cridx_srvprm_defschidx.tsql >>%logfilename%
%cmddb% <cridx_srvprm_typek.tsql >>%logfilename%
%cmddb% <cridx_srvprm_xprev.tsql >>%logfilename%
%cmddb% <cridx_srvprm_xnext.tsql >>%logfilename%
%cmddb% <cridx_srvprm_xcontprev.tsql >>%logfilename%
%cmddb% <cridx_srvprm_xcontnext.tsql >>%logfilename%
%cmddb% <cridx_popdep_xrel.tsql >>%logfilename%
%cmddb% <cridx_popdep_defschidx.tsql >>%logfilename%
%cmddb% <cridx_popsubdep1_xcpoptopdep.tsql >>%logfilename%
%cmddb% <cridx_popsubdep1_uname.tsql >>%logfilename%
%cmddb% <cridx_popsubdep2_xcpopdep1.tsql >>%logfilename%
%cmddb% <cridx_popsubdep2_uname.tsql >>%logfilename%
%cmddb% <cridx_popsubdep3_xcpopdep2.tsql >>%logfilename%
%cmddb% <cridx_popsubdep3_uname.tsql >>%logfilename%
%cmddb% <cridx_poptop_xcrel.tsql >>%logfilename%
%cmddb% <cridx_poptop_uname.tsql >>%logfilename%
%cmddb% <cridx_reldef_xuname.tsql >>%logfilename%
%cmddb% <cridx_reldef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_reldef_tableidx.tsql >>%logfilename%
%cmddb% <cridx_reldef_defschidx.tsql >>%logfilename%
%cmddb% <cridx_reldef_xrtypekey.tsql >>%logfilename%
%cmddb% <cridx_reldef_xfromkey.tsql >>%logfilename%
%cmddb% <cridx_reldef_xtotbl.tsql >>%logfilename%
%cmddb% <cridx_reldef_xtokey.tsql >>%logfilename%
%cmddb% <cridx_reldef_xnarrowed.tsql >>%logfilename%
%cmddb% <cridx_relcol_xuname.tsql >>%logfilename%
%cmddb% <cridx_relcol_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_relcol_relk.tsql >>%logfilename%
%cmddb% <cridx_relcol_defschidx.tsql >>%logfilename%
%cmddb% <cridx_relcol_fromk.tsql >>%logfilename%
%cmddb% <cridx_relcol_tok.tsql >>%logfilename%
%cmddb% <cridx_relcol_xprev.tsql >>%logfilename%
%cmddb% <cridx_relcol_xnext.tsql >>%logfilename%
%cmddb% <cridx_relcol_xrelprev.tsql >>%logfilename%
%cmddb% <cridx_relcol_xrelnext.tsql >>%logfilename%
%cmddb% <cridx_rel_type_utagidx.tsql >>%logfilename%
%cmddb% <cridx_schemadef_ctenantidx.tsql >>%logfilename%
%cmddb% <cridx_schemadef_domainidx.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xuname.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xdeflcn.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xdatascope.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xviewaccsec.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xviewaccfreq.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xeditaccsec.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xeditaccfreq.tsql >>%logfilename%
%cmddb% <cridx_schemadef_xupuburi.tsql >>%logfilename%
%cmddb% <cridx_schemaref_schk.tsql >>%logfilename%
%cmddb% <cridx_schemaref_uname.tsql >>%logfilename%
%cmddb% <cridx_schemaref_rsck.tsql >>%logfilename%
%cmddb% <cridx_scopedef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_secapp_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secapp_xujeemnt.tsql >>%logfilename%
%cmddb% <cridx_secdev_usridx.tsql >>%logfilename%
%cmddb% <cridx_secform_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secform_xsecapp.tsql >>%logfilename%
%cmddb% <cridx_secform_xujeesvlt.tsql >>%logfilename%
%cmddb% <cridx_secgroup_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secgroup_xuname.tsql >>%logfilename%
%cmddb% <cridx_secgroupform_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secgroupform_xgroup.tsql >>%logfilename%
%cmddb% <cridx_secgroupform_xapp.tsql >>%logfilename%
%cmddb% <cridx_secgroupform_xform.tsql >>%logfilename%
%cmddb% <cridx_secgroupform_xuform.tsql >>%logfilename%
%cmddb% <cridx_secinclude_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secinclude_xgroup.tsql >>%logfilename%
%cmddb% <cridx_secinclude_xinc.tsql >>%logfilename%
%cmddb% <cridx_secinclude_xuinc.tsql >>%logfilename%
%cmddb% <cridx_secmember_xcluster.tsql >>%logfilename%
%cmddb% <cridx_secmember_xgroup.tsql >>%logfilename%
%cmddb% <cridx_secmember_xuser.tsql >>%logfilename%
%cmddb% <cridx_secmember_xuuser.tsql >>%logfilename%
%cmddb% <cridx_session_xsecuser.tsql >>%logfilename%
%cmddb% <cridx_session_xsecdev.tsql >>%logfilename%
%cmddb% <cridx_session_xstart.tsql >>%logfilename%
%cmddb% <cridx_session_xfnsh.tsql >>%logfilename%
%cmddb% <cridx_session_xproxy.tsql >>%logfilename%
%cmddb% <cridx_secuser_xulogin.tsql >>%logfilename%
%cmddb% <cridx_secuser_xemconf.tsql >>%logfilename%
%cmddb% <cridx_secuser_xpwdrst.tsql >>%logfilename%
%cmddb% <cridx_secuser_defdevidx.tsql >>%logfilename%
%cmddb% <cridx_secscope_xuname.tsql >>%logfilename%
%cmddb% <cridx_srvlfunc_rettblk.tsql >>%logfilename%
%cmddb% <cridx_srvmeth_xuname.tsql >>%logfilename%
%cmddb% <cridx_srvmeth_tableidx.tsql >>%logfilename%
%cmddb% <cridx_srvmeth_defschidx.tsql >>%logfilename%
%cmddb% <cridx_srvofunc_rettblk.tsql >>%logfilename%
%cmddb% <cridx_service_xcluster.tsql >>%logfilename%
%cmddb% <cridx_service_xhost.tsql >>%logfilename%
%cmddb% <cridx_service_xtype.tsql >>%logfilename%
%cmddb% <cridx_service_xutype.tsql >>%logfilename%
%cmddb% <cridx_service_xuhpt.tsql >>%logfilename%
%cmddb% <cridx_servicetype_xudsc.tsql >>%logfilename%
%cmddb% <cridx_strcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_strtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_sprjdef_pprjidx.tsql >>%logfilename%
%cmddb% <cridx_sprjdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_sysclus_xclus.tsql >>%logfilename%
%cmddb% <cridx_tsecgroup_xtenant.tsql >>%logfilename%
%cmddb% <cridx_tsecgroup_xuname.tsql >>%logfilename%
%cmddb% <cridx_tsecinclude_xtenant.tsql >>%logfilename%
%cmddb% <cridx_tsecinclude_xgroup.tsql >>%logfilename%
%cmddb% <cridx_tsecinclude_xinc.tsql >>%logfilename%
%cmddb% <cridx_tsecinclude_xuinc.tsql >>%logfilename%
%cmddb% <cridx_tsecmember_xtenant.tsql >>%logfilename%
%cmddb% <cridx_tsecmember_xgroup.tsql >>%logfilename%
%cmddb% <cridx_tsecmember_xuser.tsql >>%logfilename%
%cmddb% <cridx_tsecmember_xuuser.tsql >>%logfilename%
%cmddb% <cridx_dzcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_dztyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tmzcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_tmztyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_zscol_xtable.tsql >>%logfilename%
%cmddb% <cridx_zstyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tbldef_schemaidx.tsql >>%logfilename%
%cmddb% <cridx_tbldef_defschidx.tsql >>%logfilename%
%cmddb% <cridx_table_xuname.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xscd.tsql >>%logfilename%
%cmddb% <cridx_def_tbl_xpidx.tsql >>%logfilename%
%cmddb% <cridx_def_tbl_xlookupidx.tsql >>%logfilename%
%cmddb% <cridx_def_tbl_xaltidx.tsql >>%logfilename%
%cmddb% <cridx_def_tbl_xqtblidx.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xloadbehave.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xdatascope.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xsecscope.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xviewaccsec.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xviewaccfreq.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xeditaccsec.tsql >>%logfilename%
%cmddb% <cridx_tabledef_xeditaccfreq.tsql >>%logfilename%
%cmddb% <cridx_tblcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_tablecol_xdata.tsql >>%logfilename%
%cmddb% <cridx_tenant_xcluster.tsql >>%logfilename%
%cmddb% <cridx_tenant_xuname.tsql >>%logfilename%
%cmddb% <cridx_txtcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_txttyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tmcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_tmtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tscol_xtable.tsql >>%logfilename%
%cmddb% <cridx_tstyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tlddef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_tlddef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_tkncol_xtable.tsql >>%logfilename%
%cmddb% <cridx_tkntyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_tdomdef_tldidx.tsql >>%logfilename%
%cmddb% <cridx_tdomdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_tprjdef_domidx.tsql >>%logfilename%
%cmddb% <cridx_tprjdef_unameidx.tsql >>%logfilename%
%cmddb% <cridx_uint16col_xtable.tsql >>%logfilename%
%cmddb% <cridx_uint16typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_uint32col_xtable.tsql >>%logfilename%
%cmddb% <cridx_uint32typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_uint64col_xtable.tsql >>%logfilename%
%cmddb% <cridx_uint64typ_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_urlproto_xuname.tsql >>%logfilename%
%cmddb% <cridx_urlproto_xsecure.tsql >>%logfilename%
%cmddb% <cridx_uuidcol_xtable.tsql >>%logfilename%
%cmddb% <cridx_idguuid_dpk_def.tsql >>%logfilename%
%cmddb% <cridx_uuidtyp_xschemadef.tsql >>%logfilename%
%cmddb% <cridx_valdef_xuname.tsql >>%logfilename%
%cmddb% <cridx_valdef_tenantidx.tsql >>%logfilename%
%cmddb% <cridx_valdef_scopeidx.tsql >>%logfilename%
%cmddb% <cridx_value_defschidx.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xdatascope.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xviewaccsec.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xviewaccfreq.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xeditaccsec.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xeditaccfreq.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xprev.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xnext.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xcontprev.tsql >>%logfilename%
%cmddb% <cridx_valuedef_xcontnext.tsql >>%logfilename%

