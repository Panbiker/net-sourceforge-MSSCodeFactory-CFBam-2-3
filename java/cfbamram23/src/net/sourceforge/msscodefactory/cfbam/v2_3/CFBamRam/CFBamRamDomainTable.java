
// Description: Java7 in-memory RAM DbIO implementation for Domain.

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
 *	CFBamRamDomainTable in-memory RAM DbIO implementation
 *	for Domain.
 */
public class CFBamRamDomainTable
	implements ICFBamDomainTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamDomainBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamDomainBuff >();
	private Map< CFBamDomainBySubDomIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamDomainBuff >> dictBySubDomIdx
		= new HashMap< CFBamDomainBySubDomIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamDomainBuff >>();
	private Map< CFBamDomainByNameIdxKey,
			CFBamDomainBuff > dictByNameIdx
		= new HashMap< CFBamDomainByNameIdxKey,
			CFBamDomainBuff >();

	public CFBamRamDomainTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDomain( CFBamAuthorization Authorization,
		CFBamDomainBuff Buff )
	{
		final String S_ProcName = "createDomain";
		schema.getTableDomainBase().createDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDomainBySubDomIdxKey keySubDomIdx = schema.getFactoryDomain().newSubDomIdxKey();
		keySubDomIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySubDomIdx.setRequiredSubDomainOfId( Buff.getRequiredSubDomainOfId() );

		CFBamDomainByNameIdxKey keyNameIdx = schema.getFactoryDomain().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredSubDomainOfId( Buff.getRequiredSubDomainOfId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DomainNameIdx",
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
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSubDomainOfId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ParentDomain",
						"DomainBase",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamDomainBuff > subdictSubDomIdx;
		if( dictBySubDomIdx.containsKey( keySubDomIdx ) ) {
			subdictSubDomIdx = dictBySubDomIdx.get( keySubDomIdx );
		}
		else {
			subdictSubDomIdx = new HashMap< CFBamDomainBasePKey, CFBamDomainBuff >();
			dictBySubDomIdx.put( keySubDomIdx, subdictSubDomIdx );
		}
		subdictSubDomIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamDomainBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomain.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomain.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDomain.readAllDerived() ";
		CFBamDomainBuff[] retList = new CFBamDomainBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDomainBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDomainBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDomainBuff> filteredList = new ArrayList<CFBamDomainBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDomainBuff ) ) {
					filteredList.add( (CFBamDomainBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDomainBuff[0] ) );
		}
	}

	public CFBamDomainBuff[] readDerivedBySubDomIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SubDomainOfId )
	{
		final String S_ProcName = "CFBamRamDomain.readDerivedBySubDomIdx() ";
		CFBamDomainBySubDomIdxKey key = schema.getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );

		CFBamDomainBuff[] recArray;
		if( dictBySubDomIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamDomainBuff > subdictSubDomIdx
				= dictBySubDomIdx.get( key );
			recArray = new CFBamDomainBuff[ subdictSubDomIdx.size() ];
			Iterator< CFBamDomainBuff > iter = subdictSubDomIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamDomainBuff > subdictSubDomIdx
				= new HashMap< CFBamDomainBasePKey, CFBamDomainBuff >();
			dictBySubDomIdx.put( key, subdictSubDomIdx );
			recArray = new CFBamDomainBuff[0];
		}
		return( recArray );
	}

	public CFBamDomainBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SubDomainOfId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDomain.readDerivedByNameIdx() ";
		CFBamDomainByNameIdxKey key = schema.getFactoryDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		key.setRequiredName( Name );

		CFBamDomainBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDomainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomain.readBuff() ";
		CFBamDomainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DOMN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomain.readBuff() ";
		CFBamDomainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DOMN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDomain.readAllBuff() ";
		CFBamDomainBuff buff;
		ArrayList<CFBamDomainBuff> filteredList = new ArrayList<CFBamDomainBuff>();
		CFBamDomainBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DOMN" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDomainBuff[0] ) );
	}

	public CFBamDomainBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamDomainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDomainBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamDomainBuff> filteredList = new ArrayList<CFBamDomainBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamDomainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDomainBuff[0] ) );
	}

	public CFBamDomainBuff[] readBuffBySubDomIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SubDomainOfId )
	{
		final String S_ProcName = "CFBamRamDomain.readBuffBySubDomIdx() ";
		CFBamDomainBuff buff;
		ArrayList<CFBamDomainBuff> filteredList = new ArrayList<CFBamDomainBuff>();
		CFBamDomainBuff[] buffList = readDerivedBySubDomIdx( Authorization,
			TenantId,
			SubDomainOfId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DOMN" ) ) {
				filteredList.add( (CFBamDomainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDomainBuff[0] ) );
	}

	public CFBamDomainBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SubDomainOfId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDomain.readBuffByNameIdx() ";
		CFBamDomainBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			SubDomainOfId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DOMN" ) ) {
			return( (CFBamDomainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDomain( CFBamAuthorization Authorization,
		CFBamDomainBuff Buff )
	{
		schema.getTableDomainBase().updateDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDomainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDomain",
				"Existing record not found",
				"Domain",
				pkey );
		}
		CFBamDomainBySubDomIdxKey existingKeySubDomIdx = schema.getFactoryDomain().newSubDomIdxKey();
		existingKeySubDomIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySubDomIdx.setRequiredSubDomainOfId( existing.getRequiredSubDomainOfId() );

		CFBamDomainBySubDomIdxKey newKeySubDomIdx = schema.getFactoryDomain().newSubDomIdxKey();
		newKeySubDomIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySubDomIdx.setRequiredSubDomainOfId( Buff.getRequiredSubDomainOfId() );

		CFBamDomainByNameIdxKey existingKeyNameIdx = schema.getFactoryDomain().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredSubDomainOfId( existing.getRequiredSubDomainOfId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDomainByNameIdxKey newKeyNameIdx = schema.getFactoryDomain().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredSubDomainOfId( Buff.getRequiredSubDomainOfId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDomain",
					"DomainNameIdx",
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
						"updateDomain",
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
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSubDomainOfId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDomain",
						"Container",
						"ParentDomain",
						"DomainBase",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamDomainBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySubDomIdx.get( existingKeySubDomIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySubDomIdx.containsKey( newKeySubDomIdx ) ) {
			subdict = dictBySubDomIdx.get( newKeySubDomIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamDomainBuff >();
			dictBySubDomIdx.put( newKeySubDomIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteDomain( CFBamAuthorization Authorization,
		CFBamDomainBuff Buff )
	{
		final String S_ProcName = "CFBamRamDomainTable.deleteDomain() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDomainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDomain",
				pkey );
		}
		CFBamDomainBySubDomIdxKey keySubDomIdx = schema.getFactoryDomain().newSubDomIdxKey();
		keySubDomIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySubDomIdx.setRequiredSubDomainOfId( existing.getRequiredSubDomainOfId() );

		CFBamDomainByNameIdxKey keyNameIdx = schema.getFactoryDomain().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredSubDomainOfId( existing.getRequiredSubDomainOfId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTopProject().deleteTopProjectByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamDomainBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySubDomIdx.get( keySubDomIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableDomainBase().deleteDomainBase( Authorization,
			Buff );
	}

	public void deleteDomainBySubDomIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSubDomainOfId )
	{
		CFBamDomainBySubDomIdxKey key = schema.getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSubDomainOfId( argSubDomainOfId );
		deleteDomainBySubDomIdx( Authorization, key );
	}

	public void deleteDomainBySubDomIdx( CFBamAuthorization Authorization,
		CFBamDomainBySubDomIdxKey argKey )
	{
		CFBamDomainBuff cur;
		LinkedList<CFBamDomainBuff> matchSet = new LinkedList<CFBamDomainBuff>();
		Iterator<CFBamDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDomain( Authorization, cur );
		}
	}

	public void deleteDomainByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSubDomainOfId,
		String argName )
	{
		CFBamDomainByNameIdxKey key = schema.getFactoryDomain().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSubDomainOfId( argSubDomainOfId );
		key.setRequiredName( argName );
		deleteDomainByNameIdx( Authorization, key );
	}

	public void deleteDomainByNameIdx( CFBamAuthorization Authorization,
		CFBamDomainByNameIdxKey argKey )
	{
		CFBamDomainBuff cur;
		LinkedList<CFBamDomainBuff> matchSet = new LinkedList<CFBamDomainBuff>();
		Iterator<CFBamDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDomain( Authorization, cur );
		}
	}

	public void deleteDomainByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDomainByIdIdx( Authorization, key );
	}

	public void deleteDomainByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamDomainBuff cur;
		LinkedList<CFBamDomainBuff> matchSet = new LinkedList<CFBamDomainBuff>();
		Iterator<CFBamDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDomain( Authorization, cur );
		}
	}

	public void deleteDomainByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDomainByTenantIdx( Authorization, key );
	}

	public void deleteDomainByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamDomainBuff cur;
		LinkedList<CFBamDomainBuff> matchSet = new LinkedList<CFBamDomainBuff>();
		Iterator<CFBamDomainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDomain( Authorization, cur );
		}
	}

	public CFBamCursor openDomainCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDomainCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDomainCursorBySubDomIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SubDomainOfId )
	{
		CFBamCursor cursor;
		CFBamDomainBySubDomIdxKey key = schema.getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );

		if( dictBySubDomIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamDomainBuff > subdictSubDomIdx
				= dictBySubDomIdx.get( key );
			cursor = new CFBamRamDomainCursor( Authorization,
				schema,
				subdictSubDomIdx.values() );
		}
		else {
			cursor = new CFBamRamDomainCursor( Authorization,
				schema,
				new ArrayList< CFBamDomainBuff >() );
		}
		return( cursor );
	}

	public void closeDomainCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDomainBuff nextDomainCursor( CFBamCursor Cursor ) {
		CFBamRamDomainCursor cursor = (CFBamRamDomainCursor)Cursor;
		CFBamDomainBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDomainBuff prevDomainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDomainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDomainBuff firstDomainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDomainBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDomainBuff lastDomainCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDomainCursor" );
	}

	public CFBamDomainBuff nthDomainCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDomainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
