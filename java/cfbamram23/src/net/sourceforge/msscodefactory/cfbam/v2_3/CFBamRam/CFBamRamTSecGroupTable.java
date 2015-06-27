
// Description: Java7 in-memory RAM DbIO implementation for TSecGroup.

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
 *	CFBamRamTSecGroupTable in-memory RAM DbIO implementation
 *	for TSecGroup.
 */
public class CFBamRamTSecGroupTable
	implements ICFBamTSecGroupTable
{
	private CFBamRamSchema schema;
	private Map< CFBamTSecGroupPKey,
				CFBamTSecGroupBuff > dictByPKey
		= new HashMap< CFBamTSecGroupPKey,
				CFBamTSecGroupBuff >();
	private Map< CFBamTSecGroupByTenantIdxKey,
				Map< CFBamTSecGroupPKey,
					CFBamTSecGroupBuff >> dictByTenantIdx
		= new HashMap< CFBamTSecGroupByTenantIdxKey,
				Map< CFBamTSecGroupPKey,
					CFBamTSecGroupBuff >>();
	private Map< CFBamTSecGroupByUNameIdxKey,
			CFBamTSecGroupBuff > dictByUNameIdx
		= new HashMap< CFBamTSecGroupByUNameIdxKey,
			CFBamTSecGroupBuff >();

	public CFBamRamTSecGroupTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGroup( CFBamAuthorization Authorization,
		CFBamTSecGroupBuff Buff )
	{
		final String S_ProcName = "createTSecGroup";
		CFBamTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( ((CFBamRamTenantTable)schema.getTableTenant()).nextTSecGroupIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGroupId( pkey.getRequiredTSecGroupId() );
		CFBamTSecGroupByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupByUNameIdxKey keyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGroupUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"TSecGroupTenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamTSecGroupPKey, CFBamTSecGroupBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamTSecGroupBuff readDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readDerived() ";
		CFBamTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupId( PKey.getRequiredTSecGroupId() );
		CFBamTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readDerived() ";
		CFBamTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupId( PKey.getRequiredTSecGroupId() );
		CFBamTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTSecGroup.readAllDerived() ";
		CFBamTSecGroupBuff[] retList = new CFBamTSecGroupBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTSecGroupBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTSecGroupBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readDerivedByTenantIdx() ";
		CFBamTSecGroupByTenantIdxKey key = schema.getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamTSecGroupBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamTSecGroupBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamTSecGroupBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdictTenantIdx
				= new HashMap< CFBamTSecGroupPKey, CFBamTSecGroupBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamTSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readDerivedByUNameIdx() ";
		CFBamTSecGroupByUNameIdxKey key = schema.getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );

		CFBamTSecGroupBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readDerivedByIdIdx() ";
		CFBamTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFBamTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff readBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readBuff() ";
		CFBamTSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readBuff() ";
		CFBamTSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readAllBuff() ";
		CFBamTSecGroupBuff buff;
		ArrayList<CFBamTSecGroupBuff> filteredList = new ArrayList<CFBamTSecGroupBuff>();
		CFBamTSecGroupBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupBuff[0] ) );
	}

	public CFBamTSecGroupBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readBuffByIdIdx() ";
		CFBamTSecGroupBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
			return( (CFBamTSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTSecGroupBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readBuffByTenantIdx() ";
		CFBamTSecGroupBuff buff;
		ArrayList<CFBamTSecGroupBuff> filteredList = new ArrayList<CFBamTSecGroupBuff>();
		CFBamTSecGroupBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
				filteredList.add( (CFBamTSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupBuff[0] ) );
	}

	public CFBamTSecGroupBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTSecGroup.readBuffByUNameIdx() ";
		CFBamTSecGroupBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
			return( (CFBamTSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTSecGroup( CFBamAuthorization Authorization,
		CFBamTSecGroupBuff Buff )
	{
		CFBamTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		CFBamTSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTSecGroup",
				"Existing record not found",
				"TSecGroup",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateTSecGroup",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamTSecGroupByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupByUNameIdxKey existingKeyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTSecGroupByUNameIdxKey newKeyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTSecGroup",
					"TSecGroupUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTSecGroup",
						"Container",
						"TSecGroupTenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamTSecGroupPKey, CFBamTSecGroupBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteTSecGroup( CFBamAuthorization Authorization,
		CFBamTSecGroupBuff Buff )
	{
		final String S_ProcName = "CFBamRamTSecGroupTable.deleteTSecGroup() ";
		CFBamTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		CFBamTSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTSecGroup",
				pkey );
		}
		CFBamTSecGroupByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupByUNameIdxKey keyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTSecGroupInclude().deleteTSecGroupIncludeByGroupIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredTSecGroupId() );
		schema.getTableTSecGroupMember().deleteTSecGroupMemberByGroupIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredTSecGroupId() );
		schema.getTableTSecGroupInclude().deleteTSecGroupIncludeByIncludeIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredTSecGroupId() );
		Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteTSecGroupByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFBamTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGroupByIdIdx( Authorization, key );
	}

	public void deleteTSecGroupByIdIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupPKey argKey )
	{
		CFBamTSecGroupBuff cur;
		LinkedList<CFBamTSecGroupBuff> matchSet = new LinkedList<CFBamTSecGroupBuff>();
		Iterator<CFBamTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void deleteTSecGroupByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamTSecGroupByTenantIdxKey key = schema.getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGroupByTenantIdx( Authorization, key );
	}

	public void deleteTSecGroupByTenantIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupByTenantIdxKey argKey )
	{
		CFBamTSecGroupBuff cur;
		LinkedList<CFBamTSecGroupBuff> matchSet = new LinkedList<CFBamTSecGroupBuff>();
		Iterator<CFBamTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void deleteTSecGroupByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		String argName )
	{
		CFBamTSecGroupByUNameIdxKey key = schema.getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteTSecGroupByUNameIdx( Authorization, key );
	}

	public void deleteTSecGroupByUNameIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupByUNameIdxKey argKey )
	{
		CFBamTSecGroupBuff cur;
		LinkedList<CFBamTSecGroupBuff> matchSet = new LinkedList<CFBamTSecGroupBuff>();
		Iterator<CFBamTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroup( Authorization, cur );
		}
	}

	public CFBamCursor openTSecGroupCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTSecGroupCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTSecGroupCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupByTenantIdxKey key = schema.getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupPKey, CFBamTSecGroupBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamTSecGroupCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupBuff >() );
		}
		return( cursor );
	}

	public void closeTSecGroupCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTSecGroupBuff nextTSecGroupCursor( CFBamCursor Cursor ) {
		CFBamRamTSecGroupCursor cursor = (CFBamRamTSecGroupCursor)Cursor;
		CFBamTSecGroupBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTSecGroupBuff prevTSecGroupCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTSecGroupBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupBuff firstTSecGroupCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTSecGroupBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupBuff lastTSecGroupCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTSecGroupCursor" );
	}

	public CFBamTSecGroupBuff nthTSecGroupCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTSecGroupBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
