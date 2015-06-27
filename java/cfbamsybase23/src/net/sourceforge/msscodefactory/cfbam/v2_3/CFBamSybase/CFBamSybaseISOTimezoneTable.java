// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for ISOTimezone.

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
 *	CFBamSybaseISOTimezoneTable PostgreSQL Jdbc DbIO implementation
 *	for ISOTimezone.
 */
public class CFBamSybaseISOTimezoneTable
	implements ICFBamISOTimezoneTable
{
	private CFBamSybaseSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByOffsetIdx = null;
	protected PreparedStatement stmtReadBuffByUTZNameIdx = null;
	protected PreparedStatement stmtReadBuffByIso8601Idx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByOffsetIdx = null;
	protected PreparedStatement stmtDeleteByUTZNameIdx = null;
	protected PreparedStatement stmtDeleteByIso8601Idx = null;

	public CFBamSybaseISOTimezoneTable( CFBamSybaseSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		final String S_ProcName = "createISOTimezone";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			short ISOTimezoneId = Buff.getRequiredISOTimezoneId();
			String Iso8601 = Buff.getRequiredIso8601();
			String TZName = Buff.getRequiredTZName();
			short TZHourOffset = Buff.getRequiredTZHourOffset();
			short TZMinOffset = Buff.getRequiredTZMinOffset();
			String Description = Buff.getRequiredDescription();
			boolean Visible = Buff.getRequiredVisible();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_isotz ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, "ITZN" );
			stmtCreateByPKey.setShort( argIdx++, ISOTimezoneId );
			stmtCreateByPKey.setString( argIdx++, Iso8601 );
			stmtCreateByPKey.setString( argIdx++, TZName );
			stmtCreateByPKey.setShort( argIdx++, TZHourOffset );
			stmtCreateByPKey.setShort( argIdx++, TZMinOffset );
			stmtCreateByPKey.setString( argIdx++, Description );
			if( Visible ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff createdBuff = unpackISOTimezoneResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredISOTimezoneId( createdBuff.getRequiredISOTimezoneId() );
				Buff.setRequiredIso8601( createdBuff.getRequiredIso8601() );
				Buff.setRequiredTZName( createdBuff.getRequiredTZName() );
				Buff.setRequiredTZHourOffset( createdBuff.getRequiredTZHourOffset() );
				Buff.setRequiredTZMinOffset( createdBuff.getRequiredTZMinOffset() );
				Buff.setRequiredDescription( createdBuff.getRequiredDescription() );
				Buff.setRequiredVisible( createdBuff.getRequiredVisible() );
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

	protected static String S_sqlSelectISOTimezoneDistinctClassCode = null;

	public String getSqlSelectISOTimezoneDistinctClassCode() {
		if( S_sqlSelectISOTimezoneDistinctClassCode == null ) {
			S_sqlSelectISOTimezoneDistinctClassCode =
					"SELECT "
				+		"DISTINCT itzn.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..ISOTz AS itzn ";
		}
		return( S_sqlSelectISOTimezoneDistinctClassCode );
	}

	protected static String S_sqlSelectISOTimezoneBuff = null;

	public String getSqlSelectISOTimezoneBuff() {
		if( S_sqlSelectISOTimezoneBuff == null ) {
			S_sqlSelectISOTimezoneBuff =
					"SELECT "
				+		"itzn.isotimezoneid, "
				+		"itzn.iso8601, "
				+		"itzn.tzname, "
				+		"itzn.tzhouroffset, "
				+		"itzn.tzminoffset, "
				+		"itzn.description, "
				+		"itzn.visible, "
				+		"itzn.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..ISOTz AS itzn ";
		}
		return( S_sqlSelectISOTimezoneBuff );
	}

	protected CFBamISOTimezoneBuff unpackISOTimezoneResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackISOTimezoneResultSetToBuff";
		int idxcol = 1;
		CFBamISOTimezoneBuff buff = schema.getFactoryISOTimezone().newBuff();
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
		buff.setRequiredISOTimezoneId( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredIso8601( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredTZName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredTZHourOffset( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredTZMinOffset( resultSet.getShort( idxcol ) );
		idxcol++;
		buff.setRequiredDescription( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredVisible( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamISOTimezoneBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOTimezoneBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOTimezoneBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOTimezoneBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamISOTimezoneBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamISOTimezoneBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOTimezoneId )
	{
		final String S_ProcName = "CFBamSybaseISOTimezoneTable.readDerivedByIdIdx() ";
		CFBamISOTimezoneBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				ISOTimezoneId );
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readDerivedByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "readDerivedByOffsetIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOTimezoneBuff[] buffList = readBuffByOffsetIdx( Authorization,
				TZHourOffset,
				TZMinOffset );
		return( buffList );

	}

	public CFBamISOTimezoneBuff readDerivedByUTZNameIdx( CFBamAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "CFBamSybaseISOTimezoneTable.readDerivedByUTZNameIdx() ";
		CFBamISOTimezoneBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUTZNameIdx( Authorization,
				TZName );
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readDerivedByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "readDerivedByIso8601Idx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamISOTimezoneBuff[] buffList = readBuffByIso8601Idx( Authorization,
				Iso8601 );
		return( buffList );

	}

	public CFBamISOTimezoneBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
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
			short ISOTimezoneId = PKey.getRequiredISOTimezoneId();
			String sql = "exec sp_read_isotz ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByPKey.setShort( argIdx++, ISOTimezoneId );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
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

	public CFBamISOTimezoneBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
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
			short ISOTimezoneId = PKey.getRequiredISOTimezoneId();
			String sql = "exec sp_lock_isotz ?, ?, ?, ?, ?" + ", "
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
			stmtLockBuffByPKey.setShort( argIdx++, ISOTimezoneId );
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
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

	public CFBamISOTimezoneBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_isotz_all ?, ?, ?, ?, ?";
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
			List<CFBamISOTimezoneBuff> buffList = new LinkedList<CFBamISOTimezoneBuff>();
			while( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOTimezoneBuff[] retBuff = new CFBamISOTimezoneBuff[ buffList.size() ];
			Iterator<CFBamISOTimezoneBuff> iter = buffList.iterator();
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

	public CFBamISOTimezoneBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOTimezoneId )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_isotz_by_ididx ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByIdIdx.setShort( argIdx++, ISOTimezoneId );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
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

	public CFBamISOTimezoneBuff[] readBuffByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "readBuffByOffsetIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_isotz_by_offsetidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByOffsetIdx == null ) {
				stmtReadBuffByOffsetIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByOffsetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByOffsetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByOffsetIdx.setShort( argIdx++, TZHourOffset );
			stmtReadBuffByOffsetIdx.setShort( argIdx++, TZMinOffset );
			resultSet = stmtReadBuffByOffsetIdx.executeQuery();
			List<CFBamISOTimezoneBuff> buffList = new LinkedList<CFBamISOTimezoneBuff>();
			while( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOTimezoneBuff[] retBuff = new CFBamISOTimezoneBuff[ buffList.size() ];
			Iterator<CFBamISOTimezoneBuff> iter = buffList.iterator();
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

	public CFBamISOTimezoneBuff readBuffByUTZNameIdx( CFBamAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "readBuffByUTZNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_isotz_by_utznameidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByUTZNameIdx == null ) {
				stmtReadBuffByUTZNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUTZNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUTZNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUTZNameIdx.setString( argIdx++, TZName );
			resultSet = stmtReadBuffByUTZNameIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
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

	public CFBamISOTimezoneBuff[] readBuffByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "readBuffByIso8601Idx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_isotz_by_iso8601idx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByIso8601Idx == null ) {
				stmtReadBuffByIso8601Idx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIso8601Idx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIso8601Idx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIso8601Idx.setString( argIdx++, Iso8601 );
			resultSet = stmtReadBuffByIso8601Idx.executeQuery();
			List<CFBamISOTimezoneBuff> buffList = new LinkedList<CFBamISOTimezoneBuff>();
			while( resultSet.next() ) {
				CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamISOTimezoneBuff[] retBuff = new CFBamISOTimezoneBuff[ buffList.size() ];
			Iterator<CFBamISOTimezoneBuff> iter = buffList.iterator();
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

	public void updateISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		final String S_ProcName = "updateISOTimezone";
		ResultSet resultSet = null;
		try {
			short ISOTimezoneId = Buff.getRequiredISOTimezoneId();
			String Iso8601 = Buff.getRequiredIso8601();
			String TZName = Buff.getRequiredTZName();
			short TZHourOffset = Buff.getRequiredTZHourOffset();
			short TZMinOffset = Buff.getRequiredTZMinOffset();
			String Description = Buff.getRequiredDescription();
			boolean Visible = Buff.getRequiredVisible();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_isotz ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "ITZN" );
			stmtUpdateByPKey.setShort( argIdx++, ISOTimezoneId );
			stmtUpdateByPKey.setString( argIdx++, Iso8601 );
			stmtUpdateByPKey.setString( argIdx++, TZName );
			stmtUpdateByPKey.setShort( argIdx++, TZHourOffset );
			stmtUpdateByPKey.setShort( argIdx++, TZMinOffset );
			stmtUpdateByPKey.setString( argIdx++, Description );
			if( Visible ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamISOTimezoneBuff updatedBuff = unpackISOTimezoneResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredIso8601( updatedBuff.getRequiredIso8601() );
				Buff.setRequiredTZName( updatedBuff.getRequiredTZName() );
				Buff.setRequiredTZHourOffset( updatedBuff.getRequiredTZHourOffset() );
				Buff.setRequiredTZMinOffset( updatedBuff.getRequiredTZMinOffset() );
				Buff.setRequiredDescription( updatedBuff.getRequiredDescription() );
				Buff.setRequiredVisible( updatedBuff.getRequiredVisible() );
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

	public void deleteISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		final String S_ProcName = "deleteISOTimezone";
		try {
			Connection cnx = schema.getCnx();
			short ISOTimezoneId = Buff.getRequiredISOTimezoneId();

			String sql = "exec sp_delete_isotz ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setShort( argIdx++, ISOTimezoneId );
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

	public void deleteISOTimezoneByIdIdx( CFBamAuthorization Authorization,
		short ISOTimezoneId )
	{
		final String S_ProcName = "deleteISOTimezoneByIdIdx";
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_isotz ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setShort( argIdx++, ISOTimezoneId );
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

	public void deleteISOTimezoneByIdIdx( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey argKey )
	{
		deleteISOTimezoneByIdIdx( Authorization,
			argKey.getRequiredISOTimezoneId() );
	}

	public void deleteISOTimezoneByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "deleteISOTimezoneByOffsetIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_isotz_by_offsetidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByOffsetIdx== null ) {
				stmtDeleteByOffsetIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByOffsetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByOffsetIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByOffsetIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByOffsetIdx.setShort( argIdx++, TZHourOffset );
			stmtDeleteByOffsetIdx.setShort( argIdx++, TZMinOffset );
			Object stuff = null;
			boolean moreResults = stmtDeleteByOffsetIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByOffsetIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByOffsetIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByOffsetIdx.getUpdateCount() ) {
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

	public void deleteISOTimezoneByOffsetIdx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByOffsetIdxKey argKey )
	{
		deleteISOTimezoneByOffsetIdx( Authorization,
			argKey.getRequiredTZHourOffset(),
			argKey.getRequiredTZMinOffset() );
	}

	public void deleteISOTimezoneByUTZNameIdx( CFBamAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "deleteISOTimezoneByUTZNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_isotz_by_utznameidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByUTZNameIdx== null ) {
				stmtDeleteByUTZNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUTZNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUTZNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUTZNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUTZNameIdx.setString( argIdx++, TZName );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUTZNameIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUTZNameIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUTZNameIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUTZNameIdx.getUpdateCount() ) {
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

	public void deleteISOTimezoneByUTZNameIdx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByUTZNameIdxKey argKey )
	{
		deleteISOTimezoneByUTZNameIdx( Authorization,
			argKey.getRequiredTZName() );
	}

	public void deleteISOTimezoneByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "deleteISOTimezoneByIso8601Idx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_isotz_by_iso8601idx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByIso8601Idx== null ) {
				stmtDeleteByIso8601Idx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByIso8601Idx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByIso8601Idx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByIso8601Idx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByIso8601Idx.setString( argIdx++, Iso8601 );
			Object stuff = null;
			boolean moreResults = stmtDeleteByIso8601Idx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByIso8601Idx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByIso8601Idx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByIso8601Idx.getUpdateCount() ) {
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

	public void deleteISOTimezoneByIso8601Idx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByIso8601IdxKey argKey )
	{
		deleteISOTimezoneByIso8601Idx( Authorization,
			argKey.getRequiredIso8601() );
	}

	public CFBamCursor openISOTimezoneCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectISOTimezoneBuff()
			+	"ORDER BY " 
			+		"itzn.ISOTimezoneId ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOTimezoneCursorByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		String sql = getSqlSelectISOTimezoneBuff()
			+	"WHERE "
				+		"itzn.tzhouroffset = " + Short.toString( TZHourOffset ) + " "
			+	"AND "
				+		"itzn.tzminoffset = " + Short.toString( TZMinOffset ) + " "
			+	"ORDER BY " 
			+		"itzn.ISOTimezoneId ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openISOTimezoneCursorByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		String sql = getSqlSelectISOTimezoneBuff()
			+	"WHERE "
				+		"itzn.iso8601 = " + CFBamSybaseSchema.getQuotedString( Iso8601 ) + " "
			+	"ORDER BY " 
			+		"itzn.ISOTimezoneId ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeISOTimezoneCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeISOTimezoneCursor",
				e );
		}
	}

	public CFBamISOTimezoneBuff nextISOTimezoneCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextISOTimezoneCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamISOTimezoneBuff buff = unpackISOTimezoneResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamISOTimezoneBuff prevISOTimezoneCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOTimezoneBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOTimezoneCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff firstISOTimezoneCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOTimezoneBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOTimezoneCursor( Cursor );
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff lastISOTimezoneCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastISOTimezoneCursor" );
	}

	public CFBamISOTimezoneBuff nthISOTimezoneCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOTimezoneBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextISOTimezoneCursor( Cursor );
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
		S_sqlSelectISOTimezoneDistinctClassCode = null;
		S_sqlSelectISOTimezoneBuff = null;

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
		if( stmtReadBuffByOffsetIdx != null ) {
			try {
				stmtReadBuffByOffsetIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByOffsetIdx = null;
			}
		}
		if( stmtReadBuffByUTZNameIdx != null ) {
			try {
				stmtReadBuffByUTZNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUTZNameIdx = null;
			}
		}
		if( stmtReadBuffByIso8601Idx != null ) {
			try {
				stmtReadBuffByIso8601Idx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByIso8601Idx = null;
			}
		}
		if( stmtDeleteByOffsetIdx != null ) {
			try {
				stmtDeleteByOffsetIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByOffsetIdx = null;
			}
		}
		if( stmtDeleteByUTZNameIdx != null ) {
			try {
				stmtDeleteByUTZNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUTZNameIdx = null;
			}
		}
		if( stmtDeleteByIso8601Idx != null ) {
			try {
				stmtDeleteByIso8601Idx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByIso8601Idx = null;
			}
		}
		if( stmtReadBuffByOffsetIdx != null ) {
			try {
				stmtReadBuffByOffsetIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByOffsetIdx = null;
			}
		}
		if( stmtReadBuffByUTZNameIdx != null ) {
			try {
				stmtReadBuffByUTZNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUTZNameIdx = null;
			}
		}
		if( stmtReadBuffByIso8601Idx != null ) {
			try {
				stmtReadBuffByIso8601Idx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByIso8601Idx = null;
			}
		}
	}
}
