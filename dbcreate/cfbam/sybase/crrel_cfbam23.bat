@ECHO OFF
REM
REM	@(#) dbcreate/cfbam/sybase/crrel_cfbam23.bat
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
SET logfilename=crrel_cfbam23.log
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

%cmdappdb% <crrel_accfreq.isql >>%logfilename%
%cmdappdb% <crrel_accsec.isql >>%logfilename%
%cmdappdb% <crrel_atomdef.isql >>%logfilename%
%cmdappdb% <crrel_auditaction.isql >>%logfilename%
%cmdappdb% <crrel_blbcol.isql >>%logfilename%
%cmdappdb% <crrel_blbdef.isql >>%logfilename%
%cmdappdb% <crrel_blbtyp.isql >>%logfilename%
%cmdappdb% <crrel_boolcol.isql >>%logfilename%
%cmdappdb% <crrel_booldef.isql >>%logfilename%
%cmdappdb% <crrel_booltyp.isql >>%logfilename%
%cmdappdb% <crrel_chain_def.isql >>%logfilename%
%cmdappdb% <crrel_clr_dep.isql >>%logfilename%
%cmdappdb% <crrel_clrsubdep1.isql >>%logfilename%
%cmdappdb% <crrel_clrsubdep2.isql >>%logfilename%
%cmdappdb% <crrel_clrsubdep3.isql >>%logfilename%
%cmdappdb% <crrel_clr_topdep.isql >>%logfilename%
%cmdappdb% <crrel_clus.isql >>%logfilename%
%cmdappdb% <crrel_clus_idg32.isql >>%logfilename%
%cmdappdb% <crrel_clus_idg64.isql >>%logfilename%
%cmdappdb% <crrel_datascope.isql >>%logfilename%
%cmdappdb% <crrel_dtcol.isql >>%logfilename%
%cmdappdb% <crrel_dtdef.isql >>%logfilename%
%cmdappdb% <crrel_dttyp.isql >>%logfilename%
%cmdappdb% <crrel_del_dep.isql >>%logfilename%
%cmdappdb% <crrel_delsubdep1.isql >>%logfilename%
%cmdappdb% <crrel_delsubdep2.isql >>%logfilename%
%cmdappdb% <crrel_delsubdep3.isql >>%logfilename%
%cmdappdb% <crrel_del_topdep.isql >>%logfilename%
%cmdappdb% <crrel_domdef.isql >>%logfilename%
%cmdappdb% <crrel_bdomdef.isql >>%logfilename%
%cmdappdb% <crrel_dblcol.isql >>%logfilename%
%cmdappdb% <crrel_dbldef.isql >>%logfilename%
%cmdappdb% <crrel_dbltyp.isql >>%logfilename%
%cmdappdb% <crrel_enumcol.isql >>%logfilename%
%cmdappdb% <crrel_enumdef.isql >>%logfilename%
%cmdappdb% <crrel_enum_tag.isql >>%logfilename%
%cmdappdb% <crrel_enumtyp.isql >>%logfilename%
%cmdappdb% <crrel_fltcol.isql >>%logfilename%
%cmdappdb% <crrel_fltdef.isql >>%logfilename%
%cmdappdb% <crrel_flttyp.isql >>%logfilename%
%cmdappdb% <crrel_hostnode.isql >>%logfilename%
%cmdappdb% <crrel_iso_cntry.isql >>%logfilename%
%cmdappdb% <crrel_iso_cntryccy.isql >>%logfilename%
%cmdappdb% <crrel_iso_cntrylng.isql >>%logfilename%
%cmdappdb% <crrel_iso_ccy.isql >>%logfilename%
%cmdappdb% <crrel_iso_lang.isql >>%logfilename%
%cmdappdb% <crrel_isotz.isql >>%logfilename%
%cmdappdb% <crrel_idg16.isql >>%logfilename%
%cmdappdb% <crrel_idg32.isql >>%logfilename%
%cmdappdb% <crrel_idg64.isql >>%logfilename%
%cmdappdb% <crrel_idxdef.isql >>%logfilename%
%cmdappdb% <crrel_idxcol.isql >>%logfilename%
%cmdappdb% <crrel_int16col.isql >>%logfilename%
%cmdappdb% <crrel_int16def.isql >>%logfilename%
%cmdappdb% <crrel_int16typ.isql >>%logfilename%
%cmdappdb% <crrel_int32col.isql >>%logfilename%
%cmdappdb% <crrel_int32def.isql >>%logfilename%
%cmdappdb% <crrel_int32typ.isql >>%logfilename%
%cmdappdb% <crrel_int64col.isql >>%logfilename%
%cmdappdb% <crrel_int64def.isql >>%logfilename%
%cmdappdb% <crrel_int64typ.isql >>%logfilename%
%cmdappdb% <crrel_licn.isql >>%logfilename%
%cmdappdb% <crrel_loadbehav.isql >>%logfilename%
%cmdappdb% <crrel_mjverdef.isql >>%logfilename%
%cmdappdb% <crrel_mimetype.isql >>%logfilename%
%cmdappdb% <crrel_mnverdef.isql >>%logfilename%
%cmdappdb% <crrel_nmtkncol.isql >>%logfilename%
%cmdappdb% <crrel_nmtkndef.isql >>%logfilename%
%cmdappdb% <crrel_nmtkntyp.isql >>%logfilename%
%cmdappdb% <crrel_nmtknscol.isql >>%logfilename%
%cmdappdb% <crrel_nmtknsdef.isql >>%logfilename%
%cmdappdb% <crrel_nmtknstyp.isql >>%logfilename%
%cmdappdb% <crrel_numcol.isql >>%logfilename%
%cmdappdb% <crrel_numdef.isql >>%logfilename%
%cmdappdb% <crrel_numtyp.isql >>%logfilename%
%cmdappdb% <crrel_srvprm.isql >>%logfilename%
%cmdappdb% <crrel_pop_dep.isql >>%logfilename%
%cmdappdb% <crrel_popsubdep1.isql >>%logfilename%
%cmdappdb% <crrel_popsubdep2.isql >>%logfilename%
%cmdappdb% <crrel_popsubdep3.isql >>%logfilename%
%cmdappdb% <crrel_pop_topdep.isql >>%logfilename%
%cmdappdb% <crrel_bprjdef.isql >>%logfilename%
%cmdappdb% <crrel_rprjdef.isql >>%logfilename%
%cmdappdb% <crrel_reldef.isql >>%logfilename%
%cmdappdb% <crrel_relcol.isql >>%logfilename%
%cmdappdb% <crrel_rel_type.isql >>%logfilename%
%cmdappdb% <crrel_schemadef.isql >>%logfilename%
%cmdappdb% <crrel_schema_ref.isql >>%logfilename%
%cmdappdb% <crrel_scopedef.isql >>%logfilename%
%cmdappdb% <crrel_secapp.isql >>%logfilename%
%cmdappdb% <crrel_secdev.isql >>%logfilename%
%cmdappdb% <crrel_secform.isql >>%logfilename%
%cmdappdb% <crrel_secgrp.isql >>%logfilename%
%cmdappdb% <crrel_secgrpfrm.isql >>%logfilename%
%cmdappdb% <crrel_secinc.isql >>%logfilename%
%cmdappdb% <crrel_secmemb.isql >>%logfilename%
%cmdappdb% <crrel_secsess.isql >>%logfilename%
%cmdappdb% <crrel_secuser.isql >>%logfilename%
%cmdappdb% <crrel_secscope.isql >>%logfilename%
%cmdappdb% <crrel_srvlfunc.isql >>%logfilename%
%cmdappdb% <crrel_srvmeth.isql >>%logfilename%
%cmdappdb% <crrel_srvofunc.isql >>%logfilename%
%cmdappdb% <crrel_srvprc.isql >>%logfilename%
%cmdappdb% <crrel_hostsvc.isql >>%logfilename%
%cmdappdb% <crrel_svctype.isql >>%logfilename%
%cmdappdb% <crrel_strcol.isql >>%logfilename%
%cmdappdb% <crrel_strdef.isql >>%logfilename%
%cmdappdb% <crrel_strtyp.isql >>%logfilename%
%cmdappdb% <crrel_sprjdef.isql >>%logfilename%
%cmdappdb% <crrel_sysclus.isql >>%logfilename%
%cmdappdb% <crrel_tsecgrp.isql >>%logfilename%
%cmdappdb% <crrel_tsecinc.isql >>%logfilename%
%cmdappdb% <crrel_tsecmemb.isql >>%logfilename%
%cmdappdb% <crrel_dzcol.isql >>%logfilename%
%cmdappdb% <crrel_dzdef.isql >>%logfilename%
%cmdappdb% <crrel_dztyp.isql >>%logfilename%
%cmdappdb% <crrel_tmzcol.isql >>%logfilename%
%cmdappdb% <crrel_tmzdef.isql >>%logfilename%
%cmdappdb% <crrel_tmztyp.isql >>%logfilename%
%cmdappdb% <crrel_zscol.isql >>%logfilename%
%cmdappdb% <crrel_zsdef.isql >>%logfilename%
%cmdappdb% <crrel_zstyp.isql >>%logfilename%
%cmdappdb% <crrel_tbldef.isql >>%logfilename%
%cmdappdb% <crrel_tblcol.isql >>%logfilename%
%cmdappdb% <crrel_tenant.isql >>%logfilename%
%cmdappdb% <crrel_tenant_idg32.isql >>%logfilename%
%cmdappdb% <crrel_tenant_idg64.isql >>%logfilename%
%cmdappdb% <crrel_txtcol.isql >>%logfilename%
%cmdappdb% <crrel_txtdef.isql >>%logfilename%
%cmdappdb% <crrel_txttyp.isql >>%logfilename%
%cmdappdb% <crrel_tmcol.isql >>%logfilename%
%cmdappdb% <crrel_tmdef.isql >>%logfilename%
%cmdappdb% <crrel_tmtyp.isql >>%logfilename%
%cmdappdb% <crrel_tscol.isql >>%logfilename%
%cmdappdb% <crrel_tsdef.isql >>%logfilename%
%cmdappdb% <crrel_tstyp.isql >>%logfilename%
%cmdappdb% <crrel_tlddef.isql >>%logfilename%
%cmdappdb% <crrel_tkncol.isql >>%logfilename%
%cmdappdb% <crrel_tkndef.isql >>%logfilename%
%cmdappdb% <crrel_tkntyp.isql >>%logfilename%
%cmdappdb% <crrel_tdomdef.isql >>%logfilename%
%cmdappdb% <crrel_tprjdef.isql >>%logfilename%
%cmdappdb% <crrel_uint16col.isql >>%logfilename%
%cmdappdb% <crrel_u16def.isql >>%logfilename%
%cmdappdb% <crrel_uint16typ.isql >>%logfilename%
%cmdappdb% <crrel_uint32col.isql >>%logfilename%
%cmdappdb% <crrel_u32def.isql >>%logfilename%
%cmdappdb% <crrel_uint32typ.isql >>%logfilename%
%cmdappdb% <crrel_uint64col.isql >>%logfilename%
%cmdappdb% <crrel_u64def.isql >>%logfilename%
%cmdappdb% <crrel_uint64typ.isql >>%logfilename%
%cmdappdb% <crrel_urlproto.isql >>%logfilename%
%cmdappdb% <crrel_uuidcol.isql >>%logfilename%
%cmdappdb% <crrel_uuiddef.isql >>%logfilename%
%cmdappdb% <crrel_idguuid.isql >>%logfilename%
%cmdappdb% <crrel_uuidtyp.isql >>%logfilename%
%cmdappdb% <crrel_valdef.isql >>%logfilename%
%cmdappdb% <crrel_verndef.isql >>%logfilename%

