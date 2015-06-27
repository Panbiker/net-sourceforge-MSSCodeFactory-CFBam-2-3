--
--	@(#) dbcreate/cfbam/oracle/crtbl_valdef.plsql
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

CREATE TABLE cfbam23.valdef (
	classcode	VARCHAR(4) NOT NULL
		CONSTRAINT chk_valdef_classcode
			CHECK( classcode IN ( 'VALU' , 'TBLC', 'ATOM', 'BLBD', 'BLBC', 'BLBT', 'BOLD', 'BOLC', 'BOLT', 'I16D', 'I16C', 'I16T', 'IG16', 'ENMD', 'ENMC', 'ENMT', 'I32D', 'I32C', 'I32T', 'IG32', 'I64D', 'I64C', 'I64T', 'IG64', 'U16D', 'U16C', 'U16T', 'U32D', 'U32C', 'U32T', 'U64D', 'U64C', 'U64T', 'FLTD', 'FLTC', 'FLTT', 'DBLD', 'DBLC', 'DBLT', 'NUMD', 'NUMC', 'NUMT', 'STRD', 'STRC', 'STRT', 'TXTD', 'TXTC', 'TXTT', 'NTKD', 'NTKC', 'NTKT', 'NTSD', 'NTSC', 'NTST', 'TKND', 'TKNC', 'TKNT', 'DATD', 'DATC', 'DATT', 'TIMD', 'TIMC', 'TIMT', 'TSPD', 'TSPC', 'TSPT', 'DAZD', 'DAZC', 'DAZT', 'TMZD', 'TMZC', 'TMZT', 'ZSTD', 'ZSTC', 'ZSTT', 'UIDD', 'UIDC', 'UIDT', 'IGUU' )),
	createdat	TIMESTAMP NOT NULL,
	createdby	VARCHAR(36) NOT NULL,
	updatedat	TIMESTAMP NOT NULL,
	updatedby	VARCHAR(36) NOT NULL,
	tenantid	numeric(22,0) NOT NULL,
	scopeid	numeric(22,0) NOT NULL,
	id	numeric(22,0) NOT NULL,
	defschtentid	numeric(22,0) NULL,
	defschid	numeric(22,0) NULL,
	name	varchar2(192) NOT NULL,
	short_name	varchar2(16) NULL,
	label	varchar2(64) NULL,
	short_descr	varchar2(128) NULL,
	descr	varchar2(1023) NULL,
	isnullable	char(1) NOT NULL,
	generateid	char(1) NULL,
	datascopeid	smallint NULL,
	vasecid	smallint NULL,
	easecid	smallint NULL,
	vafid	smallint NULL,
	eafid	smallint NULL,
	prevtenantid	numeric(22,0) NULL,
	previd	numeric(22,0) NULL,
	nexttenantid	numeric(22,0) NULL,
	nextid	numeric(22,0) NULL,
	dflt_vis	char(1) NOT NULL,
	revision	INTEGER NOT NULL)
TABLESPACE cfbam23_data1;

CREATE UNIQUE INDEX valdef_pk ON cfbam23.valdef (
	tenantid,
	id ) TABLESPACE cfbam23_idx1;

ALTER TABLE cfbam23.valdef
	ADD CONSTRAINT pk_valdef_pk PRIMARY KEY ( tenantid, id );

