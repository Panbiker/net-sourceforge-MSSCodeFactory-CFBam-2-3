
// Description: Java7 in-memory RAM DbIO implementation for DelSubDep2.

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
 *	CFBamRamDelSubDep2Table in-memory RAM DbIO implementation
 *	for DelSubDep2.
 */
public class CFBamRamDelSubDep2Table
	implements ICFBamDelSubDep2Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamDelSubDep2Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamDelSubDep2Buff >();
	private Map< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep2Buff >> dictByContDelDep1Idx
		= new HashMap< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep2Buff >>();
	private Map< CFBamDelSubDep2ByUNameIdxKey,
			CFBamDelSubDep2Buff > dictByUNameIdx
		= new HashMap< CFBamDelSubDep2ByUNameIdxKey,
			CFBamDelSubDep2Buff >();

	public CFBamRamDelSubDep2Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDelSubDep2( CFBamAuthorization Authorization,
		CFBamDelSubDep2Buff Buff )
	{
		final String S_ProcName = "createDelSubDep2";
		schema.getTableDelDep().createDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		keyContDelDep1Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContDelDep1Idx.setRequiredContDelDep1Id( Buff.getRequiredContDelDep1Id() );

		CFBamDelSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelDep1Id( Buff.getRequiredContDelDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep2UNameIdx",
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
				if( null == schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContDelSubDep1",
						"DelSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdictContDelDep1Idx;
		if( dictByContDelDep1Idx.containsKey( keyContDelDep1Idx ) ) {
			subdictContDelDep1Idx = dictByContDelDep1Idx.get( keyContDelDep1Idx );
		}
		else {
			subdictContDelDep1Idx = new HashMap< CFBamScopePKey, CFBamDelSubDep2Buff >();
			dictByContDelDep1Idx.put( keyContDelDep1Idx, subdictContDelDep1Idx );
		}
		subdictContDelDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamDelSubDep2Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDelSubDep2.readAllDerived() ";
		CFBamDelSubDep2Buff[] retList = new CFBamDelSubDep2Buff[ dictByPKey.values().size() ];
		Iterator< CFBamDelSubDep2Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDelSubDep2Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep2Buff ) ) {
					filteredList.add( (CFBamDelSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
		}
	}

	public CFBamDelSubDep2Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep2Buff ) ) {
					filteredList.add( (CFBamDelSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
		}
	}

	public CFBamDelSubDep2Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep2Buff ) ) {
					filteredList.add( (CFBamDelSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
		}
	}

	public CFBamDelSubDep2Buff[] readDerivedByContDelDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep1Id )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readDerivedByContDelDep1Idx() ";
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );

		CFBamDelSubDep2Buff[] recArray;
		if( dictByContDelDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdictContDelDep1Idx
				= dictByContDelDep1Idx.get( key );
			recArray = new CFBamDelSubDep2Buff[ subdictContDelDep1Idx.size() ];
			Iterator< CFBamDelSubDep2Buff > iter = subdictContDelDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdictContDelDep1Idx
				= new HashMap< CFBamScopePKey, CFBamDelSubDep2Buff >();
			dictByContDelDep1Idx.put( key, subdictContDelDep1Idx );
			recArray = new CFBamDelSubDep2Buff[0];
		}
		return( recArray );
	}

	public CFBamDelSubDep2Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readDerivedByUNameIdx() ";
		CFBamDelSubDep2ByUNameIdxKey key = schema.getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		key.setRequiredName( Name );

		CFBamDelSubDep2Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDelSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readBuff() ";
		CFBamDelSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readBuff() ";
		CFBamDelSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep2Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readAllBuff() ";
		CFBamDelSubDep2Buff buff;
		ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
		CFBamDelSubDep2Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL2" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
	}

	public CFBamDelSubDep2Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamDelSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDelSubDep2Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamDelSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
	}

	public CFBamDelSubDep2Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByDefSchemaIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
	}

	public CFBamDelSubDep2Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByTableIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
	}

	public CFBamDelSubDep2Buff[] readBuffByContDelDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep1Id )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readBuffByContDelDep1Idx() ";
		CFBamDelSubDep2Buff buff;
		ArrayList<CFBamDelSubDep2Buff> filteredList = new ArrayList<CFBamDelSubDep2Buff>();
		CFBamDelSubDep2Buff[] buffList = readDerivedByContDelDep1Idx( Authorization,
			ContTenantId,
			ContDelDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL2" ) ) {
				filteredList.add( (CFBamDelSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep2Buff[0] ) );
	}

	public CFBamDelSubDep2Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep2.readBuffByUNameIdx() ";
		CFBamDelSubDep2Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContDelDep1Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DEL2" ) ) {
			return( (CFBamDelSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDelSubDep2( CFBamAuthorization Authorization,
		CFBamDelSubDep2Buff Buff )
	{
		schema.getTableDelDep().updateDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDelSubDep2",
				"Existing record not found",
				"DelSubDep2",
				pkey );
		}
		CFBamDelSubDep2ByContDelDep1IdxKey existingKeyContDelDep1Idx = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		existingKeyContDelDep1Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContDelDep1Idx.setRequiredContDelDep1Id( existing.getRequiredContDelDep1Id() );

		CFBamDelSubDep2ByContDelDep1IdxKey newKeyContDelDep1Idx = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		newKeyContDelDep1Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContDelDep1Idx.setRequiredContDelDep1Id( Buff.getRequiredContDelDep1Id() );

		CFBamDelSubDep2ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryDelSubDep2().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContDelDep1Id( existing.getRequiredContDelDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDelSubDep2ByUNameIdxKey newKeyUNameIdx = schema.getFactoryDelSubDep2().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContDelDep1Id( Buff.getRequiredContDelDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDelSubDep2",
					"DelSubDep2UNameIdx",
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
						"updateDelSubDep2",
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
				if( null == schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelSubDep2",
						"Container",
						"ContDelSubDep1",
						"DelSubDep1",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContDelDep1Idx.get( existingKeyContDelDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContDelDep1Idx.containsKey( newKeyContDelDep1Idx ) ) {
			subdict = dictByContDelDep1Idx.get( newKeyContDelDep1Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelSubDep2Buff >();
			dictByContDelDep1Idx.put( newKeyContDelDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteDelSubDep2( CFBamAuthorization Authorization,
		CFBamDelSubDep2Buff Buff )
	{
		final String S_ProcName = "CFBamRamDelSubDep2Table.deleteDelSubDep2() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDelSubDep2",
				pkey );
		}
		CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		keyContDelDep1Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContDelDep1Idx.setRequiredContDelDep1Id( existing.getRequiredContDelDep1Id() );

		CFBamDelSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelDep1Id( existing.getRequiredContDelDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableDelSubDep3().deleteDelSubDep3ByContDelDep2Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContDelDep1Idx.get( keyContDelDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}

	public void deleteDelSubDep2ByContDelDep1Idx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelDep1Id )
	{
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelDep1Id( argContDelDep1Id );
		deleteDelSubDep2ByContDelDep1Idx( Authorization, key );
	}

	public void deleteDelSubDep2ByContDelDep1Idx( CFBamAuthorization Authorization,
		CFBamDelSubDep2ByContDelDep1IdxKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public void deleteDelSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelDep1Id,
		String argName )
	{
		CFBamDelSubDep2ByUNameIdxKey key = schema.getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelDep1Id( argContDelDep1Id );
		key.setRequiredName( argName );
		deleteDelSubDep2ByUNameIdx( Authorization, key );
	}

	public void deleteDelSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		CFBamDelSubDep2ByUNameIdxKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public void deleteDelSubDep2ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep2ByDefSchemaIdx( Authorization, key );
	}

	public void deleteDelSubDep2ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public void deleteDelSubDep2ByTableIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep2ByTableIdx( Authorization, key );
	}

	public void deleteDelSubDep2ByTableIdx( CFBamAuthorization Authorization,
		CFBamDelDepByTableIdxKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public void deleteDelSubDep2ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDelSubDep2ByIdIdx( Authorization, key );
	}

	public void deleteDelSubDep2ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public void deleteDelSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep2ByTenantIdx( Authorization, key );
	}

	public void deleteDelSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamDelSubDep2Buff cur;
		LinkedList<CFBamDelSubDep2Buff> matchSet = new LinkedList<CFBamDelSubDep2Buff>();
		Iterator<CFBamDelSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep2( Authorization, cur );
		}
	}

	public CFBamCursor openDelSubDep2CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDelSubDep2Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDelSubDep2CursorByContDelDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelDep1Id )
	{
		CFBamCursor cursor;
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );

		if( dictByContDelDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep2Buff > subdictContDelDep1Idx
				= dictByContDelDep1Idx.get( key );
			cursor = new CFBamRamDelSubDep2Cursor( Authorization,
				schema,
				subdictContDelDep1Idx.values() );
		}
		else {
			cursor = new CFBamRamDelSubDep2Cursor( Authorization,
				schema,
				new ArrayList< CFBamDelSubDep2Buff >() );
		}
		return( cursor );
	}

	public void closeDelSubDep2Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDelSubDep2Buff nextDelSubDep2Cursor( CFBamCursor Cursor ) {
		CFBamRamDelSubDep2Cursor cursor = (CFBamRamDelSubDep2Cursor)Cursor;
		CFBamDelSubDep2Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDelSubDep2Buff prevDelSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDelSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep2Buff firstDelSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDelSubDep2Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep2Buff lastDelSubDep2Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDelSubDep2Cursor" );
	}

	public CFBamDelSubDep2Buff nthDelSubDep2Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDelSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
