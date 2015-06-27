// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for Service.

/*
 *	CFBam
 *
 *	Copyright (c) 2014-2015 Mark Sobkow
 *	
 *	This program is available as free software under the GNU GPL v3, under
 *	the Eclipse Public License 1.0, or under a commercial license from Mark
 *	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
 *	
 *	You should have received copies of the complete license text for
 *	GPLv3.txt and EPLv1_0.txt, containing the text
 *	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
 *	
 *	Under the terms of the GPL:
 *	
 *		This program is free software: you can redistribute it and/or modify
 *		it under the terms of the GNU General Public License as published by
 *		the Free Software Foundation, either version 3 of the License, or
 *		(at your option) any later version.
 *	  
 *		This program is distributed in the hope that it will be useful,
 *		but WITHOUT ANY WARRANTY; without even the implied warranty of
 *		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *		GNU General Public License for more details.
 *	  
 *		You should have received a copy of the GNU General Public License
 *		along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	
 *	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
 *	and licensed under the BSD 3-Clause license as written by xfree86.org:
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are
 *	met:
 *	
 *	    (1) Redistributions of source code must retain the above copyright
 *	    notice, this list of conditions and the following disclaimer. 
 *	
 *	    (2) Redistributions in binary form must reproduce the above copyright
 *	    notice, this list of conditions and the following disclaimer in
 *	    the documentation and/or other materials provided with the
 *	    distribution.  
 *	    
 *	    (3)The name of the author may not be used to
 *	    endorse or promote products derived from this software without
 *	    specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
 *	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 *	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 *	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 *	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *	POSSIBILITY OF SUCH DAMAGE.
 *	
 * ***********************************************************************
 *
 *	Code manufactured by MSS Code Factory
 */


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamOracle;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import oracle.jdbc.OracleTypes;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamOracleServiceTable Oracle 11gR2 Jdbc DbIO implementation
 *	for Service.
 */
