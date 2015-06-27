$ScriptLicense$

You will find a number of script files in this directory,
all of which are intended to be executed using tsql
to install a CFBam23 database.

Each of the *.bash scripts accepts the following arguments
unless otherwise noted:

	-S server	The name of the mssql server to use.
	-U username	The login name for the server.
	-P password	The password for logging in.
	-D database	The name of the database to contain the schema.
	-L logfile	Where to write the log messages.

All tables and indices are created in the default container for
the user name and database.


Database Creation Scripts
-------------------------

crtypes_cfbam23.tsql
	Creates the OmxClassCode type if it has not already been created, and the
	user data types with their associated rules for the schema.  The types should
	be created before the database, as MSSql will copy the data types from the
	model to each of the databases created.

crdatabase_cfbam23.tsql
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

cridg_cfbam23.tsql
	Creates the database id generator objects.

crtbl_cfbam23.ksh
	Creates the database tables.

cridx_cfbam23.tsql
	Creates the database table indexes.

crrel_cfbam23.tsql
	Creates the relationships between the tables.

crtbl_accfreq.tsql
crtbl_accsec.tsql
crtbl_atomdef.tsql
crtbl_auditaction.tsql
crtbl_blbcol.tsql
crtbl_blbdef.tsql
crtbl_blbtyp.tsql
crtbl_boolcol.tsql
crtbl_booldef.tsql
crtbl_booltyp.tsql
crtbl_chain_def.tsql
crtbl_clr_dep.tsql
crtbl_clrsubdep1.tsql
crtbl_clrsubdep2.tsql
crtbl_clrsubdep3.tsql
crtbl_clr_topdep.tsql
crtbl_clus.tsql
crtbl_datascope.tsql
crtbl_dtcol.tsql
crtbl_dtdef.tsql
crtbl_dttyp.tsql
crtbl_del_dep.tsql
crtbl_delsubdep1.tsql
crtbl_delsubdep2.tsql
crtbl_delsubdep3.tsql
crtbl_del_topdep.tsql
crtbl_domdef.tsql
crtbl_bdomdef.tsql
crtbl_dblcol.tsql
crtbl_dbldef.tsql
crtbl_dbltyp.tsql
crtbl_enumcol.tsql
crtbl_enumdef.tsql
crtbl_enum_tag.tsql
crtbl_enumtyp.tsql
crtbl_fltcol.tsql
crtbl_fltdef.tsql
crtbl_flttyp.tsql
crtbl_hostnode.tsql
crtbl_iso_cntry.tsql
crtbl_iso_cntryccy.tsql
crtbl_iso_cntrylng.tsql
crtbl_iso_ccy.tsql
crtbl_iso_lang.tsql
crtbl_isotz.tsql
crtbl_idg16.tsql
crtbl_idg32.tsql
crtbl_idg64.tsql
crtbl_idxdef.tsql
crtbl_idxcol.tsql
crtbl_int16col.tsql
crtbl_int16def.tsql
crtbl_int16typ.tsql
crtbl_int32col.tsql
crtbl_int32def.tsql
crtbl_int32typ.tsql
crtbl_int64col.tsql
crtbl_int64def.tsql
crtbl_int64typ.tsql
crtbl_licn.tsql
crtbl_loadbehav.tsql
crtbl_mjverdef.tsql
crtbl_mimetype.tsql
crtbl_mnverdef.tsql
crtbl_nmtkncol.tsql
crtbl_nmtkndef.tsql
crtbl_nmtkntyp.tsql
crtbl_nmtknscol.tsql
crtbl_nmtknsdef.tsql
crtbl_nmtknstyp.tsql
crtbl_numcol.tsql
crtbl_numdef.tsql
crtbl_numtyp.tsql
crtbl_srvprm.tsql
crtbl_pop_dep.tsql
crtbl_popsubdep1.tsql
crtbl_popsubdep2.tsql
crtbl_popsubdep3.tsql
crtbl_pop_topdep.tsql
crtbl_bprjdef.tsql
crtbl_rprjdef.tsql
crtbl_reldef.tsql
crtbl_relcol.tsql
crtbl_rel_type.tsql
crtbl_schemadef.tsql
crtbl_schema_ref.tsql
crtbl_scopedef.tsql
crtbl_secapp.tsql
crtbl_secdev.tsql
crtbl_secform.tsql
crtbl_secgrp.tsql
crtbl_secgrpfrm.tsql
crtbl_secinc.tsql
crtbl_secmemb.tsql
crtbl_secsess.tsql
crtbl_secuser.tsql
crtbl_secscope.tsql
crtbl_srvlfunc.tsql
crtbl_srvmeth.tsql
crtbl_srvofunc.tsql
crtbl_srvprc.tsql
crtbl_hostsvc.tsql
crtbl_svctype.tsql
crtbl_strcol.tsql
crtbl_strdef.tsql
crtbl_strtyp.tsql
crtbl_sprjdef.tsql
crtbl_sysclus.tsql
crtbl_tsecgrp.tsql
crtbl_tsecinc.tsql
crtbl_tsecmemb.tsql
crtbl_dzcol.tsql
crtbl_dzdef.tsql
crtbl_dztyp.tsql
crtbl_tmzcol.tsql
crtbl_tmzdef.tsql
crtbl_tmztyp.tsql
crtbl_zscol.tsql
crtbl_zsdef.tsql
crtbl_zstyp.tsql
crtbl_tbldef.tsql
crtbl_tblcol.tsql
crtbl_tenant.tsql
crtbl_txtcol.tsql
crtbl_txtdef.tsql
crtbl_txttyp.tsql
crtbl_tmcol.tsql
crtbl_tmdef.tsql
crtbl_tmtyp.tsql
crtbl_tscol.tsql
crtbl_tsdef.tsql
crtbl_tstyp.tsql
crtbl_tlddef.tsql
crtbl_tkncol.tsql
crtbl_tkndef.tsql
crtbl_tkntyp.tsql
crtbl_tdomdef.tsql
crtbl_tprjdef.tsql
crtbl_uint16col.tsql
crtbl_u16def.tsql
crtbl_uint16typ.tsql
crtbl_uint32col.tsql
crtbl_u32def.tsql
crtbl_uint32typ.tsql
crtbl_uint64col.tsql
crtbl_u64def.tsql
crtbl_uint64typ.tsql
crtbl_urlproto.tsql
crtbl_uuidcol.tsql
crtbl_uuiddef.tsql
crtbl_idguuid.tsql
crtbl_uuidtyp.tsql
crtbl_valdef.tsql
crtbl_verndef.tsql
	The individual table creation scripts called by crtbl_cfbam23.tsql.

