#!/bin/bash
#
#	@(#) dbcreate/cfbam/oracle/crtbl_cfbam23.bash
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
	logfilename=`date +'crtbl_cfbam23-%Y%m%d_%Hh%M.log'`
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

echo "# crtbl_clus.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clus.plsql >>${logfilename} 2>&1
echo "# crtbl_clus_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clus_idg32.plsql >>${logfilename} 2>&1
echo "# crtbl_clus_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clus_idg64.plsql >>${logfilename} 2>&1
echo "# crtbl_secapp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secapp.plsql >>${logfilename} 2>&1
echo "# crtbl_secform.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secform.plsql >>${logfilename} 2>&1
echo "# crtbl_secgrp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secgrp.plsql >>${logfilename} 2>&1
echo "# crtbl_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secgrpfrm.plsql >>${logfilename} 2>&1
echo "# crtbl_secinc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secinc.plsql >>${logfilename} 2>&1
echo "# crtbl_secmemb.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secmemb.plsql >>${logfilename} 2>&1
echo "# crtbl_secsess.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secsess.plsql >>${logfilename} 2>&1
echo "# crtbl_secuser.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secuser.plsql >>${logfilename} 2>&1
echo "# crtbl_tenant.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tenant.plsql >>${logfilename} 2>&1
echo "# crtbl_tenant_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tenant_idg32.plsql >>${logfilename} 2>&1
echo "# crtbl_tenant_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tenant_idg64.plsql >>${logfilename} 2>&1
echo "# crtbl_accfreq.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_accfreq.plsql >>${logfilename} 2>&1
echo "# crtbl_accsec.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_accsec.plsql >>${logfilename} 2>&1
echo "# crtbl_atomdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_atomdef.plsql >>${logfilename} 2>&1
echo "# crtbl_auditaction.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_auditaction.plsql >>${logfilename} 2>&1
echo "# crtbl_blbcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbcol.plsql >>${logfilename} 2>&1
echo "# crtbl_blbdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbdef.plsql >>${logfilename} 2>&1
echo "# crtbl_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_boolcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_boolcol.plsql >>${logfilename} 2>&1
echo "# crtbl_booldef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_booldef.plsql >>${logfilename} 2>&1
echo "# crtbl_booltyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_booltyp.plsql >>${logfilename} 2>&1
echo "# crtbl_chain_def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_chain_def.plsql >>${logfilename} 2>&1
echo "# crtbl_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clr_dep.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep1.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep2.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep3.plsql >>${logfilename} 2>&1
echo "# crtbl_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clr_topdep.plsql >>${logfilename} 2>&1
echo "# crtbl_datascope.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_datascope.plsql >>${logfilename} 2>&1
echo "# crtbl_dtcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dtcol.plsql >>${logfilename} 2>&1
echo "# crtbl_dtdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dtdef.plsql >>${logfilename} 2>&1
echo "# crtbl_dttyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dttyp.plsql >>${logfilename} 2>&1
echo "# crtbl_del_dep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_del_dep.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep1.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep2.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep3.plsql >>${logfilename} 2>&1
echo "# crtbl_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_del_topdep.plsql >>${logfilename} 2>&1
echo "# crtbl_domdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_domdef.plsql >>${logfilename} 2>&1
echo "# crtbl_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_bdomdef.plsql >>${logfilename} 2>&1
echo "# crtbl_dblcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dblcol.plsql >>${logfilename} 2>&1
echo "# crtbl_dbldef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dbldef.plsql >>${logfilename} 2>&1
echo "# crtbl_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dbltyp.plsql >>${logfilename} 2>&1
echo "# crtbl_enumcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumcol.plsql >>${logfilename} 2>&1
echo "# crtbl_enumdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumdef.plsql >>${logfilename} 2>&1
echo "# crtbl_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enum_tag.plsql >>${logfilename} 2>&1
echo "# crtbl_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_fltcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_fltcol.plsql >>${logfilename} 2>&1
echo "# crtbl_fltdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_fltdef.plsql >>${logfilename} 2>&1
echo "# crtbl_flttyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_flttyp.plsql >>${logfilename} 2>&1
echo "# crtbl_hostnode.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_hostnode.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntry.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntryccy.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntrylng.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_ccy.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_lang.plsql >>${logfilename} 2>&1
echo "# crtbl_isotz.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_isotz.plsql >>${logfilename} 2>&1
echo "# crtbl_idg16.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg16.plsql >>${logfilename} 2>&1
echo "# crtbl_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg32.plsql >>${logfilename} 2>&1
echo "# crtbl_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg64.plsql >>${logfilename} 2>&1
echo "# crtbl_idxdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idxdef.plsql >>${logfilename} 2>&1
echo "# crtbl_idxcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idxcol.plsql >>${logfilename} 2>&1
echo "# crtbl_int16col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16col.plsql >>${logfilename} 2>&1
echo "# crtbl_int16def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16def.plsql >>${logfilename} 2>&1
echo "# crtbl_int16typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16typ.plsql >>${logfilename} 2>&1
echo "# crtbl_int32col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32col.plsql >>${logfilename} 2>&1
echo "# crtbl_int32def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32def.plsql >>${logfilename} 2>&1
echo "# crtbl_int32typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32typ.plsql >>${logfilename} 2>&1
echo "# crtbl_int64col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64col.plsql >>${logfilename} 2>&1
echo "# crtbl_int64def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64def.plsql >>${logfilename} 2>&1
echo "# crtbl_int64typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64typ.plsql >>${logfilename} 2>&1
echo "# crtbl_licn.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_licn.plsql >>${logfilename} 2>&1
echo "# crtbl_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_loadbehav.plsql >>${logfilename} 2>&1
echo "# crtbl_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mjverdef.plsql >>${logfilename} 2>&1
echo "# crtbl_mimetype.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mimetype.plsql >>${logfilename} 2>&1
echo "# crtbl_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mnverdef.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkncol.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkndef.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkntyp.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknscol.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknsdef.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknstyp.plsql >>${logfilename} 2>&1
echo "# crtbl_numcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numcol.plsql >>${logfilename} 2>&1
echo "# crtbl_numdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numdef.plsql >>${logfilename} 2>&1
echo "# crtbl_numtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_srvprm.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvprm.plsql >>${logfilename} 2>&1
echo "# crtbl_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_pop_dep.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep1.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep2.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep3.plsql >>${logfilename} 2>&1
echo "# crtbl_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_pop_topdep.plsql >>${logfilename} 2>&1
echo "# crtbl_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_bprjdef.plsql >>${logfilename} 2>&1
echo "# crtbl_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_rprjdef.plsql >>${logfilename} 2>&1
echo "# crtbl_reldef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_reldef.plsql >>${logfilename} 2>&1
echo "# crtbl_relcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_relcol.plsql >>${logfilename} 2>&1
echo "# crtbl_rel_type.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_rel_type.plsql >>${logfilename} 2>&1
echo "# crtbl_schemadef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_schemadef.plsql >>${logfilename} 2>&1
echo "# crtbl_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_schema_ref.plsql >>${logfilename} 2>&1
echo "# crtbl_scopedef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_scopedef.plsql >>${logfilename} 2>&1
echo "# crtbl_secdev.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secdev.plsql >>${logfilename} 2>&1
echo "# crtbl_secscope.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secscope.plsql >>${logfilename} 2>&1
echo "# crtbl_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvlfunc.plsql >>${logfilename} 2>&1
echo "# crtbl_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvmeth.plsql >>${logfilename} 2>&1
echo "# crtbl_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvofunc.plsql >>${logfilename} 2>&1
echo "# crtbl_srvprc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvprc.plsql >>${logfilename} 2>&1
echo "# crtbl_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_hostsvc.plsql >>${logfilename} 2>&1
echo "# crtbl_svctype.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_svctype.plsql >>${logfilename} 2>&1
echo "# crtbl_strcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strcol.plsql >>${logfilename} 2>&1
echo "# crtbl_strdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strdef.plsql >>${logfilename} 2>&1
echo "# crtbl_strtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_sprjdef.plsql >>${logfilename} 2>&1
echo "# crtbl_sysclus.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_sysclus.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecgrp.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecinc.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecmemb.plsql >>${logfilename} 2>&1
echo "# crtbl_dzcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dzcol.plsql >>${logfilename} 2>&1
echo "# crtbl_dzdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dzdef.plsql >>${logfilename} 2>&1
echo "# crtbl_dztyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dztyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmzcol.plsql >>${logfilename} 2>&1
echo "# crtbl_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmzdef.plsql >>${logfilename} 2>&1
echo "# crtbl_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmztyp.plsql >>${logfilename} 2>&1
echo "# crtbl_zscol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zscol.plsql >>${logfilename} 2>&1
echo "# crtbl_zsdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zsdef.plsql >>${logfilename} 2>&1
echo "# crtbl_zstyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zstyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tbldef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tbldef.plsql >>${logfilename} 2>&1
echo "# crtbl_tblcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tblcol.plsql >>${logfilename} 2>&1
echo "# crtbl_txtcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txtcol.plsql >>${logfilename} 2>&1
echo "# crtbl_txtdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txtdef.plsql >>${logfilename} 2>&1
echo "# crtbl_txttyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txttyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tmcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmcol.plsql >>${logfilename} 2>&1
echo "# crtbl_tmdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmdef.plsql >>${logfilename} 2>&1
echo "# crtbl_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tscol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tscol.plsql >>${logfilename} 2>&1
echo "# crtbl_tsdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsdef.plsql >>${logfilename} 2>&1
echo "# crtbl_tstyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tstyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tlddef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tlddef.plsql >>${logfilename} 2>&1
echo "# crtbl_tkncol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkncol.plsql >>${logfilename} 2>&1
echo "# crtbl_tkndef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkndef.plsql >>${logfilename} 2>&1
echo "# crtbl_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkntyp.plsql >>${logfilename} 2>&1
echo "# crtbl_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tdomdef.plsql >>${logfilename} 2>&1
echo "# crtbl_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tprjdef.plsql >>${logfilename} 2>&1
echo "# crtbl_uint16col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint16col.plsql >>${logfilename} 2>&1
echo "# crtbl_u16def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u16def.plsql >>${logfilename} 2>&1
echo "# crtbl_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint16typ.plsql >>${logfilename} 2>&1
echo "# crtbl_uint32col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint32col.plsql >>${logfilename} 2>&1
echo "# crtbl_u32def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u32def.plsql >>${logfilename} 2>&1
echo "# crtbl_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint32typ.plsql >>${logfilename} 2>&1
echo "# crtbl_uint64col.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint64col.plsql >>${logfilename} 2>&1
echo "# crtbl_u64def.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u64def.plsql >>${logfilename} 2>&1
echo "# crtbl_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint64typ.plsql >>${logfilename} 2>&1
echo "# crtbl_urlproto.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_urlproto.plsql >>${logfilename} 2>&1
echo "# crtbl_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuidcol.plsql >>${logfilename} 2>&1
echo "# crtbl_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuiddef.plsql >>${logfilename} 2>&1
echo "# crtbl_idguuid.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idguuid.plsql >>${logfilename} 2>&1
echo "# crtbl_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuidtyp.plsql >>${logfilename} 2>&1
echo "# crtbl_valdef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_valdef.plsql >>${logfilename} 2>&1
echo "# crtbl_verndef.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_verndef.plsql >>${logfilename} 2>&1
echo "# crtbl_atomdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_atomdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_blbcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_blbdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_blbtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_blbtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_boolcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_boolcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_booldef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_booldef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_booltyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_booltyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_chain_def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_chain_def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clr_dep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clr_dep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep1_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep1_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep2_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep2_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clrsubdep3_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clrsubdep3_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clr_topdep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clr_topdep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_clus_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_clus_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dtcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dtcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dtdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dtdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dttyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dttyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_del_dep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_del_dep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep1_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep1_h.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep2_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep2_h.plsql >>${logfilename} 2>&1
echo "# crtbl_delsubdep3_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_delsubdep3_h.plsql >>${logfilename} 2>&1
echo "# crtbl_del_topdep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_del_topdep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_domdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_domdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_bdomdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_bdomdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dblcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dblcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dbldef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dbldef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dbltyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dbltyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_enumcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_enumdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_enum_tag_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enum_tag_h.plsql >>${logfilename} 2>&1
echo "# crtbl_enumtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_enumtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_fltcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_fltcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_fltdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_fltdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_flttyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_flttyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_hostnode_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_hostnode_h.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntry_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntry_h.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntryccy_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntryccy_h.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_cntrylng_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_cntrylng_h.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_ccy_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_ccy_h.plsql >>${logfilename} 2>&1
echo "# crtbl_iso_lang_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_iso_lang_h.plsql >>${logfilename} 2>&1
echo "# crtbl_isotz_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_isotz_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idg16_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg16_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idg32_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg32_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idg64_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idg64_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idxdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idxdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idxcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idxcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int16col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int16def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int16typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int16typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int32col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int32def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int32typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int32typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int64col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int64def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_int64typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_int64typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_mjverdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mjverdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_mimetype_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mimetype_h.plsql >>${logfilename} 2>&1
echo "# crtbl_mnverdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_mnverdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkncol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkncol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkndef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkndef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtkntyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtkntyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknscol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknscol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknsdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknsdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_nmtknstyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_nmtknstyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_numcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_numdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_numtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_numtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_srvprm_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvprm_h.plsql >>${logfilename} 2>&1
echo "# crtbl_pop_dep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_pop_dep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep1_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep1_h.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep2_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep2_h.plsql >>${logfilename} 2>&1
echo "# crtbl_popsubdep3_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_popsubdep3_h.plsql >>${logfilename} 2>&1
echo "# crtbl_pop_topdep_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_pop_topdep_h.plsql >>${logfilename} 2>&1
echo "# crtbl_bprjdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_bprjdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_rprjdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_rprjdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_reldef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_reldef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_relcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_relcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_schemadef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_schemadef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_schema_ref_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_schema_ref_h.plsql >>${logfilename} 2>&1
echo "# crtbl_scopedef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_scopedef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secapp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secapp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secdev_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secdev_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secform_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secform_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secgrp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secgrp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secgrpfrm_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secgrpfrm_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secinc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secinc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secmemb_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secmemb_h.plsql >>${logfilename} 2>&1
echo "# crtbl_secuser_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_secuser_h.plsql >>${logfilename} 2>&1
echo "# crtbl_srvlfunc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvlfunc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_srvmeth_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvmeth_h.plsql >>${logfilename} 2>&1
echo "# crtbl_srvofunc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvofunc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_srvprc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_srvprc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_hostsvc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_hostsvc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_svctype_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_svctype_h.plsql >>${logfilename} 2>&1
echo "# crtbl_strcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_strdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_strtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_strtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_sprjdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_sprjdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecgrp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecgrp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecinc_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecinc_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tsecmemb_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsecmemb_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dzcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dzcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dzdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dzdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_dztyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_dztyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmzcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmzcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmzdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmzdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmztyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmztyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_zscol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zscol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_zsdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zsdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_zstyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_zstyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tbldef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tbldef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tblcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tblcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tenant_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tenant_h.plsql >>${logfilename} 2>&1
echo "# crtbl_txtcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txtcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_txtdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txtdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_txttyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_txttyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tmtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tmtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tscol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tscol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tsdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tsdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tstyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tstyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tlddef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tlddef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tkncol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkncol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tkndef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkndef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tkntyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tkntyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tdomdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tdomdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_tprjdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_tprjdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint16col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint16col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_u16def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u16def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint16typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint16typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint32col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint32col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_u32def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u32def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint32typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint32typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint64col_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint64col_h.plsql >>${logfilename} 2>&1
echo "# crtbl_u64def_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_u64def_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uint64typ_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uint64typ_h.plsql >>${logfilename} 2>&1
echo "# crtbl_urlproto_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_urlproto_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uuidcol_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuidcol_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uuiddef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuiddef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_idguuid_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_idguuid_h.plsql >>${logfilename} 2>&1
echo "# crtbl_uuidtyp_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_uuidtyp_h.plsql >>${logfilename} 2>&1
echo "# crtbl_valdef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_valdef_h.plsql >>${logfilename} 2>&1
echo "# crtbl_verndef_h.plsql" >>${logfilename}
${sqlpluscmd} <crtbl_verndef_h.plsql >>${logfilename} 2>&1

