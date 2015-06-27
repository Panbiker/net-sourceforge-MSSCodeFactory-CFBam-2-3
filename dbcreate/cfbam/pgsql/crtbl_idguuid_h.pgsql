--
--	@(#) dbcreate/cfbam/pgsql/crtbl_idguuid_h.pgsql
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

CREATE TABLE cfbam23.idguuid_h (
	tenantid	bigint NOT NULL,
	id	bigint NOT NULL,
	revision	INTEGER NOT NULL,
	auditclusterid	BIGINT NOT NULL,
		CONSTRAINT chk_idguuid_h_auditcluster
			FOREIGN KEY ( auditclusterid )
			REFERENCES cfbam23.clus( id )
			ON DELETE CASCADE,
	auditsessionid	VARCHAR(36) NOT NULL,
		CONSTRAINT chk_idguuid_h_auditsession
			FOREIGN KEY ( auditsessionid )
			REFERENCES cfbam23.SecSess( secsessionid )
			ON DELETE CASCADE,
	classcode	VARCHAR(4) NOT NULL
		CONSTRAINT chk_idguuid_h_classcode
			CHECK( classcode = 'IGUU' ),
	scopeid	bigint NOT NULL,
	defschtentid	bigint NULL,
	defschid	bigint NULL,
	name	varchar(192) NOT NULL,
	short_name	varchar(16) NULL,
	label	varchar(64) NULL,
	short_descr	varchar(128) NULL,
	descr	varchar(1023) NULL,
	isnullable	boolean NOT NULL,
	generateid	boolean NULL,
	datascopeid	smallint NULL,
	vasecid	smallint NULL,
	easecid	smallint NULL,
	vafid	smallint NULL,
	eafid	smallint NULL,
	prevtenantid	bigint NULL,
	previd	bigint NULL,
	nexttenantid	bigint NULL,
	nextid	bigint NULL,
	dflt_vis	boolean NOT NULL,
	dbname	varchar(32) NULL,
	initval	varchar(36) NULL,
	defval	varchar(36) NULL,
	nullval	varchar(36) NULL,
	unknownval	varchar(36) NULL,
	schemadefid	bigint NOT NULL,
	dispensertenantid	bigint NULL,
	dispenserid	bigint NULL,
	slice	smallint NOT NULL,
	blocksize	integer NOT NULL,
	auditaction	SMALLINT NOT NULL,
		CONSTRAINT chk_idguuid_h_auditaction
			FOREIGN KEY ( auditaction )
			REFERENCES cfbam23.AuditAction( auditactionid ),
	auditstamp	TIMESTAMP NOT NULL )
	WITHOUT OIDS
	TABLESPACE cfbam23_data1;

CREATE UNIQUE INDEX idguuid_h_ididx ON cfbam23.idguuid_h (
	auditclusterid,
	auditstamp,
	tenantid,
	id,
	auditaction,
	revision )
	TABLESPACE cfbam23_idx1;

ALTER TABLE cfbam23.idguuid_h
	ADD CONSTRAINT pk_idguuid_h_ididx PRIMARY KEY ( auditclusterid, auditstamp, tenantid, id, auditaction, revision );
