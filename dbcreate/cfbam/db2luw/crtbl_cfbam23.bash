#!/bin/bash
#
#	@(#) dbcreate/cfbam/db2luw/crtbl_cfbam23.bash
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

echo "#	Running crtbl_cfbam23_idg32.sql..."
db2 -l db2output.log -f crtbl_cfbam23_idg32.sql
echo "#	Running crtbl_cfbam23_idg64.sql..."
db2 -l db2output.log -f crtbl_cfbam23_idg64.sql
echo "#	Running crtbl_clus.sql..."
db2 -l db2output.log -f crtbl_clus.sql
echo "#	Running crtbl_clus_idg32.sql..."
db2 -l db2output.log -f crtbl_clus_idg32.sql
echo "#	Running crtbl_clus_idg64.sql..."
db2 -l db2output.log -f crtbl_clus_idg64.sql
echo "#	Running crtbl_secapp.sql..."
db2 -l db2output.log -f crtbl_secapp.sql
echo "#	Running crtbl_secform.sql..."
db2 -l db2output.log -f crtbl_secform.sql
echo "#	Running crtbl_secgrp.sql..."
db2 -l db2output.log -f crtbl_secgrp.sql
echo "#	Running crtbl_secgrpfrm.sql..."
db2 -l db2output.log -f crtbl_secgrpfrm.sql
echo "#	Running crtbl_secinc.sql..."
db2 -l db2output.log -f crtbl_secinc.sql
echo "#	Running crtbl_secmemb.sql..."
db2 -l db2output.log -f crtbl_secmemb.sql
echo "#	Running crtbl_secsess.sql..."
db2 -l db2output.log -f crtbl_secsess.sql
echo "#	Running crtbl_secuser.sql..."
db2 -l db2output.log -f crtbl_secuser.sql
echo "#	Running crtbl_tenant.sql..."
db2 -l db2output.log -f crtbl_tenant.sql
echo "#	Running crtbl_tenant_idg32.sql..."
db2 -l db2output.log -f crtbl_tenant_idg32.sql
echo "#	Running crtbl_tenant_idg64.sql..."
db2 -l db2output.log -f crtbl_tenant_idg64.sql
echo "#	Running crtbl_accfreq.sql..."
db2 -l db2output.log -f crtbl_accfreq.sql
echo "#	Running crtbl_accsec.sql..."
db2 -l db2output.log -f crtbl_accsec.sql
echo "#	Running crtbl_atomdef.sql..."
db2 -l db2output.log -f crtbl_atomdef.sql
echo "#	Running crtbl_auditaction.sql..."
db2 -l db2output.log -f crtbl_auditaction.sql
echo "#	Running crtbl_blbcol.sql..."
db2 -l db2output.log -f crtbl_blbcol.sql
echo "#	Running crtbl_blbdef.sql..."
db2 -l db2output.log -f crtbl_blbdef.sql
echo "#	Running crtbl_blbtyp.sql..."
db2 -l db2output.log -f crtbl_blbtyp.sql
echo "#	Running crtbl_boolcol.sql..."
db2 -l db2output.log -f crtbl_boolcol.sql
echo "#	Running crtbl_booldef.sql..."
db2 -l db2output.log -f crtbl_booldef.sql
echo "#	Running crtbl_booltyp.sql..."
db2 -l db2output.log -f crtbl_booltyp.sql
echo "#	Running crtbl_chain_def.sql..."
db2 -l db2output.log -f crtbl_chain_def.sql
echo "#	Running crtbl_clr_dep.sql..."
db2 -l db2output.log -f crtbl_clr_dep.sql
echo "#	Running crtbl_clrsubdep1.sql..."
db2 -l db2output.log -f crtbl_clrsubdep1.sql
echo "#	Running crtbl_clrsubdep2.sql..."
db2 -l db2output.log -f crtbl_clrsubdep2.sql
echo "#	Running crtbl_clrsubdep3.sql..."
db2 -l db2output.log -f crtbl_clrsubdep3.sql
echo "#	Running crtbl_clr_topdep.sql..."
db2 -l db2output.log -f crtbl_clr_topdep.sql
echo "#	Running crtbl_datascope.sql..."
db2 -l db2output.log -f crtbl_datascope.sql
echo "#	Running crtbl_dtcol.sql..."
db2 -l db2output.log -f crtbl_dtcol.sql
echo "#	Running crtbl_dtdef.sql..."
db2 -l db2output.log -f crtbl_dtdef.sql
echo "#	Running crtbl_dttyp.sql..."
db2 -l db2output.log -f crtbl_dttyp.sql
echo "#	Running crtbl_del_dep.sql..."
db2 -l db2output.log -f crtbl_del_dep.sql
echo "#	Running crtbl_delsubdep1.sql..."
db2 -l db2output.log -f crtbl_delsubdep1.sql
echo "#	Running crtbl_delsubdep2.sql..."
db2 -l db2output.log -f crtbl_delsubdep2.sql
echo "#	Running crtbl_delsubdep3.sql..."
db2 -l db2output.log -f crtbl_delsubdep3.sql
echo "#	Running crtbl_del_topdep.sql..."
db2 -l db2output.log -f crtbl_del_topdep.sql
echo "#	Running crtbl_domdef.sql..."
db2 -l db2output.log -f crtbl_domdef.sql
echo "#	Running crtbl_bdomdef.sql..."
db2 -l db2output.log -f crtbl_bdomdef.sql
echo "#	Running crtbl_dblcol.sql..."
db2 -l db2output.log -f crtbl_dblcol.sql
echo "#	Running crtbl_dbldef.sql..."
db2 -l db2output.log -f crtbl_dbldef.sql
echo "#	Running crtbl_dbltyp.sql..."
db2 -l db2output.log -f crtbl_dbltyp.sql
echo "#	Running crtbl_enumcol.sql..."
db2 -l db2output.log -f crtbl_enumcol.sql
echo "#	Running crtbl_enumdef.sql..."
db2 -l db2output.log -f crtbl_enumdef.sql
echo "#	Running crtbl_enum_tag.sql..."
db2 -l db2output.log -f crtbl_enum_tag.sql
echo "#	Running crtbl_enumtyp.sql..."
db2 -l db2output.log -f crtbl_enumtyp.sql
echo "#	Running crtbl_fltcol.sql..."
db2 -l db2output.log -f crtbl_fltcol.sql
echo "#	Running crtbl_fltdef.sql..."
db2 -l db2output.log -f crtbl_fltdef.sql
echo "#	Running crtbl_flttyp.sql..."
db2 -l db2output.log -f crtbl_flttyp.sql
echo "#	Running crtbl_hostnode.sql..."
db2 -l db2output.log -f crtbl_hostnode.sql
echo "#	Running crtbl_iso_cntry.sql..."
db2 -l db2output.log -f crtbl_iso_cntry.sql
echo "#	Running crtbl_iso_cntryccy.sql..."
db2 -l db2output.log -f crtbl_iso_cntryccy.sql
echo "#	Running crtbl_iso_cntrylng.sql..."
db2 -l db2output.log -f crtbl_iso_cntrylng.sql
echo "#	Running crtbl_iso_ccy.sql..."
db2 -l db2output.log -f crtbl_iso_ccy.sql
echo "#	Running crtbl_iso_lang.sql..."
db2 -l db2output.log -f crtbl_iso_lang.sql
echo "#	Running crtbl_isotz.sql..."
db2 -l db2output.log -f crtbl_isotz.sql
echo "#	Running crtbl_idg16.sql..."
db2 -l db2output.log -f crtbl_idg16.sql
echo "#	Running crtbl_idg32.sql..."
db2 -l db2output.log -f crtbl_idg32.sql
echo "#	Running crtbl_idg64.sql..."
db2 -l db2output.log -f crtbl_idg64.sql
echo "#	Running crtbl_idxdef.sql..."
db2 -l db2output.log -f crtbl_idxdef.sql
echo "#	Running crtbl_idxcol.sql..."
db2 -l db2output.log -f crtbl_idxcol.sql
echo "#	Running crtbl_int16col.sql..."
db2 -l db2output.log -f crtbl_int16col.sql
echo "#	Running crtbl_int16def.sql..."
db2 -l db2output.log -f crtbl_int16def.sql
echo "#	Running crtbl_int16typ.sql..."
db2 -l db2output.log -f crtbl_int16typ.sql
echo "#	Running crtbl_int32col.sql..."
db2 -l db2output.log -f crtbl_int32col.sql
echo "#	Running crtbl_int32def.sql..."
db2 -l db2output.log -f crtbl_int32def.sql
echo "#	Running crtbl_int32typ.sql..."
db2 -l db2output.log -f crtbl_int32typ.sql
echo "#	Running crtbl_int64col.sql..."
db2 -l db2output.log -f crtbl_int64col.sql
echo "#	Running crtbl_int64def.sql..."
db2 -l db2output.log -f crtbl_int64def.sql
echo "#	Running crtbl_int64typ.sql..."
db2 -l db2output.log -f crtbl_int64typ.sql
echo "#	Running crtbl_licn.sql..."
db2 -l db2output.log -f crtbl_licn.sql
echo "#	Running crtbl_loadbehav.sql..."
db2 -l db2output.log -f crtbl_loadbehav.sql
echo "#	Running crtbl_mjverdef.sql..."
db2 -l db2output.log -f crtbl_mjverdef.sql
echo "#	Running crtbl_mimetype.sql..."
db2 -l db2output.log -f crtbl_mimetype.sql
echo "#	Running crtbl_mnverdef.sql..."
db2 -l db2output.log -f crtbl_mnverdef.sql
echo "#	Running crtbl_nmtkncol.sql..."
db2 -l db2output.log -f crtbl_nmtkncol.sql
echo "#	Running crtbl_nmtkndef.sql..."
db2 -l db2output.log -f crtbl_nmtkndef.sql
echo "#	Running crtbl_nmtkntyp.sql..."
db2 -l db2output.log -f crtbl_nmtkntyp.sql
echo "#	Running crtbl_nmtknscol.sql..."
db2 -l db2output.log -f crtbl_nmtknscol.sql
echo "#	Running crtbl_nmtknsdef.sql..."
db2 -l db2output.log -f crtbl_nmtknsdef.sql
echo "#	Running crtbl_nmtknstyp.sql..."
db2 -l db2output.log -f crtbl_nmtknstyp.sql
echo "#	Running crtbl_numcol.sql..."
db2 -l db2output.log -f crtbl_numcol.sql
echo "#	Running crtbl_numdef.sql..."
db2 -l db2output.log -f crtbl_numdef.sql
echo "#	Running crtbl_numtyp.sql..."
db2 -l db2output.log -f crtbl_numtyp.sql
echo "#	Running crtbl_srvprm.sql..."
db2 -l db2output.log -f crtbl_srvprm.sql
echo "#	Running crtbl_pop_dep.sql..."
db2 -l db2output.log -f crtbl_pop_dep.sql
echo "#	Running crtbl_popsubdep1.sql..."
db2 -l db2output.log -f crtbl_popsubdep1.sql
echo "#	Running crtbl_popsubdep2.sql..."
db2 -l db2output.log -f crtbl_popsubdep2.sql
echo "#	Running crtbl_popsubdep3.sql..."
db2 -l db2output.log -f crtbl_popsubdep3.sql
echo "#	Running crtbl_pop_topdep.sql..."
db2 -l db2output.log -f crtbl_pop_topdep.sql
echo "#	Running crtbl_bprjdef.sql..."
db2 -l db2output.log -f crtbl_bprjdef.sql
echo "#	Running crtbl_rprjdef.sql..."
db2 -l db2output.log -f crtbl_rprjdef.sql
echo "#	Running crtbl_reldef.sql..."
db2 -l db2output.log -f crtbl_reldef.sql
echo "#	Running crtbl_relcol.sql..."
db2 -l db2output.log -f crtbl_relcol.sql
echo "#	Running crtbl_rel_type.sql..."
db2 -l db2output.log -f crtbl_rel_type.sql
echo "#	Running crtbl_schemadef.sql..."
db2 -l db2output.log -f crtbl_schemadef.sql
echo "#	Running crtbl_schema_ref.sql..."
db2 -l db2output.log -f crtbl_schema_ref.sql
echo "#	Running crtbl_scopedef.sql..."
db2 -l db2output.log -f crtbl_scopedef.sql
echo "#	Running crtbl_secdev.sql..."
db2 -l db2output.log -f crtbl_secdev.sql
echo "#	Running crtbl_secscope.sql..."
db2 -l db2output.log -f crtbl_secscope.sql
echo "#	Running crtbl_srvlfunc.sql..."
db2 -l db2output.log -f crtbl_srvlfunc.sql
echo "#	Running crtbl_srvmeth.sql..."
db2 -l db2output.log -f crtbl_srvmeth.sql
echo "#	Running crtbl_srvofunc.sql..."
db2 -l db2output.log -f crtbl_srvofunc.sql
echo "#	Running crtbl_srvprc.sql..."
db2 -l db2output.log -f crtbl_srvprc.sql
echo "#	Running crtbl_hostsvc.sql..."
db2 -l db2output.log -f crtbl_hostsvc.sql
echo "#	Running crtbl_svctype.sql..."
db2 -l db2output.log -f crtbl_svctype.sql
echo "#	Running crtbl_strcol.sql..."
db2 -l db2output.log -f crtbl_strcol.sql
echo "#	Running crtbl_strdef.sql..."
db2 -l db2output.log -f crtbl_strdef.sql
echo "#	Running crtbl_strtyp.sql..."
db2 -l db2output.log -f crtbl_strtyp.sql
echo "#	Running crtbl_sprjdef.sql..."
db2 -l db2output.log -f crtbl_sprjdef.sql
echo "#	Running crtbl_sysclus.sql..."
db2 -l db2output.log -f crtbl_sysclus.sql
echo "#	Running crtbl_tsecgrp.sql..."
db2 -l db2output.log -f crtbl_tsecgrp.sql
echo "#	Running crtbl_tsecinc.sql..."
db2 -l db2output.log -f crtbl_tsecinc.sql
echo "#	Running crtbl_tsecmemb.sql..."
db2 -l db2output.log -f crtbl_tsecmemb.sql
echo "#	Running crtbl_dzcol.sql..."
db2 -l db2output.log -f crtbl_dzcol.sql
echo "#	Running crtbl_dzdef.sql..."
db2 -l db2output.log -f crtbl_dzdef.sql
echo "#	Running crtbl_dztyp.sql..."
db2 -l db2output.log -f crtbl_dztyp.sql
echo "#	Running crtbl_tmzcol.sql..."
db2 -l db2output.log -f crtbl_tmzcol.sql
echo "#	Running crtbl_tmzdef.sql..."
db2 -l db2output.log -f crtbl_tmzdef.sql
echo "#	Running crtbl_tmztyp.sql..."
db2 -l db2output.log -f crtbl_tmztyp.sql
echo "#	Running crtbl_zscol.sql..."
db2 -l db2output.log -f crtbl_zscol.sql
echo "#	Running crtbl_zsdef.sql..."
db2 -l db2output.log -f crtbl_zsdef.sql
echo "#	Running crtbl_zstyp.sql..."
db2 -l db2output.log -f crtbl_zstyp.sql
echo "#	Running crtbl_tbldef.sql..."
db2 -l db2output.log -f crtbl_tbldef.sql
echo "#	Running crtbl_tblcol.sql..."
db2 -l db2output.log -f crtbl_tblcol.sql
echo "#	Running crtbl_txtcol.sql..."
db2 -l db2output.log -f crtbl_txtcol.sql
echo "#	Running crtbl_txtdef.sql..."
db2 -l db2output.log -f crtbl_txtdef.sql
echo "#	Running crtbl_txttyp.sql..."
db2 -l db2output.log -f crtbl_txttyp.sql
echo "#	Running crtbl_tmcol.sql..."
db2 -l db2output.log -f crtbl_tmcol.sql
echo "#	Running crtbl_tmdef.sql..."
db2 -l db2output.log -f crtbl_tmdef.sql
echo "#	Running crtbl_tmtyp.sql..."
db2 -l db2output.log -f crtbl_tmtyp.sql
echo "#	Running crtbl_tscol.sql..."
db2 -l db2output.log -f crtbl_tscol.sql
echo "#	Running crtbl_tsdef.sql..."
db2 -l db2output.log -f crtbl_tsdef.sql
echo "#	Running crtbl_tstyp.sql..."
db2 -l db2output.log -f crtbl_tstyp.sql
echo "#	Running crtbl_tlddef.sql..."
db2 -l db2output.log -f crtbl_tlddef.sql
echo "#	Running crtbl_tkncol.sql..."
db2 -l db2output.log -f crtbl_tkncol.sql
echo "#	Running crtbl_tkndef.sql..."
db2 -l db2output.log -f crtbl_tkndef.sql
echo "#	Running crtbl_tkntyp.sql..."
db2 -l db2output.log -f crtbl_tkntyp.sql
echo "#	Running crtbl_tdomdef.sql..."
db2 -l db2output.log -f crtbl_tdomdef.sql
echo "#	Running crtbl_tprjdef.sql..."
db2 -l db2output.log -f crtbl_tprjdef.sql
echo "#	Running crtbl_uint16col.sql..."
db2 -l db2output.log -f crtbl_uint16col.sql
echo "#	Running crtbl_u16def.sql..."
db2 -l db2output.log -f crtbl_u16def.sql
echo "#	Running crtbl_uint16typ.sql..."
db2 -l db2output.log -f crtbl_uint16typ.sql
echo "#	Running crtbl_uint32col.sql..."
db2 -l db2output.log -f crtbl_uint32col.sql
echo "#	Running crtbl_u32def.sql..."
db2 -l db2output.log -f crtbl_u32def.sql
echo "#	Running crtbl_uint32typ.sql..."
db2 -l db2output.log -f crtbl_uint32typ.sql
echo "#	Running crtbl_uint64col.sql..."
db2 -l db2output.log -f crtbl_uint64col.sql
echo "#	Running crtbl_u64def.sql..."
db2 -l db2output.log -f crtbl_u64def.sql
echo "#	Running crtbl_uint64typ.sql..."
db2 -l db2output.log -f crtbl_uint64typ.sql
echo "#	Running crtbl_urlproto.sql..."
db2 -l db2output.log -f crtbl_urlproto.sql
echo "#	Running crtbl_uuidcol.sql..."
db2 -l db2output.log -f crtbl_uuidcol.sql
echo "#	Running crtbl_uuiddef.sql..."
db2 -l db2output.log -f crtbl_uuiddef.sql
echo "#	Running crtbl_idguuid.sql..."
db2 -l db2output.log -f crtbl_idguuid.sql
echo "#	Running crtbl_uuidtyp.sql..."
db2 -l db2output.log -f crtbl_uuidtyp.sql
echo "#	Running crtbl_valdef.sql..."
db2 -l db2output.log -f crtbl_valdef.sql
echo "#	Running crtbl_verndef.sql..."
db2 -l db2output.log -f crtbl_verndef.sql
echo "#	Running crtbl_atomdef_h.sql..."
db2 -l db2output.log -f crtbl_atomdef_h.sql
echo "#	Running crtbl_blbcol_h.sql..."
db2 -l db2output.log -f crtbl_blbcol_h.sql
echo "#	Running crtbl_blbdef_h.sql..."
db2 -l db2output.log -f crtbl_blbdef_h.sql
echo "#	Running crtbl_blbtyp_h.sql..."
db2 -l db2output.log -f crtbl_blbtyp_h.sql
echo "#	Running crtbl_boolcol_h.sql..."
db2 -l db2output.log -f crtbl_boolcol_h.sql
echo "#	Running crtbl_booldef_h.sql..."
db2 -l db2output.log -f crtbl_booldef_h.sql
echo "#	Running crtbl_booltyp_h.sql..."
db2 -l db2output.log -f crtbl_booltyp_h.sql
echo "#	Running crtbl_chain_def_h.sql..."
db2 -l db2output.log -f crtbl_chain_def_h.sql
echo "#	Running crtbl_clr_dep_h.sql..."
db2 -l db2output.log -f crtbl_clr_dep_h.sql
echo "#	Running crtbl_clrsubdep1_h.sql..."
db2 -l db2output.log -f crtbl_clrsubdep1_h.sql
echo "#	Running crtbl_clrsubdep2_h.sql..."
db2 -l db2output.log -f crtbl_clrsubdep2_h.sql
echo "#	Running crtbl_clrsubdep3_h.sql..."
db2 -l db2output.log -f crtbl_clrsubdep3_h.sql
echo "#	Running crtbl_clr_topdep_h.sql..."
db2 -l db2output.log -f crtbl_clr_topdep_h.sql
echo "#	Running crtbl_clus_h.sql..."
db2 -l db2output.log -f crtbl_clus_h.sql
echo "#	Running crtbl_dtcol_h.sql..."
db2 -l db2output.log -f crtbl_dtcol_h.sql
echo "#	Running crtbl_dtdef_h.sql..."
db2 -l db2output.log -f crtbl_dtdef_h.sql
echo "#	Running crtbl_dttyp_h.sql..."
db2 -l db2output.log -f crtbl_dttyp_h.sql
echo "#	Running crtbl_del_dep_h.sql..."
db2 -l db2output.log -f crtbl_del_dep_h.sql
echo "#	Running crtbl_delsubdep1_h.sql..."
db2 -l db2output.log -f crtbl_delsubdep1_h.sql
echo "#	Running crtbl_delsubdep2_h.sql..."
db2 -l db2output.log -f crtbl_delsubdep2_h.sql
echo "#	Running crtbl_delsubdep3_h.sql..."
db2 -l db2output.log -f crtbl_delsubdep3_h.sql
echo "#	Running crtbl_del_topdep_h.sql..."
db2 -l db2output.log -f crtbl_del_topdep_h.sql
echo "#	Running crtbl_domdef_h.sql..."
db2 -l db2output.log -f crtbl_domdef_h.sql
echo "#	Running crtbl_bdomdef_h.sql..."
db2 -l db2output.log -f crtbl_bdomdef_h.sql
echo "#	Running crtbl_dblcol_h.sql..."
db2 -l db2output.log -f crtbl_dblcol_h.sql
echo "#	Running crtbl_dbldef_h.sql..."
db2 -l db2output.log -f crtbl_dbldef_h.sql
echo "#	Running crtbl_dbltyp_h.sql..."
db2 -l db2output.log -f crtbl_dbltyp_h.sql
echo "#	Running crtbl_enumcol_h.sql..."
db2 -l db2output.log -f crtbl_enumcol_h.sql
echo "#	Running crtbl_enumdef_h.sql..."
db2 -l db2output.log -f crtbl_enumdef_h.sql
echo "#	Running crtbl_enum_tag_h.sql..."
db2 -l db2output.log -f crtbl_enum_tag_h.sql
echo "#	Running crtbl_enumtyp_h.sql..."
db2 -l db2output.log -f crtbl_enumtyp_h.sql
echo "#	Running crtbl_fltcol_h.sql..."
db2 -l db2output.log -f crtbl_fltcol_h.sql
echo "#	Running crtbl_fltdef_h.sql..."
db2 -l db2output.log -f crtbl_fltdef_h.sql
echo "#	Running crtbl_flttyp_h.sql..."
db2 -l db2output.log -f crtbl_flttyp_h.sql
echo "#	Running crtbl_hostnode_h.sql..."
db2 -l db2output.log -f crtbl_hostnode_h.sql
echo "#	Running crtbl_iso_cntry_h.sql..."
db2 -l db2output.log -f crtbl_iso_cntry_h.sql
echo "#	Running crtbl_iso_cntryccy_h.sql..."
db2 -l db2output.log -f crtbl_iso_cntryccy_h.sql
echo "#	Running crtbl_iso_cntrylng_h.sql..."
db2 -l db2output.log -f crtbl_iso_cntrylng_h.sql
echo "#	Running crtbl_iso_ccy_h.sql..."
db2 -l db2output.log -f crtbl_iso_ccy_h.sql
echo "#	Running crtbl_iso_lang_h.sql..."
db2 -l db2output.log -f crtbl_iso_lang_h.sql
echo "#	Running crtbl_isotz_h.sql..."
db2 -l db2output.log -f crtbl_isotz_h.sql
echo "#	Running crtbl_idg16_h.sql..."
db2 -l db2output.log -f crtbl_idg16_h.sql
echo "#	Running crtbl_idg32_h.sql..."
db2 -l db2output.log -f crtbl_idg32_h.sql
echo "#	Running crtbl_idg64_h.sql..."
db2 -l db2output.log -f crtbl_idg64_h.sql
echo "#	Running crtbl_idxdef_h.sql..."
db2 -l db2output.log -f crtbl_idxdef_h.sql
echo "#	Running crtbl_idxcol_h.sql..."
db2 -l db2output.log -f crtbl_idxcol_h.sql
echo "#	Running crtbl_int16col_h.sql..."
db2 -l db2output.log -f crtbl_int16col_h.sql
echo "#	Running crtbl_int16def_h.sql..."
db2 -l db2output.log -f crtbl_int16def_h.sql
echo "#	Running crtbl_int16typ_h.sql..."
db2 -l db2output.log -f crtbl_int16typ_h.sql
echo "#	Running crtbl_int32col_h.sql..."
db2 -l db2output.log -f crtbl_int32col_h.sql
echo "#	Running crtbl_int32def_h.sql..."
db2 -l db2output.log -f crtbl_int32def_h.sql
echo "#	Running crtbl_int32typ_h.sql..."
db2 -l db2output.log -f crtbl_int32typ_h.sql
echo "#	Running crtbl_int64col_h.sql..."
db2 -l db2output.log -f crtbl_int64col_h.sql
echo "#	Running crtbl_int64def_h.sql..."
db2 -l db2output.log -f crtbl_int64def_h.sql
echo "#	Running crtbl_int64typ_h.sql..."
db2 -l db2output.log -f crtbl_int64typ_h.sql
echo "#	Running crtbl_mjverdef_h.sql..."
db2 -l db2output.log -f crtbl_mjverdef_h.sql
echo "#	Running crtbl_mimetype_h.sql..."
db2 -l db2output.log -f crtbl_mimetype_h.sql
echo "#	Running crtbl_mnverdef_h.sql..."
db2 -l db2output.log -f crtbl_mnverdef_h.sql
echo "#	Running crtbl_nmtkncol_h.sql..."
db2 -l db2output.log -f crtbl_nmtkncol_h.sql
echo "#	Running crtbl_nmtkndef_h.sql..."
db2 -l db2output.log -f crtbl_nmtkndef_h.sql
echo "#	Running crtbl_nmtkntyp_h.sql..."
db2 -l db2output.log -f crtbl_nmtkntyp_h.sql
echo "#	Running crtbl_nmtknscol_h.sql..."
db2 -l db2output.log -f crtbl_nmtknscol_h.sql
echo "#	Running crtbl_nmtknsdef_h.sql..."
db2 -l db2output.log -f crtbl_nmtknsdef_h.sql
echo "#	Running crtbl_nmtknstyp_h.sql..."
db2 -l db2output.log -f crtbl_nmtknstyp_h.sql
echo "#	Running crtbl_numcol_h.sql..."
db2 -l db2output.log -f crtbl_numcol_h.sql
echo "#	Running crtbl_numdef_h.sql..."
db2 -l db2output.log -f crtbl_numdef_h.sql
echo "#	Running crtbl_numtyp_h.sql..."
db2 -l db2output.log -f crtbl_numtyp_h.sql
echo "#	Running crtbl_srvprm_h.sql..."
db2 -l db2output.log -f crtbl_srvprm_h.sql
echo "#	Running crtbl_pop_dep_h.sql..."
db2 -l db2output.log -f crtbl_pop_dep_h.sql
echo "#	Running crtbl_popsubdep1_h.sql..."
db2 -l db2output.log -f crtbl_popsubdep1_h.sql
echo "#	Running crtbl_popsubdep2_h.sql..."
db2 -l db2output.log -f crtbl_popsubdep2_h.sql
echo "#	Running crtbl_popsubdep3_h.sql..."
db2 -l db2output.log -f crtbl_popsubdep3_h.sql
echo "#	Running crtbl_pop_topdep_h.sql..."
db2 -l db2output.log -f crtbl_pop_topdep_h.sql
echo "#	Running crtbl_bprjdef_h.sql..."
db2 -l db2output.log -f crtbl_bprjdef_h.sql
echo "#	Running crtbl_rprjdef_h.sql..."
db2 -l db2output.log -f crtbl_rprjdef_h.sql
echo "#	Running crtbl_reldef_h.sql..."
db2 -l db2output.log -f crtbl_reldef_h.sql
echo "#	Running crtbl_relcol_h.sql..."
db2 -l db2output.log -f crtbl_relcol_h.sql
echo "#	Running crtbl_schemadef_h.sql..."
db2 -l db2output.log -f crtbl_schemadef_h.sql
echo "#	Running crtbl_schema_ref_h.sql..."
db2 -l db2output.log -f crtbl_schema_ref_h.sql
echo "#	Running crtbl_scopedef_h.sql..."
db2 -l db2output.log -f crtbl_scopedef_h.sql
echo "#	Running crtbl_secapp_h.sql..."
db2 -l db2output.log -f crtbl_secapp_h.sql
echo "#	Running crtbl_secdev_h.sql..."
db2 -l db2output.log -f crtbl_secdev_h.sql
echo "#	Running crtbl_secform_h.sql..."
db2 -l db2output.log -f crtbl_secform_h.sql
echo "#	Running crtbl_secgrp_h.sql..."
db2 -l db2output.log -f crtbl_secgrp_h.sql
echo "#	Running crtbl_secgrpfrm_h.sql..."
db2 -l db2output.log -f crtbl_secgrpfrm_h.sql
echo "#	Running crtbl_secinc_h.sql..."
db2 -l db2output.log -f crtbl_secinc_h.sql
echo "#	Running crtbl_secmemb_h.sql..."
db2 -l db2output.log -f crtbl_secmemb_h.sql
echo "#	Running crtbl_secuser_h.sql..."
db2 -l db2output.log -f crtbl_secuser_h.sql
echo "#	Running crtbl_srvlfunc_h.sql..."
db2 -l db2output.log -f crtbl_srvlfunc_h.sql
echo "#	Running crtbl_srvmeth_h.sql..."
db2 -l db2output.log -f crtbl_srvmeth_h.sql
echo "#	Running crtbl_srvofunc_h.sql..."
db2 -l db2output.log -f crtbl_srvofunc_h.sql
echo "#	Running crtbl_srvprc_h.sql..."
db2 -l db2output.log -f crtbl_srvprc_h.sql
echo "#	Running crtbl_hostsvc_h.sql..."
db2 -l db2output.log -f crtbl_hostsvc_h.sql
echo "#	Running crtbl_svctype_h.sql..."
db2 -l db2output.log -f crtbl_svctype_h.sql
echo "#	Running crtbl_strcol_h.sql..."
db2 -l db2output.log -f crtbl_strcol_h.sql
echo "#	Running crtbl_strdef_h.sql..."
db2 -l db2output.log -f crtbl_strdef_h.sql
echo "#	Running crtbl_strtyp_h.sql..."
db2 -l db2output.log -f crtbl_strtyp_h.sql
echo "#	Running crtbl_sprjdef_h.sql..."
db2 -l db2output.log -f crtbl_sprjdef_h.sql
echo "#	Running crtbl_tsecgrp_h.sql..."
db2 -l db2output.log -f crtbl_tsecgrp_h.sql
echo "#	Running crtbl_tsecinc_h.sql..."
db2 -l db2output.log -f crtbl_tsecinc_h.sql
echo "#	Running crtbl_tsecmemb_h.sql..."
db2 -l db2output.log -f crtbl_tsecmemb_h.sql
echo "#	Running crtbl_dzcol_h.sql..."
db2 -l db2output.log -f crtbl_dzcol_h.sql
echo "#	Running crtbl_dzdef_h.sql..."
db2 -l db2output.log -f crtbl_dzdef_h.sql
echo "#	Running crtbl_dztyp_h.sql..."
db2 -l db2output.log -f crtbl_dztyp_h.sql
echo "#	Running crtbl_tmzcol_h.sql..."
db2 -l db2output.log -f crtbl_tmzcol_h.sql
echo "#	Running crtbl_tmzdef_h.sql..."
db2 -l db2output.log -f crtbl_tmzdef_h.sql
echo "#	Running crtbl_tmztyp_h.sql..."
db2 -l db2output.log -f crtbl_tmztyp_h.sql
echo "#	Running crtbl_zscol_h.sql..."
db2 -l db2output.log -f crtbl_zscol_h.sql
echo "#	Running crtbl_zsdef_h.sql..."
db2 -l db2output.log -f crtbl_zsdef_h.sql
echo "#	Running crtbl_zstyp_h.sql..."
db2 -l db2output.log -f crtbl_zstyp_h.sql
echo "#	Running crtbl_tbldef_h.sql..."
db2 -l db2output.log -f crtbl_tbldef_h.sql
echo "#	Running crtbl_tblcol_h.sql..."
db2 -l db2output.log -f crtbl_tblcol_h.sql
echo "#	Running crtbl_tenant_h.sql..."
db2 -l db2output.log -f crtbl_tenant_h.sql
echo "#	Running crtbl_txtcol_h.sql..."
db2 -l db2output.log -f crtbl_txtcol_h.sql
echo "#	Running crtbl_txtdef_h.sql..."
db2 -l db2output.log -f crtbl_txtdef_h.sql
echo "#	Running crtbl_txttyp_h.sql..."
db2 -l db2output.log -f crtbl_txttyp_h.sql
echo "#	Running crtbl_tmcol_h.sql..."
db2 -l db2output.log -f crtbl_tmcol_h.sql
echo "#	Running crtbl_tmdef_h.sql..."
db2 -l db2output.log -f crtbl_tmdef_h.sql
echo "#	Running crtbl_tmtyp_h.sql..."
db2 -l db2output.log -f crtbl_tmtyp_h.sql
echo "#	Running crtbl_tscol_h.sql..."
db2 -l db2output.log -f crtbl_tscol_h.sql
echo "#	Running crtbl_tsdef_h.sql..."
db2 -l db2output.log -f crtbl_tsdef_h.sql
echo "#	Running crtbl_tstyp_h.sql..."
db2 -l db2output.log -f crtbl_tstyp_h.sql
echo "#	Running crtbl_tlddef_h.sql..."
db2 -l db2output.log -f crtbl_tlddef_h.sql
echo "#	Running crtbl_tkncol_h.sql..."
db2 -l db2output.log -f crtbl_tkncol_h.sql
echo "#	Running crtbl_tkndef_h.sql..."
db2 -l db2output.log -f crtbl_tkndef_h.sql
echo "#	Running crtbl_tkntyp_h.sql..."
db2 -l db2output.log -f crtbl_tkntyp_h.sql
echo "#	Running crtbl_tdomdef_h.sql..."
db2 -l db2output.log -f crtbl_tdomdef_h.sql
echo "#	Running crtbl_tprjdef_h.sql..."
db2 -l db2output.log -f crtbl_tprjdef_h.sql
echo "#	Running crtbl_uint16col_h.sql..."
db2 -l db2output.log -f crtbl_uint16col_h.sql
echo "#	Running crtbl_u16def_h.sql..."
db2 -l db2output.log -f crtbl_u16def_h.sql
echo "#	Running crtbl_uint16typ_h.sql..."
db2 -l db2output.log -f crtbl_uint16typ_h.sql
echo "#	Running crtbl_uint32col_h.sql..."
db2 -l db2output.log -f crtbl_uint32col_h.sql
echo "#	Running crtbl_u32def_h.sql..."
db2 -l db2output.log -f crtbl_u32def_h.sql
echo "#	Running crtbl_uint32typ_h.sql..."
db2 -l db2output.log -f crtbl_uint32typ_h.sql
echo "#	Running crtbl_uint64col_h.sql..."
db2 -l db2output.log -f crtbl_uint64col_h.sql
echo "#	Running crtbl_u64def_h.sql..."
db2 -l db2output.log -f crtbl_u64def_h.sql
echo "#	Running crtbl_uint64typ_h.sql..."
db2 -l db2output.log -f crtbl_uint64typ_h.sql
echo "#	Running crtbl_urlproto_h.sql..."
db2 -l db2output.log -f crtbl_urlproto_h.sql
echo "#	Running crtbl_uuidcol_h.sql..."
db2 -l db2output.log -f crtbl_uuidcol_h.sql
echo "#	Running crtbl_uuiddef_h.sql..."
db2 -l db2output.log -f crtbl_uuiddef_h.sql
echo "#	Running crtbl_idguuid_h.sql..."
db2 -l db2output.log -f crtbl_idguuid_h.sql
echo "#	Running crtbl_uuidtyp_h.sql..."
db2 -l db2output.log -f crtbl_uuidtyp_h.sql
echo "#	Running crtbl_valdef_h.sql..."
db2 -l db2output.log -f crtbl_valdef_h.sql
echo "#	Running crtbl_verndef_h.sql..."
db2 -l db2output.log -f crtbl_verndef_h.sql

