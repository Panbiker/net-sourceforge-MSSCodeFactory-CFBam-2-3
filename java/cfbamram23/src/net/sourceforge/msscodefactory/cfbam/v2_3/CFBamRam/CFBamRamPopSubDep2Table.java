
// Description: Java7 in-memory RAM DbIO implementation for PopSubDep2.

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
 *	CFBamRamPopSubDep2Table in-memory RAM DbIO implementation
 *	for PopSubDep2.
 */
public class CFBamRamPopSubDep2Table
	implements ICFBamPopSubDep2Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamPopSubDep2Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamPopSubDep2Buff >();
	private Map< CFBamPopSubDep2ByContPopDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep2Buff >> dictByContPopDep1Idx
		= new HashMap< CFBamPopSubDep2ByContPopDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep2Buff >>();
	private Map< CFBamPopSubDep2ByUNameIdxKey,
			CFBamPopSubDep2Buff > dictByUNameIdx
		= new HashMap< CFBamPopSubDep2ByUNameIdxKey,
			CFBamPopSubDep2Buff >();

	public CFBamRamPopSubDep2Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopSubDep2( CFBamAuthorization Authorization,
		CFBamPopSubDep2Buff Buff )
	{
		final String S_ProcName = "createPopSubDep2";
		schema.getTablePopDep().createPopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		keyContPopDep1Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContPopDep1Idx.setRequiredContPopDep1Id( Buff.getRequiredContPopDep1Id() );

		CFBamPopSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopDep1Id( Buff.getRequiredContPopDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep2UNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTablePopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"PopDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContPopSubDep1",
						"PopSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdictContPopDep1Idx;
		if( dictByContPopDep1Idx.containsKey( keyContPopDep1Idx ) ) {
			subdictContPopDep1Idx = dictByContPopDep1Idx.get( keyContPopDep1Idx );
		}
		else {
			subdictContPopDep1Idx = new HashMap< CFBamScopePKey, CFBamPopSubDep2Buff >();
			dictByContPopDep1Idx.put( keyContPopDep1Idx, subdictContPopDep1Idx );
		}
		subdictContPopDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamPopSubDep2Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamPopSubDep2.readAllDerived() ";
		CFBamPopSubDep2Buff[] retList = new CFBamPopSubDep2Buff[ dictByPKey.values().size() ];
		Iterator< CFBamPopSubDep2Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamPopSubDep2Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep2Buff ) ) {
					filteredList.add( (CFBamPopSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
		}
	}

	public CFBamPopSubDep2Buff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerivedByRelationIdx() ";
		CFBamPopDepBuff buffList[] = schema.getTablePopDep().readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamPopDepBuff buff;
			ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep2Buff ) ) {
					filteredList.add( (CFBamPopSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
		}
	}

	public CFBamPopSubDep2Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerivedByDefSchemaIdx() ";
		CFBamPopDepBuff buffList[] = schema.getTablePopDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamPopDepBuff buff;
			ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep2Buff ) ) {
					filteredList.add( (CFBamPopSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
		}
	}

	public CFBamPopSubDep2Buff[] readDerivedByContPopDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep1Id )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readDerivedByContPopDep1Idx() ";
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );

		CFBamPopSubDep2Buff[] recArray;
		if( dictByContPopDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdictContPopDep1Idx
				= dictByContPopDep1Idx.get( key );
			recArray = new CFBamPopSubDep2Buff[ subdictContPopDep1Idx.size() ];
			Iterator< CFBamPopSubDep2Buff > iter = subdictContPopDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdictContPopDep1Idx
				= new HashMap< CFBamScopePKey, CFBamPopSubDep2Buff >();
			dictByContPopDep1Idx.put( key, subdictContPopDep1Idx );
			recArray = new CFBamPopSubDep2Buff[0];
		}
		return( recArray );
	}

	public CFBamPopSubDep2Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readDerivedByUNameIdx() ";
		CFBamPopSubDep2ByUNameIdxKey key = schema.getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		key.setRequiredName( Name );

		CFBamPopSubDep2Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamPopSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readBuff() ";
		CFBamPopSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readBuff() ";
		CFBamPopSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep2Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readAllBuff() ";
		CFBamPopSubDep2Buff buff;
		ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
		CFBamPopSubDep2Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP2" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
	}

	public CFBamPopSubDep2Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamPopSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamPopSubDep2Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamPopSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
	}

	public CFBamPopSubDep2Buff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByRelationIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
	}

	public CFBamPopSubDep2Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByDefSchemaIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
	}

	public CFBamPopSubDep2Buff[] readBuffByContPopDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep1Id )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readBuffByContPopDep1Idx() ";
		CFBamPopSubDep2Buff buff;
		ArrayList<CFBamPopSubDep2Buff> filteredList = new ArrayList<CFBamPopSubDep2Buff>();
		CFBamPopSubDep2Buff[] buffList = readDerivedByContPopDep1Idx( Authorization,
			ContTenantId,
			ContPopDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP2" ) ) {
				filteredList.add( (CFBamPopSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep2Buff[0] ) );
	}

	public CFBamPopSubDep2Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep2.readBuffByUNameIdx() ";
		CFBamPopSubDep2Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContPopDep1Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "POP2" ) ) {
			return( (CFBamPopSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updatePopSubDep2( CFBamAuthorization Authorization,
		CFBamPopSubDep2Buff Buff )
	{
		schema.getTablePopDep().updatePopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updatePopSubDep2",
				"Existing record not found",
				"PopSubDep2",
				pkey );
		}
		CFBamPopSubDep2ByContPopDep1IdxKey existingKeyContPopDep1Idx = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		existingKeyContPopDep1Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContPopDep1Idx.setRequiredContPopDep1Id( existing.getRequiredContPopDep1Id() );

		CFBamPopSubDep2ByContPopDep1IdxKey newKeyContPopDep1Idx = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		newKeyContPopDep1Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContPopDep1Idx.setRequiredContPopDep1Id( Buff.getRequiredContPopDep1Id() );

		CFBamPopSubDep2ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryPopSubDep2().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContPopDep1Id( existing.getRequiredContPopDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamPopSubDep2ByUNameIdxKey newKeyUNameIdx = schema.getFactoryPopSubDep2().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContPopDep1Id( Buff.getRequiredContPopDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updatePopSubDep2",
					"PopSubDep2UNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTablePopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updatePopSubDep2",
						"Superclass",
						"SuperClass",
						"PopDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updatePopSubDep2",
						"Container",
						"ContPopSubDep1",
						"PopSubDep1",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContPopDep1Idx.get( existingKeyContPopDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPopDep1Idx.containsKey( newKeyContPopDep1Idx ) ) {
			subdict = dictByContPopDep1Idx.get( newKeyContPopDep1Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamPopSubDep2Buff >();
			dictByContPopDep1Idx.put( newKeyContPopDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deletePopSubDep2( CFBamAuthorization Authorization,
		CFBamPopSubDep2Buff Buff )
	{
		final String S_ProcName = "CFBamRamPopSubDep2Table.deletePopSubDep2() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deletePopSubDep2",
				pkey );
		}
		CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		keyContPopDep1Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContPopDep1Idx.setRequiredContPopDep1Id( existing.getRequiredContPopDep1Id() );

		CFBamPopSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopDep1Id( existing.getRequiredContPopDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTablePopSubDep3().deletePopSubDep3ByContPopDep2Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContPopDep1Idx.get( keyContPopDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}

	public void deletePopSubDep2ByContPopDep1Idx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopDep1Id )
	{
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopDep1Id( argContPopDep1Id );
		deletePopSubDep2ByContPopDep1Idx( Authorization, key );
	}

	public void deletePopSubDep2ByContPopDep1Idx( CFBamAuthorization Authorization,
		CFBamPopSubDep2ByContPopDep1IdxKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public void deletePopSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopDep1Id,
		String argName )
	{
		CFBamPopSubDep2ByUNameIdxKey key = schema.getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopDep1Id( argContPopDep1Id );
		key.setRequiredName( argName );
		deletePopSubDep2ByUNameIdx( Authorization, key );
	}

	public void deletePopSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		CFBamPopSubDep2ByUNameIdxKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public void deletePopSubDep2ByRelationIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep2ByRelationIdx( Authorization, key );
	}

	public void deletePopSubDep2ByRelationIdx( CFBamAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public void deletePopSubDep2ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep2ByDefSchemaIdx( Authorization, key );
	}

	public void deletePopSubDep2ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public void deletePopSubDep2ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deletePopSubDep2ByIdIdx( Authorization, key );
	}

	public void deletePopSubDep2ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public void deletePopSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep2ByTenantIdx( Authorization, key );
	}

	public void deletePopSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamPopSubDep2Buff cur;
		LinkedList<CFBamPopSubDep2Buff> matchSet = new LinkedList<CFBamPopSubDep2Buff>();
		Iterator<CFBamPopSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep2( Authorization, cur );
		}
	}

	public CFBamCursor openPopSubDep2CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamPopSubDep2Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openPopSubDep2CursorByContPopDep1Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep1Id )
	{
		CFBamCursor cursor;
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );

		if( dictByContPopDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep2Buff > subdictContPopDep1Idx
				= dictByContPopDep1Idx.get( key );
			cursor = new CFBamRamPopSubDep2Cursor( Authorization,
				schema,
				subdictContPopDep1Idx.values() );
		}
		else {
			cursor = new CFBamRamPopSubDep2Cursor( Authorization,
				schema,
				new ArrayList< CFBamPopSubDep2Buff >() );
		}
		return( cursor );
	}

	public void closePopSubDep2Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamPopSubDep2Buff nextPopSubDep2Cursor( CFBamCursor Cursor ) {
		CFBamRamPopSubDep2Cursor cursor = (CFBamRamPopSubDep2Cursor)Cursor;
		CFBamPopSubDep2Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamPopSubDep2Buff prevPopSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamPopSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep2Buff firstPopSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamPopSubDep2Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep2Buff lastPopSubDep2Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastPopSubDep2Cursor" );
	}

	public CFBamPopSubDep2Buff nthPopSubDep2Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamPopSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
