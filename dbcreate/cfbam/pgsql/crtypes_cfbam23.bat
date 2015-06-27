@ECHO off
REM
REM	@(#) dbcreate/cfbam/pgsql/crtypes_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2014-2015 Mark Sobkow
REM	
REM	This program is available as free software under the GNU GPL v3, under
REM	the Eclipse Public License 1.0, or under a commercial license from Mark
REM	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
REM	
REM	You should have received copies of the complete license text for
REM	GPLv3.txt and EPLv1_0.txt, containing the text
REM	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
REM	
REM	Under the terms of the GPL:
REM	
REM		This program is free software: you can redistribute it and/or modify
REM		it under the terms of the GNU General Public License as published by
REM		the Free Software Foundation, either version 3 of the License, or
REM		(at your option) any later version.
REM	  
REM		This program is distributed in the hope that it will be useful,
REM		but WITHOUT ANY WARRANTY; without even the implied warranty of
REM		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
REM		GNU General Public License for more details.
REM	  
REM		You should have received a copy of the GNU General Public License
REM		along with this program.  If not, see <http://www.gnu.org/licenses/>.
REM	
REM	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
REM	and licensed under the BSD 3-Clause license as written by xfree86.org:
REM	
REM	Redistribution and use in source and binary forms, with or without
REM	modification, are permitted provided that the following conditions are
REM	met:
REM	
REM	    (1) Redistributions of source code must retain the above copyright
REM	    notice, this list of conditions and the following disclaimer. 
REM	
REM	    (2) Redistributions in binary form must reproduce the above copyright
REM	    notice, this list of conditions and the following disclaimer in
REM	    the documentation and/or other materials provided with the
REM	    distribution.  
REM	    
REM	    (3)The name of the author may not be used to
REM	    endorse or promote products derived from this software without
REM	    specific prior written permission.
REM	
REM	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
REM	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
REM	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
REM	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
REM	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
REM	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
REM	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
REM	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
REM	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
REM	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
REM	POSSIBILITY OF SUCH DAMAGE.
REM	
REM
REM **********************************************************************
REM
REM	Code manufactured by MSS Code Factory
REM

REM
REM	Initialize locals
REM
SET pgdb=""
SET pghost=""
SET pgpwd=""
SET pgsrv=""
SET pguser=""
SET logfilename=crtypes_cfbam23.log
IF NOT "%1" == "" SET pghost=%1
IF NOT "%2" == "" SET pgdb=%2
IF NOT "%3" == "" SET pguser=%3
IF NOT "%4" == "" SET pgpwd=%4
IF NOT "%5" == "" SET logfilename=%5
SET TK_DUALCASE_IN_CASE_STATEMENTS=true

REM
REM	Validate parameters
REM

IF "%pguser%" == "" (
	ECHO "ERROR: User must be specified as argument 3'"
	PAUSE
	EXIT
)

IF "%pgpwd%" == "" (
	ECHO "ERROR: Password must be specified as argument 4'"
	PAUSE
	EXIT
)

IF "%pghost%" == "" (
	ECHO "ERROR: Server host name must be specified as argument 1'"
	PAUSE
	EXIT
)

IF "%pgdb%" == "" (
	ECHO "ERROR: Database name must be specified as argument 2'"
	PAUSE
	EXIT
)

SET PGPASSWORD=%pgpwd%

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_cfbam23_cc_rec.pgsql >>%logfilename% 2>&1
psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_accfreq_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_accsec_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_atomdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_auditaction_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_blbcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_blbdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_blbtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_boolcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_booldef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_booltyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_chain_def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clr_dep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clrsubdep1_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clrsubdep2_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clrsubdep3_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clr_topdep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_clus_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_datascope_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dtcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dtdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dttyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_del_dep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_delsubdep1_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_delsubdep2_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_delsubdep3_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_del_topdep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_domdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_bdomdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dblcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dbldef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dbltyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_enumcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_enumdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_enum_tag_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_enumtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_fltcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_fltdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_flttyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_hostnode_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_iso_cntry_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_iso_cntryccy_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_iso_cntrylng_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_iso_ccy_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_iso_lang_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_isotz_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idg16_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idg32_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idg64_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idxdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idxcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int16col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int16def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int16typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int32col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int32def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int32typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int64col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int64def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_int64typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_licn_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_loadbehav_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_mjverdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_mimetype_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_mnverdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtkncol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtkndef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtkntyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtknscol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtknsdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_nmtknstyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_numcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_numdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_numtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_srvprm_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_pop_dep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_popsubdep1_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_popsubdep2_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_popsubdep3_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_pop_topdep_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_bprjdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_rprjdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_reldef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_relcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_rel_type_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_schemadef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_schema_ref_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_scopedef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secapp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secdev_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secform_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secgrp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secgrpfrm_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secinc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secmemb_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secsess_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secuser_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_secscope_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_srvlfunc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_srvmeth_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_srvofunc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_srvprc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_hostsvc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_svctype_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_strcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_strdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_strtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_sprjdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_sysclus_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tsecgrp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tsecinc_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tsecmemb_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dzcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dzdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_dztyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmzcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmzdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmztyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_zscol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_zsdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_zstyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tbldef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tblcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tenant_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_txtcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_txtdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_txttyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tmtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tscol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tsdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tstyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tlddef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tkncol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tkndef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tkntyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tdomdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_tprjdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint16col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_u16def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint16typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint32col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_u32def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint32typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint64col_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_u64def_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uint64typ_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_urlproto_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uuidcol_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uuiddef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_idguuid_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_uuidtyp_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_valdef_rec.pgsql >>%logfilename% 2>&1

psql -h %pghost% -d %pgdb% -U %pguser% -a -e -f crtype_verndef_rec.pgsql >>%logfilename% 2>&1


