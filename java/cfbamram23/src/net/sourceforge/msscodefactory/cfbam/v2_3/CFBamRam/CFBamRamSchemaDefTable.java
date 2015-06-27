
// Description: Java7 in-memory RAM DbIO implementation for SchemaDef.

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
 *	CFBamRamSchemaDefTable in-memory RAM DbIO implementation
 *	for SchemaDef.
 */
public class CFBamRamSchemaDefTable
	implements ICFBamSchemaDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamSchemaDefBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamSchemaDefBuff >();
	private Map< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByCTenantIdx
		= new HashMap< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByDomainIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByDomainIdx
		= new HashMap< CFBamSchemaDefByDomainIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByUNameIdxKey,
			CFBamSchemaDefBuff > dictByUNameIdx
		= new HashMap< CFBamSchemaDefByUNameIdxKey,
			CFBamSchemaDefBuff >();
	private Map< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByDefLcnIdx
		= new HashMap< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByDataScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByDataScopeIdx
		= new HashMap< CFBamSchemaDefByDataScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByVAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByVAccSecIdx
		= new HashMap< CFBamSchemaDefByVAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByVAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByVAccFreqIdx
		= new HashMap< CFBamSchemaDefByVAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByEAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByEAccSecIdx
		= new HashMap< CFBamSchemaDefByEAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByEAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >> dictByEAccFreqIdx
		= new HashMap< CFBamSchemaDefByEAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaDefBuff >>();
	private Map< CFBamSchemaDefByPubURIIdxKey,
			CFBamSchemaDefBuff > dictByPubURIIdx
		= new HashMap< CFBamSchemaDefByPubURIIdxKey,
			CFBamSchemaDefBuff >();

	public CFBamRamSchemaDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		final String S_ProcName = "createSchemaDef";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaDefByCTenantIdxKey keyCTenantIdx = schema.getFactorySchemaDef().newCTenantIdxKey();
		keyCTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamSchemaDefByDomainIdxKey keyDomainIdx = schema.getFactorySchemaDef().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamSchemaDefByUNameIdxKey keyUNameIdx = schema.getFactorySchemaDef().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx = schema.getFactorySchemaDef().newDefLcnIdxKey();
		keyDefLcnIdx.setOptionalDefaultLicenseTenantId( Buff.getOptionalDefaultLicenseTenantId() );
		keyDefLcnIdx.setOptionalDefaultLicenseId( Buff.getOptionalDefaultLicenseId() );

		CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx = schema.getFactorySchemaDef().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx = schema.getFactorySchemaDef().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx = schema.getFactorySchemaDef().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		CFBamSchemaDefByPubURIIdxKey keyPubURIIdx = schema.getFactorySchemaDef().newPubURIIdxKey();
		keyPubURIIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyPubURIIdx.setRequiredPublishURI( Buff.getRequiredPublishURI() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaDefUNameIdx",
				keyUNameIdx );
		}

		if( dictByPubURIIdx.containsKey( keyPubURIIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaPublishURIIdx",
				keyPubURIIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Scope",
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
						Buff.getRequiredDomainId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Domain",
						"DomainBase",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"CTenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictCTenantIdx;
		if( dictByCTenantIdx.containsKey( keyCTenantIdx ) ) {
			subdictCTenantIdx = dictByCTenantIdx.get( keyCTenantIdx );
		}
		else {
			subdictCTenantIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByCTenantIdx.put( keyCTenantIdx, subdictCTenantIdx );
		}
		subdictCTenantIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDomainIdx;
		if( dictByDomainIdx.containsKey( keyDomainIdx ) ) {
			subdictDomainIdx = dictByDomainIdx.get( keyDomainIdx );
		}
		else {
			subdictDomainIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDomainIdx.put( keyDomainIdx, subdictDomainIdx );
		}
		subdictDomainIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDefLcnIdx;
		if( dictByDefLcnIdx.containsKey( keyDefLcnIdx ) ) {
			subdictDefLcnIdx = dictByDefLcnIdx.get( keyDefLcnIdx );
		}
		else {
			subdictDefLcnIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDefLcnIdx.put( keyDefLcnIdx, subdictDefLcnIdx );
		}
		subdictDefLcnIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDataScopeIdx;
		if( dictByDataScopeIdx.containsKey( keyDataScopeIdx ) ) {
			subdictDataScopeIdx = dictByDataScopeIdx.get( keyDataScopeIdx );
		}
		else {
			subdictDataScopeIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDataScopeIdx.put( keyDataScopeIdx, subdictDataScopeIdx );
		}
		subdictDataScopeIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccSecIdx;
		if( dictByVAccSecIdx.containsKey( keyVAccSecIdx ) ) {
			subdictVAccSecIdx = dictByVAccSecIdx.get( keyVAccSecIdx );
		}
		else {
			subdictVAccSecIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccSecIdx.put( keyVAccSecIdx, subdictVAccSecIdx );
		}
		subdictVAccSecIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccFreqIdx;
		if( dictByVAccFreqIdx.containsKey( keyVAccFreqIdx ) ) {
			subdictVAccFreqIdx = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		}
		else {
			subdictVAccFreqIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccFreqIdx.put( keyVAccFreqIdx, subdictVAccFreqIdx );
		}
		subdictVAccFreqIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccSecIdx;
		if( dictByEAccSecIdx.containsKey( keyEAccSecIdx ) ) {
			subdictEAccSecIdx = dictByEAccSecIdx.get( keyEAccSecIdx );
		}
		else {
			subdictEAccSecIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccSecIdx.put( keyEAccSecIdx, subdictEAccSecIdx );
		}
		subdictEAccSecIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccFreqIdx;
		if( dictByEAccFreqIdx.containsKey( keyEAccFreqIdx ) ) {
			subdictEAccFreqIdx = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		}
		else {
			subdictEAccFreqIdx = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccFreqIdx.put( keyEAccFreqIdx, subdictEAccFreqIdx );
		}
		subdictEAccFreqIdx.put( pkey, Buff );

		dictByPubURIIdx.put( keyPubURIIdx, Buff );

	}

	public CFBamSchemaDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSchemaDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSchemaDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSchemaDef.readAllDerived() ";
		CFBamSchemaDefBuff[] retList = new CFBamSchemaDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSchemaDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSchemaDefBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByTenantIdx() ";
		CFBamScopeBuff buffList[] = schema.getTableScope().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamScopeBuff buff;
			ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamSchemaDefBuff ) ) {
					filteredList.add( (CFBamSchemaDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
		}
	}

	public CFBamSchemaDefBuff[] readDerivedByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByCTenantIdx() ";
		CFBamSchemaDefByCTenantIdxKey key = schema.getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByCTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictCTenantIdx
				= dictByCTenantIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictCTenantIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictCTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictCTenantIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByCTenantIdx.put( key, subdictCTenantIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByDomainIdx() ";
		CFBamSchemaDefByDomainIdxKey key = schema.getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictDomainIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictDomainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDomainIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDomainIdx.put( key, subdictDomainIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByUNameIdx() ";
		CFBamSchemaDefByUNameIdxKey key = schema.getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );

		CFBamSchemaDefBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff[] readDerivedByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByDefLcnIdx() ";
		CFBamSchemaDefByDefLcnIdxKey key = schema.getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByDefLcnIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDefLcnIdx
				= dictByDefLcnIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictDefLcnIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictDefLcnIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDefLcnIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDefLcnIdx.put( key, subdictDefLcnIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByDataScopeIdx() ";
		CFBamSchemaDefByDataScopeIdxKey key = schema.getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictDataScopeIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictDataScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDataScopeIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDataScopeIdx.put( key, subdictDataScopeIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByVAccSecIdx() ";
		CFBamSchemaDefByVAccSecIdxKey key = schema.getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictVAccSecIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictVAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccSecIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccSecIdx.put( key, subdictVAccSecIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByVAccFreqIdx() ";
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictVAccFreqIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictVAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccFreqIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccFreqIdx.put( key, subdictVAccFreqIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByEAccSecIdx() ";
		CFBamSchemaDefByEAccSecIdxKey key = schema.getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictEAccSecIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictEAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccSecIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccSecIdx.put( key, subdictEAccSecIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByEAccFreqIdx() ";
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		CFBamSchemaDefBuff[] recArray;
		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			recArray = new CFBamSchemaDefBuff[ subdictEAccFreqIdx.size() ];
			Iterator< CFBamSchemaDefBuff > iter = subdictEAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccFreqIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccFreqIdx.put( key, subdictEAccFreqIdx );
			recArray = new CFBamSchemaDefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaDefBuff readDerivedByPubURIIdx( CFBamAuthorization Authorization,
		long TenantId,
		String PublishURI )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readDerivedByPubURIIdx() ";
		CFBamSchemaDefByPubURIIdxKey key = schema.getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );

		CFBamSchemaDefBuff buff;
		if( dictByPubURIIdx.containsKey( key ) ) {
			buff = dictByPubURIIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamSchemaDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuff() ";
		CFBamSchemaDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCHM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuff() ";
		CFBamSchemaDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCHM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readAllBuff() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamSchemaDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSchemaDefBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByCTenantIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByCTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByDomainIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByDomainIdx( Authorization,
			TenantId,
			DomainId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByUNameIdx() ";
		CFBamSchemaDefBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			DomainId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
			return( (CFBamSchemaDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSchemaDefBuff[] readBuffByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByDefLcnIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByDefLcnIdx( Authorization,
			DefaultLicenseTenantId,
			DefaultLicenseId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByDataScopeIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByVAccSecIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByVAccFreqIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByEAccSecIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByEAccFreqIdx() ";
		CFBamSchemaDefBuff buff;
		ArrayList<CFBamSchemaDefBuff> filteredList = new ArrayList<CFBamSchemaDefBuff>();
		CFBamSchemaDefBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
				filteredList.add( (CFBamSchemaDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaDefBuff[0] ) );
	}

	public CFBamSchemaDefBuff readBuffByPubURIIdx( CFBamAuthorization Authorization,
		long TenantId,
		String PublishURI )
	{
		final String S_ProcName = "CFBamRamSchemaDef.readBuffByPubURIIdx() ";
		CFBamSchemaDefBuff buff = readDerivedByPubURIIdx( Authorization,
			TenantId,
			PublishURI );
		if( ( buff != null ) && buff.getClassCode().equals( "SCHM" ) ) {
			return( (CFBamSchemaDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSchemaDef",
				"Existing record not found",
				"SchemaDef",
				pkey );
		}
		CFBamSchemaDefByCTenantIdxKey existingKeyCTenantIdx = schema.getFactorySchemaDef().newCTenantIdxKey();
		existingKeyCTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamSchemaDefByCTenantIdxKey newKeyCTenantIdx = schema.getFactorySchemaDef().newCTenantIdxKey();
		newKeyCTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamSchemaDefByDomainIdxKey existingKeyDomainIdx = schema.getFactorySchemaDef().newDomainIdxKey();
		existingKeyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamSchemaDefByDomainIdxKey newKeyDomainIdx = schema.getFactorySchemaDef().newDomainIdxKey();
		newKeyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamSchemaDefByUNameIdxKey existingKeyUNameIdx = schema.getFactorySchemaDef().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSchemaDefByUNameIdxKey newKeyUNameIdx = schema.getFactorySchemaDef().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamSchemaDefByDefLcnIdxKey existingKeyDefLcnIdx = schema.getFactorySchemaDef().newDefLcnIdxKey();
		existingKeyDefLcnIdx.setOptionalDefaultLicenseTenantId( existing.getOptionalDefaultLicenseTenantId() );
		existingKeyDefLcnIdx.setOptionalDefaultLicenseId( existing.getOptionalDefaultLicenseId() );

		CFBamSchemaDefByDefLcnIdxKey newKeyDefLcnIdx = schema.getFactorySchemaDef().newDefLcnIdxKey();
		newKeyDefLcnIdx.setOptionalDefaultLicenseTenantId( Buff.getOptionalDefaultLicenseTenantId() );
		newKeyDefLcnIdx.setOptionalDefaultLicenseId( Buff.getOptionalDefaultLicenseId() );

		CFBamSchemaDefByDataScopeIdxKey existingKeyDataScopeIdx = schema.getFactorySchemaDef().newDataScopeIdxKey();
		existingKeyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamSchemaDefByDataScopeIdxKey newKeyDataScopeIdx = schema.getFactorySchemaDef().newDataScopeIdxKey();
		newKeyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamSchemaDefByVAccSecIdxKey existingKeyVAccSecIdx = schema.getFactorySchemaDef().newVAccSecIdxKey();
		existingKeyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamSchemaDefByVAccSecIdxKey newKeyVAccSecIdx = schema.getFactorySchemaDef().newVAccSecIdxKey();
		newKeyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamSchemaDefByVAccFreqIdxKey existingKeyVAccFreqIdx = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		existingKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamSchemaDefByVAccFreqIdxKey newKeyVAccFreqIdx = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		newKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamSchemaDefByEAccSecIdxKey existingKeyEAccSecIdx = schema.getFactorySchemaDef().newEAccSecIdxKey();
		existingKeyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamSchemaDefByEAccSecIdxKey newKeyEAccSecIdx = schema.getFactorySchemaDef().newEAccSecIdxKey();
		newKeyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamSchemaDefByEAccFreqIdxKey existingKeyEAccFreqIdx = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		existingKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );

		CFBamSchemaDefByEAccFreqIdxKey newKeyEAccFreqIdx = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		newKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		CFBamSchemaDefByPubURIIdxKey existingKeyPubURIIdx = schema.getFactorySchemaDef().newPubURIIdxKey();
		existingKeyPubURIIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyPubURIIdx.setRequiredPublishURI( existing.getRequiredPublishURI() );

		CFBamSchemaDefByPubURIIdxKey newKeyPubURIIdx = schema.getFactorySchemaDef().newPubURIIdxKey();
		newKeyPubURIIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyPubURIIdx.setRequiredPublishURI( Buff.getRequiredPublishURI() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSchemaDef",
					"SchemaDefUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeyPubURIIdx.equals( newKeyPubURIIdx ) ) {
			if( dictByPubURIIdx.containsKey( newKeyPubURIIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSchemaDef",
					"SchemaPublishURIIdx",
					newKeyPubURIIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Superclass",
						"SuperClass",
						"Scope",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredDomainId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Container",
						"Domain",
						"DomainBase",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Owner",
						"CTenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByCTenantIdx.get( existingKeyCTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCTenantIdx.containsKey( newKeyCTenantIdx ) ) {
			subdict = dictByCTenantIdx.get( newKeyCTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByCTenantIdx.put( newKeyCTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDomainIdx.get( existingKeyDomainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDomainIdx.containsKey( newKeyDomainIdx ) ) {
			subdict = dictByDomainIdx.get( newKeyDomainIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDomainIdx.put( newKeyDomainIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByDefLcnIdx.get( existingKeyDefLcnIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefLcnIdx.containsKey( newKeyDefLcnIdx ) ) {
			subdict = dictByDefLcnIdx.get( newKeyDefLcnIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDefLcnIdx.put( newKeyDefLcnIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDataScopeIdx.get( existingKeyDataScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDataScopeIdx.containsKey( newKeyDataScopeIdx ) ) {
			subdict = dictByDataScopeIdx.get( newKeyDataScopeIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByDataScopeIdx.put( newKeyDataScopeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByVAccSecIdx.get( existingKeyVAccSecIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByVAccSecIdx.containsKey( newKeyVAccSecIdx ) ) {
			subdict = dictByVAccSecIdx.get( newKeyVAccSecIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccSecIdx.put( newKeyVAccSecIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByVAccFreqIdx.get( existingKeyVAccFreqIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByVAccFreqIdx.containsKey( newKeyVAccFreqIdx ) ) {
			subdict = dictByVAccFreqIdx.get( newKeyVAccFreqIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByVAccFreqIdx.put( newKeyVAccFreqIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEAccSecIdx.get( existingKeyEAccSecIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEAccSecIdx.containsKey( newKeyEAccSecIdx ) ) {
			subdict = dictByEAccSecIdx.get( newKeyEAccSecIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccSecIdx.put( newKeyEAccSecIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEAccFreqIdx.get( existingKeyEAccFreqIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEAccFreqIdx.containsKey( newKeyEAccFreqIdx ) ) {
			subdict = dictByEAccFreqIdx.get( newKeyEAccFreqIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaDefBuff >();
			dictByEAccFreqIdx.put( newKeyEAccFreqIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByPubURIIdx.remove( existingKeyPubURIIdx );
		dictByPubURIIdx.put( newKeyPubURIIdx, Buff );

	}

	public void deleteSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamSchemaDefTable.deleteSchemaDef() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSchemaDef",
				pkey );
		}
		CFBamSchemaDefByCTenantIdxKey keyCTenantIdx = schema.getFactorySchemaDef().newCTenantIdxKey();
		keyCTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamSchemaDefByDomainIdxKey keyDomainIdx = schema.getFactorySchemaDef().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamSchemaDefByUNameIdxKey keyUNameIdx = schema.getFactorySchemaDef().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx = schema.getFactorySchemaDef().newDefLcnIdxKey();
		keyDefLcnIdx.setOptionalDefaultLicenseTenantId( existing.getOptionalDefaultLicenseTenantId() );
		keyDefLcnIdx.setOptionalDefaultLicenseId( existing.getOptionalDefaultLicenseId() );

		CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx = schema.getFactorySchemaDef().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx = schema.getFactorySchemaDef().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx = schema.getFactorySchemaDef().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );

		CFBamSchemaDefByPubURIIdxKey keyPubURIIdx = schema.getFactorySchemaDef().newPubURIIdxKey();
		keyPubURIIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyPubURIIdx.setRequiredPublishURI( existing.getRequiredPublishURI() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTable().deleteTableBySchemaDefIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableValue().deleteValueByScopeIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaRef().deleteSchemaRefBySchemaIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamSchemaDefBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCTenantIdx.get( keyCTenantIdx );
		subdict.remove( pkey );

		subdict = dictByDomainIdx.get( keyDomainIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByDefLcnIdx.get( keyDefLcnIdx );
		subdict.remove( pkey );

		subdict = dictByDataScopeIdx.get( keyDataScopeIdx );
		subdict.remove( pkey );

		subdict = dictByVAccSecIdx.get( keyVAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		subdict.remove( pkey );

		subdict = dictByEAccSecIdx.get( keyEAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		subdict.remove( pkey );

		dictByPubURIIdx.remove( keyPubURIIdx );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteSchemaDefByCTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamSchemaDefByCTenantIdxKey key = schema.getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaDefByCTenantIdx( Authorization, key );
	}

	public void deleteSchemaDefByCTenantIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByCTenantIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByDomainIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId )
	{
		CFBamSchemaDefByDomainIdxKey key = schema.getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		deleteSchemaDefByDomainIdx( Authorization, key );
	}

	public void deleteSchemaDefByDomainIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDomainIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		CFBamSchemaDefByUNameIdxKey key = schema.getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		key.setRequiredName( argName );
		deleteSchemaDefByUNameIdx( Authorization, key );
	}

	public void deleteSchemaDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByUNameIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByDefLcnIdx( CFBamAuthorization Authorization,
		Long argDefaultLicenseTenantId,
		Long argDefaultLicenseId )
	{
		CFBamSchemaDefByDefLcnIdxKey key = schema.getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( argDefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( argDefaultLicenseId );
		deleteSchemaDefByDefLcnIdx( Authorization, key );
	}

	public void deleteSchemaDefByDefLcnIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDefLcnIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamSchemaDefByDataScopeIdxKey key = schema.getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteSchemaDefByDataScopeIdx( Authorization, key );
	}

	public void deleteSchemaDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDataScopeIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamSchemaDefByVAccSecIdxKey key = schema.getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteSchemaDefByVAccSecIdx( Authorization, key );
	}

	public void deleteSchemaDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByVAccSecIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteSchemaDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteSchemaDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByVAccFreqIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamSchemaDefByEAccSecIdxKey key = schema.getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteSchemaDefByEAccSecIdx( Authorization, key );
	}

	public void deleteSchemaDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByEAccSecIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteSchemaDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteSchemaDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByEAccFreqIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByPubURIIdx( CFBamAuthorization Authorization,
		long argTenantId,
		String argPublishURI )
	{
		CFBamSchemaDefByPubURIIdxKey key = schema.getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredPublishURI( argPublishURI );
		deleteSchemaDefByPubURIIdx( Authorization, key );
	}

	public void deleteSchemaDefByPubURIIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByPubURIIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteSchemaDefByIdIdx( Authorization, key );
	}

	public void deleteSchemaDefByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public void deleteSchemaDefByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaDefByTenantIdx( Authorization, key );
	}

	public void deleteSchemaDefByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamSchemaDefBuff cur;
		LinkedList<CFBamSchemaDefBuff> matchSet = new LinkedList<CFBamSchemaDefBuff>();
		Iterator<CFBamSchemaDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaDef( Authorization, cur );
		}
	}

	public CFBamCursor openSchemaDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSchemaDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByCTenantIdxKey key = schema.getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByCTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictCTenantIdx
				= dictByCTenantIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictCTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByDomainIdxKey key = schema.getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictDomainIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByDefLcnIdxKey key = schema.getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );

		if( dictByDefLcnIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDefLcnIdx
				= dictByDefLcnIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictDefLcnIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByDataScopeIdxKey key = schema.getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictDataScopeIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByVAccSecIdxKey key = schema.getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictVAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictVAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByEAccSecIdxKey key = schema.getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictEAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaDefBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				subdictEAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaDefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaDefBuff >() );
		}
		return( cursor );
	}

	public void closeSchemaDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSchemaDefBuff nextSchemaDefCursor( CFBamCursor Cursor ) {
		CFBamRamSchemaDefCursor cursor = (CFBamRamSchemaDefCursor)Cursor;
		CFBamSchemaDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSchemaDefBuff prevSchemaDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSchemaDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSchemaDefBuff firstSchemaDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSchemaDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSchemaDefBuff lastSchemaDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSchemaDefCursor" );
	}

	public CFBamSchemaDefBuff nthSchemaDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSchemaDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
