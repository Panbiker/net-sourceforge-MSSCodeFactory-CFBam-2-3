@echo off
REM
REM	@(#) dbcreate/cfbam/mysql/cridx_cfbam23.bat
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
SET logfilename=cridx_cfbam23.log
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

echo cridx_accfreq_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_accfreq_xuname.mysql >>%logfilename% 2>&1
echo cridx_accsec_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_accsec_xuname.mysql >>%logfilename% 2>&1
echo cridx_auditaction_xudsc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_auditaction_xudsc.mysql >>%logfilename% 2>&1
echo cridx_blbcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_blbcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_blbtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_blbtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_boolcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_boolcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_booltyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_booltyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_chain_xtent.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_xtent.mysql >>%logfilename% 2>&1
echo cridx_chain_xtbl.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_xtbl.mysql >>%logfilename% 2>&1
echo cridx_chain_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_defschidx.mysql >>%logfilename% 2>&1
echo cridx_chain_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_xuname.mysql >>%logfilename% 2>&1
echo cridx_chain_xprevrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_xprevrel.mysql >>%logfilename% 2>&1
echo cridx_chain_xnextrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_chain_xnextrel.mysql >>%logfilename% 2>&1
echo cridx_clrdep_xrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrdep_xrel.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep1_xcdeltopdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep1_xcdeltopdep.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep1_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep1_uname.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep2_xcdeldep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep2_xcdeldep1.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep2_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep2_uname.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep3_xcdeldep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep3_xcdeldep2.mysql >>%logfilename% 2>&1
echo cridx_clrsubdep3_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrsubdep3_uname.mysql >>%logfilename% 2>&1
echo cridx_clrtop_xctbl.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrtop_xctbl.mysql >>%logfilename% 2>&1
echo cridx_clrtopdep_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_clrtopdep_uname.mysql >>%logfilename% 2>&1
echo cridx_cluster_xufdname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_cluster_xufdname.mysql >>%logfilename% 2>&1
echo cridx_cluster_xudescr.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_cluster_xudescr.mysql >>%logfilename% 2>&1
echo cridx_datascope_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_datascope_xuname.mysql >>%logfilename% 2>&1
echo cridx_dtcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dtcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_dttyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dttyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_deldep_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_deldep_defschidx.mysql >>%logfilename% 2>&1
echo cridx_deldep_xrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_deldep_xrel.mysql >>%logfilename% 2>&1
echo cridx_delsubdep1_xcdeltopdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep1_xcdeltopdep.mysql >>%logfilename% 2>&1
echo cridx_delsubdep1_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep1_uname.mysql >>%logfilename% 2>&1
echo cridx_delsubdep2_xcdeldep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep2_xcdeldep1.mysql >>%logfilename% 2>&1
echo cridx_delsubdep2_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep2_uname.mysql >>%logfilename% 2>&1
echo cridx_delsubdep3_xcdeldep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep3_xcdeldep2.mysql >>%logfilename% 2>&1
echo cridx_delsubdep3_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_delsubdep3_uname.mysql >>%logfilename% 2>&1
echo cridx_deltop_xctbl.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_deltop_xctbl.mysql >>%logfilename% 2>&1
echo cridx_deltop_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_deltop_uname.mysql >>%logfilename% 2>&1
echo cridx_domdef_subdomidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_domdef_subdomidx.mysql >>%logfilename% 2>&1
echo cridx_domdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_domdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_bdomdef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_bdomdef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_dblcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dblcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_dbltyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dbltyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_enumcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_enumtag_xtenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_xtenant.mysql >>%logfilename% 2>&1
echo cridx_enumtag_xenum.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_xenum.mysql >>%logfilename% 2>&1
echo cridx_enumtag_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_defschidx.mysql >>%logfilename% 2>&1
echo cridx_enumtag_uenumnm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_uenumnm.mysql >>%logfilename% 2>&1
echo cridx_enumtag_xprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_xprev.mysql >>%logfilename% 2>&1
echo cridx_enumtag_xnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtag_xnext.mysql >>%logfilename% 2>&1
echo cridx_enumtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_enumtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_fltcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_fltcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_flttyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_flttyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_hostnode_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_hostnode_xcluster.mysql >>%logfilename% 2>&1
echo cridx_hostnode_xudsc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_hostnode_xudsc.mysql >>%logfilename% 2>&1
echo cridx_hostnode_xhnm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_hostnode_xhnm.mysql >>%logfilename% 2>&1
echo cridx_isocountry_xcode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountry_xcode.mysql >>%logfilename% 2>&1
echo cridx_isocountry_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountry_xuname.mysql >>%logfilename% 2>&1
echo cridx_isocountryccy_xcountry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountryccy_xcountry.mysql >>%logfilename% 2>&1
echo cridx_isocountryccy_xccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountryccy_xccy.mysql >>%logfilename% 2>&1
echo cridx_isocountrylang_xcountry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountrylang_xcountry.mysql >>%logfilename% 2>&1
echo cridx_isocountrylang_xlang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocountrylang_xlang.mysql >>%logfilename% 2>&1
echo cridx_isocurrency_xcode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocurrency_xcode.mysql >>%logfilename% 2>&1
echo cridx_isocurrency_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isocurrency_xuname.mysql >>%logfilename% 2>&1
echo cridx_isolang_xbase.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isolang_xbase.mysql >>%logfilename% 2>&1
echo cridx_isolang_xcntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isolang_xcntry.mysql >>%logfilename% 2>&1
echo cridx_isolang_xcode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_isolang_xcode.mysql >>%logfilename% 2>&1
echo cridx_itz_xoffset.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_itz_xoffset.mysql >>%logfilename% 2>&1
echo cridx_itz_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_itz_xuname.mysql >>%logfilename% 2>&1
echo cridx_itz_xiso.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_itz_xiso.mysql >>%logfilename% 2>&1
echo cridx_idg16_dpk_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idg16_dpk_def.mysql >>%logfilename% 2>&1
echo cridx_idg32_dpk_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idg32_dpk_def.mysql >>%logfilename% 2>&1
echo cridx_idg64_dpk_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idg64_dpk_def.mysql >>%logfilename% 2>&1
echo cridx_idxdef_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxdef_xuname.mysql >>%logfilename% 2>&1
echo cridx_idxdef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxdef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_idxdef_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxdef_tableidx.mysql >>%logfilename% 2>&1
echo cridx_index_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_index_defschidx.mysql >>%logfilename% 2>&1
echo cridx_idxcol_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_xuname.mysql >>%logfilename% 2>&1
echo cridx_idxcol_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_idxcol_indexidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_indexidx.mysql >>%logfilename% 2>&1
echo cridx_idxcol_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_defschidx.mysql >>%logfilename% 2>&1
echo cridx_idxcol_col_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_col_def.mysql >>%logfilename% 2>&1
echo cridx_idxcol_xprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_xprev.mysql >>%logfilename% 2>&1
echo cridx_idxcol_xnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_xnext.mysql >>%logfilename% 2>&1
echo cridx_idxcol_xidxprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_xidxprev.mysql >>%logfilename% 2>&1
echo cridx_idxcol_xidxnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idxcol_xidxnext.mysql >>%logfilename% 2>&1
echo cridx_int16col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int16col_xtable.mysql >>%logfilename% 2>&1
echo cridx_int16typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int16typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_int32col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int32col_xtable.mysql >>%logfilename% 2>&1
echo cridx_int32typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int32typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_int64col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int64col_xtable.mysql >>%logfilename% 2>&1
echo cridx_int64typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_int64typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_lic_xtenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_lic_xtenant.mysql >>%logfilename% 2>&1
echo cridx_lic_xdom.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_lic_xdom.mysql >>%logfilename% 2>&1
echo cridx_lic_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_lic_xuname.mysql >>%logfilename% 2>&1
echo cridx_loadbehav_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_loadbehav_xuname.mysql >>%logfilename% 2>&1
echo cridx_mjverdef_pprjidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_mjverdef_pprjidx.mysql >>%logfilename% 2>&1
echo cridx_mjverdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_mjverdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_mimetype_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_mimetype_xuname.mysql >>%logfilename% 2>&1
echo cridx_mnverdef_majoridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_mnverdef_majoridx.mysql >>%logfilename% 2>&1
echo cridx_mnverdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_mnverdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_nmtkncol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_nmtkncol_xtable.mysql >>%logfilename% 2>&1
echo cridx_nmtkntyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_nmtkntyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_nmtknscol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_nmtknscol_xtable.mysql >>%logfilename% 2>&1
echo cridx_nmtknstyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_nmtknstyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_numcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_numcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_numtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_numtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_srvprm_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_xuname.mysql >>%logfilename% 2>&1
echo cridx_srvprm_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_srvprm_srvmethk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_srvmethk.mysql >>%logfilename% 2>&1
echo cridx_srvprm_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_defschidx.mysql >>%logfilename% 2>&1
echo cridx_srvprm_typek.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_typek.mysql >>%logfilename% 2>&1
echo cridx_srvprm_xprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_xprev.mysql >>%logfilename% 2>&1
echo cridx_srvprm_xnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_xnext.mysql >>%logfilename% 2>&1
echo cridx_srvprm_xcontprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_xcontprev.mysql >>%logfilename% 2>&1
echo cridx_srvprm_xcontnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvprm_xcontnext.mysql >>%logfilename% 2>&1
echo cridx_popdep_xrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popdep_xrel.mysql >>%logfilename% 2>&1
echo cridx_popdep_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popdep_defschidx.mysql >>%logfilename% 2>&1
echo cridx_popsubdep1_xcpoptopdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep1_xcpoptopdep.mysql >>%logfilename% 2>&1
echo cridx_popsubdep1_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep1_uname.mysql >>%logfilename% 2>&1
echo cridx_popsubdep2_xcpopdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep2_xcpopdep1.mysql >>%logfilename% 2>&1
echo cridx_popsubdep2_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep2_uname.mysql >>%logfilename% 2>&1
echo cridx_popsubdep3_xcpopdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep3_xcpopdep2.mysql >>%logfilename% 2>&1
echo cridx_popsubdep3_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_popsubdep3_uname.mysql >>%logfilename% 2>&1
echo cridx_poptop_xcrel.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_poptop_xcrel.mysql >>%logfilename% 2>&1
echo cridx_poptop_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_poptop_uname.mysql >>%logfilename% 2>&1
echo cridx_reldef_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xuname.mysql >>%logfilename% 2>&1
echo cridx_reldef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_reldef_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_tableidx.mysql >>%logfilename% 2>&1
echo cridx_reldef_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_defschidx.mysql >>%logfilename% 2>&1
echo cridx_reldef_xrtypekey.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xrtypekey.mysql >>%logfilename% 2>&1
echo cridx_reldef_xfromkey.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xfromkey.mysql >>%logfilename% 2>&1
echo cridx_reldef_xtotbl.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xtotbl.mysql >>%logfilename% 2>&1
echo cridx_reldef_xtokey.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xtokey.mysql >>%logfilename% 2>&1
echo cridx_reldef_xnarrowed.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_reldef_xnarrowed.mysql >>%logfilename% 2>&1
echo cridx_relcol_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_xuname.mysql >>%logfilename% 2>&1
echo cridx_relcol_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_relcol_relk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_relk.mysql >>%logfilename% 2>&1
echo cridx_relcol_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_defschidx.mysql >>%logfilename% 2>&1
echo cridx_relcol_fromk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_fromk.mysql >>%logfilename% 2>&1
echo cridx_relcol_tok.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_tok.mysql >>%logfilename% 2>&1
echo cridx_relcol_xprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_xprev.mysql >>%logfilename% 2>&1
echo cridx_relcol_xnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_xnext.mysql >>%logfilename% 2>&1
echo cridx_relcol_xrelprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_xrelprev.mysql >>%logfilename% 2>&1
echo cridx_relcol_xrelnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_relcol_xrelnext.mysql >>%logfilename% 2>&1
echo cridx_rel_type_utagidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_rel_type_utagidx.mysql >>%logfilename% 2>&1
echo cridx_schemadef_ctenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_ctenantidx.mysql >>%logfilename% 2>&1
echo cridx_schemadef_domainidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_domainidx.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xuname.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xdeflcn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xdeflcn.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xdatascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xdatascope.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xviewaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xviewaccsec.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xviewaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xviewaccfreq.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xeditaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xeditaccsec.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xeditaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xeditaccfreq.mysql >>%logfilename% 2>&1
echo cridx_schemadef_xupuburi.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemadef_xupuburi.mysql >>%logfilename% 2>&1
echo cridx_schemaref_schk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemaref_schk.mysql >>%logfilename% 2>&1
echo cridx_schemaref_uname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemaref_uname.mysql >>%logfilename% 2>&1
echo cridx_schemaref_rsck.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_schemaref_rsck.mysql >>%logfilename% 2>&1
echo cridx_scopedef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_scopedef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_secapp_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secapp_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secapp_xujeemnt.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secapp_xujeemnt.mysql >>%logfilename% 2>&1
echo cridx_secdev_usridx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secdev_usridx.mysql >>%logfilename% 2>&1
echo cridx_secform_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secform_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secform_xsecapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secform_xsecapp.mysql >>%logfilename% 2>&1
echo cridx_secform_xujeesvlt.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secform_xujeesvlt.mysql >>%logfilename% 2>&1
echo cridx_secgroup_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroup_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secgroup_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroup_xuname.mysql >>%logfilename% 2>&1
echo cridx_secgroupform_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroupform_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secgroupform_xgroup.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroupform_xgroup.mysql >>%logfilename% 2>&1
echo cridx_secgroupform_xapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroupform_xapp.mysql >>%logfilename% 2>&1
echo cridx_secgroupform_xform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroupform_xform.mysql >>%logfilename% 2>&1
echo cridx_secgroupform_xuform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secgroupform_xuform.mysql >>%logfilename% 2>&1
echo cridx_secinclude_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secinclude_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secinclude_xgroup.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secinclude_xgroup.mysql >>%logfilename% 2>&1
echo cridx_secinclude_xinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secinclude_xinc.mysql >>%logfilename% 2>&1
echo cridx_secinclude_xuinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secinclude_xuinc.mysql >>%logfilename% 2>&1
echo cridx_secmember_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secmember_xcluster.mysql >>%logfilename% 2>&1
echo cridx_secmember_xgroup.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secmember_xgroup.mysql >>%logfilename% 2>&1
echo cridx_secmember_xuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secmember_xuser.mysql >>%logfilename% 2>&1
echo cridx_secmember_xuuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secmember_xuuser.mysql >>%logfilename% 2>&1
echo cridx_session_xsecuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_session_xsecuser.mysql >>%logfilename% 2>&1
echo cridx_session_xsecdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_session_xsecdev.mysql >>%logfilename% 2>&1
echo cridx_session_xstart.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_session_xstart.mysql >>%logfilename% 2>&1
echo cridx_session_xfnsh.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_session_xfnsh.mysql >>%logfilename% 2>&1
echo cridx_session_xproxy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_session_xproxy.mysql >>%logfilename% 2>&1
echo cridx_secuser_xulogin.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secuser_xulogin.mysql >>%logfilename% 2>&1
echo cridx_secuser_xemconf.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secuser_xemconf.mysql >>%logfilename% 2>&1
echo cridx_secuser_xpwdrst.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secuser_xpwdrst.mysql >>%logfilename% 2>&1
echo cridx_secuser_defdevidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secuser_defdevidx.mysql >>%logfilename% 2>&1
echo cridx_secscope_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_secscope_xuname.mysql >>%logfilename% 2>&1
echo cridx_srvlfunc_rettblk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvlfunc_rettblk.mysql >>%logfilename% 2>&1
echo cridx_srvmeth_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvmeth_xuname.mysql >>%logfilename% 2>&1
echo cridx_srvmeth_tableidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvmeth_tableidx.mysql >>%logfilename% 2>&1
echo cridx_srvmeth_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvmeth_defschidx.mysql >>%logfilename% 2>&1
echo cridx_srvofunc_rettblk.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_srvofunc_rettblk.mysql >>%logfilename% 2>&1
echo cridx_service_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_service_xcluster.mysql >>%logfilename% 2>&1
echo cridx_service_xhost.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_service_xhost.mysql >>%logfilename% 2>&1
echo cridx_service_xtype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_service_xtype.mysql >>%logfilename% 2>&1
echo cridx_service_xutype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_service_xutype.mysql >>%logfilename% 2>&1
echo cridx_service_xuhpt.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_service_xuhpt.mysql >>%logfilename% 2>&1
echo cridx_servicetype_xudsc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_servicetype_xudsc.mysql >>%logfilename% 2>&1
echo cridx_strcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_strcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_strtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_strtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_sprjdef_pprjidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_sprjdef_pprjidx.mysql >>%logfilename% 2>&1
echo cridx_sprjdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_sprjdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_sysclus_xclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_sysclus_xclus.mysql >>%logfilename% 2>&1
echo cridx_tsecgroup_xtenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecgroup_xtenant.mysql >>%logfilename% 2>&1
echo cridx_tsecgroup_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecgroup_xuname.mysql >>%logfilename% 2>&1
echo cridx_tsecinclude_xtenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecinclude_xtenant.mysql >>%logfilename% 2>&1
echo cridx_tsecinclude_xgroup.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecinclude_xgroup.mysql >>%logfilename% 2>&1
echo cridx_tsecinclude_xinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecinclude_xinc.mysql >>%logfilename% 2>&1
echo cridx_tsecinclude_xuinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecinclude_xuinc.mysql >>%logfilename% 2>&1
echo cridx_tsecmember_xtenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecmember_xtenant.mysql >>%logfilename% 2>&1
echo cridx_tsecmember_xgroup.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecmember_xgroup.mysql >>%logfilename% 2>&1
echo cridx_tsecmember_xuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecmember_xuser.mysql >>%logfilename% 2>&1
echo cridx_tsecmember_xuuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tsecmember_xuuser.mysql >>%logfilename% 2>&1
echo cridx_dzcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dzcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_dztyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_dztyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tmzcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tmzcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_tmztyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tmztyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_zscol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_zscol_xtable.mysql >>%logfilename% 2>&1
echo cridx_zstyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_zstyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tbldef_schemaidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tbldef_schemaidx.mysql >>%logfilename% 2>&1
echo cridx_tbldef_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tbldef_defschidx.mysql >>%logfilename% 2>&1
echo cridx_table_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_table_xuname.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xscd.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xscd.mysql >>%logfilename% 2>&1
echo cridx_def_tbl_xpidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_def_tbl_xpidx.mysql >>%logfilename% 2>&1
echo cridx_def_tbl_xlookupidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_def_tbl_xlookupidx.mysql >>%logfilename% 2>&1
echo cridx_def_tbl_xaltidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_def_tbl_xaltidx.mysql >>%logfilename% 2>&1
echo cridx_def_tbl_xqtblidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_def_tbl_xqtblidx.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xloadbehave.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xloadbehave.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xdatascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xdatascope.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xsecscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xsecscope.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xviewaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xviewaccsec.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xviewaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xviewaccfreq.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xeditaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xeditaccsec.mysql >>%logfilename% 2>&1
echo cridx_tabledef_xeditaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tabledef_xeditaccfreq.mysql >>%logfilename% 2>&1
echo cridx_tblcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tblcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_tablecol_xdata.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tablecol_xdata.mysql >>%logfilename% 2>&1
echo cridx_tenant_xcluster.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tenant_xcluster.mysql >>%logfilename% 2>&1
echo cridx_tenant_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tenant_xuname.mysql >>%logfilename% 2>&1
echo cridx_txtcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_txtcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_txttyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_txttyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tmcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tmcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_tmtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tmtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tscol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tscol_xtable.mysql >>%logfilename% 2>&1
echo cridx_tstyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tstyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tlddef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tlddef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_tlddef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tlddef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_tkncol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tkncol_xtable.mysql >>%logfilename% 2>&1
echo cridx_tkntyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tkntyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_tdomdef_tldidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tdomdef_tldidx.mysql >>%logfilename% 2>&1
echo cridx_tdomdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tdomdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_tprjdef_domidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tprjdef_domidx.mysql >>%logfilename% 2>&1
echo cridx_tprjdef_unameidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_tprjdef_unameidx.mysql >>%logfilename% 2>&1
echo cridx_uint16col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint16col_xtable.mysql >>%logfilename% 2>&1
echo cridx_uint16typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint16typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_uint32col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint32col_xtable.mysql >>%logfilename% 2>&1
echo cridx_uint32typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint32typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_uint64col_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint64col_xtable.mysql >>%logfilename% 2>&1
echo cridx_uint64typ_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uint64typ_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_urlproto_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_urlproto_xuname.mysql >>%logfilename% 2>&1
echo cridx_urlproto_xsecure.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_urlproto_xsecure.mysql >>%logfilename% 2>&1
echo cridx_uuidcol_xtable.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uuidcol_xtable.mysql >>%logfilename% 2>&1
echo cridx_idguuid_dpk_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_idguuid_dpk_def.mysql >>%logfilename% 2>&1
echo cridx_uuidtyp_xschemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_uuidtyp_xschemadef.mysql >>%logfilename% 2>&1
echo cridx_valdef_xuname.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valdef_xuname.mysql >>%logfilename% 2>&1
echo cridx_valdef_tenantidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valdef_tenantidx.mysql >>%logfilename% 2>&1
echo cridx_valdef_scopeidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valdef_scopeidx.mysql >>%logfilename% 2>&1
echo cridx_value_defschidx.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_value_defschidx.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xdatascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xdatascope.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xviewaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xviewaccsec.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xviewaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xviewaccfreq.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xeditaccsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xeditaccsec.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xeditaccfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xeditaccfreq.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xprev.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xnext.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xcontprev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xcontprev.mysql >>%logfilename% 2>&1
echo cridx_valuedef_xcontnext.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < cridx_valuedef_xcontnext.mysql >>%logfilename% 2>&1

