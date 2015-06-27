#!/bin/bash
#
#	@(#) dbcreate/cfbam/db2luw/cridx_cfbam23_h.bash
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


echo "#	cridx_atomdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_unameidx.sql
echo "#	cridx_atomdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_valtentidx.sql
echo "#	cridx_atomdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_scopeidx.sql
echo "#	cridx_atomdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_defschemaidx.sql
echo "#	cridx_atomdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_datascopeidx.sql
echo "#	cridx_atomdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_vaccsecidx.sql
echo "#	cridx_atomdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_vaccfreqidx.sql
echo "#	cridx_atomdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_eaccsecidx.sql
echo "#	cridx_atomdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_eaccfreqidx.sql
echo "#	cridx_atomdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_previdx.sql
echo "#	cridx_atomdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_nextidx.sql
echo "#	cridx_atomdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_contprevidx.sql
echo "#	cridx_atomdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_atomdef_h_contnextidx.sql
echo "#	cridx_blbcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_unameidx.sql
echo "#	cridx_blbcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_valtentidx.sql
echo "#	cridx_blbcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_scopeidx.sql
echo "#	cridx_blbcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_defschemaidx.sql
echo "#	cridx_blbcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_datascopeidx.sql
echo "#	cridx_blbcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_vaccsecidx.sql
echo "#	cridx_blbcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_vaccfreqidx.sql
echo "#	cridx_blbcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_eaccsecidx.sql
echo "#	cridx_blbcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_eaccfreqidx.sql
echo "#	cridx_blbcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_previdx.sql
echo "#	cridx_blbcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_nextidx.sql
echo "#	cridx_blbcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_contprevidx.sql
echo "#	cridx_blbcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_contnextidx.sql
echo "#	cridx_blbcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_blbcol_h_tableidx.sql
echo "#	cridx_blbdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_unameidx.sql
echo "#	cridx_blbdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_valtentidx.sql
echo "#	cridx_blbdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_scopeidx.sql
echo "#	cridx_blbdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_defschemaidx.sql
echo "#	cridx_blbdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_datascopeidx.sql
echo "#	cridx_blbdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_vaccsecidx.sql
echo "#	cridx_blbdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_vaccfreqidx.sql
echo "#	cridx_blbdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_eaccsecidx.sql
echo "#	cridx_blbdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_eaccfreqidx.sql
echo "#	cridx_blbdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_previdx.sql
echo "#	cridx_blbdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_nextidx.sql
echo "#	cridx_blbdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_contprevidx.sql
echo "#	cridx_blbdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_blbdef_h_contnextidx.sql
echo "#	cridx_blbtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_unameidx.sql
echo "#	cridx_blbtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_valtentidx.sql
echo "#	cridx_blbtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_scopeidx.sql
echo "#	cridx_blbtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_defschemaidx.sql
echo "#	cridx_blbtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_datascopeidx.sql
echo "#	cridx_blbtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_vaccsecidx.sql
echo "#	cridx_blbtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_vaccfreqidx.sql
echo "#	cridx_blbtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_eaccsecidx.sql
echo "#	cridx_blbtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_eaccfreqidx.sql
echo "#	cridx_blbtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_previdx.sql
echo "#	cridx_blbtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_nextidx.sql
echo "#	cridx_blbtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_contprevidx.sql
echo "#	cridx_blbtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_contnextidx.sql
echo "#	cridx_blbtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_blbtyp_h_schemaidx.sql
echo "#	cridx_boolcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_unameidx.sql
echo "#	cridx_boolcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_valtentidx.sql
echo "#	cridx_boolcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_scopeidx.sql
echo "#	cridx_boolcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_defschemaidx.sql
echo "#	cridx_boolcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_datascopeidx.sql
echo "#	cridx_boolcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_vaccsecidx.sql
echo "#	cridx_boolcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_vaccfreqidx.sql
echo "#	cridx_boolcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_eaccsecidx.sql
echo "#	cridx_boolcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_eaccfreqidx.sql
echo "#	cridx_boolcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_previdx.sql
echo "#	cridx_boolcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_nextidx.sql
echo "#	cridx_boolcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_contprevidx.sql
echo "#	cridx_boolcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_contnextidx.sql
echo "#	cridx_boolcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_boolcol_h_tableidx.sql
echo "#	cridx_booldef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_unameidx.sql
echo "#	cridx_booldef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_valtentidx.sql
echo "#	cridx_booldef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_scopeidx.sql
echo "#	cridx_booldef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_defschemaidx.sql
echo "#	cridx_booldef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_datascopeidx.sql
echo "#	cridx_booldef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_vaccsecidx.sql
echo "#	cridx_booldef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_vaccfreqidx.sql
echo "#	cridx_booldef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_eaccsecidx.sql
echo "#	cridx_booldef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_eaccfreqidx.sql
echo "#	cridx_booldef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_previdx.sql
echo "#	cridx_booldef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_nextidx.sql
echo "#	cridx_booldef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_contprevidx.sql
echo "#	cridx_booldef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_booldef_h_contnextidx.sql
echo "#	cridx_booltyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_unameidx.sql
echo "#	cridx_booltyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_valtentidx.sql
echo "#	cridx_booltyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_scopeidx.sql
echo "#	cridx_booltyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_defschemaidx.sql
echo "#	cridx_booltyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_datascopeidx.sql
echo "#	cridx_booltyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_vaccsecidx.sql
echo "#	cridx_booltyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_vaccfreqidx.sql
echo "#	cridx_booltyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_eaccsecidx.sql
echo "#	cridx_booltyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_eaccfreqidx.sql
echo "#	cridx_booltyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_previdx.sql
echo "#	cridx_booltyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_nextidx.sql
echo "#	cridx_booltyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_contprevidx.sql
echo "#	cridx_booltyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_contnextidx.sql
echo "#	cridx_booltyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_booltyp_h_schemaidx.sql
echo "#	cridx_chain_def_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_tenantidx.sql
echo "#	cridx_chain_def_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_tableidx.sql
echo "#	cridx_chain_def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_defschemaidx.sql
echo "#	cridx_chain_def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_unameidx.sql
echo "#	cridx_chain_def_h_prevrelidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_prevrelidx.sql
echo "#	cridx_chain_def_h_nextrelidx.sql ..."
db2 -l db2output.log -f cridx_chain_def_h_nextrelidx.sql
echo "#	cridx_clr_dep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_clr_dep_h_tenantidx.sql
echo "#	cridx_clr_dep_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_clr_dep_h_tableidx.sql
echo "#	cridx_clrsubdep1_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_h_tenantidx.sql
echo "#	cridx_clrsubdep1_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_h_tableidx.sql
echo "#	cridx_clrsubdep1_h_contcleartopidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_h_contcleartopidx.sql
echo "#	cridx_clrsubdep1_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep1_h_unameidx.sql
echo "#	cridx_clrsubdep2_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_h_tenantidx.sql
echo "#	cridx_clrsubdep2_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_h_tableidx.sql
echo "#	cridx_clrsubdep2_h_contcleardep1idx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_h_contcleardep1idx.sql
echo "#	cridx_clrsubdep2_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep2_h_unameidx.sql
echo "#	cridx_clrsubdep3_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_h_tenantidx.sql
echo "#	cridx_clrsubdep3_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_h_tableidx.sql
echo "#	cridx_clrsubdep3_h_contcleardep2idx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_h_contcleardep2idx.sql
echo "#	cridx_clrsubdep3_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_clrsubdep3_h_unameidx.sql
echo "#	cridx_clr_topdep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_clr_topdep_h_tenantidx.sql
echo "#	cridx_clr_topdep_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_clr_topdep_h_tableidx.sql
echo "#	cridx_clr_topdep_h_conttblidx.sql ..."
db2 -l db2output.log -f cridx_clr_topdep_h_conttblidx.sql
echo "#	cridx_clr_topdep_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_clr_topdep_h_unameidx.sql
echo "#	cridx_clus_h_udomainnameidx.sql ..."
db2 -l db2output.log -f cridx_clus_h_udomainnameidx.sql
echo "#	cridx_clus_h_udescridx.sql ..."
db2 -l db2output.log -f cridx_clus_h_udescridx.sql
echo "#	cridx_dtcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_unameidx.sql
echo "#	cridx_dtcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_valtentidx.sql
echo "#	cridx_dtcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_scopeidx.sql
echo "#	cridx_dtcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_defschemaidx.sql
echo "#	cridx_dtcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_datascopeidx.sql
echo "#	cridx_dtcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_vaccsecidx.sql
echo "#	cridx_dtcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_vaccfreqidx.sql
echo "#	cridx_dtcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_eaccsecidx.sql
echo "#	cridx_dtcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_eaccfreqidx.sql
echo "#	cridx_dtcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_previdx.sql
echo "#	cridx_dtcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_nextidx.sql
echo "#	cridx_dtcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_contprevidx.sql
echo "#	cridx_dtcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_contnextidx.sql
echo "#	cridx_dtcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_dtcol_h_tableidx.sql
echo "#	cridx_dtdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_unameidx.sql
echo "#	cridx_dtdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_valtentidx.sql
echo "#	cridx_dtdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_scopeidx.sql
echo "#	cridx_dtdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_defschemaidx.sql
echo "#	cridx_dtdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_datascopeidx.sql
echo "#	cridx_dtdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_vaccsecidx.sql
echo "#	cridx_dtdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_vaccfreqidx.sql
echo "#	cridx_dtdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_eaccsecidx.sql
echo "#	cridx_dtdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_eaccfreqidx.sql
echo "#	cridx_dtdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_previdx.sql
echo "#	cridx_dtdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_nextidx.sql
echo "#	cridx_dtdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_contprevidx.sql
echo "#	cridx_dtdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dtdef_h_contnextidx.sql
echo "#	cridx_dttyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_unameidx.sql
echo "#	cridx_dttyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_valtentidx.sql
echo "#	cridx_dttyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_scopeidx.sql
echo "#	cridx_dttyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_defschemaidx.sql
echo "#	cridx_dttyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_datascopeidx.sql
echo "#	cridx_dttyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_vaccsecidx.sql
echo "#	cridx_dttyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_vaccfreqidx.sql
echo "#	cridx_dttyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_eaccsecidx.sql
echo "#	cridx_dttyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_eaccfreqidx.sql
echo "#	cridx_dttyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_previdx.sql
echo "#	cridx_dttyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_nextidx.sql
echo "#	cridx_dttyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_contprevidx.sql
echo "#	cridx_dttyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_contnextidx.sql
echo "#	cridx_dttyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_dttyp_h_schemaidx.sql
echo "#	cridx_del_dep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_del_dep_h_tenantidx.sql
echo "#	cridx_del_dep_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_del_dep_h_defschemaidx.sql
echo "#	cridx_del_dep_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_del_dep_h_tableidx.sql
echo "#	cridx_delsubdep1_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_h_tenantidx.sql
echo "#	cridx_delsubdep1_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_h_defschemaidx.sql
echo "#	cridx_delsubdep1_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_h_tableidx.sql
echo "#	cridx_delsubdep1_h_contdeltopidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_h_contdeltopidx.sql
echo "#	cridx_delsubdep1_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep1_h_unameidx.sql
echo "#	cridx_delsubdep2_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_h_tenantidx.sql
echo "#	cridx_delsubdep2_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_h_defschemaidx.sql
echo "#	cridx_delsubdep2_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_h_tableidx.sql
echo "#	cridx_delsubdep2_h_contdeldep1idx.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_h_contdeldep1idx.sql
echo "#	cridx_delsubdep2_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep2_h_unameidx.sql
echo "#	cridx_delsubdep3_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_h_tenantidx.sql
echo "#	cridx_delsubdep3_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_h_defschemaidx.sql
echo "#	cridx_delsubdep3_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_h_tableidx.sql
echo "#	cridx_delsubdep3_h_contdeldep2idx.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_h_contdeldep2idx.sql
echo "#	cridx_delsubdep3_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_delsubdep3_h_unameidx.sql
echo "#	cridx_del_topdep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_del_topdep_h_tenantidx.sql
echo "#	cridx_del_topdep_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_del_topdep_h_defschemaidx.sql
echo "#	cridx_del_topdep_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_del_topdep_h_tableidx.sql
echo "#	cridx_del_topdep_h_conttblidx.sql ..."
db2 -l db2output.log -f cridx_del_topdep_h_conttblidx.sql
echo "#	cridx_del_topdep_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_del_topdep_h_unameidx.sql
echo "#	cridx_domdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_domdef_h_tenantidx.sql
echo "#	cridx_domdef_h_subdomidx.sql ..."
db2 -l db2output.log -f cridx_domdef_h_subdomidx.sql
echo "#	cridx_domdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_domdef_h_nameidx.sql
echo "#	cridx_bdomdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_bdomdef_h_tenantidx.sql
echo "#	cridx_dblcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_unameidx.sql
echo "#	cridx_dblcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_valtentidx.sql
echo "#	cridx_dblcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_scopeidx.sql
echo "#	cridx_dblcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_defschemaidx.sql
echo "#	cridx_dblcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_datascopeidx.sql
echo "#	cridx_dblcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_vaccsecidx.sql
echo "#	cridx_dblcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_vaccfreqidx.sql
echo "#	cridx_dblcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_eaccsecidx.sql
echo "#	cridx_dblcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_eaccfreqidx.sql
echo "#	cridx_dblcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_previdx.sql
echo "#	cridx_dblcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_nextidx.sql
echo "#	cridx_dblcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_contprevidx.sql
echo "#	cridx_dblcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_contnextidx.sql
echo "#	cridx_dblcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_dblcol_h_tableidx.sql
echo "#	cridx_dbldef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_unameidx.sql
echo "#	cridx_dbldef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_valtentidx.sql
echo "#	cridx_dbldef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_scopeidx.sql
echo "#	cridx_dbldef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_defschemaidx.sql
echo "#	cridx_dbldef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_datascopeidx.sql
echo "#	cridx_dbldef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_vaccsecidx.sql
echo "#	cridx_dbldef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_vaccfreqidx.sql
echo "#	cridx_dbldef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_eaccsecidx.sql
echo "#	cridx_dbldef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_eaccfreqidx.sql
echo "#	cridx_dbldef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_previdx.sql
echo "#	cridx_dbldef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_nextidx.sql
echo "#	cridx_dbldef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_contprevidx.sql
echo "#	cridx_dbldef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dbldef_h_contnextidx.sql
echo "#	cridx_dbltyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_unameidx.sql
echo "#	cridx_dbltyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_valtentidx.sql
echo "#	cridx_dbltyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_scopeidx.sql
echo "#	cridx_dbltyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_defschemaidx.sql
echo "#	cridx_dbltyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_datascopeidx.sql
echo "#	cridx_dbltyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_vaccsecidx.sql
echo "#	cridx_dbltyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_vaccfreqidx.sql
echo "#	cridx_dbltyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_eaccsecidx.sql
echo "#	cridx_dbltyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_eaccfreqidx.sql
echo "#	cridx_dbltyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_previdx.sql
echo "#	cridx_dbltyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_nextidx.sql
echo "#	cridx_dbltyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_contprevidx.sql
echo "#	cridx_dbltyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_contnextidx.sql
echo "#	cridx_dbltyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_dbltyp_h_schemaidx.sql
echo "#	cridx_enumcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_unameidx.sql
echo "#	cridx_enumcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_valtentidx.sql
echo "#	cridx_enumcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_scopeidx.sql
echo "#	cridx_enumcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_defschemaidx.sql
echo "#	cridx_enumcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_datascopeidx.sql
echo "#	cridx_enumcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_vaccsecidx.sql
echo "#	cridx_enumcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_vaccfreqidx.sql
echo "#	cridx_enumcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_eaccsecidx.sql
echo "#	cridx_enumcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_eaccfreqidx.sql
echo "#	cridx_enumcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_previdx.sql
echo "#	cridx_enumcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_nextidx.sql
echo "#	cridx_enumcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_contprevidx.sql
echo "#	cridx_enumcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_contnextidx.sql
echo "#	cridx_enumcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_enumcol_h_tableidx.sql
echo "#	cridx_enumdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_unameidx.sql
echo "#	cridx_enumdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_valtentidx.sql
echo "#	cridx_enumdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_scopeidx.sql
echo "#	cridx_enumdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_defschemaidx.sql
echo "#	cridx_enumdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_datascopeidx.sql
echo "#	cridx_enumdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_vaccsecidx.sql
echo "#	cridx_enumdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_vaccfreqidx.sql
echo "#	cridx_enumdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_eaccsecidx.sql
echo "#	cridx_enumdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_eaccfreqidx.sql
echo "#	cridx_enumdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_previdx.sql
echo "#	cridx_enumdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_nextidx.sql
echo "#	cridx_enumdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_contprevidx.sql
echo "#	cridx_enumdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_enumdef_h_contnextidx.sql
echo "#	cridx_enum_tag_h_enumtagtenantidx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_enumtagtenantidx.sql
echo "#	cridx_enum_tag_h_enumidx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_enumidx.sql
echo "#	cridx_enum_tag_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_defschemaidx.sql
echo "#	cridx_enum_tag_h_enumnameidx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_enumnameidx.sql
echo "#	cridx_enum_tag_h_previdx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_previdx.sql
echo "#	cridx_enum_tag_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_enum_tag_h_nextidx.sql
echo "#	cridx_enumtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_unameidx.sql
echo "#	cridx_enumtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_valtentidx.sql
echo "#	cridx_enumtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_scopeidx.sql
echo "#	cridx_enumtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_defschemaidx.sql
echo "#	cridx_enumtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_datascopeidx.sql
echo "#	cridx_enumtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_vaccsecidx.sql
echo "#	cridx_enumtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_vaccfreqidx.sql
echo "#	cridx_enumtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_eaccsecidx.sql
echo "#	cridx_enumtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_eaccfreqidx.sql
echo "#	cridx_enumtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_previdx.sql
echo "#	cridx_enumtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_nextidx.sql
echo "#	cridx_enumtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_contprevidx.sql
echo "#	cridx_enumtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_contnextidx.sql
echo "#	cridx_enumtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_enumtyp_h_schemaidx.sql
echo "#	cridx_fltcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_unameidx.sql
echo "#	cridx_fltcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_valtentidx.sql
echo "#	cridx_fltcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_scopeidx.sql
echo "#	cridx_fltcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_defschemaidx.sql
echo "#	cridx_fltcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_datascopeidx.sql
echo "#	cridx_fltcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_vaccsecidx.sql
echo "#	cridx_fltcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_vaccfreqidx.sql
echo "#	cridx_fltcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_eaccsecidx.sql
echo "#	cridx_fltcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_eaccfreqidx.sql
echo "#	cridx_fltcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_previdx.sql
echo "#	cridx_fltcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_nextidx.sql
echo "#	cridx_fltcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_contprevidx.sql
echo "#	cridx_fltcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_contnextidx.sql
echo "#	cridx_fltcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_fltcol_h_tableidx.sql
echo "#	cridx_fltdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_unameidx.sql
echo "#	cridx_fltdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_valtentidx.sql
echo "#	cridx_fltdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_scopeidx.sql
echo "#	cridx_fltdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_defschemaidx.sql
echo "#	cridx_fltdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_datascopeidx.sql
echo "#	cridx_fltdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_vaccsecidx.sql
echo "#	cridx_fltdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_vaccfreqidx.sql
echo "#	cridx_fltdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_eaccsecidx.sql
echo "#	cridx_fltdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_eaccfreqidx.sql
echo "#	cridx_fltdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_previdx.sql
echo "#	cridx_fltdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_nextidx.sql
echo "#	cridx_fltdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_contprevidx.sql
echo "#	cridx_fltdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_fltdef_h_contnextidx.sql
echo "#	cridx_flttyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_unameidx.sql
echo "#	cridx_flttyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_valtentidx.sql
echo "#	cridx_flttyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_scopeidx.sql
echo "#	cridx_flttyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_defschemaidx.sql
echo "#	cridx_flttyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_datascopeidx.sql
echo "#	cridx_flttyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_vaccsecidx.sql
echo "#	cridx_flttyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_vaccfreqidx.sql
echo "#	cridx_flttyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_eaccsecidx.sql
echo "#	cridx_flttyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_eaccfreqidx.sql
echo "#	cridx_flttyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_previdx.sql
echo "#	cridx_flttyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_nextidx.sql
echo "#	cridx_flttyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_contprevidx.sql
echo "#	cridx_flttyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_contnextidx.sql
echo "#	cridx_flttyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_flttyp_h_schemaidx.sql
echo "#	cridx_hostnode_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_hostnode_h_clusteridx.sql
echo "#	cridx_hostnode_h_udescridx.sql ..."
db2 -l db2output.log -f cridx_hostnode_h_udescridx.sql
echo "#	cridx_hostnode_h_hostnameidx.sql ..."
db2 -l db2output.log -f cridx_hostnode_h_hostnameidx.sql
echo "#	cridx_iso_cntry_h_isocodeidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntry_h_isocodeidx.sql
echo "#	cridx_iso_cntry_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntry_h_nameidx.sql
echo "#	cridx_iso_cntryccy_h_countryidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntryccy_h_countryidx.sql
echo "#	cridx_iso_cntryccy_h_currencyidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntryccy_h_currencyidx.sql
echo "#	cridx_iso_cntrylng_h_countryidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntrylng_h_countryidx.sql
echo "#	cridx_iso_cntrylng_h_languageidx.sql ..."
db2 -l db2output.log -f cridx_iso_cntrylng_h_languageidx.sql
echo "#	cridx_iso_ccy_h_ccycdidx.sql ..."
db2 -l db2output.log -f cridx_iso_ccy_h_ccycdidx.sql
echo "#	cridx_iso_ccy_h_ccynmidx.sql ..."
db2 -l db2output.log -f cridx_iso_ccy_h_ccynmidx.sql
echo "#	cridx_iso_lang_h_baseidx.sql ..."
db2 -l db2output.log -f cridx_iso_lang_h_baseidx.sql
echo "#	cridx_iso_lang_h_countryidx.sql ..."
db2 -l db2output.log -f cridx_iso_lang_h_countryidx.sql
echo "#	cridx_iso_lang_h_codeidx.sql ..."
db2 -l db2output.log -f cridx_iso_lang_h_codeidx.sql
echo "#	cridx_isotz_h_offsetidx.sql ..."
db2 -l db2output.log -f cridx_isotz_h_offsetidx.sql
echo "#	cridx_isotz_h_utznameidx.sql ..."
db2 -l db2output.log -f cridx_isotz_h_utznameidx.sql
echo "#	cridx_isotz_h_iso8601idx.sql ..."
db2 -l db2output.log -f cridx_isotz_h_iso8601idx.sql
echo "#	cridx_idg16_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_unameidx.sql
echo "#	cridx_idg16_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_valtentidx.sql
echo "#	cridx_idg16_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_scopeidx.sql
echo "#	cridx_idg16_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_defschemaidx.sql
echo "#	cridx_idg16_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_datascopeidx.sql
echo "#	cridx_idg16_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_vaccsecidx.sql
echo "#	cridx_idg16_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_vaccfreqidx.sql
echo "#	cridx_idg16_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_eaccsecidx.sql
echo "#	cridx_idg16_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_eaccfreqidx.sql
echo "#	cridx_idg16_h_previdx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_previdx.sql
echo "#	cridx_idg16_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_nextidx.sql
echo "#	cridx_idg16_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_contprevidx.sql
echo "#	cridx_idg16_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_contnextidx.sql
echo "#	cridx_idg16_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_schemaidx.sql
echo "#	cridx_idg16_h_dispidx.sql ..."
db2 -l db2output.log -f cridx_idg16_h_dispidx.sql
echo "#	cridx_idg32_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_unameidx.sql
echo "#	cridx_idg32_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_valtentidx.sql
echo "#	cridx_idg32_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_scopeidx.sql
echo "#	cridx_idg32_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_defschemaidx.sql
echo "#	cridx_idg32_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_datascopeidx.sql
echo "#	cridx_idg32_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_vaccsecidx.sql
echo "#	cridx_idg32_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_vaccfreqidx.sql
echo "#	cridx_idg32_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_eaccsecidx.sql
echo "#	cridx_idg32_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_eaccfreqidx.sql
echo "#	cridx_idg32_h_previdx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_previdx.sql
echo "#	cridx_idg32_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_nextidx.sql
echo "#	cridx_idg32_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_contprevidx.sql
echo "#	cridx_idg32_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_contnextidx.sql
echo "#	cridx_idg32_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_schemaidx.sql
echo "#	cridx_idg32_h_dispidx.sql ..."
db2 -l db2output.log -f cridx_idg32_h_dispidx.sql
echo "#	cridx_idg64_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_unameidx.sql
echo "#	cridx_idg64_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_valtentidx.sql
echo "#	cridx_idg64_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_scopeidx.sql
echo "#	cridx_idg64_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_defschemaidx.sql
echo "#	cridx_idg64_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_datascopeidx.sql
echo "#	cridx_idg64_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_vaccsecidx.sql
echo "#	cridx_idg64_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_vaccfreqidx.sql
echo "#	cridx_idg64_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_eaccsecidx.sql
echo "#	cridx_idg64_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_eaccfreqidx.sql
echo "#	cridx_idg64_h_previdx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_previdx.sql
echo "#	cridx_idg64_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_nextidx.sql
echo "#	cridx_idg64_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_contprevidx.sql
echo "#	cridx_idg64_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_contnextidx.sql
echo "#	cridx_idg64_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_schemaidx.sql
echo "#	cridx_idg64_h_dispidx.sql ..."
db2 -l db2output.log -f cridx_idg64_h_dispidx.sql
echo "#	cridx_idxdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_h_tenantidx.sql
echo "#	cridx_idxdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_h_unameidx.sql
echo "#	cridx_idxdef_h_indextenantidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_h_indextenantidx.sql
echo "#	cridx_idxdef_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_h_tableidx.sql
echo "#	cridx_idxdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idxdef_h_defschemaidx.sql
echo "#	cridx_idxcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_unameidx.sql
echo "#	cridx_idxcol_h_idxcoltenantidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_idxcoltenantidx.sql
echo "#	cridx_idxcol_h_indexidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_indexidx.sql
echo "#	cridx_idxcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_defschemaidx.sql
echo "#	cridx_idxcol_h_colidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_colidx.sql
echo "#	cridx_idxcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_previdx.sql
echo "#	cridx_idxcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_nextidx.sql
echo "#	cridx_idxcol_h_idxprevidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_idxprevidx.sql
echo "#	cridx_idxcol_h_idxnextidx.sql ..."
db2 -l db2output.log -f cridx_idxcol_h_idxnextidx.sql
echo "#	cridx_int16col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_unameidx.sql
echo "#	cridx_int16col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_valtentidx.sql
echo "#	cridx_int16col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_scopeidx.sql
echo "#	cridx_int16col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_defschemaidx.sql
echo "#	cridx_int16col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_datascopeidx.sql
echo "#	cridx_int16col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_vaccsecidx.sql
echo "#	cridx_int16col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_vaccfreqidx.sql
echo "#	cridx_int16col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_eaccsecidx.sql
echo "#	cridx_int16col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_eaccfreqidx.sql
echo "#	cridx_int16col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_previdx.sql
echo "#	cridx_int16col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_nextidx.sql
echo "#	cridx_int16col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_contprevidx.sql
echo "#	cridx_int16col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_contnextidx.sql
echo "#	cridx_int16col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_int16col_h_tableidx.sql
echo "#	cridx_int16def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_unameidx.sql
echo "#	cridx_int16def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_valtentidx.sql
echo "#	cridx_int16def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_scopeidx.sql
echo "#	cridx_int16def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_defschemaidx.sql
echo "#	cridx_int16def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_datascopeidx.sql
echo "#	cridx_int16def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_vaccsecidx.sql
echo "#	cridx_int16def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_vaccfreqidx.sql
echo "#	cridx_int16def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_eaccsecidx.sql
echo "#	cridx_int16def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_eaccfreqidx.sql
echo "#	cridx_int16def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_previdx.sql
echo "#	cridx_int16def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_nextidx.sql
echo "#	cridx_int16def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_contprevidx.sql
echo "#	cridx_int16def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int16def_h_contnextidx.sql
echo "#	cridx_int16typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_unameidx.sql
echo "#	cridx_int16typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_valtentidx.sql
echo "#	cridx_int16typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_scopeidx.sql
echo "#	cridx_int16typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_defschemaidx.sql
echo "#	cridx_int16typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_datascopeidx.sql
echo "#	cridx_int16typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_vaccsecidx.sql
echo "#	cridx_int16typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_vaccfreqidx.sql
echo "#	cridx_int16typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_eaccsecidx.sql
echo "#	cridx_int16typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_eaccfreqidx.sql
echo "#	cridx_int16typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_previdx.sql
echo "#	cridx_int16typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_nextidx.sql
echo "#	cridx_int16typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_contprevidx.sql
echo "#	cridx_int16typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_contnextidx.sql
echo "#	cridx_int16typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_int16typ_h_schemaidx.sql
echo "#	cridx_int32col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_unameidx.sql
echo "#	cridx_int32col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_valtentidx.sql
echo "#	cridx_int32col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_scopeidx.sql
echo "#	cridx_int32col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_defschemaidx.sql
echo "#	cridx_int32col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_datascopeidx.sql
echo "#	cridx_int32col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_vaccsecidx.sql
echo "#	cridx_int32col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_vaccfreqidx.sql
echo "#	cridx_int32col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_eaccsecidx.sql
echo "#	cridx_int32col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_eaccfreqidx.sql
echo "#	cridx_int32col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_previdx.sql
echo "#	cridx_int32col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_nextidx.sql
echo "#	cridx_int32col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_contprevidx.sql
echo "#	cridx_int32col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_contnextidx.sql
echo "#	cridx_int32col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_int32col_h_tableidx.sql
echo "#	cridx_int32def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_unameidx.sql
echo "#	cridx_int32def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_valtentidx.sql
echo "#	cridx_int32def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_scopeidx.sql
echo "#	cridx_int32def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_defschemaidx.sql
echo "#	cridx_int32def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_datascopeidx.sql
echo "#	cridx_int32def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_vaccsecidx.sql
echo "#	cridx_int32def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_vaccfreqidx.sql
echo "#	cridx_int32def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_eaccsecidx.sql
echo "#	cridx_int32def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_eaccfreqidx.sql
echo "#	cridx_int32def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_previdx.sql
echo "#	cridx_int32def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_nextidx.sql
echo "#	cridx_int32def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_contprevidx.sql
echo "#	cridx_int32def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int32def_h_contnextidx.sql
echo "#	cridx_int32typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_unameidx.sql
echo "#	cridx_int32typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_valtentidx.sql
echo "#	cridx_int32typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_scopeidx.sql
echo "#	cridx_int32typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_defschemaidx.sql
echo "#	cridx_int32typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_datascopeidx.sql
echo "#	cridx_int32typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_vaccsecidx.sql
echo "#	cridx_int32typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_vaccfreqidx.sql
echo "#	cridx_int32typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_eaccsecidx.sql
echo "#	cridx_int32typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_eaccfreqidx.sql
echo "#	cridx_int32typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_previdx.sql
echo "#	cridx_int32typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_nextidx.sql
echo "#	cridx_int32typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_contprevidx.sql
echo "#	cridx_int32typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_contnextidx.sql
echo "#	cridx_int32typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_int32typ_h_schemaidx.sql
echo "#	cridx_int64col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_unameidx.sql
echo "#	cridx_int64col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_valtentidx.sql
echo "#	cridx_int64col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_scopeidx.sql
echo "#	cridx_int64col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_defschemaidx.sql
echo "#	cridx_int64col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_datascopeidx.sql
echo "#	cridx_int64col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_vaccsecidx.sql
echo "#	cridx_int64col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_vaccfreqidx.sql
echo "#	cridx_int64col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_eaccsecidx.sql
echo "#	cridx_int64col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_eaccfreqidx.sql
echo "#	cridx_int64col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_previdx.sql
echo "#	cridx_int64col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_nextidx.sql
echo "#	cridx_int64col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_contprevidx.sql
echo "#	cridx_int64col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_contnextidx.sql
echo "#	cridx_int64col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_int64col_h_tableidx.sql
echo "#	cridx_int64def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_unameidx.sql
echo "#	cridx_int64def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_valtentidx.sql
echo "#	cridx_int64def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_scopeidx.sql
echo "#	cridx_int64def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_defschemaidx.sql
echo "#	cridx_int64def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_datascopeidx.sql
echo "#	cridx_int64def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_vaccsecidx.sql
echo "#	cridx_int64def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_vaccfreqidx.sql
echo "#	cridx_int64def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_eaccsecidx.sql
echo "#	cridx_int64def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_eaccfreqidx.sql
echo "#	cridx_int64def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_previdx.sql
echo "#	cridx_int64def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_nextidx.sql
echo "#	cridx_int64def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_contprevidx.sql
echo "#	cridx_int64def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int64def_h_contnextidx.sql
echo "#	cridx_int64typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_unameidx.sql
echo "#	cridx_int64typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_valtentidx.sql
echo "#	cridx_int64typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_scopeidx.sql
echo "#	cridx_int64typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_defschemaidx.sql
echo "#	cridx_int64typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_datascopeidx.sql
echo "#	cridx_int64typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_vaccsecidx.sql
echo "#	cridx_int64typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_vaccfreqidx.sql
echo "#	cridx_int64typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_eaccsecidx.sql
echo "#	cridx_int64typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_eaccfreqidx.sql
echo "#	cridx_int64typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_previdx.sql
echo "#	cridx_int64typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_nextidx.sql
echo "#	cridx_int64typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_contprevidx.sql
echo "#	cridx_int64typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_contnextidx.sql
echo "#	cridx_int64typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_int64typ_h_schemaidx.sql
echo "#	cridx_mjverdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_mjverdef_h_tenantidx.sql
echo "#	cridx_mjverdef_h_pprjidx.sql ..."
db2 -l db2output.log -f cridx_mjverdef_h_pprjidx.sql
echo "#	cridx_mjverdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_mjverdef_h_nameidx.sql
echo "#	cridx_mimetype_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_mimetype_h_unameidx.sql
echo "#	cridx_mnverdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_mnverdef_h_tenantidx.sql
echo "#	cridx_mnverdef_h_majoridx.sql ..."
db2 -l db2output.log -f cridx_mnverdef_h_majoridx.sql
echo "#	cridx_mnverdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_mnverdef_h_nameidx.sql
echo "#	cridx_nmtkncol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_unameidx.sql
echo "#	cridx_nmtkncol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_valtentidx.sql
echo "#	cridx_nmtkncol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_scopeidx.sql
echo "#	cridx_nmtkncol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_defschemaidx.sql
echo "#	cridx_nmtkncol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_datascopeidx.sql
echo "#	cridx_nmtkncol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_vaccsecidx.sql
echo "#	cridx_nmtkncol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_vaccfreqidx.sql
echo "#	cridx_nmtkncol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_eaccsecidx.sql
echo "#	cridx_nmtkncol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_eaccfreqidx.sql
echo "#	cridx_nmtkncol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_previdx.sql
echo "#	cridx_nmtkncol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_nextidx.sql
echo "#	cridx_nmtkncol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_contprevidx.sql
echo "#	cridx_nmtkncol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_contnextidx.sql
echo "#	cridx_nmtkncol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_nmtkncol_h_tableidx.sql
echo "#	cridx_nmtkndef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_unameidx.sql
echo "#	cridx_nmtkndef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_valtentidx.sql
echo "#	cridx_nmtkndef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_scopeidx.sql
echo "#	cridx_nmtkndef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_defschemaidx.sql
echo "#	cridx_nmtkndef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_datascopeidx.sql
echo "#	cridx_nmtkndef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_vaccsecidx.sql
echo "#	cridx_nmtkndef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_vaccfreqidx.sql
echo "#	cridx_nmtkndef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_eaccsecidx.sql
echo "#	cridx_nmtkndef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_eaccfreqidx.sql
echo "#	cridx_nmtkndef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_previdx.sql
echo "#	cridx_nmtkndef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_nextidx.sql
echo "#	cridx_nmtkndef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_contprevidx.sql
echo "#	cridx_nmtkndef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkndef_h_contnextidx.sql
echo "#	cridx_nmtkntyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_unameidx.sql
echo "#	cridx_nmtkntyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_valtentidx.sql
echo "#	cridx_nmtkntyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_scopeidx.sql
echo "#	cridx_nmtkntyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_defschemaidx.sql
echo "#	cridx_nmtkntyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_datascopeidx.sql
echo "#	cridx_nmtkntyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_vaccsecidx.sql
echo "#	cridx_nmtkntyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_vaccfreqidx.sql
echo "#	cridx_nmtkntyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_eaccsecidx.sql
echo "#	cridx_nmtkntyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_eaccfreqidx.sql
echo "#	cridx_nmtkntyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_previdx.sql
echo "#	cridx_nmtkntyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_nextidx.sql
echo "#	cridx_nmtkntyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_contprevidx.sql
echo "#	cridx_nmtkntyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_contnextidx.sql
echo "#	cridx_nmtkntyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtkntyp_h_schemaidx.sql
echo "#	cridx_nmtknscol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_unameidx.sql
echo "#	cridx_nmtknscol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_valtentidx.sql
echo "#	cridx_nmtknscol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_scopeidx.sql
echo "#	cridx_nmtknscol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_defschemaidx.sql
echo "#	cridx_nmtknscol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_datascopeidx.sql
echo "#	cridx_nmtknscol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_vaccsecidx.sql
echo "#	cridx_nmtknscol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_vaccfreqidx.sql
echo "#	cridx_nmtknscol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_eaccsecidx.sql
echo "#	cridx_nmtknscol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_eaccfreqidx.sql
echo "#	cridx_nmtknscol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_previdx.sql
echo "#	cridx_nmtknscol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_nextidx.sql
echo "#	cridx_nmtknscol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_contprevidx.sql
echo "#	cridx_nmtknscol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_contnextidx.sql
echo "#	cridx_nmtknscol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_nmtknscol_h_tableidx.sql
echo "#	cridx_nmtknsdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_unameidx.sql
echo "#	cridx_nmtknsdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_valtentidx.sql
echo "#	cridx_nmtknsdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_scopeidx.sql
echo "#	cridx_nmtknsdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_defschemaidx.sql
echo "#	cridx_nmtknsdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_datascopeidx.sql
echo "#	cridx_nmtknsdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_vaccsecidx.sql
echo "#	cridx_nmtknsdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_vaccfreqidx.sql
echo "#	cridx_nmtknsdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_eaccsecidx.sql
echo "#	cridx_nmtknsdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_eaccfreqidx.sql
echo "#	cridx_nmtknsdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_previdx.sql
echo "#	cridx_nmtknsdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_nextidx.sql
echo "#	cridx_nmtknsdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_contprevidx.sql
echo "#	cridx_nmtknsdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknsdef_h_contnextidx.sql
echo "#	cridx_nmtknstyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_unameidx.sql
echo "#	cridx_nmtknstyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_valtentidx.sql
echo "#	cridx_nmtknstyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_scopeidx.sql
echo "#	cridx_nmtknstyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_defschemaidx.sql
echo "#	cridx_nmtknstyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_datascopeidx.sql
echo "#	cridx_nmtknstyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_vaccsecidx.sql
echo "#	cridx_nmtknstyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_vaccfreqidx.sql
echo "#	cridx_nmtknstyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_eaccsecidx.sql
echo "#	cridx_nmtknstyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_eaccfreqidx.sql
echo "#	cridx_nmtknstyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_previdx.sql
echo "#	cridx_nmtknstyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_nextidx.sql
echo "#	cridx_nmtknstyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_contprevidx.sql
echo "#	cridx_nmtknstyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_contnextidx.sql
echo "#	cridx_nmtknstyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_nmtknstyp_h_schemaidx.sql
echo "#	cridx_numcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_unameidx.sql
echo "#	cridx_numcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_valtentidx.sql
echo "#	cridx_numcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_scopeidx.sql
echo "#	cridx_numcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_defschemaidx.sql
echo "#	cridx_numcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_datascopeidx.sql
echo "#	cridx_numcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_vaccsecidx.sql
echo "#	cridx_numcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_vaccfreqidx.sql
echo "#	cridx_numcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_eaccsecidx.sql
echo "#	cridx_numcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_eaccfreqidx.sql
echo "#	cridx_numcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_previdx.sql
echo "#	cridx_numcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_nextidx.sql
echo "#	cridx_numcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_contprevidx.sql
echo "#	cridx_numcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_contnextidx.sql
echo "#	cridx_numcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_numcol_h_tableidx.sql
echo "#	cridx_numdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_unameidx.sql
echo "#	cridx_numdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_valtentidx.sql
echo "#	cridx_numdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_scopeidx.sql
echo "#	cridx_numdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_defschemaidx.sql
echo "#	cridx_numdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_datascopeidx.sql
echo "#	cridx_numdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_vaccsecidx.sql
echo "#	cridx_numdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_vaccfreqidx.sql
echo "#	cridx_numdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_eaccsecidx.sql
echo "#	cridx_numdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_eaccfreqidx.sql
echo "#	cridx_numdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_previdx.sql
echo "#	cridx_numdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_nextidx.sql
echo "#	cridx_numdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_contprevidx.sql
echo "#	cridx_numdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_numdef_h_contnextidx.sql
echo "#	cridx_numtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_unameidx.sql
echo "#	cridx_numtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_valtentidx.sql
echo "#	cridx_numtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_scopeidx.sql
echo "#	cridx_numtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_defschemaidx.sql
echo "#	cridx_numtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_datascopeidx.sql
echo "#	cridx_numtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_vaccsecidx.sql
echo "#	cridx_numtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_vaccfreqidx.sql
echo "#	cridx_numtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_eaccsecidx.sql
echo "#	cridx_numtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_eaccfreqidx.sql
echo "#	cridx_numtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_previdx.sql
echo "#	cridx_numtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_nextidx.sql
echo "#	cridx_numtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_contprevidx.sql
echo "#	cridx_numtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_contnextidx.sql
echo "#	cridx_numtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_numtyp_h_schemaidx.sql
echo "#	cridx_srvprm_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_unameidx.sql
echo "#	cridx_srvprm_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_valtentidx.sql
echo "#	cridx_srvprm_h_servermethodidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_servermethodidx.sql
echo "#	cridx_srvprm_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_defschemaidx.sql
echo "#	cridx_srvprm_h_servertypeidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_servertypeidx.sql
echo "#	cridx_srvprm_h_previdx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_previdx.sql
echo "#	cridx_srvprm_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_nextidx.sql
echo "#	cridx_srvprm_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_contprevidx.sql
echo "#	cridx_srvprm_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_srvprm_h_contnextidx.sql
echo "#	cridx_pop_dep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_pop_dep_h_tenantidx.sql
echo "#	cridx_pop_dep_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_pop_dep_h_relationidx.sql
echo "#	cridx_pop_dep_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_pop_dep_h_defschemaidx.sql
echo "#	cridx_popsubdep1_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_h_tenantidx.sql
echo "#	cridx_popsubdep1_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_h_relationidx.sql
echo "#	cridx_popsubdep1_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_h_defschemaidx.sql
echo "#	cridx_popsubdep1_h_contpoptopidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_h_contpoptopidx.sql
echo "#	cridx_popsubdep1_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep1_h_unameidx.sql
echo "#	cridx_popsubdep2_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_h_tenantidx.sql
echo "#	cridx_popsubdep2_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_h_relationidx.sql
echo "#	cridx_popsubdep2_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_h_defschemaidx.sql
echo "#	cridx_popsubdep2_h_contpopdep1idx.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_h_contpopdep1idx.sql
echo "#	cridx_popsubdep2_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep2_h_unameidx.sql
echo "#	cridx_popsubdep3_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_h_tenantidx.sql
echo "#	cridx_popsubdep3_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_h_relationidx.sql
echo "#	cridx_popsubdep3_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_h_defschemaidx.sql
echo "#	cridx_popsubdep3_h_contpopdep2idx.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_h_contpopdep2idx.sql
echo "#	cridx_popsubdep3_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_popsubdep3_h_unameidx.sql
echo "#	cridx_pop_topdep_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_pop_topdep_h_tenantidx.sql
echo "#	cridx_pop_topdep_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_pop_topdep_h_relationidx.sql
echo "#	cridx_pop_topdep_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_pop_topdep_h_defschemaidx.sql
echo "#	cridx_pop_topdep_h_contrelidx.sql ..."
db2 -l db2output.log -f cridx_pop_topdep_h_contrelidx.sql
echo "#	cridx_pop_topdep_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_pop_topdep_h_unameidx.sql
echo "#	cridx_bprjdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_bprjdef_h_tenantidx.sql
echo "#	cridx_rprjdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_rprjdef_h_tenantidx.sql
echo "#	cridx_reldef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_tenantidx.sql
echo "#	cridx_reldef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_unameidx.sql
echo "#	cridx_reldef_h_relntenantidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_relntenantidx.sql
echo "#	cridx_reldef_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_tableidx.sql
echo "#	cridx_reldef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_defschemaidx.sql
echo "#	cridx_reldef_h_rtypekeyidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_rtypekeyidx.sql
echo "#	cridx_reldef_h_fromkeyidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_fromkeyidx.sql
echo "#	cridx_reldef_h_totblidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_totblidx.sql
echo "#	cridx_reldef_h_tokeyidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_tokeyidx.sql
echo "#	cridx_reldef_h_narrowedidx.sql ..."
db2 -l db2output.log -f cridx_reldef_h_narrowedidx.sql
echo "#	cridx_relcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_unameidx.sql
echo "#	cridx_relcol_h_relcoltenantidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_relcoltenantidx.sql
echo "#	cridx_relcol_h_relationidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_relationidx.sql
echo "#	cridx_relcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_defschemaidx.sql
echo "#	cridx_relcol_h_fromcolidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_fromcolidx.sql
echo "#	cridx_relcol_h_tocolidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_tocolidx.sql
echo "#	cridx_relcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_previdx.sql
echo "#	cridx_relcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_nextidx.sql
echo "#	cridx_relcol_h_relprevidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_relprevidx.sql
echo "#	cridx_relcol_h_relnextidx.sql ..."
db2 -l db2output.log -f cridx_relcol_h_relnextidx.sql
echo "#	cridx_schemadef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_tenantidx.sql
echo "#	cridx_schemadef_h_ctenantidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_ctenantidx.sql
echo "#	cridx_schemadef_h_domainidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_domainidx.sql
echo "#	cridx_schemadef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_unameidx.sql
echo "#	cridx_schemadef_h_deflcnidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_deflcnidx.sql
echo "#	cridx_schemadef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_datascopeidx.sql
echo "#	cridx_schemadef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_vaccsecidx.sql
echo "#	cridx_schemadef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_vaccfreqidx.sql
echo "#	cridx_schemadef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_eaccsecidx.sql
echo "#	cridx_schemadef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_eaccfreqidx.sql
echo "#	cridx_schemadef_h_puburiidx.sql ..."
db2 -l db2output.log -f cridx_schemadef_h_puburiidx.sql
echo "#	cridx_schema_ref_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_schema_ref_h_tenantidx.sql
echo "#	cridx_schema_ref_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_schema_ref_h_schemaidx.sql
echo "#	cridx_schema_ref_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_schema_ref_h_unameidx.sql
echo "#	cridx_schema_ref_h_refschemaidx.sql ..."
db2 -l db2output.log -f cridx_schema_ref_h_refschemaidx.sql
echo "#	cridx_scopedef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_scopedef_h_tenantidx.sql
echo "#	cridx_secapp_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secapp_h_clusteridx.sql
echo "#	cridx_secapp_h_ujeemountidx.sql ..."
db2 -l db2output.log -f cridx_secapp_h_ujeemountidx.sql
echo "#	cridx_secdev_h_useridx.sql ..."
db2 -l db2output.log -f cridx_secdev_h_useridx.sql
echo "#	cridx_secform_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secform_h_clusteridx.sql
echo "#	cridx_secform_h_secappidx.sql ..."
db2 -l db2output.log -f cridx_secform_h_secappidx.sql
echo "#	cridx_secform_h_ujeeservletidx.sql ..."
db2 -l db2output.log -f cridx_secform_h_ujeeservletidx.sql
echo "#	cridx_secgrp_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secgrp_h_clusteridx.sql
echo "#	cridx_secgrp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_secgrp_h_unameidx.sql
echo "#	cridx_secgrpfrm_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secgrpfrm_h_clusteridx.sql
echo "#	cridx_secgrpfrm_h_groupidx.sql ..."
db2 -l db2output.log -f cridx_secgrpfrm_h_groupidx.sql
echo "#	cridx_secgrpfrm_h_appidx.sql ..."
db2 -l db2output.log -f cridx_secgrpfrm_h_appidx.sql
echo "#	cridx_secgrpfrm_h_formidx.sql ..."
db2 -l db2output.log -f cridx_secgrpfrm_h_formidx.sql
echo "#	cridx_secgrpfrm_h_uformidx.sql ..."
db2 -l db2output.log -f cridx_secgrpfrm_h_uformidx.sql
echo "#	cridx_secinc_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secinc_h_clusteridx.sql
echo "#	cridx_secinc_h_groupidx.sql ..."
db2 -l db2output.log -f cridx_secinc_h_groupidx.sql
echo "#	cridx_secinc_h_includeidx.sql ..."
db2 -l db2output.log -f cridx_secinc_h_includeidx.sql
echo "#	cridx_secinc_h_uincludeidx.sql ..."
db2 -l db2output.log -f cridx_secinc_h_uincludeidx.sql
echo "#	cridx_secmemb_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_secmemb_h_clusteridx.sql
echo "#	cridx_secmemb_h_groupidx.sql ..."
db2 -l db2output.log -f cridx_secmemb_h_groupidx.sql
echo "#	cridx_secmemb_h_useridx.sql ..."
db2 -l db2output.log -f cridx_secmemb_h_useridx.sql
echo "#	cridx_secmemb_h_uuseridx.sql ..."
db2 -l db2output.log -f cridx_secmemb_h_uuseridx.sql
echo "#	cridx_secuser_h_uloginidx.sql ..."
db2 -l db2output.log -f cridx_secuser_h_uloginidx.sql
echo "#	cridx_secuser_h_emconfidx.sql ..."
db2 -l db2output.log -f cridx_secuser_h_emconfidx.sql
echo "#	cridx_secuser_h_pwdresetidx.sql ..."
db2 -l db2output.log -f cridx_secuser_h_pwdresetidx.sql
echo "#	cridx_secuser_h_defdevidx.sql ..."
db2 -l db2output.log -f cridx_secuser_h_defdevidx.sql
echo "#	cridx_srvlfunc_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_h_tenantidx.sql
echo "#	cridx_srvlfunc_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_h_unameidx.sql
echo "#	cridx_srvlfunc_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_h_tableidx.sql
echo "#	cridx_srvlfunc_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_h_defschemaidx.sql
echo "#	cridx_srvlfunc_h_rettblidx.sql ..."
db2 -l db2output.log -f cridx_srvlfunc_h_rettblidx.sql
echo "#	cridx_srvmeth_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_h_tenantidx.sql
echo "#	cridx_srvmeth_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_h_unameidx.sql
echo "#	cridx_srvmeth_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_h_tableidx.sql
echo "#	cridx_srvmeth_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_srvmeth_h_defschemaidx.sql
echo "#	cridx_srvofunc_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_srvofunc_h_tenantidx.sql
echo "#	cridx_srvofunc_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_srvofunc_h_unameidx.sql
echo "#	cridx_srvofunc_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_srvofunc_h_tableidx.sql
echo "#	cridx_srvofunc_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_srvofunc_h_defschemaidx.sql
echo "#	cridx_srvofunc_h_rettblidx.sql ..."
db2 -l db2output.log -f cridx_srvofunc_h_rettblidx.sql
echo "#	cridx_srvprc_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_srvprc_h_tenantidx.sql
echo "#	cridx_srvprc_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_srvprc_h_unameidx.sql
echo "#	cridx_srvprc_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_srvprc_h_tableidx.sql
echo "#	cridx_srvprc_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_srvprc_h_defschemaidx.sql
echo "#	cridx_hostsvc_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_hostsvc_h_clusteridx.sql
echo "#	cridx_hostsvc_h_hostidx.sql ..."
db2 -l db2output.log -f cridx_hostsvc_h_hostidx.sql
echo "#	cridx_hostsvc_h_typeidx.sql ..."
db2 -l db2output.log -f cridx_hostsvc_h_typeidx.sql
echo "#	cridx_hostsvc_h_utypeidx.sql ..."
db2 -l db2output.log -f cridx_hostsvc_h_utypeidx.sql
echo "#	cridx_hostsvc_h_uhostportidx.sql ..."
db2 -l db2output.log -f cridx_hostsvc_h_uhostportidx.sql
echo "#	cridx_svctype_h_udescridx.sql ..."
db2 -l db2output.log -f cridx_svctype_h_udescridx.sql
echo "#	cridx_strcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_unameidx.sql
echo "#	cridx_strcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_valtentidx.sql
echo "#	cridx_strcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_scopeidx.sql
echo "#	cridx_strcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_defschemaidx.sql
echo "#	cridx_strcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_datascopeidx.sql
echo "#	cridx_strcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_vaccsecidx.sql
echo "#	cridx_strcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_vaccfreqidx.sql
echo "#	cridx_strcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_eaccsecidx.sql
echo "#	cridx_strcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_eaccfreqidx.sql
echo "#	cridx_strcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_previdx.sql
echo "#	cridx_strcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_nextidx.sql
echo "#	cridx_strcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_contprevidx.sql
echo "#	cridx_strcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_contnextidx.sql
echo "#	cridx_strcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_strcol_h_tableidx.sql
echo "#	cridx_strdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_unameidx.sql
echo "#	cridx_strdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_valtentidx.sql
echo "#	cridx_strdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_scopeidx.sql
echo "#	cridx_strdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_defschemaidx.sql
echo "#	cridx_strdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_datascopeidx.sql
echo "#	cridx_strdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_vaccsecidx.sql
echo "#	cridx_strdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_vaccfreqidx.sql
echo "#	cridx_strdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_eaccsecidx.sql
echo "#	cridx_strdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_eaccfreqidx.sql
echo "#	cridx_strdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_previdx.sql
echo "#	cridx_strdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_nextidx.sql
echo "#	cridx_strdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_contprevidx.sql
echo "#	cridx_strdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_strdef_h_contnextidx.sql
echo "#	cridx_strtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_unameidx.sql
echo "#	cridx_strtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_valtentidx.sql
echo "#	cridx_strtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_scopeidx.sql
echo "#	cridx_strtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_defschemaidx.sql
echo "#	cridx_strtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_datascopeidx.sql
echo "#	cridx_strtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_vaccsecidx.sql
echo "#	cridx_strtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_vaccfreqidx.sql
echo "#	cridx_strtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_eaccsecidx.sql
echo "#	cridx_strtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_eaccfreqidx.sql
echo "#	cridx_strtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_previdx.sql
echo "#	cridx_strtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_nextidx.sql
echo "#	cridx_strtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_contprevidx.sql
echo "#	cridx_strtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_contnextidx.sql
echo "#	cridx_strtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_strtyp_h_schemaidx.sql
echo "#	cridx_sprjdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_sprjdef_h_tenantidx.sql
echo "#	cridx_sprjdef_h_parentidx.sql ..."
db2 -l db2output.log -f cridx_sprjdef_h_parentidx.sql
echo "#	cridx_sprjdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_sprjdef_h_nameidx.sql
echo "#	cridx_tsecgrp_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tsecgrp_h_tenantidx.sql
echo "#	cridx_tsecgrp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tsecgrp_h_unameidx.sql
echo "#	cridx_tsecinc_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tsecinc_h_tenantidx.sql
echo "#	cridx_tsecinc_h_groupidx.sql ..."
db2 -l db2output.log -f cridx_tsecinc_h_groupidx.sql
echo "#	cridx_tsecinc_h_includeidx.sql ..."
db2 -l db2output.log -f cridx_tsecinc_h_includeidx.sql
echo "#	cridx_tsecinc_h_uincludeidx.sql ..."
db2 -l db2output.log -f cridx_tsecinc_h_uincludeidx.sql
echo "#	cridx_tsecmemb_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tsecmemb_h_tenantidx.sql
echo "#	cridx_tsecmemb_h_groupidx.sql ..."
db2 -l db2output.log -f cridx_tsecmemb_h_groupidx.sql
echo "#	cridx_tsecmemb_h_useridx.sql ..."
db2 -l db2output.log -f cridx_tsecmemb_h_useridx.sql
echo "#	cridx_tsecmemb_h_uuseridx.sql ..."
db2 -l db2output.log -f cridx_tsecmemb_h_uuseridx.sql
echo "#	cridx_dzcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_unameidx.sql
echo "#	cridx_dzcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_valtentidx.sql
echo "#	cridx_dzcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_scopeidx.sql
echo "#	cridx_dzcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_defschemaidx.sql
echo "#	cridx_dzcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_datascopeidx.sql
echo "#	cridx_dzcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_vaccsecidx.sql
echo "#	cridx_dzcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_vaccfreqidx.sql
echo "#	cridx_dzcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_eaccsecidx.sql
echo "#	cridx_dzcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_eaccfreqidx.sql
echo "#	cridx_dzcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_previdx.sql
echo "#	cridx_dzcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_nextidx.sql
echo "#	cridx_dzcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_contprevidx.sql
echo "#	cridx_dzcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_contnextidx.sql
echo "#	cridx_dzcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_dzcol_h_tableidx.sql
echo "#	cridx_dzdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_unameidx.sql
echo "#	cridx_dzdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_valtentidx.sql
echo "#	cridx_dzdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_scopeidx.sql
echo "#	cridx_dzdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_defschemaidx.sql
echo "#	cridx_dzdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_datascopeidx.sql
echo "#	cridx_dzdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_vaccsecidx.sql
echo "#	cridx_dzdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_vaccfreqidx.sql
echo "#	cridx_dzdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_eaccsecidx.sql
echo "#	cridx_dzdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_eaccfreqidx.sql
echo "#	cridx_dzdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_previdx.sql
echo "#	cridx_dzdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_nextidx.sql
echo "#	cridx_dzdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_contprevidx.sql
echo "#	cridx_dzdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dzdef_h_contnextidx.sql
echo "#	cridx_dztyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_unameidx.sql
echo "#	cridx_dztyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_valtentidx.sql
echo "#	cridx_dztyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_scopeidx.sql
echo "#	cridx_dztyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_defschemaidx.sql
echo "#	cridx_dztyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_datascopeidx.sql
echo "#	cridx_dztyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_vaccsecidx.sql
echo "#	cridx_dztyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_vaccfreqidx.sql
echo "#	cridx_dztyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_eaccsecidx.sql
echo "#	cridx_dztyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_eaccfreqidx.sql
echo "#	cridx_dztyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_previdx.sql
echo "#	cridx_dztyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_nextidx.sql
echo "#	cridx_dztyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_contprevidx.sql
echo "#	cridx_dztyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_contnextidx.sql
echo "#	cridx_dztyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_dztyp_h_schemaidx.sql
echo "#	cridx_tmzcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_unameidx.sql
echo "#	cridx_tmzcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_valtentidx.sql
echo "#	cridx_tmzcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_scopeidx.sql
echo "#	cridx_tmzcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_defschemaidx.sql
echo "#	cridx_tmzcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_datascopeidx.sql
echo "#	cridx_tmzcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_vaccsecidx.sql
echo "#	cridx_tmzcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_vaccfreqidx.sql
echo "#	cridx_tmzcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_eaccsecidx.sql
echo "#	cridx_tmzcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_eaccfreqidx.sql
echo "#	cridx_tmzcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_previdx.sql
echo "#	cridx_tmzcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_nextidx.sql
echo "#	cridx_tmzcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_contprevidx.sql
echo "#	cridx_tmzcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_contnextidx.sql
echo "#	cridx_tmzcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_tmzcol_h_tableidx.sql
echo "#	cridx_tmzdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_unameidx.sql
echo "#	cridx_tmzdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_valtentidx.sql
echo "#	cridx_tmzdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_scopeidx.sql
echo "#	cridx_tmzdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_defschemaidx.sql
echo "#	cridx_tmzdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_datascopeidx.sql
echo "#	cridx_tmzdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_vaccsecidx.sql
echo "#	cridx_tmzdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_vaccfreqidx.sql
echo "#	cridx_tmzdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_eaccsecidx.sql
echo "#	cridx_tmzdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_eaccfreqidx.sql
echo "#	cridx_tmzdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_previdx.sql
echo "#	cridx_tmzdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_nextidx.sql
echo "#	cridx_tmzdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_contprevidx.sql
echo "#	cridx_tmzdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmzdef_h_contnextidx.sql
echo "#	cridx_tmztyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_unameidx.sql
echo "#	cridx_tmztyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_valtentidx.sql
echo "#	cridx_tmztyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_scopeidx.sql
echo "#	cridx_tmztyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_defschemaidx.sql
echo "#	cridx_tmztyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_datascopeidx.sql
echo "#	cridx_tmztyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_vaccsecidx.sql
echo "#	cridx_tmztyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_vaccfreqidx.sql
echo "#	cridx_tmztyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_eaccsecidx.sql
echo "#	cridx_tmztyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_eaccfreqidx.sql
echo "#	cridx_tmztyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_previdx.sql
echo "#	cridx_tmztyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_nextidx.sql
echo "#	cridx_tmztyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_contprevidx.sql
echo "#	cridx_tmztyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_contnextidx.sql
echo "#	cridx_tmztyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_tmztyp_h_schemaidx.sql
echo "#	cridx_zscol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_unameidx.sql
echo "#	cridx_zscol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_valtentidx.sql
echo "#	cridx_zscol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_scopeidx.sql
echo "#	cridx_zscol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_defschemaidx.sql
echo "#	cridx_zscol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_datascopeidx.sql
echo "#	cridx_zscol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_vaccsecidx.sql
echo "#	cridx_zscol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_vaccfreqidx.sql
echo "#	cridx_zscol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_eaccsecidx.sql
echo "#	cridx_zscol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_eaccfreqidx.sql
echo "#	cridx_zscol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_previdx.sql
echo "#	cridx_zscol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_nextidx.sql
echo "#	cridx_zscol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_contprevidx.sql
echo "#	cridx_zscol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_contnextidx.sql
echo "#	cridx_zscol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_zscol_h_tableidx.sql
echo "#	cridx_zsdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_unameidx.sql
echo "#	cridx_zsdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_valtentidx.sql
echo "#	cridx_zsdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_scopeidx.sql
echo "#	cridx_zsdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_defschemaidx.sql
echo "#	cridx_zsdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_datascopeidx.sql
echo "#	cridx_zsdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_vaccsecidx.sql
echo "#	cridx_zsdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_vaccfreqidx.sql
echo "#	cridx_zsdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_eaccsecidx.sql
echo "#	cridx_zsdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_eaccfreqidx.sql
echo "#	cridx_zsdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_previdx.sql
echo "#	cridx_zsdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_nextidx.sql
echo "#	cridx_zsdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_contprevidx.sql
echo "#	cridx_zsdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_zsdef_h_contnextidx.sql
echo "#	cridx_zstyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_unameidx.sql
echo "#	cridx_zstyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_valtentidx.sql
echo "#	cridx_zstyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_scopeidx.sql
echo "#	cridx_zstyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_defschemaidx.sql
echo "#	cridx_zstyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_datascopeidx.sql
echo "#	cridx_zstyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_vaccsecidx.sql
echo "#	cridx_zstyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_vaccfreqidx.sql
echo "#	cridx_zstyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_eaccsecidx.sql
echo "#	cridx_zstyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_eaccfreqidx.sql
echo "#	cridx_zstyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_previdx.sql
echo "#	cridx_zstyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_nextidx.sql
echo "#	cridx_zstyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_contprevidx.sql
echo "#	cridx_zstyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_contnextidx.sql
echo "#	cridx_zstyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_zstyp_h_schemaidx.sql
echo "#	cridx_tbldef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_tenantidx.sql
echo "#	cridx_tbldef_h_schemadefidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_schemadefidx.sql
echo "#	cridx_tbldef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_defschemaidx.sql
echo "#	cridx_tbldef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_unameidx.sql
echo "#	cridx_tbldef_h_schemacdidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_schemacdidx.sql
echo "#	cridx_tbldef_h_primaryindexidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_primaryindexidx.sql
echo "#	cridx_tbldef_h_lookupindexidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_lookupindexidx.sql
echo "#	cridx_tbldef_h_altindexidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_altindexidx.sql
echo "#	cridx_tbldef_h_qualtableidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_qualtableidx.sql
echo "#	cridx_tbldef_h_loadbehaveidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_loadbehaveidx.sql
echo "#	cridx_tbldef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_datascopeidx.sql
echo "#	cridx_tbldef_h_secscopeidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_secscopeidx.sql
echo "#	cridx_tbldef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_vaccsecidx.sql
echo "#	cridx_tbldef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_vaccfreqidx.sql
echo "#	cridx_tbldef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_eaccsecidx.sql
echo "#	cridx_tbldef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tbldef_h_eaccfreqidx.sql
echo "#	cridx_tblcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_unameidx.sql
echo "#	cridx_tblcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_valtentidx.sql
echo "#	cridx_tblcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_scopeidx.sql
echo "#	cridx_tblcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_defschemaidx.sql
echo "#	cridx_tblcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_datascopeidx.sql
echo "#	cridx_tblcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_vaccsecidx.sql
echo "#	cridx_tblcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_vaccfreqidx.sql
echo "#	cridx_tblcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_eaccsecidx.sql
echo "#	cridx_tblcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_eaccfreqidx.sql
echo "#	cridx_tblcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_previdx.sql
echo "#	cridx_tblcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_nextidx.sql
echo "#	cridx_tblcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_contprevidx.sql
echo "#	cridx_tblcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_contnextidx.sql
echo "#	cridx_tblcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_tableidx.sql
echo "#	cridx_tblcol_h_dataidx.sql ..."
db2 -l db2output.log -f cridx_tblcol_h_dataidx.sql
echo "#	cridx_tenant_h_clusteridx.sql ..."
db2 -l db2output.log -f cridx_tenant_h_clusteridx.sql
echo "#	cridx_tenant_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tenant_h_unameidx.sql
echo "#	cridx_txtcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_unameidx.sql
echo "#	cridx_txtcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_valtentidx.sql
echo "#	cridx_txtcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_scopeidx.sql
echo "#	cridx_txtcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_defschemaidx.sql
echo "#	cridx_txtcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_datascopeidx.sql
echo "#	cridx_txtcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_vaccsecidx.sql
echo "#	cridx_txtcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_vaccfreqidx.sql
echo "#	cridx_txtcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_eaccsecidx.sql
echo "#	cridx_txtcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_eaccfreqidx.sql
echo "#	cridx_txtcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_previdx.sql
echo "#	cridx_txtcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_nextidx.sql
echo "#	cridx_txtcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_contprevidx.sql
echo "#	cridx_txtcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_contnextidx.sql
echo "#	cridx_txtcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_txtcol_h_tableidx.sql
echo "#	cridx_txtdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_unameidx.sql
echo "#	cridx_txtdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_valtentidx.sql
echo "#	cridx_txtdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_scopeidx.sql
echo "#	cridx_txtdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_defschemaidx.sql
echo "#	cridx_txtdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_datascopeidx.sql
echo "#	cridx_txtdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_vaccsecidx.sql
echo "#	cridx_txtdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_vaccfreqidx.sql
echo "#	cridx_txtdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_eaccsecidx.sql
echo "#	cridx_txtdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_eaccfreqidx.sql
echo "#	cridx_txtdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_previdx.sql
echo "#	cridx_txtdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_nextidx.sql
echo "#	cridx_txtdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_contprevidx.sql
echo "#	cridx_txtdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_txtdef_h_contnextidx.sql
echo "#	cridx_txttyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_unameidx.sql
echo "#	cridx_txttyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_valtentidx.sql
echo "#	cridx_txttyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_scopeidx.sql
echo "#	cridx_txttyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_defschemaidx.sql
echo "#	cridx_txttyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_datascopeidx.sql
echo "#	cridx_txttyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_vaccsecidx.sql
echo "#	cridx_txttyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_vaccfreqidx.sql
echo "#	cridx_txttyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_eaccsecidx.sql
echo "#	cridx_txttyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_eaccfreqidx.sql
echo "#	cridx_txttyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_previdx.sql
echo "#	cridx_txttyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_nextidx.sql
echo "#	cridx_txttyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_contprevidx.sql
echo "#	cridx_txttyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_contnextidx.sql
echo "#	cridx_txttyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_txttyp_h_schemaidx.sql
echo "#	cridx_tmcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_unameidx.sql
echo "#	cridx_tmcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_valtentidx.sql
echo "#	cridx_tmcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_scopeidx.sql
echo "#	cridx_tmcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_defschemaidx.sql
echo "#	cridx_tmcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_datascopeidx.sql
echo "#	cridx_tmcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_vaccsecidx.sql
echo "#	cridx_tmcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_vaccfreqidx.sql
echo "#	cridx_tmcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_eaccsecidx.sql
echo "#	cridx_tmcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_eaccfreqidx.sql
echo "#	cridx_tmcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_previdx.sql
echo "#	cridx_tmcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_nextidx.sql
echo "#	cridx_tmcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_contprevidx.sql
echo "#	cridx_tmcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_contnextidx.sql
echo "#	cridx_tmcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_tmcol_h_tableidx.sql
echo "#	cridx_tmdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_unameidx.sql
echo "#	cridx_tmdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_valtentidx.sql
echo "#	cridx_tmdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_scopeidx.sql
echo "#	cridx_tmdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_defschemaidx.sql
echo "#	cridx_tmdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_datascopeidx.sql
echo "#	cridx_tmdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_vaccsecidx.sql
echo "#	cridx_tmdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_vaccfreqidx.sql
echo "#	cridx_tmdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_eaccsecidx.sql
echo "#	cridx_tmdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_eaccfreqidx.sql
echo "#	cridx_tmdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_previdx.sql
echo "#	cridx_tmdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_nextidx.sql
echo "#	cridx_tmdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_contprevidx.sql
echo "#	cridx_tmdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmdef_h_contnextidx.sql
echo "#	cridx_tmtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_unameidx.sql
echo "#	cridx_tmtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_valtentidx.sql
echo "#	cridx_tmtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_scopeidx.sql
echo "#	cridx_tmtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_defschemaidx.sql
echo "#	cridx_tmtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_datascopeidx.sql
echo "#	cridx_tmtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_vaccsecidx.sql
echo "#	cridx_tmtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_vaccfreqidx.sql
echo "#	cridx_tmtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_eaccsecidx.sql
echo "#	cridx_tmtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_eaccfreqidx.sql
echo "#	cridx_tmtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_previdx.sql
echo "#	cridx_tmtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_nextidx.sql
echo "#	cridx_tmtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_contprevidx.sql
echo "#	cridx_tmtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_contnextidx.sql
echo "#	cridx_tmtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_tmtyp_h_schemaidx.sql
echo "#	cridx_tscol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_unameidx.sql
echo "#	cridx_tscol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_valtentidx.sql
echo "#	cridx_tscol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_scopeidx.sql
echo "#	cridx_tscol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_defschemaidx.sql
echo "#	cridx_tscol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_datascopeidx.sql
echo "#	cridx_tscol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_vaccsecidx.sql
echo "#	cridx_tscol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_vaccfreqidx.sql
echo "#	cridx_tscol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_eaccsecidx.sql
echo "#	cridx_tscol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_eaccfreqidx.sql
echo "#	cridx_tscol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_previdx.sql
echo "#	cridx_tscol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_nextidx.sql
echo "#	cridx_tscol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_contprevidx.sql
echo "#	cridx_tscol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_contnextidx.sql
echo "#	cridx_tscol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_tscol_h_tableidx.sql
echo "#	cridx_tsdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_unameidx.sql
echo "#	cridx_tsdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_valtentidx.sql
echo "#	cridx_tsdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_scopeidx.sql
echo "#	cridx_tsdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_defschemaidx.sql
echo "#	cridx_tsdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_datascopeidx.sql
echo "#	cridx_tsdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_vaccsecidx.sql
echo "#	cridx_tsdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_vaccfreqidx.sql
echo "#	cridx_tsdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_eaccsecidx.sql
echo "#	cridx_tsdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_eaccfreqidx.sql
echo "#	cridx_tsdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_previdx.sql
echo "#	cridx_tsdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_nextidx.sql
echo "#	cridx_tsdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_contprevidx.sql
echo "#	cridx_tsdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tsdef_h_contnextidx.sql
echo "#	cridx_tstyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_unameidx.sql
echo "#	cridx_tstyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_valtentidx.sql
echo "#	cridx_tstyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_scopeidx.sql
echo "#	cridx_tstyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_defschemaidx.sql
echo "#	cridx_tstyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_datascopeidx.sql
echo "#	cridx_tstyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_vaccsecidx.sql
echo "#	cridx_tstyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_vaccfreqidx.sql
echo "#	cridx_tstyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_eaccsecidx.sql
echo "#	cridx_tstyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_eaccfreqidx.sql
echo "#	cridx_tstyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_previdx.sql
echo "#	cridx_tstyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_nextidx.sql
echo "#	cridx_tstyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_contprevidx.sql
echo "#	cridx_tstyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_contnextidx.sql
echo "#	cridx_tstyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_tstyp_h_schemaidx.sql
echo "#	cridx_tlddef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tlddef_h_tenantidx.sql
echo "#	cridx_tlddef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_tlddef_h_nameidx.sql
echo "#	cridx_tkncol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_unameidx.sql
echo "#	cridx_tkncol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_valtentidx.sql
echo "#	cridx_tkncol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_scopeidx.sql
echo "#	cridx_tkncol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_defschemaidx.sql
echo "#	cridx_tkncol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_datascopeidx.sql
echo "#	cridx_tkncol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_vaccsecidx.sql
echo "#	cridx_tkncol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_vaccfreqidx.sql
echo "#	cridx_tkncol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_eaccsecidx.sql
echo "#	cridx_tkncol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_eaccfreqidx.sql
echo "#	cridx_tkncol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_previdx.sql
echo "#	cridx_tkncol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_nextidx.sql
echo "#	cridx_tkncol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_contprevidx.sql
echo "#	cridx_tkncol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_contnextidx.sql
echo "#	cridx_tkncol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_tkncol_h_tableidx.sql
echo "#	cridx_tkndef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_unameidx.sql
echo "#	cridx_tkndef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_valtentidx.sql
echo "#	cridx_tkndef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_scopeidx.sql
echo "#	cridx_tkndef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_defschemaidx.sql
echo "#	cridx_tkndef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_datascopeidx.sql
echo "#	cridx_tkndef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_vaccsecidx.sql
echo "#	cridx_tkndef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_vaccfreqidx.sql
echo "#	cridx_tkndef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_eaccsecidx.sql
echo "#	cridx_tkndef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_eaccfreqidx.sql
echo "#	cridx_tkndef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_previdx.sql
echo "#	cridx_tkndef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_nextidx.sql
echo "#	cridx_tkndef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_contprevidx.sql
echo "#	cridx_tkndef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tkndef_h_contnextidx.sql
echo "#	cridx_tkntyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_unameidx.sql
echo "#	cridx_tkntyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_valtentidx.sql
echo "#	cridx_tkntyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_scopeidx.sql
echo "#	cridx_tkntyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_defschemaidx.sql
echo "#	cridx_tkntyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_datascopeidx.sql
echo "#	cridx_tkntyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_vaccsecidx.sql
echo "#	cridx_tkntyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_vaccfreqidx.sql
echo "#	cridx_tkntyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_eaccsecidx.sql
echo "#	cridx_tkntyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_eaccfreqidx.sql
echo "#	cridx_tkntyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_previdx.sql
echo "#	cridx_tkntyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_nextidx.sql
echo "#	cridx_tkntyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_contprevidx.sql
echo "#	cridx_tkntyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_contnextidx.sql
echo "#	cridx_tkntyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_tkntyp_h_schemaidx.sql
echo "#	cridx_tdomdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tdomdef_h_tenantidx.sql
echo "#	cridx_tdomdef_h_tldidx.sql ..."
db2 -l db2output.log -f cridx_tdomdef_h_tldidx.sql
echo "#	cridx_tdomdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_tdomdef_h_nameidx.sql
echo "#	cridx_tprjdef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_tprjdef_h_tenantidx.sql
echo "#	cridx_tprjdef_h_domainidx.sql ..."
db2 -l db2output.log -f cridx_tprjdef_h_domainidx.sql
echo "#	cridx_tprjdef_h_nameidx.sql ..."
db2 -l db2output.log -f cridx_tprjdef_h_nameidx.sql
echo "#	cridx_uint16col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_unameidx.sql
echo "#	cridx_uint16col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_valtentidx.sql
echo "#	cridx_uint16col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_scopeidx.sql
echo "#	cridx_uint16col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_defschemaidx.sql
echo "#	cridx_uint16col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_datascopeidx.sql
echo "#	cridx_uint16col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_vaccsecidx.sql
echo "#	cridx_uint16col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_vaccfreqidx.sql
echo "#	cridx_uint16col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_eaccsecidx.sql
echo "#	cridx_uint16col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_eaccfreqidx.sql
echo "#	cridx_uint16col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_previdx.sql
echo "#	cridx_uint16col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_nextidx.sql
echo "#	cridx_uint16col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_contprevidx.sql
echo "#	cridx_uint16col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_contnextidx.sql
echo "#	cridx_uint16col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_uint16col_h_tableidx.sql
echo "#	cridx_u16def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_unameidx.sql
echo "#	cridx_u16def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_valtentidx.sql
echo "#	cridx_u16def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_scopeidx.sql
echo "#	cridx_u16def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_defschemaidx.sql
echo "#	cridx_u16def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_datascopeidx.sql
echo "#	cridx_u16def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_vaccsecidx.sql
echo "#	cridx_u16def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_vaccfreqidx.sql
echo "#	cridx_u16def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_eaccsecidx.sql
echo "#	cridx_u16def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_eaccfreqidx.sql
echo "#	cridx_u16def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_previdx.sql
echo "#	cridx_u16def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_nextidx.sql
echo "#	cridx_u16def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_contprevidx.sql
echo "#	cridx_u16def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_u16def_h_contnextidx.sql
echo "#	cridx_uint16typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_unameidx.sql
echo "#	cridx_uint16typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_valtentidx.sql
echo "#	cridx_uint16typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_scopeidx.sql
echo "#	cridx_uint16typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_defschemaidx.sql
echo "#	cridx_uint16typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_datascopeidx.sql
echo "#	cridx_uint16typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_vaccsecidx.sql
echo "#	cridx_uint16typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_vaccfreqidx.sql
echo "#	cridx_uint16typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_eaccsecidx.sql
echo "#	cridx_uint16typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_eaccfreqidx.sql
echo "#	cridx_uint16typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_previdx.sql
echo "#	cridx_uint16typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_nextidx.sql
echo "#	cridx_uint16typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_contprevidx.sql
echo "#	cridx_uint16typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_contnextidx.sql
echo "#	cridx_uint16typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_uint16typ_h_schemaidx.sql
echo "#	cridx_uint32col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_unameidx.sql
echo "#	cridx_uint32col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_valtentidx.sql
echo "#	cridx_uint32col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_scopeidx.sql
echo "#	cridx_uint32col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_defschemaidx.sql
echo "#	cridx_uint32col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_datascopeidx.sql
echo "#	cridx_uint32col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_vaccsecidx.sql
echo "#	cridx_uint32col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_vaccfreqidx.sql
echo "#	cridx_uint32col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_eaccsecidx.sql
echo "#	cridx_uint32col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_eaccfreqidx.sql
echo "#	cridx_uint32col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_previdx.sql
echo "#	cridx_uint32col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_nextidx.sql
echo "#	cridx_uint32col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_contprevidx.sql
echo "#	cridx_uint32col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_contnextidx.sql
echo "#	cridx_uint32col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_uint32col_h_tableidx.sql
echo "#	cridx_u32def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_unameidx.sql
echo "#	cridx_u32def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_valtentidx.sql
echo "#	cridx_u32def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_scopeidx.sql
echo "#	cridx_u32def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_defschemaidx.sql
echo "#	cridx_u32def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_datascopeidx.sql
echo "#	cridx_u32def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_vaccsecidx.sql
echo "#	cridx_u32def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_vaccfreqidx.sql
echo "#	cridx_u32def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_eaccsecidx.sql
echo "#	cridx_u32def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_eaccfreqidx.sql
echo "#	cridx_u32def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_previdx.sql
echo "#	cridx_u32def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_nextidx.sql
echo "#	cridx_u32def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_contprevidx.sql
echo "#	cridx_u32def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_u32def_h_contnextidx.sql
echo "#	cridx_uint32typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_unameidx.sql
echo "#	cridx_uint32typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_valtentidx.sql
echo "#	cridx_uint32typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_scopeidx.sql
echo "#	cridx_uint32typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_defschemaidx.sql
echo "#	cridx_uint32typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_datascopeidx.sql
echo "#	cridx_uint32typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_vaccsecidx.sql
echo "#	cridx_uint32typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_vaccfreqidx.sql
echo "#	cridx_uint32typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_eaccsecidx.sql
echo "#	cridx_uint32typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_eaccfreqidx.sql
echo "#	cridx_uint32typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_previdx.sql
echo "#	cridx_uint32typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_nextidx.sql
echo "#	cridx_uint32typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_contprevidx.sql
echo "#	cridx_uint32typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_contnextidx.sql
echo "#	cridx_uint32typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_uint32typ_h_schemaidx.sql
echo "#	cridx_uint64col_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_unameidx.sql
echo "#	cridx_uint64col_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_valtentidx.sql
echo "#	cridx_uint64col_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_scopeidx.sql
echo "#	cridx_uint64col_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_defschemaidx.sql
echo "#	cridx_uint64col_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_datascopeidx.sql
echo "#	cridx_uint64col_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_vaccsecidx.sql
echo "#	cridx_uint64col_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_vaccfreqidx.sql
echo "#	cridx_uint64col_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_eaccsecidx.sql
echo "#	cridx_uint64col_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_eaccfreqidx.sql
echo "#	cridx_uint64col_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_previdx.sql
echo "#	cridx_uint64col_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_nextidx.sql
echo "#	cridx_uint64col_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_contprevidx.sql
echo "#	cridx_uint64col_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_contnextidx.sql
echo "#	cridx_uint64col_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_uint64col_h_tableidx.sql
echo "#	cridx_u64def_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_unameidx.sql
echo "#	cridx_u64def_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_valtentidx.sql
echo "#	cridx_u64def_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_scopeidx.sql
echo "#	cridx_u64def_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_defschemaidx.sql
echo "#	cridx_u64def_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_datascopeidx.sql
echo "#	cridx_u64def_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_vaccsecidx.sql
echo "#	cridx_u64def_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_vaccfreqidx.sql
echo "#	cridx_u64def_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_eaccsecidx.sql
echo "#	cridx_u64def_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_eaccfreqidx.sql
echo "#	cridx_u64def_h_previdx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_previdx.sql
echo "#	cridx_u64def_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_nextidx.sql
echo "#	cridx_u64def_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_contprevidx.sql
echo "#	cridx_u64def_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_u64def_h_contnextidx.sql
echo "#	cridx_uint64typ_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_unameidx.sql
echo "#	cridx_uint64typ_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_valtentidx.sql
echo "#	cridx_uint64typ_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_scopeidx.sql
echo "#	cridx_uint64typ_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_defschemaidx.sql
echo "#	cridx_uint64typ_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_datascopeidx.sql
echo "#	cridx_uint64typ_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_vaccsecidx.sql
echo "#	cridx_uint64typ_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_vaccfreqidx.sql
echo "#	cridx_uint64typ_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_eaccsecidx.sql
echo "#	cridx_uint64typ_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_eaccfreqidx.sql
echo "#	cridx_uint64typ_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_previdx.sql
echo "#	cridx_uint64typ_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_nextidx.sql
echo "#	cridx_uint64typ_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_contprevidx.sql
echo "#	cridx_uint64typ_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_contnextidx.sql
echo "#	cridx_uint64typ_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_uint64typ_h_schemaidx.sql
echo "#	cridx_urlproto_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_urlproto_h_unameidx.sql
echo "#	cridx_urlproto_h_issecureidx.sql ..."
db2 -l db2output.log -f cridx_urlproto_h_issecureidx.sql
echo "#	cridx_uuidcol_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_unameidx.sql
echo "#	cridx_uuidcol_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_valtentidx.sql
echo "#	cridx_uuidcol_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_scopeidx.sql
echo "#	cridx_uuidcol_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_defschemaidx.sql
echo "#	cridx_uuidcol_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_datascopeidx.sql
echo "#	cridx_uuidcol_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_vaccsecidx.sql
echo "#	cridx_uuidcol_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_vaccfreqidx.sql
echo "#	cridx_uuidcol_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_eaccsecidx.sql
echo "#	cridx_uuidcol_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_eaccfreqidx.sql
echo "#	cridx_uuidcol_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_previdx.sql
echo "#	cridx_uuidcol_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_nextidx.sql
echo "#	cridx_uuidcol_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_contprevidx.sql
echo "#	cridx_uuidcol_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_contnextidx.sql
echo "#	cridx_uuidcol_h_tableidx.sql ..."
db2 -l db2output.log -f cridx_uuidcol_h_tableidx.sql
echo "#	cridx_uuiddef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_unameidx.sql
echo "#	cridx_uuiddef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_valtentidx.sql
echo "#	cridx_uuiddef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_scopeidx.sql
echo "#	cridx_uuiddef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_defschemaidx.sql
echo "#	cridx_uuiddef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_datascopeidx.sql
echo "#	cridx_uuiddef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_vaccsecidx.sql
echo "#	cridx_uuiddef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_vaccfreqidx.sql
echo "#	cridx_uuiddef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_eaccsecidx.sql
echo "#	cridx_uuiddef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_eaccfreqidx.sql
echo "#	cridx_uuiddef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_previdx.sql
echo "#	cridx_uuiddef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_nextidx.sql
echo "#	cridx_uuiddef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_contprevidx.sql
echo "#	cridx_uuiddef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uuiddef_h_contnextidx.sql
echo "#	cridx_idguuid_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_unameidx.sql
echo "#	cridx_idguuid_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_valtentidx.sql
echo "#	cridx_idguuid_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_scopeidx.sql
echo "#	cridx_idguuid_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_defschemaidx.sql
echo "#	cridx_idguuid_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_datascopeidx.sql
echo "#	cridx_idguuid_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_vaccsecidx.sql
echo "#	cridx_idguuid_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_vaccfreqidx.sql
echo "#	cridx_idguuid_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_eaccsecidx.sql
echo "#	cridx_idguuid_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_eaccfreqidx.sql
echo "#	cridx_idguuid_h_previdx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_previdx.sql
echo "#	cridx_idguuid_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_nextidx.sql
echo "#	cridx_idguuid_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_contprevidx.sql
echo "#	cridx_idguuid_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_contnextidx.sql
echo "#	cridx_idguuid_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_schemaidx.sql
echo "#	cridx_idguuid_h_dispidx.sql ..."
db2 -l db2output.log -f cridx_idguuid_h_dispidx.sql
echo "#	cridx_uuidtyp_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_unameidx.sql
echo "#	cridx_uuidtyp_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_valtentidx.sql
echo "#	cridx_uuidtyp_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_scopeidx.sql
echo "#	cridx_uuidtyp_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_defschemaidx.sql
echo "#	cridx_uuidtyp_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_datascopeidx.sql
echo "#	cridx_uuidtyp_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_vaccsecidx.sql
echo "#	cridx_uuidtyp_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_vaccfreqidx.sql
echo "#	cridx_uuidtyp_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_eaccsecidx.sql
echo "#	cridx_uuidtyp_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_eaccfreqidx.sql
echo "#	cridx_uuidtyp_h_previdx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_previdx.sql
echo "#	cridx_uuidtyp_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_nextidx.sql
echo "#	cridx_uuidtyp_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_contprevidx.sql
echo "#	cridx_uuidtyp_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_contnextidx.sql
echo "#	cridx_uuidtyp_h_schemaidx.sql ..."
db2 -l db2output.log -f cridx_uuidtyp_h_schemaidx.sql
echo "#	cridx_valdef_h_unameidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_unameidx.sql
echo "#	cridx_valdef_h_valtentidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_valtentidx.sql
echo "#	cridx_valdef_h_scopeidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_scopeidx.sql
echo "#	cridx_valdef_h_defschemaidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_defschemaidx.sql
echo "#	cridx_valdef_h_datascopeidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_datascopeidx.sql
echo "#	cridx_valdef_h_vaccsecidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_vaccsecidx.sql
echo "#	cridx_valdef_h_vaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_vaccfreqidx.sql
echo "#	cridx_valdef_h_eaccsecidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_eaccsecidx.sql
echo "#	cridx_valdef_h_eaccfreqidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_eaccfreqidx.sql
echo "#	cridx_valdef_h_previdx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_previdx.sql
echo "#	cridx_valdef_h_nextidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_nextidx.sql
echo "#	cridx_valdef_h_contprevidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_contprevidx.sql
echo "#	cridx_valdef_h_contnextidx.sql ..."
db2 -l db2output.log -f cridx_valdef_h_contnextidx.sql
echo "#	cridx_verndef_h_tenantidx.sql ..."
db2 -l db2output.log -f cridx_verndef_h_tenantidx.sql
