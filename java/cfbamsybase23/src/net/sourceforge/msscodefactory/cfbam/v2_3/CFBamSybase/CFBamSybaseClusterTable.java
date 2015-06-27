// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for Cluster.

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
 *	CFBamSybaseClusterTable PostgreSQL Jdbc DbIO implementation
 *	for Cluster.
 */
public class CFBamSybaseClusterTable
	implements ICFBamClusterTable
{
	private CFBamSybaseSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByUDomainNameIdx = null;
	protected PreparedStatement stmtReadBuffByUDescrIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByUDomainNameIdx = null;
	protected PreparedStatement stmtDeleteByUDescrIdx = null;

	public CFBamSybaseClusterTable( CFBamSybaseSchema argSchema ) {
		schema = argSchema;
	}

	public int nextSecAppIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecAppIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecAppIdGen = null;
		try {
			String sql =
					"{ call sp_next_secappidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecAppIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecAppIdGen.registerOutParameter( argIdx++, java.sql.Types.INTEGER );
			stmtSelectNextSecAppIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecAppIdGen.execute();
			int nextId = stmtSelectNextSecAppIdGen.getInt( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecAppIdGen != null ) {
				try {
					stmtSelectNextSecAppIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecAppIdGen = null;
			}
		}
	}

	public int nextSecAppIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		int retval = nextSecAppIdGen( Authorization, pkey );
		return( retval );
	}

	public int nextSecFormIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecFormIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecFormIdGen = null;
		try {
			String sql =
					"{ call sp_next_secformidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecFormIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecFormIdGen.registerOutParameter( argIdx++, java.sql.Types.INTEGER );
			stmtSelectNextSecFormIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecFormIdGen.execute();
			int nextId = stmtSelectNextSecFormIdGen.getInt( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecFormIdGen != null ) {
				try {
					stmtSelectNextSecFormIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecFormIdGen = null;
			}
		}
	}

	public int nextSecFormIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		int retval = nextSecFormIdGen( Authorization, pkey );
		return( retval );
	}

	public int nextSecGroupIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecGroupIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecGroupIdGen = null;
		try {
			String sql =
					"{ call sp_next_secgroupidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecGroupIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecGroupIdGen.registerOutParameter( argIdx++, java.sql.Types.INTEGER );
			stmtSelectNextSecGroupIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecGroupIdGen.execute();
			int nextId = stmtSelectNextSecGroupIdGen.getInt( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecGroupIdGen != null ) {
				try {
					stmtSelectNextSecGroupIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecGroupIdGen = null;
			}
		}
	}

	public int nextSecGroupIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		int retval = nextSecGroupIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextSecGroupMemberIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecGroupMemberIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecGroupMemberIdGen = null;
		try {
			String sql =
					"{ call sp_next_secgroupmemberidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecGroupMemberIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecGroupMemberIdGen.registerOutParameter( argIdx++, java.sql.Types.BIGINT );
			stmtSelectNextSecGroupMemberIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecGroupMemberIdGen.execute();
			long nextId = stmtSelectNextSecGroupMemberIdGen.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecGroupMemberIdGen != null ) {
				try {
					stmtSelectNextSecGroupMemberIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecGroupMemberIdGen = null;
			}
		}
	}

	public long nextSecGroupMemberIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextSecGroupMemberIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecGroupIncludeIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecGroupIncludeIdGen = null;
		try {
			String sql =
					"{ call sp_next_secgroupincludeidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecGroupIncludeIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecGroupIncludeIdGen.registerOutParameter( argIdx++, java.sql.Types.BIGINT );
			stmtSelectNextSecGroupIncludeIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecGroupIncludeIdGen.execute();
			long nextId = stmtSelectNextSecGroupIncludeIdGen.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecGroupIncludeIdGen != null ) {
				try {
					stmtSelectNextSecGroupIncludeIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecGroupIncludeIdGen = null;
			}
		}
	}

	public long nextSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextSecGroupIncludeIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextSecGroupFormIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextSecGroupFormIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextSecGroupFormIdGen = null;
		try {
			String sql =
					"{ call sp_next_secgroupformidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextSecGroupFormIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextSecGroupFormIdGen.registerOutParameter( argIdx++, java.sql.Types.BIGINT );
			stmtSelectNextSecGroupFormIdGen.setLong( argIdx++, Id );
			stmtSelectNextSecGroupFormIdGen.execute();
			long nextId = stmtSelectNextSecGroupFormIdGen.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextSecGroupFormIdGen != null ) {
				try {
					stmtSelectNextSecGroupFormIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextSecGroupFormIdGen = null;
			}
		}
	}

	public long nextSecGroupFormIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextSecGroupFormIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextServiceIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextServiceIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextServiceIdGen = null;
		try {
			String sql =
					"{ call sp_next_serviceidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextServiceIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextServiceIdGen.registerOutParameter( argIdx++, java.sql.Types.BIGINT );
			stmtSelectNextServiceIdGen.setLong( argIdx++, Id );
			stmtSelectNextServiceIdGen.execute();
			long nextId = stmtSelectNextServiceIdGen.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextServiceIdGen != null ) {
				try {
					stmtSelectNextServiceIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextServiceIdGen = null;
			}
		}
	}

	public long nextServiceIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextServiceIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextHostNodeIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "nextHostNodeIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();			long Id = PKey.getRequiredId();

		CallableStatement stmtSelectNextHostNodeIdGen = null;
		try {
			String sql =
					"{ call sp_next_hostnodeidgen( ?" + ", "
			+		"?"
				+		" ) }";
			stmtSelectNextHostNodeIdGen = cnx.prepareCall( sql );
			int argIdx = 1;
			stmtSelectNextHostNodeIdGen.registerOutParameter( argIdx++, java.sql.Types.BIGINT );
			stmtSelectNextHostNodeIdGen.setLong( argIdx++, Id );
			stmtSelectNextHostNodeIdGen.execute();
			long nextId = stmtSelectNextHostNodeIdGen.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSelectNextHostNodeIdGen != null ) {
				try {
					stmtSelectNextHostNodeIdGen.close();
				}
				catch( SQLException e ) {
				}
				stmtSelectNextHostNodeIdGen = null;
			}
		}
	}

	public long nextHostNodeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextHostNodeIdGen( Authorization, pkey );
		return( retval );
	}

	public void createCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		final String S_ProcName = "createCluster";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			String FullDomainName = Buff.getRequiredFullDomainName();
			String Description = Buff.getRequiredDescription();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_clus ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, "CLUS" );
			stmtCreateByPKey.setString( argIdx++, FullDomainName );
			stmtCreateByPKey.setString( argIdx++, Description );
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff createdBuff = unpackClusterResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredFullDomainName( createdBuff.getRequiredFullDomainName() );
				Buff.setRequiredDescription( createdBuff.getRequiredDescription() );
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

	protected static String S_sqlSelectClusterDistinctClassCode = null;

	public String getSqlSelectClusterDistinctClassCode() {
		if( S_sqlSelectClusterDistinctClassCode == null ) {
			S_sqlSelectClusterDistinctClassCode =
					"SELECT "
				+		"DISTINCT clus.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..clus AS clus ";
		}
		return( S_sqlSelectClusterDistinctClassCode );
	}

	protected static String S_sqlSelectClusterBuff = null;

	public String getSqlSelectClusterBuff() {
		if( S_sqlSelectClusterBuff == null ) {
			S_sqlSelectClusterBuff =
					"SELECT "
				+		"clus.id, "
				+		"clus.fulldomainname, "
				+		"clus.description, "
				+		"clus.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..clus AS clus ";
		}
		return( S_sqlSelectClusterBuff );
	}

	protected CFBamClusterBuff unpackClusterResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackClusterResultSetToBuff";
		int idxcol = 1;
		CFBamClusterBuff buff = schema.getFactoryCluster().newBuff();
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
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredFullDomainName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredDescription( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamClusterBuff readDerived( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClusterBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamClusterBuff lockDerived( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClusterBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamClusterBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamClusterBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamClusterBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamSybaseClusterTable.readDerivedByIdIdx() ";
		CFBamClusterBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				Id );
		return( buff );
	}

	public CFBamClusterBuff readDerivedByUDomainNameIdx( CFBamAuthorization Authorization,
		String FullDomainName )
	{
		final String S_ProcName = "CFBamSybaseClusterTable.readDerivedByUDomainNameIdx() ";
		CFBamClusterBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUDomainNameIdx( Authorization,
				FullDomainName );
		return( buff );
	}

	public CFBamClusterBuff readDerivedByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamSybaseClusterTable.readDerivedByUDescrIdx() ";
		CFBamClusterBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUDescrIdx( Authorization,
				Description );
		return( buff );
	}

	public CFBamClusterBuff readBuff( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
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
			long Id = PKey.getRequiredId();
			String sql = "exec sp_read_clus ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
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

	public CFBamClusterBuff lockBuff( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
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
			long Id = PKey.getRequiredId();
			String sql = "exec sp_lock_clus ?, ?, ?, ?, ?" + ", "
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
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
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

	public CFBamClusterBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_clus_all ?, ?, ?, ?, ?";
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
			List<CFBamClusterBuff> buffList = new LinkedList<CFBamClusterBuff>();
			while( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFBamClusterBuff[] retBuff = new CFBamClusterBuff[ buffList.size() ];
			Iterator<CFBamClusterBuff> iter = buffList.iterator();
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

	public CFBamClusterBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_clus_by_ididx ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
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

	public CFBamClusterBuff readBuffByUDomainNameIdx( CFBamAuthorization Authorization,
		String FullDomainName )
	{
		final String S_ProcName = "readBuffByUDomainNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_clus_by_udomainnameidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByUDomainNameIdx == null ) {
				stmtReadBuffByUDomainNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUDomainNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUDomainNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUDomainNameIdx.setString( argIdx++, FullDomainName );
			resultSet = stmtReadBuffByUDomainNameIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
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

	public CFBamClusterBuff readBuffByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "readBuffByUDescrIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_read_clus_by_udescridx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtReadBuffByUDescrIdx == null ) {
				stmtReadBuffByUDescrIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUDescrIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUDescrIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUDescrIdx.setString( argIdx++, Description );
			resultSet = stmtReadBuffByUDescrIdx.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
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

	public void updateCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		final String S_ProcName = "updateCluster";
		ResultSet resultSet = null;
		try {
			long Id = Buff.getRequiredId();
			String FullDomainName = Buff.getRequiredFullDomainName();
			String Description = Buff.getRequiredDescription();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_clus ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "CLUS" );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setString( argIdx++, FullDomainName );
			stmtUpdateByPKey.setString( argIdx++, Description );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFBamClusterBuff updatedBuff = unpackClusterResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredFullDomainName( updatedBuff.getRequiredFullDomainName() );
				Buff.setRequiredDescription( updatedBuff.getRequiredDescription() );
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

	public void deleteCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		final String S_ProcName = "deleteCluster";
		try {
			Connection cnx = schema.getCnx();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_clus ?, ?, ?, ?, ?" + ", "
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

	public void deleteClusterByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "deleteClusterByIdIdx";
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_clus ?, ?, ?, ?, ?" + ", "
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

	public void deleteClusterByIdIdx( CFBamAuthorization Authorization,
		CFBamClusterPKey argKey )
	{
		deleteClusterByIdIdx( Authorization,
			argKey.getRequiredId() );
	}

	public void deleteClusterByUDomainNameIdx( CFBamAuthorization Authorization,
		String FullDomainName )
	{
		final String S_ProcName = "deleteClusterByUDomainNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_clus_by_udomainnameidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByUDomainNameIdx== null ) {
				stmtDeleteByUDomainNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUDomainNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUDomainNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUDomainNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUDomainNameIdx.setString( argIdx++, FullDomainName );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUDomainNameIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUDomainNameIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUDomainNameIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUDomainNameIdx.getUpdateCount() ) {
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

	public void deleteClusterByUDomainNameIdx( CFBamAuthorization Authorization,
		CFBamClusterByUDomainNameIdxKey argKey )
	{
		deleteClusterByUDomainNameIdx( Authorization,
			argKey.getRequiredFullDomainName() );
	}

	public void deleteClusterByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "deleteClusterByUDescrIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_clus_by_udescridx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByUDescrIdx== null ) {
				stmtDeleteByUDescrIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUDescrIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUDescrIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUDescrIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUDescrIdx.setString( argIdx++, Description );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUDescrIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUDescrIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUDescrIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUDescrIdx.getUpdateCount() ) {
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

	public void deleteClusterByUDescrIdx( CFBamAuthorization Authorization,
		CFBamClusterByUDescrIdxKey argKey )
	{
		deleteClusterByUDescrIdx( Authorization,
			argKey.getRequiredDescription() );
	}

	public CFBamCursor openClusterCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectClusterBuff()
			+	"ORDER BY " 
			+		"clus.Id ASC";
		CFBamCursor cursor = new CFBamSybaseCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeClusterCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeClusterCursor",
				e );
		}
	}

	public CFBamClusterBuff nextClusterCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextClusterCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamClusterBuff buff = unpackClusterResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamClusterBuff prevClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClusterBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextClusterCursor( Cursor );
		}
		return( buff );
	}

	public CFBamClusterBuff firstClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClusterBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextClusterCursor( Cursor );
		}
		return( buff );
	}

	public CFBamClusterBuff lastClusterCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastClusterCursor" );
	}

	public CFBamClusterBuff nthClusterCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClusterBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextClusterCursor( Cursor );
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
		S_sqlSelectClusterDistinctClassCode = null;
		S_sqlSelectClusterBuff = null;

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
		if( stmtReadBuffByUDomainNameIdx != null ) {
			try {
				stmtReadBuffByUDomainNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUDomainNameIdx = null;
			}
		}
		if( stmtReadBuffByUDescrIdx != null ) {
			try {
				stmtReadBuffByUDescrIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUDescrIdx = null;
			}
		}
		if( stmtDeleteByUDomainNameIdx != null ) {
			try {
				stmtDeleteByUDomainNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUDomainNameIdx = null;
			}
		}
		if( stmtDeleteByUDescrIdx != null ) {
			try {
				stmtDeleteByUDescrIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUDescrIdx = null;
			}
		}
		if( stmtReadBuffByUDomainNameIdx != null ) {
			try {
				stmtReadBuffByUDomainNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUDomainNameIdx = null;
			}
		}
		if( stmtReadBuffByUDescrIdx != null ) {
			try {
				stmtReadBuffByUDescrIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtReadBuffByUDescrIdx = null;
			}
		}
	}
}
