@ECHO OFF
REM
REM	@(#) dbcreate/cfbam/sybase/crtbl_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2013 Mark Sobkow
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
@ECHO OFF
REM
REM	Initialize locals
REM
SET sybsrv=""
SET sybdb=""
SET sybuser=""
SET sybpwd=""
SET logfilename=crtbl_cfbam23.log
IF NOT "%1" == "" SET sybsrv=%1
IF NOT "%2" == "" SET sybdb=%2
IF NOT "%3" == "" SET sybuser=%3
IF NOT "%4" == "" SET sybpwd=%4
IF NOT "%5" == "" SET logfilename=%5

IF "%sybsrv%" == "" (
	ECHO "ERROR: Sybase server must be specified as 1st argument"
	PAUSE
	EXIT
)

IF "%sybdb%" == "" (
	ECHO "ERROR: Database must be specified as 2nd argument"
	PAUSE
	EXIT
)

IF "%sybuser%" == "" (
	ECHO "ERROR: User must be specified as 3rd argument"
	PAUSE
	EXIT
)

IF "%sybpwd%" == "" (
	ECHO "ERROR: Password must be specified as 4th argument"
	PAUSE
	EXIT
)

REM
REM	Define commands to use for running scripts
REM
SET cmdappdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D %sybdb% -e 
SET cmdmasterdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D master -e 
SET cmdmodeldb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D model -e 
SET cmdtempdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D tempdb -e 

%cmdappdb% <crtbl_cfbam23_idg32.isql >>%logfilename%
%cmdappdb% <crtbl_cfbam23_idg64.isql >>%logfilename%
%cmdappdb% <crtbl_clus.isql >>%logfilename%
%cmdappdb% <crtbl_clus_idg32.isql >>%logfilename%
%cmdappdb% <crtbl_clus_idg64.isql >>%logfilename%
%cmdappdb% <crtbl_secapp.isql >>%logfilename%
%cmdappdb% <crtbl_secform.isql >>%logfilename%
%cmdappdb% <crtbl_secgrp.isql >>%logfilename%
%cmdappdb% <crtbl_secgrpfrm.isql >>%logfilename%
%cmdappdb% <crtbl_secinc.isql >>%logfilename%
%cmdappdb% <crtbl_secmemb.isql >>%logfilename%
%cmdappdb% <crtbl_secsess.isql >>%logfilename%
%cmdappdb% <crtbl_secuser.isql >>%logfilename%
%cmdappdb% <crtbl_tenant.isql >>%logfilename%
%cmdappdb% <crtbl_tenant_idg32.isql >>%logfilename%
%cmdappdb% <crtbl_tenant_idg64.isql >>%logfilename%
%cmdappdb% <crtbl_accfreq.isql >>%logfilename%
%cmdappdb% <crtbl_accsec.isql >>%logfilename%
%cmdappdb% <crtbl_atomdef.isql >>%logfilename%
%cmdappdb% <crtbl_auditaction.isql >>%logfilename%
%cmdappdb% <crtbl_blbcol.isql >>%logfilename%
%cmdappdb% <crtbl_blbdef.isql >>%logfilename%
%cmdappdb% <crtbl_blbtyp.isql >>%logfilename%
%cmdappdb% <crtbl_boolcol.isql >>%logfilename%
%cmdappdb% <crtbl_booldef.isql >>%logfilename%
%cmdappdb% <crtbl_booltyp.isql >>%logfilename%
%cmdappdb% <crtbl_chain_def.isql >>%logfilename%
%cmdappdb% <crtbl_clr_dep.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep1.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep2.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep3.isql >>%logfilename%
%cmdappdb% <crtbl_clr_topdep.isql >>%logfilename%
%cmdappdb% <crtbl_datascope.isql >>%logfilename%
%cmdappdb% <crtbl_dtcol.isql >>%logfilename%
%cmdappdb% <crtbl_dtdef.isql >>%logfilename%
%cmdappdb% <crtbl_dttyp.isql >>%logfilename%
%cmdappdb% <crtbl_del_dep.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep1.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep2.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep3.isql >>%logfilename%
%cmdappdb% <crtbl_del_topdep.isql >>%logfilename%
%cmdappdb% <crtbl_domdef.isql >>%logfilename%
%cmdappdb% <crtbl_bdomdef.isql >>%logfilename%
%cmdappdb% <crtbl_dblcol.isql >>%logfilename%
%cmdappdb% <crtbl_dbldef.isql >>%logfilename%
%cmdappdb% <crtbl_dbltyp.isql >>%logfilename%
%cmdappdb% <crtbl_enumcol.isql >>%logfilename%
%cmdappdb% <crtbl_enumdef.isql >>%logfilename%
%cmdappdb% <crtbl_enum_tag.isql >>%logfilename%
%cmdappdb% <crtbl_enumtyp.isql >>%logfilename%
%cmdappdb% <crtbl_fltcol.isql >>%logfilename%
%cmdappdb% <crtbl_fltdef.isql >>%logfilename%
%cmdappdb% <crtbl_flttyp.isql >>%logfilename%
%cmdappdb% <crtbl_hostnode.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntry.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntryccy.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntrylng.isql >>%logfilename%
%cmdappdb% <crtbl_iso_ccy.isql >>%logfilename%
%cmdappdb% <crtbl_iso_lang.isql >>%logfilename%
%cmdappdb% <crtbl_isotz.isql >>%logfilename%
%cmdappdb% <crtbl_idg16.isql >>%logfilename%
%cmdappdb% <crtbl_idg32.isql >>%logfilename%
%cmdappdb% <crtbl_idg64.isql >>%logfilename%
%cmdappdb% <crtbl_idxdef.isql >>%logfilename%
%cmdappdb% <crtbl_idxcol.isql >>%logfilename%
%cmdappdb% <crtbl_int16col.isql >>%logfilename%
%cmdappdb% <crtbl_int16def.isql >>%logfilename%
%cmdappdb% <crtbl_int16typ.isql >>%logfilename%
%cmdappdb% <crtbl_int32col.isql >>%logfilename%
%cmdappdb% <crtbl_int32def.isql >>%logfilename%
%cmdappdb% <crtbl_int32typ.isql >>%logfilename%
%cmdappdb% <crtbl_int64col.isql >>%logfilename%
%cmdappdb% <crtbl_int64def.isql >>%logfilename%
%cmdappdb% <crtbl_int64typ.isql >>%logfilename%
%cmdappdb% <crtbl_licn.isql >>%logfilename%
%cmdappdb% <crtbl_loadbehav.isql >>%logfilename%
%cmdappdb% <crtbl_mjverdef.isql >>%logfilename%
%cmdappdb% <crtbl_mimetype.isql >>%logfilename%
%cmdappdb% <crtbl_mnverdef.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkncol.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkndef.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkntyp.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknscol.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknsdef.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknstyp.isql >>%logfilename%
%cmdappdb% <crtbl_numcol.isql >>%logfilename%
%cmdappdb% <crtbl_numdef.isql >>%logfilename%
%cmdappdb% <crtbl_numtyp.isql >>%logfilename%
%cmdappdb% <crtbl_srvprm.isql >>%logfilename%
%cmdappdb% <crtbl_pop_dep.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep1.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep2.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep3.isql >>%logfilename%
%cmdappdb% <crtbl_pop_topdep.isql >>%logfilename%
%cmdappdb% <crtbl_bprjdef.isql >>%logfilename%
%cmdappdb% <crtbl_rprjdef.isql >>%logfilename%
%cmdappdb% <crtbl_reldef.isql >>%logfilename%
%cmdappdb% <crtbl_relcol.isql >>%logfilename%
%cmdappdb% <crtbl_rel_type.isql >>%logfilename%
%cmdappdb% <crtbl_schemadef.isql >>%logfilename%
%cmdappdb% <crtbl_schema_ref.isql >>%logfilename%
%cmdappdb% <crtbl_scopedef.isql >>%logfilename%
%cmdappdb% <crtbl_secdev.isql >>%logfilename%
%cmdappdb% <crtbl_secscope.isql >>%logfilename%
%cmdappdb% <crtbl_srvlfunc.isql >>%logfilename%
%cmdappdb% <crtbl_srvmeth.isql >>%logfilename%
%cmdappdb% <crtbl_srvofunc.isql >>%logfilename%
%cmdappdb% <crtbl_srvprc.isql >>%logfilename%
%cmdappdb% <crtbl_hostsvc.isql >>%logfilename%
%cmdappdb% <crtbl_svctype.isql >>%logfilename%
%cmdappdb% <crtbl_strcol.isql >>%logfilename%
%cmdappdb% <crtbl_strdef.isql >>%logfilename%
%cmdappdb% <crtbl_strtyp.isql >>%logfilename%
%cmdappdb% <crtbl_sprjdef.isql >>%logfilename%
%cmdappdb% <crtbl_sysclus.isql >>%logfilename%
%cmdappdb% <crtbl_tsecgrp.isql >>%logfilename%
%cmdappdb% <crtbl_tsecinc.isql >>%logfilename%
%cmdappdb% <crtbl_tsecmemb.isql >>%logfilename%
%cmdappdb% <crtbl_dzcol.isql >>%logfilename%
%cmdappdb% <crtbl_dzdef.isql >>%logfilename%
%cmdappdb% <crtbl_dztyp.isql >>%logfilename%
%cmdappdb% <crtbl_tmzcol.isql >>%logfilename%
%cmdappdb% <crtbl_tmzdef.isql >>%logfilename%
%cmdappdb% <crtbl_tmztyp.isql >>%logfilename%
%cmdappdb% <crtbl_zscol.isql >>%logfilename%
%cmdappdb% <crtbl_zsdef.isql >>%logfilename%
%cmdappdb% <crtbl_zstyp.isql >>%logfilename%
%cmdappdb% <crtbl_tbldef.isql >>%logfilename%
%cmdappdb% <crtbl_tblcol.isql >>%logfilename%
%cmdappdb% <crtbl_txtcol.isql >>%logfilename%
%cmdappdb% <crtbl_txtdef.isql >>%logfilename%
%cmdappdb% <crtbl_txttyp.isql >>%logfilename%
%cmdappdb% <crtbl_tmcol.isql >>%logfilename%
%cmdappdb% <crtbl_tmdef.isql >>%logfilename%
%cmdappdb% <crtbl_tmtyp.isql >>%logfilename%
%cmdappdb% <crtbl_tscol.isql >>%logfilename%
%cmdappdb% <crtbl_tsdef.isql >>%logfilename%
%cmdappdb% <crtbl_tstyp.isql >>%logfilename%
%cmdappdb% <crtbl_tlddef.isql >>%logfilename%
%cmdappdb% <crtbl_tkncol.isql >>%logfilename%
%cmdappdb% <crtbl_tkndef.isql >>%logfilename%
%cmdappdb% <crtbl_tkntyp.isql >>%logfilename%
%cmdappdb% <crtbl_tdomdef.isql >>%logfilename%
%cmdappdb% <crtbl_tprjdef.isql >>%logfilename%
%cmdappdb% <crtbl_uint16col.isql >>%logfilename%
%cmdappdb% <crtbl_u16def.isql >>%logfilename%
%cmdappdb% <crtbl_uint16typ.isql >>%logfilename%
%cmdappdb% <crtbl_uint32col.isql >>%logfilename%
%cmdappdb% <crtbl_u32def.isql >>%logfilename%
%cmdappdb% <crtbl_uint32typ.isql >>%logfilename%
%cmdappdb% <crtbl_uint64col.isql >>%logfilename%
%cmdappdb% <crtbl_u64def.isql >>%logfilename%
%cmdappdb% <crtbl_uint64typ.isql >>%logfilename%
%cmdappdb% <crtbl_urlproto.isql >>%logfilename%
%cmdappdb% <crtbl_uuidcol.isql >>%logfilename%
%cmdappdb% <crtbl_uuiddef.isql >>%logfilename%
%cmdappdb% <crtbl_idguuid.isql >>%logfilename%
%cmdappdb% <crtbl_uuidtyp.isql >>%logfilename%
%cmdappdb% <crtbl_valdef.isql >>%logfilename%
%cmdappdb% <crtbl_verndef.isql >>%logfilename%
%cmdappdb% <crtbl_atomdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_blbcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_blbdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_blbtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_boolcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_booldef_h.isql >>%logfilename%
%cmdappdb% <crtbl_booltyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_chain_def_h.isql >>%logfilename%
%cmdappdb% <crtbl_clr_dep_h.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep1_h.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep2_h.isql >>%logfilename%
%cmdappdb% <crtbl_clrsubdep3_h.isql >>%logfilename%
%cmdappdb% <crtbl_clr_topdep_h.isql >>%logfilename%
%cmdappdb% <crtbl_clus_h.isql >>%logfilename%
%cmdappdb% <crtbl_dtcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_dtdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_dttyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_del_dep_h.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep1_h.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep2_h.isql >>%logfilename%
%cmdappdb% <crtbl_delsubdep3_h.isql >>%logfilename%
%cmdappdb% <crtbl_del_topdep_h.isql >>%logfilename%
%cmdappdb% <crtbl_domdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_bdomdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_dblcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_dbldef_h.isql >>%logfilename%
%cmdappdb% <crtbl_dbltyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_enumcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_enumdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_enum_tag_h.isql >>%logfilename%
%cmdappdb% <crtbl_enumtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_fltcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_fltdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_flttyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_hostnode_h.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntry_h.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntryccy_h.isql >>%logfilename%
%cmdappdb% <crtbl_iso_cntrylng_h.isql >>%logfilename%
%cmdappdb% <crtbl_iso_ccy_h.isql >>%logfilename%
%cmdappdb% <crtbl_iso_lang_h.isql >>%logfilename%
%cmdappdb% <crtbl_isotz_h.isql >>%logfilename%
%cmdappdb% <crtbl_idg16_h.isql >>%logfilename%
%cmdappdb% <crtbl_idg32_h.isql >>%logfilename%
%cmdappdb% <crtbl_idg64_h.isql >>%logfilename%
%cmdappdb% <crtbl_idxdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_idxcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_int16col_h.isql >>%logfilename%
%cmdappdb% <crtbl_int16def_h.isql >>%logfilename%
%cmdappdb% <crtbl_int16typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_int32col_h.isql >>%logfilename%
%cmdappdb% <crtbl_int32def_h.isql >>%logfilename%
%cmdappdb% <crtbl_int32typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_int64col_h.isql >>%logfilename%
%cmdappdb% <crtbl_int64def_h.isql >>%logfilename%
%cmdappdb% <crtbl_int64typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_mjverdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_mimetype_h.isql >>%logfilename%
%cmdappdb% <crtbl_mnverdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkncol_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkndef_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtkntyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknscol_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknsdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_nmtknstyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_numcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_numdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_numtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_srvprm_h.isql >>%logfilename%
%cmdappdb% <crtbl_pop_dep_h.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep1_h.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep2_h.isql >>%logfilename%
%cmdappdb% <crtbl_popsubdep3_h.isql >>%logfilename%
%cmdappdb% <crtbl_pop_topdep_h.isql >>%logfilename%
%cmdappdb% <crtbl_bprjdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_rprjdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_reldef_h.isql >>%logfilename%
%cmdappdb% <crtbl_relcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_schemadef_h.isql >>%logfilename%
%cmdappdb% <crtbl_schema_ref_h.isql >>%logfilename%
%cmdappdb% <crtbl_scopedef_h.isql >>%logfilename%
%cmdappdb% <crtbl_secapp_h.isql >>%logfilename%
%cmdappdb% <crtbl_secdev_h.isql >>%logfilename%
%cmdappdb% <crtbl_secform_h.isql >>%logfilename%
%cmdappdb% <crtbl_secgrp_h.isql >>%logfilename%
%cmdappdb% <crtbl_secgrpfrm_h.isql >>%logfilename%
%cmdappdb% <crtbl_secinc_h.isql >>%logfilename%
%cmdappdb% <crtbl_secmemb_h.isql >>%logfilename%
%cmdappdb% <crtbl_secuser_h.isql >>%logfilename%
%cmdappdb% <crtbl_srvlfunc_h.isql >>%logfilename%
%cmdappdb% <crtbl_srvmeth_h.isql >>%logfilename%
%cmdappdb% <crtbl_srvofunc_h.isql >>%logfilename%
%cmdappdb% <crtbl_srvprc_h.isql >>%logfilename%
%cmdappdb% <crtbl_hostsvc_h.isql >>%logfilename%
%cmdappdb% <crtbl_svctype_h.isql >>%logfilename%
%cmdappdb% <crtbl_strcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_strdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_strtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_sprjdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tsecgrp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tsecinc_h.isql >>%logfilename%
%cmdappdb% <crtbl_tsecmemb_h.isql >>%logfilename%
%cmdappdb% <crtbl_dzcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_dzdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_dztyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmzcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmzdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmztyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_zscol_h.isql >>%logfilename%
%cmdappdb% <crtbl_zsdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_zstyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tbldef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tblcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_tenant_h.isql >>%logfilename%
%cmdappdb% <crtbl_txtcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_txtdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_txttyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tmtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tscol_h.isql >>%logfilename%
%cmdappdb% <crtbl_tsdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tstyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tlddef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tkncol_h.isql >>%logfilename%
%cmdappdb% <crtbl_tkndef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tkntyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_tdomdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_tprjdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint16col_h.isql >>%logfilename%
%cmdappdb% <crtbl_u16def_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint16typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint32col_h.isql >>%logfilename%
%cmdappdb% <crtbl_u32def_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint32typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint64col_h.isql >>%logfilename%
%cmdappdb% <crtbl_u64def_h.isql >>%logfilename%
%cmdappdb% <crtbl_uint64typ_h.isql >>%logfilename%
%cmdappdb% <crtbl_urlproto_h.isql >>%logfilename%
%cmdappdb% <crtbl_uuidcol_h.isql >>%logfilename%
%cmdappdb% <crtbl_uuiddef_h.isql >>%logfilename%
%cmdappdb% <crtbl_idguuid_h.isql >>%logfilename%
%cmdappdb% <crtbl_uuidtyp_h.isql >>%logfilename%
%cmdappdb% <crtbl_valdef_h.isql >>%logfilename%
%cmdappdb% <crtbl_verndef_h.isql >>%logfilename%

