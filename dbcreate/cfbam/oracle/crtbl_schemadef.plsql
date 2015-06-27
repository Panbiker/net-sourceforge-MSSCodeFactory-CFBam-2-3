--
--	@(#) dbcreate/cfbam/oracle/crtbl_schemadef.plsql
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

CREATE TABLE cfbam23.schemadef (
	tenantid	numeric(22,0) NOT NULL,
	id	numeric(22,0) NOT NULL,
	domainid	numeric(22,0) NOT NULL,
	name	varchar2(192) NOT NULL,
	dbname	varchar2(12) NULL,
	short_name	varchar2(16) NULL,
	label	varchar2(64) NULL,
	short_descr	varchar2(128) NULL,
	descr	varchar2(1023) NULL,
	defaultlicensetenantid	numeric(22,0) NULL,
	deflcnid	numeric(22,0) NULL,
	extendcfcore	char(1) NOT NULL,
	datascopeid	smallint NULL,
	vaccsecid	smallint NULL,
	eaccsecid	smallint NULL,
	vaccfreqid	smallint NULL,
	eaccfreqid	smallint NULL,
	copyperd	varchar2(10) NOT NULL,
	copyhold	varchar2(511) NOT NULL,
	puburi	varchar2(512) NOT NULL,
	jobj_import	clob NULL,
	jobj_xface	clob NULL,
	jobj_memb	clob NULL,
	jobj_impl	clob NULL,
	jdb2_memb	clob NULL,
	jdb2_impl	clob NULL,
	jdb2_import	clob NULL,
	jmssql_memb	clob NULL,
	jmssql_impl	clob NULL,
	jmssql_import	clob NULL,
	jmysql_memb	clob NULL,
	jmysql_impl	clob NULL,
	jmysql_import	clob NULL,
	joracle_memb	clob NULL,
	joracle_impl	clob NULL,
	joracle_import	clob NULL,
	jpgsql_memb	clob NULL,
	jpgsql_impl	clob NULL,
	jpgsql_import	clob NULL,
	jsybase_memb	clob NULL,
	jsybase_impl	clob NULL,
	jsybase_import	clob NULL,
	jram_memb	clob NULL,
	jram_impl	clob NULL,
	jram_impl	clob NULL,
	javaxmsgschimp	clob NULL,
	javaxmsgschfmts	clob NULL,
	javaxmsgcltschimp	clob NULL,
	javaxmsgcltschbdy	clob NULL,
	javaxmsgrqstschbdy	clob NULL,
	javaxmsgrqstschimp	clob NULL,
	javaxmsgrqstschwirep	clob NULL,
	javaxmsgrqstschxsdspec	clob NULL,
	javaxmsgrqstschxsdeltlst	clob NULL,
	javaxmsgrspnschemabody	clob NULL,
	javaxmsgrspnschimp	clob NULL,
	javaxmsgrspnschwirep	clob NULL,
	javaxmsgrspnschxsdeltlst	clob NULL,
	javaxmsgrspnschxsdspec	clob NULL)
TABLESPACE cfbam23_data1;

CREATE UNIQUE INDEX schemadef_pk ON cfbam23.schemadef (
	tenantid,
	id ) TABLESPACE cfbam23_idx1;

ALTER TABLE cfbam23.schemadef
	ADD CONSTRAINT pk_schemadef_pk PRIMARY KEY ( tenantid, id );

