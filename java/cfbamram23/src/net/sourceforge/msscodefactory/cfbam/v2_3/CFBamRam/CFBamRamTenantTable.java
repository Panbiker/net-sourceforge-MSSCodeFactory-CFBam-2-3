
// Description: Java7 in-memory RAM DbIO implementation for Tenant.

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
 *	CFBamRamTenantTable in-memory RAM DbIO implementation
 *	for Tenant.
 */
public class CFBamRamTenantTable
	implements ICFBamTenantTable
{
	private CFBamRamSchema schema;
	private Map< CFBamTenantPKey,
				CFBamTenantBuff > dictByPKey
		= new HashMap< CFBamTenantPKey,
				CFBamTenantBuff >();
	private Map< CFBamTenantByClusterIdxKey,
				Map< CFBamTenantPKey,
					CFBamTenantBuff >> dictByClusterIdx
		= new HashMap< CFBamTenantByClusterIdxKey,
				Map< CFBamTenantPKey,
					CFBamTenantBuff >>();
	private Map< CFBamTenantByUNameIdxKey,
			CFBamTenantBuff > dictByUNameIdx
		= new HashMap< CFBamTenantByUNameIdxKey,
			CFBamTenantBuff >();
	private Map< CFBamRamTenantId32Gen,
				CFBamRamTenantId32Gen > id32Generator
		= new HashMap< CFBamRamTenantId32Gen,
				CFBamRamTenantId32Gen >();
	private Map< CFBamRamTenantId64Gen,
				CFBamRamTenantId64Gen > id64Generator
		= new HashMap< CFBamRamTenantId64Gen,
				CFBamRamTenantId64Gen >();

	public CFBamRamTenantTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	protected int generateNextId32( long argId,
		short argSliceId )
	{
		CFBamRamTenantId32Gen key = new CFBamRamTenantId32Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFBamRamTenantId32Gen useGen = id32Generator.get( key );
		if( useGen == null ) {
			id32Generator.put( key, key );
			useGen = key;
		}

		int retNext = useGen.getNextId();

		return( retNext );
	}

	protected long generateNextId64( long argId,
		short argSliceId )
	{
		CFBamRamTenantId64Gen key = new CFBamRamTenantId64Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFBamRamTenantId64Gen useGen = id64Generator.get( key );
		if( useGen == null ) {
			id64Generator.put( key, key );
			useGen = key;
		}

		long retNext = useGen.getNextId();

		return( retNext );
	}

	public int nextTSecGroupIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		int retval = nextTSecGroupIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextTSecGroupIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)113 );
		return( retNext );
	}

	public long nextTSecGroupMemberIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextTSecGroupMemberIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextTSecGroupMemberIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)114 );
		return( retNext );
	}

	public long nextTSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextTSecGroupIncludeIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextTSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)115 );
		return( retNext );
	}

	public long nextTldIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextTldIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextTldIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)211 );
		return( retNext );
	}

	public long nextDomainIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextDomainIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextDomainIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)212 );
		return( retNext );
	}

	public long nextScopeIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextScopeIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextScopeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1001 );
		return( retNext );
	}

	public long nextIndexColIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextIndexColIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextIndexColIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1003 );
		return( retNext );
	}

	public long nextLicenseIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextLicenseIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextLicenseIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1004 );
		return( retNext );
	}

	public long nextRelationColIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextRelationColIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextRelationColIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1006 );
		return( retNext );
	}

	public long nextValueIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextValueIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextValueIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1007 );
		return( retNext );
	}

	public long nextEnumTagIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextEnumTagIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextEnumTagIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1008 );
		return( retNext );
	}

	public long nextChainIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextChainIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextChainIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1009 );
		return( retNext );
	}

	public long nextParamIdGen( CFBamAuthorization Authorization,
		CFBamTenantPKey pkey )
	{
		long retval = nextParamIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextParamIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1010 );
		return( retNext );
	}

	public void createTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		final String S_ProcName = "createTenant";
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( schema.nextTenantIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamTenantByClusterIdxKey keyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamTenantByUNameIdxKey keyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TenantUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"TenantCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamTenantPKey, CFBamTenantBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamTenantPKey, CFBamTenantBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamTenantBuff readDerived( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "CFBamRamTenant.readDerived() ";
		CFBamTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "CFBamRamTenant.readDerived() ";
		CFBamTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTenant.readAllDerived() ";
		CFBamTenantBuff[] retList = new CFBamTenantBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTenantBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTenantBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamTenant.readDerivedByClusterIdx() ";
		CFBamTenantByClusterIdxKey key = schema.getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamTenantBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamTenantPKey, CFBamTenantBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamTenantBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamTenantBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTenantPKey, CFBamTenantBuff > subdictClusterIdx
				= new HashMap< CFBamTenantPKey, CFBamTenantBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamTenantBuff[0];
		}
		return( recArray );
	}

	public CFBamTenantBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFBamRamTenant.readDerivedByUNameIdx() ";
		CFBamTenantByUNameIdxKey key = schema.getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );

		CFBamTenantBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamRamTenant.readDerivedByIdIdx() ";
		CFBamTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( Id );

		CFBamTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff readBuff( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "CFBamRamTenant.readBuff() ";
		CFBamTenantBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TENT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTenantPKey PKey )
	{
		final String S_ProcName = "CFBamRamTenant.readBuff() ";
		CFBamTenantBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TENT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTenantBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTenant.readAllBuff() ";
		CFBamTenantBuff buff;
		ArrayList<CFBamTenantBuff> filteredList = new ArrayList<CFBamTenantBuff>();
		CFBamTenantBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTenantBuff[0] ) );
	}

	public CFBamTenantBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamRamTenant.readBuffByIdIdx() ";
		CFBamTenantBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
			return( (CFBamTenantBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTenantBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamTenant.readBuffByClusterIdx() ";
		CFBamTenantBuff buff;
		ArrayList<CFBamTenantBuff> filteredList = new ArrayList<CFBamTenantBuff>();
		CFBamTenantBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
				filteredList.add( (CFBamTenantBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTenantBuff[0] ) );
	}

	public CFBamTenantBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFBamRamTenant.readBuffByUNameIdx() ";
		CFBamTenantBuff buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			TenantName );
		if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
			return( (CFBamTenantBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTenantBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTenant",
				"Existing record not found",
				"Tenant",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateTenant",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamTenantByClusterIdxKey existingKeyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamTenantByClusterIdxKey newKeyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamTenantByUNameIdxKey existingKeyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );

		CFBamTenantByUNameIdxKey newKeyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTenant",
					"TenantUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTenant",
						"Container",
						"TenantCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamTenantPKey, CFBamTenantBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFBamTenantPKey, CFBamTenantBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteTenant( CFBamAuthorization Authorization,
		CFBamTenantBuff Buff )
	{
		final String S_ProcName = "CFBamRamTenantTable.deleteTenant() ";
		CFBamTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTenantBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTenant",
				pkey );
		}
		CFBamTenantByClusterIdxKey keyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamTenantByUNameIdxKey keyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTSecGroup().deleteTSecGroupByTenantIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableDomainBase().deleteDomainBaseByTenantIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableTld().deleteTldByTenantIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByCTenantIdx( Authorization,
			Buff.getRequiredId() );
		Map< CFBamTenantPKey, CFBamTenantBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteTenantByIdIdx( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( argId );
		deleteTenantByIdIdx( Authorization, key );
	}

	public void deleteTenantByIdIdx( CFBamAuthorization Authorization,
		CFBamTenantPKey argKey )
	{
		CFBamTenantBuff cur;
		LinkedList<CFBamTenantBuff> matchSet = new LinkedList<CFBamTenantBuff>();
		Iterator<CFBamTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTenant( Authorization, cur );
		}
	}

	public void deleteTenantByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamTenantByClusterIdxKey key = schema.getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteTenantByClusterIdx( Authorization, key );
	}

	public void deleteTenantByClusterIdx( CFBamAuthorization Authorization,
		CFBamTenantByClusterIdxKey argKey )
	{
		CFBamTenantBuff cur;
		LinkedList<CFBamTenantBuff> matchSet = new LinkedList<CFBamTenantBuff>();
		Iterator<CFBamTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTenant( Authorization, cur );
		}
	}

	public void deleteTenantByUNameIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argTenantName )
	{
		CFBamTenantByUNameIdxKey key = schema.getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredTenantName( argTenantName );
		deleteTenantByUNameIdx( Authorization, key );
	}

	public void deleteTenantByUNameIdx( CFBamAuthorization Authorization,
		CFBamTenantByUNameIdxKey argKey )
	{
		CFBamTenantBuff cur;
		LinkedList<CFBamTenantBuff> matchSet = new LinkedList<CFBamTenantBuff>();
		Iterator<CFBamTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTenant( Authorization, cur );
		}
	}

	public CFBamCursor openTenantCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTenantCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTenantCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamTenantByClusterIdxKey key = schema.getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamTenantPKey, CFBamTenantBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamTenantCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamTenantCursor( Authorization,
				schema,
				new ArrayList< CFBamTenantBuff >() );
		}
		return( cursor );
	}

	public void closeTenantCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTenantBuff nextTenantCursor( CFBamCursor Cursor ) {
		CFBamRamTenantCursor cursor = (CFBamRamTenantCursor)Cursor;
		CFBamTenantBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTenantBuff prevTenantCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTenantBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTenantCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTenantBuff firstTenantCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTenantBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTenantCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTenantBuff lastTenantCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTenantCursor" );
	}

	public CFBamTenantBuff nthTenantCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTenantBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTenantCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
