@ECHO OFF
REM	@(#) dbcreate/cfbam/mssql/crtbl_cfbam23.bat
REM 
REM 	CFBam
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

REM	Initialize locals
SET mssqlpwd=""
SET mssqlsrv=""
SET mssqluser=""
SET logfilename=crtbl_cfbam23.log

IF NOT "%1" == "" SET mssqlsrv=%1
IF NOT "%2" == "" SET mssqluser=%2
IF NOT "%3" == "" SET mssqlpwd=%3
IF NOT "%4" == "" SET logfilename=%4

IF "%mssqluser%" == "" (
	ECHO "ERROR: User must be specified as second argument"
	PAUSE
	EXIT
)

IF "%mssqlpwd%" == "" (
	ECHO "ERROR: Password must be specified as third argument"
	PAUSE
	EXIT
)

IF "%mssqlsrv%" == "" (
	ECHO "ERROR: Server must be specified as first argument"
	PAUSE
	EXIT
)

SET cmddb=sqlcmd -S %mssqlsrv% -U %mssqluser% -P %mssqlpwd% -e

%cmddb% <crtbl_cfbam23_idg32.tsql >>%logfilename%
%cmddb% <crtbl_cfbam23_idg64.tsql >>%logfilename%
%cmddb% <crtbl_clus.tsql >>%logfilename%
%cmddb% <crtbl_clus_idg32.tsql >>%logfilename%
%cmddb% <crtbl_clus_idg64.tsql >>%logfilename%
%cmddb% <crtbl_secapp.tsql >>%logfilename%
%cmddb% <crtbl_secform.tsql >>%logfilename%
%cmddb% <crtbl_secgrp.tsql >>%logfilename%
%cmddb% <crtbl_secgrpfrm.tsql >>%logfilename%
%cmddb% <crtbl_secinc.tsql >>%logfilename%
%cmddb% <crtbl_secmemb.tsql >>%logfilename%
%cmddb% <crtbl_secsess.tsql >>%logfilename%
%cmddb% <crtbl_secuser.tsql >>%logfilename%
%cmddb% <crtbl_tenant.tsql >>%logfilename%
%cmddb% <crtbl_tenant_idg32.tsql >>%logfilename%
%cmddb% <crtbl_tenant_idg64.tsql >>%logfilename%
%cmddb% <crtbl_accfreq.tsql >>%logfilename%
%cmddb% <crtbl_accsec.tsql >>%logfilename%
%cmddb% <crtbl_atomdef.tsql >>%logfilename%
%cmddb% <crtbl_auditaction.tsql >>%logfilename%
%cmddb% <crtbl_blbcol.tsql >>%logfilename%
%cmddb% <crtbl_blbdef.tsql >>%logfilename%
%cmddb% <crtbl_blbtyp.tsql >>%logfilename%
%cmddb% <crtbl_boolcol.tsql >>%logfilename%
%cmddb% <crtbl_booldef.tsql >>%logfilename%
%cmddb% <crtbl_booltyp.tsql >>%logfilename%
%cmddb% <crtbl_chain_def.tsql >>%logfilename%
%cmddb% <crtbl_clr_dep.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep1.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep2.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep3.tsql >>%logfilename%
%cmddb% <crtbl_clr_topdep.tsql >>%logfilename%
%cmddb% <crtbl_datascope.tsql >>%logfilename%
%cmddb% <crtbl_dtcol.tsql >>%logfilename%
%cmddb% <crtbl_dtdef.tsql >>%logfilename%
%cmddb% <crtbl_dttyp.tsql >>%logfilename%
%cmddb% <crtbl_del_dep.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep1.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep2.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep3.tsql >>%logfilename%
%cmddb% <crtbl_del_topdep.tsql >>%logfilename%
%cmddb% <crtbl_domdef.tsql >>%logfilename%
%cmddb% <crtbl_bdomdef.tsql >>%logfilename%
%cmddb% <crtbl_dblcol.tsql >>%logfilename%
%cmddb% <crtbl_dbldef.tsql >>%logfilename%
%cmddb% <crtbl_dbltyp.tsql >>%logfilename%
%cmddb% <crtbl_enumcol.tsql >>%logfilename%
%cmddb% <crtbl_enumdef.tsql >>%logfilename%
%cmddb% <crtbl_enum_tag.tsql >>%logfilename%
%cmddb% <crtbl_enumtyp.tsql >>%logfilename%
%cmddb% <crtbl_fltcol.tsql >>%logfilename%
%cmddb% <crtbl_fltdef.tsql >>%logfilename%
%cmddb% <crtbl_flttyp.tsql >>%logfilename%
%cmddb% <crtbl_hostnode.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntry.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crtbl_iso_ccy.tsql >>%logfilename%
%cmddb% <crtbl_iso_lang.tsql >>%logfilename%
%cmddb% <crtbl_isotz.tsql >>%logfilename%
%cmddb% <crtbl_idg16.tsql >>%logfilename%
%cmddb% <crtbl_idg32.tsql >>%logfilename%
%cmddb% <crtbl_idg64.tsql >>%logfilename%
%cmddb% <crtbl_idxdef.tsql >>%logfilename%
%cmddb% <crtbl_idxcol.tsql >>%logfilename%
%cmddb% <crtbl_int16col.tsql >>%logfilename%
%cmddb% <crtbl_int16def.tsql >>%logfilename%
%cmddb% <crtbl_int16typ.tsql >>%logfilename%
%cmddb% <crtbl_int32col.tsql >>%logfilename%
%cmddb% <crtbl_int32def.tsql >>%logfilename%
%cmddb% <crtbl_int32typ.tsql >>%logfilename%
%cmddb% <crtbl_int64col.tsql >>%logfilename%
%cmddb% <crtbl_int64def.tsql >>%logfilename%
%cmddb% <crtbl_int64typ.tsql >>%logfilename%
%cmddb% <crtbl_licn.tsql >>%logfilename%
%cmddb% <crtbl_loadbehav.tsql >>%logfilename%
%cmddb% <crtbl_mjverdef.tsql >>%logfilename%
%cmddb% <crtbl_mimetype.tsql >>%logfilename%
%cmddb% <crtbl_mnverdef.tsql >>%logfilename%
%cmddb% <crtbl_nmtkncol.tsql >>%logfilename%
%cmddb% <crtbl_nmtkndef.tsql >>%logfilename%
%cmddb% <crtbl_nmtkntyp.tsql >>%logfilename%
%cmddb% <crtbl_nmtknscol.tsql >>%logfilename%
%cmddb% <crtbl_nmtknsdef.tsql >>%logfilename%
%cmddb% <crtbl_nmtknstyp.tsql >>%logfilename%
%cmddb% <crtbl_numcol.tsql >>%logfilename%
%cmddb% <crtbl_numdef.tsql >>%logfilename%
%cmddb% <crtbl_numtyp.tsql >>%logfilename%
%cmddb% <crtbl_srvprm.tsql >>%logfilename%
%cmddb% <crtbl_pop_dep.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep1.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep2.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep3.tsql >>%logfilename%
%cmddb% <crtbl_pop_topdep.tsql >>%logfilename%
%cmddb% <crtbl_bprjdef.tsql >>%logfilename%
%cmddb% <crtbl_rprjdef.tsql >>%logfilename%
%cmddb% <crtbl_reldef.tsql >>%logfilename%
%cmddb% <crtbl_relcol.tsql >>%logfilename%
%cmddb% <crtbl_rel_type.tsql >>%logfilename%
%cmddb% <crtbl_schemadef.tsql >>%logfilename%
%cmddb% <crtbl_schema_ref.tsql >>%logfilename%
%cmddb% <crtbl_scopedef.tsql >>%logfilename%
%cmddb% <crtbl_secdev.tsql >>%logfilename%
%cmddb% <crtbl_secscope.tsql >>%logfilename%
%cmddb% <crtbl_srvlfunc.tsql >>%logfilename%
%cmddb% <crtbl_srvmeth.tsql >>%logfilename%
%cmddb% <crtbl_srvofunc.tsql >>%logfilename%
%cmddb% <crtbl_srvprc.tsql >>%logfilename%
%cmddb% <crtbl_hostsvc.tsql >>%logfilename%
%cmddb% <crtbl_svctype.tsql >>%logfilename%
%cmddb% <crtbl_strcol.tsql >>%logfilename%
%cmddb% <crtbl_strdef.tsql >>%logfilename%
%cmddb% <crtbl_strtyp.tsql >>%logfilename%
%cmddb% <crtbl_sprjdef.tsql >>%logfilename%
%cmddb% <crtbl_sysclus.tsql >>%logfilename%
%cmddb% <crtbl_tsecgrp.tsql >>%logfilename%
%cmddb% <crtbl_tsecinc.tsql >>%logfilename%
%cmddb% <crtbl_tsecmemb.tsql >>%logfilename%
%cmddb% <crtbl_dzcol.tsql >>%logfilename%
%cmddb% <crtbl_dzdef.tsql >>%logfilename%
%cmddb% <crtbl_dztyp.tsql >>%logfilename%
%cmddb% <crtbl_tmzcol.tsql >>%logfilename%
%cmddb% <crtbl_tmzdef.tsql >>%logfilename%
%cmddb% <crtbl_tmztyp.tsql >>%logfilename%
%cmddb% <crtbl_zscol.tsql >>%logfilename%
%cmddb% <crtbl_zsdef.tsql >>%logfilename%
%cmddb% <crtbl_zstyp.tsql >>%logfilename%
%cmddb% <crtbl_tbldef.tsql >>%logfilename%
%cmddb% <crtbl_tblcol.tsql >>%logfilename%
%cmddb% <crtbl_txtcol.tsql >>%logfilename%
%cmddb% <crtbl_txtdef.tsql >>%logfilename%
%cmddb% <crtbl_txttyp.tsql >>%logfilename%
%cmddb% <crtbl_tmcol.tsql >>%logfilename%
%cmddb% <crtbl_tmdef.tsql >>%logfilename%
%cmddb% <crtbl_tmtyp.tsql >>%logfilename%
%cmddb% <crtbl_tscol.tsql >>%logfilename%
%cmddb% <crtbl_tsdef.tsql >>%logfilename%
%cmddb% <crtbl_tstyp.tsql >>%logfilename%
%cmddb% <crtbl_tlddef.tsql >>%logfilename%
%cmddb% <crtbl_tkncol.tsql >>%logfilename%
%cmddb% <crtbl_tkndef.tsql >>%logfilename%
%cmddb% <crtbl_tkntyp.tsql >>%logfilename%
%cmddb% <crtbl_tdomdef.tsql >>%logfilename%
%cmddb% <crtbl_tprjdef.tsql >>%logfilename%
%cmddb% <crtbl_uint16col.tsql >>%logfilename%
%cmddb% <crtbl_u16def.tsql >>%logfilename%
%cmddb% <crtbl_uint16typ.tsql >>%logfilename%
%cmddb% <crtbl_uint32col.tsql >>%logfilename%
%cmddb% <crtbl_u32def.tsql >>%logfilename%
%cmddb% <crtbl_uint32typ.tsql >>%logfilename%
%cmddb% <crtbl_uint64col.tsql >>%logfilename%
%cmddb% <crtbl_u64def.tsql >>%logfilename%
%cmddb% <crtbl_uint64typ.tsql >>%logfilename%
%cmddb% <crtbl_urlproto.tsql >>%logfilename%
%cmddb% <crtbl_uuidcol.tsql >>%logfilename%
%cmddb% <crtbl_uuiddef.tsql >>%logfilename%
%cmddb% <crtbl_idguuid.tsql >>%logfilename%
%cmddb% <crtbl_uuidtyp.tsql >>%logfilename%
%cmddb% <crtbl_valdef.tsql >>%logfilename%
%cmddb% <crtbl_verndef.tsql >>%logfilename%
%cmddb% <crtbl_atomdef_h.tsql >>%logfilename%
%cmddb% <crtbl_blbcol_h.tsql >>%logfilename%
%cmddb% <crtbl_blbdef_h.tsql >>%logfilename%
%cmddb% <crtbl_blbtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_boolcol_h.tsql >>%logfilename%
%cmddb% <crtbl_booldef_h.tsql >>%logfilename%
%cmddb% <crtbl_booltyp_h.tsql >>%logfilename%
%cmddb% <crtbl_chain_def_h.tsql >>%logfilename%
%cmddb% <crtbl_clr_dep_h.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep1_h.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep2_h.tsql >>%logfilename%
%cmddb% <crtbl_clrsubdep3_h.tsql >>%logfilename%
%cmddb% <crtbl_clr_topdep_h.tsql >>%logfilename%
%cmddb% <crtbl_clus_h.tsql >>%logfilename%
%cmddb% <crtbl_dtcol_h.tsql >>%logfilename%
%cmddb% <crtbl_dtdef_h.tsql >>%logfilename%
%cmddb% <crtbl_dttyp_h.tsql >>%logfilename%
%cmddb% <crtbl_del_dep_h.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep1_h.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep2_h.tsql >>%logfilename%
%cmddb% <crtbl_delsubdep3_h.tsql >>%logfilename%
%cmddb% <crtbl_del_topdep_h.tsql >>%logfilename%
%cmddb% <crtbl_domdef_h.tsql >>%logfilename%
%cmddb% <crtbl_bdomdef_h.tsql >>%logfilename%
%cmddb% <crtbl_dblcol_h.tsql >>%logfilename%
%cmddb% <crtbl_dbldef_h.tsql >>%logfilename%
%cmddb% <crtbl_dbltyp_h.tsql >>%logfilename%
%cmddb% <crtbl_enumcol_h.tsql >>%logfilename%
%cmddb% <crtbl_enumdef_h.tsql >>%logfilename%
%cmddb% <crtbl_enum_tag_h.tsql >>%logfilename%
%cmddb% <crtbl_enumtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_fltcol_h.tsql >>%logfilename%
%cmddb% <crtbl_fltdef_h.tsql >>%logfilename%
%cmddb% <crtbl_flttyp_h.tsql >>%logfilename%
%cmddb% <crtbl_hostnode_h.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntry_h.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntryccy_h.tsql >>%logfilename%
%cmddb% <crtbl_iso_cntrylng_h.tsql >>%logfilename%
%cmddb% <crtbl_iso_ccy_h.tsql >>%logfilename%
%cmddb% <crtbl_iso_lang_h.tsql >>%logfilename%
%cmddb% <crtbl_isotz_h.tsql >>%logfilename%
%cmddb% <crtbl_idg16_h.tsql >>%logfilename%
%cmddb% <crtbl_idg32_h.tsql >>%logfilename%
%cmddb% <crtbl_idg64_h.tsql >>%logfilename%
%cmddb% <crtbl_idxdef_h.tsql >>%logfilename%
%cmddb% <crtbl_idxcol_h.tsql >>%logfilename%
%cmddb% <crtbl_int16col_h.tsql >>%logfilename%
%cmddb% <crtbl_int16def_h.tsql >>%logfilename%
%cmddb% <crtbl_int16typ_h.tsql >>%logfilename%
%cmddb% <crtbl_int32col_h.tsql >>%logfilename%
%cmddb% <crtbl_int32def_h.tsql >>%logfilename%
%cmddb% <crtbl_int32typ_h.tsql >>%logfilename%
%cmddb% <crtbl_int64col_h.tsql >>%logfilename%
%cmddb% <crtbl_int64def_h.tsql >>%logfilename%
%cmddb% <crtbl_int64typ_h.tsql >>%logfilename%
%cmddb% <crtbl_mjverdef_h.tsql >>%logfilename%
%cmddb% <crtbl_mimetype_h.tsql >>%logfilename%
%cmddb% <crtbl_mnverdef_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtkncol_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtkndef_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtkntyp_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtknscol_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtknsdef_h.tsql >>%logfilename%
%cmddb% <crtbl_nmtknstyp_h.tsql >>%logfilename%
%cmddb% <crtbl_numcol_h.tsql >>%logfilename%
%cmddb% <crtbl_numdef_h.tsql >>%logfilename%
%cmddb% <crtbl_numtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_srvprm_h.tsql >>%logfilename%
%cmddb% <crtbl_pop_dep_h.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep1_h.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep2_h.tsql >>%logfilename%
%cmddb% <crtbl_popsubdep3_h.tsql >>%logfilename%
%cmddb% <crtbl_pop_topdep_h.tsql >>%logfilename%
%cmddb% <crtbl_bprjdef_h.tsql >>%logfilename%
%cmddb% <crtbl_rprjdef_h.tsql >>%logfilename%
%cmddb% <crtbl_reldef_h.tsql >>%logfilename%
%cmddb% <crtbl_relcol_h.tsql >>%logfilename%
%cmddb% <crtbl_schemadef_h.tsql >>%logfilename%
%cmddb% <crtbl_schema_ref_h.tsql >>%logfilename%
%cmddb% <crtbl_scopedef_h.tsql >>%logfilename%
%cmddb% <crtbl_secapp_h.tsql >>%logfilename%
%cmddb% <crtbl_secdev_h.tsql >>%logfilename%
%cmddb% <crtbl_secform_h.tsql >>%logfilename%
%cmddb% <crtbl_secgrp_h.tsql >>%logfilename%
%cmddb% <crtbl_secgrpfrm_h.tsql >>%logfilename%
%cmddb% <crtbl_secinc_h.tsql >>%logfilename%
%cmddb% <crtbl_secmemb_h.tsql >>%logfilename%
%cmddb% <crtbl_secuser_h.tsql >>%logfilename%
%cmddb% <crtbl_srvlfunc_h.tsql >>%logfilename%
%cmddb% <crtbl_srvmeth_h.tsql >>%logfilename%
%cmddb% <crtbl_srvofunc_h.tsql >>%logfilename%
%cmddb% <crtbl_srvprc_h.tsql >>%logfilename%
%cmddb% <crtbl_hostsvc_h.tsql >>%logfilename%
%cmddb% <crtbl_svctype_h.tsql >>%logfilename%
%cmddb% <crtbl_strcol_h.tsql >>%logfilename%
%cmddb% <crtbl_strdef_h.tsql >>%logfilename%
%cmddb% <crtbl_strtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_sprjdef_h.tsql >>%logfilename%
%cmddb% <crtbl_tsecgrp_h.tsql >>%logfilename%
%cmddb% <crtbl_tsecinc_h.tsql >>%logfilename%
%cmddb% <crtbl_tsecmemb_h.tsql >>%logfilename%
%cmddb% <crtbl_dzcol_h.tsql >>%logfilename%
%cmddb% <crtbl_dzdef_h.tsql >>%logfilename%
%cmddb% <crtbl_dztyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tmzcol_h.tsql >>%logfilename%
%cmddb% <crtbl_tmzdef_h.tsql >>%logfilename%
%cmddb% <crtbl_tmztyp_h.tsql >>%logfilename%
%cmddb% <crtbl_zscol_h.tsql >>%logfilename%
%cmddb% <crtbl_zsdef_h.tsql >>%logfilename%
%cmddb% <crtbl_zstyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tbldef_h.tsql >>%logfilename%
%cmddb% <crtbl_tblcol_h.tsql >>%logfilename%
%cmddb% <crtbl_tenant_h.tsql >>%logfilename%
%cmddb% <crtbl_txtcol_h.tsql >>%logfilename%
%cmddb% <crtbl_txtdef_h.tsql >>%logfilename%
%cmddb% <crtbl_txttyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tmcol_h.tsql >>%logfilename%
%cmddb% <crtbl_tmdef_h.tsql >>%logfilename%
%cmddb% <crtbl_tmtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tscol_h.tsql >>%logfilename%
%cmddb% <crtbl_tsdef_h.tsql >>%logfilename%
%cmddb% <crtbl_tstyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tlddef_h.tsql >>%logfilename%
%cmddb% <crtbl_tkncol_h.tsql >>%logfilename%
%cmddb% <crtbl_tkndef_h.tsql >>%logfilename%
%cmddb% <crtbl_tkntyp_h.tsql >>%logfilename%
%cmddb% <crtbl_tdomdef_h.tsql >>%logfilename%
%cmddb% <crtbl_tprjdef_h.tsql >>%logfilename%
%cmddb% <crtbl_uint16col_h.tsql >>%logfilename%
%cmddb% <crtbl_u16def_h.tsql >>%logfilename%
%cmddb% <crtbl_uint16typ_h.tsql >>%logfilename%
%cmddb% <crtbl_uint32col_h.tsql >>%logfilename%
%cmddb% <crtbl_u32def_h.tsql >>%logfilename%
%cmddb% <crtbl_uint32typ_h.tsql >>%logfilename%
%cmddb% <crtbl_uint64col_h.tsql >>%logfilename%
%cmddb% <crtbl_u64def_h.tsql >>%logfilename%
%cmddb% <crtbl_uint64typ_h.tsql >>%logfilename%
%cmddb% <crtbl_urlproto_h.tsql >>%logfilename%
%cmddb% <crtbl_uuidcol_h.tsql >>%logfilename%
%cmddb% <crtbl_uuiddef_h.tsql >>%logfilename%
%cmddb% <crtbl_idguuid_h.tsql >>%logfilename%
%cmddb% <crtbl_uuidtyp_h.tsql >>%logfilename%
%cmddb% <crtbl_valdef_h.tsql >>%logfilename%
%cmddb% <crtbl_verndef_h.tsql >>%logfilename%

