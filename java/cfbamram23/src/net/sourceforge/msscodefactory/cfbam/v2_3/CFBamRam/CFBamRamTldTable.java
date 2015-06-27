
// Description: Java7 in-memory RAM DbIO implementation for Tld.

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
 *	CFBamRamTldTable in-memory RAM DbIO implementation
 *	for Tld.
 */
public class CFBamRamTldTable
	implements ICFBamTldTable
{
	private CFBamRamSchema schema;
	private Map< CFBamTldPKey,
				CFBamTldBuff > dictByPKey
		= new HashMap< CFBamTldPKey,
				CFBamTldBuff >();
	private Map< CFBamTldByTenantIdxKey,
				Map< CFBamTldPKey,
					CFBamTldBuff >> dictByTenantIdx
		= new HashMap< CFBamTldByTenantIdxKey,
				Map< CFBamTldPKey,
					CFBamTldBuff >>();
	private Map< CFBamTldByNameIdxKey,
			CFBamTldBuff > dictByNameIdx
		= new HashMap< CFBamTldByNameIdxKey,
			CFBamTldBuff >();

	public CFBamRamTldTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTld( CFBamAuthorization Authorization,
		CFBamTldBuff Buff )
	{
		final String S_ProcName = "createTld";
		CFBamTldPKey pkey = schema.getFactoryTld().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTldId( ((CFBamRamTenantTable)schema.getTableTenant()).nextTldIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTldId( pkey.getRequiredTldId() );
		CFBamTldByTenantIdxKey keyTenantIdx = schema.getFactoryTld().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTldByNameIdxKey keyNameIdx = schema.getFactoryTld().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TldNameIdx",
				keyNameIdx );
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
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamTldPKey, CFBamTldBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamTldPKey, CFBamTldBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamTldBuff readDerived( CFBamAuthorization Authorization,
		CFBamTldPKey PKey )
	{
		final String S_ProcName = "CFBamRamTld.readDerived() ";
		CFBamTldPKey key = schema.getFactoryTld().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTldId( PKey.getRequiredTldId() );
		CFBamTldBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTldPKey PKey )
	{
		final String S_ProcName = "CFBamRamTld.readDerived() ";
		CFBamTldPKey key = schema.getFactoryTld().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTldId( PKey.getRequiredTldId() );
		CFBamTldBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTld.readAllDerived() ";
		CFBamTldBuff[] retList = new CFBamTldBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTldBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTldBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTld.readDerivedByTenantIdx() ";
		CFBamTldByTenantIdxKey key = schema.getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamTldBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTldPKey, CFBamTldBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamTldBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamTldBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTldPKey, CFBamTldBuff > subdictTenantIdx
				= new HashMap< CFBamTldPKey, CFBamTldBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamTldBuff[0];
		}
		return( recArray );
	}

	public CFBamTldBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTld.readDerivedByNameIdx() ";
		CFBamTldByNameIdxKey key = schema.getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );

		CFBamTldBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId )
	{
		final String S_ProcName = "CFBamRamTld.readDerivedByIdIdx() ";
		CFBamTldPKey key = schema.getFactoryTld().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );

		CFBamTldBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff readBuff( CFBamAuthorization Authorization,
		CFBamTldPKey PKey )
	{
		final String S_ProcName = "CFBamRamTld.readBuff() ";
		CFBamTldBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GTld" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTldPKey PKey )
	{
		final String S_ProcName = "CFBamRamTld.readBuff() ";
		CFBamTldBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GTld" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTldBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTld.readAllBuff() ";
		CFBamTldBuff buff;
		ArrayList<CFBamTldBuff> filteredList = new ArrayList<CFBamTldBuff>();
		CFBamTldBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GTld" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTldBuff[0] ) );
	}

	public CFBamTldBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId )
	{
		final String S_ProcName = "CFBamRamTld.readBuffByIdIdx() ";
		CFBamTldBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TldId );
		if( ( buff != null ) && buff.getClassCode().equals( "GTld" ) ) {
			return( (CFBamTldBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTldBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTld.readBuffByTenantIdx() ";
		CFBamTldBuff buff;
		ArrayList<CFBamTldBuff> filteredList = new ArrayList<CFBamTldBuff>();
		CFBamTldBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GTld" ) ) {
				filteredList.add( (CFBamTldBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTldBuff[0] ) );
	}

	public CFBamTldBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTld.readBuffByNameIdx() ";
		CFBamTldBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "GTld" ) ) {
			return( (CFBamTldBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTld( CFBamAuthorization Authorization,
		CFBamTldBuff Buff )
	{
		CFBamTldPKey pkey = schema.getFactoryTld().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTldId( Buff.getRequiredTldId() );
		CFBamTldBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTld",
				"Existing record not found",
				"Tld",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateTld",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamTldByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTld().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTldByTenantIdxKey newKeyTenantIdx = schema.getFactoryTld().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTldByNameIdxKey existingKeyNameIdx = schema.getFactoryTld().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTldByNameIdxKey newKeyNameIdx = schema.getFactoryTld().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTld",
					"TldNameIdx",
					newKeyNameIdx );
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
						"updateTld",
						"Container",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamTldPKey, CFBamTldBuff > subdict;

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
			subdict = new HashMap< CFBamTldPKey, CFBamTldBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteTld( CFBamAuthorization Authorization,
		CFBamTldBuff Buff )
	{
		final String S_ProcName = "CFBamRamTldTable.deleteTld() ";
		CFBamTldPKey pkey = schema.getFactoryTld().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTldId( Buff.getRequiredTldId() );
		CFBamTldBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTld",
				pkey );
		}
		CFBamTldByTenantIdxKey keyTenantIdx = schema.getFactoryTld().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTldByNameIdxKey keyNameIdx = schema.getFactoryTld().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTopDomain().deleteTopDomainByTldIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredTldId() );
		Map< CFBamTldPKey, CFBamTldBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}

	public void deleteTldByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTldId )
	{
		CFBamTldPKey key = schema.getFactoryTld().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTldId( argTldId );
		deleteTldByIdIdx( Authorization, key );
	}

	public void deleteTldByIdIdx( CFBamAuthorization Authorization,
		CFBamTldPKey argKey )
	{
		CFBamTldBuff cur;
		LinkedList<CFBamTldBuff> matchSet = new LinkedList<CFBamTldBuff>();
		Iterator<CFBamTldBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTldBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTld( Authorization, cur );
		}
	}

	public void deleteTldByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamTldByTenantIdxKey key = schema.getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTldByTenantIdx( Authorization, key );
	}

	public void deleteTldByTenantIdx( CFBamAuthorization Authorization,
		CFBamTldByTenantIdxKey argKey )
	{
		CFBamTldBuff cur;
		LinkedList<CFBamTldBuff> matchSet = new LinkedList<CFBamTldBuff>();
		Iterator<CFBamTldBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTldBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTld( Authorization, cur );
		}
	}

	public void deleteTldByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		String argName )
	{
		CFBamTldByNameIdxKey key = schema.getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteTldByNameIdx( Authorization, key );
	}

	public void deleteTldByNameIdx( CFBamAuthorization Authorization,
		CFBamTldByNameIdxKey argKey )
	{
		CFBamTldBuff cur;
		LinkedList<CFBamTldBuff> matchSet = new LinkedList<CFBamTldBuff>();
		Iterator<CFBamTldBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTldBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTld( Authorization, cur );
		}
	}

	public CFBamCursor openTldCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTldCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTldCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamTldByTenantIdxKey key = schema.getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTldPKey, CFBamTldBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamTldCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamTldCursor( Authorization,
				schema,
				new ArrayList< CFBamTldBuff >() );
		}
		return( cursor );
	}

	public void closeTldCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTldBuff nextTldCursor( CFBamCursor Cursor ) {
		CFBamRamTldCursor cursor = (CFBamRamTldCursor)Cursor;
		CFBamTldBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTldBuff prevTldCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTldBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTldCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTldBuff firstTldCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTldBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTldCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTldBuff lastTldCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTldCursor" );
	}

	public CFBamTldBuff nthTldCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTldBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTldCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
