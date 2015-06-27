
// Description: Java7 in-memory RAM DbIO implementation for ISOTimezone.

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
 *	CFBamRamISOTimezoneTable in-memory RAM DbIO implementation
 *	for ISOTimezone.
 */
public class CFBamRamISOTimezoneTable
	implements ICFBamISOTimezoneTable
{
	private CFBamRamSchema schema;
	private Map< CFBamISOTimezonePKey,
				CFBamISOTimezoneBuff > dictByPKey
		= new HashMap< CFBamISOTimezonePKey,
				CFBamISOTimezoneBuff >();
	private Map< CFBamISOTimezoneByOffsetIdxKey,
				Map< CFBamISOTimezonePKey,
					CFBamISOTimezoneBuff >> dictByOffsetIdx
		= new HashMap< CFBamISOTimezoneByOffsetIdxKey,
				Map< CFBamISOTimezonePKey,
					CFBamISOTimezoneBuff >>();
	private Map< CFBamISOTimezoneByUTZNameIdxKey,
			CFBamISOTimezoneBuff > dictByUTZNameIdx
		= new HashMap< CFBamISOTimezoneByUTZNameIdxKey,
			CFBamISOTimezoneBuff >();
	private Map< CFBamISOTimezoneByIso8601IdxKey,
				Map< CFBamISOTimezonePKey,
					CFBamISOTimezoneBuff >> dictByIso8601Idx
		= new HashMap< CFBamISOTimezoneByIso8601IdxKey,
				Map< CFBamISOTimezonePKey,
					CFBamISOTimezoneBuff >>();

	public CFBamRamISOTimezoneTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		final String S_ProcName = "createISOTimezone";
		CFBamISOTimezonePKey pkey = schema.getFactoryISOTimezone().newPKey();
		pkey.setRequiredISOTimezoneId( Buff.getRequiredISOTimezoneId() );
		Buff.setRequiredISOTimezoneId( pkey.getRequiredISOTimezoneId() );
		CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx = schema.getFactoryISOTimezone().newOffsetIdxKey();
		keyOffsetIdx.setRequiredTZHourOffset( Buff.getRequiredTZHourOffset() );
		keyOffsetIdx.setRequiredTZMinOffset( Buff.getRequiredTZMinOffset() );

		CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		keyUTZNameIdx.setRequiredTZName( Buff.getRequiredTZName() );

		CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx = schema.getFactoryISOTimezone().newIso8601IdxKey();
		keyIso8601Idx.setRequiredIso8601( Buff.getRequiredIso8601() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUTZNameIdx.containsKey( keyUTZNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOTimezoneUTZNameIdx",
				keyUTZNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictOffsetIdx;
		if( dictByOffsetIdx.containsKey( keyOffsetIdx ) ) {
			subdictOffsetIdx = dictByOffsetIdx.get( keyOffsetIdx );
		}
		else {
			subdictOffsetIdx = new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByOffsetIdx.put( keyOffsetIdx, subdictOffsetIdx );
		}
		subdictOffsetIdx.put( pkey, Buff );

		dictByUTZNameIdx.put( keyUTZNameIdx, Buff );

		Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictIso8601Idx;
		if( dictByIso8601Idx.containsKey( keyIso8601Idx ) ) {
			subdictIso8601Idx = dictByIso8601Idx.get( keyIso8601Idx );
		}
		else {
			subdictIso8601Idx = new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByIso8601Idx.put( keyIso8601Idx, subdictIso8601Idx );
		}
		subdictIso8601Idx.put( pkey, Buff );

	}

	public CFBamISOTimezoneBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerived() ";
		CFBamISOTimezonePKey key = schema.getFactoryISOTimezone().newPKey();
		key.setRequiredISOTimezoneId( PKey.getRequiredISOTimezoneId() );
		CFBamISOTimezoneBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerived() ";
		CFBamISOTimezonePKey key = schema.getFactoryISOTimezone().newPKey();
		key.setRequiredISOTimezoneId( PKey.getRequiredISOTimezoneId() );
		CFBamISOTimezoneBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamISOTimezone.readAllDerived() ";
		CFBamISOTimezoneBuff[] retList = new CFBamISOTimezoneBuff[ dictByPKey.values().size() ];
		Iterator< CFBamISOTimezoneBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamISOTimezoneBuff[] readDerivedByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerivedByOffsetIdx() ";
		CFBamISOTimezoneByOffsetIdxKey key = schema.getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );

		CFBamISOTimezoneBuff[] recArray;
		if( dictByOffsetIdx.containsKey( key ) ) {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictOffsetIdx
				= dictByOffsetIdx.get( key );
			recArray = new CFBamISOTimezoneBuff[ subdictOffsetIdx.size() ];
			Iterator< CFBamISOTimezoneBuff > iter = subdictOffsetIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictOffsetIdx
				= new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByOffsetIdx.put( key, subdictOffsetIdx );
			recArray = new CFBamISOTimezoneBuff[0];
		}
		return( recArray );
	}

	public CFBamISOTimezoneBuff readDerivedByUTZNameIdx( CFBamAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerivedByUTZNameIdx() ";
		CFBamISOTimezoneByUTZNameIdxKey key = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );

		CFBamISOTimezoneBuff buff;
		if( dictByUTZNameIdx.containsKey( key ) ) {
			buff = dictByUTZNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readDerivedByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerivedByIso8601Idx() ";
		CFBamISOTimezoneByIso8601IdxKey key = schema.getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );

		CFBamISOTimezoneBuff[] recArray;
		if( dictByIso8601Idx.containsKey( key ) ) {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictIso8601Idx
				= dictByIso8601Idx.get( key );
			recArray = new CFBamISOTimezoneBuff[ subdictIso8601Idx.size() ];
			Iterator< CFBamISOTimezoneBuff > iter = subdictIso8601Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictIso8601Idx
				= new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByIso8601Idx.put( key, subdictIso8601Idx );
			recArray = new CFBamISOTimezoneBuff[0];
		}
		return( recArray );
	}

	public CFBamISOTimezoneBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOTimezoneId )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readDerivedByIdIdx() ";
		CFBamISOTimezonePKey key = schema.getFactoryISOTimezone().newPKey();
		key.setRequiredISOTimezoneId( ISOTimezoneId );

		CFBamISOTimezoneBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuff() ";
		CFBamISOTimezoneBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITZN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey PKey )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuff() ";
		CFBamISOTimezoneBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITZN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamISOTimezoneBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readAllBuff() ";
		CFBamISOTimezoneBuff buff;
		ArrayList<CFBamISOTimezoneBuff> filteredList = new ArrayList<CFBamISOTimezoneBuff>();
		CFBamISOTimezoneBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITZN" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamISOTimezoneBuff[0] ) );
	}

	public CFBamISOTimezoneBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOTimezoneId )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuffByIdIdx() ";
		CFBamISOTimezoneBuff buff = readDerivedByIdIdx( Authorization,
			ISOTimezoneId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITZN" ) ) {
			return( (CFBamISOTimezoneBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOTimezoneBuff[] readBuffByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuffByOffsetIdx() ";
		CFBamISOTimezoneBuff buff;
		ArrayList<CFBamISOTimezoneBuff> filteredList = new ArrayList<CFBamISOTimezoneBuff>();
		CFBamISOTimezoneBuff[] buffList = readDerivedByOffsetIdx( Authorization,
			TZHourOffset,
			TZMinOffset );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITZN" ) ) {
				filteredList.add( (CFBamISOTimezoneBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOTimezoneBuff[0] ) );
	}

	public CFBamISOTimezoneBuff readBuffByUTZNameIdx( CFBamAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuffByUTZNameIdx() ";
		CFBamISOTimezoneBuff buff = readDerivedByUTZNameIdx( Authorization,
			TZName );
		if( ( buff != null ) && buff.getClassCode().equals( "ITZN" ) ) {
			return( (CFBamISOTimezoneBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamISOTimezoneBuff[] readBuffByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "CFBamRamISOTimezone.readBuffByIso8601Idx() ";
		CFBamISOTimezoneBuff buff;
		ArrayList<CFBamISOTimezoneBuff> filteredList = new ArrayList<CFBamISOTimezoneBuff>();
		CFBamISOTimezoneBuff[] buffList = readDerivedByIso8601Idx( Authorization,
			Iso8601 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITZN" ) ) {
				filteredList.add( (CFBamISOTimezoneBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamISOTimezoneBuff[0] ) );
	}

	public void updateISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		CFBamISOTimezonePKey pkey = schema.getFactoryISOTimezone().newPKey();
		pkey.setRequiredISOTimezoneId( Buff.getRequiredISOTimezoneId() );
		CFBamISOTimezoneBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateISOTimezone",
				"Existing record not found",
				"ISOTimezone",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateISOTimezone",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamISOTimezoneByOffsetIdxKey existingKeyOffsetIdx = schema.getFactoryISOTimezone().newOffsetIdxKey();
		existingKeyOffsetIdx.setRequiredTZHourOffset( existing.getRequiredTZHourOffset() );
		existingKeyOffsetIdx.setRequiredTZMinOffset( existing.getRequiredTZMinOffset() );

		CFBamISOTimezoneByOffsetIdxKey newKeyOffsetIdx = schema.getFactoryISOTimezone().newOffsetIdxKey();
		newKeyOffsetIdx.setRequiredTZHourOffset( Buff.getRequiredTZHourOffset() );
		newKeyOffsetIdx.setRequiredTZMinOffset( Buff.getRequiredTZMinOffset() );

		CFBamISOTimezoneByUTZNameIdxKey existingKeyUTZNameIdx = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		existingKeyUTZNameIdx.setRequiredTZName( existing.getRequiredTZName() );

		CFBamISOTimezoneByUTZNameIdxKey newKeyUTZNameIdx = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		newKeyUTZNameIdx.setRequiredTZName( Buff.getRequiredTZName() );

		CFBamISOTimezoneByIso8601IdxKey existingKeyIso8601Idx = schema.getFactoryISOTimezone().newIso8601IdxKey();
		existingKeyIso8601Idx.setRequiredIso8601( existing.getRequiredIso8601() );

		CFBamISOTimezoneByIso8601IdxKey newKeyIso8601Idx = schema.getFactoryISOTimezone().newIso8601IdxKey();
		newKeyIso8601Idx.setRequiredIso8601( Buff.getRequiredIso8601() );

		// Check unique indexes

		if( ! existingKeyUTZNameIdx.equals( newKeyUTZNameIdx ) ) {
			if( dictByUTZNameIdx.containsKey( newKeyUTZNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateISOTimezone",
					"ISOTimezoneUTZNameIdx",
					newKeyUTZNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByOffsetIdx.get( existingKeyOffsetIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByOffsetIdx.containsKey( newKeyOffsetIdx ) ) {
			subdict = dictByOffsetIdx.get( newKeyOffsetIdx );
		}
		else {
			subdict = new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByOffsetIdx.put( newKeyOffsetIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUTZNameIdx.remove( existingKeyUTZNameIdx );
		dictByUTZNameIdx.put( newKeyUTZNameIdx, Buff );

		subdict = dictByIso8601Idx.get( existingKeyIso8601Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIso8601Idx.containsKey( newKeyIso8601Idx ) ) {
			subdict = dictByIso8601Idx.get( newKeyIso8601Idx );
		}
		else {
			subdict = new HashMap< CFBamISOTimezonePKey, CFBamISOTimezoneBuff >();
			dictByIso8601Idx.put( newKeyIso8601Idx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteISOTimezone( CFBamAuthorization Authorization,
		CFBamISOTimezoneBuff Buff )
	{
		final String S_ProcName = "CFBamRamISOTimezoneTable.deleteISOTimezone() ";
		CFBamISOTimezonePKey pkey = schema.getFactoryISOTimezone().newPKey();
		pkey.setRequiredISOTimezoneId( Buff.getRequiredISOTimezoneId() );
		CFBamISOTimezoneBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteISOTimezone",
				pkey );
		}
		CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx = schema.getFactoryISOTimezone().newOffsetIdxKey();
		keyOffsetIdx.setRequiredTZHourOffset( existing.getRequiredTZHourOffset() );
		keyOffsetIdx.setRequiredTZMinOffset( existing.getRequiredTZMinOffset() );

		CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		keyUTZNameIdx.setRequiredTZName( existing.getRequiredTZName() );

		CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx = schema.getFactoryISOTimezone().newIso8601IdxKey();
		keyIso8601Idx.setRequiredIso8601( existing.getRequiredIso8601() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByOffsetIdx.get( keyOffsetIdx );
		subdict.remove( pkey );

		dictByUTZNameIdx.remove( keyUTZNameIdx );

		subdict = dictByIso8601Idx.get( keyIso8601Idx );
		subdict.remove( pkey );

	}

	public void deleteISOTimezoneByIdIdx( CFBamAuthorization Authorization,
		short argISOTimezoneId )
	{
		CFBamISOTimezonePKey key = schema.getFactoryISOTimezone().newPKey();
		key.setRequiredISOTimezoneId( argISOTimezoneId );
		deleteISOTimezoneByIdIdx( Authorization, key );
	}

	public void deleteISOTimezoneByIdIdx( CFBamAuthorization Authorization,
		CFBamISOTimezonePKey argKey )
	{
		CFBamISOTimezoneBuff cur;
		LinkedList<CFBamISOTimezoneBuff> matchSet = new LinkedList<CFBamISOTimezoneBuff>();
		Iterator<CFBamISOTimezoneBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOTimezoneBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOTimezone( Authorization, cur );
		}
	}

	public void deleteISOTimezoneByOffsetIdx( CFBamAuthorization Authorization,
		short argTZHourOffset,
		short argTZMinOffset )
	{
		CFBamISOTimezoneByOffsetIdxKey key = schema.getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( argTZHourOffset );
		key.setRequiredTZMinOffset( argTZMinOffset );
		deleteISOTimezoneByOffsetIdx( Authorization, key );
	}

	public void deleteISOTimezoneByOffsetIdx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByOffsetIdxKey argKey )
	{
		CFBamISOTimezoneBuff cur;
		LinkedList<CFBamISOTimezoneBuff> matchSet = new LinkedList<CFBamISOTimezoneBuff>();
		Iterator<CFBamISOTimezoneBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOTimezoneBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOTimezone( Authorization, cur );
		}
	}

	public void deleteISOTimezoneByUTZNameIdx( CFBamAuthorization Authorization,
		String argTZName )
	{
		CFBamISOTimezoneByUTZNameIdxKey key = schema.getFactoryISOTimezone().newUTZNameIdxKey();
		key.setRequiredTZName( argTZName );
		deleteISOTimezoneByUTZNameIdx( Authorization, key );
	}

	public void deleteISOTimezoneByUTZNameIdx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByUTZNameIdxKey argKey )
	{
		CFBamISOTimezoneBuff cur;
		LinkedList<CFBamISOTimezoneBuff> matchSet = new LinkedList<CFBamISOTimezoneBuff>();
		Iterator<CFBamISOTimezoneBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOTimezoneBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOTimezone( Authorization, cur );
		}
	}

	public void deleteISOTimezoneByIso8601Idx( CFBamAuthorization Authorization,
		String argIso8601 )
	{
		CFBamISOTimezoneByIso8601IdxKey key = schema.getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( argIso8601 );
		deleteISOTimezoneByIso8601Idx( Authorization, key );
	}

	public void deleteISOTimezoneByIso8601Idx( CFBamAuthorization Authorization,
		CFBamISOTimezoneByIso8601IdxKey argKey )
	{
		CFBamISOTimezoneBuff cur;
		LinkedList<CFBamISOTimezoneBuff> matchSet = new LinkedList<CFBamISOTimezoneBuff>();
		Iterator<CFBamISOTimezoneBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamISOTimezoneBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteISOTimezone( Authorization, cur );
		}
	}

	public CFBamCursor openISOTimezoneCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamISOTimezoneCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openISOTimezoneCursorByOffsetIdx( CFBamAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		CFBamCursor cursor;
		CFBamISOTimezoneByOffsetIdxKey key = schema.getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );

		if( dictByOffsetIdx.containsKey( key ) ) {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictOffsetIdx
				= dictByOffsetIdx.get( key );
			cursor = new CFBamRamISOTimezoneCursor( Authorization,
				schema,
				subdictOffsetIdx.values() );
		}
		else {
			cursor = new CFBamRamISOTimezoneCursor( Authorization,
				schema,
				new ArrayList< CFBamISOTimezoneBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openISOTimezoneCursorByIso8601Idx( CFBamAuthorization Authorization,
		String Iso8601 )
	{
		CFBamCursor cursor;
		CFBamISOTimezoneByIso8601IdxKey key = schema.getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );

		if( dictByIso8601Idx.containsKey( key ) ) {
			Map< CFBamISOTimezonePKey, CFBamISOTimezoneBuff > subdictIso8601Idx
				= dictByIso8601Idx.get( key );
			cursor = new CFBamRamISOTimezoneCursor( Authorization,
				schema,
				subdictIso8601Idx.values() );
		}
		else {
			cursor = new CFBamRamISOTimezoneCursor( Authorization,
				schema,
				new ArrayList< CFBamISOTimezoneBuff >() );
		}
		return( cursor );
	}

	public void closeISOTimezoneCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamISOTimezoneBuff nextISOTimezoneCursor( CFBamCursor Cursor ) {
		CFBamRamISOTimezoneCursor cursor = (CFBamRamISOTimezoneCursor)Cursor;
		CFBamISOTimezoneBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamISOTimezoneBuff prevISOTimezoneCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamISOTimezoneBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOTimezoneCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOTimezoneBuff firstISOTimezoneCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamISOTimezoneBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOTimezoneCursor( Cursor );
		}
		return( rec );
	}

	public CFBamISOTimezoneBuff lastISOTimezoneCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastISOTimezoneCursor" );
	}

	public CFBamISOTimezoneBuff nthISOTimezoneCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamISOTimezoneBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextISOTimezoneCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
