
// Description: Java7 in-memory RAM DbIO implementation for DelSubDep3.

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
 *	CFBamRamDelSubDep3Table in-memory RAM DbIO implementation
 *	for DelSubDep3.
 */
public class CFBamRamDelSubDep3Table
	implements ICFBamDelSubDep3Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamDelSubDep3Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamDelSubDep3Buff >();
	private Map< CFBamDelSubDep3ByContDelDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep3Buff >> dictByContDelDep2Idx
		= new HashMap< CFBamDelSubDep3ByContDelDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep3Buff >>();
	private Map< CFBamDelSubDep3ByUNameIdxKey,
			CFBamDelSubDep3Buff > dictByUNameIdx
		= new HashMap< CFBamDelSubDep3ByUNameIdxKey,
			CFBamDelSubDep3Buff >();

	public CFBamRamDelSubDep3Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDelSubDep3( CFBamAuthorization Authorization,
		CFBamDelSubDep3Buff Buff )
	{
		final String S_ProcName = "createDelSubDep3";
		schema.getTableDelDep().createDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		keyContDelDep2Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContDelDep2Idx.setRequiredContDelDep2Id( Buff.getRequiredContDelDep2Id() );

		CFBamDelSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelDep2Id( Buff.getRequiredContDelDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep3UNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"DelDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContDelSubDep3",
						"DelSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdictContDelDep2Idx;
		if( dictByContDelDep2Idx.containsKey( keyContDelDep2Idx ) ) {
			subdictContDelDep2Idx = dictByContDelDep2Idx.get( keyContDelDep2Idx );
		}
		else {
			subdictContDelDep2Idx = new HashMap< CFBamScopePKey, CFBamDelSubDep3Buff >();
			dictByContDelDep2Idx.put( keyContDelDep2Idx, subdictContDelDep2Idx );
		}
		subdictContDelDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamDelSubDep3Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDelSubDep3.readAllDerived() ";
		CFBamDelSubDep3Buff[] retList = new CFBamDelSubDep3Buff[ dictByPKey.values().size() ];
		Iterator< CFBamDelSubDep3Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDelSubDep3Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep3Buff ) ) {
					filteredList.add( (CFBamDelSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
		}
	}

	public CFBamDelSubDep3Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerivedByDefSchemaIdx() ";
		CFBamDelDepBuff buffList[] = schema.getTableDelDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamDelDepBuff buff;
			ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep3Buff ) ) {
					filteredList.add( (CFBamDelSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
		}
	}

	public CFBamDelSubDep3Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerivedByTableIdx() ";
		CFBamDelDepBuff buffList[] = schema.getTableDelDep().readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamDelDepBuff buff;
			ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep3Buff ) ) {
					filteredList.add( (CFBamDelSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
		}
	}

	public CFBamDelSubDep3Buff[] readDerivedByContDelDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep2Id )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readDerivedByContDelDep2Idx() ";
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );

		CFBamDelSubDep3Buff[] recArray;
		if( dictByContDelDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdictContDelDep2Idx
				= dictByContDelDep2Idx.get( key );
			recArray = new CFBamDelSubDep3Buff[ subdictContDelDep2Idx.size() ];
			Iterator< CFBamDelSubDep3Buff > iter = subdictContDelDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdictContDelDep2Idx
				= new HashMap< CFBamScopePKey, CFBamDelSubDep3Buff >();
			dictByContDelDep2Idx.put( key, subdictContDelDep2Idx );
			recArray = new CFBamDelSubDep3Buff[0];
		}
		return( recArray );
	}

	public CFBamDelSubDep3Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readDerivedByUNameIdx() ";
		CFBamDelSubDep3ByUNameIdxKey key = schema.getFactoryDelSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		key.setRequiredName( Name );

		CFBamDelSubDep3Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDelSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readBuff() ";
		CFBamDelSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readBuff() ";
		CFBamDelSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep3Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readAllBuff() ";
		CFBamDelSubDep3Buff buff;
		ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
		CFBamDelSubDep3Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL3" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
	}

	public CFBamDelSubDep3Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamDelSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDelSubDep3Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamDelSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
	}

	public CFBamDelSubDep3Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByDefSchemaIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
	}

	public CFBamDelSubDep3Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByTableIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
	}

	public CFBamDelSubDep3Buff[] readBuffByContDelDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep2Id )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readBuffByContDelDep2Idx() ";
		CFBamDelSubDep3Buff buff;
		ArrayList<CFBamDelSubDep3Buff> filteredList = new ArrayList<CFBamDelSubDep3Buff>();
		CFBamDelSubDep3Buff[] buffList = readDerivedByContDelDep2Idx( Authorization,
			ContTenantId,
			ContDelDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL3" ) ) {
				filteredList.add( (CFBamDelSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep3Buff[0] ) );
	}

	public CFBamDelSubDep3Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep3.readBuffByUNameIdx() ";
		CFBamDelSubDep3Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContDelDep2Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DEL3" ) ) {
			return( (CFBamDelSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDelSubDep3( CFBamAuthorization Authorization,
		CFBamDelSubDep3Buff Buff )
	{
		schema.getTableDelDep().updateDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDelSubDep3",
				"Existing record not found",
				"DelSubDep3",
				pkey );
		}
		CFBamDelSubDep3ByContDelDep2IdxKey existingKeyContDelDep2Idx = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		existingKeyContDelDep2Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContDelDep2Idx.setRequiredContDelDep2Id( existing.getRequiredContDelDep2Id() );

		CFBamDelSubDep3ByContDelDep2IdxKey newKeyContDelDep2Idx = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		newKeyContDelDep2Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContDelDep2Idx.setRequiredContDelDep2Id( Buff.getRequiredContDelDep2Id() );

		CFBamDelSubDep3ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryDelSubDep3().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContDelDep2Id( existing.getRequiredContDelDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDelSubDep3ByUNameIdxKey newKeyUNameIdx = schema.getFactoryDelSubDep3().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContDelDep2Id( Buff.getRequiredContDelDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDelSubDep3",
					"DelSubDep3UNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelSubDep3",
						"Superclass",
						"SuperClass",
						"DelDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelSubDep3",
						"Container",
						"ContDelSubDep3",
						"DelSubDep2",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContDelDep2Idx.get( existingKeyContDelDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContDelDep2Idx.containsKey( newKeyContDelDep2Idx ) ) {
			subdict = dictByContDelDep2Idx.get( newKeyContDelDep2Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelSubDep3Buff >();
			dictByContDelDep2Idx.put( newKeyContDelDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteDelSubDep3( CFBamAuthorization Authorization,
		CFBamDelSubDep3Buff Buff )
	{
		final String S_ProcName = "CFBamRamDelSubDep3Table.deleteDelSubDep3() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDelSubDep3",
				pkey );
		}
		CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		keyContDelDep2Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContDelDep2Idx.setRequiredContDelDep2Id( existing.getRequiredContDelDep2Id() );

		CFBamDelSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelDep2Id( existing.getRequiredContDelDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContDelDep2Idx.get( keyContDelDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}

	public void deleteDelSubDep3ByContDelDep2Idx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelDep2Id )
	{
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelDep2Id( argContDelDep2Id );
		deleteDelSubDep3ByContDelDep2Idx( Authorization, key );
	}

	public void deleteDelSubDep3ByContDelDep2Idx( CFBamAuthorization Authorization,
		CFBamDelSubDep3ByContDelDep2IdxKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public void deleteDelSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelDep2Id,
		String argName )
	{
		CFBamDelSubDep3ByUNameIdxKey key = schema.getFactoryDelSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelDep2Id( argContDelDep2Id );
		key.setRequiredName( argName );
		deleteDelSubDep3ByUNameIdx( Authorization, key );
	}

	public void deleteDelSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		CFBamDelSubDep3ByUNameIdxKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public void deleteDelSubDep3ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep3ByDefSchemaIdx( Authorization, key );
	}

	public void deleteDelSubDep3ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public void deleteDelSubDep3ByTableIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep3ByTableIdx( Authorization, key );
	}

	public void deleteDelSubDep3ByTableIdx( CFBamAuthorization Authorization,
		CFBamDelDepByTableIdxKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public void deleteDelSubDep3ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDelSubDep3ByIdIdx( Authorization, key );
	}

	public void deleteDelSubDep3ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public void deleteDelSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep3ByTenantIdx( Authorization, key );
	}

	public void deleteDelSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamDelSubDep3Buff cur;
		LinkedList<CFBamDelSubDep3Buff> matchSet = new LinkedList<CFBamDelSubDep3Buff>();
		Iterator<CFBamDelSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep3( Authorization, cur );
		}
	}

	public CFBamCursor openDelSubDep3CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDelSubDep3Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDelSubDep3CursorByContDelDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep2Id )
	{
		CFBamCursor cursor;
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );

		if( dictByContDelDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep3Buff > subdictContDelDep2Idx
				= dictByContDelDep2Idx.get( key );
			cursor = new CFBamRamDelSubDep3Cursor( Authorization,
				schema,
				subdictContDelDep2Idx.values() );
		}
		else {
			cursor = new CFBamRamDelSubDep3Cursor( Authorization,
				schema,
				new ArrayList< CFBamDelSubDep3Buff >() );
		}
		return( cursor );
	}

	public void closeDelSubDep3Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDelSubDep3Buff nextDelSubDep3Cursor( CFBamCursor Cursor ) {
		CFBamRamDelSubDep3Cursor cursor = (CFBamRamDelSubDep3Cursor)Cursor;
		CFBamDelSubDep3Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDelSubDep3Buff prevDelSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDelSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep3Buff firstDelSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDelSubDep3Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep3Buff lastDelSubDep3Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDelSubDep3Cursor" );
	}

	public CFBamDelSubDep3Buff nthDelSubDep3Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDelSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
