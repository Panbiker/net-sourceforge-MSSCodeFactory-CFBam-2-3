
// Description: Java7 in-memory RAM DbIO implementation for Index.

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
 *	CFBamRamIndexTable in-memory RAM DbIO implementation
 *	for Index.
 */
public class CFBamRamIndexTable
	implements ICFBamIndexTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamIndexBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamIndexBuff >();
	private Map< CFBamIndexByUNameIdxKey,
			CFBamIndexBuff > dictByUNameIdx
		= new HashMap< CFBamIndexByUNameIdxKey,
			CFBamIndexBuff >();
	private Map< CFBamIndexByIndexTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >> dictByIndexTenantIdx
		= new HashMap< CFBamIndexByIndexTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >>();
	private Map< CFBamIndexByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >> dictByTableIdx
		= new HashMap< CFBamIndexByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >>();
	private Map< CFBamIndexByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamIndexByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamIndexBuff >>();

	public CFBamRamIndexTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createIndex( CFBamAuthorization Authorization,
		CFBamIndexBuff Buff )
	{
		final String S_ProcName = "createIndex";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamIndexByUNameIdxKey keyUNameIdx = schema.getFactoryIndex().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx = schema.getFactoryIndex().newIndexTenantIdxKey();
		keyIndexTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamIndexByTableIdxKey keyTableIdx = schema.getFactoryIndex().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryIndex().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"IndexUNameIdx",
				keyUNameIdx );
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
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"IndexTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamScopePKey, CFBamIndexBuff > subdictIndexTenantIdx;
		if( dictByIndexTenantIdx.containsKey( keyIndexTenantIdx ) ) {
			subdictIndexTenantIdx = dictByIndexTenantIdx.get( keyIndexTenantIdx );
		}
		else {
			subdictIndexTenantIdx = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByIndexTenantIdx.put( keyIndexTenantIdx, subdictIndexTenantIdx );
		}
		subdictIndexTenantIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamIndexBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamIndexBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

	}

	public CFBamIndexBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamIndex.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamIndexBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamIndex.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamIndexBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamIndex.readAllDerived() ";
		CFBamIndexBuff[] retList = new CFBamIndexBuff[ dictByPKey.values().size() ];
		Iterator< CFBamIndexBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamIndexBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamIndexBuff ) ) {
					filteredList.add( (CFBamIndexBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamIndexBuff[0] ) );
		}
	}

	public CFBamIndexBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamIndex.readDerivedByUNameIdx() ";
		CFBamIndexByUNameIdxKey key = schema.getFactoryIndex().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );

		CFBamIndexBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff[] readDerivedByIndexTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamIndex.readDerivedByIndexTenantIdx() ";
		CFBamIndexByIndexTenantIdxKey key = schema.getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamIndexBuff[] recArray;
		if( dictByIndexTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictIndexTenantIdx
				= dictByIndexTenantIdx.get( key );
			recArray = new CFBamIndexBuff[ subdictIndexTenantIdx.size() ];
			Iterator< CFBamIndexBuff > iter = subdictIndexTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictIndexTenantIdx
				= new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByIndexTenantIdx.put( key, subdictIndexTenantIdx );
			recArray = new CFBamIndexBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamIndex.readDerivedByTableIdx() ";
		CFBamIndexByTableIdxKey key = schema.getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		CFBamIndexBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamIndexBuff[ subdictTableIdx.size() ];
			Iterator< CFBamIndexBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictTableIdx
				= new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamIndexBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamIndex.readDerivedByDefSchemaIdx() ";
		CFBamIndexByDefSchemaIdxKey key = schema.getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamIndexBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamIndexBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamIndexBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamIndexBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamIndexBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamIndex.readBuff() ";
		CFBamIndexBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "IDXD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamIndex.readBuff() ";
		CFBamIndexBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "IDXD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamIndex.readAllBuff() ";
		CFBamIndexBuff buff;
		ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
		CFBamIndexBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexBuff[0] ) );
	}

	public CFBamIndexBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamIndexBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamIndexBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamIndexBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexBuff[0] ) );
	}

	public CFBamIndexBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamIndex.readBuffByUNameIdx() ";
		CFBamIndexBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "IDXD" ) ) {
			return( (CFBamIndexBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamIndexBuff[] readBuffByIndexTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamIndex.readBuffByIndexTenantIdx() ";
		CFBamIndexBuff buff;
		ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
		CFBamIndexBuff[] buffList = readDerivedByIndexTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXD" ) ) {
				filteredList.add( (CFBamIndexBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexBuff[0] ) );
	}

	public CFBamIndexBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamIndex.readBuffByTableIdx() ";
		CFBamIndexBuff buff;
		ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
		CFBamIndexBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXD" ) ) {
				filteredList.add( (CFBamIndexBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexBuff[0] ) );
	}

	public CFBamIndexBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamIndex.readBuffByDefSchemaIdx() ";
		CFBamIndexBuff buff;
		ArrayList<CFBamIndexBuff> filteredList = new ArrayList<CFBamIndexBuff>();
		CFBamIndexBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXD" ) ) {
				filteredList.add( (CFBamIndexBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexBuff[0] ) );
	}

	public void updateIndex( CFBamAuthorization Authorization,
		CFBamIndexBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamIndexBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateIndex",
				"Existing record not found",
				"Index",
				pkey );
		}
		CFBamIndexByUNameIdxKey existingKeyUNameIdx = schema.getFactoryIndex().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamIndexByUNameIdxKey newKeyUNameIdx = schema.getFactoryIndex().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamIndexByIndexTenantIdxKey existingKeyIndexTenantIdx = schema.getFactoryIndex().newIndexTenantIdxKey();
		existingKeyIndexTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamIndexByIndexTenantIdxKey newKeyIndexTenantIdx = schema.getFactoryIndex().newIndexTenantIdxKey();
		newKeyIndexTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamIndexByTableIdxKey existingKeyTableIdx = schema.getFactoryIndex().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamIndexByTableIdxKey newKeyTableIdx = schema.getFactoryIndex().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamIndexByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryIndex().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamIndexByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryIndex().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateIndex",
					"IndexUNameIdx",
					newKeyUNameIdx );
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
						"updateIndex",
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
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateIndex",
						"Owner",
						"IndexTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateIndex",
						"Container",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamIndexBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByIndexTenantIdx.get( existingKeyIndexTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIndexTenantIdx.containsKey( newKeyIndexTenantIdx ) ) {
			subdict = dictByIndexTenantIdx.get( newKeyIndexTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByIndexTenantIdx.put( newKeyIndexTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByTableIdx.put( newKeyTableIdx, subdict );
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
			subdict = new HashMap< CFBamScopePKey, CFBamIndexBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteIndex( CFBamAuthorization Authorization,
		CFBamIndexBuff Buff )
	{
		final String S_ProcName = "CFBamRamIndexTable.deleteIndex() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamIndexBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteIndex",
				pkey );
		}
		CFBamIndexByUNameIdxKey keyUNameIdx = schema.getFactoryIndex().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx = schema.getFactoryIndex().newIndexTenantIdxKey();
		keyIndexTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamIndexByTableIdxKey keyTableIdx = schema.getFactoryIndex().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryIndex().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );


		// Validate reverse foreign keys

		if( schema.getTableRelation().readDerivedByFromKeyIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteIndex",
				"Lookup",
				"FromIndex",
				"Relation",
				pkey );
		}

		if( schema.getTableRelation().readDerivedByToKeyIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteIndex",
				"Lookup",
				"ToIndex",
				"Relation",
				pkey );
		}

		// Delete is valid

		schema.getTableIndexCol().deleteIndexColByIndexIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamIndexBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByIndexTenantIdx.get( keyIndexTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteIndexByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamIndexByUNameIdxKey key = schema.getFactoryIndex().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteIndexByUNameIdx( Authorization, key );
	}

	public void deleteIndexByUNameIdx( CFBamAuthorization Authorization,
		CFBamIndexByUNameIdxKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public void deleteIndexByIndexTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamIndexByIndexTenantIdxKey key = schema.getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteIndexByIndexTenantIdx( Authorization, key );
	}

	public void deleteIndexByIndexTenantIdx( CFBamAuthorization Authorization,
		CFBamIndexByIndexTenantIdxKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public void deleteIndexByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamIndexByTableIdxKey key = schema.getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteIndexByTableIdx( Authorization, key );
	}

	public void deleteIndexByTableIdx( CFBamAuthorization Authorization,
		CFBamIndexByTableIdxKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public void deleteIndexByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamIndexByDefSchemaIdxKey key = schema.getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteIndexByDefSchemaIdx( Authorization, key );
	}

	public void deleteIndexByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamIndexByDefSchemaIdxKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public void deleteIndexByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteIndexByIdIdx( Authorization, key );
	}

	public void deleteIndexByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public void deleteIndexByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteIndexByTenantIdx( Authorization, key );
	}

	public void deleteIndexByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamIndexBuff cur;
		LinkedList<CFBamIndexBuff> matchSet = new LinkedList<CFBamIndexBuff>();
		Iterator<CFBamIndexBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndex( Authorization, cur );
		}
	}

	public CFBamCursor openIndexCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamIndexCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openIndexCursorByIndexTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamIndexByIndexTenantIdxKey key = schema.getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByIndexTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictIndexTenantIdx
				= dictByIndexTenantIdx.get( key );
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				subdictIndexTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		CFBamCursor cursor;
		CFBamIndexByTableIdxKey key = schema.getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamIndexByDefSchemaIdxKey key = schema.getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamIndexBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexBuff >() );
		}
		return( cursor );
	}

	public void closeIndexCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamIndexBuff nextIndexCursor( CFBamCursor Cursor ) {
		CFBamRamIndexCursor cursor = (CFBamRamIndexCursor)Cursor;
		CFBamIndexBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamIndexBuff prevIndexCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamIndexBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexCursor( Cursor );
		}
		return( rec );
	}

	public CFBamIndexBuff firstIndexCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamIndexBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexCursor( Cursor );
		}
		return( rec );
	}

	public CFBamIndexBuff lastIndexCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastIndexCursor" );
	}

	public CFBamIndexBuff nthIndexCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamIndexBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
