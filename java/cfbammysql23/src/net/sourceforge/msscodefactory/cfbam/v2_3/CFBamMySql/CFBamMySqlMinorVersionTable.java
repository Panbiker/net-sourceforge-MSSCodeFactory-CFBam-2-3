// Description: Java 7 MySQL Jdbc DbIO implementation for MinorVersion.

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
 *	CFBamMySqlMinorVersionTable MySQL Jdbc DbIO implementation
 *	for MinorVersion.
 */
public class CFBamMySqlMinorVersionTable
	implements ICFBamMinorVersionTable
{
	private CFBamMySqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtReadBuffByMajorIdx = null;
	protected PreparedStatement stmtReadBuffByNameIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtDeleteByMajorIdx = null;
	protected PreparedStatement stmtDeleteByNameIdx = null;

	public CFBamMySqlMinorVersionTable( CFBamMySqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		final String S_ProcName = "createMinorVersion";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			String Description = Buff.getOptionalDescription();
			long MajorId = Buff.getRequiredMajorId();
			String Name = Buff.getRequiredName();
			Connection cnx = schema.getCnx();
			String sql =
				"call " + schema.getLowerDbSchemaName() + ".sp_create_mnverdef( ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, ClassCode );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			if( Description != null ) {
				stmtCreateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtCreateByPKey.setLong( argIdx++, MajorId );
			stmtCreateByPKey.setString( argIdx++, Name );
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
				CFBamMinorVersionBuff createdBuff = unpackMinorVersionResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setOptionalDescription( createdBuff.getOptionalDescription() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				Buff.setRequiredMajorId( createdBuff.getRequiredMajorId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
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

	protected static String S_sqlSelectMinorVersionDistinctClassCode = null;

	public String getSqlSelectMinorVersionDistinctClassCode() {
		if( S_sqlSelectMinorVersionDistinctClassCode == null ) {
			S_sqlSelectMinorVersionDistinctClassCode =
					"SELECT "
				+		"DISTINCT bdom.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".bdomdef AS bdom "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".bprjdef bprj ON "
				+		"bprj.TenantId = bdom.TenantId "
				+		"AND bprj.Id = bdom.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".verndef vern ON "
				+		"vern.TenantId = bdom.TenantId "
				+		"AND vern.Id = bdom.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".mnverdef mnvr ON "
				+		"mnvr.TenantId = bdom.TenantId "
				+		"AND mnvr.Id = bdom.Id ";
		}
		return( S_sqlSelectMinorVersionDistinctClassCode );
	}

	protected static String S_sqlSelectMinorVersionBuff = null;

	public String getSqlSelectMinorVersionBuff() {
		if( S_sqlSelectMinorVersionBuff == null ) {
			S_sqlSelectMinorVersionBuff =
					"SELECT "
				+		"bdom.ClassCode, "
				+		"bdom.TenantId, "
				+		"bdom.Id, "
				+		"bdom.descr, "
				+		"mnvr.MajorId, "
				+		"mnvr.Name, "
				+		"bdom.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".bdomdef AS bdom "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".bprjdef bprj ON "
				+		"bprj.TenantId = bdom.TenantId "
				+		"AND bprj.Id = bdom.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".verndef vern ON "
				+		"vern.TenantId = bdom.TenantId "
				+		"AND vern.Id = bdom.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".mnverdef mnvr ON "
				+		"mnvr.TenantId = bdom.TenantId "
				+		"AND mnvr.Id = bdom.Id ";
		}
		return( S_sqlSelectMinorVersionBuff );
	}

	protected CFBamMinorVersionBuff unpackMinorVersionResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackMinorVersionResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamMinorVersionBuff buff;
		if( classCode.equals( "MNVR" ) ) {
			buff = schema.getFactoryMinorVersion().newBuff();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Unrecognized class code \"" + classCode + "\"" );
		}
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
		idxcol++;		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDescription( null );
			}
			else {
				buff.setOptionalDescription( colVal );
			}
		}
		idxcol++;
		buff.setRequiredMajorId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;

		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamMinorVersionBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamMinorVersionBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamMinorVersionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamMinorVersionBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamMinorVersionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamMinorVersionBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamMinorVersionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamMySqlMinorVersionTable.readDerivedByIdIdx() ";
		CFBamMinorVersionBuff buff;
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

	public CFBamMinorVersionBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamMinorVersionBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamMinorVersionBuff[] readDerivedByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		final String S_ProcName = "readDerivedByMajorIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamMinorVersionBuff[] buffList = readBuffByMajorIdx( Authorization,
				TenantId,
				MajorId );
		return( buffList );

	}

	public CFBamMinorVersionBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId,
		String Name )
	{
		final String S_ProcName = "CFBamMySqlMinorVersionTable.readDerivedByNameIdx() ";
		CFBamMinorVersionBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByNameIdx( Authorization,
				TenantId,
				MajorId,
				Name );
		return( buff );
	}

	public CFBamMinorVersionBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
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
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByPKey.setLong( argIdx++, TenantId );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
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
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
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

	public CFBamMinorVersionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
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
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_lock_mnverdef( ?, ?, ?, ?, ?" + ", "
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
			stmtLockBuffByPKey.setLong( argIdx++, TenantId );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
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
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
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

	public CFBamMinorVersionBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef_all( ?, ?, ?, ?, ? )";
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
			List<CFBamMinorVersionBuff> buffList = new LinkedList<CFBamMinorVersionBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamMinorVersionBuff[] retBuff = new CFBamMinorVersionBuff[ buffList.size() ];
			Iterator<CFBamMinorVersionBuff> iter = buffList.iterator();
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

	public CFBamMinorVersionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef_by_ididx( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByIdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
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
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
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

	public CFBamMinorVersionBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef_by_tenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByTenantIdx == null ) {
				stmtReadBuffByTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, TenantId );
			try {
				resultSet = stmtReadBuffByTenantIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamMinorVersionBuff> buffList = new LinkedList<CFBamMinorVersionBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamMinorVersionBuff[] retBuff = new CFBamMinorVersionBuff[ buffList.size() ];
			Iterator<CFBamMinorVersionBuff> iter = buffList.iterator();
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

	public CFBamMinorVersionBuff[] readBuffByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		final String S_ProcName = "readBuffByMajorIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef_by_majoridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByMajorIdx == null ) {
				stmtReadBuffByMajorIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByMajorIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByMajorIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByMajorIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByMajorIdx.setLong( argIdx++, MajorId );
			try {
				resultSet = stmtReadBuffByMajorIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			List<CFBamMinorVersionBuff> buffList = new LinkedList<CFBamMinorVersionBuff>();
			while( ( resultSet != null ) && resultSet.next() ) {
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamMinorVersionBuff[] retBuff = new CFBamMinorVersionBuff[ buffList.size() ];
			Iterator<CFBamMinorVersionBuff> iter = buffList.iterator();
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

	public CFBamMinorVersionBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId,
		String Name )
	{
		final String S_ProcName = "readBuffByNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_read_mnverdef_by_nameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByNameIdx == null ) {
				stmtReadBuffByNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByNameIdx.setLong( argIdx++, MajorId );
			stmtReadBuffByNameIdx.setString( argIdx++, Name );
			try {
				resultSet = stmtReadBuffByNameIdx.executeQuery();
			}
			catch( SQLException e ) {
				if( e.getErrorCode() != 1329 ) {
					throw e;
				}
				resultSet = null;
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
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

	public void updateMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		final String S_ProcName = "updateMinorVersion";
		ResultSet resultSet = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			String Description = Buff.getOptionalDescription();
			long MajorId = Buff.getRequiredMajorId();
			String Name = Buff.getRequiredName();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"call " + schema.getLowerDbSchemaName() + ".sp_update_mnverdef( ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, ClassCode );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			if( Description != null ) {
				stmtUpdateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setLong( argIdx++, MajorId );
			stmtUpdateByPKey.setString( argIdx++, Name );
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
				CFBamMinorVersionBuff updatedBuff = unpackMinorVersionResultSetToBuff( resultSet );
				if( ( resultSet != null ) && resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setOptionalDescription( updatedBuff.getOptionalDescription() );
				Buff.setRequiredMajorId( updatedBuff.getRequiredMajorId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
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

	public void deleteMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		final String S_ProcName = "deleteMinorVersion";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_mnverdef( ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
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

	public void deleteMinorVersionByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteMinorVersionByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_mnverdef_by_ididx( ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByIdIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByIdIdx.setLong( argIdx++, argId );
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

	public void deleteMinorVersionByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		deleteMinorVersionByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteMinorVersionByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteMinorVersionByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_mnverdef_by_tenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtDeleteByTenantIdx == null ) {
				stmtDeleteByTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByTenantIdx.executeUpdate();
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

	public void deleteMinorVersionByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		deleteMinorVersionByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteMinorVersionByMajorIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argMajorId )
	{
		final String S_ProcName = "deleteMinorVersionByMajorIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_mnverdef_by_majoridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByMajorIdx == null ) {
				stmtDeleteByMajorIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByMajorIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByMajorIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByMajorIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByMajorIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByMajorIdx.setLong( argIdx++, argMajorId );
			stmtDeleteByMajorIdx.executeUpdate();
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

	public void deleteMinorVersionByMajorIdx( CFBamAuthorization Authorization,
		CFBamMinorVersionByMajorIdxKey argKey )
	{
		deleteMinorVersionByMajorIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredMajorId() );
	}

	public void deleteMinorVersionByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argMajorId,
		String argName )
	{
		final String S_ProcName = "deleteMinorVersionByNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "call " + schema.getLowerDbSchemaName() + ".sp_delete_mnverdef_by_nameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByNameIdx == null ) {
				stmtDeleteByNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByNameIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByNameIdx.setLong( argIdx++, argMajorId );
			stmtDeleteByNameIdx.setString( argIdx++, argName );
			stmtDeleteByNameIdx.executeUpdate();
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

	public void deleteMinorVersionByNameIdx( CFBamAuthorization Authorization,
		CFBamMinorVersionByNameIdxKey argKey )
	{
		deleteMinorVersionByNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredMajorId(),
			argKey.getRequiredName() );
	}

	public CFBamCursor openMinorVersionCursorAll( CFBamAuthorization Authorization ) {
		String sql =
				getSqlSelectMinorVersionBuff()
				+		"WHERE "
				+			"bdom.ClassCode = 'MNVR'"
			+		( ( schema.isSystemUser( Authorization ) ) ? "" : ( " AND bdom.TenantId = " + Authorization.getSecTenantId() ) )
			+	"ORDER BY " 
			+		"mnvr.TenantId ASC" + ", "
			+		"mnvr.Id ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openMinorVersionCursorByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		String sql = getSqlSelectMinorVersionBuff()
			+	"WHERE "
				+		"mnvr.TenantId = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"mnvr.MajorId = " + Long.toString( MajorId ) + " "
				+		"AND "
				+			"bdom.ClassCode = 'MNVR'"
			+	"ORDER BY " 
			+		"mnvr.TenantId ASC" + ", "
			+		"mnvr.Id ASC";
		CFBamCursor cursor = new CFBamMySqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeMinorVersionCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeMinorVersionCursor",
				e );
		}
	}

	public CFBamMinorVersionBuff nextMinorVersionCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextMinorVersionCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamMinorVersionBuff buff = unpackMinorVersionResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamMinorVersionBuff prevMinorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamMinorVersionBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextMinorVersionCursor( Cursor );
		}
		return( buff );
	}

	public CFBamMinorVersionBuff firstMinorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamMinorVersionBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextMinorVersionCursor( Cursor );
		}
		return( buff );
	}

	public CFBamMinorVersionBuff lastMinorVersionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastMinorVersionCursor" );
	}

	public CFBamMinorVersionBuff nthMinorVersionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamMinorVersionBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextMinorVersionCursor( Cursor );
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
		S_sqlSelectMinorVersionDistinctClassCode = null;
		S_sqlSelectMinorVersionBuff = null;
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
		if( stmtDeleteByTenantIdx != null ) {
			try {
				stmtDeleteByTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByTenantIdx = null;
		}
		if( stmtDeleteByMajorIdx != null ) {
			try {
				stmtDeleteByMajorIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByMajorIdx = null;
		}
		if( stmtDeleteByNameIdx != null ) {
			try {
				stmtDeleteByNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByNameIdx = null;
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
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByTenantIdx = null;
		}
		if( stmtReadBuffByMajorIdx != null ) {
			try {
				stmtReadBuffByMajorIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByMajorIdx = null;
		}
		if( stmtReadBuffByNameIdx != null ) {
			try {
				stmtReadBuffByNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByNameIdx = null;
		}
	}
}
