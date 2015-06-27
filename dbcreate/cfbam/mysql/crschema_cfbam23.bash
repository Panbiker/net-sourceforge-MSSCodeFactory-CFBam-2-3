#!/bin/bash
#
#	@(#) dbcreate/cfbam/mysql/crschema_cfbam23.bash
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
mysqlpwd=""
mysqluser=""
logfilename=""
parmerrors=""
TK_DUALCASE_IN_CASE_STATEMENTS=true

#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case "$1" in

		-L)
			shift
			logfilename=$1
			shift
			;;

		-P)
			shift
			mysqlpwd=$1
			shift
			;;

		-U)
			shift
			mysqluser=$1
			shift
			;;

		*)
			echo >&2 "ERROR: Option $1 not recognized."
			shift
			parmerrors="Y"
			;;
	esac
done

#
#	Validate parameters
#

if [ "$mysqluser" = "" ]; then
	echo >&2 "ERROR: MySQL user must be specified with '-U username'"
	parmerrors="Y"
fi

if [ "$mysqlpwd" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	parmerrors="Y"
fi

if [ "$parmerrors" != "" ]; then
	echo >&2 "ABORT: Cannot continue"
	exit 1
fi

if [ "$logfilename" = "" ]; then
	logfilename=`date +'crschema_cfbam23-%Y%m%d_%Hh%M.log'`
	echo "" >$logfilename
fi

echo "Dropping any existing schema CFBam23 for $mysqluser"
echo "Dropping any existing schema CFBam23 for $mysqluser" >>$logfilename
mysql -v -u $mysqluser --password=$mysqlpwd --execute="drop schema cfbam23" >>$logfilename 2>&1

echo "Creating schema CFBam23 for $mysqluser"
echo "Creating schema CFBam23 $mysqluser" >>$logfilename
mysql -v -u $mysqluser --password=$mysqlpwd --execute="create schema cfbam23" >>$logfilename 2>&1


#
#	Create the database tables
#
if [ -f crtbl_cfbam23.bash ]; then
	echo "	Creating database tables ..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crtbl_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crtbl_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
fi

#
#	Create the database indexes
#
if [ -f cridx_cfbam23.bash ]; then
	echo "	Creating database indexes ..."
	echo "#" >>$logfilename
	echo "#	Executing script cridx_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./cridx_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
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
	./crrel_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
fi

#
#	Create the stored procedureds
#
if [ -f crprocs_cfbam23.bash ]; then
	echo "	Creating stored procedures..."
	echo "" >>$logfilename
	echo "#" >>$logfilename
	echo "#	Executing script crprocs_cfbam23.bash" >>$logfilename
	echo "#" >>$logfilename
	./crprocs_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
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
	./load_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
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
	./crtrg_cfbam23.bash -U $mysqluser -P $mysqlpwd -L $logfilename
fi

exit 0

