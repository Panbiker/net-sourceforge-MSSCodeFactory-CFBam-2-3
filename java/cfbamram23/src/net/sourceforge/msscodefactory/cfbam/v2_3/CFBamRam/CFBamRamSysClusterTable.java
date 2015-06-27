
// Description: Java7 in-memory RAM DbIO implementation for SysCluster.

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
 *	CFBamRamSysClusterTable in-memory RAM DbIO implementation
 *	for SysCluster.
 */
public class CFBamRamSysClusterTable
	implements ICFBamSysClusterTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSysClusterPKey,
				CFBamSysClusterBuff > dictByPKey
		= new HashMap< CFBamSysClusterPKey,
				CFBamSysClusterBuff >();
	private Map< CFBamSysClusterByClusterIdxKey,
				Map< CFBamSysClusterPKey,
					CFBamSysClusterBuff >> dictByClusterIdx
		= new HashMap< CFBamSysClusterByClusterIdxKey,
				Map< CFBamSysClusterPKey,
					CFBamSysClusterBuff >>();

	public CFBamRamSysClusterTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSysCluster( CFBamAuthorization Authorization,
		CFBamSysClusterBuff Buff )
	{
		final String S_ProcName = "createSysCluster";
		CFBamSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		Buff.setRequiredSingletonId( pkey.getRequiredSingletonId() );
		CFBamSysClusterByClusterIdxKey keyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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
						"SysClusterCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSysClusterPKey, CFBamSysClusterBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

	}

	public CFBamSysClusterBuff readDerived( CFBamAuthorization Authorization,
		CFBamSysClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamSysCluster.readDerived() ";
		CFBamSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( PKey.getRequiredSingletonId() );
		CFBamSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSysClusterBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSysClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamSysCluster.readDerived() ";
		CFBamSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( PKey.getRequiredSingletonId() );
		CFBamSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSysClusterBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSysCluster.readAllDerived() ";
		CFBamSysClusterBuff[] retList = new CFBamSysClusterBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSysClusterBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSysClusterBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSysCluster.readDerivedByClusterIdx() ";
		CFBamSysClusterByClusterIdxKey key = schema.getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSysClusterBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSysClusterBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSysClusterBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdictClusterIdx
				= new HashMap< CFBamSysClusterPKey, CFBamSysClusterBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSysClusterBuff[0];
		}
		return( recArray );
	}

	public CFBamSysClusterBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		int SingletonId )
	{
		final String S_ProcName = "CFBamRamSysCluster.readDerivedByIdIdx() ";
		CFBamSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( SingletonId );

		CFBamSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSysClusterBuff readBuff( CFBamAuthorization Authorization,
		CFBamSysClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamSysCluster.readBuff() ";
		CFBamSysClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SYSC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSysClusterBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSysClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamSysCluster.readBuff() ";
		CFBamSysClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SYSC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSysClusterBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSysCluster.readAllBuff() ";
		CFBamSysClusterBuff buff;
		ArrayList<CFBamSysClusterBuff> filteredList = new ArrayList<CFBamSysClusterBuff>();
		CFBamSysClusterBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSysClusterBuff[0] ) );
	}

	public CFBamSysClusterBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		int SingletonId )
	{
		final String S_ProcName = "CFBamRamSysCluster.readBuffByIdIdx() ";
		CFBamSysClusterBuff buff = readDerivedByIdIdx( Authorization,
			SingletonId );
		if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
			return( (CFBamSysClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSysClusterBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSysCluster.readBuffByClusterIdx() ";
		CFBamSysClusterBuff buff;
		ArrayList<CFBamSysClusterBuff> filteredList = new ArrayList<CFBamSysClusterBuff>();
		CFBamSysClusterBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
				filteredList.add( (CFBamSysClusterBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSysClusterBuff[0] ) );
	}

	public void updateSysCluster( CFBamAuthorization Authorization,
		CFBamSysClusterBuff Buff )
	{
		CFBamSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		CFBamSysClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSysCluster",
				"Existing record not found",
				"SysCluster",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSysCluster",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSysClusterByClusterIdxKey existingKeyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSysClusterByClusterIdxKey newKeyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSysCluster",
						"Container",
						"SysClusterCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdict;

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
			subdict = new HashMap< CFBamSysClusterPKey, CFBamSysClusterBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSysCluster( CFBamAuthorization Authorization,
		CFBamSysClusterBuff Buff )
	{
		final String S_ProcName = "CFBamRamSysClusterTable.deleteSysCluster() ";
		CFBamSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		CFBamSysClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSysCluster",
				pkey );
		}
		CFBamSysClusterByClusterIdxKey keyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

	}

	public void deleteSysClusterByIdIdx( CFBamAuthorization Authorization,
		int argSingletonId )
	{
		CFBamSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( argSingletonId );
		deleteSysClusterByIdIdx( Authorization, key );
	}

	public void deleteSysClusterByIdIdx( CFBamAuthorization Authorization,
		CFBamSysClusterPKey argKey )
	{
		CFBamSysClusterBuff cur;
		LinkedList<CFBamSysClusterBuff> matchSet = new LinkedList<CFBamSysClusterBuff>();
		Iterator<CFBamSysClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSysClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSysCluster( Authorization, cur );
		}
	}

	public void deleteSysClusterByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSysClusterByClusterIdxKey key = schema.getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSysClusterByClusterIdx( Authorization, key );
	}

	public void deleteSysClusterByClusterIdx( CFBamAuthorization Authorization,
		CFBamSysClusterByClusterIdxKey argKey )
	{
		CFBamSysClusterBuff cur;
		LinkedList<CFBamSysClusterBuff> matchSet = new LinkedList<CFBamSysClusterBuff>();
		Iterator<CFBamSysClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSysClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSysCluster( Authorization, cur );
		}
	}

	public CFBamCursor openSysClusterCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSysClusterCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSysClusterCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSysClusterByClusterIdxKey key = schema.getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSysClusterPKey, CFBamSysClusterBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSysClusterCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSysClusterCursor( Authorization,
				schema,
				new ArrayList< CFBamSysClusterBuff >() );
		}
		return( cursor );
	}

	public void closeSysClusterCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSysClusterBuff nextSysClusterCursor( CFBamCursor Cursor ) {
		CFBamRamSysClusterCursor cursor = (CFBamRamSysClusterCursor)Cursor;
		CFBamSysClusterBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSysClusterBuff prevSysClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSysClusterBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSysClusterCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSysClusterBuff firstSysClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSysClusterBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSysClusterCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSysClusterBuff lastSysClusterCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSysClusterCursor" );
	}

	public CFBamSysClusterBuff nthSysClusterCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSysClusterBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSysClusterCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