public class CFBamOracleServiceTable
	implements ICFBamServiceTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByClusterIdx = null;
	protected PreparedStatement stmtReadBuffByHostIdx = null;
	protected PreparedStatement stmtReadBuffByTypeIdx = null;
	protected PreparedStatement stmtReadBuffByUTypeIdx = null;
	protected PreparedStatement stmtReadBuffByUHostPortIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByClusterIdx = null;
	protected PreparedStatement stmtDeleteByHostIdx = null;
	protected PreparedStatement stmtDeleteByTypeIdx = null;
	protected PreparedStatement stmtDeleteByUTypeIdx = null;
	protected PreparedStatement stmtDeleteByUHostPortIdx = null;

	public CFBamOracleServiceTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		final String S_ProcName = "createService";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			long HostNodeId = Buff.getRequiredHostNodeId();
			int ServiceTypeId = Buff.getRequiredServiceTypeId();
			short HostPort = Buff.getRequiredHostPort();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_hostsvc( ?, ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtCreateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "HSVC" );
			stmtCreateByPKey.setLong( argIdx++, ClusterId );
			stmtCreateByPKey.setLong( argIdx++, HostNodeId );
			stmtCreateByPKey.setInt( argIdx++, ServiceTypeId );
			stmtCreateByPKey.setShort( argIdx++, HostPort );
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_hostsvc() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff createdBuff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredClusterId( createdBuff.getRequiredClusterId() );
				Buff.setRequiredServiceId( createdBuff.getRequiredServiceId() );
				Buff.setRequiredHostNodeId( createdBuff.getRequiredHostNodeId() );
				Buff.setRequiredServiceTypeId( createdBuff.getRequiredServiceTypeId() );
				Buff.setRequiredHostPort( createdBuff.getRequiredHostPort() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_hostsvc() did not return a valid result set" );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtCreateByPKey != null ) {
				try {
					stmtCreateByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtCreateByPKey = null;
			}
		}
	}

	protected static String S_sqlSelectServiceDistinctClassCode = null;

	public String getSqlSelectServiceDistinctClassCode() {
		if( S_sqlSelectServiceDistinctClassCode == null ) {
			S_sqlSelectServiceDistinctClassCode =
					"SELECT "
				+		"DISTINCT hsvc.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".HostSvc hsvc ";
		}
		return( S_sqlSelectServiceDistinctClassCode );
	}

	protected static String S_sqlSelectServiceBuff = null;

	public String getSqlSelectServiceBuff() {
		if( S_sqlSelectServiceBuff == null ) {
			S_sqlSelectServiceBuff =
					"SELECT "
				+		"hsvc.ClusterId, "
				+		"hsvc.ServiceId, "
				+		"hsvc.HostNodeId, "
				+		"hsvc.ServiceTypeId, "
				+		"hsvc.HostPort, "
				+		"hsvc.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".HostSvc hsvc ";
		}
		return( S_sqlSelectServiceBuff );
	}

	protected CFBamServiceBuff unpackServiceResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackServiceResultSetToBuff";
		int idxcol = 1;
		CFBamServiceBuff buff = schema.getFactoryService().newBuff();
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedByUserId( null );
			}
			else {
				buff.setCreatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedAt( null );
			}
			else {
				buff.setCreatedAt( CFBamOracleSchema.convertTimestampString( colString ) );
			}
			idxcol++;
			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedByUserId( null );
			}
			else {
				buff.setUpdatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedAt( null );
			}
			else {
				buff.setUpdatedAt( CFBamOracleSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredClusterId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredServiceId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredHostNodeId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredServiceTypeId( resultSet.getInt( idxcol ) );
		idxcol++;
		buff.setRequiredHostPort( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamServiceBuff readDerived( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServiceBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamServiceBuff lockDerived( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServiceBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamServiceBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamServiceBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamServiceBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long ServiceId )
	{
		final String S_ProcName = "CFBamOracleServiceTable.readDerivedByIdIdx() ";
		CFBamServiceBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				ClusterId,
				ServiceId );
		return( buff );
	}

	public CFBamServiceBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readDerivedByClusterIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServiceBuff[] buffList = readBuffByClusterIdx( Authorization,
				ClusterId );
		return( buffList );

	}

	public CFBamServiceBuff[] readDerivedByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "readDerivedByHostIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServiceBuff[] buffList = readBuffByHostIdx( Authorization,
				ClusterId,
				HostNodeId );
		return( buffList );

	}

	public CFBamServiceBuff[] readDerivedByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "readDerivedByTypeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServiceBuff[] buffList = readBuffByTypeIdx( Authorization,
				ServiceTypeId );
		return( buffList );

	}

	public CFBamServiceBuff readDerivedByUTypeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamOracleServiceTable.readDerivedByUTypeIdx() ";
		CFBamServiceBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUTypeIdx( Authorization,
				ClusterId,
				HostNodeId,
				ServiceTypeId );
		return( buff );
	}

	public CFBamServiceBuff readDerivedByUHostPortIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		final String S_ProcName = "CFBamOracleServiceTable.readDerivedByUHostPortIdx() ";
		CFBamServiceBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUHostPortIdx( Authorization,
				ClusterId,
				HostNodeId,
				HostPort );
		return( buff );
	}

	public CFBamServiceBuff readBuff( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "readBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPKey = null;
		try {
			long ClusterId = PKey.getRequiredClusterId();
			long ServiceId = PKey.getRequiredServiceId();

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setLong( argIdx++, ClusterId );
			stmtReadBuffByPKey.setLong( argIdx++, ServiceId );
			stmtReadBuffByPKey.execute();
			resultSet = (ResultSet)stmtReadBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByPKey != null ) {
				try {
					stmtReadBuffByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByPKey = null;
			}
		}
	}

	public CFBamServiceBuff lockBuff( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtLockBuffByPKey = null;
		try {
			long ClusterId = PKey.getRequiredClusterId();
			long ServiceId = PKey.getRequiredServiceId();

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_hostsvc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setLong( argIdx++, ClusterId );
			stmtLockBuffByPKey.setLong( argIdx++, ServiceId );
			stmtLockBuffByPKey.execute();
			resultSet = (ResultSet)stmtLockBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtLockBuffByPKey != null ) {
				try {
					stmtLockBuffByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtLockBuffByPKey = null;
			}
		}
	}

	public CFBamServiceBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadAllBuff = null;
		try {
			CFBamServiceBuff buff = null;
			List<CFBamServiceBuff> buffList = new LinkedList<CFBamServiceBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcall( ?, ?, ?, ?, ?, ? ) ); end;" );
			int argIdx = 1;
			stmtReadAllBuff.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadAllBuff.execute();
			resultSet = (ResultSet)stmtReadAllBuff.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						buff = unpackServiceResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamServiceBuff[] retBuff = new CFBamServiceBuff[ buffList.size() ];
			Iterator<CFBamServiceBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadAllBuff != null ) {
				try {
					stmtReadAllBuff.close();
				}
				catch( SQLException e ) {
				}
				stmtReadAllBuff = null;
			}
		}
	}

	public CFBamServiceBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long ServiceId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByIdIdx.setLong( argIdx++, ServiceId );
			stmtReadBuffByIdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByIdIdx != null ) {
				try {
					stmtReadBuffByIdIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByIdIdx = null;
			}
		}
	}

	public CFBamServiceBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readBuffByClusterIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByClusterIdx = null;
		List<CFBamServiceBuff> buffList = new LinkedList<CFBamServiceBuff>();
		try {
			stmtReadBuffByClusterIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbyclusteridx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByClusterIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByClusterIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByClusterIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamServiceBuff[] retBuff = new CFBamServiceBuff[ buffList.size() ];
			Iterator<CFBamServiceBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByClusterIdx != null ) {
				try {
					stmtReadBuffByClusterIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByClusterIdx = null;
			}
		}
	}

	public CFBamServiceBuff[] readBuffByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "readBuffByHostIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByHostIdx = null;
		List<CFBamServiceBuff> buffList = new LinkedList<CFBamServiceBuff>();
		try {
			stmtReadBuffByHostIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbyhostidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByHostIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByHostIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByHostIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByHostIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByHostIdx.setLong( argIdx++, HostNodeId );
			stmtReadBuffByHostIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByHostIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamServiceBuff[] retBuff = new CFBamServiceBuff[ buffList.size() ];
			Iterator<CFBamServiceBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByHostIdx != null ) {
				try {
					stmtReadBuffByHostIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByHostIdx = null;
			}
		}
	}

	public CFBamServiceBuff[] readBuffByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "readBuffByTypeIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByTypeIdx = null;
		List<CFBamServiceBuff> buffList = new LinkedList<CFBamServiceBuff>();
		try {
			stmtReadBuffByTypeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbytypeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByTypeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByTypeIdx.setInt( argIdx++, ServiceTypeId );
			stmtReadBuffByTypeIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByTypeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamServiceBuff[] retBuff = new CFBamServiceBuff[ buffList.size() ];
			Iterator<CFBamServiceBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByTypeIdx != null ) {
				try {
					stmtReadBuffByTypeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByTypeIdx = null;
			}
		}
	}

	public CFBamServiceBuff readBuffByUTypeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		final String S_ProcName = "readBuffByUTypeIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUTypeIdx = null;
		try {
			stmtReadBuffByUTypeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbyutypeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByUTypeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUTypeIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByUTypeIdx.setLong( argIdx++, HostNodeId );
			stmtReadBuffByUTypeIdx.setInt( argIdx++, ServiceTypeId );
			stmtReadBuffByUTypeIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUTypeIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByUTypeIdx != null ) {
				try {
					stmtReadBuffByUTypeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByUTypeIdx = null;
			}
		}
	}

	public CFBamServiceBuff readBuffByUHostPortIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		final String S_ProcName = "readBuffByUHostPortIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUHostPortIdx = null;
		try {
			stmtReadBuffByUHostPortIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_hostsvcbyuhostportidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByUHostPortIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUHostPortIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUHostPortIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUHostPortIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByUHostPortIdx.setLong( argIdx++, HostNodeId );
			stmtReadBuffByUHostPortIdx.setShort( argIdx++, HostPort );
			stmtReadBuffByUHostPortIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUHostPortIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByUHostPortIdx != null ) {
				try {
					stmtReadBuffByUHostPortIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByUHostPortIdx = null;
			}
		}
	}

	public void updateService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		final String S_ProcName = "updateService";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamServiceBuff> buffList = new LinkedList<CFBamServiceBuff>();
		try {			long ClusterId = Buff.getRequiredClusterId();
			long ServiceId = Buff.getRequiredServiceId();
			long HostNodeId = Buff.getRequiredHostNodeId();
			int ServiceTypeId = Buff.getRequiredServiceTypeId();
			short HostPort = Buff.getRequiredHostPort();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_hostsvc( ?, ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"? ); end;" );
			int argIdx = 1;
			stmtUpdateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "HSVC" );
			stmtUpdateByPKey.setLong( argIdx++, ClusterId );
			stmtUpdateByPKey.setLong( argIdx++, ServiceId );
			stmtUpdateByPKey.setLong( argIdx++, HostNodeId );
			stmtUpdateByPKey.setInt( argIdx++, ServiceTypeId );
			stmtUpdateByPKey.setShort( argIdx++, HostPort );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamServiceBuff updatedBuff = unpackServiceResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredHostNodeId( updatedBuff.getRequiredHostNodeId() );
				Buff.setRequiredServiceTypeId( updatedBuff.getRequiredServiceTypeId() );
				Buff.setRequiredHostPort( updatedBuff.getRequiredHostPort() );
				Buff.setRequiredRevision( updatedBuff.getRequiredRevision() );
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
					}
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"upd_hostsvc() did not return a valid result cursor" );
				}
				finally {
					if( resultSet != null ) {
						try {
							resultSet.close();
						}
						catch( SQLException e ) {
						}
						resultSet = null;
					}
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"upd_hostsvc() did not return a result cursor" );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtUpdateByPKey != null ) {
				try {
					stmtUpdateByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtUpdateByPKey = null;
			}
		}
	}

	public void deleteService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		final String S_ProcName = "deleteService";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			long ServiceId = Buff.getRequiredServiceId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_hostsvc( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, ClusterId );
			stmtDeleteByPKey.setLong( argIdx++, ServiceId );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			stmtDeleteByPKey.execute();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtDeleteByPKey != null ) {
				try {
					stmtDeleteByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtDeleteByPKey = null;
			}
		}
	}

	public void deleteServiceByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argServiceId )
	{
		final String S_ProcName = "deleteServiceByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbyididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByIdIdx == null ) {
					stmtDeleteByIdIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByIdIdx.setLong( argIdx++, argClusterId );
				stmtDeleteByIdIdx.setLong( argIdx++, argServiceId );
				int rowsUpdated = stmtDeleteByIdIdx.executeUpdate();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				if( resultSet != null ) {
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
			}
	}

	public void deleteServiceByIdIdx( CFBamAuthorization Authorization,
		CFBamServicePKey argKey )
	{
		deleteServiceByIdIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredServiceId() );
	}

	public void deleteServiceByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "deleteServiceByClusterIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbyclusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByClusterIdx == null ) {
					stmtDeleteByClusterIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByClusterIdx.setLong( argIdx++, argClusterId );
				int rowsUpdated = stmtDeleteByClusterIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteServiceByClusterIdx( CFBamAuthorization Authorization,
		CFBamServiceByClusterIdxKey argKey )
	{
		deleteServiceByClusterIdx( Authorization,
			argKey.getRequiredClusterId() );
	}

	public void deleteServiceByHostIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId )
	{
		final String S_ProcName = "deleteServiceByHostIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbyhostidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByHostIdx == null ) {
					stmtDeleteByHostIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByHostIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByHostIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByHostIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByHostIdx.setLong( argIdx++, argClusterId );
				stmtDeleteByHostIdx.setLong( argIdx++, argHostNodeId );
				int rowsUpdated = stmtDeleteByHostIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteServiceByHostIdx( CFBamAuthorization Authorization,
		CFBamServiceByHostIdxKey argKey )
	{
		deleteServiceByHostIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredHostNodeId() );
	}

	public void deleteServiceByTypeIdx( CFBamAuthorization Authorization,
		int argServiceTypeId )
	{
		final String S_ProcName = "deleteServiceByTypeIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbytypeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByTypeIdx == null ) {
					stmtDeleteByTypeIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByTypeIdx.setInt( argIdx++, argServiceTypeId );
				int rowsUpdated = stmtDeleteByTypeIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteServiceByTypeIdx( CFBamAuthorization Authorization,
		CFBamServiceByTypeIdxKey argKey )
	{
		deleteServiceByTypeIdx( Authorization,
			argKey.getRequiredServiceTypeId() );
	}

	public void deleteServiceByUTypeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId,
		int argServiceTypeId )
	{
		final String S_ProcName = "deleteServiceByUTypeIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbyutypeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByUTypeIdx == null ) {
					stmtDeleteByUTypeIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByUTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByUTypeIdx.setLong( argIdx++, argClusterId );
				stmtDeleteByUTypeIdx.setLong( argIdx++, argHostNodeId );
				stmtDeleteByUTypeIdx.setInt( argIdx++, argServiceTypeId );
				int rowsUpdated = stmtDeleteByUTypeIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteServiceByUTypeIdx( CFBamAuthorization Authorization,
		CFBamServiceByUTypeIdxKey argKey )
	{
		deleteServiceByUTypeIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredHostNodeId(),
			argKey.getRequiredServiceTypeId() );
	}

	public void deleteServiceByUHostPortIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId,
		short argHostPort )
	{
		final String S_ProcName = "deleteServiceByUHostPortIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_hostsvcbyuhostportidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByUHostPortIdx == null ) {
					stmtDeleteByUHostPortIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUHostPortIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByUHostPortIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUHostPortIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByUHostPortIdx.setLong( argIdx++, argClusterId );
				stmtDeleteByUHostPortIdx.setLong( argIdx++, argHostNodeId );
				stmtDeleteByUHostPortIdx.setShort( argIdx++, argHostPort );
				int rowsUpdated = stmtDeleteByUHostPortIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteServiceByUHostPortIdx( CFBamAuthorization Authorization,
		CFBamServiceByUHostPortIdxKey argKey )
	{
		deleteServiceByUHostPortIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredHostNodeId(),
			argKey.getRequiredHostPort() );
	}

	public CFBamCursor openServiceCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectServiceBuff()
			+	"ORDER BY " 
			+		"hsvc.ClusterId ASC" + ", "
			+		"hsvc.ServiceId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openServiceCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		String sql = getSqlSelectServiceBuff()
			+	"WHERE "
				+		"hsvc.ClusterId = " + Long.toString( ClusterId ) + " "
			+	"ORDER BY " 
			+		"hsvc.ClusterId ASC" + ", "
			+		"hsvc.ServiceId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openServiceCursorByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		String sql = getSqlSelectServiceBuff()
			+	"WHERE "
				+		"hsvc.ClusterId = " + Long.toString( ClusterId ) + " "
			+	"AND "
				+		"hsvc.HostNodeId = " + Long.toString( HostNodeId ) + " "
			+	"ORDER BY " 
			+		"hsvc.ClusterId ASC" + ", "
			+		"hsvc.ServiceId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openServiceCursorByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		String sql = getSqlSelectServiceBuff()
			+	"WHERE "
				+		"hsvc.ServiceTypeId = " + Integer.toString( ServiceTypeId ) + " "
			+	"ORDER BY " 
			+		"hsvc.ClusterId ASC" + ", "
			+		"hsvc.ServiceId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeServiceCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeServiceCursor",
				e );
		}
	}

	public CFBamServiceBuff nextServiceCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextServiceCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamServiceBuff buff = unpackServiceResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamServiceBuff prevServiceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServiceBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServiceCursor( Cursor );
		}
		return( buff );
	}

	public CFBamServiceBuff firstServiceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServiceBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServiceCursor( Cursor );
		}
		return( buff );
	}

	public CFBamServiceBuff lastServiceCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastServiceCursor" );
	}

	public CFBamServiceBuff nthServiceCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServiceBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServiceCursor( Cursor );
		}
		return( buff );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";
		S_sqlSelectServiceBuff = null;
		S_sqlSelectServiceDistinctClassCode = null;

		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtReadBuffByPKey = null;
			}
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtLockBuffByPKey = null;
			}
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtCreateByPKey = null;
			}
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtUpdateByPKey = null;
			}
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtDeleteByPKey = null;
			}
		}
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByClusterIdx != null ) {
			try {
				stmtDeleteByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByClusterIdx = null;
		}
		if( stmtDeleteByHostIdx != null ) {
			try {
				stmtDeleteByHostIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByHostIdx = null;
		}
		if( stmtDeleteByTypeIdx != null ) {
			try {
				stmtDeleteByTypeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByTypeIdx = null;
		}
		if( stmtDeleteByUTypeIdx != null ) {
			try {
				stmtDeleteByUTypeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUTypeIdx = null;
		}
		if( stmtDeleteByUHostPortIdx != null ) {
			try {
				stmtDeleteByUHostPortIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUHostPortIdx = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtReadAllBuff = null;
			}
		}
		if( stmtReadBuffByIdIdx != null ) {
			try {
				stmtReadBuffByIdIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByIdIdx = null;
		}
		if( stmtReadBuffByClusterIdx != null ) {
			try {
				stmtReadBuffByClusterIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByClusterIdx = null;
		}
		if( stmtReadBuffByHostIdx != null ) {
			try {
				stmtReadBuffByHostIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByHostIdx = null;
		}
		if( stmtReadBuffByTypeIdx != null ) {
			try {
				stmtReadBuffByTypeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByTypeIdx = null;
		}
		if( stmtReadBuffByUTypeIdx != null ) {
			try {
				stmtReadBuffByUTypeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByUTypeIdx = null;
		}
		if( stmtReadBuffByUHostPortIdx != null ) {
			try {
				stmtReadBuffByUHostPortIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByUHostPortIdx = null;
		}
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByClusterIdx != null ) {
			try {
				stmtDeleteByClusterIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByClusterIdx = null;
		}
		if( stmtDeleteByHostIdx != null ) {
			try {
				stmtDeleteByHostIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByHostIdx = null;
		}
		if( stmtDeleteByTypeIdx != null ) {
			try {
				stmtDeleteByTypeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByTypeIdx = null;
		}
		if( stmtDeleteByUTypeIdx != null ) {
			try {
				stmtDeleteByUTypeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByUTypeIdx = null;
		}
		if( stmtDeleteByUHostPortIdx != null ) {
			try {
				stmtDeleteByUHostPortIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByUHostPortIdx = null;
		}
	}
}
