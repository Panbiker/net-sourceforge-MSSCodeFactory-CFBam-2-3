# **********************************************************************
#
#	package dbcreate;
#	@(#) dbcreate/cfbam/mysql/readme.txt
#
#	CFBam
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




You will find a number of script files in this directory,
all of which are intended to be executed using psql
to install a CFBam23 database.

Each of the *.ksh scripts accepts the following arguments
unless otherwise noted:

	-U username	The admin login name for the server (postgres).
	-P password	The admin password for logging in.
	-L logfile	Where to write the log messages.



Database Creation Scripts
-------------------------

crdatabase_cfbam23.pgsql
	Creates the database cfbam23 in the cfbam23_data1
	tablespace.

crdb_cfbam23.ksh
	The master script for creating the database schema.

cridg_cfbam23.pgsql
	Creates the database id generator objects.

crtbl_cfbam23.ksh
	Creates the database tables.

cridx_cfbam23.pgsql
	Creates the database table indexes.

crrel_cfbam23.pgsql
	Creates the relationships between the tables.

crtbl_accfreq.mysql
crtbl_accsec.mysql
crtbl_atomdef.mysql
crtbl_auditaction.mysql
crtbl_blbcol.mysql
crtbl_blbdef.mysql
crtbl_blbtyp.mysql
crtbl_boolcol.mysql
crtbl_booldef.mysql
crtbl_booltyp.mysql
crtbl_chain_def.mysql
crtbl_clr_dep.mysql
crtbl_clrsubdep1.mysql
crtbl_clrsubdep2.mysql
crtbl_clrsubdep3.mysql
crtbl_clr_topdep.mysql
crtbl_clus.mysql
crtbl_datascope.mysql
crtbl_dtcol.mysql
crtbl_dtdef.mysql
crtbl_dttyp.mysql
crtbl_del_dep.mysql
crtbl_delsubdep1.mysql
crtbl_delsubdep2.mysql
crtbl_delsubdep3.mysql
crtbl_del_topdep.mysql
crtbl_domdef.mysql
crtbl_bdomdef.mysql
crtbl_dblcol.mysql
crtbl_dbldef.mysql
crtbl_dbltyp.mysql
crtbl_enumcol.mysql
crtbl_enumdef.mysql
crtbl_enum_tag.mysql
crtbl_enumtyp.mysql
crtbl_fltcol.mysql
crtbl_fltdef.mysql
crtbl_flttyp.mysql
crtbl_hostnode.mysql
crtbl_iso_cntry.mysql
crtbl_iso_cntryccy.mysql
crtbl_iso_cntrylng.mysql
crtbl_iso_ccy.mysql
crtbl_iso_lang.mysql
crtbl_isotz.mysql
crtbl_idg16.mysql
crtbl_idg32.mysql
crtbl_idg64.mysql
crtbl_idxdef.mysql
crtbl_idxcol.mysql
crtbl_int16col.mysql
crtbl_int16def.mysql
crtbl_int16typ.mysql
crtbl_int32col.mysql
crtbl_int32def.mysql
crtbl_int32typ.mysql
crtbl_int64col.mysql
crtbl_int64def.mysql
crtbl_int64typ.mysql
crtbl_licn.mysql
crtbl_loadbehav.mysql
crtbl_mjverdef.mysql
crtbl_mimetype.mysql
crtbl_mnverdef.mysql
crtbl_nmtkncol.mysql
crtbl_nmtkndef.mysql
crtbl_nmtkntyp.mysql
crtbl_nmtknscol.mysql
crtbl_nmtknsdef.mysql
crtbl_nmtknstyp.mysql
crtbl_numcol.mysql
crtbl_numdef.mysql
crtbl_numtyp.mysql
crtbl_srvprm.mysql
crtbl_pop_dep.mysql
crtbl_popsubdep1.mysql
crtbl_popsubdep2.mysql
crtbl_popsubdep3.mysql
crtbl_pop_topdep.mysql
crtbl_bprjdef.mysql
crtbl_rprjdef.mysql
crtbl_reldef.mysql
crtbl_relcol.mysql
crtbl_rel_type.mysql
crtbl_schemadef.mysql
crtbl_schema_ref.mysql
crtbl_scopedef.mysql
crtbl_secapp.mysql
crtbl_secdev.mysql
crtbl_secform.mysql
crtbl_secgrp.mysql
crtbl_secgrpfrm.mysql
crtbl_secinc.mysql
crtbl_secmemb.mysql
crtbl_secsess.mysql
crtbl_secuser.mysql
crtbl_secscope.mysql
crtbl_srvlfunc.mysql
crtbl_srvmeth.mysql
crtbl_srvofunc.mysql
crtbl_srvprc.mysql
crtbl_hostsvc.mysql
crtbl_svctype.mysql
crtbl_strcol.mysql
crtbl_strdef.mysql
crtbl_strtyp.mysql
crtbl_sprjdef.mysql
crtbl_sysclus.mysql
crtbl_tsecgrp.mysql
crtbl_tsecinc.mysql
crtbl_tsecmemb.mysql
crtbl_dzcol.mysql
crtbl_dzdef.mysql
crtbl_dztyp.mysql
crtbl_tmzcol.mysql
crtbl_tmzdef.mysql
crtbl_tmztyp.mysql
crtbl_zscol.mysql
crtbl_zsdef.mysql
crtbl_zstyp.mysql
crtbl_tbldef.mysql
crtbl_tblcol.mysql
crtbl_tenant.mysql
crtbl_txtcol.mysql
crtbl_txtdef.mysql
crtbl_txttyp.mysql
crtbl_tmcol.mysql
crtbl_tmdef.mysql
crtbl_tmtyp.mysql
crtbl_tscol.mysql
crtbl_tsdef.mysql
crtbl_tstyp.mysql
crtbl_tlddef.mysql
crtbl_tkncol.mysql
crtbl_tkndef.mysql
crtbl_tkntyp.mysql
crtbl_tdomdef.mysql
crtbl_tprjdef.mysql
crtbl_uint16col.mysql
crtbl_u16def.mysql
crtbl_uint16typ.mysql
crtbl_uint32col.mysql
crtbl_u32def.mysql
crtbl_uint32typ.mysql
crtbl_uint64col.mysql
crtbl_u64def.mysql
crtbl_uint64typ.mysql
crtbl_urlproto.mysql
crtbl_uuidcol.mysql
crtbl_uuiddef.mysql
crtbl_idguuid.mysql
crtbl_uuidtyp.mysql
crtbl_valdef.mysql
crtbl_verndef.mysql
	The individual table creation scripts called by crtbl_cfbam23.pgsql.

