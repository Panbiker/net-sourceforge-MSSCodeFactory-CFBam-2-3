#!/bin/bash
#
#	@(#) dbcreate/cfbam/sybase/crrel_cfbam23.bash
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
#	logfilename=`date +'crrel_cfbam23-%Y%m%d_%Hh%M.log'`
	logfilename="crrel_cfbam23.log"
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

$cmdappdb <crrel_accfreq.isql >>$logfilename
$cmdappdb <crrel_accsec.isql >>$logfilename
$cmdappdb <crrel_atomdef.isql >>$logfilename
$cmdappdb <crrel_auditaction.isql >>$logfilename
$cmdappdb <crrel_blbcol.isql >>$logfilename
$cmdappdb <crrel_blbdef.isql >>$logfilename
$cmdappdb <crrel_blbtyp.isql >>$logfilename
$cmdappdb <crrel_boolcol.isql >>$logfilename
$cmdappdb <crrel_booldef.isql >>$logfilename
$cmdappdb <crrel_booltyp.isql >>$logfilename
$cmdappdb <crrel_chain_def.isql >>$logfilename
$cmdappdb <crrel_clr_dep.isql >>$logfilename
$cmdappdb <crrel_clrsubdep1.isql >>$logfilename
$cmdappdb <crrel_clrsubdep2.isql >>$logfilename
$cmdappdb <crrel_clrsubdep3.isql >>$logfilename
$cmdappdb <crrel_clr_topdep.isql >>$logfilename
$cmdappdb <crrel_clus.isql >>$logfilename
$cmdappdb <crrel_clus_idg32.isql >>$logfilename
$cmdappdb <crrel_clus_idg64.isql >>$logfilename
$cmdappdb <crrel_datascope.isql >>$logfilename
$cmdappdb <crrel_dtcol.isql >>$logfilename
$cmdappdb <crrel_dtdef.isql >>$logfilename
$cmdappdb <crrel_dttyp.isql >>$logfilename
$cmdappdb <crrel_del_dep.isql >>$logfilename
$cmdappdb <crrel_delsubdep1.isql >>$logfilename
$cmdappdb <crrel_delsubdep2.isql >>$logfilename
$cmdappdb <crrel_delsubdep3.isql >>$logfilename
$cmdappdb <crrel_del_topdep.isql >>$logfilename
$cmdappdb <crrel_domdef.isql >>$logfilename
$cmdappdb <crrel_bdomdef.isql >>$logfilename
$cmdappdb <crrel_dblcol.isql >>$logfilename
$cmdappdb <crrel_dbldef.isql >>$logfilename
$cmdappdb <crrel_dbltyp.isql >>$logfilename
$cmdappdb <crrel_enumcol.isql >>$logfilename
$cmdappdb <crrel_enumdef.isql >>$logfilename
$cmdappdb <crrel_enum_tag.isql >>$logfilename
$cmdappdb <crrel_enumtyp.isql >>$logfilename
$cmdappdb <crrel_fltcol.isql >>$logfilename
$cmdappdb <crrel_fltdef.isql >>$logfilename
$cmdappdb <crrel_flttyp.isql >>$logfilename
$cmdappdb <crrel_hostnode.isql >>$logfilename
$cmdappdb <crrel_iso_cntry.isql >>$logfilename
$cmdappdb <crrel_iso_cntryccy.isql >>$logfilename
$cmdappdb <crrel_iso_cntrylng.isql >>$logfilename
$cmdappdb <crrel_iso_ccy.isql >>$logfilename
$cmdappdb <crrel_iso_lang.isql >>$logfilename
$cmdappdb <crrel_isotz.isql >>$logfilename
$cmdappdb <crrel_idg16.isql >>$logfilename
$cmdappdb <crrel_idg32.isql >>$logfilename
$cmdappdb <crrel_idg64.isql >>$logfilename
$cmdappdb <crrel_idxdef.isql >>$logfilename
$cmdappdb <crrel_idxcol.isql >>$logfilename
$cmdappdb <crrel_int16col.isql >>$logfilename
$cmdappdb <crrel_int16def.isql >>$logfilename
$cmdappdb <crrel_int16typ.isql >>$logfilename
$cmdappdb <crrel_int32col.isql >>$logfilename
$cmdappdb <crrel_int32def.isql >>$logfilename
$cmdappdb <crrel_int32typ.isql >>$logfilename
$cmdappdb <crrel_int64col.isql >>$logfilename
$cmdappdb <crrel_int64def.isql >>$logfilename
$cmdappdb <crrel_int64typ.isql >>$logfilename
$cmdappdb <crrel_licn.isql >>$logfilename
$cmdappdb <crrel_loadbehav.isql >>$logfilename
$cmdappdb <crrel_mjverdef.isql >>$logfilename
$cmdappdb <crrel_mimetype.isql >>$logfilename
$cmdappdb <crrel_mnverdef.isql >>$logfilename
$cmdappdb <crrel_nmtkncol.isql >>$logfilename
$cmdappdb <crrel_nmtkndef.isql >>$logfilename
$cmdappdb <crrel_nmtkntyp.isql >>$logfilename
$cmdappdb <crrel_nmtknscol.isql >>$logfilename
$cmdappdb <crrel_nmtknsdef.isql >>$logfilename
$cmdappdb <crrel_nmtknstyp.isql >>$logfilename
$cmdappdb <crrel_numcol.isql >>$logfilename
$cmdappdb <crrel_numdef.isql >>$logfilename
$cmdappdb <crrel_numtyp.isql >>$logfilename
$cmdappdb <crrel_srvprm.isql >>$logfilename
$cmdappdb <crrel_pop_dep.isql >>$logfilename
$cmdappdb <crrel_popsubdep1.isql >>$logfilename
$cmdappdb <crrel_popsubdep2.isql >>$logfilename
$cmdappdb <crrel_popsubdep3.isql >>$logfilename
$cmdappdb <crrel_pop_topdep.isql >>$logfilename
$cmdappdb <crrel_bprjdef.isql >>$logfilename
$cmdappdb <crrel_rprjdef.isql >>$logfilename
$cmdappdb <crrel_reldef.isql >>$logfilename
$cmdappdb <crrel_relcol.isql >>$logfilename
$cmdappdb <crrel_rel_type.isql >>$logfilename
$cmdappdb <crrel_schemadef.isql >>$logfilename
$cmdappdb <crrel_schema_ref.isql >>$logfilename
$cmdappdb <crrel_scopedef.isql >>$logfilename
$cmdappdb <crrel_secapp.isql >>$logfilename
$cmdappdb <crrel_secdev.isql >>$logfilename
$cmdappdb <crrel_secform.isql >>$logfilename
$cmdappdb <crrel_secgrp.isql >>$logfilename
$cmdappdb <crrel_secgrpfrm.isql >>$logfilename
$cmdappdb <crrel_secinc.isql >>$logfilename
$cmdappdb <crrel_secmemb.isql >>$logfilename
$cmdappdb <crrel_secsess.isql >>$logfilename
$cmdappdb <crrel_secuser.isql >>$logfilename
$cmdappdb <crrel_secscope.isql >>$logfilename
$cmdappdb <crrel_srvlfunc.isql >>$logfilename
$cmdappdb <crrel_srvmeth.isql >>$logfilename
$cmdappdb <crrel_srvofunc.isql >>$logfilename
$cmdappdb <crrel_srvprc.isql >>$logfilename
$cmdappdb <crrel_hostsvc.isql >>$logfilename
$cmdappdb <crrel_svctype.isql >>$logfilename
$cmdappdb <crrel_strcol.isql >>$logfilename
$cmdappdb <crrel_strdef.isql >>$logfilename
$cmdappdb <crrel_strtyp.isql >>$logfilename
$cmdappdb <crrel_sprjdef.isql >>$logfilename
$cmdappdb <crrel_sysclus.isql >>$logfilename
$cmdappdb <crrel_tsecgrp.isql >>$logfilename
$cmdappdb <crrel_tsecinc.isql >>$logfilename
$cmdappdb <crrel_tsecmemb.isql >>$logfilename
$cmdappdb <crrel_dzcol.isql >>$logfilename
$cmdappdb <crrel_dzdef.isql >>$logfilename
$cmdappdb <crrel_dztyp.isql >>$logfilename
$cmdappdb <crrel_tmzcol.isql >>$logfilename
$cmdappdb <crrel_tmzdef.isql >>$logfilename
$cmdappdb <crrel_tmztyp.isql >>$logfilename
$cmdappdb <crrel_zscol.isql >>$logfilename
$cmdappdb <crrel_zsdef.isql >>$logfilename
$cmdappdb <crrel_zstyp.isql >>$logfilename
$cmdappdb <crrel_tbldef.isql >>$logfilename
$cmdappdb <crrel_tblcol.isql >>$logfilename
$cmdappdb <crrel_tenant.isql >>$logfilename
$cmdappdb <crrel_tenant_idg32.isql >>$logfilename
$cmdappdb <crrel_tenant_idg64.isql >>$logfilename
$cmdappdb <crrel_txtcol.isql >>$logfilename
$cmdappdb <crrel_txtdef.isql >>$logfilename
$cmdappdb <crrel_txttyp.isql >>$logfilename
$cmdappdb <crrel_tmcol.isql >>$logfilename
$cmdappdb <crrel_tmdef.isql >>$logfilename
$cmdappdb <crrel_tmtyp.isql >>$logfilename
$cmdappdb <crrel_tscol.isql >>$logfilename
$cmdappdb <crrel_tsdef.isql >>$logfilename
$cmdappdb <crrel_tstyp.isql >>$logfilename
$cmdappdb <crrel_tlddef.isql >>$logfilename
$cmdappdb <crrel_tkncol.isql >>$logfilename
$cmdappdb <crrel_tkndef.isql >>$logfilename
$cmdappdb <crrel_tkntyp.isql >>$logfilename
$cmdappdb <crrel_tdomdef.isql >>$logfilename
$cmdappdb <crrel_tprjdef.isql >>$logfilename
$cmdappdb <crrel_uint16col.isql >>$logfilename
$cmdappdb <crrel_u16def.isql >>$logfilename
$cmdappdb <crrel_uint16typ.isql >>$logfilename
$cmdappdb <crrel_uint32col.isql >>$logfilename
$cmdappdb <crrel_u32def.isql >>$logfilename
$cmdappdb <crrel_uint32typ.isql >>$logfilename
$cmdappdb <crrel_uint64col.isql >>$logfilename
$cmdappdb <crrel_u64def.isql >>$logfilename
$cmdappdb <crrel_uint64typ.isql >>$logfilename
$cmdappdb <crrel_urlproto.isql >>$logfilename
$cmdappdb <crrel_uuidcol.isql >>$logfilename
$cmdappdb <crrel_uuiddef.isql >>$logfilename
$cmdappdb <crrel_idguuid.isql >>$logfilename
$cmdappdb <crrel_uuidtyp.isql >>$logfilename
$cmdappdb <crrel_valdef.isql >>$logfilename
$cmdappdb <crrel_verndef.isql >>$logfilename

