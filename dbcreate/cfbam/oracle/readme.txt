# **********************************************************************
#
#	package dbcreate;
#	@(#) dbcreate/cfbam/oracle/readme.txt
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

	-S server	The name of the Oracle 11gR2 server to use.
	-U username	The admin login name for the server (postgres).
	-P password	The admin password for logging in.
	-d database	The name of the database to contain the schema.
	-L logfile	Where to write the log messages.

crdb_cfbam23.bash will also create the tablespaces for
the database if you specify:

	-D datadir	The directory for the tablespace.

If you don't specify a directory, it's assumed that the tablespaces
cfbam23_data1 and cfbam23_idx1 already exists.


Database Creation Scripts
-------------------------

crdatabase_cfbam23.plsql
	Creates the database cfbam23 in the cfbam23_data1
	tablespace.  Optionally creates the cfbam23_data1 and
	cfbam23_idx1 tablespaces if "-d dirName" is specified on
	the command line.

crdb_cfbam23.ksh
	The master script for creating the database schema.

cridg_cfbam23.plsql
	Creates the database id generator objects.

crtbl_cfbam23.ksh
	Creates the database tables.

cridx_cfbam23.plsql
	Creates the database table indexes.

crrel_cfbam23.plsql
	Creates the relationships between the tables.

