#!/bin/bash
#
#	@(#) dbcreate/cfbam/pgsql/crdb_cfbam23.bash
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
pgdatadir=""
pgdb=""
pghost=""
pgport=""
pgpwd=""
pgsrv=""
pguser=""
logfilename=""
parmerrors=""
TK_DUALCASE_IN_CASE_STATEMENTS=true


#
#	Parse the command line options
#
while [ -n "$1" ]
do
	case "$1" in

		-D)
			shift
			pgdatadir=$1
			shift
			;;

		-d)
			shift
			pgdb=$1
			shift
			;;

		-L)
			shift
			logfilename=$1
			shift
			;;

		-H)
			shift
			pghost=$1
			shift
			;;

		-p)
			shift
			pgport=$1
			shift
			;;

		-P)
			shift
			pgpwd=$1
			shift
			;;

		-S)
			shift
			pgsrv=$1
			shift
			;;

		-U)
			shift
			pguser=$1
			shift
			;;

		*)
			echo >&2 "ERROR: Option $1 not recognized."
			parmerrors="Y"
			shift
			;;
	esac
done


#
#	Validate parameters
#

if [ "${pguser}" = "" ]; then
	echo >&2 "WARNING: Postgres DBA login not specified with '-U username', using default 'postgres'"
fi

if [ "${pgpwd}" = "" ]; then
	echo >&2 "ERROR: Password must be specified with '-P password'"
	parmerrors="Y"
fi

if [ "${pghost}" = "" ]; then
	echo >&2 "ERROR: Server hostname must be specified with '-H hostname'"
	parmerrors="Y"
fi

if [ "${pgdatadir}" = "" ]; then
	echo >&2 "WARNING: Database data directory was not specified with '-D directory', tablespaces will not be created"
fi

if [ "$parmerrors" != "" ]; then
	echo >&2 "ABORT: Cannot continue"
	exit 1
fi

if [ "${logfilename}" = "" ]; then
	logfilename=`date +'crdb_cfbam23-%Y%m%d_%Hh%M.log'`
	echo "" >${logfilename}
fi

export PGPASSWORD="${pgpwd}"

if [ "${pgport}" != "" ]; then
	export PGPORT="--port=${pgport} "
	export PASSPGPORT="-p ${pgport} "
else
	export PGPORT=""
	export PASSPGPORT=""
fi


#
#	Create the tablespaces
#

if [ "${pgdatadir}" != "" ]; then

	need_dirs="N"

	if [ ! -d ${pgdatadir} ]; then
		need_dirs="Y"
	fi

	if [ ! -d ${pgdatadir}/cfbam23_data1 ]; then
		need_dirs="Y"
	fi

	if [ ! -d ${pgdatadir}/cfbam23_idx1 ]; then
		need_dirs="Y"
	fi

	if [ "${need_dirs}" = "Y" ]; then
		echo "Creating tablespace directories" | tee -a ${logfilename}

		if [ "${OS}" != "Windows_NT" ]; then
			su ${pguser} --command="mkdir ${pgdatadir} ${pgdatadir}/cfbam23_data1 ${pgdatadir}/cfbam23_idx1"
		else
			runas /user:${COMPUTERNAME}\\${pguser} "mkdir ${pgdatadir} ${pgdatadir}/cfbam23_data1 ${pgdatadir}/cfbam23_idx1"
		fi
	fi

	echo "" | tee -a ${logfilename}
	echo "Creating tablespaces cfbam23_data1 and cfbam23_idx1" | tee -a ${logfilename}
	psql -h ${pghost} ${PGPORT} -d template1 -U ${pguser} -a -e -c "create tablespace cfbam23_data1 location '${pgdatadir}/cfbam23_data1'" >>${logfilename} 2>&1

	psql -h ${pghost} ${PGPORT} -d template1 -U ${pguser} -a -e -c "create tablespace cfbam23_idx1 location '${pgdatadir}/cfbam23_idx1'" >>${logfilename} 2>&1

fi


#
#	Recreate the database instance
#
echo "Recreating database cfbam23 ..." | tee -a ${logfilename}

echo "" >>${logfilename}
echo "#" >>${logfilename}
echo "#	Drop database cfbam23" >>${logfilename}
echo "#" >>${logfilename}

psql -h ${pghost} ${PGPORT} -d template1 -U ${pguser} -a -e -c "drop database cfbam23" >>${logfilename} 2>&1

echo "" >>${logfilename}
echo "#" >>${logfilename}
echo "#	Create database cfbam23" >>${logfilename}
echo "#" >>${logfilename}

psql -h ${pghost} ${PGPORT} -d template1 -U ${pguser} -a -e -c "create database cfbam23 tablespace cfbam23_data1" >>${logfilename} 2>&1

./crschema_cfbam23.bash -H ${pghost} ${PASSPGPORT} -d cfbam23 -U ${pguser} -P ${pgpwd} -L ${logfilename}
