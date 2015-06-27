
// Description: Java7 in-memory RAM DbIO implementation for ISOCountry.

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
 *	CFBamRamISOCountryTable in-memory RAM DbIO implementation
 *	for ISOCountry.
 */
public class CFBamRamISOCountryTable
	implements ICFBamISOCountryTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOCountryPKey,
				CFBamISOCountryBuff > dictByPKey
		= new HashMap< CFBamISOCountryPKey,
				CFBamISOCountryBuff >();
	private Map< CFBamISOCountryByISOCodeIdxKey,
			CFBamISOCountryBuff > dictByISOCodeIdx
		= new HashMap< CFBamISOCountryByISOCodeIdxKey,
			CFBamISOCountryBuff >();
	private Map< CFBamISOCountryByNameIdxKey,
			CFBamISOCountryBuff > dictByNameIdx
		= new HashMap< CFBamISOCountryByNameIdxKey,
			CFBamISOCountryBuff >();

	public CFBamRamISOCountryTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCountry( CFBamAuthorization Authorization,
		CFBamISOCountryBuff Buff )
	{
		final String S_ProcName = "createISOCountry";
		CFBamISOCountryPKey pkey = schema.getFactoryISOCountry().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx = schema.getFactoryISOCountry().newISOCodeIdxKey();
		keyISOCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		CFBamISOCountryByNameIdxKey keyNameIdx = schema.getFactoryISOCountry().newNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByISOCodeIdx.containsKey( keyISOCodeIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCountryCodeIdx",
				keyISOCodeIdx );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCountryNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByISOCodeIdx.put( keyISOCodeIdx, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamISOCountryBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountry.readDerived() ";
		CFBamISOCountryPKey key = schema.getFactoryISOCountry().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOCountryBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountry.readDerived() ";
		CFBamISOCountryPKey key = schema.getFactoryISOCountry().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOCountryBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOCountry.readAllDerived() ";
		CFBamISOCountryBuff[] retList = new CFBamISOCountryBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOCountryBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOCountryBuff readDerivedByISOCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOCountry.readDerivedByISOCodeIdx() ";
		CFBamISOCountryByISOCodeIdxKey key = schema.getFactoryISOCountry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );

		CFBamISOCountryBuff buff;
		if( dictByISOCodeIdx.containsKey( key ) ) {
			buff = dictByISOCodeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamISOCountry.readDerivedByNameIdx() ";
		CFBamISOCountryByNameIdxKey key = schema.getFactoryISOCountry().newNameIdxKey();
		key.setRequiredName( Name );

		CFBamISOCountryBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOCountry.readDerivedByIdIdx() ";
		CFBamISOCountryPKey key = schema.getFactoryISOCountry().newPKey();
		key.setRequiredId( Id );

		CFBamISOCountryBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountry.readBuff() ";
		CFBamISOCountryBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISOC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountry.readBuff() ";
		CFBamISOCountryBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISOC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOCountry.readAllBuff() ";
		CFBamISOCountryBuff buff;
		ArrayList<CFBamISOCountryBuff> filteredList = new ArrayList<CFBamISOCountryBuff>();
		CFBamISOCountryBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISOC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryBuff[0] ) );
	}

	public CFBamISOCountryBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOCountry.readBuffByIdIdx() ";
		CFBamISOCountryBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "ISOC" ) ) {
			return( (CFBamISOCountryBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCountryBuff readBuffByISOCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOCountry.readBuffByISOCodeIdx() ";
		CFBamISOCountryBuff buff = readDerivedByISOCodeIdx( Authorization,
			ISOCode );
		if( ( buff != null ) && buff.getClassCode().equals( "ISOC" ) ) {
			return( (CFBamISOCountryBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCountryBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamISOCountry.readBuffByNameIdx() ";
		CFBamISOCountryBuff buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "ISOC" ) ) {
			return( (CFBamISOCountryBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateISOCountry( CFBamAuthorization Authorization,
		CFBamISOCountryBuff Buff )
	{
		CFBamISOCountryPKey pkey = schema.getFactoryISOCountry().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOCountryBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOCountry",
				"Existing record not found",
				"ISOCountry",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOCountry",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOCountryByISOCodeIdxKey existingKeyISOCodeIdx = schema.getFactoryISOCountry().newISOCodeIdxKey();
		existingKeyISOCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		CFBamISOCountryByISOCodeIdxKey newKeyISOCodeIdx = schema.getFactoryISOCountry().newISOCodeIdxKey();
		newKeyISOCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		CFBamISOCountryByNameIdxKey existingKeyNameIdx = schema.getFactoryISOCountry().newNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamISOCountryByNameIdxKey newKeyNameIdx = schema.getFactoryISOCountry().newNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyISOCodeIdx.equals( newKeyISOCodeIdx ) ) {
			if( dictByISOCodeIdx.containsKey( newKeyISOCodeIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOCountry",
					"ISOCountryCodeIdx",
					newKeyISOCodeIdx );
			}
		}

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOCountry",
					"ISOCountryNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamISOCountryPKey, CFBamISOCountryBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByISOCodeIdx.remove( existingKeyISOCodeIdx );
		dictByISOCodeIdx.put( newKeyISOCodeIdx, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteISOCountry( CFBamAuthorization Authorization,
		CFBamISOCountryBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOCountryTable.deleteISOCountry() ";
		CFBamISOCountryPKey pkey = schema.getFactoryISOCountry().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOCountryBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOCountry",
				pkey );
		}
		CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx = schema.getFactoryISOCountry().newISOCodeIdxKey();
		keyISOCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		CFBamISOCountryByNameIdxKey keyNameIdx = schema.getFactoryISOCountry().newNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableISOCountryCurrency().deleteISOCountryCurrencyByCountryIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableISOCountryLanguage().deleteISOCountryLanguageByCountryIdx( Authorization,
			Buff.getRequiredId() );
		Map< CFBamISOCountryPKey, CFBamISOCountryBuff > subdict;

		dictByPKey.remove( pkey );

		dictByISOCodeIdx.remove( keyISOCodeIdx );

		dictByNameIdx.remove( keyNameIdx );

	}

	public void deleteISOCountryByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamISOCountryPKey key = schema.getFactoryISOCountry().newPKey();
		key.setRequiredId( argId );
		deleteISOCountryByIdIdx( Authorization, key );
	}

	public void deleteISOCountryByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryPKey argKey )
	{
		CFBamISOCountryBuff cur;
		LinkedList<CFBamISOCountryBuff> matchSet = new LinkedList<CFBamISOCountryBuff>();
		Iterator<CFBamISOCountryBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountry( Authorization, cur );
		}
	}

	public void deleteISOCountryByISOCodeIdx( CFBamAuthorization Authorization,
		String argISOCode )
	{
		CFBamISOCountryByISOCodeIdxKey key = schema.getFactoryISOCountry().newISOCodeIdxKey();
		key.setRequiredISOCode( argISOCode );
		deleteISOCountryByISOCodeIdx( Authorization, key );
	}

	public void deleteISOCountryByISOCodeIdx( CFBamAuthorization Authorization,
		CFBamISOCountryByISOCodeIdxKey argKey )
	{
		CFBamISOCountryBuff cur;
		LinkedList<CFBamISOCountryBuff> matchSet = new LinkedList<CFBamISOCountryBuff>();
		Iterator<CFBamISOCountryBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountry( Authorization, cur );
		}
	}

	public void deleteISOCountryByNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamISOCountryByNameIdxKey key = schema.getFactoryISOCountry().newNameIdxKey();
		key.setRequiredName( argName );
		deleteISOCountryByNameIdx( Authorization, key );
	}

	public void deleteISOCountryByNameIdx( CFBamAuthorization Authorization,
		CFBamISOCountryByNameIdxKey argKey )
	{
		CFBamISOCountryBuff cur;
		LinkedList<CFBamISOCountryBuff> matchSet = new LinkedList<CFBamISOCountryBuff>();
		Iterator<CFBamISOCountryBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountry( Authorization, cur );
		}
	}

	public CFBamCursor openISOCountryCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOCountryCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeISOCountryCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOCountryBuff nextISOCountryCursor( CFBamCursor Cursor ) {
		CFBamRamISOCountryCursor cursor = (CFBamRamISOCountryCursor)Cursor;
		CFBamISOCountryBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOCountryBuff prevISOCountryCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOCountryBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryBuff firstISOCountryCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOCountryBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryBuff lastISOCountryCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOCountryCursor" );
	}

	public CFBamISOCountryBuff nthISOCountryCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOCountryBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
