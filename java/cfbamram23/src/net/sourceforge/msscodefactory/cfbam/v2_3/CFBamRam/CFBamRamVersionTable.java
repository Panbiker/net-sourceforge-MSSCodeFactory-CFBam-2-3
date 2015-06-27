
// Description: Java7 in-memory RAM DbIO implementation for Version.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamRam;

import java.sql.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamRam.*;

/*
 *	CFBamRamVersionTable in-memory RAM DbIO implementation
 *	for Version.
 */
public class CFBamRamVersionTable
	implements ICFBamVersionTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamVersionBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamVersionBuff >();

	public CFBamRamVersionTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createVersion( CFBamAuthorization Authorization,
		CFBamVersionBuff Buff )
	{
		final String S_ProcName = "createVersion";
		schema.getTableProjectBase().createProjectBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableProjectBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"ProjectBase",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamVersionBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamVersionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamVersionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamVersion.readAllDerived() ";
		CFBamVersionBuff[] retList = new CFBamVersionBuff[ dictByPKey.values().size() ];
		Iterator< CFBamVersionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamVersionBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByTenantIdx() ";
		CFBamDomainBaseBuff buffList[] = schema.getTableDomainBase().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamDomainBaseBuff buff;
			ArrayList<CFBamVersionBuff> filteredList = new ArrayList<CFBamVersionBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamVersionBuff ) ) {
					filteredList.add( (CFBamVersionBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamVersionBuff[0] ) );
		}
	}

	public CFBamVersionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamVersionBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamVersion.readBuff() ";
		CFBamVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "VERN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamVersionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamVersion.readBuff() ";
		CFBamVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "VERN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamVersionBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamVersion.readAllBuff() ";
		CFBamVersionBuff buff;
		ArrayList<CFBamVersionBuff> filteredList = new ArrayList<CFBamVersionBuff>();
		CFBamVersionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VERN" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamVersionBuff[0] ) );
	}

	public CFBamVersionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamVersionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamVersionBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamVersionBuff> filteredList = new ArrayList<CFBamVersionBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamVersionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamVersionBuff[0] ) );
	}

	public void updateVersion( CFBamAuthorization Authorization,
		CFBamVersionBuff Buff )
	{
		schema.getTableProjectBase().updateProjectBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateVersion",
				"Existing record not found",
				"Version",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableProjectBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateVersion",
						"Superclass",
						"SuperClass",
						"ProjectBase",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamVersionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteVersion( CFBamAuthorization Authorization,
		CFBamVersionBuff Buff )
	{
		final String S_ProcName = "CFBamRamVersionTable.deleteVersion() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteVersion",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteVersion",
				"Superclass",
				"SuperClass",
				"MajorVersion",
				pkey );
		}

		if( schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteVersion",
				"Superclass",
				"SuperClass",
				"MinorVersion",
				pkey );
		}

		// Delete is valid

		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamVersionBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableProjectBase().deleteProjectBase( Authorization,
			Buff );
	}

	public void deleteVersionByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteVersionByIdIdx( Authorization, key );
	}

	public void deleteVersionByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		final String S_ProcName = "deleteVersionByIdIdx";
		CFBamVersionBuff cur;
		LinkedList<CFBamVersionBuff> matchSet = new LinkedList<CFBamVersionBuff>();
		Iterator<CFBamVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VERN".equals( subClassCode ) ) {
				schema.getTableVersion().deleteVersion( Authorization, cur );
			}
			else if( "MJVR".equals( subClassCode ) ) {
				schema.getTableMajorVersion().deleteMajorVersion( Authorization, (CFBamMajorVersionBuff)cur );
			}
			else if( "MNVR".equals( subClassCode ) ) {
				schema.getTableMinorVersion().deleteMinorVersion( Authorization, (CFBamMinorVersionBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Version must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteVersionByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteVersionByTenantIdx( Authorization, key );
	}

	public void deleteVersionByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteVersionByTenantIdx";
		CFBamVersionBuff cur;
		LinkedList<CFBamVersionBuff> matchSet = new LinkedList<CFBamVersionBuff>();
		Iterator<CFBamVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VERN".equals( subClassCode ) ) {
				schema.getTableVersion().deleteVersion( Authorization, cur );
			}
			else if( "MJVR".equals( subClassCode ) ) {
				schema.getTableMajorVersion().deleteMajorVersion( Authorization, (CFBamMajorVersionBuff)cur );
			}
			else if( "MNVR".equals( subClassCode ) ) {
				schema.getTableMinorVersion().deleteMinorVersion( Authorization, (CFBamMinorVersionBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Version must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openVersionCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamVersionCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeVersionCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamVersionBuff nextVersionCursor( CFBamCursor Cursor ) {
		CFBamRamVersionCursor cursor = (CFBamRamVersionCursor)Cursor;
		CFBamVersionBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamVersionBuff prevVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamVersionBuff firstVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamVersionBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamVersionBuff lastVersionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastVersionCursor" );
	}

	public CFBamVersionBuff nthVersionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextVersionCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
