
// Description: Java7 in-memory RAM DbIO implementation for ISOCountryLanguage.

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
 *	CFBamRamISOCountryLanguageTable in-memory RAM DbIO implementation
 *	for ISOCountryLanguage.
 */
public class CFBamRamISOCountryLanguageTable
	implements ICFBamISOCountryLanguageTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOCountryLanguagePKey,
				CFBamISOCountryLanguageBuff > dictByPKey
		= new HashMap< CFBamISOCountryLanguagePKey,
				CFBamISOCountryLanguageBuff >();
	private Map< CFBamISOCountryLanguageByCountryIdxKey,
				Map< CFBamISOCountryLanguagePKey,
					CFBamISOCountryLanguageBuff >> dictByCountryIdx
		= new HashMap< CFBamISOCountryLanguageByCountryIdxKey,
				Map< CFBamISOCountryLanguagePKey,
					CFBamISOCountryLanguageBuff >>();
	private Map< CFBamISOCountryLanguageByLanguageIdxKey,
				Map< CFBamISOCountryLanguagePKey,
					CFBamISOCountryLanguageBuff >> dictByLanguageIdx
		= new HashMap< CFBamISOCountryLanguageByLanguageIdxKey,
				Map< CFBamISOCountryLanguagePKey,
					CFBamISOCountryLanguageBuff >>();

	public CFBamRamISOCountryLanguageTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		final String S_ProcName = "createISOCountryLanguage";
		CFBamISOCountryLanguagePKey pkey = schema.getFactoryISOCountryLanguage().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOLanguageId( Buff.getRequiredISOLanguageId() );
		Buff.setRequiredISOCountryId( pkey.getRequiredISOCountryId() );
		Buff.setRequiredISOLanguageId( pkey.getRequiredISOLanguageId() );
		CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		keyCountryIdx.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );

		CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		keyLanguageIdx.setRequiredISOLanguageId( Buff.getRequiredISOLanguageId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableISOCountry().readDerivedByIdIdx( Authorization,
						Buff.getRequiredISOCountryId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ISOCountryLanguageCountry",
						"ISOCountry",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictCountryIdx;
		if( dictByCountryIdx.containsKey( keyCountryIdx ) ) {
			subdictCountryIdx = dictByCountryIdx.get( keyCountryIdx );
		}
		else {
			subdictCountryIdx = new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByCountryIdx.put( keyCountryIdx, subdictCountryIdx );
		}
		subdictCountryIdx.put( pkey, Buff );

		Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictLanguageIdx;
		if( dictByLanguageIdx.containsKey( keyLanguageIdx ) ) {
			subdictLanguageIdx = dictByLanguageIdx.get( keyLanguageIdx );
		}
		else {
			subdictLanguageIdx = new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByLanguageIdx.put( keyLanguageIdx, subdictLanguageIdx );
		}
		subdictLanguageIdx.put( pkey, Buff );

	}

	public CFBamISOCountryLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readDerived() ";
		CFBamISOCountryLanguagePKey key = schema.getFactoryISOCountryLanguage().newPKey();
		key.setRequiredISOCountryId( PKey.getRequiredISOCountryId() );
		key.setRequiredISOLanguageId( PKey.getRequiredISOLanguageId() );
		CFBamISOCountryLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readDerived() ";
		CFBamISOCountryLanguagePKey key = schema.getFactoryISOCountryLanguage().newPKey();
		key.setRequiredISOCountryId( PKey.getRequiredISOCountryId() );
		key.setRequiredISOLanguageId( PKey.getRequiredISOLanguageId() );
		CFBamISOCountryLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOCountryLanguage.readAllDerived() ";
		CFBamISOCountryLanguageBuff[] retList = new CFBamISOCountryLanguageBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOCountryLanguageBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOCountryLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readDerivedByCountryIdx() ";
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );

		CFBamISOCountryLanguageBuff[] recArray;
		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			recArray = new CFBamISOCountryLanguageBuff[ subdictCountryIdx.size() ];
			Iterator< CFBamISOCountryLanguageBuff > iter = subdictCountryIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictCountryIdx
				= new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByCountryIdx.put( key, subdictCountryIdx );
			recArray = new CFBamISOCountryLanguageBuff[0];
		}
		return( recArray );
	}

	public CFBamISOCountryLanguageBuff[] readDerivedByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readDerivedByLanguageIdx() ";
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( ISOLanguageId );

		CFBamISOCountryLanguageBuff[] recArray;
		if( dictByLanguageIdx.containsKey( key ) ) {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictLanguageIdx
				= dictByLanguageIdx.get( key );
			recArray = new CFBamISOCountryLanguageBuff[ subdictLanguageIdx.size() ];
			Iterator< CFBamISOCountryLanguageBuff > iter = subdictLanguageIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictLanguageIdx
				= new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByLanguageIdx.put( key, subdictLanguageIdx );
			recArray = new CFBamISOCountryLanguageBuff[0];
		}
		return( recArray );
	}

	public CFBamISOCountryLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOLanguageId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readDerivedByIdIdx() ";
		CFBamISOCountryLanguagePKey key = schema.getFactoryISOCountryLanguage().newPKey();
		key.setRequiredISOCountryId( ISOCountryId );
		key.setRequiredISOLanguageId( ISOLanguageId );

		CFBamISOCountryLanguageBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readBuff() ";
		CFBamISOCountryLanguageBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISCL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readBuff() ";
		CFBamISOCountryLanguageBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ISCL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readAllBuff() ";
		CFBamISOCountryLanguageBuff buff;
		ArrayList<CFBamISOCountryLanguageBuff> filteredList = new ArrayList<CFBamISOCountryLanguageBuff>();
		CFBamISOCountryLanguageBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISCL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryLanguageBuff[0] ) );
	}

	public CFBamISOCountryLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOLanguageId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readBuffByIdIdx() ";
		CFBamISOCountryLanguageBuff buff = readDerivedByIdIdx( Authorization,
			ISOCountryId,
			ISOLanguageId );
		if( ( buff != null ) && buff.getClassCode().equals( "ISCL" ) ) {
			return( (CFBamISOCountryLanguageBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCountryLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readBuffByCountryIdx() ";
		CFBamISOCountryLanguageBuff buff;
		ArrayList<CFBamISOCountryLanguageBuff> filteredList = new ArrayList<CFBamISOCountryLanguageBuff>();
		CFBamISOCountryLanguageBuff[] buffList = readDerivedByCountryIdx( Authorization,
			ISOCountryId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISCL" ) ) {
				filteredList.add( (CFBamISOCountryLanguageBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryLanguageBuff[0] ) );
	}

	public CFBamISOCountryLanguageBuff[] readBuffByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguage.readBuffByLanguageIdx() ";
		CFBamISOCountryLanguageBuff buff;
		ArrayList<CFBamISOCountryLanguageBuff> filteredList = new ArrayList<CFBamISOCountryLanguageBuff>();
		CFBamISOCountryLanguageBuff[] buffList = readDerivedByLanguageIdx( Authorization,
			ISOLanguageId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ISCL" ) ) {
				filteredList.add( (CFBamISOCountryLanguageBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryLanguageBuff[0] ) );
	}

	public void updateISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		CFBamISOCountryLanguagePKey pkey = schema.getFactoryISOCountryLanguage().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOLanguageId( Buff.getRequiredISOLanguageId() );
		CFBamISOCountryLanguageBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOCountryLanguage",
				"Existing record not found",
				"ISOCountryLanguage",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOCountryLanguage",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOCountryLanguageByCountryIdxKey existingKeyCountryIdx = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		existingKeyCountryIdx.setRequiredISOCountryId( existing.getRequiredISOCountryId() );

		CFBamISOCountryLanguageByCountryIdxKey newKeyCountryIdx = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		newKeyCountryIdx.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );

		CFBamISOCountryLanguageByLanguageIdxKey existingKeyLanguageIdx = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		existingKeyLanguageIdx.setRequiredISOLanguageId( existing.getRequiredISOLanguageId() );

		CFBamISOCountryLanguageByLanguageIdxKey newKeyLanguageIdx = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		newKeyLanguageIdx.setRequiredISOLanguageId( Buff.getRequiredISOLanguageId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableISOCountry().readDerivedByIdIdx( Authorization,
						Buff.getRequiredISOCountryId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateISOCountryLanguage",
						"Container",
						"ISOCountryLanguageCountry",
						"ISOCountry",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByCountryIdx.get( existingKeyCountryIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCountryIdx.containsKey( newKeyCountryIdx ) ) {
			subdict = dictByCountryIdx.get( newKeyCountryIdx );
		}
		else {
			subdict = new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByCountryIdx.put( newKeyCountryIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLanguageIdx.get( existingKeyLanguageIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLanguageIdx.containsKey( newKeyLanguageIdx ) ) {
			subdict = dictByLanguageIdx.get( newKeyLanguageIdx );
		}
		else {
			subdict = new HashMap< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff >();
			dictByLanguageIdx.put( newKeyLanguageIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOCountryLanguageTable.deleteISOCountryLanguage() ";
		CFBamISOCountryLanguagePKey pkey = schema.getFactoryISOCountryLanguage().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOLanguageId( Buff.getRequiredISOLanguageId() );
		CFBamISOCountryLanguageBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOCountryLanguage",
				pkey );
		}
		CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		keyCountryIdx.setRequiredISOCountryId( existing.getRequiredISOCountryId() );

		CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		keyLanguageIdx.setRequiredISOLanguageId( existing.getRequiredISOLanguageId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCountryIdx.get( keyCountryIdx );
		subdict.remove( pkey );

		subdict = dictByLanguageIdx.get( keyLanguageIdx );
		subdict.remove( pkey );

	}

	public void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOLanguageId )
	{
		CFBamISOCountryLanguagePKey key = schema.getFactoryISOCountryLanguage().newPKey();
		key.setRequiredISOCountryId( argISOCountryId );
		key.setRequiredISOLanguageId( argISOLanguageId );
		deleteISOCountryLanguageByIdIdx( Authorization, key );
	}

	public void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey argKey )
	{
		CFBamISOCountryLanguageBuff cur;
		LinkedList<CFBamISOCountryLanguageBuff> matchSet = new LinkedList<CFBamISOCountryLanguageBuff>();
		Iterator<CFBamISOCountryLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryLanguage( Authorization, cur );
		}
	}

	public void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( argISOCountryId );
		deleteISOCountryLanguageByCountryIdx( Authorization, key );
	}

	public void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByCountryIdxKey argKey )
	{
		CFBamISOCountryLanguageBuff cur;
		LinkedList<CFBamISOCountryLanguageBuff> matchSet = new LinkedList<CFBamISOCountryLanguageBuff>();
		Iterator<CFBamISOCountryLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryLanguage( Authorization, cur );
		}
	}

	public void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId )
	{
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( argISOLanguageId );
		deleteISOCountryLanguageByLanguageIdx( Authorization, key );
	}

	public void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByLanguageIdxKey argKey )
	{
		CFBamISOCountryLanguageBuff cur;
		LinkedList<CFBamISOCountryLanguageBuff> matchSet = new LinkedList<CFBamISOCountryLanguageBuff>();
		Iterator<CFBamISOCountryLanguageBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryLanguageBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryLanguage( Authorization, cur );
		}
	}

	public CFBamCursor openISOCountryLanguageCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOCountryLanguageCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openISOCountryLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		CFBamCursor cursor;
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );

		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			cursor = new CFBamRamISOCountryLanguageCursor( Authorization,
				schema,
				subdictCountryIdx.values() );
		}
		else {
			cursor = new CFBamRamISOCountryLanguageCursor( Authorization,
				schema,
				new ArrayList< CFBamISOCountryLanguageBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openISOCountryLanguageCursorByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId )
	{
		CFBamCursor cursor;
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( ISOLanguageId );

		if( dictByLanguageIdx.containsKey( key ) ) {
			Map< CFBamISOCountryLanguagePKey, CFBamISOCountryLanguageBuff > subdictLanguageIdx
				= dictByLanguageIdx.get( key );
			cursor = new CFBamRamISOCountryLanguageCursor( Authorization,
				schema,
				subdictLanguageIdx.values() );
		}
		else {
			cursor = new CFBamRamISOCountryLanguageCursor( Authorization,
				schema,
				new ArrayList< CFBamISOCountryLanguageBuff >() );
		}
		return( cursor );
	}

	public void closeISOCountryLanguageCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOCountryLanguageBuff nextISOCountryLanguageCursor( CFBamCursor Cursor ) {
		CFBamRamISOCountryLanguageCursor cursor = (CFBamRamISOCountryLanguageCursor)Cursor;
		CFBamISOCountryLanguageBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOCountryLanguageBuff prevISOCountryLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOCountryLanguageBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryLanguageCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryLanguageBuff firstISOCountryLanguageCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOCountryLanguageBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryLanguageCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryLanguageBuff lastISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff nthISOCountryLanguageCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOCountryLanguageBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryLanguageCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
