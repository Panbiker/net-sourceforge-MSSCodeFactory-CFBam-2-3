
// Description: Java7 in-memory RAM DbIO implementation for LoaderBehaviour.

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
 *	CFBamRamLoaderBehaviourTable in-memory RAM DbIO implementation
 *	for LoaderBehaviour.
 */
public class CFBamRamLoaderBehaviourTable
	implements ICFBamLoaderBehaviourTable
{
	private CFBamRamSchema schema;
	private Map< CFBamLoaderBehaviourPKey,
				CFBamLoaderBehaviourBuff > dictByPKey
		= new HashMap< CFBamLoaderBehaviourPKey,
				CFBamLoaderBehaviourBuff >();
	private Map< CFBamLoaderBehaviourByUNameIdxKey,
			CFBamLoaderBehaviourBuff > dictByUNameIdx
		= new HashMap< CFBamLoaderBehaviourByUNameIdxKey,
			CFBamLoaderBehaviourBuff >();

	public CFBamRamLoaderBehaviourTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff )
	{
		final String S_ProcName = "createLoaderBehaviour";
		CFBamLoaderBehaviourPKey pkey = schema.getFactoryLoaderBehaviour().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"LoaderBehaviourUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamLoaderBehaviourBuff readDerived( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readDerived() ";
		CFBamLoaderBehaviourPKey key = schema.getFactoryLoaderBehaviour().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamLoaderBehaviourBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff lockDerived( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readDerived() ";
		CFBamLoaderBehaviourPKey key = schema.getFactoryLoaderBehaviour().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamLoaderBehaviourBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamLoaderBehaviour.readAllDerived() ";
		CFBamLoaderBehaviourBuff[] retList = new CFBamLoaderBehaviourBuff[ dictByPKey.values().size() ];
		Iterator< CFBamLoaderBehaviourBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamLoaderBehaviourBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readDerivedByUNameIdx() ";
		CFBamLoaderBehaviourByUNameIdxKey key = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamLoaderBehaviourBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readDerivedByIdIdx() ";
		CFBamLoaderBehaviourPKey key = schema.getFactoryLoaderBehaviour().newPKey();
		key.setRequiredId( Id );

		CFBamLoaderBehaviourBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff readBuff( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readBuff() ";
		CFBamLoaderBehaviourBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "LDBV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff lockBuff( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readBuff() ";
		CFBamLoaderBehaviourBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "LDBV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamLoaderBehaviourBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readAllBuff() ";
		CFBamLoaderBehaviourBuff buff;
		ArrayList<CFBamLoaderBehaviourBuff> filteredList = new ArrayList<CFBamLoaderBehaviourBuff>();
		CFBamLoaderBehaviourBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "LDBV" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamLoaderBehaviourBuff[0] ) );
	}

	public CFBamLoaderBehaviourBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readBuffByIdIdx() ";
		CFBamLoaderBehaviourBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "LDBV" ) ) {
			return( (CFBamLoaderBehaviourBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamLoaderBehaviourBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviour.readBuffByUNameIdx() ";
		CFBamLoaderBehaviourBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "LDBV" ) ) {
			return( (CFBamLoaderBehaviourBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff )
	{
		CFBamLoaderBehaviourPKey pkey = schema.getFactoryLoaderBehaviour().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamLoaderBehaviourBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateLoaderBehaviour",
				"Existing record not found",
				"LoaderBehaviour",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateLoaderBehaviour",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamLoaderBehaviourByUNameIdxKey existingKeyUNameIdx = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamLoaderBehaviourByUNameIdxKey newKeyUNameIdx = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateLoaderBehaviour",
					"LoaderBehaviourUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamLoaderBehaviourPKey, CFBamLoaderBehaviourBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff )
	{
		final String S_ProcName = "CFBamRamLoaderBehaviourTable.deleteLoaderBehaviour() ";
		CFBamLoaderBehaviourPKey pkey = schema.getFactoryLoaderBehaviour().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamLoaderBehaviourBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteLoaderBehaviour",
				pkey );
		}
		CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		if( schema.getTableTable().readDerivedByLoadBehaveIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteLoaderBehaviour",
				"Lookup",
				"LoaderBehaviour",
				"Table",
				pkey );
		}

		// Delete is valid

		Map< CFBamLoaderBehaviourPKey, CFBamLoaderBehaviourBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteLoaderBehaviourByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamLoaderBehaviourPKey key = schema.getFactoryLoaderBehaviour().newPKey();
		key.setRequiredId( argId );
		deleteLoaderBehaviourByIdIdx( Authorization, key );
	}

	public void deleteLoaderBehaviourByIdIdx( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey argKey )
	{
		CFBamLoaderBehaviourBuff cur;
		LinkedList<CFBamLoaderBehaviourBuff> matchSet = new LinkedList<CFBamLoaderBehaviourBuff>();
		Iterator<CFBamLoaderBehaviourBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLoaderBehaviourBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLoaderBehaviour( Authorization, cur );
		}
	}

	public void deleteLoaderBehaviourByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamLoaderBehaviourByUNameIdxKey key = schema.getFactoryLoaderBehaviour().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteLoaderBehaviourByUNameIdx( Authorization, key );
	}

	public void deleteLoaderBehaviourByUNameIdx( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourByUNameIdxKey argKey )
	{
		CFBamLoaderBehaviourBuff cur;
		LinkedList<CFBamLoaderBehaviourBuff> matchSet = new LinkedList<CFBamLoaderBehaviourBuff>();
		Iterator<CFBamLoaderBehaviourBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLoaderBehaviourBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLoaderBehaviour( Authorization, cur );
		}
	}

	public CFBamCursor openLoaderBehaviourCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamLoaderBehaviourCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeLoaderBehaviourCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamLoaderBehaviourBuff nextLoaderBehaviourCursor( CFBamCursor Cursor ) {
		CFBamRamLoaderBehaviourCursor cursor = (CFBamRamLoaderBehaviourCursor)Cursor;
		CFBamLoaderBehaviourBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamLoaderBehaviourBuff prevLoaderBehaviourCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamLoaderBehaviourBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLoaderBehaviourCursor( Cursor );
		}
		return( rec );
	}

	public CFBamLoaderBehaviourBuff firstLoaderBehaviourCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamLoaderBehaviourBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLoaderBehaviourCursor( Cursor );
		}
		return( rec );
	}

	public CFBamLoaderBehaviourBuff lastLoaderBehaviourCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastLoaderBehaviourCursor" );
	}

	public CFBamLoaderBehaviourBuff nthLoaderBehaviourCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamLoaderBehaviourBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLoaderBehaviourCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