crtbl_accfreq.plsql
crtbl_accsec.plsql
crtbl_atomdef.plsql
crtbl_auditaction.plsql
crtbl_blbcol.plsql
crtbl_blbdef.plsql
crtbl_blbtyp.plsql
crtbl_boolcol.plsql
crtbl_booldef.plsql
crtbl_booltyp.plsql
crtbl_chain_def.plsql
crtbl_clr_dep.plsql
crtbl_clrsubdep1.plsql
crtbl_clrsubdep2.plsql
crtbl_clrsubdep3.plsql
crtbl_clr_topdep.plsql
crtbl_clus.plsql
crtbl_datascope.plsql
crtbl_dtcol.plsql
crtbl_dtdef.plsql
crtbl_dttyp.plsql
crtbl_del_dep.plsql
crtbl_delsubdep1.plsql
crtbl_delsubdep2.plsql
crtbl_delsubdep3.plsql
crtbl_del_topdep.plsql
crtbl_domdef.plsql
crtbl_bdomdef.plsql
crtbl_dblcol.plsql
crtbl_dbldef.plsql
crtbl_dbltyp.plsql
crtbl_enumcol.plsql
crtbl_enumdef.plsql
crtbl_enum_tag.plsql
crtbl_enumtyp.plsql
crtbl_fltcol.plsql
crtbl_fltdef.plsql
crtbl_flttyp.plsql
crtbl_hostnode.plsql
crtbl_iso_cntry.plsql
crtbl_iso_cntryccy.plsql
crtbl_iso_cntrylng.plsql
crtbl_iso_ccy.plsql
crtbl_iso_lang.plsql
crtbl_isotz.plsql
crtbl_idg16.plsql
crtbl_idg32.plsql
crtbl_idg64.plsql
crtbl_idxdef.plsql
crtbl_idxcol.plsql
crtbl_int16col.plsql
crtbl_int16def.plsql
crtbl_int16typ.plsql
crtbl_int32col.plsql
crtbl_int32def.plsql
crtbl_int32typ.plsql
crtbl_int64col.plsql
crtbl_int64def.plsql
crtbl_int64typ.plsql
crtbl_licn.plsql
crtbl_loadbehav.plsql
crtbl_mjverdef.plsql
crtbl_mimetype.plsql
crtbl_mnverdef.plsql
crtbl_nmtkncol.plsql
crtbl_nmtkndef.plsql
crtbl_nmtkntyp.plsql
crtbl_nmtknscol.plsql
crtbl_nmtknsdef.plsql
crtbl_nmtknstyp.plsql
crtbl_numcol.plsql
crtbl_numdef.plsql
crtbl_numtyp.plsql
crtbl_srvprm.plsql
crtbl_pop_dep.plsql
crtbl_popsubdep1.plsql
crtbl_popsubdep2.plsql
crtbl_popsubdep3.plsql
crtbl_pop_topdep.plsql
crtbl_bprjdef.plsql
crtbl_rprjdef.plsql
crtbl_reldef.plsql
crtbl_relcol.plsql
crtbl_rel_type.plsql
crtbl_schemadef.plsql
crtbl_schema_ref.plsql
crtbl_scopedef.plsql
crtbl_secapp.plsql
crtbl_secdev.plsql
crtbl_secform.plsql
crtbl_secgrp.plsql
crtbl_secgrpfrm.plsql
crtbl_secinc.plsql
crtbl_secmemb.plsql
crtbl_secsess.plsql
crtbl_secuser.plsql
crtbl_secscope.plsql
crtbl_srvlfunc.plsql
crtbl_srvmeth.plsql
crtbl_srvofunc.plsql
crtbl_srvprc.plsql
crtbl_hostsvc.plsql
crtbl_svctype.plsql
crtbl_strcol.plsql
crtbl_strdef.plsql
crtbl_strtyp.plsql
crtbl_sprjdef.plsql
crtbl_sysclus.plsql
crtbl_tsecgrp.plsql
crtbl_tsecinc.plsql
crtbl_tsecmemb.plsql
crtbl_dzcol.plsql
crtbl_dzdef.plsql
crtbl_dztyp.plsql
crtbl_tmzcol.plsql
crtbl_tmzdef.plsql
crtbl_tmztyp.plsql
crtbl_zscol.plsql
crtbl_zsdef.plsql
crtbl_zstyp.plsql
crtbl_tbldef.plsql
crtbl_tblcol.plsql
crtbl_tenant.plsql
crtbl_txtcol.plsql
crtbl_txtdef.plsql
crtbl_txttyp.plsql
crtbl_tmcol.plsql
crtbl_tmdef.plsql
crtbl_tmtyp.plsql
crtbl_tscol.plsql
crtbl_tsdef.plsql
crtbl_tstyp.plsql
crtbl_tlddef.plsql
crtbl_tkncol.plsql
crtbl_tkndef.plsql
crtbl_tkntyp.plsql
crtbl_tdomdef.plsql
crtbl_tprjdef.plsql
crtbl_uint16col.plsql
crtbl_u16def.plsql
crtbl_uint16typ.plsql
crtbl_uint32col.plsql
crtbl_u32def.plsql
crtbl_uint32typ.plsql
crtbl_uint64col.plsql
crtbl_u64def.plsql
crtbl_uint64typ.plsql
crtbl_urlproto.plsql
crtbl_uuidcol.plsql
crtbl_uuiddef.plsql
crtbl_idguuid.plsql
crtbl_uuidtyp.plsql
crtbl_valdef.plsql
crtbl_verndef.plsql
	The individual table creation scripts called by crtbl_cfbam23.plsql.

