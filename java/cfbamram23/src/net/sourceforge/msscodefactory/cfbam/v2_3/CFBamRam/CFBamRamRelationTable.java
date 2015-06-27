
// Description: Java7 in-memory RAM DbIO implementation for Relation.

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
 *	CFBamRamRelationTable in-memory RAM DbIO implementation
 *	for Relation.
 */
public class CFBamRamRelationTable
	implements ICFBamRelationTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamRelationBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamRelationBuff >();
	private Map< CFBamRelationByUNameIdxKey,
			CFBamRelationBuff > dictByUNameIdx
		= new HashMap< CFBamRelationByUNameIdxKey,
			CFBamRelationBuff >();
	private Map< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByRelnTenantIdx
		= new HashMap< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByTableIdx
		= new HashMap< CFBamRelationByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByRTypeKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByRTypeKeyIdx
		= new HashMap< CFBamRelationByRTypeKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByFromKeyIdx
		= new HashMap< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByToTblIdx
		= new HashMap< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByToKeyIdx
		= new HashMap< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();
	private Map< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >> dictByNarrowedIdx
		= new HashMap< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey,
					CFBamRelationBuff >>();

	public CFBamRamRelationTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createRelation( CFBamAuthorization Authorization,
		CFBamRelationBuff Buff )
	{
		final String S_ProcName = "createRelation";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationByUNameIdxKey keyUNameIdx = schema.getFactoryRelation().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx = schema.getFactoryRelation().newRelnTenantIdxKey();
		keyRelnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamRelationByTableIdxKey keyTableIdx = schema.getFactoryRelation().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryRelation().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx = schema.getFactoryRelation().newRTypeKeyIdxKey();
		keyRTypeKeyIdx.setRequiredRelationTypeId( Buff.getRequiredRelationTypeId() );

		CFBamRelationByFromKeyIdxKey keyFromKeyIdx = schema.getFactoryRelation().newFromKeyIdxKey();
		keyFromKeyIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyFromKeyIdx.setRequiredFromIndexId( Buff.getRequiredFromIndexId() );

		CFBamRelationByToTblIdxKey keyToTblIdx = schema.getFactoryRelation().newToTblIdxKey();
		keyToTblIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyToTblIdx.setRequiredToTableId( Buff.getRequiredToTableId() );

		CFBamRelationByToKeyIdxKey keyToKeyIdx = schema.getFactoryRelation().newToKeyIdxKey();
		keyToKeyIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyToKeyIdx.setRequiredToIndexId( Buff.getRequiredToIndexId() );

		CFBamRelationByNarrowedIdxKey keyNarrowedIdx = schema.getFactoryRelation().newNarrowedIdxKey();
		keyNarrowedIdx.setOptionalNarrowedTenantId( Buff.getOptionalNarrowedTenantId() );
		keyNarrowedIdx.setOptionalNarrowedId( Buff.getOptionalNarrowedId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RelationUNameIdx",
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
						"RelTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelationType().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationTypeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"RelationType",
						"RelationType",
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
						"FromTable",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredFromIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"FromIndex",
						"Index",
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
						Buff.getRequiredToTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"ToTable",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredToIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"ToIndex",
						"Index",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictRelnTenantIdx;
		if( dictByRelnTenantIdx.containsKey( keyRelnTenantIdx ) ) {
			subdictRelnTenantIdx = dictByRelnTenantIdx.get( keyRelnTenantIdx );
		}
		else {
			subdictRelnTenantIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRelnTenantIdx.put( keyRelnTenantIdx, subdictRelnTenantIdx );
		}
		subdictRelnTenantIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictRTypeKeyIdx;
		if( dictByRTypeKeyIdx.containsKey( keyRTypeKeyIdx ) ) {
			subdictRTypeKeyIdx = dictByRTypeKeyIdx.get( keyRTypeKeyIdx );
		}
		else {
			subdictRTypeKeyIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRTypeKeyIdx.put( keyRTypeKeyIdx, subdictRTypeKeyIdx );
		}
		subdictRTypeKeyIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictFromKeyIdx;
		if( dictByFromKeyIdx.containsKey( keyFromKeyIdx ) ) {
			subdictFromKeyIdx = dictByFromKeyIdx.get( keyFromKeyIdx );
		}
		else {
			subdictFromKeyIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByFromKeyIdx.put( keyFromKeyIdx, subdictFromKeyIdx );
		}
		subdictFromKeyIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictToTblIdx;
		if( dictByToTblIdx.containsKey( keyToTblIdx ) ) {
			subdictToTblIdx = dictByToTblIdx.get( keyToTblIdx );
		}
		else {
			subdictToTblIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToTblIdx.put( keyToTblIdx, subdictToTblIdx );
		}
		subdictToTblIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictToKeyIdx;
		if( dictByToKeyIdx.containsKey( keyToKeyIdx ) ) {
			subdictToKeyIdx = dictByToKeyIdx.get( keyToKeyIdx );
		}
		else {
			subdictToKeyIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToKeyIdx.put( keyToKeyIdx, subdictToKeyIdx );
		}
		subdictToKeyIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamRelationBuff > subdictNarrowedIdx;
		if( dictByNarrowedIdx.containsKey( keyNarrowedIdx ) ) {
			subdictNarrowedIdx = dictByNarrowedIdx.get( keyNarrowedIdx );
		}
		else {
			subdictNarrowedIdx = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByNarrowedIdx.put( keyNarrowedIdx, subdictNarrowedIdx );
		}
		subdictNarrowedIdx.put( pkey, Buff );

	}

	public CFBamRelationBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelation.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelation.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamRelation.readAllDerived() ";
		CFBamRelationBuff[] retList = new CFBamRelationBuff[ dictByPKey.values().size() ];
		Iterator< CFBamRelationBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamRelationBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamRelationBuff ) ) {
					filteredList.add( (CFBamRelationBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamRelationBuff[0] ) );
		}
	}

	public CFBamRelationBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByUNameIdx() ";
		CFBamRelationByUNameIdxKey key = schema.getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );

		CFBamRelationBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff[] readDerivedByRelnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByRelnTenantIdx() ";
		CFBamRelationByRelnTenantIdxKey key = schema.getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamRelationBuff[] recArray;
		if( dictByRelnTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRelnTenantIdx
				= dictByRelnTenantIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictRelnTenantIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictRelnTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRelnTenantIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRelnTenantIdx.put( key, subdictRelnTenantIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByTableIdx() ";
		CFBamRelationByTableIdxKey key = schema.getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		CFBamRelationBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictTableIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictTableIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByDefSchemaIdx() ";
		CFBamRelationByDefSchemaIdxKey key = schema.getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamRelationBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByRTypeKeyIdx( CFBamAuthorization Authorization,
		short RelationTypeId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByRTypeKeyIdx() ";
		CFBamRelationByRTypeKeyIdxKey key = schema.getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( RelationTypeId );

		CFBamRelationBuff[] recArray;
		if( dictByRTypeKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRTypeKeyIdx
				= dictByRTypeKeyIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictRTypeKeyIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictRTypeKeyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRTypeKeyIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRTypeKeyIdx.put( key, subdictRTypeKeyIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByFromKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromIndexId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByFromKeyIdx() ";
		CFBamRelationByFromKeyIdxKey key = schema.getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );

		CFBamRelationBuff[] recArray;
		if( dictByFromKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictFromKeyIdx
				= dictByFromKeyIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictFromKeyIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictFromKeyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictFromKeyIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByFromKeyIdx.put( key, subdictFromKeyIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByToTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToTableId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByToTblIdx() ";
		CFBamRelationByToTblIdxKey key = schema.getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );

		CFBamRelationBuff[] recArray;
		if( dictByToTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToTblIdx
				= dictByToTblIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictToTblIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictToTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToTblIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToTblIdx.put( key, subdictToTblIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByToKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToIndexId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByToKeyIdx() ";
		CFBamRelationByToKeyIdxKey key = schema.getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );

		CFBamRelationBuff[] recArray;
		if( dictByToKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToKeyIdx
				= dictByToKeyIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictToKeyIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictToKeyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToKeyIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToKeyIdx.put( key, subdictToKeyIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff[] readDerivedByNarrowedIdx( CFBamAuthorization Authorization,
		Long NarrowedTenantId,
		Long NarrowedId )
	{
		final String S_ProcName = "CFBamRamRelation.readDerivedByNarrowedIdx() ";
		CFBamRelationByNarrowedIdxKey key = schema.getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );

		CFBamRelationBuff[] recArray;
		if( dictByNarrowedIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictNarrowedIdx
				= dictByNarrowedIdx.get( key );
			recArray = new CFBamRelationBuff[ subdictNarrowedIdx.size() ];
			Iterator< CFBamRelationBuff > iter = subdictNarrowedIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictNarrowedIdx
				= new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByNarrowedIdx.put( key, subdictNarrowedIdx );
			recArray = new CFBamRelationBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamRelationBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelation.readBuff() ";
		CFBamRelationBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RELD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamRelation.readBuff() ";
		CFBamRelationBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RELD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamRelation.readAllBuff() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamRelationBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamRelationBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByUNameIdx() ";
		CFBamRelationBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
			return( (CFBamRelationBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamRelationBuff[] readBuffByRelnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByRelnTenantIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByRelnTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByTableIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByDefSchemaIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByRTypeKeyIdx( CFBamAuthorization Authorization,
		short RelationTypeId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByRTypeKeyIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByRTypeKeyIdx( Authorization,
			RelationTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByFromKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromIndexId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByFromKeyIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByFromKeyIdx( Authorization,
			TenantId,
			FromIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByToTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToTableId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByToTblIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByToTblIdx( Authorization,
			TenantId,
			ToTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByToKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToIndexId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByToKeyIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByToKeyIdx( Authorization,
			TenantId,
			ToIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public CFBamRelationBuff[] readBuffByNarrowedIdx( CFBamAuthorization Authorization,
		Long NarrowedTenantId,
		Long NarrowedId )
	{
		final String S_ProcName = "CFBamRamRelation.readBuffByNarrowedIdx() ";
		CFBamRelationBuff buff;
		ArrayList<CFBamRelationBuff> filteredList = new ArrayList<CFBamRelationBuff>();
		CFBamRelationBuff[] buffList = readDerivedByNarrowedIdx( Authorization,
			NarrowedTenantId,
			NarrowedId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELD" ) ) {
				filteredList.add( (CFBamRelationBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationBuff[0] ) );
	}

	public void updateRelation( CFBamAuthorization Authorization,
		CFBamRelationBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateRelation",
				"Existing record not found",
				"Relation",
				pkey );
		}
		CFBamRelationByUNameIdxKey existingKeyUNameIdx = schema.getFactoryRelation().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamRelationByUNameIdxKey newKeyUNameIdx = schema.getFactoryRelation().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamRelationByRelnTenantIdxKey existingKeyRelnTenantIdx = schema.getFactoryRelation().newRelnTenantIdxKey();
		existingKeyRelnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamRelationByRelnTenantIdxKey newKeyRelnTenantIdx = schema.getFactoryRelation().newRelnTenantIdxKey();
		newKeyRelnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamRelationByTableIdxKey existingKeyTableIdx = schema.getFactoryRelation().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamRelationByTableIdxKey newKeyTableIdx = schema.getFactoryRelation().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamRelationByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryRelation().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamRelationByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryRelation().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamRelationByRTypeKeyIdxKey existingKeyRTypeKeyIdx = schema.getFactoryRelation().newRTypeKeyIdxKey();
		existingKeyRTypeKeyIdx.setRequiredRelationTypeId( existing.getRequiredRelationTypeId() );

		CFBamRelationByRTypeKeyIdxKey newKeyRTypeKeyIdx = schema.getFactoryRelation().newRTypeKeyIdxKey();
		newKeyRTypeKeyIdx.setRequiredRelationTypeId( Buff.getRequiredRelationTypeId() );

		CFBamRelationByFromKeyIdxKey existingKeyFromKeyIdx = schema.getFactoryRelation().newFromKeyIdxKey();
		existingKeyFromKeyIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyFromKeyIdx.setRequiredFromIndexId( existing.getRequiredFromIndexId() );

		CFBamRelationByFromKeyIdxKey newKeyFromKeyIdx = schema.getFactoryRelation().newFromKeyIdxKey();
		newKeyFromKeyIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyFromKeyIdx.setRequiredFromIndexId( Buff.getRequiredFromIndexId() );

		CFBamRelationByToTblIdxKey existingKeyToTblIdx = schema.getFactoryRelation().newToTblIdxKey();
		existingKeyToTblIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyToTblIdx.setRequiredToTableId( existing.getRequiredToTableId() );

		CFBamRelationByToTblIdxKey newKeyToTblIdx = schema.getFactoryRelation().newToTblIdxKey();
		newKeyToTblIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyToTblIdx.setRequiredToTableId( Buff.getRequiredToTableId() );

		CFBamRelationByToKeyIdxKey existingKeyToKeyIdx = schema.getFactoryRelation().newToKeyIdxKey();
		existingKeyToKeyIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyToKeyIdx.setRequiredToIndexId( existing.getRequiredToIndexId() );

		CFBamRelationByToKeyIdxKey newKeyToKeyIdx = schema.getFactoryRelation().newToKeyIdxKey();
		newKeyToKeyIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyToKeyIdx.setRequiredToIndexId( Buff.getRequiredToIndexId() );

		CFBamRelationByNarrowedIdxKey existingKeyNarrowedIdx = schema.getFactoryRelation().newNarrowedIdxKey();
		existingKeyNarrowedIdx.setOptionalNarrowedTenantId( existing.getOptionalNarrowedTenantId() );
		existingKeyNarrowedIdx.setOptionalNarrowedId( existing.getOptionalNarrowedId() );

		CFBamRelationByNarrowedIdxKey newKeyNarrowedIdx = schema.getFactoryRelation().newNarrowedIdxKey();
		newKeyNarrowedIdx.setOptionalNarrowedTenantId( Buff.getOptionalNarrowedTenantId() );
		newKeyNarrowedIdx.setOptionalNarrowedId( Buff.getOptionalNarrowedId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateRelation",
					"RelationUNameIdx",
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
						"updateRelation",
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
						"updateRelation",
						"Owner",
						"RelTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelationType().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationTypeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"RelationType",
						"RelationType",
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
						"updateRelation",
						"Container",
						"FromTable",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredFromIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"FromIndex",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredToTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"ToTable",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredToIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"ToIndex",
						"Index",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamRelationBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRelnTenantIdx.get( existingKeyRelnTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelnTenantIdx.containsKey( newKeyRelnTenantIdx ) ) {
			subdict = dictByRelnTenantIdx.get( newKeyRelnTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRelnTenantIdx.put( newKeyRelnTenantIdx, subdict );
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
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
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
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRTypeKeyIdx.get( existingKeyRTypeKeyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRTypeKeyIdx.containsKey( newKeyRTypeKeyIdx ) ) {
			subdict = dictByRTypeKeyIdx.get( newKeyRTypeKeyIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByRTypeKeyIdx.put( newKeyRTypeKeyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFromKeyIdx.get( existingKeyFromKeyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFromKeyIdx.containsKey( newKeyFromKeyIdx ) ) {
			subdict = dictByFromKeyIdx.get( newKeyFromKeyIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByFromKeyIdx.put( newKeyFromKeyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToTblIdx.get( existingKeyToTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToTblIdx.containsKey( newKeyToTblIdx ) ) {
			subdict = dictByToTblIdx.get( newKeyToTblIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToTblIdx.put( newKeyToTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToKeyIdx.get( existingKeyToKeyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToKeyIdx.containsKey( newKeyToKeyIdx ) ) {
			subdict = dictByToKeyIdx.get( newKeyToKeyIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByToKeyIdx.put( newKeyToKeyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNarrowedIdx.get( existingKeyNarrowedIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNarrowedIdx.containsKey( newKeyNarrowedIdx ) ) {
			subdict = dictByNarrowedIdx.get( newKeyNarrowedIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamRelationBuff >();
			dictByNarrowedIdx.put( newKeyNarrowedIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteRelation( CFBamAuthorization Authorization,
		CFBamRelationBuff Buff )
	{
		final String S_ProcName = "CFBamRamRelationTable.deleteRelation() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteRelation",
				pkey );
		}
		CFBamRelationByUNameIdxKey keyUNameIdx = schema.getFactoryRelation().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx = schema.getFactoryRelation().newRelnTenantIdxKey();
		keyRelnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamRelationByTableIdxKey keyTableIdx = schema.getFactoryRelation().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryRelation().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx = schema.getFactoryRelation().newRTypeKeyIdxKey();
		keyRTypeKeyIdx.setRequiredRelationTypeId( existing.getRequiredRelationTypeId() );

		CFBamRelationByFromKeyIdxKey keyFromKeyIdx = schema.getFactoryRelation().newFromKeyIdxKey();
		keyFromKeyIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyFromKeyIdx.setRequiredFromIndexId( existing.getRequiredFromIndexId() );

		CFBamRelationByToTblIdxKey keyToTblIdx = schema.getFactoryRelation().newToTblIdxKey();
		keyToTblIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyToTblIdx.setRequiredToTableId( existing.getRequiredToTableId() );

		CFBamRelationByToKeyIdxKey keyToKeyIdx = schema.getFactoryRelation().newToKeyIdxKey();
		keyToKeyIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyToKeyIdx.setRequiredToIndexId( existing.getRequiredToIndexId() );

		CFBamRelationByNarrowedIdxKey keyNarrowedIdx = schema.getFactoryRelation().newNarrowedIdxKey();
		keyNarrowedIdx.setOptionalNarrowedTenantId( existing.getOptionalNarrowedTenantId() );
		keyNarrowedIdx.setOptionalNarrowedId( existing.getOptionalNarrowedId() );


		// Validate reverse foreign keys

		if( schema.getTableDelDep().readDerivedByTableIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Relation",
				"DelDep",
				pkey );
		}

		if( schema.getTableClearDep().readDerivedByTableIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Relation",
				"ClearDep",
				pkey );
		}

		if( schema.getTablePopDep().readDerivedByRelationIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Relation",
				"PopDep",
				pkey );
		}

		if( schema.getTableChain().readDerivedByPrevRelIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"PrevRelation",
				"Chain",
				pkey );
		}

		if( schema.getTableChain().readDerivedByNextRelIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"NextRelation",
				"Chain",
				pkey );
		}

		// Delete is valid

		schema.getTableRelationCol().deleteRelationColByRelationIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTablePopTopDep().deletePopTopDepByContRelIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamRelationBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRelnTenantIdx.get( keyRelnTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByRTypeKeyIdx.get( keyRTypeKeyIdx );
		subdict.remove( pkey );

		subdict = dictByFromKeyIdx.get( keyFromKeyIdx );
		subdict.remove( pkey );

		subdict = dictByToTblIdx.get( keyToTblIdx );
		subdict.remove( pkey );

		subdict = dictByToKeyIdx.get( keyToKeyIdx );
		subdict.remove( pkey );

		subdict = dictByNarrowedIdx.get( keyNarrowedIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteRelationByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamRelationByUNameIdxKey key = schema.getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteRelationByUNameIdx( Authorization, key );
	}

	public void deleteRelationByUNameIdx( CFBamAuthorization Authorization,
		CFBamRelationByUNameIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByRelnTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamRelationByRelnTenantIdxKey key = schema.getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteRelationByRelnTenantIdx( Authorization, key );
	}

	public void deleteRelationByRelnTenantIdx( CFBamAuthorization Authorization,
		CFBamRelationByRelnTenantIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamRelationByTableIdxKey key = schema.getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteRelationByTableIdx( Authorization, key );
	}

	public void deleteRelationByTableIdx( CFBamAuthorization Authorization,
		CFBamRelationByTableIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamRelationByDefSchemaIdxKey key = schema.getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteRelationByDefSchemaIdx( Authorization, key );
	}

	public void deleteRelationByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamRelationByDefSchemaIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByRTypeKeyIdx( CFBamAuthorization Authorization,
		short argRelationTypeId )
	{
		CFBamRelationByRTypeKeyIdxKey key = schema.getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( argRelationTypeId );
		deleteRelationByRTypeKeyIdx( Authorization, key );
	}

	public void deleteRelationByRTypeKeyIdx( CFBamAuthorization Authorization,
		CFBamRelationByRTypeKeyIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByFromKeyIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argFromIndexId )
	{
		CFBamRelationByFromKeyIdxKey key = schema.getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredFromIndexId( argFromIndexId );
		deleteRelationByFromKeyIdx( Authorization, key );
	}

	public void deleteRelationByFromKeyIdx( CFBamAuthorization Authorization,
		CFBamRelationByFromKeyIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByToTblIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argToTableId )
	{
		CFBamRelationByToTblIdxKey key = schema.getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredToTableId( argToTableId );
		deleteRelationByToTblIdx( Authorization, key );
	}

	public void deleteRelationByToTblIdx( CFBamAuthorization Authorization,
		CFBamRelationByToTblIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByToKeyIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argToIndexId )
	{
		CFBamRelationByToKeyIdxKey key = schema.getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredToIndexId( argToIndexId );
		deleteRelationByToKeyIdx( Authorization, key );
	}

	public void deleteRelationByToKeyIdx( CFBamAuthorization Authorization,
		CFBamRelationByToKeyIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByNarrowedIdx( CFBamAuthorization Authorization,
		Long argNarrowedTenantId,
		Long argNarrowedId )
	{
		CFBamRelationByNarrowedIdxKey key = schema.getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( argNarrowedTenantId );
		key.setOptionalNarrowedId( argNarrowedId );
		deleteRelationByNarrowedIdx( Authorization, key );
	}

	public void deleteRelationByNarrowedIdx( CFBamAuthorization Authorization,
		CFBamRelationByNarrowedIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteRelationByIdIdx( Authorization, key );
	}

	public void deleteRelationByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public void deleteRelationByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteRelationByTenantIdx( Authorization, key );
	}

	public void deleteRelationByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamRelationBuff cur;
		LinkedList<CFBamRelationBuff> matchSet = new LinkedList<CFBamRelationBuff>();
		Iterator<CFBamRelationBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelation( Authorization, cur );
		}
	}

	public CFBamCursor openRelationCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamRelationCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openRelationCursorByRelnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamRelationByRelnTenantIdxKey key = schema.getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByRelnTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRelnTenantIdx
				= dictByRelnTenantIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictRelnTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		CFBamCursor cursor;
		CFBamRelationByTableIdxKey key = schema.getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamRelationByDefSchemaIdxKey key = schema.getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByRTypeKeyIdx( CFBamAuthorization Authorization,
		short RelationTypeId )
	{
		CFBamCursor cursor;
		CFBamRelationByRTypeKeyIdxKey key = schema.getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( RelationTypeId );

		if( dictByRTypeKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictRTypeKeyIdx
				= dictByRTypeKeyIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictRTypeKeyIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByFromKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromIndexId )
	{
		CFBamCursor cursor;
		CFBamRelationByFromKeyIdxKey key = schema.getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );

		if( dictByFromKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictFromKeyIdx
				= dictByFromKeyIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictFromKeyIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByToTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToTableId )
	{
		CFBamCursor cursor;
		CFBamRelationByToTblIdxKey key = schema.getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );

		if( dictByToTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToTblIdx
				= dictByToTblIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictToTblIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByToKeyIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToIndexId )
	{
		CFBamCursor cursor;
		CFBamRelationByToKeyIdxKey key = schema.getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );

		if( dictByToKeyIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictToKeyIdx
				= dictByToKeyIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictToKeyIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationCursorByNarrowedIdx( CFBamAuthorization Authorization,
		Long NarrowedTenantId,
		Long NarrowedId )
	{
		CFBamCursor cursor;
		CFBamRelationByNarrowedIdxKey key = schema.getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );

		if( dictByNarrowedIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamRelationBuff > subdictNarrowedIdx
				= dictByNarrowedIdx.get( key );
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				subdictNarrowedIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationBuff >() );
		}
		return( cursor );
	}

	public void closeRelationCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamRelationBuff nextRelationCursor( CFBamCursor Cursor ) {
		CFBamRamRelationCursor cursor = (CFBamRamRelationCursor)Cursor;
		CFBamRelationBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamRelationBuff prevRelationCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamRelationBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationBuff firstRelationCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamRelationBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationBuff lastRelationCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastRelationCursor" );
	}

	public CFBamRelationBuff nthRelationCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamRelationBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
