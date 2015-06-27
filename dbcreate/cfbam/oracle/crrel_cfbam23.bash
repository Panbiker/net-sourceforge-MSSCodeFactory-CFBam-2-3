#!/bin/bash
#
#	@(#) dbcreate/cfbam/oracle/crrel_cfbam23.bash
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
	logfilename=`date +'crrel_cfbam23-%Y%m%d_%Hh%M.log'`
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

echo "# crrel_accfreq.plsql" >>${logfilename}
${sqlpluscmd} <crrel_accfreq.plsql >>${logfilename} 2>&1
echo "# crrel_accsec.plsql" >>${logfilename}
${sqlpluscmd} <crrel_accsec.plsql >>${logfilename} 2>&1
echo "# crrel_atomdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_atomdef.plsql >>${logfilename} 2>&1
echo "# crrel_auditaction.plsql" >>${logfilename}
${sqlpluscmd} <crrel_auditaction.plsql >>${logfilename} 2>&1
echo "# crrel_blbcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_blbcol.plsql >>${logfilename} 2>&1
echo "# crrel_blbdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_blbdef.plsql >>${logfilename} 2>&1
echo "# crrel_blbtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_blbtyp.plsql >>${logfilename} 2>&1
echo "# crrel_boolcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_boolcol.plsql >>${logfilename} 2>&1
echo "# crrel_booldef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_booldef.plsql >>${logfilename} 2>&1
echo "# crrel_booltyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_booltyp.plsql >>${logfilename} 2>&1
echo "# crrel_chain_def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_chain_def.plsql >>${logfilename} 2>&1
echo "# crrel_clr_dep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clr_dep.plsql >>${logfilename} 2>&1
echo "# crrel_clrsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clrsubdep1.plsql >>${logfilename} 2>&1
echo "# crrel_clrsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clrsubdep2.plsql >>${logfilename} 2>&1
echo "# crrel_clrsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clrsubdep3.plsql >>${logfilename} 2>&1
echo "# crrel_clr_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clr_topdep.plsql >>${logfilename} 2>&1
echo "# crrel_clus.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clus.plsql >>${logfilename} 2>&1
echo "# crrel_clus_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clus_idg32.plsql >>${logfilename} 2>&1
echo "# crrel_clus_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crrel_clus_idg64.plsql >>${logfilename} 2>&1
echo "# crrel_datascope.plsql" >>${logfilename}
${sqlpluscmd} <crrel_datascope.plsql >>${logfilename} 2>&1
echo "# crrel_dtcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dtcol.plsql >>${logfilename} 2>&1
echo "# crrel_dtdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dtdef.plsql >>${logfilename} 2>&1
echo "# crrel_dttyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dttyp.plsql >>${logfilename} 2>&1
echo "# crrel_del_dep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_del_dep.plsql >>${logfilename} 2>&1
echo "# crrel_delsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crrel_delsubdep1.plsql >>${logfilename} 2>&1
echo "# crrel_delsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crrel_delsubdep2.plsql >>${logfilename} 2>&1
echo "# crrel_delsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crrel_delsubdep3.plsql >>${logfilename} 2>&1
echo "# crrel_del_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_del_topdep.plsql >>${logfilename} 2>&1
echo "# crrel_domdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_domdef.plsql >>${logfilename} 2>&1
echo "# crrel_bdomdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_bdomdef.plsql >>${logfilename} 2>&1
echo "# crrel_dblcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dblcol.plsql >>${logfilename} 2>&1
echo "# crrel_dbldef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dbldef.plsql >>${logfilename} 2>&1
echo "# crrel_dbltyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dbltyp.plsql >>${logfilename} 2>&1
echo "# crrel_enumcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_enumcol.plsql >>${logfilename} 2>&1
echo "# crrel_enumdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_enumdef.plsql >>${logfilename} 2>&1
echo "# crrel_enum_tag.plsql" >>${logfilename}
${sqlpluscmd} <crrel_enum_tag.plsql >>${logfilename} 2>&1
echo "# crrel_enumtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_enumtyp.plsql >>${logfilename} 2>&1
echo "# crrel_fltcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_fltcol.plsql >>${logfilename} 2>&1
echo "# crrel_fltdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_fltdef.plsql >>${logfilename} 2>&1
echo "# crrel_flttyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_flttyp.plsql >>${logfilename} 2>&1
echo "# crrel_hostnode.plsql" >>${logfilename}
${sqlpluscmd} <crrel_hostnode.plsql >>${logfilename} 2>&1
echo "# crrel_iso_cntry.plsql" >>${logfilename}
${sqlpluscmd} <crrel_iso_cntry.plsql >>${logfilename} 2>&1
echo "# crrel_iso_cntryccy.plsql" >>${logfilename}
${sqlpluscmd} <crrel_iso_cntryccy.plsql >>${logfilename} 2>&1
echo "# crrel_iso_cntrylng.plsql" >>${logfilename}
${sqlpluscmd} <crrel_iso_cntrylng.plsql >>${logfilename} 2>&1
echo "# crrel_iso_ccy.plsql" >>${logfilename}
${sqlpluscmd} <crrel_iso_ccy.plsql >>${logfilename} 2>&1
echo "# crrel_iso_lang.plsql" >>${logfilename}
${sqlpluscmd} <crrel_iso_lang.plsql >>${logfilename} 2>&1
echo "# crrel_isotz.plsql" >>${logfilename}
${sqlpluscmd} <crrel_isotz.plsql >>${logfilename} 2>&1
echo "# crrel_idg16.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idg16.plsql >>${logfilename} 2>&1
echo "# crrel_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idg32.plsql >>${logfilename} 2>&1
echo "# crrel_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idg64.plsql >>${logfilename} 2>&1
echo "# crrel_idxdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idxdef.plsql >>${logfilename} 2>&1
echo "# crrel_idxcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idxcol.plsql >>${logfilename} 2>&1
echo "# crrel_int16col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int16col.plsql >>${logfilename} 2>&1
echo "# crrel_int16def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int16def.plsql >>${logfilename} 2>&1
echo "# crrel_int16typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int16typ.plsql >>${logfilename} 2>&1
echo "# crrel_int32col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int32col.plsql >>${logfilename} 2>&1
echo "# crrel_int32def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int32def.plsql >>${logfilename} 2>&1
echo "# crrel_int32typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int32typ.plsql >>${logfilename} 2>&1
echo "# crrel_int64col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int64col.plsql >>${logfilename} 2>&1
echo "# crrel_int64def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int64def.plsql >>${logfilename} 2>&1
echo "# crrel_int64typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_int64typ.plsql >>${logfilename} 2>&1
echo "# crrel_licn.plsql" >>${logfilename}
${sqlpluscmd} <crrel_licn.plsql >>${logfilename} 2>&1
echo "# crrel_loadbehav.plsql" >>${logfilename}
${sqlpluscmd} <crrel_loadbehav.plsql >>${logfilename} 2>&1
echo "# crrel_mjverdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_mjverdef.plsql >>${logfilename} 2>&1
echo "# crrel_mimetype.plsql" >>${logfilename}
${sqlpluscmd} <crrel_mimetype.plsql >>${logfilename} 2>&1
echo "# crrel_mnverdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_mnverdef.plsql >>${logfilename} 2>&1
echo "# crrel_nmtkncol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtkncol.plsql >>${logfilename} 2>&1
echo "# crrel_nmtkndef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtkndef.plsql >>${logfilename} 2>&1
echo "# crrel_nmtkntyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtkntyp.plsql >>${logfilename} 2>&1
echo "# crrel_nmtknscol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtknscol.plsql >>${logfilename} 2>&1
echo "# crrel_nmtknsdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtknsdef.plsql >>${logfilename} 2>&1
echo "# crrel_nmtknstyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_nmtknstyp.plsql >>${logfilename} 2>&1
echo "# crrel_numcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_numcol.plsql >>${logfilename} 2>&1
echo "# crrel_numdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_numdef.plsql >>${logfilename} 2>&1
echo "# crrel_numtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_numtyp.plsql >>${logfilename} 2>&1
echo "# crrel_srvprm.plsql" >>${logfilename}
${sqlpluscmd} <crrel_srvprm.plsql >>${logfilename} 2>&1
echo "# crrel_pop_dep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_pop_dep.plsql >>${logfilename} 2>&1
echo "# crrel_popsubdep1.plsql" >>${logfilename}
${sqlpluscmd} <crrel_popsubdep1.plsql >>${logfilename} 2>&1
echo "# crrel_popsubdep2.plsql" >>${logfilename}
${sqlpluscmd} <crrel_popsubdep2.plsql >>${logfilename} 2>&1
echo "# crrel_popsubdep3.plsql" >>${logfilename}
${sqlpluscmd} <crrel_popsubdep3.plsql >>${logfilename} 2>&1
echo "# crrel_pop_topdep.plsql" >>${logfilename}
${sqlpluscmd} <crrel_pop_topdep.plsql >>${logfilename} 2>&1
echo "# crrel_bprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_bprjdef.plsql >>${logfilename} 2>&1
echo "# crrel_rprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_rprjdef.plsql >>${logfilename} 2>&1
echo "# crrel_reldef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_reldef.plsql >>${logfilename} 2>&1
echo "# crrel_relcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_relcol.plsql >>${logfilename} 2>&1
echo "# crrel_rel_type.plsql" >>${logfilename}
${sqlpluscmd} <crrel_rel_type.plsql >>${logfilename} 2>&1
echo "# crrel_schemadef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_schemadef.plsql >>${logfilename} 2>&1
echo "# crrel_schema_ref.plsql" >>${logfilename}
${sqlpluscmd} <crrel_schema_ref.plsql >>${logfilename} 2>&1
echo "# crrel_scopedef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_scopedef.plsql >>${logfilename} 2>&1
echo "# crrel_secapp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secapp.plsql >>${logfilename} 2>&1
echo "# crrel_secdev.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secdev.plsql >>${logfilename} 2>&1
echo "# crrel_secform.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secform.plsql >>${logfilename} 2>&1
echo "# crrel_secgrp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secgrp.plsql >>${logfilename} 2>&1
echo "# crrel_secgrpfrm.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secgrpfrm.plsql >>${logfilename} 2>&1
echo "# crrel_secinc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secinc.plsql >>${logfilename} 2>&1
echo "# crrel_secmemb.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secmemb.plsql >>${logfilename} 2>&1
echo "# crrel_secsess.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secsess.plsql >>${logfilename} 2>&1
echo "# crrel_secuser.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secuser.plsql >>${logfilename} 2>&1
echo "# crrel_secscope.plsql" >>${logfilename}
${sqlpluscmd} <crrel_secscope.plsql >>${logfilename} 2>&1
echo "# crrel_srvlfunc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_srvlfunc.plsql >>${logfilename} 2>&1
echo "# crrel_srvmeth.plsql" >>${logfilename}
${sqlpluscmd} <crrel_srvmeth.plsql >>${logfilename} 2>&1
echo "# crrel_srvofunc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_srvofunc.plsql >>${logfilename} 2>&1
echo "# crrel_srvprc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_srvprc.plsql >>${logfilename} 2>&1
echo "# crrel_hostsvc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_hostsvc.plsql >>${logfilename} 2>&1
echo "# crrel_svctype.plsql" >>${logfilename}
${sqlpluscmd} <crrel_svctype.plsql >>${logfilename} 2>&1
echo "# crrel_strcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_strcol.plsql >>${logfilename} 2>&1
echo "# crrel_strdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_strdef.plsql >>${logfilename} 2>&1
echo "# crrel_strtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_strtyp.plsql >>${logfilename} 2>&1
echo "# crrel_sprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_sprjdef.plsql >>${logfilename} 2>&1
echo "# crrel_sysclus.plsql" >>${logfilename}
${sqlpluscmd} <crrel_sysclus.plsql >>${logfilename} 2>&1
echo "# crrel_tsecgrp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tsecgrp.plsql >>${logfilename} 2>&1
echo "# crrel_tsecinc.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tsecinc.plsql >>${logfilename} 2>&1
echo "# crrel_tsecmemb.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tsecmemb.plsql >>${logfilename} 2>&1
echo "# crrel_dzcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dzcol.plsql >>${logfilename} 2>&1
echo "# crrel_dzdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dzdef.plsql >>${logfilename} 2>&1
echo "# crrel_dztyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_dztyp.plsql >>${logfilename} 2>&1
echo "# crrel_tmzcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmzcol.plsql >>${logfilename} 2>&1
echo "# crrel_tmzdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmzdef.plsql >>${logfilename} 2>&1
echo "# crrel_tmztyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmztyp.plsql >>${logfilename} 2>&1
echo "# crrel_zscol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_zscol.plsql >>${logfilename} 2>&1
echo "# crrel_zsdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_zsdef.plsql >>${logfilename} 2>&1
echo "# crrel_zstyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_zstyp.plsql >>${logfilename} 2>&1
echo "# crrel_tbldef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tbldef.plsql >>${logfilename} 2>&1
echo "# crrel_tblcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tblcol.plsql >>${logfilename} 2>&1
echo "# crrel_tenant.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tenant.plsql >>${logfilename} 2>&1
echo "# crrel_tenant_idg32.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tenant_idg32.plsql >>${logfilename} 2>&1
echo "# crrel_tenant_idg64.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tenant_idg64.plsql >>${logfilename} 2>&1
echo "# crrel_txtcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_txtcol.plsql >>${logfilename} 2>&1
echo "# crrel_txtdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_txtdef.plsql >>${logfilename} 2>&1
echo "# crrel_txttyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_txttyp.plsql >>${logfilename} 2>&1
echo "# crrel_tmcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmcol.plsql >>${logfilename} 2>&1
echo "# crrel_tmdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmdef.plsql >>${logfilename} 2>&1
echo "# crrel_tmtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tmtyp.plsql >>${logfilename} 2>&1
echo "# crrel_tscol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tscol.plsql >>${logfilename} 2>&1
echo "# crrel_tsdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tsdef.plsql >>${logfilename} 2>&1
echo "# crrel_tstyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tstyp.plsql >>${logfilename} 2>&1
echo "# crrel_tlddef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tlddef.plsql >>${logfilename} 2>&1
echo "# crrel_tkncol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tkncol.plsql >>${logfilename} 2>&1
echo "# crrel_tkndef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tkndef.plsql >>${logfilename} 2>&1
echo "# crrel_tkntyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tkntyp.plsql >>${logfilename} 2>&1
echo "# crrel_tdomdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tdomdef.plsql >>${logfilename} 2>&1
echo "# crrel_tprjdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_tprjdef.plsql >>${logfilename} 2>&1
echo "# crrel_uint16col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint16col.plsql >>${logfilename} 2>&1
echo "# crrel_u16def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_u16def.plsql >>${logfilename} 2>&1
echo "# crrel_uint16typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint16typ.plsql >>${logfilename} 2>&1
echo "# crrel_uint32col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint32col.plsql >>${logfilename} 2>&1
echo "# crrel_u32def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_u32def.plsql >>${logfilename} 2>&1
echo "# crrel_uint32typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint32typ.plsql >>${logfilename} 2>&1
echo "# crrel_uint64col.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint64col.plsql >>${logfilename} 2>&1
echo "# crrel_u64def.plsql" >>${logfilename}
${sqlpluscmd} <crrel_u64def.plsql >>${logfilename} 2>&1
echo "# crrel_uint64typ.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uint64typ.plsql >>${logfilename} 2>&1
echo "# crrel_urlproto.plsql" >>${logfilename}
${sqlpluscmd} <crrel_urlproto.plsql >>${logfilename} 2>&1
echo "# crrel_uuidcol.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uuidcol.plsql >>${logfilename} 2>&1
echo "# crrel_uuiddef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uuiddef.plsql >>${logfilename} 2>&1
echo "# crrel_idguuid.plsql" >>${logfilename}
${sqlpluscmd} <crrel_idguuid.plsql >>${logfilename} 2>&1
echo "# crrel_uuidtyp.plsql" >>${logfilename}
${sqlpluscmd} <crrel_uuidtyp.plsql >>${logfilename} 2>&1
echo "# crrel_valdef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_valdef.plsql >>${logfilename} 2>&1
echo "# crrel_verndef.plsql" >>${logfilename}
${sqlpluscmd} <crrel_verndef.plsql >>${logfilename} 2>&1

