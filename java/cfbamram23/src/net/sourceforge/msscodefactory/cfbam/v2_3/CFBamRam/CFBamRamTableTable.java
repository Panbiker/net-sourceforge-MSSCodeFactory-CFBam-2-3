
// Description: Java7 in-memory RAM DbIO implementation for Table.

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
 *	CFBamRamTableTable in-memory RAM DbIO implementation
 *	for Table.
 */
public class CFBamRamTableTable
	implements ICFBamTableTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamTableBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamTableBuff >();
	private Map< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictBySchemaDefIdx
		= new HashMap< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByUNameIdxKey,
			CFBamTableBuff > dictByUNameIdx
		= new HashMap< CFBamTableByUNameIdxKey,
			CFBamTableBuff >();
	private Map< CFBamTableBySchemaCdIdxKey,
			CFBamTableBuff > dictBySchemaCdIdx
		= new HashMap< CFBamTableBySchemaCdIdxKey,
			CFBamTableBuff >();
	private Map< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByPrimaryIndexIdx
		= new HashMap< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByLookupIndexIdx
		= new HashMap< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByAltIndexIdx
		= new HashMap< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByQualTableIdx
		= new HashMap< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByLoadBehaveIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByLoadBehaveIdx
		= new HashMap< CFBamTableByLoadBehaveIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByDataScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByDataScopeIdx
		= new HashMap< CFBamTableByDataScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableBySecScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictBySecScopeIdx
		= new HashMap< CFBamTableBySecScopeIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByVAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByVAccSecIdx
		= new HashMap< CFBamTableByVAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByVAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByVAccFreqIdx
		= new HashMap< CFBamTableByVAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByEAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByEAccSecIdx
		= new HashMap< CFBamTableByEAccSecIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();
	private Map< CFBamTableByEAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >> dictByEAccFreqIdx
		= new HashMap< CFBamTableByEAccFreqIdxKey,
				Map< CFBamScopePKey,
					CFBamTableBuff >>();

	public CFBamRamTableTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "createTable";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTableBySchemaDefIdxKey keySchemaDefIdx = schema.getFactoryTable().newSchemaDefIdxKey();
		keySchemaDefIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySchemaDefIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		CFBamTableByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryTable().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamTableByUNameIdxKey keyUNameIdx = schema.getFactoryTable().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamTableBySchemaCdIdxKey keySchemaCdIdx = schema.getFactoryTable().newSchemaCdIdxKey();
		keySchemaCdIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySchemaCdIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keySchemaCdIdx.setRequiredTableClassCode( Buff.getRequiredTableClassCode() );

		CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx = schema.getFactoryTable().newPrimaryIndexIdxKey();
		keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( Buff.getOptionalPrimaryIndexTenantId() );
		keyPrimaryIndexIdx.setOptionalPrimaryIndexId( Buff.getOptionalPrimaryIndexId() );

		CFBamTableByLookupIndexIdxKey keyLookupIndexIdx = schema.getFactoryTable().newLookupIndexIdxKey();
		keyLookupIndexIdx.setOptionalLookupIndexTenantId( Buff.getOptionalLookupIndexTenantId() );
		keyLookupIndexIdx.setOptionalLookupIndexId( Buff.getOptionalLookupIndexId() );

		CFBamTableByAltIndexIdxKey keyAltIndexIdx = schema.getFactoryTable().newAltIndexIdxKey();
		keyAltIndexIdx.setOptionalAltIndexTenantId( Buff.getOptionalAltIndexTenantId() );
		keyAltIndexIdx.setOptionalAltIndexId( Buff.getOptionalAltIndexId() );

		CFBamTableByQualTableIdxKey keyQualTableIdx = schema.getFactoryTable().newQualTableIdxKey();
		keyQualTableIdx.setOptionalQualifyingTenantId( Buff.getOptionalQualifyingTenantId() );
		keyQualTableIdx.setOptionalQualifyingTableId( Buff.getOptionalQualifyingTableId() );

		CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx = schema.getFactoryTable().newLoadBehaveIdxKey();
		keyLoadBehaveIdx.setRequiredLoaderBehaviourId( Buff.getRequiredLoaderBehaviourId() );

		CFBamTableByDataScopeIdxKey keyDataScopeIdx = schema.getFactoryTable().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamTableBySecScopeIdxKey keySecScopeIdx = schema.getFactoryTable().newSecScopeIdxKey();
		keySecScopeIdx.setRequiredSecurityScopeId( Buff.getRequiredSecurityScopeId() );

		CFBamTableByVAccSecIdxKey keyVAccSecIdx = schema.getFactoryTable().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamTableByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactoryTable().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamTableByEAccSecIdxKey keyEAccSecIdx = schema.getFactoryTable().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamTableByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactoryTable().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableUNameIdx",
				keyUNameIdx );
		}

		if( dictBySchemaCdIdx.containsKey( keySchemaCdIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableSchemaCodeIdx",
				keySchemaCdIdx );
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
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSchemaDefId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableLoaderBehaviour().readDerivedByIdIdx( Authorization,
						Buff.getRequiredLoaderBehaviourId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"LoaderBehaviour",
						"LoaderBehaviour",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecurityScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecurityScopeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"SecurityScope",
						"SecurityScope",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictSchemaDefIdx;
		if( dictBySchemaDefIdx.containsKey( keySchemaDefIdx ) ) {
			subdictSchemaDefIdx = dictBySchemaDefIdx.get( keySchemaDefIdx );
		}
		else {
			subdictSchemaDefIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySchemaDefIdx.put( keySchemaDefIdx, subdictSchemaDefIdx );
		}
		subdictSchemaDefIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		dictBySchemaCdIdx.put( keySchemaCdIdx, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictPrimaryIndexIdx;
		if( dictByPrimaryIndexIdx.containsKey( keyPrimaryIndexIdx ) ) {
			subdictPrimaryIndexIdx = dictByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
		}
		else {
			subdictPrimaryIndexIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByPrimaryIndexIdx.put( keyPrimaryIndexIdx, subdictPrimaryIndexIdx );
		}
		subdictPrimaryIndexIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictLookupIndexIdx;
		if( dictByLookupIndexIdx.containsKey( keyLookupIndexIdx ) ) {
			subdictLookupIndexIdx = dictByLookupIndexIdx.get( keyLookupIndexIdx );
		}
		else {
			subdictLookupIndexIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLookupIndexIdx.put( keyLookupIndexIdx, subdictLookupIndexIdx );
		}
		subdictLookupIndexIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictAltIndexIdx;
		if( dictByAltIndexIdx.containsKey( keyAltIndexIdx ) ) {
			subdictAltIndexIdx = dictByAltIndexIdx.get( keyAltIndexIdx );
		}
		else {
			subdictAltIndexIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByAltIndexIdx.put( keyAltIndexIdx, subdictAltIndexIdx );
		}
		subdictAltIndexIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictQualTableIdx;
		if( dictByQualTableIdx.containsKey( keyQualTableIdx ) ) {
			subdictQualTableIdx = dictByQualTableIdx.get( keyQualTableIdx );
		}
		else {
			subdictQualTableIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByQualTableIdx.put( keyQualTableIdx, subdictQualTableIdx );
		}
		subdictQualTableIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictLoadBehaveIdx;
		if( dictByLoadBehaveIdx.containsKey( keyLoadBehaveIdx ) ) {
			subdictLoadBehaveIdx = dictByLoadBehaveIdx.get( keyLoadBehaveIdx );
		}
		else {
			subdictLoadBehaveIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLoadBehaveIdx.put( keyLoadBehaveIdx, subdictLoadBehaveIdx );
		}
		subdictLoadBehaveIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictDataScopeIdx;
		if( dictByDataScopeIdx.containsKey( keyDataScopeIdx ) ) {
			subdictDataScopeIdx = dictByDataScopeIdx.get( keyDataScopeIdx );
		}
		else {
			subdictDataScopeIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDataScopeIdx.put( keyDataScopeIdx, subdictDataScopeIdx );
		}
		subdictDataScopeIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictSecScopeIdx;
		if( dictBySecScopeIdx.containsKey( keySecScopeIdx ) ) {
			subdictSecScopeIdx = dictBySecScopeIdx.get( keySecScopeIdx );
		}
		else {
			subdictSecScopeIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySecScopeIdx.put( keySecScopeIdx, subdictSecScopeIdx );
		}
		subdictSecScopeIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictVAccSecIdx;
		if( dictByVAccSecIdx.containsKey( keyVAccSecIdx ) ) {
			subdictVAccSecIdx = dictByVAccSecIdx.get( keyVAccSecIdx );
		}
		else {
			subdictVAccSecIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByVAccSecIdx.put( keyVAccSecIdx, subdictVAccSecIdx );
		}
		subdictVAccSecIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictVAccFreqIdx;
		if( dictByVAccFreqIdx.containsKey( keyVAccFreqIdx ) ) {
			subdictVAccFreqIdx = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		}
		else {
			subdictVAccFreqIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByVAccFreqIdx.put( keyVAccFreqIdx, subdictVAccFreqIdx );
		}
		subdictVAccFreqIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictEAccSecIdx;
		if( dictByEAccSecIdx.containsKey( keyEAccSecIdx ) ) {
			subdictEAccSecIdx = dictByEAccSecIdx.get( keyEAccSecIdx );
		}
		else {
			subdictEAccSecIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByEAccSecIdx.put( keyEAccSecIdx, subdictEAccSecIdx );
		}
		subdictEAccSecIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamTableBuff > subdictEAccFreqIdx;
		if( dictByEAccFreqIdx.containsKey( keyEAccFreqIdx ) ) {
			subdictEAccFreqIdx = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		}
		else {
			subdictEAccFreqIdx = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByEAccFreqIdx.put( keyEAccFreqIdx, subdictEAccFreqIdx );
		}
		subdictEAccFreqIdx.put( pkey, Buff );

	}

	public CFBamTableBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamTable.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamTable.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTable.readAllDerived() ";
		CFBamTableBuff[] retList = new CFBamTableBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTableBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTableBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTableBuff ) ) {
					filteredList.add( (CFBamTableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTableBuff[0] ) );
		}
	}

	public CFBamTableBuff[] readDerivedBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedBySchemaDefIdx() ";
		CFBamTableBySchemaDefIdxKey key = schema.getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );

		CFBamTableBuff[] recArray;
		if( dictBySchemaDefIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSchemaDefIdx
				= dictBySchemaDefIdx.get( key );
			recArray = new CFBamTableBuff[ subdictSchemaDefIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictSchemaDefIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSchemaDefIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySchemaDefIdx.put( key, subdictSchemaDefIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByDefSchemaIdx() ";
		CFBamTableByDefSchemaIdxKey key = schema.getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamTableBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamTableBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByUNameIdx() ";
		CFBamTableByUNameIdxKey key = schema.getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );

		CFBamTableBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff readDerivedBySchemaCdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedBySchemaCdIdx() ";
		CFBamTableBySchemaCdIdxKey key = schema.getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );

		CFBamTableBuff buff;
		if( dictBySchemaCdIdx.containsKey( key ) ) {
			buff = dictBySchemaCdIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff[] readDerivedByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByPrimaryIndexIdx() ";
		CFBamTableByPrimaryIndexIdxKey key = schema.getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );

		CFBamTableBuff[] recArray;
		if( dictByPrimaryIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictPrimaryIndexIdx
				= dictByPrimaryIndexIdx.get( key );
			recArray = new CFBamTableBuff[ subdictPrimaryIndexIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictPrimaryIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictPrimaryIndexIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByPrimaryIndexIdx.put( key, subdictPrimaryIndexIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByLookupIndexIdx() ";
		CFBamTableByLookupIndexIdxKey key = schema.getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );

		CFBamTableBuff[] recArray;
		if( dictByLookupIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLookupIndexIdx
				= dictByLookupIndexIdx.get( key );
			recArray = new CFBamTableBuff[ subdictLookupIndexIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictLookupIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLookupIndexIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLookupIndexIdx.put( key, subdictLookupIndexIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByAltIndexIdx() ";
		CFBamTableByAltIndexIdxKey key = schema.getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );

		CFBamTableBuff[] recArray;
		if( dictByAltIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictAltIndexIdx
				= dictByAltIndexIdx.get( key );
			recArray = new CFBamTableBuff[ subdictAltIndexIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictAltIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictAltIndexIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByAltIndexIdx.put( key, subdictAltIndexIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByQualTableIdx() ";
		CFBamTableByQualTableIdxKey key = schema.getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );

		CFBamTableBuff[] recArray;
		if( dictByQualTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictQualTableIdx
				= dictByQualTableIdx.get( key );
			recArray = new CFBamTableBuff[ subdictQualTableIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictQualTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictQualTableIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByQualTableIdx.put( key, subdictQualTableIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByLoadBehaveIdx() ";
		CFBamTableByLoadBehaveIdxKey key = schema.getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( LoaderBehaviourId );

		CFBamTableBuff[] recArray;
		if( dictByLoadBehaveIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLoadBehaveIdx
				= dictByLoadBehaveIdx.get( key );
			recArray = new CFBamTableBuff[ subdictLoadBehaveIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictLoadBehaveIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLoadBehaveIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLoadBehaveIdx.put( key, subdictLoadBehaveIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByDataScopeIdx() ";
		CFBamTableByDataScopeIdxKey key = schema.getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		CFBamTableBuff[] recArray;
		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			recArray = new CFBamTableBuff[ subdictDataScopeIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictDataScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDataScopeIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDataScopeIdx.put( key, subdictDataScopeIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedBySecScopeIdx() ";
		CFBamTableBySecScopeIdxKey key = schema.getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( SecurityScopeId );

		CFBamTableBuff[] recArray;
		if( dictBySecScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSecScopeIdx
				= dictBySecScopeIdx.get( key );
			recArray = new CFBamTableBuff[ subdictSecScopeIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictSecScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSecScopeIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySecScopeIdx.put( key, subdictSecScopeIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByVAccSecIdx() ";
		CFBamTableByVAccSecIdxKey key = schema.getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		CFBamTableBuff[] recArray;
		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			recArray = new CFBamTableBuff[ subdictVAccSecIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictVAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccSecIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByVAccSecIdx.put( key, subdictVAccSecIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByVAccFreqIdx() ";
		CFBamTableByVAccFreqIdxKey key = schema.getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		CFBamTableBuff[] recArray;
		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			recArray = new CFBamTableBuff[ subdictVAccFreqIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictVAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccFreqIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByVAccFreqIdx.put( key, subdictVAccFreqIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByEAccSecIdx() ";
		CFBamTableByEAccSecIdxKey key = schema.getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		CFBamTableBuff[] recArray;
		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			recArray = new CFBamTableBuff[ subdictEAccSecIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictEAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccSecIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByEAccSecIdx.put( key, subdictEAccSecIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamTable.readDerivedByEAccFreqIdx() ";
		CFBamTableByEAccFreqIdxKey key = schema.getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		CFBamTableBuff[] recArray;
		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			recArray = new CFBamTableBuff[ subdictEAccFreqIdx.size() ];
			Iterator< CFBamTableBuff > iter = subdictEAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccFreqIdx
				= new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByEAccFreqIdx.put( key, subdictEAccFreqIdx );
			recArray = new CFBamTableBuff[0];
		}
		return( recArray );
	}

	public CFBamTableBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamTable.readBuff() ";
		CFBamTableBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TBLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamTable.readBuff() ";
		CFBamTableBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TBLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTableBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTable.readAllBuff() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamTableBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTableBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffBySchemaDefIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedBySchemaDefIdx( Authorization,
			TenantId,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByDefSchemaIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByUNameIdx() ";
		CFBamTableBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			SchemaDefId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
			return( (CFBamTableBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTableBuff readBuffBySchemaCdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "CFBamRamTable.readBuffBySchemaCdIdx() ";
		CFBamTableBuff buff = readDerivedBySchemaCdIdx( Authorization,
			TenantId,
			SchemaDefId,
			TableClassCode );
		if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
			return( (CFBamTableBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTableBuff[] readBuffByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByPrimaryIndexIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByPrimaryIndexIdx( Authorization,
			PrimaryIndexTenantId,
			PrimaryIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByLookupIndexIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByLookupIndexIdx( Authorization,
			LookupIndexTenantId,
			LookupIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByAltIndexIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByAltIndexIdx( Authorization,
			AltIndexTenantId,
			AltIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByQualTableIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByQualTableIdx( Authorization,
			QualifyingTenantId,
			QualifyingTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByLoadBehaveIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByLoadBehaveIdx( Authorization,
			LoaderBehaviourId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByDataScopeIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffBySecScopeIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedBySecScopeIdx( Authorization,
			SecurityScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByVAccSecIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByVAccFreqIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByEAccSecIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public CFBamTableBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamTable.readBuffByEAccFreqIdx() ";
		CFBamTableBuff buff;
		ArrayList<CFBamTableBuff> filteredList = new ArrayList<CFBamTableBuff>();
		CFBamTableBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TBLD" ) ) {
				filteredList.add( (CFBamTableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTableBuff[0] ) );
	}

	public void updateTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTableBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTable",
				"Existing record not found",
				"Table",
				pkey );
		}
		CFBamTableBySchemaDefIdxKey existingKeySchemaDefIdx = schema.getFactoryTable().newSchemaDefIdxKey();
		existingKeySchemaDefIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySchemaDefIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		CFBamTableBySchemaDefIdxKey newKeySchemaDefIdx = schema.getFactoryTable().newSchemaDefIdxKey();
		newKeySchemaDefIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySchemaDefIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		CFBamTableByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryTable().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamTableByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryTable().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamTableByUNameIdxKey existingKeyUNameIdx = schema.getFactoryTable().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTableByUNameIdxKey newKeyUNameIdx = schema.getFactoryTable().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamTableBySchemaCdIdxKey existingKeySchemaCdIdx = schema.getFactoryTable().newSchemaCdIdxKey();
		existingKeySchemaCdIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySchemaCdIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeySchemaCdIdx.setRequiredTableClassCode( existing.getRequiredTableClassCode() );

		CFBamTableBySchemaCdIdxKey newKeySchemaCdIdx = schema.getFactoryTable().newSchemaCdIdxKey();
		newKeySchemaCdIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySchemaCdIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeySchemaCdIdx.setRequiredTableClassCode( Buff.getRequiredTableClassCode() );

		CFBamTableByPrimaryIndexIdxKey existingKeyPrimaryIndexIdx = schema.getFactoryTable().newPrimaryIndexIdxKey();
		existingKeyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( existing.getOptionalPrimaryIndexTenantId() );
		existingKeyPrimaryIndexIdx.setOptionalPrimaryIndexId( existing.getOptionalPrimaryIndexId() );

		CFBamTableByPrimaryIndexIdxKey newKeyPrimaryIndexIdx = schema.getFactoryTable().newPrimaryIndexIdxKey();
		newKeyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( Buff.getOptionalPrimaryIndexTenantId() );
		newKeyPrimaryIndexIdx.setOptionalPrimaryIndexId( Buff.getOptionalPrimaryIndexId() );

		CFBamTableByLookupIndexIdxKey existingKeyLookupIndexIdx = schema.getFactoryTable().newLookupIndexIdxKey();
		existingKeyLookupIndexIdx.setOptionalLookupIndexTenantId( existing.getOptionalLookupIndexTenantId() );
		existingKeyLookupIndexIdx.setOptionalLookupIndexId( existing.getOptionalLookupIndexId() );

		CFBamTableByLookupIndexIdxKey newKeyLookupIndexIdx = schema.getFactoryTable().newLookupIndexIdxKey();
		newKeyLookupIndexIdx.setOptionalLookupIndexTenantId( Buff.getOptionalLookupIndexTenantId() );
		newKeyLookupIndexIdx.setOptionalLookupIndexId( Buff.getOptionalLookupIndexId() );

		CFBamTableByAltIndexIdxKey existingKeyAltIndexIdx = schema.getFactoryTable().newAltIndexIdxKey();
		existingKeyAltIndexIdx.setOptionalAltIndexTenantId( existing.getOptionalAltIndexTenantId() );
		existingKeyAltIndexIdx.setOptionalAltIndexId( existing.getOptionalAltIndexId() );

		CFBamTableByAltIndexIdxKey newKeyAltIndexIdx = schema.getFactoryTable().newAltIndexIdxKey();
		newKeyAltIndexIdx.setOptionalAltIndexTenantId( Buff.getOptionalAltIndexTenantId() );
		newKeyAltIndexIdx.setOptionalAltIndexId( Buff.getOptionalAltIndexId() );

		CFBamTableByQualTableIdxKey existingKeyQualTableIdx = schema.getFactoryTable().newQualTableIdxKey();
		existingKeyQualTableIdx.setOptionalQualifyingTenantId( existing.getOptionalQualifyingTenantId() );
		existingKeyQualTableIdx.setOptionalQualifyingTableId( existing.getOptionalQualifyingTableId() );

		CFBamTableByQualTableIdxKey newKeyQualTableIdx = schema.getFactoryTable().newQualTableIdxKey();
		newKeyQualTableIdx.setOptionalQualifyingTenantId( Buff.getOptionalQualifyingTenantId() );
		newKeyQualTableIdx.setOptionalQualifyingTableId( Buff.getOptionalQualifyingTableId() );

		CFBamTableByLoadBehaveIdxKey existingKeyLoadBehaveIdx = schema.getFactoryTable().newLoadBehaveIdxKey();
		existingKeyLoadBehaveIdx.setRequiredLoaderBehaviourId( existing.getRequiredLoaderBehaviourId() );

		CFBamTableByLoadBehaveIdxKey newKeyLoadBehaveIdx = schema.getFactoryTable().newLoadBehaveIdxKey();
		newKeyLoadBehaveIdx.setRequiredLoaderBehaviourId( Buff.getRequiredLoaderBehaviourId() );

		CFBamTableByDataScopeIdxKey existingKeyDataScopeIdx = schema.getFactoryTable().newDataScopeIdxKey();
		existingKeyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamTableByDataScopeIdxKey newKeyDataScopeIdx = schema.getFactoryTable().newDataScopeIdxKey();
		newKeyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamTableBySecScopeIdxKey existingKeySecScopeIdx = schema.getFactoryTable().newSecScopeIdxKey();
		existingKeySecScopeIdx.setRequiredSecurityScopeId( existing.getRequiredSecurityScopeId() );

		CFBamTableBySecScopeIdxKey newKeySecScopeIdx = schema.getFactoryTable().newSecScopeIdxKey();
		newKeySecScopeIdx.setRequiredSecurityScopeId( Buff.getRequiredSecurityScopeId() );

		CFBamTableByVAccSecIdxKey existingKeyVAccSecIdx = schema.getFactoryTable().newVAccSecIdxKey();
		existingKeyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamTableByVAccSecIdxKey newKeyVAccSecIdx = schema.getFactoryTable().newVAccSecIdxKey();
		newKeyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamTableByVAccFreqIdxKey existingKeyVAccFreqIdx = schema.getFactoryTable().newVAccFreqIdxKey();
		existingKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamTableByVAccFreqIdxKey newKeyVAccFreqIdx = schema.getFactoryTable().newVAccFreqIdxKey();
		newKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamTableByEAccSecIdxKey existingKeyEAccSecIdx = schema.getFactoryTable().newEAccSecIdxKey();
		existingKeyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamTableByEAccSecIdxKey newKeyEAccSecIdx = schema.getFactoryTable().newEAccSecIdxKey();
		newKeyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamTableByEAccFreqIdxKey existingKeyEAccFreqIdx = schema.getFactoryTable().newEAccFreqIdxKey();
		existingKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );

		CFBamTableByEAccFreqIdxKey newKeyEAccFreqIdx = schema.getFactoryTable().newEAccFreqIdxKey();
		newKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTable",
					"TableUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeySchemaCdIdx.equals( newKeySchemaCdIdx ) ) {
			if( dictBySchemaCdIdx.containsKey( newKeySchemaCdIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTable",
					"TableSchemaCodeIdx",
					newKeySchemaCdIdx );
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
						"updateTable",
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
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSchemaDefId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTable",
						"Container",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableLoaderBehaviour().readDerivedByIdIdx( Authorization,
						Buff.getRequiredLoaderBehaviourId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTable",
						"Lookup",
						"LoaderBehaviour",
						"LoaderBehaviour",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecurityScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecurityScopeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTable",
						"Lookup",
						"SecurityScope",
						"SecurityScope",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamTableBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaDefIdx.get( existingKeySchemaDefIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaDefIdx.containsKey( newKeySchemaDefIdx ) ) {
			subdict = dictBySchemaDefIdx.get( newKeySchemaDefIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySchemaDefIdx.put( newKeySchemaDefIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		dictBySchemaCdIdx.remove( existingKeySchemaCdIdx );
		dictBySchemaCdIdx.put( newKeySchemaCdIdx, Buff );

		subdict = dictByPrimaryIndexIdx.get( existingKeyPrimaryIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrimaryIndexIdx.containsKey( newKeyPrimaryIndexIdx ) ) {
			subdict = dictByPrimaryIndexIdx.get( newKeyPrimaryIndexIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByPrimaryIndexIdx.put( newKeyPrimaryIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLookupIndexIdx.get( existingKeyLookupIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLookupIndexIdx.containsKey( newKeyLookupIndexIdx ) ) {
			subdict = dictByLookupIndexIdx.get( newKeyLookupIndexIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLookupIndexIdx.put( newKeyLookupIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByAltIndexIdx.get( existingKeyAltIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByAltIndexIdx.containsKey( newKeyAltIndexIdx ) ) {
			subdict = dictByAltIndexIdx.get( newKeyAltIndexIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByAltIndexIdx.put( newKeyAltIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByQualTableIdx.get( existingKeyQualTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByQualTableIdx.containsKey( newKeyQualTableIdx ) ) {
			subdict = dictByQualTableIdx.get( newKeyQualTableIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByQualTableIdx.put( newKeyQualTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLoadBehaveIdx.get( existingKeyLoadBehaveIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLoadBehaveIdx.containsKey( newKeyLoadBehaveIdx ) ) {
			subdict = dictByLoadBehaveIdx.get( newKeyLoadBehaveIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByLoadBehaveIdx.put( newKeyLoadBehaveIdx, subdict );
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
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByDataScopeIdx.put( newKeyDataScopeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecScopeIdx.get( existingKeySecScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecScopeIdx.containsKey( newKeySecScopeIdx ) ) {
			subdict = dictBySecScopeIdx.get( newKeySecScopeIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictBySecScopeIdx.put( newKeySecScopeIdx, subdict );
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
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
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
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
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
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
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
			subdict = new HashMap< CFBamScopePKey, CFBamTableBuff >();
			dictByEAccFreqIdx.put( newKeyEAccFreqIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "CFBamRamTableTable.deleteTable() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTableBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTable",
				pkey );
		}
		CFBamTableBySchemaDefIdxKey keySchemaDefIdx = schema.getFactoryTable().newSchemaDefIdxKey();
		keySchemaDefIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySchemaDefIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		CFBamTableByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryTable().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamTableByUNameIdxKey keyUNameIdx = schema.getFactoryTable().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTableBySchemaCdIdxKey keySchemaCdIdx = schema.getFactoryTable().newSchemaCdIdxKey();
		keySchemaCdIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySchemaCdIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchemaCdIdx.setRequiredTableClassCode( existing.getRequiredTableClassCode() );

		CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx = schema.getFactoryTable().newPrimaryIndexIdxKey();
		keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( existing.getOptionalPrimaryIndexTenantId() );
		keyPrimaryIndexIdx.setOptionalPrimaryIndexId( existing.getOptionalPrimaryIndexId() );

		CFBamTableByLookupIndexIdxKey keyLookupIndexIdx = schema.getFactoryTable().newLookupIndexIdxKey();
		keyLookupIndexIdx.setOptionalLookupIndexTenantId( existing.getOptionalLookupIndexTenantId() );
		keyLookupIndexIdx.setOptionalLookupIndexId( existing.getOptionalLookupIndexId() );

		CFBamTableByAltIndexIdxKey keyAltIndexIdx = schema.getFactoryTable().newAltIndexIdxKey();
		keyAltIndexIdx.setOptionalAltIndexTenantId( existing.getOptionalAltIndexTenantId() );
		keyAltIndexIdx.setOptionalAltIndexId( existing.getOptionalAltIndexId() );

		CFBamTableByQualTableIdxKey keyQualTableIdx = schema.getFactoryTable().newQualTableIdxKey();
		keyQualTableIdx.setOptionalQualifyingTenantId( existing.getOptionalQualifyingTenantId() );
		keyQualTableIdx.setOptionalQualifyingTableId( existing.getOptionalQualifyingTableId() );

		CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx = schema.getFactoryTable().newLoadBehaveIdxKey();
		keyLoadBehaveIdx.setRequiredLoaderBehaviourId( existing.getRequiredLoaderBehaviourId() );

		CFBamTableByDataScopeIdxKey keyDataScopeIdx = schema.getFactoryTable().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamTableBySecScopeIdxKey keySecScopeIdx = schema.getFactoryTable().newSecScopeIdxKey();
		keySecScopeIdx.setRequiredSecurityScopeId( existing.getRequiredSecurityScopeId() );

		CFBamTableByVAccSecIdxKey keyVAccSecIdx = schema.getFactoryTable().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamTableByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactoryTable().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamTableByEAccSecIdxKey keyEAccSecIdx = schema.getFactoryTable().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamTableByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactoryTable().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );


		// Validate reverse foreign keys

		if( schema.getTableRelation().readDerivedByToTblIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTable",
				"Lookup",
				"ToTable",
				"Relation",
				pkey );
		}

		// Delete is valid

		schema.getTableRelation().deleteRelationByTableIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableIndex().deleteIndexByTableIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableValue().deleteValueByScopeIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableRelation().deleteRelationByToTblIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableChain().deleteChainByTableIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableDelTopDep().deleteDelTopDepByContTblIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableClearTopDep().deleteClearTopDepByContTblIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableId16Gen().deleteId16GenByDispIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableId32Gen().deleteId32GenByDispIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableId64Gen().deleteId64GenByDispIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableServerMethod().deleteServerMethodByTableIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamTableBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaDefIdx.get( keySchemaDefIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		dictBySchemaCdIdx.remove( keySchemaCdIdx );

		subdict = dictByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
		subdict.remove( pkey );

		subdict = dictByLookupIndexIdx.get( keyLookupIndexIdx );
		subdict.remove( pkey );

		subdict = dictByAltIndexIdx.get( keyAltIndexIdx );
		subdict.remove( pkey );

		subdict = dictByQualTableIdx.get( keyQualTableIdx );
		subdict.remove( pkey );

		subdict = dictByLoadBehaveIdx.get( keyLoadBehaveIdx );
		subdict.remove( pkey );

		subdict = dictByDataScopeIdx.get( keyDataScopeIdx );
		subdict.remove( pkey );

		subdict = dictBySecScopeIdx.get( keySecScopeIdx );
		subdict.remove( pkey );

		subdict = dictByVAccSecIdx.get( keyVAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		subdict.remove( pkey );

		subdict = dictByEAccSecIdx.get( keyEAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteTableBySchemaDefIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId )
	{
		CFBamTableBySchemaDefIdxKey key = schema.getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteTableBySchemaDefIdx( Authorization, key );
	}

	public void deleteTableBySchemaDefIdx( CFBamAuthorization Authorization,
		CFBamTableBySchemaDefIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamTableByDefSchemaIdxKey key = schema.getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTableByDefSchemaIdx( Authorization, key );
	}

	public void deleteTableByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamTableByDefSchemaIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argName )
	{
		CFBamTableByUNameIdxKey key = schema.getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredName( argName );
		deleteTableByUNameIdx( Authorization, key );
	}

	public void deleteTableByUNameIdx( CFBamAuthorization Authorization,
		CFBamTableByUNameIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableBySchemaCdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode )
	{
		CFBamTableBySchemaCdIdxKey key = schema.getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredTableClassCode( argTableClassCode );
		deleteTableBySchemaCdIdx( Authorization, key );
	}

	public void deleteTableBySchemaCdIdx( CFBamAuthorization Authorization,
		CFBamTableBySchemaCdIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId )
	{
		CFBamTableByPrimaryIndexIdxKey key = schema.getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( argPrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( argPrimaryIndexId );
		deleteTableByPrimaryIndexIdx( Authorization, key );
	}

	public void deleteTableByPrimaryIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByPrimaryIndexIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByLookupIndexIdx( CFBamAuthorization Authorization,
		Long argLookupIndexTenantId,
		Long argLookupIndexId )
	{
		CFBamTableByLookupIndexIdxKey key = schema.getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( argLookupIndexTenantId );
		key.setOptionalLookupIndexId( argLookupIndexId );
		deleteTableByLookupIndexIdx( Authorization, key );
	}

	public void deleteTableByLookupIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByLookupIndexIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByAltIndexIdx( CFBamAuthorization Authorization,
		Long argAltIndexTenantId,
		Long argAltIndexId )
	{
		CFBamTableByAltIndexIdxKey key = schema.getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( argAltIndexTenantId );
		key.setOptionalAltIndexId( argAltIndexId );
		deleteTableByAltIndexIdx( Authorization, key );
	}

	public void deleteTableByAltIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByAltIndexIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByQualTableIdx( CFBamAuthorization Authorization,
		Long argQualifyingTenantId,
		Long argQualifyingTableId )
	{
		CFBamTableByQualTableIdxKey key = schema.getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( argQualifyingTenantId );
		key.setOptionalQualifyingTableId( argQualifyingTableId );
		deleteTableByQualTableIdx( Authorization, key );
	}

	public void deleteTableByQualTableIdx( CFBamAuthorization Authorization,
		CFBamTableByQualTableIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByLoadBehaveIdx( CFBamAuthorization Authorization,
		short argLoaderBehaviourId )
	{
		CFBamTableByLoadBehaveIdxKey key = schema.getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( argLoaderBehaviourId );
		deleteTableByLoadBehaveIdx( Authorization, key );
	}

	public void deleteTableByLoadBehaveIdx( CFBamAuthorization Authorization,
		CFBamTableByLoadBehaveIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamTableByDataScopeIdxKey key = schema.getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTableByDataScopeIdx( Authorization, key );
	}

	public void deleteTableByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamTableByDataScopeIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableBySecScopeIdx( CFBamAuthorization Authorization,
		short argSecurityScopeId )
	{
		CFBamTableBySecScopeIdxKey key = schema.getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( argSecurityScopeId );
		deleteTableBySecScopeIdx( Authorization, key );
	}

	public void deleteTableBySecScopeIdx( CFBamAuthorization Authorization,
		CFBamTableBySecScopeIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamTableByVAccSecIdxKey key = schema.getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTableByVAccSecIdx( Authorization, key );
	}

	public void deleteTableByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamTableByVAccSecIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamTableByVAccFreqIdxKey key = schema.getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTableByVAccFreqIdx( Authorization, key );
	}

	public void deleteTableByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamTableByVAccFreqIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamTableByEAccSecIdxKey key = schema.getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTableByEAccSecIdx( Authorization, key );
	}

	public void deleteTableByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamTableByEAccSecIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamTableByEAccFreqIdxKey key = schema.getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTableByEAccFreqIdx( Authorization, key );
	}

	public void deleteTableByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamTableByEAccFreqIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTableByIdIdx( Authorization, key );
	}

	public void deleteTableByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public void deleteTableByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTableByTenantIdx( Authorization, key );
	}

	public void deleteTableByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamTableBuff cur;
		LinkedList<CFBamTableBuff> matchSet = new LinkedList<CFBamTableBuff>();
		Iterator<CFBamTableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTable( Authorization, cur );
		}
	}

	public CFBamCursor openTableCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTableCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTableCursorBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		CFBamCursor cursor;
		CFBamTableBySchemaDefIdxKey key = schema.getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );

		if( dictBySchemaDefIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSchemaDefIdx
				= dictBySchemaDefIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictSchemaDefIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamTableByDefSchemaIdxKey key = schema.getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		CFBamCursor cursor;
		CFBamTableByPrimaryIndexIdxKey key = schema.getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );

		if( dictByPrimaryIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictPrimaryIndexIdx
				= dictByPrimaryIndexIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictPrimaryIndexIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		CFBamCursor cursor;
		CFBamTableByLookupIndexIdxKey key = schema.getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );

		if( dictByLookupIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLookupIndexIdx
				= dictByLookupIndexIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictLookupIndexIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		CFBamCursor cursor;
		CFBamTableByAltIndexIdxKey key = schema.getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );

		if( dictByAltIndexIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictAltIndexIdx
				= dictByAltIndexIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictAltIndexIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		CFBamCursor cursor;
		CFBamTableByQualTableIdxKey key = schema.getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );

		if( dictByQualTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictQualTableIdx
				= dictByQualTableIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictQualTableIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		CFBamCursor cursor;
		CFBamTableByLoadBehaveIdxKey key = schema.getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( LoaderBehaviourId );

		if( dictByLoadBehaveIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictLoadBehaveIdx
				= dictByLoadBehaveIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictLoadBehaveIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		CFBamCursor cursor;
		CFBamTableByDataScopeIdxKey key = schema.getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictDataScopeIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		CFBamCursor cursor;
		CFBamTableBySecScopeIdxKey key = schema.getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( SecurityScopeId );

		if( dictBySecScopeIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictSecScopeIdx
				= dictBySecScopeIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictSecScopeIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamTableByVAccSecIdxKey key = schema.getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictVAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamTableByVAccFreqIdxKey key = schema.getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictVAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamTableByEAccSecIdxKey key = schema.getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictEAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTableCursorByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamTableByEAccFreqIdxKey key = schema.getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamTableBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				subdictEAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamTableCursor( Authorization,
				schema,
				new ArrayList< CFBamTableBuff >() );
		}
		return( cursor );
	}

	public void closeTableCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTableBuff nextTableCursor( CFBamCursor Cursor ) {
		CFBamRamTableCursor cursor = (CFBamRamTableCursor)Cursor;
		CFBamTableBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTableBuff prevTableCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTableBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTableCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTableBuff firstTableCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTableBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTableCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTableBuff lastTableCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTableCursor" );
	}

	public CFBamTableBuff nthTableCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTableBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTableCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
