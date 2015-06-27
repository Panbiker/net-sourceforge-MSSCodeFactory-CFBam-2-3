#!/bin/bash
#
#	@(#) dbcreate/cfbam/db2luw/cridx_cfbam23.bash
# 
# 	CFBam
#
#	Copyright (c) 2014-2015 Mark Sobkow
#	
#	This program is available as free software under the GNU GPL v3, under
#	the Eclipse Public License 1.0, or under a commercial license from Mark
#	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
#	
#	You should have received copies of the complete license text for
#	GPLv3.txt and EPLv1_0.txt, containing the text
#	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
#	
#	Under the terms of the GPL:
#	
#		This program is free software: you can redistribute it and/or modify
#		it under the terms of the GNU General Public License as published by
#		the Free Software Foundation, either version 3 of the License, or
#		(at your option) any later version.
#	  
#		This program is distributed in the hope that it will be useful,
#		but WITHOUT ANY WARRANTY; without even the implied warranty of
#		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#		GNU General Public License for more details.
#	  
#		You should have received a copy of the GNU General Public License
#		along with this program.  If not, see <http://www.gnu.org/licenses/>.
#	
#	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
#	and licensed under the BSD 3-Clause license as written by xfree86.org:
#	
#	Redistribution and use in source and binary forms, with or without
#	modification, are permitted provided that the following conditions are
#	met:
#	
#	    (1) Redistributions of source code must retain the above copyright
#	    notice, this list of conditions and the following disclaimer. 
#	
#	    (2) Redistributions in binary form must reproduce the above copyright
#	    notice, this list of conditions and the following disclaimer in
#	    the documentation and/or other materials provided with the
#	    distribution.  
#	    
#	    (3)The name of the author may not be used to
#	    endorse or promote products derived from this software without
#	    specific prior written permission.
#	
#	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
#	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
#	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
#	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
#	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
#	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
#	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
#	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
#	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
#	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
#	POSSIBILITY OF SUCH DAMAGE.
#	
#
# **********************************************************************
#
# 	Code manufactured by MSS Code Factory
#

#

