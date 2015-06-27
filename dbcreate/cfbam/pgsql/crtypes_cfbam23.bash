#!/bin/bash
#
#	@(#) dbcreate/cfbam/pgsql/crtypes_cfbam23.bash
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
pgdb=""
pghost=""
pgport=""
pgpwd=""
pgsrv=""
pguser=""
logfilename=""
parmerrors=""
TK_DUALCASE_IN_CASE_STATEMENTS=true

#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case "$1" in

		-d)
			shift
			pgdb=$1
			shift
			;;

		-L)
			shift
			logfilename=$1
			shift
			;;

		-H)
			shift
			pghost=$1
			shift
			;;

		-p)
			shift
			pgport=$1
			shift
			;;

		-P)
			shift
			pgpwd=$1
			shift
			;;

		-S)
			shift
			pgsrv=$1
			shift
			;;

		-U)
			shift
			pguser=$1
			shift
			;;

		*)
			echo >&2 "ERROR: Option $1 not recognized."
			parmerrors="Y"
			shift
			;;
	esac
done

#
#	Validate parameters
#

if [ "${pguser}" = "" ]; then
	echo >&2 "ERROR: User must be specified with '-U username'"
	parmerrors="Y"
fi

if [ "${pgpwd}" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	parmerrors="Y"
fi

if [ "${pghost}" = "" ]; then
	echo >&2 "ERROR: Server host name must be specified with '-H hostname'"
	parmerrors="Y"
fi

if [ "${pgdb}" = "" ]; then
	echo >&2 "ERROR: Database name must be specified with '-d dbname'"
	parmerrors="Y"
fi

if [ "${parmerrors}" != "" ]; then
	echo >&2 "ABORT: Cannot continue"
	exit 1
fi

if [ "${logfilename}" = "" ]; then
	logfilename=`date +'crtypes_cfbam23-%Y%m%d_%Hh%M.log'`
	echo "" >$logfilename
fi

export PGPASSWORD="${pgpwd}"

if [ "${pgport}" != "" ]; then
	export PGPORT="--port=${pgport} "
	export PASSPGPORT="-p ${pgport} "
else
	export PGPORT=""
	export PASSPGPORT=""
fi

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_cfbam23_cc_rec.pgsql >>$logfilename 2>&1
psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_accfreq_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_accsec_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_atomdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_auditaction_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_blbcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_blbdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_blbtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_boolcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_booldef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_booltyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_chain_def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clr_dep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clrsubdep1_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clrsubdep2_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clrsubdep3_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clr_topdep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_clus_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_datascope_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dtcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dtdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dttyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_del_dep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_delsubdep1_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_delsubdep2_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_delsubdep3_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_del_topdep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_domdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_bdomdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dblcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dbldef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dbltyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_enumcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_enumdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_enum_tag_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_enumtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_fltcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_fltdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_flttyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_hostnode_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_iso_cntry_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_iso_cntryccy_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_iso_cntrylng_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_iso_ccy_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_iso_lang_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_isotz_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idg16_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idg32_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idg64_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idxdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idxcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int16col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int16def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int16typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int32col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int32def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int32typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int64col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int64def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_int64typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_licn_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_loadbehav_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_mjverdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_mimetype_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_mnverdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtkncol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtkndef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtkntyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtknscol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtknsdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_nmtknstyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_numcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_numdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_numtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_srvprm_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_pop_dep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_popsubdep1_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_popsubdep2_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_popsubdep3_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_pop_topdep_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_bprjdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_rprjdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_reldef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_relcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_rel_type_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_schemadef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_schema_ref_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_scopedef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secapp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secdev_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secform_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secgrp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secgrpfrm_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secinc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secmemb_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secsess_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secuser_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_secscope_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_srvlfunc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_srvmeth_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_srvofunc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_srvprc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_hostsvc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_svctype_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_strcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_strdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_strtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_sprjdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_sysclus_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tsecgrp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tsecinc_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tsecmemb_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dzcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dzdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_dztyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmzcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmzdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmztyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_zscol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_zsdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_zstyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tbldef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tblcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tenant_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_txtcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_txtdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_txttyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tmtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tscol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tsdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tstyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tlddef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tkncol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tkndef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tkntyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tdomdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_tprjdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint16col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_u16def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint16typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint32col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_u32def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint32typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint64col_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_u64def_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uint64typ_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_urlproto_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uuidcol_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uuiddef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_idguuid_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_uuidtyp_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_valdef_rec.pgsql >>$logfilename 2>&1

psql -h ${pghost} ${PGPORT} -d ${pgdb} -U ${pguser} -a -e -f crtype_verndef_rec.pgsql >>$logfilename 2>&1


