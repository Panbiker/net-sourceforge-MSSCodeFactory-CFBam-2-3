// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for ISOLanguage.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSybase;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamSybaseISOLanguageTable PostgreSQL Jdbc DbIO implementation
 *	for ISOLanguage.
 */
public class CFBamSybaseISOLanguageTable
	implements ICFBamISOLanguageTable
{
	private CFBamSybaseSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByBaseIdx = null;
	protected PreparedStatement stmtReadBuffByCountryIdx = null;
	protected PreparedStatement stmtReadBuffByCodeIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByBaseIdx = null;
	protected PreparedStatement stmtDeleteByCountryIdx = null;
	protected PreparedStatement stmtDeleteByCodeIdx = null;

	public CFBamSybaseISOLanguageTable( CFBamSybaseSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		final String S_ProcName = "createISOLanguage";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			short Id = Buff.getRequiredId();
			String ISOCode = Buff.getRequiredISOCode();
			String BaseLanguageCode = Buff.getRequiredBaseLanguageCode();
			Short ISOCountryId = Buff.getOptionalISOCountryId();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_iso_lang ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "ISLN" );
			stmtCreateByPKey.setShort( argIdx++, Id );
			stmtCreateByPKey.setString( argIdx++, ISOCode );
			stmtCreateByPKey.setString( argIdx++, BaseLanguageCode );
			if( ISOCountryId != null ) {
				stmtCreateByPKey.setShort( argIdx++, ISOCountryId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff createdBuff = unpackISOLanguageResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredISOCode( createdBuff.getRequiredISOCode() );
				Buff.setRequiredBaseLanguageCode( createdBuff.getRequiredBaseLanguageCode() );
				Buff.setOptionalISOCountryId( createdBuff.getOptionalISOCountryId() );
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

	protected static String S_sqlSelectISOLanguageDistinctClassCode = null;

	public String getSqlSelectISOLanguageDistinctClassCode() {
		if( S_sqlSelectISOLanguageDistinctClassCode == null ) {
			S_sqlSelectISOLanguageDistinctClassCode =
					"SELECT "
				+		"DISTINCT isln.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..iso_lang AS isln ";
		}
		return( S_sqlSelectISOLanguageDistinctClassCode );
	}

	protected static String S_sqlSelectISOLanguageBuff = null;

	public String getSqlSelectISOLanguageBuff() {
		if( S_sqlSelectISOLanguageBuff == null ) {
			S_sqlSelectISOLanguageBuff =
					"SELECT "
				+		"isln.id, "
				+		"isln.iso_code, "
				+		"isln.base_lang_cd, "
				+		"isln.iso_country_id, "
				+		"isln.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..iso_lang AS isln ";
		}
		return( S_sqlSelectISOLanguageBuff );
	}

	protected CFBamISOLanguageBuff unpackISOLanguageResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackISOLanguageResultSetToBuff";
		int idxcol = 1;
		CFBamISOLanguageBuff buff = schema.getFactoryISOLanguage().newBuff();
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
				buff.setCreatedAt( CFBamSybaseSchema.convertTimestampString( colString ) );
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
				buff.setUpdatedAt( CFBamSybaseSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredId( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredISOCode( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredBaseLanguageCode( resultSet.getString( idxcol ) );
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalISOCountryId( null );
			}
			else {
				buff.setOptionalISOCountryId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamISOLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOLanguageBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOLanguageBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOLanguageBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamISOLanguageBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamISOLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamSybaseISOLanguageTable.readDerivedByIdIdx() ";
		CFBamISOLanguageBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				Id );
		return( buff );
	}

	public CFBamISOLanguageBuff[] readDerivedByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		final String S_ProcName = "readDerivedByBaseIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOLanguageBuff[] buffList = readBuffByBaseIdx( Authorization,
				BaseLanguageCode );
		return( buffList );

	}

	public CFBamISOLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		final String S_ProcName = "readDerivedByCountryIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOLanguageBuff[] buffList = readBuffByCountryIdx( Authorization,
				ISOCountryId );
		return( buffList );

	}

	public CFBamISOLanguageBuff readDerivedByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamSybaseISOLanguageTable.readDerivedByCodeIdx() ";
		CFBamISOLanguageBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByCodeIdx( Authorization,
				ISOCode );
		return( buff );
	}

	public CFBamISOLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
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
			short Id = PKey.getRequiredId();
			String sql = "exec sp_read_iso_lang ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByPKey == null ) {
				stmtReadBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setShort( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
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

	public CFBamISOLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
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
			short Id = PKey.getRequiredId();
			String sql = "exec sp_lock_iso_lang ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtLockBuffByPKey == null ) {
				stmtLockBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setShort( argIdx++, Id );
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
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

	public CFBamISOLanguageBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_iso_lang_all ?, ?, ?, ?, ?";
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
			List<CFBamISOLanguageBuff> buffList = new LinkedList<CFBamISOLanguageBuff>();
			while( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOLanguageBuff[] retBuff = new CFBamISOLanguageBuff[ buffList.size() ];
			Iterator<CFBamISOLanguageBuff> iter = buffList.iterator();
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

	public CFBamISOLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_iso_lang_by_ididx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByIdIdx == null ) {
				stmtReadBuffByIdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setShort( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
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

	public CFBamISOLanguageBuff[] readBuffByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		final String S_ProcName = "readBuffByBaseIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_iso_lang_by_baseidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByBaseIdx == null ) {
				stmtReadBuffByBaseIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByBaseIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByBaseIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByBaseIdx.setString( argIdx++, BaseLanguageCode );
			resultSet = stmtReadBuffByBaseIdx.executeQuery();
			List<CFBamISOLanguageBuff> buffList = new LinkedList<CFBamISOLanguageBuff>();
			while( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOLanguageBuff[] retBuff = new CFBamISOLanguageBuff[ buffList.size() ];
			Iterator<CFBamISOLanguageBuff> iter = buffList.iterator();
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

	public CFBamISOLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		final String S_ProcName = "readBuffByCountryIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_iso_lang_by_countryidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByCountryIdx == null ) {
				stmtReadBuffByCountryIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ISOCountryId != null ) {
				stmtReadBuffByCountryIdx.setShort( argIdx++, ISOCountryId.shortValue() );
			}
			else {
				stmtReadBuffByCountryIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByCountryIdx.executeQuery();
			List<CFBamISOLanguageBuff> buffList = new LinkedList<CFBamISOLanguageBuff>();
			while( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOLanguageBuff[] retBuff = new CFBamISOLanguageBuff[ buffList.size() ];
			Iterator<CFBamISOLanguageBuff> iter = buffList.iterator();
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

	public CFBamISOLanguageBuff readBuffByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "readBuffByCodeIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_iso_lang_by_codeidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByCodeIdx == null ) {
				stmtReadBuffByCodeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCodeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByCodeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByCodeIdx.setString( argIdx++, ISOCode );
			resultSet = stmtReadBuffByCodeIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
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

	public void updateISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		final String S_ProcName = "updateISOLanguage";
		ResultSet resultSet = null;
		try {
			short Id = Buff.getRequiredId();
			String ISOCode = Buff.getRequiredISOCode();
			String BaseLanguageCode = Buff.getRequiredBaseLanguageCode();
			Short ISOCountryId = Buff.getOptionalISOCountryId();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_iso_lang ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+ "?";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "ISLN" );
			stmtUpdateByPKey.setShort( argIdx++, Id );
			stmtUpdateByPKey.setString( argIdx++, ISOCode );
			stmtUpdateByPKey.setString( argIdx++, BaseLanguageCode );
			if( ISOCountryId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, ISOCountryId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOLanguageBuff updatedBuff = unpackISOLanguageResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredISOCode( updatedBuff.getRequiredISOCode() );
				Buff.setRequiredBaseLanguageCode( updatedBuff.getRequiredBaseLanguageCode() );
				Buff.setOptionalISOCountryId( updatedBuff.getOptionalISOCountryId() );
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

	public void deleteISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		final String S_ProcName = "deleteISOLanguage";
		try {
			Connection cnx = schema.getCnx();
			short Id = Buff.getRequiredId();

			String sql = "exec sp_delete_iso_lang ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setShort( argIdx++, Id );
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

	public void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "deleteISOLanguageByIdIdx";
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_iso_lang ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setShort( argIdx++, Id );
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

	public void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey argKey )
	{
		deleteISOLanguageByIdIdx( Authorization,
			argKey.getRequiredId() );
	}

	public void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		final String S_ProcName = "deleteISOLanguageByBaseIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_iso_lang_by_baseidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByBaseIdx== null ) {
				stmtDeleteByBaseIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByBaseIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByBaseIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByBaseIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByBaseIdx.setString( argIdx++, BaseLanguageCode );
			Object stuff = null;
			boolean moreResults = stmtDeleteByBaseIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByBaseIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByBaseIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByBaseIdx.getUpdateCount() ) {
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

	public void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByBaseIdxKey argKey )
	{
		deleteISOLanguageByBaseIdx( Authorization,
			argKey.getRequiredBaseLanguageCode() );
	}

	public void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		final String S_ProcName = "deleteISOLanguageByCountryIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_iso_lang_by_countryidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByCountryIdx== null ) {
				stmtDeleteByCountryIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ISOCountryId != null ) {
				stmtDeleteByCountryIdx.setShort( argIdx++, ISOCountryId.shortValue() );
			}
			else {
				stmtDeleteByCountryIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByCountryIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByCountryIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByCountryIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByCountryIdx.getUpdateCount() ) {
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

	public void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCountryIdxKey argKey )
	{
		deleteISOLanguageByCountryIdx( Authorization,
			argKey.getOptionalISOCountryId() );
	}

	public void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "deleteISOLanguageByCodeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_iso_lang_by_codeidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByCodeIdx== null ) {
				stmtDeleteByCodeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCodeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByCodeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCodeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByCodeIdx.setString( argIdx++, ISOCode );
			Object stuff = null;
			boolean moreResults = stmtDeleteByCodeIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByCodeIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByCodeIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByCodeIdx.getUpdateCount() ) {
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

	public void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCodeIdxKey argKey )
	{
		deleteISOLanguageByCodeIdx( Authorization,
			argKey.getRequiredISOCode() );
	}

	public CFBamCursor openISOLanguageCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectISOLanguageBuff()
			+	"ORDER BY " 
			+		"isln.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOLanguageCursorByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		String sql = getSqlSelectISOLanguageBuff()
			+	"WHERE "
				+		"isln.base_lang_cd = " + CFBamSybaseSchema.getQuotedString( BaseLanguageCode ) + " "
			+	"ORDER BY " 
			+		"isln.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		String sql = getSqlSelectISOLanguageBuff()
			+	"WHERE "
				+		( ( ISOCountryId == null ) ? "isln.iso_country_id is null "
							: "isln.iso_country_id = " + ISOCountryId.toString() + " " )
			+	"ORDER BY " 
			+		"isln.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeISOLanguageCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeISOLanguageCursor",
				e );
		}
	}

	public CFBamISOLanguageBuff nextISOLanguageCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextISOLanguageCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamISOLanguageBuff buff = unpackISOLanguageResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamISOLanguageBuff prevISOLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOLanguageBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOLanguageCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOLanguageBuff firstISOLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOLanguageBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOLanguageCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOLanguageBuff lastISOLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastISOLanguageCursor" );
	}

	public CFBamISOLanguageBuff nthISOLanguageCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOLanguageBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOLanguageCursor( Cursor );
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
		S_sqlSelectISOLanguageDistinctClassCode = null;
		S_sqlSelectISOLanguageBuff = null;

		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtReadBuffByPKey = null;
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtLockBuffByPKey = null;
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtCreateByPKey = null;
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtUpdateByPKey = null;
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtDeleteByPKey = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadAllBuff = null;
			}
		}
		if( stmtReadBuffByBaseIdx != null ) {
			try {
				stmtReadBuffByBaseIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByBaseIdx = null;
			}
		}
		if( stmtReadBuffByCountryIdx != null ) {
			try {
				stmtReadBuffByCountryIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByCountryIdx = null;
			}
		}
		if( stmtReadBuffByCodeIdx != null ) {
			try {
				stmtReadBuffByCodeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByCodeIdx = null;
			}
		}
		if( stmtDeleteByBaseIdx != null ) {
			try {
				stmtDeleteByBaseIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByBaseIdx = null;
			}
		}
		if( stmtDeleteByCountryIdx != null ) {
			try {
				stmtDeleteByCountryIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByCountryIdx = null;
			}
		}
		if( stmtDeleteByCodeIdx != null ) {
			try {
				stmtDeleteByCodeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByCodeIdx = null;
			}
		}
		if( stmtReadBuffByBaseIdx != null ) {
			try {
				stmtReadBuffByBaseIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByBaseIdx = null;
			}
		}
		if( stmtReadBuffByCountryIdx != null ) {
			try {
				stmtReadBuffByCountryIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByCountryIdx = null;
			}
		}
		if( stmtReadBuffByCodeIdx != null ) {
			try {
				stmtReadBuffByCodeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByCodeIdx = null;
			}
		}
	}
}
