
// Description: Java7 in-memory RAM DbIO implementation for PopSubDep3.

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
 *	CFBamRamPopSubDep3Table in-memory RAM DbIO implementation
 *	for PopSubDep3.
 */
public class CFBamRamPopSubDep3Table
	implements ICFBamPopSubDep3Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamPopSubDep3Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamPopSubDep3Buff >();
	private Map< CFBamPopSubDep3ByContPopDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep3Buff >> dictByContPopDep2Idx
		= new HashMap< CFBamPopSubDep3ByContPopDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep3Buff >>();
	private Map< CFBamPopSubDep3ByUNameIdxKey,
			CFBamPopSubDep3Buff > dictByUNameIdx
		= new HashMap< CFBamPopSubDep3ByUNameIdxKey,
			CFBamPopSubDep3Buff >();

	public CFBamRamPopSubDep3Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopSubDep3( CFBamAuthorization Authorization,
		CFBamPopSubDep3Buff Buff )
	{
		final String S_ProcName = "createPopSubDep3";
		schema.getTablePopDep().createPopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		keyContPopDep2Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContPopDep2Idx.setRequiredContPopDep2Id( Buff.getRequiredContPopDep2Id() );

		CFBamPopSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopDep2Id( Buff.getRequiredContPopDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep3UNameIdx",
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
				if( null == schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContPopSubDep3",
						"PopSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdictContPopDep2Idx;
		if( dictByContPopDep2Idx.containsKey( keyContPopDep2Idx ) ) {
			subdictContPopDep2Idx = dictByContPopDep2Idx.get( keyContPopDep2Idx );
		}
		else {
			subdictContPopDep2Idx = new HashMap< CFBamScopePKey, CFBamPopSubDep3Buff >();
			dictByContPopDep2Idx.put( keyContPopDep2Idx, subdictContPopDep2Idx );
		}
		subdictContPopDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamPopSubDep3Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamPopSubDep3.readAllDerived() ";
		CFBamPopSubDep3Buff[] retList = new CFBamPopSubDep3Buff[ dictByPKey.values().size() ];
		Iterator< CFBamPopSubDep3Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamPopSubDep3Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep3Buff ) ) {
					filteredList.add( (CFBamPopSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
		}
	}

	public CFBamPopSubDep3Buff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep3Buff ) ) {
					filteredList.add( (CFBamPopSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
		}
	}

	public CFBamPopSubDep3Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep3Buff ) ) {
					filteredList.add( (CFBamPopSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
		}
	}

	public CFBamPopSubDep3Buff[] readDerivedByContPopDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep2Id )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readDerivedByContPopDep2Idx() ";
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );

		CFBamPopSubDep3Buff[] recArray;
		if( dictByContPopDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdictContPopDep2Idx
				= dictByContPopDep2Idx.get( key );
			recArray = new CFBamPopSubDep3Buff[ subdictContPopDep2Idx.size() ];
			Iterator< CFBamPopSubDep3Buff > iter = subdictContPopDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdictContPopDep2Idx
				= new HashMap< CFBamScopePKey, CFBamPopSubDep3Buff >();
			dictByContPopDep2Idx.put( key, subdictContPopDep2Idx );
			recArray = new CFBamPopSubDep3Buff[0];
		}
		return( recArray );
	}

	public CFBamPopSubDep3Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readDerivedByUNameIdx() ";
		CFBamPopSubDep3ByUNameIdxKey key = schema.getFactoryPopSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		key.setRequiredName( Name );

		CFBamPopSubDep3Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamPopSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readBuff() ";
		CFBamPopSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readBuff() ";
		CFBamPopSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep3Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readAllBuff() ";
		CFBamPopSubDep3Buff buff;
		ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
		CFBamPopSubDep3Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP3" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
	}

	public CFBamPopSubDep3Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamPopSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamPopSubDep3Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamPopSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
	}

	public CFBamPopSubDep3Buff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByRelationIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
	}

	public CFBamPopSubDep3Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByDefSchemaIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
	}

	public CFBamPopSubDep3Buff[] readBuffByContPopDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep2Id )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readBuffByContPopDep2Idx() ";
		CFBamPopSubDep3Buff buff;
		ArrayList<CFBamPopSubDep3Buff> filteredList = new ArrayList<CFBamPopSubDep3Buff>();
		CFBamPopSubDep3Buff[] buffList = readDerivedByContPopDep2Idx( Authorization,
			ContTenantId,
			ContPopDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP3" ) ) {
				filteredList.add( (CFBamPopSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep3Buff[0] ) );
	}

	public CFBamPopSubDep3Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep3.readBuffByUNameIdx() ";
		CFBamPopSubDep3Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContPopDep2Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "POP3" ) ) {
			return( (CFBamPopSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updatePopSubDep3( CFBamAuthorization Authorization,
		CFBamPopSubDep3Buff Buff )
	{
		schema.getTablePopDep().updatePopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updatePopSubDep3",
				"Existing record not found",
				"PopSubDep3",
				pkey );
		}
		CFBamPopSubDep3ByContPopDep2IdxKey existingKeyContPopDep2Idx = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		existingKeyContPopDep2Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContPopDep2Idx.setRequiredContPopDep2Id( existing.getRequiredContPopDep2Id() );

		CFBamPopSubDep3ByContPopDep2IdxKey newKeyContPopDep2Idx = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		newKeyContPopDep2Idx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContPopDep2Idx.setRequiredContPopDep2Id( Buff.getRequiredContPopDep2Id() );

		CFBamPopSubDep3ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryPopSubDep3().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContPopDep2Id( existing.getRequiredContPopDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamPopSubDep3ByUNameIdxKey newKeyUNameIdx = schema.getFactoryPopSubDep3().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContPopDep2Id( Buff.getRequiredContPopDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updatePopSubDep3",
					"PopSubDep3UNameIdx",
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
						"updatePopSubDep3",
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
				if( null == schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updatePopSubDep3",
						"Container",
						"ContPopSubDep3",
						"PopSubDep2",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContPopDep2Idx.get( existingKeyContPopDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPopDep2Idx.containsKey( newKeyContPopDep2Idx ) ) {
			subdict = dictByContPopDep2Idx.get( newKeyContPopDep2Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamPopSubDep3Buff >();
			dictByContPopDep2Idx.put( newKeyContPopDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deletePopSubDep3( CFBamAuthorization Authorization,
		CFBamPopSubDep3Buff Buff )
	{
		final String S_ProcName = "CFBamRamPopSubDep3Table.deletePopSubDep3() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deletePopSubDep3",
				pkey );
		}
		CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		keyContPopDep2Idx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContPopDep2Idx.setRequiredContPopDep2Id( existing.getRequiredContPopDep2Id() );

		CFBamPopSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopDep2Id( existing.getRequiredContPopDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContPopDep2Idx.get( keyContPopDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}

	public void deletePopSubDep3ByContPopDep2Idx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopDep2Id )
	{
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopDep2Id( argContPopDep2Id );
		deletePopSubDep3ByContPopDep2Idx( Authorization, key );
	}

	public void deletePopSubDep3ByContPopDep2Idx( CFBamAuthorization Authorization,
		CFBamPopSubDep3ByContPopDep2IdxKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public void deletePopSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopDep2Id,
		String argName )
	{
		CFBamPopSubDep3ByUNameIdxKey key = schema.getFactoryPopSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopDep2Id( argContPopDep2Id );
		key.setRequiredName( argName );
		deletePopSubDep3ByUNameIdx( Authorization, key );
	}

	public void deletePopSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		CFBamPopSubDep3ByUNameIdxKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public void deletePopSubDep3ByRelationIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep3ByRelationIdx( Authorization, key );
	}

	public void deletePopSubDep3ByRelationIdx( CFBamAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public void deletePopSubDep3ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep3ByDefSchemaIdx( Authorization, key );
	}

	public void deletePopSubDep3ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public void deletePopSubDep3ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deletePopSubDep3ByIdIdx( Authorization, key );
	}

	public void deletePopSubDep3ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public void deletePopSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep3ByTenantIdx( Authorization, key );
	}

	public void deletePopSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamPopSubDep3Buff cur;
		LinkedList<CFBamPopSubDep3Buff> matchSet = new LinkedList<CFBamPopSubDep3Buff>();
		Iterator<CFBamPopSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep3( Authorization, cur );
		}
	}

	public CFBamCursor openPopSubDep3CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamPopSubDep3Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openPopSubDep3CursorByContPopDep2Idx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopDep2Id )
	{
		CFBamCursor cursor;
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );

		if( dictByContPopDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep3Buff > subdictContPopDep2Idx
				= dictByContPopDep2Idx.get( key );
			cursor = new CFBamRamPopSubDep3Cursor( Authorization,
				schema,
				subdictContPopDep2Idx.values() );
		}
		else {
			cursor = new CFBamRamPopSubDep3Cursor( Authorization,
				schema,
				new ArrayList< CFBamPopSubDep3Buff >() );
		}
		return( cursor );
	}

	public void closePopSubDep3Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamPopSubDep3Buff nextPopSubDep3Cursor( CFBamCursor Cursor ) {
		CFBamRamPopSubDep3Cursor cursor = (CFBamRamPopSubDep3Cursor)Cursor;
		CFBamPopSubDep3Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamPopSubDep3Buff prevPopSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamPopSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep3Buff firstPopSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamPopSubDep3Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep3Buff lastPopSubDep3Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastPopSubDep3Cursor" );
	}

	public CFBamPopSubDep3Buff nthPopSubDep3Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamPopSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
