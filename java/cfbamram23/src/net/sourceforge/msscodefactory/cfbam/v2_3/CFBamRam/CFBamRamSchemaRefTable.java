
// Description: Java7 in-memory RAM DbIO implementation for SchemaRef.

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
 *	CFBamRamSchemaRefTable in-memory RAM DbIO implementation
 *	for SchemaRef.
 */
public class CFBamRamSchemaRefTable
	implements ICFBamSchemaRefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamSchemaRefBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamSchemaRefBuff >();
	private Map< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaRefBuff >> dictBySchemaIdx
		= new HashMap< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaRefBuff >>();
	private Map< CFBamSchemaRefByUNameIdxKey,
			CFBamSchemaRefBuff > dictByUNameIdx
		= new HashMap< CFBamSchemaRefByUNameIdxKey,
			CFBamSchemaRefBuff >();
	private Map< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaRefBuff >> dictByRefSchemaIdx
		= new HashMap< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamSchemaRefBuff >>();

	public CFBamRamSchemaRefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		final String S_ProcName = "createSchemaRef";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaRefBySchemaIdxKey keySchemaIdx = schema.getFactorySchemaRef().newSchemaIdxKey();
		keySchemaIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySchemaIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );

		CFBamSchemaRefByUNameIdxKey keyUNameIdx = schema.getFactorySchemaRef().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		keyRefSchemaIdx.setOptionalRefSchemaTenantId( Buff.getOptionalRefSchemaTenantId() );
		keyRefSchemaIdx.setOptionalRefSchemaId( Buff.getOptionalRefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaRefUNameIdx",
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
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSchemaId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Schema",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictRefSchemaIdx;
		if( dictByRefSchemaIdx.containsKey( keyRefSchemaIdx ) ) {
			subdictRefSchemaIdx = dictByRefSchemaIdx.get( keyRefSchemaIdx );
		}
		else {
			subdictRefSchemaIdx = new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictByRefSchemaIdx.put( keyRefSchemaIdx, subdictRefSchemaIdx );
		}
		subdictRefSchemaIdx.put( pkey, Buff );

	}

	public CFBamSchemaRefBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSchemaRefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSchemaRefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSchemaRef.readAllDerived() ";
		CFBamSchemaRefBuff[] retList = new CFBamSchemaRefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSchemaRefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSchemaRefBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamSchemaRefBuff> filteredList = new ArrayList<CFBamSchemaRefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamSchemaRefBuff ) ) {
					filteredList.add( (CFBamSchemaRefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamSchemaRefBuff[0] ) );
		}
	}

	public CFBamSchemaRefBuff[] readDerivedBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readDerivedBySchemaIdx() ";
		CFBamSchemaRefBySchemaIdxKey key = schema.getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );

		CFBamSchemaRefBuff[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new CFBamSchemaRefBuff[ subdictSchemaIdx.size() ];
			Iterator< CFBamSchemaRefBuff > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new CFBamSchemaRefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaRefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readDerivedByUNameIdx() ";
		CFBamSchemaRefByUNameIdxKey key = schema.getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );

		CFBamSchemaRefBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff[] readDerivedByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readDerivedByRefSchemaIdx() ";
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );

		CFBamSchemaRefBuff[] recArray;
		if( dictByRefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictRefSchemaIdx
				= dictByRefSchemaIdx.get( key );
			recArray = new CFBamSchemaRefBuff[ subdictRefSchemaIdx.size() ];
			Iterator< CFBamSchemaRefBuff > iter = subdictRefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictRefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictByRefSchemaIdx.put( key, subdictRefSchemaIdx );
			recArray = new CFBamSchemaRefBuff[0];
		}
		return( recArray );
	}

	public CFBamSchemaRefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamSchemaRefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readBuff() ";
		CFBamSchemaRefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCRF" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readBuff() ";
		CFBamSchemaRefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCRF" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSchemaRefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readAllBuff() ";
		CFBamSchemaRefBuff buff;
		ArrayList<CFBamSchemaRefBuff> filteredList = new ArrayList<CFBamSchemaRefBuff>();
		CFBamSchemaRefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCRF" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaRefBuff[0] ) );
	}

	public CFBamSchemaRefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamSchemaRefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSchemaRefBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamSchemaRefBuff> filteredList = new ArrayList<CFBamSchemaRefBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamSchemaRefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaRefBuff[0] ) );
	}

	public CFBamSchemaRefBuff[] readBuffBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readBuffBySchemaIdx() ";
		CFBamSchemaRefBuff buff;
		ArrayList<CFBamSchemaRefBuff> filteredList = new ArrayList<CFBamSchemaRefBuff>();
		CFBamSchemaRefBuff[] buffList = readDerivedBySchemaIdx( Authorization,
			TenantId,
			SchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCRF" ) ) {
				filteredList.add( (CFBamSchemaRefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaRefBuff[0] ) );
	}

	public CFBamSchemaRefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readBuffByUNameIdx() ";
		CFBamSchemaRefBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			SchemaId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SCRF" ) ) {
			return( (CFBamSchemaRefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSchemaRefBuff[] readBuffByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		final String S_ProcName = "CFBamRamSchemaRef.readBuffByRefSchemaIdx() ";
		CFBamSchemaRefBuff buff;
		ArrayList<CFBamSchemaRefBuff> filteredList = new ArrayList<CFBamSchemaRefBuff>();
		CFBamSchemaRefBuff[] buffList = readDerivedByRefSchemaIdx( Authorization,
			RefSchemaTenantId,
			RefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCRF" ) ) {
				filteredList.add( (CFBamSchemaRefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSchemaRefBuff[0] ) );
	}

	public void updateSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaRefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSchemaRef",
				"Existing record not found",
				"SchemaRef",
				pkey );
		}
		CFBamSchemaRefBySchemaIdxKey existingKeySchemaIdx = schema.getFactorySchemaRef().newSchemaIdxKey();
		existingKeySchemaIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySchemaIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );

		CFBamSchemaRefBySchemaIdxKey newKeySchemaIdx = schema.getFactorySchemaRef().newSchemaIdxKey();
		newKeySchemaIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySchemaIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );

		CFBamSchemaRefByUNameIdxKey existingKeyUNameIdx = schema.getFactorySchemaRef().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSchemaRefByUNameIdxKey newKeyUNameIdx = schema.getFactorySchemaRef().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamSchemaRefByRefSchemaIdxKey existingKeyRefSchemaIdx = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		existingKeyRefSchemaIdx.setOptionalRefSchemaTenantId( existing.getOptionalRefSchemaTenantId() );
		existingKeyRefSchemaIdx.setOptionalRefSchemaId( existing.getOptionalRefSchemaId() );

		CFBamSchemaRefByRefSchemaIdxKey newKeyRefSchemaIdx = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		newKeyRefSchemaIdx.setOptionalRefSchemaTenantId( Buff.getOptionalRefSchemaTenantId() );
		newKeyRefSchemaIdx.setOptionalRefSchemaId( Buff.getOptionalRefSchemaId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSchemaRef",
					"SchemaRefUNameIdx",
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
						"updateSchemaRef",
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
						Buff.getRequiredSchemaId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSchemaRef",
						"Container",
						"Schema",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamSchemaRefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaIdx.get( existingKeySchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaIdx.containsKey( newKeySchemaIdx ) ) {
			subdict = dictBySchemaIdx.get( newKeySchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRefSchemaIdx.get( existingKeyRefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRefSchemaIdx.containsKey( newKeyRefSchemaIdx ) ) {
			subdict = dictByRefSchemaIdx.get( newKeyRefSchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamSchemaRefBuff >();
			dictByRefSchemaIdx.put( newKeyRefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSchemaRef( CFBamAuthorization Authorization,
		CFBamSchemaRefBuff Buff )
	{
		final String S_ProcName = "CFBamRamSchemaRefTable.deleteSchemaRef() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSchemaRefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSchemaRef",
				pkey );
		}
		CFBamSchemaRefBySchemaIdxKey keySchemaIdx = schema.getFactorySchemaRef().newSchemaIdxKey();
		keySchemaIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySchemaIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );

		CFBamSchemaRefByUNameIdxKey keyUNameIdx = schema.getFactorySchemaRef().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		keyRefSchemaIdx.setOptionalRefSchemaTenantId( existing.getOptionalRefSchemaTenantId() );
		keyRefSchemaIdx.setOptionalRefSchemaId( existing.getOptionalRefSchemaId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamScopePKey, CFBamSchemaRefBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRefSchemaIdx.get( keyRefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteSchemaRefBySchemaIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaId )
	{
		CFBamSchemaRefBySchemaIdxKey key = schema.getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaId( argSchemaId );
		deleteSchemaRefBySchemaIdx( Authorization, key );
	}

	public void deleteSchemaRefBySchemaIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefBySchemaIdxKey argKey )
	{
		CFBamSchemaRefBuff cur;
		LinkedList<CFBamSchemaRefBuff> matchSet = new LinkedList<CFBamSchemaRefBuff>();
		Iterator<CFBamSchemaRefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaRefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaRef( Authorization, cur );
		}
	}

	public void deleteSchemaRefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaId,
		String argName )
	{
		CFBamSchemaRefByUNameIdxKey key = schema.getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaId( argSchemaId );
		key.setRequiredName( argName );
		deleteSchemaRefByUNameIdx( Authorization, key );
	}

	public void deleteSchemaRefByUNameIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefByUNameIdxKey argKey )
	{
		CFBamSchemaRefBuff cur;
		LinkedList<CFBamSchemaRefBuff> matchSet = new LinkedList<CFBamSchemaRefBuff>();
		Iterator<CFBamSchemaRefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaRefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaRef( Authorization, cur );
		}
	}

	public void deleteSchemaRefByRefSchemaIdx( CFBamAuthorization Authorization,
		Long argRefSchemaTenantId,
		Long argRefSchemaId )
	{
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( argRefSchemaTenantId );
		key.setOptionalRefSchemaId( argRefSchemaId );
		deleteSchemaRefByRefSchemaIdx( Authorization, key );
	}

	public void deleteSchemaRefByRefSchemaIdx( CFBamAuthorization Authorization,
		CFBamSchemaRefByRefSchemaIdxKey argKey )
	{
		CFBamSchemaRefBuff cur;
		LinkedList<CFBamSchemaRefBuff> matchSet = new LinkedList<CFBamSchemaRefBuff>();
		Iterator<CFBamSchemaRefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaRefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaRef( Authorization, cur );
		}
	}

	public void deleteSchemaRefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteSchemaRefByIdIdx( Authorization, key );
	}

	public void deleteSchemaRefByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamSchemaRefBuff cur;
		LinkedList<CFBamSchemaRefBuff> matchSet = new LinkedList<CFBamSchemaRefBuff>();
		Iterator<CFBamSchemaRefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaRefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaRef( Authorization, cur );
		}
	}

	public void deleteSchemaRefByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaRefByTenantIdx( Authorization, key );
	}

	public void deleteSchemaRefByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamSchemaRefBuff cur;
		LinkedList<CFBamSchemaRefBuff> matchSet = new LinkedList<CFBamSchemaRefBuff>();
		Iterator<CFBamSchemaRefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSchemaRefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSchemaRef( Authorization, cur );
		}
	}

	public CFBamCursor openSchemaRefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSchemaRefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSchemaRefCursorBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaId )
	{
		CFBamCursor cursor;
		CFBamSchemaRefBySchemaIdxKey key = schema.getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );

		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			cursor = new CFBamRamSchemaRefCursor( Authorization,
				schema,
				subdictSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaRefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaRefBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSchemaRefCursorByRefSchemaIdx( CFBamAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		CFBamCursor cursor;
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );

		if( dictByRefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamSchemaRefBuff > subdictRefSchemaIdx
				= dictByRefSchemaIdx.get( key );
			cursor = new CFBamRamSchemaRefCursor( Authorization,
				schema,
				subdictRefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamSchemaRefCursor( Authorization,
				schema,
				new ArrayList< CFBamSchemaRefBuff >() );
		}
		return( cursor );
	}

	public void closeSchemaRefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSchemaRefBuff nextSchemaRefCursor( CFBamCursor Cursor ) {
		CFBamRamSchemaRefCursor cursor = (CFBamRamSchemaRefCursor)Cursor;
		CFBamSchemaRefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSchemaRefBuff prevSchemaRefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSchemaRefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaRefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSchemaRefBuff firstSchemaRefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSchemaRefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaRefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSchemaRefBuff lastSchemaRefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSchemaRefCursor" );
	}

	public CFBamSchemaRefBuff nthSchemaRefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSchemaRefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSchemaRefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
