
// Description: Java7 in-memory RAM DbIO implementation for ISOCurrency.

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
 *	CFBamRamISOCurrencyTable in-memory RAM DbIO implementation
 *	for ISOCurrency.
 */
public class CFBamRamISOCurrencyTable
	implements ICFBamISOCurrencyTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOCurrencyPKey,
				CFBamISOCurrencyBuff > dictByPKey
		= new HashMap< CFBamISOCurrencyPKey,
				CFBamISOCurrencyBuff >();
	private Map< CFBamISOCurrencyByCcyCdIdxKey,
			CFBamISOCurrencyBuff > dictByCcyCdIdx
		= new HashMap< CFBamISOCurrencyByCcyCdIdxKey,
			CFBamISOCurrencyBuff >();
	private Map< CFBamISOCurrencyByCcyNmIdxKey,
			CFBamISOCurrencyBuff > dictByCcyNmIdx
		= new HashMap< CFBamISOCurrencyByCcyNmIdxKey,
			CFBamISOCurrencyBuff >();

	public CFBamRamISOCurrencyTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCurrency( CFBamAuthorization Authorization,
		CFBamISOCurrencyBuff Buff )
	{
		final String S_ProcName = "createISOCurrency";
		CFBamISOCurrencyPKey pkey = schema.getFactoryISOCurrency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		keyCcyCdIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		keyCcyNmIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByCcyCdIdx.containsKey( keyCcyCdIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCurrencyCodeIdx",
				keyCcyCdIdx );
		}

		if( dictByCcyNmIdx.containsKey( keyCcyNmIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCurrencyNameIdx",
				keyCcyNmIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByCcyCdIdx.put( keyCcyCdIdx, Buff );

		dictByCcyNmIdx.put( keyCcyNmIdx, Buff );

	}

	public CFBamISOCurrencyBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readDerived() ";
		CFBamISOCurrencyPKey key = schema.getFactoryISOCurrency().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readDerived() ";
		CFBamISOCurrencyPKey key = schema.getFactoryISOCurrency().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOCurrency.readAllDerived() ";
		CFBamISOCurrencyBuff[] retList = new CFBamISOCurrencyBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOCurrencyBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOCurrencyBuff readDerivedByCcyCdIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readDerivedByCcyCdIdx() ";
		CFBamISOCurrencyByCcyCdIdxKey key = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );

		CFBamISOCurrencyBuff buff;
		if( dictByCcyCdIdx.containsKey( key ) ) {
			buff = dictByCcyCdIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff readDerivedByCcyNmIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readDerivedByCcyNmIdx() ";
		CFBamISOCurrencyByCcyNmIdxKey key = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		key.setRequiredName( Name );

		CFBamISOCurrencyBuff buff;
		if( dictByCcyNmIdx.containsKey( key ) ) {
			buff = dictByCcyNmIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readDerivedByIdIdx() ";
		CFBamISOCurrencyPKey key = schema.getFactoryISOCurrency().newPKey();
		key.setRequiredId( Id );

		CFBamISOCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readBuff() ";
		CFBamISOCurrencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISCY" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readBuff() ";
		CFBamISOCurrencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISCY" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCurrencyBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readAllBuff() ";
		CFBamISOCurrencyBuff buff;
		ArrayList<CFBamISOCurrencyBuff> filteredList = new ArrayList<CFBamISOCurrencyBuff>();
		CFBamISOCurrencyBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISCY" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCurrencyBuff[0] ) );
	}

	public CFBamISOCurrencyBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readBuffByIdIdx() ";
		CFBamISOCurrencyBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "ISCY" ) ) {
			return( (CFBamISOCurrencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCurrencyBuff readBuffByCcyCdIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readBuffByCcyCdIdx() ";
		CFBamISOCurrencyBuff buff = readDerivedByCcyCdIdx( Authorization,
			ISOCode );
		if( ( buff != null ) && buff.getClassCode().equals( "ISCY" ) ) {
			return( (CFBamISOCurrencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCurrencyBuff readBuffByCcyNmIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamISOCurrency.readBuffByCcyNmIdx() ";
		CFBamISOCurrencyBuff buff = readDerivedByCcyNmIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "ISCY" ) ) {
			return( (CFBamISOCurrencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateISOCurrency( CFBamAuthorization Authorization,
		CFBamISOCurrencyBuff Buff )
	{
		CFBamISOCurrencyPKey pkey = schema.getFactoryISOCurrency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOCurrencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOCurrency",
				"Existing record not found",
				"ISOCurrency",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOCurrency",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOCurrencyByCcyCdIdxKey existingKeyCcyCdIdx = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		existingKeyCcyCdIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		CFBamISOCurrencyByCcyCdIdxKey newKeyCcyCdIdx = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		newKeyCcyCdIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		CFBamISOCurrencyByCcyNmIdxKey existingKeyCcyNmIdx = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		existingKeyCcyNmIdx.setRequiredName( existing.getRequiredName() );

		CFBamISOCurrencyByCcyNmIdxKey newKeyCcyNmIdx = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		newKeyCcyNmIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyCcyCdIdx.equals( newKeyCcyCdIdx ) ) {
			if( dictByCcyCdIdx.containsKey( newKeyCcyCdIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOCurrency",
					"ISOCurrencyCodeIdx",
					newKeyCcyCdIdx );
			}
		}

		if( ! existingKeyCcyNmIdx.equals( newKeyCcyNmIdx ) ) {
			if( dictByCcyNmIdx.containsKey( newKeyCcyNmIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOCurrency",
					"ISOCurrencyNameIdx",
					newKeyCcyNmIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamISOCurrencyPKey, CFBamISOCurrencyBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByCcyCdIdx.remove( existingKeyCcyCdIdx );
		dictByCcyCdIdx.put( newKeyCcyCdIdx, Buff );

		dictByCcyNmIdx.remove( existingKeyCcyNmIdx );
		dictByCcyNmIdx.put( newKeyCcyNmIdx, Buff );

	}

	public void deleteISOCurrency( CFBamAuthorization Authorization,
		CFBamISOCurrencyBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOCurrencyTable.deleteISOCurrency() ";
		CFBamISOCurrencyPKey pkey = schema.getFactoryISOCurrency().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOCurrencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOCurrency",
				pkey );
		}
		CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		keyCcyCdIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		keyCcyNmIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableISOCountryCurrency().deleteISOCountryCurrencyByCurrencyIdx( Authorization,
			Buff.getRequiredId() );
		Map< CFBamISOCurrencyPKey, CFBamISOCurrencyBuff > subdict;

		dictByPKey.remove( pkey );

		dictByCcyCdIdx.remove( keyCcyCdIdx );

		dictByCcyNmIdx.remove( keyCcyNmIdx );

	}

	public void deleteISOCurrencyByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamISOCurrencyPKey key = schema.getFactoryISOCurrency().newPKey();
		key.setRequiredId( argId );
		deleteISOCurrencyByIdIdx( Authorization, key );
	}

	public void deleteISOCurrencyByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCurrencyPKey argKey )
	{
		CFBamISOCurrencyBuff cur;
		LinkedList<CFBamISOCurrencyBuff> matchSet = new LinkedList<CFBamISOCurrencyBuff>();
		Iterator<CFBamISOCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCurrency( Authorization, cur );
		}
	}

	public void deleteISOCurrencyByCcyCdIdx( CFBamAuthorization Authorization,
		String argISOCode )
	{
		CFBamISOCurrencyByCcyCdIdxKey key = schema.getFactoryISOCurrency().newCcyCdIdxKey();
		key.setRequiredISOCode( argISOCode );
		deleteISOCurrencyByCcyCdIdx( Authorization, key );
	}

	public void deleteISOCurrencyByCcyCdIdx( CFBamAuthorization Authorization,
		CFBamISOCurrencyByCcyCdIdxKey argKey )
	{
		CFBamISOCurrencyBuff cur;
		LinkedList<CFBamISOCurrencyBuff> matchSet = new LinkedList<CFBamISOCurrencyBuff>();
		Iterator<CFBamISOCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCurrency( Authorization, cur );
		}
	}

	public void deleteISOCurrencyByCcyNmIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamISOCurrencyByCcyNmIdxKey key = schema.getFactoryISOCurrency().newCcyNmIdxKey();
		key.setRequiredName( argName );
		deleteISOCurrencyByCcyNmIdx( Authorization, key );
	}

	public void deleteISOCurrencyByCcyNmIdx( CFBamAuthorization Authorization,
		CFBamISOCurrencyByCcyNmIdxKey argKey )
	{
		CFBamISOCurrencyBuff cur;
		LinkedList<CFBamISOCurrencyBuff> matchSet = new LinkedList<CFBamISOCurrencyBuff>();
		Iterator<CFBamISOCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCurrency( Authorization, cur );
		}
	}

	public CFBamCursor openISOCurrencyCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOCurrencyCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeISOCurrencyCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOCurrencyBuff nextISOCurrencyCursor( CFBamCursor Cursor ) {
		CFBamRamISOCurrencyCursor cursor = (CFBamRamISOCurrencyCursor)Cursor;
		CFBamISOCurrencyBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOCurrencyBuff prevISOCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOCurrencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCurrencyBuff firstISOCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOCurrencyBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCurrencyBuff lastISOCurrencyCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOCurrencyCursor" );
	}

	public CFBamISOCurrencyBuff nthISOCurrencyCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOCurrencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
