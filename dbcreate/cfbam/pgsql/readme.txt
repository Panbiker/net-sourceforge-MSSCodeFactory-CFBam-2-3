# **********************************************************************
#
#	package dbcreate;
#	@(#) dbcreate/cfbam/pgsql/readme.txt
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

	-S server	The name of the PostgreSQL 8 server to use.
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

crdatabase_cfbam23.pgsql
	Creates the database cfbam23 in the cfbam23_data1
	tablespace.  Optionally creates the cfbam23_data1 and
	cfbam23_idx1 tablespaces if "-d dirName" is specified on
	the command line.

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

crtbl_accfreq.pgsql
crtbl_accsec.pgsql
crtbl_atomdef.pgsql
crtbl_auditaction.pgsql
crtbl_blbcol.pgsql
crtbl_blbdef.pgsql
crtbl_blbtyp.pgsql
crtbl_boolcol.pgsql
crtbl_booldef.pgsql
crtbl_booltyp.pgsql
crtbl_chain_def.pgsql
crtbl_clr_dep.pgsql
crtbl_clrsubdep1.pgsql
crtbl_clrsubdep2.pgsql
crtbl_clrsubdep3.pgsql
crtbl_clr_topdep.pgsql
crtbl_clus.pgsql
crtbl_datascope.pgsql
crtbl_dtcol.pgsql
crtbl_dtdef.pgsql
crtbl_dttyp.pgsql
crtbl_del_dep.pgsql
crtbl_delsubdep1.pgsql
crtbl_delsubdep2.pgsql
crtbl_delsubdep3.pgsql
crtbl_del_topdep.pgsql
crtbl_domdef.pgsql
crtbl_bdomdef.pgsql
crtbl_dblcol.pgsql
crtbl_dbldef.pgsql
crtbl_dbltyp.pgsql
crtbl_enumcol.pgsql
crtbl_enumdef.pgsql
crtbl_enum_tag.pgsql
crtbl_enumtyp.pgsql
crtbl_fltcol.pgsql
crtbl_fltdef.pgsql
crtbl_flttyp.pgsql
crtbl_hostnode.pgsql
crtbl_iso_cntry.pgsql
crtbl_iso_cntryccy.pgsql
crtbl_iso_cntrylng.pgsql
crtbl_iso_ccy.pgsql
crtbl_iso_lang.pgsql
crtbl_isotz.pgsql
crtbl_idg16.pgsql
crtbl_idg32.pgsql
crtbl_idg64.pgsql
crtbl_idxdef.pgsql
crtbl_idxcol.pgsql
crtbl_int16col.pgsql
crtbl_int16def.pgsql
crtbl_int16typ.pgsql
crtbl_int32col.pgsql
crtbl_int32def.pgsql
crtbl_int32typ.pgsql
crtbl_int64col.pgsql
crtbl_int64def.pgsql
crtbl_int64typ.pgsql
crtbl_licn.pgsql
crtbl_loadbehav.pgsql
crtbl_mjverdef.pgsql
crtbl_mimetype.pgsql
crtbl_mnverdef.pgsql
crtbl_nmtkncol.pgsql
crtbl_nmtkndef.pgsql
crtbl_nmtkntyp.pgsql
crtbl_nmtknscol.pgsql
crtbl_nmtknsdef.pgsql
crtbl_nmtknstyp.pgsql
crtbl_numcol.pgsql
crtbl_numdef.pgsql
crtbl_numtyp.pgsql
crtbl_srvprm.pgsql
crtbl_pop_dep.pgsql
crtbl_popsubdep1.pgsql
crtbl_popsubdep2.pgsql
crtbl_popsubdep3.pgsql
crtbl_pop_topdep.pgsql
crtbl_bprjdef.pgsql
crtbl_rprjdef.pgsql
crtbl_reldef.pgsql
crtbl_relcol.pgsql
crtbl_rel_type.pgsql
crtbl_schemadef.pgsql
crtbl_schema_ref.pgsql
crtbl_scopedef.pgsql
crtbl_secapp.pgsql
crtbl_secdev.pgsql
crtbl_secform.pgsql
crtbl_secgrp.pgsql
crtbl_secgrpfrm.pgsql
crtbl_secinc.pgsql
crtbl_secmemb.pgsql
crtbl_secsess.pgsql
crtbl_secuser.pgsql
crtbl_secscope.pgsql
crtbl_srvlfunc.pgsql
crtbl_srvmeth.pgsql
crtbl_srvofunc.pgsql
crtbl_srvprc.pgsql
crtbl_hostsvc.pgsql
crtbl_svctype.pgsql
crtbl_strcol.pgsql
crtbl_strdef.pgsql
crtbl_strtyp.pgsql
crtbl_sprjdef.pgsql
crtbl_sysclus.pgsql
crtbl_tsecgrp.pgsql
crtbl_tsecinc.pgsql
crtbl_tsecmemb.pgsql
crtbl_dzcol.pgsql
crtbl_dzdef.pgsql
crtbl_dztyp.pgsql
crtbl_tmzcol.pgsql
crtbl_tmzdef.pgsql
crtbl_tmztyp.pgsql
crtbl_zscol.pgsql
crtbl_zsdef.pgsql
crtbl_zstyp.pgsql
crtbl_tbldef.pgsql
crtbl_tblcol.pgsql
crtbl_tenant.pgsql
crtbl_txtcol.pgsql
crtbl_txtdef.pgsql
crtbl_txttyp.pgsql
crtbl_tmcol.pgsql
crtbl_tmdef.pgsql
crtbl_tmtyp.pgsql
crtbl_tscol.pgsql
crtbl_tsdef.pgsql
crtbl_tstyp.pgsql
crtbl_tlddef.pgsql
crtbl_tkncol.pgsql
crtbl_tkndef.pgsql
crtbl_tkntyp.pgsql
crtbl_tdomdef.pgsql
crtbl_tprjdef.pgsql
crtbl_uint16col.pgsql
crtbl_u16def.pgsql
crtbl_uint16typ.pgsql
crtbl_uint32col.pgsql
crtbl_u32def.pgsql
crtbl_uint32typ.pgsql
crtbl_uint64col.pgsql
crtbl_u64def.pgsql
crtbl_uint64typ.pgsql
crtbl_urlproto.pgsql
crtbl_uuidcol.pgsql
crtbl_uuiddef.pgsql
crtbl_idguuid.pgsql
crtbl_uuidtyp.pgsql
crtbl_valdef.pgsql
crtbl_verndef.pgsql
	The individual table creation scripts called by crtbl_cfbam23.pgsql.

