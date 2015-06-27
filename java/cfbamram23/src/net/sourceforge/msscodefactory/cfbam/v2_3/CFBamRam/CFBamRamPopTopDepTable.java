
// Description: Java7 in-memory RAM DbIO implementation for PopTopDep.

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
 *	CFBamRamPopTopDepTable in-memory RAM DbIO implementation
 *	for PopTopDep.
 */
public class CFBamRamPopTopDepTable
	implements ICFBamPopTopDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamPopTopDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamPopTopDepBuff >();
	private Map< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey,
					CFBamPopTopDepBuff >> dictByContRelIdx
		= new HashMap< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey,
					CFBamPopTopDepBuff >>();
	private Map< CFBamPopTopDepByUNameIdxKey,
			CFBamPopTopDepBuff > dictByUNameIdx
		= new HashMap< CFBamPopTopDepByUNameIdxKey,
			CFBamPopTopDepBuff >();

	public CFBamRamPopTopDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopTopDep( CFBamAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		final String S_ProcName = "createPopTopDep";
		schema.getTablePopDep().createPopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopTopDepByContRelIdxKey keyContRelIdx = schema.getFactoryPopTopDep().newContRelIdxKey();
		keyContRelIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContRelIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );

		CFBamPopTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryPopTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopTopDepUNameIdx",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContRelation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamPopTopDepBuff > subdictContRelIdx;
		if( dictByContRelIdx.containsKey( keyContRelIdx ) ) {
			subdictContRelIdx = dictByContRelIdx.get( keyContRelIdx );
		}
		else {
			subdictContRelIdx = new HashMap< CFBamScopePKey, CFBamPopTopDepBuff >();
			dictByContRelIdx.put( keyContRelIdx, subdictContRelIdx );
		}
		subdictContRelIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamPopTopDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamPopTopDep.readAllDerived() ";
		CFBamPopTopDepBuff[] retList = new CFBamPopTopDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamPopTopDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamPopTopDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopTopDepBuff ) ) {
					filteredList.add( (CFBamPopTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
		}
	}

	public CFBamPopTopDepBuff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopTopDepBuff ) ) {
					filteredList.add( (CFBamPopTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
		}
	}

	public CFBamPopTopDepBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopTopDepBuff ) ) {
					filteredList.add( (CFBamPopTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
		}
	}

	public CFBamPopTopDepBuff[] readDerivedByContRelIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContRelationId )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readDerivedByContRelIdx() ";
		CFBamPopTopDepByContRelIdxKey key = schema.getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );

		CFBamPopTopDepBuff[] recArray;
		if( dictByContRelIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopTopDepBuff > subdictContRelIdx
				= dictByContRelIdx.get( key );
			recArray = new CFBamPopTopDepBuff[ subdictContRelIdx.size() ];
			Iterator< CFBamPopTopDepBuff > iter = subdictContRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopTopDepBuff > subdictContRelIdx
				= new HashMap< CFBamScopePKey, CFBamPopTopDepBuff >();
			dictByContRelIdx.put( key, subdictContRelIdx );
			recArray = new CFBamPopTopDepBuff[0];
		}
		return( recArray );
	}

	public CFBamPopTopDepBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContRelationId,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readDerivedByUNameIdx() ";
		CFBamPopTopDepByUNameIdxKey key = schema.getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );

		CFBamPopTopDepBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamPopTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readBuff() ";
		CFBamPopTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POPT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readBuff() ";
		CFBamPopTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POPT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopTopDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readAllBuff() ";
		CFBamPopTopDepBuff buff;
		ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
		CFBamPopTopDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
	}

	public CFBamPopTopDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamPopTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamPopTopDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamPopTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
	}

	public CFBamPopTopDepBuff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByRelationIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
		CFBamPopDepBuff[] buffList = readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
	}

	public CFBamPopTopDepBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByDefSchemaIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
		CFBamPopDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
	}

	public CFBamPopTopDepBuff[] readBuffByContRelIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContRelationId )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readBuffByContRelIdx() ";
		CFBamPopTopDepBuff buff;
		ArrayList<CFBamPopTopDepBuff> filteredList = new ArrayList<CFBamPopTopDepBuff>();
		CFBamPopTopDepBuff[] buffList = readDerivedByContRelIdx( Authorization,
			ContTenantId,
			ContRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPT" ) ) {
				filteredList.add( (CFBamPopTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopTopDepBuff[0] ) );
	}

	public CFBamPopTopDepBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContRelationId,
		String Name )
	{
		final String S_ProcName = "CFBamRamPopTopDep.readBuffByUNameIdx() ";
		CFBamPopTopDepBuff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContRelationId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "POPT" ) ) {
			return( (CFBamPopTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updatePopTopDep( CFBamAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		schema.getTablePopDep().updatePopDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updatePopTopDep",
				"Existing record not found",
				"PopTopDep",
				pkey );
		}
		CFBamPopTopDepByContRelIdxKey existingKeyContRelIdx = schema.getFactoryPopTopDep().newContRelIdxKey();
		existingKeyContRelIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContRelIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );

		CFBamPopTopDepByContRelIdxKey newKeyContRelIdx = schema.getFactoryPopTopDep().newContRelIdxKey();
		newKeyContRelIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContRelIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );

		CFBamPopTopDepByUNameIdxKey existingKeyUNameIdx = schema.getFactoryPopTopDep().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamPopTopDepByUNameIdxKey newKeyUNameIdx = schema.getFactoryPopTopDep().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updatePopTopDep",
					"PopTopDepUNameIdx",
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
						"updatePopTopDep",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updatePopTopDep",
						"Container",
						"ContRelation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamPopTopDepBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContRelIdx.get( existingKeyContRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContRelIdx.containsKey( newKeyContRelIdx ) ) {
			subdict = dictByContRelIdx.get( newKeyContRelIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamPopTopDepBuff >();
			dictByContRelIdx.put( newKeyContRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deletePopTopDep( CFBamAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamPopTopDepTable.deletePopTopDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deletePopTopDep",
				pkey );
		}
		CFBamPopTopDepByContRelIdxKey keyContRelIdx = schema.getFactoryPopTopDep().newContRelIdxKey();
		keyContRelIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContRelIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );

		CFBamPopTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryPopTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTablePopSubDep1().deletePopSubDep1ByContPopTopIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamPopTopDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContRelIdx.get( keyContRelIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}

	public void deletePopTopDepByContRelIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContRelationId )
	{
		CFBamPopTopDepByContRelIdxKey key = schema.getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContRelationId( argContRelationId );
		deletePopTopDepByContRelIdx( Authorization, key );
	}

	public void deletePopTopDepByContRelIdx( CFBamAuthorization Authorization,
		CFBamPopTopDepByContRelIdxKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public void deletePopTopDepByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContRelationId,
		String argName )
	{
		CFBamPopTopDepByUNameIdxKey key = schema.getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContRelationId( argContRelationId );
		key.setRequiredName( argName );
		deletePopTopDepByUNameIdx( Authorization, key );
	}

	public void deletePopTopDepByUNameIdx( CFBamAuthorization Authorization,
		CFBamPopTopDepByUNameIdxKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public void deletePopTopDepByRelationIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deletePopTopDepByRelationIdx( Authorization, key );
	}

	public void deletePopTopDepByRelationIdx( CFBamAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public void deletePopTopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopTopDepByDefSchemaIdx( Authorization, key );
	}

	public void deletePopTopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public void deletePopTopDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deletePopTopDepByIdIdx( Authorization, key );
	}

	public void deletePopTopDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public void deletePopTopDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopTopDepByTenantIdx( Authorization, key );
	}

	public void deletePopTopDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamPopTopDepBuff cur;
		LinkedList<CFBamPopTopDepBuff> matchSet = new LinkedList<CFBamPopTopDepBuff>();
		Iterator<CFBamPopTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deletePopTopDep( Authorization, cur );
		}
	}

	public CFBamCursor openPopTopDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamPopTopDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openPopTopDepCursorByContRelIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContRelationId )
	{
		CFBamCursor cursor;
		CFBamPopTopDepByContRelIdxKey key = schema.getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );

		if( dictByContRelIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopTopDepBuff > subdictContRelIdx
				= dictByContRelIdx.get( key );
			cursor = new CFBamRamPopTopDepCursor( Authorization,
				schema,
				subdictContRelIdx.values() );
		}
		else {
			cursor = new CFBamRamPopTopDepCursor( Authorization,
				schema,
				new ArrayList< CFBamPopTopDepBuff >() );
		}
		return( cursor );
	}

	public void closePopTopDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamPopTopDepBuff nextPopTopDepCursor( CFBamCursor Cursor ) {
		CFBamRamPopTopDepCursor cursor = (CFBamRamPopTopDepCursor)Cursor;
		CFBamPopTopDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamPopTopDepBuff prevPopTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamPopTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopTopDepBuff firstPopTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamPopTopDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopTopDepBuff lastPopTopDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastPopTopDepCursor" );
	}

	public CFBamPopTopDepBuff nthPopTopDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamPopTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopTopDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
