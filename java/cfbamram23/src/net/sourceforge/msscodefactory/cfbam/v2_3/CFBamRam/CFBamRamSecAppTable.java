
// Description: Java7 in-memory RAM DbIO implementation for SecApp.

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
 *	CFBamRamSecAppTable in-memory RAM DbIO implementation
 *	for SecApp.
 */
public class CFBamRamSecAppTable
	implements ICFBamSecAppTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecAppPKey,
				CFBamSecAppBuff > dictByPKey
		= new HashMap< CFBamSecAppPKey,
				CFBamSecAppBuff >();
	private Map< CFBamSecAppByClusterIdxKey,
				Map< CFBamSecAppPKey,
					CFBamSecAppBuff >> dictByClusterIdx
		= new HashMap< CFBamSecAppByClusterIdxKey,
				Map< CFBamSecAppPKey,
					CFBamSecAppBuff >>();
	private Map< CFBamSecAppByUJEEMountIdxKey,
			CFBamSecAppBuff > dictByUJEEMountIdx
		= new HashMap< CFBamSecAppByUJEEMountIdxKey,
			CFBamSecAppBuff >();

	public CFBamRamSecAppTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecApp( CFBamAuthorization Authorization,
		CFBamSecAppBuff Buff )
	{
		final String S_ProcName = "createSecApp";
		CFBamSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecAppIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecAppId( pkey.getRequiredSecAppId() );
		CFBamSecAppByClusterIdxKey keyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		keyUJEEMountIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUJEEMountIdx.setRequiredJEEMountName( Buff.getRequiredJEEMountName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUJEEMountIdx.containsKey( keyUJEEMountIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecAppUJEEMountIdx",
				keyUJEEMountIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecAppCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecAppPKey, CFBamSecAppBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecAppPKey, CFBamSecAppBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUJEEMountIdx.put( keyUJEEMountIdx, Buff );

	}

	public CFBamSecAppBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecAppPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecApp.readDerived() ";
		CFBamSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecAppId( PKey.getRequiredSecAppId() );
		CFBamSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecAppPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecApp.readDerived() ";
		CFBamSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecAppId( PKey.getRequiredSecAppId() );
		CFBamSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecApp.readAllDerived() ";
		CFBamSecAppBuff[] retList = new CFBamSecAppBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecAppBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecAppBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecApp.readDerivedByClusterIdx() ";
		CFBamSecAppByClusterIdxKey key = schema.getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecAppBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecAppPKey, CFBamSecAppBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecAppBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecAppBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecAppPKey, CFBamSecAppBuff > subdictClusterIdx
				= new HashMap< CFBamSecAppPKey, CFBamSecAppBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecAppBuff[0];
		}
		return( recArray );
	}

	public CFBamSecAppBuff readDerivedByUJEEMountIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String JEEMountName )
	{
		final String S_ProcName = "CFBamRamSecApp.readDerivedByUJEEMountIdx() ";
		CFBamSecAppByUJEEMountIdxKey key = schema.getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );

		CFBamSecAppBuff buff;
		if( dictByUJEEMountIdx.containsKey( key ) ) {
			buff = dictByUJEEMountIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecApp.readDerivedByIdIdx() ";
		CFBamSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFBamSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecAppPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecApp.readBuff() ";
		CFBamSecAppBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SAPP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecAppPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecApp.readBuff() ";
		CFBamSecAppBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SAPP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecAppBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecApp.readAllBuff() ";
		CFBamSecAppBuff buff;
		ArrayList<CFBamSecAppBuff> filteredList = new ArrayList<CFBamSecAppBuff>();
		CFBamSecAppBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecAppBuff[0] ) );
	}

	public CFBamSecAppBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecApp.readBuffByIdIdx() ";
		CFBamSecAppBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecAppId );
		if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
			return( (CFBamSecAppBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecAppBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecApp.readBuffByClusterIdx() ";
		CFBamSecAppBuff buff;
		ArrayList<CFBamSecAppBuff> filteredList = new ArrayList<CFBamSecAppBuff>();
		CFBamSecAppBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
				filteredList.add( (CFBamSecAppBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecAppBuff[0] ) );
	}

	public CFBamSecAppBuff readBuffByUJEEMountIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String JEEMountName )
	{
		final String S_ProcName = "CFBamRamSecApp.readBuffByUJEEMountIdx() ";
		CFBamSecAppBuff buff = readDerivedByUJEEMountIdx( Authorization,
			ClusterId,
			JEEMountName );
		if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
			return( (CFBamSecAppBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecApp( CFBamAuthorization Authorization,
		CFBamSecAppBuff Buff )
	{
		CFBamSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		CFBamSecAppBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecApp",
				"Existing record not found",
				"SecApp",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecApp",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecAppByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecAppByClusterIdxKey newKeyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecAppByUJEEMountIdxKey existingKeyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		existingKeyUJEEMountIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUJEEMountIdx.setRequiredJEEMountName( existing.getRequiredJEEMountName() );

		CFBamSecAppByUJEEMountIdxKey newKeyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		newKeyUJEEMountIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUJEEMountIdx.setRequiredJEEMountName( Buff.getRequiredJEEMountName() );

		// Check unique indexes

		if( ! existingKeyUJEEMountIdx.equals( newKeyUJEEMountIdx ) ) {
			if( dictByUJEEMountIdx.containsKey( newKeyUJEEMountIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecApp",
					"SecAppUJEEMountIdx",
					newKeyUJEEMountIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecApp",
						"Container",
						"SecAppCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecAppPKey, CFBamSecAppBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFBamSecAppPKey, CFBamSecAppBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUJEEMountIdx.remove( existingKeyUJEEMountIdx );
		dictByUJEEMountIdx.put( newKeyUJEEMountIdx, Buff );

	}

	public void deleteSecApp( CFBamAuthorization Authorization,
		CFBamSecAppBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecAppTable.deleteSecApp() ";
		CFBamSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		CFBamSecAppBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecApp",
				pkey );
		}
		CFBamSecAppByClusterIdxKey keyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		keyUJEEMountIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUJEEMountIdx.setRequiredJEEMountName( existing.getRequiredJEEMountName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableSecForm().deleteSecFormBySecAppIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredSecAppId() );
		Map< CFBamSecAppPKey, CFBamSecAppBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUJEEMountIdx.remove( keyUJEEMountIdx );

	}

	public void deleteSecAppByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFBamSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecAppByIdIdx( Authorization, key );
	}

	public void deleteSecAppByIdIdx( CFBamAuthorization Authorization,
		CFBamSecAppPKey argKey )
	{
		CFBamSecAppBuff cur;
		LinkedList<CFBamSecAppBuff> matchSet = new LinkedList<CFBamSecAppBuff>();
		Iterator<CFBamSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecApp( Authorization, cur );
		}
	}

	public void deleteSecAppByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecAppByClusterIdxKey key = schema.getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecAppByClusterIdx( Authorization, key );
	}

	public void deleteSecAppByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecAppByClusterIdxKey argKey )
	{
		CFBamSecAppBuff cur;
		LinkedList<CFBamSecAppBuff> matchSet = new LinkedList<CFBamSecAppBuff>();
		Iterator<CFBamSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecApp( Authorization, cur );
		}
	}

	public void deleteSecAppByUJEEMountIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argJEEMountName )
	{
		CFBamSecAppByUJEEMountIdxKey key = schema.getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredJEEMountName( argJEEMountName );
		deleteSecAppByUJEEMountIdx( Authorization, key );
	}

	public void deleteSecAppByUJEEMountIdx( CFBamAuthorization Authorization,
		CFBamSecAppByUJEEMountIdxKey argKey )
	{
		CFBamSecAppBuff cur;
		LinkedList<CFBamSecAppBuff> matchSet = new LinkedList<CFBamSecAppBuff>();
		Iterator<CFBamSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecApp( Authorization, cur );
		}
	}

	public CFBamCursor openSecAppCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecAppCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecAppCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecAppByClusterIdxKey key = schema.getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecAppPKey, CFBamSecAppBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecAppCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecAppCursor( Authorization,
				schema,
				new ArrayList< CFBamSecAppBuff >() );
		}
		return( cursor );
	}

	public void closeSecAppCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecAppBuff nextSecAppCursor( CFBamCursor Cursor ) {
		CFBamRamSecAppCursor cursor = (CFBamRamSecAppCursor)Cursor;
		CFBamSecAppBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecAppBuff prevSecAppCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecAppBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecAppCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecAppBuff firstSecAppCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecAppBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecAppCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecAppBuff lastSecAppCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecAppCursor" );
	}

	public CFBamSecAppBuff nthSecAppCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecAppBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecAppCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
