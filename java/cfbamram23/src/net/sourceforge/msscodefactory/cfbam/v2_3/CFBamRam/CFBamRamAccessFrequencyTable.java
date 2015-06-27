
// Description: Java7 in-memory RAM DbIO implementation for AccessFrequency.

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
 *	CFBamRamAccessFrequencyTable in-memory RAM DbIO implementation
 *	for AccessFrequency.
 */
public class CFBamRamAccessFrequencyTable
	implements ICFBamAccessFrequencyTable
{
	private CFBamRamSchema schema;
	private Map< CFBamAccessFrequencyPKey,
				CFBamAccessFrequencyBuff > dictByPKey
		= new HashMap< CFBamAccessFrequencyPKey,
				CFBamAccessFrequencyBuff >();
	private Map< CFBamAccessFrequencyByUNameIdxKey,
			CFBamAccessFrequencyBuff > dictByUNameIdx
		= new HashMap< CFBamAccessFrequencyByUNameIdxKey,
			CFBamAccessFrequencyBuff >();

	public CFBamRamAccessFrequencyTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createAccessFrequency( CFBamAuthorization Authorization,
		CFBamAccessFrequencyBuff Buff )
	{
		final String S_ProcName = "createAccessFrequency";
		CFBamAccessFrequencyPKey pkey = schema.getFactoryAccessFrequency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamAccessFrequencyByUNameIdxKey keyUNameIdx = schema.getFactoryAccessFrequency().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"AccessFrequencyUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamAccessFrequencyBuff readDerived( CFBamAuthorization Authorization,
		CFBamAccessFrequencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readDerived() ";
		CFBamAccessFrequencyPKey key = schema.getFactoryAccessFrequency().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAccessFrequencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff lockDerived( CFBamAuthorization Authorization,
		CFBamAccessFrequencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readDerived() ";
		CFBamAccessFrequencyPKey key = schema.getFactoryAccessFrequency().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAccessFrequencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamAccessFrequency.readAllDerived() ";
		CFBamAccessFrequencyBuff[] retList = new CFBamAccessFrequencyBuff[ dictByPKey.values().size() ];
		Iterator< CFBamAccessFrequencyBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamAccessFrequencyBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readDerivedByUNameIdx() ";
		CFBamAccessFrequencyByUNameIdxKey key = schema.getFactoryAccessFrequency().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamAccessFrequencyBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readDerivedByIdIdx() ";
		CFBamAccessFrequencyPKey key = schema.getFactoryAccessFrequency().newPKey();
		key.setRequiredId( Id );

		CFBamAccessFrequencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff readBuff( CFBamAuthorization Authorization,
		CFBamAccessFrequencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readBuff() ";
		CFBamAccessFrequencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "AFRQ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff lockBuff( CFBamAuthorization Authorization,
		CFBamAccessFrequencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readBuff() ";
		CFBamAccessFrequencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "AFRQ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessFrequencyBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readAllBuff() ";
		CFBamAccessFrequencyBuff buff;
		ArrayList<CFBamAccessFrequencyBuff> filteredList = new ArrayList<CFBamAccessFrequencyBuff>();
		CFBamAccessFrequencyBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "AFRQ" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamAccessFrequencyBuff[0] ) );
	}

	public CFBamAccessFrequencyBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readBuffByIdIdx() ";
		CFBamAccessFrequencyBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "AFRQ" ) ) {
			return( (CFBamAccessFrequencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAccessFrequencyBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamAccessFrequency.readBuffByUNameIdx() ";
		CFBamAccessFrequencyBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "AFRQ" ) ) {
			return( (CFBamAccessFrequencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateAccessFrequency( CFBamAuthorization Authorization,
		CFBamAccessFrequencyBuff Buff )
	{
		CFBamAccessFrequencyPKey pkey = schema.getFactoryAccessFrequency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAccessFrequencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateAccessFrequency",
				"Existing record not found",
				"AccessFrequency",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateAccessFrequency",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamAccessFrequencyByUNameIdxKey existingKeyUNameIdx = schema.getFactoryAccessFrequency().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamAccessFrequencyByUNameIdxKey newKeyUNameIdx = schema.getFactoryAccessFrequency().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateAccessFrequency",
					"AccessFrequencyUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamAccessFrequencyPKey, CFBamAccessFrequencyBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteAccessFrequency( CFBamAuthorization Authorization,
		CFBamAccessFrequencyBuff Buff )
	{
		final String S_ProcName = "CFBamRamAccessFrequencyTable.deleteAccessFrequency() ";
		CFBamAccessFrequencyPKey pkey = schema.getFactoryAccessFrequency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAccessFrequencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteAccessFrequency",
				pkey );
		}
		CFBamAccessFrequencyByUNameIdxKey keyUNameIdx = schema.getFactoryAccessFrequency().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamAccessFrequencyPKey, CFBamAccessFrequencyBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteAccessFrequencyByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamAccessFrequencyPKey key = schema.getFactoryAccessFrequency().newPKey();
		key.setRequiredId( argId );
		deleteAccessFrequencyByIdIdx( Authorization, key );
	}

	public void deleteAccessFrequencyByIdIdx( CFBamAuthorization Authorization,
		CFBamAccessFrequencyPKey argKey )
	{
		CFBamAccessFrequencyBuff cur;
		LinkedList<CFBamAccessFrequencyBuff> matchSet = new LinkedList<CFBamAccessFrequencyBuff>();
		Iterator<CFBamAccessFrequencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAccessFrequencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAccessFrequency( Authorization, cur );
		}
	}

	public void deleteAccessFrequencyByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamAccessFrequencyByUNameIdxKey key = schema.getFactoryAccessFrequency().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteAccessFrequencyByUNameIdx( Authorization, key );
	}

	public void deleteAccessFrequencyByUNameIdx( CFBamAuthorization Authorization,
		CFBamAccessFrequencyByUNameIdxKey argKey )
	{
		CFBamAccessFrequencyBuff cur;
		LinkedList<CFBamAccessFrequencyBuff> matchSet = new LinkedList<CFBamAccessFrequencyBuff>();
		Iterator<CFBamAccessFrequencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAccessFrequencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAccessFrequency( Authorization, cur );
		}
	}

	public CFBamCursor openAccessFrequencyCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamAccessFrequencyCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeAccessFrequencyCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamAccessFrequencyBuff nextAccessFrequencyCursor( CFBamCursor Cursor ) {
		CFBamRamAccessFrequencyCursor cursor = (CFBamRamAccessFrequencyCursor)Cursor;
		CFBamAccessFrequencyBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamAccessFrequencyBuff prevAccessFrequencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamAccessFrequencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessFrequencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAccessFrequencyBuff firstAccessFrequencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamAccessFrequencyBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessFrequencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAccessFrequencyBuff lastAccessFrequencyCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastAccessFrequencyCursor" );
	}

	public CFBamAccessFrequencyBuff nthAccessFrequencyCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamAccessFrequencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessFrequencyCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
