
// Description: Java7 in-memory RAM DbIO implementation for SecGroup.

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
 *	CFBamRamSecGroupTable in-memory RAM DbIO implementation
 *	for SecGroup.
 */
public class CFBamRamSecGroupTable
	implements ICFBamSecGroupTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecGroupPKey,
				CFBamSecGroupBuff > dictByPKey
		= new HashMap< CFBamSecGroupPKey,
				CFBamSecGroupBuff >();
	private Map< CFBamSecGroupByClusterIdxKey,
				Map< CFBamSecGroupPKey,
					CFBamSecGroupBuff >> dictByClusterIdx
		= new HashMap< CFBamSecGroupByClusterIdxKey,
				Map< CFBamSecGroupPKey,
					CFBamSecGroupBuff >>();
	private Map< CFBamSecGroupByUNameIdxKey,
			CFBamSecGroupBuff > dictByUNameIdx
		= new HashMap< CFBamSecGroupByUNameIdxKey,
			CFBamSecGroupBuff >();

	public CFBamRamSecGroupTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroup( CFBamAuthorization Authorization,
		CFBamSecGroupBuff Buff )
	{
		final String S_ProcName = "createSecGroup";
		CFBamSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecGroupIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupId( pkey.getRequiredSecGroupId() );
		CFBamSecGroupByClusterIdxKey keyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupByUNameIdxKey keyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupUNameIdx",
				keyUNameIdx );
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
						"SecGroupCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecGroupPKey, CFBamSecGroupBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamSecGroupBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroup.readDerived() ";
		CFBamSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupId( PKey.getRequiredSecGroupId() );
		CFBamSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroup.readDerived() ";
		CFBamSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupId( PKey.getRequiredSecGroupId() );
		CFBamSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecGroup.readAllDerived() ";
		CFBamSecGroupBuff[] retList = new CFBamSecGroupBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecGroupBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecGroupBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroup.readDerivedByClusterIdx() ";
		CFBamSecGroupByClusterIdxKey key = schema.getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecGroupBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecGroupBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecGroupBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdictClusterIdx
				= new HashMap< CFBamSecGroupPKey, CFBamSecGroupBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSecGroup.readDerivedByUNameIdx() ";
		CFBamSecGroupByUNameIdxKey key = schema.getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );

		CFBamSecGroupBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroup.readDerivedByIdIdx() ";
		CFBamSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFBamSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroup.readBuff() ";
		CFBamSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroup.readBuff() ";
		CFBamSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecGroup.readAllBuff() ";
		CFBamSecGroupBuff buff;
		ArrayList<CFBamSecGroupBuff> filteredList = new ArrayList<CFBamSecGroupBuff>();
		CFBamSecGroupBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupBuff[0] ) );
	}

	public CFBamSecGroupBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroup.readBuffByIdIdx() ";
		CFBamSecGroupBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
			return( (CFBamSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecGroupBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroup.readBuffByClusterIdx() ";
		CFBamSecGroupBuff buff;
		ArrayList<CFBamSecGroupBuff> filteredList = new ArrayList<CFBamSecGroupBuff>();
		CFBamSecGroupBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
				filteredList.add( (CFBamSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupBuff[0] ) );
	}

	public CFBamSecGroupBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSecGroup.readBuffByUNameIdx() ";
		CFBamSecGroupBuff buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
			return( (CFBamSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecGroup( CFBamAuthorization Authorization,
		CFBamSecGroupBuff Buff )
	{
		CFBamSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		CFBamSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecGroup",
				"Existing record not found",
				"SecGroup",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecGroup",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecGroupByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupByUNameIdxKey existingKeyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSecGroupByUNameIdxKey newKeyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecGroup",
					"SecGroupUNameIdx",
					newKeyUNameIdx );
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
						"updateSecGroup",
						"Container",
						"SecGroupCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdict;

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
			subdict = new HashMap< CFBamSecGroupPKey, CFBamSecGroupBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteSecGroup( CFBamAuthorization Authorization,
		CFBamSecGroupBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecGroupTable.deleteSecGroup() ";
		CFBamSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		CFBamSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecGroup",
				pkey );
		}
		CFBamSecGroupByClusterIdxKey keyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupByUNameIdxKey keyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableSecGroupInclude().deleteSecGroupIncludeByGroupIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredSecGroupId() );
		schema.getTableSecGroupMember().deleteSecGroupMemberByGroupIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredSecGroupId() );
		schema.getTableSecGroupInclude().deleteSecGroupIncludeByIncludeIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredSecGroupId() );
		schema.getTableSecGroupForm().deleteSecGroupFormByGroupIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredSecGroupId() );
		Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteSecGroupByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFBamSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupByIdIdx( Authorization, key );
	}

	public void deleteSecGroupByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupPKey argKey )
	{
		CFBamSecGroupBuff cur;
		LinkedList<CFBamSecGroupBuff> matchSet = new LinkedList<CFBamSecGroupBuff>();
		Iterator<CFBamSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroup( Authorization, cur );
		}
	}

	public void deleteSecGroupByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecGroupByClusterIdxKey key = schema.getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupByClusterIdxKey argKey )
	{
		CFBamSecGroupBuff cur;
		LinkedList<CFBamSecGroupBuff> matchSet = new LinkedList<CFBamSecGroupBuff>();
		Iterator<CFBamSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroup( Authorization, cur );
		}
	}

	public void deleteSecGroupByUNameIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argName )
	{
		CFBamSecGroupByUNameIdxKey key = schema.getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredName( argName );
		deleteSecGroupByUNameIdx( Authorization, key );
	}

	public void deleteSecGroupByUNameIdx( CFBamAuthorization Authorization,
		CFBamSecGroupByUNameIdxKey argKey )
	{
		CFBamSecGroupBuff cur;
		LinkedList<CFBamSecGroupBuff> matchSet = new LinkedList<CFBamSecGroupBuff>();
		Iterator<CFBamSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroup( Authorization, cur );
		}
	}

	public CFBamCursor openSecGroupCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecGroupCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecGroupCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecGroupByClusterIdxKey key = schema.getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupPKey, CFBamSecGroupBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecGroupCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupBuff >() );
		}
		return( cursor );
	}

	public void closeSecGroupCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecGroupBuff nextSecGroupCursor( CFBamCursor Cursor ) {
		CFBamRamSecGroupCursor cursor = (CFBamRamSecGroupCursor)Cursor;
		CFBamSecGroupBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecGroupBuff prevSecGroupCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecGroupBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupBuff firstSecGroupCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecGroupBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupBuff lastSecGroupCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecGroupCursor" );
	}

	public CFBamSecGroupBuff nthSecGroupCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecGroupBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
