@ECHO OFF
REM	@(#) dbcreate/cfbam/mssql/crdb_cfbam23.bat
REM 
REM 	CFBam
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

REM	Initialize locals
SET mssqlpwd=""
SET mssqlsrv=""
SET mssqluser=""
SET logfilename=crdb_cfbam23.log

IF NOT "%1" == "" SET mssqlsrv=%1
IF NOT "%2" == "" SET mssqluser=%2
IF NOT "%3" == "" SET mssqlpwd=%3
IF NOT "%4" == "" SET logfilename=%4

IF "%mssqluser%" == "" (
	ECHO "ERROR: User must be specified as second argument"
	PAUSE
	EXIT
)

IF "%mssqlpwd%" == "" (
	ECHO "ERROR: Password must be specified as third argument"
	PAUSE
	EXIT
)

IF "%mssqlsrv%" == "" (
	ECHO "ERROR: Server must be specified as first argument"
	PAUSE
	EXIT
)

SET cmddb=sqlcmd -S %mssqlsrv% -U %mssqluser% -P %mssqlpwd% -e

if exist %logfilename% (
	DEL %logfilename%
)


REM
REM	Drop the database, if it exists
REM
if exist drdb_cfbam23.tsql (
	echo 	Dropping any existing database 'cfbam23' ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script drdb_cfbam23.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <drdb_cfbam23.tsql >>%logfilename%
)

REM
REM	Create the database owner
REM
if exist crdb_owner.tsql (
	echo 	Creating database owner 'cfbam23' ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_owner.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_owner.tsql >>%logfilename%
)

REM
REM	Create the database logins
REM
if exist crdb_logins.tsql (
	echo 	Creating database logins ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_logins.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_logins.tsql >>%logfilename%
)

REM
REM	Create the database groups
REM
if exist crdb_groups.tsql (
	echo 	Creating database groups ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_groups.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_groups.tsql >>%logfilename%
)

REM
REM	Create the database roles
REM
if exist crdb_roles.tsql (
	echo 	Creating database roles ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_roles.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_roles.tsql >>%logfilename%
)

REM
REM	Create the database users
REM
if exist crdb_users.tsql (
	echo 	Creating database users ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_users.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_users.tsql >>%logfilename%
)

REM
REM	Create the database defaults
REM
if exist crdb_defaults.tsql (
	echo 	Creating database defaults ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_defaults.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_defaults.tsql >>%logfilename%
)

REM
REM	Create the database
REM
if exist crdb_cfbam23.tsql (
	echo 	Creating database cfbam23 ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_cfbam23.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_cfbam23.tsql >>%logfilename%
)

REM
REM	Create the database rules
REM
if exist crdb_rules.tsql (
	echo 	Creating database rules ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_rules.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_rules.tsql >>%logfilename%
)

REM
REM	Create the database types
REM
if exist crdb_types.tsql (
	echo 	Creating database types ...
	echo REM >>%logfilename%
	echo REM	Executing SQL script crdb_types.tsql >>%logfilename%
	echo REM >>%logfilename%
	%cmddb% <crdb_types.tsql >>%logfilename%
)

REM
REM	Create the database tables
REM
if exist crtbl_cfbam23.bat (
	echo 	Creating database tables ...
	echo REM >>%logfilename%
	echo REM	Executing script crtbl_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crtbl_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

REM
REM	Create the database indexes
REM
if exist cridx_cfbam23.bat (
	echo 	Creating database indexes ...
	echo REM >>%logfilename%
	echo REM	Executing script cridx_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL cridx_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

REM
REM	Create the database relations
REM
if exist crrel_cfbam23.bat (
	echo 	Creating database relations ...
	echo REM >>%logfilename%
	echo REM	Executing script crrel_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crrel_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

REM
REM	Create the database stored procedures
REM
if exist crprocs_cfbam23.bat (
	echo 	Creating database stored procedures ...
	echo REM >>%logfilename%
	echo REM	Executing script crprocs_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crprocs_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

REM
REM	Load initial data
REM
if exist load_cfbam23.bat (
	echo 	Loading initial data ...
	echo REM >>%logfilename%
	echo REM	Executing script load_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL load_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

REM
REM	Create the database triggers
REM
if exist crtrg_cfbam23.bat (
	echo 	Creating database triggers ...
	echo REM >>%logfilename%
	echo REM	Executing script crtrg_cfbam23.bat >>%logfilename%
	echo REM >>%logfilename%
	CALL crtrg_cfbam23.bat %mssqlsrv% %mssqluser% %mssqlpwd% %logfilename%
)

PAUSE