cridx_accfreq_xuname.pgsql
cridx_accsec_xuname.pgsql
cridx_auditaction_xudsc.pgsql
cridx_blbcol_xtable.pgsql
cridx_blbtyp_xschemadef.pgsql
cridx_boolcol_xtable.pgsql
cridx_booltyp_xschemadef.pgsql
cridx_chain_xtent.pgsql
cridx_chain_xtbl.pgsql
cridx_chain_defschidx.pgsql
cridx_chain_xuname.pgsql
cridx_chain_xprevrel.pgsql
cridx_chain_xnextrel.pgsql
cridx_clrdep_xrel.pgsql
cridx_clrsubdep1_xcdeltopdep.pgsql
cridx_clrsubdep1_uname.pgsql
cridx_clrsubdep2_xcdeldep1.pgsql
cridx_clrsubdep2_uname.pgsql
cridx_clrsubdep3_xcdeldep2.pgsql
cridx_clrsubdep3_uname.pgsql
cridx_clrtop_xctbl.pgsql
cridx_clrtopdep_uname.pgsql
cridx_cluster_xufdname.pgsql
cridx_cluster_xudescr.pgsql
cridx_datascope_xuname.pgsql
cridx_dtcol_xtable.pgsql
cridx_dttyp_xschemadef.pgsql
cridx_deldep_defschidx.pgsql
cridx_deldep_xrel.pgsql
cridx_delsubdep1_xcdeltopdep.pgsql
cridx_delsubdep1_uname.pgsql
cridx_delsubdep2_xcdeldep1.pgsql
cridx_delsubdep2_uname.pgsql
cridx_delsubdep3_xcdeldep2.pgsql
cridx_delsubdep3_uname.pgsql
cridx_deltop_xctbl.pgsql
cridx_deltop_uname.pgsql
cridx_domdef_subdomidx.pgsql
cridx_domdef_unameidx.pgsql
cridx_bdomdef_tenantidx.pgsql
cridx_dblcol_xtable.pgsql
cridx_dbltyp_xschemadef.pgsql
cridx_enumcol_xtable.pgsql
cridx_enumtag_xtenant.pgsql
cridx_enumtag_xenum.pgsql
cridx_enumtag_defschidx.pgsql
cridx_enumtag_uenumnm.pgsql
cridx_enumtag_xprev.pgsql
cridx_enumtag_xnext.pgsql
cridx_enumtyp_xschemadef.pgsql
cridx_fltcol_xtable.pgsql
cridx_flttyp_xschemadef.pgsql
cridx_hostnode_xcluster.pgsql
cridx_hostnode_xudsc.pgsql
cridx_hostnode_xhnm.pgsql
cridx_isocountry_xcode.pgsql
cridx_isocountry_xuname.pgsql
cridx_isocountryccy_xcountry.pgsql
cridx_isocountryccy_xccy.pgsql
cridx_isocountrylang_xcountry.pgsql
cridx_isocountrylang_xlang.pgsql
cridx_isocurrency_xcode.pgsql
cridx_isocurrency_xuname.pgsql
cridx_isolang_xbase.pgsql
cridx_isolang_xcntry.pgsql
cridx_isolang_xcode.pgsql
cridx_itz_xoffset.pgsql
cridx_itz_xuname.pgsql
cridx_itz_xiso.pgsql
cridx_idg16_dpk_def.pgsql
cridx_idg32_dpk_def.pgsql
cridx_idg64_dpk_def.pgsql
cridx_idxdef_xuname.pgsql
cridx_idxdef_tenantidx.pgsql
cridx_idxdef_tableidx.pgsql
cridx_index_defschidx.pgsql
cridx_idxcol_xuname.pgsql
cridx_idxcol_tenantidx.pgsql
cridx_idxcol_indexidx.pgsql
cridx_idxcol_defschidx.pgsql
cridx_idxcol_col_def.pgsql
cridx_idxcol_xprev.pgsql
cridx_idxcol_xnext.pgsql
cridx_idxcol_xidxprev.pgsql
cridx_idxcol_xidxnext.pgsql
cridx_int16col_xtable.pgsql
cridx_int16typ_xschemadef.pgsql
cridx_int32col_xtable.pgsql
cridx_int32typ_xschemadef.pgsql
cridx_int64col_xtable.pgsql
cridx_int64typ_xschemadef.pgsql
cridx_lic_xtenant.pgsql
cridx_lic_xdom.pgsql
cridx_lic_xuname.pgsql
cridx_loadbehav_xuname.pgsql
cridx_mjverdef_pprjidx.pgsql
cridx_mjverdef_unameidx.pgsql
cridx_mimetype_xuname.pgsql
cridx_mnverdef_majoridx.pgsql
cridx_mnverdef_unameidx.pgsql
cridx_nmtkncol_xtable.pgsql
cridx_nmtkntyp_xschemadef.pgsql
cridx_nmtknscol_xtable.pgsql
cridx_nmtknstyp_xschemadef.pgsql
cridx_numcol_xtable.pgsql
cridx_numtyp_xschemadef.pgsql
cridx_srvprm_xuname.pgsql
cridx_srvprm_tenantidx.pgsql
cridx_srvprm_srvmethk.pgsql
cridx_srvprm_defschidx.pgsql
cridx_srvprm_typek.pgsql
cridx_srvprm_xprev.pgsql
cridx_srvprm_xnext.pgsql
cridx_srvprm_xcontprev.pgsql
cridx_srvprm_xcontnext.pgsql
cridx_popdep_xrel.pgsql
cridx_popdep_defschidx.pgsql
cridx_popsubdep1_xcpoptopdep.pgsql
cridx_popsubdep1_uname.pgsql
cridx_popsubdep2_xcpopdep1.pgsql
cridx_popsubdep2_uname.pgsql
cridx_popsubdep3_xcpopdep2.pgsql
cridx_popsubdep3_uname.pgsql
cridx_poptop_xcrel.pgsql
cridx_poptop_uname.pgsql
cridx_reldef_xuname.pgsql
cridx_reldef_tenantidx.pgsql
cridx_reldef_tableidx.pgsql
cridx_reldef_defschidx.pgsql
cridx_reldef_xrtypekey.pgsql
cridx_reldef_xfromkey.pgsql
cridx_reldef_xtotbl.pgsql
cridx_reldef_xtokey.pgsql
cridx_reldef_xnarrowed.pgsql
cridx_relcol_xuname.pgsql
cridx_relcol_tenantidx.pgsql
cridx_relcol_relk.pgsql
cridx_relcol_defschidx.pgsql
cridx_relcol_fromk.pgsql
cridx_relcol_tok.pgsql
cridx_relcol_xprev.pgsql
cridx_relcol_xnext.pgsql
cridx_relcol_xrelprev.pgsql
cridx_relcol_xrelnext.pgsql
cridx_rel_type_utagidx.pgsql
cridx_schemadef_ctenantidx.pgsql
cridx_schemadef_domainidx.pgsql
cridx_schemadef_xuname.pgsql
cridx_schemadef_xdeflcn.pgsql
cridx_schemadef_xdatascope.pgsql
cridx_schemadef_xviewaccsec.pgsql
cridx_schemadef_xviewaccfreq.pgsql
cridx_schemadef_xeditaccsec.pgsql
cridx_schemadef_xeditaccfreq.pgsql
cridx_schemadef_xupuburi.pgsql
cridx_schemaref_schk.pgsql
cridx_schemaref_uname.pgsql
cridx_schemaref_rsck.pgsql
cridx_scopedef_tenantidx.pgsql
cridx_secapp_xcluster.pgsql
cridx_secapp_xujeemnt.pgsql
cridx_secdev_usridx.pgsql
cridx_secform_xcluster.pgsql
cridx_secform_xsecapp.pgsql
cridx_secform_xujeesvlt.pgsql
cridx_secgroup_xcluster.pgsql
cridx_secgroup_xuname.pgsql
cridx_secgroupform_xcluster.pgsql
cridx_secgroupform_xgroup.pgsql
cridx_secgroupform_xapp.pgsql
cridx_secgroupform_xform.pgsql
cridx_secgroupform_xuform.pgsql
cridx_secinclude_xcluster.pgsql
cridx_secinclude_xgroup.pgsql
cridx_secinclude_xinc.pgsql
cridx_secinclude_xuinc.pgsql
cridx_secmember_xcluster.pgsql
cridx_secmember_xgroup.pgsql
cridx_secmember_xuser.pgsql
cridx_secmember_xuuser.pgsql
cridx_session_xsecuser.pgsql
cridx_session_xsecdev.pgsql
cridx_session_xstart.pgsql
cridx_session_xfnsh.pgsql
cridx_session_xproxy.pgsql
cridx_secuser_xulogin.pgsql
cridx_secuser_xemconf.pgsql
cridx_secuser_xpwdrst.pgsql
cridx_secuser_defdevidx.pgsql
cridx_secscope_xuname.pgsql
cridx_srvlfunc_rettblk.pgsql
cridx_srvmeth_xuname.pgsql
cridx_srvmeth_tableidx.pgsql
cridx_srvmeth_defschidx.pgsql
cridx_srvofunc_rettblk.pgsql
cridx_service_xcluster.pgsql
cridx_service_xhost.pgsql
cridx_service_xtype.pgsql
cridx_service_xutype.pgsql
cridx_service_xuhpt.pgsql
cridx_servicetype_xudsc.pgsql
cridx_strcol_xtable.pgsql
cridx_strtyp_xschemadef.pgsql
cridx_sprjdef_pprjidx.pgsql
cridx_sprjdef_unameidx.pgsql
cridx_sysclus_xclus.pgsql
cridx_tsecgroup_xtenant.pgsql
cridx_tsecgroup_xuname.pgsql
cridx_tsecinclude_xtenant.pgsql
cridx_tsecinclude_xgroup.pgsql
cridx_tsecinclude_xinc.pgsql
cridx_tsecinclude_xuinc.pgsql
cridx_tsecmember_xtenant.pgsql
cridx_tsecmember_xgroup.pgsql
cridx_tsecmember_xuser.pgsql
cridx_tsecmember_xuuser.pgsql
cridx_dzcol_xtable.pgsql
cridx_dztyp_xschemadef.pgsql
cridx_tmzcol_xtable.pgsql
cridx_tmztyp_xschemadef.pgsql
cridx_zscol_xtable.pgsql
cridx_zstyp_xschemadef.pgsql
cridx_tbldef_schemaidx.pgsql
cridx_tbldef_defschidx.pgsql
cridx_table_xuname.pgsql
cridx_tabledef_xscd.pgsql
cridx_def_tbl_xpidx.pgsql
cridx_def_tbl_xlookupidx.pgsql
cridx_def_tbl_xaltidx.pgsql
cridx_def_tbl_xqtblidx.pgsql
cridx_tabledef_xloadbehave.pgsql
cridx_tabledef_xdatascope.pgsql
cridx_tabledef_xsecscope.pgsql
cridx_tabledef_xviewaccsec.pgsql
cridx_tabledef_xviewaccfreq.pgsql
cridx_tabledef_xeditaccsec.pgsql
cridx_tabledef_xeditaccfreq.pgsql
cridx_tblcol_xtable.pgsql
cridx_tablecol_xdata.pgsql
cridx_tenant_xcluster.pgsql
cridx_tenant_xuname.pgsql
cridx_txtcol_xtable.pgsql
cridx_txttyp_xschemadef.pgsql
cridx_tmcol_xtable.pgsql
cridx_tmtyp_xschemadef.pgsql
cridx_tscol_xtable.pgsql
cridx_tstyp_xschemadef.pgsql
cridx_tlddef_tenantidx.pgsql
cridx_tlddef_unameidx.pgsql
cridx_tkncol_xtable.pgsql
cridx_tkntyp_xschemadef.pgsql
cridx_tdomdef_tldidx.pgsql
cridx_tdomdef_unameidx.pgsql
cridx_tprjdef_domidx.pgsql
cridx_tprjdef_unameidx.pgsql
cridx_uint16col_xtable.pgsql
cridx_uint16typ_xschemadef.pgsql
cridx_uint32col_xtable.pgsql
cridx_uint32typ_xschemadef.pgsql
cridx_uint64col_xtable.pgsql
cridx_uint64typ_xschemadef.pgsql
cridx_urlproto_xuname.pgsql
cridx_urlproto_xsecure.pgsql
cridx_uuidcol_xtable.pgsql
cridx_idguuid_dpk_def.pgsql
cridx_uuidtyp_xschemadef.pgsql
cridx_valdef_xuname.pgsql
cridx_valdef_tenantidx.pgsql
cridx_valdef_scopeidx.pgsql
cridx_value_defschidx.pgsql
cridx_valuedef_xdatascope.pgsql
cridx_valuedef_xviewaccsec.pgsql
cridx_valuedef_xviewaccfreq.pgsql
cridx_valuedef_xeditaccsec.pgsql
cridx_valuedef_xeditaccfreq.pgsql
cridx_valuedef_xprev.pgsql
cridx_valuedef_xnext.pgsql
cridx_valuedef_xcontprev.pgsql
cridx_valuedef_xcontnext.pgsql
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

