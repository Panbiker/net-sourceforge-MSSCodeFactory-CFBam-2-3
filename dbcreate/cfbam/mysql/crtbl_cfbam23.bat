@echo off
REM
REM	@(#) dbcreate/cfbam/mysql/crtbl_cfbam23.bat
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
SET logfilename=crtbl_cfbam23.log
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

echo crtbl_cfbam23_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_cfbam23_idg32.mysql >>%logfilename% 2>&1
echo crtbl_cfbam23_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_cfbam23_idg64.mysql >>%logfilename% 2>&1
echo crtbl_clus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clus.mysql >>%logfilename% 2>&1
echo crtbl_clus_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clus_idg32.mysql >>%logfilename% 2>&1
echo crtbl_clus_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clus_idg64.mysql >>%logfilename% 2>&1
echo crtbl_secapp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secapp.mysql >>%logfilename% 2>&1
echo crtbl_secform.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secform.mysql >>%logfilename% 2>&1
echo crtbl_secgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secgrp.mysql >>%logfilename% 2>&1
echo crtbl_secgrpfrm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secgrpfrm.mysql >>%logfilename% 2>&1
echo crtbl_secinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secinc.mysql >>%logfilename% 2>&1
echo crtbl_secmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secmemb.mysql >>%logfilename% 2>&1
echo crtbl_secsess.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secsess.mysql >>%logfilename% 2>&1
echo crtbl_secuser.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secuser.mysql >>%logfilename% 2>&1
echo crtbl_tenant.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tenant.mysql >>%logfilename% 2>&1
echo crtbl_tenant_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tenant_idg32.mysql >>%logfilename% 2>&1
echo crtbl_tenant_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tenant_idg64.mysql >>%logfilename% 2>&1
echo crtbl_accfreq.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_accfreq.mysql >>%logfilename% 2>&1
echo crtbl_accsec.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_accsec.mysql >>%logfilename% 2>&1
echo crtbl_atomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_atomdef.mysql >>%logfilename% 2>&1
echo crtbl_auditaction.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_auditaction.mysql >>%logfilename% 2>&1
echo crtbl_blbcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbcol.mysql >>%logfilename% 2>&1
echo crtbl_blbdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbdef.mysql >>%logfilename% 2>&1
echo crtbl_blbtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbtyp.mysql >>%logfilename% 2>&1
echo crtbl_boolcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_boolcol.mysql >>%logfilename% 2>&1
echo crtbl_booldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_booldef.mysql >>%logfilename% 2>&1
echo crtbl_booltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_booltyp.mysql >>%logfilename% 2>&1
echo crtbl_chain_def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_chain_def.mysql >>%logfilename% 2>&1
echo crtbl_clr_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clr_dep.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep1.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep2.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep3.mysql >>%logfilename% 2>&1
echo crtbl_clr_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clr_topdep.mysql >>%logfilename% 2>&1
echo crtbl_datascope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_datascope.mysql >>%logfilename% 2>&1
echo crtbl_dtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dtcol.mysql >>%logfilename% 2>&1
echo crtbl_dtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dtdef.mysql >>%logfilename% 2>&1
echo crtbl_dttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dttyp.mysql >>%logfilename% 2>&1
echo crtbl_del_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_del_dep.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep1.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep2.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep3.mysql >>%logfilename% 2>&1
echo crtbl_del_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_del_topdep.mysql >>%logfilename% 2>&1
echo crtbl_domdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_domdef.mysql >>%logfilename% 2>&1
echo crtbl_bdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_bdomdef.mysql >>%logfilename% 2>&1
echo crtbl_dblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dblcol.mysql >>%logfilename% 2>&1
echo crtbl_dbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dbldef.mysql >>%logfilename% 2>&1
echo crtbl_dbltyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dbltyp.mysql >>%logfilename% 2>&1
echo crtbl_enumcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumcol.mysql >>%logfilename% 2>&1
echo crtbl_enumdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumdef.mysql >>%logfilename% 2>&1
echo crtbl_enum_tag.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enum_tag.mysql >>%logfilename% 2>&1
echo crtbl_enumtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumtyp.mysql >>%logfilename% 2>&1
echo crtbl_fltcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_fltcol.mysql >>%logfilename% 2>&1
echo crtbl_fltdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_fltdef.mysql >>%logfilename% 2>&1
echo crtbl_flttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_flttyp.mysql >>%logfilename% 2>&1
echo crtbl_hostnode.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_hostnode.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntry.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntry.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntryccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntryccy.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntrylng.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntrylng.mysql >>%logfilename% 2>&1
echo crtbl_iso_ccy.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_ccy.mysql >>%logfilename% 2>&1
echo crtbl_iso_lang.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_lang.mysql >>%logfilename% 2>&1
echo crtbl_isotz.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_isotz.mysql >>%logfilename% 2>&1
echo crtbl_idg16.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg16.mysql >>%logfilename% 2>&1
echo crtbl_idg32.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg32.mysql >>%logfilename% 2>&1
echo crtbl_idg64.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg64.mysql >>%logfilename% 2>&1
echo crtbl_idxdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idxdef.mysql >>%logfilename% 2>&1
echo crtbl_idxcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idxcol.mysql >>%logfilename% 2>&1
echo crtbl_int16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16col.mysql >>%logfilename% 2>&1
echo crtbl_int16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16def.mysql >>%logfilename% 2>&1
echo crtbl_int16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16typ.mysql >>%logfilename% 2>&1
echo crtbl_int32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32col.mysql >>%logfilename% 2>&1
echo crtbl_int32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32def.mysql >>%logfilename% 2>&1
echo crtbl_int32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32typ.mysql >>%logfilename% 2>&1
echo crtbl_int64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64col.mysql >>%logfilename% 2>&1
echo crtbl_int64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64def.mysql >>%logfilename% 2>&1
echo crtbl_int64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64typ.mysql >>%logfilename% 2>&1
echo crtbl_licn.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_licn.mysql >>%logfilename% 2>&1
echo crtbl_loadbehav.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_loadbehav.mysql >>%logfilename% 2>&1
echo crtbl_mjverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mjverdef.mysql >>%logfilename% 2>&1
echo crtbl_mimetype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mimetype.mysql >>%logfilename% 2>&1
echo crtbl_mnverdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mnverdef.mysql >>%logfilename% 2>&1
echo crtbl_nmtkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkncol.mysql >>%logfilename% 2>&1
echo crtbl_nmtkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkndef.mysql >>%logfilename% 2>&1
echo crtbl_nmtkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkntyp.mysql >>%logfilename% 2>&1
echo crtbl_nmtknscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknscol.mysql >>%logfilename% 2>&1
echo crtbl_nmtknsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknsdef.mysql >>%logfilename% 2>&1
echo crtbl_nmtknstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknstyp.mysql >>%logfilename% 2>&1
echo crtbl_numcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numcol.mysql >>%logfilename% 2>&1
echo crtbl_numdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numdef.mysql >>%logfilename% 2>&1
echo crtbl_numtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numtyp.mysql >>%logfilename% 2>&1
echo crtbl_srvprm.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvprm.mysql >>%logfilename% 2>&1
echo crtbl_pop_dep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_pop_dep.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep1.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep1.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep2.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep2.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep3.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep3.mysql >>%logfilename% 2>&1
echo crtbl_pop_topdep.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_pop_topdep.mysql >>%logfilename% 2>&1
echo crtbl_bprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_bprjdef.mysql >>%logfilename% 2>&1
echo crtbl_rprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_rprjdef.mysql >>%logfilename% 2>&1
echo crtbl_reldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_reldef.mysql >>%logfilename% 2>&1
echo crtbl_relcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_relcol.mysql >>%logfilename% 2>&1
echo crtbl_rel_type.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_rel_type.mysql >>%logfilename% 2>&1
echo crtbl_schemadef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_schemadef.mysql >>%logfilename% 2>&1
echo crtbl_schema_ref.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_schema_ref.mysql >>%logfilename% 2>&1
echo crtbl_scopedef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_scopedef.mysql >>%logfilename% 2>&1
echo crtbl_secdev.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secdev.mysql >>%logfilename% 2>&1
echo crtbl_secscope.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secscope.mysql >>%logfilename% 2>&1
echo crtbl_srvlfunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvlfunc.mysql >>%logfilename% 2>&1
echo crtbl_srvmeth.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvmeth.mysql >>%logfilename% 2>&1
echo crtbl_srvofunc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvofunc.mysql >>%logfilename% 2>&1
echo crtbl_srvprc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvprc.mysql >>%logfilename% 2>&1
echo crtbl_hostsvc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_hostsvc.mysql >>%logfilename% 2>&1
echo crtbl_svctype.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_svctype.mysql >>%logfilename% 2>&1
echo crtbl_strcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strcol.mysql >>%logfilename% 2>&1
echo crtbl_strdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strdef.mysql >>%logfilename% 2>&1
echo crtbl_strtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strtyp.mysql >>%logfilename% 2>&1
echo crtbl_sprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_sprjdef.mysql >>%logfilename% 2>&1
echo crtbl_sysclus.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_sysclus.mysql >>%logfilename% 2>&1
echo crtbl_tsecgrp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecgrp.mysql >>%logfilename% 2>&1
echo crtbl_tsecinc.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecinc.mysql >>%logfilename% 2>&1
echo crtbl_tsecmemb.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecmemb.mysql >>%logfilename% 2>&1
echo crtbl_dzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dzcol.mysql >>%logfilename% 2>&1
echo crtbl_dzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dzdef.mysql >>%logfilename% 2>&1
echo crtbl_dztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dztyp.mysql >>%logfilename% 2>&1
echo crtbl_tmzcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmzcol.mysql >>%logfilename% 2>&1
echo crtbl_tmzdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmzdef.mysql >>%logfilename% 2>&1
echo crtbl_tmztyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmztyp.mysql >>%logfilename% 2>&1
echo crtbl_zscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zscol.mysql >>%logfilename% 2>&1
echo crtbl_zsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zsdef.mysql >>%logfilename% 2>&1
echo crtbl_zstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zstyp.mysql >>%logfilename% 2>&1
echo crtbl_tbldef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tbldef.mysql >>%logfilename% 2>&1
echo crtbl_tblcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tblcol.mysql >>%logfilename% 2>&1
echo crtbl_txtcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txtcol.mysql >>%logfilename% 2>&1
echo crtbl_txtdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txtdef.mysql >>%logfilename% 2>&1
echo crtbl_txttyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txttyp.mysql >>%logfilename% 2>&1
echo crtbl_tmcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmcol.mysql >>%logfilename% 2>&1
echo crtbl_tmdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmdef.mysql >>%logfilename% 2>&1
echo crtbl_tmtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmtyp.mysql >>%logfilename% 2>&1
echo crtbl_tscol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tscol.mysql >>%logfilename% 2>&1
echo crtbl_tsdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsdef.mysql >>%logfilename% 2>&1
echo crtbl_tstyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tstyp.mysql >>%logfilename% 2>&1
echo crtbl_tlddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tlddef.mysql >>%logfilename% 2>&1
echo crtbl_tkncol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkncol.mysql >>%logfilename% 2>&1
echo crtbl_tkndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkndef.mysql >>%logfilename% 2>&1
echo crtbl_tkntyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkntyp.mysql >>%logfilename% 2>&1
echo crtbl_tdomdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tdomdef.mysql >>%logfilename% 2>&1
echo crtbl_tprjdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tprjdef.mysql >>%logfilename% 2>&1
echo crtbl_uint16col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint16col.mysql >>%logfilename% 2>&1
echo crtbl_u16def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u16def.mysql >>%logfilename% 2>&1
echo crtbl_uint16typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint16typ.mysql >>%logfilename% 2>&1
echo crtbl_uint32col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint32col.mysql >>%logfilename% 2>&1
echo crtbl_u32def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u32def.mysql >>%logfilename% 2>&1
echo crtbl_uint32typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint32typ.mysql >>%logfilename% 2>&1
echo crtbl_uint64col.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint64col.mysql >>%logfilename% 2>&1
echo crtbl_u64def.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u64def.mysql >>%logfilename% 2>&1
echo crtbl_uint64typ.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint64typ.mysql >>%logfilename% 2>&1
echo crtbl_urlproto.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_urlproto.mysql >>%logfilename% 2>&1
echo crtbl_uuidcol.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuidcol.mysql >>%logfilename% 2>&1
echo crtbl_uuiddef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuiddef.mysql >>%logfilename% 2>&1
echo crtbl_idguuid.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idguuid.mysql >>%logfilename% 2>&1
echo crtbl_uuidtyp.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuidtyp.mysql >>%logfilename% 2>&1
echo crtbl_valdef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_valdef.mysql >>%logfilename% 2>&1
echo crtbl_verndef.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_verndef.mysql >>%logfilename% 2>&1
echo crtbl_atomdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_atomdef_h.mysql >>%logfilename% 2>&1
echo crtbl_blbcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbcol_h.mysql >>%logfilename% 2>&1
echo crtbl_blbdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbdef_h.mysql >>%logfilename% 2>&1
echo crtbl_blbtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_blbtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_boolcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_boolcol_h.mysql >>%logfilename% 2>&1
echo crtbl_booldef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_booldef_h.mysql >>%logfilename% 2>&1
echo crtbl_booltyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_booltyp_h.mysql >>%logfilename% 2>&1
echo crtbl_chain_def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_chain_def_h.mysql >>%logfilename% 2>&1
echo crtbl_clr_dep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clr_dep_h.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep1_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep1_h.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep2_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep2_h.mysql >>%logfilename% 2>&1
echo crtbl_clrsubdep3_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clrsubdep3_h.mysql >>%logfilename% 2>&1
echo crtbl_clr_topdep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clr_topdep_h.mysql >>%logfilename% 2>&1
echo crtbl_clus_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_clus_h.mysql >>%logfilename% 2>&1
echo crtbl_dtcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dtcol_h.mysql >>%logfilename% 2>&1
echo crtbl_dtdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dtdef_h.mysql >>%logfilename% 2>&1
echo crtbl_dttyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dttyp_h.mysql >>%logfilename% 2>&1
echo crtbl_del_dep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_del_dep_h.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep1_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep1_h.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep2_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep2_h.mysql >>%logfilename% 2>&1
echo crtbl_delsubdep3_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_delsubdep3_h.mysql >>%logfilename% 2>&1
echo crtbl_del_topdep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_del_topdep_h.mysql >>%logfilename% 2>&1
echo crtbl_domdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_domdef_h.mysql >>%logfilename% 2>&1
echo crtbl_bdomdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_bdomdef_h.mysql >>%logfilename% 2>&1
echo crtbl_dblcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dblcol_h.mysql >>%logfilename% 2>&1
echo crtbl_dbldef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dbldef_h.mysql >>%logfilename% 2>&1
echo crtbl_dbltyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dbltyp_h.mysql >>%logfilename% 2>&1
echo crtbl_enumcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumcol_h.mysql >>%logfilename% 2>&1
echo crtbl_enumdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumdef_h.mysql >>%logfilename% 2>&1
echo crtbl_enum_tag_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enum_tag_h.mysql >>%logfilename% 2>&1
echo crtbl_enumtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_enumtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_fltcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_fltcol_h.mysql >>%logfilename% 2>&1
echo crtbl_fltdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_fltdef_h.mysql >>%logfilename% 2>&1
echo crtbl_flttyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_flttyp_h.mysql >>%logfilename% 2>&1
echo crtbl_hostnode_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_hostnode_h.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntry_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntry_h.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntryccy_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntryccy_h.mysql >>%logfilename% 2>&1
echo crtbl_iso_cntrylng_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_cntrylng_h.mysql >>%logfilename% 2>&1
echo crtbl_iso_ccy_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_ccy_h.mysql >>%logfilename% 2>&1
echo crtbl_iso_lang_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_iso_lang_h.mysql >>%logfilename% 2>&1
echo crtbl_isotz_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_isotz_h.mysql >>%logfilename% 2>&1
echo crtbl_idg16_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg16_h.mysql >>%logfilename% 2>&1
echo crtbl_idg32_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg32_h.mysql >>%logfilename% 2>&1
echo crtbl_idg64_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idg64_h.mysql >>%logfilename% 2>&1
echo crtbl_idxdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idxdef_h.mysql >>%logfilename% 2>&1
echo crtbl_idxcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idxcol_h.mysql >>%logfilename% 2>&1
echo crtbl_int16col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16col_h.mysql >>%logfilename% 2>&1
echo crtbl_int16def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16def_h.mysql >>%logfilename% 2>&1
echo crtbl_int16typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int16typ_h.mysql >>%logfilename% 2>&1
echo crtbl_int32col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32col_h.mysql >>%logfilename% 2>&1
echo crtbl_int32def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32def_h.mysql >>%logfilename% 2>&1
echo crtbl_int32typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int32typ_h.mysql >>%logfilename% 2>&1
echo crtbl_int64col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64col_h.mysql >>%logfilename% 2>&1
echo crtbl_int64def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64def_h.mysql >>%logfilename% 2>&1
echo crtbl_int64typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_int64typ_h.mysql >>%logfilename% 2>&1
echo crtbl_mjverdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mjverdef_h.mysql >>%logfilename% 2>&1
echo crtbl_mimetype_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mimetype_h.mysql >>%logfilename% 2>&1
echo crtbl_mnverdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_mnverdef_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtkncol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkncol_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtkndef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkndef_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtkntyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtkntyp_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtknscol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknscol_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtknsdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknsdef_h.mysql >>%logfilename% 2>&1
echo crtbl_nmtknstyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_nmtknstyp_h.mysql >>%logfilename% 2>&1
echo crtbl_numcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numcol_h.mysql >>%logfilename% 2>&1
echo crtbl_numdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numdef_h.mysql >>%logfilename% 2>&1
echo crtbl_numtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_numtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_srvprm_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvprm_h.mysql >>%logfilename% 2>&1
echo crtbl_pop_dep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_pop_dep_h.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep1_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep1_h.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep2_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep2_h.mysql >>%logfilename% 2>&1
echo crtbl_popsubdep3_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_popsubdep3_h.mysql >>%logfilename% 2>&1
echo crtbl_pop_topdep_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_pop_topdep_h.mysql >>%logfilename% 2>&1
echo crtbl_bprjdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_bprjdef_h.mysql >>%logfilename% 2>&1
echo crtbl_rprjdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_rprjdef_h.mysql >>%logfilename% 2>&1
echo crtbl_reldef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_reldef_h.mysql >>%logfilename% 2>&1
echo crtbl_relcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_relcol_h.mysql >>%logfilename% 2>&1
echo crtbl_schemadef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_schemadef_h.mysql >>%logfilename% 2>&1
echo crtbl_schema_ref_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_schema_ref_h.mysql >>%logfilename% 2>&1
echo crtbl_scopedef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_scopedef_h.mysql >>%logfilename% 2>&1
echo crtbl_secapp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secapp_h.mysql >>%logfilename% 2>&1
echo crtbl_secdev_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secdev_h.mysql >>%logfilename% 2>&1
echo crtbl_secform_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secform_h.mysql >>%logfilename% 2>&1
echo crtbl_secgrp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secgrp_h.mysql >>%logfilename% 2>&1
echo crtbl_secgrpfrm_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secgrpfrm_h.mysql >>%logfilename% 2>&1
echo crtbl_secinc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secinc_h.mysql >>%logfilename% 2>&1
echo crtbl_secmemb_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secmemb_h.mysql >>%logfilename% 2>&1
echo crtbl_secuser_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_secuser_h.mysql >>%logfilename% 2>&1
echo crtbl_srvlfunc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvlfunc_h.mysql >>%logfilename% 2>&1
echo crtbl_srvmeth_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvmeth_h.mysql >>%logfilename% 2>&1
echo crtbl_srvofunc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvofunc_h.mysql >>%logfilename% 2>&1
echo crtbl_srvprc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_srvprc_h.mysql >>%logfilename% 2>&1
echo crtbl_hostsvc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_hostsvc_h.mysql >>%logfilename% 2>&1
echo crtbl_svctype_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_svctype_h.mysql >>%logfilename% 2>&1
echo crtbl_strcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strcol_h.mysql >>%logfilename% 2>&1
echo crtbl_strdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strdef_h.mysql >>%logfilename% 2>&1
echo crtbl_strtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_strtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_sprjdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_sprjdef_h.mysql >>%logfilename% 2>&1
echo crtbl_tsecgrp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecgrp_h.mysql >>%logfilename% 2>&1
echo crtbl_tsecinc_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecinc_h.mysql >>%logfilename% 2>&1
echo crtbl_tsecmemb_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsecmemb_h.mysql >>%logfilename% 2>&1
echo crtbl_dzcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dzcol_h.mysql >>%logfilename% 2>&1
echo crtbl_dzdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dzdef_h.mysql >>%logfilename% 2>&1
echo crtbl_dztyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_dztyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tmzcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmzcol_h.mysql >>%logfilename% 2>&1
echo crtbl_tmzdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmzdef_h.mysql >>%logfilename% 2>&1
echo crtbl_tmztyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmztyp_h.mysql >>%logfilename% 2>&1
echo crtbl_zscol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zscol_h.mysql >>%logfilename% 2>&1
echo crtbl_zsdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zsdef_h.mysql >>%logfilename% 2>&1
echo crtbl_zstyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_zstyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tbldef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tbldef_h.mysql >>%logfilename% 2>&1
echo crtbl_tblcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tblcol_h.mysql >>%logfilename% 2>&1
echo crtbl_tenant_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tenant_h.mysql >>%logfilename% 2>&1
echo crtbl_txtcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txtcol_h.mysql >>%logfilename% 2>&1
echo crtbl_txtdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txtdef_h.mysql >>%logfilename% 2>&1
echo crtbl_txttyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_txttyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tmcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmcol_h.mysql >>%logfilename% 2>&1
echo crtbl_tmdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmdef_h.mysql >>%logfilename% 2>&1
echo crtbl_tmtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tmtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tscol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tscol_h.mysql >>%logfilename% 2>&1
echo crtbl_tsdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tsdef_h.mysql >>%logfilename% 2>&1
echo crtbl_tstyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tstyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tlddef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tlddef_h.mysql >>%logfilename% 2>&1
echo crtbl_tkncol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkncol_h.mysql >>%logfilename% 2>&1
echo crtbl_tkndef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkndef_h.mysql >>%logfilename% 2>&1
echo crtbl_tkntyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tkntyp_h.mysql >>%logfilename% 2>&1
echo crtbl_tdomdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tdomdef_h.mysql >>%logfilename% 2>&1
echo crtbl_tprjdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_tprjdef_h.mysql >>%logfilename% 2>&1
echo crtbl_uint16col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint16col_h.mysql >>%logfilename% 2>&1
echo crtbl_u16def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u16def_h.mysql >>%logfilename% 2>&1
echo crtbl_uint16typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint16typ_h.mysql >>%logfilename% 2>&1
echo crtbl_uint32col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint32col_h.mysql >>%logfilename% 2>&1
echo crtbl_u32def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u32def_h.mysql >>%logfilename% 2>&1
echo crtbl_uint32typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint32typ_h.mysql >>%logfilename% 2>&1
echo crtbl_uint64col_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint64col_h.mysql >>%logfilename% 2>&1
echo crtbl_u64def_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_u64def_h.mysql >>%logfilename% 2>&1
echo crtbl_uint64typ_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uint64typ_h.mysql >>%logfilename% 2>&1
echo crtbl_urlproto_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_urlproto_h.mysql >>%logfilename% 2>&1
echo crtbl_uuidcol_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuidcol_h.mysql >>%logfilename% 2>&1
echo crtbl_uuiddef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuiddef_h.mysql >>%logfilename% 2>&1
echo crtbl_idguuid_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_idguuid_h.mysql >>%logfilename% 2>&1
echo crtbl_uuidtyp_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_uuidtyp_h.mysql >>%logfilename% 2>&1
echo crtbl_valdef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_valdef_h.mysql >>%logfilename% 2>&1
echo crtbl_verndef_h.mysql >>%logfilename%
mysql -v -u %mysqluser% --password=%mysqlpwd% < crtbl_verndef_h.mysql >>%logfilename% 2>&1

