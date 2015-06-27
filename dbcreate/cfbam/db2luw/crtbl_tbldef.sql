--
--	@(#) dbcreate/cfbam/db2luw/crtbl_tbldef.sql
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

CREATE TABLE cfbam23.tbldef (	\
	TenantId	BIGINT NOT NULL,	\
	SchemaDefId	BIGINT NOT NULL,	\
	defschtentid	BIGINT,	\
	defschid	BIGINT,	\
	Id	BIGINT NOT NULL,	\
	Name	VARCHAR(192) NOT NULL,	\
	DbName	VARCHAR(32),	\
	short_name	VARCHAR(16),	\
	Label	VARCHAR(64),	\
	short_descr	VARCHAR(50),	\
	descr	VARCHAR(100),	\
	PrimIdxTentId	BIGINT,	\
	PrimIdxId	BIGINT,	\
	TblClsCd	VARCHAR(4) NOT NULL,	\
	LookIdxTentId	BIGINT,	\
	LookIdxId	BIGINT,	\
	AltIdxTentId	BIGINT,	\
	AltIdxId	BIGINT,	\
	QualTentId	BIGINT,	\
	QualTblId	BIGINT,	\
	PolyBase	CHAR(1) NOT NULL,	\
	IsInstantiable	CHAR(1) NOT NULL,	\
	HasHistory	CHAR(1) NOT NULL,	\
	HasAuditColumns	CHAR(1) NOT NULL,	\
	LoadBehavId	SMALLINT NOT NULL,	\
	DataScopeId	SMALLINT,	\
	SecScopeId	SMALLINT NOT NULL,	\
	VASecId	SMALLINT,	\
	EASecId	SMALLINT,	\
	VAFId	SMALLINT,	\
	EAFId	SMALLINT,	\
	jobj_memb	CLOB(2000000),	\
	jobj_xface	CLOB(2000000),	\
	jtbl_objimp	CLOB(2000000),	\
	jobj_impl	CLOB(2000000),	\
	jedt_memb	CLOB(2000000),	\
	jedt_xface	CLOB(2000000),	\
	jtbl_eobjimp	CLOB(2000000),	\
	jedt_impl	CLOB(2000000),	\
	jtbl_imp	CLOB(2000000),	\
	jtbl_memb	CLOB(2000000),	\
	jtbl_xface	CLOB(2000000),	\
	jtbl_impl	CLOB(2000000),	\
	jtbl_objimp	CLOB(2000000),	\
	jtbl_objmemb	CLOB(2000000),	\
	jtbl_objxface	CLOB(2000000),	\
	jtbl_objimpl	CLOB(2000000),	\
	jtbl_db2imp	CLOB(2000000),	\
	jdb2_memb	CLOB(2000000),	\
	jdb2_impl	CLOB(2000000),	\
	jtbl_msimp	CLOB(2000000),	\
	jmssql_memb	CLOB(2000000),	\
	jmssql_impl	CLOB(2000000),	\
	jtbl_myimp	CLOB(2000000),	\
	jmysql_memb	CLOB(2000000),	\
	jmysql_impl	CLOB(2000000),	\
	jtbl_oraimp	CLOB(2000000),	\
	joracle_memb	CLOB(2000000),	\
	joracle_impl	CLOB(2000000),	\
	jtbl_pgimp	CLOB(2000000),	\
	jpgsql_memb	CLOB(2000000),	\
	jpgsql_impl	CLOB(2000000),	\
	jtbl_sybaseimp	CLOB(2000000),	\
	jsybase_memb	CLOB(2000000),	\
	jsybase_impl	CLOB(2000000),	\
	jtbl_ramimp	CLOB(2000000),	\
	jram_memb	CLOB(2000000),	\
	jram_impl	CLOB(2000000),	\
	jtbl_saxldimp	CLOB(2000000),	\
	jsaxstart_memb	CLOB(2000000),	\
	jsaxend_impl	CLOB(2000000),	\
	jxmtbl_imp	CLOB(2000000),	\
	jxmtbl_fmt	CLOB(2000000),	\
	jxmtbl_rqstimp	CLOB(2000000),	\
	jxmtbl_rspnimp	CLOB(2000000),	\
	jxmtbl_clntimp	CLOB(2000000),	\
	jxmtbl_rqstbdy	CLOB(2000000),	\
	jxmtbl_rspnbdy	CLOB(2000000),	\
	jxmtbl_clntbdy	CLOB(2000000),	\
	dflt_vis	CHAR(1) NOT NULL)	\
IN msidata1

CREATE UNIQUE INDEX CFBam23.tbldef_pk ON CFBam23.tbldef (	\
	TenantId DESC,	\
	Id DESC )

ALTER TABLE CFBam23.tbldef	\
	ADD CONSTRAINT pk_tbldef_pk PRIMARY KEY ( TenantId, Id )

commit
