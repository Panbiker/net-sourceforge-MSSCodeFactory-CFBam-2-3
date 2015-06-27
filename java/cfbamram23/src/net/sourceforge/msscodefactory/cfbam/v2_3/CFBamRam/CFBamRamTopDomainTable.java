
// Description: Java7 in-memory RAM DbIO implementation for TopDomain.

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
 *	CFBamRamTopDomainTable in-memory RAM DbIO implementation
 *	for TopDomain.
 */
public class CFBamRamTopDomainTable
	implements ICFBamTopDomainTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamTopDomainBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamTopDomainBuff >();
	private Map< CFBamTopDomainByTldIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamTopDomainBuff >> dictByTldIdx
		= new HashMap< CFBamTopDomainByTldIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamTopDomainBuff >>();
	private Map< CFBamTopDomainByNameIdxKey,
			CFBamTopDomainBuff > dictByNameIdx
		= new HashMap< CFBamTopDomainByNameIdxKey,
			CFBamTopDomainBuff >();

	public CFBamRamTopDomainTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTopDomain( CFBamAuthorization Authorization,
		CFBamTopDomainBuff Buff )
	{
		final String S_ProcName = "createTopDomain";
		schema.getTableDomainBase().createDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopDomainByTldIdxKey keyTldIdx = schema.getFactoryTopDomain().newTldIdxKey();
		keyTldIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTldIdx.setRequiredTldId( Buff.getRequiredTldId() );

		CFBamTopDomainByNameIdxKey keyNameIdx = schema.getFactoryTopDomain().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredTldId( Buff.getRequiredTldId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TopDomainNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"DomainBase",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTld().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTldId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Tld",
						"Tld",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdictTldIdx;
		if( dictByTldIdx.containsKey( keyTldIdx ) ) {
			subdictTldIdx = dictByTldIdx.get( keyTldIdx );
		}
		else {
			subdictTldIdx = new HashMap< CFBamDomainBasePKey, CFBamTopDomainBuff >();
			dictByTldIdx.put( keyTldIdx, subdictTldIdx );
		}
		subdictTldIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamTopDomainBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopDomain.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTopDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopDomain.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTopDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTopDomain.readAllDerived() ";
		CFBamTopDomainBuff[] retList = new CFBamTopDomainBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTopDomainBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTopDomainBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByTenantIdx() ";
		CFBamDomainBaseBuff buffList[] = schema.getTableDomainBase().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamDomainBaseBuff buff;
			ArrayList<CFBamTopDomainBuff> filteredList = new ArrayList<CFBamTopDomainBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTopDomainBuff ) ) {
					filteredList.add( (CFBamTopDomainBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTopDomainBuff[0] ) );
		}
	}

	public CFBamTopDomainBuff[] readDerivedByTldIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId )
	{
		final String S_ProcName = "CFBamRamTopDomain.readDerivedByTldIdx() ";
		CFBamTopDomainByTldIdxKey key = schema.getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );

		CFBamTopDomainBuff[] recArray;
		if( dictByTldIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdictTldIdx
				= dictByTldIdx.get( key );
			recArray = new CFBamTopDomainBuff[ subdictTldIdx.size() ];
			Iterator< CFBamTopDomainBuff > iter = subdictTldIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdictTldIdx
				= new HashMap< CFBamDomainBasePKey, CFBamTopDomainBuff >();
			dictByTldIdx.put( key, subdictTldIdx );
			recArray = new CFBamTopDomainBuff[0];
		}
		return( recArray );
	}

	public CFBamTopDomainBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTopDomain.readDerivedByNameIdx() ";
		CFBamTopDomainByNameIdxKey key = schema.getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );

		CFBamTopDomainBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTopDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopDomain.readBuff() ";
		CFBamTopDomainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TDOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopDomain.readBuff() ";
		CFBamTopDomainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TDOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopDomainBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTopDomain.readAllBuff() ";
		CFBamTopDomainBuff buff;
		ArrayList<CFBamTopDomainBuff> filteredList = new ArrayList<CFBamTopDomainBuff>();
		CFBamTopDomainBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TDOM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTopDomainBuff[0] ) );
	}

	public CFBamTopDomainBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamTopDomainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTopDomainBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamTopDomainBuff> filteredList = new ArrayList<CFBamTopDomainBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamTopDomainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTopDomainBuff[0] ) );
	}

	public CFBamTopDomainBuff[] readBuffByTldIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId )
	{
		final String S_ProcName = "CFBamRamTopDomain.readBuffByTldIdx() ";
		CFBamTopDomainBuff buff;
		ArrayList<CFBamTopDomainBuff> filteredList = new ArrayList<CFBamTopDomainBuff>();
		CFBamTopDomainBuff[] buffList = readDerivedByTldIdx( Authorization,
			TenantId,
			TldId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TDOM" ) ) {
				filteredList.add( (CFBamTopDomainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTopDomainBuff[0] ) );
	}

	public CFBamTopDomainBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTopDomain.readBuffByNameIdx() ";
		CFBamTopDomainBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			TldId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TDOM" ) ) {
			return( (CFBamTopDomainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTopDomain( CFBamAuthorization Authorization,
		CFBamTopDomainBuff Buff )
	{
		schema.getTableDomainBase().updateDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopDomainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTopDomain",
				"Existing record not found",
				"TopDomain",
				pkey );
		}
		CFBamTopDomainByTldIdxKey existingKeyTldIdx = schema.getFactoryTopDomain().newTldIdxKey();
		existingKeyTldIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTldIdx.setRequiredTldId( existing.getRequiredTldId() );

		CFBamTopDomainByTldIdxKey newKeyTldIdx = schema.getFactoryTopDomain().newTldIdxKey();
		newKeyTldIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTldIdx.setRequiredTldId( Buff.getRequiredTldId() );

		CFBamTopDomainByNameIdxKey existingKeyNameIdx = schema.getFactoryTopDomain().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredTldId( existing.getRequiredTldId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTopDomainByNameIdxKey newKeyNameIdx = schema.getFactoryTopDomain().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredTldId( Buff.getRequiredTldId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTopDomain",
					"TopDomainNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTopDomain",
						"Superclass",
						"SuperClass",
						"DomainBase",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTld().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTldId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTopDomain",
						"Container",
						"Tld",
						"Tld",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTldIdx.get( existingKeyTldIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTldIdx.containsKey( newKeyTldIdx ) ) {
			subdict = dictByTldIdx.get( newKeyTldIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamTopDomainBuff >();
			dictByTldIdx.put( newKeyTldIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteTopDomain( CFBamAuthorization Authorization,
		CFBamTopDomainBuff Buff )
	{
		final String S_ProcName = "CFBamRamTopDomainTable.deleteTopDomain() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopDomainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTopDomain",
				pkey );
		}
		CFBamTopDomainByTldIdxKey keyTldIdx = schema.getFactoryTopDomain().newTldIdxKey();
		keyTldIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTldIdx.setRequiredTldId( existing.getRequiredTldId() );

		CFBamTopDomainByNameIdxKey keyNameIdx = schema.getFactoryTopDomain().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredTldId( existing.getRequiredTldId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableDomain().deleteDomainBySubDomIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableTopProject().deleteTopProjectByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTldIdx.get( keyTldIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableDomainBase().deleteDomainBase( Authorization,
			Buff );
	}

	public void deleteTopDomainByTldIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTldId )
	{
		CFBamTopDomainByTldIdxKey key = schema.getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTldId( argTldId );
		deleteTopDomainByTldIdx( Authorization, key );
	}

	public void deleteTopDomainByTldIdx( CFBamAuthorization Authorization,
		CFBamTopDomainByTldIdxKey argKey )
	{
		CFBamTopDomainBuff cur;
		LinkedList<CFBamTopDomainBuff> matchSet = new LinkedList<CFBamTopDomainBuff>();
		Iterator<CFBamTopDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopDomain( Authorization, cur );
		}
	}

	public void deleteTopDomainByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTldId,
		String argName )
	{
		CFBamTopDomainByNameIdxKey key = schema.getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTldId( argTldId );
		key.setRequiredName( argName );
		deleteTopDomainByNameIdx( Authorization, key );
	}

	public void deleteTopDomainByNameIdx( CFBamAuthorization Authorization,
		CFBamTopDomainByNameIdxKey argKey )
	{
		CFBamTopDomainBuff cur;
		LinkedList<CFBamTopDomainBuff> matchSet = new LinkedList<CFBamTopDomainBuff>();
		Iterator<CFBamTopDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopDomain( Authorization, cur );
		}
	}

	public void deleteTopDomainByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTopDomainByIdIdx( Authorization, key );
	}

	public void deleteTopDomainByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamTopDomainBuff cur;
		LinkedList<CFBamTopDomainBuff> matchSet = new LinkedList<CFBamTopDomainBuff>();
		Iterator<CFBamTopDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopDomain( Authorization, cur );
		}
	}

	public void deleteTopDomainByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTopDomainByTenantIdx( Authorization, key );
	}

	public void deleteTopDomainByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamTopDomainBuff cur;
		LinkedList<CFBamTopDomainBuff> matchSet = new LinkedList<CFBamTopDomainBuff>();
		Iterator<CFBamTopDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopDomain( Authorization, cur );
		}
	}

	public CFBamCursor openTopDomainCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTopDomainCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTopDomainCursorByTldIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TldId )
	{
		CFBamCursor cursor;
		CFBamTopDomainByTldIdxKey key = schema.getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );

		if( dictByTldIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamTopDomainBuff > subdictTldIdx
				= dictByTldIdx.get( key );
			cursor = new CFBamRamTopDomainCursor( Authorization,
				schema,
				subdictTldIdx.values() );
		}
		else {
			cursor = new CFBamRamTopDomainCursor( Authorization,
				schema,
				new ArrayList< CFBamTopDomainBuff >() );
		}
		return( cursor );
	}

	public void closeTopDomainCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTopDomainBuff nextTopDomainCursor( CFBamCursor Cursor ) {
		CFBamRamTopDomainCursor cursor = (CFBamRamTopDomainCursor)Cursor;
		CFBamTopDomainBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTopDomainBuff prevTopDomainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTopDomainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopDomainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTopDomainBuff firstTopDomainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTopDomainBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopDomainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTopDomainBuff lastTopDomainCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTopDomainCursor" );
	}

	public CFBamTopDomainBuff nthTopDomainCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTopDomainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopDomainCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