cridx_accfreq_xuname.mysql
cridx_accsec_xuname.mysql
cridx_auditaction_xudsc.mysql
cridx_blbcol_xtable.mysql
cridx_blbtyp_xschemadef.mysql
cridx_boolcol_xtable.mysql
cridx_booltyp_xschemadef.mysql
cridx_chain_xtent.mysql
cridx_chain_xtbl.mysql
cridx_chain_defschidx.mysql
cridx_chain_xuname.mysql
cridx_chain_xprevrel.mysql
cridx_chain_xnextrel.mysql
cridx_clrdep_xrel.mysql
cridx_clrsubdep1_xcdeltopdep.mysql
cridx_clrsubdep1_uname.mysql
cridx_clrsubdep2_xcdeldep1.mysql
cridx_clrsubdep2_uname.mysql
cridx_clrsubdep3_xcdeldep2.mysql
cridx_clrsubdep3_uname.mysql
cridx_clrtop_xctbl.mysql
cridx_clrtopdep_uname.mysql
cridx_cluster_xufdname.mysql
cridx_cluster_xudescr.mysql
cridx_datascope_xuname.mysql
cridx_dtcol_xtable.mysql
cridx_dttyp_xschemadef.mysql
cridx_deldep_defschidx.mysql
cridx_deldep_xrel.mysql
cridx_delsubdep1_xcdeltopdep.mysql
cridx_delsubdep1_uname.mysql
cridx_delsubdep2_xcdeldep1.mysql
cridx_delsubdep2_uname.mysql
cridx_delsubdep3_xcdeldep2.mysql
cridx_delsubdep3_uname.mysql
cridx_deltop_xctbl.mysql
cridx_deltop_uname.mysql
cridx_domdef_subdomidx.mysql
cridx_domdef_unameidx.mysql
cridx_bdomdef_tenantidx.mysql
cridx_dblcol_xtable.mysql
cridx_dbltyp_xschemadef.mysql
cridx_enumcol_xtable.mysql
cridx_enumtag_xtenant.mysql
cridx_enumtag_xenum.mysql
cridx_enumtag_defschidx.mysql
cridx_enumtag_uenumnm.mysql
cridx_enumtag_xprev.mysql
cridx_enumtag_xnext.mysql
cridx_enumtyp_xschemadef.mysql
cridx_fltcol_xtable.mysql
cridx_flttyp_xschemadef.mysql
cridx_hostnode_xcluster.mysql
cridx_hostnode_xudsc.mysql
cridx_hostnode_xhnm.mysql
cridx_isocountry_xcode.mysql
cridx_isocountry_xuname.mysql
cridx_isocountryccy_xcountry.mysql
cridx_isocountryccy_xccy.mysql
cridx_isocountrylang_xcountry.mysql
cridx_isocountrylang_xlang.mysql
cridx_isocurrency_xcode.mysql
cridx_isocurrency_xuname.mysql
cridx_isolang_xbase.mysql
cridx_isolang_xcntry.mysql
cridx_isolang_xcode.mysql
cridx_itz_xoffset.mysql
cridx_itz_xuname.mysql
cridx_itz_xiso.mysql
cridx_idg16_dpk_def.mysql
cridx_idg32_dpk_def.mysql
cridx_idg64_dpk_def.mysql
cridx_idxdef_xuname.mysql
cridx_idxdef_tenantidx.mysql
cridx_idxdef_tableidx.mysql
cridx_index_defschidx.mysql
cridx_idxcol_xuname.mysql
cridx_idxcol_tenantidx.mysql
cridx_idxcol_indexidx.mysql
cridx_idxcol_defschidx.mysql
cridx_idxcol_col_def.mysql
cridx_idxcol_xprev.mysql
cridx_idxcol_xnext.mysql
cridx_idxcol_xidxprev.mysql
cridx_idxcol_xidxnext.mysql
cridx_int16col_xtable.mysql
cridx_int16typ_xschemadef.mysql
cridx_int32col_xtable.mysql
cridx_int32typ_xschemadef.mysql
cridx_int64col_xtable.mysql
cridx_int64typ_xschemadef.mysql
cridx_lic_xtenant.mysql
cridx_lic_xdom.mysql
cridx_lic_xuname.mysql
cridx_loadbehav_xuname.mysql
cridx_mjverdef_pprjidx.mysql
cridx_mjverdef_unameidx.mysql
cridx_mimetype_xuname.mysql
cridx_mnverdef_majoridx.mysql
cridx_mnverdef_unameidx.mysql
cridx_nmtkncol_xtable.mysql
cridx_nmtkntyp_xschemadef.mysql
cridx_nmtknscol_xtable.mysql
cridx_nmtknstyp_xschemadef.mysql
cridx_numcol_xtable.mysql
cridx_numtyp_xschemadef.mysql
cridx_srvprm_xuname.mysql
cridx_srvprm_tenantidx.mysql
cridx_srvprm_srvmethk.mysql
cridx_srvprm_defschidx.mysql
cridx_srvprm_typek.mysql
cridx_srvprm_xprev.mysql
cridx_srvprm_xnext.mysql
cridx_srvprm_xcontprev.mysql
cridx_srvprm_xcontnext.mysql
cridx_popdep_xrel.mysql
cridx_popdep_defschidx.mysql
cridx_popsubdep1_xcpoptopdep.mysql
cridx_popsubdep1_uname.mysql
cridx_popsubdep2_xcpopdep1.mysql
cridx_popsubdep2_uname.mysql
cridx_popsubdep3_xcpopdep2.mysql
cridx_popsubdep3_uname.mysql
cridx_poptop_xcrel.mysql
cridx_poptop_uname.mysql
cridx_reldef_xuname.mysql
cridx_reldef_tenantidx.mysql
cridx_reldef_tableidx.mysql
cridx_reldef_defschidx.mysql
cridx_reldef_xrtypekey.mysql
cridx_reldef_xfromkey.mysql
cridx_reldef_xtotbl.mysql
cridx_reldef_xtokey.mysql
cridx_reldef_xnarrowed.mysql
cridx_relcol_xuname.mysql
cridx_relcol_tenantidx.mysql
cridx_relcol_relk.mysql
cridx_relcol_defschidx.mysql
cridx_relcol_fromk.mysql
cridx_relcol_tok.mysql
cridx_relcol_xprev.mysql
cridx_relcol_xnext.mysql
cridx_relcol_xrelprev.mysql
cridx_relcol_xrelnext.mysql
cridx_rel_type_utagidx.mysql
cridx_schemadef_ctenantidx.mysql
cridx_schemadef_domainidx.mysql
cridx_schemadef_xuname.mysql
cridx_schemadef_xdeflcn.mysql
cridx_schemadef_xdatascope.mysql
cridx_schemadef_xviewaccsec.mysql
cridx_schemadef_xviewaccfreq.mysql
cridx_schemadef_xeditaccsec.mysql
cridx_schemadef_xeditaccfreq.mysql
cridx_schemadef_xupuburi.mysql
cridx_schemaref_schk.mysql
cridx_schemaref_uname.mysql
cridx_schemaref_rsck.mysql
cridx_scopedef_tenantidx.mysql
cridx_secapp_xcluster.mysql
cridx_secapp_xujeemnt.mysql
cridx_secdev_usridx.mysql
cridx_secform_xcluster.mysql
cridx_secform_xsecapp.mysql
cridx_secform_xujeesvlt.mysql
cridx_secgroup_xcluster.mysql
cridx_secgroup_xuname.mysql
cridx_secgroupform_xcluster.mysql
cridx_secgroupform_xgroup.mysql
cridx_secgroupform_xapp.mysql
cridx_secgroupform_xform.mysql
cridx_secgroupform_xuform.mysql
cridx_secinclude_xcluster.mysql
cridx_secinclude_xgroup.mysql
cridx_secinclude_xinc.mysql
cridx_secinclude_xuinc.mysql
cridx_secmember_xcluster.mysql
cridx_secmember_xgroup.mysql
cridx_secmember_xuser.mysql
cridx_secmember_xuuser.mysql
cridx_session_xsecuser.mysql
cridx_session_xsecdev.mysql
cridx_session_xstart.mysql
cridx_session_xfnsh.mysql
cridx_session_xproxy.mysql
cridx_secuser_xulogin.mysql
cridx_secuser_xemconf.mysql
cridx_secuser_xpwdrst.mysql
cridx_secuser_defdevidx.mysql
cridx_secscope_xuname.mysql
cridx_srvlfunc_rettblk.mysql
cridx_srvmeth_xuname.mysql
cridx_srvmeth_tableidx.mysql
cridx_srvmeth_defschidx.mysql
cridx_srvofunc_rettblk.mysql
cridx_service_xcluster.mysql
cridx_service_xhost.mysql
cridx_service_xtype.mysql
cridx_service_xutype.mysql
cridx_service_xuhpt.mysql
cridx_servicetype_xudsc.mysql
cridx_strcol_xtable.mysql
cridx_strtyp_xschemadef.mysql
cridx_sprjdef_pprjidx.mysql
cridx_sprjdef_unameidx.mysql
cridx_sysclus_xclus.mysql
cridx_tsecgroup_xtenant.mysql
cridx_tsecgroup_xuname.mysql
cridx_tsecinclude_xtenant.mysql
cridx_tsecinclude_xgroup.mysql
cridx_tsecinclude_xinc.mysql
cridx_tsecinclude_xuinc.mysql
cridx_tsecmember_xtenant.mysql
cridx_tsecmember_xgroup.mysql
cridx_tsecmember_xuser.mysql
cridx_tsecmember_xuuser.mysql
cridx_dzcol_xtable.mysql
cridx_dztyp_xschemadef.mysql
cridx_tmzcol_xtable.mysql
cridx_tmztyp_xschemadef.mysql
cridx_zscol_xtable.mysql
cridx_zstyp_xschemadef.mysql
cridx_tbldef_schemaidx.mysql
cridx_tbldef_defschidx.mysql
cridx_table_xuname.mysql
cridx_tabledef_xscd.mysql
cridx_def_tbl_xpidx.mysql
cridx_def_tbl_xlookupidx.mysql
cridx_def_tbl_xaltidx.mysql
cridx_def_tbl_xqtblidx.mysql
cridx_tabledef_xloadbehave.mysql
cridx_tabledef_xdatascope.mysql
cridx_tabledef_xsecscope.mysql
cridx_tabledef_xviewaccsec.mysql
cridx_tabledef_xviewaccfreq.mysql
cridx_tabledef_xeditaccsec.mysql
cridx_tabledef_xeditaccfreq.mysql
cridx_tblcol_xtable.mysql
cridx_tablecol_xdata.mysql
cridx_tenant_xcluster.mysql
cridx_tenant_xuname.mysql
cridx_txtcol_xtable.mysql
cridx_txttyp_xschemadef.mysql
cridx_tmcol_xtable.mysql
cridx_tmtyp_xschemadef.mysql
cridx_tscol_xtable.mysql
cridx_tstyp_xschemadef.mysql
cridx_tlddef_tenantidx.mysql
cridx_tlddef_unameidx.mysql
cridx_tkncol_xtable.mysql
cridx_tkntyp_xschemadef.mysql
cridx_tdomdef_tldidx.mysql
cridx_tdomdef_unameidx.mysql
cridx_tprjdef_domidx.mysql
cridx_tprjdef_unameidx.mysql
cridx_uint16col_xtable.mysql
cridx_uint16typ_xschemadef.mysql
cridx_uint32col_xtable.mysql
cridx_uint32typ_xschemadef.mysql
cridx_uint64col_xtable.mysql
cridx_uint64typ_xschemadef.mysql
cridx_urlproto_xuname.mysql
cridx_urlproto_xsecure.mysql
cridx_uuidcol_xtable.mysql
cridx_idguuid_dpk_def.mysql
cridx_uuidtyp_xschemadef.mysql
cridx_valdef_xuname.mysql
cridx_valdef_tenantidx.mysql
cridx_valdef_scopeidx.mysql
cridx_value_defschidx.mysql
cridx_valuedef_xdatascope.mysql
cridx_valuedef_xviewaccsec.mysql
cridx_valuedef_xviewaccfreq.mysql
cridx_valuedef_xeditaccsec.mysql
cridx_valuedef_xeditaccfreq.mysql
cridx_valuedef_xprev.mysql
cridx_valuedef_xnext.mysql
cridx_valuedef_xcontprev.mysql
cridx_valuedef_xcontnext.mysql
	The individual table index creation scripts called by cridx_cfbam23.pgsql.



Database Drop Scripts
---------------------

drdb_cfbam23.pgsql
	Drops the id generators, tables, indexes and constraints
	of the database.

dridg_cfbam23.pgsql
	Drops the database id generator objects.

drtbl_cfbam23.pgsql
	Drops the database tables.

dridx_cfbam23.pgsql
	Drops the database table indexes.

drrel_cfbam23.pgsql
	Drops the relationships between the tables.


