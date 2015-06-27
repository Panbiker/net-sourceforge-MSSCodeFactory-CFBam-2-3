--
--	@(#) dbcreate/cfbam/pgsql/crtype_tbldef_rec.pgsql
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

create type cfbam23.type_tbldef_rec as (
		ClassCode varchar,
		createdby varchar,
		createdat text,
		updatedby varchar,
		updatedat text,
		tenantid bigint,
		id bigint,
		schemadefid bigint,
		defschtentid bigint,
		defschid bigint,
		name varchar,
		dbname varchar,
		short_name varchar,
		label varchar,
		short_descr varchar,
		descr varchar,
		primidxtentid bigint,
		primidxid bigint,
		tblclscd varchar,
		lookidxtentid bigint,
		lookidxid bigint,
		altidxtentid bigint,
		altidxid bigint,
		qualtentid bigint,
		qualtblid bigint,
		polybase boolean,
		isinstantiable boolean,
		hashistory boolean,
		hasauditcolumns boolean,
		loadbehavid smallint,
		datascopeid smallint,
		secscopeid smallint,
		vasecid smallint,
		easecid smallint,
		vafid smallint,
		eafid smallint,
		jobj_memb text,
		jobj_xface text,
		jtbl_objimp text,
		jobj_impl text,
		jedt_memb text,
		jedt_xface text,
		jtbl_eobjimp text,
		jedt_impl text,
		jtbl_imp text,
		jtbl_memb text,
		jtbl_xface text,
		jtbl_impl text,
		jtbl_objimp text,
		jtbl_objmemb text,
		jtbl_objxface text,
		jtbl_objimpl text,
		jtbl_db2imp text,
		jdb2_memb text,
		jdb2_impl text,
		jtbl_msimp text,
		jmssql_memb text,
		jmssql_impl text,
		jtbl_myimp text,
		jmysql_memb text,
		jmysql_impl text,
		jtbl_oraimp text,
		joracle_memb text,
		joracle_impl text,
		jtbl_pgimp text,
		jpgsql_memb text,
		jpgsql_impl text,
		jtbl_sybaseimp text,
		jsybase_memb text,
		jsybase_impl text,
		jtbl_ramimp text,
		jram_memb text,
		jram_impl text,
		jtbl_saxldimp text,
		jsaxstart_memb text,
		jsaxend_impl text,
		jxmtbl_imp text,
		jxmtbl_fmt text,
		jxmtbl_rqstimp text,
		jxmtbl_rspnimp text,
		jxmtbl_clntimp text,
		jxmtbl_rqstbdy text,
		jxmtbl_rspnbdy text,
		jxmtbl_clntbdy text,
		dflt_vis boolean,
		revision integer );
