// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for SecSession.

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
 *	CFBamOracleSecSessionTable Oracle 11gR2 Jdbc DbIO implementation
 *	for SecSession.
 */
public class CFBamOracleSecSessionTable
	implements ICFBamSecSessionTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffBySecUserIdx = null;
	protected PreparedStatement stmtReadBuffBySecDevIdx = null;
	protected PreparedStatement stmtReadBuffByStartIdx = null;
	protected PreparedStatement stmtReadBuffByFinishIdx = null;
	protected PreparedStatement stmtReadBuffBySecProxyIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteBySecUserIdx = null;
	protected PreparedStatement stmtDeleteBySecDevIdx = null;
	protected PreparedStatement stmtDeleteByStartIdx = null;
	protected PreparedStatement stmtDeleteByFinishIdx = null;
	protected PreparedStatement stmtDeleteBySecProxyIdx = null;

	public CFBamOracleSecSessionTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		final String S_ProcName = "createSecSession";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			UUID SecUserId = Buff.getRequiredSecUserId();
			String SecDevName = Buff.getOptionalSecDevName();
			Calendar Start = Buff.getRequiredStart();
			Calendar Finish = Buff.getOptionalFinish();
			UUID SecProxyId = Buff.getOptionalSecProxyId();

			UUID SecSessionId = UUID.randomUUID();			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_secsess( ?, ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtCreateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "SESS" );
			stmtCreateByPKey.setString( argIdx++, SecSessionId.toString() );
			stmtCreateByPKey.setString( argIdx++, SecUserId.toString() );
			if( SecDevName != null ) {
				stmtCreateByPKey.setString( argIdx++, SecDevName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtCreateByPKey.setString( argIdx++, CFBamOracleSchema.getTimestampString( Start ) );
			if( Finish != null ) {
				stmtCreateByPKey.setString( argIdx++, CFBamOracleSchema.getTimestampString( Finish ) );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( SecProxyId != null ) {
				stmtCreateByPKey.setString( argIdx++, SecProxyId.toString() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_secsess() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamSecSessionBuff createdBuff = unpackSecSessionResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredSecSessionId( createdBuff.getRequiredSecSessionId() );
				Buff.setRequiredSecUserId( createdBuff.getRequiredSecUserId() );
				Buff.setOptionalSecDevName( createdBuff.getOptionalSecDevName() );
				Buff.setRequiredStart( createdBuff.getRequiredStart() );
				Buff.setOptionalFinish( createdBuff.getOptionalFinish() );
				Buff.setOptionalSecProxyId( createdBuff.getOptionalSecProxyId() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
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
					"crt_secsess() did not return a valid result set" );
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

	protected static String S_sqlSelectSecSessionDistinctClassCode = null;

	public String getSqlSelectSecSessionDistinctClassCode() {
		if( S_sqlSelectSecSessionDistinctClassCode == null ) {
			S_sqlSelectSecSessionDistinctClassCode =
					"SELECT "
				+		"DISTINCT sess.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".SecSess sess ";
		}
		return( S_sqlSelectSecSessionDistinctClassCode );
	}

	protected static String S_sqlSelectSecSessionBuff = null;

	public String getSqlSelectSecSessionBuff() {
		if( S_sqlSelectSecSessionBuff == null ) {
			S_sqlSelectSecSessionBuff =
					"SELECT "
				+		"sess.SecSessionId, "
				+		"sess.SecUserId, "
				+		"sess.SecDevName, "
				+		"to_char( sess.start_ts, 'YYYY-MM-DD HH24:MI:SS' ) AS start_ts, "
				+		"to_char( sess.finish_ts, 'YYYY-MM-DD HH24:MI:SS' ) AS finish_ts, "
				+		"sess.SecProxyId, "
				+		"sess.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".SecSess sess ";
		}
		return( S_sqlSelectSecSessionBuff );
	}

	protected CFBamSecSessionBuff unpackSecSessionResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSecSessionResultSetToBuff";
		int idxcol = 1;
		CFBamSecSessionBuff buff = schema.getFactorySecSession().newBuff();		buff.setRequiredSecSessionId( CFBamOracleSchema.convertUuidString( resultSet.getString( idxcol ) ) );
		idxcol++;
		buff.setRequiredSecUserId( CFBamOracleSchema.convertUuidString( resultSet.getString( idxcol ) ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalSecDevName( null );
			}
			else {
				buff.setOptionalSecDevName( colVal );
			}
		}
		idxcol++;
		buff.setRequiredStart( CFBamOracleSchema.convertTimestampString( resultSet.getString( idxcol ) ) );
		idxcol++;
		{
			Calendar colVal = CFBamOracleSchema.convertTimestampString( resultSet.getString( idxcol ) );
			if( resultSet.wasNull() ) {
				buff.setOptionalFinish( null );
			}
			else {
				buff.setOptionalFinish( colVal );
			}
		}
		idxcol++;
		{
			UUID colVal = CFBamOracleSchema.convertUuidString( resultSet.getString( idxcol ) );
			if( resultSet.wasNull() ) {
				buff.setOptionalSecProxyId( null );
			}
			else {
				buff.setOptionalSecProxyId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSecSessionBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecSessionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecSessionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSecSessionBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSecSessionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "CFBamOracleSecSessionTable.readDerivedByIdIdx() ";
		CFBamSecSessionBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				SecSessionId );
		return( buff );
	}

	public CFBamSecSessionBuff[] readDerivedBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "readDerivedBySecUserIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff[] buffList = readBuffBySecUserIdx( Authorization,
				SecUserId );
		return( buffList );

	}

	public CFBamSecSessionBuff[] readDerivedBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "readDerivedBySecDevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff[] buffList = readBuffBySecDevIdx( Authorization,
				SecUserId,
				SecDevName );
		return( buffList );

	}

	public CFBamSecSessionBuff readDerivedByStartIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "CFBamOracleSecSessionTable.readDerivedByStartIdx() ";
		CFBamSecSessionBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByStartIdx( Authorization,
				SecUserId,
				Start );
		return( buff );
	}

	public CFBamSecSessionBuff[] readDerivedByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "readDerivedByFinishIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff[] buffList = readBuffByFinishIdx( Authorization,
				SecUserId,
				Finish );
		return( buffList );

	}

	public CFBamSecSessionBuff[] readDerivedBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "readDerivedBySecProxyIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecSessionBuff[] buffList = readBuffBySecProxyIdx( Authorization,
				SecProxyId );
		return( buffList );

	}

	public CFBamSecSessionBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
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
			UUID SecSessionId = PKey.getRequiredSecSessionId();

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsess( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setString( argIdx++, SecSessionId.toString() );
			stmtReadBuffByPKey.execute();
			resultSet = (ResultSet)stmtReadBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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

	public CFBamSecSessionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
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
			UUID SecSessionId = PKey.getRequiredSecSessionId();

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_secsess( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setString( argIdx++, SecSessionId.toString() );
			stmtLockBuffByPKey.execute();
			resultSet = (ResultSet)stmtLockBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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

	public CFBamSecSessionBuff[] readAllBuff( CFBamAuthorization Authorization ) {
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
			CFBamSecSessionBuff buff = null;
			List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackSecSessionResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamSecSessionBuff[] retBuff = new CFBamSecSessionBuff[ buffList.size() ];
			Iterator<CFBamSecSessionBuff> iter = buffList.iterator();
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

	public CFBamSecSessionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setString( argIdx++, SecSessionId.toString() );
			stmtReadBuffByIdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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

	public CFBamSecSessionBuff[] readBuffBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "readBuffBySecUserIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffBySecUserIdx = null;
		List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
		try {
			stmtReadBuffBySecUserIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbysecuseridx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffBySecUserIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySecUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySecUserIdx.setString( argIdx++, SecUserId.toString() );
			stmtReadBuffBySecUserIdx.execute();
			resultSet = (ResultSet)stmtReadBuffBySecUserIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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
			CFBamSecSessionBuff[] retBuff = new CFBamSecSessionBuff[ buffList.size() ];
			Iterator<CFBamSecSessionBuff> iter = buffList.iterator();
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
			if( stmtReadBuffBySecUserIdx != null ) {
				try {
					stmtReadBuffBySecUserIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffBySecUserIdx = null;
			}
		}
	}

	public CFBamSecSessionBuff[] readBuffBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "readBuffBySecDevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffBySecDevIdx = null;
		List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
		try {
			stmtReadBuffBySecDevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbysecdevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffBySecDevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySecDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySecDevIdx.setString( argIdx++, SecUserId.toString() );
			if( SecDevName != null ) {
				stmtReadBuffBySecDevIdx.setString( argIdx++, SecDevName );
			}
			else {
				stmtReadBuffBySecDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtReadBuffBySecDevIdx.execute();
			resultSet = (ResultSet)stmtReadBuffBySecDevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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
			CFBamSecSessionBuff[] retBuff = new CFBamSecSessionBuff[ buffList.size() ];
			Iterator<CFBamSecSessionBuff> iter = buffList.iterator();
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
			if( stmtReadBuffBySecDevIdx != null ) {
				try {
					stmtReadBuffBySecDevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffBySecDevIdx = null;
			}
		}
	}

	public CFBamSecSessionBuff readBuffByStartIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "readBuffByStartIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByStartIdx = null;
		try {
			stmtReadBuffByStartIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbystartidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByStartIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByStartIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByStartIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByStartIdx.setString( argIdx++, SecUserId.toString() );
			stmtReadBuffByStartIdx.setString( argIdx++, CFBamOracleSchema.getTimestampString( Start ) );
			stmtReadBuffByStartIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByStartIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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
			if( stmtReadBuffByStartIdx != null ) {
				try {
					stmtReadBuffByStartIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByStartIdx = null;
			}
		}
	}

	public CFBamSecSessionBuff[] readBuffByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "readBuffByFinishIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByFinishIdx = null;
		List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
		try {
			stmtReadBuffByFinishIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbyfinishidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByFinishIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByFinishIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByFinishIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByFinishIdx.setString( argIdx++, SecUserId.toString() );
			if( Finish != null ) {
				stmtReadBuffByFinishIdx.setString( argIdx++, CFBamOracleSchema.getTimestampString( Finish ) );
			}
			else {
				stmtReadBuffByFinishIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtReadBuffByFinishIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByFinishIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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
			CFBamSecSessionBuff[] retBuff = new CFBamSecSessionBuff[ buffList.size() ];
			Iterator<CFBamSecSessionBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByFinishIdx != null ) {
				try {
					stmtReadBuffByFinishIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByFinishIdx = null;
			}
		}
	}

	public CFBamSecSessionBuff[] readBuffBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "readBuffBySecProxyIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffBySecProxyIdx = null;
		List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
		try {
			stmtReadBuffBySecProxyIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_secsessbysecproxyidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffBySecProxyIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecProxyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySecProxyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( SecProxyId != null ) {
				stmtReadBuffBySecProxyIdx.setString( argIdx++, SecProxyId.toString() );
			}
			else {
				stmtReadBuffBySecProxyIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtReadBuffBySecProxyIdx.execute();
			resultSet = (ResultSet)stmtReadBuffBySecProxyIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
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
			CFBamSecSessionBuff[] retBuff = new CFBamSecSessionBuff[ buffList.size() ];
			Iterator<CFBamSecSessionBuff> iter = buffList.iterator();
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
			if( stmtReadBuffBySecProxyIdx != null ) {
				try {
					stmtReadBuffBySecProxyIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffBySecProxyIdx = null;
			}
		}
	}

	public void updateSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		final String S_ProcName = "updateSecSession";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamSecSessionBuff> buffList = new LinkedList<CFBamSecSessionBuff>();
		try {			UUID SecSessionId = Buff.getRequiredSecSessionId();
			UUID SecUserId = Buff.getRequiredSecUserId();
			String SecDevName = Buff.getOptionalSecDevName();
			Calendar Start = Buff.getRequiredStart();
			Calendar Finish = Buff.getOptionalFinish();
			UUID SecProxyId = Buff.getOptionalSecProxyId();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_secsess( ?, ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + ", "
					+	"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + ", "
					+	"?" + ", "
					+	"? ); end;" );
			int argIdx = 1;
			stmtUpdateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "SESS" );
			stmtUpdateByPKey.setString( argIdx++, SecSessionId.toString() );
			stmtUpdateByPKey.setString( argIdx++, SecUserId.toString() );
			if( SecDevName != null ) {
				stmtUpdateByPKey.setString( argIdx++, SecDevName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setString( argIdx++, CFBamOracleSchema.getTimestampString( Start ) );
			if( Finish != null ) {
				stmtUpdateByPKey.setString( argIdx++, CFBamOracleSchema.getTimestampString( Finish ) );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( SecProxyId != null ) {
				stmtUpdateByPKey.setString( argIdx++, SecProxyId.toString() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamSecSessionBuff updatedBuff = unpackSecSessionResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredSecUserId( updatedBuff.getRequiredSecUserId() );
				Buff.setOptionalSecDevName( updatedBuff.getOptionalSecDevName() );
				Buff.setRequiredStart( updatedBuff.getRequiredStart() );
				Buff.setOptionalFinish( updatedBuff.getOptionalFinish() );
				Buff.setOptionalSecProxyId( updatedBuff.getOptionalSecProxyId() );
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
						"upd_secsess() did not return a valid result cursor" );
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
					"upd_secsess() did not return a result cursor" );
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

	public void deleteSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		final String S_ProcName = "deleteSecSession";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			UUID SecSessionId = Buff.getRequiredSecSessionId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_secsess( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setString( argIdx++, SecSessionId.toString() );
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

	public void deleteSecSessionByIdIdx( CFBamAuthorization Authorization,
		UUID argSecSessionId )
	{
		final String S_ProcName = "deleteSecSessionByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbyididx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByIdIdx.setString( argIdx++, argSecSessionId.toString() );
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

	public void deleteSecSessionByIdIdx( CFBamAuthorization Authorization,
		CFBamSecSessionPKey argKey )
	{
		deleteSecSessionByIdIdx( Authorization,
			argKey.getRequiredSecSessionId() );
	}

	public void deleteSecSessionBySecUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		final String S_ProcName = "deleteSecSessionBySecUserIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbysecuseridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteBySecUserIdx == null ) {
					stmtDeleteBySecUserIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteBySecUserIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecUserIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteBySecUserIdx.setString( argIdx++, argSecUserId.toString() );
				int rowsUpdated = stmtDeleteBySecUserIdx.executeUpdate();
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

	public void deleteSecSessionBySecUserIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecUserIdxKey argKey )
	{
		deleteSecSessionBySecUserIdx( Authorization,
			argKey.getRequiredSecUserId() );
	}

	public void deleteSecSessionBySecDevIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		String argSecDevName )
	{
		final String S_ProcName = "deleteSecSessionBySecDevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbysecdevidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteBySecDevIdx == null ) {
					stmtDeleteBySecDevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteBySecDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteBySecDevIdx.setString( argIdx++, argSecUserId.toString() );
				if( argSecDevName != null ) {
					stmtDeleteBySecDevIdx.setString( argIdx++, argSecDevName );
				}
				else {
					stmtDeleteBySecDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				int rowsUpdated = stmtDeleteBySecDevIdx.executeUpdate();
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

	public void deleteSecSessionBySecDevIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecDevIdxKey argKey )
	{
		deleteSecSessionBySecDevIdx( Authorization,
			argKey.getRequiredSecUserId(),
			argKey.getOptionalSecDevName() );
	}

	public void deleteSecSessionByStartIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		Calendar argStart )
	{
		final String S_ProcName = "deleteSecSessionByStartIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbystartidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + " ); end";
				if( stmtDeleteByStartIdx == null ) {
					stmtDeleteByStartIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByStartIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByStartIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByStartIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByStartIdx.setString( argIdx++, argSecUserId.toString() );
				stmtDeleteByStartIdx.setString( argIdx++, CFBamOracleSchema.getTimestampString( argStart ) );
				int rowsUpdated = stmtDeleteByStartIdx.executeUpdate();
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

	public void deleteSecSessionByStartIdx( CFBamAuthorization Authorization,
		CFBamSecSessionByStartIdxKey argKey )
	{
		deleteSecSessionByStartIdx( Authorization,
			argKey.getRequiredSecUserId(),
			argKey.getRequiredStart() );
	}

	public void deleteSecSessionByFinishIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		Calendar argFinish )
	{
		final String S_ProcName = "deleteSecSessionByFinishIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbyfinishidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"to_timestamp( ?, 'YYYY-MM-DD HH24:MI:SS' )" + " ); end";
				if( stmtDeleteByFinishIdx == null ) {
					stmtDeleteByFinishIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByFinishIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByFinishIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByFinishIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByFinishIdx.setString( argIdx++, argSecUserId.toString() );
				if( argFinish != null ) {
					stmtDeleteByFinishIdx.setString( argIdx++, CFBamOracleSchema.getTimestampString( argFinish ) );
				}
				else {
					stmtDeleteByFinishIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				int rowsUpdated = stmtDeleteByFinishIdx.executeUpdate();
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

	public void deleteSecSessionByFinishIdx( CFBamAuthorization Authorization,
		CFBamSecSessionByFinishIdxKey argKey )
	{
		deleteSecSessionByFinishIdx( Authorization,
			argKey.getRequiredSecUserId(),
			argKey.getOptionalFinish() );
	}

	public void deleteSecSessionBySecProxyIdx( CFBamAuthorization Authorization,
		UUID argSecProxyId )
	{
		final String S_ProcName = "deleteSecSessionBySecProxyIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_secsessbysecproxyidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteBySecProxyIdx == null ) {
					stmtDeleteBySecProxyIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecProxyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteBySecProxyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySecProxyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argSecProxyId != null ) {
					stmtDeleteBySecProxyIdx.setString( argIdx++, argSecProxyId.toString() );
				}
				else {
					stmtDeleteBySecProxyIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				int rowsUpdated = stmtDeleteBySecProxyIdx.executeUpdate();
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

	public void deleteSecSessionBySecProxyIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecProxyIdxKey argKey )
	{
		deleteSecSessionBySecProxyIdx( Authorization,
			argKey.getOptionalSecProxyId() );
	}

	public CFBamCursor openSecSessionCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectSecSessionBuff()
			+	"ORDER BY " 
			+		"sess.SecSessionId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		String sql = getSqlSelectSecSessionBuff()
			+	"WHERE "
				+		"sess.SecUserId = '" + SecUserId.toString() + "' "
			+	"ORDER BY " 
			+		"sess.SecSessionId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		String sql = getSqlSelectSecSessionBuff()
			+	"WHERE "
				+		"sess.SecUserId = '" + SecUserId.toString() + "' "
			+	"AND "
				+		( ( SecDevName == null ) ? "sess.SecDevName is null "
							: "sess.SecDevName = " + CFBamOracleSchema.getQuotedString( SecDevName ) + " " )
			+	"ORDER BY " 
			+		"sess.SecSessionId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		String sql = getSqlSelectSecSessionBuff()
			+	"WHERE "
				+		"sess.SecUserId = '" + SecUserId.toString() + "' "
			+	"AND "
				+		( ( Finish == null ) ? "sess.finish_ts is null "
							: "sess.finish_ts = to_timestamp( " + CFBamOracleSchema.getTimestampString( Finish ) + ", 'YYYY-MM-DD HH24:MI:SS' ) " )

			+	"ORDER BY " 
			+		"sess.SecSessionId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		String sql = getSqlSelectSecSessionBuff()
			+	"WHERE "
				+		( ( SecProxyId == null ) ? "sess.SecProxyId is null "
							: "sess.SecProxyId = '" + SecProxyId.toString() + "' " )
			+	"ORDER BY " 
			+		"sess.SecSessionId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSecSessionCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSecSessionCursor",
				e );
		}
	}

	public CFBamSecSessionBuff nextSecSessionCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSecSessionCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSecSessionBuff buff = unpackSecSessionResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSecSessionBuff prevSecSessionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecSessionBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecSessionCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecSessionBuff firstSecSessionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecSessionBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecSessionCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecSessionBuff lastSecSessionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSecSessionCursor" );
	}

	public CFBamSecSessionBuff nthSecSessionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecSessionBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecSessionCursor( Cursor );
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
		S_sqlSelectSecSessionBuff = null;
		S_sqlSelectSecSessionDistinctClassCode = null;

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
		if( stmtDeleteBySecUserIdx != null ) {
			try {
				stmtDeleteBySecUserIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteBySecUserIdx = null;
		}
		if( stmtDeleteBySecDevIdx != null ) {
			try {
				stmtDeleteBySecDevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteBySecDevIdx = null;
		}
		if( stmtDeleteByStartIdx != null ) {
			try {
				stmtDeleteByStartIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByStartIdx = null;
		}
		if( stmtDeleteByFinishIdx != null ) {
			try {
				stmtDeleteByFinishIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByFinishIdx = null;
		}
		if( stmtDeleteBySecProxyIdx != null ) {
			try {
				stmtDeleteBySecProxyIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteBySecProxyIdx = null;
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
		if( stmtReadBuffBySecUserIdx != null ) {
			try {
				stmtReadBuffBySecUserIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffBySecUserIdx = null;
		}
		if( stmtReadBuffBySecDevIdx != null ) {
			try {
				stmtReadBuffBySecDevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffBySecDevIdx = null;
		}
		if( stmtReadBuffByStartIdx != null ) {
			try {
				stmtReadBuffByStartIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByStartIdx = null;
		}
		if( stmtReadBuffByFinishIdx != null ) {
			try {
				stmtReadBuffByFinishIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByFinishIdx = null;
		}
		if( stmtReadBuffBySecProxyIdx != null ) {
			try {
				stmtReadBuffBySecProxyIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffBySecProxyIdx = null;
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
		if( stmtDeleteBySecUserIdx != null ) {
			try {
				stmtDeleteBySecUserIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteBySecUserIdx = null;
		}
		if( stmtDeleteBySecDevIdx != null ) {
			try {
				stmtDeleteBySecDevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteBySecDevIdx = null;
		}
		if( stmtDeleteByStartIdx != null ) {
			try {
				stmtDeleteByStartIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByStartIdx = null;
		}
		if( stmtDeleteByFinishIdx != null ) {
			try {
				stmtDeleteByFinishIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByFinishIdx = null;
		}
		if( stmtDeleteBySecProxyIdx != null ) {
			try {
				stmtDeleteBySecProxyIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteBySecProxyIdx = null;
		}
	}
}
