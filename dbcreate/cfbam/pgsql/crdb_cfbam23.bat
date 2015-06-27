@ECHO off
REM
REM	@(#) dbcreate/cfbam/pgsql/crdb_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2014-2015 Mark Sobkow
REM	
REM	This program is available as free software under the GNU GPL v3, under
REM	the Eclipse Public License 1.0, or under a commercial license from Mark
REM	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
REM	
REM	You should have received copies of the complete license text for
REM	GPLv3.txt and EPLv1_0.txt, containing the text
REM	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
REM	
REM	Under the terms of the GPL:
REM	
REM		This program is free software: you can redistribute it and/or modify
REM		it under the terms of the GNU General Public License as published by
REM		the Free Software Foundation, either version 3 of the License, or
REM		(at your option) any later version.
REM	  
REM		This program is distributed in the hope that it will be useful,
REM		but WITHOUT ANY WARRANTY; without even the implied warranty of
REM		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
REM		GNU General Public License for more details.
REM	  
REM		You should have received a copy of the GNU General Public License
REM		along with this program.  If not, see <http://www.gnu.org/licenses/>.
REM	
REM	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
REM	and licensed under the BSD 3-Clause license as written by xfree86.org:
REM	
REM	Redistribution and use in source and binary forms, with or without
REM	modification, are permitted provided that the following conditions are
REM	met:
REM	
REM	    (1) Redistributions of source code must retain the above copyright
REM	    notice, this list of conditions and the following disclaimer. 
REM	
REM	    (2) Redistributions in binary form must reproduce the above copyright
REM	    notice, this list of conditions and the following disclaimer in
REM	    the documentation and/or other materials provided with the
REM	    distribution.  
REM	    
REM	    (3)The name of the author may not be used to
REM	    endorse or promote products derived from this software without
REM	    specific prior written permission.
REM	
REM	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
REM	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
REM	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
REM	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
REM	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
REM	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
REM	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
REM	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
REM	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
REM	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
REM	POSSIBILITY OF SUCH DAMAGE.
REM	
REM
REM **********************************************************************
REM
REM	Code manufactured by MSS Code Factory
REM

REM
REM	Initialize locals
REM
SET pghost=""
SET pgpwd=""
SET pgsrv=""
SET pguser=""
SET logfilename=crdb_cfbam23.log
SET pgdatadir=""
IF NOT "%1" == "" SET pghost=%1
IF NOT "%2" == "" SET pguser=%2
IF NOT "%3" == "" SET pgpwd=%3
IF NOT "%4" == "" SET pgdatadir=%4
SET TK_DUALCASE_IN_CASE_STATEMENTS=true


REM
REM	Validate parameters
REM

IF "%pguser%" == "" (
	ECHO "ERROR: User must be specified as argument 2"
	PAUSE
	EXIT
)

IF "%pgpwd%" == "" (
	ECHO "ERROR: Password must be specified as argument 3"
	PAUSE
	EXIT
)

IF "%pghost%" == "" (
	ECHO "ERROR: Server host name must be specified as argument 1"
	PAUSE
	EXIT
)

SET PGPASSWORD=%pgpwd%

IF "%pgdatadir%" == "" (
	ECHO "WARNING: Database data directory was not specified as argument 4, tablespaces will not be created"
)

ECHO REM >%logfilename%


REM
REM	Create the tablespaces
REM

IF NOT "%pgdatadir%" == "" (

	ECHO Creating tablespace directories >> %logfilename%

	mkdir %pgdatadir%
	mkdir %pgdatadir%\cfbam23_data1
	mkdir %pgdatadir%\cfbam23_idx1

	ECHO >> %logfilename%
	ECHO Creating tablespaces cfbam23_data1, cfbam23_idx1
	ECHO Creating tablespaces cfbam23_data1, cfbam23_idx1 >> %logfilename%
	psql -h %pghost% -d template1 -U %pguser% -a -e -c "create tablespace cfbam23_data1 location '%pgdatadir%/cfbam23_data1'" >>%logfilename% 2>&1

	psql -h %pghost% -d template1 -U %pguser% -a -e -c "create tablespace cfbam23_idx1 location '%pgdatadir%/cfbam23_idx1'" >>%logfilename% 2>&1

)


REM 
REM Create the database instance
REM 
ECHO Recreating database cfbam23 ...
ECHO Recreating database cfbam23 ... >> %logfilename%

ECHO  >>%logfilename%
ECHO REM >>%logfilename%
ECHO REM Drop database cfbam23 >>%logfilename%
ECHO REM >>%logfilename%

psql -h %pghost% -d template1 -U %pguser% -a -e -c "drop database cfbam23" >>%logfilename% 2>&1

ECHO  >>%logfilename%
ECHO REM >>%logfilename%
ECHO REM Create database cfbam23 >>%logfilename%
ECHO REM >>%logfilename%

psql -h %pghost% -d template1 -U %pguser% -a -e -c "create database cfbam23 tablespace cfbam23_data1" >>%logfilename% 2>&1

CALL crschema_cfbam23.bat %pghost% cfbam23 %pguser% %pgpwd% %logfilename%
