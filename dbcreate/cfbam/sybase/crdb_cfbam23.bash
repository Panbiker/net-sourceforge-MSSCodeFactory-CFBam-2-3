#!/bin/bash
#
#	@(#) dbcreate/cfbam/sybase/crdb_cfbam23.bash
# 
# 	CFBam
#
#	Copyright (c) 2014-2015 Mark Sobkow
#	
#	This program is available as free software under the GNU GPL v3, under
#	the Eclipse Public License 1.0, or under a commercial license from Mark
#	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
#	
#	You should have received copies of the complete license text for
#	GPLv3.txt and EPLv1_0.txt, containing the text
#	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
#	
#	Under the terms of the GPL:
#	
#		This program is free software: you can redistribute it and/or modify
#		it under the terms of the GNU General Public License as published by
#		the Free Software Foundation, either version 3 of the License, or
#		(at your option) any later version.
#	  
#		This program is distributed in the hope that it will be useful,
#		but WITHOUT ANY WARRANTY; without even the implied warranty of
#		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#		GNU General Public License for more details.
#	  
#		You should have received a copy of the GNU General Public License
#		along with this program.  If not, see <http://www.gnu.org/licenses/>.
#	
#	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
#	and licensed under the BSD 3-Clause license as written by xfree86.org:
#	
#	Redistribution and use in source and binary forms, with or without
#	modification, are permitted provided that the following conditions are
#	met:
#	
#	    (1) Redistributions of source code must retain the above copyright
#	    notice, this list of conditions and the following disclaimer. 
#	
#	    (2) Redistributions in binary form must reproduce the above copyright
#	    notice, this list of conditions and the following disclaimer in
#	    the documentation and/or other materials provided with the
#	    distribution.  
#	    
#	    (3)The name of the author may not be used to
#	    endorse or promote products derived from this software without
#	    specific prior written permission.
#	
#	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
#	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
#	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
#	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
#	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
#	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
#	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
#	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
#	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
#	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
#	POSSIBILITY OF SUCH DAMAGE.
#	
#
# **********************************************************************
#
# 	Code manufactured by MSS Code Factory
#

#
#	Initialize locals
#
sybdb=""
sybpwd=""
sybsrv=""
sybuser=""
logfilename=""

#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case $1 in

		-D)
			shift
			sybdb=$1
			shift
			;;

		-L)
			shift
			logfilename=$1
			shift
			;;

		-P)
			shift
			sybpwd=$1
			shift
			;;

		-S)
			shift
			sybsrv=$1
			shift
			;;

		-U)
			shift
			sybuser=$1
			shift
			;;

		*)
			echo >&2 "ERROR: Option $1 not recognized."
			exit 1
			;;
	esac
done

#
#	Validate parameters
#

if [ "$sybuser" = "" ]; then
	echo >&2 "ERROR: User must be specified with '-U username'"
	exit 1
fi

