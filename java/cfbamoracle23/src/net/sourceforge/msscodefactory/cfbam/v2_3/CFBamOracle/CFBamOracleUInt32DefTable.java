// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for UInt32Def.

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
 *	CFBamOracleUInt32DefTable Oracle 11gR2 Jdbc DbIO implementation
 *	for UInt32Def.
 */
public class CFBamOracleUInt32DefTable
	implements ICFBamUInt32DefTable
{
	private CFBamOracleSchema schema;
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
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadClassCodeByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadClassCodeByValTentIdx = null;
	protected PreparedStatement stmtReadBuffByValTentIdx = null;
	protected PreparedStatement stmtReadClassCodeByScopeIdx = null;
	protected PreparedStatement stmtReadBuffByScopeIdx = null;
	protected PreparedStatement stmtReadClassCodeByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadClassCodeByDataScopeIdx = null;
	protected PreparedStatement stmtReadBuffByDataScopeIdx = null;
	protected PreparedStatement stmtReadClassCodeByVAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByVAccSecIdx = null;
	protected PreparedStatement stmtReadClassCodeByVAccFreqIdx = null;
	protected PreparedStatement stmtReadBuffByVAccFreqIdx = null;
	protected PreparedStatement stmtReadClassCodeByEAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByEAccSecIdx = null;
	protected PreparedStatement stmtReadClassCodeByEAccFreqIdx = null;
	protected PreparedStatement stmtReadBuffByEAccFreqIdx = null;
	protected PreparedStatement stmtReadClassCodeByPrevIdx = null;
	protected PreparedStatement stmtReadBuffByPrevIdx = null;
	protected PreparedStatement stmtReadClassCodeByNextIdx = null;
	protected PreparedStatement stmtReadBuffByNextIdx = null;
	protected PreparedStatement stmtReadClassCodeByContPrevIdx = null;
	protected PreparedStatement stmtReadBuffByContPrevIdx = null;
	protected PreparedStatement stmtReadClassCodeByContNextIdx = null;
	protected PreparedStatement stmtReadBuffByContNextIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByValTentIdx = null;
	protected PreparedStatement stmtDeleteByScopeIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByDataScopeIdx = null;
	protected PreparedStatement stmtDeleteByVAccSecIdx = null;
	protected PreparedStatement stmtDeleteByVAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByEAccSecIdx = null;
	protected PreparedStatement stmtDeleteByEAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByPrevIdx = null;
	protected PreparedStatement stmtDeleteByNextIdx = null;
	protected PreparedStatement stmtDeleteByContPrevIdx = null;
	protected PreparedStatement stmtDeleteByContNextIdx = null;

	public CFBamOracleUInt32DefTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		final String S_ProcName = "createUInt32Def";
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long ScopeId = Buff.getRequiredScopeId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Boolean GenerateId = Buff.getOptionalGenerateId();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			boolean DefaultVisibility = Buff.getRequiredDefaultVisibility();
			String DbName = Buff.getOptionalDbName();
			Long InitValue = Buff.getOptionalInitValue();
			Long DefaultValue = Buff.getOptionalDefaultValue();
			Long MinValue = Buff.getOptionalMinValue();
			Long MaxValue = Buff.getOptionalMaxValue();
			Long NullValue = Buff.getOptionalNullValue();
			Long UnknownValue = Buff.getOptionalUnknownValue();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_u32def( ?, ?, ?, ?, ?, ?, ?" + ", "
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
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtCreateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, ClassCode );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, ScopeId );
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
			if( ShortName != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtCreateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
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
			if( GenerateId != null ) {
				if( GenerateId.booleanValue() ) {
					stmtCreateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtCreateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DataScopeId != null ) {
				stmtCreateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessSecurityId != null ) {
				stmtCreateByPKey.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessSecurityId != null ) {
				stmtCreateByPKey.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessFrequencyId != null ) {
				stmtCreateByPKey.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessFrequencyId != null ) {
				stmtCreateByPKey.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
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
			if( DefaultVisibility ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( DbName != null ) {
				stmtCreateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( InitValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, InitValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefaultValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefaultValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( MinValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, MinValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( MaxValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, MaxValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NullValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, NullValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( UnknownValue != null ) {
				stmtCreateByPKey.setLong( argIdx++, UnknownValue.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"crt_u32def() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamUInt32DefBuff createdBuff = unpackUInt32DefResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredScopeId( createdBuff.getRequiredScopeId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalShortName( createdBuff.getOptionalShortName() );
				Buff.setOptionalLabel( createdBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( createdBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( createdBuff.getOptionalDescription() );
				Buff.setRequiredIsNullable( createdBuff.getRequiredIsNullable() );
				Buff.setOptionalGenerateId( createdBuff.getOptionalGenerateId() );
				Buff.setOptionalDataScopeId( createdBuff.getOptionalDataScopeId() );
				Buff.setOptionalViewAccessSecurityId( createdBuff.getOptionalViewAccessSecurityId() );
				Buff.setOptionalEditAccessSecurityId( createdBuff.getOptionalEditAccessSecurityId() );
				Buff.setOptionalViewAccessFrequencyId( createdBuff.getOptionalViewAccessFrequencyId() );
				Buff.setOptionalEditAccessFrequencyId( createdBuff.getOptionalEditAccessFrequencyId() );
				Buff.setOptionalPrevTenantId( createdBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( createdBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( createdBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( createdBuff.getOptionalNextId() );
				Buff.setRequiredDefaultVisibility( createdBuff.getRequiredDefaultVisibility() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				Buff.setOptionalDbName( createdBuff.getOptionalDbName() );
				Buff.setOptionalInitValue( createdBuff.getOptionalInitValue() );
				Buff.setOptionalDefaultValue( createdBuff.getOptionalDefaultValue() );
				Buff.setOptionalMinValue( createdBuff.getOptionalMinValue() );
				Buff.setOptionalMaxValue( createdBuff.getOptionalMaxValue() );
				Buff.setOptionalNullValue( createdBuff.getOptionalNullValue() );
				Buff.setOptionalUnknownValue( createdBuff.getOptionalUnknownValue() );
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
					"crt_u32def() did not return a valid result set" );
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

	protected static String S_sqlSelectUInt32DefDistinctClassCode = null;

	public String getSqlSelectUInt32DefDistinctClassCode() {
		if( S_sqlSelectUInt32DefDistinctClassCode == null ) {
			S_sqlSelectUInt32DefDistinctClassCode =
					"SELECT "
				+		"DISTINCT valu.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".valdef valu "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".atomdef atom ON "
				+		"atom.TenantId = valu.TenantId "
				+		"AND atom.Id = valu.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".u32def u32d ON "
				+		"u32d.TenantId = valu.TenantId "
				+		"AND u32d.Id = valu.Id ";
		}
		return( S_sqlSelectUInt32DefDistinctClassCode );
	}

	protected static String S_sqlSelectUInt32DefBuff = null;

	public String getSqlSelectUInt32DefBuff() {
		if( S_sqlSelectUInt32DefBuff == null ) {
			S_sqlSelectUInt32DefBuff =
					"SELECT "
				+		"valu.ClassCode, "
				+		"valu.TenantId, "
				+		"valu.Id, "
				+		"valu.ScopeId, "
				+		"valu.defschtentid, "
				+		"valu.defschid, "
				+		"valu.Name, "
				+		"valu.short_name, "
				+		"valu.Label, "
				+		"valu.short_descr, "
				+		"valu.descr, "
				+		"valu.IsNullable, "
				+		"valu.GenerateId, "
				+		"valu.DataScopeId, "
				+		"valu.VASecId, "
				+		"valu.EASecId, "
				+		"valu.VAFId, "
				+		"valu.EAFId, "
				+		"valu.PrevTenantId, "
				+		"valu.PrevId, "
				+		"valu.NextTenantId, "
				+		"valu.NextId, "
				+		"valu.dflt_vis, "
				+		"atom.DbName, "
				+		"u32d.InitVal, "
				+		"u32d.DefVal, "
				+		"u32d.MinVal, "
				+		"u32d.MaxVal, "
				+		"u32d.NullValue, "
				+		"u32d.UnknownVal, "
				+		"valu.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".valdef valu "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".atomdef atom ON "
				+		"atom.TenantId = valu.TenantId "
				+		"AND atom.Id = valu.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".u32def u32d ON "
				+		"u32d.TenantId = valu.TenantId "
				+		"AND u32d.Id = valu.Id ";
		}
		return( S_sqlSelectUInt32DefBuff );
	}

	protected CFBamUInt32DefBuff unpackUInt32DefResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackUInt32DefResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamUInt32DefBuff buff;
		if( classCode.equals( "U32D" ) ) {
			buff = schema.getFactoryUInt32Def().newBuff();
		}
		else if( classCode.equals( "U32C" ) ) {
			buff = schema.getFactoryUInt32Col().newBuff();
		}
		else if( classCode.equals( "U32T" ) ) {
			buff = schema.getFactoryUInt32Type().newBuff();
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
		buff.setRequiredScopeId( resultSet.getLong( idxcol ) );
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
				buff.setOptionalShortName( null );
			}
			else {
				buff.setOptionalShortName( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLabel( null );
			}
			else {
				buff.setOptionalLabel( colVal );
			}
		}
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
			boolean colVal = ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false );
			if( resultSet.wasNull() ) {
				buff.setOptionalGenerateId( null );
			}
			else {
				buff.setOptionalGenerateId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDataScopeId( null );
			}
			else {
				buff.setOptionalDataScopeId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalViewAccessSecurityId( null );
			}
			else {
				buff.setOptionalViewAccessSecurityId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalEditAccessSecurityId( null );
			}
			else {
				buff.setOptionalEditAccessSecurityId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalViewAccessFrequencyId( null );
			}
			else {
				buff.setOptionalViewAccessFrequencyId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalEditAccessFrequencyId( null );
			}
			else {
				buff.setOptionalEditAccessFrequencyId( colVal );
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
		buff.setRequiredDefaultVisibility( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDbName( null );
			}
			else {
				buff.setOptionalDbName( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalInitValue( null );
			}
			else {
				buff.setOptionalInitValue( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultValue( null );
			}
			else {
				buff.setOptionalDefaultValue( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalMinValue( null );
			}
			else {
				buff.setOptionalMinValue( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalMaxValue( null );
			}
			else {
				buff.setOptionalMaxValue( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNullValue( null );
			}
			else {
				buff.setOptionalNullValue( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalUnknownValue( null );
			}
			else {
				buff.setOptionalUnknownValue( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamUInt32DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamUInt32DefBuff buff;

		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtReadDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defcc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadDerivedClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadDerivedClassCode.setLong( argIdx++, TenantId );
			stmtReadDerivedClassCode.setLong( argIdx++, Id );
			stmtReadDerivedClassCode.execute();
			resultSet = (ResultSet)stmtReadDerivedClassCode.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"rd_u32defcc() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtReadDerivedClassCode != null ) {
				try {
					stmtReadDerivedClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtReadDerivedClassCode = null;
			}
		}
		if( classCode.equals( "U32D" ) ) {
			buff = readBuff( Authorization, PKey );
		}
		else if( classCode.equals( "U32C" ) ) {
			buff = schema.getTableUInt32Col().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "U32T" ) ) {
			buff = schema.getTableUInt32Type().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamUInt32DefBuff buff;
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtLockDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtLockDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defcc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockDerivedClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockDerivedClassCode.setLong( argIdx++, TenantId );
			stmtLockDerivedClassCode.setLong( argIdx++, Id );
			stmtLockDerivedClassCode.execute();
			resultSet = (ResultSet)stmtLockDerivedClassCode.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"rd_u32defcc() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtLockDerivedClassCode != null ) {
				try {
					stmtLockDerivedClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtLockDerivedClassCode = null;
			}
		}
		if( classCode.equals( "U32D" ) ) {
			buff = lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "U32C" ) ) {
			buff = schema.getTableUInt32Col().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "U32T" ) ) {
			buff = schema.getTableUInt32Type().lockBuff( Authorization, PKey );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamUInt32DefBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ArrayList<String> classCodeList = new ArrayList<String>();
		ResultSet resultSet = null;
		CallableStatement stmtReadAllClassCode = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadAllClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccall( ?, ?, ?, ?, ?, ? ); end;" );
			int argIdx = 1;
			stmtReadAllClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadAllClassCode.execute();
			resultSet = (ResultSet)stmtReadAllClassCode.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
				}
				finally {
					if( stmtReadAllClassCode != null ) {
						try {
							stmtReadAllClassCode.close();
						}
						catch( SQLException e ) {
						}
						stmtReadAllClassCode = null;
					}
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
			if( stmtReadAllClassCode != null ) {
				try {
					stmtReadAllClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtReadAllClassCode = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		for( int classCodeIdx = 0; classCodeIdx < classCodeList.size(); classCodeIdx ++ ) {
			CFBamUInt32DefBuff[] subList;
			classCode = classCodeList.get( classCodeIdx );
			if( classCode.equals( "U32D" ) ) {
				subList = readAllBuff( Authorization );
			}
			else if( classCode.equals( "U32C" ) ) {
				subList = schema.getTableUInt32Col().readAllBuff( Authorization );
			}
			else if( classCode.equals( "U32T" ) ) {
				subList = schema.getTableUInt32Type().readAllBuff( Authorization );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
			for( int idxSubList = 0; idxSubList < subList.length; idxSubList ++ ) {
				resultList.add( subList[ idxSubList ] );
			}
		}
		int idx = 0;
		buffArray = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			buffArray[idx++] = iter.next();
		}
		return( buffArray );
	}

	public CFBamUInt32DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleUInt32DefTable.readDerivedByIdIdx() ";
		CFBamUInt32DefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByIdIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, Id );
			stmtReadClassCodeByIdIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"rd_u32defccbyididx() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtReadClassCodeByIdIdx != null ) {
				try {
					stmtReadClassCodeByIdIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByIdIdx = null;
			}
		}
		if( classCode.equals( "U32D" ) ) {
			buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "U32C" ) ) {
			buff = schema.getTableUInt32Col().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "U32T" ) ) {
			buff = schema.getTableUInt32Type().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamOracleUInt32DefTable.readDerivedByUNameIdx() ";
		CFBamUInt32DefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByUNameIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByUNameIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ScopeId );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, Name );
			stmtReadClassCodeByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"rd_u32defccbyunameidx() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtReadClassCodeByUNameIdx != null ) {
				try {
					stmtReadClassCodeByUNameIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByUNameIdx = null;
			}
		}
		if( classCode.equals( "U32D" ) ) {
			buff = readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else if( classCode.equals( "U32C" ) ) {
			buff = schema.getTableUInt32Col().readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else if( classCode.equals( "U32T" ) ) {
			buff = schema.getTableUInt32Type().readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByValTentIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByValTentIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByValTentIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyvaltentidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByValTentIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByValTentIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByValTentIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByValTentIdx != null ) {
				try {
					stmtReadClassCodeByValTentIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByValTentIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByValTentIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByValTentIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByValTentIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByScopeIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyscopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ScopeId );
			stmtReadClassCodeByScopeIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByScopeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByScopeIdx != null ) {
				try {
					stmtReadClassCodeByScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByScopeIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByDefSchemaIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByDefSchemaIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtReadClassCodeByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByDefSchemaIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByDefSchemaIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByDefSchemaIdx != null ) {
				try {
					stmtReadClassCodeByDefSchemaIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByDefSchemaIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readDerivedByDataScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByDataScopeIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByDataScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbydatascopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByDataScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DataScopeId != null ) {
				stmtReadClassCodeByDataScopeIdx.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtReadClassCodeByDataScopeIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadClassCodeByDataScopeIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByDataScopeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByDataScopeIdx != null ) {
				try {
					stmtReadClassCodeByDataScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByDataScopeIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByDataScopeIdx( Authorization,
						DataScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByDataScopeIdx( Authorization,
						DataScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByDataScopeIdx( Authorization,
						DataScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByVAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByVAccSecIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByVAccSecIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyvaccsecidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByVAccSecIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessSecurityId != null ) {
				stmtReadClassCodeByVAccSecIdx.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtReadClassCodeByVAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadClassCodeByVAccSecIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByVAccSecIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByVAccSecIdx != null ) {
				try {
					stmtReadClassCodeByVAccSecIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByVAccSecIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByVAccSecIdx( Authorization,
						ViewAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByVAccSecIdx( Authorization,
						ViewAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByVAccSecIdx( Authorization,
						ViewAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByVAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByVAccFreqIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByVAccFreqIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyvaccfreqidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByVAccFreqIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessFrequencyId != null ) {
				stmtReadClassCodeByVAccFreqIdx.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadClassCodeByVAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadClassCodeByVAccFreqIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByVAccFreqIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByVAccFreqIdx != null ) {
				try {
					stmtReadClassCodeByVAccFreqIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByVAccFreqIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByVAccFreqIdx( Authorization,
						ViewAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByVAccFreqIdx( Authorization,
						ViewAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByVAccFreqIdx( Authorization,
						ViewAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByEAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByEAccSecIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByEAccSecIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyeaccsecidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByEAccSecIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessSecurityId != null ) {
				stmtReadClassCodeByEAccSecIdx.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtReadClassCodeByEAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadClassCodeByEAccSecIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByEAccSecIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByEAccSecIdx != null ) {
				try {
					stmtReadClassCodeByEAccSecIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByEAccSecIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByEAccSecIdx( Authorization,
						EditAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByEAccSecIdx( Authorization,
						EditAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByEAccSecIdx( Authorization,
						EditAccessSecurityId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByEAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByEAccFreqIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByEAccFreqIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyeaccfreqidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByEAccFreqIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessFrequencyId != null ) {
				stmtReadClassCodeByEAccFreqIdx.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadClassCodeByEAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadClassCodeByEAccFreqIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByEAccFreqIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByEAccFreqIdx != null ) {
				try {
					stmtReadClassCodeByEAccFreqIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByEAccFreqIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByEAccFreqIdx( Authorization,
						EditAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByEAccFreqIdx( Authorization,
						EditAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByEAccFreqIdx( Authorization,
						EditAccessFrequencyId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByPrevIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrevTenantId != null ) {
				stmtReadClassCodeByPrevIdx.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtReadClassCodeByPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadClassCodeByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByPrevIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByPrevIdx != null ) {
				try {
					stmtReadClassCodeByPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByPrevIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByNextIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbynextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( NextTenantId != null ) {
				stmtReadClassCodeByNextIdx.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtReadClassCodeByNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadClassCodeByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByNextIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByNextIdx != null ) {
				try {
					stmtReadClassCodeByNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByNextIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByContPrevIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByContPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbycontprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByContPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ScopeId );
			if( PrevId != null ) {
				stmtReadClassCodeByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadClassCodeByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByContPrevIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByContPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByContPrevIdx != null ) {
				try {
					stmtReadClassCodeByContPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByContPrevIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByContNextIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByContNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defccbycontnextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByContNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ScopeId );
			if( NextId != null ) {
				stmtReadClassCodeByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadClassCodeByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByContNextIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByContNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
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
			if( stmtReadClassCodeByContNextIdx != null ) {
				try {
					stmtReadClassCodeByContNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByContNextIdx = null;
			}
		}
		List<CFBamUInt32DefBuff> resultList = new LinkedList<CFBamUInt32DefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff[] subList
					= readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff[] subList
					= schema.getTableUInt32Col().readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff[] subList
					= schema.getTableUInt32Type().readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ resultList.size() ];
		Iterator<CFBamUInt32DefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamUInt32DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
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

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32def( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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

	public CFBamUInt32DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
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

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_u32def( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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

	public CFBamUInt32DefBuff[] readAllBuff( CFBamAuthorization Authorization ) {
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
			CFBamUInt32DefBuff buff = null;
			List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackUInt32DefResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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

	public CFBamUInt32DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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

	public CFBamUInt32DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUNameIdx = null;
		try {
			stmtReadBuffByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByUNameIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ScopeId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			stmtReadBuffByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			if( stmtReadBuffByUNameIdx != null ) {
				try {
					stmtReadBuffByUNameIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByUNameIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByValTentIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByValTentIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByValTentIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyvaltentidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByValTentIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByValTentIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByValTentIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByValTentIdx != null ) {
				try {
					stmtReadBuffByValTentIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByValTentIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "readBuffByScopeIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByScopeIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyscopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ScopeId );
			stmtReadBuffByScopeIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByScopeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByScopeIdx != null ) {
				try {
					stmtReadBuffByScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByScopeIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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

	public CFBamUInt32DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readBuffByDataScopeIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDataScopeIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByDataScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbydatascopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByDataScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DataScopeId != null ) {
				stmtReadBuffByDataScopeIdx.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtReadBuffByDataScopeIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadBuffByDataScopeIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByDataScopeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByDataScopeIdx != null ) {
				try {
					stmtReadBuffByDataScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByDataScopeIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readBuffByVAccSecIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByVAccSecIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByVAccSecIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyvaccsecidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByVAccSecIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessSecurityId != null ) {
				stmtReadBuffByVAccSecIdx.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtReadBuffByVAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadBuffByVAccSecIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByVAccSecIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByVAccSecIdx != null ) {
				try {
					stmtReadBuffByVAccSecIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByVAccSecIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByVAccFreqIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByVAccFreqIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByVAccFreqIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyvaccfreqidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByVAccFreqIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessFrequencyId != null ) {
				stmtReadBuffByVAccFreqIdx.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadBuffByVAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadBuffByVAccFreqIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByVAccFreqIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByVAccFreqIdx != null ) {
				try {
					stmtReadBuffByVAccFreqIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByVAccFreqIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readBuffByEAccSecIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByEAccSecIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByEAccSecIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyeaccsecidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByEAccSecIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessSecurityId != null ) {
				stmtReadBuffByEAccSecIdx.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtReadBuffByEAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadBuffByEAccSecIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByEAccSecIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByEAccSecIdx != null ) {
				try {
					stmtReadBuffByEAccSecIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByEAccSecIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByEAccFreqIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByEAccFreqIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByEAccFreqIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyeaccfreqidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByEAccFreqIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessFrequencyId != null ) {
				stmtReadBuffByEAccFreqIdx.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadBuffByEAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtReadBuffByEAccFreqIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByEAccFreqIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByEAccFreqIdx != null ) {
				try {
					stmtReadBuffByEAccFreqIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByEAccFreqIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPrevIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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

	public CFBamUInt32DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByNextIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbynextidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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

	public CFBamUInt32DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByContPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByContPrevIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByContPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbycontprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByContPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ScopeId );
			if( PrevId != null ) {
				stmtReadBuffByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadBuffByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByContPrevIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByContPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByContPrevIdx != null ) {
				try {
					stmtReadBuffByContPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByContPrevIdx = null;
			}
		}
	}

	public CFBamUInt32DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByContNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByContNextIdx = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {
			stmtReadBuffByContNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_u32defbycontnextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByContNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ScopeId );
			if( NextId != null ) {
				stmtReadBuffByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadBuffByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByContNextIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByContNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
			CFBamUInt32DefBuff[] retBuff = new CFBamUInt32DefBuff[ buffList.size() ];
			Iterator<CFBamUInt32DefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByContNextIdx != null ) {
				try {
					stmtReadBuffByContNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByContNextIdx = null;
			}
		}
	}

	public void updateUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		final String S_ProcName = "updateUInt32Def";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamUInt32DefBuff> buffList = new LinkedList<CFBamUInt32DefBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long ScopeId = Buff.getRequiredScopeId();
			long Id = Buff.getRequiredId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Boolean GenerateId = Buff.getOptionalGenerateId();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			boolean DefaultVisibility = Buff.getRequiredDefaultVisibility();
			String DbName = Buff.getOptionalDbName();
			Long InitValue = Buff.getOptionalInitValue();
			Long DefaultValue = Buff.getOptionalDefaultValue();
			Long MinValue = Buff.getOptionalMinValue();
			Long MaxValue = Buff.getOptionalMaxValue();
			Long NullValue = Buff.getOptionalNullValue();
			Long UnknownValue = Buff.getOptionalUnknownValue();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_u32def( ?, ?, ?, ?, ?, ?, ?" + ", "
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
					+	"? ); end;" );
			int argIdx = 1;
			stmtUpdateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, ClassCode );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, ScopeId );
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
			if( ShortName != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtUpdateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
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
			if( GenerateId != null ) {
				if( GenerateId.booleanValue() ) {
					stmtUpdateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtUpdateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DataScopeId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessSecurityId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessSecurityId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessFrequencyId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessFrequencyId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
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
			if( DefaultVisibility ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( DbName != null ) {
				stmtUpdateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( InitValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, InitValue.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefaultValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefaultValue.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( MinValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, MinValue.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( MaxValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, MaxValue.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NullValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, NullValue.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( UnknownValue != null ) {
				stmtUpdateByPKey.setLong( argIdx++, UnknownValue.longValue() );
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
						CFBamUInt32DefBuff updatedBuff = unpackUInt32DefResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredScopeId( updatedBuff.getRequiredScopeId() );
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalShortName( updatedBuff.getOptionalShortName() );
				Buff.setOptionalLabel( updatedBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( updatedBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( updatedBuff.getOptionalDescription() );
				Buff.setRequiredIsNullable( updatedBuff.getRequiredIsNullable() );
				Buff.setOptionalGenerateId( updatedBuff.getOptionalGenerateId() );
				Buff.setOptionalDataScopeId( updatedBuff.getOptionalDataScopeId() );
				Buff.setOptionalViewAccessSecurityId( updatedBuff.getOptionalViewAccessSecurityId() );
				Buff.setOptionalEditAccessSecurityId( updatedBuff.getOptionalEditAccessSecurityId() );
				Buff.setOptionalViewAccessFrequencyId( updatedBuff.getOptionalViewAccessFrequencyId() );
				Buff.setOptionalEditAccessFrequencyId( updatedBuff.getOptionalEditAccessFrequencyId() );
				Buff.setOptionalPrevTenantId( updatedBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( updatedBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( updatedBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( updatedBuff.getOptionalNextId() );
				Buff.setRequiredDefaultVisibility( updatedBuff.getRequiredDefaultVisibility() );
				Buff.setOptionalDbName( updatedBuff.getOptionalDbName() );
				Buff.setOptionalInitValue( updatedBuff.getOptionalInitValue() );
				Buff.setOptionalDefaultValue( updatedBuff.getOptionalDefaultValue() );
				Buff.setOptionalMinValue( updatedBuff.getOptionalMinValue() );
				Buff.setOptionalMaxValue( updatedBuff.getOptionalMaxValue() );
				Buff.setOptionalNullValue( updatedBuff.getOptionalNullValue() );
				Buff.setOptionalUnknownValue( updatedBuff.getOptionalUnknownValue() );
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
						"upd_u32def() did not return a valid result cursor" );
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
					"upd_u32def() did not return a result cursor" );
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

	public void deleteUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		final String S_ProcName = "deleteUInt32Def";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_u32def( ?, ?, ?, ?, ?" + ", "
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

	public void deleteUInt32DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteUInt32DefByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyididx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteUInt32DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		deleteUInt32DefByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteUInt32DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteUInt32DefByUNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyunameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByUNameIdx == null ) {
					stmtDeleteByUNameIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByUNameIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByUNameIdx.setLong( argIdx++, argScopeId );
				stmtDeleteByUNameIdx.setString( argIdx++, argName );
				int rowsUpdated = stmtDeleteByUNameIdx.executeUpdate();
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

	public void deleteUInt32DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		deleteUInt32DefByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getRequiredName() );
	}

	public void deleteUInt32DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteUInt32DefByValTentIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyvaltentidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByValTentIdx == null ) {
					stmtDeleteByValTentIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByValTentIdx.setLong( argIdx++, argTenantId );
				int rowsUpdated = stmtDeleteByValTentIdx.executeUpdate();
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

	public void deleteUInt32DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		deleteUInt32DefByValTentIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteUInt32DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		final String S_ProcName = "deleteUInt32DefByScopeIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyscopeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByScopeIdx == null ) {
					stmtDeleteByScopeIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByScopeIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByScopeIdx.setLong( argIdx++, argScopeId );
				int rowsUpdated = stmtDeleteByScopeIdx.executeUpdate();
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

	public void deleteUInt32DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		deleteUInt32DefByScopeIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId() );
	}

	public void deleteUInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteUInt32DefByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbydefschemaidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteUInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		deleteUInt32DefByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteUInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		final String S_ProcName = "deleteUInt32DefByDataScopeIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbydatascopeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByDataScopeIdx == null ) {
					stmtDeleteByDataScopeIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argDataScopeId != null ) {
					stmtDeleteByDataScopeIdx.setShort( argIdx++, argDataScopeId.shortValue() );
				}
				else {
					stmtDeleteByDataScopeIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
				}
				int rowsUpdated = stmtDeleteByDataScopeIdx.executeUpdate();
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

	public void deleteUInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		deleteUInt32DefByDataScopeIdx( Authorization,
			argKey.getOptionalDataScopeId() );
	}

	public void deleteUInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		final String S_ProcName = "deleteUInt32DefByVAccSecIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyvaccsecidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByVAccSecIdx == null ) {
					stmtDeleteByVAccSecIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argViewAccessSecurityId != null ) {
					stmtDeleteByVAccSecIdx.setShort( argIdx++, argViewAccessSecurityId.shortValue() );
				}
				else {
					stmtDeleteByVAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
				}
				int rowsUpdated = stmtDeleteByVAccSecIdx.executeUpdate();
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

	public void deleteUInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		deleteUInt32DefByVAccSecIdx( Authorization,
			argKey.getOptionalViewAccessSecurityId() );
	}

	public void deleteUInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		final String S_ProcName = "deleteUInt32DefByVAccFreqIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyvaccfreqidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByVAccFreqIdx == null ) {
					stmtDeleteByVAccFreqIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argViewAccessFrequencyId != null ) {
					stmtDeleteByVAccFreqIdx.setShort( argIdx++, argViewAccessFrequencyId.shortValue() );
				}
				else {
					stmtDeleteByVAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
				}
				int rowsUpdated = stmtDeleteByVAccFreqIdx.executeUpdate();
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

	public void deleteUInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		deleteUInt32DefByVAccFreqIdx( Authorization,
			argKey.getOptionalViewAccessFrequencyId() );
	}

	public void deleteUInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		final String S_ProcName = "deleteUInt32DefByEAccSecIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyeaccsecidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByEAccSecIdx == null ) {
					stmtDeleteByEAccSecIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argEditAccessSecurityId != null ) {
					stmtDeleteByEAccSecIdx.setShort( argIdx++, argEditAccessSecurityId.shortValue() );
				}
				else {
					stmtDeleteByEAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
				}
				int rowsUpdated = stmtDeleteByEAccSecIdx.executeUpdate();
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

	public void deleteUInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		deleteUInt32DefByEAccSecIdx( Authorization,
			argKey.getOptionalEditAccessSecurityId() );
	}

	public void deleteUInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		final String S_ProcName = "deleteUInt32DefByEAccFreqIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyeaccfreqidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByEAccFreqIdx == null ) {
					stmtDeleteByEAccFreqIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argEditAccessFrequencyId != null ) {
					stmtDeleteByEAccFreqIdx.setShort( argIdx++, argEditAccessFrequencyId.shortValue() );
				}
				else {
					stmtDeleteByEAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
				}
				int rowsUpdated = stmtDeleteByEAccFreqIdx.executeUpdate();
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

	public void deleteUInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		deleteUInt32DefByEAccFreqIdx( Authorization,
			argKey.getOptionalEditAccessFrequencyId() );
	}

	public void deleteUInt32DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteUInt32DefByPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbyprevidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteUInt32DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		deleteUInt32DefByPrevIdx( Authorization,
			argKey.getOptionalPrevTenantId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteUInt32DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		final String S_ProcName = "deleteUInt32DefByNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbynextidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteUInt32DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		deleteUInt32DefByNextIdx( Authorization,
			argKey.getOptionalNextTenantId(),
			argKey.getOptionalNextId() );
	}

	public void deleteUInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteUInt32DefByContPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbycontprevidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByContPrevIdx == null ) {
					stmtDeleteByContPrevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByContPrevIdx.setLong( argIdx++, argScopeId );
				if( argPrevId != null ) {
					stmtDeleteByContPrevIdx.setLong( argIdx++, argPrevId.longValue() );
				}
				else {
					stmtDeleteByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByContPrevIdx.executeUpdate();
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

	public void deleteUInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		deleteUInt32DefByContPrevIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteUInt32DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		final String S_ProcName = "deleteUInt32DefByContNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_u32defbycontnextidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByContNextIdx == null ) {
					stmtDeleteByContNextIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByContNextIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByContNextIdx.setLong( argIdx++, argScopeId );
				if( argNextId != null ) {
					stmtDeleteByContNextIdx.setLong( argIdx++, argNextId.longValue() );
				}
				else {
					stmtDeleteByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByContNextIdx.executeUpdate();
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

	public void deleteUInt32DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		deleteUInt32DefByContNextIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getOptionalNextId() );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt32DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
			stmtMoveUp = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvup_u32def( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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
	public CFBamUInt32DefBuff moveBuffDown( CFBamAuthorization Authorization,
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
			stmtMoveDown = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvdn_u32def( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
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

	public CFBamCursor openUInt32DefCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectUInt32DefBuff()
			+	"ORDER BY " 
			+		"u32d.TenantId ASC" + ", "
			+		"u32d.Id ASC";
		CFBamCursor cursor = new CFBamOracleCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeUInt32DefCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeUInt32DefCursor",
				e );
		}
	}

	public CFBamUInt32DefBuff nextUInt32DefCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextUInt32DefCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamUInt32DefBuff buff = unpackUInt32DefResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamUInt32DefBuff prevUInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamUInt32DefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextUInt32DefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff firstUInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamUInt32DefBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextUInt32DefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamUInt32DefBuff lastUInt32DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastUInt32DefCursor" );
	}

	public CFBamUInt32DefBuff nthUInt32DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamUInt32DefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextUInt32DefCursor( Cursor );
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
		S_sqlSelectUInt32DefBuff = null;
		S_sqlSelectUInt32DefDistinctClassCode = null;

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
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteByValTentIdx != null ) {
			try {
				stmtDeleteByValTentIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByValTentIdx = null;
		}
		if( stmtDeleteByScopeIdx != null ) {
			try {
				stmtDeleteByScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByScopeIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByDataScopeIdx != null ) {
			try {
				stmtDeleteByDataScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDataScopeIdx = null;
		}
		if( stmtDeleteByVAccSecIdx != null ) {
			try {
				stmtDeleteByVAccSecIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByVAccSecIdx = null;
		}
		if( stmtDeleteByVAccFreqIdx != null ) {
			try {
				stmtDeleteByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByVAccFreqIdx = null;
		}
		if( stmtDeleteByEAccSecIdx != null ) {
			try {
				stmtDeleteByEAccSecIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEAccSecIdx = null;
		}
		if( stmtDeleteByEAccFreqIdx != null ) {
			try {
				stmtDeleteByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByEAccFreqIdx = null;
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
		if( stmtDeleteByContPrevIdx != null ) {
			try {
				stmtDeleteByContPrevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByContPrevIdx = null;
		}
		if( stmtDeleteByContNextIdx != null ) {
			try {
				stmtDeleteByContNextIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByContNextIdx = null;
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
		if( stmtReadDerivedClassCode != null ) {
			try {
				stmtReadDerivedClassCode.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadDerivedClassCode = null;
		}
		if( stmtLockDerivedClassCode != null ) {
			try {
				stmtLockDerivedClassCode.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtLockDerivedClassCode = null;
		}
		if( stmtReadAllClassCode != null ) {
			try {
				stmtReadAllClassCode.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadAllClassCode = null;
		}
		if( stmtReadClassCodeByIdIdx != null ) {
			try {
				stmtReadClassCodeByIdIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByIdIdx = null;
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
		if( stmtReadClassCodeByUNameIdx != null ) {
			try {
				stmtReadClassCodeByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByUNameIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtReadClassCodeByValTentIdx != null ) {
			try {
				stmtReadClassCodeByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByValTentIdx = null;
		}
		if( stmtReadBuffByValTentIdx != null ) {
			try {
				stmtReadBuffByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByValTentIdx = null;
		}
		if( stmtReadClassCodeByScopeIdx != null ) {
			try {
				stmtReadClassCodeByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByScopeIdx = null;
		}
		if( stmtReadBuffByScopeIdx != null ) {
			try {
				stmtReadBuffByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByScopeIdx = null;
		}
		if( stmtReadClassCodeByDefSchemaIdx != null ) {
			try {
				stmtReadClassCodeByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByDefSchemaIdx = null;
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
		if( stmtReadClassCodeByDataScopeIdx != null ) {
			try {
				stmtReadClassCodeByDataScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByDataScopeIdx = null;
		}
		if( stmtReadBuffByDataScopeIdx != null ) {
			try {
				stmtReadBuffByDataScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByDataScopeIdx = null;
		}
		if( stmtReadClassCodeByVAccSecIdx != null ) {
			try {
				stmtReadClassCodeByVAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByVAccSecIdx = null;
		}
		if( stmtReadBuffByVAccSecIdx != null ) {
			try {
				stmtReadBuffByVAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByVAccSecIdx = null;
		}
		if( stmtReadClassCodeByVAccFreqIdx != null ) {
			try {
				stmtReadClassCodeByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByVAccFreqIdx = null;
		}
		if( stmtReadBuffByVAccFreqIdx != null ) {
			try {
				stmtReadBuffByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByVAccFreqIdx = null;
		}
		if( stmtReadClassCodeByEAccSecIdx != null ) {
			try {
				stmtReadClassCodeByEAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByEAccSecIdx = null;
		}
		if( stmtReadBuffByEAccSecIdx != null ) {
			try {
				stmtReadBuffByEAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByEAccSecIdx = null;
		}
		if( stmtReadClassCodeByEAccFreqIdx != null ) {
			try {
				stmtReadClassCodeByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByEAccFreqIdx = null;
		}
		if( stmtReadBuffByEAccFreqIdx != null ) {
			try {
				stmtReadBuffByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByEAccFreqIdx = null;
		}
		if( stmtReadClassCodeByPrevIdx != null ) {
			try {
				stmtReadClassCodeByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByPrevIdx = null;
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
		if( stmtReadClassCodeByNextIdx != null ) {
			try {
				stmtReadClassCodeByNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByNextIdx = null;
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
		if( stmtReadClassCodeByContPrevIdx != null ) {
			try {
				stmtReadClassCodeByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByContPrevIdx = null;
		}
		if( stmtReadBuffByContPrevIdx != null ) {
			try {
				stmtReadBuffByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByContPrevIdx = null;
		}
		if( stmtReadClassCodeByContNextIdx != null ) {
			try {
				stmtReadClassCodeByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByContNextIdx = null;
		}
		if( stmtReadBuffByContNextIdx != null ) {
			try {
				stmtReadBuffByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByContNextIdx = null;
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
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteByValTentIdx != null ) {
			try {
				stmtDeleteByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByValTentIdx = null;
		}
		if( stmtDeleteByScopeIdx != null ) {
			try {
				stmtDeleteByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByScopeIdx = null;
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
		if( stmtDeleteByDataScopeIdx != null ) {
			try {
				stmtDeleteByDataScopeIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByDataScopeIdx = null;
		}
		if( stmtDeleteByVAccSecIdx != null ) {
			try {
				stmtDeleteByVAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByVAccSecIdx = null;
		}
		if( stmtDeleteByVAccFreqIdx != null ) {
			try {
				stmtDeleteByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByVAccFreqIdx = null;
		}
		if( stmtDeleteByEAccSecIdx != null ) {
			try {
				stmtDeleteByEAccSecIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByEAccSecIdx = null;
		}
		if( stmtDeleteByEAccFreqIdx != null ) {
			try {
				stmtDeleteByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByEAccFreqIdx = null;
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
		if( stmtDeleteByContPrevIdx != null ) {
			try {
				stmtDeleteByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByContPrevIdx = null;
		}
		if( stmtDeleteByContNextIdx != null ) {
			try {
				stmtDeleteByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByContNextIdx = null;
		}
	}
}
