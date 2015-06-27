// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for SecDevice.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMSSql;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamMSSqlSecDeviceTable PostgreSQL Jdbc DbIO implementation
 *	for SecDevice.
 */
public class CFBamMSSqlSecDeviceTable
	implements ICFBamSecDeviceTable
{
	private CFBamMSSqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtAuditCreatedByPKey = null;
	protected PreparedStatement stmtAuditUpdatedByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByUserIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByUserIdx = null;

	public CFBamMSSqlSecDeviceTable( CFBamMSSqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		final String S_ProcName = "createSecDevice";
		if( "SDEV".equals( Buff.getClassCode() )
			&& ( ! schema.isSystemUser( Authorization ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- only system user can modify SecDevice data" );
		}
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = Buff.getRequiredSecUserId();
			String DevName = Buff.getRequiredDevName();
			String PubKey = Buff.getOptionalPubKey();
			int Revision = 1;
			String sql =
					"INSERT INTO " + schema.getLowerDbSchemaName() + "..SecDev( "
				+		"forcesynclock, "
				+		"createdby, "
				+		"createdat, "
				+		"updatedby, "
				+		"updatedat, "
				+		"secuserid, "
				+		"devname, "
				+		"pubkey"
				+		", revision )"
				+	"VALUES ( "
				+		"0, "
				+		" ?, "
				+		" getdate(), "
				+		" ?, "
				+		" getdate(), "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"1 )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setString( argIdx++, Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, SecUserId.toString() );
			stmtCreateByPKey.setString( argIdx++, DevName );
			if( PubKey != null ) {
				stmtCreateByPKey.setString( argIdx++, PubKey );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			int rowsAffected = stmtCreateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by insert, not " + rowsAffected );
			}
			Buff.setRequiredRevision( Revision );
			String sqlAuditCreated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..SecDev_h( auditclusterid, "
					+		" auditsessionid, "
					+		" auditstamp" + ", "
					+		"secuserid" + ", "
					+		"devname" + ", "
					+		"pubkey" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime()" + ", "
					+		"sdev.secuserid"  + ", "
					+		"sdev.devname"  + ", "
					+		"sdev.pubkey" + ", "
					+		" sdev.revision, "
					+		" 1"
					+	"FROM " + schema.getLowerDbSchemaName() + "..SecDev AS sdev "
					+	" WHERE "
					+				"sdev.secuserid = ? "
					+			"AND sdev.devname = ? ";
			if( stmtAuditCreatedByPKey == null ) {
				stmtAuditCreatedByPKey = cnx.prepareStatement( sqlAuditCreated );
			}
			argIdx = 1;
			stmtAuditCreatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
			stmtAuditCreatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditCreatedByPKey.setString( argIdx++, SecUserId.toString() );
				stmtAuditCreatedByPKey.setString( argIdx++, DevName );
			int rowsAudited = stmtAuditCreatedByPKey.executeUpdate();
			if( rowsAudited != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
			}

		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	protected static String S_sqlSelectSecDeviceDistinctClassCode = null;

	public String getSqlSelectSecDeviceDistinctClassCode() {
		if( S_sqlSelectSecDeviceDistinctClassCode == null ) {
			S_sqlSelectSecDeviceDistinctClassCode =
					"SELECT "
				+		"DISTINCT sdev.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..SecDev AS sdev ";
		}
		return( S_sqlSelectSecDeviceDistinctClassCode );
	}

	protected static String S_sqlSelectSecDeviceBuff = null;

	public String getSqlSelectSecDeviceBuff() {
		if( S_sqlSelectSecDeviceBuff == null ) {
			S_sqlSelectSecDeviceBuff =
					"SELECT "
				+		"sdev.secuserid, "
				+		"sdev.devname, "
				+		"sdev.pubkey, "
				+		"sdev.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..SecDev AS sdev ";
		}
		return( S_sqlSelectSecDeviceBuff );
	}

	protected CFBamSecDeviceBuff unpackSecDeviceResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSecDeviceResultSetToBuff";
		int idxcol = 1;
		CFBamSecDeviceBuff buff = schema.getFactorySecDevice().newBuff();
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
				buff.setCreatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
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
				buff.setUpdatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredSecUserId( CFBamMSSqlSchema.convertUuidString( resultSet.getString( idxcol ) ) );
		idxcol++;
		buff.setRequiredDevName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPubKey( null );
			}
			else {
				buff.setOptionalPubKey( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSecDeviceBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecDeviceBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecDeviceBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecDeviceBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecDeviceBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSecDeviceBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSecDeviceBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFBamMSSqlSecDeviceTable.readDerivedByIdIdx() ";
		CFBamSecDeviceBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				SecUserId,
				DevName );
		return( buff );
	}

	public CFBamSecDeviceBuff[] readDerivedByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "readDerivedByUserIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecDeviceBuff[] buffList = readBuffByUserIdx( Authorization,
				SecUserId );
		return( buffList );

	}

	public CFBamSecDeviceBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "readBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = PKey.getRequiredSecUserId();
			String DevName = PKey.getRequiredDevName();
			String sql = "{ call sp_read_secdev( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByPKey == null ) {
				stmtReadBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setString( argIdx++, SecUserId.toString() );
			stmtReadBuffByPKey.setString( argIdx++, DevName );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
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

	public CFBamSecDeviceBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = PKey.getRequiredSecUserId();
			String DevName = PKey.getRequiredDevName();
			String sql = "{ call sp_lock_secdev( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtLockBuffByPKey == null ) {
				stmtLockBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setString( argIdx++, SecUserId.toString() );
			stmtLockBuffByPKey.setString( argIdx++, DevName );
			stmtLockBuffByPKey.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtLockBuffByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtLockBuffByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtLockBuffByPKey.getUpdateCount() ) {
					break;
				}
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
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

	public CFBamSecDeviceBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_secdev_all( ?, ?, ?, ?, ? ) }";
			if( stmtReadAllBuff == null ) {
				stmtReadAllBuff = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			resultSet = stmtReadAllBuff.executeQuery();
			List<CFBamSecDeviceBuff> buffList = new LinkedList<CFBamSecDeviceBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSecDeviceBuff[] retBuff = new CFBamSecDeviceBuff[ buffList.size() ];
			Iterator<CFBamSecDeviceBuff> iter = buffList.iterator();
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
		}
	}

	public CFBamSecDeviceBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_secdev_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByIdIdx == null ) {
				stmtReadBuffByIdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setString( argIdx++, SecUserId.toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, DevName );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
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

	public CFBamSecDeviceBuff[] readBuffByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "readBuffByUserIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_secdev_by_useridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByUserIdx == null ) {
				stmtReadBuffByUserIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUserIdx.setString( argIdx++, SecUserId.toString() );
			resultSet = stmtReadBuffByUserIdx.executeQuery();
			List<CFBamSecDeviceBuff> buffList = new LinkedList<CFBamSecDeviceBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSecDeviceBuff[] retBuff = new CFBamSecDeviceBuff[ buffList.size() ];
			Iterator<CFBamSecDeviceBuff> iter = buffList.iterator();
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
		}
	}

	public void updateSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		final String S_ProcName = "updateSecDevice";
		if( "SDEV".equals( Buff.getClassCode() )
			&& ( ! schema.isSystemUser( Authorization ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- only system user can modify SecDevice data" );
		}
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = Buff.getRequiredSecUserId();
			String DevName = Buff.getRequiredDevName();
			String PubKey = Buff.getOptionalPubKey();
			int Revision = Buff.getRequiredRevision();
			CFBamSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
			pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
			pkey.setRequiredDevName( Buff.getRequiredDevName() );
			CFBamSecDeviceBuff readBuff = lockBuff( Authorization, pkey );
			if( readBuff == null ) {
				throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
					S_ProcName,
					"Attempted to update record which could not be locked/found",
					schema.getLowerDbSchemaName() + "..secdev",
					pkey );
			}
			int oldRevision = readBuff.getRequiredRevision();
			if( oldRevision != Revision ) {
				throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
					S_ProcName,
					Buff );
			}
			int newRevision = Revision + 1;
			String sql =
					"UPDATE " + schema.getLowerDbSchemaName() + "..SecDev "
				+	"SET "
				+		"secuserid = ?" + ", "
				+		"devname = ?" + ", "
				+		"pubkey = ?" + ", "
				+		"updatedby = ?, "
				+		"updatedat = sysdatetime() "
				+		", revision = ? "
				+	" WHERE "
				+		"secuserid = ? "
				+	"AND "
				+		"devname = ? "
				+	"AND "
				+		"revision = ? ";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;

			stmtUpdateByPKey.setString( argIdx++, SecUserId.toString() );
			stmtUpdateByPKey.setString( argIdx++, DevName );
			if( PubKey != null ) {
				stmtUpdateByPKey.setString( argIdx++, PubKey );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setString( argIdx++, Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setInt( argIdx++, newRevision );
			stmtUpdateByPKey.setString( argIdx++, SecUserId.toString() );
			stmtUpdateByPKey.setString( argIdx++, DevName );
			stmtUpdateByPKey.setInt( argIdx++, Revision );;
			int rowsAffected = stmtUpdateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by update, not " + rowsAffected );
			}
			Buff.setRequiredRevision( newRevision );
			String sqlAuditUpdated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..SecDev_h( auditclusterid, "
					+		" auditsessionid, "
					+		" auditstamp" + ", "
					+		"secuserid" + ", "
					+		"devname" + ", "
					+		"pubkey" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime()" + ", "
					+		"sdev.secuserid"  + ", "
					+		"sdev.devname"  + ", "
					+		"sdev.pubkey" + ", "
					+		" sdev.revision, "
					+		" 2 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..SecDev AS sdev "
					+	" WHERE "
					+				"sdev.secuserid = ? "
					+			"AND sdev.devname = ? ";
			if( stmtAuditUpdatedByPKey == null ) {
				stmtAuditUpdatedByPKey = cnx.prepareStatement( sqlAuditUpdated );
			}
			argIdx = 1;
			stmtAuditUpdatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
			stmtAuditUpdatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditUpdatedByPKey.setString( argIdx++, SecUserId.toString() );
				stmtAuditUpdatedByPKey.setString( argIdx++, DevName );
			int rowsAudited = stmtAuditUpdatedByPKey.executeUpdate();
			if( rowsAudited != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public void deleteSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		final String S_ProcName = "deleteSecDevice";
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = Buff.getRequiredSecUserId();
			String DevName = Buff.getRequiredDevName();

			String sql = "exec sp_delete_secdev ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByPKey == null ) {
				stmtDeleteByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setString( argIdx++, SecUserId.toString() );
			stmtDeleteByPKey.setString( argIdx++, DevName );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			Object stuff = null;
			boolean moreResults = stmtDeleteByPKey.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByPKey.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public void deleteSecDeviceByIdIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		String argDevName )
	{
		final String S_ProcName = "deleteSecDeviceByIdIdx";
		// MSS TODO WORKING
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName );
	}

	public void deleteSecDeviceByIdIdx( CFBamAuthorization Authorization,
		CFBamSecDevicePKey argKey )
	{
		deleteSecDeviceByIdIdx( Authorization,
			argKey.getRequiredSecUserId(),
			argKey.getRequiredDevName() );
	}

	public void deleteSecDeviceByUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		final String S_ProcName = "deleteSecDeviceByUserIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_secdev_by_useridx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByUserIdx== null ) {
				stmtDeleteByUserIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUserIdx.setString( argIdx++, argSecUserId.toString() );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUserIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUserIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUserIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUserIdx.getUpdateCount() ) {
					break;
				}
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
		}
	}

	public void deleteSecDeviceByUserIdx( CFBamAuthorization Authorization,
		CFBamSecDeviceByUserIdxKey argKey )
	{
		deleteSecDeviceByUserIdx( Authorization,
			argKey.getRequiredSecUserId() );
	}

	public CFBamCursor openSecDeviceCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectSecDeviceBuff()
			+	"ORDER BY " 
			+		"sdev.SecUserId ASC" + ", "
			+		"sdev.DevName ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecDeviceCursorByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		String sql = getSqlSelectSecDeviceBuff()
			+	" WHERE "
				+		"sdev.secuserid = '" + SecUserId.toString() + "' "
			+	"ORDER BY " 
			+		"sdev.SecUserId ASC" + ", "
			+		"sdev.DevName ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSecDeviceCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSecDeviceCursor",
				e );
		}
	}

	public CFBamSecDeviceBuff nextSecDeviceCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSecDeviceCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSecDeviceBuff buff = unpackSecDeviceResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSecDeviceBuff prevSecDeviceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecDeviceBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecDeviceCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecDeviceBuff firstSecDeviceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecDeviceBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecDeviceCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecDeviceBuff lastSecDeviceCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSecDeviceCursor" );
	}

	public CFBamSecDeviceBuff nthSecDeviceCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecDeviceBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecDeviceCursor( Cursor );
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
		S_sqlSelectSecDeviceDistinctClassCode = null;
		S_sqlSelectSecDeviceBuff = null;
		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPKey = null;
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtLockBuffByPKey = null;
		}
		if( stmtAuditCreatedByPKey != null ) {
			try {
				stmtAuditCreatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditCreatedByPKey = null;
		}
		if( stmtAuditUpdatedByPKey != null ) {
			try {
				stmtAuditUpdatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditUpdatedByPKey = null;
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtCreateByPKey = null;
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateByPKey = null;
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPKey = null;
		}
		if( stmtDeleteByUserIdx != null ) {
			try {
				stmtDeleteByUserIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUserIdx = null;
			}
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
			}
			stmtReadAllBuff = null;
		}
		if( stmtReadBuffByIdIdx != null ) {
			try {
				stmtReadBuffByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByIdIdx = null;
		}
		if( stmtReadBuffByUserIdx != null ) {
			try {
				stmtReadBuffByUserIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUserIdx = null;
		}
	}
}
