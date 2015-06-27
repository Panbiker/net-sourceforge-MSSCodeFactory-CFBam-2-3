
// Description: Java7 in-memory RAM DbIO implementation for ServerMethod.

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
 *	CFBamRamServerMethodTable in-memory RAM DbIO implementation
 *	for ServerMethod.
 */
public class CFBamRamServerMethodTable
	implements ICFBamServerMethodTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamServerMethodBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamServerMethodBuff >();
	private Map< CFBamServerMethodByUNameIdxKey,
			CFBamServerMethodBuff > dictByUNameIdx
		= new HashMap< CFBamServerMethodByUNameIdxKey,
			CFBamServerMethodBuff >();
	private Map< CFBamServerMethodByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamServerMethodBuff >> dictByTableIdx
		= new HashMap< CFBamServerMethodByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamServerMethodBuff >>();
	private Map< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamServerMethodBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamServerMethodBuff >>();

	public CFBamRamServerMethodTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createServerMethod( CFBamAuthorization Authorization,
		CFBamServerMethodBuff Buff )
	{
		final String S_ProcName = "createServerMethod";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerMethodByUNameIdxKey keyUNameIdx = schema.getFactoryServerMethod().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamServerMethodByTableIdxKey keyTableIdx = schema.getFactoryServerMethod().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ServerMethodUNameIdx",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ForTable",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamScopePKey, CFBamServerMethodBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamServerMethodBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

	}

	public CFBamServerMethodBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerMethodBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerMethodBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamServerMethod.readAllDerived() ";
		CFBamServerMethodBuff[] retList = new CFBamServerMethodBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServerMethodBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServerMethodBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerMethodBuff> filteredList = new ArrayList<CFBamServerMethodBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerMethodBuff ) ) {
					filteredList.add( (CFBamServerMethodBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerMethodBuff[0] ) );
		}
	}

	public CFBamServerMethodBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByUNameIdx() ";
		CFBamServerMethodByUNameIdxKey key = schema.getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );

		CFBamServerMethodBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByTableIdx() ";
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		CFBamServerMethodBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamServerMethodBuff[ subdictTableIdx.size() ];
			Iterator< CFBamServerMethodBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictTableIdx
				= new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamServerMethodBuff[0];
		}
		return( recArray );
	}

	public CFBamServerMethodBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByDefSchemaIdx() ";
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamServerMethodBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamServerMethodBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamServerMethodBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamServerMethodBuff[0];
		}
		return( recArray );
	}

	public CFBamServerMethodBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamServerMethodBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuff() ";
		CFBamServerMethodBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuff() ";
		CFBamServerMethodBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerMethodBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamServerMethod.readAllBuff() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerMethodBuff> filteredList = new ArrayList<CFBamServerMethodBuff>();
		CFBamServerMethodBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServerMethodBuff[0] ) );
	}

	public CFBamServerMethodBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamServerMethodBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerMethodBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamServerMethodBuff> filteredList = new ArrayList<CFBamServerMethodBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamServerMethodBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerMethodBuff[0] ) );
	}

	public CFBamServerMethodBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByUNameIdx() ";
		CFBamServerMethodBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
			return( (CFBamServerMethodBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerMethodBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByTableIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerMethodBuff> filteredList = new ArrayList<CFBamServerMethodBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerMethodBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerMethodBuff[0] ) );
	}

	public CFBamServerMethodBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByDefSchemaIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerMethodBuff> filteredList = new ArrayList<CFBamServerMethodBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerMethodBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerMethodBuff[0] ) );
	}

	public void updateServerMethod( CFBamAuthorization Authorization,
		CFBamServerMethodBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerMethodBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateServerMethod",
				"Existing record not found",
				"ServerMethod",
				pkey );
		}
		CFBamServerMethodByUNameIdxKey existingKeyUNameIdx = schema.getFactoryServerMethod().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamServerMethodByUNameIdxKey newKeyUNameIdx = schema.getFactoryServerMethod().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamServerMethodByTableIdxKey existingKeyTableIdx = schema.getFactoryServerMethod().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamServerMethodByTableIdxKey newKeyTableIdx = schema.getFactoryServerMethod().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		CFBamServerMethodByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamServerMethodByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateServerMethod",
					"ServerMethodUNameIdx",
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
						"updateServerMethod",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateServerMethod",
						"Container",
						"ForTable",
						"Table",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamServerMethodBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
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
			subdict = new HashMap< CFBamScopePKey, CFBamServerMethodBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteServerMethod( CFBamAuthorization Authorization,
		CFBamServerMethodBuff Buff )
	{
		final String S_ProcName = "CFBamRamServerMethodTable.deleteServerMethod() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerMethodBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteServerMethod",
				pkey );
		}
		CFBamServerMethodByUNameIdxKey keyUNameIdx = schema.getFactoryServerMethod().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamServerMethodByTableIdxKey keyTableIdx = schema.getFactoryServerMethod().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );


		// Validate reverse foreign keys

		if( schema.getTableServerProc().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"SuperClass",
				"ServerProc",
				pkey );
		}

		if( schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"SuperClass",
				"ServerObjFunc",
				pkey );
		}

		if( schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"SuperClass",
				"ServerListFunc",
				pkey );
		}

		// Delete is valid

		schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamServerMethodBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteServerMethodByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamServerMethodByUNameIdxKey key = schema.getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerMethodByUNameIdx( Authorization, key );
	}

	public void deleteServerMethodByUNameIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByUNameIdx";
		CFBamServerMethodBuff cur;
		LinkedList<CFBamServerMethodBuff> matchSet = new LinkedList<CFBamServerMethodBuff>();
		Iterator<CFBamServerMethodBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerMethodBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of ServerMethod must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteServerMethodByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteServerMethodByTableIdx( Authorization, key );
	}

	public void deleteServerMethodByTableIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByTableIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByTableIdx";
		CFBamServerMethodBuff cur;
		LinkedList<CFBamServerMethodBuff> matchSet = new LinkedList<CFBamServerMethodBuff>();
		Iterator<CFBamServerMethodBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerMethodBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of ServerMethod must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteServerMethodByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerMethodByDefSchemaIdx( Authorization, key );
	}

	public void deleteServerMethodByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByDefSchemaIdx";
		CFBamServerMethodBuff cur;
		LinkedList<CFBamServerMethodBuff> matchSet = new LinkedList<CFBamServerMethodBuff>();
		Iterator<CFBamServerMethodBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerMethodBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of ServerMethod must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteServerMethodByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteServerMethodByIdIdx( Authorization, key );
	}

	public void deleteServerMethodByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByIdIdx";
		CFBamServerMethodBuff cur;
		LinkedList<CFBamServerMethodBuff> matchSet = new LinkedList<CFBamServerMethodBuff>();
		Iterator<CFBamServerMethodBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerMethodBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of ServerMethod must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteServerMethodByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerMethodByTenantIdx( Authorization, key );
	}

	public void deleteServerMethodByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByTenantIdx";
		CFBamServerMethodBuff cur;
		LinkedList<CFBamServerMethodBuff> matchSet = new LinkedList<CFBamServerMethodBuff>();
		Iterator<CFBamServerMethodBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerMethodBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of ServerMethod must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openServerMethodCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServerMethodCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openServerMethodCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		CFBamCursor cursor;
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamServerMethodCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamServerMethodCursor( Authorization,
				schema,
				new ArrayList< CFBamServerMethodBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openServerMethodCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerMethodBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamServerMethodCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamServerMethodCursor( Authorization,
				schema,
				new ArrayList< CFBamServerMethodBuff >() );
		}
		return( cursor );
	}

	public void closeServerMethodCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServerMethodBuff nextServerMethodCursor( CFBamCursor Cursor ) {
		CFBamRamServerMethodCursor cursor = (CFBamRamServerMethodCursor)Cursor;
		CFBamServerMethodBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServerMethodBuff prevServerMethodCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServerMethodBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerMethodCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerMethodBuff firstServerMethodCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServerMethodBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerMethodCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerMethodBuff lastServerMethodCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServerMethodCursor" );
	}

	public CFBamServerMethodBuff nthServerMethodCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServerMethodBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerMethodCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
