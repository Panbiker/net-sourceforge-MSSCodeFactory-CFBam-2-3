@echo off
REM
REM	@(#) dbcreate/cfbam/mysql/crrel_cfbam23.bat
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
REM	Manufactured by MSS Code Factory
REM
REM
REM	Initialize locals
REM

SET mysqlpwd=""
SET mysqluser=""
SET logfilename=crrel_cfbam23.log
SET TK_DUALCASE_IN_CASE_STATEMENTS=true

IF NOT "%1" == "" SET mysqluser=%1
IF NOT "%2" == "" SET mysqlpwd=%2
IF NOT "%3" == "" SET logfilename=%3

REM
REM	Validate parameters
REM

IF "%mysqluser%" == "" (
	ECHO ERROR: MySQL DBA login not specified as argument 1
	PAUSE
	EXIT
)

IF "%mysqlpwd%" == "" (
	ECHO ERROR: Password must be specified as argument 2 >&2
	PAUSE
	EXIT
)

echo crrel_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_accfreq.mysql >>%logfilename% 2>&1
echo crrel_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_accsec.mysql >>%logfilename% 2>&1
echo crrel_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_atomdef.mysql >>%logfilename% 2>&1
echo crrel_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_auditaction.mysql >>%logfilename% 2>&1
echo crrel_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_blbcol.mysql >>%logfilename% 2>&1
echo crrel_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_blbdef.mysql >>%logfilename% 2>&1
echo crrel_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_blbtyp.mysql >>%logfilename% 2>&1
echo crrel_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_boolcol.mysql >>%logfilename% 2>&1
echo crrel_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_booldef.mysql >>%logfilename% 2>&1
echo crrel_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_booltyp.mysql >>%logfilename% 2>&1
echo crrel_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_chain_def.mysql >>%logfilename% 2>&1
echo crrel_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clr_dep.mysql >>%logfilename% 2>&1
echo crrel_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clrsubdep1.mysql >>%logfilename% 2>&1
echo crrel_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clrsubdep2.mysql >>%logfilename% 2>&1
echo crrel_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clrsubdep3.mysql >>%logfilename% 2>&1
echo crrel_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clr_topdep.mysql >>%logfilename% 2>&1
echo crrel_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clus.mysql >>%logfilename% 2>&1
echo crrel_clus_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clus_idg32.mysql >>%logfilename% 2>&1
echo crrel_clus_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_clus_idg64.mysql >>%logfilename% 2>&1
echo crrel_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_datascope.mysql >>%logfilename% 2>&1
echo crrel_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dtcol.mysql >>%logfilename% 2>&1
echo crrel_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dtdef.mysql >>%logfilename% 2>&1
echo crrel_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dttyp.mysql >>%logfilename% 2>&1
echo crrel_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_del_dep.mysql >>%logfilename% 2>&1
echo crrel_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_delsubdep1.mysql >>%logfilename% 2>&1
echo crrel_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_delsubdep2.mysql >>%logfilename% 2>&1
echo crrel_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_delsubdep3.mysql >>%logfilename% 2>&1
echo crrel_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_del_topdep.mysql >>%logfilename% 2>&1
echo crrel_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_domdef.mysql >>%logfilename% 2>&1
echo crrel_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_bdomdef.mysql >>%logfilename% 2>&1
echo crrel_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dblcol.mysql >>%logfilename% 2>&1
echo crrel_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dbldef.mysql >>%logfilename% 2>&1
echo crrel_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dbltyp.mysql >>%logfilename% 2>&1
echo crrel_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_enumcol.mysql >>%logfilename% 2>&1
echo crrel_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_enumdef.mysql >>%logfilename% 2>&1
echo crrel_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_enum_tag.mysql >>%logfilename% 2>&1
echo crrel_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_enumtyp.mysql >>%logfilename% 2>&1
echo crrel_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_fltcol.mysql >>%logfilename% 2>&1
echo crrel_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_fltdef.mysql >>%logfilename% 2>&1
echo crrel_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_flttyp.mysql >>%logfilename% 2>&1
echo crrel_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_hostnode.mysql >>%logfilename% 2>&1
echo crrel_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_iso_cntry.mysql >>%logfilename% 2>&1
echo crrel_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crrel_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crrel_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_iso_ccy.mysql >>%logfilename% 2>&1
echo crrel_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_iso_lang.mysql >>%logfilename% 2>&1
echo crrel_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_isotz.mysql >>%logfilename% 2>&1
echo crrel_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idg16.mysql >>%logfilename% 2>&1
echo crrel_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idg32.mysql >>%logfilename% 2>&1
echo crrel_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idg64.mysql >>%logfilename% 2>&1
echo crrel_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idxdef.mysql >>%logfilename% 2>&1
echo crrel_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idxcol.mysql >>%logfilename% 2>&1
echo crrel_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int16col.mysql >>%logfilename% 2>&1
echo crrel_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int16def.mysql >>%logfilename% 2>&1
echo crrel_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int16typ.mysql >>%logfilename% 2>&1
echo crrel_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int32col.mysql >>%logfilename% 2>&1
echo crrel_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int32def.mysql >>%logfilename% 2>&1
echo crrel_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int32typ.mysql >>%logfilename% 2>&1
echo crrel_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int64col.mysql >>%logfilename% 2>&1
echo crrel_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int64def.mysql >>%logfilename% 2>&1
echo crrel_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_int64typ.mysql >>%logfilename% 2>&1
echo crrel_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_licn.mysql >>%logfilename% 2>&1
echo crrel_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_loadbehav.mysql >>%logfilename% 2>&1
echo crrel_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_mjverdef.mysql >>%logfilename% 2>&1
echo crrel_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_mimetype.mysql >>%logfilename% 2>&1
echo crrel_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_mnverdef.mysql >>%logfilename% 2>&1
echo crrel_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtkncol.mysql >>%logfilename% 2>&1
echo crrel_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtkndef.mysql >>%logfilename% 2>&1
echo crrel_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtkntyp.mysql >>%logfilename% 2>&1
echo crrel_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtknscol.mysql >>%logfilename% 2>&1
echo crrel_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtknsdef.mysql >>%logfilename% 2>&1
echo crrel_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_nmtknstyp.mysql >>%logfilename% 2>&1
echo crrel_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_numcol.mysql >>%logfilename% 2>&1
echo crrel_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_numdef.mysql >>%logfilename% 2>&1
echo crrel_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_numtyp.mysql >>%logfilename% 2>&1
echo crrel_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_srvprm.mysql >>%logfilename% 2>&1
echo crrel_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_pop_dep.mysql >>%logfilename% 2>&1
echo crrel_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_popsubdep1.mysql >>%logfilename% 2>&1
echo crrel_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_popsubdep2.mysql >>%logfilename% 2>&1
echo crrel_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_popsubdep3.mysql >>%logfilename% 2>&1
echo crrel_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_pop_topdep.mysql >>%logfilename% 2>&1
echo crrel_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_bprjdef.mysql >>%logfilename% 2>&1
echo crrel_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_rprjdef.mysql >>%logfilename% 2>&1
echo crrel_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_reldef.mysql >>%logfilename% 2>&1
echo crrel_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_relcol.mysql >>%logfilename% 2>&1
echo crrel_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_rel_type.mysql >>%logfilename% 2>&1
echo crrel_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_schemadef.mysql >>%logfilename% 2>&1
echo crrel_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_schema_ref.mysql >>%logfilename% 2>&1
echo crrel_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_scopedef.mysql >>%logfilename% 2>&1
echo crrel_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secapp.mysql >>%logfilename% 2>&1
echo crrel_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secdev.mysql >>%logfilename% 2>&1
echo crrel_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secform.mysql >>%logfilename% 2>&1
echo crrel_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secgrp.mysql >>%logfilename% 2>&1
echo crrel_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secgrpfrm.mysql >>%logfilename% 2>&1
echo crrel_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secinc.mysql >>%logfilename% 2>&1
echo crrel_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secmemb.mysql >>%logfilename% 2>&1
echo crrel_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secsess.mysql >>%logfilename% 2>&1
echo crrel_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secuser.mysql >>%logfilename% 2>&1
echo crrel_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_secscope.mysql >>%logfilename% 2>&1
echo crrel_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_srvlfunc.mysql >>%logfilename% 2>&1
echo crrel_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_srvmeth.mysql >>%logfilename% 2>&1
echo crrel_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_srvofunc.mysql >>%logfilename% 2>&1
echo crrel_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_srvprc.mysql >>%logfilename% 2>&1
echo crrel_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_hostsvc.mysql >>%logfilename% 2>&1
echo crrel_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_svctype.mysql >>%logfilename% 2>&1
echo crrel_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_strcol.mysql >>%logfilename% 2>&1
echo crrel_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_strdef.mysql >>%logfilename% 2>&1
echo crrel_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_strtyp.mysql >>%logfilename% 2>&1
echo crrel_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_sprjdef.mysql >>%logfilename% 2>&1
echo crrel_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_sysclus.mysql >>%logfilename% 2>&1
echo crrel_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tsecgrp.mysql >>%logfilename% 2>&1
echo crrel_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tsecinc.mysql >>%logfilename% 2>&1
echo crrel_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tsecmemb.mysql >>%logfilename% 2>&1
echo crrel_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dzcol.mysql >>%logfilename% 2>&1
echo crrel_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dzdef.mysql >>%logfilename% 2>&1
echo crrel_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_dztyp.mysql >>%logfilename% 2>&1
echo crrel_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmzcol.mysql >>%logfilename% 2>&1
echo crrel_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmzdef.mysql >>%logfilename% 2>&1
echo crrel_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmztyp.mysql >>%logfilename% 2>&1
echo crrel_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_zscol.mysql >>%logfilename% 2>&1
echo crrel_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_zsdef.mysql >>%logfilename% 2>&1
echo crrel_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_zstyp.mysql >>%logfilename% 2>&1
echo crrel_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tbldef.mysql >>%logfilename% 2>&1
echo crrel_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tblcol.mysql >>%logfilename% 2>&1
echo crrel_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tenant.mysql >>%logfilename% 2>&1
echo crrel_tenant_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tenant_idg32.mysql >>%logfilename% 2>&1
echo crrel_tenant_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tenant_idg64.mysql >>%logfilename% 2>&1
echo crrel_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_txtcol.mysql >>%logfilename% 2>&1
echo crrel_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_txtdef.mysql >>%logfilename% 2>&1
echo crrel_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_txttyp.mysql >>%logfilename% 2>&1
echo crrel_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmcol.mysql >>%logfilename% 2>&1
echo crrel_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmdef.mysql >>%logfilename% 2>&1
echo crrel_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tmtyp.mysql >>%logfilename% 2>&1
echo crrel_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tscol.mysql >>%logfilename% 2>&1
echo crrel_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tsdef.mysql >>%logfilename% 2>&1
echo crrel_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tstyp.mysql >>%logfilename% 2>&1
echo crrel_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tlddef.mysql >>%logfilename% 2>&1
echo crrel_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tkncol.mysql >>%logfilename% 2>&1
echo crrel_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tkndef.mysql >>%logfilename% 2>&1
echo crrel_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tkntyp.mysql >>%logfilename% 2>&1
echo crrel_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tdomdef.mysql >>%logfilename% 2>&1
echo crrel_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_tprjdef.mysql >>%logfilename% 2>&1
echo crrel_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint16col.mysql >>%logfilename% 2>&1
echo crrel_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_u16def.mysql >>%logfilename% 2>&1
echo crrel_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint16typ.mysql >>%logfilename% 2>&1
echo crrel_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint32col.mysql >>%logfilename% 2>&1
echo crrel_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_u32def.mysql >>%logfilename% 2>&1
echo crrel_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint32typ.mysql >>%logfilename% 2>&1
echo crrel_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint64col.mysql >>%logfilename% 2>&1
echo crrel_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_u64def.mysql >>%logfilename% 2>&1
echo crrel_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uint64typ.mysql >>%logfilename% 2>&1
echo crrel_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_urlproto.mysql >>%logfilename% 2>&1
echo crrel_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uuidcol.mysql >>%logfilename% 2>&1
echo crrel_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uuiddef.mysql >>%logfilename% 2>&1
echo crrel_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_idguuid.mysql >>%logfilename% 2>&1
echo crrel_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_uuidtyp.mysql >>%logfilename% 2>&1
echo crrel_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_valdef.mysql >>%logfilename% 2>&1
echo crrel_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crrel_verndef.mysql >>%logfilename% 2>&1

