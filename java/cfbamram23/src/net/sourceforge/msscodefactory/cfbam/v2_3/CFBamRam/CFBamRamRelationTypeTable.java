
// Description: Java7 in-memory RAM DbIO implementation for RelationType.

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
 *	CFBamRamRelationTypeTable in-memory RAM DbIO implementation
 *	for RelationType.
 */
public class CFBamRamRelationTypeTable
	implements ICFBamRelationTypeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamRelationTypePKey,
				CFBamRelationTypeBuff > dictByPKey
		= new HashMap< CFBamRelationTypePKey,
				CFBamRelationTypeBuff >();
	private Map< CFBamRelationTypeByUTagIdxKey,
			CFBamRelationTypeBuff > dictByUTagIdx
		= new HashMap< CFBamRelationTypeByUTagIdxKey,
			CFBamRelationTypeBuff >();

	public CFBamRamRelationTypeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createRelationType( CFBamAuthorization Authorization,
		CFBamRelationTypeBuff Buff )
	{
		final String S_ProcName = "createRelationType";
		CFBamRelationTypePKey pkey = schema.getFactoryRelationType().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamRelationTypeByUTagIdxKey keyUTagIdx = schema.getFactoryRelationType().newUTagIdxKey();
		keyUTagIdx.setRequiredTag( Buff.getRequiredTag() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUTagIdx.containsKey( keyUTagIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RelationTypeUTagIdx",
				keyUTagIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUTagIdx.put( keyUTagIdx, Buff );

	}

	public CFBamRelationTypeBuff readDerived( CFBamAuthorization Authorization,
		CFBamRelationTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationType.readDerived() ";
		CFBamRelationTypePKey key = schema.getFactoryRelationType().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamRelationTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationType.readDerived() ";
		CFBamRelationTypePKey key = schema.getFactoryRelationType().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamRelationType.readAllDerived() ";
		CFBamRelationTypeBuff[] retList = new CFBamRelationTypeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamRelationTypeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamRelationTypeBuff readDerivedByUTagIdx( CFBamAuthorization Authorization,
		String Tag )
	{
		final String S_ProcName = "CFBamRamRelationType.readDerivedByUTagIdx() ";
		CFBamRelationTypeByUTagIdxKey key = schema.getFactoryRelationType().newUTagIdxKey();
		key.setRequiredTag( Tag );

		CFBamRelationTypeBuff buff;
		if( dictByUTagIdx.containsKey( key ) ) {
			buff = dictByUTagIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamRelationType.readDerivedByIdIdx() ";
		CFBamRelationTypePKey key = schema.getFactoryRelationType().newPKey();
		key.setRequiredId( Id );

		CFBamRelationTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff readBuff( CFBamAuthorization Authorization,
		CFBamRelationTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationType.readBuff() ";
		CFBamRelationTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RLT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamRelationTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationType.readBuff() ";
		CFBamRelationTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RLT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationTypeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamRelationType.readAllBuff() ";
		CFBamRelationTypeBuff buff;
		ArrayList<CFBamRelationTypeBuff> filteredList = new ArrayList<CFBamRelationTypeBuff>();
		CFBamRelationTypeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RLT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationTypeBuff[0] ) );
	}

	public CFBamRelationTypeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamRelationType.readBuffByIdIdx() ";
		CFBamRelationTypeBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "RLT" ) ) {
			return( (CFBamRelationTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamRelationTypeBuff readBuffByUTagIdx( CFBamAuthorization Authorization,
		String Tag )
	{
		final String S_ProcName = "CFBamRamRelationType.readBuffByUTagIdx() ";
		CFBamRelationTypeBuff buff = readDerivedByUTagIdx( Authorization,
			Tag );
		if( ( buff != null ) && buff.getClassCode().equals( "RLT" ) ) {
			return( (CFBamRelationTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateRelationType( CFBamAuthorization Authorization,
		CFBamRelationTypeBuff Buff )
	{
		CFBamRelationTypePKey pkey = schema.getFactoryRelationType().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateRelationType",
				"Existing record not found",
				"RelationType",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateRelationType",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamRelationTypeByUTagIdxKey existingKeyUTagIdx = schema.getFactoryRelationType().newUTagIdxKey();
		existingKeyUTagIdx.setRequiredTag( existing.getRequiredTag() );

		CFBamRelationTypeByUTagIdxKey newKeyUTagIdx = schema.getFactoryRelationType().newUTagIdxKey();
		newKeyUTagIdx.setRequiredTag( Buff.getRequiredTag() );

		// Check unique indexes

		if( ! existingKeyUTagIdx.equals( newKeyUTagIdx ) ) {
			if( dictByUTagIdx.containsKey( newKeyUTagIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateRelationType",
					"RelationTypeUTagIdx",
					newKeyUTagIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamRelationTypePKey, CFBamRelationTypeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUTagIdx.remove( existingKeyUTagIdx );
		dictByUTagIdx.put( newKeyUTagIdx, Buff );

	}

	public void deleteRelationType( CFBamAuthorization Authorization,
		CFBamRelationTypeBuff Buff )
	{
		final String S_ProcName = "CFBamRamRelationTypeTable.deleteRelationType() ";
		CFBamRelationTypePKey pkey = schema.getFactoryRelationType().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteRelationType",
				pkey );
		}
		CFBamRelationTypeByUTagIdxKey keyUTagIdx = schema.getFactoryRelationType().newUTagIdxKey();
		keyUTagIdx.setRequiredTag( existing.getRequiredTag() );


		// Validate reverse foreign keys

		if( schema.getTableRelation().readDerivedByRTypeKeyIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelationType",
				"Lookup",
				"RelationType",
				"Relation",
				pkey );
		}

		// Delete is valid

		Map< CFBamRelationTypePKey, CFBamRelationTypeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUTagIdx.remove( keyUTagIdx );

	}

	public void deleteRelationTypeByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamRelationTypePKey key = schema.getFactoryRelationType().newPKey();
		key.setRequiredId( argId );
		deleteRelationTypeByIdIdx( Authorization, key );
	}

	public void deleteRelationTypeByIdIdx( CFBamAuthorization Authorization,
		CFBamRelationTypePKey argKey )
	{
		CFBamRelationTypeBuff cur;
		LinkedList<CFBamRelationTypeBuff> matchSet = new LinkedList<CFBamRelationTypeBuff>();
		Iterator<CFBamRelationTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationType( Authorization, cur );
		}
	}

	public void deleteRelationTypeByUTagIdx( CFBamAuthorization Authorization,
		String argTag )
	{
		CFBamRelationTypeByUTagIdxKey key = schema.getFactoryRelationType().newUTagIdxKey();
		key.setRequiredTag( argTag );
		deleteRelationTypeByUTagIdx( Authorization, key );
	}

	public void deleteRelationTypeByUTagIdx( CFBamAuthorization Authorization,
		CFBamRelationTypeByUTagIdxKey argKey )
	{
		CFBamRelationTypeBuff cur;
		LinkedList<CFBamRelationTypeBuff> matchSet = new LinkedList<CFBamRelationTypeBuff>();
		Iterator<CFBamRelationTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationType( Authorization, cur );
		}
	}

	public CFBamCursor openRelationTypeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamRelationTypeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeRelationTypeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamRelationTypeBuff nextRelationTypeCursor( CFBamCursor Cursor ) {
		CFBamRamRelationTypeCursor cursor = (CFBamRamRelationTypeCursor)Cursor;
		CFBamRelationTypeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamRelationTypeBuff prevRelationTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamRelationTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationTypeBuff firstRelationTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamRelationTypeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationTypeBuff lastRelationTypeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastRelationTypeCursor" );
	}

	public CFBamRelationTypeBuff nthRelationTypeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamRelationTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationTypeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
