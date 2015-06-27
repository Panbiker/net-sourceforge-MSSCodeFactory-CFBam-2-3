
// Description: Java7 in-memory RAM DbIO implementation for Param.

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
 *	CFBamRamParamTable in-memory RAM DbIO implementation
 *	for Param.
 */
public class CFBamRamParamTable
	implements ICFBamParamTable
{
	private CFBamRamSchema schema;
	private Map< CFBamParamPKey,
				CFBamParamBuff > dictByPKey
		= new HashMap< CFBamParamPKey,
				CFBamParamBuff >();
	private Map< CFBamParamByUNameIdxKey,
			CFBamParamBuff > dictByUNameIdx
		= new HashMap< CFBamParamByUNameIdxKey,
			CFBamParamBuff >();
	private Map< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByValTentIdx
		= new HashMap< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByServerMethodIdx
		= new HashMap< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByServerTypeIdx
		= new HashMap< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByPrevIdx
		= new HashMap< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByNextIdx
		= new HashMap< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByContPrevIdx
		= new HashMap< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();
	private Map< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >> dictByContNextIdx
		= new HashMap< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey,
					CFBamParamBuff >>();

	public CFBamRamParamTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		final String S_ProcName = "createParam";
			CFBamParamBuff tail = null;

			CFBamParamBuff[] siblings = schema.getTableParam().readDerivedByServerMethodIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredServerMethodId() );
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
		
		CFBamParamPKey pkey = schema.getFactoryParam().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextParamIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamParamByUNameIdxKey keyUNameIdx = schema.getFactoryParam().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamParamByValTentIdxKey keyValTentIdx = schema.getFactoryParam().newValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamParamByServerMethodIdxKey keyServerMethodIdx = schema.getFactoryParam().newServerMethodIdxKey();
		keyServerMethodIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyServerMethodIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );

		CFBamParamByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryParam().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamParamByServerTypeIdxKey keyServerTypeIdx = schema.getFactoryParam().newServerTypeIdxKey();
		keyServerTypeIdx.setOptionalTypeTenantId( Buff.getOptionalTypeTenantId() );
		keyServerTypeIdx.setOptionalTypeId( Buff.getOptionalTypeId() );

		CFBamParamByPrevIdxKey keyPrevIdx = schema.getFactoryParam().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamParamByNextIdxKey keyNextIdx = schema.getFactoryParam().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamParamByContPrevIdxKey keyContPrevIdx = schema.getFactoryParam().newContPrevIdxKey();
		keyContPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyContPrevIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamParamByContNextIdxKey keyContNextIdx = schema.getFactoryParam().newContNextIdxKey();
		keyContNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyContNextIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ParamUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredServerMethodId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ServerMethod",
						"ServerMethod",
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
			if( Buff.getOptionalTypeTenantId() != null ) {
				allNull = false;
			}
			if( Buff.getOptionalTypeId() != null ) {
				allNull = false;
			}
			if( ! allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getOptionalTypeTenantId(),
						Buff.getOptionalTypeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Type",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictValTentIdx;
		if( dictByValTentIdx.containsKey( keyValTentIdx ) ) {
			subdictValTentIdx = dictByValTentIdx.get( keyValTentIdx );
		}
		else {
			subdictValTentIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByValTentIdx.put( keyValTentIdx, subdictValTentIdx );
		}
		subdictValTentIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictServerMethodIdx;
		if( dictByServerMethodIdx.containsKey( keyServerMethodIdx ) ) {
			subdictServerMethodIdx = dictByServerMethodIdx.get( keyServerMethodIdx );
		}
		else {
			subdictServerMethodIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerMethodIdx.put( keyServerMethodIdx, subdictServerMethodIdx );
		}
		subdictServerMethodIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictServerTypeIdx;
		if( dictByServerTypeIdx.containsKey( keyServerTypeIdx ) ) {
			subdictServerTypeIdx = dictByServerTypeIdx.get( keyServerTypeIdx );
		}
		else {
			subdictServerTypeIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerTypeIdx.put( keyServerTypeIdx, subdictServerTypeIdx );
		}
		subdictServerTypeIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictContPrevIdx;
		if( dictByContPrevIdx.containsKey( keyContPrevIdx ) ) {
			subdictContPrevIdx = dictByContPrevIdx.get( keyContPrevIdx );
		}
		else {
			subdictContPrevIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContPrevIdx.put( keyContPrevIdx, subdictContPrevIdx );
		}
		subdictContPrevIdx.put( pkey, Buff );

		Map< CFBamParamPKey, CFBamParamBuff > subdictContNextIdx;
		if( dictByContNextIdx.containsKey( keyContNextIdx ) ) {
			subdictContNextIdx = dictByContNextIdx.get( keyContNextIdx );
		}
		else {
			subdictContNextIdx = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContNextIdx.put( keyContNextIdx, subdictContNextIdx );
		}
		subdictContNextIdx.put( pkey, Buff );

		if( tail != null ) {
			CFBamParamBuff tailEdit = schema.getFactoryParam().newBuff();
			tailEdit.set( (CFBamParamBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
			schema.getTableParam().updateParam( Authorization, tailEdit );
		}
	}

	public CFBamParamBuff readDerived( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "CFBamRamParam.readDerived() ";
		CFBamParamPKey key = schema.getFactoryParam().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamParamBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff lockDerived( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "CFBamRamParam.readDerived() ";
		CFBamParamPKey key = schema.getFactoryParam().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamParamBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamParam.readAllDerived() ";
		CFBamParamBuff[] retList = new CFBamParamBuff[ dictByPKey.values().size() ];
		Iterator< CFBamParamBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamParamBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		String Name )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByUNameIdx() ";
		CFBamParamByUNameIdxKey key = schema.getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );

		CFBamParamBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByValTentIdx() ";
		CFBamParamByValTentIdxKey key = schema.getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamParamBuff[] recArray;
		if( dictByValTentIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictValTentIdx
				= dictByValTentIdx.get( key );
			recArray = new CFBamParamBuff[ subdictValTentIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictValTentIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictValTentIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByValTentIdx.put( key, subdictValTentIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByServerMethodIdx() ";
		CFBamParamByServerMethodIdxKey key = schema.getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );

		CFBamParamBuff[] recArray;
		if( dictByServerMethodIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerMethodIdx
				= dictByServerMethodIdx.get( key );
			recArray = new CFBamParamBuff[ subdictServerMethodIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictServerMethodIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerMethodIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerMethodIdx.put( key, subdictServerMethodIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByDefSchemaIdx() ";
		CFBamParamByDefSchemaIdxKey key = schema.getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamParamBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamParamBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictDefSchemaIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByServerTypeIdx() ";
		CFBamParamByServerTypeIdxKey key = schema.getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );

		CFBamParamBuff[] recArray;
		if( dictByServerTypeIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerTypeIdx
				= dictByServerTypeIdx.get( key );
			recArray = new CFBamParamBuff[ subdictServerTypeIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictServerTypeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerTypeIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerTypeIdx.put( key, subdictServerTypeIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByPrevIdx() ";
		CFBamParamByPrevIdxKey key = schema.getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		CFBamParamBuff[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new CFBamParamBuff[ subdictPrevIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictPrevIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByNextIdx() ";
		CFBamParamByNextIdxKey key = schema.getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		CFBamParamBuff[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new CFBamParamBuff[ subdictNextIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictNextIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByContPrevIdx() ";
		CFBamParamByContPrevIdxKey key = schema.getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );

		CFBamParamBuff[] recArray;
		if( dictByContPrevIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContPrevIdx
				= dictByContPrevIdx.get( key );
			recArray = new CFBamParamBuff[ subdictContPrevIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictContPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContPrevIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContPrevIdx.put( key, subdictContPrevIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByContNextIdx() ";
		CFBamParamByContNextIdxKey key = schema.getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );

		CFBamParamBuff[] recArray;
		if( dictByContNextIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContNextIdx
				= dictByContNextIdx.get( key );
			recArray = new CFBamParamBuff[ subdictContNextIdx.size() ];
			Iterator< CFBamParamBuff > iter = subdictContNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContNextIdx
				= new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContNextIdx.put( key, subdictContNextIdx );
			recArray = new CFBamParamBuff[0];
		}
		return( recArray );
	}

	public CFBamParamBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamParam.readDerivedByIdIdx() ";
		CFBamParamPKey key = schema.getFactoryParam().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamParamBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff readBuff( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "CFBamRamParam.readBuff() ";
		CFBamParamBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SPRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff lockBuff( CFBamAuthorization Authorization,
		CFBamParamPKey PKey )
	{
		final String S_ProcName = "CFBamRamParam.readBuff() ";
		CFBamParamBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SPRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamParamBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamParam.readAllBuff() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByIdIdx() ";
		CFBamParamBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
			return( (CFBamParamBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamParamBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		String Name )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByUNameIdx() ";
		CFBamParamBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ServerMethodId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
			return( (CFBamParamBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamParamBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByValTentIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByServerMethodIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByServerMethodIdx( Authorization,
			TenantId,
			ServerMethodId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByDefSchemaIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByServerTypeIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByServerTypeIdx( Authorization,
			TypeTenantId,
			TypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByPrevIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByNextIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByContPrevIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ServerMethodId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	public CFBamParamBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamParam.readBuffByContNextIdx() ";
		CFBamParamBuff buff;
		ArrayList<CFBamParamBuff> filteredList = new ArrayList<CFBamParamBuff>();
		CFBamParamBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ServerMethodId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRM" ) ) {
				filteredList.add( (CFBamParamBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamParamBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamParamBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamParamBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		CFBamParamPKey pkey = schema.getFactoryParam().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamParamBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateParam",
				"Existing record not found",
				"Param",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateParam",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamParamByUNameIdxKey existingKeyUNameIdx = schema.getFactoryParam().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamParamByUNameIdxKey newKeyUNameIdx = schema.getFactoryParam().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamParamByValTentIdxKey existingKeyValTentIdx = schema.getFactoryParam().newValTentIdxKey();
		existingKeyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamParamByValTentIdxKey newKeyValTentIdx = schema.getFactoryParam().newValTentIdxKey();
		newKeyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamParamByServerMethodIdxKey existingKeyServerMethodIdx = schema.getFactoryParam().newServerMethodIdxKey();
		existingKeyServerMethodIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyServerMethodIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );

		CFBamParamByServerMethodIdxKey newKeyServerMethodIdx = schema.getFactoryParam().newServerMethodIdxKey();
		newKeyServerMethodIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyServerMethodIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );

		CFBamParamByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryParam().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamParamByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryParam().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamParamByServerTypeIdxKey existingKeyServerTypeIdx = schema.getFactoryParam().newServerTypeIdxKey();
		existingKeyServerTypeIdx.setOptionalTypeTenantId( existing.getOptionalTypeTenantId() );
		existingKeyServerTypeIdx.setOptionalTypeId( existing.getOptionalTypeId() );

		CFBamParamByServerTypeIdxKey newKeyServerTypeIdx = schema.getFactoryParam().newServerTypeIdxKey();
		newKeyServerTypeIdx.setOptionalTypeTenantId( Buff.getOptionalTypeTenantId() );
		newKeyServerTypeIdx.setOptionalTypeId( Buff.getOptionalTypeId() );

		CFBamParamByPrevIdxKey existingKeyPrevIdx = schema.getFactoryParam().newPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamParamByPrevIdxKey newKeyPrevIdx = schema.getFactoryParam().newPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamParamByNextIdxKey existingKeyNextIdx = schema.getFactoryParam().newNextIdxKey();
		existingKeyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamParamByNextIdxKey newKeyNextIdx = schema.getFactoryParam().newNextIdxKey();
		newKeyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamParamByContPrevIdxKey existingKeyContPrevIdx = schema.getFactoryParam().newContPrevIdxKey();
		existingKeyContPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyContPrevIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamParamByContPrevIdxKey newKeyContPrevIdx = schema.getFactoryParam().newContPrevIdxKey();
		newKeyContPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyContPrevIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamParamByContNextIdxKey existingKeyContNextIdx = schema.getFactoryParam().newContNextIdxKey();
		existingKeyContNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyContNextIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamParamByContNextIdxKey newKeyContNextIdx = schema.getFactoryParam().newContNextIdxKey();
		newKeyContNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyContNextIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateParam",
					"ParamUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredServerMethodId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateParam",
						"Container",
						"ServerMethod",
						"ServerMethod",
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
						"updateParam",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			if( Buff.getOptionalTypeTenantId() != null ) {
				allNull = false;
			}			if( Buff.getOptionalTypeId() != null ) {
				allNull = false;
			}
			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getOptionalTypeTenantId(),
						Buff.getOptionalTypeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateParam",
						"Lookup",
						"Type",
						"Value",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamParamPKey, CFBamParamBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByValTentIdx.get( existingKeyValTentIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByValTentIdx.containsKey( newKeyValTentIdx ) ) {
			subdict = dictByValTentIdx.get( newKeyValTentIdx );
		}
		else {
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByValTentIdx.put( newKeyValTentIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByServerMethodIdx.get( existingKeyServerMethodIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByServerMethodIdx.containsKey( newKeyServerMethodIdx ) ) {
			subdict = dictByServerMethodIdx.get( newKeyServerMethodIdx );
		}
		else {
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerMethodIdx.put( newKeyServerMethodIdx, subdict );
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
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByServerTypeIdx.get( existingKeyServerTypeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByServerTypeIdx.containsKey( newKeyServerTypeIdx ) ) {
			subdict = dictByServerTypeIdx.get( newKeyServerTypeIdx );
		}
		else {
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByServerTypeIdx.put( newKeyServerTypeIdx, subdict );
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
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
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
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContPrevIdx.get( existingKeyContPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPrevIdx.containsKey( newKeyContPrevIdx ) ) {
			subdict = dictByContPrevIdx.get( newKeyContPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContPrevIdx.put( newKeyContPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContNextIdx.get( existingKeyContNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContNextIdx.containsKey( newKeyContNextIdx ) ) {
			subdict = dictByContNextIdx.get( newKeyContNextIdx );
		}
		else {
			subdict = new HashMap< CFBamParamPKey, CFBamParamBuff >();
			dictByContNextIdx.put( newKeyContNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteParam( CFBamAuthorization Authorization,
		CFBamParamBuff Buff )
	{
		final String S_ProcName = "CFBamRamParamTable.deleteParam() ";
		CFBamParamPKey pkey = schema.getFactoryParam().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamParamBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteParam",
				pkey );
		}
		CFBamParamByUNameIdxKey keyUNameIdx = schema.getFactoryParam().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamParamByValTentIdxKey keyValTentIdx = schema.getFactoryParam().newValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamParamByServerMethodIdxKey keyServerMethodIdx = schema.getFactoryParam().newServerMethodIdxKey();
		keyServerMethodIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyServerMethodIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );

		CFBamParamByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryParam().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamParamByServerTypeIdxKey keyServerTypeIdx = schema.getFactoryParam().newServerTypeIdxKey();
		keyServerTypeIdx.setOptionalTypeTenantId( existing.getOptionalTypeTenantId() );
		keyServerTypeIdx.setOptionalTypeId( existing.getOptionalTypeId() );

		CFBamParamByPrevIdxKey keyPrevIdx = schema.getFactoryParam().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamParamByNextIdxKey keyNextIdx = schema.getFactoryParam().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamParamByContPrevIdxKey keyContPrevIdx = schema.getFactoryParam().newContPrevIdxKey();
		keyContPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyContPrevIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamParamByContNextIdxKey keyContNextIdx = schema.getFactoryParam().newContNextIdxKey();
		keyContNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyContNextIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamParamPKey, CFBamParamBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByValTentIdx.get( keyValTentIdx );
		subdict.remove( pkey );

		subdict = dictByServerMethodIdx.get( keyServerMethodIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByServerTypeIdx.get( keyServerTypeIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByContPrevIdx.get( keyContPrevIdx );
		subdict.remove( pkey );

		subdict = dictByContNextIdx.get( keyContNextIdx );
		subdict.remove( pkey );

	}

	public void deleteParamByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamParamPKey key = schema.getFactoryParam().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteParamByIdIdx( Authorization, key );
	}

	public void deleteParamByIdIdx( CFBamAuthorization Authorization,
		CFBamParamPKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argServerMethodId,
		String argName )
	{
		CFBamParamByUNameIdxKey key = schema.getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredServerMethodId( argServerMethodId );
		key.setRequiredName( argName );
		deleteParamByUNameIdx( Authorization, key );
	}

	public void deleteParamByUNameIdx( CFBamAuthorization Authorization,
		CFBamParamByUNameIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamParamByValTentIdxKey key = schema.getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteParamByValTentIdx( Authorization, key );
	}

	public void deleteParamByValTentIdx( CFBamAuthorization Authorization,
		CFBamParamByValTentIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByServerMethodIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argServerMethodId )
	{
		CFBamParamByServerMethodIdxKey key = schema.getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredServerMethodId( argServerMethodId );
		deleteParamByServerMethodIdx( Authorization, key );
	}

	public void deleteParamByServerMethodIdx( CFBamAuthorization Authorization,
		CFBamParamByServerMethodIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamParamByDefSchemaIdxKey key = schema.getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteParamByDefSchemaIdx( Authorization, key );
	}

	public void deleteParamByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamParamByDefSchemaIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByServerTypeIdx( CFBamAuthorization Authorization,
		Long argTypeTenantId,
		Long argTypeId )
	{
		CFBamParamByServerTypeIdxKey key = schema.getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( argTypeTenantId );
		key.setOptionalTypeId( argTypeId );
		deleteParamByServerTypeIdx( Authorization, key );
	}

	public void deleteParamByServerTypeIdx( CFBamAuthorization Authorization,
		CFBamParamByServerTypeIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamParamByPrevIdxKey key = schema.getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteParamByPrevIdx( Authorization, key );
	}

	public void deleteParamByPrevIdx( CFBamAuthorization Authorization,
		CFBamParamByPrevIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamParamByNextIdxKey key = schema.getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteParamByNextIdx( Authorization, key );
	}

	public void deleteParamByNextIdx( CFBamAuthorization Authorization,
		CFBamParamByNextIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argServerMethodId,
		Long argPrevId )
	{
		CFBamParamByContPrevIdxKey key = schema.getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredServerMethodId( argServerMethodId );
		key.setOptionalPrevId( argPrevId );
		deleteParamByContPrevIdx( Authorization, key );
	}

	public void deleteParamByContPrevIdx( CFBamAuthorization Authorization,
		CFBamParamByContPrevIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public void deleteParamByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argServerMethodId,
		Long argNextId )
	{
		CFBamParamByContNextIdxKey key = schema.getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredServerMethodId( argServerMethodId );
		key.setOptionalNextId( argNextId );
		deleteParamByContNextIdx( Authorization, key );
	}

	public void deleteParamByContNextIdx( CFBamAuthorization Authorization,
		CFBamParamByContNextIdxKey argKey )
	{
		CFBamParamBuff cur;
		LinkedList<CFBamParamBuff> matchSet = new LinkedList<CFBamParamBuff>();
		Iterator<CFBamParamBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamParamBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteParam( Authorization, cur );
		}
	}

	public CFBamCursor openParamCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamParamCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openParamCursorByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamParamByValTentIdxKey key = schema.getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByValTentIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictValTentIdx
				= dictByValTentIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictValTentIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByServerMethodIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId )
	{
		CFBamCursor cursor;
		CFBamParamByServerMethodIdxKey key = schema.getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );

		if( dictByServerMethodIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerMethodIdx
				= dictByServerMethodIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictServerMethodIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamParamByDefSchemaIdxKey key = schema.getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByServerTypeIdx( CFBamAuthorization Authorization,
		Long TypeTenantId,
		Long TypeId )
	{
		CFBamCursor cursor;
		CFBamParamByServerTypeIdxKey key = schema.getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );

		if( dictByServerTypeIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictServerTypeIdx
				= dictByServerTypeIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictServerTypeIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamParamByPrevIdxKey key = schema.getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamParamByNextIdxKey key = schema.getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictNextIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamParamByContPrevIdxKey key = schema.getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );

		if( dictByContPrevIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContPrevIdx
				= dictByContPrevIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictContPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openParamCursorByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamParamByContNextIdxKey key = schema.getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );

		if( dictByContNextIdx.containsKey( key ) ) {
			Map< CFBamParamPKey, CFBamParamBuff > subdictContNextIdx
				= dictByContNextIdx.get( key );
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				subdictContNextIdx.values() );
		}
		else {
			cursor = new CFBamRamParamCursor( Authorization,
				schema,
				new ArrayList< CFBamParamBuff >() );
		}
		return( cursor );
	}

	public void closeParamCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamParamBuff nextParamCursor( CFBamCursor Cursor ) {
		CFBamRamParamCursor cursor = (CFBamRamParamCursor)Cursor;
		CFBamParamBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamParamBuff prevParamCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamParamBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextParamCursor( Cursor );
		}
		return( rec );
	}

	public CFBamParamBuff firstParamCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamParamBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextParamCursor( Cursor );
		}
		return( rec );
	}

	public CFBamParamBuff lastParamCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastParamCursor" );
	}

	public CFBamParamBuff nthParamCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamParamBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextParamCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
