#!/bin/bash
#
#	@(#) dbcreate/cfbam/sybase/cridx_cfbam23_h.bash
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
#	logfilename=`date +'cridx_cfbam23_h-%Y%m%d_%Hh%M.log'`
	logfilename="cridx_cfbam23_h.log"
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

$cmdappdb <cridx_atomdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_atomdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_blbcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_blbdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_blbtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_boolcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_booldef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_booltyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_prevrelidx.isql >>$logfilename
$cmdappdb <cridx_chain_def_h_nextrelidx.isql >>$logfilename
$cmdappdb <cridx_clr_dep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_clr_dep_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_h_contcleartopidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep1_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_h_contcleardep1idx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep2_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_h_contcleardep2idx.isql >>$logfilename
$cmdappdb <cridx_clrsubdep3_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_clr_topdep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_clr_topdep_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_clr_topdep_h_conttblidx.isql >>$logfilename
$cmdappdb <cridx_clr_topdep_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_clus_h_udomainnameidx.isql >>$logfilename
$cmdappdb <cridx_clus_h_udescridx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dtcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dtdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dttyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_del_dep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_del_dep_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_del_dep_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_h_contdeltopidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep1_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_h_contdeldep1idx.isql >>$logfilename
$cmdappdb <cridx_delsubdep2_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_h_contdeldep2idx.isql >>$logfilename
$cmdappdb <cridx_delsubdep3_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_del_topdep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_del_topdep_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_del_topdep_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_del_topdep_h_conttblidx.isql >>$logfilename
$cmdappdb <cridx_del_topdep_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_domdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_domdef_h_subdomidx.isql >>$logfilename
$cmdappdb <cridx_domdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_bdomdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dblcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dbldef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dbltyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_enumcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_enumdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_enumtagtenantidx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_enumidx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_enumnameidx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_previdx.isql >>$logfilename
$cmdappdb <cridx_enum_tag_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_enumtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_fltcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_fltdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_flttyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_hostnode_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_hostnode_h_udescridx.isql >>$logfilename
$cmdappdb <cridx_hostnode_h_hostnameidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntry_h_isocodeidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntry_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntryccy_h_countryidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntryccy_h_currencyidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntrylng_h_countryidx.isql >>$logfilename
$cmdappdb <cridx_iso_cntrylng_h_languageidx.isql >>$logfilename
$cmdappdb <cridx_iso_ccy_h_ccycdidx.isql >>$logfilename
$cmdappdb <cridx_iso_ccy_h_ccynmidx.isql >>$logfilename
$cmdappdb <cridx_iso_lang_h_baseidx.isql >>$logfilename
$cmdappdb <cridx_iso_lang_h_countryidx.isql >>$logfilename
$cmdappdb <cridx_iso_lang_h_codeidx.isql >>$logfilename
$cmdappdb <cridx_isotz_h_offsetidx.isql >>$logfilename
$cmdappdb <cridx_isotz_h_utznameidx.isql >>$logfilename
$cmdappdb <cridx_isotz_h_iso8601idx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_previdx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_idg16_h_dispidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_previdx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_idg32_h_dispidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_previdx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_idg64_h_dispidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_h_indextenantidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_idxdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_idxcoltenantidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_indexidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_colidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_idxprevidx.isql >>$logfilename
$cmdappdb <cridx_idxcol_h_idxnextidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int16col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int16def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int16typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int32col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int32def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int32typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int64col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int64def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_int64typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_mjverdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_mjverdef_h_pprjidx.isql >>$logfilename
$cmdappdb <cridx_mjverdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_mimetype_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_mnverdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_mnverdef_h_majoridx.isql >>$logfilename
$cmdappdb <cridx_mnverdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkncol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtkndef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtkntyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknscol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtknsdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_nmtknstyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_numcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_numdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_numtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_servermethodidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_servertypeidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_previdx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_srvprm_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_pop_dep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_pop_dep_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_pop_dep_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_h_contpoptopidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep1_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_h_contpopdep1idx.isql >>$logfilename
$cmdappdb <cridx_popsubdep2_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_h_contpopdep2idx.isql >>$logfilename
$cmdappdb <cridx_popsubdep3_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_pop_topdep_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_pop_topdep_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_pop_topdep_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_pop_topdep_h_contrelidx.isql >>$logfilename
$cmdappdb <cridx_pop_topdep_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_bprjdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_rprjdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_relntenantidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_rtypekeyidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_fromkeyidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_totblidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_tokeyidx.isql >>$logfilename
$cmdappdb <cridx_reldef_h_narrowedidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_relcoltenantidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_relationidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_fromcolidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_tocolidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_relprevidx.isql >>$logfilename
$cmdappdb <cridx_relcol_h_relnextidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_ctenantidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_domainidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_deflcnidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_schemadef_h_puburiidx.isql >>$logfilename
$cmdappdb <cridx_schema_ref_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_schema_ref_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_schema_ref_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_schema_ref_h_refschemaidx.isql >>$logfilename
$cmdappdb <cridx_scopedef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_secapp_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secapp_h_ujeemountidx.isql >>$logfilename
$cmdappdb <cridx_secdev_h_useridx.isql >>$logfilename
$cmdappdb <cridx_secform_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secform_h_secappidx.isql >>$logfilename
$cmdappdb <cridx_secform_h_ujeeservletidx.isql >>$logfilename
$cmdappdb <cridx_secgrp_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secgrp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_secgrpfrm_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secgrpfrm_h_groupidx.isql >>$logfilename
$cmdappdb <cridx_secgrpfrm_h_appidx.isql >>$logfilename
$cmdappdb <cridx_secgrpfrm_h_formidx.isql >>$logfilename
$cmdappdb <cridx_secgrpfrm_h_uformidx.isql >>$logfilename
$cmdappdb <cridx_secinc_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secinc_h_groupidx.isql >>$logfilename
$cmdappdb <cridx_secinc_h_includeidx.isql >>$logfilename
$cmdappdb <cridx_secinc_h_uincludeidx.isql >>$logfilename
$cmdappdb <cridx_secmemb_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_secmemb_h_groupidx.isql >>$logfilename
$cmdappdb <cridx_secmemb_h_useridx.isql >>$logfilename
$cmdappdb <cridx_secmemb_h_uuseridx.isql >>$logfilename
$cmdappdb <cridx_secuser_h_uloginidx.isql >>$logfilename
$cmdappdb <cridx_secuser_h_emconfidx.isql >>$logfilename
$cmdappdb <cridx_secuser_h_pwdresetidx.isql >>$logfilename
$cmdappdb <cridx_secuser_h_defdevidx.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_srvlfunc_h_rettblidx.isql >>$logfilename
$cmdappdb <cridx_srvmeth_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_srvmeth_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_srvmeth_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_srvmeth_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_srvofunc_h_rettblidx.isql >>$logfilename
$cmdappdb <cridx_srvprc_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_srvprc_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_srvprc_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_srvprc_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_hostsvc_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_hostsvc_h_hostidx.isql >>$logfilename
$cmdappdb <cridx_hostsvc_h_typeidx.isql >>$logfilename
$cmdappdb <cridx_hostsvc_h_utypeidx.isql >>$logfilename
$cmdappdb <cridx_hostsvc_h_uhostportidx.isql >>$logfilename
$cmdappdb <cridx_svctype_h_udescridx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_strcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_strdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_strtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_sprjdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_sprjdef_h_parentidx.isql >>$logfilename
$cmdappdb <cridx_sprjdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_tsecgrp_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tsecgrp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tsecinc_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tsecinc_h_groupidx.isql >>$logfilename
$cmdappdb <cridx_tsecinc_h_includeidx.isql >>$logfilename
$cmdappdb <cridx_tsecinc_h_uincludeidx.isql >>$logfilename
$cmdappdb <cridx_tsecmemb_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tsecmemb_h_groupidx.isql >>$logfilename
$cmdappdb <cridx_tsecmemb_h_useridx.isql >>$logfilename
$cmdappdb <cridx_tsecmemb_h_uuseridx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dzcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dzdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_dztyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmzcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmzdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmztyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_zscol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_zsdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_zstyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_schemadefidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_schemacdidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_primaryindexidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_lookupindexidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_altindexidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_qualtableidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_loadbehaveidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_secscopeidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tbldef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_tblcol_h_dataidx.isql >>$logfilename
$cmdappdb <cridx_tenant_h_clusteridx.isql >>$logfilename
$cmdappdb <cridx_tenant_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_txtcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_txtdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_txttyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tmtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tscol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tsdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tstyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tlddef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tlddef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tkncol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tkndef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_tkntyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_tdomdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tdomdef_h_tldidx.isql >>$logfilename
$cmdappdb <cridx_tdomdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_tprjdef_h_tenantidx.isql >>$logfilename
$cmdappdb <cridx_tprjdef_h_domainidx.isql >>$logfilename
$cmdappdb <cridx_tprjdef_h_nameidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint16col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_u16def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint16typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint32col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_u32def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint32typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint64col_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_previdx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_u64def_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uint64typ_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_urlproto_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_urlproto_h_issecureidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uuidcol_h_tableidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uuiddef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_previdx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_idguuid_h_dispidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_previdx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_uuidtyp_h_schemaidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_unameidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_valtentidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_scopeidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_defschemaidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_datascopeidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_vaccsecidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_vaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_eaccsecidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_eaccfreqidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_previdx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_nextidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_contprevidx.isql >>$logfilename
$cmdappdb <cridx_valdef_h_contnextidx.isql >>$logfilename
$cmdappdb <cridx_verndef_h_tenantidx.isql >>$logfilename

