// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for SchemaRef.

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
 *	CFBamSybaseSchemaRefTable PostgreSQL Jdbc DbIO implementation
 *	for SchemaRef.
 */
public class CFBamSybaseSchemaRefTable
	implements ICFBamSchemaRefTable
{
	private CFBamSybaseSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadDerivedClassCode = null;
	protected PreparedStatement stmtLockDerivedClassCode = null;
	protected PreparedStatement stmtReadAllClassCode = null;
	protected PreparedStatement stmtReadClassCodeByIdIdx = null;
	protected PreparedStatement stmtReadClassCodeByTenantIdx = null;
	protected PreparedStatement stmtReadClassCodeBySchemaIdx = null;
	protected PreparedStatement stmtReadClassCodeByUNameIdx = null;
	protected PreparedStatement stmtReadClassCodeByRefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtReadBuffBySchemaIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByRefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtDeleteBySchemaIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByRefSchemaIdx = null;

	public CFBamSybaseSchemaRefTable( CFBamSybaseSchema argSchema ) {
		schema = argSchema;
	}

	public void createSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		final String S_ProcName = "createSchemaRef";
		ResultSet resultSet = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long SchemaId = Buff.getRequiredSchemaId();
			String Name = Buff.getRequiredName();
			String RefModelName = Buff.getRequiredRefModelName();
			String IncludeRoot = Buff.getRequiredIncludeRoot();
			Long RefSchemaTenantId = Buff.getOptionalRefSchemaTenantId();
			Long RefSchemaId = Buff.getOptionalRefSchemaId();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_schema_ref ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, ClassCode );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, SchemaId );
			stmtCreateByPKey.setString( argIdx++, Name );
			stmtCreateByPKey.setString( argIdx++, RefModelName );
			stmtCreateByPKey.setString( argIdx++, IncludeRoot );
			if( RefSchemaTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, RefSchemaTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RefSchemaId != null ) {
				stmtCreateByPKey.setLong( argIdx++, RefSchemaId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff createdBuff = unpackSchemaRefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				Buff.setRequiredSchemaId( createdBuff.getRequiredSchemaId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setRequiredRefModelName( createdBuff.getRequiredRefModelName() );
				Buff.setRequiredIncludeRoot( createdBuff.getRequiredIncludeRoot() );
				Buff.setOptionalRefSchemaTenantId( createdBuff.getOptionalRefSchemaTenantId() );
				Buff.setOptionalRefSchemaId( createdBuff.getOptionalRefSchemaId() );
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

	protected static String S_sqlSelectSchemaRefDistinctClassCode = null;

	public String getSqlSelectSchemaRefDistinctClassCode() {
		if( S_sqlSelectSchemaRefDistinctClassCode == null ) {
			S_sqlSelectSchemaRefDistinctClassCode =
					"SELECT "
				+		"DISTINCT scop.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schema_ref scrf ON "
				+		"scrf.tenantid = scop.tenantid "
				+		"AND scrf.id = scop.id ";
		}
		return( S_sqlSelectSchemaRefDistinctClassCode );
	}

	protected static String S_sqlSelectSchemaRefBuff = null;

	public String getSqlSelectSchemaRefBuff() {
		if( S_sqlSelectSchemaRefBuff == null ) {
			S_sqlSelectSchemaRefBuff =
					"SELECT "
				+		"scop.ClassCode, "
				+		"scop.tenantid, "
				+		"scop.id, "
				+		"scrf.schemaid, "
				+		"scrf.name, "
				+		"scrf.refmodelname, "
				+		"scrf.includeroot, "
				+		"scrf.refschtentid, "
				+		"scrf.refschid, "
				+		"scop.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schema_ref scrf ON "
				+		"scrf.tenantid = scop.tenantid "
				+		"AND scrf.id = scop.id ";
		}
		return( S_sqlSelectSchemaRefBuff );
	}

	protected CFBamSchemaRefBuff unpackSchemaRefResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSchemaRefResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamSchemaRefBuff buff;
		if( classCode.equals( "SCRF" ) ) {
			buff = schema.getFactorySchemaRef().newBuff();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Unrecognized class code \"" + classCode + "\"" );
		}
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
		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredSchemaId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredRefModelName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredIncludeRoot( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalRefSchemaTenantId( null );
			}
			else {
				buff.setOptionalRefSchemaTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalRefSchemaId( null );
			}
			else {
				buff.setOptionalRefSchemaId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSchemaRefBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaRefBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSchemaRefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaRefBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSchemaRefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSchemaRefBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSchemaRefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamSybaseSchemaRefTable.readDerivedByIdIdx() ";
		CFBamSchemaRefBuff buff;
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

	public CFBamSchemaRefBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaRefBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamSchemaRefBuff[] readDerivedBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		final String S_ProcName = "readDerivedBySchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaRefBuff[] buffList = readBuffBySchemaIdx( Authorization,
				TenantId,
				SchemaId );
		return( buffList );

	}

	public CFBamSchemaRefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name )
	{
		final String S_ProcName = "CFBamSybaseSchemaRefTable.readDerivedByUNameIdx() ";
		CFBamSchemaRefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				SchemaId,
				Name );
		return( buff );
	}

	public CFBamSchemaRefBuff[] readDerivedByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		final String S_ProcName = "readDerivedByRefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaRefBuff[] buffList = readBuffByRefSchemaIdx( Authorization,
				RefSchemaTenantId,
				RefSchemaId );
		return( buffList );

	}

	public CFBamSchemaRefBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
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
			String sql = "exec sp_read_schema_ref ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtReadBuffByPKey.setLong( argIdx++, TenantId );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
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

	public CFBamSchemaRefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
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
			String sql = "exec sp_lock_schema_ref ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtLockBuffByPKey.setLong( argIdx++, TenantId );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
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

	public CFBamSchemaRefBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_all ?, ?, ?, ?, ?";
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
			List<CFBamSchemaRefBuff> buffList = new LinkedList<CFBamSchemaRefBuff>();
			while( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSchemaRefBuff[] retBuff = new CFBamSchemaRefBuff[ buffList.size() ];
			Iterator<CFBamSchemaRefBuff> iter = buffList.iterator();
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

	public CFBamSchemaRefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_by_ididx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
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
			stmtReadBuffByIdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
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

	public CFBamSchemaRefBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_by_tenantidx ?, ?, ?, ?, ?" + ", "
				+		"?";
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
			resultSet = stmtReadBuffByTenantIdx.executeQuery();
			List<CFBamSchemaRefBuff> buffList = new LinkedList<CFBamSchemaRefBuff>();
			while( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSchemaRefBuff[] retBuff = new CFBamSchemaRefBuff[ buffList.size() ];
			Iterator<CFBamSchemaRefBuff> iter = buffList.iterator();
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

	public CFBamSchemaRefBuff[] readBuffBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		final String S_ProcName = "readBuffBySchemaIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_by_schemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffBySchemaIdx == null ) {
				stmtReadBuffBySchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySchemaIdx.setLong( argIdx++, TenantId );
			stmtReadBuffBySchemaIdx.setLong( argIdx++, SchemaId );
			resultSet = stmtReadBuffBySchemaIdx.executeQuery();
			List<CFBamSchemaRefBuff> buffList = new LinkedList<CFBamSchemaRefBuff>();
			while( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSchemaRefBuff[] retBuff = new CFBamSchemaRefBuff[ buffList.size() ];
			Iterator<CFBamSchemaRefBuff> iter = buffList.iterator();
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

	public CFBamSchemaRefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_by_unameidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByUNameIdx == null ) {
				stmtReadBuffByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, SchemaId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
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

	public CFBamSchemaRefBuff[] readBuffByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		final String S_ProcName = "readBuffByRefSchemaIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_schema_ref_by_refschemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByRefSchemaIdx == null ) {
				stmtReadBuffByRefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByRefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( RefSchemaTenantId != null ) {
				stmtReadBuffByRefSchemaIdx.setLong( argIdx++, RefSchemaTenantId.longValue() );
			}
			else {
				stmtReadBuffByRefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RefSchemaId != null ) {
				stmtReadBuffByRefSchemaIdx.setLong( argIdx++, RefSchemaId.longValue() );
			}
			else {
				stmtReadBuffByRefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByRefSchemaIdx.executeQuery();
			List<CFBamSchemaRefBuff> buffList = new LinkedList<CFBamSchemaRefBuff>();
			while( resultSet.next() ) {
				CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamSchemaRefBuff[] retBuff = new CFBamSchemaRefBuff[ buffList.size() ];
			Iterator<CFBamSchemaRefBuff> iter = buffList.iterator();
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

	public void updateSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		final String S_ProcName = "updateSchemaRef";
		ResultSet resultSet = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long SchemaId = Buff.getRequiredSchemaId();
			String Name = Buff.getRequiredName();
			String RefModelName = Buff.getRequiredRefModelName();
			String IncludeRoot = Buff.getRequiredIncludeRoot();
			Long RefSchemaTenantId = Buff.getOptionalRefSchemaTenantId();
			Long RefSchemaId = Buff.getOptionalRefSchemaId();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_schema_ref ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, ClassCode );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setLong( argIdx++, SchemaId );
			stmtUpdateByPKey.setString( argIdx++, Name );
			stmtUpdateByPKey.setString( argIdx++, RefModelName );
			stmtUpdateByPKey.setString( argIdx++, IncludeRoot );
			if( RefSchemaTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, RefSchemaTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RefSchemaId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, RefSchemaId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamSchemaRefBuff updatedBuff = unpackSchemaRefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredSchemaId( updatedBuff.getRequiredSchemaId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setRequiredRefModelName( updatedBuff.getRequiredRefModelName() );
				Buff.setRequiredIncludeRoot( updatedBuff.getRequiredIncludeRoot() );
				Buff.setOptionalRefSchemaTenantId( updatedBuff.getOptionalRefSchemaTenantId() );
				Buff.setOptionalRefSchemaId( updatedBuff.getOptionalRefSchemaId() );
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

	public void deleteSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		final String S_ProcName = "deleteSchemaRef";
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_schema_ref ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
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

	public void deleteSchemaRefByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "deleteSchemaRefByIdIdx";
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schema_ref ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
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

	public void deleteSchemaRefByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteSchemaRefByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteSchemaRefByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "deleteSchemaRefByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schema_ref_by_tenantidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByTenantIdx== null ) {
				stmtDeleteByTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, TenantId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByTenantIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByTenantIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByTenantIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByTenantIdx.getUpdateCount() ) {
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

	public void deleteSchemaRefByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteSchemaRefByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteSchemaRefBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		final String S_ProcName = "deleteSchemaRefBySchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schema_ref_by_schemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteBySchemaIdx== null ) {
				stmtDeleteBySchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteBySchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteBySchemaIdx.setLong( argIdx++, TenantId );
			stmtDeleteBySchemaIdx.setLong( argIdx++, SchemaId );
			Object stuff = null;
			boolean moreResults = stmtDeleteBySchemaIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteBySchemaIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteBySchemaIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteBySchemaIdx.getUpdateCount() ) {
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

	public void deleteSchemaRefBySchemaIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefBySchemaIdxKey argKey )
	{
		deleteSchemaRefBySchemaIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaId() );
	}

	public void deleteSchemaRefByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name )
	{
		final String S_ProcName = "deleteSchemaRefByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schema_ref_by_unameidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByUNameIdx== null ) {
				stmtDeleteByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, TenantId );
			stmtDeleteByUNameIdx.setLong( argIdx++, SchemaId );
			stmtDeleteByUNameIdx.setString( argIdx++, Name );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUNameIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUNameIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUNameIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUNameIdx.getUpdateCount() ) {
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

	public void deleteSchemaRefByUNameIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefByUNameIdxKey argKey )
	{
		deleteSchemaRefByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaId(),
			argKey.getRequiredName() );
	}

	public void deleteSchemaRefByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		final String S_ProcName = "deleteSchemaRefByRefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schema_ref_by_refschemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByRefSchemaIdx== null ) {
				stmtDeleteByRefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByRefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByRefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByRefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( RefSchemaTenantId != null ) {
				stmtDeleteByRefSchemaIdx.setLong( argIdx++, RefSchemaTenantId.longValue() );
			}
			else {
				stmtDeleteByRefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RefSchemaId != null ) {
				stmtDeleteByRefSchemaIdx.setLong( argIdx++, RefSchemaId.longValue() );
			}
			else {
				stmtDeleteByRefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByRefSchemaIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByRefSchemaIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByRefSchemaIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByRefSchemaIdx.getUpdateCount() ) {
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

	public void deleteSchemaRefByRefSchemaIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefByRefSchemaIdxKey argKey )
	{
		deleteSchemaRefByRefSchemaIdx( Authorization,
			argKey.getOptionalRefSchemaTenantId(),
			argKey.getOptionalRefSchemaId() );
	}

	public CFBamCursor openSchemaRefCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectSchemaRefBuff()
			+	"ORDER BY " 
			+		"scrf.TenantId ASC" + ", "
			+		"scrf.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaRefCursorBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		String sql = getSqlSelectSchemaRefBuff()
			+	"WHERE "
				+		"scrf.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"scrf.schemaid = " + Long.toString( SchemaId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'SCRF'"
			+	"ORDER BY " 
			+		"scrf.TenantId ASC" + ", "
			+		"scrf.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaRefCursorByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		String sql = getSqlSelectSchemaRefBuff()
			+	"WHERE "
				+		( ( RefSchemaTenantId == null ) ? "scrf.refschtentid is null "
							: "scrf.refschtentid = " + RefSchemaTenantId.toString() + " " )
			+	"AND "
				+		( ( RefSchemaId == null ) ? "scrf.refschid is null "
							: "scrf.refschid = " + RefSchemaId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCRF'"
			+	"ORDER BY " 
			+		"scrf.TenantId ASC" + ", "
			+		"scrf.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSchemaRefCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSchemaRefCursor",
				e );
		}
	}

	public CFBamSchemaRefBuff nextSchemaRefCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSchemaRefCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSchemaRefBuff buff = unpackSchemaRefResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSchemaRefBuff prevSchemaRefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSchemaRefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaRefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSchemaRefBuff firstSchemaRefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSchemaRefBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaRefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSchemaRefBuff lastSchemaRefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSchemaRefCursor" );
	}

	public CFBamSchemaRefBuff nthSchemaRefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSchemaRefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaRefCursor( Cursor );
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
		S_sqlSelectSchemaRefDistinctClassCode = null;
		S_sqlSelectSchemaRefBuff = null;

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
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByTenantIdx = null;
			}
		}
		if( stmtReadBuffBySchemaIdx != null ) {
			try {
				stmtReadBuffBySchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffBySchemaIdx = null;
			}
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUNameIdx = null;
			}
		}
		if( stmtReadBuffByRefSchemaIdx != null ) {
			try {
				stmtReadBuffByRefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByRefSchemaIdx = null;
			}
		}
		if( stmtDeleteByTenantIdx != null ) {
			try {
				stmtDeleteByTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByTenantIdx = null;
			}
		}
		if( stmtDeleteBySchemaIdx != null ) {
			try {
				stmtDeleteBySchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteBySchemaIdx = null;
			}
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUNameIdx = null;
			}
		}
		if( stmtDeleteByRefSchemaIdx != null ) {
			try {
				stmtDeleteByRefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByRefSchemaIdx = null;
			}
		}
		if( stmtReadDerivedClassCode != null ) {
			try {
				stmtReadDerivedClassCode.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadDerivedClassCode = null;
			}
		}
		if( stmtLockDerivedClassCode != null ) {
			try {
				stmtLockDerivedClassCode.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtLockDerivedClassCode = null;
			}
		}
		if( stmtReadAllClassCode != null ) {
			try {
				stmtReadAllClassCode.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadAllClassCode = null;
			}
		}
		if( stmtReadClassCodeByTenantIdx != null ) {
			try {
				stmtReadClassCodeByTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadClassCodeByTenantIdx = null;
			}
		}
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByTenantIdx = null;
			}
		}
		if( stmtReadClassCodeBySchemaIdx != null ) {
			try {
				stmtReadClassCodeBySchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadClassCodeBySchemaIdx = null;
			}
		}
		if( stmtReadBuffBySchemaIdx != null ) {
			try {
				stmtReadBuffBySchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffBySchemaIdx = null;
			}
		}
		if( stmtReadClassCodeByUNameIdx != null ) {
			try {
				stmtReadClassCodeByUNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadClassCodeByUNameIdx = null;
			}
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUNameIdx = null;
			}
		}
		if( stmtReadClassCodeByRefSchemaIdx != null ) {
			try {
				stmtReadClassCodeByRefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadClassCodeByRefSchemaIdx = null;
			}
		}
		if( stmtReadBuffByRefSchemaIdx != null ) {
			try {
				stmtReadBuffByRefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByRefSchemaIdx = null;
			}
		}
	}
}
