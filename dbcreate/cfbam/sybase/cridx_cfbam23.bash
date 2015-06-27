#!/bin/bash
#
#	@(#) dbcreate/cfbam/sybase/cridx_cfbam23.bash
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
#	Initialize locals
#
sybdb=""
sybpwd=""
sybsrv=""
sybuser=""
logfilename=""

#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case $1 in

		-D)
			shift
			sybdb=$1
			shift
			;;

		-L)
			shift
			logfilename=$1
			shift
			;;

		-P)
			shift
			sybpwd=$1
			shift
			;;

		-S)
			shift
			sybsrv=$1
			shift
			;;

		-U)
			shift
			sybuser=$1
			shift
			;;

		*)
			echo >&2 "ERROR: Option $1 not recognized."
			exit 1
			;;
	esac
done

#
#	Validate parameters
#

if [ "$sybuser" = "" ]; then
	echo >&2 "ERROR: User must be specified with '-U username'"
	exit 1
fi

if [ "$sybpwd" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	exit 1
fi

if [ "$sybsrv" = "" ]; then
	if [ "$DSQUERY" = "" ]; then
		echo >&2 "ERROR: Server was not specified with '-S server' and DSQUERY is not set"
		exit 1
	fi
fi

if [ "$sybdb" = "" ]; then
	echo >&2 "WARNING: Database was not specified with '-D database', using default for $sybuser"
	exit 1
fi

if [ "$logfilename" = "" ]; then
#	logfilename=`date +'cridx_cfbam23-%Y%m%d_%Hh%M.log'`
	logfilename="cridx_cfbam23.log"
	echo "" >$logfilename
fi

#
#	Define commands to use for running scripts
#

if [ "$sybsrv" = "" ]; then
	if [ "$sybdb" = "" ]; then
		connectargs="-U $sybuser -P $sybpwd"
		dbargs=""
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	else
		connectargs="-U $sybuser -P $sybpwd"
		dbargs="-D $sybdb"
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	fi
else
	if [ "$sybdb" = "" ]; then
		connectargs="-S $sybsrv -U $sybuser -P $sybpwd"
		dbargs=""
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	else
		connectargs="-S $sybsrv -U $sybuser -P $sybpwd"
		dbargs="-D $sybdb"
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	fi
fi

$cmdappdb <cridx_accfreq_xuname.isql >>$logfilename
$cmdappdb <cridx_accsec_xuname.isql >>$logfilename
$cmdappdb <cridx_auditaction_xudsc.isql >>$logfilename
$cmdappdb <cridx_blbcol_xtable.isql >>$logfilename
$cmdappdb <cridx_blbtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_boolcol_xtable.isql >>$logfilename
$cmdappdb <cridx_booltyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_chain_xtent.isql >>$logfilename
$cmdappdb <cridx_chain_xtbl.isql >>$logfilename
$cmdappdb <cridx_chain_defschidx.isql >>$logfilename
$cmdappdb <cridx_chain_xuname.isql >>$logfilename
$cmdappdb <cridx_chain_xprevrel.isql >>$logfilename
$cmdappdb <cridx_chain_xnextrel.isql >>$logfilename
$cmdappdb <cridx_clrdep_xrel.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_xcdeltopdep.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_uname.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_xcdeldep1.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_uname.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_xcdeldep2.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_uname.isql >>$logfilename
$cmdappdb <cridx_clrtop_xctbl.isql >>$logfilename
$cmdappdb <cridx_clrtopdep_uname.isql >>$logfilename
$cmdappdb <cridx_cluster_xufdname.isql >>$logfilename
$cmdappdb <cridx_cluster_xudescr.isql >>$logfilename
$cmdappdb <cridx_datascope_xuname.isql >>$logfilename
$cmdappdb <cridx_dtcol_xtable.isql >>$logfilename
$cmdappdb <cridx_dttyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_deldep_defschidx.isql >>$logfilename
$cmdappdb <cridx_deldep_xrel.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_xcdeltopdep.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_uname.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_xcdeldep1.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_uname.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_xcdeldep2.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_uname.isql >>$logfilename
$cmdappdb <cridx_deltop_xctbl.isql >>$logfilename
$cmdappdb <cridx_deltop_uname.isql >>$logfilename
$cmdappdb <cridx_domdef_subdomidx.isql >>$logfilename
$cmdappdb <cridx_domdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_bdomdef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_xtable.isql >>$logfilename
$cmdappdb <cridx_dbltyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_enumcol_xtable.isql >>$logfilename
$cmdappdb <cridx_enumtag_xtenant.isql >>$logfilename
$cmdappdb <cridx_enumtag_xenum.isql >>$logfilename
$cmdappdb <cridx_enumtag_defschidx.isql >>$logfilename
$cmdappdb <cridx_enumtag_uenumnm.isql >>$logfilename
$cmdappdb <cridx_enumtag_xprev.isql >>$logfilename
$cmdappdb <cridx_enumtag_xnext.isql >>$logfilename
$cmdappdb <cridx_enumtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_fltcol_xtable.isql >>$logfilename
$cmdappdb <cridx_flttyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_hostnode_xcluster.isql >>$logfilename
$cmdappdb <cridx_hostnode_xudsc.isql >>$logfilename
$cmdappdb <cridx_hostnode_xhnm.isql >>$logfilename
$cmdappdb <cridx_isocountry_xcode.isql >>$logfilename
$cmdappdb <cridx_isocountry_xuname.isql >>$logfilename
$cmdappdb <cridx_isocountryccy_xcountry.isql >>$logfilename
$cmdappdb <cridx_isocountryccy_xccy.isql >>$logfilename
$cmdappdb <cridx_isocountrylang_xcountry.isql >>$logfilename
$cmdappdb <cridx_isocountrylang_xlang.isql >>$logfilename
$cmdappdb <cridx_isocurrency_xcode.isql >>$logfilename
$cmdappdb <cridx_isocurrency_xuname.isql >>$logfilename
$cmdappdb <cridx_isolang_xbase.isql >>$logfilename
$cmdappdb <cridx_isolang_xcntry.isql >>$logfilename
$cmdappdb <cridx_isolang_xcode.isql >>$logfilename
$cmdappdb <cridx_itz_xoffset.isql >>$logfilename
$cmdappdb <cridx_itz_xuname.isql >>$logfilename
$cmdappdb <cridx_itz_xiso.isql >>$logfilename
$cmdappdb <cridx_idg16_dpk_def.isql >>$logfilename
$cmdappdb <cridx_idg32_dpk_def.isql >>$logfilename
$cmdappdb <cridx_idg64_dpk_def.isql >>$logfilename
$cmdappdb <cridx_idxdef_xuname.isql >>$logfilename
$cmdappdb <cridx_idxdef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_tableidx.isql >>$logfilename
$cmdappdb <cridx_index_defschidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_xuname.isql >>$logfilename
$cmdappdb <cridx_idxcol_tenantidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_indexidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_defschidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_col_def.isql >>$logfilename
$cmdappdb <cridx_idxcol_xprev.isql >>$logfilename
$cmdappdb <cridx_idxcol_xnext.isql >>$logfilename
$cmdappdb <cridx_idxcol_xidxprev.isql >>$logfilename
$cmdappdb <cridx_idxcol_xidxnext.isql >>$logfilename
$cmdappdb <cridx_int16col_xtable.isql >>$logfilename
$cmdappdb <cridx_int16typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_int32col_xtable.isql >>$logfilename
$cmdappdb <cridx_int32typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_int64col_xtable.isql >>$logfilename
$cmdappdb <cridx_int64typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_lic_xtenant.isql >>$logfilename
$cmdappdb <cridx_lic_xdom.isql >>$logfilename
$cmdappdb <cridx_lic_xuname.isql >>$logfilename
$cmdappdb <cridx_loadbehav_xuname.isql >>$logfilename
$cmdappdb <cridx_mjverdef_pprjidx.isql >>$logfilename
$cmdappdb <cridx_mjverdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_mimetype_xuname.isql >>$logfilename
$cmdappdb <cridx_mnverdef_majoridx.isql >>$logfilename
$cmdappdb <cridx_mnverdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_xtable.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_xtable.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_numcol_xtable.isql >>$logfilename
$cmdappdb <cridx_numtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_srvprm_xuname.isql >>$logfilename
$cmdappdb <cridx_srvprm_tenantidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_srvmethk.isql >>$logfilename
$cmdappdb <cridx_srvprm_defschidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_typek.isql >>$logfilename
$cmdappdb <cridx_srvprm_xprev.isql >>$logfilename
$cmdappdb <cridx_srvprm_xnext.isql >>$logfilename
$cmdappdb <cridx_srvprm_xcontprev.isql >>$logfilename
$cmdappdb <cridx_srvprm_xcontnext.isql >>$logfilename
$cmdappdb <cridx_popdep_xrel.isql >>$logfilename
$cmdappdb <cridx_popdep_defschidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_xcpoptopdep.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_uname.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_xcpopdep1.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_uname.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_xcpopdep2.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_uname.isql >>$logfilename
$cmdappdb <cridx_poptop_xcrel.isql >>$logfilename
$cmdappdb <cridx_poptop_uname.isql >>$logfilename
$cmdappdb <cridx_reldef_xuname.isql >>$logfilename
$cmdappdb <cridx_reldef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_reldef_tableidx.isql >>$logfilename
$cmdappdb <cridx_reldef_defschidx.isql >>$logfilename
$cmdappdb <cridx_reldef_xrtypekey.isql >>$logfilename
$cmdappdb <cridx_reldef_xfromkey.isql >>$logfilename
$cmdappdb <cridx_reldef_xtotbl.isql >>$logfilename
$cmdappdb <cridx_reldef_xtokey.isql >>$logfilename
$cmdappdb <cridx_reldef_xnarrowed.isql >>$logfilename
$cmdappdb <cridx_relcol_xuname.isql >>$logfilename
$cmdappdb <cridx_relcol_tenantidx.isql >>$logfilename
$cmdappdb <cridx_relcol_relk.isql >>$logfilename
$cmdappdb <cridx_relcol_defschidx.isql >>$logfilename
$cmdappdb <cridx_relcol_fromk.isql >>$logfilename
$cmdappdb <cridx_relcol_tok.isql >>$logfilename
$cmdappdb <cridx_relcol_xprev.isql >>$logfilename
$cmdappdb <cridx_relcol_xnext.isql >>$logfilename
$cmdappdb <cridx_relcol_xrelprev.isql >>$logfilename
$cmdappdb <cridx_relcol_xrelnext.isql >>$logfilename
$cmdappdb <cridx_rel_type_utagidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_ctenantidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_domainidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_xuname.isql >>$logfilename
$cmdappdb <cridx_schemadef_xdeflcn.isql >>$logfilename
$cmdappdb <cridx_schemadef_xdatascope.isql >>$logfilename
$cmdappdb <cridx_schemadef_xviewaccsec.isql >>$logfilename
$cmdappdb <cridx_schemadef_xviewaccfreq.isql >>$logfilename
$cmdappdb <cridx_schemadef_xeditaccsec.isql >>$logfilename
$cmdappdb <cridx_schemadef_xeditaccfreq.isql >>$logfilename
$cmdappdb <cridx_schemadef_xupuburi.isql >>$logfilename
$cmdappdb <cridx_schemaref_schk.isql >>$logfilename
$cmdappdb <cridx_schemaref_uname.isql >>$logfilename
$cmdappdb <cridx_schemaref_rsck.isql >>$logfilename
$cmdappdb <cridx_scopedef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_secapp_xcluster.isql >>$logfilename
$cmdappdb <cridx_secapp_xujeemnt.isql >>$logfilename
$cmdappdb <cridx_secdev_usridx.isql >>$logfilename
$cmdappdb <cridx_secform_xcluster.isql >>$logfilename
$cmdappdb <cridx_secform_xsecapp.isql >>$logfilename
$cmdappdb <cridx_secform_xujeesvlt.isql >>$logfilename
$cmdappdb <cridx_secgroup_xcluster.isql >>$logfilename
$cmdappdb <cridx_secgroup_xuname.isql >>$logfilename
$cmdappdb <cridx_secgroupform_xcluster.isql >>$logfilename
$cmdappdb <cridx_secgroupform_xgroup.isql >>$logfilename
$cmdappdb <cridx_secgroupform_xapp.isql >>$logfilename
$cmdappdb <cridx_secgroupform_xform.isql >>$logfilename
$cmdappdb <cridx_secgroupform_xuform.isql >>$logfilename
$cmdappdb <cridx_secinclude_xcluster.isql >>$logfilename
$cmdappdb <cridx_secinclude_xgroup.isql >>$logfilename
$cmdappdb <cridx_secinclude_xinc.isql >>$logfilename
$cmdappdb <cridx_secinclude_xuinc.isql >>$logfilename
$cmdappdb <cridx_secmember_xcluster.isql >>$logfilename
$cmdappdb <cridx_secmember_xgroup.isql >>$logfilename
$cmdappdb <cridx_secmember_xuser.isql >>$logfilename
$cmdappdb <cridx_secmember_xuuser.isql >>$logfilename
$cmdappdb <cridx_session_xsecuser.isql >>$logfilename
$cmdappdb <cridx_session_xsecdev.isql >>$logfilename
$cmdappdb <cridx_session_xstart.isql >>$logfilename
$cmdappdb <cridx_session_xfnsh.isql >>$logfilename
$cmdappdb <cridx_session_xproxy.isql >>$logfilename
$cmdappdb <cridx_secuser_xulogin.isql >>$logfilename
$cmdappdb <cridx_secuser_xemconf.isql >>$logfilename
$cmdappdb <cridx_secuser_xpwdrst.isql >>$logfilename
$cmdappdb <cridx_secuser_defdevidx.isql >>$logfilename
$cmdappdb <cridx_secscope_xuname.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_rettblk.isql >>$logfilename
$cmdappdb <cridx_srvmeth_xuname.isql >>$logfilename
$cmdappdb <cridx_srvmeth_tableidx.isql >>$logfilename
$cmdappdb <cridx_srvmeth_defschidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_rettblk.isql >>$logfilename
$cmdappdb <cridx_service_xcluster.isql >>$logfilename
$cmdappdb <cridx_service_xhost.isql >>$logfilename
$cmdappdb <cridx_service_xtype.isql >>$logfilename
$cmdappdb <cridx_service_xutype.isql >>$logfilename
$cmdappdb <cridx_service_xuhpt.isql >>$logfilename
$cmdappdb <cridx_servicetype_xudsc.isql >>$logfilename
$cmdappdb <cridx_strcol_xtable.isql >>$logfilename
$cmdappdb <cridx_strtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_sprjdef_pprjidx.isql >>$logfilename
$cmdappdb <cridx_sprjdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_sysclus_xclus.isql >>$logfilename
$cmdappdb <cridx_tsecgroup_xtenant.isql >>$logfilename
$cmdappdb <cridx_tsecgroup_xuname.isql >>$logfilename
$cmdappdb <cridx_tsecinclude_xtenant.isql >>$logfilename
$cmdappdb <cridx_tsecinclude_xgroup.isql >>$logfilename
$cmdappdb <cridx_tsecinclude_xinc.isql >>$logfilename
$cmdappdb <cridx_tsecinclude_xuinc.isql >>$logfilename
$cmdappdb <cridx_tsecmember_xtenant.isql >>$logfilename
$cmdappdb <cridx_tsecmember_xgroup.isql >>$logfilename
$cmdappdb <cridx_tsecmember_xuser.isql >>$logfilename
$cmdappdb <cridx_tsecmember_xuuser.isql >>$logfilename
$cmdappdb <cridx_dzcol_xtable.isql >>$logfilename
$cmdappdb <cridx_dztyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tmzcol_xtable.isql >>$logfilename
$cmdappdb <cridx_tmztyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_zscol_xtable.isql >>$logfilename
$cmdappdb <cridx_zstyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tbldef_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_defschidx.isql >>$logfilename
$cmdappdb <cridx_table_xuname.isql >>$logfilename
$cmdappdb <cridx_tabledef_xscd.isql >>$logfilename
$cmdappdb <cridx_def_tbl_xpidx.isql >>$logfilename
$cmdappdb <cridx_def_tbl_xlookupidx.isql >>$logfilename
$cmdappdb <cridx_def_tbl_xaltidx.isql >>$logfilename
$cmdappdb <cridx_def_tbl_xqtblidx.isql >>$logfilename
$cmdappdb <cridx_tabledef_xloadbehave.isql >>$logfilename
$cmdappdb <cridx_tabledef_xdatascope.isql >>$logfilename
$cmdappdb <cridx_tabledef_xsecscope.isql >>$logfilename
$cmdappdb <cridx_tabledef_xviewaccsec.isql >>$logfilename
$cmdappdb <cridx_tabledef_xviewaccfreq.isql >>$logfilename
$cmdappdb <cridx_tabledef_xeditaccsec.isql >>$logfilename
$cmdappdb <cridx_tabledef_xeditaccfreq.isql >>$logfilename
$cmdappdb <cridx_tblcol_xtable.isql >>$logfilename
$cmdappdb <cridx_tablecol_xdata.isql >>$logfilename
$cmdappdb <cridx_tenant_xcluster.isql >>$logfilename
$cmdappdb <cridx_tenant_xuname.isql >>$logfilename
$cmdappdb <cridx_txtcol_xtable.isql >>$logfilename
$cmdappdb <cridx_txttyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tmcol_xtable.isql >>$logfilename
$cmdappdb <cridx_tmtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tscol_xtable.isql >>$logfilename
$cmdappdb <cridx_tstyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tlddef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tlddef_unameidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_xtable.isql >>$logfilename
$cmdappdb <cridx_tkntyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_tdomdef_tldidx.isql >>$logfilename
$cmdappdb <cridx_tdomdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_tprjdef_domidx.isql >>$logfilename
$cmdappdb <cridx_tprjdef_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_xtable.isql >>$logfilename
$cmdappdb <cridx_uint16typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_uint32col_xtable.isql >>$logfilename
$cmdappdb <cridx_uint32typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_uint64col_xtable.isql >>$logfilename
$cmdappdb <cridx_uint64typ_xschemadef.isql >>$logfilename
$cmdappdb <cridx_urlproto_xuname.isql >>$logfilename
$cmdappdb <cridx_urlproto_xsecure.isql >>$logfilename
$cmdappdb <cridx_uuidcol_xtable.isql >>$logfilename
$cmdappdb <cridx_idguuid_dpk_def.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_xschemadef.isql >>$logfilename
$cmdappdb <cridx_valdef_xuname.isql >>$logfilename
$cmdappdb <cridx_valdef_tenantidx.isql >>$logfilename
$cmdappdb <cridx_valdef_scopeidx.isql >>$logfilename
$cmdappdb <cridx_value_defschidx.isql >>$logfilename
$cmdappdb <cridx_valuedef_xdatascope.isql >>$logfilename
$cmdappdb <cridx_valuedef_xviewaccsec.isql >>$logfilename
$cmdappdb <cridx_valuedef_xviewaccfreq.isql >>$logfilename
$cmdappdb <cridx_valuedef_xeditaccsec.isql >>$logfilename
$cmdappdb <cridx_valuedef_xeditaccfreq.isql >>$logfilename
$cmdappdb <cridx_valuedef_xprev.isql >>$logfilename
$cmdappdb <cridx_valuedef_xnext.isql >>$logfilename
$cmdappdb <cridx_valuedef_xcontprev.isql >>$logfilename
$cmdappdb <cridx_valuedef_xcontnext.isql >>$logfilename

