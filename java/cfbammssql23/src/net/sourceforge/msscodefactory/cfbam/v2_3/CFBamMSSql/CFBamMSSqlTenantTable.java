// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for Tenant.

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
 *	CFBamMSSqlTenantTable PostgreSQL Jdbc DbIO implementation
 *	for Tenant.
 */
public class CFBamMSSqlTenantTable
	implements ICFBamTenantTable
{
	private CFBamMSSqlSchema schema;
	protected PreparedStatement stmtSelectNextTSecGroupIdGen = null;
	protected PreparedStatement stmtSelectNextTSecGroupMemberIdGen = null;
	protected PreparedStatement stmtSelectNextTSecGroupIncludeIdGen = null;
	protected PreparedStatement stmtSelectNextTldIdGen = null;
	protected PreparedStatement stmtSelectNextDomainIdGen = null;
	protected PreparedStatement stmtSelectNextScopeIdGen = null;
	protected PreparedStatement stmtSelectNextIndexColIdGen = null;
	protected PreparedStatement stmtSelectNextLicenseIdGen = null;
	protected PreparedStatement stmtSelectNextRelationColIdGen = null;
	protected PreparedStatement stmtSelectNextValueIdGen = null;
	protected PreparedStatement stmtSelectNextEnumTagIdGen = null;
	protected PreparedStatement stmtSelectNextChainIdGen = null;
	protected PreparedStatement stmtSelectNextParamIdGen = null;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByClusterIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByClusterIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;

	public CFBamMSSqlTenantTable( CFBamMSSqlSchema argSchema ) {
		schema = argSchema;
	}

	public int nextTSecGroupIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGroupIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		int nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_tsecgroupidgen "
			+		"?";
			if( stmtSelectNextTSecGroupIdGen == null ) {
				stmtSelectNextTSecGroupIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextTSecGroupIdGen.setLong( argIdx++, Id );
			stmtSelectNextTSecGroupIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTSecGroupIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTSecGroupIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTSecGroupIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public int nextTSecGroupIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		int retval = nextTSecGroupIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTSecGroupMemberIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGroupMemberIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_tsecgroupmemberidgen "
			+		"?";
			if( stmtSelectNextTSecGroupMemberIdGen == null ) {
				stmtSelectNextTSecGroupMemberIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextTSecGroupMemberIdGen.setLong( argIdx++, Id );
			stmtSelectNextTSecGroupMemberIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTSecGroupMemberIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTSecGroupMemberIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTSecGroupMemberIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextTSecGroupMemberIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTSecGroupMemberIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGroupIncludeIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_tsecgroupincludeidgen "
			+		"?";
			if( stmtSelectNextTSecGroupIncludeIdGen == null ) {
				stmtSelectNextTSecGroupIncludeIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextTSecGroupIncludeIdGen.setLong( argIdx++, Id );
			stmtSelectNextTSecGroupIncludeIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTSecGroupIncludeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTSecGroupIncludeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTSecGroupIncludeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextTSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTSecGroupIncludeIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTldIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextTldIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_tldidgen "
			+		"?";
			if( stmtSelectNextTldIdGen == null ) {
				stmtSelectNextTldIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextTldIdGen.setLong( argIdx++, Id );
			stmtSelectNextTldIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTldIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTldIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTldIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextTldIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTldIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextDomainIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextDomainIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_domainidgen "
			+		"?";
			if( stmtSelectNextDomainIdGen == null ) {
				stmtSelectNextDomainIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextDomainIdGen.setLong( argIdx++, Id );
			stmtSelectNextDomainIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextDomainIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextDomainIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextDomainIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextDomainIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextDomainIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextScopeIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextScopeIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_scopeidgen "
			+		"?";
			if( stmtSelectNextScopeIdGen == null ) {
				stmtSelectNextScopeIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextScopeIdGen.setLong( argIdx++, Id );
			stmtSelectNextScopeIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextScopeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextScopeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextScopeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextScopeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextScopeIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextIndexColIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextIndexColIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_indexcolidgen "
			+		"?";
			if( stmtSelectNextIndexColIdGen == null ) {
				stmtSelectNextIndexColIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextIndexColIdGen.setLong( argIdx++, Id );
			stmtSelectNextIndexColIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextIndexColIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextIndexColIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextIndexColIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextIndexColIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextIndexColIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextLicenseIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextLicenseIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_licenseidgen "
			+		"?";
			if( stmtSelectNextLicenseIdGen == null ) {
				stmtSelectNextLicenseIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextLicenseIdGen.setLong( argIdx++, Id );
			stmtSelectNextLicenseIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextLicenseIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextLicenseIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextLicenseIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextLicenseIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextLicenseIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextRelationColIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextRelationColIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_relationcolidgen "
			+		"?";
			if( stmtSelectNextRelationColIdGen == null ) {
				stmtSelectNextRelationColIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextRelationColIdGen.setLong( argIdx++, Id );
			stmtSelectNextRelationColIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextRelationColIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextRelationColIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextRelationColIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextRelationColIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextRelationColIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextValueIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextValueIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_valueidgen "
			+		"?";
			if( stmtSelectNextValueIdGen == null ) {
				stmtSelectNextValueIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextValueIdGen.setLong( argIdx++, Id );
			stmtSelectNextValueIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextValueIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextValueIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextValueIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextValueIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextValueIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextEnumTagIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextEnumTagIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_enumtagidgen "
			+		"?";
			if( stmtSelectNextEnumTagIdGen == null ) {
				stmtSelectNextEnumTagIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextEnumTagIdGen.setLong( argIdx++, Id );
			stmtSelectNextEnumTagIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextEnumTagIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextEnumTagIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextEnumTagIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextEnumTagIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextEnumTagIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextChainIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextChainIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_chainidgen "
			+		"?";
			if( stmtSelectNextChainIdGen == null ) {
				stmtSelectNextChainIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextChainIdGen.setLong( argIdx++, Id );
			stmtSelectNextChainIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextChainIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextChainIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextChainIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextChainIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextChainIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextParamIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "nextParamIdGen";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
		long nextId = -1;
		ResultSet resultSet = null;
		try {
			String sql = "exec sp_selnext_tenant_paramidgen "
			+		"?";
			if( stmtSelectNextParamIdGen == null ) {
				stmtSelectNextParamIdGen = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtSelectNextParamIdGen.setLong( argIdx++, Id );
			stmtSelectNextParamIdGen.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextParamIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextParamIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextParamIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
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

	public long nextParamIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextParamIdGen( Authorization, pkey );
		return( retval );
	}

	public void createTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		final String S_ProcName = "createTenant";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			String TenantName = Buff.getRequiredTenantName();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_create_tenant ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setString( argIdx++, "TENT" );
			stmtCreateByPKey.setLong( argIdx++, ClusterId );
			stmtCreateByPKey.setString( argIdx++, TenantName );
			stmtCreateByPKey.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtCreateByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtCreateByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtCreateByPKey.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				CFBamTenantBuff createdBuff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredClusterId( createdBuff.getRequiredClusterId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredTenantName( createdBuff.getRequiredTenantName() );
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

	protected static String S_sqlSelectTenantDistinctClassCode = null;

	public String getSqlSelectTenantDistinctClassCode() {
		if( S_sqlSelectTenantDistinctClassCode == null ) {
			S_sqlSelectTenantDistinctClassCode =
					"SELECT "
				+		"DISTINCT tent.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..tenant AS tent ";
		}
		return( S_sqlSelectTenantDistinctClassCode );
	}

	protected static String S_sqlSelectTenantBuff = null;

	public String getSqlSelectTenantBuff() {
		if( S_sqlSelectTenantBuff == null ) {
			S_sqlSelectTenantBuff =
					"SELECT "
				+		"tent.id, "
				+		"tent.clusterid, "
				+		"tent.tenantname, "
				+		"tent.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..tenant AS tent ";
		}
		return( S_sqlSelectTenantBuff );
	}

	protected CFBamTenantBuff unpackTenantResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackTenantResultSetToBuff";
		int idxcol = 1;
		CFBamTenantBuff buff = schema.getFactoryTenant().newBuff();
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
		buff.setRequiredClusterId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredTenantName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamTenantBuff readDerived( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTenantBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTenantBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTenantBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTenantBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamTenantBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamTenantBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamMSSqlTenantTable.readDerivedByIdIdx() ";
		CFBamTenantBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				Id );
		return( buff );
	}

	public CFBamTenantBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readDerivedByClusterIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTenantBuff[] buffList = readBuffByClusterIdx( Authorization,
				ClusterId );
		return( buffList );

	}

	public CFBamTenantBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFBamMSSqlTenantTable.readDerivedByUNameIdx() ";
		CFBamTenantBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				ClusterId,
				TenantName );
		return( buff );
	}

	public CFBamTenantBuff readBuff( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
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
			String sql = "{ call sp_read_tenant( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
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

	public CFBamTenantBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
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
			String sql = "{ call sp_lock_tenant( ?, ?, ?, ?, ?" + ", "
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
				CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
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

	public CFBamTenantBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tenant_all( ?, ?, ?, ?, ? ) }";
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
			List<CFBamTenantBuff> buffList = new LinkedList<CFBamTenantBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTenantBuff[] retBuff = new CFBamTenantBuff[ buffList.size() ];
			Iterator<CFBamTenantBuff> iter = buffList.iterator();
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

	public CFBamTenantBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tenant_by_ididx( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
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

	public CFBamTenantBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readBuffByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tenant_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByClusterIdx == null ) {
				stmtReadBuffByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ClusterId );
			resultSet = stmtReadBuffByClusterIdx.executeQuery();
			List<CFBamTenantBuff> buffList = new LinkedList<CFBamTenantBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTenantBuff[] retBuff = new CFBamTenantBuff[ buffList.size() ];
			Iterator<CFBamTenantBuff> iter = buffList.iterator();
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

	public CFBamTenantBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tenant_by_unameidx( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByUNameIdx.setString( argIdx++, TenantName );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
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

	public void updateTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		final String S_ProcName = "updateTenant";
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			long Id = Buff.getRequiredId();
			String TenantName = Buff.getRequiredTenantName();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			String sql =
				"exec sp_update_tenant ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setString( argIdx++, "TENT" );
			stmtUpdateByPKey.setLong( argIdx++, ClusterId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setString( argIdx++, TenantName );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtUpdateByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtUpdateByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtUpdateByPKey.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				CFBamTenantBuff updatedBuff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredClusterId( updatedBuff.getRequiredClusterId() );
				Buff.setRequiredTenantName( updatedBuff.getRequiredTenantName() );
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

	public void deleteTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		final String S_ProcName = "deleteTenant";
		try {
			Connection cnx = schema.getCnx();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_tenant ?, ?, ?, ?, ?" + ", "
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

	public void deleteTenantByIdIdx( CFBamAuthorization Authorization,
		long argId )
	{
		final String S_ProcName = "deleteTenantByIdIdx";
		// MSS TODO WORKING
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName );
	}

	public void deleteTenantByIdIdx( CFBamAuthorization Authorization,
		CFBamTenantPKey argKey )
	{
		deleteTenantByIdIdx( Authorization,
			argKey.getRequiredId() );
	}

	public void deleteTenantByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "deleteTenantByClusterIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tenant_by_clusteridx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByClusterIdx== null ) {
				stmtDeleteByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByClusterIdx.setLong( argIdx++, argClusterId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByClusterIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByClusterIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByClusterIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByClusterIdx.getUpdateCount() ) {
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

	public void deleteTenantByClusterIdx( CFBamAuthorization Authorization,
		CFBamTenantByClusterIdxKey argKey )
	{
		deleteTenantByClusterIdx( Authorization,
			argKey.getRequiredClusterId() );
	}

	public void deleteTenantByUNameIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argTenantName )
	{
		final String S_ProcName = "deleteTenantByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tenant_by_unameidx ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByUNameIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByUNameIdx.setString( argIdx++, argTenantName );
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

	public void deleteTenantByUNameIdx( CFBamAuthorization Authorization,
		CFBamTenantByUNameIdxKey argKey )
	{
		deleteTenantByUNameIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredTenantName() );
	}

	public CFBamCursor openTenantCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectTenantBuff()
			+	"ORDER BY " 
			+		"tent.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTenantCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		String sql = getSqlSelectTenantBuff()
			+	" WHERE "
				+		"tent.clusterid = " + Long.toString( ClusterId ) + " "
			+	"ORDER BY " 
			+		"tent.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeTenantCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeTenantCursor",
				e );
		}
	}

	public CFBamTenantBuff nextTenantCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextTenantCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamTenantBuff prevTenantCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTenantBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTenantCursor( Cursor );
		}
		return( buff );
	}

	public CFBamTenantBuff firstTenantCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTenantBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTenantCursor( Cursor );
		}
		return( buff );
	}

	public CFBamTenantBuff lastTenantCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastTenantCursor" );
	}

	public CFBamTenantBuff nthTenantCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTenantBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTenantCursor( Cursor );
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
		S_sqlSelectTenantDistinctClassCode = null;
		S_sqlSelectTenantBuff = null;
		if( stmtSelectNextTSecGroupIdGen != null ) {
			try {
				stmtSelectNextTSecGroupIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGroupIdGen = null;
		}
		if( stmtSelectNextTSecGroupMemberIdGen != null ) {
			try {
				stmtSelectNextTSecGroupMemberIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGroupMemberIdGen = null;
		}
		if( stmtSelectNextTSecGroupIncludeIdGen != null ) {
			try {
				stmtSelectNextTSecGroupIncludeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGroupIncludeIdGen = null;
		}
		if( stmtSelectNextTldIdGen != null ) {
			try {
				stmtSelectNextTldIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTldIdGen = null;
		}
		if( stmtSelectNextDomainIdGen != null ) {
			try {
				stmtSelectNextDomainIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextDomainIdGen = null;
		}
		if( stmtSelectNextScopeIdGen != null ) {
			try {
				stmtSelectNextScopeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextScopeIdGen = null;
		}
		if( stmtSelectNextIndexColIdGen != null ) {
			try {
				stmtSelectNextIndexColIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextIndexColIdGen = null;
		}
		if( stmtSelectNextLicenseIdGen != null ) {
			try {
				stmtSelectNextLicenseIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextLicenseIdGen = null;
		}
		if( stmtSelectNextRelationColIdGen != null ) {
			try {
				stmtSelectNextRelationColIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextRelationColIdGen = null;
		}
		if( stmtSelectNextValueIdGen != null ) {
			try {
				stmtSelectNextValueIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextValueIdGen = null;
		}
		if( stmtSelectNextEnumTagIdGen != null ) {
			try {
				stmtSelectNextEnumTagIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextEnumTagIdGen = null;
		}
		if( stmtSelectNextChainIdGen != null ) {
			try {
				stmtSelectNextChainIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextChainIdGen = null;
		}
		if( stmtSelectNextParamIdGen != null ) {
			try {
				stmtSelectNextParamIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextParamIdGen = null;
		}
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
		if( stmtDeleteByClusterIdx != null ) {
			try {
				stmtDeleteByClusterIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByClusterIdx = null;
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
		if( stmtReadBuffByClusterIdx != null ) {
			try {
				stmtReadBuffByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByClusterIdx = null;
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
