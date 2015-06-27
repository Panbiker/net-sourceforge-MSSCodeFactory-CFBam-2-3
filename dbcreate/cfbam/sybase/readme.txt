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


You will find a number of script files in this directory,
all of which are intended to be executed using isql
to install a CFBam23 database.

Each of the *.bash scripts accepts the following arguments
unless otherwise noted:

	-S server	The name of the sybase server to use.
	-U username	The login name for the server.
	-P password	The password for logging in.
	-D database	The name of the database to contain the schema.
	-L logfile	Where to write the log messages.

All tables and indices are created in the default container for
the user name and database.

Database Creation Scripts
-------------------------

crtypes_cfbam23.isql
	Creates the MssCFClassCode type if it has not already been created, and the
	user data types with their associated rules for the schema.  The types should
	be created before the database, as Sybase will copy the data types from the
	model to each of the databases created.

crdatabase_cfbam23.isql
	Creates the database "cfbam23" and the database owner
	login "cfbam23dba".  The initial password for the database
	owner is "cfbam23pwd" and should not be changed until after
	the remaining schema creation scripts have been executed.

	Creating the database itself takes roughly two hours on my C300 Linux system.

		drop database cfbam23
		go

		exec sp_droplogin cfbam23dba
		go

crdb_cfbam23.ksh
	The master script for creating the user data types, tables, indexes, and
	constraints for the database.

cridg_cfbam23.isql
	Creates the database id generator objects.

crtbl_cfbam23.ksh
	Creates the database tables.

cridx_cfbam23.isql
	Creates the database table indexes.

crrel_cfbam23.isql
	Creates the relationships between the tables.
