// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for Param.

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
 *	CFBamSybaseParamTable PostgreSQL Jdbc DbIO implementation
 *	for Param.
 */
public class CFBamSybaseParamTable
	implements ICFBamParamTable
{
	private CFBamSybaseSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtMoveUp = null;
	protected PreparedStatement stmtMoveDown = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByValTentIdx = null;
	protected PreparedStatement stmtReadBuffByServerMethodIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByServerTypeIdx = null;
	protected PreparedStatement stmtReadBuffByPrevIdx = null;
	protected PreparedStatement stmtReadBuffByNextIdx = null;
	protected PreparedStatement stmtReadBuffByContPrevIdx = null;
	protected PreparedStatement stmtReadBuffByContNextIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByValTentIdx = null;
	protected PreparedStatement stmtDeleteByServerMethodIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByServerTypeIdx = null;
	protected PreparedStatement stmtDeleteByPrevIdx = null;
	protected PreparedStatement stmtDeleteByNextIdx = null;
	protected PreparedStatement stmtDeleteByContPrevIdx = null;
	protected PreparedStatement stmtDeleteByContNextIdx = null;

	public CFBamSybaseParamTable( CFBamSybaseSchema argSchema ) {
		schema = argSchema;
	}

	public void createParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		final String S_ProcName = "createParam";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long ServerMethodId = Buff.getRequiredServerMethodId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Long TypeTenantId = Buff.getOptionalTypeTenantId();
			Long TypeId = Buff.getOptionalTypeId();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_srvprm ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, "SPRM" );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, ServerMethodId );
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
			stmtCreateByPKey.setString( argIdx++, Name );
			if( ShortDescription != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtCreateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( IsNullable ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( TypeTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, TypeTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( TypeId != null ) {
				stmtCreateByPKey.setLong( argIdx++, TypeId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
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
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamParamBuff createdBuff = unpackParamResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredServerMethodId( createdBuff.getRequiredServerMethodId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalShortDescription( createdBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( createdBuff.getOptionalDescription() );
				Buff.setRequiredIsNullable( createdBuff.getRequiredIsNullable() );
				Buff.setOptionalTypeTenantId( createdBuff.getOptionalTypeTenantId() );
				Buff.setOptionalTypeId( createdBuff.getOptionalTypeId() );
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

	protected static String S_sqlSelectParamDistinctClassCode = null;

	public String getSqlSelectParamDistinctClassCode() {
		if( S_sqlSelectParamDistinctClassCode == null ) {
			S_sqlSelectParamDistinctClassCode =
					"SELECT "
				+		"DISTINCT sprm.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..srvprm AS sprm ";
		}
		return( S_sqlSelectParamDistinctClassCode );
	}

	protected static String S_sqlSelectParamBuff = null;

	public String getSqlSelectParamBuff() {
		if( S_sqlSelectParamBuff == null ) {
			S_sqlSelectParamBuff =
					"SELECT "
				+		"sprm.tenantid, "
				+		"sprm.id, "
				+		"sprm.srvmeth_id, "
				+		"sprm.defschtentid, "
				+		"sprm.defschid, "
				+		"sprm.name, "
				+		"sprm.short_descr, "
				+		"sprm.descr, "
				+		"sprm.isnullable, "
				+		"sprm.tptentid, "
				+		"sprm.tpid, "
				+		"sprm.prevtenantid, "
				+		"sprm.previd, "
				+		"sprm.nexttenantid, "
				+		"sprm.nextid, "
				+		"sprm.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..srvprm AS sprm ";
		}
		return( S_sqlSelectParamBuff );
	}

	protected CFBamParamBuff unpackParamResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackParamResultSetToBuff";
		int idxcol = 1;
		CFBamParamBuff buff = schema.getFactoryParam().newBuff();
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
		buff.setRequiredServerMethodId( resultSet.getLong( idxcol ) );
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
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalShortDescription( null );
			}
			else {
				buff.setOptionalShortDescription( colVal );
			}
		}
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
		buff.setRequiredIsNullable( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalTypeTenantId( null );
			}
			else {
				buff.setOptionalTypeTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalTypeId( null );
			}
			else {
				buff.setOptionalTypeId( colVal );
			}
		}
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

	public CFBamParamBuff readDerived( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamParamBuff lockDerived( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamParamBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamParamBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamParamBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamSybaseParamTable.readDerivedByIdIdx() ";
		CFBamParamBuff buff;
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

	public CFBamParamBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		String Name )
	{
		final String S_ProcName = "CFBamSybaseParamTable.readDerivedByUNameIdx() ";
		CFBamParamBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				ServerMethodId,
				Name );
		return( buff );
	}

	public CFBamParamBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByValTentIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByValTentIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		final String S_ProcName = "readDerivedByServerMethodIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByServerMethodIdx( Authorization,
				TenantId,
				ServerMethodId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		final String S_ProcName = "readDerivedByServerTypeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByServerTypeIdx( Authorization,
				TypeTenantId,
				TypeId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByPrevIdx( Authorization,
				PrevTenantId,
				PrevId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByNextIdx( Authorization,
				NextTenantId,
				NextId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByContPrevIdx( Authorization,
				TenantId,
				ServerMethodId,
				PrevId );
		return( buffList );

	}

	public CFBamParamBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamParamBuff[] buffList = readBuffByContNextIdx( Authorization,
				TenantId,
				ServerMethodId,
				NextId );
		return( buffList );

	}

	public CFBamParamBuff readBuff( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
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
			String sql = "exec sp_read_srvprm ?, ?, ?, ?, ?" + ", "
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
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	public CFBamParamBuff lockBuff( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
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
			String sql = "exec sp_lock_srvprm ?, ?, ?, ?, ?" + ", "
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
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	public CFBamParamBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_all ?, ?, ?, ?, ?";
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
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_ididx ?, ?, ?, ?, ?" + ", "
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
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	public CFBamParamBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_unameidx ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, ServerMethodId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	public CFBamParamBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByValTentIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_valtentidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByValTentIdx == null ) {
				stmtReadBuffByValTentIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, TenantId );
			resultSet = stmtReadBuffByValTentIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		final String S_ProcName = "readBuffByServerMethodIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_servermethodidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByServerMethodIdx == null ) {
				stmtReadBuffByServerMethodIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByServerMethodIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByServerMethodIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByServerMethodIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByServerMethodIdx.setLong( argIdx++, ServerMethodId );
			resultSet = stmtReadBuffByServerMethodIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_defschemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByDefSchemaIdx == null ) {
				stmtReadBuffByDefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
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
			resultSet = stmtReadBuffByDefSchemaIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		final String S_ProcName = "readBuffByServerTypeIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_servertypeidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByServerTypeIdx == null ) {
				stmtReadBuffByServerTypeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByServerTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByServerTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( TypeTenantId != null ) {
				stmtReadBuffByServerTypeIdx.setLong( argIdx++, TypeTenantId.longValue() );
			}
			else {
				stmtReadBuffByServerTypeIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( TypeId != null ) {
				stmtReadBuffByServerTypeIdx.setLong( argIdx++, TypeId.longValue() );
			}
			else {
				stmtReadBuffByServerTypeIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByServerTypeIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByPrevIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_previdx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByPrevIdx == null ) {
				stmtReadBuffByPrevIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
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
			resultSet = stmtReadBuffByPrevIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByNextIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_nextidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByNextIdx == null ) {
				stmtReadBuffByNextIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
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
			resultSet = stmtReadBuffByNextIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByContPrevIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_contprevidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByContPrevIdx == null ) {
				stmtReadBuffByContPrevIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ServerMethodId );
			if( PrevId != null ) {
				stmtReadBuffByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadBuffByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByContPrevIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public CFBamParamBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByContNextIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_srvprm_by_contnextidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtReadBuffByContNextIdx == null ) {
				stmtReadBuffByContNextIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ServerMethodId );
			if( NextId != null ) {
				stmtReadBuffByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadBuffByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByContNextIdx.executeQuery();
			List<CFBamParamBuff> buffList = new LinkedList<CFBamParamBuff>();
			while( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamParamBuff[] retBuff = new CFBamParamBuff[ buffList.size() ];
			Iterator<CFBamParamBuff> iter = buffList.iterator();
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

	public void updateParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		final String S_ProcName = "updateParam";
		ResultSet resultSet = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long ServerMethodId = Buff.getRequiredServerMethodId();
			long Id = Buff.getRequiredId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Long TypeTenantId = Buff.getOptionalTypeTenantId();
			Long TypeId = Buff.getOptionalTypeId();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_srvprm ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "SPRM" );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, ServerMethodId );
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
			stmtUpdateByPKey.setString( argIdx++, Name );
			if( ShortDescription != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtUpdateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( IsNullable ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( TypeTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, TypeTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( TypeId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, TypeId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
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
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamParamBuff updatedBuff = unpackParamResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredServerMethodId( updatedBuff.getRequiredServerMethodId() );
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalShortDescription( updatedBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( updatedBuff.getOptionalDescription() );
				Buff.setRequiredIsNullable( updatedBuff.getRequiredIsNullable() );
				Buff.setOptionalTypeTenantId( updatedBuff.getOptionalTypeTenantId() );
				Buff.setOptionalTypeId( updatedBuff.getOptionalTypeId() );
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

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamParamBuff moveBuffUp( CFBamAuthorization Authorization,
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
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_moveup_srvprm( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ) }";
			if( stmtMoveUp == null ) {
				stmtMoveUp = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveUp.setLong( argIdx++, TenantId );
			stmtMoveUp.setLong( argIdx++, Id );
			stmtMoveUp.setInt( argIdx++, revision );
			resultSet = stmtMoveUp.executeQuery();
			if( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamParamBuff moveBuffDown( CFBamAuthorization Authorization,
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
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_movedown_srvprm( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ) }";
			if( stmtMoveDown == null ) {
				stmtMoveDown = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveDown.setLong( argIdx++, TenantId );
			stmtMoveDown.setLong( argIdx++, Id );
			stmtMoveDown.setInt( argIdx++, revision );
			resultSet = stmtMoveDown.executeQuery();
			if( resultSet.next() ) {
				CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
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

	public void deleteParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		final String S_ProcName = "deleteParam";
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_srvprm ?, ?, ?, ?, ?" + ", "
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

	public void deleteParamByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "deleteParamByIdIdx";
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm ?, ?, ?, ?, ?" + ", "
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

	public void deleteParamByIdIdx( CFBamAuthorization Authorization,
		CFBamParamPKey argKey )
	{
		deleteParamByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteParamByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		String Name )
	{
		final String S_ProcName = "deleteParamByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_unameidx ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByUNameIdx.setLong( argIdx++, ServerMethodId );
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

	public void deleteParamByUNameIdx( CFBamAuthorization Authorization,
		CFBamParamByUNameIdxKey argKey )
	{
		deleteParamByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredServerMethodId(),
			argKey.getRequiredName() );
	}

	public void deleteParamByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "deleteParamByValTentIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_valtentidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByValTentIdx== null ) {
				stmtDeleteByValTentIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByValTentIdx.setLong( argIdx++, TenantId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByValTentIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByValTentIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByValTentIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByValTentIdx.getUpdateCount() ) {
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

	public void deleteParamByValTentIdx( CFBamAuthorization Authorization,
		CFBamParamByValTentIdxKey argKey )
	{
		deleteParamByValTentIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteParamByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		final String S_ProcName = "deleteParamByServerMethodIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_servermethodidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByServerMethodIdx== null ) {
				stmtDeleteByServerMethodIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByServerMethodIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByServerMethodIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByServerMethodIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByServerMethodIdx.setLong( argIdx++, TenantId );
			stmtDeleteByServerMethodIdx.setLong( argIdx++, ServerMethodId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByServerMethodIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByServerMethodIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByServerMethodIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByServerMethodIdx.getUpdateCount() ) {
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

	public void deleteParamByServerMethodIdx( CFBamAuthorization Authorization,
		CFBamParamByServerMethodIdxKey argKey )
	{
		deleteParamByServerMethodIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredServerMethodId() );
	}

	public void deleteParamByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "deleteParamByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_defschemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByDefSchemaIdx== null ) {
				stmtDeleteByDefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByDefSchemaIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByDefSchemaIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByDefSchemaIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByDefSchemaIdx.getUpdateCount() ) {
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

	public void deleteParamByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamParamByDefSchemaIdxKey argKey )
	{
		deleteParamByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteParamByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		final String S_ProcName = "deleteParamByServerTypeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_servertypeidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByServerTypeIdx== null ) {
				stmtDeleteByServerTypeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByServerTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByServerTypeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByServerTypeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( TypeTenantId != null ) {
				stmtDeleteByServerTypeIdx.setLong( argIdx++, TypeTenantId.longValue() );
			}
			else {
				stmtDeleteByServerTypeIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( TypeId != null ) {
				stmtDeleteByServerTypeIdx.setLong( argIdx++, TypeId.longValue() );
			}
			else {
				stmtDeleteByServerTypeIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByServerTypeIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByServerTypeIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByServerTypeIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByServerTypeIdx.getUpdateCount() ) {
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

	public void deleteParamByServerTypeIdx( CFBamAuthorization Authorization,
		CFBamParamByServerTypeIdxKey argKey )
	{
		deleteParamByServerTypeIdx( Authorization,
			argKey.getOptionalTypeTenantId(),
			argKey.getOptionalTypeId() );
	}

	public void deleteParamByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "deleteParamByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_previdx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByPrevIdx== null ) {
				stmtDeleteByPrevIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrevTenantId != null ) {
				stmtDeleteByPrevIdx.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtDeleteByPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByPrevIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByPrevIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByPrevIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByPrevIdx.getUpdateCount() ) {
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

	public void deleteParamByPrevIdx( CFBamAuthorization Authorization,
		CFBamParamByPrevIdxKey argKey )
	{
		deleteParamByPrevIdx( Authorization,
			argKey.getOptionalPrevTenantId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteParamByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "deleteParamByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_nextidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByNextIdx== null ) {
				stmtDeleteByNextIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( NextTenantId != null ) {
				stmtDeleteByNextIdx.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtDeleteByNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByNextIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByNextIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByNextIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByNextIdx.getUpdateCount() ) {
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

	public void deleteParamByNextIdx( CFBamAuthorization Authorization,
		CFBamParamByNextIdxKey argKey )
	{
		deleteParamByNextIdx( Authorization,
			argKey.getOptionalNextTenantId(),
			argKey.getOptionalNextId() );
	}

	public void deleteParamByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		final String S_ProcName = "deleteParamByContPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_contprevidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByContPrevIdx== null ) {
				stmtDeleteByContPrevIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByContPrevIdx.setLong( argIdx++, TenantId );
			stmtDeleteByContPrevIdx.setLong( argIdx++, ServerMethodId );
			if( PrevId != null ) {
				stmtDeleteByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtDeleteByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByContPrevIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByContPrevIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByContPrevIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByContPrevIdx.getUpdateCount() ) {
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

	public void deleteParamByContPrevIdx( CFBamAuthorization Authorization,
		CFBamParamByContPrevIdxKey argKey )
	{
		deleteParamByContPrevIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredServerMethodId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteParamByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		final String S_ProcName = "deleteParamByContNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvprm_by_contnextidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByContNextIdx== null ) {
				stmtDeleteByContNextIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByContNextIdx.setLong( argIdx++, TenantId );
			stmtDeleteByContNextIdx.setLong( argIdx++, ServerMethodId );
			if( NextId != null ) {
				stmtDeleteByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtDeleteByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByContNextIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByContNextIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByContNextIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByContNextIdx.getUpdateCount() ) {
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

	public void deleteParamByContNextIdx( CFBamAuthorization Authorization,
		CFBamParamByContNextIdxKey argKey )
	{
		deleteParamByContNextIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredServerMethodId(),
			argKey.getOptionalNextId() );
	}

	public CFBamCursor openParamCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectParamBuff()
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		"sprm.tenantid = " + Long.toString( TenantId ) + " "
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		"sprm.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"sprm.srvmeth_id = " + Long.toString( ServerMethodId ) + " "
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		( ( DefSchemaTenantId == null ) ? "sprm.defschtentid is null "
							: "sprm.defschtentid = " + DefSchemaTenantId.toString() + " " )
			+	"AND "
				+		( ( DefSchemaId == null ) ? "sprm.defschid is null "
							: "sprm.defschid = " + DefSchemaId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		( ( TypeTenantId == null ) ? "sprm.tptentid is null "
							: "sprm.tptentid = " + TypeTenantId.toString() + " " )
			+	"AND "
				+		( ( TypeId == null ) ? "sprm.tpid is null "
							: "sprm.tpid = " + TypeId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		( ( PrevTenantId == null ) ? "sprm.prevtenantid is null "
							: "sprm.prevtenantid = " + PrevTenantId.toString() + " " )
			+	"AND "
				+		( ( PrevId == null ) ? "sprm.previd is null "
							: "sprm.previd = " + PrevId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		( ( NextTenantId == null ) ? "sprm.nexttenantid is null "
							: "sprm.nexttenantid = " + NextTenantId.toString() + " " )
			+	"AND "
				+		( ( NextId == null ) ? "sprm.nextid is null "
							: "sprm.nextid = " + NextId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		"sprm.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"sprm.srvmeth_id = " + Long.toString( ServerMethodId ) + " "
			+	"AND "
				+		( ( PrevId == null ) ? "sprm.previd is null "
							: "sprm.previd = " + PrevId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openParamCursorByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		String sql = getSqlSelectParamBuff()
			+	"WHERE "
				+		"sprm.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"sprm.srvmeth_id = " + Long.toString( ServerMethodId ) + " "
			+	"AND "
				+		( ( NextId == null ) ? "sprm.nextid is null "
							: "sprm.nextid = " + NextId.toString() + " " )
			+	"ORDER BY " 
			+		"sprm.TenantId ASC" + ", "
			+		"sprm.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeParamCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeParamCursor",
				e );
		}
	}

	public CFBamParamBuff nextParamCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextParamCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamParamBuff buff = unpackParamResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamParamBuff prevParamCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamParamBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextParamCursor( Cursor );
		}
		return( buff );
	}

	public CFBamParamBuff firstParamCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamParamBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextParamCursor( Cursor );
		}
		return( buff );
	}

	public CFBamParamBuff lastParamCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastParamCursor" );
	}

	public CFBamParamBuff nthParamCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamParamBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextParamCursor( Cursor );
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
		S_sqlSelectParamDistinctClassCode = null;
		S_sqlSelectParamBuff = null;

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
		if( stmtMoveUp != null ) {
			try {
				stmtMoveUp.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtMoveUp = null;
		}
		if( stmtMoveDown != null ) {
			try {
				stmtMoveDown.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtMoveDown = null;
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
		if( stmtReadBuffByValTentIdx != null ) {
			try {
				stmtReadBuffByValTentIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByValTentIdx = null;
			}
		}
		if( stmtReadBuffByServerMethodIdx != null ) {
			try {
				stmtReadBuffByServerMethodIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByServerMethodIdx = null;
			}
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByDefSchemaIdx = null;
			}
		}
		if( stmtReadBuffByServerTypeIdx != null ) {
			try {
				stmtReadBuffByServerTypeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByServerTypeIdx = null;
			}
		}
		if( stmtReadBuffByPrevIdx != null ) {
			try {
				stmtReadBuffByPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByPrevIdx = null;
			}
		}
		if( stmtReadBuffByNextIdx != null ) {
			try {
				stmtReadBuffByNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByNextIdx = null;
			}
		}
		if( stmtReadBuffByContPrevIdx != null ) {
			try {
				stmtReadBuffByContPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByContPrevIdx = null;
			}
		}
		if( stmtReadBuffByContNextIdx != null ) {
			try {
				stmtReadBuffByContNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByContNextIdx = null;
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
		if( stmtDeleteByValTentIdx != null ) {
			try {
				stmtDeleteByValTentIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByValTentIdx = null;
			}
		}
		if( stmtDeleteByServerMethodIdx != null ) {
			try {
				stmtDeleteByServerMethodIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByServerMethodIdx = null;
			}
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByDefSchemaIdx = null;
			}
		}
		if( stmtDeleteByServerTypeIdx != null ) {
			try {
				stmtDeleteByServerTypeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByServerTypeIdx = null;
			}
		}
		if( stmtDeleteByPrevIdx != null ) {
			try {
				stmtDeleteByPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByPrevIdx = null;
			}
		}
		if( stmtDeleteByNextIdx != null ) {
			try {
				stmtDeleteByNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByNextIdx = null;
			}
		}
		if( stmtDeleteByContPrevIdx != null ) {
			try {
				stmtDeleteByContPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByContPrevIdx = null;
			}
		}
		if( stmtDeleteByContNextIdx != null ) {
			try {
				stmtDeleteByContNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByContNextIdx = null;
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
		if( stmtReadBuffByValTentIdx != null ) {
			try {
				stmtReadBuffByValTentIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByValTentIdx = null;
			}
		}
		if( stmtReadBuffByServerMethodIdx != null ) {
			try {
				stmtReadBuffByServerMethodIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByServerMethodIdx = null;
			}
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByDefSchemaIdx = null;
			}
		}
		if( stmtReadBuffByServerTypeIdx != null ) {
			try {
				stmtReadBuffByServerTypeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByServerTypeIdx = null;
			}
		}
		if( stmtReadBuffByPrevIdx != null ) {
			try {
				stmtReadBuffByPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByPrevIdx = null;
			}
		}
		if( stmtReadBuffByNextIdx != null ) {
			try {
				stmtReadBuffByNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByNextIdx = null;
			}
		}
		if( stmtReadBuffByContPrevIdx != null ) {
			try {
				stmtReadBuffByContPrevIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByContPrevIdx = null;
			}
		}
		if( stmtReadBuffByContNextIdx != null ) {
			try {
				stmtReadBuffByContNextIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByContNextIdx = null;
			}
		}
	}
}
