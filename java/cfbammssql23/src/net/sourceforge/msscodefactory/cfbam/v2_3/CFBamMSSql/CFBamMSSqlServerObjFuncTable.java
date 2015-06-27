// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for ServerObjFunc.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMSSql;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamMSSqlServerObjFuncTable PostgreSQL Jdbc DbIO implementation
 *	for ServerObjFunc.
 */
public class CFBamMSSqlServerObjFuncTable
	implements ICFBamServerObjFuncTable
{
	private CFBamMSSqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtAuditCreatedByPKey = null;
	protected PreparedStatement stmtAuditUpdatedByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByTableIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByRetTblIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByTableIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByRetTblIdx = null;

	public CFBamMSSqlServerObjFuncTable( CFBamMSSqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		final String S_ProcName = "createServerObjFunc";
		if( "SRVO".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"CreateServerObjFunc" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup CreateServerObjFunc" );
		}
		schema.getTableServerMethod().createServerMethod( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			Long RetTenantId = Buff.getOptionalRetTenantId();
			Long RetTableId = Buff.getOptionalRetTableId();
			String sql =
					"INSERT INTO " + schema.getLowerDbSchemaName() + "..srvofunc( "
				+		"tenantid, "
				+		"id, "
				+		"rettentid, "
				+		"rettblid" + " )"
				+	"VALUES ( "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, Id );
			if( RetTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, RetTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RetTableId != null ) {
				stmtCreateByPKey.setLong( argIdx++, RetTableId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			int rowsAffected = stmtCreateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by insert, not " + rowsAffected );
			}
			if( "SRVO".equals( Buff.getClassCode() ) ) {
				String sqlAuditCreated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..srvofunc_h( auditclusterid, "
					+		" auditsessionid,"
					+		" auditstamp,"
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"tableid" + ", "
					+		"defschtentid" + ", "
					+		"defschid" + ", "
					+		"name" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"suffix" + ", "
					+		"dflt_vis" + ", "
					+		"inst_meth" + ", "
					+		"jmeth_body" + ", "
					+		"rettentid" + ", "
					+		"rettblid" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"srvm.tableid" + ", "
					+		"srvm.defschtentid" + ", "
					+		"srvm.defschid" + ", "
					+		"srvm.name" + ", "
					+		"srvm.short_name" + ", "
					+		"srvm.label" + ", "
					+		"srvm.short_descr" + ", "
					+		"srvm.descr" + ", "
					+		"srvm.suffix" + ", "
					+		"srvm.dflt_vis" + ", "
					+		"srvm.inst_meth" + ", "
					+		"srvm.jmeth_body" + ", "
					+		"srvo.rettentid" + ", "
					+		"srvo.rettblid" + ", "
					+		" scop.revision, "
					+		" 1 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvmeth srvm ON "
				+		"srvm.TenantId = scop.TenantId "
				+		"AND srvm.Id = scop.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvofunc srvo ON "
				+		"srvo.TenantId = scop.TenantId "
				+		"AND srvo.Id = scop.Id "
					+	" WHERE "
					+				"scop.tenantid = ? "
					+			"AND scop.id = ? ";
				if( stmtAuditCreatedByPKey == null ) {
					stmtAuditCreatedByPKey = cnx.prepareStatement( sqlAuditCreated );
				}
				argIdx = 1;
				stmtAuditCreatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
				stmtAuditCreatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditCreatedByPKey.setLong( argIdx++, TenantId );
				stmtAuditCreatedByPKey.setLong( argIdx++, Id );
				int rowsAudited = stmtAuditCreatedByPKey.executeUpdate();
				if( rowsAudited != 1 ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	protected static String S_sqlSelectServerObjFuncDistinctClassCode = null;

	public String getSqlSelectServerObjFuncDistinctClassCode() {
		if( S_sqlSelectServerObjFuncDistinctClassCode == null ) {
			S_sqlSelectServerObjFuncDistinctClassCode =
					"SELECT "
				+		"DISTINCT scop.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvmeth srvm ON "
				+		"srvm.TenantId = scop.TenantId "
				+		"AND srvm.Id = scop.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvofunc srvo ON "
				+		"srvo.TenantId = scop.TenantId "
				+		"AND srvo.Id = scop.Id ";
		}
		return( S_sqlSelectServerObjFuncDistinctClassCode );
	}

	protected static String S_sqlSelectServerObjFuncBuff = null;

	public String getSqlSelectServerObjFuncBuff() {
		if( S_sqlSelectServerObjFuncBuff == null ) {
			S_sqlSelectServerObjFuncBuff =
					"SELECT "
				+		"scop.ClassCode, "
				+		"scop.tenantid, "
				+		"scop.id, "
				+		"srvm.tableid, "
				+		"srvm.defschtentid, "
				+		"srvm.defschid, "
				+		"srvm.name, "
				+		"srvm.short_name, "
				+		"srvm.label, "
				+		"srvm.short_descr, "
				+		"srvm.descr, "
				+		"srvm.suffix, "
				+		"srvm.dflt_vis, "
				+		"srvm.inst_meth, "
				+		"srvm.jmeth_body, "
				+		"srvo.rettentid, "
				+		"srvo.rettblid, "
				+		"scop.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvmeth srvm ON "
				+		"srvm.TenantId = scop.TenantId "
				+		"AND srvm.Id = scop.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvofunc srvo ON "
				+		"srvo.TenantId = scop.TenantId "
				+		"AND srvo.Id = scop.Id ";
		}
		return( S_sqlSelectServerObjFuncBuff );
	}

	protected CFBamServerObjFuncBuff unpackServerObjFuncResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackServerObjFuncResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamServerObjFuncBuff buff;
		if( classCode.equals( "SRVO" ) ) {
			buff = schema.getFactoryServerObjFunc().newBuff();
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
				buff.setCreatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
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
				buff.setUpdatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredTableId( resultSet.getLong( idxcol ) );
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
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalSuffix( null );
			}
			else {
				buff.setOptionalSuffix( colVal );
			}
		}
		idxcol++;
		buff.setRequiredDefaultVisibility( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredIsInstanceMethod( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredJMethodBody( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalRetTenantId( null );
			}
			else {
				buff.setOptionalRetTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalRetTableId( null );
			}
			else {
				buff.setOptionalRetTableId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamServerObjFuncBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamServerObjFuncBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamServerObjFuncBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamServerObjFuncBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamServerObjFuncBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamMSSqlServerObjFuncTable.readDerivedByIdIdx() ";
		CFBamServerObjFuncBuff buff;
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

	public CFBamServerObjFuncBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamServerObjFuncBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamMSSqlServerObjFuncTable.readDerivedByUNameIdx() ";
		CFBamServerObjFuncBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				TableId,
				Name );
		return( buff );
	}

	public CFBamServerObjFuncBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "readDerivedByTableIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff[] buffList = readBuffByTableIdx( Authorization,
				TenantId,
				TableId );
		return( buffList );

	}

	public CFBamServerObjFuncBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamServerObjFuncBuff[] readDerivedByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "readDerivedByRetTblIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamServerObjFuncBuff[] buffList = readBuffByRetTblIdx( Authorization,
				RetTenantId,
				RetTableId );
		return( buffList );

	}

	public CFBamServerObjFuncBuff readBuff( CFBamAuthorization Authorization,
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
			String sql = "{ call sp_read_srvofunc( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
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
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
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

	public CFBamServerObjFuncBuff lockBuff( CFBamAuthorization Authorization,
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
			String sql = "{ call sp_lock_srvofunc( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
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
			stmtLockBuffByPKey.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtLockBuffByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtLockBuffByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtLockBuffByPKey.getUpdateCount() ) {
					break;
				}
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
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

	public CFBamServerObjFuncBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_all( ?, ?, ?, ?, ? ) }";
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
			List<CFBamServerObjFuncBuff> buffList = new LinkedList<CFBamServerObjFuncBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamServerObjFuncBuff[] retBuff = new CFBamServerObjFuncBuff[ buffList.size() ];
			Iterator<CFBamServerObjFuncBuff> iter = buffList.iterator();
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

	public CFBamServerObjFuncBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
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
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
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

	public CFBamServerObjFuncBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_tenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
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
			List<CFBamServerObjFuncBuff> buffList = new LinkedList<CFBamServerObjFuncBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamServerObjFuncBuff[] retBuff = new CFBamServerObjFuncBuff[ buffList.size() ];
			Iterator<CFBamServerObjFuncBuff> iter = buffList.iterator();
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

	public CFBamServerObjFuncBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_unameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, TableId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
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

	public CFBamServerObjFuncBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "readBuffByTableIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_tableidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByTableIdx == null ) {
				stmtReadBuffByTableIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByTableIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByTableIdx.setLong( argIdx++, TableId );
			resultSet = stmtReadBuffByTableIdx.executeQuery();
			List<CFBamServerObjFuncBuff> buffList = new LinkedList<CFBamServerObjFuncBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamServerObjFuncBuff[] retBuff = new CFBamServerObjFuncBuff[ buffList.size() ];
			Iterator<CFBamServerObjFuncBuff> iter = buffList.iterator();
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

	public CFBamServerObjFuncBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_defschemaidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
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
			List<CFBamServerObjFuncBuff> buffList = new LinkedList<CFBamServerObjFuncBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamServerObjFuncBuff[] retBuff = new CFBamServerObjFuncBuff[ buffList.size() ];
			Iterator<CFBamServerObjFuncBuff> iter = buffList.iterator();
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

	public CFBamServerObjFuncBuff[] readBuffByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "readBuffByRetTblIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_srvofunc_by_rettblidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByRetTblIdx == null ) {
				stmtReadBuffByRetTblIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRetTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByRetTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( RetTenantId != null ) {
				stmtReadBuffByRetTblIdx.setLong( argIdx++, RetTenantId.longValue() );
			}
			else {
				stmtReadBuffByRetTblIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RetTableId != null ) {
				stmtReadBuffByRetTblIdx.setLong( argIdx++, RetTableId.longValue() );
			}
			else {
				stmtReadBuffByRetTblIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByRetTblIdx.executeQuery();
			List<CFBamServerObjFuncBuff> buffList = new LinkedList<CFBamServerObjFuncBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamServerObjFuncBuff[] retBuff = new CFBamServerObjFuncBuff[ buffList.size() ];
			Iterator<CFBamServerObjFuncBuff> iter = buffList.iterator();
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

	public void updateServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		final String S_ProcName = "updateServerObjFunc";
		if( "SRVO".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"UpdateServerObjFunc" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup UpdateServerObjFunc" );
		}
		schema.getTableServerMethod().updateServerMethod( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			Long RetTenantId = Buff.getOptionalRetTenantId();
			Long RetTableId = Buff.getOptionalRetTableId();
			int Revision = Buff.getRequiredRevision();

			String sql =
					"UPDATE " + schema.getLowerDbSchemaName() + "..srvofunc "
				+	"SET "
				+		"tenantid = ?" + ", "
				+		"id = ?" + ", "
				+		"rettentid = ?" + ", "
				+		"rettblid = ?"
				+	" WHERE "
				+		"tenantid = ? "
				+	"AND "
				+		"id = ? ";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;

			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			if( RetTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, RetTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( RetTableId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, RetTableId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );;
			int rowsAffected = stmtUpdateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by update, not " + rowsAffected );
			}
			if( "SRVO".equals( Buff.getClassCode() ) ) {
				String sqlAuditUpdated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..srvofunc_h( auditclusterid, "
					+		" auditsessionid, "
					+		" auditstamp, "
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"tableid" + ", "
					+		"defschtentid" + ", "
					+		"defschid" + ", "
					+		"name" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"suffix" + ", "
					+		"dflt_vis" + ", "
					+		"inst_meth" + ", "
					+		"jmeth_body" + ", "
					+		"rettentid" + ", "
					+		"rettblid" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"srvm.tableid" + ", "
					+		"srvm.defschtentid" + ", "
					+		"srvm.defschid" + ", "
					+		"srvm.name" + ", "
					+		"srvm.short_name" + ", "
					+		"srvm.label" + ", "
					+		"srvm.short_descr" + ", "
					+		"srvm.descr" + ", "
					+		"srvm.suffix" + ", "
					+		"srvm.dflt_vis" + ", "
					+		"srvm.inst_meth" + ", "
					+		"srvm.jmeth_body" + ", "
					+		"srvo.rettentid" + ", "
					+		"srvo.rettblid" + ", "
					+		" scop.revision, "
					+		" 2 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvmeth srvm ON "
				+		"srvm.TenantId = scop.TenantId "
				+		"AND srvm.Id = scop.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..srvofunc srvo ON "
				+		"srvo.TenantId = scop.TenantId "
				+		"AND srvo.Id = scop.Id "
					+	" WHERE "
					+				"scop.tenantid = ? "
					+			"AND scop.id = ? ";
				if( stmtAuditUpdatedByPKey == null ) {
					stmtAuditUpdatedByPKey = cnx.prepareStatement( sqlAuditUpdated );
				}
				argIdx = 1;
				stmtAuditUpdatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
				stmtAuditUpdatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditUpdatedByPKey.setLong( argIdx++, TenantId );
				stmtAuditUpdatedByPKey.setLong( argIdx++, Id );
				int rowsAudited = stmtAuditUpdatedByPKey.executeUpdate();
				if( rowsAudited != 1 ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public void deleteServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		final String S_ProcName = "deleteServerObjFunc";
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_srvofunc ?, ?, ?, ?, ?" + ", "
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

	public void deleteServerObjFuncByRetTblIdx( CFBamAuthorization Authorization,
		Long argRetTenantId,
		Long argRetTableId )
	{
		final String S_ProcName = "deleteServerObjFuncByRetTblIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvofunc_by_rettblidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByRetTblIdx== null ) {
				stmtDeleteByRetTblIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByRetTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByRetTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByRetTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argRetTenantId != null ) {
				stmtDeleteByRetTblIdx.setLong( argIdx++, argRetTenantId.longValue() );
			}
			else {
				stmtDeleteByRetTblIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argRetTableId != null ) {
				stmtDeleteByRetTblIdx.setLong( argIdx++, argRetTableId.longValue() );
			}
			else {
				stmtDeleteByRetTblIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByRetTblIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByRetTblIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByRetTblIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByRetTblIdx.getUpdateCount() ) {
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

	public void deleteServerObjFuncByRetTblIdx( CFBamAuthorization Authorization,
		CFBamServerObjFuncByRetTblIdxKey argKey )
	{
		deleteServerObjFuncByRetTblIdx( Authorization,
			argKey.getOptionalRetTenantId(),
			argKey.getOptionalRetTableId() );
	}

	public void deleteServerObjFuncByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		final String S_ProcName = "deleteServerObjFuncByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvofunc_by_unameidx ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByUNameIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByUNameIdx.setLong( argIdx++, argTableId );
			stmtDeleteByUNameIdx.setString( argIdx++, argName );
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

	public void deleteServerObjFuncByUNameIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey )
	{
		deleteServerObjFuncByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredTableId(),
			argKey.getRequiredName() );
	}

	public void deleteServerObjFuncByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		final String S_ProcName = "deleteServerObjFuncByTableIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvofunc_by_tableidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByTableIdx== null ) {
				stmtDeleteByTableIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByTableIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByTableIdx.setLong( argIdx++, argTableId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByTableIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByTableIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByTableIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByTableIdx.getUpdateCount() ) {
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

	public void deleteServerObjFuncByTableIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByTableIdxKey argKey )
	{
		deleteServerObjFuncByTableIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredTableId() );
	}

	public void deleteServerObjFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteServerObjFuncByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvofunc_by_defschemaidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteServerObjFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey )
	{
		deleteServerObjFuncByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteServerObjFuncByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteServerObjFuncByIdIdx";
		// MSS TODO WORKING
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName );
	}

	public void deleteServerObjFuncByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteServerObjFuncByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteServerObjFuncByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteServerObjFuncByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_srvofunc_by_tenantidx ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByTenantIdx.setLong( argIdx++, argTenantId );
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

	public void deleteServerObjFuncByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteServerObjFuncByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public CFBamCursor openServerObjFuncCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectServerObjFuncBuff()
			+	"ORDER BY " 
			+		"srvo.TenantId ASC" + ", "
			+		"srvo.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openServerObjFuncCursorByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		String sql = getSqlSelectServerObjFuncBuff()
			+	" WHERE "
				+		( ( RetTenantId == null ) ? "srvo.rettentid is null "
							: "srvo.rettentid = " + RetTenantId.toString() + " " )
			+	"AND "
				+		( ( RetTableId == null ) ? "srvo.rettblid is null "
							: "srvo.rettblid = " + RetTableId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SRVO'"
			+	"ORDER BY " 
			+		"srvo.TenantId ASC" + ", "
			+		"srvo.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeServerObjFuncCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeServerObjFuncCursor",
				e );
		}
	}

	public CFBamServerObjFuncBuff nextServerObjFuncCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextServerObjFuncCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamServerObjFuncBuff buff = unpackServerObjFuncResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamServerObjFuncBuff prevServerObjFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServerObjFuncBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServerObjFuncCursor( Cursor );
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff firstServerObjFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServerObjFuncBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServerObjFuncCursor( Cursor );
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff lastServerObjFuncCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastServerObjFuncCursor" );
	}

	public CFBamServerObjFuncBuff nthServerObjFuncCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServerObjFuncBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextServerObjFuncCursor( Cursor );
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
		S_sqlSelectServerObjFuncDistinctClassCode = null;
		S_sqlSelectServerObjFuncBuff = null;
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
		if( stmtAuditCreatedByPKey != null ) {
			try {
				stmtAuditCreatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditCreatedByPKey = null;
		}
		if( stmtAuditUpdatedByPKey != null ) {
			try {
				stmtAuditUpdatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditUpdatedByPKey = null;
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
		if( stmtDeleteByTableIdx != null ) {
			try {
				stmtDeleteByTableIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByTableIdx = null;
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
		if( stmtDeleteByRetTblIdx != null ) {
			try {
				stmtDeleteByRetTblIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByRetTblIdx = null;
			}
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
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByTenantIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtReadBuffByTableIdx != null ) {
			try {
				stmtReadBuffByTableIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByTableIdx = null;
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDefSchemaIdx = null;
		}
		if( stmtReadBuffByRetTblIdx != null ) {
			try {
				stmtReadBuffByRetTblIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByRetTblIdx = null;
		}
	}
}
