@ECHO OFF
REM	@(#) dbcreate/cfbam/mssql/crrel_cfbam23.bat
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
SET logfilename=crrel_cfbam23.log

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

%cmddb% <crrel_accfreq.tsql >>%logfilename%
%cmddb% <crrel_accsec.tsql >>%logfilename%
%cmddb% <crrel_atomdef.tsql >>%logfilename%
%cmddb% <crrel_auditaction.tsql >>%logfilename%
%cmddb% <crrel_blbcol.tsql >>%logfilename%
%cmddb% <crrel_blbdef.tsql >>%logfilename%
%cmddb% <crrel_blbtyp.tsql >>%logfilename%
%cmddb% <crrel_boolcol.tsql >>%logfilename%
%cmddb% <crrel_booldef.tsql >>%logfilename%
%cmddb% <crrel_booltyp.tsql >>%logfilename%
%cmddb% <crrel_chain_def.tsql >>%logfilename%
%cmddb% <crrel_clr_dep.tsql >>%logfilename%
%cmddb% <crrel_clrsubdep1.tsql >>%logfilename%
%cmddb% <crrel_clrsubdep2.tsql >>%logfilename%
%cmddb% <crrel_clrsubdep3.tsql >>%logfilename%
%cmddb% <crrel_clr_topdep.tsql >>%logfilename%
%cmddb% <crrel_clus.tsql >>%logfilename%
%cmddb% <crrel_clus_idg32.tsql >>%logfilename%
%cmddb% <crrel_clus_idg64.tsql >>%logfilename%
%cmddb% <crrel_datascope.tsql >>%logfilename%
%cmddb% <crrel_dtcol.tsql >>%logfilename%
%cmddb% <crrel_dtdef.tsql >>%logfilename%
%cmddb% <crrel_dttyp.tsql >>%logfilename%
%cmddb% <crrel_del_dep.tsql >>%logfilename%
%cmddb% <crrel_delsubdep1.tsql >>%logfilename%
%cmddb% <crrel_delsubdep2.tsql >>%logfilename%
%cmddb% <crrel_delsubdep3.tsql >>%logfilename%
%cmddb% <crrel_del_topdep.tsql >>%logfilename%
%cmddb% <crrel_domdef.tsql >>%logfilename%
%cmddb% <crrel_bdomdef.tsql >>%logfilename%
%cmddb% <crrel_dblcol.tsql >>%logfilename%
%cmddb% <crrel_dbldef.tsql >>%logfilename%
%cmddb% <crrel_dbltyp.tsql >>%logfilename%
%cmddb% <crrel_enumcol.tsql >>%logfilename%
%cmddb% <crrel_enumdef.tsql >>%logfilename%
%cmddb% <crrel_enum_tag.tsql >>%logfilename%
%cmddb% <crrel_enumtyp.tsql >>%logfilename%
%cmddb% <crrel_fltcol.tsql >>%logfilename%
%cmddb% <crrel_fltdef.tsql >>%logfilename%
%cmddb% <crrel_flttyp.tsql >>%logfilename%
%cmddb% <crrel_hostnode.tsql >>%logfilename%
%cmddb% <crrel_iso_cntry.tsql >>%logfilename%
%cmddb% <crrel_iso_cntryccy.tsql >>%logfilename%
%cmddb% <crrel_iso_cntrylng.tsql >>%logfilename%
%cmddb% <crrel_iso_ccy.tsql >>%logfilename%
%cmddb% <crrel_iso_lang.tsql >>%logfilename%
%cmddb% <crrel_isotz.tsql >>%logfilename%
%cmddb% <crrel_idg16.tsql >>%logfilename%
%cmddb% <crrel_idg32.tsql >>%logfilename%
%cmddb% <crrel_idg64.tsql >>%logfilename%
%cmddb% <crrel_idxdef.tsql >>%logfilename%
%cmddb% <crrel_idxcol.tsql >>%logfilename%
%cmddb% <crrel_int16col.tsql >>%logfilename%
%cmddb% <crrel_int16def.tsql >>%logfilename%
%cmddb% <crrel_int16typ.tsql >>%logfilename%
%cmddb% <crrel_int32col.tsql >>%logfilename%
%cmddb% <crrel_int32def.tsql >>%logfilename%
%cmddb% <crrel_int32typ.tsql >>%logfilename%
%cmddb% <crrel_int64col.tsql >>%logfilename%
%cmddb% <crrel_int64def.tsql >>%logfilename%
%cmddb% <crrel_int64typ.tsql >>%logfilename%
%cmddb% <crrel_licn.tsql >>%logfilename%
%cmddb% <crrel_loadbehav.tsql >>%logfilename%
%cmddb% <crrel_mjverdef.tsql >>%logfilename%
%cmddb% <crrel_mimetype.tsql >>%logfilename%
%cmddb% <crrel_mnverdef.tsql >>%logfilename%
%cmddb% <crrel_nmtkncol.tsql >>%logfilename%
%cmddb% <crrel_nmtkndef.tsql >>%logfilename%
%cmddb% <crrel_nmtkntyp.tsql >>%logfilename%
%cmddb% <crrel_nmtknscol.tsql >>%logfilename%
%cmddb% <crrel_nmtknsdef.tsql >>%logfilename%
%cmddb% <crrel_nmtknstyp.tsql >>%logfilename%
%cmddb% <crrel_numcol.tsql >>%logfilename%
%cmddb% <crrel_numdef.tsql >>%logfilename%
%cmddb% <crrel_numtyp.tsql >>%logfilename%
%cmddb% <crrel_srvprm.tsql >>%logfilename%
%cmddb% <crrel_pop_dep.tsql >>%logfilename%
%cmddb% <crrel_popsubdep1.tsql >>%logfilename%
%cmddb% <crrel_popsubdep2.tsql >>%logfilename%
%cmddb% <crrel_popsubdep3.tsql >>%logfilename%
%cmddb% <crrel_pop_topdep.tsql >>%logfilename%
%cmddb% <crrel_bprjdef.tsql >>%logfilename%
%cmddb% <crrel_rprjdef.tsql >>%logfilename%
%cmddb% <crrel_reldef.tsql >>%logfilename%
%cmddb% <crrel_relcol.tsql >>%logfilename%
%cmddb% <crrel_rel_type.tsql >>%logfilename%
%cmddb% <crrel_schemadef.tsql >>%logfilename%
%cmddb% <crrel_schema_ref.tsql >>%logfilename%
%cmddb% <crrel_scopedef.tsql >>%logfilename%
%cmddb% <crrel_secapp.tsql >>%logfilename%
%cmddb% <crrel_secdev.tsql >>%logfilename%
%cmddb% <crrel_secform.tsql >>%logfilename%
%cmddb% <crrel_secgrp.tsql >>%logfilename%
%cmddb% <crrel_secgrpfrm.tsql >>%logfilename%
%cmddb% <crrel_secinc.tsql >>%logfilename%
%cmddb% <crrel_secmemb.tsql >>%logfilename%
%cmddb% <crrel_secsess.tsql >>%logfilename%
%cmddb% <crrel_secuser.tsql >>%logfilename%
%cmddb% <crrel_secscope.tsql >>%logfilename%
%cmddb% <crrel_srvlfunc.tsql >>%logfilename%
%cmddb% <crrel_srvmeth.tsql >>%logfilename%
%cmddb% <crrel_srvofunc.tsql >>%logfilename%
%cmddb% <crrel_srvprc.tsql >>%logfilename%
%cmddb% <crrel_hostsvc.tsql >>%logfilename%
%cmddb% <crrel_svctype.tsql >>%logfilename%
%cmddb% <crrel_strcol.tsql >>%logfilename%
%cmddb% <crrel_strdef.tsql >>%logfilename%
%cmddb% <crrel_strtyp.tsql >>%logfilename%
%cmddb% <crrel_sprjdef.tsql >>%logfilename%
%cmddb% <crrel_sysclus.tsql >>%logfilename%
%cmddb% <crrel_tsecgrp.tsql >>%logfilename%
%cmddb% <crrel_tsecinc.tsql >>%logfilename%
%cmddb% <crrel_tsecmemb.tsql >>%logfilename%
%cmddb% <crrel_dzcol.tsql >>%logfilename%
%cmddb% <crrel_dzdef.tsql >>%logfilename%
%cmddb% <crrel_dztyp.tsql >>%logfilename%
%cmddb% <crrel_tmzcol.tsql >>%logfilename%
%cmddb% <crrel_tmzdef.tsql >>%logfilename%
%cmddb% <crrel_tmztyp.tsql >>%logfilename%
%cmddb% <crrel_zscol.tsql >>%logfilename%
%cmddb% <crrel_zsdef.tsql >>%logfilename%
%cmddb% <crrel_zstyp.tsql >>%logfilename%
%cmddb% <crrel_tbldef.tsql >>%logfilename%
%cmddb% <crrel_tblcol.tsql >>%logfilename%
%cmddb% <crrel_tenant.tsql >>%logfilename%
%cmddb% <crrel_tenant_idg32.tsql >>%logfilename%
%cmddb% <crrel_tenant_idg64.tsql >>%logfilename%
%cmddb% <crrel_txtcol.tsql >>%logfilename%
%cmddb% <crrel_txtdef.tsql >>%logfilename%
%cmddb% <crrel_txttyp.tsql >>%logfilename%
%cmddb% <crrel_tmcol.tsql >>%logfilename%
%cmddb% <crrel_tmdef.tsql >>%logfilename%
%cmddb% <crrel_tmtyp.tsql >>%logfilename%
%cmddb% <crrel_tscol.tsql >>%logfilename%
%cmddb% <crrel_tsdef.tsql >>%logfilename%
%cmddb% <crrel_tstyp.tsql >>%logfilename%
%cmddb% <crrel_tlddef.tsql >>%logfilename%
%cmddb% <crrel_tkncol.tsql >>%logfilename%
%cmddb% <crrel_tkndef.tsql >>%logfilename%
%cmddb% <crrel_tkntyp.tsql >>%logfilename%
%cmddb% <crrel_tdomdef.tsql >>%logfilename%
%cmddb% <crrel_tprjdef.tsql >>%logfilename%
%cmddb% <crrel_uint16col.tsql >>%logfilename%
%cmddb% <crrel_u16def.tsql >>%logfilename%
%cmddb% <crrel_uint16typ.tsql >>%logfilename%
%cmddb% <crrel_uint32col.tsql >>%logfilename%
%cmddb% <crrel_u32def.tsql >>%logfilename%
%cmddb% <crrel_uint32typ.tsql >>%logfilename%
%cmddb% <crrel_uint64col.tsql >>%logfilename%
%cmddb% <crrel_u64def.tsql >>%logfilename%
%cmddb% <crrel_uint64typ.tsql >>%logfilename%
%cmddb% <crrel_urlproto.tsql >>%logfilename%
%cmddb% <crrel_uuidcol.tsql >>%logfilename%
%cmddb% <crrel_uuiddef.tsql >>%logfilename%
%cmddb% <crrel_idguuid.tsql >>%logfilename%
%cmddb% <crrel_uuidtyp.tsql >>%logfilename%
%cmddb% <crrel_valdef.tsql >>%logfilename%
%cmddb% <crrel_verndef.tsql >>%logfilename%

