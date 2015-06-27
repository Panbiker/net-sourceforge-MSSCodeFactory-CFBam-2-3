
// Description: Java7 in-memory RAM DbIO implementation for RelationCol.

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
 *	CFBamRamRelationColTable in-memory RAM DbIO implementation
 *	for RelationCol.
 */
public class CFBamRamRelationColTable
	implements ICFBamRelationColTable
{
	private CFBamRamSchema schema;
	private Map< CFBamRelationColPKey,
				CFBamRelationColBuff > dictByPKey
		= new HashMap< CFBamRelationColPKey,
				CFBamRelationColBuff >();
	private Map< CFBamRelationColByUNameIdxKey,
			CFBamRelationColBuff > dictByUNameIdx
		= new HashMap< CFBamRelationColByUNameIdxKey,
			CFBamRelationColBuff >();
	private Map< CFBamRelationColByRelColTenantIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByRelColTenantIdx
		= new HashMap< CFBamRelationColByRelColTenantIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByRelationIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByRelationIdx
		= new HashMap< CFBamRelationColByRelationIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByDefSchemaIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamRelationColByDefSchemaIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByFromColIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByFromColIdx
		= new HashMap< CFBamRelationColByFromColIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByToColIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByToColIdx
		= new HashMap< CFBamRelationColByToColIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByPrevIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByPrevIdx
		= new HashMap< CFBamRelationColByPrevIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByNextIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByNextIdx
		= new HashMap< CFBamRelationColByNextIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByRelPrevIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByRelPrevIdx
		= new HashMap< CFBamRelationColByRelPrevIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();
	private Map< CFBamRelationColByRelNextIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >> dictByRelNextIdx
		= new HashMap< CFBamRelationColByRelNextIdxKey,
				Map< CFBamRelationColPKey,
					CFBamRelationColBuff >>();

	public CFBamRamRelationColTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff )
	{
		final String S_ProcName = "createRelationCol";
			CFBamRelationColBuff tail = null;

			CFBamRelationColBuff[] siblings = schema.getTableRelationCol().readDerivedByRelationIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredRelationId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextTenantId() == null )
					&& ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalPrevTenantId( tail.getRequiredTenantId() );
				Buff.setOptionalPrevId( tail.getRequiredId() );
			}
			else {
				Buff.setOptionalPrevTenantId( null );
				Buff.setOptionalPrevId( null );
			}
		
		CFBamRelationColPKey pkey = schema.getFactoryRelationCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextRelationColIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamRelationColByUNameIdxKey keyUNameIdx = schema.getFactoryRelationCol().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		keyRelColTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamRelationColByRelationIdxKey keyRelationIdx = schema.getFactoryRelationCol().newRelationIdxKey();
		keyRelationIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamRelationColByFromColIdxKey keyFromColIdx = schema.getFactoryRelationCol().newFromColIdxKey();
		keyFromColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyFromColIdx.setRequiredFromColId( Buff.getRequiredFromColId() );

		CFBamRelationColByToColIdxKey keyToColIdx = schema.getFactoryRelationCol().newToColIdxKey();
		keyToColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyToColIdx.setRequiredToColId( Buff.getRequiredToColId() );

		CFBamRelationColByPrevIdxKey keyPrevIdx = schema.getFactoryRelationCol().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamRelationColByNextIdxKey keyNextIdx = schema.getFactoryRelationCol().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamRelationColByRelPrevIdxKey keyRelPrevIdx = schema.getFactoryRelationCol().newRelPrevIdxKey();
		keyRelPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyRelPrevIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyRelPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamRelationColByRelNextIdxKey keyRelNextIdx = schema.getFactoryRelationCol().newRelNextIdxKey();
		keyRelNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyRelNextIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyRelNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RelationColUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Relation",
						"Relation",
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
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredFromColId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"LookupFromCol",
						"IndexCol",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredToColId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"LookupToCol",
						"IndexCol",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelColTenantIdx;
		if( dictByRelColTenantIdx.containsKey( keyRelColTenantIdx ) ) {
			subdictRelColTenantIdx = dictByRelColTenantIdx.get( keyRelColTenantIdx );
		}
		else {
			subdictRelColTenantIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelColTenantIdx.put( keyRelColTenantIdx, subdictRelColTenantIdx );
		}
		subdictRelColTenantIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelationIdx;
		if( dictByRelationIdx.containsKey( keyRelationIdx ) ) {
			subdictRelationIdx = dictByRelationIdx.get( keyRelationIdx );
		}
		else {
			subdictRelationIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelationIdx.put( keyRelationIdx, subdictRelationIdx );
		}
		subdictRelationIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictFromColIdx;
		if( dictByFromColIdx.containsKey( keyFromColIdx ) ) {
			subdictFromColIdx = dictByFromColIdx.get( keyFromColIdx );
		}
		else {
			subdictFromColIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByFromColIdx.put( keyFromColIdx, subdictFromColIdx );
		}
		subdictFromColIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictToColIdx;
		if( dictByToColIdx.containsKey( keyToColIdx ) ) {
			subdictToColIdx = dictByToColIdx.get( keyToColIdx );
		}
		else {
			subdictToColIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByToColIdx.put( keyToColIdx, subdictToColIdx );
		}
		subdictToColIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelPrevIdx;
		if( dictByRelPrevIdx.containsKey( keyRelPrevIdx ) ) {
			subdictRelPrevIdx = dictByRelPrevIdx.get( keyRelPrevIdx );
		}
		else {
			subdictRelPrevIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelPrevIdx.put( keyRelPrevIdx, subdictRelPrevIdx );
		}
		subdictRelPrevIdx.put( pkey, Buff );

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelNextIdx;
		if( dictByRelNextIdx.containsKey( keyRelNextIdx ) ) {
			subdictRelNextIdx = dictByRelNextIdx.get( keyRelNextIdx );
		}
		else {
			subdictRelNextIdx = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelNextIdx.put( keyRelNextIdx, subdictRelNextIdx );
		}
		subdictRelNextIdx.put( pkey, Buff );

		if( tail != null ) {
			CFBamRelationColBuff tailEdit = schema.getFactoryRelationCol().newBuff();
			tailEdit.set( (CFBamRelationColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
			schema.getTableRelationCol().updateRelationCol( Authorization, tailEdit );
		}
	}

	public CFBamRelationColBuff readDerived( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerived() ";
		CFBamRelationColPKey key = schema.getFactoryRelationCol().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff lockDerived( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerived() ";
		CFBamRelationColPKey key = schema.getFactoryRelationCol().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamRelationColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamRelationCol.readAllDerived() ";
		CFBamRelationColBuff[] retList = new CFBamRelationColBuff[ dictByPKey.values().size() ];
		Iterator< CFBamRelationColBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamRelationColBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		String Name )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByUNameIdx() ";
		CFBamRelationColByUNameIdxKey key = schema.getFactoryRelationCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setRequiredName( Name );

		CFBamRelationColBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff[] readDerivedByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByRelColTenantIdx() ";
		CFBamRelationColByRelColTenantIdxKey key = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamRelationColBuff[] recArray;
		if( dictByRelColTenantIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelColTenantIdx
				= dictByRelColTenantIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictRelColTenantIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictRelColTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelColTenantIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelColTenantIdx.put( key, subdictRelColTenantIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByRelationIdx() ";
		CFBamRelationColByRelationIdxKey key = schema.getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );

		CFBamRelationColBuff[] recArray;
		if( dictByRelationIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelationIdx
				= dictByRelationIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictRelationIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictRelationIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelationIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelationIdx.put( key, subdictRelationIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByDefSchemaIdx() ";
		CFBamRelationColByDefSchemaIdxKey key = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamRelationColBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictDefSchemaIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByFromColIdx() ";
		CFBamRelationColByFromColIdxKey key = schema.getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromColId( FromColId );

		CFBamRelationColBuff[] recArray;
		if( dictByFromColIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictFromColIdx
				= dictByFromColIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictFromColIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictFromColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictFromColIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByFromColIdx.put( key, subdictFromColIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByToColIdx() ";
		CFBamRelationColByToColIdxKey key = schema.getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToColId( ToColId );

		CFBamRelationColBuff[] recArray;
		if( dictByToColIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictToColIdx
				= dictByToColIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictToColIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictToColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictToColIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByToColIdx.put( key, subdictToColIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByPrevIdx() ";
		CFBamRelationColByPrevIdxKey key = schema.getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		CFBamRelationColBuff[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictPrevIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictPrevIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByNextIdx() ";
		CFBamRelationColByNextIdxKey key = schema.getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		CFBamRelationColBuff[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictNextIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictNextIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByRelPrevIdx() ";
		CFBamRelationColByRelPrevIdxKey key = schema.getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );

		CFBamRelationColBuff[] recArray;
		if( dictByRelPrevIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelPrevIdx
				= dictByRelPrevIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictRelPrevIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictRelPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelPrevIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelPrevIdx.put( key, subdictRelPrevIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff[] readDerivedByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByRelNextIdx() ";
		CFBamRelationColByRelNextIdxKey key = schema.getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );

		CFBamRelationColBuff[] recArray;
		if( dictByRelNextIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelNextIdx
				= dictByRelNextIdx.get( key );
			recArray = new CFBamRelationColBuff[ subdictRelNextIdx.size() ];
			Iterator< CFBamRelationColBuff > iter = subdictRelNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelNextIdx
				= new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelNextIdx.put( key, subdictRelNextIdx );
			recArray = new CFBamRelationColBuff[0];
		}
		return( recArray );
	}

	public CFBamRelationColBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamRelationCol.readDerivedByIdIdx() ";
		CFBamRelationColPKey key = schema.getFactoryRelationCol().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamRelationColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff readBuff( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuff() ";
		CFBamRelationColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RELC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff lockBuff( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuff() ";
		CFBamRelationColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RELC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamRelationColBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamRelationCol.readAllBuff() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByIdIdx() ";
		CFBamRelationColBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
			return( (CFBamRelationColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamRelationColBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		String Name )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByUNameIdx() ";
		CFBamRelationColBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			RelationId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
			return( (CFBamRelationColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamRelationColBuff[] readBuffByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByRelColTenantIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByRelColTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByRelationIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByRelationIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByDefSchemaIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByFromColIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByFromColIdx( Authorization,
			TenantId,
			FromColId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByToColIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByToColIdx( Authorization,
			TenantId,
			ToColId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByPrevIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByNextIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByRelPrevIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByRelPrevIdx( Authorization,
			TenantId,
			RelationId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	public CFBamRelationColBuff[] readBuffByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamRelationCol.readBuffByRelNextIdx() ";
		CFBamRelationColBuff buff;
		ArrayList<CFBamRelationColBuff> filteredList = new ArrayList<CFBamRelationColBuff>();
		CFBamRelationColBuff[] buffList = readDerivedByRelNextIdx( Authorization,
			TenantId,
			RelationId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RELC" ) ) {
				filteredList.add( (CFBamRelationColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamRelationColBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamRelationColBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffUp" );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamRelationColBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff )
	{
		CFBamRelationColPKey pkey = schema.getFactoryRelationCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateRelationCol",
				"Existing record not found",
				"RelationCol",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateRelationCol",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamRelationColByUNameIdxKey existingKeyUNameIdx = schema.getFactoryRelationCol().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamRelationColByUNameIdxKey newKeyUNameIdx = schema.getFactoryRelationCol().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamRelationColByRelColTenantIdxKey existingKeyRelColTenantIdx = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		existingKeyRelColTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamRelationColByRelColTenantIdxKey newKeyRelColTenantIdx = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		newKeyRelColTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamRelationColByRelationIdxKey existingKeyRelationIdx = schema.getFactoryRelationCol().newRelationIdxKey();
		existingKeyRelationIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamRelationColByRelationIdxKey newKeyRelationIdx = schema.getFactoryRelationCol().newRelationIdxKey();
		newKeyRelationIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		CFBamRelationColByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamRelationColByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamRelationColByFromColIdxKey existingKeyFromColIdx = schema.getFactoryRelationCol().newFromColIdxKey();
		existingKeyFromColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyFromColIdx.setRequiredFromColId( existing.getRequiredFromColId() );

		CFBamRelationColByFromColIdxKey newKeyFromColIdx = schema.getFactoryRelationCol().newFromColIdxKey();
		newKeyFromColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyFromColIdx.setRequiredFromColId( Buff.getRequiredFromColId() );

		CFBamRelationColByToColIdxKey existingKeyToColIdx = schema.getFactoryRelationCol().newToColIdxKey();
		existingKeyToColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyToColIdx.setRequiredToColId( existing.getRequiredToColId() );

		CFBamRelationColByToColIdxKey newKeyToColIdx = schema.getFactoryRelationCol().newToColIdxKey();
		newKeyToColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyToColIdx.setRequiredToColId( Buff.getRequiredToColId() );

		CFBamRelationColByPrevIdxKey existingKeyPrevIdx = schema.getFactoryRelationCol().newPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamRelationColByPrevIdxKey newKeyPrevIdx = schema.getFactoryRelationCol().newPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamRelationColByNextIdxKey existingKeyNextIdx = schema.getFactoryRelationCol().newNextIdxKey();
		existingKeyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamRelationColByNextIdxKey newKeyNextIdx = schema.getFactoryRelationCol().newNextIdxKey();
		newKeyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamRelationColByRelPrevIdxKey existingKeyRelPrevIdx = schema.getFactoryRelationCol().newRelPrevIdxKey();
		existingKeyRelPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyRelPrevIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyRelPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamRelationColByRelPrevIdxKey newKeyRelPrevIdx = schema.getFactoryRelationCol().newRelPrevIdxKey();
		newKeyRelPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyRelPrevIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyRelPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamRelationColByRelNextIdxKey existingKeyRelNextIdx = schema.getFactoryRelationCol().newRelNextIdxKey();
		existingKeyRelNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyRelNextIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyRelNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamRelationColByRelNextIdxKey newKeyRelNextIdx = schema.getFactoryRelationCol().newRelNextIdxKey();
		newKeyRelNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyRelNextIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyRelNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateRelationCol",
					"RelationColUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Container",
						"Relation",
						"Relation",
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
						"updateRelationCol",
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
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredFromColId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Lookup",
						"LookupFromCol",
						"IndexCol",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredToColId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Lookup",
						"LookupToCol",
						"IndexCol",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRelColTenantIdx.get( existingKeyRelColTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelColTenantIdx.containsKey( newKeyRelColTenantIdx ) ) {
			subdict = dictByRelColTenantIdx.get( newKeyRelColTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelColTenantIdx.put( newKeyRelColTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelationIdx.get( existingKeyRelationIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelationIdx.containsKey( newKeyRelationIdx ) ) {
			subdict = dictByRelationIdx.get( newKeyRelationIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelationIdx.put( newKeyRelationIdx, subdict );
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
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFromColIdx.get( existingKeyFromColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFromColIdx.containsKey( newKeyFromColIdx ) ) {
			subdict = dictByFromColIdx.get( newKeyFromColIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByFromColIdx.put( newKeyFromColIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToColIdx.get( existingKeyToColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToColIdx.containsKey( newKeyToColIdx ) ) {
			subdict = dictByToColIdx.get( newKeyToColIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByToColIdx.put( newKeyToColIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByPrevIdx.put( newKeyPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextIdx.get( existingKeyNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextIdx.containsKey( newKeyNextIdx ) ) {
			subdict = dictByNextIdx.get( newKeyNextIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelPrevIdx.get( existingKeyRelPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelPrevIdx.containsKey( newKeyRelPrevIdx ) ) {
			subdict = dictByRelPrevIdx.get( newKeyRelPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelPrevIdx.put( newKeyRelPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelNextIdx.get( existingKeyRelNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelNextIdx.containsKey( newKeyRelNextIdx ) ) {
			subdict = dictByRelNextIdx.get( newKeyRelNextIdx );
		}
		else {
			subdict = new HashMap< CFBamRelationColPKey, CFBamRelationColBuff >();
			dictByRelNextIdx.put( newKeyRelNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff )
	{
		final String S_ProcName = "CFBamRamRelationColTable.deleteRelationCol() ";
		CFBamRelationColPKey pkey = schema.getFactoryRelationCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamRelationColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteRelationCol",
				pkey );
		}
		CFBamRelationColByUNameIdxKey keyUNameIdx = schema.getFactoryRelationCol().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		keyRelColTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamRelationColByRelationIdxKey keyRelationIdx = schema.getFactoryRelationCol().newRelationIdxKey();
		keyRelationIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamRelationColByFromColIdxKey keyFromColIdx = schema.getFactoryRelationCol().newFromColIdxKey();
		keyFromColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyFromColIdx.setRequiredFromColId( existing.getRequiredFromColId() );

		CFBamRelationColByToColIdxKey keyToColIdx = schema.getFactoryRelationCol().newToColIdxKey();
		keyToColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyToColIdx.setRequiredToColId( existing.getRequiredToColId() );

		CFBamRelationColByPrevIdxKey keyPrevIdx = schema.getFactoryRelationCol().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamRelationColByNextIdxKey keyNextIdx = schema.getFactoryRelationCol().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamRelationColByRelPrevIdxKey keyRelPrevIdx = schema.getFactoryRelationCol().newRelPrevIdxKey();
		keyRelPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyRelPrevIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyRelPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamRelationColByRelNextIdxKey keyRelNextIdx = schema.getFactoryRelationCol().newRelNextIdxKey();
		keyRelNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyRelNextIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyRelNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamRelationColPKey, CFBamRelationColBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRelColTenantIdx.get( keyRelColTenantIdx );
		subdict.remove( pkey );

		subdict = dictByRelationIdx.get( keyRelationIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByFromColIdx.get( keyFromColIdx );
		subdict.remove( pkey );

		subdict = dictByToColIdx.get( keyToColIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByRelPrevIdx.get( keyRelPrevIdx );
		subdict.remove( pkey );

		subdict = dictByRelNextIdx.get( keyRelNextIdx );
		subdict.remove( pkey );

	}

	public void deleteRelationColByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamRelationColPKey key = schema.getFactoryRelationCol().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteRelationColByIdIdx( Authorization, key );
	}

	public void deleteRelationColByIdIdx( CFBamAuthorization Authorization,
		CFBamRelationColPKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		String argName )
	{
		CFBamRelationColByUNameIdxKey key = schema.getFactoryRelationCol().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		key.setRequiredName( argName );
		deleteRelationColByUNameIdx( Authorization, key );
	}

	public void deleteRelationColByUNameIdx( CFBamAuthorization Authorization,
		CFBamRelationColByUNameIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByRelColTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamRelationColByRelColTenantIdxKey key = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteRelationColByRelColTenantIdx( Authorization, key );
	}

	public void deleteRelationColByRelColTenantIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelColTenantIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByRelationIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamRelationColByRelationIdxKey key = schema.getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteRelationColByRelationIdx( Authorization, key );
	}

	public void deleteRelationColByRelationIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelationIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamRelationColByDefSchemaIdxKey key = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteRelationColByDefSchemaIdx( Authorization, key );
	}

	public void deleteRelationColByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamRelationColByDefSchemaIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByFromColIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argFromColId )
	{
		CFBamRelationColByFromColIdxKey key = schema.getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredFromColId( argFromColId );
		deleteRelationColByFromColIdx( Authorization, key );
	}

	public void deleteRelationColByFromColIdx( CFBamAuthorization Authorization,
		CFBamRelationColByFromColIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByToColIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argToColId )
	{
		CFBamRelationColByToColIdxKey key = schema.getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredToColId( argToColId );
		deleteRelationColByToColIdx( Authorization, key );
	}

	public void deleteRelationColByToColIdx( CFBamAuthorization Authorization,
		CFBamRelationColByToColIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamRelationColByPrevIdxKey key = schema.getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteRelationColByPrevIdx( Authorization, key );
	}

	public void deleteRelationColByPrevIdx( CFBamAuthorization Authorization,
		CFBamRelationColByPrevIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamRelationColByNextIdxKey key = schema.getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteRelationColByNextIdx( Authorization, key );
	}

	public void deleteRelationColByNextIdx( CFBamAuthorization Authorization,
		CFBamRelationColByNextIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByRelPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		Long argPrevId )
	{
		CFBamRelationColByRelPrevIdxKey key = schema.getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		key.setOptionalPrevId( argPrevId );
		deleteRelationColByRelPrevIdx( Authorization, key );
	}

	public void deleteRelationColByRelPrevIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelPrevIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public void deleteRelationColByRelNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		Long argNextId )
	{
		CFBamRelationColByRelNextIdxKey key = schema.getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		key.setOptionalNextId( argNextId );
		deleteRelationColByRelNextIdx( Authorization, key );
	}

	public void deleteRelationColByRelNextIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelNextIdxKey argKey )
	{
		CFBamRelationColBuff cur;
		LinkedList<CFBamRelationColBuff> matchSet = new LinkedList<CFBamRelationColBuff>();
		Iterator<CFBamRelationColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamRelationColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteRelationCol( Authorization, cur );
		}
	}

	public CFBamCursor openRelationColCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamRelationColCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamRelationColByRelColTenantIdxKey key = schema.getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByRelColTenantIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelColTenantIdx
				= dictByRelColTenantIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictRelColTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		CFBamCursor cursor;
		CFBamRelationColByRelationIdxKey key = schema.getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );

		if( dictByRelationIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelationIdx
				= dictByRelationIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictRelationIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamRelationColByDefSchemaIdxKey key = schema.getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId )
	{
		CFBamCursor cursor;
		CFBamRelationColByFromColIdxKey key = schema.getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromColId( FromColId );

		if( dictByFromColIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictFromColIdx
				= dictByFromColIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictFromColIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId )
	{
		CFBamCursor cursor;
		CFBamRelationColByToColIdxKey key = schema.getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToColId( ToColId );

		if( dictByToColIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictToColIdx
				= dictByToColIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictToColIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamRelationColByPrevIdxKey key = schema.getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamRelationColByNextIdxKey key = schema.getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictNextIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamRelationColByRelPrevIdxKey key = schema.getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );

		if( dictByRelPrevIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelPrevIdx
				= dictByRelPrevIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictRelPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openRelationColCursorByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamRelationColByRelNextIdxKey key = schema.getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );

		if( dictByRelNextIdx.containsKey( key ) ) {
			Map< CFBamRelationColPKey, CFBamRelationColBuff > subdictRelNextIdx
				= dictByRelNextIdx.get( key );
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				subdictRelNextIdx.values() );
		}
		else {
			cursor = new CFBamRamRelationColCursor( Authorization,
				schema,
				new ArrayList< CFBamRelationColBuff >() );
		}
		return( cursor );
	}

	public void closeRelationColCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamRelationColBuff nextRelationColCursor( CFBamCursor Cursor ) {
		CFBamRamRelationColCursor cursor = (CFBamRamRelationColCursor)Cursor;
		CFBamRelationColBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamRelationColBuff prevRelationColCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamRelationColBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationColCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationColBuff firstRelationColCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamRelationColBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationColCursor( Cursor );
		}
		return( rec );
	}

	public CFBamRelationColBuff lastRelationColCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastRelationColCursor" );
	}

	public CFBamRelationColBuff nthRelationColCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamRelationColBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextRelationColCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
