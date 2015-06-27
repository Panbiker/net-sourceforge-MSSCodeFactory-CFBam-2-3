--
--	@(#) dbcreate/cfbam/db2luw/readme.txt
REM
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
--	Code manufactured by MSS Code Factory
--




You will find a number of script files in this directory,
all of which are intended to be executed using the DB/2 LUW
bash shell integration to install a CFBam23 database.

You must be logged in as the schema administrator cfbam23
in order to run these scripts.



Database Creation Scripts
-------------------------

crdb_cfbam23.sql
	Creates the id generators, tables, indexes and constraints
	of the database.

cridg_cfbam23.sql
	Creates the database id generator objects.

crtbl_cfbam23.ksh
	Creates the database tables.

cridx_cfbam23.sql
	Creates the database table indexes.

crrel_cfbam23.sql
	Creates the relationships between the tables.

crtbl_accfreq.sql
crtbl_accsec.sql
crtbl_atomdef.sql
crtbl_auditaction.sql
crtbl_blbcol.sql
crtbl_blbdef.sql
crtbl_blbtyp.sql
crtbl_boolcol.sql
crtbl_booldef.sql
crtbl_booltyp.sql
crtbl_chain_def.sql
crtbl_clr_dep.sql
crtbl_clrsubdep1.sql
crtbl_clrsubdep2.sql
crtbl_clrsubdep3.sql
crtbl_clr_topdep.sql
crtbl_clus.sql
crtbl_datascope.sql
crtbl_dtcol.sql
crtbl_dtdef.sql
crtbl_dttyp.sql
crtbl_del_dep.sql
crtbl_delsubdep1.sql
crtbl_delsubdep2.sql
crtbl_delsubdep3.sql
crtbl_del_topdep.sql
crtbl_domdef.sql
crtbl_bdomdef.sql
crtbl_dblcol.sql
crtbl_dbldef.sql
crtbl_dbltyp.sql
crtbl_enumcol.sql
crtbl_enumdef.sql
crtbl_enum_tag.sql
crtbl_enumtyp.sql
crtbl_fltcol.sql
crtbl_fltdef.sql
crtbl_flttyp.sql
crtbl_hostnode.sql
crtbl_iso_cntry.sql
crtbl_iso_cntryccy.sql
crtbl_iso_cntrylng.sql
crtbl_iso_ccy.sql
crtbl_iso_lang.sql
crtbl_isotz.sql
crtbl_idg16.sql
crtbl_idg32.sql
crtbl_idg64.sql
crtbl_idxdef.sql
crtbl_idxcol.sql
crtbl_int16col.sql
crtbl_int16def.sql
crtbl_int16typ.sql
crtbl_int32col.sql
crtbl_int32def.sql
crtbl_int32typ.sql
crtbl_int64col.sql
crtbl_int64def.sql
crtbl_int64typ.sql
crtbl_licn.sql
crtbl_loadbehav.sql
crtbl_mjverdef.sql
crtbl_mimetype.sql
crtbl_mnverdef.sql
crtbl_nmtkncol.sql
crtbl_nmtkndef.sql
crtbl_nmtkntyp.sql
crtbl_nmtknscol.sql
crtbl_nmtknsdef.sql
crtbl_nmtknstyp.sql
crtbl_numcol.sql
crtbl_numdef.sql
crtbl_numtyp.sql
crtbl_srvprm.sql
crtbl_pop_dep.sql
crtbl_popsubdep1.sql
crtbl_popsubdep2.sql
crtbl_popsubdep3.sql
crtbl_pop_topdep.sql
crtbl_bprjdef.sql
crtbl_rprjdef.sql
crtbl_reldef.sql
crtbl_relcol.sql
crtbl_rel_type.sql
crtbl_schemadef.sql
crtbl_schema_ref.sql
crtbl_scopedef.sql
crtbl_secapp.sql
crtbl_secdev.sql
crtbl_secform.sql
crtbl_secgrp.sql
crtbl_secgrpfrm.sql
crtbl_secinc.sql
crtbl_secmemb.sql
crtbl_secsess.sql
crtbl_secuser.sql
crtbl_secscope.sql
crtbl_srvlfunc.sql
crtbl_srvmeth.sql
crtbl_srvofunc.sql
crtbl_srvprc.sql
crtbl_hostsvc.sql
crtbl_svctype.sql
crtbl_strcol.sql
crtbl_strdef.sql
crtbl_strtyp.sql
crtbl_sprjdef.sql
crtbl_sysclus.sql
crtbl_tsecgrp.sql
crtbl_tsecinc.sql
crtbl_tsecmemb.sql
crtbl_dzcol.sql
crtbl_dzdef.sql
crtbl_dztyp.sql
crtbl_tmzcol.sql
crtbl_tmzdef.sql
crtbl_tmztyp.sql
crtbl_zscol.sql
crtbl_zsdef.sql
crtbl_zstyp.sql
crtbl_tbldef.sql
crtbl_tblcol.sql
crtbl_tenant.sql
crtbl_txtcol.sql
crtbl_txtdef.sql
crtbl_txttyp.sql
crtbl_tmcol.sql
crtbl_tmdef.sql
crtbl_tmtyp.sql
crtbl_tscol.sql
crtbl_tsdef.sql
crtbl_tstyp.sql
crtbl_tlddef.sql
crtbl_tkncol.sql
crtbl_tkndef.sql
crtbl_tkntyp.sql
crtbl_tdomdef.sql
crtbl_tprjdef.sql
crtbl_uint16col.sql
crtbl_u16def.sql
crtbl_uint16typ.sql
crtbl_uint32col.sql
crtbl_u32def.sql
crtbl_uint32typ.sql
crtbl_uint64col.sql
crtbl_u64def.sql
crtbl_uint64typ.sql
crtbl_urlproto.sql
crtbl_uuidcol.sql
crtbl_uuiddef.sql
crtbl_idguuid.sql
crtbl_uuidtyp.sql
crtbl_valdef.sql
crtbl_verndef.sql
	The individual table creation scripts called by crtbl_cfbam23.sql.

cridx_accfreq_xuname.sql
cridx_accsec_xuname.sql
cridx_auditaction_xudsc.sql
cridx_blbcol_xtable.sql
cridx_blbtyp_xschemadef.sql
cridx_boolcol_xtable.sql
cridx_booltyp_xschemadef.sql
cridx_chain_xtent.sql
cridx_chain_xtbl.sql
cridx_chain_defschidx.sql
cridx_chain_xuname.sql
cridx_chain_xprevrel.sql
cridx_chain_xnextrel.sql
cridx_clrdep_xrel.sql
cridx_clrsubdep1_xcdeltopdep.sql
cridx_clrsubdep1_uname.sql
cridx_clrsubdep2_xcdeldep1.sql
cridx_clrsubdep2_uname.sql
cridx_clrsubdep3_xcdeldep2.sql
cridx_clrsubdep3_uname.sql
cridx_clrtop_xctbl.sql
cridx_clrtopdep_uname.sql
cridx_cluster_xufdname.sql
cridx_cluster_xudescr.sql
cridx_datascope_xuname.sql
cridx_dtcol_xtable.sql
cridx_dttyp_xschemadef.sql
cridx_deldep_defschidx.sql
cridx_deldep_xrel.sql
cridx_delsubdep1_xcdeltopdep.sql
cridx_delsubdep1_uname.sql
cridx_delsubdep2_xcdeldep1.sql
cridx_delsubdep2_uname.sql
cridx_delsubdep3_xcdeldep2.sql
cridx_delsubdep3_uname.sql
cridx_deltop_xctbl.sql
cridx_deltop_uname.sql
cridx_domdef_subdomidx.sql
cridx_domdef_unameidx.sql
cridx_bdomdef_tenantidx.sql
cridx_dblcol_xtable.sql
cridx_dbltyp_xschemadef.sql
cridx_enumcol_xtable.sql
cridx_enumtag_xtenant.sql
cridx_enumtag_xenum.sql
cridx_enumtag_defschidx.sql
cridx_enumtag_uenumnm.sql
cridx_enumtag_xprev.sql
cridx_enumtag_xnext.sql
cridx_enumtyp_xschemadef.sql
cridx_fltcol_xtable.sql
cridx_flttyp_xschemadef.sql
cridx_hostnode_xcluster.sql
cridx_hostnode_xudsc.sql
cridx_hostnode_xhnm.sql
cridx_isocountry_xcode.sql
cridx_isocountry_xuname.sql
cridx_isocountryccy_xcountry.sql
cridx_isocountryccy_xccy.sql
cridx_isocountrylang_xcountry.sql
cridx_isocountrylang_xlang.sql
cridx_isocurrency_xcode.sql
cridx_isocurrency_xuname.sql
cridx_isolang_xbase.sql
cridx_isolang_xcntry.sql
cridx_isolang_xcode.sql
cridx_itz_xoffset.sql
cridx_itz_xuname.sql
cridx_itz_xiso.sql
cridx_idg16_dpk_def.sql
cridx_idg32_dpk_def.sql
cridx_idg64_dpk_def.sql
cridx_idxdef_xuname.sql
cridx_idxdef_tenantidx.sql
cridx_idxdef_tableidx.sql
cridx_index_defschidx.sql
cridx_idxcol_xuname.sql
cridx_idxcol_tenantidx.sql
cridx_idxcol_indexidx.sql
cridx_idxcol_defschidx.sql
cridx_idxcol_col_def.sql
cridx_idxcol_xprev.sql
cridx_idxcol_xnext.sql
cridx_idxcol_xidxprev.sql
cridx_idxcol_xidxnext.sql
cridx_int16col_xtable.sql
cridx_int16typ_xschemadef.sql
cridx_int32col_xtable.sql
cridx_int32typ_xschemadef.sql
cridx_int64col_xtable.sql
cridx_int64typ_xschemadef.sql
cridx_lic_xtenant.sql
cridx_lic_xdom.sql
cridx_lic_xuname.sql
cridx_loadbehav_xuname.sql
cridx_mjverdef_pprjidx.sql
cridx_mjverdef_unameidx.sql
cridx_mimetype_xuname.sql
cridx_mnverdef_majoridx.sql
cridx_mnverdef_unameidx.sql
cridx_nmtkncol_xtable.sql
cridx_nmtkntyp_xschemadef.sql
cridx_nmtknscol_xtable.sql
cridx_nmtknstyp_xschemadef.sql
cridx_numcol_xtable.sql
cridx_numtyp_xschemadef.sql
cridx_srvprm_xuname.sql
cridx_srvprm_tenantidx.sql
cridx_srvprm_srvmethk.sql
cridx_srvprm_defschidx.sql
cridx_srvprm_typek.sql
cridx_srvprm_xprev.sql
cridx_srvprm_xnext.sql
cridx_srvprm_xcontprev.sql
cridx_srvprm_xcontnext.sql
cridx_popdep_xrel.sql
cridx_popdep_defschidx.sql
cridx_popsubdep1_xcpoptopdep.sql
cridx_popsubdep1_uname.sql
cridx_popsubdep2_xcpopdep1.sql
cridx_popsubdep2_uname.sql
cridx_popsubdep3_xcpopdep2.sql
cridx_popsubdep3_uname.sql
cridx_poptop_xcrel.sql
cridx_poptop_uname.sql
cridx_reldef_xuname.sql
cridx_reldef_tenantidx.sql
cridx_reldef_tableidx.sql
cridx_reldef_defschidx.sql
cridx_reldef_xrtypekey.sql
cridx_reldef_xfromkey.sql
cridx_reldef_xtotbl.sql
cridx_reldef_xtokey.sql
cridx_reldef_xnarrowed.sql
cridx_relcol_xuname.sql
cridx_relcol_tenantidx.sql
cridx_relcol_relk.sql
cridx_relcol_defschidx.sql
cridx_relcol_fromk.sql
cridx_relcol_tok.sql
cridx_relcol_xprev.sql
cridx_relcol_xnext.sql
cridx_relcol_xrelprev.sql
cridx_relcol_xrelnext.sql
cridx_rel_type_utagidx.sql
cridx_schemadef_ctenantidx.sql
cridx_schemadef_domainidx.sql
cridx_schemadef_xuname.sql
cridx_schemadef_xdeflcn.sql
cridx_schemadef_xdatascope.sql
cridx_schemadef_xviewaccsec.sql
cridx_schemadef_xviewaccfreq.sql
cridx_schemadef_xeditaccsec.sql
cridx_schemadef_xeditaccfreq.sql
cridx_schemadef_xupuburi.sql
cridx_schemaref_schk.sql
cridx_schemaref_uname.sql
cridx_schemaref_rsck.sql
cridx_scopedef_tenantidx.sql
cridx_secapp_xcluster.sql
cridx_secapp_xujeemnt.sql
cridx_secdev_usridx.sql
cridx_secform_xcluster.sql
cridx_secform_xsecapp.sql
cridx_secform_xujeesvlt.sql
cridx_secgroup_xcluster.sql
cridx_secgroup_xuname.sql
cridx_secgroupform_xcluster.sql
cridx_secgroupform_xgroup.sql
cridx_secgroupform_xapp.sql
cridx_secgroupform_xform.sql
cridx_secgroupform_xuform.sql
cridx_secinclude_xcluster.sql
cridx_secinclude_xgroup.sql
cridx_secinclude_xinc.sql
cridx_secinclude_xuinc.sql
cridx_secmember_xcluster.sql
cridx_secmember_xgroup.sql
cridx_secmember_xuser.sql
cridx_secmember_xuuser.sql
cridx_session_xsecuser.sql
cridx_session_xsecdev.sql
cridx_session_xstart.sql
cridx_session_xfnsh.sql
cridx_session_xproxy.sql
cridx_secuser_xulogin.sql
cridx_secuser_xemconf.sql
cridx_secuser_xpwdrst.sql
cridx_secuser_defdevidx.sql
cridx_secscope_xuname.sql
cridx_srvlfunc_rettblk.sql
cridx_srvmeth_xuname.sql
cridx_srvmeth_tableidx.sql
cridx_srvmeth_defschidx.sql
cridx_srvofunc_rettblk.sql
cridx_service_xcluster.sql
cridx_service_xhost.sql
cridx_service_xtype.sql
cridx_service_xutype.sql
cridx_service_xuhpt.sql
cridx_servicetype_xudsc.sql
cridx_strcol_xtable.sql
cridx_strtyp_xschemadef.sql
cridx_sprjdef_pprjidx.sql
cridx_sprjdef_unameidx.sql
cridx_sysclus_xclus.sql
cridx_tsecgroup_xtenant.sql
cridx_tsecgroup_xuname.sql
cridx_tsecinclude_xtenant.sql
cridx_tsecinclude_xgroup.sql
cridx_tsecinclude_xinc.sql
cridx_tsecinclude_xuinc.sql
cridx_tsecmember_xtenant.sql
cridx_tsecmember_xgroup.sql
cridx_tsecmember_xuser.sql
cridx_tsecmember_xuuser.sql
cridx_dzcol_xtable.sql
cridx_dztyp_xschemadef.sql
cridx_tmzcol_xtable.sql
cridx_tmztyp_xschemadef.sql
cridx_zscol_xtable.sql
cridx_zstyp_xschemadef.sql
cridx_tbldef_schemaidx.sql
cridx_tbldef_defschidx.sql
cridx_table_xuname.sql
cridx_tabledef_xscd.sql
cridx_def_tbl_xpidx.sql
cridx_def_tbl_xlookupidx.sql
cridx_def_tbl_xaltidx.sql
cridx_def_tbl_xqtblidx.sql
cridx_tabledef_xloadbehave.sql
cridx_tabledef_xdatascope.sql
cridx_tabledef_xsecscope.sql
cridx_tabledef_xviewaccsec.sql
cridx_tabledef_xviewaccfreq.sql
cridx_tabledef_xeditaccsec.sql
cridx_tabledef_xeditaccfreq.sql
cridx_tblcol_xtable.sql
cridx_tablecol_xdata.sql
cridx_tenant_xcluster.sql
cridx_tenant_xuname.sql
cridx_txtcol_xtable.sql
cridx_txttyp_xschemadef.sql
cridx_tmcol_xtable.sql
cridx_tmtyp_xschemadef.sql
cridx_tscol_xtable.sql
cridx_tstyp_xschemadef.sql
cridx_tlddef_tenantidx.sql
cridx_tlddef_unameidx.sql
cridx_tkncol_xtable.sql
cridx_tkntyp_xschemadef.sql
cridx_tdomdef_tldidx.sql
cridx_tdomdef_unameidx.sql
cridx_tprjdef_domidx.sql
cridx_tprjdef_unameidx.sql
cridx_uint16col_xtable.sql
cridx_uint16typ_xschemadef.sql
cridx_uint32col_xtable.sql
cridx_uint32typ_xschemadef.sql
cridx_uint64col_xtable.sql
cridx_uint64typ_xschemadef.sql
cridx_urlproto_xuname.sql
cridx_urlproto_xsecure.sql
cridx_uuidcol_xtable.sql
cridx_idguuid_dpk_def.sql
cridx_uuidtyp_xschemadef.sql
cridx_valdef_xuname.sql
cridx_valdef_tenantidx.sql
cridx_valdef_scopeidx.sql
cridx_value_defschidx.sql
cridx_valuedef_xdatascope.sql
cridx_valuedef_xviewaccsec.sql
cridx_valuedef_xviewaccfreq.sql
cridx_valuedef_xeditaccsec.sql
cridx_valuedef_xeditaccfreq.sql
cridx_valuedef_xprev.sql
cridx_valuedef_xnext.sql
cridx_valuedef_xcontprev.sql
cridx_valuedef_xcontnext.sql
	The individual table index creation scripts called by cridx_cfbam23.sql.




Database Drop Scripts
---------------------

drdb_cfbam23.sql
	Drops the id generators, tables, indexes and constraints
	of the database.

dridg_cfbam23.sql
	Drops the database id generator objects.

drtbl_cfbam23.sql
	Drops the database tables.

dridx_cfbam23.sql
	Drops the database table indexes.

drrel_cfbam23.sql
	Drops the relationships between the tables.


