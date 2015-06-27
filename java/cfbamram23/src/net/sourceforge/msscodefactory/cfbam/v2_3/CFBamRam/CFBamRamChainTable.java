
// Description: Java7 in-memory RAM DbIO implementation for Chain.

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
 *	CFBamRamChainTable in-memory RAM DbIO implementation
 *	for Chain.
 */
public class CFBamRamChainTable
	implements ICFBamChainTable
{
	private CFBamRamSchema schema;
	private Map< CFBamChainPKey,
				CFBamChainBuff > dictByPKey
		= new HashMap< CFBamChainPKey,
				CFBamChainBuff >();
	private Map< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >> dictByTenantIdx
		= new HashMap< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >>();
	private Map< CFBamChainByTableIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >> dictByTableIdx
		= new HashMap< CFBamChainByTableIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >>();
	private Map< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >>();
	private Map< CFBamChainByUNameIdxKey,
			CFBamChainBuff > dictByUNameIdx
		= new HashMap< CFBamChainByUNameIdxKey,
			CFBamChainBuff >();
	private Map< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >> dictByPrevRelIdx
		= new HashMap< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >>();
	private Map< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >> dictByNextRelIdx
		= new HashMap< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey,
					CFBamChainBuff >>();

	public CFBamRamChainTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createChain( CFBamAuthorization Authorization,
		CFBamChainBuff Buff )
	{
		final String S_ProcName = "createChain";
		CFBamChainPKey pkey = schema.getFactoryChain().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextChainIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamChainByTenantIdxKey keyTenantIdx = schema.getFactoryChain().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamChainByTableIdxKey keyTableIdx = schema.getFactoryChain().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamChainByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryChain().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamChainByUNameIdxKey keyUNameIdx = schema.getFactoryChain().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamChainByPrevRelIdxKey keyPrevRelIdx = schema.getFactoryChain().newPrevRelIdxKey();
		keyPrevRelIdx.setRequiredPrevRelationTenantId( Buff.getRequiredPrevRelationTenantId() );
		keyPrevRelIdx.setRequiredPrevRelationId( Buff.getRequiredPrevRelationId() );

		CFBamChainByNextRelIdxKey keyNextRelIdx = schema.getFactoryChain().newNextRelIdxKey();
		keyNextRelIdx.setRequiredNextRelationTenantId( Buff.getRequiredNextRelationTenantId() );
		keyNextRelIdx.setRequiredNextRelationId( Buff.getRequiredNextRelationId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ChainUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

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
						"Tenant",
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

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPrevRelationTenantId(),
						Buff.getRequiredPrevRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"PrevRelation",
						"Relation",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredNextRelationTenantId(),
						Buff.getRequiredNextRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"NextRelation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamChainPKey, CFBamChainBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFBamChainPKey, CFBamChainBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		Map< CFBamChainPKey, CFBamChainBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamChainPKey, CFBamChainBuff > subdictPrevRelIdx;
		if( dictByPrevRelIdx.containsKey( keyPrevRelIdx ) ) {
			subdictPrevRelIdx = dictByPrevRelIdx.get( keyPrevRelIdx );
		}
		else {
			subdictPrevRelIdx = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByPrevRelIdx.put( keyPrevRelIdx, subdictPrevRelIdx );
		}
		subdictPrevRelIdx.put( pkey, Buff );

		Map< CFBamChainPKey, CFBamChainBuff > subdictNextRelIdx;
		if( dictByNextRelIdx.containsKey( keyNextRelIdx ) ) {
			subdictNextRelIdx = dictByNextRelIdx.get( keyNextRelIdx );
		}
		else {
			subdictNextRelIdx = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByNextRelIdx.put( keyNextRelIdx, subdictNextRelIdx );
		}
		subdictNextRelIdx.put( pkey, Buff );

	}

	public CFBamChainBuff readDerived( CFBamAuthorization Authorization,
		CFBamChainPKey PKey )
	{
		final String S_ProcName = "CFBamRamChain.readDerived() ";
		CFBamChainPKey key = schema.getFactoryChain().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamChainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff lockDerived( CFBamAuthorization Authorization,
		CFBamChainPKey PKey )
	{
		final String S_ProcName = "CFBamRamChain.readDerived() ";
		CFBamChainPKey key = schema.getFactoryChain().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamChainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamChain.readAllDerived() ";
		CFBamChainBuff[] retList = new CFBamChainBuff[ dictByPKey.values().size() ];
		Iterator< CFBamChainBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamChainBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByTenantIdx() ";
		CFBamChainByTenantIdxKey key = schema.getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamChainBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamChainBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamChainBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTenantIdx
				= new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamChainBuff[0];
		}
		return( recArray );
	}

	public CFBamChainBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByTableIdx() ";
		CFBamChainByTableIdxKey key = schema.getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		CFBamChainBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamChainBuff[ subdictTableIdx.size() ];
			Iterator< CFBamChainBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTableIdx
				= new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamChainBuff[0];
		}
		return( recArray );
	}

	public CFBamChainBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByDefSchemaIdx() ";
		CFBamChainByDefSchemaIdxKey key = schema.getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamChainBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamChainBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamChainBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamChainPKey, CFBamChainBuff > subdictDefSchemaIdx
				= new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamChainBuff[0];
		}
		return( recArray );
	}

	public CFBamChainBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByUNameIdx() ";
		CFBamChainByUNameIdxKey key = schema.getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );

		CFBamChainBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff[] readDerivedByPrevRelIdx( CFBamAuthorization Authorization,
		long PrevRelationTenantId,
		long PrevRelationId )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByPrevRelIdx() ";
		CFBamChainByPrevRelIdxKey key = schema.getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );

		CFBamChainBuff[] recArray;
		if( dictByPrevRelIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictPrevRelIdx
				= dictByPrevRelIdx.get( key );
			recArray = new CFBamChainBuff[ subdictPrevRelIdx.size() ];
			Iterator< CFBamChainBuff > iter = subdictPrevRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamChainPKey, CFBamChainBuff > subdictPrevRelIdx
				= new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByPrevRelIdx.put( key, subdictPrevRelIdx );
			recArray = new CFBamChainBuff[0];
		}
		return( recArray );
	}

	public CFBamChainBuff[] readDerivedByNextRelIdx( CFBamAuthorization Authorization,
		long NextRelationTenantId,
		long NextRelationId )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByNextRelIdx() ";
		CFBamChainByNextRelIdxKey key = schema.getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );

		CFBamChainBuff[] recArray;
		if( dictByNextRelIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictNextRelIdx
				= dictByNextRelIdx.get( key );
			recArray = new CFBamChainBuff[ subdictNextRelIdx.size() ];
			Iterator< CFBamChainBuff > iter = subdictNextRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamChainPKey, CFBamChainBuff > subdictNextRelIdx
				= new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByNextRelIdx.put( key, subdictNextRelIdx );
			recArray = new CFBamChainBuff[0];
		}
		return( recArray );
	}

	public CFBamChainBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamChain.readDerivedByIdIdx() ";
		CFBamChainPKey key = schema.getFactoryChain().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamChainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff readBuff( CFBamAuthorization Authorization,
		CFBamChainPKey PKey )
	{
		final String S_ProcName = "CFBamRamChain.readBuff() ";
		CFBamChainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CHN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff lockBuff( CFBamAuthorization Authorization,
		CFBamChainPKey PKey )
	{
		final String S_ProcName = "CFBamRamChain.readBuff() ";
		CFBamChainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CHN" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamChainBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamChain.readAllBuff() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public CFBamChainBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByIdIdx() ";
		CFBamChainBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
			return( (CFBamChainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamChainBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByTenantIdx() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( (CFBamChainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public CFBamChainBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByTableIdx() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( (CFBamChainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public CFBamChainBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByDefSchemaIdx() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( (CFBamChainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public CFBamChainBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByUNameIdx() ";
		CFBamChainBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
			return( (CFBamChainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamChainBuff[] readBuffByPrevRelIdx( CFBamAuthorization Authorization,
		long PrevRelationTenantId,
		long PrevRelationId )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByPrevRelIdx() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readDerivedByPrevRelIdx( Authorization,
			PrevRelationTenantId,
			PrevRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( (CFBamChainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public CFBamChainBuff[] readBuffByNextRelIdx( CFBamAuthorization Authorization,
		long NextRelationTenantId,
		long NextRelationId )
	{
		final String S_ProcName = "CFBamRamChain.readBuffByNextRelIdx() ";
		CFBamChainBuff buff;
		ArrayList<CFBamChainBuff> filteredList = new ArrayList<CFBamChainBuff>();
		CFBamChainBuff[] buffList = readDerivedByNextRelIdx( Authorization,
			NextRelationTenantId,
			NextRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CHN" ) ) {
				filteredList.add( (CFBamChainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamChainBuff[0] ) );
	}

	public void updateChain( CFBamAuthorization Authorization,
		CFBamChainBuff Buff )
	{
		CFBamChainPKey pkey = schema.getFactoryChain().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamChainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateChain",
				"Existing record not found",
				"Chain",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateChain",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamChainByTenantIdxKey existingKeyTenantIdx = schema.getFactoryChain().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamChainByTenantIdxKey newKeyTenantIdx = schema.getFactoryChain().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamChainByTableIdxKey existingKeyTableIdx = schema.getFactoryChain().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamChainByTableIdxKey newKeyTableIdx = schema.getFactoryChain().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamChainByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryChain().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamChainByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryChain().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamChainByUNameIdxKey existingKeyUNameIdx = schema.getFactoryChain().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamChainByUNameIdxKey newKeyUNameIdx = schema.getFactoryChain().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamChainByPrevRelIdxKey existingKeyPrevRelIdx = schema.getFactoryChain().newPrevRelIdxKey();
		existingKeyPrevRelIdx.setRequiredPrevRelationTenantId( existing.getRequiredPrevRelationTenantId() );
		existingKeyPrevRelIdx.setRequiredPrevRelationId( existing.getRequiredPrevRelationId() );

		CFBamChainByPrevRelIdxKey newKeyPrevRelIdx = schema.getFactoryChain().newPrevRelIdxKey();
		newKeyPrevRelIdx.setRequiredPrevRelationTenantId( Buff.getRequiredPrevRelationTenantId() );
		newKeyPrevRelIdx.setRequiredPrevRelationId( Buff.getRequiredPrevRelationId() );

		CFBamChainByNextRelIdxKey existingKeyNextRelIdx = schema.getFactoryChain().newNextRelIdxKey();
		existingKeyNextRelIdx.setRequiredNextRelationTenantId( existing.getRequiredNextRelationTenantId() );
		existingKeyNextRelIdx.setRequiredNextRelationId( existing.getRequiredNextRelationId() );

		CFBamChainByNextRelIdxKey newKeyNextRelIdx = schema.getFactoryChain().newNextRelIdxKey();
		newKeyNextRelIdx.setRequiredNextRelationTenantId( Buff.getRequiredNextRelationTenantId() );
		newKeyNextRelIdx.setRequiredNextRelationId( Buff.getRequiredNextRelationId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateChain",
					"ChainUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateChain",
						"Owner",
						"Tenant",
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
						"updateChain",
						"Container",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPrevRelationTenantId(),
						Buff.getRequiredPrevRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateChain",
						"Lookup",
						"PrevRelation",
						"Relation",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredNextRelationTenantId(),
						Buff.getRequiredNextRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateChain",
						"Lookup",
						"NextRelation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamChainPKey, CFBamChainBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
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
			subdict = new HashMap< CFBamChainPKey, CFBamChainBuff >();
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
			subdict = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByPrevRelIdx.get( existingKeyPrevRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevRelIdx.containsKey( newKeyPrevRelIdx ) ) {
			subdict = dictByPrevRelIdx.get( newKeyPrevRelIdx );
		}
		else {
			subdict = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByPrevRelIdx.put( newKeyPrevRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextRelIdx.get( existingKeyNextRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextRelIdx.containsKey( newKeyNextRelIdx ) ) {
			subdict = dictByNextRelIdx.get( newKeyNextRelIdx );
		}
		else {
			subdict = new HashMap< CFBamChainPKey, CFBamChainBuff >();
			dictByNextRelIdx.put( newKeyNextRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteChain( CFBamAuthorization Authorization,
		CFBamChainBuff Buff )
	{
		final String S_ProcName = "CFBamRamChainTable.deleteChain() ";
		CFBamChainPKey pkey = schema.getFactoryChain().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamChainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteChain",
				pkey );
		}
		CFBamChainByTenantIdxKey keyTenantIdx = schema.getFactoryChain().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamChainByTableIdxKey keyTableIdx = schema.getFactoryChain().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamChainByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryChain().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamChainByUNameIdxKey keyUNameIdx = schema.getFactoryChain().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamChainByPrevRelIdxKey keyPrevRelIdx = schema.getFactoryChain().newPrevRelIdxKey();
		keyPrevRelIdx.setRequiredPrevRelationTenantId( existing.getRequiredPrevRelationTenantId() );
		keyPrevRelIdx.setRequiredPrevRelationId( existing.getRequiredPrevRelationId() );

		CFBamChainByNextRelIdxKey keyNextRelIdx = schema.getFactoryChain().newNextRelIdxKey();
		keyNextRelIdx.setRequiredNextRelationTenantId( existing.getRequiredNextRelationTenantId() );
		keyNextRelIdx.setRequiredNextRelationId( existing.getRequiredNextRelationId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamChainPKey, CFBamChainBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByPrevRelIdx.get( keyPrevRelIdx );
		subdict.remove( pkey );

		subdict = dictByNextRelIdx.get( keyNextRelIdx );
		subdict.remove( pkey );

	}

	public void deleteChainByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamChainPKey key = schema.getFactoryChain().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteChainByIdIdx( Authorization, key );
	}

	public void deleteChainByIdIdx( CFBamAuthorization Authorization,
		CFBamChainPKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamChainByTenantIdxKey key = schema.getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteChainByTenantIdx( Authorization, key );
	}

	public void deleteChainByTenantIdx( CFBamAuthorization Authorization,
		CFBamChainByTenantIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamChainByTableIdxKey key = schema.getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteChainByTableIdx( Authorization, key );
	}

	public void deleteChainByTableIdx( CFBamAuthorization Authorization,
		CFBamChainByTableIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamChainByDefSchemaIdxKey key = schema.getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteChainByDefSchemaIdx( Authorization, key );
	}

	public void deleteChainByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamChainByDefSchemaIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamChainByUNameIdxKey key = schema.getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteChainByUNameIdx( Authorization, key );
	}

	public void deleteChainByUNameIdx( CFBamAuthorization Authorization,
		CFBamChainByUNameIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByPrevRelIdx( CFBamAuthorization Authorization,
		long argPrevRelationTenantId,
		long argPrevRelationId )
	{
		CFBamChainByPrevRelIdxKey key = schema.getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( argPrevRelationTenantId );
		key.setRequiredPrevRelationId( argPrevRelationId );
		deleteChainByPrevRelIdx( Authorization, key );
	}

	public void deleteChainByPrevRelIdx( CFBamAuthorization Authorization,
		CFBamChainByPrevRelIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public void deleteChainByNextRelIdx( CFBamAuthorization Authorization,
		long argNextRelationTenantId,
		long argNextRelationId )
	{
		CFBamChainByNextRelIdxKey key = schema.getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( argNextRelationTenantId );
		key.setRequiredNextRelationId( argNextRelationId );
		deleteChainByNextRelIdx( Authorization, key );
	}

	public void deleteChainByNextRelIdx( CFBamAuthorization Authorization,
		CFBamChainByNextRelIdxKey argKey )
	{
		CFBamChainBuff cur;
		LinkedList<CFBamChainBuff> matchSet = new LinkedList<CFBamChainBuff>();
		Iterator<CFBamChainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamChainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteChain( Authorization, cur );
		}
	}

	public CFBamCursor openChainCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamChainCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openChainCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamChainByTenantIdxKey key = schema.getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				new ArrayList< CFBamChainBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openChainCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		CFBamCursor cursor;
		CFBamChainByTableIdxKey key = schema.getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				new ArrayList< CFBamChainBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openChainCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamChainByDefSchemaIdxKey key = schema.getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				new ArrayList< CFBamChainBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openChainCursorByPrevRelIdx( CFBamAuthorization Authorization,
		long PrevRelationTenantId,
		long PrevRelationId )
	{
		CFBamCursor cursor;
		CFBamChainByPrevRelIdxKey key = schema.getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );

		if( dictByPrevRelIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictPrevRelIdx
				= dictByPrevRelIdx.get( key );
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				subdictPrevRelIdx.values() );
		}
		else {
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				new ArrayList< CFBamChainBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openChainCursorByNextRelIdx( CFBamAuthorization Authorization,
		long NextRelationTenantId,
		long NextRelationId )
	{
		CFBamCursor cursor;
		CFBamChainByNextRelIdxKey key = schema.getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );

		if( dictByNextRelIdx.containsKey( key ) ) {
			Map< CFBamChainPKey, CFBamChainBuff > subdictNextRelIdx
				= dictByNextRelIdx.get( key );
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				subdictNextRelIdx.values() );
		}
		else {
			cursor = new CFBamRamChainCursor( Authorization,
				schema,
				new ArrayList< CFBamChainBuff >() );
		}
		return( cursor );
	}

	public void closeChainCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamChainBuff nextChainCursor( CFBamCursor Cursor ) {
		CFBamRamChainCursor cursor = (CFBamRamChainCursor)Cursor;
		CFBamChainBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamChainBuff prevChainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamChainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextChainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamChainBuff firstChainCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamChainBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextChainCursor( Cursor );
		}
		return( rec );
	}

	public CFBamChainBuff lastChainCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastChainCursor" );
	}

	public CFBamChainBuff nthChainCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamChainBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextChainCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
