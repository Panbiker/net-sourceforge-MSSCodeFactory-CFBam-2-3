// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for EnumTag.

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
 *	CFBamOracleEnumTagTable Oracle 11gR2 Jdbc DbIO implementation
 *	for EnumTag.
 */
public class CFBamOracleEnumTagTable
	implements ICFBamEnumTagTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByEnumTagTenantIdx = null;
	protected PreparedStatement stmtReadBuffByEnumIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByEnumNameIdx = null;
	protected PreparedStatement stmtReadBuffByPrevIdx = null;
	protected PreparedStatement stmtReadBuffByNextIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByEnumTagTenantIdx = null;
	protected PreparedStatement stmtDeleteByEnumIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByEnumNameIdx = null;
	protected PreparedStatement stmtDeleteByPrevIdx = null;
	protected PreparedStatement stmtDeleteByNextIdx = null;

	public CFBamOracleEnumTagTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		final String S_ProcName = "createEnumTag";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long EnumId = Buff.getRequiredEnumId();
			Short EnumCode = Buff.getOptionalEnumCode();
			String Name = Buff.getRequiredName();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_enum_tag( ?, ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, "ETG" );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			if( DefSchemaTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.setLong( argIdx++, EnumId );
			if( EnumCode != null ) {
				stmtCreateByPKey.setShort( argIdx++, EnumCode.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtCreateByPKey.setString( argIdx++, Name );
			if( PrevTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtCreateByPKey.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_enum_tag() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff createdBuff = unpackEnumTagResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredEnumId( createdBuff.getRequiredEnumId() );
				Buff.setOptionalEnumCode( createdBuff.getOptionalEnumCode() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalPrevTenantId( createdBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( createdBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( createdBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( createdBuff.getOptionalNextId() );
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
					"crt_enum_tag() did not return a valid result set" );
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

	protected static String S_sqlSelectEnumTagDistinctClassCode = null;

	public String getSqlSelectEnumTagDistinctClassCode() {
		if( S_sqlSelectEnumTagDistinctClassCode == null ) {
			S_sqlSelectEnumTagDistinctClassCode =
					"SELECT "
				+		"DISTINCT etg.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".enum_tag etg ";
		}
		return( S_sqlSelectEnumTagDistinctClassCode );
	}

	protected static String S_sqlSelectEnumTagBuff = null;

	public String getSqlSelectEnumTagBuff() {
		if( S_sqlSelectEnumTagBuff == null ) {
			S_sqlSelectEnumTagBuff =
					"SELECT "
				+		"etg.TenantId, "
				+		"etg.Id, "
				+		"etg.defschtentid, "
				+		"etg.defschid, "
				+		"etg.EnumId, "
				+		"etg.EnumCode, "
				+		"etg.Name, "
				+		"etg.PrevTenantId, "
				+		"etg.PrevId, "
				+		"etg.NextTenantId, "
				+		"etg.NextId, "
				+		"etg.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".enum_tag etg ";
		}
		return( S_sqlSelectEnumTagBuff );
	}

	protected CFBamEnumTagBuff unpackEnumTagResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackEnumTagResultSetToBuff";
		int idxcol = 1;
		CFBamEnumTagBuff buff = schema.getFactoryEnumTag().newBuff();
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
		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaTenantId( null );
			}
			else {
				buff.setOptionalDefSchemaTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaId( null );
			}
			else {
				buff.setOptionalDefSchemaId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredEnumId( resultSet.getLong( idxcol ) );
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalEnumCode( null );
			}
			else {
				buff.setOptionalEnumCode( colVal );
			}
		}
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrevTenantId( null );
			}
			else {
				buff.setOptionalPrevTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrevId( null );
			}
			else {
				buff.setOptionalPrevId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNextTenantId( null );
			}
			else {
				buff.setOptionalNextTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNextId( null );
			}
			else {
				buff.setOptionalNextId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamEnumTagBuff readDerived( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamEnumTagBuff lockDerived( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamEnumTagBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamEnumTagBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamEnumTagBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleEnumTagTable.readDerivedByIdIdx() ";
		CFBamEnumTagBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		return( buff );
	}

	public CFBamEnumTagBuff[] readDerivedByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByEnumTagTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff[] buffList = readBuffByEnumTagTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamEnumTagBuff[] readDerivedByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		final String S_ProcName = "readDerivedByEnumIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff[] buffList = readBuffByEnumIdx( Authorization,
				TenantId,
				EnumId );
		return( buffList );

	}

	public CFBamEnumTagBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamEnumTagBuff readDerivedByEnumNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name )
	{
		final String S_ProcName = "CFBamOracleEnumTagTable.readDerivedByEnumNameIdx() ";
		CFBamEnumTagBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByEnumNameIdx( Authorization,
				TenantId,
				EnumId,
				Name );
		return( buff );
	}

	public CFBamEnumTagBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff[] buffList = readBuffByPrevIdx( Authorization,
				PrevTenantId,
				PrevId );
		return( buffList );

	}

	public CFBamEnumTagBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamEnumTagBuff[] buffList = readBuffByNextIdx( Authorization,
				NextTenantId,
				NextId );
		return( buffList );

	}

	public CFBamEnumTagBuff readBuff( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
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
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tag( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setLong( argIdx++, TenantId );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			stmtReadBuffByPKey.execute();
			resultSet = (ResultSet)stmtReadBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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

	public CFBamEnumTagBuff lockBuff( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
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
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_enum_tag( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setLong( argIdx++, TenantId );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			stmtLockBuffByPKey.execute();
			resultSet = (ResultSet)stmtLockBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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

	public CFBamEnumTagBuff[] readAllBuff( CFBamAuthorization Authorization ) {
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
			CFBamEnumTagBuff buff = null;
			List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackEnumTagResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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

	public CFBamEnumTagBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			stmtReadBuffByIdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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

	public CFBamEnumTagBuff[] readBuffByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByEnumTagTenantIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByEnumTagTenantIdx = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {
			stmtReadBuffByEnumTagTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbyenumtagtenantidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByEnumTagTenantIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumTagTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEnumTagTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByEnumTagTenantIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByEnumTagTenantIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByEnumTagTenantIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByEnumTagTenantIdx != null ) {
				try {
					stmtReadBuffByEnumTagTenantIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByEnumTagTenantIdx = null;
			}
		}
	}

	public CFBamEnumTagBuff[] readBuffByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		final String S_ProcName = "readBuffByEnumIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByEnumIdx = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {
			stmtReadBuffByEnumIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbyenumidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByEnumIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEnumIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByEnumIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByEnumIdx.setLong( argIdx++, EnumId );
			stmtReadBuffByEnumIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByEnumIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByEnumIdx != null ) {
				try {
					stmtReadBuffByEnumIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByEnumIdx = null;
			}
		}
	}

	public CFBamEnumTagBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByDefSchemaIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByDefSchemaIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByDefSchemaIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByDefSchemaIdx != null ) {
				try {
					stmtReadBuffByDefSchemaIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByDefSchemaIdx = null;
			}
		}
	}

	public CFBamEnumTagBuff readBuffByEnumNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name )
	{
		final String S_ProcName = "readBuffByEnumNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByEnumNameIdx = null;
		try {
			stmtReadBuffByEnumNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbyenumnameidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByEnumNameIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEnumNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByEnumNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByEnumNameIdx.setLong( argIdx++, EnumId );
			stmtReadBuffByEnumNameIdx.setString( argIdx++, Name );
			stmtReadBuffByEnumNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByEnumNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			if( stmtReadBuffByEnumNameIdx != null ) {
				try {
					stmtReadBuffByEnumNameIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByEnumNameIdx = null;
			}
		}
	}

	public CFBamEnumTagBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPrevIdx = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {
			stmtReadBuffByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrevTenantId != null ) {
				stmtReadBuffByPrevIdx.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtReadBuffByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtReadBuffByPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadBuffByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByPrevIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByPrevIdx != null ) {
				try {
					stmtReadBuffByPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByPrevIdx = null;
			}
		}
	}

	public CFBamEnumTagBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByNextIdx = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {
			stmtReadBuffByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_enum_tagbynextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( NextTenantId != null ) {
				stmtReadBuffByNextIdx.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtReadBuffByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtReadBuffByNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadBuffByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByNextIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			CFBamEnumTagBuff[] retBuff = new CFBamEnumTagBuff[ buffList.size() ];
			Iterator<CFBamEnumTagBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByNextIdx != null ) {
				try {
					stmtReadBuffByNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByNextIdx = null;
			}
		}
	}

	public void updateEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		final String S_ProcName = "updateEnumTag";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamEnumTagBuff> buffList = new LinkedList<CFBamEnumTagBuff>();
		try {			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long EnumId = Buff.getRequiredEnumId();
			Short EnumCode = Buff.getOptionalEnumCode();
			String Name = Buff.getRequiredName();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_enum_tag( ?, ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "ETG" );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			if( DefSchemaTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setLong( argIdx++, EnumId );
			if( EnumCode != null ) {
				stmtUpdateByPKey.setShort( argIdx++, EnumCode.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtUpdateByPKey.setString( argIdx++, Name );
			if( PrevTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamEnumTagBuff updatedBuff = unpackEnumTagResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredEnumId( updatedBuff.getRequiredEnumId() );
				Buff.setOptionalEnumCode( updatedBuff.getOptionalEnumCode() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalPrevTenantId( updatedBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( updatedBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( updatedBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( updatedBuff.getOptionalNextId() );
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
						"upd_enum_tag() did not return a valid result cursor" );
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
					"upd_enum_tag() did not return a result cursor" );
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

	public void deleteEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		final String S_ProcName = "deleteEnumTag";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_enum_tag( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
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

	public void deleteEnumTagByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteEnumTagByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbyididx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByIdIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByIdIdx.setLong( argIdx++, argId );
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

	public void deleteEnumTagByIdIdx( CFBamAuthorization Authorization,
		CFBamEnumTagPKey argKey )
	{
		deleteEnumTagByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteEnumTagByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteEnumTagByEnumTagTenantIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbyenumtagtenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByEnumTagTenantIdx == null ) {
					stmtDeleteByEnumTagTenantIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumTagTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEnumTagTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumTagTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByEnumTagTenantIdx.setLong( argIdx++, argTenantId );
				int rowsUpdated = stmtDeleteByEnumTagTenantIdx.executeUpdate();
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

	public void deleteEnumTagByEnumTagTenantIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumTagTenantIdxKey argKey )
	{
		deleteEnumTagByEnumTagTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteEnumTagByEnumIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argEnumId )
	{
		final String S_ProcName = "deleteEnumTagByEnumIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbyenumidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByEnumIdx == null ) {
					stmtDeleteByEnumIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEnumIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByEnumIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByEnumIdx.setLong( argIdx++, argEnumId );
				int rowsUpdated = stmtDeleteByEnumIdx.executeUpdate();
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

	public void deleteEnumTagByEnumIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumIdxKey argKey )
	{
		deleteEnumTagByEnumIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredEnumId() );
	}

	public void deleteEnumTagByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteEnumTagByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbydefschemaidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByDefSchemaIdx == null ) {
					stmtDeleteByDefSchemaIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argDefSchemaTenantId != null ) {
					stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaTenantId.longValue() );
				}
				else {
					stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argDefSchemaId != null ) {
					stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaId.longValue() );
				}
				else {
					stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByDefSchemaIdx.executeUpdate();
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

	public void deleteEnumTagByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByDefSchemaIdxKey argKey )
	{
		deleteEnumTagByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteEnumTagByEnumNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argEnumId,
		String argName )
	{
		final String S_ProcName = "deleteEnumTagByEnumNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbyenumnameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByEnumNameIdx == null ) {
					stmtDeleteByEnumNameIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEnumNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEnumNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByEnumNameIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByEnumNameIdx.setLong( argIdx++, argEnumId );
				stmtDeleteByEnumNameIdx.setString( argIdx++, argName );
				int rowsUpdated = stmtDeleteByEnumNameIdx.executeUpdate();
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

	public void deleteEnumTagByEnumNameIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumNameIdxKey argKey )
	{
		deleteEnumTagByEnumNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredEnumId(),
			argKey.getRequiredName() );
	}

	public void deleteEnumTagByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteEnumTagByPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbyprevidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByPrevIdx == null ) {
					stmtDeleteByPrevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argPrevTenantId != null ) {
					stmtDeleteByPrevIdx.setLong( argIdx++, argPrevTenantId.longValue() );
				}
				else {
					stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argPrevId != null ) {
					stmtDeleteByPrevIdx.setLong( argIdx++, argPrevId.longValue() );
				}
				else {
					stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByPrevIdx.executeUpdate();
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

	public void deleteEnumTagByPrevIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByPrevIdxKey argKey )
	{
		deleteEnumTagByPrevIdx( Authorization,
			argKey.getOptionalPrevTenantId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteEnumTagByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		final String S_ProcName = "deleteEnumTagByNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_enum_tagbynextidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByNextIdx == null ) {
					stmtDeleteByNextIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argNextTenantId != null ) {
					stmtDeleteByNextIdx.setLong( argIdx++, argNextTenantId.longValue() );
				}
				else {
					stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argNextId != null ) {
					stmtDeleteByNextIdx.setLong( argIdx++, argNextId.longValue() );
				}
				else {
					stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByNextIdx.executeUpdate();
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

	public void deleteEnumTagByNextIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByNextIdxKey argKey )
	{
		deleteEnumTagByNextIdx( Authorization,
			argKey.getOptionalNextTenantId(),
			argKey.getOptionalNextId() );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamEnumTagBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffUp";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtMoveUp = null;
		try {
			stmtMoveUp = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvup_enum_tag( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ); end;" );
			int argIdx = 1;
			stmtMoveUp.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveUp.setLong( argIdx++, TenantId );
			stmtMoveUp.setLong( argIdx++, Id );
			stmtMoveUp.setInt( argIdx++, revision );
			stmtMoveUp.execute();
			resultSet = (ResultSet)stmtMoveUp.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			if( stmtMoveUp != null ) {
				try {
					stmtMoveUp.close();
				}
				catch( SQLException e ) {
				}
				stmtMoveUp = null;
			}
		}
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamEnumTagBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffDown";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtMoveDown = null;
		try {
			stmtMoveDown = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvdn_enum_tag( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ); end;" );
			int argIdx = 1;
			stmtMoveDown.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveDown.setLong( argIdx++, TenantId );
			stmtMoveDown.setLong( argIdx++, Id );
			stmtMoveDown.setInt( argIdx++, revision );
			stmtMoveDown.execute();
			resultSet = (ResultSet)stmtMoveDown.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
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
			if( stmtMoveDown != null ) {
				try {
					stmtMoveDown.close();
				}
				catch( SQLException e ) {
				}
				stmtMoveDown = null;
			}
		}
	}

	public CFBamCursor openEnumTagCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectEnumTagBuff()
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		String sql = getSqlSelectEnumTagBuff()
			+	"WHERE "
				+		"etg.TenantId = " + Long.toString( TenantId ) + " "
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		String sql = getSqlSelectEnumTagBuff()
			+	"WHERE "
				+		"etg.TenantId = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"etg.EnumId = " + Long.toString( EnumId ) + " "
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		String sql = getSqlSelectEnumTagBuff()
			+	"WHERE "
				+		( ( DefSchemaTenantId == null ) ? "etg.defschtentid is null "
							: "etg.defschtentid = " + DefSchemaTenantId.toString() + " " )
			+	"AND "
				+		( ( DefSchemaId == null ) ? "etg.defschid is null "
							: "etg.defschid = " + DefSchemaId.toString() + " " )
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		String sql = getSqlSelectEnumTagBuff()
			+	"WHERE "
				+		( ( PrevTenantId == null ) ? "etg.PrevTenantId is null "
							: "etg.PrevTenantId = " + PrevTenantId.toString() + " " )
			+	"AND "
				+		( ( PrevId == null ) ? "etg.PrevId is null "
							: "etg.PrevId = " + PrevId.toString() + " " )
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		String sql = getSqlSelectEnumTagBuff()
			+	"WHERE "
				+		( ( NextTenantId == null ) ? "etg.NextTenantId is null "
							: "etg.NextTenantId = " + NextTenantId.toString() + " " )
			+	"AND "
				+		( ( NextId == null ) ? "etg.NextId is null "
							: "etg.NextId = " + NextId.toString() + " " )
			+	"ORDER BY " 
			+		"etg.TenantId ASC" + ", "
			+		"etg.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeEnumTagCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeEnumTagCursor",
				e );
		}
	}

	public CFBamEnumTagBuff nextEnumTagCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextEnumTagCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamEnumTagBuff buff = unpackEnumTagResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamEnumTagBuff prevEnumTagCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamEnumTagBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextEnumTagCursor( Cursor );
		}
		return( buff );
	}

	public CFBamEnumTagBuff firstEnumTagCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamEnumTagBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextEnumTagCursor( Cursor );
		}
		return( buff );
	}

	public CFBamEnumTagBuff lastEnumTagCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastEnumTagCursor" );
	}

	public CFBamEnumTagBuff nthEnumTagCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamEnumTagBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextEnumTagCursor( Cursor );
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
		S_sqlSelectEnumTagBuff = null;
		S_sqlSelectEnumTagDistinctClassCode = null;

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
		if( stmtDeleteByEnumTagTenantIdx != null ) {
			try {
				stmtDeleteByEnumTagTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEnumTagTenantIdx = null;
		}
		if( stmtDeleteByEnumIdx != null ) {
			try {
				stmtDeleteByEnumIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEnumIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByEnumNameIdx != null ) {
			try {
				stmtDeleteByEnumNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEnumNameIdx = null;
		}
		if( stmtDeleteByPrevIdx != null ) {
			try {
				stmtDeleteByPrevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPrevIdx = null;
		}
		if( stmtDeleteByNextIdx != null ) {
			try {
				stmtDeleteByNextIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByNextIdx = null;
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
		if( stmtReadBuffByEnumTagTenantIdx != null ) {
			try {
				stmtReadBuffByEnumTagTenantIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByEnumTagTenantIdx = null;
		}
		if( stmtReadBuffByEnumIdx != null ) {
			try {
				stmtReadBuffByEnumIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByEnumIdx = null;
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByDefSchemaIdx = null;
		}
		if( stmtReadBuffByEnumNameIdx != null ) {
			try {
				stmtReadBuffByEnumNameIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByEnumNameIdx = null;
		}
		if( stmtReadBuffByPrevIdx != null ) {
			try {
				stmtReadBuffByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByPrevIdx = null;
		}
		if( stmtReadBuffByNextIdx != null ) {
			try {
				stmtReadBuffByNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByNextIdx = null;
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
		if( stmtDeleteByEnumTagTenantIdx != null ) {
			try {
				stmtDeleteByEnumTagTenantIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByEnumTagTenantIdx = null;
		}
		if( stmtDeleteByEnumIdx != null ) {
			try {
				stmtDeleteByEnumIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByEnumIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByEnumNameIdx != null ) {
			try {
				stmtDeleteByEnumNameIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByEnumNameIdx = null;
		}
		if( stmtDeleteByPrevIdx != null ) {
			try {
				stmtDeleteByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByPrevIdx = null;
		}
		if( stmtDeleteByNextIdx != null ) {
			try {
				stmtDeleteByNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByNextIdx = null;
		}
	}
}
