
// Description: Java7 in-memory RAM DbIO implementation for PopSubDep1.

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
 *	CFBamRamPopSubDep1Table in-memory RAM DbIO implementation
 *	for PopSubDep1.
 */
public class CFBamRamPopSubDep1Table
	implements ICFBamPopSubDep1Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamPopSubDep1Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamPopSubDep1Buff >();
	private Map< CFBamPopSubDep1ByContPopTopIdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep1Buff >> dictByContPopTopIdx
		= new HashMap< CFBamPopSubDep1ByContPopTopIdxKey,
				Map< CFBamScopePKey,
					CFBamPopSubDep1Buff >>();
	private Map< CFBamPopSubDep1ByUNameIdxKey,
			CFBamPopSubDep1Buff > dictByUNameIdx
		= new HashMap< CFBamPopSubDep1ByUNameIdxKey,
			CFBamPopSubDep1Buff >();

	public CFBamRamPopSubDep1Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopSubDep1( CFBamAuthorization Authorization,
		CFBamPopSubDep1Buff Buff )
	{
		final String S_ProcName = "createPopSubDep1";
		schema.getTablePopDep().createPopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		keyContPopTopIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContPopTopIdx.setRequiredContPopTopDepId( Buff.getRequiredContPopTopDepId() );

		CFBamPopSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopTopDepId( Buff.getRequiredContPopTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep1UNameIdx",
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
				if( null == schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContPopTopDep",
						"PopTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdictContPopTopIdx;
		if( dictByContPopTopIdx.containsKey( keyContPopTopIdx ) ) {
			subdictContPopTopIdx = dictByContPopTopIdx.get( keyContPopTopIdx );
		}
		else {
			subdictContPopTopIdx = new HashMap< CFBamScopePKey, CFBamPopSubDep1Buff >();
			dictByContPopTopIdx.put( keyContPopTopIdx, subdictContPopTopIdx );
		}
		subdictContPopTopIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamPopSubDep1Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamPopSubDep1.readAllDerived() ";
		CFBamPopSubDep1Buff[] retList = new CFBamPopSubDep1Buff[ dictByPKey.values().size() ];
		Iterator< CFBamPopSubDep1Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamPopSubDep1Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep1Buff ) ) {
					filteredList.add( (CFBamPopSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
		}
	}

	public CFBamPopSubDep1Buff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep1Buff ) ) {
					filteredList.add( (CFBamPopSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
		}
	}

	public CFBamPopSubDep1Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopSubDep1Buff ) ) {
					filteredList.add( (CFBamPopSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
		}
	}

	public CFBamPopSubDep1Buff[] readDerivedByContPopTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopTopDepId )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readDerivedByContPopTopIdx() ";
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );

		CFBamPopSubDep1Buff[] recArray;
		if( dictByContPopTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdictContPopTopIdx
				= dictByContPopTopIdx.get( key );
			recArray = new CFBamPopSubDep1Buff[ subdictContPopTopIdx.size() ];
			Iterator< CFBamPopSubDep1Buff > iter = subdictContPopTopIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdictContPopTopIdx
				= new HashMap< CFBamScopePKey, CFBamPopSubDep1Buff >();
			dictByContPopTopIdx.put( key, subdictContPopTopIdx );
			recArray = new CFBamPopSubDep1Buff[0];
		}
		return( recArray );
	}

	public CFBamPopSubDep1Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readDerivedByUNameIdx() ";
		CFBamPopSubDep1ByUNameIdxKey key = schema.getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		key.setRequiredName( Name );

		CFBamPopSubDep1Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamPopSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readBuff() ";
		CFBamPopSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readBuff() ";
		CFBamPopSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POP1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopSubDep1Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readAllBuff() ";
		CFBamPopSubDep1Buff buff;
		ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
		CFBamPopSubDep1Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP1" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
	}

	public CFBamPopSubDep1Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamPopSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamPopSubDep1Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamPopSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
	}

	public CFBamPopSubDep1Buff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByRelationIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
	}

	public CFBamPopSubDep1Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByDefSchemaIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
		CFBamPopDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
	}

	public CFBamPopSubDep1Buff[] readBuffByContPopTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopTopDepId )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readBuffByContPopTopIdx() ";
		CFBamPopSubDep1Buff buff;
		ArrayList<CFBamPopSubDep1Buff> filteredList = new ArrayList<CFBamPopSubDep1Buff>();
		CFBamPopSubDep1Buff[] buffList = readDerivedByContPopTopIdx( Authorization,
			ContTenantId,
			ContPopTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POP1" ) ) {
				filteredList.add( (CFBamPopSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopSubDep1Buff[0] ) );
	}

	public CFBamPopSubDep1Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopSubDep1.readBuffByUNameIdx() ";
		CFBamPopSubDep1Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContPopTopDepId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "POP1" ) ) {
			return( (CFBamPopSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updatePopSubDep1( CFBamAuthorization Authorization,
		CFBamPopSubDep1Buff Buff )
	{
		schema.getTablePopDep().updatePopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updatePopSubDep1",
				"Existing record not found",
				"PopSubDep1",
				pkey );
		}
		CFBamPopSubDep1ByContPopTopIdxKey existingKeyContPopTopIdx = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		existingKeyContPopTopIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContPopTopIdx.setRequiredContPopTopDepId( existing.getRequiredContPopTopDepId() );

		CFBamPopSubDep1ByContPopTopIdxKey newKeyContPopTopIdx = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		newKeyContPopTopIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContPopTopIdx.setRequiredContPopTopDepId( Buff.getRequiredContPopTopDepId() );

		CFBamPopSubDep1ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryPopSubDep1().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContPopTopDepId( existing.getRequiredContPopTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamPopSubDep1ByUNameIdxKey newKeyUNameIdx = schema.getFactoryPopSubDep1().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContPopTopDepId( Buff.getRequiredContPopTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updatePopSubDep1",
					"PopSubDep1UNameIdx",
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
						"updatePopSubDep1",
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
				if( null == schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContPopTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updatePopSubDep1",
						"Container",
						"ContPopTopDep",
						"PopTopDep",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContPopTopIdx.get( existingKeyContPopTopIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPopTopIdx.containsKey( newKeyContPopTopIdx ) ) {
			subdict = dictByContPopTopIdx.get( newKeyContPopTopIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamPopSubDep1Buff >();
			dictByContPopTopIdx.put( newKeyContPopTopIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deletePopSubDep1( CFBamAuthorization Authorization,
		CFBamPopSubDep1Buff Buff )
	{
		final String S_ProcName = "CFBamRamPopSubDep1Table.deletePopSubDep1() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deletePopSubDep1",
				pkey );
		}
		CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		keyContPopTopIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContPopTopIdx.setRequiredContPopTopDepId( existing.getRequiredContPopTopDepId() );

		CFBamPopSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryPopSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContPopTopDepId( existing.getRequiredContPopTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTablePopSubDep2().deletePopSubDep2ByContPopDep1Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContPopTopIdx.get( keyContPopTopIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}

	public void deletePopSubDep1ByContPopTopIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopTopDepId )
	{
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopTopDepId( argContPopTopDepId );
		deletePopSubDep1ByContPopTopIdx( Authorization, key );
	}

	public void deletePopSubDep1ByContPopTopIdx( CFBamAuthorization Authorization,
		CFBamPopSubDep1ByContPopTopIdxKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public void deletePopSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContPopTopDepId,
		String argName )
	{
		CFBamPopSubDep1ByUNameIdxKey key = schema.getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContPopTopDepId( argContPopTopDepId );
		key.setRequiredName( argName );
		deletePopSubDep1ByUNameIdx( Authorization, key );
	}

	public void deletePopSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		CFBamPopSubDep1ByUNameIdxKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public void deletePopSubDep1ByRelationIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep1ByRelationIdx( Authorization, key );
	}

	public void deletePopSubDep1ByRelationIdx( CFBamAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public void deletePopSubDep1ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep1ByDefSchemaIdx( Authorization, key );
	}

	public void deletePopSubDep1ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public void deletePopSubDep1ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deletePopSubDep1ByIdIdx( Authorization, key );
	}

	public void deletePopSubDep1ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public void deletePopSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep1ByTenantIdx( Authorization, key );
	}

	public void deletePopSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamPopSubDep1Buff cur;
		LinkedList<CFBamPopSubDep1Buff> matchSet = new LinkedList<CFBamPopSubDep1Buff>();
		Iterator<CFBamPopSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopSubDep1( Authorization, cur );
		}
	}

	public CFBamCursor openPopSubDep1CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamPopSubDep1Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openPopSubDep1CursorByContPopTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContPopTopDepId )
	{
		CFBamCursor cursor;
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );

		if( dictByContPopTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopSubDep1Buff > subdictContPopTopIdx
				= dictByContPopTopIdx.get( key );
			cursor = new CFBamRamPopSubDep1Cursor( Authorization,
				schema,
				subdictContPopTopIdx.values() );
		}
		else {
			cursor = new CFBamRamPopSubDep1Cursor( Authorization,
				schema,
				new ArrayList< CFBamPopSubDep1Buff >() );
		}
		return( cursor );
	}

	public void closePopSubDep1Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamPopSubDep1Buff nextPopSubDep1Cursor( CFBamCursor Cursor ) {
		CFBamRamPopSubDep1Cursor cursor = (CFBamRamPopSubDep1Cursor)Cursor;
		CFBamPopSubDep1Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamPopSubDep1Buff prevPopSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamPopSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep1Buff firstPopSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamPopSubDep1Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopSubDep1Buff lastPopSubDep1Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastPopSubDep1Cursor" );
	}

	public CFBamPopSubDep1Buff nthPopSubDep1Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamPopSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
