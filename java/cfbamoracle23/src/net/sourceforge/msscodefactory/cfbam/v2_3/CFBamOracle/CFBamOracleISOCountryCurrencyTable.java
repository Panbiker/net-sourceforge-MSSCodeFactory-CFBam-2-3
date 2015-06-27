// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for ISOCountryCurrency.

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
 *	CFBamOracleISOCountryCurrencyTable Oracle 11gR2 Jdbc DbIO implementation
 *	for ISOCountryCurrency.
 */
public class CFBamOracleISOCountryCurrencyTable
	implements ICFBamISOCountryCurrencyTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByCountryIdx = null;
	protected PreparedStatement stmtReadBuffByCurrencyIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByCountryIdx = null;
	protected PreparedStatement stmtDeleteByCurrencyIdx = null;

	public CFBamOracleISOCountryCurrencyTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		final String S_ProcName = "createISOCountryCurrency";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			short ISOCountryId = Buff.getRequiredISOCountryId();
			short ISOCurrencyId = Buff.getRequiredISOCurrencyId();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_iso_cntryccy( ?, ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtCreateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "ICCY" );
			stmtCreateByPKey.setShort( argIdx++, ISOCountryId );
			stmtCreateByPKey.setShort( argIdx++, ISOCurrencyId );
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_iso_cntryccy() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamISOCountryCurrencyBuff createdBuff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredISOCountryId( createdBuff.getRequiredISOCountryId() );
				Buff.setRequiredISOCurrencyId( createdBuff.getRequiredISOCurrencyId() );
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
					"crt_iso_cntryccy() did not return a valid result set" );
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

	protected static String S_sqlSelectISOCountryCurrencyDistinctClassCode = null;

	public String getSqlSelectISOCountryCurrencyDistinctClassCode() {
		if( S_sqlSelectISOCountryCurrencyDistinctClassCode == null ) {
			S_sqlSelectISOCountryCurrencyDistinctClassCode =
					"SELECT "
				+		"DISTINCT iccy.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".iso_cntryccy iccy ";
		}
		return( S_sqlSelectISOCountryCurrencyDistinctClassCode );
	}

	protected static String S_sqlSelectISOCountryCurrencyBuff = null;

	public String getSqlSelectISOCountryCurrencyBuff() {
		if( S_sqlSelectISOCountryCurrencyBuff == null ) {
			S_sqlSelectISOCountryCurrencyBuff =
					"SELECT "
				+		"iccy.ISOCountryId, "
				+		"iccy.ISOCurrencyId, "
				+		"iccy.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".iso_cntryccy iccy ";
		}
		return( S_sqlSelectISOCountryCurrencyBuff );
	}

	protected CFBamISOCountryCurrencyBuff unpackISOCountryCurrencyResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackISOCountryCurrencyResultSetToBuff";
		int idxcol = 1;
		CFBamISOCountryCurrencyBuff buff = schema.getFactoryISOCountryCurrency().newBuff();
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
		buff.setRequiredISOCountryId( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredISOCurrencyId( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOCountryCurrencyBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOCountryCurrencyBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamISOCountryCurrencyBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamISOCountryCurrencyBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOCurrencyId )
	{
		final String S_ProcName = "CFBamOracleISOCountryCurrencyTable.readDerivedByIdIdx() ";
		CFBamISOCountryCurrencyBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				ISOCountryId,
				ISOCurrencyId );
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "readDerivedByCountryIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOCountryCurrencyBuff[] buffList = readBuffByCountryIdx( Authorization,
				ISOCountryId );
		return( buffList );

	}

	public CFBamISOCountryCurrencyBuff[] readDerivedByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		final String S_ProcName = "readDerivedByCurrencyIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOCountryCurrencyBuff[] buffList = readBuffByCurrencyIdx( Authorization,
				ISOCurrencyId );
		return( buffList );

	}

	public CFBamISOCountryCurrencyBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
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
			short ISOCountryId = PKey.getRequiredISOCountryId();
			short ISOCurrencyId = PKey.getRequiredISOCurrencyId();

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_iso_cntryccy( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setShort( argIdx++, ISOCountryId );
			stmtReadBuffByPKey.setShort( argIdx++, ISOCurrencyId );
			stmtReadBuffByPKey.execute();
			resultSet = (ResultSet)stmtReadBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
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

	public CFBamISOCountryCurrencyBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
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
			short ISOCountryId = PKey.getRequiredISOCountryId();
			short ISOCurrencyId = PKey.getRequiredISOCurrencyId();

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_iso_cntryccy( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setShort( argIdx++, ISOCountryId );
			stmtLockBuffByPKey.setShort( argIdx++, ISOCurrencyId );
			stmtLockBuffByPKey.execute();
			resultSet = (ResultSet)stmtLockBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
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

	public CFBamISOCountryCurrencyBuff[] readAllBuff( CFBamAuthorization Authorization ) {
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
			CFBamISOCountryCurrencyBuff buff = null;
			List<CFBamISOCountryCurrencyBuff> buffList = new LinkedList<CFBamISOCountryCurrencyBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_iso_cntryccyall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamISOCountryCurrencyBuff[] retBuff = new CFBamISOCountryCurrencyBuff[ buffList.size() ];
			Iterator<CFBamISOCountryCurrencyBuff> iter = buffList.iterator();
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

	public CFBamISOCountryCurrencyBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOCurrencyId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_iso_cntryccybyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setShort( argIdx++, ISOCountryId );
			stmtReadBuffByIdIdx.setShort( argIdx++, ISOCurrencyId );
			stmtReadBuffByIdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
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

	public CFBamISOCountryCurrencyBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "readBuffByCountryIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByCountryIdx = null;
		List<CFBamISOCountryCurrencyBuff> buffList = new LinkedList<CFBamISOCountryCurrencyBuff>();
		try {
			stmtReadBuffByCountryIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_iso_cntryccybycountryidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByCountryIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByCountryIdx.setShort( argIdx++, ISOCountryId );
			stmtReadBuffByCountryIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByCountryIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
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
			CFBamISOCountryCurrencyBuff[] retBuff = new CFBamISOCountryCurrencyBuff[ buffList.size() ];
			Iterator<CFBamISOCountryCurrencyBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByCountryIdx != null ) {
				try {
					stmtReadBuffByCountryIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByCountryIdx = null;
			}
		}
	}

	public CFBamISOCountryCurrencyBuff[] readBuffByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		final String S_ProcName = "readBuffByCurrencyIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByCurrencyIdx = null;
		List<CFBamISOCountryCurrencyBuff> buffList = new LinkedList<CFBamISOCountryCurrencyBuff>();
		try {
			stmtReadBuffByCurrencyIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_iso_cntryccybycurrencyidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByCurrencyIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCurrencyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByCurrencyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByCurrencyIdx.setShort( argIdx++, ISOCurrencyId );
			stmtReadBuffByCurrencyIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByCurrencyIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
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
			CFBamISOCountryCurrencyBuff[] retBuff = new CFBamISOCountryCurrencyBuff[ buffList.size() ];
			Iterator<CFBamISOCountryCurrencyBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByCurrencyIdx != null ) {
				try {
					stmtReadBuffByCurrencyIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByCurrencyIdx = null;
			}
		}
	}

	public void updateISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		final String S_ProcName = "updateISOCountryCurrency";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamISOCountryCurrencyBuff> buffList = new LinkedList<CFBamISOCountryCurrencyBuff>();
		try {			short ISOCountryId = Buff.getRequiredISOCountryId();
			short ISOCurrencyId = Buff.getRequiredISOCurrencyId();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_iso_cntryccy( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "ICCY" );
			stmtUpdateByPKey.setShort( argIdx++, ISOCountryId );
			stmtUpdateByPKey.setShort( argIdx++, ISOCurrencyId );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamISOCountryCurrencyBuff updatedBuff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
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
						"upd_iso_cntryccy() did not return a valid result cursor" );
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
					"upd_iso_cntryccy() did not return a result cursor" );
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

	public void deleteISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		final String S_ProcName = "deleteISOCountryCurrency";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			short ISOCountryId = Buff.getRequiredISOCountryId();
			short ISOCurrencyId = Buff.getRequiredISOCurrencyId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_iso_cntryccy( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setShort( argIdx++, ISOCountryId );
			stmtDeleteByPKey.setShort( argIdx++, ISOCurrencyId );
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

	public void deleteISOCountryCurrencyByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOCurrencyId )
	{
		final String S_ProcName = "deleteISOCountryCurrencyByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_iso_cntryccybyididx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByIdIdx.setShort( argIdx++, argISOCountryId );
				stmtDeleteByIdIdx.setShort( argIdx++, argISOCurrencyId );
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

	public void deleteISOCountryCurrencyByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey argKey )
	{
		deleteISOCountryCurrencyByIdIdx( Authorization,
			argKey.getRequiredISOCountryId(),
			argKey.getRequiredISOCurrencyId() );
	}

	public void deleteISOCountryCurrencyByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		final String S_ProcName = "deleteISOCountryCurrencyByCountryIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_iso_cntryccybycountryidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByCountryIdx == null ) {
					stmtDeleteByCountryIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByCountryIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByCountryIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByCountryIdx.setShort( argIdx++, argISOCountryId );
				int rowsUpdated = stmtDeleteByCountryIdx.executeUpdate();
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

	public void deleteISOCountryCurrencyByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyByCountryIdxKey argKey )
	{
		deleteISOCountryCurrencyByCountryIdx( Authorization,
			argKey.getRequiredISOCountryId() );
	}

	public void deleteISOCountryCurrencyByCurrencyIdx( CFBamAuthorization Authorization,
		short argISOCurrencyId )
	{
		final String S_ProcName = "deleteISOCountryCurrencyByCurrencyIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_iso_cntryccybycurrencyidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByCurrencyIdx == null ) {
					stmtDeleteByCurrencyIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByCurrencyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByCurrencyIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByCurrencyIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByCurrencyIdx.setShort( argIdx++, argISOCurrencyId );
				int rowsUpdated = stmtDeleteByCurrencyIdx.executeUpdate();
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

	public void deleteISOCountryCurrencyByCurrencyIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyByCurrencyIdxKey argKey )
	{
		deleteISOCountryCurrencyByCurrencyIdx( Authorization,
			argKey.getRequiredISOCurrencyId() );
	}

	public CFBamCursor openISOCountryCurrencyCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectISOCountryCurrencyBuff()
			+	"ORDER BY " 
			+		"iccy.ISOCountryId ASC" + ", "
			+		"iccy.ISOCurrencyId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOCountryCurrencyCursorByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		String sql = getSqlSelectISOCountryCurrencyBuff()
			+	"WHERE "
				+		"iccy.ISOCountryId = " + Short.toString( ISOCountryId ) + " "
			+	"ORDER BY " 
			+		"iccy.ISOCountryId ASC" + ", "
			+		"iccy.ISOCurrencyId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOCountryCurrencyCursorByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		String sql = getSqlSelectISOCountryCurrencyBuff()
			+	"WHERE "
				+		"iccy.ISOCurrencyId = " + Short.toString( ISOCurrencyId ) + " "
			+	"ORDER BY " 
			+		"iccy.ISOCountryId ASC" + ", "
			+		"iccy.ISOCurrencyId ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeISOCountryCurrencyCursor",
				e );
		}
	}

	public CFBamISOCountryCurrencyBuff nextISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextISOCountryCurrencyCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamISOCountryCurrencyBuff buff = unpackISOCountryCurrencyResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamISOCountryCurrencyBuff prevISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOCountryCurrencyBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOCountryCurrencyCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff firstISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOCountryCurrencyBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOCountryCurrencyCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff lastISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastISOCountryCurrencyCursor" );
	}

	public CFBamISOCountryCurrencyBuff nthISOCountryCurrencyCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOCountryCurrencyBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOCountryCurrencyCursor( Cursor );
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
		S_sqlSelectISOCountryCurrencyBuff = null;
		S_sqlSelectISOCountryCurrencyDistinctClassCode = null;

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
		if( stmtDeleteByCountryIdx != null ) {
			try {
				stmtDeleteByCountryIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByCountryIdx = null;
		}
		if( stmtDeleteByCurrencyIdx != null ) {
			try {
				stmtDeleteByCurrencyIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByCurrencyIdx = null;
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
		if( stmtReadBuffByCountryIdx != null ) {
			try {
				stmtReadBuffByCountryIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByCountryIdx = null;
		}
		if( stmtReadBuffByCurrencyIdx != null ) {
			try {
				stmtReadBuffByCurrencyIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByCurrencyIdx = null;
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
		if( stmtDeleteByCountryIdx != null ) {
			try {
				stmtDeleteByCountryIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByCountryIdx = null;
		}
		if( stmtDeleteByCurrencyIdx != null ) {
			try {
				stmtDeleteByCurrencyIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByCurrencyIdx = null;
		}
	}
}