crtbl_accfreq.isql
crtbl_accsec.isql
crtbl_atomdef.isql
crtbl_auditaction.isql
crtbl_blbcol.isql
crtbl_blbdef.isql
crtbl_blbtyp.isql
crtbl_boolcol.isql
crtbl_booldef.isql
crtbl_booltyp.isql
crtbl_chain_def.isql
crtbl_clr_dep.isql
crtbl_clrsubdep1.isql
crtbl_clrsubdep2.isql
crtbl_clrsubdep3.isql
crtbl_clr_topdep.isql
crtbl_clus.isql
crtbl_datascope.isql
crtbl_dtcol.isql
crtbl_dtdef.isql
crtbl_dttyp.isql
crtbl_del_dep.isql
crtbl_delsubdep1.isql
crtbl_delsubdep2.isql
crtbl_delsubdep3.isql
crtbl_del_topdep.isql
crtbl_domdef.isql
crtbl_bdomdef.isql
crtbl_dblcol.isql
crtbl_dbldef.isql
crtbl_dbltyp.isql
crtbl_enumcol.isql
crtbl_enumdef.isql
crtbl_enum_tag.isql
crtbl_enumtyp.isql
crtbl_fltcol.isql
crtbl_fltdef.isql
crtbl_flttyp.isql
crtbl_hostnode.isql
crtbl_iso_cntry.isql
crtbl_iso_cntryccy.isql
crtbl_iso_cntrylng.isql
crtbl_iso_ccy.isql
crtbl_iso_lang.isql
crtbl_isotz.isql
crtbl_idg16.isql
crtbl_idg32.isql
crtbl_idg64.isql
crtbl_idxdef.isql
crtbl_idxcol.isql
crtbl_int16col.isql
crtbl_int16def.isql
crtbl_int16typ.isql
crtbl_int32col.isql
crtbl_int32def.isql
crtbl_int32typ.isql
crtbl_int64col.isql
crtbl_int64def.isql
crtbl_int64typ.isql
crtbl_licn.isql
crtbl_loadbehav.isql
crtbl_mjverdef.isql
crtbl_mimetype.isql
crtbl_mnverdef.isql
crtbl_nmtkncol.isql
crtbl_nmtkndef.isql
crtbl_nmtkntyp.isql
crtbl_nmtknscol.isql
crtbl_nmtknsdef.isql
crtbl_nmtknstyp.isql
crtbl_numcol.isql
crtbl_numdef.isql
crtbl_numtyp.isql
crtbl_srvprm.isql
crtbl_pop_dep.isql
crtbl_popsubdep1.isql
crtbl_popsubdep2.isql
crtbl_popsubdep3.isql
crtbl_pop_topdep.isql
crtbl_bprjdef.isql
crtbl_rprjdef.isql
crtbl_reldef.isql
crtbl_relcol.isql
crtbl_rel_type.isql
crtbl_schemadef.isql
crtbl_schema_ref.isql
crtbl_scopedef.isql
crtbl_secapp.isql
crtbl_secdev.isql
crtbl_secform.isql
crtbl_secgrp.isql
crtbl_secgrpfrm.isql
crtbl_secinc.isql
crtbl_secmemb.isql
crtbl_secsess.isql
crtbl_secuser.isql
crtbl_secscope.isql
crtbl_srvlfunc.isql
crtbl_srvmeth.isql
crtbl_srvofunc.isql
crtbl_srvprc.isql
crtbl_hostsvc.isql
crtbl_svctype.isql
crtbl_strcol.isql
crtbl_strdef.isql
crtbl_strtyp.isql
crtbl_sprjdef.isql
crtbl_sysclus.isql
crtbl_tsecgrp.isql
crtbl_tsecinc.isql
crtbl_tsecmemb.isql
crtbl_dzcol.isql
crtbl_dzdef.isql
crtbl_dztyp.isql
crtbl_tmzcol.isql
crtbl_tmzdef.isql
crtbl_tmztyp.isql
crtbl_zscol.isql
crtbl_zsdef.isql
crtbl_zstyp.isql
crtbl_tbldef.isql
crtbl_tblcol.isql
crtbl_tenant.isql
crtbl_txtcol.isql
crtbl_txtdef.isql
crtbl_txttyp.isql
crtbl_tmcol.isql
crtbl_tmdef.isql
crtbl_tmtyp.isql
crtbl_tscol.isql
crtbl_tsdef.isql
crtbl_tstyp.isql
crtbl_tlddef.isql
crtbl_tkncol.isql
crtbl_tkndef.isql
crtbl_tkntyp.isql
crtbl_tdomdef.isql
crtbl_tprjdef.isql
crtbl_uint16col.isql
crtbl_u16def.isql
crtbl_uint16typ.isql
crtbl_uint32col.isql
crtbl_u32def.isql
crtbl_uint32typ.isql
crtbl_uint64col.isql
crtbl_u64def.isql
crtbl_uint64typ.isql
crtbl_urlproto.isql
crtbl_uuidcol.isql
crtbl_uuiddef.isql
crtbl_idguuid.isql
crtbl_uuidtyp.isql
crtbl_valdef.isql
crtbl_verndef.isql
	The individual table creation scripts called by crtbl_cfbam23.isql.