cridx_accfreq_xuname.tsql
cridx_accsec_xuname.tsql
cridx_auditaction_xudsc.tsql
cridx_blbcol_xtable.tsql
cridx_blbtyp_xschemadef.tsql
cridx_boolcol_xtable.tsql
cridx_booltyp_xschemadef.tsql
cridx_chain_xtent.tsql
cridx_chain_xtbl.tsql
cridx_chain_defschidx.tsql
cridx_chain_xuname.tsql
cridx_chain_xprevrel.tsql
cridx_chain_xnextrel.tsql
cridx_clrdep_xrel.tsql
cridx_clrsubdep1_xcdeltopdep.tsql
cridx_clrsubdep1_uname.tsql
cridx_clrsubdep2_xcdeldep1.tsql
cridx_clrsubdep2_uname.tsql
cridx_clrsubdep3_xcdeldep2.tsql
cridx_clrsubdep3_uname.tsql
cridx_clrtop_xctbl.tsql
cridx_clrtopdep_uname.tsql
cridx_cluster_xufdname.tsql
cridx_cluster_xudescr.tsql
cridx_datascope_xuname.tsql
cridx_dtcol_xtable.tsql
cridx_dttyp_xschemadef.tsql
cridx_deldep_defschidx.tsql
cridx_deldep_xrel.tsql
cridx_delsubdep1_xcdeltopdep.tsql
cridx_delsubdep1_uname.tsql
cridx_delsubdep2_xcdeldep1.tsql
cridx_delsubdep2_uname.tsql
cridx_delsubdep3_xcdeldep2.tsql
cridx_delsubdep3_uname.tsql
cridx_deltop_xctbl.tsql
cridx_deltop_uname.tsql
cridx_domdef_subdomidx.tsql
cridx_domdef_unameidx.tsql
cridx_bdomdef_tenantidx.tsql
cridx_dblcol_xtable.tsql
cridx_dbltyp_xschemadef.tsql
cridx_enumcol_xtable.tsql
cridx_enumtag_xtenant.tsql
cridx_enumtag_xenum.tsql
cridx_enumtag_defschidx.tsql
cridx_enumtag_uenumnm.tsql
cridx_enumtag_xprev.tsql
cridx_enumtag_xnext.tsql
cridx_enumtyp_xschemadef.tsql
cridx_fltcol_xtable.tsql
cridx_flttyp_xschemadef.tsql
cridx_hostnode_xcluster.tsql
cridx_hostnode_xudsc.tsql
cridx_hostnode_xhnm.tsql
cridx_isocountry_xcode.tsql
cridx_isocountry_xuname.tsql
cridx_isocountryccy_xcountry.tsql
cridx_isocountryccy_xccy.tsql
cridx_isocountrylang_xcountry.tsql
cridx_isocountrylang_xlang.tsql
cridx_isocurrency_xcode.tsql
cridx_isocurrency_xuname.tsql
cridx_isolang_xbase.tsql
cridx_isolang_xcntry.tsql
cridx_isolang_xcode.tsql
cridx_itz_xoffset.tsql
cridx_itz_xuname.tsql
cridx_itz_xiso.tsql
cridx_idg16_dpk_def.tsql
cridx_idg32_dpk_def.tsql
cridx_idg64_dpk_def.tsql
cridx_idxdef_xuname.tsql
cridx_idxdef_tenantidx.tsql
cridx_idxdef_tableidx.tsql
cridx_index_defschidx.tsql
cridx_idxcol_xuname.tsql
cridx_idxcol_tenantidx.tsql
cridx_idxcol_indexidx.tsql
cridx_idxcol_defschidx.tsql
cridx_idxcol_col_def.tsql
cridx_idxcol_xprev.tsql
cridx_idxcol_xnext.tsql
cridx_idxcol_xidxprev.tsql
cridx_idxcol_xidxnext.tsql
cridx_int16col_xtable.tsql
cridx_int16typ_xschemadef.tsql
cridx_int32col_xtable.tsql
cridx_int32typ_xschemadef.tsql
cridx_int64col_xtable.tsql
cridx_int64typ_xschemadef.tsql
cridx_lic_xtenant.tsql
cridx_lic_xdom.tsql
cridx_lic_xuname.tsql
cridx_loadbehav_xuname.tsql
cridx_mjverdef_pprjidx.tsql
cridx_mjverdef_unameidx.tsql
cridx_mimetype_xuname.tsql
cridx_mnverdef_majoridx.tsql
cridx_mnverdef_unameidx.tsql
cridx_nmtkncol_xtable.tsql
cridx_nmtkntyp_xschemadef.tsql
cridx_nmtknscol_xtable.tsql
cridx_nmtknstyp_xschemadef.tsql
cridx_numcol_xtable.tsql
cridx_numtyp_xschemadef.tsql
cridx_srvprm_xuname.tsql
cridx_srvprm_tenantidx.tsql
cridx_srvprm_srvmethk.tsql
cridx_srvprm_defschidx.tsql
cridx_srvprm_typek.tsql
cridx_srvprm_xprev.tsql
cridx_srvprm_xnext.tsql
cridx_srvprm_xcontprev.tsql
cridx_srvprm_xcontnext.tsql
cridx_popdep_xrel.tsql
cridx_popdep_defschidx.tsql
cridx_popsubdep1_xcpoptopdep.tsql
cridx_popsubdep1_uname.tsql
cridx_popsubdep2_xcpopdep1.tsql
cridx_popsubdep2_uname.tsql
cridx_popsubdep3_xcpopdep2.tsql
cridx_popsubdep3_uname.tsql
cridx_poptop_xcrel.tsql
cridx_poptop_uname.tsql
cridx_reldef_xuname.tsql
cridx_reldef_tenantidx.tsql
cridx_reldef_tableidx.tsql
cridx_reldef_defschidx.tsql
cridx_reldef_xrtypekey.tsql
cridx_reldef_xfromkey.tsql
cridx_reldef_xtotbl.tsql
cridx_reldef_xtokey.tsql
cridx_reldef_xnarrowed.tsql
cridx_relcol_xuname.tsql
cridx_relcol_tenantidx.tsql
cridx_relcol_relk.tsql
cridx_relcol_defschidx.tsql
cridx_relcol_fromk.tsql
cridx_relcol_tok.tsql
cridx_relcol_xprev.tsql
cridx_relcol_xnext.tsql
cridx_relcol_xrelprev.tsql
cridx_relcol_xrelnext.tsql
cridx_rel_type_utagidx.tsql
cridx_schemadef_ctenantidx.tsql
cridx_schemadef_domainidx.tsql
cridx_schemadef_xuname.tsql
cridx_schemadef_xdeflcn.tsql
cridx_schemadef_xdatascope.tsql
cridx_schemadef_xviewaccsec.tsql
cridx_schemadef_xviewaccfreq.tsql
cridx_schemadef_xeditaccsec.tsql
cridx_schemadef_xeditaccfreq.tsql
cridx_schemadef_xupuburi.tsql
cridx_schemaref_schk.tsql
cridx_schemaref_uname.tsql
cridx_schemaref_rsck.tsql
cridx_scopedef_tenantidx.tsql
cridx_secapp_xcluster.tsql
cridx_secapp_xujeemnt.tsql
cridx_secdev_usridx.tsql
cridx_secform_xcluster.tsql
cridx_secform_xsecapp.tsql
cridx_secform_xujeesvlt.tsql
cridx_secgroup_xcluster.tsql
cridx_secgroup_xuname.tsql
cridx_secgroupform_xcluster.tsql
cridx_secgroupform_xgroup.tsql
cridx_secgroupform_xapp.tsql
cridx_secgroupform_xform.tsql
cridx_secgroupform_xuform.tsql
cridx_secinclude_xcluster.tsql
cridx_secinclude_xgroup.tsql
cridx_secinclude_xinc.tsql
cridx_secinclude_xuinc.tsql
cridx_secmember_xcluster.tsql
cridx_secmember_xgroup.tsql
cridx_secmember_xuser.tsql
cridx_secmember_xuuser.tsql
cridx_session_xsecuser.tsql
cridx_session_xsecdev.tsql
cridx_session_xstart.tsql
cridx_session_xfnsh.tsql
cridx_session_xproxy.tsql
cridx_secuser_xulogin.tsql
cridx_secuser_xemconf.tsql
cridx_secuser_xpwdrst.tsql
cridx_secuser_defdevidx.tsql
cridx_secscope_xuname.tsql
cridx_srvlfunc_rettblk.tsql
cridx_srvmeth_xuname.tsql
cridx_srvmeth_tableidx.tsql
cridx_srvmeth_defschidx.tsql
cridx_srvofunc_rettblk.tsql
cridx_service_xcluster.tsql
cridx_service_xhost.tsql
cridx_service_xtype.tsql
cridx_service_xutype.tsql
cridx_service_xuhpt.tsql
cridx_servicetype_xudsc.tsql
cridx_strcol_xtable.tsql
cridx_strtyp_xschemadef.tsql
cridx_sprjdef_pprjidx.tsql
cridx_sprjdef_unameidx.tsql
cridx_sysclus_xclus.tsql
cridx_tsecgroup_xtenant.tsql
cridx_tsecgroup_xuname.tsql
cridx_tsecinclude_xtenant.tsql
cridx_tsecinclude_xgroup.tsql
cridx_tsecinclude_xinc.tsql
cridx_tsecinclude_xuinc.tsql
cridx_tsecmember_xtenant.tsql
cridx_tsecmember_xgroup.tsql
cridx_tsecmember_xuser.tsql
cridx_tsecmember_xuuser.tsql
cridx_dzcol_xtable.tsql
cridx_dztyp_xschemadef.tsql
cridx_tmzcol_xtable.tsql
cridx_tmztyp_xschemadef.tsql
cridx_zscol_xtable.tsql
cridx_zstyp_xschemadef.tsql
cridx_tbldef_schemaidx.tsql
cridx_tbldef_defschidx.tsql
cridx_table_xuname.tsql
cridx_tabledef_xscd.tsql
cridx_def_tbl_xpidx.tsql
cridx_def_tbl_xlookupidx.tsql
cridx_def_tbl_xaltidx.tsql
cridx_def_tbl_xqtblidx.tsql
cridx_tabledef_xloadbehave.tsql
cridx_tabledef_xdatascope.tsql
cridx_tabledef_xsecscope.tsql
cridx_tabledef_xviewaccsec.tsql
cridx_tabledef_xviewaccfreq.tsql
cridx_tabledef_xeditaccsec.tsql
cridx_tabledef_xeditaccfreq.tsql
cridx_tblcol_xtable.tsql
cridx_tablecol_xdata.tsql
cridx_tenant_xcluster.tsql
cridx_tenant_xuname.tsql
cridx_txtcol_xtable.tsql
cridx_txttyp_xschemadef.tsql
cridx_tmcol_xtable.tsql
cridx_tmtyp_xschemadef.tsql
cridx_tscol_xtable.tsql
cridx_tstyp_xschemadef.tsql
cridx_tlddef_tenantidx.tsql
cridx_tlddef_unameidx.tsql
cridx_tkncol_xtable.tsql
cridx_tkntyp_xschemadef.tsql
cridx_tdomdef_tldidx.tsql
cridx_tdomdef_unameidx.tsql
cridx_tprjdef_domidx.tsql
cridx_tprjdef_unameidx.tsql
cridx_uint16col_xtable.tsql
cridx_uint16typ_xschemadef.tsql
cridx_uint32col_xtable.tsql
cridx_uint32typ_xschemadef.tsql
cridx_uint64col_xtable.tsql
cridx_uint64typ_xschemadef.tsql
cridx_urlproto_xuname.tsql
cridx_urlproto_xsecure.tsql
cridx_uuidcol_xtable.tsql
cridx_idguuid_dpk_def.tsql
cridx_uuidtyp_xschemadef.tsql
cridx_valdef_xuname.tsql
cridx_valdef_tenantidx.tsql
cridx_valdef_scopeidx.tsql
cridx_value_defschidx.tsql
cridx_valuedef_xdatascope.tsql
cridx_valuedef_xviewaccsec.tsql
cridx_valuedef_xviewaccfreq.tsql
cridx_valuedef_xeditaccsec.tsql
cridx_valuedef_xeditaccfreq.tsql
cridx_valuedef_xprev.tsql
cridx_valuedef_xnext.tsql
cridx_valuedef_xcontprev.tsql
cridx_valuedef_xcontnext.tsql
	The individual table index creation scripts called by cridx_cfbam23.tsql.

