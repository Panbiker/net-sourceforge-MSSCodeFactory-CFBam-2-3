--
--	@(#) dbcreate/cfbam/db2luw/crtbl_uint64typ_h.sql
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

CREATE TABLE cfbam23.uint64typ_h (	\
	tenantid	BIGINT NOT NULL,	\
	id	BIGINT NOT NULL,	\
	Revision	int NOT NULL,	\
	auditclusterid	BIGINT NOT NULL,	\
		CONSTRAINT chk_uint64typ_h_auditcluster	\
			FOREIGN KEY ( auditclusterid )	\
			REFERENCES cfbam23.clus( id )	\
			ON DELETE CASCADE,	\
	auditsessionid	VARCHAR(36) NOT NULL,	\
		CONSTRAINT chk_uint64typ_h_auditsession	\
			FOREIGN KEY ( auditsessionid )	\
			REFERENCES cfbam23.SecSess( secsessionid )	\
			ON DELETE CASCADE,	\
	classcode	VARCHAR(4) NOT NULL	\
		CONSTRAINT chk_uint64typ_h_classcode	\
			CHECK( classcode = 'U64T' ),	\
	ScopeId	BIGINT NOT NULL,	\
	defschtentid	BIGINT,	\
	defschid	BIGINT,	\
	Name	VARCHAR(192) NOT NULL,	\
	short_name	VARCHAR(16),	\
	Label	VARCHAR(64),	\
	short_descr	VARCHAR(128),	\
	descr	VARCHAR(1023),	\
	IsNullable	CHAR(1) NOT NULL,	\
	GenerateId	CHAR(1),	\
	DataScopeId	SMALLINT,	\
	VASecId	SMALLINT,	\
	EASecId	SMALLINT,	\
	VAFId	SMALLINT,	\
	EAFId	SMALLINT,	\
	PrevTenantId	BIGINT,	\
	PrevId	BIGINT,	\
	NextTenantId	BIGINT,	\
	NextId	BIGINT,	\
	dflt_vis	CHAR(1) NOT NULL,	\
	DbName	VARCHAR(32),	\
	InitVal	DECIMAL(22,0),	\
	DefVal	DECIMAL(22,0),	\
	MinVal	DECIMAL(22,0),	\
	MaxVal	DECIMAL(22,0),	\
	NullValue	DECIMAL(22,0),	\
	UnknownVal	DECIMAL(22,0),	\
	SchemaDefId	BIGINT NOT NULL,	\
	auditaction	SMALLINT NOT NULL,	\
		CONSTRAINT chk_uint64typ_h_auditaction	\
			FOREIGN KEY ( auditaction )	\
			REFERENCES cfbam23.AuditAction( auditactionid ),	\
	auditstamp	TIMESTAMP NOT NULL )	\
IN msidata1

CREATE UNIQUE INDEX cfbam23.uint64typ_h_ididx ON cfbam23.uint64typ_h (	\
	auditclusterid,	\
	auditstamp,	\
	TenantId DESC,	\
	Id DESC,	\
	auditaction,	\
	revision )

ALTER TABLE cfbam23.uint64typ_h	\
	ADD CONSTRAINT pk_uint64typ_pk_h PRIMARY KEY (	\
	auditclusterid,	\
	auditstamp, TenantId, Id,	\
	auditaction,	\
	revision )

