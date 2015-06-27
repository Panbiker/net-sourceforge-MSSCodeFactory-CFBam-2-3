#!/bin/bash
#
#	@(#) dbcreate/cfbam/oracle/cridx_cfbam23.bash
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
	logfilename=`date +'cridx_cfbam23-%Y%m%d_%Hh%M.log'`
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

echo "# cridx_accfreq_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_accfreq_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_accsec_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_accsec_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_auditaction_xudsc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_auditaction_xudsc.plsql >>${logfilename} 2>&1
echo "# cridx_blbcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_blbcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_blbtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_blbtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_boolcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_boolcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_booltyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_booltyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_chain_xtent.plsql" >>${logfilename}
${sqlpluscmd} <cridx_chain_xtent.plsql >>${logfilename} 2>&1
echo "# cridx_chain_xtbl.plsql" >>${logfilename}
${sqlpluscmd} <cridx_chain_xtbl.plsql >>${logfilename} 2>&1
echo "# cridx_chain_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_chain_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_chain_xprevrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_chain_xprevrel.plsql >>${logfilename} 2>&1
echo "# cridx_chain_xnextrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_chain_xnextrel.plsql >>${logfilename} 2>&1
echo "# cridx_clrdep_xrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrdep_xrel.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep1_xcdeltopdep.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep1_xcdeltopdep.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep1_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep1_uname.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep2_xcdeldep1.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep2_xcdeldep1.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep2_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep2_uname.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep3_xcdeldep2.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep3_xcdeldep2.plsql >>${logfilename} 2>&1
echo "# cridx_clrsubdep3_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrsubdep3_uname.plsql >>${logfilename} 2>&1
echo "# cridx_clrtop_xctbl.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrtop_xctbl.plsql >>${logfilename} 2>&1
echo "# cridx_clrtopdep_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_clrtopdep_uname.plsql >>${logfilename} 2>&1
echo "# cridx_cluster_xufdname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_cluster_xufdname.plsql >>${logfilename} 2>&1
echo "# cridx_cluster_xudescr.plsql" >>${logfilename}
${sqlpluscmd} <cridx_cluster_xudescr.plsql >>${logfilename} 2>&1
echo "# cridx_datascope_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_datascope_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_dtcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dtcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_dttyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dttyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_deldep_xrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_deldep_xrel.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep1_xcdeltopdep.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep1_xcdeltopdep.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep1_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep1_uname.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep2_xcdeldep1.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep2_xcdeldep1.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep2_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep2_uname.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep3_xcdeldep2.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep3_xcdeldep2.plsql >>${logfilename} 2>&1
echo "# cridx_delsubdep3_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_delsubdep3_uname.plsql >>${logfilename} 2>&1
echo "# cridx_deltop_xctbl.plsql" >>${logfilename}
${sqlpluscmd} <cridx_deltop_xctbl.plsql >>${logfilename} 2>&1
echo "# cridx_deltop_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_deltop_uname.plsql >>${logfilename} 2>&1
echo "# cridx_domdef_subdomidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_domdef_subdomidx.plsql >>${logfilename} 2>&1
echo "# cridx_domdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_domdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_bdomdef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_bdomdef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_dblcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dblcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_dbltyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dbltyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_enumcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_enumcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_enumtag_xtenant.plsql" >>${logfilename}
${sqlpluscmd} <cridx_enumtag_xtenant.plsql >>${logfilename} 2>&1
echo "# cridx_enumtag_xenum.plsql" >>${logfilename}
${sqlpluscmd} <cridx_enumtag_xenum.plsql >>${logfilename} 2>&1
echo "# cridx_enumtag_uenumnm.plsql" >>${logfilename}
${sqlpluscmd} <cridx_enumtag_uenumnm.plsql >>${logfilename} 2>&1
echo "# cridx_enumtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_enumtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_fltcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_fltcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_flttyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_flttyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_hostnode_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_hostnode_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_hostnode_xudsc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_hostnode_xudsc.plsql >>${logfilename} 2>&1
echo "# cridx_hostnode_xhnm.plsql" >>${logfilename}
${sqlpluscmd} <cridx_hostnode_xhnm.plsql >>${logfilename} 2>&1
echo "# cridx_isocountry_xcode.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountry_xcode.plsql >>${logfilename} 2>&1
echo "# cridx_isocountry_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountry_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_isocountryccy_xcountry.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountryccy_xcountry.plsql >>${logfilename} 2>&1
echo "# cridx_isocountryccy_xccy.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountryccy_xccy.plsql >>${logfilename} 2>&1
echo "# cridx_isocountrylang_xcountry.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountrylang_xcountry.plsql >>${logfilename} 2>&1
echo "# cridx_isocountrylang_xlang.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocountrylang_xlang.plsql >>${logfilename} 2>&1
echo "# cridx_isocurrency_xcode.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocurrency_xcode.plsql >>${logfilename} 2>&1
echo "# cridx_isocurrency_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isocurrency_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_isolang_xbase.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isolang_xbase.plsql >>${logfilename} 2>&1
echo "# cridx_isolang_xcode.plsql" >>${logfilename}
${sqlpluscmd} <cridx_isolang_xcode.plsql >>${logfilename} 2>&1
echo "# cridx_itz_xoffset.plsql" >>${logfilename}
${sqlpluscmd} <cridx_itz_xoffset.plsql >>${logfilename} 2>&1
echo "# cridx_itz_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_itz_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_itz_xiso.plsql" >>${logfilename}
${sqlpluscmd} <cridx_itz_xiso.plsql >>${logfilename} 2>&1
echo "# cridx_idxdef_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxdef_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_idxdef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxdef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_idxdef_tableidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxdef_tableidx.plsql >>${logfilename} 2>&1
echo "# cridx_idxcol_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxcol_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_idxcol_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxcol_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_idxcol_indexidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxcol_indexidx.plsql >>${logfilename} 2>&1
echo "# cridx_idxcol_col_def.plsql" >>${logfilename}
${sqlpluscmd} <cridx_idxcol_col_def.plsql >>${logfilename} 2>&1
echo "# cridx_int16col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int16col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_int16typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int16typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_int32col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int32col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_int32typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int32typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_int64col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int64col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_int64typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_int64typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_lic_xtenant.plsql" >>${logfilename}
${sqlpluscmd} <cridx_lic_xtenant.plsql >>${logfilename} 2>&1
echo "# cridx_lic_xdom.plsql" >>${logfilename}
${sqlpluscmd} <cridx_lic_xdom.plsql >>${logfilename} 2>&1
echo "# cridx_lic_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_lic_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_loadbehav_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_loadbehav_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_mjverdef_pprjidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_mjverdef_pprjidx.plsql >>${logfilename} 2>&1
echo "# cridx_mjverdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_mjverdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_mimetype_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_mimetype_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_mnverdef_majoridx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_mnverdef_majoridx.plsql >>${logfilename} 2>&1
echo "# cridx_mnverdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_mnverdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_nmtkncol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_nmtkncol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_nmtkntyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_nmtkntyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_nmtknscol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_nmtknscol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_nmtknstyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_nmtknstyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_numcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_numcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_numtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_numtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_srvprm_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_srvprm_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_srvprm_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_srvprm_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_srvprm_srvmethk.plsql" >>${logfilename}
${sqlpluscmd} <cridx_srvprm_srvmethk.plsql >>${logfilename} 2>&1
echo "# cridx_popdep_xrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popdep_xrel.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep1_xcpoptopdep.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep1_xcpoptopdep.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep1_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep1_uname.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep2_xcpopdep1.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep2_xcpopdep1.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep2_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep2_uname.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep3_xcpopdep2.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep3_xcpopdep2.plsql >>${logfilename} 2>&1
echo "# cridx_popsubdep3_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_popsubdep3_uname.plsql >>${logfilename} 2>&1
echo "# cridx_poptop_xcrel.plsql" >>${logfilename}
${sqlpluscmd} <cridx_poptop_xcrel.plsql >>${logfilename} 2>&1
echo "# cridx_poptop_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_poptop_uname.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_tableidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_tableidx.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_xrtypekey.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_xrtypekey.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_xfromkey.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_xfromkey.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_xtotbl.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_xtotbl.plsql >>${logfilename} 2>&1
echo "# cridx_reldef_xtokey.plsql" >>${logfilename}
${sqlpluscmd} <cridx_reldef_xtokey.plsql >>${logfilename} 2>&1
echo "# cridx_relcol_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_relcol_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_relcol_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_relcol_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_relcol_relk.plsql" >>${logfilename}
${sqlpluscmd} <cridx_relcol_relk.plsql >>${logfilename} 2>&1
echo "# cridx_relcol_fromk.plsql" >>${logfilename}
${sqlpluscmd} <cridx_relcol_fromk.plsql >>${logfilename} 2>&1
echo "# cridx_relcol_tok.plsql" >>${logfilename}
${sqlpluscmd} <cridx_relcol_tok.plsql >>${logfilename} 2>&1
echo "# cridx_rel_type_utagidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_rel_type_utagidx.plsql >>${logfilename} 2>&1
echo "# cridx_schemadef_ctenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemadef_ctenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_schemadef_domainidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemadef_domainidx.plsql >>${logfilename} 2>&1
echo "# cridx_schemadef_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemadef_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_schemadef_xupuburi.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemadef_xupuburi.plsql >>${logfilename} 2>&1
echo "# cridx_schemaref_schk.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemaref_schk.plsql >>${logfilename} 2>&1
echo "# cridx_schemaref_uname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_schemaref_uname.plsql >>${logfilename} 2>&1
echo "# cridx_scopedef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_scopedef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_secapp_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secapp_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secapp_xujeemnt.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secapp_xujeemnt.plsql >>${logfilename} 2>&1
echo "# cridx_secdev_usridx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secdev_usridx.plsql >>${logfilename} 2>&1
echo "# cridx_secform_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secform_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secform_xsecapp.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secform_xsecapp.plsql >>${logfilename} 2>&1
echo "# cridx_secform_xujeesvlt.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secform_xujeesvlt.plsql >>${logfilename} 2>&1
echo "# cridx_secgroup_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroup_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secgroup_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroup_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_secgroupform_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroupform_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secgroupform_xgroup.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroupform_xgroup.plsql >>${logfilename} 2>&1
echo "# cridx_secgroupform_xapp.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroupform_xapp.plsql >>${logfilename} 2>&1
echo "# cridx_secgroupform_xform.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroupform_xform.plsql >>${logfilename} 2>&1
echo "# cridx_secgroupform_xuform.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secgroupform_xuform.plsql >>${logfilename} 2>&1
echo "# cridx_secinclude_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secinclude_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secinclude_xgroup.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secinclude_xgroup.plsql >>${logfilename} 2>&1
echo "# cridx_secinclude_xinc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secinclude_xinc.plsql >>${logfilename} 2>&1
echo "# cridx_secinclude_xuinc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secinclude_xuinc.plsql >>${logfilename} 2>&1
echo "# cridx_secmember_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secmember_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_secmember_xgroup.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secmember_xgroup.plsql >>${logfilename} 2>&1
echo "# cridx_secmember_xuser.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secmember_xuser.plsql >>${logfilename} 2>&1
echo "# cridx_secmember_xuuser.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secmember_xuuser.plsql >>${logfilename} 2>&1
echo "# cridx_session_xsecuser.plsql" >>${logfilename}
${sqlpluscmd} <cridx_session_xsecuser.plsql >>${logfilename} 2>&1
echo "# cridx_session_xstart.plsql" >>${logfilename}
${sqlpluscmd} <cridx_session_xstart.plsql >>${logfilename} 2>&1
echo "# cridx_secuser_xulogin.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secuser_xulogin.plsql >>${logfilename} 2>&1
echo "# cridx_secscope_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_secscope_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_srvmeth_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_srvmeth_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_srvmeth_tableidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_srvmeth_tableidx.plsql >>${logfilename} 2>&1
echo "# cridx_service_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_service_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_service_xhost.plsql" >>${logfilename}
${sqlpluscmd} <cridx_service_xhost.plsql >>${logfilename} 2>&1
echo "# cridx_service_xtype.plsql" >>${logfilename}
${sqlpluscmd} <cridx_service_xtype.plsql >>${logfilename} 2>&1
echo "# cridx_service_xutype.plsql" >>${logfilename}
${sqlpluscmd} <cridx_service_xutype.plsql >>${logfilename} 2>&1
echo "# cridx_service_xuhpt.plsql" >>${logfilename}
${sqlpluscmd} <cridx_service_xuhpt.plsql >>${logfilename} 2>&1
echo "# cridx_servicetype_xudsc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_servicetype_xudsc.plsql >>${logfilename} 2>&1
echo "# cridx_strcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_strcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_strtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_strtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_sprjdef_pprjidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_sprjdef_pprjidx.plsql >>${logfilename} 2>&1
echo "# cridx_sprjdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_sprjdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_sysclus_xclus.plsql" >>${logfilename}
${sqlpluscmd} <cridx_sysclus_xclus.plsql >>${logfilename} 2>&1
echo "# cridx_tsecgroup_xtenant.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecgroup_xtenant.plsql >>${logfilename} 2>&1
echo "# cridx_tsecgroup_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecgroup_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_tsecinclude_xtenant.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecinclude_xtenant.plsql >>${logfilename} 2>&1
echo "# cridx_tsecinclude_xgroup.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecinclude_xgroup.plsql >>${logfilename} 2>&1
echo "# cridx_tsecinclude_xinc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecinclude_xinc.plsql >>${logfilename} 2>&1
echo "# cridx_tsecinclude_xuinc.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecinclude_xuinc.plsql >>${logfilename} 2>&1
echo "# cridx_tsecmember_xtenant.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecmember_xtenant.plsql >>${logfilename} 2>&1
echo "# cridx_tsecmember_xgroup.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecmember_xgroup.plsql >>${logfilename} 2>&1
echo "# cridx_tsecmember_xuser.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecmember_xuser.plsql >>${logfilename} 2>&1
echo "# cridx_tsecmember_xuuser.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tsecmember_xuuser.plsql >>${logfilename} 2>&1
echo "# cridx_dzcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dzcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_dztyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_dztyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tmzcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tmzcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_tmztyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tmztyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_zscol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_zscol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_zstyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_zstyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tbldef_schemaidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tbldef_schemaidx.plsql >>${logfilename} 2>&1
echo "# cridx_table_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_table_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_tabledef_xscd.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tabledef_xscd.plsql >>${logfilename} 2>&1
echo "# cridx_tabledef_xloadbehave.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tabledef_xloadbehave.plsql >>${logfilename} 2>&1
echo "# cridx_tabledef_xsecscope.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tabledef_xsecscope.plsql >>${logfilename} 2>&1
echo "# cridx_tblcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tblcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_tablecol_xdata.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tablecol_xdata.plsql >>${logfilename} 2>&1
echo "# cridx_tenant_xcluster.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tenant_xcluster.plsql >>${logfilename} 2>&1
echo "# cridx_tenant_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tenant_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_txtcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_txtcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_txttyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_txttyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tmcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tmcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_tmtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tmtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tscol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tscol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_tstyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tstyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tlddef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tlddef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_tlddef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tlddef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_tkncol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tkncol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_tkntyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tkntyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_tdomdef_tldidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tdomdef_tldidx.plsql >>${logfilename} 2>&1
echo "# cridx_tdomdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tdomdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_tprjdef_domidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tprjdef_domidx.plsql >>${logfilename} 2>&1
echo "# cridx_tprjdef_unameidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_tprjdef_unameidx.plsql >>${logfilename} 2>&1
echo "# cridx_uint16col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint16col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_uint16typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint16typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_uint32col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint32col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_uint32typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint32typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_uint64col_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint64col_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_uint64typ_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uint64typ_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_urlproto_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_urlproto_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_urlproto_xsecure.plsql" >>${logfilename}
${sqlpluscmd} <cridx_urlproto_xsecure.plsql >>${logfilename} 2>&1
echo "# cridx_uuidcol_xtable.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uuidcol_xtable.plsql >>${logfilename} 2>&1
echo "# cridx_uuidtyp_xschemadef.plsql" >>${logfilename}
${sqlpluscmd} <cridx_uuidtyp_xschemadef.plsql >>${logfilename} 2>&1
echo "# cridx_valdef_xuname.plsql" >>${logfilename}
${sqlpluscmd} <cridx_valdef_xuname.plsql >>${logfilename} 2>&1
echo "# cridx_valdef_tenantidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_valdef_tenantidx.plsql >>${logfilename} 2>&1
echo "# cridx_valdef_scopeidx.plsql" >>${logfilename}
${sqlpluscmd} <cridx_valdef_scopeidx.plsql >>${logfilename} 2>&1

