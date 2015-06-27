
// Description: Java7 in-memory RAM DbIO implementation for DelSubDep1.

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
 *	CFBamRamDelSubDep1Table in-memory RAM DbIO implementation
 *	for DelSubDep1.
 */
public class CFBamRamDelSubDep1Table
	implements ICFBamDelSubDep1Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamDelSubDep1Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamDelSubDep1Buff >();
	private Map< CFBamDelSubDep1ByContDelTopIdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep1Buff >> dictByContDelTopIdx
		= new HashMap< CFBamDelSubDep1ByContDelTopIdxKey,
				Map< CFBamScopePKey,
					CFBamDelSubDep1Buff >>();
	private Map< CFBamDelSubDep1ByUNameIdxKey,
			CFBamDelSubDep1Buff > dictByUNameIdx
		= new HashMap< CFBamDelSubDep1ByUNameIdxKey,
			CFBamDelSubDep1Buff >();

	public CFBamRamDelSubDep1Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDelSubDep1( CFBamAuthorization Authorization,
		CFBamDelSubDep1Buff Buff )
	{
		final String S_ProcName = "createDelSubDep1";
		schema.getTableDelDep().createDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		keyContDelTopIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContDelTopIdx.setRequiredContDelTopDepId( Buff.getRequiredContDelTopDepId() );

		CFBamDelSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelTopDepId( Buff.getRequiredContDelTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep1UNameIdx",
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
				if( null == schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContDelTopDep",
						"DelTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdictContDelTopIdx;
		if( dictByContDelTopIdx.containsKey( keyContDelTopIdx ) ) {
			subdictContDelTopIdx = dictByContDelTopIdx.get( keyContDelTopIdx );
		}
		else {
			subdictContDelTopIdx = new HashMap< CFBamScopePKey, CFBamDelSubDep1Buff >();
			dictByContDelTopIdx.put( keyContDelTopIdx, subdictContDelTopIdx );
		}
		subdictContDelTopIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamDelSubDep1Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDelSubDep1.readAllDerived() ";
		CFBamDelSubDep1Buff[] retList = new CFBamDelSubDep1Buff[ dictByPKey.values().size() ];
		Iterator< CFBamDelSubDep1Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDelSubDep1Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep1Buff ) ) {
					filteredList.add( (CFBamDelSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
		}
	}

	public CFBamDelSubDep1Buff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep1Buff ) ) {
					filteredList.add( (CFBamDelSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
		}
	}

	public CFBamDelSubDep1Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelSubDep1Buff ) ) {
					filteredList.add( (CFBamDelSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
		}
	}

	public CFBamDelSubDep1Buff[] readDerivedByContDelTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelTopDepId )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readDerivedByContDelTopIdx() ";
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );

		CFBamDelSubDep1Buff[] recArray;
		if( dictByContDelTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdictContDelTopIdx
				= dictByContDelTopIdx.get( key );
			recArray = new CFBamDelSubDep1Buff[ subdictContDelTopIdx.size() ];
			Iterator< CFBamDelSubDep1Buff > iter = subdictContDelTopIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdictContDelTopIdx
				= new HashMap< CFBamScopePKey, CFBamDelSubDep1Buff >();
			dictByContDelTopIdx.put( key, subdictContDelTopIdx );
			recArray = new CFBamDelSubDep1Buff[0];
		}
		return( recArray );
	}

	public CFBamDelSubDep1Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readDerivedByUNameIdx() ";
		CFBamDelSubDep1ByUNameIdxKey key = schema.getFactoryDelSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		key.setRequiredName( Name );

		CFBamDelSubDep1Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDelSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readBuff() ";
		CFBamDelSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readBuff() ";
		CFBamDelSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DEL1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelSubDep1Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readAllBuff() ";
		CFBamDelSubDep1Buff buff;
		ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
		CFBamDelSubDep1Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL1" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
	}

	public CFBamDelSubDep1Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamDelSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDelSubDep1Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamDelSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
	}

	public CFBamDelSubDep1Buff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByDefSchemaIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
	}

	public CFBamDelSubDep1Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByTableIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
		CFBamDelDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
	}

	public CFBamDelSubDep1Buff[] readBuffByContDelTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelTopDepId )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readBuffByContDelTopIdx() ";
		CFBamDelSubDep1Buff buff;
		ArrayList<CFBamDelSubDep1Buff> filteredList = new ArrayList<CFBamDelSubDep1Buff>();
		CFBamDelSubDep1Buff[] buffList = readDerivedByContDelTopIdx( Authorization,
			ContTenantId,
			ContDelTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DEL1" ) ) {
				filteredList.add( (CFBamDelSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelSubDep1Buff[0] ) );
	}

	public CFBamDelSubDep1Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelSubDep1.readBuffByUNameIdx() ";
		CFBamDelSubDep1Buff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContDelTopDepId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DEL1" ) ) {
			return( (CFBamDelSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDelSubDep1( CFBamAuthorization Authorization,
		CFBamDelSubDep1Buff Buff )
	{
		schema.getTableDelDep().updateDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDelSubDep1",
				"Existing record not found",
				"DelSubDep1",
				pkey );
		}
		CFBamDelSubDep1ByContDelTopIdxKey existingKeyContDelTopIdx = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		existingKeyContDelTopIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContDelTopIdx.setRequiredContDelTopDepId( existing.getRequiredContDelTopDepId() );

		CFBamDelSubDep1ByContDelTopIdxKey newKeyContDelTopIdx = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		newKeyContDelTopIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContDelTopIdx.setRequiredContDelTopDepId( Buff.getRequiredContDelTopDepId() );

		CFBamDelSubDep1ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryDelSubDep1().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContDelTopDepId( existing.getRequiredContDelTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDelSubDep1ByUNameIdxKey newKeyUNameIdx = schema.getFactoryDelSubDep1().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContDelTopDepId( Buff.getRequiredContDelTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDelSubDep1",
					"DelSubDep1UNameIdx",
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
						"updateDelSubDep1",
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
				if( null == schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContDelTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelSubDep1",
						"Container",
						"ContDelTopDep",
						"DelTopDep",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContDelTopIdx.get( existingKeyContDelTopIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContDelTopIdx.containsKey( newKeyContDelTopIdx ) ) {
			subdict = dictByContDelTopIdx.get( newKeyContDelTopIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelSubDep1Buff >();
			dictByContDelTopIdx.put( newKeyContDelTopIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteDelSubDep1( CFBamAuthorization Authorization,
		CFBamDelSubDep1Buff Buff )
	{
		final String S_ProcName = "CFBamRamDelSubDep1Table.deleteDelSubDep1() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDelSubDep1",
				pkey );
		}
		CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		keyContDelTopIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContDelTopIdx.setRequiredContDelTopDepId( existing.getRequiredContDelTopDepId() );

		CFBamDelSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryDelSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContDelTopDepId( existing.getRequiredContDelTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContDelTopIdx.get( keyContDelTopIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}

	public void deleteDelSubDep1ByContDelTopIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelTopDepId )
	{
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelTopDepId( argContDelTopDepId );
		deleteDelSubDep1ByContDelTopIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByContDelTopIdx( CFBamAuthorization Authorization,
		CFBamDelSubDep1ByContDelTopIdxKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public void deleteDelSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContDelTopDepId,
		String argName )
	{
		CFBamDelSubDep1ByUNameIdxKey key = schema.getFactoryDelSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContDelTopDepId( argContDelTopDepId );
		key.setRequiredName( argName );
		deleteDelSubDep1ByUNameIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		CFBamDelSubDep1ByUNameIdxKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public void deleteDelSubDep1ByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep1ByDefSchemaIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public void deleteDelSubDep1ByTableIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep1ByTableIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByTableIdx( CFBamAuthorization Authorization,
		CFBamDelDepByTableIdxKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public void deleteDelSubDep1ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDelSubDep1ByIdIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public void deleteDelSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep1ByTenantIdx( Authorization, key );
	}

	public void deleteDelSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamDelSubDep1Buff cur;
		LinkedList<CFBamDelSubDep1Buff> matchSet = new LinkedList<CFBamDelSubDep1Buff>();
		Iterator<CFBamDelSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelSubDep1( Authorization, cur );
		}
	}

	public CFBamCursor openDelSubDep1CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDelSubDep1Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDelSubDep1CursorByContDelTopIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContDelTopDepId )
	{
		CFBamCursor cursor;
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );

		if( dictByContDelTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelSubDep1Buff > subdictContDelTopIdx
				= dictByContDelTopIdx.get( key );
			cursor = new CFBamRamDelSubDep1Cursor( Authorization,
				schema,
				subdictContDelTopIdx.values() );
		}
		else {
			cursor = new CFBamRamDelSubDep1Cursor( Authorization,
				schema,
				new ArrayList< CFBamDelSubDep1Buff >() );
		}
		return( cursor );
	}

	public void closeDelSubDep1Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDelSubDep1Buff nextDelSubDep1Cursor( CFBamCursor Cursor ) {
		CFBamRamDelSubDep1Cursor cursor = (CFBamRamDelSubDep1Cursor)Cursor;
		CFBamDelSubDep1Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDelSubDep1Buff prevDelSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDelSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep1Buff firstDelSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDelSubDep1Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelSubDep1Buff lastDelSubDep1Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDelSubDep1Cursor" );
	}

	public CFBamDelSubDep1Buff nthDelSubDep1Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDelSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
