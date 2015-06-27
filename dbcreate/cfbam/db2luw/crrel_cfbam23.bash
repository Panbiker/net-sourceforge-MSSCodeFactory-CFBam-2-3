#!/bin/bash
#
#	@(#) dbcreate/cfbam/db2luw/crrel_cfbam23.bash
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

echo "#	Running crrel_accfreq.sql ..."
db2 -l db2output.log -f crrel_accfreq.sql
echo "#	Running crrel_accsec.sql ..."
db2 -l db2output.log -f crrel_accsec.sql
echo "#	Running crrel_atomdef.sql ..."
db2 -l db2output.log -f crrel_atomdef.sql
echo "#	Running crrel_auditaction.sql ..."
db2 -l db2output.log -f crrel_auditaction.sql
echo "#	Running crrel_blbcol.sql ..."
db2 -l db2output.log -f crrel_blbcol.sql
echo "#	Running crrel_blbdef.sql ..."
db2 -l db2output.log -f crrel_blbdef.sql
echo "#	Running crrel_blbtyp.sql ..."
db2 -l db2output.log -f crrel_blbtyp.sql
echo "#	Running crrel_boolcol.sql ..."
db2 -l db2output.log -f crrel_boolcol.sql
echo "#	Running crrel_booldef.sql ..."
db2 -l db2output.log -f crrel_booldef.sql
echo "#	Running crrel_booltyp.sql ..."
db2 -l db2output.log -f crrel_booltyp.sql
echo "#	Running crrel_chain_def.sql ..."
db2 -l db2output.log -f crrel_chain_def.sql
echo "#	Running crrel_clr_dep.sql ..."
db2 -l db2output.log -f crrel_clr_dep.sql
echo "#	Running crrel_clrsubdep1.sql ..."
db2 -l db2output.log -f crrel_clrsubdep1.sql
echo "#	Running crrel_clrsubdep2.sql ..."
db2 -l db2output.log -f crrel_clrsubdep2.sql
echo "#	Running crrel_clrsubdep3.sql ..."
db2 -l db2output.log -f crrel_clrsubdep3.sql
echo "#	Running crrel_clr_topdep.sql ..."
db2 -l db2output.log -f crrel_clr_topdep.sql
echo "#	Running crrel_clus.sql ..."
db2 -l db2output.log -f crrel_clus.sql
echo "#	Running crrel_datascope.sql ..."
db2 -l db2output.log -f crrel_datascope.sql
echo "#	Running crrel_dtcol.sql ..."
db2 -l db2output.log -f crrel_dtcol.sql
echo "#	Running crrel_dtdef.sql ..."
db2 -l db2output.log -f crrel_dtdef.sql
echo "#	Running crrel_dttyp.sql ..."
db2 -l db2output.log -f crrel_dttyp.sql
echo "#	Running crrel_del_dep.sql ..."
db2 -l db2output.log -f crrel_del_dep.sql
echo "#	Running crrel_delsubdep1.sql ..."
db2 -l db2output.log -f crrel_delsubdep1.sql
echo "#	Running crrel_delsubdep2.sql ..."
db2 -l db2output.log -f crrel_delsubdep2.sql
echo "#	Running crrel_delsubdep3.sql ..."
db2 -l db2output.log -f crrel_delsubdep3.sql
echo "#	Running crrel_del_topdep.sql ..."
db2 -l db2output.log -f crrel_del_topdep.sql
echo "#	Running crrel_domdef.sql ..."
db2 -l db2output.log -f crrel_domdef.sql
echo "#	Running crrel_bdomdef.sql ..."
db2 -l db2output.log -f crrel_bdomdef.sql
echo "#	Running crrel_dblcol.sql ..."
db2 -l db2output.log -f crrel_dblcol.sql
echo "#	Running crrel_dbldef.sql ..."
db2 -l db2output.log -f crrel_dbldef.sql
echo "#	Running crrel_dbltyp.sql ..."
db2 -l db2output.log -f crrel_dbltyp.sql
echo "#	Running crrel_enumcol.sql ..."
db2 -l db2output.log -f crrel_enumcol.sql
echo "#	Running crrel_enumdef.sql ..."
db2 -l db2output.log -f crrel_enumdef.sql
echo "#	Running crrel_enum_tag.sql ..."
db2 -l db2output.log -f crrel_enum_tag.sql
echo "#	Running crrel_enumtyp.sql ..."
db2 -l db2output.log -f crrel_enumtyp.sql
echo "#	Running crrel_fltcol.sql ..."
db2 -l db2output.log -f crrel_fltcol.sql
echo "#	Running crrel_fltdef.sql ..."
db2 -l db2output.log -f crrel_fltdef.sql
echo "#	Running crrel_flttyp.sql ..."
db2 -l db2output.log -f crrel_flttyp.sql
echo "#	Running crrel_hostnode.sql ..."
db2 -l db2output.log -f crrel_hostnode.sql
echo "#	Running crrel_iso_cntry.sql ..."
db2 -l db2output.log -f crrel_iso_cntry.sql
echo "#	Running crrel_iso_cntryccy.sql ..."
db2 -l db2output.log -f crrel_iso_cntryccy.sql
echo "#	Running crrel_iso_cntrylng.sql ..."
db2 -l db2output.log -f crrel_iso_cntrylng.sql
echo "#	Running crrel_iso_ccy.sql ..."
db2 -l db2output.log -f crrel_iso_ccy.sql
echo "#	Running crrel_iso_lang.sql ..."
db2 -l db2output.log -f crrel_iso_lang.sql
echo "#	Running crrel_isotz.sql ..."
db2 -l db2output.log -f crrel_isotz.sql
echo "#	Running crrel_idg16.sql ..."
db2 -l db2output.log -f crrel_idg16.sql
echo "#	Running crrel_idg32.sql ..."
db2 -l db2output.log -f crrel_idg32.sql
echo "#	Running crrel_idg64.sql ..."
db2 -l db2output.log -f crrel_idg64.sql
echo "#	Running crrel_idxdef.sql ..."
db2 -l db2output.log -f crrel_idxdef.sql
echo "#	Running crrel_idxcol.sql ..."
db2 -l db2output.log -f crrel_idxcol.sql
echo "#	Running crrel_int16col.sql ..."
db2 -l db2output.log -f crrel_int16col.sql
echo "#	Running crrel_int16def.sql ..."
db2 -l db2output.log -f crrel_int16def.sql
echo "#	Running crrel_int16typ.sql ..."
db2 -l db2output.log -f crrel_int16typ.sql
echo "#	Running crrel_int32col.sql ..."
db2 -l db2output.log -f crrel_int32col.sql
echo "#	Running crrel_int32def.sql ..."
db2 -l db2output.log -f crrel_int32def.sql
echo "#	Running crrel_int32typ.sql ..."
db2 -l db2output.log -f crrel_int32typ.sql
echo "#	Running crrel_int64col.sql ..."
db2 -l db2output.log -f crrel_int64col.sql
echo "#	Running crrel_int64def.sql ..."
db2 -l db2output.log -f crrel_int64def.sql
echo "#	Running crrel_int64typ.sql ..."
db2 -l db2output.log -f crrel_int64typ.sql
echo "#	Running crrel_licn.sql ..."
db2 -l db2output.log -f crrel_licn.sql
echo "#	Running crrel_loadbehav.sql ..."
db2 -l db2output.log -f crrel_loadbehav.sql
echo "#	Running crrel_mjverdef.sql ..."
db2 -l db2output.log -f crrel_mjverdef.sql
echo "#	Running crrel_mimetype.sql ..."
db2 -l db2output.log -f crrel_mimetype.sql
echo "#	Running crrel_mnverdef.sql ..."
db2 -l db2output.log -f crrel_mnverdef.sql
echo "#	Running crrel_nmtkncol.sql ..."
db2 -l db2output.log -f crrel_nmtkncol.sql
echo "#	Running crrel_nmtkndef.sql ..."
db2 -l db2output.log -f crrel_nmtkndef.sql
echo "#	Running crrel_nmtkntyp.sql ..."
db2 -l db2output.log -f crrel_nmtkntyp.sql
echo "#	Running crrel_nmtknscol.sql ..."
db2 -l db2output.log -f crrel_nmtknscol.sql
echo "#	Running crrel_nmtknsdef.sql ..."
db2 -l db2output.log -f crrel_nmtknsdef.sql
echo "#	Running crrel_nmtknstyp.sql ..."
db2 -l db2output.log -f crrel_nmtknstyp.sql
echo "#	Running crrel_numcol.sql ..."
db2 -l db2output.log -f crrel_numcol.sql
echo "#	Running crrel_numdef.sql ..."
db2 -l db2output.log -f crrel_numdef.sql
echo "#	Running crrel_numtyp.sql ..."
db2 -l db2output.log -f crrel_numtyp.sql
echo "#	Running crrel_srvprm.sql ..."
db2 -l db2output.log -f crrel_srvprm.sql
echo "#	Running crrel_pop_dep.sql ..."
db2 -l db2output.log -f crrel_pop_dep.sql
echo "#	Running crrel_popsubdep1.sql ..."
db2 -l db2output.log -f crrel_popsubdep1.sql
echo "#	Running crrel_popsubdep2.sql ..."
db2 -l db2output.log -f crrel_popsubdep2.sql
echo "#	Running crrel_popsubdep3.sql ..."
db2 -l db2output.log -f crrel_popsubdep3.sql
echo "#	Running crrel_pop_topdep.sql ..."
db2 -l db2output.log -f crrel_pop_topdep.sql
echo "#	Running crrel_bprjdef.sql ..."
db2 -l db2output.log -f crrel_bprjdef.sql
echo "#	Running crrel_rprjdef.sql ..."
db2 -l db2output.log -f crrel_rprjdef.sql
echo "#	Running crrel_reldef.sql ..."
db2 -l db2output.log -f crrel_reldef.sql
echo "#	Running crrel_relcol.sql ..."
db2 -l db2output.log -f crrel_relcol.sql
echo "#	Running crrel_rel_type.sql ..."
db2 -l db2output.log -f crrel_rel_type.sql
echo "#	Running crrel_schemadef.sql ..."
db2 -l db2output.log -f crrel_schemadef.sql
echo "#	Running crrel_schema_ref.sql ..."
db2 -l db2output.log -f crrel_schema_ref.sql
echo "#	Running crrel_scopedef.sql ..."
db2 -l db2output.log -f crrel_scopedef.sql
echo "#	Running crrel_secapp.sql ..."
db2 -l db2output.log -f crrel_secapp.sql
echo "#	Running crrel_secdev.sql ..."
db2 -l db2output.log -f crrel_secdev.sql
echo "#	Running crrel_secform.sql ..."
db2 -l db2output.log -f crrel_secform.sql
echo "#	Running crrel_secgrp.sql ..."
db2 -l db2output.log -f crrel_secgrp.sql
echo "#	Running crrel_secgrpfrm.sql ..."
db2 -l db2output.log -f crrel_secgrpfrm.sql
echo "#	Running crrel_secinc.sql ..."
db2 -l db2output.log -f crrel_secinc.sql
echo "#	Running crrel_secmemb.sql ..."
db2 -l db2output.log -f crrel_secmemb.sql
echo "#	Running crrel_secsess.sql ..."
db2 -l db2output.log -f crrel_secsess.sql
echo "#	Running crrel_secuser.sql ..."
db2 -l db2output.log -f crrel_secuser.sql
echo "#	Running crrel_secscope.sql ..."
db2 -l db2output.log -f crrel_secscope.sql
echo "#	Running crrel_srvlfunc.sql ..."
db2 -l db2output.log -f crrel_srvlfunc.sql
echo "#	Running crrel_srvmeth.sql ..."
db2 -l db2output.log -f crrel_srvmeth.sql
echo "#	Running crrel_srvofunc.sql ..."
db2 -l db2output.log -f crrel_srvofunc.sql
echo "#	Running crrel_srvprc.sql ..."
db2 -l db2output.log -f crrel_srvprc.sql
echo "#	Running crrel_hostsvc.sql ..."
db2 -l db2output.log -f crrel_hostsvc.sql
echo "#	Running crrel_svctype.sql ..."
db2 -l db2output.log -f crrel_svctype.sql
echo "#	Running crrel_strcol.sql ..."
db2 -l db2output.log -f crrel_strcol.sql
echo "#	Running crrel_strdef.sql ..."
db2 -l db2output.log -f crrel_strdef.sql
echo "#	Running crrel_strtyp.sql ..."
db2 -l db2output.log -f crrel_strtyp.sql
echo "#	Running crrel_sprjdef.sql ..."
db2 -l db2output.log -f crrel_sprjdef.sql
echo "#	Running crrel_sysclus.sql ..."
db2 -l db2output.log -f crrel_sysclus.sql
echo "#	Running crrel_tsecgrp.sql ..."
db2 -l db2output.log -f crrel_tsecgrp.sql
echo "#	Running crrel_tsecinc.sql ..."
db2 -l db2output.log -f crrel_tsecinc.sql
echo "#	Running crrel_tsecmemb.sql ..."
db2 -l db2output.log -f crrel_tsecmemb.sql
echo "#	Running crrel_dzcol.sql ..."
db2 -l db2output.log -f crrel_dzcol.sql
echo "#	Running crrel_dzdef.sql ..."
db2 -l db2output.log -f crrel_dzdef.sql
echo "#	Running crrel_dztyp.sql ..."
db2 -l db2output.log -f crrel_dztyp.sql
echo "#	Running crrel_tmzcol.sql ..."
db2 -l db2output.log -f crrel_tmzcol.sql
echo "#	Running crrel_tmzdef.sql ..."
db2 -l db2output.log -f crrel_tmzdef.sql
echo "#	Running crrel_tmztyp.sql ..."
db2 -l db2output.log -f crrel_tmztyp.sql
echo "#	Running crrel_zscol.sql ..."
db2 -l db2output.log -f crrel_zscol.sql
echo "#	Running crrel_zsdef.sql ..."
db2 -l db2output.log -f crrel_zsdef.sql
echo "#	Running crrel_zstyp.sql ..."
db2 -l db2output.log -f crrel_zstyp.sql
echo "#	Running crrel_tbldef.sql ..."
db2 -l db2output.log -f crrel_tbldef.sql
echo "#	Running crrel_tblcol.sql ..."
db2 -l db2output.log -f crrel_tblcol.sql
echo "#	Running crrel_tenant.sql ..."
db2 -l db2output.log -f crrel_tenant.sql
echo "#	Running crrel_txtcol.sql ..."
db2 -l db2output.log -f crrel_txtcol.sql
echo "#	Running crrel_txtdef.sql ..."
db2 -l db2output.log -f crrel_txtdef.sql
echo "#	Running crrel_txttyp.sql ..."
db2 -l db2output.log -f crrel_txttyp.sql
echo "#	Running crrel_tmcol.sql ..."
db2 -l db2output.log -f crrel_tmcol.sql
echo "#	Running crrel_tmdef.sql ..."
db2 -l db2output.log -f crrel_tmdef.sql
echo "#	Running crrel_tmtyp.sql ..."
db2 -l db2output.log -f crrel_tmtyp.sql
echo "#	Running crrel_tscol.sql ..."
db2 -l db2output.log -f crrel_tscol.sql
echo "#	Running crrel_tsdef.sql ..."
db2 -l db2output.log -f crrel_tsdef.sql
echo "#	Running crrel_tstyp.sql ..."
db2 -l db2output.log -f crrel_tstyp.sql
echo "#	Running crrel_tlddef.sql ..."
db2 -l db2output.log -f crrel_tlddef.sql
echo "#	Running crrel_tkncol.sql ..."
db2 -l db2output.log -f crrel_tkncol.sql
echo "#	Running crrel_tkndef.sql ..."
db2 -l db2output.log -f crrel_tkndef.sql
echo "#	Running crrel_tkntyp.sql ..."
db2 -l db2output.log -f crrel_tkntyp.sql
echo "#	Running crrel_tdomdef.sql ..."
db2 -l db2output.log -f crrel_tdomdef.sql
echo "#	Running crrel_tprjdef.sql ..."
db2 -l db2output.log -f crrel_tprjdef.sql
echo "#	Running crrel_uint16col.sql ..."
db2 -l db2output.log -f crrel_uint16col.sql
echo "#	Running crrel_u16def.sql ..."
db2 -l db2output.log -f crrel_u16def.sql
echo "#	Running crrel_uint16typ.sql ..."
db2 -l db2output.log -f crrel_uint16typ.sql
echo "#	Running crrel_uint32col.sql ..."
db2 -l db2output.log -f crrel_uint32col.sql
echo "#	Running crrel_u32def.sql ..."
db2 -l db2output.log -f crrel_u32def.sql
echo "#	Running crrel_uint32typ.sql ..."
db2 -l db2output.log -f crrel_uint32typ.sql
echo "#	Running crrel_uint64col.sql ..."
db2 -l db2output.log -f crrel_uint64col.sql
echo "#	Running crrel_u64def.sql ..."
db2 -l db2output.log -f crrel_u64def.sql
echo "#	Running crrel_uint64typ.sql ..."
db2 -l db2output.log -f crrel_uint64typ.sql
echo "#	Running crrel_urlproto.sql ..."
db2 -l db2output.log -f crrel_urlproto.sql
echo "#	Running crrel_uuidcol.sql ..."
db2 -l db2output.log -f crrel_uuidcol.sql
echo "#	Running crrel_uuiddef.sql ..."
db2 -l db2output.log -f crrel_uuiddef.sql
echo "#	Running crrel_idguuid.sql ..."
db2 -l db2output.log -f crrel_idguuid.sql
echo "#	Running crrel_uuidtyp.sql ..."
db2 -l db2output.log -f crrel_uuidtyp.sql
echo "#	Running crrel_valdef.sql ..."
db2 -l db2output.log -f crrel_valdef.sql
echo "#	Running crrel_verndef.sql ..."
db2 -l db2output.log -f crrel_verndef.sql

