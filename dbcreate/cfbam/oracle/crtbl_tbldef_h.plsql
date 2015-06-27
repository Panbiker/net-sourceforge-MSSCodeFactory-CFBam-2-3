--
--	@(#) dbcreate/cfbam/oracle/crtbl_tbldef_h.plsql
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
--	Code manufactured MSS Code Factory
--

CREATE TABLE cfbam23.tbldef_h (
	tenantid	numeric(22,0) NOT NULL,
	id	numeric(22,0) NOT NULL,
	revision	INTEGER NOT NULL,
	auditclusterid	NUMERIC(22,0) NOT NULL,
		CONSTRAINT chkh_tbldefauditcluster
			FOREIGN KEY ( auditclusterid )
			REFERENCES cfbam23.clus( id )
			ON DELETE CASCADE,
	auditsessionid	VARCHAR(36) NOT NULL,
		CONSTRAINT chkh_tbldefauditsession
			FOREIGN KEY ( auditsessionid )
			REFERENCES cfbam23.SecSess( secsessionid )
			ON DELETE CASCADE,
	classcode	VARCHAR(4) NOT NULL
		CONSTRAINT chkh_tbldefclasscode
			CHECK( classcode = 'TBLD' ),
	schemadefid	numeric(22,0) NOT NULL,
	defschtentid	numeric(22,0) NULL,
	defschid	numeric(22,0) NULL,
	name	varchar2(192) NOT NULL,
	dbname	varchar2(32) NULL,
	short_name	varchar2(16) NULL,
	label	varchar2(64) NULL,
	short_descr	varchar2(50) NULL,
	descr	varchar2(100) NULL,
	primidxtentid	numeric(22,0) NULL,
	primidxid	numeric(22,0) NULL,
	tblclscd	varchar2(4) NOT NULL,
	lookidxtentid	numeric(22,0) NULL,
	lookidxid	numeric(22,0) NULL,
	altidxtentid	numeric(22,0) NULL,
	altidxid	numeric(22,0) NULL,
	qualtentid	numeric(22,0) NULL,
	qualtblid	numeric(22,0) NULL,
	polybase	char(1) NOT NULL,
	isinstantiable	char(1) NOT NULL,
	hashistory	char(1) NOT NULL,
	hasauditcolumns	char(1) NOT NULL,
	loadbehavid	smallint NOT NULL,
	datascopeid	smallint NULL,
	secscopeid	smallint NOT NULL,
	vasecid	smallint NULL,
	easecid	smallint NULL,
	vafid	smallint NULL,
	eafid	smallint NULL,
	jobj_memb	clob NULL,
	jobj_xface	clob NULL,
	jtbl_objimp	clob NULL,
	jobj_impl	clob NULL,
	jedt_memb	clob NULL,
	jedt_xface	clob NULL,
	jtbl_eobjimp	clob NULL,
	jedt_impl	clob NULL,
	jtbl_imp	clob NULL,
	jtbl_memb	clob NULL,
	jtbl_xface	clob NULL,
	jtbl_impl	clob NULL,
	jtbl_objimp	clob NULL,
	jtbl_objmemb	clob NULL,
	jtbl_objxface	clob NULL,
	jtbl_objimpl	clob NULL,
	jtbl_db2imp	clob NULL,
	jdb2_memb	clob NULL,
	jdb2_impl	clob NULL,
	jtbl_msimp	clob NULL,
	jmssql_memb	clob NULL,
	jmssql_impl	clob NULL,
	jtbl_myimp	clob NULL,
	jmysql_memb	clob NULL,
	jmysql_impl	clob NULL,
	jtbl_oraimp	clob NULL,
	joracle_memb	clob NULL,
	joracle_impl	clob NULL,
	jtbl_pgimp	clob NULL,
	jpgsql_memb	clob NULL,
	jpgsql_impl	clob NULL,
	jtbl_sybaseimp	clob NULL,
	jsybase_memb	clob NULL,
	jsybase_impl	clob NULL,
	jtbl_ramimp	clob NULL,
	jram_memb	clob NULL,
	jram_impl	clob NULL,
	jtbl_saxldimp	clob NULL,
	jsaxstart_memb	clob NULL,
	jsaxend_impl	clob NULL,
	jxmtbl_imp	clob NULL,
	jxmtbl_fmt	clob NULL,
	jxmtbl_rqstimp	clob NULL,
	jxmtbl_rspnimp	clob NULL,
	jxmtbl_clntimp	clob NULL,
	jxmtbl_rqstbdy	clob NULL,
	jxmtbl_rspnbdy	clob NULL,
	jxmtbl_clntbdy	clob NULL,
	dflt_vis	char(1) NOT NULL,
	auditaction	SMALLINT NOT NULL,
		CONSTRAINT chkh_tbldefauditaction
			FOREIGN KEY ( auditaction )
			REFERENCES cfbam23.AuditAction( auditactionid ),
	auditstamp	TIMESTAMP NOT NULL )
	TABLESPACE cfbam23_data1;

CREATE UNIQUE INDEX tbldef_hididx ON cfbam23.tbldef_h (
	auditclusterid,
	auditstamp,
	tenantid,
	id,
	auditaction,
	revision )
	TABLESPACE cfbam23_idx1;

ALTER TABLE cfbam23.tbldef_h
	ADD CONSTRAINT pk_tbldef_hididx PRIMARY KEY ( auditclusterid, auditstamp, tenantid, id, auditaction, revision );
