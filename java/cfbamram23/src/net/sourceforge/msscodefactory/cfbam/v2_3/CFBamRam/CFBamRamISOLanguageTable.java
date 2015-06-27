
// Description: Java7 in-memory RAM DbIO implementation for ISOLanguage.

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
 *	CFBamRamISOLanguageTable in-memory RAM DbIO implementation
 *	for ISOLanguage.
 */
public class CFBamRamISOLanguageTable
	implements ICFBamISOLanguageTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOLanguagePKey,
				CFBamISOLanguageBuff > dictByPKey
		= new HashMap< CFBamISOLanguagePKey,
				CFBamISOLanguageBuff >();
	private Map< CFBamISOLanguageByBaseIdxKey,
				Map< CFBamISOLanguagePKey,
					CFBamISOLanguageBuff >> dictByBaseIdx
		= new HashMap< CFBamISOLanguageByBaseIdxKey,
				Map< CFBamISOLanguagePKey,
					CFBamISOLanguageBuff >>();
	private Map< CFBamISOLanguageByCountryIdxKey,
				Map< CFBamISOLanguagePKey,
					CFBamISOLanguageBuff >> dictByCountryIdx
		= new HashMap< CFBamISOLanguageByCountryIdxKey,
				Map< CFBamISOLanguagePKey,
					CFBamISOLanguageBuff >>();
	private Map< CFBamISOLanguageByCodeIdxKey,
			CFBamISOLanguageBuff > dictByCodeIdx
		= new HashMap< CFBamISOLanguageByCodeIdxKey,
			CFBamISOLanguageBuff >();

	public CFBamRamISOLanguageTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		final String S_ProcName = "createISOLanguage";
		CFBamISOLanguagePKey pkey = schema.getFactoryISOLanguage().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamISOLanguageByBaseIdxKey keyBaseIdx = schema.getFactoryISOLanguage().newBaseIdxKey();
		keyBaseIdx.setRequiredBaseLanguageCode( Buff.getRequiredBaseLanguageCode() );

		CFBamISOLanguageByCountryIdxKey keyCountryIdx = schema.getFactoryISOLanguage().newCountryIdxKey();
		keyCountryIdx.setOptionalISOCountryId( Buff.getOptionalISOCountryId() );

		CFBamISOLanguageByCodeIdxKey keyCodeIdx = schema.getFactoryISOLanguage().newCodeIdxKey();
		keyCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByCodeIdx.containsKey( keyCodeIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOLanguageCodeIdx",
				keyCodeIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictBaseIdx;
		if( dictByBaseIdx.containsKey( keyBaseIdx ) ) {
			subdictBaseIdx = dictByBaseIdx.get( keyBaseIdx );
		}
		else {
			subdictBaseIdx = new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByBaseIdx.put( keyBaseIdx, subdictBaseIdx );
		}
		subdictBaseIdx.put( pkey, Buff );

		Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictCountryIdx;
		if( dictByCountryIdx.containsKey( keyCountryIdx ) ) {
			subdictCountryIdx = dictByCountryIdx.get( keyCountryIdx );
		}
		else {
			subdictCountryIdx = new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByCountryIdx.put( keyCountryIdx, subdictCountryIdx );
		}
		subdictCountryIdx.put( pkey, Buff );

		dictByCodeIdx.put( keyCodeIdx, Buff );

	}

	public CFBamISOLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerived() ";
		CFBamISOLanguagePKey key = schema.getFactoryISOLanguage().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerived() ";
		CFBamISOLanguagePKey key = schema.getFactoryISOLanguage().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamISOLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOLanguage.readAllDerived() ";
		CFBamISOLanguageBuff[] retList = new CFBamISOLanguageBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOLanguageBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOLanguageBuff[] readDerivedByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerivedByBaseIdx() ";
		CFBamISOLanguageByBaseIdxKey key = schema.getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( BaseLanguageCode );

		CFBamISOLanguageBuff[] recArray;
		if( dictByBaseIdx.containsKey( key ) ) {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictBaseIdx
				= dictByBaseIdx.get( key );
			recArray = new CFBamISOLanguageBuff[ subdictBaseIdx.size() ];
			Iterator< CFBamISOLanguageBuff > iter = subdictBaseIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictBaseIdx
				= new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByBaseIdx.put( key, subdictBaseIdx );
			recArray = new CFBamISOLanguageBuff[0];
		}
		return( recArray );
	}

	public CFBamISOLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerivedByCountryIdx() ";
		CFBamISOLanguageByCountryIdxKey key = schema.getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( ISOCountryId );

		CFBamISOLanguageBuff[] recArray;
		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			recArray = new CFBamISOLanguageBuff[ subdictCountryIdx.size() ];
			Iterator< CFBamISOLanguageBuff > iter = subdictCountryIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictCountryIdx
				= new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByCountryIdx.put( key, subdictCountryIdx );
			recArray = new CFBamISOLanguageBuff[0];
		}
		return( recArray );
	}

	public CFBamISOLanguageBuff readDerivedByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerivedByCodeIdx() ";
		CFBamISOLanguageByCodeIdxKey key = schema.getFactoryISOLanguage().newCodeIdxKey();
		key.setRequiredISOCode( ISOCode );

		CFBamISOLanguageBuff buff;
		if( dictByCodeIdx.containsKey( key ) ) {
			buff = dictByCodeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readDerivedByIdIdx() ";
		CFBamISOLanguagePKey key = schema.getFactoryISOLanguage().newPKey();
		key.setRequiredId( Id );

		CFBamISOLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuff() ";
		CFBamISOLanguageBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISLN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuff() ";
		CFBamISOLanguageBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISLN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOLanguageBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readAllBuff() ";
		CFBamISOLanguageBuff buff;
		ArrayList<CFBamISOLanguageBuff> filteredList = new ArrayList<CFBamISOLanguageBuff>();
		CFBamISOLanguageBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISLN" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOLanguageBuff[0] ) );
	}

	public CFBamISOLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuffByIdIdx() ";
		CFBamISOLanguageBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "ISLN" ) ) {
			return( (CFBamISOLanguageBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOLanguageBuff[] readBuffByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuffByBaseIdx() ";
		CFBamISOLanguageBuff buff;
		ArrayList<CFBamISOLanguageBuff> filteredList = new ArrayList<CFBamISOLanguageBuff>();
		CFBamISOLanguageBuff[] buffList = readDerivedByBaseIdx( Authorization,
			BaseLanguageCode );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISLN" ) ) {
				filteredList.add( (CFBamISOLanguageBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOLanguageBuff[0] ) );
	}

	public CFBamISOLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuffByCountryIdx() ";
		CFBamISOLanguageBuff buff;
		ArrayList<CFBamISOLanguageBuff> filteredList = new ArrayList<CFBamISOLanguageBuff>();
		CFBamISOLanguageBuff[] buffList = readDerivedByCountryIdx( Authorization,
			ISOCountryId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISLN" ) ) {
				filteredList.add( (CFBamISOLanguageBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOLanguageBuff[0] ) );
	}

	public CFBamISOLanguageBuff readBuffByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "CFBamRamISOLanguage.readBuffByCodeIdx() ";
		CFBamISOLanguageBuff buff = readDerivedByCodeIdx( Authorization,
			ISOCode );
		if( ( buff != null ) && buff.getClassCode().equals( "ISLN" ) ) {
			return( (CFBamISOLanguageBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		CFBamISOLanguagePKey pkey = schema.getFactoryISOLanguage().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOLanguageBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOLanguage",
				"Existing record not found",
				"ISOLanguage",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOLanguage",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOLanguageByBaseIdxKey existingKeyBaseIdx = schema.getFactoryISOLanguage().newBaseIdxKey();
		existingKeyBaseIdx.setRequiredBaseLanguageCode( existing.getRequiredBaseLanguageCode() );

		CFBamISOLanguageByBaseIdxKey newKeyBaseIdx = schema.getFactoryISOLanguage().newBaseIdxKey();
		newKeyBaseIdx.setRequiredBaseLanguageCode( Buff.getRequiredBaseLanguageCode() );

		CFBamISOLanguageByCountryIdxKey existingKeyCountryIdx = schema.getFactoryISOLanguage().newCountryIdxKey();
		existingKeyCountryIdx.setOptionalISOCountryId( existing.getOptionalISOCountryId() );

		CFBamISOLanguageByCountryIdxKey newKeyCountryIdx = schema.getFactoryISOLanguage().newCountryIdxKey();
		newKeyCountryIdx.setOptionalISOCountryId( Buff.getOptionalISOCountryId() );

		CFBamISOLanguageByCodeIdxKey existingKeyCodeIdx = schema.getFactoryISOLanguage().newCodeIdxKey();
		existingKeyCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		CFBamISOLanguageByCodeIdxKey newKeyCodeIdx = schema.getFactoryISOLanguage().newCodeIdxKey();
		newKeyCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		// Check unique indexes

		if( ! existingKeyCodeIdx.equals( newKeyCodeIdx ) ) {
			if( dictByCodeIdx.containsKey( newKeyCodeIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOLanguage",
					"ISOLanguageCodeIdx",
					newKeyCodeIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByBaseIdx.get( existingKeyBaseIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBaseIdx.containsKey( newKeyBaseIdx ) ) {
			subdict = dictByBaseIdx.get( newKeyBaseIdx );
		}
		else {
			subdict = new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByBaseIdx.put( newKeyBaseIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByCountryIdx.get( existingKeyCountryIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCountryIdx.containsKey( newKeyCountryIdx ) ) {
			subdict = dictByCountryIdx.get( newKeyCountryIdx );
		}
		else {
			subdict = new HashMap< CFBamISOLanguagePKey, CFBamISOLanguageBuff >();
			dictByCountryIdx.put( newKeyCountryIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByCodeIdx.remove( existingKeyCodeIdx );
		dictByCodeIdx.put( newKeyCodeIdx, Buff );

	}

	public void deleteISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOLanguageTable.deleteISOLanguage() ";
		CFBamISOLanguagePKey pkey = schema.getFactoryISOLanguage().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamISOLanguageBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOLanguage",
				pkey );
		}
		CFBamISOLanguageByBaseIdxKey keyBaseIdx = schema.getFactoryISOLanguage().newBaseIdxKey();
		keyBaseIdx.setRequiredBaseLanguageCode( existing.getRequiredBaseLanguageCode() );

		CFBamISOLanguageByCountryIdxKey keyCountryIdx = schema.getFactoryISOLanguage().newCountryIdxKey();
		keyCountryIdx.setOptionalISOCountryId( existing.getOptionalISOCountryId() );

		CFBamISOLanguageByCodeIdxKey keyCodeIdx = schema.getFactoryISOLanguage().newCodeIdxKey();
		keyCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableISOCountryLanguage().deleteISOCountryLanguageByLanguageIdx( Authorization,
			Buff.getRequiredId() );
		Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByBaseIdx.get( keyBaseIdx );
		subdict.remove( pkey );

		subdict = dictByCountryIdx.get( keyCountryIdx );
		subdict.remove( pkey );

		dictByCodeIdx.remove( keyCodeIdx );

	}

	public void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamISOLanguagePKey key = schema.getFactoryISOLanguage().newPKey();
		key.setRequiredId( argId );
		deleteISOLanguageByIdIdx( Authorization, key );
	}

	public void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey argKey )
	{
		CFBamISOLanguageBuff cur;
		LinkedList<CFBamISOLanguageBuff> matchSet = new LinkedList<CFBamISOLanguageBuff>();
		Iterator<CFBamISOLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOLanguage( Authorization, cur );
		}
	}

	public void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		String argBaseLanguageCode )
	{
		CFBamISOLanguageByBaseIdxKey key = schema.getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( argBaseLanguageCode );
		deleteISOLanguageByBaseIdx( Authorization, key );
	}

	public void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByBaseIdxKey argKey )
	{
		CFBamISOLanguageBuff cur;
		LinkedList<CFBamISOLanguageBuff> matchSet = new LinkedList<CFBamISOLanguageBuff>();
		Iterator<CFBamISOLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOLanguage( Authorization, cur );
		}
	}

	public void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		Short argISOCountryId )
	{
		CFBamISOLanguageByCountryIdxKey key = schema.getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( argISOCountryId );
		deleteISOLanguageByCountryIdx( Authorization, key );
	}

	public void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCountryIdxKey argKey )
	{
		CFBamISOLanguageBuff cur;
		LinkedList<CFBamISOLanguageBuff> matchSet = new LinkedList<CFBamISOLanguageBuff>();
		Iterator<CFBamISOLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOLanguage( Authorization, cur );
		}
	}

	public void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		String argISOCode )
	{
		CFBamISOLanguageByCodeIdxKey key = schema.getFactoryISOLanguage().newCodeIdxKey();
		key.setRequiredISOCode( argISOCode );
		deleteISOLanguageByCodeIdx( Authorization, key );
	}

	public void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCodeIdxKey argKey )
	{
		CFBamISOLanguageBuff cur;
		LinkedList<CFBamISOLanguageBuff> matchSet = new LinkedList<CFBamISOLanguageBuff>();
		Iterator<CFBamISOLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOLanguage( Authorization, cur );
		}
	}

	public CFBamCursor openISOLanguageCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOLanguageCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openISOLanguageCursorByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode )
	{
		CFBamCursor cursor;
		CFBamISOLanguageByBaseIdxKey key = schema.getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( BaseLanguageCode );

		if( dictByBaseIdx.containsKey( key ) ) {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictBaseIdx
				= dictByBaseIdx.get( key );
			cursor = new CFBamRamISOLanguageCursor( Authorization,
				schema,
				subdictBaseIdx.values() );
		}
		else {
			cursor = new CFBamRamISOLanguageCursor( Authorization,
				schema,
				new ArrayList< CFBamISOLanguageBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openISOLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId )
	{
		CFBamCursor cursor;
		CFBamISOLanguageByCountryIdxKey key = schema.getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( ISOCountryId );

		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOLanguagePKey, CFBamISOLanguageBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			cursor = new CFBamRamISOLanguageCursor( Authorization,
				schema,
				subdictCountryIdx.values() );
		}
		else {
			cursor = new CFBamRamISOLanguageCursor( Authorization,
				schema,
				new ArrayList< CFBamISOLanguageBuff >() );
		}
		return( cursor );
	}

	public void closeISOLanguageCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOLanguageBuff nextISOLanguageCursor( CFBamCursor Cursor ) {
		CFBamRamISOLanguageCursor cursor = (CFBamRamISOLanguageCursor)Cursor;
		CFBamISOLanguageBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOLanguageBuff prevISOLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOLanguageBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOLanguageCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOLanguageBuff firstISOLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOLanguageBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOLanguageCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOLanguageBuff lastISOLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOLanguageCursor" );
	}

	public CFBamISOLanguageBuff nthISOLanguageCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOLanguageBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOLanguageCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