cridx_accfreq_xuname.isql
cridx_accsec_xuname.isql
cridx_auditaction_xudsc.isql
cridx_blbcol_xtable.isql
cridx_blbtyp_xschemadef.isql
cridx_boolcol_xtable.isql
cridx_booltyp_xschemadef.isql
cridx_chain_xtent.isql
cridx_chain_xtbl.isql
cridx_chain_defschidx.isql
cridx_chain_xuname.isql
cridx_chain_xprevrel.isql
cridx_chain_xnextrel.isql
cridx_clrdep_xrel.isql
cridx_clrsubdep1_xcdeltopdep.isql
cridx_clrsubdep1_uname.isql
cridx_clrsubdep2_xcdeldep1.isql
cridx_clrsubdep2_uname.isql
cridx_clrsubdep3_xcdeldep2.isql
cridx_clrsubdep3_uname.isql
cridx_clrtop_xctbl.isql
cridx_clrtopdep_uname.isql
cridx_cluster_xufdname.isql
cridx_cluster_xudescr.isql
cridx_datascope_xuname.isql
cridx_dtcol_xtable.isql
cridx_dttyp_xschemadef.isql
cridx_deldep_defschidx.isql
cridx_deldep_xrel.isql
cridx_delsubdep1_xcdeltopdep.isql
cridx_delsubdep1_uname.isql
cridx_delsubdep2_xcdeldep1.isql
cridx_delsubdep2_uname.isql
cridx_delsubdep3_xcdeldep2.isql
cridx_delsubdep3_uname.isql
cridx_deltop_xctbl.isql
cridx_deltop_uname.isql
cridx_domdef_subdomidx.isql
cridx_domdef_unameidx.isql
cridx_bdomdef_tenantidx.isql
cridx_dblcol_xtable.isql
cridx_dbltyp_xschemadef.isql
cridx_enumcol_xtable.isql
cridx_enumtag_xtenant.isql
cridx_enumtag_xenum.isql
cridx_enumtag_defschidx.isql
cridx_enumtag_uenumnm.isql
cridx_enumtag_xprev.isql
cridx_enumtag_xnext.isql
cridx_enumtyp_xschemadef.isql
cridx_fltcol_xtable.isql
cridx_flttyp_xschemadef.isql
cridx_hostnode_xcluster.isql
cridx_hostnode_xudsc.isql
cridx_hostnode_xhnm.isql
cridx_isocountry_xcode.isql
cridx_isocountry_xuname.isql
cridx_isocountryccy_xcountry.isql
cridx_isocountryccy_xccy.isql
cridx_isocountrylang_xcountry.isql
cridx_isocountrylang_xlang.isql
cridx_isocurrency_xcode.isql
cridx_isocurrency_xuname.isql
cridx_isolang_xbase.isql
cridx_isolang_xcntry.isql
cridx_isolang_xcode.isql
cridx_itz_xoffset.isql
cridx_itz_xuname.isql
cridx_itz_xiso.isql
cridx_idg16_dpk_def.isql
cridx_idg32_dpk_def.isql
cridx_idg64_dpk_def.isql
cridx_idxdef_xuname.isql
cridx_idxdef_tenantidx.isql
cridx_idxdef_tableidx.isql
cridx_index_defschidx.isql
cridx_idxcol_xuname.isql
cridx_idxcol_tenantidx.isql
cridx_idxcol_indexidx.isql
cridx_idxcol_defschidx.isql
cridx_idxcol_col_def.isql
cridx_idxcol_xprev.isql
cridx_idxcol_xnext.isql
cridx_idxcol_xidxprev.isql
cridx_idxcol_xidxnext.isql
cridx_int16col_xtable.isql
cridx_int16typ_xschemadef.isql
cridx_int32col_xtable.isql
cridx_int32typ_xschemadef.isql
cridx_int64col_xtable.isql
cridx_int64typ_xschemadef.isql
cridx_lic_xtenant.isql
cridx_lic_xdom.isql
cridx_lic_xuname.isql
cridx_loadbehav_xuname.isql
cridx_mjverdef_pprjidx.isql
cridx_mjverdef_unameidx.isql
cridx_mimetype_xuname.isql
cridx_mnverdef_majoridx.isql
cridx_mnverdef_unameidx.isql
cridx_nmtkncol_xtable.isql
cridx_nmtkntyp_xschemadef.isql
cridx_nmtknscol_xtable.isql
cridx_nmtknstyp_xschemadef.isql
cridx_numcol_xtable.isql
cridx_numtyp_xschemadef.isql
cridx_srvprm_xuname.isql
cridx_srvprm_tenantidx.isql
cridx_srvprm_srvmethk.isql
cridx_srvprm_defschidx.isql
cridx_srvprm_typek.isql
cridx_srvprm_xprev.isql
cridx_srvprm_xnext.isql
cridx_srvprm_xcontprev.isql
cridx_srvprm_xcontnext.isql
cridx_popdep_xrel.isql
cridx_popdep_defschidx.isql
cridx_popsubdep1_xcpoptopdep.isql
cridx_popsubdep1_uname.isql
cridx_popsubdep2_xcpopdep1.isql
cridx_popsubdep2_uname.isql
cridx_popsubdep3_xcpopdep2.isql
cridx_popsubdep3_uname.isql
cridx_poptop_xcrel.isql
cridx_poptop_uname.isql
cridx_reldef_xuname.isql
cridx_reldef_tenantidx.isql
cridx_reldef_tableidx.isql
cridx_reldef_defschidx.isql
cridx_reldef_xrtypekey.isql
cridx_reldef_xfromkey.isql
cridx_reldef_xtotbl.isql
cridx_reldef_xtokey.isql
cridx_reldef_xnarrowed.isql
cridx_relcol_xuname.isql
cridx_relcol_tenantidx.isql
cridx_relcol_relk.isql
cridx_relcol_defschidx.isql
cridx_relcol_fromk.isql
cridx_relcol_tok.isql
cridx_relcol_xprev.isql
cridx_relcol_xnext.isql
cridx_relcol_xrelprev.isql
cridx_relcol_xrelnext.isql
cridx_rel_type_utagidx.isql
cridx_schemadef_ctenantidx.isql
cridx_schemadef_domainidx.isql
cridx_schemadef_xuname.isql
cridx_schemadef_xdeflcn.isql
cridx_schemadef_xdatascope.isql
cridx_schemadef_xviewaccsec.isql
cridx_schemadef_xviewaccfreq.isql
cridx_schemadef_xeditaccsec.isql
cridx_schemadef_xeditaccfreq.isql
cridx_schemadef_xupuburi.isql
cridx_schemaref_schk.isql
cridx_schemaref_uname.isql
cridx_schemaref_rsck.isql
cridx_scopedef_tenantidx.isql
cridx_secapp_xcluster.isql
cridx_secapp_xujeemnt.isql
cridx_secdev_usridx.isql
cridx_secform_xcluster.isql
cridx_secform_xsecapp.isql
cridx_secform_xujeesvlt.isql
cridx_secgroup_xcluster.isql
cridx_secgroup_xuname.isql
cridx_secgroupform_xcluster.isql
cridx_secgroupform_xgroup.isql
cridx_secgroupform_xapp.isql
cridx_secgroupform_xform.isql
cridx_secgroupform_xuform.isql
cridx_secinclude_xcluster.isql
cridx_secinclude_xgroup.isql
cridx_secinclude_xinc.isql
cridx_secinclude_xuinc.isql
cridx_secmember_xcluster.isql
cridx_secmember_xgroup.isql
cridx_secmember_xuser.isql
cridx_secmember_xuuser.isql
cridx_session_xsecuser.isql
cridx_session_xsecdev.isql
cridx_session_xstart.isql
cridx_session_xfnsh.isql
cridx_session_xproxy.isql
cridx_secuser_xulogin.isql
cridx_secuser_xemconf.isql
cridx_secuser_xpwdrst.isql
cridx_secuser_defdevidx.isql
cridx_secscope_xuname.isql
cridx_srvlfunc_rettblk.isql
cridx_srvmeth_xuname.isql
cridx_srvmeth_tableidx.isql
cridx_srvmeth_defschidx.isql
cridx_srvofunc_rettblk.isql
cridx_service_xcluster.isql
cridx_service_xhost.isql
cridx_service_xtype.isql
cridx_service_xutype.isql
cridx_service_xuhpt.isql
cridx_servicetype_xudsc.isql
cridx_strcol_xtable.isql
cridx_strtyp_xschemadef.isql
cridx_sprjdef_pprjidx.isql
cridx_sprjdef_unameidx.isql
cridx_sysclus_xclus.isql
cridx_tsecgroup_xtenant.isql
cridx_tsecgroup_xuname.isql
cridx_tsecinclude_xtenant.isql
cridx_tsecinclude_xgroup.isql
cridx_tsecinclude_xinc.isql
cridx_tsecinclude_xuinc.isql
cridx_tsecmember_xtenant.isql
cridx_tsecmember_xgroup.isql
cridx_tsecmember_xuser.isql
cridx_tsecmember_xuuser.isql
cridx_dzcol_xtable.isql
cridx_dztyp_xschemadef.isql
cridx_tmzcol_xtable.isql
cridx_tmztyp_xschemadef.isql
cridx_zscol_xtable.isql
cridx_zstyp_xschemadef.isql
cridx_tbldef_schemaidx.isql
cridx_tbldef_defschidx.isql
cridx_table_xuname.isql
cridx_tabledef_xscd.isql
cridx_def_tbl_xpidx.isql
cridx_def_tbl_xlookupidx.isql
cridx_def_tbl_xaltidx.isql
cridx_def_tbl_xqtblidx.isql
cridx_tabledef_xloadbehave.isql
cridx_tabledef_xdatascope.isql
cridx_tabledef_xsecscope.isql
cridx_tabledef_xviewaccsec.isql
cridx_tabledef_xviewaccfreq.isql
cridx_tabledef_xeditaccsec.isql
cridx_tabledef_xeditaccfreq.isql
cridx_tblcol_xtable.isql
cridx_tablecol_xdata.isql
cridx_tenant_xcluster.isql
cridx_tenant_xuname.isql
cridx_txtcol_xtable.isql
cridx_txttyp_xschemadef.isql
cridx_tmcol_xtable.isql
cridx_tmtyp_xschemadef.isql
cridx_tscol_xtable.isql
cridx_tstyp_xschemadef.isql
cridx_tlddef_tenantidx.isql
cridx_tlddef_unameidx.isql
cridx_tkncol_xtable.isql
cridx_tkntyp_xschemadef.isql
cridx_tdomdef_tldidx.isql
cridx_tdomdef_unameidx.isql
cridx_tprjdef_domidx.isql
cridx_tprjdef_unameidx.isql
cridx_uint16col_xtable.isql
cridx_uint16typ_xschemadef.isql
cridx_uint32col_xtable.isql
cridx_uint32typ_xschemadef.isql
cridx_uint64col_xtable.isql
cridx_uint64typ_xschemadef.isql
cridx_urlproto_xuname.isql
cridx_urlproto_xsecure.isql
cridx_uuidcol_xtable.isql
cridx_idguuid_dpk_def.isql
cridx_uuidtyp_xschemadef.isql
cridx_valdef_xuname.isql
cridx_valdef_tenantidx.isql
cridx_valdef_scopeidx.isql
cridx_value_defschidx.isql
cridx_valuedef_xdatascope.isql
cridx_valuedef_xviewaccsec.isql
cridx_valuedef_xviewaccfreq.isql
cridx_valuedef_xeditaccsec.isql
cridx_valuedef_xeditaccfreq.isql
cridx_valuedef_xprev.isql
cridx_valuedef_xnext.isql
cridx_valuedef_xcontprev.isql
cridx_valuedef_xcontnext.isql
	The individual table index creation scripts called by cridx_cfbam23.isql.

crsp_next_servicetypeidgen.isql
crsp_next_mimetypeidgen.isql
crsp_next_clusteridgen.isql
crsp_next_tenantidgen.isql
	The stored procedures for getting the next schema id from the generators.

crsp_next_secappidgen.isql
crsp_next_secformidgen.isql
crsp_next_secgroupidgen.isql
crsp_next_secgroupmemberidgen.isql
crsp_next_secgroupincludeidgen.isql
crsp_next_secgroupformidgen.isql
crsp_next_serviceidgen.isql
crsp_next_hostnodeidgen.isql
crsp_next_tsecgroupidgen.isql
crsp_next_tsecgroupmemberidgen.isql
crsp_next_tsecgroupincludeidgen.isql
crsp_next_tldidgen.isql
crsp_next_domainidgen.isql
crsp_next_scopeidgen.isql
crsp_next_indexcolidgen.isql
crsp_next_licenseidgen.isql
crsp_next_relationcolidgen.isql
crsp_next_valueidgen.isql
crsp_next_enumtagidgen.isql
crsp_next_chainidgen.isql
crsp_next_paramidgen.isql
	The stored procedures for getting the next table-dispenssed id from the generators.
