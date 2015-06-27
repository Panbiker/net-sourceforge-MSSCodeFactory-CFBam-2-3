// Description: Java 7 MySQL Jdbc DbIO implementation for SecGroupForm.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMySql;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamMySqlSecGroupFormTable MySQL Jdbc DbIO implementation
 *	for SecGroupForm.
 */
public class CFBamMySqlSecGroupFormTable
	implements ICFBamSecGroupFormTable
{
	private CFBamMySqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByClusterIdx = null;
	protected PreparedStatement stmtReadBuffByGroupIdx = null;
	protected PreparedStatement stmtReadBuffByAppIdx = null;
	protected PreparedStatement stmtReadBuffByFormIdx = null;
	protected PreparedStatement stmtReadBuffByUFormIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByClusterIdx = null;
	protected PreparedStatement stmtDeleteByGroupIdx = null;
	protected PreparedStatement stmtDeleteByAppIdx = null;
	protected PreparedStatement stmtDeleteByFormIdx = null;
	protected PreparedStatement stmtDeleteByUFormIdx = null;

	public CFBamMySqlSecGroupFormTable( CFBamMySqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "createSecGroupForm";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			int SecGroupId = Buff.getRequiredSecGroupId();
			int SecAppId = Buff.getRequiredSecAppId();
			int SecFormId = Buff.getRequiredSecFormId();
			Connection cnx = schema.getCnx();
			String sql =
				"call " + schema.getLowerDbSchemaName() + ".sp_create_secgrpfrm( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "SGFM" );
			stmtCreateByPKey.setLong( argIdx++, ClusterId );
			stmtCreateByPKey.setInt( argIdx++, SecGroupId );
			stmtCreateByPKey.setInt( argIdx++, SecAppId );
			stmtCreateByPKey.setInt( argIdx++, SecFormId );
			try {
				resultSet = stmtCreateByPKey.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff createdBuff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredClusterId( createdBuff.getRequiredClusterId() );
				Buff.setRequiredSecGroupFormId( createdBuff.getRequiredSecGroupFormId() );
				Buff.setRequiredSecGroupId( createdBuff.getRequiredSecGroupId() );
				Buff.setRequiredSecAppId( createdBuff.getRequiredSecAppId() );
				Buff.setRequiredSecFormId( createdBuff.getRequiredSecFormId() );
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

	protected static String S_sqlSelectSecGroupFormDistinctClassCode = null;

	public String getSqlSelectSecGroupFormDistinctClassCode() {
		if( S_sqlSelectSecGroupFormDistinctClassCode == null ) {
			S_sqlSelectSecGroupFormDistinctClassCode =
					"SELECT "
				+		"DISTINCT sgfm.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".SecGrpFrm AS sgfm ";
		}
		return( S_sqlSelectSecGroupFormDistinctClassCode );
	}

	protected static String S_sqlSelectSecGroupFormBuff = null;

	public String getSqlSelectSecGroupFormBuff() {
		if( S_sqlSelectSecGroupFormBuff == null ) {
			S_sqlSelectSecGroupFormBuff =
					"SELECT "
				+		"sgfm.ClusId, "
				+		"sgfm.SecGrpFrmId, "
				+		"sgfm.SecGrpId, "
				+		"sgfm.SecAppId, "
				+		"sgfm.SecFrmId, "
				+		"sgfm.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".SecGrpFrm AS sgfm ";
		}
		return( S_sqlSelectSecGroupFormBuff );
	}

	protected CFBamSecGroupFormBuff unpackSecGroupFormResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSecGroupFormResultSetToBuff";
		int idxcol = 1;
		CFBamSecGroupFormBuff buff = schema.getFactorySecGroupForm().newBuff();
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedAt( null );
			}
			else {
				buff.setCreatedAt( CFBamMySqlSchema.convertTimestampString( colString ) );
			}
		}
		idxcol++;
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
		}
		idxcol++;
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedAt( null );
			}
			else {
				buff.setUpdatedAt( CFBamMySqlSchema.convertTimestampString( colString ) );
			}
		}
		idxcol++;
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedByUserId( null );
			}
			else {
				buff.setUpdatedByUserId( UUID.fromString( colString ) );
			}
		}
		idxcol++;		buff.setRequiredClusterId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredSecGroupFormId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredSecGroupId( resultSet.getInt( idxcol ) );
		idxcol++;
		buff.setRequiredSecAppId( resultSet.getInt( idxcol ) );
		idxcol++;
		buff.setRequiredSecFormId( resultSet.getInt( idxcol ) );
		idxcol++;

		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSecGroupFormBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecGroupFormBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSecGroupFormBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSecGroupFormBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "CFBamMySqlSecGroupFormTable.readDerivedByIdIdx() ";
		CFBamSecGroupFormBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				ClusterId,
				SecGroupFormId );
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readDerivedByClusterIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff[] buffList = readBuffByClusterIdx( Authorization,
				ClusterId );
		return( buffList );

	}

	public CFBamSecGroupFormBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "readDerivedByGroupIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff[] buffList = readBuffByGroupIdx( Authorization,
				ClusterId,
				SecGroupId );
		return( buffList );

	}

	public CFBamSecGroupFormBuff[] readDerivedByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "readDerivedByAppIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff[] buffList = readBuffByAppIdx( Authorization,
				ClusterId,
				SecAppId );
		return( buffList );

	}

	public CFBamSecGroupFormBuff[] readDerivedByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "readDerivedByFormIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSecGroupFormBuff[] buffList = readBuffByFormIdx( Authorization,
				ClusterId,
				SecFormId );
		return( buffList );

	}

	public CFBamSecGroupFormBuff readDerivedByUFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamMySqlSecGroupFormTable.readDerivedByUFormIdx() ";
		CFBamSecGroupFormBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUFormIdx( Authorization,
				ClusterId,
				SecGroupId,
				SecFormId );
		return( buff );
	}

	public CFBamSecGroupFormBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
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
			long ClusterId = PKey.getRequiredClusterId();
			long SecGroupFormId = PKey.getRequiredSecGroupFormId();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtReadBuffByPKey.setLong( argIdx++, ClusterId );
			stmtReadBuffByPKey.setLong( argIdx++, SecGroupFormId );
			try {
				resultSet = stmtReadBuffByPKey.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
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

	public CFBamSecGroupFormBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
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
			long ClusterId = PKey.getRequiredClusterId();
			long SecGroupFormId = PKey.getRequiredSecGroupFormId();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_lock_secgrpfrm( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtLockBuffByPKey.setLong( argIdx++, ClusterId );
			stmtLockBuffByPKey.setLong( argIdx++, SecGroupFormId );
			try {
				resultSet = stmtLockBuffByPKey.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
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

	public CFBamSecGroupFormBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_all( ?, ?, ?, ?, ? )";
			if( stmtReadAllBuff == null ) {
				stmtReadAllBuff = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			try {
				resultSet = stmtReadAllBuff.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamSecGroupFormBuff> buffList = new LinkedList<CFBamSecGroupFormBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecGroupFormBuff[] retBuff = new CFBamSecGroupFormBuff[ buffList.size() ];
			Iterator<CFBamSecGroupFormBuff> iter = buffList.iterator();
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

	public CFBamSecGroupFormBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtReadBuffByIdIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByIdIdx.setLong( argIdx++, SecGroupFormId );
			try {
				resultSet = stmtReadBuffByIdIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
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

	public CFBamSecGroupFormBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readBuffByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByClusterIdx == null ) {
				stmtReadBuffByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ClusterId );
			try {
				resultSet = stmtReadBuffByClusterIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamSecGroupFormBuff> buffList = new LinkedList<CFBamSecGroupFormBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecGroupFormBuff[] retBuff = new CFBamSecGroupFormBuff[ buffList.size() ];
			Iterator<CFBamSecGroupFormBuff> iter = buffList.iterator();
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

	public CFBamSecGroupFormBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "readBuffByGroupIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_groupidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByGroupIdx == null ) {
				stmtReadBuffByGroupIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByGroupIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByGroupIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByGroupIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByGroupIdx.setInt( argIdx++, SecGroupId );
			try {
				resultSet = stmtReadBuffByGroupIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamSecGroupFormBuff> buffList = new LinkedList<CFBamSecGroupFormBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecGroupFormBuff[] retBuff = new CFBamSecGroupFormBuff[ buffList.size() ];
			Iterator<CFBamSecGroupFormBuff> iter = buffList.iterator();
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

	public CFBamSecGroupFormBuff[] readBuffByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "readBuffByAppIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_appidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByAppIdx == null ) {
				stmtReadBuffByAppIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAppIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByAppIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByAppIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByAppIdx.setInt( argIdx++, SecAppId );
			try {
				resultSet = stmtReadBuffByAppIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamSecGroupFormBuff> buffList = new LinkedList<CFBamSecGroupFormBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecGroupFormBuff[] retBuff = new CFBamSecGroupFormBuff[ buffList.size() ];
			Iterator<CFBamSecGroupFormBuff> iter = buffList.iterator();
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

	public CFBamSecGroupFormBuff[] readBuffByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "readBuffByFormIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_formidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByFormIdx == null ) {
				stmtReadBuffByFormIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByFormIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByFormIdx.setInt( argIdx++, SecFormId );
			try {
				resultSet = stmtReadBuffByFormIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamSecGroupFormBuff> buffList = new LinkedList<CFBamSecGroupFormBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSecGroupFormBuff[] retBuff = new CFBamSecGroupFormBuff[ buffList.size() ];
			Iterator<CFBamSecGroupFormBuff> iter = buffList.iterator();
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

	public CFBamSecGroupFormBuff readBuffByUFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "readBuffByUFormIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_secgrpfrm_by_uformidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByUFormIdx == null ) {
				stmtReadBuffByUFormIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUFormIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByUFormIdx.setInt( argIdx++, SecGroupId );
			stmtReadBuffByUFormIdx.setInt( argIdx++, SecFormId );
			try {
				resultSet = stmtReadBuffByUFormIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
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

	public void updateSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "updateSecGroupForm";
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			long SecGroupFormId = Buff.getRequiredSecGroupFormId();
			int SecGroupId = Buff.getRequiredSecGroupId();
			int SecAppId = Buff.getRequiredSecAppId();
			int SecFormId = Buff.getRequiredSecFormId();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"call " + schema.getLowerDbSchemaName() + ".sp_update_secgrpfrm( ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+ "?" + " )";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "SGFM" );
			stmtUpdateByPKey.setLong( argIdx++, ClusterId );
			stmtUpdateByPKey.setLong( argIdx++, SecGroupFormId );
			stmtUpdateByPKey.setInt( argIdx++, SecGroupId );
			stmtUpdateByPKey.setInt( argIdx++, SecAppId );
			stmtUpdateByPKey.setInt( argIdx++, SecFormId );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			try {
				resultSet = stmtUpdateByPKey.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSecGroupFormBuff updatedBuff = unpackSecGroupFormResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredSecGroupId( updatedBuff.getRequiredSecGroupId() );
				Buff.setRequiredSecAppId( updatedBuff.getRequiredSecAppId() );
				Buff.setRequiredSecFormId( updatedBuff.getRequiredSecFormId() );
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

	public void deleteSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "deleteSecGroupForm";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long ClusterId = Buff.getRequiredClusterId();
			long SecGroupFormId = Buff.getRequiredSecGroupFormId();

			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByPKey == null ) {
				stmtDeleteByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, ClusterId );
			stmtDeleteByPKey.setLong( argIdx++, SecGroupFormId );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			stmtDeleteByPKey.executeUpdate();
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

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
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
			stmtDeleteByIdIdx.setLong( argIdx++, argSecGroupFormId );
			stmtDeleteByIdIdx.executeUpdate();
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

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey argKey )
	{
		deleteSecGroupFormByIdIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupFormId() );
	}

	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "deleteSecGroupFormByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
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
			stmtDeleteByClusterIdx.executeUpdate();
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

	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByClusterIdxKey argKey )
	{
		deleteSecGroupFormByClusterIdx( Authorization,
			argKey.getRequiredClusterId() );
	}

	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		final String S_ProcName = "deleteSecGroupFormByGroupIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_groupidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByGroupIdx == null ) {
				stmtDeleteByGroupIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByGroupIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByGroupIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByGroupIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByGroupIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByGroupIdx.setInt( argIdx++, argSecGroupId );
			stmtDeleteByGroupIdx.executeUpdate();
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

	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByGroupIdxKey argKey )
	{
		deleteSecGroupFormByGroupIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupId() );
	}

	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		final String S_ProcName = "deleteSecGroupFormByAppIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_appidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByAppIdx == null ) {
				stmtDeleteByAppIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByAppIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByAppIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByAppIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByAppIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByAppIdx.setInt( argIdx++, argSecAppId );
			stmtDeleteByAppIdx.executeUpdate();
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

	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByAppIdxKey argKey )
	{
		deleteSecGroupFormByAppIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecAppId() );
	}

	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByFormIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_formidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByFormIdx == null ) {
				stmtDeleteByFormIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByFormIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByFormIdx.setInt( argIdx++, argSecFormId );
			stmtDeleteByFormIdx.executeUpdate();
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

	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByFormIdxKey argKey )
	{
		deleteSecGroupFormByFormIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecFormId() );
	}

	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByUFormIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_secgrpfrm_by_uformidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByUFormIdx == null ) {
				stmtDeleteByUFormIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUFormIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUFormIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUFormIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByUFormIdx.setInt( argIdx++, argSecGroupId );
			stmtDeleteByUFormIdx.setInt( argIdx++, argSecFormId );
			stmtDeleteByUFormIdx.executeUpdate();
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

	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByUFormIdxKey argKey )
	{
		deleteSecGroupFormByUFormIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupId(),
			argKey.getRequiredSecFormId() );
	}

	public CFBamCursor openSecGroupFormCursorAll( CFBamAuthorization Authorization ) {
		String sql =
				getSqlSelectSecGroupFormBuff()
				+		( ( schema.isSystemUser( Authorization ) ) ? "" : ( " WHERE sgfm.ClusId = " + Authorization.getSecClusterId() ) )
			+	"ORDER BY " 
			+		"sgfm.ClusId ASC" + ", "
			+		"sgfm.SecGrpFrmId ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		String sql = getSqlSelectSecGroupFormBuff()
			+	"WHERE "
				+		"sgfm.ClusId = " + Long.toString( ClusterId ) + " "
			+	"ORDER BY " 
			+		"sgfm.ClusId ASC" + ", "
			+		"sgfm.SecGrpFrmId ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		String sql = getSqlSelectSecGroupFormBuff()
			+	"WHERE "
				+		"sgfm.ClusId = " + Long.toString( ClusterId ) + " "
			+	"AND "
				+		"sgfm.SecGrpId = " + Integer.toString( SecGroupId ) + " "
			+	"ORDER BY " 
			+		"sgfm.ClusId ASC" + ", "
			+		"sgfm.SecGrpFrmId ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		String sql = getSqlSelectSecGroupFormBuff()
			+	"WHERE "
				+		"sgfm.ClusId = " + Long.toString( ClusterId ) + " "
			+	"AND "
				+		"sgfm.SecAppId = " + Integer.toString( SecAppId ) + " "
			+	"ORDER BY " 
			+		"sgfm.ClusId ASC" + ", "
			+		"sgfm.SecGrpFrmId ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		String sql = getSqlSelectSecGroupFormBuff()
			+	"WHERE "
				+		"sgfm.ClusId = " + Long.toString( ClusterId ) + " "
			+	"AND "
				+		"sgfm.SecFrmId = " + Integer.toString( SecFormId ) + " "
			+	"ORDER BY " 
			+		"sgfm.ClusId ASC" + ", "
			+		"sgfm.SecGrpFrmId ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSecGroupFormCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSecGroupFormCursor",
				e );
		}
	}

	public CFBamSecGroupFormBuff nextSecGroupFormCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSecGroupFormCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSecGroupFormBuff buff = unpackSecGroupFormResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSecGroupFormBuff prevSecGroupFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecGroupFormBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecGroupFormCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff firstSecGroupFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecGroupFormBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecGroupFormCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff lastSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff nthSecGroupFormCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecGroupFormBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSecGroupFormCursor( Cursor );
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
		S_sqlSelectSecGroupFormDistinctClassCode = null;
		S_sqlSelectSecGroupFormBuff = null;
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
		if( stmtDeleteByClusterIdx != null ) {
			try {
				stmtDeleteByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByClusterIdx = null;
		}
		if( stmtDeleteByGroupIdx != null ) {
			try {
				stmtDeleteByGroupIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByGroupIdx = null;
		}
		if( stmtDeleteByAppIdx != null ) {
			try {
				stmtDeleteByAppIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByAppIdx = null;
		}
		if( stmtDeleteByFormIdx != null ) {
			try {
				stmtDeleteByFormIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByFormIdx = null;
		}
		if( stmtDeleteByUFormIdx != null ) {
			try {
				stmtDeleteByUFormIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUFormIdx = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff .close();
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
		if( stmtReadBuffByClusterIdx != null ) {
			try {
				stmtReadBuffByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByClusterIdx = null;
		}
		if( stmtReadBuffByGroupIdx != null ) {
			try {
				stmtReadBuffByGroupIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByGroupIdx = null;
		}
		if( stmtReadBuffByAppIdx != null ) {
			try {
				stmtReadBuffByAppIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByAppIdx = null;
		}
		if( stmtReadBuffByFormIdx != null ) {
			try {
				stmtReadBuffByFormIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByFormIdx = null;
		}
		if( stmtReadBuffByUFormIdx != null ) {
			try {
				stmtReadBuffByUFormIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUFormIdx = null;
		}
	}
}