cridx_accfreq_xuname.plsql
cridx_accsec_xuname.plsql
cridx_auditaction_xudsc.plsql
cridx_blbcol_xtable.plsql
cridx_blbtyp_xschemadef.plsql
cridx_boolcol_xtable.plsql
cridx_booltyp_xschemadef.plsql
cridx_chain_xtent.plsql
cridx_chain_xtbl.plsql
cridx_chain_defschidx.plsql
cridx_chain_xuname.plsql
cridx_chain_xprevrel.plsql
cridx_chain_xnextrel.plsql
cridx_clrdep_xrel.plsql
cridx_clrsubdep1_xcdeltopdep.plsql
cridx_clrsubdep1_uname.plsql
cridx_clrsubdep2_xcdeldep1.plsql
cridx_clrsubdep2_uname.plsql
cridx_clrsubdep3_xcdeldep2.plsql
cridx_clrsubdep3_uname.plsql
cridx_clrtop_xctbl.plsql
cridx_clrtopdep_uname.plsql
cridx_cluster_xufdname.plsql
cridx_cluster_xudescr.plsql
cridx_datascope_xuname.plsql
cridx_dtcol_xtable.plsql
cridx_dttyp_xschemadef.plsql
cridx_deldep_defschidx.plsql
cridx_deldep_xrel.plsql
cridx_delsubdep1_xcdeltopdep.plsql
cridx_delsubdep1_uname.plsql
cridx_delsubdep2_xcdeldep1.plsql
cridx_delsubdep2_uname.plsql
cridx_delsubdep3_xcdeldep2.plsql
cridx_delsubdep3_uname.plsql
cridx_deltop_xctbl.plsql
cridx_deltop_uname.plsql
cridx_domdef_subdomidx.plsql
cridx_domdef_unameidx.plsql
cridx_bdomdef_tenantidx.plsql
cridx_dblcol_xtable.plsql
cridx_dbltyp_xschemadef.plsql
cridx_enumcol_xtable.plsql
cridx_enumtag_xtenant.plsql
cridx_enumtag_xenum.plsql
cridx_enumtag_defschidx.plsql
cridx_enumtag_uenumnm.plsql
cridx_enumtag_xprev.plsql
cridx_enumtag_xnext.plsql
cridx_enumtyp_xschemadef.plsql
cridx_fltcol_xtable.plsql
cridx_flttyp_xschemadef.plsql
cridx_hostnode_xcluster.plsql
cridx_hostnode_xudsc.plsql
cridx_hostnode_xhnm.plsql
cridx_isocountry_xcode.plsql
cridx_isocountry_xuname.plsql
cridx_isocountryccy_xcountry.plsql
cridx_isocountryccy_xccy.plsql
cridx_isocountrylang_xcountry.plsql
cridx_isocountrylang_xlang.plsql
cridx_isocurrency_xcode.plsql
cridx_isocurrency_xuname.plsql
cridx_isolang_xbase.plsql
cridx_isolang_xcntry.plsql
cridx_isolang_xcode.plsql
cridx_itz_xoffset.plsql
cridx_itz_xuname.plsql
cridx_itz_xiso.plsql
cridx_idg16_dpk_def.plsql
cridx_idg32_dpk_def.plsql
cridx_idg64_dpk_def.plsql
cridx_idxdef_xuname.plsql
cridx_idxdef_tenantidx.plsql
cridx_idxdef_tableidx.plsql
cridx_index_defschidx.plsql
cridx_idxcol_xuname.plsql
cridx_idxcol_tenantidx.plsql
cridx_idxcol_indexidx.plsql
cridx_idxcol_defschidx.plsql
cridx_idxcol_col_def.plsql
cridx_idxcol_xprev.plsql
cridx_idxcol_xnext.plsql
cridx_idxcol_xidxprev.plsql
cridx_idxcol_xidxnext.plsql
cridx_int16col_xtable.plsql
cridx_int16typ_xschemadef.plsql
cridx_int32col_xtable.plsql
cridx_int32typ_xschemadef.plsql
cridx_int64col_xtable.plsql
cridx_int64typ_xschemadef.plsql
cridx_lic_xtenant.plsql
cridx_lic_xdom.plsql
cridx_lic_xuname.plsql
cridx_loadbehav_xuname.plsql
cridx_mjverdef_pprjidx.plsql
cridx_mjverdef_unameidx.plsql
cridx_mimetype_xuname.plsql
cridx_mnverdef_majoridx.plsql
cridx_mnverdef_unameidx.plsql
cridx_nmtkncol_xtable.plsql
cridx_nmtkntyp_xschemadef.plsql
cridx_nmtknscol_xtable.plsql
cridx_nmtknstyp_xschemadef.plsql
cridx_numcol_xtable.plsql
cridx_numtyp_xschemadef.plsql
cridx_srvprm_xuname.plsql
cridx_srvprm_tenantidx.plsql
cridx_srvprm_srvmethk.plsql
cridx_srvprm_defschidx.plsql
cridx_srvprm_typek.plsql
cridx_srvprm_xprev.plsql
cridx_srvprm_xnext.plsql
cridx_srvprm_xcontprev.plsql
cridx_srvprm_xcontnext.plsql
cridx_popdep_xrel.plsql
cridx_popdep_defschidx.plsql
cridx_popsubdep1_xcpoptopdep.plsql
cridx_popsubdep1_uname.plsql
cridx_popsubdep2_xcpopdep1.plsql
cridx_popsubdep2_uname.plsql
cridx_popsubdep3_xcpopdep2.plsql
cridx_popsubdep3_uname.plsql
cridx_poptop_xcrel.plsql
cridx_poptop_uname.plsql
cridx_reldef_xuname.plsql
cridx_reldef_tenantidx.plsql
cridx_reldef_tableidx.plsql
cridx_reldef_defschidx.plsql
cridx_reldef_xrtypekey.plsql
cridx_reldef_xfromkey.plsql
cridx_reldef_xtotbl.plsql
cridx_reldef_xtokey.plsql
cridx_reldef_xnarrowed.plsql
cridx_relcol_xuname.plsql
cridx_relcol_tenantidx.plsql
cridx_relcol_relk.plsql
cridx_relcol_defschidx.plsql
cridx_relcol_fromk.plsql
cridx_relcol_tok.plsql
cridx_relcol_xprev.plsql
cridx_relcol_xnext.plsql
cridx_relcol_xrelprev.plsql
cridx_relcol_xrelnext.plsql
cridx_rel_type_utagidx.plsql
cridx_schemadef_ctenantidx.plsql
cridx_schemadef_domainidx.plsql
cridx_schemadef_xuname.plsql
cridx_schemadef_xdeflcn.plsql
cridx_schemadef_xdatascope.plsql
cridx_schemadef_xviewaccsec.plsql
cridx_schemadef_xviewaccfreq.plsql
cridx_schemadef_xeditaccsec.plsql
cridx_schemadef_xeditaccfreq.plsql
cridx_schemadef_xupuburi.plsql
cridx_schemaref_schk.plsql
cridx_schemaref_uname.plsql
cridx_schemaref_rsck.plsql
cridx_scopedef_tenantidx.plsql
cridx_secapp_xcluster.plsql
cridx_secapp_xujeemnt.plsql
cridx_secdev_usridx.plsql
cridx_secform_xcluster.plsql
cridx_secform_xsecapp.plsql
cridx_secform_xujeesvlt.plsql
cridx_secgroup_xcluster.plsql
cridx_secgroup_xuname.plsql
cridx_secgroupform_xcluster.plsql
cridx_secgroupform_xgroup.plsql
cridx_secgroupform_xapp.plsql
cridx_secgroupform_xform.plsql
cridx_secgroupform_xuform.plsql
cridx_secinclude_xcluster.plsql
cridx_secinclude_xgroup.plsql
cridx_secinclude_xinc.plsql
cridx_secinclude_xuinc.plsql
cridx_secmember_xcluster.plsql
cridx_secmember_xgroup.plsql
cridx_secmember_xuser.plsql
cridx_secmember_xuuser.plsql
cridx_session_xsecuser.plsql
cridx_session_xsecdev.plsql
cridx_session_xstart.plsql
cridx_session_xfnsh.plsql
cridx_session_xproxy.plsql
cridx_secuser_xulogin.plsql
cridx_secuser_xemconf.plsql
cridx_secuser_xpwdrst.plsql
cridx_secuser_defdevidx.plsql
cridx_secscope_xuname.plsql
cridx_srvlfunc_rettblk.plsql
cridx_srvmeth_xuname.plsql
cridx_srvmeth_tableidx.plsql
cridx_srvmeth_defschidx.plsql
cridx_srvofunc_rettblk.plsql
cridx_service_xcluster.plsql
cridx_service_xhost.plsql
cridx_service_xtype.plsql
cridx_service_xutype.plsql
cridx_service_xuhpt.plsql
cridx_servicetype_xudsc.plsql
cridx_strcol_xtable.plsql
cridx_strtyp_xschemadef.plsql
cridx_sprjdef_pprjidx.plsql
cridx_sprjdef_unameidx.plsql
cridx_sysclus_xclus.plsql
cridx_tsecgroup_xtenant.plsql
cridx_tsecgroup_xuname.plsql
cridx_tsecinclude_xtenant.plsql
cridx_tsecinclude_xgroup.plsql
cridx_tsecinclude_xinc.plsql
cridx_tsecinclude_xuinc.plsql
cridx_tsecmember_xtenant.plsql
cridx_tsecmember_xgroup.plsql
cridx_tsecmember_xuser.plsql
cridx_tsecmember_xuuser.plsql
cridx_dzcol_xtable.plsql
cridx_dztyp_xschemadef.plsql
cridx_tmzcol_xtable.plsql
cridx_tmztyp_xschemadef.plsql
cridx_zscol_xtable.plsql
cridx_zstyp_xschemadef.plsql
cridx_tbldef_schemaidx.plsql
cridx_tbldef_defschidx.plsql
cridx_table_xuname.plsql
cridx_tabledef_xscd.plsql
cridx_def_tbl_xpidx.plsql
cridx_def_tbl_xlookupidx.plsql
cridx_def_tbl_xaltidx.plsql
cridx_def_tbl_xqtblidx.plsql
cridx_tabledef_xloadbehave.plsql
cridx_tabledef_xdatascope.plsql
cridx_tabledef_xsecscope.plsql
cridx_tabledef_xviewaccsec.plsql
cridx_tabledef_xviewaccfreq.plsql
cridx_tabledef_xeditaccsec.plsql
cridx_tabledef_xeditaccfreq.plsql
cridx_tblcol_xtable.plsql
cridx_tablecol_xdata.plsql
cridx_tenant_xcluster.plsql
cridx_tenant_xuname.plsql
cridx_txtcol_xtable.plsql
cridx_txttyp_xschemadef.plsql
cridx_tmcol_xtable.plsql
cridx_tmtyp_xschemadef.plsql
cridx_tscol_xtable.plsql
cridx_tstyp_xschemadef.plsql
cridx_tlddef_tenantidx.plsql
cridx_tlddef_unameidx.plsql
cridx_tkncol_xtable.plsql
cridx_tkntyp_xschemadef.plsql
cridx_tdomdef_tldidx.plsql
cridx_tdomdef_unameidx.plsql
cridx_tprjdef_domidx.plsql
cridx_tprjdef_unameidx.plsql
cridx_uint16col_xtable.plsql
cridx_uint16typ_xschemadef.plsql
cridx_uint32col_xtable.plsql
cridx_uint32typ_xschemadef.plsql
cridx_uint64col_xtable.plsql
cridx_uint64typ_xschemadef.plsql
cridx_urlproto_xuname.plsql
cridx_urlproto_xsecure.plsql
cridx_uuidcol_xtable.plsql
cridx_idguuid_dpk_def.plsql
cridx_uuidtyp_xschemadef.plsql
cridx_valdef_xuname.plsql
cridx_valdef_tenantidx.plsql
cridx_valdef_scopeidx.plsql
cridx_value_defschidx.plsql
cridx_valuedef_xdatascope.plsql
cridx_valuedef_xviewaccsec.plsql
cridx_valuedef_xviewaccfreq.plsql
cridx_valuedef_xeditaccsec.plsql
cridx_valuedef_xeditaccfreq.plsql
cridx_valuedef_xprev.plsql
cridx_valuedef_xnext.plsql
cridx_valuedef_xcontprev.plsql
cridx_valuedef_xcontnext.plsql
	The individual table index creation scripts called by cridx_cfbam23.plsql.