echo "#	cridx_accfreq_xuname.sql ..."
db2 -l db2output.log -f cridx_accfreq_xuname.sql
echo "#	cridx_accsec_xuname.sql ..."
db2 -l db2output.log -f cridx_accsec_xuname.sql
echo "#	cridx_auditaction_xudsc.sql ..."
db2 -l db2output.log -f cridx_auditaction_xudsc.sql
echo "#	cridx_blbcol_xtable.sql ..."
db2 -l db2output.log -f cridx_blbcol_xtable.sql
echo "#	cridx_blbtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_blbtyp_xschemadef.sql
echo "#	cridx_boolcol_xtable.sql ..."
db2 -l db2output.log -f cridx_boolcol_xtable.sql
echo "#	cridx_booltyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_booltyp_xschemadef.sql
echo "#	cridx_chain_xtent.sql ..."
db2 -l db2output.log -f cridx_chain_xtent.sql
echo "#	cridx_chain_xtbl.sql ..."
db2 -l db2output.log -f cridx_chain_xtbl.sql
echo "#	cridx_chain_defschidx.sql ..."
db2 -l db2output.log -f cridx_chain_defschidx.sql
echo "#	cridx_chain_xuname.sql ..."
db2 -l db2output.log -f cridx_chain_xuname.sql
echo "#	cridx_chain_xprevrel.sql ..."
db2 -l db2output.log -f cridx_chain_xprevrel.sql
echo "#	cridx_chain_xnextrel.sql ..."
db2 -l db2output.log -f cridx_chain_xnextrel.sql
echo "#	cridx_clrdep_xrel.sql ..."
db2 -l db2output.log -f cridx_clrdep_xrel.sql
echo "#	cridx_clrsubdep1_xcdeltopdep.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_xcdeltopdep.sql
echo "#	cridx_clrsubdep1_uname.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_uname.sql
echo "#	cridx_clrsubdep2_xcdeldep1.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_xcdeldep1.sql
echo "#	cridx_clrsubdep2_uname.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_uname.sql
echo "#	cridx_clrsubdep3_xcdeldep2.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_xcdeldep2.sql
echo "#	cridx_clrsubdep3_uname.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_uname.sql
echo "#	cridx_clrtop_xctbl.sql ..."
db2 -l db2output.log -f cridx_clrtop_xctbl.sql
echo "#	cridx_clrtopdep_uname.sql ..."
db2 -l db2output.log -f cridx_clrtopdep_uname.sql
echo "#	cridx_cluster_xufdname.sql ..."
db2 -l db2output.log -f cridx_cluster_xufdname.sql
echo "#	cridx_cluster_xudescr.sql ..."
db2 -l db2output.log -f cridx_cluster_xudescr.sql
echo "#	cridx_datascope_xuname.sql ..."
db2 -l db2output.log -f cridx_datascope_xuname.sql
echo "#	cridx_dtcol_xtable.sql ..."
db2 -l db2output.log -f cridx_dtcol_xtable.sql
echo "#	cridx_dttyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_dttyp_xschemadef.sql
echo "#	cridx_deldep_defschidx.sql ..."
db2 -l db2output.log -f cridx_deldep_defschidx.sql
echo "#	cridx_deldep_xrel.sql ..."
db2 -l db2output.log -f cridx_deldep_xrel.sql
echo "#	cridx_delsubdep1_xcdeltopdep.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_xcdeltopdep.sql
echo "#	cridx_delsubdep1_uname.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_uname.sql
echo "#	cridx_delsubdep2_xcdeldep1.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_xcdeldep1.sql
echo "#	cridx_delsubdep2_uname.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_uname.sql
echo "#	cridx_delsubdep3_xcdeldep2.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_xcdeldep2.sql
echo "#	cridx_delsubdep3_uname.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_uname.sql
echo "#	cridx_deltop_xctbl.sql ..."
db2 -l db2output.log -f cridx_deltop_xctbl.sql
echo "#	cridx_deltop_uname.sql ..."
db2 -l db2output.log -f cridx_deltop_uname.sql
echo "#	cridx_domdef_subdomidx.sql ..."
db2 -l db2output.log -f cridx_domdef_subdomidx.sql
echo "#	cridx_domdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_domdef_unameidx.sql
echo "#	cridx_bdomdef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_bdomdef_tenantidx.sql
echo "#	cridx_dblcol_xtable.sql ..."
db2 -l db2output.log -f cridx_dblcol_xtable.sql
echo "#	cridx_dbltyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_dbltyp_xschemadef.sql
echo "#	cridx_enumcol_xtable.sql ..."
db2 -l db2output.log -f cridx_enumcol_xtable.sql
echo "#	cridx_enumtag_xtenant.sql ..."
db2 -l db2output.log -f cridx_enumtag_xtenant.sql
echo "#	cridx_enumtag_xenum.sql ..."
db2 -l db2output.log -f cridx_enumtag_xenum.sql
echo "#	cridx_enumtag_defschidx.sql ..."
db2 -l db2output.log -f cridx_enumtag_defschidx.sql
echo "#	cridx_enumtag_uenumnm.sql ..."
db2 -l db2output.log -f cridx_enumtag_uenumnm.sql
echo "#	cridx_enumtag_xprev.sql ..."
db2 -l db2output.log -f cridx_enumtag_xprev.sql
echo "#	cridx_enumtag_xnext.sql ..."
db2 -l db2output.log -f cridx_enumtag_xnext.sql
echo "#	cridx_enumtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_enumtyp_xschemadef.sql
echo "#	cridx_fltcol_xtable.sql ..."
db2 -l db2output.log -f cridx_fltcol_xtable.sql
echo "#	cridx_flttyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_flttyp_xschemadef.sql
echo "#	cridx_hostnode_xcluster.sql ..."
db2 -l db2output.log -f cridx_hostnode_xcluster.sql
echo "#	cridx_hostnode_xudsc.sql ..."
db2 -l db2output.log -f cridx_hostnode_xudsc.sql
echo "#	cridx_hostnode_xhnm.sql ..."
db2 -l db2output.log -f cridx_hostnode_xhnm.sql
echo "#	cridx_isocountry_xcode.sql ..."
db2 -l db2output.log -f cridx_isocountry_xcode.sql
echo "#	cridx_isocountry_xuname.sql ..."
db2 -l db2output.log -f cridx_isocountry_xuname.sql
echo "#	cridx_isocountryccy_xcountry.sql ..."
db2 -l db2output.log -f cridx_isocountryccy_xcountry.sql
echo "#	cridx_isocountryccy_xccy.sql ..."
db2 -l db2output.log -f cridx_isocountryccy_xccy.sql
echo "#	cridx_isocountrylang_xcountry.sql ..."
db2 -l db2output.log -f cridx_isocountrylang_xcountry.sql
echo "#	cridx_isocountrylang_xlang.sql ..."
db2 -l db2output.log -f cridx_isocountrylang_xlang.sql
echo "#	cridx_isocurrency_xcode.sql ..."
db2 -l db2output.log -f cridx_isocurrency_xcode.sql
echo "#	cridx_isocurrency_xuname.sql ..."
db2 -l db2output.log -f cridx_isocurrency_xuname.sql
echo "#	cridx_isolang_xbase.sql ..."
db2 -l db2output.log -f cridx_isolang_xbase.sql
echo "#	cridx_isolang_xcntry.sql ..."
db2 -l db2output.log -f cridx_isolang_xcntry.sql
echo "#	cridx_isolang_xcode.sql ..."
db2 -l db2output.log -f cridx_isolang_xcode.sql
echo "#	cridx_itz_xoffset.sql ..."
db2 -l db2output.log -f cridx_itz_xoffset.sql
echo "#	cridx_itz_xuname.sql ..."
db2 -l db2output.log -f cridx_itz_xuname.sql
echo "#	cridx_itz_xiso.sql ..."
db2 -l db2output.log -f cridx_itz_xiso.sql
echo "#	cridx_idg16_dpk_def.sql ..."
db2 -l db2output.log -f cridx_idg16_dpk_def.sql
echo "#	cridx_idg32_dpk_def.sql ..."
db2 -l db2output.log -f cridx_idg32_dpk_def.sql
echo "#	cridx_idg64_dpk_def.sql ..."
db2 -l db2output.log -f cridx_idg64_dpk_def.sql
echo "#	cridx_idxdef_xuname.sql ..."
db2 -l db2output.log -f cridx_idxdef_xuname.sql
echo "#	cridx_idxdef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_tenantidx.sql
echo "#	cridx_idxdef_tableidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_tableidx.sql
echo "#	cridx_index_defschidx.sql ..."
db2 -l db2output.log -f cridx_index_defschidx.sql
echo "#	cridx_idxcol_xuname.sql ..."
db2 -l db2output.log -f cridx_idxcol_xuname.sql
echo "#	cridx_idxcol_tenantidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_tenantidx.sql
echo "#	cridx_idxcol_indexidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_indexidx.sql
echo "#	cridx_idxcol_defschidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_defschidx.sql
echo "#	cridx_idxcol_col_def.sql ..."
db2 -l db2output.log -f cridx_idxcol_col_def.sql
echo "#	cridx_idxcol_xprev.sql ..."
db2 -l db2output.log -f cridx_idxcol_xprev.sql
echo "#	cridx_idxcol_xnext.sql ..."
db2 -l db2output.log -f cridx_idxcol_xnext.sql
echo "#	cridx_idxcol_xidxprev.sql ..."
db2 -l db2output.log -f cridx_idxcol_xidxprev.sql
echo "#	cridx_idxcol_xidxnext.sql ..."
db2 -l db2output.log -f cridx_idxcol_xidxnext.sql
echo "#	cridx_int16col_xtable.sql ..."
db2 -l db2output.log -f cridx_int16col_xtable.sql
echo "#	cridx_int16typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_int16typ_xschemadef.sql
echo "#	cridx_int32col_xtable.sql ..."
db2 -l db2output.log -f cridx_int32col_xtable.sql
echo "#	cridx_int32typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_int32typ_xschemadef.sql
echo "#	cridx_int64col_xtable.sql ..."
db2 -l db2output.log -f cridx_int64col_xtable.sql
echo "#	cridx_int64typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_int64typ_xschemadef.sql
echo "#	cridx_lic_xtenant.sql ..."
db2 -l db2output.log -f cridx_lic_xtenant.sql
echo "#	cridx_lic_xdom.sql ..."
db2 -l db2output.log -f cridx_lic_xdom.sql
echo "#	cridx_lic_xuname.sql ..."
db2 -l db2output.log -f cridx_lic_xuname.sql
echo "#	cridx_loadbehav_xuname.sql ..."
db2 -l db2output.log -f cridx_loadbehav_xuname.sql
echo "#	cridx_mjverdef_pprjidx.sql ..."
db2 -l db2output.log -f cridx_mjverdef_pprjidx.sql
echo "#	cridx_mjverdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_mjverdef_unameidx.sql
echo "#	cridx_mimetype_xuname.sql ..."
db2 -l db2output.log -f cridx_mimetype_xuname.sql
echo "#	cridx_mnverdef_majoridx.sql ..."
db2 -l db2output.log -f cridx_mnverdef_majoridx.sql
echo "#	cridx_mnverdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_mnverdef_unameidx.sql
echo "#	cridx_nmtkncol_xtable.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_xtable.sql
echo "#	cridx_nmtkntyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_xschemadef.sql
echo "#	cridx_nmtknscol_xtable.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_xtable.sql
echo "#	cridx_nmtknstyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_xschemadef.sql
echo "#	cridx_numcol_xtable.sql ..."
db2 -l db2output.log -f cridx_numcol_xtable.sql
echo "#	cridx_numtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_numtyp_xschemadef.sql
echo "#	cridx_srvprm_xuname.sql ..."
db2 -l db2output.log -f cridx_srvprm_xuname.sql
echo "#	cridx_srvprm_tenantidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_tenantidx.sql
echo "#	cridx_srvprm_srvmethk.sql ..."
db2 -l db2output.log -f cridx_srvprm_srvmethk.sql
echo "#	cridx_srvprm_defschidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_defschidx.sql
echo "#	cridx_srvprm_typek.sql ..."
db2 -l db2output.log -f cridx_srvprm_typek.sql
echo "#	cridx_srvprm_xprev.sql ..."
db2 -l db2output.log -f cridx_srvprm_xprev.sql
echo "#	cridx_srvprm_xnext.sql ..."
db2 -l db2output.log -f cridx_srvprm_xnext.sql
echo "#	cridx_srvprm_xcontprev.sql ..."
db2 -l db2output.log -f cridx_srvprm_xcontprev.sql
echo "#	cridx_srvprm_xcontnext.sql ..."
db2 -l db2output.log -f cridx_srvprm_xcontnext.sql
echo "#	cridx_popdep_xrel.sql ..."
db2 -l db2output.log -f cridx_popdep_xrel.sql
echo "#	cridx_popdep_defschidx.sql ..."
db2 -l db2output.log -f cridx_popdep_defschidx.sql
echo "#	cridx_popsubdep1_xcpoptopdep.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_xcpoptopdep.sql
echo "#	cridx_popsubdep1_uname.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_uname.sql
echo "#	cridx_popsubdep2_xcpopdep1.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_xcpopdep1.sql
echo "#	cridx_popsubdep2_uname.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_uname.sql
echo "#	cridx_popsubdep3_xcpopdep2.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_xcpopdep2.sql
echo "#	cridx_popsubdep3_uname.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_uname.sql
echo "#	cridx_poptop_xcrel.sql ..."
db2 -l db2output.log -f cridx_poptop_xcrel.sql
echo "#	cridx_poptop_uname.sql ..."
db2 -l db2output.log -f cridx_poptop_uname.sql
echo "#	cridx_reldef_xuname.sql ..."
db2 -l db2output.log -f cridx_reldef_xuname.sql
echo "#	cridx_reldef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_reldef_tenantidx.sql
echo "#	cridx_reldef_tableidx.sql ..."
db2 -l db2output.log -f cridx_reldef_tableidx.sql
echo "#	cridx_reldef_defschidx.sql ..."
db2 -l db2output.log -f cridx_reldef_defschidx.sql
echo "#	cridx_reldef_xrtypekey.sql ..."
db2 -l db2output.log -f cridx_reldef_xrtypekey.sql
echo "#	cridx_reldef_xfromkey.sql ..."
db2 -l db2output.log -f cridx_reldef_xfromkey.sql
echo "#	cridx_reldef_xtotbl.sql ..."
db2 -l db2output.log -f cridx_reldef_xtotbl.sql
echo "#	cridx_reldef_xtokey.sql ..."
db2 -l db2output.log -f cridx_reldef_xtokey.sql
echo "#	cridx_reldef_xnarrowed.sql ..."
db2 -l db2output.log -f cridx_reldef_xnarrowed.sql
echo "#	cridx_relcol_xuname.sql ..."
db2 -l db2output.log -f cridx_relcol_xuname.sql
echo "#	cridx_relcol_tenantidx.sql ..."
db2 -l db2output.log -f cridx_relcol_tenantidx.sql
echo "#	cridx_relcol_relk.sql ..."
db2 -l db2output.log -f cridx_relcol_relk.sql
echo "#	cridx_relcol_defschidx.sql ..."
db2 -l db2output.log -f cridx_relcol_defschidx.sql
echo "#	cridx_relcol_fromk.sql ..."
db2 -l db2output.log -f cridx_relcol_fromk.sql
echo "#	cridx_relcol_tok.sql ..."
db2 -l db2output.log -f cridx_relcol_tok.sql
echo "#	cridx_relcol_xprev.sql ..."
db2 -l db2output.log -f cridx_relcol_xprev.sql
echo "#	cridx_relcol_xnext.sql ..."
db2 -l db2output.log -f cridx_relcol_xnext.sql
echo "#	cridx_relcol_xrelprev.sql ..."
db2 -l db2output.log -f cridx_relcol_xrelprev.sql
echo "#	cridx_relcol_xrelnext.sql ..."
db2 -l db2output.log -f cridx_relcol_xrelnext.sql
echo "#	cridx_rel_type_utagidx.sql ..."
db2 -l db2output.log -f cridx_rel_type_utagidx.sql
echo "#	cridx_schemadef_ctenantidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_ctenantidx.sql
echo "#	cridx_schemadef_domainidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_domainidx.sql
echo "#	cridx_schemadef_xuname.sql ..."
db2 -l db2output.log -f cridx_schemadef_xuname.sql
echo "#	cridx_schemadef_xdeflcn.sql ..."
db2 -l db2output.log -f cridx_schemadef_xdeflcn.sql
echo "#	cridx_schemadef_xdatascope.sql ..."
db2 -l db2output.log -f cridx_schemadef_xdatascope.sql
echo "#	cridx_schemadef_xviewaccsec.sql ..."
db2 -l db2output.log -f cridx_schemadef_xviewaccsec.sql
echo "#	cridx_schemadef_xviewaccfreq.sql ..."
db2 -l db2output.log -f cridx_schemadef_xviewaccfreq.sql
echo "#	cridx_schemadef_xeditaccsec.sql ..."
db2 -l db2output.log -f cridx_schemadef_xeditaccsec.sql
echo "#	cridx_schemadef_xeditaccfreq.sql ..."
db2 -l db2output.log -f cridx_schemadef_xeditaccfreq.sql
echo "#	cridx_schemadef_xupuburi.sql ..."
db2 -l db2output.log -f cridx_schemadef_xupuburi.sql
echo "#	cridx_schemaref_schk.sql ..."
db2 -l db2output.log -f cridx_schemaref_schk.sql
echo "#	cridx_schemaref_uname.sql ..."
db2 -l db2output.log -f cridx_schemaref_uname.sql
echo "#	cridx_schemaref_rsck.sql ..."
db2 -l db2output.log -f cridx_schemaref_rsck.sql
echo "#	cridx_scopedef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_scopedef_tenantidx.sql
echo "#	cridx_secapp_xcluster.sql ..."
db2 -l db2output.log -f cridx_secapp_xcluster.sql
echo "#	cridx_secapp_xujeemnt.sql ..."
db2 -l db2output.log -f cridx_secapp_xujeemnt.sql
echo "#	cridx_secdev_usridx.sql ..."
db2 -l db2output.log -f cridx_secdev_usridx.sql
echo "#	cridx_secform_xcluster.sql ..."
db2 -l db2output.log -f cridx_secform_xcluster.sql
echo "#	cridx_secform_xsecapp.sql ..."
db2 -l db2output.log -f cridx_secform_xsecapp.sql
echo "#	cridx_secform_xujeesvlt.sql ..."
db2 -l db2output.log -f cridx_secform_xujeesvlt.sql
echo "#	cridx_secgroup_xcluster.sql ..."
db2 -l db2output.log -f cridx_secgroup_xcluster.sql
echo "#	cridx_secgroup_xuname.sql ..."
db2 -l db2output.log -f cridx_secgroup_xuname.sql
echo "#	cridx_secgroupform_xcluster.sql ..."
db2 -l db2output.log -f cridx_secgroupform_xcluster.sql
echo "#	cridx_secgroupform_xgroup.sql ..."
db2 -l db2output.log -f cridx_secgroupform_xgroup.sql
echo "#	cridx_secgroupform_xapp.sql ..."
db2 -l db2output.log -f cridx_secgroupform_xapp.sql
echo "#	cridx_secgroupform_xform.sql ..."
db2 -l db2output.log -f cridx_secgroupform_xform.sql
echo "#	cridx_secgroupform_xuform.sql ..."
db2 -l db2output.log -f cridx_secgroupform_xuform.sql
echo "#	cridx_secinclude_xcluster.sql ..."
db2 -l db2output.log -f cridx_secinclude_xcluster.sql
echo "#	cridx_secinclude_xgroup.sql ..."
db2 -l db2output.log -f cridx_secinclude_xgroup.sql
echo "#	cridx_secinclude_xinc.sql ..."
db2 -l db2output.log -f cridx_secinclude_xinc.sql
echo "#	cridx_secinclude_xuinc.sql ..."
db2 -l db2output.log -f cridx_secinclude_xuinc.sql
echo "#	cridx_secmember_xcluster.sql ..."
db2 -l db2output.log -f cridx_secmember_xcluster.sql
echo "#	cridx_secmember_xgroup.sql ..."
db2 -l db2output.log -f cridx_secmember_xgroup.sql
echo "#	cridx_secmember_xuser.sql ..."
db2 -l db2output.log -f cridx_secmember_xuser.sql
echo "#	cridx_secmember_xuuser.sql ..."
db2 -l db2output.log -f cridx_secmember_xuuser.sql
echo "#	cridx_session_xsecuser.sql ..."
db2 -l db2output.log -f cridx_session_xsecuser.sql
echo "#	cridx_session_xsecdev.sql ..."
db2 -l db2output.log -f cridx_session_xsecdev.sql
echo "#	cridx_session_xstart.sql ..."
db2 -l db2output.log -f cridx_session_xstart.sql
echo "#	cridx_session_xfnsh.sql ..."
db2 -l db2output.log -f cridx_session_xfnsh.sql
echo "#	cridx_session_xproxy.sql ..."
db2 -l db2output.log -f cridx_session_xproxy.sql
echo "#	cridx_secuser_xulogin.sql ..."
db2 -l db2output.log -f cridx_secuser_xulogin.sql
echo "#	cridx_secuser_xemconf.sql ..."
db2 -l db2output.log -f cridx_secuser_xemconf.sql
echo "#	cridx_secuser_xpwdrst.sql ..."
db2 -l db2output.log -f cridx_secuser_xpwdrst.sql
echo "#	cridx_secuser_defdevidx.sql ..."
db2 -l db2output.log -f cridx_secuser_defdevidx.sql
echo "#	cridx_secscope_xuname.sql ..."
db2 -l db2output.log -f cridx_secscope_xuname.sql
echo "#	cridx_srvlfunc_rettblk.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_rettblk.sql
echo "#	cridx_srvmeth_xuname.sql ..."
db2 -l db2output.log -f cridx_srvmeth_xuname.sql
echo "#	cridx_srvmeth_tableidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_tableidx.sql
echo "#	cridx_srvmeth_defschidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_defschidx.sql
echo "#	cridx_srvofunc_rettblk.sql ..."
db2 -l db2output.log -f cridx_srvofunc_rettblk.sql
echo "#	cridx_service_xcluster.sql ..."
db2 -l db2output.log -f cridx_service_xcluster.sql
echo "#	cridx_service_xhost.sql ..."
db2 -l db2output.log -f cridx_service_xhost.sql
echo "#	cridx_service_xtype.sql ..."
db2 -l db2output.log -f cridx_service_xtype.sql
echo "#	cridx_service_xutype.sql ..."
db2 -l db2output.log -f cridx_service_xutype.sql
echo "#	cridx_service_xuhpt.sql ..."
db2 -l db2output.log -f cridx_service_xuhpt.sql
echo "#	cridx_servicetype_xudsc.sql ..."
db2 -l db2output.log -f cridx_servicetype_xudsc.sql
echo "#	cridx_strcol_xtable.sql ..."
db2 -l db2output.log -f cridx_strcol_xtable.sql
echo "#	cridx_strtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_strtyp_xschemadef.sql
echo "#	cridx_sprjdef_pprjidx.sql ..."
db2 -l db2output.log -f cridx_sprjdef_pprjidx.sql
echo "#	cridx_sprjdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_sprjdef_unameidx.sql
echo "#	cridx_sysclus_xclus.sql ..."
db2 -l db2output.log -f cridx_sysclus_xclus.sql
echo "#	cridx_tsecgroup_xtenant.sql ..."
db2 -l db2output.log -f cridx_tsecgroup_xtenant.sql
echo "#	cridx_tsecgroup_xuname.sql ..."
db2 -l db2output.log -f cridx_tsecgroup_xuname.sql
echo "#	cridx_tsecinclude_xtenant.sql ..."
db2 -l db2output.log -f cridx_tsecinclude_xtenant.sql
echo "#	cridx_tsecinclude_xgroup.sql ..."
db2 -l db2output.log -f cridx_tsecinclude_xgroup.sql
echo "#	cridx_tsecinclude_xinc.sql ..."
db2 -l db2output.log -f cridx_tsecinclude_xinc.sql
echo "#	cridx_tsecinclude_xuinc.sql ..."
db2 -l db2output.log -f cridx_tsecinclude_xuinc.sql
echo "#	cridx_tsecmember_xtenant.sql ..."
db2 -l db2output.log -f cridx_tsecmember_xtenant.sql
echo "#	cridx_tsecmember_xgroup.sql ..."
db2 -l db2output.log -f cridx_tsecmember_xgroup.sql
echo "#	cridx_tsecmember_xuser.sql ..."
db2 -l db2output.log -f cridx_tsecmember_xuser.sql
echo "#	cridx_tsecmember_xuuser.sql ..."
db2 -l db2output.log -f cridx_tsecmember_xuuser.sql
echo "#	cridx_dzcol_xtable.sql ..."
db2 -l db2output.log -f cridx_dzcol_xtable.sql
echo "#	cridx_dztyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_dztyp_xschemadef.sql
echo "#	cridx_tmzcol_xtable.sql ..."
db2 -l db2output.log -f cridx_tmzcol_xtable.sql
echo "#	cridx_tmztyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_tmztyp_xschemadef.sql
echo "#	cridx_zscol_xtable.sql ..."
db2 -l db2output.log -f cridx_zscol_xtable.sql
echo "#	cridx_zstyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_zstyp_xschemadef.sql
echo "#	cridx_tbldef_schemaidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_schemaidx.sql
echo "#	cridx_tbldef_defschidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_defschidx.sql
echo "#	cridx_table_xuname.sql ..."
db2 -l db2output.log -f cridx_table_xuname.sql
echo "#	cridx_tabledef_xscd.sql ..."
db2 -l db2output.log -f cridx_tabledef_xscd.sql
echo "#	cridx_def_tbl_xpidx.sql ..."
db2 -l db2output.log -f cridx_def_tbl_xpidx.sql
echo "#	cridx_def_tbl_xlookupidx.sql ..."
db2 -l db2output.log -f cridx_def_tbl_xlookupidx.sql
echo "#	cridx_def_tbl_xaltidx.sql ..."
db2 -l db2output.log -f cridx_def_tbl_xaltidx.sql
echo "#	cridx_def_tbl_xqtblidx.sql ..."
db2 -l db2output.log -f cridx_def_tbl_xqtblidx.sql
echo "#	cridx_tabledef_xloadbehave.sql ..."
db2 -l db2output.log -f cridx_tabledef_xloadbehave.sql
echo "#	cridx_tabledef_xdatascope.sql ..."
db2 -l db2output.log -f cridx_tabledef_xdatascope.sql
echo "#	cridx_tabledef_xsecscope.sql ..."
db2 -l db2output.log -f cridx_tabledef_xsecscope.sql
echo "#	cridx_tabledef_xviewaccsec.sql ..."
db2 -l db2output.log -f cridx_tabledef_xviewaccsec.sql
echo "#	cridx_tabledef_xviewaccfreq.sql ..."
db2 -l db2output.log -f cridx_tabledef_xviewaccfreq.sql
echo "#	cridx_tabledef_xeditaccsec.sql ..."
db2 -l db2output.log -f cridx_tabledef_xeditaccsec.sql
echo "#	cridx_tabledef_xeditaccfreq.sql ..."
db2 -l db2output.log -f cridx_tabledef_xeditaccfreq.sql
echo "#	cridx_tblcol_xtable.sql ..."
db2 -l db2output.log -f cridx_tblcol_xtable.sql
echo "#	cridx_tablecol_xdata.sql ..."
db2 -l db2output.log -f cridx_tablecol_xdata.sql
echo "#	cridx_tenant_xcluster.sql ..."
db2 -l db2output.log -f cridx_tenant_xcluster.sql
echo "#	cridx_tenant_xuname.sql ..."
db2 -l db2output.log -f cridx_tenant_xuname.sql
echo "#	cridx_txtcol_xtable.sql ..."
db2 -l db2output.log -f cridx_txtcol_xtable.sql
echo "#	cridx_txttyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_txttyp_xschemadef.sql
echo "#	cridx_tmcol_xtable.sql ..."
db2 -l db2output.log -f cridx_tmcol_xtable.sql
echo "#	cridx_tmtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_tmtyp_xschemadef.sql
echo "#	cridx_tscol_xtable.sql ..."
db2 -l db2output.log -f cridx_tscol_xtable.sql
echo "#	cridx_tstyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_tstyp_xschemadef.sql
echo "#	cridx_tlddef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tlddef_tenantidx.sql
echo "#	cridx_tlddef_unameidx.sql ..."
db2 -l db2output.log -f cridx_tlddef_unameidx.sql
echo "#	cridx_tkncol_xtable.sql ..."
db2 -l db2output.log -f cridx_tkncol_xtable.sql
echo "#	cridx_tkntyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_tkntyp_xschemadef.sql
echo "#	cridx_tdomdef_tldidx.sql ..."
db2 -l db2output.log -f cridx_tdomdef_tldidx.sql
echo "#	cridx_tdomdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_tdomdef_unameidx.sql
echo "#	cridx_tprjdef_domidx.sql ..."
db2 -l db2output.log -f cridx_tprjdef_domidx.sql
echo "#	cridx_tprjdef_unameidx.sql ..."
db2 -l db2output.log -f cridx_tprjdef_unameidx.sql
echo "#	cridx_uint16col_xtable.sql ..."
db2 -l db2output.log -f cridx_uint16col_xtable.sql
echo "#	cridx_uint16typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_uint16typ_xschemadef.sql
echo "#	cridx_uint32col_xtable.sql ..."
db2 -l db2output.log -f cridx_uint32col_xtable.sql
echo "#	cridx_uint32typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_uint32typ_xschemadef.sql
echo "#	cridx_uint64col_xtable.sql ..."
db2 -l db2output.log -f cridx_uint64col_xtable.sql
echo "#	cridx_uint64typ_xschemadef.sql ..."
db2 -l db2output.log -f cridx_uint64typ_xschemadef.sql
echo "#	cridx_urlproto_xuname.sql ..."
db2 -l db2output.log -f cridx_urlproto_xuname.sql
echo "#	cridx_urlproto_xsecure.sql ..."
db2 -l db2output.log -f cridx_urlproto_xsecure.sql
echo "#	cridx_uuidcol_xtable.sql ..."
db2 -l db2output.log -f cridx_uuidcol_xtable.sql
echo "#	cridx_idguuid_dpk_def.sql ..."
db2 -l db2output.log -f cridx_idguuid_dpk_def.sql
echo "#	cridx_uuidtyp_xschemadef.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_xschemadef.sql
echo "#	cridx_valdef_xuname.sql ..."
db2 -l db2output.log -f cridx_valdef_xuname.sql
echo "#	cridx_valdef_tenantidx.sql ..."
db2 -l db2output.log -f cridx_valdef_tenantidx.sql
echo "#	cridx_valdef_scopeidx.sql ..."
db2 -l db2output.log -f cridx_valdef_scopeidx.sql
echo "#	cridx_value_defschidx.sql ..."
db2 -l db2output.log -f cridx_value_defschidx.sql
echo "#	cridx_valuedef_xdatascope.sql ..."
db2 -l db2output.log -f cridx_valuedef_xdatascope.sql
echo "#	cridx_valuedef_xviewaccsec.sql ..."
db2 -l db2output.log -f cridx_valuedef_xviewaccsec.sql
echo "#	cridx_valuedef_xviewaccfreq.sql ..."
db2 -l db2output.log -f cridx_valuedef_xviewaccfreq.sql
echo "#	cridx_valuedef_xeditaccsec.sql ..."
db2 -l db2output.log -f cridx_valuedef_xeditaccsec.sql
echo "#	cridx_valuedef_xeditaccfreq.sql ..."
db2 -l db2output.log -f cridx_valuedef_xeditaccfreq.sql
echo "#	cridx_valuedef_xprev.sql ..."
db2 -l db2output.log -f cridx_valuedef_xprev.sql
echo "#	cridx_valuedef_xnext.sql ..."
db2 -l db2output.log -f cridx_valuedef_xnext.sql
echo "#	cridx_valuedef_xcontprev.sql ..."
db2 -l db2output.log -f cridx_valuedef_xcontprev.sql
echo "#	cridx_valuedef_xcontnext.sql ..."
db2 -l db2output.log -f cridx_valuedef_xcontnext.sql

