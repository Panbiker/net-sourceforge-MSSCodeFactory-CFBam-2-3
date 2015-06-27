// Description: Java 7 PostgreSQL Jdbc DbIO implementation for SecUser.

/*
 *	CFBam
 *
 *	Copyright (c) 2014 2014-2015 Mark Sobkow
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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamPgSql;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamPgSqlSecUserTable PostgreSQL Jdbc DbIO implementation
 *	for SecUser.
 */
public class CFBamPgSqlSecUserTable
	implements ICFBamSecUserTable
{
	private CFBamPgSqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtReadBuffAll = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByULoginIdx = null;
	protected PreparedStatement stmtReadBuffByEMConfIdx = null;
	protected PreparedStatement stmtReadBuffByPwdResetIdx = null;
	protected PreparedStatement stmtReadBuffByDefDevIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByULoginIdx = null;
	protected PreparedStatement stmtDeleteByEMConfIdx = null;
	protected PreparedStatement stmtDeleteByPwdResetIdx = null;
	protected PreparedStatement stmtDeleteByDefDevIdx = null;

	public CFBamPgSqlSecUserTable( CFBamPgSqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		final String S_ProcName = "createSecUser";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			String LoginId = Buff.getRequiredLoginId();
			String EMailAddress = Buff.getRequiredEMailAddress();
			UUID EMailConfirmationUuid = Buff.getOptionalEMailConfirmationUuid();
			UUID DefaultDevSecUserId = Buff.getOptionalDefaultDevSecUserId();
			String DefaultDevName = Buff.getOptionalDefaultDevName();
			String PasswordHash = Buff.getRequiredPasswordHash();
			UUID PasswordResetUuid = Buff.getOptionalPasswordResetUuid();

			UUID SecUserId = UUID.randomUUID();			Connection cnx = schema.getCnx();
			String sql =
				"select * from " + schema.getLowerDbSchemaName() + ".sp_create_secuser( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "SUSR" );
			stmtCreateByPKey.setString( argIdx++, SecUserId.toString() );
			stmtCreateByPKey.setString( argIdx++, LoginId );
			stmtCreateByPKey.setString( argIdx++, EMailAddress );
			if( EMailConfirmationUuid != null ) {
				stmtCreateByPKey.setString( argIdx++, EMailConfirmationUuid.toString() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultDevSecUserId != null ) {
				stmtCreateByPKey.setString( argIdx++, DefaultDevSecUserId.toString() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultDevName != null ) {
				stmtCreateByPKey.setString( argIdx++, DefaultDevName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtCreateByPKey.setString( argIdx++, PasswordHash );
			if( PasswordResetUuid != null ) {
				stmtCreateByPKey.setString( argIdx++, PasswordResetUuid.toString() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff createdBuff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
				}
				Buff.setRequiredSecUserId( createdBuff.getRequiredSecUserId() );
				Buff.setRequiredLoginId( createdBuff.getRequiredLoginId() );
				Buff.setRequiredEMailAddress( createdBuff.getRequiredEMailAddress() );
				Buff.setOptionalEMailConfirmationUuid( createdBuff.getOptionalEMailConfirmationUuid() );
				Buff.setOptionalDefaultDevSecUserId( createdBuff.getOptionalDefaultDevSecUserId() );
				Buff.setOptionalDefaultDevName( createdBuff.getOptionalDefaultDevName() );
				Buff.setRequiredPasswordHash( createdBuff.getRequiredPasswordHash() );
				Buff.setOptionalPasswordResetUuid( createdBuff.getOptionalPasswordResetUuid() );
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

	public String S_sqlSelectSecUserDistinctClassCode = null;

	public String getSqlSelectSecUserDistinctClassCode() {
		if( S_sqlSelectSecUserDistinctClassCode == null ) {
			S_sqlSelectSecUserDistinctClassCode =
					"SELECT "
					+		"DISTINCT susr.ClassCode "
					+	"FROM " + schema.getLowerDbSchemaName() + ".SecUser AS susr ";
		}
		return( S_sqlSelectSecUserDistinctClassCode );
	}

	public String S_sqlSelectSecUserBuff = null;

	public String getSqlSelectSecUserBuff() {
		if( S_sqlSelectSecUserBuff == null ) {
			S_sqlSelectSecUserBuff =
					"SELECT "
					+		"susr.SecUserId, "
					+		"susr.login_id, "
					+		"susr.email_addr, "
					+		"susr.em_confuuid, "
					+		"susr.DefDevUserId, "
					+		"susr.DefDevName, "
					+		"susr.pwd_hash, "
					+		"susr.pwdrstuuid, "
					+		"susr.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".SecUser AS susr ";
		}
		return( S_sqlSelectSecUserBuff );
	}

	protected CFBamSecUserBuff unpackSecUserResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSecUserResultSetToBuff";
		int idxcol = 1;
		CFBamSecUserBuff buff = schema.getFactorySecUser().newBuff();
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
				buff.setCreatedAt( CFBamPgSqlSchema.convertTimestampString( colString ) );
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
				buff.setUpdatedAt( CFBamPgSqlSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredSecUserId( CFBamPgSqlSchema.convertUuidString( resultSet.getString( idxcol ) ) );
		idxcol++;
		buff.setRequiredLoginId( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredEMailAddress( resultSet.getString( idxcol ) );
		idxcol++;
		{
			UUID colVal = CFBamPgSqlSchema.convertUuidString( resultSet.getString( idxcol ) );
			if( resultSet.wasNull() ) {
				buff.setOptionalEMailConfirmationUuid( null );
			}
			else {
				buff.setOptionalEMailConfirmationUuid( colVal );
			}
		}
		idxcol++;
		{
			UUID colVal = CFBamPgSqlSchema.convertUuidString( resultSet.getString( idxcol ) );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultDevSecUserId( null );
			}
			else {
				buff.setOptionalDefaultDevSecUserId( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultDevName( null );
			}
			else {
				buff.setOptionalDefaultDevName( colVal );
			}
		}
		idxcol++;
		buff.setRequiredPasswordHash( resultSet.getString( idxcol ) );
		idxcol++;
		{
			UUID colVal = CFBamPgSqlSchema.convertUuidString( resultSet.getString( idxcol ) );
			if( resultSet.wasNull() ) {
				buff.setOptionalPasswordResetUuid( null );
			}
			else {
				buff.setOptionalPasswordResetUuid( colVal );
			}
		}
		idxcol++;

		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSecUserBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecUserBuff buff;

		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecUserBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecUserBuff buff;

		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecUserBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSecUserBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSecUserBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamPgSqlSecUserTable.readDerivedByIdIdx() ";
		CFBamSecUserBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				SecUserId );
		return( buff );
	}

	public CFBamSecUserBuff readDerivedByULoginIdx( CFBamAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "CFBamPgSqlSecUserTable.readDerivedByULoginIdx() ";
		CFBamSecUserBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByULoginIdx( Authorization,
				LoginId );
		return( buff );
	}

	public CFBamSecUserBuff[] readDerivedByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		final String S_ProcName = "readDerivedByEMConfIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecUserBuff[] buffList = readBuffByEMConfIdx( Authorization,
				EMailConfirmationUuid );
		return( buffList );

	}

	public CFBamSecUserBuff[] readDerivedByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "readDerivedByPwdResetIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecUserBuff[] buffList = readBuffByPwdResetIdx( Authorization,
				PasswordResetUuid );
		return( buffList );

	}

	public CFBamSecUserBuff readDerivedByDefDevIdx( CFBamAuthorization Authorization,
		UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		final String S_ProcName = "CFBamPgSqlSecUserTable.readDerivedByDefDevIdx() ";
		CFBamSecUserBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByDefDevIdx( Authorization,
				DefaultDevSecUserId,
				DefaultDevName );
		return( buff );
	}

	public CFBamSecUserBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
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
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
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
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
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

	public CFBamSecUserBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
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
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_lock_secuser( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
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
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
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

	public CFBamSecUserBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_all( ?, ?, ?, ?, ? )";
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
			List<CFBamSecUserBuff> buffList = new LinkedList<CFBamSecUserBuff>();
			while( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecUserBuff[] retBuff = new CFBamSecUserBuff[ buffList.size() ];
			Iterator<CFBamSecUserBuff> iter = buffList.iterator();
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

	public CFBamSecUserBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_by_ididx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
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
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
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

	public CFBamSecUserBuff readBuffByULoginIdx( CFBamAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "readBuffByULoginIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_by_uloginidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
			if( stmtReadBuffByULoginIdx == null ) {
				stmtReadBuffByULoginIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByULoginIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByULoginIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByULoginIdx.setString( argIdx++, LoginId );
			resultSet = stmtReadBuffByULoginIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
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

	public CFBamSecUserBuff[] readBuffByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		final String S_ProcName = "readBuffByEMConfIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_by_emconfidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
			if( stmtReadBuffByEMConfIdx == null ) {
				stmtReadBuffByEMConfIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEMConfIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEMConfIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EMailConfirmationUuid != null ) {
				stmtReadBuffByEMConfIdx.setString( argIdx++, EMailConfirmationUuid.toString() );
			}
			else {
				stmtReadBuffByEMConfIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			resultSet = stmtReadBuffByEMConfIdx.executeQuery();
			List<CFBamSecUserBuff> buffList = new LinkedList<CFBamSecUserBuff>();
			while( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecUserBuff[] retBuff = new CFBamSecUserBuff[ buffList.size() ];
			Iterator<CFBamSecUserBuff> iter = buffList.iterator();
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

	public CFBamSecUserBuff[] readBuffByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "readBuffByPwdResetIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_by_pwdresetidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " )";
			if( stmtReadBuffByPwdResetIdx == null ) {
				stmtReadBuffByPwdResetIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPwdResetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPwdResetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PasswordResetUuid != null ) {
				stmtReadBuffByPwdResetIdx.setString( argIdx++, PasswordResetUuid.toString() );
			}
			else {
				stmtReadBuffByPwdResetIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			resultSet = stmtReadBuffByPwdResetIdx.executeQuery();
			List<CFBamSecUserBuff> buffList = new LinkedList<CFBamSecUserBuff>();
			while( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecUserBuff[] retBuff = new CFBamSecUserBuff[ buffList.size() ];
			Iterator<CFBamSecUserBuff> iter = buffList.iterator();
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

	public CFBamSecUserBuff readBuffByDefDevIdx( CFBamAuthorization Authorization,
		UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		final String S_ProcName = "readBuffByDefDevIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "SELECT * FROM " + schema.getLowerDbSchemaName() + ".sp_read_secuser_by_defdevidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + ", "
					+		"?" + " )";
			if( stmtReadBuffByDefDevIdx == null ) {
				stmtReadBuffByDefDevIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDefDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefaultDevSecUserId != null ) {
				stmtReadBuffByDefDevIdx.setString( argIdx++, DefaultDevSecUserId.toString() );
			}
			else {
				stmtReadBuffByDefDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultDevName != null ) {
				stmtReadBuffByDefDevIdx.setString( argIdx++, DefaultDevName );
			}
			else {
				stmtReadBuffByDefDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			resultSet = stmtReadBuffByDefDevIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
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

	public void updateSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		final String S_ProcName = "updateSecUser";
		ResultSet resultSet = null;
		try {
			UUID SecUserId = Buff.getRequiredSecUserId();
			String LoginId = Buff.getRequiredLoginId();
			String EMailAddress = Buff.getRequiredEMailAddress();
			UUID EMailConfirmationUuid = Buff.getOptionalEMailConfirmationUuid();
			UUID DefaultDevSecUserId = Buff.getOptionalDefaultDevSecUserId();
			String DefaultDevName = Buff.getOptionalDefaultDevName();
			String PasswordHash = Buff.getRequiredPasswordHash();
			UUID PasswordResetUuid = Buff.getOptionalPasswordResetUuid();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"select * from " + schema.getLowerDbSchemaName() + ".sp_update_secuser( ?, ?, ?, ?, ?, ?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + ", "
						+	"?" + " )";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "SUSR" );
			stmtUpdateByPKey.setString( argIdx++, SecUserId.toString() );
			stmtUpdateByPKey.setString( argIdx++, LoginId );
			stmtUpdateByPKey.setString( argIdx++, EMailAddress );
			if( EMailConfirmationUuid != null ) {
				stmtUpdateByPKey.setString( argIdx++, EMailConfirmationUuid.toString() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultDevSecUserId != null ) {
				stmtUpdateByPKey.setString( argIdx++, DefaultDevSecUserId.toString() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultDevName != null ) {
				stmtUpdateByPKey.setString( argIdx++, DefaultDevName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setString( argIdx++, PasswordHash );
			if( PasswordResetUuid != null ) {
				stmtUpdateByPKey.setString( argIdx++, PasswordResetUuid.toString() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSecUserBuff updatedBuff = unpackSecUserResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
				}
				Buff.setRequiredLoginId( updatedBuff.getRequiredLoginId() );
				Buff.setRequiredEMailAddress( updatedBuff.getRequiredEMailAddress() );
				Buff.setOptionalEMailConfirmationUuid( updatedBuff.getOptionalEMailConfirmationUuid() );
				Buff.setOptionalDefaultDevSecUserId( updatedBuff.getOptionalDefaultDevSecUserId() );
				Buff.setOptionalDefaultDevName( updatedBuff.getOptionalDefaultDevName() );
				Buff.setRequiredPasswordHash( updatedBuff.getRequiredPasswordHash() );
				Buff.setOptionalPasswordResetUuid( updatedBuff.getOptionalPasswordResetUuid() );
				Buff.setRequiredRevision( updatedBuff.getRequiredRevision() );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
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

	public void deleteSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		final String S_ProcName = "deleteSecUser";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			UUID SecUserId = Buff.getRequiredSecUserId();

			String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser( ?, ?, ?, ?, ?" + ", "
					+		"?" + ", "
					+		"?" + " ) as DeletedFlag";
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
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			resultSet = stmtDeleteByPKey.executeQuery();
			if( resultSet.next() ) {
				boolean deleteFlag = resultSet.getBoolean( 1 );
				if( resultSet.next() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response" );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByIdIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		final String S_ProcName = "deleteSecUserByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser_by_ididx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " ) as DeletedFlag";
				if( stmtDeleteByIdIdx == null ) {
					stmtDeleteByIdIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByIdIdx.setString( argIdx++, argSecUserId.toString() );
				resultSet = stmtDeleteByIdIdx.executeQuery();
				if( resultSet.next() ) {
					boolean deleteFlag = resultSet.getBoolean( 1 );
					if( resultSet.next() ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response" );
					}
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByIdIdx( CFBamAuthorization Authorization,
		CFBamSecUserPKey argKey )
	{
		deleteSecUserByIdIdx( Authorization,
			argKey.getRequiredSecUserId() );
	}

	public void deleteSecUserByULoginIdx( CFBamAuthorization Authorization,
		String argLoginId )
	{
		final String S_ProcName = "deleteSecUserByULoginIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser_by_uloginidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " ) as DeletedFlag";
				if( stmtDeleteByULoginIdx == null ) {
					stmtDeleteByULoginIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByULoginIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByULoginIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByULoginIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByULoginIdx.setString( argIdx++, argLoginId );
				resultSet = stmtDeleteByULoginIdx.executeQuery();
				if( resultSet.next() ) {
					boolean deleteFlag = resultSet.getBoolean( 1 );
					if( resultSet.next() ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response" );
					}
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByULoginIdx( CFBamAuthorization Authorization,
		CFBamSecUserByULoginIdxKey argKey )
	{
		deleteSecUserByULoginIdx( Authorization,
			argKey.getRequiredLoginId() );
	}

	public void deleteSecUserByEMConfIdx( CFBamAuthorization Authorization,
		UUID argEMailConfirmationUuid )
	{
		final String S_ProcName = "deleteSecUserByEMConfIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser_by_emconfidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " ) as DeletedFlag";
				if( stmtDeleteByEMConfIdx == null ) {
					stmtDeleteByEMConfIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEMConfIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEMConfIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEMConfIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argEMailConfirmationUuid != null ) {
					stmtDeleteByEMConfIdx.setString( argIdx++, argEMailConfirmationUuid.toString() );
				}
				else {
					stmtDeleteByEMConfIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				resultSet = stmtDeleteByEMConfIdx.executeQuery();
				if( resultSet.next() ) {
					boolean deleteFlag = resultSet.getBoolean( 1 );
					if( resultSet.next() ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response" );
					}
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByEMConfIdx( CFBamAuthorization Authorization,
		CFBamSecUserByEMConfIdxKey argKey )
	{
		deleteSecUserByEMConfIdx( Authorization,
			argKey.getOptionalEMailConfirmationUuid() );
	}

	public void deleteSecUserByPwdResetIdx( CFBamAuthorization Authorization,
		UUID argPasswordResetUuid )
	{
		final String S_ProcName = "deleteSecUserByPwdResetIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser_by_pwdresetidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + " ) as DeletedFlag";
				if( stmtDeleteByPwdResetIdx == null ) {
					stmtDeleteByPwdResetIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPwdResetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByPwdResetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPwdResetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argPasswordResetUuid != null ) {
					stmtDeleteByPwdResetIdx.setString( argIdx++, argPasswordResetUuid.toString() );
				}
				else {
					stmtDeleteByPwdResetIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				resultSet = stmtDeleteByPwdResetIdx.executeQuery();
				if( resultSet.next() ) {
					boolean deleteFlag = resultSet.getBoolean( 1 );
					if( resultSet.next() ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response" );
					}
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByPwdResetIdx( CFBamAuthorization Authorization,
		CFBamSecUserByPwdResetIdxKey argKey )
	{
		deleteSecUserByPwdResetIdx( Authorization,
			argKey.getOptionalPasswordResetUuid() );
	}

	public void deleteSecUserByDefDevIdx( CFBamAuthorization Authorization,
		UUID argDefaultDevSecUserId,
		String argDefaultDevName )
	{
		final String S_ProcName = "deleteSecUserByDefDevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "SELECT " + schema.getLowerDbSchemaName() + ".sp_delete_secuser_by_defdevidx( ?, ?, ?, ?, ?" + ", "
					+		"?" + ", "
					+		"?" + " ) as DeletedFlag";
				if( stmtDeleteByDefDevIdx == null ) {
					stmtDeleteByDefDevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByDefDevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefDevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argDefaultDevSecUserId != null ) {
					stmtDeleteByDefDevIdx.setString( argIdx++, argDefaultDevSecUserId.toString() );
				}
				else {
					stmtDeleteByDefDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				if( argDefaultDevName != null ) {
					stmtDeleteByDefDevIdx.setString( argIdx++, argDefaultDevName );
				}
				else {
					stmtDeleteByDefDevIdx.setNull( argIdx++, java.sql.Types.VARCHAR );
				}
				resultSet = stmtDeleteByDefDevIdx.executeQuery();
				if( resultSet.next() ) {
					boolean deleteFlag = resultSet.getBoolean( 1 );
					if( resultSet.next() ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response" );
					}
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 record result set to be returned by delete, not 0 rows" );
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

	public void deleteSecUserByDefDevIdx( CFBamAuthorization Authorization,
		CFBamSecUserByDefDevIdxKey argKey )
	{
		deleteSecUserByDefDevIdx( Authorization,
			argKey.getOptionalDefaultDevSecUserId(),
			argKey.getOptionalDefaultDevName() );
	}

	public CFBamCursor openSecUserCursorAll( CFBamAuthorization Authorization ) {
		String sql =
						getSqlSelectSecUserBuff()
			+	"ORDER BY " 
				+		"susr.SecUserId ASC";
		CFBamCursor cursor = new CFBamPgSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecUserCursorByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		String sql = getSqlSelectSecUserBuff()
			+	"WHERE "
				+		( ( EMailConfirmationUuid == null ) ? "susr.em_confuuid is null "
							: "susr.em_confuuid = '" + EMailConfirmationUuid.toString() + "' " )
			+	"ORDER BY " 
				+		"susr.SecUserId ASC";
		CFBamCursor cursor = new CFBamPgSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecUserCursorByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		String sql = getSqlSelectSecUserBuff()
			+	"WHERE "
				+		( ( PasswordResetUuid == null ) ? "susr.pwdrstuuid is null "
							: "susr.pwdrstuuid = '" + PasswordResetUuid.toString() + "' " )
			+	"ORDER BY " 
				+		"susr.SecUserId ASC";
		CFBamCursor cursor = new CFBamPgSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSecUserCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSecUserCursor",
				e );
		}
	}

	public CFBamSecUserBuff nextSecUserCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSecUserCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSecUserBuff buff = unpackSecUserResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSecUserBuff prevSecUserCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecUserBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecUserCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecUserBuff firstSecUserCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecUserBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecUserCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecUserBuff lastSecUserCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSecUserCursor" );
	}

	public CFBamSecUserBuff nthSecUserCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecUserBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecUserCursor( Cursor );
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
		S_sqlSelectSecUserDistinctClassCode = null;
		S_sqlSelectSecUserBuff = null;

		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPKey = null;
		}
		if( stmtReadBuffAll != null ) {
			try {
				stmtReadBuffAll.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffAll = null;
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtLockBuffByPKey = null;
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
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByULoginIdx != null ) {
			try {
				stmtDeleteByULoginIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByULoginIdx = null;
		}
		if( stmtDeleteByEMConfIdx != null ) {
			try {
				stmtDeleteByEMConfIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEMConfIdx = null;
		}
		if( stmtDeleteByPwdResetIdx != null ) {
			try {
				stmtDeleteByPwdResetIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPwdResetIdx = null;
		}
		if( stmtDeleteByDefDevIdx != null ) {
			try {
				stmtDeleteByDefDevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefDevIdx = null;
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
		if( stmtReadBuffByULoginIdx != null ) {
			try {
				stmtReadBuffByULoginIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByULoginIdx = null;
		}
		if( stmtReadBuffByEMConfIdx != null ) {
			try {
				stmtReadBuffByEMConfIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByEMConfIdx = null;
		}
		if( stmtReadBuffByPwdResetIdx != null ) {
			try {
				stmtReadBuffByPwdResetIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPwdResetIdx = null;
		}
		if( stmtReadBuffByDefDevIdx != null ) {
			try {
				stmtReadBuffByDefDevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDefDevIdx = null;
		}
	}
}
