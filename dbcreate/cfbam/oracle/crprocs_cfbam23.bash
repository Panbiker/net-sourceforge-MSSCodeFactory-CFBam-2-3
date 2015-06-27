#!/bin/bash
#
#	@(#) dbcreate/cfbam/oracle/crprocs_cfbam23.bash
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
orahost=""
oraport=""
orapwd=""
oraservice=""
orauser=""
logfilename=""
parmerrors=""
TK_DUALCASE_IN_CASE_STATEMENTS=true

#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case "$1" in

		-L)
			shift
			logfilename=$1
			shift
			;;

		-H)
			shift
			orahost=$1
			shift
			;;

		-P)
			shift
			orapwd=$1
			shift
			;;

		-p)
			shift
			oraport=$1
			shift
			;;

		-S)
			shift
			oraservice=$1
			shift
			;;

		-U)
			shift
			orauser=$1
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

if [ "${orauser}" = "" ]; then
	echo >&2 "ERROR: User must be specified with '-U username'"
	parmerrors="Y"
fi

if [ "${orapwd}" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	parmerrors="Y"
fi

if [ "${parmerrors}" != "" ]; then
	echo >&2 "ABORT: Cannot continue"
	exit 1
fi

if [ "${logfilename}" = "" ]; then
	logfilename=`date +'crprocs_cfbam23-%Y%m%d_%Hh%M.log'`
	echo "" >$logfilename
fi

if [ "${orahost}" = "" ]; then
	export sqlpluscmd="sqlplus ${orauser}/${orapwd} "
else
	if [ "${oraport}" = "" ]; then
		if [ "${oraservice}" = "" ]; then
			export sqlpluscmd="sqlplus ${orauser}/${orapwd}@//${orahost} "
		else
			export sqlpluscmd="sqlplus ${orauser}/${orapwd}@//${orahost}/${oraservice} "
		fi
	else
		if [ "${oraservice}" = "" ]; then
			export sqlpluscmd="sqlplus ${orauser}/${orapwd}@//${orahost}:${oraport} "
		else
			export sqlpluscmd="sqlplus ${orauser}/${orapwd}@//${orahost}:${oraport}/${oraservice} "
		fi
	fi
fi

echo "#crsp_is_system_user.plsql" >>${logfilename}
${sqlpluscmd} <crsp_is_system_user.plsql >>${logfilename} 2>&1
echo "#crsp_is_cluster_user.plsql" >>${logfilename}
${sqlpluscmd} <crsp_is_cluster_user.plsql >>${logfilename} 2>&1
echo "#crsp_is_tenant_user.plsql" >>${logfilename}
${sqlpluscmd} <crsp_is_tenant_user.plsql >>${logfilename} 2>&1
echo "#	crnxt_servicetypeidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_servicetypeidgen.plsql >>$logfilename 2>&1
echo "#	crnxt_mimetypeidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_mimetypeidgen.plsql >>$logfilename 2>&1
echo "#	crnxt_clusteridgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_clusteridgen.plsql >>$logfilename 2>&1
echo "#	crnxt_tenantidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_tenantidgen.plsql >>$logfilename 2>&1
echo "#	crnxt_secappidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_secappidgen.plsql >>$logfilename 2>&1
echo "#	crnxt_secformidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_secformidgen.plsql >>$logfilename 2>&1
echo "#	crnxt_secgroupidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_secgroupidgen.plsql >>$logfilename 2>&1
echo "# crnxt_secgroupmemberidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_secgroupmemberidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_secgroupincludeidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_secgroupincludeidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_secgroupformidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_secgroupformidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_serviceidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_serviceidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_hostnodeidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_hostnodeidgen.plsql >>${logfilename} 2>&1
echo "#	crnxt_tsecgroupidgen.plsql" >>${logfilename}
${sqlpluscmd} < crnxt_tsecgroupidgen.plsql >>$logfilename 2>&1
echo "# crnxt_tsecgroupmemberidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_tsecgroupmemberidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_tsecgroupincludeidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_tsecgroupincludeidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_tldidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_tldidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_domainidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_domainidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_scopeidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_scopeidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_indexcolidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_indexcolidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_licenseidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_licenseidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_relationcolidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_relationcolidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_valueidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_valueidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_enumtagidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_enumtagidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_chainidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_chainidgen.plsql >>${logfilename} 2>&1
echo "# crnxt_paramidgen.plsql" >>$logfilename 2>&1
${sqlpluscmd} <crnxt_paramidgen.plsql >>${logfilename} 2>&1
echo "#crsp_bootstrap.plsql" >>${logfilename}
${sqlpluscmd} <crsp_bootstrap.plsql >>${logfilename} 2>&1

echo "#	craud_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < craud_enum_tag.plsql >>$logfilename 2>&1
echo "#	craud_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < craud_idxcol.plsql >>$logfilename 2>&1
echo "#	craud_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < craud_srvprm.plsql >>$logfilename 2>&1
echo "#	craud_relcol.plsql" >>${logfilename}
${sqlpluscmd} < craud_relcol.plsql >>$logfilename 2>&1
echo "#	craud_valdef.plsql" >>${logfilename}
${sqlpluscmd} < craud_valdef.plsql >>$logfilename 2>&1

echo "#	crcrt_accfreq.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_accfreq.plsql >>$logfilename 2>&1
echo "#	crcrt_accsec.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_accsec.plsql >>$logfilename 2>&1
echo "#	crcrt_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_atomdef.plsql >>$logfilename 2>&1
echo "#	crcrt_auditaction.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_auditaction.plsql >>$logfilename 2>&1
echo "#	crcrt_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_boolcol.plsql >>$logfilename 2>&1
echo "#	crcrt_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_booldef.plsql >>$logfilename 2>&1
echo "#	crcrt_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_booltyp.plsql >>$logfilename 2>&1
echo "#	crcrt_chain_def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_chain_def.plsql >>$logfilename 2>&1
echo "#	crcrt_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clr_dep.plsql >>$logfilename 2>&1
echo "#	crcrt_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clrsubdep1.plsql >>$logfilename 2>&1
echo "#	crcrt_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clrsubdep2.plsql >>$logfilename 2>&1
echo "#	crcrt_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clrsubdep3.plsql >>$logfilename 2>&1
echo "#	crcrt_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clr_topdep.plsql >>$logfilename 2>&1
echo "#	crcrt_clus.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_clus.plsql >>$logfilename 2>&1
echo "#	crcrt_datascope.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_datascope.plsql >>$logfilename 2>&1
echo "#	crcrt_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dtcol.plsql >>$logfilename 2>&1
echo "#	crcrt_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dtdef.plsql >>$logfilename 2>&1
echo "#	crcrt_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dttyp.plsql >>$logfilename 2>&1
echo "#	crcrt_del_dep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_del_dep.plsql >>$logfilename 2>&1
echo "#	crcrt_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_delsubdep1.plsql >>$logfilename 2>&1
echo "#	crcrt_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_delsubdep2.plsql >>$logfilename 2>&1
echo "#	crcrt_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_delsubdep3.plsql >>$logfilename 2>&1
echo "#	crcrt_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_del_topdep.plsql >>$logfilename 2>&1
echo "#	crcrt_domdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_domdef.plsql >>$logfilename 2>&1
echo "#	crcrt_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_bdomdef.plsql >>$logfilename 2>&1
echo "#	crcrt_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dblcol.plsql >>$logfilename 2>&1
echo "#	crcrt_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dbldef.plsql >>$logfilename 2>&1
echo "#	crcrt_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dbltyp.plsql >>$logfilename 2>&1
echo "#	crcrt_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_enumcol.plsql >>$logfilename 2>&1
echo "#	crcrt_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_enumdef.plsql >>$logfilename 2>&1
echo "#	crcrt_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_enum_tag.plsql >>$logfilename 2>&1
echo "#	crcrt_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_enumtyp.plsql >>$logfilename 2>&1
echo "#	crcrt_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_fltcol.plsql >>$logfilename 2>&1
echo "#	crcrt_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_fltdef.plsql >>$logfilename 2>&1
echo "#	crcrt_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_flttyp.plsql >>$logfilename 2>&1
echo "#	crcrt_hostnode.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_hostnode.plsql >>$logfilename 2>&1
echo "#	crcrt_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_iso_cntry.plsql >>$logfilename 2>&1
echo "#	crcrt_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_iso_cntryccy.plsql >>$logfilename 2>&1
echo "#	crcrt_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_iso_cntrylng.plsql >>$logfilename 2>&1
echo "#	crcrt_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_iso_ccy.plsql >>$logfilename 2>&1
echo "#	crcrt_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_iso_lang.plsql >>$logfilename 2>&1
echo "#	crcrt_isotz.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_isotz.plsql >>$logfilename 2>&1
echo "#	crcrt_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idg16.plsql >>$logfilename 2>&1
echo "#	crcrt_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idg32.plsql >>$logfilename 2>&1
echo "#	crcrt_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idg64.plsql >>$logfilename 2>&1
echo "#	crcrt_idxdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idxdef.plsql >>$logfilename 2>&1
echo "#	crcrt_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idxcol.plsql >>$logfilename 2>&1
echo "#	crcrt_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int16col.plsql >>$logfilename 2>&1
echo "#	crcrt_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int16def.plsql >>$logfilename 2>&1
echo "#	crcrt_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int16typ.plsql >>$logfilename 2>&1
echo "#	crcrt_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int32col.plsql >>$logfilename 2>&1
echo "#	crcrt_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int32def.plsql >>$logfilename 2>&1
echo "#	crcrt_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int32typ.plsql >>$logfilename 2>&1
echo "#	crcrt_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int64col.plsql >>$logfilename 2>&1
echo "#	crcrt_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int64def.plsql >>$logfilename 2>&1
echo "#	crcrt_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_int64typ.plsql >>$logfilename 2>&1
echo "#	crcrt_licn.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_licn.plsql >>$logfilename 2>&1
echo "#	crcrt_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_loadbehav.plsql >>$logfilename 2>&1
echo "#	crcrt_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_mjverdef.plsql >>$logfilename 2>&1
echo "#	crcrt_mimetype.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_mimetype.plsql >>$logfilename 2>&1
echo "#	crcrt_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_mnverdef.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crcrt_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crcrt_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_numcol.plsql >>$logfilename 2>&1
echo "#	crcrt_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_numdef.plsql >>$logfilename 2>&1
echo "#	crcrt_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_numtyp.plsql >>$logfilename 2>&1
echo "#	crcrt_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_srvprm.plsql >>$logfilename 2>&1
echo "#	crcrt_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_pop_dep.plsql >>$logfilename 2>&1
echo "#	crcrt_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_popsubdep1.plsql >>$logfilename 2>&1
echo "#	crcrt_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_popsubdep2.plsql >>$logfilename 2>&1
echo "#	crcrt_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_popsubdep3.plsql >>$logfilename 2>&1
echo "#	crcrt_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_pop_topdep.plsql >>$logfilename 2>&1
echo "#	crcrt_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_bprjdef.plsql >>$logfilename 2>&1
echo "#	crcrt_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_rprjdef.plsql >>$logfilename 2>&1
echo "#	crcrt_reldef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_reldef.plsql >>$logfilename 2>&1
echo "#	crcrt_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_relcol.plsql >>$logfilename 2>&1
echo "#	crcrt_rel_type.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_rel_type.plsql >>$logfilename 2>&1
echo "#	crcrt_schemadef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_schemadef.plsql >>$logfilename 2>&1
echo "#	crcrt_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_schema_ref.plsql >>$logfilename 2>&1
echo "#	crcrt_scopedef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_scopedef.plsql >>$logfilename 2>&1
echo "#	crcrt_secapp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secapp.plsql >>$logfilename 2>&1
echo "#	crcrt_secdev.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secdev.plsql >>$logfilename 2>&1
echo "#	crcrt_secform.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secform.plsql >>$logfilename 2>&1
echo "#	crcrt_secgrp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secgrp.plsql >>$logfilename 2>&1
echo "#	crcrt_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secgrpfrm.plsql >>$logfilename 2>&1
echo "#	crcrt_secinc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secinc.plsql >>$logfilename 2>&1
echo "#	crcrt_secmemb.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secmemb.plsql >>$logfilename 2>&1
echo "#	crcrt_secsess.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secsess.plsql >>$logfilename 2>&1
echo "#	crcrt_secuser.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secuser.plsql >>$logfilename 2>&1
echo "#	crcrt_secscope.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_secscope.plsql >>$logfilename 2>&1
echo "#	crcrt_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_srvlfunc.plsql >>$logfilename 2>&1
echo "#	crcrt_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_srvmeth.plsql >>$logfilename 2>&1
echo "#	crcrt_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_srvofunc.plsql >>$logfilename 2>&1
echo "#	crcrt_srvprc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_srvprc.plsql >>$logfilename 2>&1
echo "#	crcrt_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_hostsvc.plsql >>$logfilename 2>&1
echo "#	crcrt_svctype.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_svctype.plsql >>$logfilename 2>&1
echo "#	crcrt_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_strcol.plsql >>$logfilename 2>&1
echo "#	crcrt_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_strdef.plsql >>$logfilename 2>&1
echo "#	crcrt_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_strtyp.plsql >>$logfilename 2>&1
echo "#	crcrt_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_sprjdef.plsql >>$logfilename 2>&1
echo "#	crcrt_sysclus.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_sysclus.plsql >>$logfilename 2>&1
echo "#	crcrt_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tsecgrp.plsql >>$logfilename 2>&1
echo "#	crcrt_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tsecinc.plsql >>$logfilename 2>&1
echo "#	crcrt_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tsecmemb.plsql >>$logfilename 2>&1
echo "#	crcrt_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dzcol.plsql >>$logfilename 2>&1
echo "#	crcrt_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dzdef.plsql >>$logfilename 2>&1
echo "#	crcrt_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_dztyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmzcol.plsql >>$logfilename 2>&1
echo "#	crcrt_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmzdef.plsql >>$logfilename 2>&1
echo "#	crcrt_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmztyp.plsql >>$logfilename 2>&1
echo "#	crcrt_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_zscol.plsql >>$logfilename 2>&1
echo "#	crcrt_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_zsdef.plsql >>$logfilename 2>&1
echo "#	crcrt_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_zstyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tbldef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tbldef.plsql >>$logfilename 2>&1
echo "#	crcrt_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tblcol.plsql >>$logfilename 2>&1
echo "#	crcrt_tenant.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tenant.plsql >>$logfilename 2>&1
echo "#	crcrt_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_txtcol.plsql >>$logfilename 2>&1
echo "#	crcrt_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_txtdef.plsql >>$logfilename 2>&1
echo "#	crcrt_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_txttyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmcol.plsql >>$logfilename 2>&1
echo "#	crcrt_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmdef.plsql >>$logfilename 2>&1
echo "#	crcrt_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tmtyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tscol.plsql >>$logfilename 2>&1
echo "#	crcrt_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tsdef.plsql >>$logfilename 2>&1
echo "#	crcrt_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tstyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tlddef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tlddef.plsql >>$logfilename 2>&1
echo "#	crcrt_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tkncol.plsql >>$logfilename 2>&1
echo "#	crcrt_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tkndef.plsql >>$logfilename 2>&1
echo "#	crcrt_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tkntyp.plsql >>$logfilename 2>&1
echo "#	crcrt_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tdomdef.plsql >>$logfilename 2>&1
echo "#	crcrt_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_tprjdef.plsql >>$logfilename 2>&1
echo "#	crcrt_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint16col.plsql >>$logfilename 2>&1
echo "#	crcrt_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_u16def.plsql >>$logfilename 2>&1
echo "#	crcrt_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint16typ.plsql >>$logfilename 2>&1
echo "#	crcrt_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint32col.plsql >>$logfilename 2>&1
echo "#	crcrt_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_u32def.plsql >>$logfilename 2>&1
echo "#	crcrt_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint32typ.plsql >>$logfilename 2>&1
echo "#	crcrt_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint64col.plsql >>$logfilename 2>&1
echo "#	crcrt_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_u64def.plsql >>$logfilename 2>&1
echo "#	crcrt_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uint64typ.plsql >>$logfilename 2>&1
echo "#	crcrt_urlproto.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_urlproto.plsql >>$logfilename 2>&1
echo "#	crcrt_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uuidcol.plsql >>$logfilename 2>&1
echo "#	crcrt_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uuiddef.plsql >>$logfilename 2>&1
echo "#	crcrt_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_idguuid.plsql >>$logfilename 2>&1
echo "#	crcrt_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crcrt_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_valdef.plsql >>$logfilename 2>&1
echo "#	crcrt_verndef.plsql" >>${logfilename}
${sqlpluscmd} < crcrt_verndef.plsql >>$logfilename 2>&1

echo "#	crlck_accfreq.plsql" >>${logfilename}
${sqlpluscmd} < crlck_accfreq.plsql >>$logfilename 2>&1
echo "#	crlck_accsec.plsql" >>${logfilename}
${sqlpluscmd} < crlck_accsec.plsql >>$logfilename 2>&1
echo "#	crlck_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_atomdef.plsql >>$logfilename 2>&1
echo "#	crlck_auditaction.plsql" >>${logfilename}
${sqlpluscmd} < crlck_auditaction.plsql >>$logfilename 2>&1
echo "#	crlck_blbcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_blbcol.plsql >>$logfilename 2>&1
echo "#	crlck_blbdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_blbdef.plsql >>$logfilename 2>&1
echo "#	crlck_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_blbtyp.plsql >>$logfilename 2>&1
echo "#	crlck_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_boolcol.plsql >>$logfilename 2>&1
echo "#	crlck_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_booldef.plsql >>$logfilename 2>&1
echo "#	crlck_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_booltyp.plsql >>$logfilename 2>&1
echo "#	crlck_chain_def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_chain_def.plsql >>$logfilename 2>&1
echo "#	crlck_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clr_dep.plsql >>$logfilename 2>&1
echo "#	crlck_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clrsubdep1.plsql >>$logfilename 2>&1
echo "#	crlck_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clrsubdep2.plsql >>$logfilename 2>&1
echo "#	crlck_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clrsubdep3.plsql >>$logfilename 2>&1
echo "#	crlck_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clr_topdep.plsql >>$logfilename 2>&1
echo "#	crlck_clus.plsql" >>${logfilename}
${sqlpluscmd} < crlck_clus.plsql >>$logfilename 2>&1
echo "#	crlck_datascope.plsql" >>${logfilename}
${sqlpluscmd} < crlck_datascope.plsql >>$logfilename 2>&1
echo "#	crlck_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dtcol.plsql >>$logfilename 2>&1
echo "#	crlck_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dtdef.plsql >>$logfilename 2>&1
echo "#	crlck_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dttyp.plsql >>$logfilename 2>&1
echo "#	crlck_del_dep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_del_dep.plsql >>$logfilename 2>&1
echo "#	crlck_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crlck_delsubdep1.plsql >>$logfilename 2>&1
echo "#	crlck_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crlck_delsubdep2.plsql >>$logfilename 2>&1
echo "#	crlck_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crlck_delsubdep3.plsql >>$logfilename 2>&1
echo "#	crlck_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_del_topdep.plsql >>$logfilename 2>&1
echo "#	crlck_domdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_domdef.plsql >>$logfilename 2>&1
echo "#	crlck_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_bdomdef.plsql >>$logfilename 2>&1
echo "#	crlck_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dblcol.plsql >>$logfilename 2>&1
echo "#	crlck_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dbldef.plsql >>$logfilename 2>&1
echo "#	crlck_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dbltyp.plsql >>$logfilename 2>&1
echo "#	crlck_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_enumcol.plsql >>$logfilename 2>&1
echo "#	crlck_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_enumdef.plsql >>$logfilename 2>&1
echo "#	crlck_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crlck_enum_tag.plsql >>$logfilename 2>&1
echo "#	crlck_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_enumtyp.plsql >>$logfilename 2>&1
echo "#	crlck_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_fltcol.plsql >>$logfilename 2>&1
echo "#	crlck_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_fltdef.plsql >>$logfilename 2>&1
echo "#	crlck_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_flttyp.plsql >>$logfilename 2>&1
echo "#	crlck_hostnode.plsql" >>${logfilename}
${sqlpluscmd} < crlck_hostnode.plsql >>$logfilename 2>&1
echo "#	crlck_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} < crlck_iso_cntry.plsql >>$logfilename 2>&1
echo "#	crlck_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} < crlck_iso_cntryccy.plsql >>$logfilename 2>&1
echo "#	crlck_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} < crlck_iso_cntrylng.plsql >>$logfilename 2>&1
echo "#	crlck_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} < crlck_iso_ccy.plsql >>$logfilename 2>&1
echo "#	crlck_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} < crlck_iso_lang.plsql >>$logfilename 2>&1
echo "#	crlck_isotz.plsql" >>${logfilename}
${sqlpluscmd} < crlck_isotz.plsql >>$logfilename 2>&1
echo "#	crlck_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idg16.plsql >>$logfilename 2>&1
echo "#	crlck_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idg32.plsql >>$logfilename 2>&1
echo "#	crlck_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idg64.plsql >>$logfilename 2>&1
echo "#	crlck_idxdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idxdef.plsql >>$logfilename 2>&1
echo "#	crlck_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idxcol.plsql >>$logfilename 2>&1
echo "#	crlck_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int16col.plsql >>$logfilename 2>&1
echo "#	crlck_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int16def.plsql >>$logfilename 2>&1
echo "#	crlck_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int16typ.plsql >>$logfilename 2>&1
echo "#	crlck_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int32col.plsql >>$logfilename 2>&1
echo "#	crlck_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int32def.plsql >>$logfilename 2>&1
echo "#	crlck_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int32typ.plsql >>$logfilename 2>&1
echo "#	crlck_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int64col.plsql >>$logfilename 2>&1
echo "#	crlck_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int64def.plsql >>$logfilename 2>&1
echo "#	crlck_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_int64typ.plsql >>$logfilename 2>&1
echo "#	crlck_licn.plsql" >>${logfilename}
${sqlpluscmd} < crlck_licn.plsql >>$logfilename 2>&1
echo "#	crlck_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} < crlck_loadbehav.plsql >>$logfilename 2>&1
echo "#	crlck_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_mjverdef.plsql >>$logfilename 2>&1
echo "#	crlck_mimetype.plsql" >>${logfilename}
${sqlpluscmd} < crlck_mimetype.plsql >>$logfilename 2>&1
echo "#	crlck_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_mnverdef.plsql >>$logfilename 2>&1
echo "#	crlck_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crlck_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crlck_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crlck_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crlck_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crlck_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crlck_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_numcol.plsql >>$logfilename 2>&1
echo "#	crlck_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_numdef.plsql >>$logfilename 2>&1
echo "#	crlck_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_numtyp.plsql >>$logfilename 2>&1
echo "#	crlck_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crlck_srvprm.plsql >>$logfilename 2>&1
echo "#	crlck_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_pop_dep.plsql >>$logfilename 2>&1
echo "#	crlck_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crlck_popsubdep1.plsql >>$logfilename 2>&1
echo "#	crlck_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crlck_popsubdep2.plsql >>$logfilename 2>&1
echo "#	crlck_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crlck_popsubdep3.plsql >>$logfilename 2>&1
echo "#	crlck_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crlck_pop_topdep.plsql >>$logfilename 2>&1
echo "#	crlck_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_bprjdef.plsql >>$logfilename 2>&1
echo "#	crlck_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_rprjdef.plsql >>$logfilename 2>&1
echo "#	crlck_reldef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_reldef.plsql >>$logfilename 2>&1
echo "#	crlck_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_relcol.plsql >>$logfilename 2>&1
echo "#	crlck_rel_type.plsql" >>${logfilename}
${sqlpluscmd} < crlck_rel_type.plsql >>$logfilename 2>&1
echo "#	crlck_schemadef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_schemadef.plsql >>$logfilename 2>&1
echo "#	crlck_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} < crlck_schema_ref.plsql >>$logfilename 2>&1
echo "#	crlck_scopedef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_scopedef.plsql >>$logfilename 2>&1
echo "#	crlck_secapp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secapp.plsql >>$logfilename 2>&1
echo "#	crlck_secdev.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secdev.plsql >>$logfilename 2>&1
echo "#	crlck_secform.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secform.plsql >>$logfilename 2>&1
echo "#	crlck_secgrp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secgrp.plsql >>$logfilename 2>&1
echo "#	crlck_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secgrpfrm.plsql >>$logfilename 2>&1
echo "#	crlck_secinc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secinc.plsql >>$logfilename 2>&1
echo "#	crlck_secmemb.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secmemb.plsql >>$logfilename 2>&1
echo "#	crlck_secsess.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secsess.plsql >>$logfilename 2>&1
echo "#	crlck_secuser.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secuser.plsql >>$logfilename 2>&1
echo "#	crlck_secscope.plsql" >>${logfilename}
${sqlpluscmd} < crlck_secscope.plsql >>$logfilename 2>&1
echo "#	crlck_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_srvlfunc.plsql >>$logfilename 2>&1
echo "#	crlck_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} < crlck_srvmeth.plsql >>$logfilename 2>&1
echo "#	crlck_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_srvofunc.plsql >>$logfilename 2>&1
echo "#	crlck_srvprc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_srvprc.plsql >>$logfilename 2>&1
echo "#	crlck_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_hostsvc.plsql >>$logfilename 2>&1
echo "#	crlck_svctype.plsql" >>${logfilename}
${sqlpluscmd} < crlck_svctype.plsql >>$logfilename 2>&1
echo "#	crlck_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_strcol.plsql >>$logfilename 2>&1
echo "#	crlck_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_strdef.plsql >>$logfilename 2>&1
echo "#	crlck_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_strtyp.plsql >>$logfilename 2>&1
echo "#	crlck_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_sprjdef.plsql >>$logfilename 2>&1
echo "#	crlck_sysclus.plsql" >>${logfilename}
${sqlpluscmd} < crlck_sysclus.plsql >>$logfilename 2>&1
echo "#	crlck_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tsecgrp.plsql >>$logfilename 2>&1
echo "#	crlck_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tsecinc.plsql >>$logfilename 2>&1
echo "#	crlck_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tsecmemb.plsql >>$logfilename 2>&1
echo "#	crlck_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dzcol.plsql >>$logfilename 2>&1
echo "#	crlck_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dzdef.plsql >>$logfilename 2>&1
echo "#	crlck_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_dztyp.plsql >>$logfilename 2>&1
echo "#	crlck_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmzcol.plsql >>$logfilename 2>&1
echo "#	crlck_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmzdef.plsql >>$logfilename 2>&1
echo "#	crlck_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmztyp.plsql >>$logfilename 2>&1
echo "#	crlck_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_zscol.plsql >>$logfilename 2>&1
echo "#	crlck_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_zsdef.plsql >>$logfilename 2>&1
echo "#	crlck_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_zstyp.plsql >>$logfilename 2>&1
echo "#	crlck_tbldef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tbldef.plsql >>$logfilename 2>&1
echo "#	crlck_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tblcol.plsql >>$logfilename 2>&1
echo "#	crlck_tenant.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tenant.plsql >>$logfilename 2>&1
echo "#	crlck_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_txtcol.plsql >>$logfilename 2>&1
echo "#	crlck_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_txtdef.plsql >>$logfilename 2>&1
echo "#	crlck_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_txttyp.plsql >>$logfilename 2>&1
echo "#	crlck_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmcol.plsql >>$logfilename 2>&1
echo "#	crlck_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmdef.plsql >>$logfilename 2>&1
echo "#	crlck_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tmtyp.plsql >>$logfilename 2>&1
echo "#	crlck_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tscol.plsql >>$logfilename 2>&1
echo "#	crlck_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tsdef.plsql >>$logfilename 2>&1
echo "#	crlck_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tstyp.plsql >>$logfilename 2>&1
echo "#	crlck_tlddef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tlddef.plsql >>$logfilename 2>&1
echo "#	crlck_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tkncol.plsql >>$logfilename 2>&1
echo "#	crlck_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tkndef.plsql >>$logfilename 2>&1
echo "#	crlck_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tkntyp.plsql >>$logfilename 2>&1
echo "#	crlck_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tdomdef.plsql >>$logfilename 2>&1
echo "#	crlck_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_tprjdef.plsql >>$logfilename 2>&1
echo "#	crlck_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint16col.plsql >>$logfilename 2>&1
echo "#	crlck_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_u16def.plsql >>$logfilename 2>&1
echo "#	crlck_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint16typ.plsql >>$logfilename 2>&1
echo "#	crlck_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint32col.plsql >>$logfilename 2>&1
echo "#	crlck_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_u32def.plsql >>$logfilename 2>&1
echo "#	crlck_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint32typ.plsql >>$logfilename 2>&1
echo "#	crlck_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint64col.plsql >>$logfilename 2>&1
echo "#	crlck_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crlck_u64def.plsql >>$logfilename 2>&1
echo "#	crlck_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uint64typ.plsql >>$logfilename 2>&1
echo "#	crlck_urlproto.plsql" >>${logfilename}
${sqlpluscmd} < crlck_urlproto.plsql >>$logfilename 2>&1
echo "#	crlck_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uuidcol.plsql >>$logfilename 2>&1
echo "#	crlck_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uuiddef.plsql >>$logfilename 2>&1
echo "#	crlck_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crlck_idguuid.plsql >>$logfilename 2>&1
echo "#	crlck_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crlck_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crlck_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_valdef.plsql >>$logfilename 2>&1
echo "#	crlck_verndef.plsql" >>${logfilename}
${sqlpluscmd} < crlck_verndef.plsql >>$logfilename 2>&1

echo "#	crrd_accfreq.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accfreq.plsql >>$logfilename 2>&1
echo "#	crrd_accfreqall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accfreqall.plsql >>$logfilename 2>&1
echo "#	crrd_accfreqbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accfreqbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_accfreqbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accfreqbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_accsec.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accsec.plsql >>$logfilename 2>&1
echo "#	crrd_accsecall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accsecall.plsql >>$logfilename 2>&1
echo "#	crrd_accsecbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accsecbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_accsecbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_accsecbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdef.plsql >>$logfilename 2>&1
echo "#	crrd_atomdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefall.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_atomdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_atomdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_auditaction.plsql" >>${logfilename}
${sqlpluscmd} < crrd_auditaction.plsql >>$logfilename 2>&1
echo "#	crrd_auditactionall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_auditactionall.plsql >>$logfilename 2>&1
echo "#	crrd_auditactionbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_auditactionbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_auditactionbyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_auditactionbyudescridx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcol.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolall.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdef.plsql >>$logfilename 2>&1
echo "#	crrd_blbdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefall.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtyp.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypall.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_blbtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_blbtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcol.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolall.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_boolcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_boolcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldef.plsql >>$logfilename 2>&1
echo "#	crrd_booldef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_booldefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefall.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccall.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booldefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booldefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltyp.plsql >>$logfilename 2>&1
echo "#	crrd_booltypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypall.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_booltypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_booltypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_def.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defall.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbyprevrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbyprevrelidx.plsql >>$logfilename 2>&1
echo "#	crrd_chain_defbynextrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_chain_defbynextrelidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_dep.plsql >>$logfilename 2>&1
echo "#	crrd_clr_dep_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_dep_cc.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depall.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depccall.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_depbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_depbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1all.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1bycontcleartopidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1bycontcleartopidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2all.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2bycontcleardep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2bycontcleardep1idx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3all.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3bycontcleardep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3bycontcleardep2idx.plsql >>$logfilename 2>&1
echo "#	crrd_clrsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clrsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdep.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepall.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepbyconttblidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepbyconttblidx.plsql >>$logfilename 2>&1
echo "#	crrd_clr_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clr_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_clus.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clus.plsql >>$logfilename 2>&1
echo "#	crrd_clusall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clusall.plsql >>$logfilename 2>&1
echo "#	crrd_clusbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clusbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_clusbyudomainnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clusbyudomainnameidx.plsql >>$logfilename 2>&1
echo "#	crrd_clusbyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_clusbyudescridx.plsql >>$logfilename 2>&1
echo "#	crrd_datascope.plsql" >>${logfilename}
${sqlpluscmd} < crrd_datascope.plsql >>$logfilename 2>&1
echo "#	crrd_datascopeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_datascopeall.plsql >>$logfilename 2>&1
echo "#	crrd_datascopebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_datascopebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_datascopebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_datascopebyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcol.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolall.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdef.plsql >>$logfilename 2>&1
echo "#	crrd_dtdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefall.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dtdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dtdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttyp.plsql >>$logfilename 2>&1
echo "#	crrd_dttypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypall.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_dep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_dep.plsql >>$logfilename 2>&1
echo "#	crrd_del_dep_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_dep_cc.plsql >>$logfilename 2>&1
echo "#	crrd_del_depall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depall.plsql >>$logfilename 2>&1
echo "#	crrd_del_depccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depccall.plsql >>$logfilename 2>&1
echo "#	crrd_del_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_del_depccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_del_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_depccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_depbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_depbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_depbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1all.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1bycontdeltopidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1bycontdeltopidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2all.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2bycontdeldep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2bycontdeldep1idx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3all.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3bytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3bycontdeldep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3bycontdeldep2idx.plsql >>$logfilename 2>&1
echo "#	crrd_delsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_delsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdep.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepall.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbyconttblidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbyconttblidx.plsql >>$logfilename 2>&1
echo "#	crrd_del_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_del_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_domdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdef.plsql >>$logfilename 2>&1
echo "#	crrd_domdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdefall.plsql >>$logfilename 2>&1
echo "#	crrd_domdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_domdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_domdefbysubdomidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdefbysubdomidx.plsql >>$logfilename 2>&1
echo "#	crrd_domdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_domdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdef.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefall.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_bdomdefccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bdomdefccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcol.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolall.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dblcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dblcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldef.plsql >>$logfilename 2>&1
echo "#	crrd_dbldef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefall.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccall.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbldefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbldefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltyp.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypall.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dbltypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dbltypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcol.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolall.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdef.plsql >>$logfilename 2>&1
echo "#	crrd_enumdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefall.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tag.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagall.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbyenumtagtenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbyenumtagtenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbyenumidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbyenumidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbyenumnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbyenumnameidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enum_tagbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enum_tagbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtyp.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypall.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_enumtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_enumtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcol.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolall.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdef.plsql >>$logfilename 2>&1
echo "#	crrd_fltdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefall.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_fltdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_fltdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttyp.plsql >>$logfilename 2>&1
echo "#	crrd_flttypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypall.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_flttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_flttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_hostnode.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnode.plsql >>$logfilename 2>&1
echo "#	crrd_hostnodeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnodeall.plsql >>$logfilename 2>&1
echo "#	crrd_hostnodebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnodebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_hostnodebyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnodebyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_hostnodebyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnodebyudescridx.plsql >>$logfilename 2>&1
echo "#	crrd_hostnodebyhostnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostnodebyhostnameidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntry.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryall.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrybyididx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrybyisocodeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrybyisocodeidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrybynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrybynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryccy.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryccyall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryccyall.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryccybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryccybyididx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryccybycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryccybycountryidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntryccybycurrencyidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntryccybycurrencyidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrylng.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrylngall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrylngall.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrylngbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrylngbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrylngbycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrylngbycountryidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_cntrylngbylanguageidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_cntrylngbylanguageidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_ccy.plsql >>$logfilename 2>&1
echo "#	crrd_iso_ccyall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_ccyall.plsql >>$logfilename 2>&1
echo "#	crrd_iso_ccybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_ccybyididx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_ccybyccycdidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_ccybyccycdidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_ccybyccynmidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_ccybyccynmidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_lang.plsql >>$logfilename 2>&1
echo "#	crrd_iso_langall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_langall.plsql >>$logfilename 2>&1
echo "#	crrd_iso_langbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_langbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_langbybaseidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_langbybaseidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_langbycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_langbycountryidx.plsql >>$logfilename 2>&1
echo "#	crrd_iso_langbycodeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_iso_langbycodeidx.plsql >>$logfilename 2>&1
echo "#	crrd_isotz.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotz.plsql >>$logfilename 2>&1
echo "#	crrd_isotzall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotzall.plsql >>$logfilename 2>&1
echo "#	crrd_isotzbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotzbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_isotzbyoffsetidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotzbyoffsetidx.plsql >>$logfilename 2>&1
echo "#	crrd_isotzbyutznameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotzbyutznameidx.plsql >>$logfilename 2>&1
echo "#	crrd_isotzbyiso8601idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_isotzbyiso8601idx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16.plsql >>$logfilename 2>&1
echo "#	crrd_idg16all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16all.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byididx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16byschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg16bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg16bydispidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32.plsql >>$logfilename 2>&1
echo "#	crrd_idg32all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32all.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byididx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32byschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg32bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg32bydispidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64.plsql >>$logfilename 2>&1
echo "#	crrd_idg64all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64all.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byididx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64byschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idg64bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idg64bydispidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdef.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefall.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbyindextenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbyindextenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcol.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolall.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyidxcoltenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyidxcoltenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyindexidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbycolidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbycolidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyidxprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyidxprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idxcolbyidxnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idxcolbyidxnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16col.plsql >>$logfilename 2>&1
echo "#	crrd_int16colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colall.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16def.plsql >>$logfilename 2>&1
echo "#	crrd_int16def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int16defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defall.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccall.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typ.plsql >>$logfilename 2>&1
echo "#	crrd_int16typ_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typ_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int16typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typall.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccall.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int16typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int16typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32col.plsql >>$logfilename 2>&1
echo "#	crrd_int32colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colall.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32def.plsql >>$logfilename 2>&1
echo "#	crrd_int32def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int32defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defall.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccall.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typ.plsql >>$logfilename 2>&1
echo "#	crrd_int32typ_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typ_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int32typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typall.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccall.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int32typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int32typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64col.plsql >>$logfilename 2>&1
echo "#	crrd_int64colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colall.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64def.plsql >>$logfilename 2>&1
echo "#	crrd_int64def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int64defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defall.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccall.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typ.plsql >>$logfilename 2>&1
echo "#	crrd_int64typ_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typ_cc.plsql >>$logfilename 2>&1
echo "#	crrd_int64typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typall.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccall.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_int64typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_int64typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_licn.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licn.plsql >>$logfilename 2>&1
echo "#	crrd_licnall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licnall.plsql >>$logfilename 2>&1
echo "#	crrd_licnbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licnbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_licnbylicntenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licnbylicntenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_licnbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licnbydomainidx.plsql >>$logfilename 2>&1
echo "#	crrd_licnbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_licnbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} < crrd_loadbehav.plsql >>$logfilename 2>&1
echo "#	crrd_loadbehavall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_loadbehavall.plsql >>$logfilename 2>&1
echo "#	crrd_loadbehavbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_loadbehavbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_loadbehavbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_loadbehavbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdef.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdefall.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdefbypprjidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdefbypprjidx.plsql >>$logfilename 2>&1
echo "#	crrd_mjverdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mjverdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_mimetype.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mimetype.plsql >>$logfilename 2>&1
echo "#	crrd_mimetypeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mimetypeall.plsql >>$logfilename 2>&1
echo "#	crrd_mimetypebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mimetypebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_mimetypebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mimetypebyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdef.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdefall.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdefbymajoridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdefbymajoridx.plsql >>$logfilename 2>&1
echo "#	crrd_mnverdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_mnverdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkncolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkncolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkndefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkndefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtkntypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtkntypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknsdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknsdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypall.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_nmtknstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_nmtknstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcol.plsql >>$logfilename 2>&1
echo "#	crrd_numcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolall.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdef.plsql >>$logfilename 2>&1
echo "#	crrd_numdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_numdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefall.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtyp.plsql >>$logfilename 2>&1
echo "#	crrd_numtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypall.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_numtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_numtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprm.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmall.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyservermethodidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyservermethodidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyservertypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyservertypeidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprmbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprmbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_dep.plsql >>$logfilename 2>&1
echo "#	crrd_pop_dep_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_dep_cc.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depall.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depccall.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_depbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_depbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1all.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1byrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1bycontpoptopidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1bycontpoptopidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2all.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2byrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2bycontpopdep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2bycontpopdep1idx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3all.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3all.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3byrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3bycontpopdep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3bycontpopdep2idx.plsql >>$logfilename 2>&1
echo "#	crrd_popsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_popsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdep.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepall.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbycontrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbycontrelidx.plsql >>$logfilename 2>&1
echo "#	crrd_pop_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_pop_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdef.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefall.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_bprjdefccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_bprjdefccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdef.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefall.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_rprjdefccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rprjdefccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldef.plsql >>$logfilename 2>&1
echo "#	crrd_reldefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefall.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbyrelntenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbyrelntenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbyrtypekeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbyrtypekeyidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbyfromkeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbyfromkeyidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbytotblidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbytotblidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbytokeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbytokeyidx.plsql >>$logfilename 2>&1
echo "#	crrd_reldefbynarrowedidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_reldefbynarrowedidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcol.plsql >>$logfilename 2>&1
echo "#	crrd_relcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolall.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyrelcoltenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyrelcoltenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyfromcolidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyfromcolidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbytocolidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbytocolidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyrelprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyrelprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_relcolbyrelnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_relcolbyrelnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_rel_type.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rel_type.plsql >>$logfilename 2>&1
echo "#	crrd_rel_typeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rel_typeall.plsql >>$logfilename 2>&1
echo "#	crrd_rel_typebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rel_typebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_rel_typebyutagidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_rel_typebyutagidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadef.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefall.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyctenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyctenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbydomainidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbydeflcnidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbydeflcnidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_schemadefbypuburiidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schemadefbypuburiidx.plsql >>$logfilename 2>&1
echo "#	crrd_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_ref.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refall.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_schema_refbyrefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_schema_refbyrefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_scopedef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedef.plsql >>$logfilename 2>&1
echo "#	crrd_scopedef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefall.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefccall.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_scopedefccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_scopedefccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_secapp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secapp.plsql >>$logfilename 2>&1
echo "#	crrd_secappall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secappall.plsql >>$logfilename 2>&1
echo "#	crrd_secappbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secappbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secappbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secappbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secappbyujeemountidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secappbyujeemountidx.plsql >>$logfilename 2>&1
echo "#	crrd_secdev.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secdev.plsql >>$logfilename 2>&1
echo "#	crrd_secdevall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secdevall.plsql >>$logfilename 2>&1
echo "#	crrd_secdevbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secdevbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secdevbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secdevbyuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_secform.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secform.plsql >>$logfilename 2>&1
echo "#	crrd_secformall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secformall.plsql >>$logfilename 2>&1
echo "#	crrd_secformbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secformbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secformbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secformbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secformbysecappidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secformbysecappidx.plsql >>$logfilename 2>&1
echo "#	crrd_secformbyujeeservletidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secformbyujeeservletidx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrp.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpall.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrm.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmall.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbygroupidx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbyappidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbyappidx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbyformidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbyformidx.plsql >>$logfilename 2>&1
echo "#	crrd_secgrpfrmbyuformidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secgrpfrmbyuformidx.plsql >>$logfilename 2>&1
echo "#	crrd_secinc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secinc.plsql >>$logfilename 2>&1
echo "#	crrd_secincall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincall.plsql >>$logfilename 2>&1
echo "#	crrd_secincbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secincbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secincbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincbygroupidx.plsql >>$logfilename 2>&1
echo "#	crrd_secincbyincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincbyincludeidx.plsql >>$logfilename 2>&1
echo "#	crrd_secincbyuincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secincbyuincludeidx.plsql >>$logfilename 2>&1
echo "#	crrd_secmemb.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmemb.plsql >>$logfilename 2>&1
echo "#	crrd_secmemball.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmemball.plsql >>$logfilename 2>&1
echo "#	crrd_secmembbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmembbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secmembbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmembbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_secmembbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmembbygroupidx.plsql >>$logfilename 2>&1
echo "#	crrd_secmembbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmembbyuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_secmembbyuuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secmembbyuuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_secsess.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsess.plsql >>$logfilename 2>&1
echo "#	crrd_secsessall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessall.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbysecuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbysecuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbysecdevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbysecdevidx.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbystartidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbystartidx.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbyfinishidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbyfinishidx.plsql >>$logfilename 2>&1
echo "#	crrd_secsessbysecproxyidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secsessbysecproxyidx.plsql >>$logfilename 2>&1
echo "#	crrd_secuser.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuser.plsql >>$logfilename 2>&1
echo "#	crrd_secuserall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserall.plsql >>$logfilename 2>&1
echo "#	crrd_secuserbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secuserbyuloginidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserbyuloginidx.plsql >>$logfilename 2>&1
echo "#	crrd_secuserbyemconfidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserbyemconfidx.plsql >>$logfilename 2>&1
echo "#	crrd_secuserbypwdresetidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserbypwdresetidx.plsql >>$logfilename 2>&1
echo "#	crrd_secuserbydefdevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secuserbydefdevidx.plsql >>$logfilename 2>&1
echo "#	crrd_secscope.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secscope.plsql >>$logfilename 2>&1
echo "#	crrd_secscopeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secscopeall.plsql >>$logfilename 2>&1
echo "#	crrd_secscopebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secscopebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_secscopebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_secscopebyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfunc.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncall.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvlfuncbyrettblidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvlfuncbyrettblidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmeth.plsql >>$logfilename 2>&1
echo "#	crrd_srvmeth_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmeth_cc.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethall.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethccall.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethccbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvmethbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvmethbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofunc.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncall.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvofuncbyrettblidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvofuncbyrettblidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprc.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcall.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_srvprcbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_srvprcbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvc.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcall.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbyhostidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbyhostidx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbytypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbytypeidx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbyutypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbyutypeidx.plsql >>$logfilename 2>&1
echo "#	crrd_hostsvcbyuhostportidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_hostsvcbyuhostportidx.plsql >>$logfilename 2>&1
echo "#	crrd_svctype.plsql" >>${logfilename}
${sqlpluscmd} < crrd_svctype.plsql >>$logfilename 2>&1
echo "#	crrd_svctypeall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_svctypeall.plsql >>$logfilename 2>&1
echo "#	crrd_svctypebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_svctypebyididx.plsql >>$logfilename 2>&1
echo "#	crrd_svctypebyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_svctypebyudescridx.plsql >>$logfilename 2>&1
echo "#	crrd_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcol.plsql >>$logfilename 2>&1
echo "#	crrd_strcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolall.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdef.plsql >>$logfilename 2>&1
echo "#	crrd_strdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_strdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefall.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtyp.plsql >>$logfilename 2>&1
echo "#	crrd_strtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypall.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_strtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_strtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdef.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdefall.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdefbyparentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdefbyparentidx.plsql >>$logfilename 2>&1
echo "#	crrd_sprjdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sprjdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_sysclus.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sysclus.plsql >>$logfilename 2>&1
echo "#	crrd_sysclusall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sysclusall.plsql >>$logfilename 2>&1
echo "#	crrd_sysclusbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sysclusbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_sysclusbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_sysclusbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecgrp.plsql >>$logfilename 2>&1
echo "#	crrd_tsecgrpall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecgrpall.plsql >>$logfilename 2>&1
echo "#	crrd_tsecgrpbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecgrpbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecgrpbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecgrpbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecgrpbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecgrpbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecinc.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincall.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincbygroupidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincbyincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincbyincludeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecincbyuincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecincbyuincludeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmemb.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmemball.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmemball.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmembbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmembbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmembbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmembbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmembbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmembbygroupidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmembbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmembbyuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_tsecmembbyuuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsecmembbyuuseridx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcol.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolall.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdef.plsql >>$logfilename 2>&1
echo "#	crrd_dzdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefall.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dzdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dzdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztyp.plsql >>$logfilename 2>&1
echo "#	crrd_dztypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypall.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_dztypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_dztypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcol.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolall.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdef.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefall.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmzdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmzdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztyp.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypall.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmztypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmztypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscol.plsql >>$logfilename 2>&1
echo "#	crrd_zscolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolall.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdef.plsql >>$logfilename 2>&1
echo "#	crrd_zsdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefall.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zsdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zsdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstyp.plsql >>$logfilename 2>&1
echo "#	crrd_zstypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypall.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_zstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_zstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldef.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefall.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyschemadefidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyschemadefidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyschemacdidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyschemacdidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyprimaryindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyprimaryindexidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbylookupindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbylookupindexidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyaltindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyaltindexidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyqualtableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyqualtableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyloadbehaveidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyloadbehaveidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbysecscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbysecscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tbldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tbldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcol.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolall.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tblcolbydataidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tblcolbydataidx.plsql >>$logfilename 2>&1
echo "#	crrd_tenant.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tenant.plsql >>$logfilename 2>&1
echo "#	crrd_tenantall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tenantall.plsql >>$logfilename 2>&1
echo "#	crrd_tenantbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tenantbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tenantbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tenantbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crrd_tenantbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tenantbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcol.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolall.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdef.plsql >>$logfilename 2>&1
echo "#	crrd_txtdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefall.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txtdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txtdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttyp.plsql >>$logfilename 2>&1
echo "#	crrd_txttypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypall.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_txttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_txttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcol.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolall.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdef.plsql >>$logfilename 2>&1
echo "#	crrd_tmdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefall.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtyp.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypall.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tmtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tmtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscol.plsql >>$logfilename 2>&1
echo "#	crrd_tscolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolall.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdef.plsql >>$logfilename 2>&1
echo "#	crrd_tsdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefall.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tsdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tsdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstyp.plsql >>$logfilename 2>&1
echo "#	crrd_tstypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypall.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tlddef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tlddef.plsql >>$logfilename 2>&1
echo "#	crrd_tlddefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tlddefall.plsql >>$logfilename 2>&1
echo "#	crrd_tlddefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tlddefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tlddefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tlddefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tlddefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tlddefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncol.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolall.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkncolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkncolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndef.plsql >>$logfilename 2>&1
echo "#	crrd_tkndef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefall.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccall.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkndefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkndefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntyp.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypall.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_tkntypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tkntypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdef.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdefall.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdefbytldidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdefbytldidx.plsql >>$logfilename 2>&1
echo "#	crrd_tdomdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tdomdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdef.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdefall.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdefbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdefbydomainidx.plsql >>$logfilename 2>&1
echo "#	crrd_tprjdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_tprjdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16col.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colall.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16def.plsql >>$logfilename 2>&1
echo "#	crrd_u16def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_u16defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defall.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccall.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u16defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u16defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typ.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typall.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint16typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint16typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32col.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colall.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32def.plsql >>$logfilename 2>&1
echo "#	crrd_u32def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_u32defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defall.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccall.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u32defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u32defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typ.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typall.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint32typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint32typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64col.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colall.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64colbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64def.plsql >>$logfilename 2>&1
echo "#	crrd_u64def_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64def_cc.plsql >>$logfilename 2>&1
echo "#	crrd_u64defall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defall.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccall.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_u64defccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_u64defccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typ.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typall.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uint64typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uint64typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_urlproto.plsql" >>${logfilename}
${sqlpluscmd} < crrd_urlproto.plsql >>$logfilename 2>&1
echo "#	crrd_urlprotoall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_urlprotoall.plsql >>$logfilename 2>&1
echo "#	crrd_urlprotobyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_urlprotobyididx.plsql >>$logfilename 2>&1
echo "#	crrd_urlprotobyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_urlprotobyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_urlprotobyissecureidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_urlprotobyissecureidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcol.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolall.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddef.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefall.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccall.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuiddefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuiddefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuid.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidall.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_idguuidbydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_idguuidbydispidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtyp_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtyp_cc.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypall.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccall.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_uuidtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_uuidtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdef.plsql >>$logfilename 2>&1
echo "#	crrd_valdef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_valdefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefall.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccall.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyunameidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbyprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbynextidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_valdefccbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_valdefccbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crrd_verndef.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndef.plsql >>$logfilename 2>&1
echo "#	crrd_verndef_cc.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndef_cc.plsql >>$logfilename 2>&1
echo "#	crrd_verndefall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefall.plsql >>$logfilename 2>&1
echo "#	crrd_verndefccall.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefccall.plsql >>$logfilename 2>&1
echo "#	crrd_verndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_verndefccbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefccbyididx.plsql >>$logfilename 2>&1
echo "#	crrd_verndefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crrd_verndefccbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crrd_verndefccbytenantidx.plsql >>$logfilename 2>&1

echo "#	crupd_accfreq.plsql" >>${logfilename}
${sqlpluscmd} < crupd_accfreq.plsql >>$logfilename 2>&1
echo "#	crupd_accsec.plsql" >>${logfilename}
${sqlpluscmd} < crupd_accsec.plsql >>$logfilename 2>&1
echo "#	crupd_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_atomdef.plsql >>$logfilename 2>&1
echo "#	crupd_auditaction.plsql" >>${logfilename}
${sqlpluscmd} < crupd_auditaction.plsql >>$logfilename 2>&1
echo "#	crupd_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_boolcol.plsql >>$logfilename 2>&1
echo "#	crupd_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_booldef.plsql >>$logfilename 2>&1
echo "#	crupd_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_booltyp.plsql >>$logfilename 2>&1
echo "#	crupd_chain_def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_chain_def.plsql >>$logfilename 2>&1
echo "#	crupd_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clr_dep.plsql >>$logfilename 2>&1
echo "#	crupd_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clrsubdep1.plsql >>$logfilename 2>&1
echo "#	crupd_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clrsubdep2.plsql >>$logfilename 2>&1
echo "#	crupd_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clrsubdep3.plsql >>$logfilename 2>&1
echo "#	crupd_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clr_topdep.plsql >>$logfilename 2>&1
echo "#	crupd_clus.plsql" >>${logfilename}
${sqlpluscmd} < crupd_clus.plsql >>$logfilename 2>&1
echo "#	crupd_datascope.plsql" >>${logfilename}
${sqlpluscmd} < crupd_datascope.plsql >>$logfilename 2>&1
echo "#	crupd_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dtcol.plsql >>$logfilename 2>&1
echo "#	crupd_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dtdef.plsql >>$logfilename 2>&1
echo "#	crupd_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dttyp.plsql >>$logfilename 2>&1
echo "#	crupd_del_dep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_del_dep.plsql >>$logfilename 2>&1
echo "#	crupd_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crupd_delsubdep1.plsql >>$logfilename 2>&1
echo "#	crupd_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crupd_delsubdep2.plsql >>$logfilename 2>&1
echo "#	crupd_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crupd_delsubdep3.plsql >>$logfilename 2>&1
echo "#	crupd_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_del_topdep.plsql >>$logfilename 2>&1
echo "#	crupd_domdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_domdef.plsql >>$logfilename 2>&1
echo "#	crupd_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_bdomdef.plsql >>$logfilename 2>&1
echo "#	crupd_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dblcol.plsql >>$logfilename 2>&1
echo "#	crupd_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dbldef.plsql >>$logfilename 2>&1
echo "#	crupd_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dbltyp.plsql >>$logfilename 2>&1
echo "#	crupd_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_enumcol.plsql >>$logfilename 2>&1
echo "#	crupd_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_enumdef.plsql >>$logfilename 2>&1
echo "#	crupd_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crupd_enum_tag.plsql >>$logfilename 2>&1
echo "#	crupd_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_enumtyp.plsql >>$logfilename 2>&1
echo "#	crupd_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_fltcol.plsql >>$logfilename 2>&1
echo "#	crupd_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_fltdef.plsql >>$logfilename 2>&1
echo "#	crupd_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_flttyp.plsql >>$logfilename 2>&1
echo "#	crupd_hostnode.plsql" >>${logfilename}
${sqlpluscmd} < crupd_hostnode.plsql >>$logfilename 2>&1
echo "#	crupd_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} < crupd_iso_cntry.plsql >>$logfilename 2>&1
echo "#	crupd_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} < crupd_iso_cntryccy.plsql >>$logfilename 2>&1
echo "#	crupd_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} < crupd_iso_cntrylng.plsql >>$logfilename 2>&1
echo "#	crupd_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} < crupd_iso_ccy.plsql >>$logfilename 2>&1
echo "#	crupd_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} < crupd_iso_lang.plsql >>$logfilename 2>&1
echo "#	crupd_isotz.plsql" >>${logfilename}
${sqlpluscmd} < crupd_isotz.plsql >>$logfilename 2>&1
echo "#	crupd_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idg16.plsql >>$logfilename 2>&1
echo "#	crupd_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idg32.plsql >>$logfilename 2>&1
echo "#	crupd_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idg64.plsql >>$logfilename 2>&1
echo "#	crupd_idxdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idxdef.plsql >>$logfilename 2>&1
echo "#	crupd_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idxcol.plsql >>$logfilename 2>&1
echo "#	crupd_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int16col.plsql >>$logfilename 2>&1
echo "#	crupd_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int16def.plsql >>$logfilename 2>&1
echo "#	crupd_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int16typ.plsql >>$logfilename 2>&1
echo "#	crupd_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int32col.plsql >>$logfilename 2>&1
echo "#	crupd_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int32def.plsql >>$logfilename 2>&1
echo "#	crupd_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int32typ.plsql >>$logfilename 2>&1
echo "#	crupd_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int64col.plsql >>$logfilename 2>&1
echo "#	crupd_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int64def.plsql >>$logfilename 2>&1
echo "#	crupd_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_int64typ.plsql >>$logfilename 2>&1
echo "#	crupd_licn.plsql" >>${logfilename}
${sqlpluscmd} < crupd_licn.plsql >>$logfilename 2>&1
echo "#	crupd_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} < crupd_loadbehav.plsql >>$logfilename 2>&1
echo "#	crupd_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_mjverdef.plsql >>$logfilename 2>&1
echo "#	crupd_mimetype.plsql" >>${logfilename}
${sqlpluscmd} < crupd_mimetype.plsql >>$logfilename 2>&1
echo "#	crupd_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_mnverdef.plsql >>$logfilename 2>&1
echo "#	crupd_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crupd_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crupd_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crupd_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crupd_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crupd_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crupd_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_numcol.plsql >>$logfilename 2>&1
echo "#	crupd_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_numdef.plsql >>$logfilename 2>&1
echo "#	crupd_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_numtyp.plsql >>$logfilename 2>&1
echo "#	crupd_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crupd_srvprm.plsql >>$logfilename 2>&1
echo "#	crupd_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_pop_dep.plsql >>$logfilename 2>&1
echo "#	crupd_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crupd_popsubdep1.plsql >>$logfilename 2>&1
echo "#	crupd_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crupd_popsubdep2.plsql >>$logfilename 2>&1
echo "#	crupd_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crupd_popsubdep3.plsql >>$logfilename 2>&1
echo "#	crupd_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crupd_pop_topdep.plsql >>$logfilename 2>&1
echo "#	crupd_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_bprjdef.plsql >>$logfilename 2>&1
echo "#	crupd_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_rprjdef.plsql >>$logfilename 2>&1
echo "#	crupd_reldef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_reldef.plsql >>$logfilename 2>&1
echo "#	crupd_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_relcol.plsql >>$logfilename 2>&1
echo "#	crupd_rel_type.plsql" >>${logfilename}
${sqlpluscmd} < crupd_rel_type.plsql >>$logfilename 2>&1
echo "#	crupd_schemadef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_schemadef.plsql >>$logfilename 2>&1
echo "#	crupd_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} < crupd_schema_ref.plsql >>$logfilename 2>&1
echo "#	crupd_scopedef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_scopedef.plsql >>$logfilename 2>&1
echo "#	crupd_secapp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secapp.plsql >>$logfilename 2>&1
echo "#	crupd_secdev.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secdev.plsql >>$logfilename 2>&1
echo "#	crupd_secform.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secform.plsql >>$logfilename 2>&1
echo "#	crupd_secgrp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secgrp.plsql >>$logfilename 2>&1
echo "#	crupd_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secgrpfrm.plsql >>$logfilename 2>&1
echo "#	crupd_secinc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secinc.plsql >>$logfilename 2>&1
echo "#	crupd_secmemb.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secmemb.plsql >>$logfilename 2>&1
echo "#	crupd_secsess.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secsess.plsql >>$logfilename 2>&1
echo "#	crupd_secuser.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secuser.plsql >>$logfilename 2>&1
echo "#	crupd_secscope.plsql" >>${logfilename}
${sqlpluscmd} < crupd_secscope.plsql >>$logfilename 2>&1
echo "#	crupd_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_srvlfunc.plsql >>$logfilename 2>&1
echo "#	crupd_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} < crupd_srvmeth.plsql >>$logfilename 2>&1
echo "#	crupd_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_srvofunc.plsql >>$logfilename 2>&1
echo "#	crupd_srvprc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_srvprc.plsql >>$logfilename 2>&1
echo "#	crupd_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_hostsvc.plsql >>$logfilename 2>&1
echo "#	crupd_svctype.plsql" >>${logfilename}
${sqlpluscmd} < crupd_svctype.plsql >>$logfilename 2>&1
echo "#	crupd_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_strcol.plsql >>$logfilename 2>&1
echo "#	crupd_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_strdef.plsql >>$logfilename 2>&1
echo "#	crupd_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_strtyp.plsql >>$logfilename 2>&1
echo "#	crupd_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_sprjdef.plsql >>$logfilename 2>&1
echo "#	crupd_sysclus.plsql" >>${logfilename}
${sqlpluscmd} < crupd_sysclus.plsql >>$logfilename 2>&1
echo "#	crupd_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tsecgrp.plsql >>$logfilename 2>&1
echo "#	crupd_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tsecinc.plsql >>$logfilename 2>&1
echo "#	crupd_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tsecmemb.plsql >>$logfilename 2>&1
echo "#	crupd_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dzcol.plsql >>$logfilename 2>&1
echo "#	crupd_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dzdef.plsql >>$logfilename 2>&1
echo "#	crupd_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_dztyp.plsql >>$logfilename 2>&1
echo "#	crupd_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmzcol.plsql >>$logfilename 2>&1
echo "#	crupd_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmzdef.plsql >>$logfilename 2>&1
echo "#	crupd_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmztyp.plsql >>$logfilename 2>&1
echo "#	crupd_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_zscol.plsql >>$logfilename 2>&1
echo "#	crupd_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_zsdef.plsql >>$logfilename 2>&1
echo "#	crupd_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_zstyp.plsql >>$logfilename 2>&1
echo "#	crupd_tbldef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tbldef.plsql >>$logfilename 2>&1
echo "#	crupd_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tblcol.plsql >>$logfilename 2>&1
echo "#	crupd_tenant.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tenant.plsql >>$logfilename 2>&1
echo "#	crupd_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_txtcol.plsql >>$logfilename 2>&1
echo "#	crupd_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_txtdef.plsql >>$logfilename 2>&1
echo "#	crupd_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_txttyp.plsql >>$logfilename 2>&1
echo "#	crupd_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmcol.plsql >>$logfilename 2>&1
echo "#	crupd_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmdef.plsql >>$logfilename 2>&1
echo "#	crupd_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tmtyp.plsql >>$logfilename 2>&1
echo "#	crupd_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tscol.plsql >>$logfilename 2>&1
echo "#	crupd_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tsdef.plsql >>$logfilename 2>&1
echo "#	crupd_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tstyp.plsql >>$logfilename 2>&1
echo "#	crupd_tlddef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tlddef.plsql >>$logfilename 2>&1
echo "#	crupd_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tkncol.plsql >>$logfilename 2>&1
echo "#	crupd_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tkndef.plsql >>$logfilename 2>&1
echo "#	crupd_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tkntyp.plsql >>$logfilename 2>&1
echo "#	crupd_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tdomdef.plsql >>$logfilename 2>&1
echo "#	crupd_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_tprjdef.plsql >>$logfilename 2>&1
echo "#	crupd_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint16col.plsql >>$logfilename 2>&1
echo "#	crupd_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_u16def.plsql >>$logfilename 2>&1
echo "#	crupd_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint16typ.plsql >>$logfilename 2>&1
echo "#	crupd_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint32col.plsql >>$logfilename 2>&1
echo "#	crupd_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_u32def.plsql >>$logfilename 2>&1
echo "#	crupd_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint32typ.plsql >>$logfilename 2>&1
echo "#	crupd_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint64col.plsql >>$logfilename 2>&1
echo "#	crupd_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crupd_u64def.plsql >>$logfilename 2>&1
echo "#	crupd_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uint64typ.plsql >>$logfilename 2>&1
echo "#	crupd_urlproto.plsql" >>${logfilename}
${sqlpluscmd} < crupd_urlproto.plsql >>$logfilename 2>&1
echo "#	crupd_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uuidcol.plsql >>$logfilename 2>&1
echo "#	crupd_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uuiddef.plsql >>$logfilename 2>&1
echo "#	crupd_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crupd_idguuid.plsql >>$logfilename 2>&1
echo "#	crupd_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crupd_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crupd_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_valdef.plsql >>$logfilename 2>&1
echo "#	crupd_verndef.plsql" >>${logfilename}
${sqlpluscmd} < crupd_verndef.plsql >>$logfilename 2>&1

echo "#	crmvup_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_atomdef.plsql >>$logfilename 2>&1
echo "#	crmvup_blbcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_blbcol.plsql >>$logfilename 2>&1
echo "#	crmvup_blbdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_blbdef.plsql >>$logfilename 2>&1
echo "#	crmvup_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_blbtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_boolcol.plsql >>$logfilename 2>&1
echo "#	crmvup_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_booldef.plsql >>$logfilename 2>&1
echo "#	crmvup_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_booltyp.plsql >>$logfilename 2>&1
echo "#	crmvup_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dtcol.plsql >>$logfilename 2>&1
echo "#	crmvup_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dtdef.plsql >>$logfilename 2>&1
echo "#	crmvup_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dttyp.plsql >>$logfilename 2>&1
echo "#	crmvup_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dblcol.plsql >>$logfilename 2>&1
echo "#	crmvup_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dbldef.plsql >>$logfilename 2>&1
echo "#	crmvup_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dbltyp.plsql >>$logfilename 2>&1
echo "#	crmvup_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_enumcol.plsql >>$logfilename 2>&1
echo "#	crmvup_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_enumdef.plsql >>$logfilename 2>&1
echo "#	crmvup_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_enum_tag.plsql >>$logfilename 2>&1
echo "#	crmvup_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_enumtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_fltcol.plsql >>$logfilename 2>&1
echo "#	crmvup_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_fltdef.plsql >>$logfilename 2>&1
echo "#	crmvup_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_flttyp.plsql >>$logfilename 2>&1
echo "#	crmvup_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_idg16.plsql >>$logfilename 2>&1
echo "#	crmvup_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_idg32.plsql >>$logfilename 2>&1
echo "#	crmvup_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_idg64.plsql >>$logfilename 2>&1
echo "#	crmvup_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_idxcol.plsql >>$logfilename 2>&1
echo "#	crmvup_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int16col.plsql >>$logfilename 2>&1
echo "#	crmvup_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int16def.plsql >>$logfilename 2>&1
echo "#	crmvup_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int16typ.plsql >>$logfilename 2>&1
echo "#	crmvup_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int32col.plsql >>$logfilename 2>&1
echo "#	crmvup_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int32def.plsql >>$logfilename 2>&1
echo "#	crmvup_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int32typ.plsql >>$logfilename 2>&1
echo "#	crmvup_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int64col.plsql >>$logfilename 2>&1
echo "#	crmvup_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int64def.plsql >>$logfilename 2>&1
echo "#	crmvup_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_int64typ.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crmvup_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crmvup_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_numcol.plsql >>$logfilename 2>&1
echo "#	crmvup_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_numdef.plsql >>$logfilename 2>&1
echo "#	crmvup_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_numtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_srvprm.plsql >>$logfilename 2>&1
echo "#	crmvup_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_relcol.plsql >>$logfilename 2>&1
echo "#	crmvup_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_strcol.plsql >>$logfilename 2>&1
echo "#	crmvup_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_strdef.plsql >>$logfilename 2>&1
echo "#	crmvup_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_strtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dzcol.plsql >>$logfilename 2>&1
echo "#	crmvup_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dzdef.plsql >>$logfilename 2>&1
echo "#	crmvup_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_dztyp.plsql >>$logfilename 2>&1
echo "#	crmvup_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmzcol.plsql >>$logfilename 2>&1
echo "#	crmvup_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmzdef.plsql >>$logfilename 2>&1
echo "#	crmvup_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmztyp.plsql >>$logfilename 2>&1
echo "#	crmvup_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_zscol.plsql >>$logfilename 2>&1
echo "#	crmvup_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_zsdef.plsql >>$logfilename 2>&1
echo "#	crmvup_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_zstyp.plsql >>$logfilename 2>&1
echo "#	crmvup_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tblcol.plsql >>$logfilename 2>&1
echo "#	crmvup_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_txtcol.plsql >>$logfilename 2>&1
echo "#	crmvup_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_txtdef.plsql >>$logfilename 2>&1
echo "#	crmvup_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_txttyp.plsql >>$logfilename 2>&1
echo "#	crmvup_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmcol.plsql >>$logfilename 2>&1
echo "#	crmvup_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmdef.plsql >>$logfilename 2>&1
echo "#	crmvup_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tmtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tscol.plsql >>$logfilename 2>&1
echo "#	crmvup_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tsdef.plsql >>$logfilename 2>&1
echo "#	crmvup_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tstyp.plsql >>$logfilename 2>&1
echo "#	crmvup_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tkncol.plsql >>$logfilename 2>&1
echo "#	crmvup_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tkndef.plsql >>$logfilename 2>&1
echo "#	crmvup_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_tkntyp.plsql >>$logfilename 2>&1
echo "#	crmvup_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint16col.plsql >>$logfilename 2>&1
echo "#	crmvup_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_u16def.plsql >>$logfilename 2>&1
echo "#	crmvup_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint16typ.plsql >>$logfilename 2>&1
echo "#	crmvup_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint32col.plsql >>$logfilename 2>&1
echo "#	crmvup_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_u32def.plsql >>$logfilename 2>&1
echo "#	crmvup_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint32typ.plsql >>$logfilename 2>&1
echo "#	crmvup_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint64col.plsql >>$logfilename 2>&1
echo "#	crmvup_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_u64def.plsql >>$logfilename 2>&1
echo "#	crmvup_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uint64typ.plsql >>$logfilename 2>&1
echo "#	crmvup_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uuidcol.plsql >>$logfilename 2>&1
echo "#	crmvup_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uuiddef.plsql >>$logfilename 2>&1
echo "#	crmvup_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_idguuid.plsql >>$logfilename 2>&1
echo "#	crmvup_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crmvup_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvup_valdef.plsql >>$logfilename 2>&1

echo "#	crmvdn_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_atomdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_blbcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_blbcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_blbdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_blbdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_blbtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_boolcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_booldef.plsql >>$logfilename 2>&1
echo "#	crmvdn_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_booltyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dtcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dtdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dttyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dblcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dbldef.plsql >>$logfilename 2>&1
echo "#	crmvdn_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dbltyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_enumcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_enumdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_enum_tag.plsql >>$logfilename 2>&1
echo "#	crmvdn_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_enumtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_fltcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_fltdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_flttyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_idg16.plsql >>$logfilename 2>&1
echo "#	crmvdn_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_idg32.plsql >>$logfilename 2>&1
echo "#	crmvdn_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_idg64.plsql >>$logfilename 2>&1
echo "#	crmvdn_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_idxcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int16col.plsql >>$logfilename 2>&1
echo "#	crmvdn_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int16def.plsql >>$logfilename 2>&1
echo "#	crmvdn_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int16typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int32col.plsql >>$logfilename 2>&1
echo "#	crmvdn_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int32def.plsql >>$logfilename 2>&1
echo "#	crmvdn_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int32typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int64col.plsql >>$logfilename 2>&1
echo "#	crmvdn_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int64def.plsql >>$logfilename 2>&1
echo "#	crmvdn_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_int64typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_numcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_numdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_numtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_srvprm.plsql >>$logfilename 2>&1
echo "#	crmvdn_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_relcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_strcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_strdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_strtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dzcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dzdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_dztyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmzcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmzdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmztyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_zscol.plsql >>$logfilename 2>&1
echo "#	crmvdn_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_zsdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_zstyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tblcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_txtcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_txtdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_txttyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tmtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tscol.plsql >>$logfilename 2>&1
echo "#	crmvdn_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tsdef.plsql >>$logfilename 2>&1
echo "#	crmvdn_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tstyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tkncol.plsql >>$logfilename 2>&1
echo "#	crmvdn_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tkndef.plsql >>$logfilename 2>&1
echo "#	crmvdn_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_tkntyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint16col.plsql >>$logfilename 2>&1
echo "#	crmvdn_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_u16def.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint16typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint32col.plsql >>$logfilename 2>&1
echo "#	crmvdn_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_u32def.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint32typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint64col.plsql >>$logfilename 2>&1
echo "#	crmvdn_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_u64def.plsql >>$logfilename 2>&1
echo "#	crmvdn_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uint64typ.plsql >>$logfilename 2>&1
echo "#	crmvdn_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uuidcol.plsql >>$logfilename 2>&1
echo "#	crmvdn_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uuiddef.plsql >>$logfilename 2>&1
echo "#	crmvdn_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_idguuid.plsql >>$logfilename 2>&1
echo "#	crmvdn_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crmvdn_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crmvdn_valdef.plsql >>$logfilename 2>&1

echo "#	crdl_accfreq_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accfreq_stub.plsql >>$logfilename 2>&1
echo "#	crdl_accsec_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accsec_stub.plsql >>$logfilename 2>&1
echo "#	crdl_atomdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_auditaction_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_auditaction_stub.plsql >>$logfilename 2>&1
echo "#	crdl_blbcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_blbdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_blbtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_boolcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_booldef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_booltyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_chain_def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clr_dep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_dep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_clus_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clus_stub.plsql >>$logfilename 2>&1
echo "#	crdl_datascope_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_datascope_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dtcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dtdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dttyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_del_dep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_dep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1_stub.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2_stub.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3_stub.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_domdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_bdomdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bdomdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dblcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dbldef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dbltyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_enumcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_enumdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tag_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tag_stub.plsql >>$logfilename 2>&1
echo "#	crdl_enumtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_fltcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_fltdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_flttyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_hostnode_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnode_stub.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntry_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntry_stub.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntryccy_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntryccy_stub.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrylng_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrylng_stub.plsql >>$logfilename 2>&1
echo "#	crdl_iso_ccy_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_ccy_stub.plsql >>$logfilename 2>&1
echo "#	crdl_iso_lang_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_lang_stub.plsql >>$logfilename 2>&1
echo "#	crdl_isotz_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotz_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idg16_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idg32_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idg64_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idxdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idxcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int16col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int16def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int16typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int32col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int32def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int32typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int64col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int64def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_int64typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_licn_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licn_stub.plsql >>$logfilename 2>&1
echo "#	crdl_loadbehav_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_loadbehav_stub.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_mimetype_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mimetype_stub.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_numcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_numdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_numtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_srvprm_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprm_stub.plsql >>$logfilename 2>&1
echo "#	crdl_pop_dep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_dep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1_stub.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2_stub.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3_stub.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdep_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdep_stub.plsql >>$logfilename 2>&1
echo "#	crdl_bprjdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bprjdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_rprjdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rprjdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_reldef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_relcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_rel_type_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rel_type_stub.plsql >>$logfilename 2>&1
echo "#	crdl_schemadef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_schema_ref_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_ref_stub.plsql >>$logfilename 2>&1
echo "#	crdl_scopedef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_scopedef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secapp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secapp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secdev_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secdev_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secform_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secform_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secgrp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrm_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrm_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secinc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secinc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secmemb_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmemb_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secsess_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsess_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secuser_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuser_stub.plsql >>$logfilename 2>&1
echo "#	crdl_secscope_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secscope_stub.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfunc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfunc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_srvmeth_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmeth_stub.plsql >>$logfilename 2>&1
echo "#	crdl_srvofunc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofunc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_srvprc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_svctype_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_svctype_stub.plsql >>$logfilename 2>&1
echo "#	crdl_strcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_strdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_strtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_sysclus_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sysclus_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tsecgrp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecgrp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tsecinc_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecinc_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmemb_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmemb_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dzcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dzdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_dztyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmztyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_zscol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_zsdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_zstyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tbldef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tblcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tenant_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tenant_stub.plsql >>$logfilename 2>&1
echo "#	crdl_txtcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_txtdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_txttyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tmtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tscol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tsdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tstyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tlddef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tlddef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tkncol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tkndef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tkntyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint16col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_u16def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint32col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_u32def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint64col_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64col_stub.plsql >>$logfilename 2>&1
echo "#	crdl_u64def_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64def_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typ_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typ_stub.plsql >>$logfilename 2>&1
echo "#	crdl_urlproto_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_urlproto_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcol_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcol_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_idguuid_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuid_stub.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtyp_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtyp_stub.plsql >>$logfilename 2>&1
echo "#	crdl_valdef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdef_stub.plsql >>$logfilename 2>&1
echo "#	crdl_verndef_stub.plsql" >>${logfilename}
${sqlpluscmd} < crdl_verndef_stub.plsql >>$logfilename 2>&1

echo "#	crdl_accfreqbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accfreqbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_accfreqbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accfreqbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_accsecbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accsecbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_accsecbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accsecbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_atomdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_auditactionbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_auditactionbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_auditactionbyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_auditactionbyudescridx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_blbtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_boolcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_booldefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_booltypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbyprevrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbyprevrelidx.plsql >>$logfilename 2>&1
echo "#	crdl_chain_defbynextrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_defbynextrelidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_depbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_depbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_depbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1bycontcleartopidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1bycontcleartopidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2bycontcleardep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2bycontcleardep1idx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3bycontcleardep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3bycontcleardep2idx.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdepbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdepbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdepbyconttblidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdepbyconttblidx.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_clusbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clusbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_clusbyudomainnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clusbyudomainnameidx.plsql >>$logfilename 2>&1
echo "#	crdl_clusbyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clusbyudescridx.plsql >>$logfilename 2>&1
echo "#	crdl_datascopebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_datascopebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_datascopebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_datascopebyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dtdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_depbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_del_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_depbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_depbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_depbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_depbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1bycontdeltopidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1bycontdeltopidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2bycontdeldep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2bycontdeldep1idx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3bytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3bytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3bycontdeldep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3bycontdeldep2idx.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbyconttblidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbyconttblidx.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_domdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_domdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_domdefbysubdomidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdefbysubdomidx.plsql >>$logfilename 2>&1
echo "#	crdl_domdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_bdomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bdomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_bdomdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bdomdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dblcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbldefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dbltypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbyenumtagtenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbyenumtagtenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbyenumidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbyenumidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbyenumnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbyenumnameidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tagbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tagbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_enumtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_fltdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_flttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_hostnodebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnodebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_hostnodebyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnodebyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_hostnodebyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnodebyudescridx.plsql >>$logfilename 2>&1
echo "#	crdl_hostnodebyhostnameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnodebyhostnameidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrybyididx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrybyisocodeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrybyisocodeidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrybynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrybynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntryccybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntryccybyididx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntryccybycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntryccybycountryidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntryccybycurrencyidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntryccybycurrencyidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrylngbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrylngbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrylngbycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrylngbycountryidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrylngbylanguageidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrylngbylanguageidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_ccybyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_ccybyididx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_ccybyccycdidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_ccybyccycdidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_ccybyccynmidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_ccybyccynmidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_langbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_langbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_langbybaseidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_langbybaseidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_langbycountryidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_langbycountryidx.plsql >>$logfilename 2>&1
echo "#	crdl_iso_langbycodeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_langbycodeidx.plsql >>$logfilename 2>&1
echo "#	crdl_isotzbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotzbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_isotzbyoffsetidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotzbyoffsetidx.plsql >>$logfilename 2>&1
echo "#	crdl_isotzbyutznameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotzbyutznameidx.plsql >>$logfilename 2>&1
echo "#	crdl_isotzbyiso8601idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotzbyiso8601idx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byididx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16byschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg16bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16bydispidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byididx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32byschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg32bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32bydispidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byididx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64byschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64byschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idg64bydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64bydispidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbyindextenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbyindextenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyidxcoltenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyidxcoltenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyindexidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbycolidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbycolidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyidxprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyidxprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idxcolbyidxnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcolbyidxnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int16typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int32typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_int64typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_licnbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licnbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_licnbylicntenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licnbylicntenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_licnbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licnbydomainidx.plsql >>$logfilename 2>&1
echo "#	crdl_licnbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licnbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_loadbehavbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_loadbehavbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_loadbehavbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_loadbehavbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdefbypprjidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdefbypprjidx.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_mimetypebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mimetypebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_mimetypebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mimetypebyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdefbymajoridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdefbymajoridx.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_numtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyservermethodidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyservermethodidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyservertypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyservertypeidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprmbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprmbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_depbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_depbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_depbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_depbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_depbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_depbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_depbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_depbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1byididx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1byrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1bycontpoptopidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1bycontpoptopidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2byididx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2byrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2bycontpopdep1idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2bycontpopdep1idx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3byididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3byididx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3bytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3bytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3byrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3byrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3bydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3bydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3bycontpopdep2idx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3bycontpopdep2idx.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3byunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3byunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbycontrelidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbycontrelidx.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdepbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdepbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_bprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_bprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_rprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_rprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbyrelntenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbyrelntenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbyrtypekeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbyrtypekeyidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbyfromkeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbyfromkeyidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbytotblidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbytotblidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbytokeyidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbytokeyidx.plsql >>$logfilename 2>&1
echo "#	crdl_reldefbynarrowedidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldefbynarrowedidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyrelcoltenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyrelcoltenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyrelationidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyrelationidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyfromcolidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyfromcolidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbytocolidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbytocolidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyrelprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyrelprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_relcolbyrelnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcolbyrelnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_rel_typebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rel_typebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_rel_typebyutagidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rel_typebyutagidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyctenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyctenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbydomainidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbydeflcnidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbydeflcnidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_schemadefbypuburiidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadefbypuburiidx.plsql >>$logfilename 2>&1
echo "#	crdl_schema_refbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_refbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_schema_refbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_refbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_schema_refbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_refbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_schema_refbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_refbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_schema_refbyrefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_refbyrefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_scopedefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_scopedefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_scopedefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_scopedefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_secappbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secappbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secappbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secappbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secappbyujeemountidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secappbyujeemountidx.plsql >>$logfilename 2>&1
echo "#	crdl_secdevbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secdevbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secdevbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secdevbyuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_secformbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secformbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secformbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secformbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secformbysecappidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secformbysecappidx.plsql >>$logfilename 2>&1
echo "#	crdl_secformbyujeeservletidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secformbyujeeservletidx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbygroupidx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbyappidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbyappidx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbyformidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbyformidx.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrmbyuformidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrmbyuformidx.plsql >>$logfilename 2>&1
echo "#	crdl_secincbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secincbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secincbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secincbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secincbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secincbygroupidx.plsql >>$logfilename 2>&1
echo "#	crdl_secincbyincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secincbyincludeidx.plsql >>$logfilename 2>&1
echo "#	crdl_secincbyuincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secincbyuincludeidx.plsql >>$logfilename 2>&1
echo "#	crdl_secmembbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmembbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secmembbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmembbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_secmembbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmembbygroupidx.plsql >>$logfilename 2>&1
echo "#	crdl_secmembbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmembbyuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_secmembbyuuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmembbyuuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbysecuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbysecuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbysecdevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbysecdevidx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbystartidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbystartidx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbyfinishidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbyfinishidx.plsql >>$logfilename 2>&1
echo "#	crdl_secsessbysecproxyidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsessbysecproxyidx.plsql >>$logfilename 2>&1
echo "#	crdl_secuserbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuserbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secuserbyuloginidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuserbyuloginidx.plsql >>$logfilename 2>&1
echo "#	crdl_secuserbyemconfidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuserbyemconfidx.plsql >>$logfilename 2>&1
echo "#	crdl_secuserbypwdresetidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuserbypwdresetidx.plsql >>$logfilename 2>&1
echo "#	crdl_secuserbydefdevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuserbydefdevidx.plsql >>$logfilename 2>&1
echo "#	crdl_secscopebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secscopebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_secscopebyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secscopebyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfuncbyrettblidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfuncbyrettblidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvmethbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmethbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_srvmethbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmethbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvmethbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmethbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvmethbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmethbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvmethbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmethbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvofuncbyrettblidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofuncbyrettblidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprcbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprcbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprcbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprcbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprcbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprcbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprcbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprcbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_srvprcbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprcbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbyhostidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbyhostidx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbytypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbytypeidx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbyutypeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbyutypeidx.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvcbyuhostportidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvcbyuhostportidx.plsql >>$logfilename 2>&1
echo "#	crdl_svctypebyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_svctypebyididx.plsql >>$logfilename 2>&1
echo "#	crdl_svctypebyudescridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_svctypebyudescridx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_strtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdefbyparentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdefbyparentidx.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_sysclusbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sysclusbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_sysclusbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sysclusbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecgrpbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecgrpbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecgrpbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecgrpbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecgrpbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecgrpbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecincbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecincbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecincbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecincbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecincbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecincbygroupidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecincbyincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecincbyincludeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecincbyuincludeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecincbyuincludeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmembbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmembbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmembbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmembbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmembbygroupidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmembbygroupidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmembbyuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmembbyuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmembbyuuseridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmembbyuuseridx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dzdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_dztypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmztypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_zstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyschemadefidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyschemadefidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyschemacdidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyschemacdidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyprimaryindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyprimaryindexidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbylookupindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbylookupindexidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyaltindexidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyaltindexidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyqualtableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyqualtableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyloadbehaveidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyloadbehaveidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbysecscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbysecscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tbldefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tblcolbydataidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcolbydataidx.plsql >>$logfilename 2>&1
echo "#	crdl_tenantbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tenantbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tenantbyclusteridx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tenantbyclusteridx.plsql >>$logfilename 2>&1
echo "#	crdl_tenantbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tenantbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txtdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_txttypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tmtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tscolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tsdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tstypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tlddefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tlddefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tlddefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tlddefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tlddefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tlddefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkncolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkndefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_tkntypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdefbytldidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdefbytldidx.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdefbytenantidx.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdefbydomainidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdefbydomainidx.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdefbynameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdefbynameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u16defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u32defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64colbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64colbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_u64defbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64defbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_urlprotobyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_urlprotobyididx.plsql >>$logfilename 2>&1
echo "#	crdl_urlprotobyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_urlprotobyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_urlprotobyissecureidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_urlprotobyissecureidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcolbytableidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcolbytableidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_idguuidbydispidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuidbydispidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtypbyschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtypbyschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyunameidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyunameidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyvaltentidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyvaltentidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyscopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyscopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbydefschemaidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbydefschemaidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbydatascopeidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbydatascopeidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyvaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyvaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyvaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyvaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyeaccsecidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyeaccsecidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyeaccfreqidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyeaccfreqidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbyprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbyprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbynextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbynextidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbycontprevidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbycontprevidx.plsql >>$logfilename 2>&1
echo "#	crdl_valdefbycontnextidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdefbycontnextidx.plsql >>$logfilename 2>&1
echo "#	crdl_verndefbyididx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_verndefbyididx.plsql >>$logfilename 2>&1
echo "#	crdl_verndefbytenantidx.plsql" >>${logfilename}
${sqlpluscmd} < crdl_verndefbytenantidx.plsql >>$logfilename 2>&1

echo "#	crdl_accfreq.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accfreq.plsql >>$logfilename 2>&1
echo "#	crdl_accsec.plsql" >>${logfilename}
${sqlpluscmd} < crdl_accsec.plsql >>$logfilename 2>&1
echo "#	crdl_atomdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_atomdef.plsql >>$logfilename 2>&1
echo "#	crdl_auditaction.plsql" >>${logfilename}
${sqlpluscmd} < crdl_auditaction.plsql >>$logfilename 2>&1
echo "#	crdl_blbcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbcol.plsql >>$logfilename 2>&1
echo "#	crdl_blbdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbdef.plsql >>$logfilename 2>&1
echo "#	crdl_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_blbtyp.plsql >>$logfilename 2>&1
echo "#	crdl_boolcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_boolcol.plsql >>$logfilename 2>&1
echo "#	crdl_booldef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booldef.plsql >>$logfilename 2>&1
echo "#	crdl_booltyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_booltyp.plsql >>$logfilename 2>&1
echo "#	crdl_chain_def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_chain_def.plsql >>$logfilename 2>&1
echo "#	crdl_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_dep.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep1.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep2.plsql >>$logfilename 2>&1
echo "#	crdl_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clrsubdep3.plsql >>$logfilename 2>&1
echo "#	crdl_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clr_topdep.plsql >>$logfilename 2>&1
echo "#	crdl_clus.plsql" >>${logfilename}
${sqlpluscmd} < crdl_clus.plsql >>$logfilename 2>&1
echo "#	crdl_datascope.plsql" >>${logfilename}
${sqlpluscmd} < crdl_datascope.plsql >>$logfilename 2>&1
echo "#	crdl_dtcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtcol.plsql >>$logfilename 2>&1
echo "#	crdl_dtdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dtdef.plsql >>$logfilename 2>&1
echo "#	crdl_dttyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dttyp.plsql >>$logfilename 2>&1
echo "#	crdl_del_dep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_dep.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep1.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep2.plsql >>$logfilename 2>&1
echo "#	crdl_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crdl_delsubdep3.plsql >>$logfilename 2>&1
echo "#	crdl_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_del_topdep.plsql >>$logfilename 2>&1
echo "#	crdl_domdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_domdef.plsql >>$logfilename 2>&1
echo "#	crdl_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bdomdef.plsql >>$logfilename 2>&1
echo "#	crdl_dblcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dblcol.plsql >>$logfilename 2>&1
echo "#	crdl_dbldef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbldef.plsql >>$logfilename 2>&1
echo "#	crdl_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dbltyp.plsql >>$logfilename 2>&1
echo "#	crdl_enumcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumcol.plsql >>$logfilename 2>&1
echo "#	crdl_enumdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumdef.plsql >>$logfilename 2>&1
echo "#	crdl_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enum_tag.plsql >>$logfilename 2>&1
echo "#	crdl_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_enumtyp.plsql >>$logfilename 2>&1
echo "#	crdl_fltcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltcol.plsql >>$logfilename 2>&1
echo "#	crdl_fltdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_fltdef.plsql >>$logfilename 2>&1
echo "#	crdl_flttyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_flttyp.plsql >>$logfilename 2>&1
echo "#	crdl_hostnode.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostnode.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntry.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntryccy.plsql >>$logfilename 2>&1
echo "#	crdl_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_cntrylng.plsql >>$logfilename 2>&1
echo "#	crdl_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_ccy.plsql >>$logfilename 2>&1
echo "#	crdl_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} < crdl_iso_lang.plsql >>$logfilename 2>&1
echo "#	crdl_isotz.plsql" >>${logfilename}
${sqlpluscmd} < crdl_isotz.plsql >>$logfilename 2>&1
echo "#	crdl_idg16.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg16.plsql >>$logfilename 2>&1
echo "#	crdl_idg32.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg32.plsql >>$logfilename 2>&1
echo "#	crdl_idg64.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idg64.plsql >>$logfilename 2>&1
echo "#	crdl_idxdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxdef.plsql >>$logfilename 2>&1
echo "#	crdl_idxcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idxcol.plsql >>$logfilename 2>&1
echo "#	crdl_int16col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16col.plsql >>$logfilename 2>&1
echo "#	crdl_int16def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16def.plsql >>$logfilename 2>&1
echo "#	crdl_int16typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int16typ.plsql >>$logfilename 2>&1
echo "#	crdl_int32col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32col.plsql >>$logfilename 2>&1
echo "#	crdl_int32def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32def.plsql >>$logfilename 2>&1
echo "#	crdl_int32typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int32typ.plsql >>$logfilename 2>&1
echo "#	crdl_int64col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64col.plsql >>$logfilename 2>&1
echo "#	crdl_int64def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64def.plsql >>$logfilename 2>&1
echo "#	crdl_int64typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_int64typ.plsql >>$logfilename 2>&1
echo "#	crdl_licn.plsql" >>${logfilename}
${sqlpluscmd} < crdl_licn.plsql >>$logfilename 2>&1
echo "#	crdl_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} < crdl_loadbehav.plsql >>$logfilename 2>&1
echo "#	crdl_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mjverdef.plsql >>$logfilename 2>&1
echo "#	crdl_mimetype.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mimetype.plsql >>$logfilename 2>&1
echo "#	crdl_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_mnverdef.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkncol.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkndef.plsql >>$logfilename 2>&1
echo "#	crdl_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtkntyp.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknscol.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknsdef.plsql >>$logfilename 2>&1
echo "#	crdl_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_nmtknstyp.plsql >>$logfilename 2>&1
echo "#	crdl_numcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numcol.plsql >>$logfilename 2>&1
echo "#	crdl_numdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numdef.plsql >>$logfilename 2>&1
echo "#	crdl_numtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_numtyp.plsql >>$logfilename 2>&1
echo "#	crdl_srvprm.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprm.plsql >>$logfilename 2>&1
echo "#	crdl_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_dep.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep1.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep2.plsql >>$logfilename 2>&1
echo "#	crdl_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} < crdl_popsubdep3.plsql >>$logfilename 2>&1
echo "#	crdl_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} < crdl_pop_topdep.plsql >>$logfilename 2>&1
echo "#	crdl_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_bprjdef.plsql >>$logfilename 2>&1
echo "#	crdl_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rprjdef.plsql >>$logfilename 2>&1
echo "#	crdl_reldef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_reldef.plsql >>$logfilename 2>&1
echo "#	crdl_relcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_relcol.plsql >>$logfilename 2>&1
echo "#	crdl_rel_type.plsql" >>${logfilename}
${sqlpluscmd} < crdl_rel_type.plsql >>$logfilename 2>&1
echo "#	crdl_schemadef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schemadef.plsql >>$logfilename 2>&1
echo "#	crdl_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} < crdl_schema_ref.plsql >>$logfilename 2>&1
echo "#	crdl_scopedef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_scopedef.plsql >>$logfilename 2>&1
echo "#	crdl_secapp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secapp.plsql >>$logfilename 2>&1
echo "#	crdl_secdev.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secdev.plsql >>$logfilename 2>&1
echo "#	crdl_secform.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secform.plsql >>$logfilename 2>&1
echo "#	crdl_secgrp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrp.plsql >>$logfilename 2>&1
echo "#	crdl_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secgrpfrm.plsql >>$logfilename 2>&1
echo "#	crdl_secinc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secinc.plsql >>$logfilename 2>&1
echo "#	crdl_secmemb.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secmemb.plsql >>$logfilename 2>&1
echo "#	crdl_secsess.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secsess.plsql >>$logfilename 2>&1
echo "#	crdl_secuser.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secuser.plsql >>$logfilename 2>&1
echo "#	crdl_secscope.plsql" >>${logfilename}
${sqlpluscmd} < crdl_secscope.plsql >>$logfilename 2>&1
echo "#	crdl_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvlfunc.plsql >>$logfilename 2>&1
echo "#	crdl_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvmeth.plsql >>$logfilename 2>&1
echo "#	crdl_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvofunc.plsql >>$logfilename 2>&1
echo "#	crdl_srvprc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_srvprc.plsql >>$logfilename 2>&1
echo "#	crdl_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_hostsvc.plsql >>$logfilename 2>&1
echo "#	crdl_svctype.plsql" >>${logfilename}
${sqlpluscmd} < crdl_svctype.plsql >>$logfilename 2>&1
echo "#	crdl_strcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strcol.plsql >>$logfilename 2>&1
echo "#	crdl_strdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strdef.plsql >>$logfilename 2>&1
echo "#	crdl_strtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_strtyp.plsql >>$logfilename 2>&1
echo "#	crdl_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sprjdef.plsql >>$logfilename 2>&1
echo "#	crdl_sysclus.plsql" >>${logfilename}
${sqlpluscmd} < crdl_sysclus.plsql >>$logfilename 2>&1
echo "#	crdl_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecgrp.plsql >>$logfilename 2>&1
echo "#	crdl_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecinc.plsql >>$logfilename 2>&1
echo "#	crdl_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsecmemb.plsql >>$logfilename 2>&1
echo "#	crdl_dzcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzcol.plsql >>$logfilename 2>&1
echo "#	crdl_dzdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dzdef.plsql >>$logfilename 2>&1
echo "#	crdl_dztyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_dztyp.plsql >>$logfilename 2>&1
echo "#	crdl_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzcol.plsql >>$logfilename 2>&1
echo "#	crdl_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmzdef.plsql >>$logfilename 2>&1
echo "#	crdl_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmztyp.plsql >>$logfilename 2>&1
echo "#	crdl_zscol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zscol.plsql >>$logfilename 2>&1
echo "#	crdl_zsdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zsdef.plsql >>$logfilename 2>&1
echo "#	crdl_zstyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_zstyp.plsql >>$logfilename 2>&1
echo "#	crdl_tbldef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tbldef.plsql >>$logfilename 2>&1
echo "#	crdl_tblcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tblcol.plsql >>$logfilename 2>&1
echo "#	crdl_tenant.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tenant.plsql >>$logfilename 2>&1
echo "#	crdl_txtcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtcol.plsql >>$logfilename 2>&1
echo "#	crdl_txtdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txtdef.plsql >>$logfilename 2>&1
echo "#	crdl_txttyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_txttyp.plsql >>$logfilename 2>&1
echo "#	crdl_tmcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmcol.plsql >>$logfilename 2>&1
echo "#	crdl_tmdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmdef.plsql >>$logfilename 2>&1
echo "#	crdl_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tmtyp.plsql >>$logfilename 2>&1
echo "#	crdl_tscol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tscol.plsql >>$logfilename 2>&1
echo "#	crdl_tsdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tsdef.plsql >>$logfilename 2>&1
echo "#	crdl_tstyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tstyp.plsql >>$logfilename 2>&1
echo "#	crdl_tlddef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tlddef.plsql >>$logfilename 2>&1
echo "#	crdl_tkncol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkncol.plsql >>$logfilename 2>&1
echo "#	crdl_tkndef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkndef.plsql >>$logfilename 2>&1
echo "#	crdl_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tkntyp.plsql >>$logfilename 2>&1
echo "#	crdl_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tdomdef.plsql >>$logfilename 2>&1
echo "#	crdl_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_tprjdef.plsql >>$logfilename 2>&1
echo "#	crdl_uint16col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16col.plsql >>$logfilename 2>&1
echo "#	crdl_u16def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u16def.plsql >>$logfilename 2>&1
echo "#	crdl_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint16typ.plsql >>$logfilename 2>&1
echo "#	crdl_uint32col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32col.plsql >>$logfilename 2>&1
echo "#	crdl_u32def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u32def.plsql >>$logfilename 2>&1
echo "#	crdl_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint32typ.plsql >>$logfilename 2>&1
echo "#	crdl_uint64col.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64col.plsql >>$logfilename 2>&1
echo "#	crdl_u64def.plsql" >>${logfilename}
${sqlpluscmd} < crdl_u64def.plsql >>$logfilename 2>&1
echo "#	crdl_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uint64typ.plsql >>$logfilename 2>&1
echo "#	crdl_urlproto.plsql" >>${logfilename}
${sqlpluscmd} < crdl_urlproto.plsql >>$logfilename 2>&1
echo "#	crdl_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidcol.plsql >>$logfilename 2>&1
echo "#	crdl_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuiddef.plsql >>$logfilename 2>&1
echo "#	crdl_idguuid.plsql" >>${logfilename}
${sqlpluscmd} < crdl_idguuid.plsql >>$logfilename 2>&1
echo "#	crdl_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} < crdl_uuidtyp.plsql >>$logfilename 2>&1
echo "#	crdl_valdef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_valdef.plsql >>$logfilename 2>&1
echo "#	crdl_verndef.plsql" >>${logfilename}
${sqlpluscmd} < crdl_verndef.plsql >>$logfilename 2>&1

