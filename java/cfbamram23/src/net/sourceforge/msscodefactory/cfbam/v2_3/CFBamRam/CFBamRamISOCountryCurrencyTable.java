
// Description: Java7 in-memory RAM DbIO implementation for ISOCountryCurrency.

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
 *	CFBamRamISOCountryCurrencyTable in-memory RAM DbIO implementation
 *	for ISOCountryCurrency.
 */
public class CFBamRamISOCountryCurrencyTable
	implements ICFBamISOCountryCurrencyTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOCountryCurrencyPKey,
				CFBamISOCountryCurrencyBuff > dictByPKey
		= new HashMap< CFBamISOCountryCurrencyPKey,
				CFBamISOCountryCurrencyBuff >();
	private Map< CFBamISOCountryCurrencyByCountryIdxKey,
				Map< CFBamISOCountryCurrencyPKey,
					CFBamISOCountryCurrencyBuff >> dictByCountryIdx
		= new HashMap< CFBamISOCountryCurrencyByCountryIdxKey,
				Map< CFBamISOCountryCurrencyPKey,
					CFBamISOCountryCurrencyBuff >>();
	private Map< CFBamISOCountryCurrencyByCurrencyIdxKey,
				Map< CFBamISOCountryCurrencyPKey,
					CFBamISOCountryCurrencyBuff >> dictByCurrencyIdx
		= new HashMap< CFBamISOCountryCurrencyByCurrencyIdxKey,
				Map< CFBamISOCountryCurrencyPKey,
					CFBamISOCountryCurrencyBuff >>();

	public CFBamRamISOCountryCurrencyTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		final String S_ProcName = "createISOCountryCurrency";
		CFBamISOCountryCurrencyPKey pkey = schema.getFactoryISOCountryCurrency().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOCurrencyId( Buff.getRequiredISOCurrencyId() );
		Buff.setRequiredISOCountryId( pkey.getRequiredISOCountryId() );
		Buff.setRequiredISOCurrencyId( pkey.getRequiredISOCurrencyId() );
		CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		keyCountryIdx.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );

		CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		keyCurrencyIdx.setRequiredISOCurrencyId( Buff.getRequiredISOCurrencyId() );

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
						"ISOCountryCurrencyCountry",
						"ISOCountry",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCountryIdx;
		if( dictByCountryIdx.containsKey( keyCountryIdx ) ) {
			subdictCountryIdx = dictByCountryIdx.get( keyCountryIdx );
		}
		else {
			subdictCountryIdx = new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCountryIdx.put( keyCountryIdx, subdictCountryIdx );
		}
		subdictCountryIdx.put( pkey, Buff );

		Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCurrencyIdx;
		if( dictByCurrencyIdx.containsKey( keyCurrencyIdx ) ) {
			subdictCurrencyIdx = dictByCurrencyIdx.get( keyCurrencyIdx );
		}
		else {
			subdictCurrencyIdx = new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCurrencyIdx.put( keyCurrencyIdx, subdictCurrencyIdx );
		}
		subdictCurrencyIdx.put( pkey, Buff );

	}

	public CFBamISOCountryCurrencyBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readDerived() ";
		CFBamISOCountryCurrencyPKey key = schema.getFactoryISOCountryCurrency().newPKey();
		key.setRequiredISOCountryId( PKey.getRequiredISOCountryId() );
		key.setRequiredISOCurrencyId( PKey.getRequiredISOCurrencyId() );
		CFBamISOCountryCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readDerived() ";
		CFBamISOCountryCurrencyPKey key = schema.getFactoryISOCountryCurrency().newPKey();
		key.setRequiredISOCountryId( PKey.getRequiredISOCountryId() );
		key.setRequiredISOCurrencyId( PKey.getRequiredISOCurrencyId() );
		CFBamISOCountryCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOCountryCurrency.readAllDerived() ";
		CFBamISOCountryCurrencyBuff[] retList = new CFBamISOCountryCurrencyBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOCountryCurrencyBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOCountryCurrencyBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readDerivedByCountryIdx() ";
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );

		CFBamISOCountryCurrencyBuff[] recArray;
		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			recArray = new CFBamISOCountryCurrencyBuff[ subdictCountryIdx.size() ];
			Iterator< CFBamISOCountryCurrencyBuff > iter = subdictCountryIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCountryIdx
				= new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCountryIdx.put( key, subdictCountryIdx );
			recArray = new CFBamISOCountryCurrencyBuff[0];
		}
		return( recArray );
	}

	public CFBamISOCountryCurrencyBuff[] readDerivedByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readDerivedByCurrencyIdx() ";
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( ISOCurrencyId );

		CFBamISOCountryCurrencyBuff[] recArray;
		if( dictByCurrencyIdx.containsKey( key ) ) {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCurrencyIdx
				= dictByCurrencyIdx.get( key );
			recArray = new CFBamISOCountryCurrencyBuff[ subdictCurrencyIdx.size() ];
			Iterator< CFBamISOCountryCurrencyBuff > iter = subdictCurrencyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCurrencyIdx
				= new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCurrencyIdx.put( key, subdictCurrencyIdx );
			recArray = new CFBamISOCountryCurrencyBuff[0];
		}
		return( recArray );
	}

	public CFBamISOCountryCurrencyBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOCurrencyId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readDerivedByIdIdx() ";
		CFBamISOCountryCurrencyPKey key = schema.getFactoryISOCountryCurrency().newPKey();
		key.setRequiredISOCountryId( ISOCountryId );
		key.setRequiredISOCurrencyId( ISOCurrencyId );

		CFBamISOCountryCurrencyBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readBuff() ";
		CFBamISOCountryCurrencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ICCY" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey PKey )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readBuff() ";
		CFBamISOCountryCurrencyBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ICCY" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOCountryCurrencyBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readAllBuff() ";
		CFBamISOCountryCurrencyBuff buff;
		ArrayList<CFBamISOCountryCurrencyBuff> filteredList = new ArrayList<CFBamISOCountryCurrencyBuff>();
		CFBamISOCountryCurrencyBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ICCY" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryCurrencyBuff[0] ) );
	}

	public CFBamISOCountryCurrencyBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOCurrencyId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readBuffByIdIdx() ";
		CFBamISOCountryCurrencyBuff buff = readDerivedByIdIdx( Authorization,
			ISOCountryId,
			ISOCurrencyId );
		if( ( buff != null ) && buff.getClassCode().equals( "ICCY" ) ) {
			return( (CFBamISOCountryCurrencyBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOCountryCurrencyBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readBuffByCountryIdx() ";
		CFBamISOCountryCurrencyBuff buff;
		ArrayList<CFBamISOCountryCurrencyBuff> filteredList = new ArrayList<CFBamISOCountryCurrencyBuff>();
		CFBamISOCountryCurrencyBuff[] buffList = readDerivedByCountryIdx( Authorization,
			ISOCountryId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ICCY" ) ) {
				filteredList.add( (CFBamISOCountryCurrencyBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryCurrencyBuff[0] ) );
	}

	public CFBamISOCountryCurrencyBuff[] readBuffByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrency.readBuffByCurrencyIdx() ";
		CFBamISOCountryCurrencyBuff buff;
		ArrayList<CFBamISOCountryCurrencyBuff> filteredList = new ArrayList<CFBamISOCountryCurrencyBuff>();
		CFBamISOCountryCurrencyBuff[] buffList = readDerivedByCurrencyIdx( Authorization,
			ISOCurrencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ICCY" ) ) {
				filteredList.add( (CFBamISOCountryCurrencyBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOCountryCurrencyBuff[0] ) );
	}

	public void updateISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		CFBamISOCountryCurrencyPKey pkey = schema.getFactoryISOCountryCurrency().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOCurrencyId( Buff.getRequiredISOCurrencyId() );
		CFBamISOCountryCurrencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOCountryCurrency",
				"Existing record not found",
				"ISOCountryCurrency",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOCountryCurrency",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOCountryCurrencyByCountryIdxKey existingKeyCountryIdx = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		existingKeyCountryIdx.setRequiredISOCountryId( existing.getRequiredISOCountryId() );

		CFBamISOCountryCurrencyByCountryIdxKey newKeyCountryIdx = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		newKeyCountryIdx.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );

		CFBamISOCountryCurrencyByCurrencyIdxKey existingKeyCurrencyIdx = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		existingKeyCurrencyIdx.setRequiredISOCurrencyId( existing.getRequiredISOCurrencyId() );

		CFBamISOCountryCurrencyByCurrencyIdxKey newKeyCurrencyIdx = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		newKeyCurrencyIdx.setRequiredISOCurrencyId( Buff.getRequiredISOCurrencyId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableISOCountry().readDerivedByIdIdx( Authorization,
						Buff.getRequiredISOCountryId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateISOCountryCurrency",
						"Container",
						"ISOCountryCurrencyCountry",
						"ISOCountry",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdict;

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
			subdict = new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCountryIdx.put( newKeyCountryIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByCurrencyIdx.get( existingKeyCurrencyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCurrencyIdx.containsKey( newKeyCurrencyIdx ) ) {
			subdict = dictByCurrencyIdx.get( newKeyCurrencyIdx );
		}
		else {
			subdict = new HashMap< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff >();
			dictByCurrencyIdx.put( newKeyCurrencyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteISOCountryCurrency( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOCountryCurrencyTable.deleteISOCountryCurrency() ";
		CFBamISOCountryCurrencyPKey pkey = schema.getFactoryISOCountryCurrency().newPKey();
		pkey.setRequiredISOCountryId( Buff.getRequiredISOCountryId() );
		pkey.setRequiredISOCurrencyId( Buff.getRequiredISOCurrencyId() );
		CFBamISOCountryCurrencyBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOCountryCurrency",
				pkey );
		}
		CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		keyCountryIdx.setRequiredISOCountryId( existing.getRequiredISOCountryId() );

		CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		keyCurrencyIdx.setRequiredISOCurrencyId( existing.getRequiredISOCurrencyId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCountryIdx.get( keyCountryIdx );
		subdict.remove( pkey );

		subdict = dictByCurrencyIdx.get( keyCurrencyIdx );
		subdict.remove( pkey );

	}

	public void deleteISOCountryCurrencyByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOCurrencyId )
	{
		CFBamISOCountryCurrencyPKey key = schema.getFactoryISOCountryCurrency().newPKey();
		key.setRequiredISOCountryId( argISOCountryId );
		key.setRequiredISOCurrencyId( argISOCurrencyId );
		deleteISOCountryCurrencyByIdIdx( Authorization, key );
	}

	public void deleteISOCountryCurrencyByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyPKey argKey )
	{
		CFBamISOCountryCurrencyBuff cur;
		LinkedList<CFBamISOCountryCurrencyBuff> matchSet = new LinkedList<CFBamISOCountryCurrencyBuff>();
		Iterator<CFBamISOCountryCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryCurrency( Authorization, cur );
		}
	}

	public void deleteISOCountryCurrencyByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( argISOCountryId );
		deleteISOCountryCurrencyByCountryIdx( Authorization, key );
	}

	public void deleteISOCountryCurrencyByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyByCountryIdxKey argKey )
	{
		CFBamISOCountryCurrencyBuff cur;
		LinkedList<CFBamISOCountryCurrencyBuff> matchSet = new LinkedList<CFBamISOCountryCurrencyBuff>();
		Iterator<CFBamISOCountryCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryCurrency( Authorization, cur );
		}
	}

	public void deleteISOCountryCurrencyByCurrencyIdx( CFBamAuthorization Authorization,
		short argISOCurrencyId )
	{
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( argISOCurrencyId );
		deleteISOCountryCurrencyByCurrencyIdx( Authorization, key );
	}

	public void deleteISOCountryCurrencyByCurrencyIdx( CFBamAuthorization Authorization,
		CFBamISOCountryCurrencyByCurrencyIdxKey argKey )
	{
		CFBamISOCountryCurrencyBuff cur;
		LinkedList<CFBamISOCountryCurrencyBuff> matchSet = new LinkedList<CFBamISOCountryCurrencyBuff>();
		Iterator<CFBamISOCountryCurrencyBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOCountryCurrencyBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOCountryCurrency( Authorization, cur );
		}
	}

	public CFBamCursor openISOCountryCurrencyCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOCountryCurrencyCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openISOCountryCurrencyCursorByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId )
	{
		CFBamCursor cursor;
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );

		if( dictByCountryIdx.containsKey( key ) ) {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCountryIdx
				= dictByCountryIdx.get( key );
			cursor = new CFBamRamISOCountryCurrencyCursor( Authorization,
				schema,
				subdictCountryIdx.values() );
		}
		else {
			cursor = new CFBamRamISOCountryCurrencyCursor( Authorization,
				schema,
				new ArrayList< CFBamISOCountryCurrencyBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openISOCountryCurrencyCursorByCurrencyIdx( CFBamAuthorization Authorization,
		short ISOCurrencyId )
	{
		CFBamCursor cursor;
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( ISOCurrencyId );

		if( dictByCurrencyIdx.containsKey( key ) ) {
			Map< CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff > subdictCurrencyIdx
				= dictByCurrencyIdx.get( key );
			cursor = new CFBamRamISOCountryCurrencyCursor( Authorization,
				schema,
				subdictCurrencyIdx.values() );
		}
		else {
			cursor = new CFBamRamISOCountryCurrencyCursor( Authorization,
				schema,
				new ArrayList< CFBamISOCountryCurrencyBuff >() );
		}
		return( cursor );
	}

	public void closeISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOCountryCurrencyBuff nextISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		CFBamRamISOCountryCurrencyCursor cursor = (CFBamRamISOCountryCurrencyCursor)Cursor;
		CFBamISOCountryCurrencyBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOCountryCurrencyBuff prevISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOCountryCurrencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryCurrencyBuff firstISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOCountryCurrencyBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOCountryCurrencyBuff lastISOCountryCurrencyCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOCountryCurrencyCursor" );
	}

	public CFBamISOCountryCurrencyBuff nthISOCountryCurrencyCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOCountryCurrencyBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOCountryCurrencyCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