crsp_next_servicetypeidgen.tsql
crsp_next_mimetypeidgen.tsql
crsp_next_clusteridgen.tsql
crsp_next_tenantidgen.tsql
	The stored procedures for getting the next schema id from the generators.

crsp_next_clus_secappidgen.tsql
crsp_next_clus_secformidgen.tsql
crsp_next_clus_secgroupidgen.tsql
crsp_next_clus_secgroupmemberidgen.tsql
crsp_next_clus_secgroupincludeidgen.tsql
crsp_next_clus_secgroupformidgen.tsql
crsp_next_clus_serviceidgen.tsql
crsp_next_clus_hostnodeidgen.tsql
crsp_next_tenant_tsecgroupidgen.tsql
crsp_next_tenant_tsecgroupmemberidgen.tsql
crsp_next_tenant_tsecgroupincludeidgen.tsql
crsp_next_tenant_tldidgen.tsql
crsp_next_tenant_domainidgen.tsql
crsp_next_tenant_scopeidgen.tsql
crsp_next_tenant_indexcolidgen.tsql
crsp_next_tenant_licenseidgen.tsql
crsp_next_tenant_relationcolidgen.tsql
crsp_next_tenant_valueidgen.tsql
crsp_next_tenant_enumtagidgen.tsql
crsp_next_tenant_chainidgen.tsql
crsp_next_tenant_paramidgen.tsql
	The stored procedures for getting the next table-dispenssed id from the generators.


Database Drop Scripts
---------------------

drdb_cfbam23.tsql
	Drops the id generators, tables, indexes and constraints
	of the database.

dridg_cfbam23.tsql
	Drops the database id generator objects.

drtbl_cfbam23.tsql
	Drops the database tables.

dridx_cfbam23.tsql
	Drops the database table indexes.

drrel_cfbam23.tsql
	Drops the relationships between the tables.
