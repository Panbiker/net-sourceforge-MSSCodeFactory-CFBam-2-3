--
--	@(#) dbcreate/cfbam/db2luw/reorg_cfbam23.sql
--
--	CFBam
--
--	Copyright (c) 2014-2015 Mark Sobkow
--	
--	This program is available as free software under the GNU GPL v3, under
--	the Eclipse Public License 1.0, or under a commercial license from Mark
--	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
--	
--	You should have received copies of the complete license text for
--	GPLv3.txt and EPLv1_0.txt, containing the text
--	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
--	
--	Under the terms of the GPL:
--	
--		This program is free software: you can redistribute it and/or modify
--		it under the terms of the GNU General Public License as published by
--		the Free Software Foundation, either version 3 of the License, or
--		(at your option) any later version.
--	  
--		This program is distributed in the hope that it will be useful,
--		but WITHOUT ANY WARRANTY; without even the implied warranty of
--		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--		GNU General Public License for more details.
--	  
--		You should have received a copy of the GNU General Public License
--		along with this program.  If not, see <http://www.gnu.org/licenses/>.
--	
--	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
--	and licensed under the BSD 3-Clause license as written by xfree86.org:
--	
--	Redistribution and use in source and binary forms, with or without
--	modification, are permitted provided that the following conditions are
--	met:
--	
--	    (1) Redistributions of source code must retain the above copyright
--	    notice, this list of conditions and the following disclaimer. 
--	
--	    (2) Redistributions in binary form must reproduce the above copyright
--	    notice, this list of conditions and the following disclaimer in
--	    the documentation and/or other materials provided with the
--	    distribution.  
--	    
--	    (3)The name of the author may not be used to
--	    endorse or promote products derived from this software without
--	    specific prior written permission.
--	
--	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
--	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
--	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
--	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
--	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
--	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
--	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
--	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
--	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
--	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
--	POSSIBILITY OF SUCH DAMAGE.
--	
--
-- **********************************************************************
--
--	Code manufactured by MSS Code Factory
--

REORG TABLE CFBam23.accfreq index CFBam23.accfreq_pk
REORG TABLE CFBam23.accsec index CFBam23.accsec_pk
REORG TABLE CFBam23.atomdef index CFBam23.atomdef_pk
REORG TABLE CFBam23.AuditAction index CFBam23.AuditAction_pidx
REORG TABLE CFBam23.blbcol index CFBam23.blbcol_pk
REORG TABLE CFBam23.blbdef index CFBam23.blbdef_pk
REORG TABLE CFBam23.blbtyp index CFBam23.blbtyp_pk
REORG TABLE CFBam23.boolcol index CFBam23.boolcol_pk
REORG TABLE CFBam23.booldef index CFBam23.booldef_pk
REORG TABLE CFBam23.booltyp index CFBam23.booltyp_pk
REORG TABLE CFBam23.chain_def index CFBam23.chain_pk
REORG TABLE CFBam23.clr_dep index CFBam23.clrdep_pk
REORG TABLE CFBam23.clrsubdep1 index CFBam23.clrsubdep1_pk
REORG TABLE CFBam23.clrsubdep2 index CFBam23.clrsubdep2_pk
REORG TABLE CFBam23.clrsubdep3 index CFBam23.clrsubdep3_pk
REORG TABLE CFBam23.clr_topdep index CFBam23.clrtop_pk
REORG TABLE CFBam23.clus index CFBam23.cluster_pk
REORG TABLE CFBam23.datascope index CFBam23.datascope_pk
REORG TABLE CFBam23.dtcol index CFBam23.dtcol_pk
REORG TABLE CFBam23.dtdef index CFBam23.dtdef_pk
REORG TABLE CFBam23.dttyp index CFBam23.dttyp_pk
REORG TABLE CFBam23.del_dep index CFBam23.deldep_pk
REORG TABLE CFBam23.delsubdep1 index CFBam23.delsubdep1_pk
REORG TABLE CFBam23.delsubdep2 index CFBam23.delsubdep2_pk
REORG TABLE CFBam23.delsubdep3 index CFBam23.delsubdep3_pk
REORG TABLE CFBam23.del_topdep index CFBam23.deltop_pk
REORG TABLE CFBam23.domdef index CFBam23.domdef_pk
REORG TABLE CFBam23.bdomdef index CFBam23.bdomdef_pk
REORG TABLE CFBam23.dblcol index CFBam23.dblcol_pk
REORG TABLE CFBam23.dbldef index CFBam23.dbldef_pk
REORG TABLE CFBam23.dbltyp index CFBam23.dbltyp_pk
REORG TABLE CFBam23.enumcol index CFBam23.enumcol_pk
REORG TABLE CFBam23.enumdef index CFBam23.enumdef_pk
REORG TABLE CFBam23.enum_tag index CFBam23.enumtag_pk
REORG TABLE CFBam23.enumtyp index CFBam23.enumtyp_pk
REORG TABLE CFBam23.fltcol index CFBam23.fltcol_pk
REORG TABLE CFBam23.fltdef index CFBam23.fltdef_pk
REORG TABLE CFBam23.flttyp index CFBam23.flttyp_pk
REORG TABLE CFBam23.HostNode index CFBam23.HostNode_pidx
REORG TABLE CFBam23.iso_cntry index CFBam23.isocountry_pk
REORG TABLE CFBam23.iso_cntryccy index CFBam23.isocountryccy_pk
REORG TABLE CFBam23.iso_cntrylng index CFBam23.isocountrylang_pk
REORG TABLE CFBam23.iso_ccy index CFBam23.isocurrency_pk
REORG TABLE CFBam23.iso_lang index CFBam23.isolang_pk
REORG TABLE CFBam23.ISOTz index CFBam23.ITz_pidx
REORG TABLE CFBam23.idg16 index CFBam23.idg16_pk
REORG TABLE CFBam23.idg32 index CFBam23.idg32_pk
REORG TABLE CFBam23.idg64 index CFBam23.idg64_pk
REORG TABLE CFBam23.idxdef index CFBam23.idxdef_pk
REORG TABLE CFBam23.idxcol index CFBam23.idxcol_pk
REORG TABLE CFBam23.int16col index CFBam23.int16col_pk
REORG TABLE CFBam23.int16def index CFBam23.int16def_pk
REORG TABLE CFBam23.int16typ index CFBam23.int16typ_pk
REORG TABLE CFBam23.int32col index CFBam23.int32col_pk
REORG TABLE CFBam23.int32def index CFBam23.int32def_pk
REORG TABLE CFBam23.int32typ index CFBam23.int32typ_pk
REORG TABLE CFBam23.int64col index CFBam23.int64col_pk
REORG TABLE CFBam23.int64def index CFBam23.int64def_pk
REORG TABLE CFBam23.int64typ index CFBam23.int64typ_pk
REORG TABLE CFBam23.licn index CFBam23.lic_pk
REORG TABLE CFBam23.loadbehav index CFBam23.loadbehav_pk
REORG TABLE CFBam23.mjverdef index CFBam23.mjverdef_pk
REORG TABLE CFBam23.MimeType index CFBam23.MimeType_pidx
REORG TABLE CFBam23.mnverdef index CFBam23.mnverdef_pk
REORG TABLE CFBam23.nmtkncol index CFBam23.nmtkncol_pk
REORG TABLE CFBam23.nmtkndef index CFBam23.nmtkndef_pk
REORG TABLE CFBam23.nmtkntyp index CFBam23.nmtkntyp_pk
REORG TABLE CFBam23.nmtknscol index CFBam23.nmtknscol_pk
REORG TABLE CFBam23.nmtknsdef index CFBam23.nmtknsdef_pk
REORG TABLE CFBam23.nmtknstyp index CFBam23.nmtknstyp_pk
REORG TABLE CFBam23.numcol index CFBam23.numcol_pk
REORG TABLE CFBam23.numdef index CFBam23.numdef_pk
REORG TABLE CFBam23.numtyp index CFBam23.numtyp_pk
REORG TABLE CFBam23.srvprm index CFBam23.srvprm_pk
REORG TABLE CFBam23.pop_dep index CFBam23.popdep_pk
REORG TABLE CFBam23.popsubdep1 index CFBam23.popsubdep1_pk
REORG TABLE CFBam23.popsubdep2 index CFBam23.popsubdep2_pk
REORG TABLE CFBam23.popsubdep3 index CFBam23.popsubdep3_pk
REORG TABLE CFBam23.pop_topdep index CFBam23.poptop_pk
REORG TABLE CFBam23.bprjdef index CFBam23.bprjdef_pk
REORG TABLE CFBam23.rprjdef index CFBam23.rprjdef_pk
REORG TABLE CFBam23.reldef index CFBam23.reldef_pk
REORG TABLE CFBam23.relcol index CFBam23.relcol_pk
REORG TABLE CFBam23.rel_type index CFBam23.rel_type_pk
REORG TABLE CFBam23.schemadef index CFBam23.schemadef_pk
REORG TABLE CFBam23.schema_ref index CFBam23.schemaref_pk
REORG TABLE CFBam23.scopedef index CFBam23.scopedef_pk
REORG TABLE CFBam23.SecApp index CFBam23.SecApp_pidx
REORG TABLE CFBam23.SecDev index CFBam23.SecDev_pidx
REORG TABLE CFBam23.SecForm index CFBam23.SecForm_pidx
REORG TABLE CFBam23.SecGrp index CFBam23.SecGroup_pidx
REORG TABLE CFBam23.SecGrpFrm index CFBam23.SecGroupForm_pidx
REORG TABLE CFBam23.SecInc index CFBam23.SecInclude_pidx
REORG TABLE CFBam23.SecMemb index CFBam23.SecMember_pidx
REORG TABLE CFBam23.SecSess index CFBam23.Session_pidx
REORG TABLE CFBam23.SecUser index CFBam23.SecUser_pidx
REORG TABLE CFBam23.secscope index CFBam23.secscope_pk
REORG TABLE CFBam23.srvlfunc index CFBam23.srvlfunc_pk
REORG TABLE CFBam23.srvmeth index CFBam23.srvmeth_pk
REORG TABLE CFBam23.srvofunc index CFBam23.srvofunc_pk
REORG TABLE CFBam23.srvprc index CFBam23.srvprc_pk
REORG TABLE CFBam23.HostSvc index CFBam23.Service_pidx
REORG TABLE CFBam23.SvcType index CFBam23.ServiceType_pidx
REORG TABLE CFBam23.strcol index CFBam23.strcol_pk
REORG TABLE CFBam23.strdef index CFBam23.strdef_pk
REORG TABLE CFBam23.strtyp index CFBam23.strtyp_pk
REORG TABLE CFBam23.sprjdef index CFBam23.sprjdef_pk
REORG TABLE CFBam23.sysclus index CFBam23.syscluster_pk
REORG TABLE CFBam23.TSecGrp index CFBam23.TSecGroup_pidx
REORG TABLE CFBam23.TSecInc index CFBam23.TSecInclude_pidx
REORG TABLE CFBam23.TSecMemb index CFBam23.TSecMember_pidx
REORG TABLE CFBam23.dzcol index CFBam23.dzcol_pk
REORG TABLE CFBam23.dzdef index CFBam23.dzdef_pk
REORG TABLE CFBam23.dztyp index CFBam23.dztyp_pk
REORG TABLE CFBam23.tmzcol index CFBam23.tmzcol_pk
REORG TABLE CFBam23.tmzdef index CFBam23.tmzdef_pk
REORG TABLE CFBam23.tmztyp index CFBam23.tmztyp_pk
REORG TABLE CFBam23.zscol index CFBam23.zscol_pk
REORG TABLE CFBam23.zsdef index CFBam23.zsdef_pk
REORG TABLE CFBam23.zstyp index CFBam23.zstyp_pk
REORG TABLE CFBam23.tbldef index CFBam23.tbldef_pk
REORG TABLE CFBam23.tblcol index CFBam23.tblcol_pk
REORG TABLE CFBam23.tenant index CFBam23.tenant_pk
REORG TABLE CFBam23.txtcol index CFBam23.txtcol_pk
REORG TABLE CFBam23.txtdef index CFBam23.txtdef_pk
REORG TABLE CFBam23.txttyp index CFBam23.txttyp_pk
REORG TABLE CFBam23.tmcol index CFBam23.tmcol_pk
REORG TABLE CFBam23.tmdef index CFBam23.tmdef_pk
REORG TABLE CFBam23.tmtyp index CFBam23.tmtyp_pk
REORG TABLE CFBam23.tscol index CFBam23.tscol_pk
REORG TABLE CFBam23.tsdef index CFBam23.tsdef_pk
REORG TABLE CFBam23.tstyp index CFBam23.tstyp_pk
REORG TABLE CFBam23.tlddef index CFBam23.tlddef_pk
REORG TABLE CFBam23.tkncol index CFBam23.tkncol_pk
REORG TABLE CFBam23.tkndef index CFBam23.tkndef_pk
REORG TABLE CFBam23.tkntyp index CFBam23.tkntyp_pk
REORG TABLE CFBam23.tdomdef index CFBam23.tdomdef_pk
REORG TABLE CFBam23.tprjdef index CFBam23.tprjdef_pk
REORG TABLE CFBam23.uint16col index CFBam23.uint16col_pk
REORG TABLE CFBam23.u16def index CFBam23.ui16def_pk
REORG TABLE CFBam23.uint16typ index CFBam23.uint16typ_pk
REORG TABLE CFBam23.uint32col index CFBam23.uint32col_pk
REORG TABLE CFBam23.u32def index CFBam23.ui32def_pk
REORG TABLE CFBam23.uint32typ index CFBam23.uint32typ_pk
REORG TABLE CFBam23.uint64col index CFBam23.uint64col_pk
REORG TABLE CFBam23.u64def index CFBam23.ui64def_pk
REORG TABLE CFBam23.uint64typ index CFBam23.uint64typ_pk
REORG TABLE CFBam23.URLProto index CFBam23.URLProto_pidx
REORG TABLE CFBam23.uuidcol index CFBam23.uuidcol_pk
REORG TABLE CFBam23.uuiddef index CFBam23.uuiddef_pk
REORG TABLE CFBam23.idguuid index CFBam23.idguuid_pk
REORG TABLE CFBam23.uuidtyp index CFBam23.uuidtyp_pk
REORG TABLE CFBam23.valdef index CFBam23.valdef_pk
REORG TABLE CFBam23.verndef index CFBam23.verndef_pk

commit
