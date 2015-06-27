#!/bin/bash
#
#	@(#) dbcreate/cfbam/sybase/crtbl_cfbam23.bash
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
#	logfilename=`date +'crtbl_cfbam23-%Y%m%d_%Hh%M.log'`
	logfilename="crtbl_cfbam23.log"
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

$cmdappdb <crtbl_cfbam23_idg32.isql >>$logfilename
$cmdappdb <crtbl_cfbam23_idg64.isql >>$logfilename
$cmdappdb <crtbl_clus.isql >>$logfilename
$cmdappdb <crtbl_clus_idg32.isql >>$logfilename
$cmdappdb <crtbl_clus_idg64.isql >>$logfilename
$cmdappdb <crtbl_secapp.isql >>$logfilename
$cmdappdb <crtbl_secform.isql >>$logfilename
$cmdappdb <crtbl_secgrp.isql >>$logfilename
$cmdappdb <crtbl_secgrpfrm.isql >>$logfilename
$cmdappdb <crtbl_secinc.isql >>$logfilename
$cmdappdb <crtbl_secmemb.isql >>$logfilename
$cmdappdb <crtbl_secsess.isql >>$logfilename
$cmdappdb <crtbl_secuser.isql >>$logfilename
$cmdappdb <crtbl_tenant.isql >>$logfilename
$cmdappdb <crtbl_tenant_idg32.isql >>$logfilename
$cmdappdb <crtbl_tenant_idg64.isql >>$logfilename
$cmdappdb <crtbl_accfreq.isql >>$logfilename
$cmdappdb <crtbl_accsec.isql >>$logfilename
$cmdappdb <crtbl_atomdef.isql >>$logfilename
$cmdappdb <crtbl_auditaction.isql >>$logfilename
$cmdappdb <crtbl_blbcol.isql >>$logfilename
$cmdappdb <crtbl_blbdef.isql >>$logfilename
$cmdappdb <crtbl_blbtyp.isql >>$logfilename
$cmdappdb <crtbl_boolcol.isql >>$logfilename
$cmdappdb <crtbl_booldef.isql >>$logfilename
$cmdappdb <crtbl_booltyp.isql >>$logfilename
$cmdappdb <crtbl_chain_def.isql >>$logfilename
$cmdappdb <crtbl_clr_dep.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep1.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep2.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep3.isql >>$logfilename
$cmdappdb <crtbl_clr_topdep.isql >>$logfilename
$cmdappdb <crtbl_datascope.isql >>$logfilename
$cmdappdb <crtbl_dtcol.isql >>$logfilename
$cmdappdb <crtbl_dtdef.isql >>$logfilename
$cmdappdb <crtbl_dttyp.isql >>$logfilename
$cmdappdb <crtbl_del_dep.isql >>$logfilename
$cmdappdb <crtbl_delsubdep1.isql >>$logfilename
$cmdappdb <crtbl_delsubdep2.isql >>$logfilename
$cmdappdb <crtbl_delsubdep3.isql >>$logfilename
$cmdappdb <crtbl_del_topdep.isql >>$logfilename
$cmdappdb <crtbl_domdef.isql >>$logfilename
$cmdappdb <crtbl_bdomdef.isql >>$logfilename
$cmdappdb <crtbl_dblcol.isql >>$logfilename
$cmdappdb <crtbl_dbldef.isql >>$logfilename
$cmdappdb <crtbl_dbltyp.isql >>$logfilename
$cmdappdb <crtbl_enumcol.isql >>$logfilename
$cmdappdb <crtbl_enumdef.isql >>$logfilename
$cmdappdb <crtbl_enum_tag.isql >>$logfilename
$cmdappdb <crtbl_enumtyp.isql >>$logfilename
$cmdappdb <crtbl_fltcol.isql >>$logfilename
$cmdappdb <crtbl_fltdef.isql >>$logfilename
$cmdappdb <crtbl_flttyp.isql >>$logfilename
$cmdappdb <crtbl_hostnode.isql >>$logfilename
$cmdappdb <crtbl_iso_cntry.isql >>$logfilename
$cmdappdb <crtbl_iso_cntryccy.isql >>$logfilename
$cmdappdb <crtbl_iso_cntrylng.isql >>$logfilename
$cmdappdb <crtbl_iso_ccy.isql >>$logfilename
$cmdappdb <crtbl_iso_lang.isql >>$logfilename
$cmdappdb <crtbl_isotz.isql >>$logfilename
$cmdappdb <crtbl_idg16.isql >>$logfilename
$cmdappdb <crtbl_idg32.isql >>$logfilename
$cmdappdb <crtbl_idg64.isql >>$logfilename
$cmdappdb <crtbl_idxdef.isql >>$logfilename
$cmdappdb <crtbl_idxcol.isql >>$logfilename
$cmdappdb <crtbl_int16col.isql >>$logfilename
$cmdappdb <crtbl_int16def.isql >>$logfilename
$cmdappdb <crtbl_int16typ.isql >>$logfilename
$cmdappdb <crtbl_int32col.isql >>$logfilename
$cmdappdb <crtbl_int32def.isql >>$logfilename
$cmdappdb <crtbl_int32typ.isql >>$logfilename
$cmdappdb <crtbl_int64col.isql >>$logfilename
$cmdappdb <crtbl_int64def.isql >>$logfilename
$cmdappdb <crtbl_int64typ.isql >>$logfilename
$cmdappdb <crtbl_licn.isql >>$logfilename
$cmdappdb <crtbl_loadbehav.isql >>$logfilename
$cmdappdb <crtbl_mjverdef.isql >>$logfilename
$cmdappdb <crtbl_mimetype.isql >>$logfilename
$cmdappdb <crtbl_mnverdef.isql >>$logfilename
$cmdappdb <crtbl_nmtkncol.isql >>$logfilename
$cmdappdb <crtbl_nmtkndef.isql >>$logfilename
$cmdappdb <crtbl_nmtkntyp.isql >>$logfilename
$cmdappdb <crtbl_nmtknscol.isql >>$logfilename
$cmdappdb <crtbl_nmtknsdef.isql >>$logfilename
$cmdappdb <crtbl_nmtknstyp.isql >>$logfilename
$cmdappdb <crtbl_numcol.isql >>$logfilename
$cmdappdb <crtbl_numdef.isql >>$logfilename
$cmdappdb <crtbl_numtyp.isql >>$logfilename
$cmdappdb <crtbl_srvprm.isql >>$logfilename
$cmdappdb <crtbl_pop_dep.isql >>$logfilename
$cmdappdb <crtbl_popsubdep1.isql >>$logfilename
$cmdappdb <crtbl_popsubdep2.isql >>$logfilename
$cmdappdb <crtbl_popsubdep3.isql >>$logfilename
$cmdappdb <crtbl_pop_topdep.isql >>$logfilename
$cmdappdb <crtbl_bprjdef.isql >>$logfilename
$cmdappdb <crtbl_rprjdef.isql >>$logfilename
$cmdappdb <crtbl_reldef.isql >>$logfilename
$cmdappdb <crtbl_relcol.isql >>$logfilename
$cmdappdb <crtbl_rel_type.isql >>$logfilename
$cmdappdb <crtbl_schemadef.isql >>$logfilename
$cmdappdb <crtbl_schema_ref.isql >>$logfilename
$cmdappdb <crtbl_scopedef.isql >>$logfilename
$cmdappdb <crtbl_secdev.isql >>$logfilename
$cmdappdb <crtbl_secscope.isql >>$logfilename
$cmdappdb <crtbl_srvlfunc.isql >>$logfilename
$cmdappdb <crtbl_srvmeth.isql >>$logfilename
$cmdappdb <crtbl_srvofunc.isql >>$logfilename
$cmdappdb <crtbl_srvprc.isql >>$logfilename
$cmdappdb <crtbl_hostsvc.isql >>$logfilename
$cmdappdb <crtbl_svctype.isql >>$logfilename
$cmdappdb <crtbl_strcol.isql >>$logfilename
$cmdappdb <crtbl_strdef.isql >>$logfilename
$cmdappdb <crtbl_strtyp.isql >>$logfilename
$cmdappdb <crtbl_sprjdef.isql >>$logfilename
$cmdappdb <crtbl_sysclus.isql >>$logfilename
$cmdappdb <crtbl_tsecgrp.isql >>$logfilename
$cmdappdb <crtbl_tsecinc.isql >>$logfilename
$cmdappdb <crtbl_tsecmemb.isql >>$logfilename
$cmdappdb <crtbl_dzcol.isql >>$logfilename
$cmdappdb <crtbl_dzdef.isql >>$logfilename
$cmdappdb <crtbl_dztyp.isql >>$logfilename
$cmdappdb <crtbl_tmzcol.isql >>$logfilename
$cmdappdb <crtbl_tmzdef.isql >>$logfilename
$cmdappdb <crtbl_tmztyp.isql >>$logfilename
$cmdappdb <crtbl_zscol.isql >>$logfilename
$cmdappdb <crtbl_zsdef.isql >>$logfilename
$cmdappdb <crtbl_zstyp.isql >>$logfilename
$cmdappdb <crtbl_tbldef.isql >>$logfilename
$cmdappdb <crtbl_tblcol.isql >>$logfilename
$cmdappdb <crtbl_txtcol.isql >>$logfilename
$cmdappdb <crtbl_txtdef.isql >>$logfilename
$cmdappdb <crtbl_txttyp.isql >>$logfilename
$cmdappdb <crtbl_tmcol.isql >>$logfilename
$cmdappdb <crtbl_tmdef.isql >>$logfilename
$cmdappdb <crtbl_tmtyp.isql >>$logfilename
$cmdappdb <crtbl_tscol.isql >>$logfilename
$cmdappdb <crtbl_tsdef.isql >>$logfilename
$cmdappdb <crtbl_tstyp.isql >>$logfilename
$cmdappdb <crtbl_tlddef.isql >>$logfilename
$cmdappdb <crtbl_tkncol.isql >>$logfilename
$cmdappdb <crtbl_tkndef.isql >>$logfilename
$cmdappdb <crtbl_tkntyp.isql >>$logfilename
$cmdappdb <crtbl_tdomdef.isql >>$logfilename
$cmdappdb <crtbl_tprjdef.isql >>$logfilename
$cmdappdb <crtbl_uint16col.isql >>$logfilename
$cmdappdb <crtbl_u16def.isql >>$logfilename
$cmdappdb <crtbl_uint16typ.isql >>$logfilename
$cmdappdb <crtbl_uint32col.isql >>$logfilename
$cmdappdb <crtbl_u32def.isql >>$logfilename
$cmdappdb <crtbl_uint32typ.isql >>$logfilename
$cmdappdb <crtbl_uint64col.isql >>$logfilename
$cmdappdb <crtbl_u64def.isql >>$logfilename
$cmdappdb <crtbl_uint64typ.isql >>$logfilename
$cmdappdb <crtbl_urlproto.isql >>$logfilename
$cmdappdb <crtbl_uuidcol.isql >>$logfilename
$cmdappdb <crtbl_uuiddef.isql >>$logfilename
$cmdappdb <crtbl_idguuid.isql >>$logfilename
$cmdappdb <crtbl_uuidtyp.isql >>$logfilename
$cmdappdb <crtbl_valdef.isql >>$logfilename
$cmdappdb <crtbl_verndef.isql >>$logfilename
$cmdappdb <crtbl_atomdef_h.isql >>$logfilename
$cmdappdb <crtbl_blbcol_h.isql >>$logfilename
$cmdappdb <crtbl_blbdef_h.isql >>$logfilename
$cmdappdb <crtbl_blbtyp_h.isql >>$logfilename
$cmdappdb <crtbl_boolcol_h.isql >>$logfilename
$cmdappdb <crtbl_booldef_h.isql >>$logfilename
$cmdappdb <crtbl_booltyp_h.isql >>$logfilename
$cmdappdb <crtbl_chain_def_h.isql >>$logfilename
$cmdappdb <crtbl_clr_dep_h.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep1_h.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep2_h.isql >>$logfilename
$cmdappdb <crtbl_clrsubdep3_h.isql >>$logfilename
$cmdappdb <crtbl_clr_topdep_h.isql >>$logfilename
$cmdappdb <crtbl_clus_h.isql >>$logfilename
$cmdappdb <crtbl_dtcol_h.isql >>$logfilename
$cmdappdb <crtbl_dtdef_h.isql >>$logfilename
$cmdappdb <crtbl_dttyp_h.isql >>$logfilename
$cmdappdb <crtbl_del_dep_h.isql >>$logfilename
$cmdappdb <crtbl_delsubdep1_h.isql >>$logfilename
$cmdappdb <crtbl_delsubdep2_h.isql >>$logfilename
$cmdappdb <crtbl_delsubdep3_h.isql >>$logfilename
$cmdappdb <crtbl_del_topdep_h.isql >>$logfilename
$cmdappdb <crtbl_domdef_h.isql >>$logfilename
$cmdappdb <crtbl_bdomdef_h.isql >>$logfilename
$cmdappdb <crtbl_dblcol_h.isql >>$logfilename
$cmdappdb <crtbl_dbldef_h.isql >>$logfilename
$cmdappdb <crtbl_dbltyp_h.isql >>$logfilename
$cmdappdb <crtbl_enumcol_h.isql >>$logfilename
$cmdappdb <crtbl_enumdef_h.isql >>$logfilename
$cmdappdb <crtbl_enum_tag_h.isql >>$logfilename
$cmdappdb <crtbl_enumtyp_h.isql >>$logfilename
$cmdappdb <crtbl_fltcol_h.isql >>$logfilename
$cmdappdb <crtbl_fltdef_h.isql >>$logfilename
$cmdappdb <crtbl_flttyp_h.isql >>$logfilename
$cmdappdb <crtbl_hostnode_h.isql >>$logfilename
$cmdappdb <crtbl_iso_cntry_h.isql >>$logfilename
$cmdappdb <crtbl_iso_cntryccy_h.isql >>$logfilename
$cmdappdb <crtbl_iso_cntrylng_h.isql >>$logfilename
$cmdappdb <crtbl_iso_ccy_h.isql >>$logfilename
$cmdappdb <crtbl_iso_lang_h.isql >>$logfilename
$cmdappdb <crtbl_isotz_h.isql >>$logfilename
$cmdappdb <crtbl_idg16_h.isql >>$logfilename
$cmdappdb <crtbl_idg32_h.isql >>$logfilename
$cmdappdb <crtbl_idg64_h.isql >>$logfilename
$cmdappdb <crtbl_idxdef_h.isql >>$logfilename
$cmdappdb <crtbl_idxcol_h.isql >>$logfilename
$cmdappdb <crtbl_int16col_h.isql >>$logfilename
$cmdappdb <crtbl_int16def_h.isql >>$logfilename
$cmdappdb <crtbl_int16typ_h.isql >>$logfilename
$cmdappdb <crtbl_int32col_h.isql >>$logfilename
$cmdappdb <crtbl_int32def_h.isql >>$logfilename
$cmdappdb <crtbl_int32typ_h.isql >>$logfilename
$cmdappdb <crtbl_int64col_h.isql >>$logfilename
$cmdappdb <crtbl_int64def_h.isql >>$logfilename
$cmdappdb <crtbl_int64typ_h.isql >>$logfilename
$cmdappdb <crtbl_mjverdef_h.isql >>$logfilename
$cmdappdb <crtbl_mimetype_h.isql >>$logfilename
$cmdappdb <crtbl_mnverdef_h.isql >>$logfilename
$cmdappdb <crtbl_nmtkncol_h.isql >>$logfilename
$cmdappdb <crtbl_nmtkndef_h.isql >>$logfilename
$cmdappdb <crtbl_nmtkntyp_h.isql >>$logfilename
$cmdappdb <crtbl_nmtknscol_h.isql >>$logfilename
$cmdappdb <crtbl_nmtknsdef_h.isql >>$logfilename
$cmdappdb <crtbl_nmtknstyp_h.isql >>$logfilename
$cmdappdb <crtbl_numcol_h.isql >>$logfilename
$cmdappdb <crtbl_numdef_h.isql >>$logfilename
$cmdappdb <crtbl_numtyp_h.isql >>$logfilename
$cmdappdb <crtbl_srvprm_h.isql >>$logfilename
$cmdappdb <crtbl_pop_dep_h.isql >>$logfilename
$cmdappdb <crtbl_popsubdep1_h.isql >>$logfilename
$cmdappdb <crtbl_popsubdep2_h.isql >>$logfilename
$cmdappdb <crtbl_popsubdep3_h.isql >>$logfilename
$cmdappdb <crtbl_pop_topdep_h.isql >>$logfilename
$cmdappdb <crtbl_bprjdef_h.isql >>$logfilename
$cmdappdb <crtbl_rprjdef_h.isql >>$logfilename
$cmdappdb <crtbl_reldef_h.isql >>$logfilename
$cmdappdb <crtbl_relcol_h.isql >>$logfilename
$cmdappdb <crtbl_schemadef_h.isql >>$logfilename
$cmdappdb <crtbl_schema_ref_h.isql >>$logfilename
$cmdappdb <crtbl_scopedef_h.isql >>$logfilename
$cmdappdb <crtbl_secapp_h.isql >>$logfilename
$cmdappdb <crtbl_secdev_h.isql >>$logfilename
$cmdappdb <crtbl_secform_h.isql >>$logfilename
$cmdappdb <crtbl_secgrp_h.isql >>$logfilename
$cmdappdb <crtbl_secgrpfrm_h.isql >>$logfilename
$cmdappdb <crtbl_secinc_h.isql >>$logfilename
$cmdappdb <crtbl_secmemb_h.isql >>$logfilename
$cmdappdb <crtbl_secuser_h.isql >>$logfilename
$cmdappdb <crtbl_srvlfunc_h.isql >>$logfilename
$cmdappdb <crtbl_srvmeth_h.isql >>$logfilename
$cmdappdb <crtbl_srvofunc_h.isql >>$logfilename
$cmdappdb <crtbl_srvprc_h.isql >>$logfilename
$cmdappdb <crtbl_hostsvc_h.isql >>$logfilename
$cmdappdb <crtbl_svctype_h.isql >>$logfilename
$cmdappdb <crtbl_strcol_h.isql >>$logfilename
$cmdappdb <crtbl_strdef_h.isql >>$logfilename
$cmdappdb <crtbl_strtyp_h.isql >>$logfilename
$cmdappdb <crtbl_sprjdef_h.isql >>$logfilename
$cmdappdb <crtbl_tsecgrp_h.isql >>$logfilename
$cmdappdb <crtbl_tsecinc_h.isql >>$logfilename
$cmdappdb <crtbl_tsecmemb_h.isql >>$logfilename
$cmdappdb <crtbl_dzcol_h.isql >>$logfilename
$cmdappdb <crtbl_dzdef_h.isql >>$logfilename
$cmdappdb <crtbl_dztyp_h.isql >>$logfilename
$cmdappdb <crtbl_tmzcol_h.isql >>$logfilename
$cmdappdb <crtbl_tmzdef_h.isql >>$logfilename
$cmdappdb <crtbl_tmztyp_h.isql >>$logfilename
$cmdappdb <crtbl_zscol_h.isql >>$logfilename
$cmdappdb <crtbl_zsdef_h.isql >>$logfilename
$cmdappdb <crtbl_zstyp_h.isql >>$logfilename
$cmdappdb <crtbl_tbldef_h.isql >>$logfilename
$cmdappdb <crtbl_tblcol_h.isql >>$logfilename
$cmdappdb <crtbl_tenant_h.isql >>$logfilename
$cmdappdb <crtbl_txtcol_h.isql >>$logfilename
$cmdappdb <crtbl_txtdef_h.isql >>$logfilename
$cmdappdb <crtbl_txttyp_h.isql >>$logfilename
$cmdappdb <crtbl_tmcol_h.isql >>$logfilename
$cmdappdb <crtbl_tmdef_h.isql >>$logfilename
$cmdappdb <crtbl_tmtyp_h.isql >>$logfilename
$cmdappdb <crtbl_tscol_h.isql >>$logfilename
$cmdappdb <crtbl_tsdef_h.isql >>$logfilename
$cmdappdb <crtbl_tstyp_h.isql >>$logfilename
$cmdappdb <crtbl_tlddef_h.isql >>$logfilename
$cmdappdb <crtbl_tkncol_h.isql >>$logfilename
$cmdappdb <crtbl_tkndef_h.isql >>$logfilename
$cmdappdb <crtbl_tkntyp_h.isql >>$logfilename
$cmdappdb <crtbl_tdomdef_h.isql >>$logfilename
$cmdappdb <crtbl_tprjdef_h.isql >>$logfilename
$cmdappdb <crtbl_uint16col_h.isql >>$logfilename
$cmdappdb <crtbl_u16def_h.isql >>$logfilename
$cmdappdb <crtbl_uint16typ_h.isql >>$logfilename
$cmdappdb <crtbl_uint32col_h.isql >>$logfilename
$cmdappdb <crtbl_u32def_h.isql >>$logfilename
$cmdappdb <crtbl_uint32typ_h.isql >>$logfilename
$cmdappdb <crtbl_uint64col_h.isql >>$logfilename
$cmdappdb <crtbl_u64def_h.isql >>$logfilename
$cmdappdb <crtbl_uint64typ_h.isql >>$logfilename
$cmdappdb <crtbl_urlproto_h.isql >>$logfilename
$cmdappdb <crtbl_uuidcol_h.isql >>$logfilename
$cmdappdb <crtbl_uuiddef_h.isql >>$logfilename
$cmdappdb <crtbl_idguuid_h.isql >>$logfilename
$cmdappdb <crtbl_uuidtyp_h.isql >>$logfilename
$cmdappdb <crtbl_valdef_h.isql >>$logfilename
$cmdappdb <crtbl_verndef_h.isql >>$logfilename