if [ "$sybpwd" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	exit 1
fi

if [ "$sybsrv" = "" ]; then
	if [ "$DSQUERY" = "" ]; then
		echo >&2 "ERROR: Server was not specified with '-S server' and DSQUERY is not set"
		exit 1
	fi
fi

if [ "$sybdb" = "" ]; then
	echo >&2 "WARNING: Database was not specified with '-D database', using default for $sybuser"
	exit 1
fi

if [ "$logfilename" = "" ]; then
#	logfilename=`date +'crdb_cfbam23-%Y%m%d_%Hh%M.log'`
	logfilename="crdb_cfbam23.log"
	echo "" >$logfilename
fi

#
#	Define commands to use for running scripts
#

if [ "$sybsrv" = "" ]; then
	if [ "$sybdb" = "" ]; then
		connectargs="-U $sybuser -P $sybpwd"
		dbargs=""
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	else
		connectargs="-U $sybuser -P $sybpwd"
		dbargs="-D $sybdb"
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	fi
else
	if [ "$sybdb" = "" ]; then
		connectargs="-S $sybsrv -U $sybuser -P $sybpwd"
		dbargs=""
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	else
		connectargs="-S $sybsrv -U $sybuser -P $sybpwd"
		dbargs="-D $sybdb"
		cmdappdb="isql $connectargs $dbargs -e "
		cmdmasterdb="isql $connectargs -D master -e "
		cmdmodeldb="isql $connectargs -D model -e "
		cmdtempdb="isql $connectargs -D tempdb -e "
	fi
fi

if [ "$sybdb" = "" ]; then
	echo "Creating schema CFBam23 in default database for $sybuser"
	echo "Creating schema CFBam23 in default database for $sybuser" >>$logfilename
else
	echo "Creating schema CFBam23 in database $sybdb for $sybuser"
	echo "Creating schema CFBam23 in database $sybdb for $sybuser" >>$logfilename
fi

echo 'sp_dboption tempdb, "ddl in tran", true' >crdbcfbam23_SetDdlInTranTrue.isql
echo 'go' >>crdbcfbam23_SetDdlInTranTrue.isql
$cmdmasterdb <crdbcfbam23_SetDdlInTranTrue.isql >>%logfilename%

#
#	Create the database data device
#
if [ -f crdatadev_cfbam23.isql ]; then
	echo "	Creating database device 'cfbamdev' ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdatadev_cfbam23.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmasterdb <crdatadev_cfbam23.isql >>$logfilename
fi

#
#	Create the database
#
if [ -f crdb_cfbam23.isql ]; then
	echo "	Creating database cfbam23 ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_cfbam23.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmasterdb <crdb_cfbam23.isql >>$logfilename
fi

#
#	Create the database owner
#
if [ -f crdb_owner.isql ]; then
	echo "	Creating database owner 'cfbam23' ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_owner.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmasterdb <crdb_owner.isql >>$logfilename
	$cmdappdb <crdb_owner.isql >>$logfilename
fi

#
#	Set the database owner
#
if [ -f crdb_acquire.isql ]; then
	echo "	Setting database owner 'cfbam23' ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_acquire.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdappdb <crdb_acquire.isql >>$logfilename
fi

#
#	Drop the database types
#
if [ -f drdb_types.isql ]; then
	echo "	Dropping database types ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script drdb_types.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmodeldb <drdb_types.isql >>$logfilename
	$cmdtempdb <drdb_types.isql >>$logfilename
	$cmdappdb <drdb_types.isql >>$logfilename
fi

#
#	Create the database rules
#
if [ -f crdb_rules.isql ]; then
	echo "	Creating database rules ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_rules.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmodeldb <crdb_rules.isql >>$logfilename
	$cmdtempdb <crdb_rules.isql >>$logfilename
	$cmdappdb <crdb_rules.isql >>$logfilename
fi

#
#	Create the database types
#
if [ -f crdb_types.isql ]; then
	echo "	Creating database types ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_types.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmodeldb <crdb_types.isql >>$logfilename
	$cmdtempdb <crdb_types.isql >>$logfilename
	$cmdappdb <crdb_types.isql >>$logfilename
fi

#
#	Create the database defaults
#
if [ -f crdb_defaults.isql ]; then
	echo "	Creating database defaults ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing SQL script crdb_defaults.isql" >>$logfilename
	echo "#" >>$logfilename
	$cmdmodeldb <crdb_defaults.isql >>$logfilename
fi

#
#	Create the database tables
#
if [ -f crtbl_cfbam23.bash ]; then
	echo "	Creating database tables ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crtbl_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crtbl_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

#
#	Create the database indexes
#
if [ -f cridx_cfbam23.bash ]; then
	echo "	Creating database indexes ..."
	echo "#" >>$logfilename
	echo "#	Executing script cridx_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./cridx_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

#
#	Create the database relations
#
if [ -f crrel_cfbam23.bash ]; then
	echo "	Creating database relations ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crrel_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crrel_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

#
#	Create the database stored procedures
#
if [ -f crprocs_cfbam23.bash ]; then
	echo "	Creating database stored procedures ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crprocs_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crprocs_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

#
#	Load initial data
#
if [ -f load_cfbam23.bash ]; then
	echo "	Loading initial data ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script load_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./load_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

#
#	Create the database triggers
#
if [ -f crtrg_cfbam23.bash ]; then
	echo "	Creating database triggers ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crtrg_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crtrg_cfbam23.bash $connectargs $dbargs -L $logfilename
fi

exit 0

