@ECHO OFF
REM
REM	@(REM) dbcreate/cfbam/sybase/crdb_cfbam23.bat
REM
REM	CFBam
REM
REM	Copyright (c) 2013 Mark Sobkow
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
@ECHO OFF
REM
REM	Initialize locals
REM
SET sybsrv=""
SET sybdb=""
SET sybuser=""
SET sybpwd=""
SET logfilename=crdb_cfbam23.log
IF NOT "%1" == "" SET sybsrv=%1
IF NOT "%2" == "" SET sybdb=%2
IF NOT "%3" == "" SET sybuser=%3
IF NOT "%4" == "" SET sybpwd=%4
IF NOT "%5" == "" SET logfilename=%5

IF "%sybsrv%" == "" (
	ECHO "ERROR: Sybase server must be specified as 1st argument"
	PAUSE
	EXIT
)

IF "%sybdb%" == "" (
	ECHO "ERROR: Database must be specified as 2nd argument"
	PAUSE
	EXIT
)

IF "%sybuser%" == "" (
	ECHO "ERROR: User must be specified as 3rd argument"
	PAUSE
	EXIT
)

IF "%sybpwd%" == "" (
	ECHO "ERROR: Password must be specified as 4th argument"
	PAUSE
	EXIT
)

REM
REM	Define commands to use for running scripts
REM
SET cmdappdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D %sybdb% -e 
SET cmdmasterdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D master -e 
SET cmdmodeldb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D model -e 
SET cmdtempdb=isql -S %sybsrv% -U %sybuser% -P %sybpwd% -D tempdb -e 

if exist %logfilename% (
	del %logfilename%
)

if "%sybdb%" == "" (
	echo Creating schema CFBam23 in default database for %sybuser%
	echo Creating schema CFBam23 in default database for %sybuser% >>%logfilename%
)
if not "%sybdb%" == "" (
	echo Creating schema CFBam23 in database %sybdb% for %sybuser%
	echo Creating schema CFBam23 in database %sybdb% for %sybuser% >>%logfilename%
)

echo sp_dboption tempdb, "ddl in tran", true >crdbcfbam23_SetDdlInTranTrue.isql
echo go >>crdbcfbam23_SetDdlInTranTrue.isql
%cmdmasterdb% <crdbcfbam23_SetDdlInTranTrue.isql >>%logfilename%

REM
REM	Create the database data device
REM
if exist crdatadev_cfbam23.isql (
	echo 	Creating database device 'cfbamdev' ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdatadev_cfbam23.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmasterdb% <crdatadev_cfbam23.isql >>%logfilename%
)

REM
REM	Create the database
REM
if exist crdb_cfbam23.isql (
	echo 	Creating database cfbam23 ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_cfbam23.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmasterdb% <crdb_cfbam23.isql >>%logfilename%
)

REM
REM	Create the database owner
REM
if exist crdb_owner.isql (
	echo 	Creating database owner 'cfbam23' ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_owner.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmasterdb% <crdb_owner.isql >>%logfilename%
	%cmdappdb% <crdb_owner.isql >>%logfilename%
)

REM
REM	Set the database owner
REM
if exist crdb_acquire.isql (
	echo 	Setting database owner 'cfbam23' ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_acquire.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdappdb% <crdb_acquire.isql >>%logfilename%
)

REM
REM	Drop the database types
REM
if exist drdb_types.isql (
	echo 	Dropping database types ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script drdb_types.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmodeldb% <drdb_types.isql >>%logfilename%
	%cmdtempdb% <drdb_types.isql >>%logfilename%
	%cmdappdb% <drdb_types.isql >>%logfilename%
)

REM
REM	Create the database rules
REM
if exist crdb_rules.isql (
	echo 	Creating database rules ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_rules.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmodeldb% <crdb_rules.isql >>%logfilename%
	%cmdtempdb% <crdb_rules.isql >>%logfilename%
	%cmdappdb% <crdb_rules.isql >>%logfilename%
)

REM
REM	Create the database types
REM
if exist crdb_types.isql (
	echo 	Creating database types ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_types.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmodeldb% <crdb_types.isql >>%logfilename%
	%cmdtempdb% <crdb_types.isql >>%logfilename%
	%cmdappdb% <crdb_types.isql >>%logfilename%
)

REM
REM	Create the database defaults
REM
if exist crdb_defaults.isql (
	echo 	Creating database defaults ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_defaults.isql >>%logfilename%
	echo REM >>%logfilename%
	%cmdmodeldb% <crdb_defaults.isql >>%logfilename%
)

REM
REM	Create the database tables
REM
if exist crtbl_cfbam23.bat (
	echo 	Creating database tables ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing script crtbl_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crtbl_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

REM
REM	Create the database indexes
REM
if exist cridx_cfbam23.bat (
	echo 	Creating database indexes ...
	echo REM >>%logfilename%
	echo REM	Executing script cridx_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL cridx_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

REM
REM	Create the database relations
REM
if exist crrel_cfbam23.bat (
	echo 	Creating database relations ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing script crrel_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crrel_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

REM
REM	Create the database stored procedures
REM
if exist crprocs_cfbam23.bat (
	echo 	Creating database stored procedures ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing script crprocs_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crprocs_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

REM
REM	Load initial data
REM
if exist load_cfbam23.bat (
	echo 	Loading initial data ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing script load_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL load_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

REM
REM	Create the database triggers
REM
if exist crtrg_cfbam23.bat (
	echo 	Creating database triggers ...
	echo  >>%logfilename%
	echo REM >>%logfilename%
	echo REM	Executing script crtrg_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crtrg_cfbam23.bat %sybsrv% %sybdb% %sybuser% %sybpwd% %logfilename%
)

pause

