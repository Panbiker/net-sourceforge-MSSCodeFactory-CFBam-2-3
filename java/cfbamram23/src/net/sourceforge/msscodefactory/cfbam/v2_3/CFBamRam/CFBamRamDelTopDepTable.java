
// Description: Java7 in-memory RAM DbIO implementation for DelTopDep.

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
 *	CFBamRamDelTopDepTable in-memory RAM DbIO implementation
 *	for DelTopDep.
 */
public class CFBamRamDelTopDepTable
	implements ICFBamDelTopDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamDelTopDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamDelTopDepBuff >();
	private Map< CFBamDelTopDepByContTblIdxKey,
				Map< CFBamScopePKey,
					CFBamDelTopDepBuff >> dictByContTblIdx
		= new HashMap< CFBamDelTopDepByContTblIdxKey,
				Map< CFBamScopePKey,
					CFBamDelTopDepBuff >>();
	private Map< CFBamDelTopDepByUNameIdxKey,
			CFBamDelTopDepBuff > dictByUNameIdx
		= new HashMap< CFBamDelTopDepByUNameIdxKey,
			CFBamDelTopDepBuff >();

	public CFBamRamDelTopDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDelTopDep( CFBamAuthorization Authorization,
		CFBamDelTopDepBuff Buff )
	{
		final String S_ProcName = "createDelTopDep";
		schema.getTableDelDep().createDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelTopDepByContTblIdxKey keyContTblIdx = schema.getFactoryDelTopDep().newContTblIdxKey();
		keyContTblIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyContTblIdx.setRequiredContTableId( Buff.getRequiredContTableId() );

		CFBamDelTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryDelTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContTableId( Buff.getRequiredContTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelTopDepUNameIdx",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContTable",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelTopDepBuff > subdictContTblIdx;
		if( dictByContTblIdx.containsKey( keyContTblIdx ) ) {
			subdictContTblIdx = dictByContTblIdx.get( keyContTblIdx );
		}
		else {
			subdictContTblIdx = new HashMap< CFBamScopePKey, CFBamDelTopDepBuff >();
			dictByContTblIdx.put( keyContTblIdx, subdictContTblIdx );
		}
		subdictContTblIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamDelTopDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDelTopDep.readAllDerived() ";
		CFBamDelTopDepBuff[] retList = new CFBamDelTopDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDelTopDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDelTopDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelTopDepBuff ) ) {
					filteredList.add( (CFBamDelTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
		}
	}

	public CFBamDelTopDepBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelTopDepBuff ) ) {
					filteredList.add( (CFBamDelTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
		}
	}

	public CFBamDelTopDepBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelTopDepBuff ) ) {
					filteredList.add( (CFBamDelTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
		}
	}

	public CFBamDelTopDepBuff[] readDerivedByContTblIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContTableId )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readDerivedByContTblIdx() ";
		CFBamDelTopDepByContTblIdxKey key = schema.getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );

		CFBamDelTopDepBuff[] recArray;
		if( dictByContTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelTopDepBuff > subdictContTblIdx
				= dictByContTblIdx.get( key );
			recArray = new CFBamDelTopDepBuff[ subdictContTblIdx.size() ];
			Iterator< CFBamDelTopDepBuff > iter = subdictContTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelTopDepBuff > subdictContTblIdx
				= new HashMap< CFBamScopePKey, CFBamDelTopDepBuff >();
			dictByContTblIdx.put( key, subdictContTblIdx );
			recArray = new CFBamDelTopDepBuff[0];
		}
		return( recArray );
	}

	public CFBamDelTopDepBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContTableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readDerivedByUNameIdx() ";
		CFBamDelTopDepByUNameIdxKey key = schema.getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );

		CFBamDelTopDepBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDelTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readBuff() ";
		CFBamDelTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DELT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readBuff() ";
		CFBamDelTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DELT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelTopDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readAllBuff() ";
		CFBamDelTopDepBuff buff;
		ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
		CFBamDelTopDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
	}

	public CFBamDelTopDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamDelTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDelTopDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamDelTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
	}

	public CFBamDelTopDepBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByDefSchemaIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
		CFBamDelDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
	}

	public CFBamDelTopDepBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByTableIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
		CFBamDelDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
	}

	public CFBamDelTopDepBuff[] readBuffByContTblIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContTableId )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readBuffByContTblIdx() ";
		CFBamDelTopDepBuff buff;
		ArrayList<CFBamDelTopDepBuff> filteredList = new ArrayList<CFBamDelTopDepBuff>();
		CFBamDelTopDepBuff[] buffList = readDerivedByContTblIdx( Authorization,
			ContTenantId,
			ContTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELT" ) ) {
				filteredList.add( (CFBamDelTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelTopDepBuff[0] ) );
	}

	public CFBamDelTopDepBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContTableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamDelTopDep.readBuffByUNameIdx() ";
		CFBamDelTopDepBuff buff = readDerivedByUNameIdx( Authorization,
			ContTenantId,
			ContTableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DELT" ) ) {
			return( (CFBamDelTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDelTopDep( CFBamAuthorization Authorization,
		CFBamDelTopDepBuff Buff )
	{
		schema.getTableDelDep().updateDelDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDelTopDep",
				"Existing record not found",
				"DelTopDep",
				pkey );
		}
		CFBamDelTopDepByContTblIdxKey existingKeyContTblIdx = schema.getFactoryDelTopDep().newContTblIdxKey();
		existingKeyContTblIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyContTblIdx.setRequiredContTableId( existing.getRequiredContTableId() );

		CFBamDelTopDepByContTblIdxKey newKeyContTblIdx = schema.getFactoryDelTopDep().newContTblIdxKey();
		newKeyContTblIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyContTblIdx.setRequiredContTableId( Buff.getRequiredContTableId() );

		CFBamDelTopDepByUNameIdxKey existingKeyUNameIdx = schema.getFactoryDelTopDep().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		existingKeyUNameIdx.setRequiredContTableId( existing.getRequiredContTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDelTopDepByUNameIdxKey newKeyUNameIdx = schema.getFactoryDelTopDep().newUNameIdxKey();
		newKeyUNameIdx.setRequiredContTenantId( Buff.getRequiredContTenantId() );
		newKeyUNameIdx.setRequiredContTableId( Buff.getRequiredContTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDelTopDep",
					"DelTopDepUNameIdx",
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
						"updateDelTopDep",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContTenantId(),
						Buff.getRequiredContTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelTopDep",
						"Container",
						"ContTable",
						"Table",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamDelTopDepBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContTblIdx.get( existingKeyContTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContTblIdx.containsKey( newKeyContTblIdx ) ) {
			subdict = dictByContTblIdx.get( newKeyContTblIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelTopDepBuff >();
			dictByContTblIdx.put( newKeyContTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteDelTopDep( CFBamAuthorization Authorization,
		CFBamDelTopDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamDelTopDepTable.deleteDelTopDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDelTopDep",
				pkey );
		}
		CFBamDelTopDepByContTblIdxKey keyContTblIdx = schema.getFactoryDelTopDep().newContTblIdxKey();
		keyContTblIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyContTblIdx.setRequiredContTableId( existing.getRequiredContTableId() );

		CFBamDelTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryDelTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredContTenantId( existing.getRequiredContTenantId() );
		keyUNameIdx.setRequiredContTableId( existing.getRequiredContTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableDelSubDep1().deleteDelSubDep1ByContDelTopIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamDelTopDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContTblIdx.get( keyContTblIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}

	public void deleteDelTopDepByContTblIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContTableId )
	{
		CFBamDelTopDepByContTblIdxKey key = schema.getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContTableId( argContTableId );
		deleteDelTopDepByContTblIdx( Authorization, key );
	}

	public void deleteDelTopDepByContTblIdx( CFBamAuthorization Authorization,
		CFBamDelTopDepByContTblIdxKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public void deleteDelTopDepByUNameIdx( CFBamAuthorization Authorization,
		long argContTenantId,
		long argContTableId,
		String argName )
	{
		CFBamDelTopDepByUNameIdxKey key = schema.getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( argContTenantId );
		key.setRequiredContTableId( argContTableId );
		key.setRequiredName( argName );
		deleteDelTopDepByUNameIdx( Authorization, key );
	}

	public void deleteDelTopDepByUNameIdx( CFBamAuthorization Authorization,
		CFBamDelTopDepByUNameIdxKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public void deleteDelTopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelTopDepByDefSchemaIdx( Authorization, key );
	}

	public void deleteDelTopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public void deleteDelTopDepByTableIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteDelTopDepByTableIdx( Authorization, key );
	}

	public void deleteDelTopDepByTableIdx( CFBamAuthorization Authorization,
		CFBamDelDepByTableIdxKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public void deleteDelTopDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDelTopDepByIdIdx( Authorization, key );
	}

	public void deleteDelTopDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public void deleteDelTopDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelTopDepByTenantIdx( Authorization, key );
	}

	public void deleteDelTopDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamDelTopDepBuff cur;
		LinkedList<CFBamDelTopDepBuff> matchSet = new LinkedList<CFBamDelTopDepBuff>();
		Iterator<CFBamDelTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDelTopDep( Authorization, cur );
		}
	}

	public CFBamCursor openDelTopDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDelTopDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDelTopDepCursorByContTblIdx( CFBamAuthorization Authorization,
		long ContTenantId,
		long ContTableId )
	{
		CFBamCursor cursor;
		CFBamDelTopDepByContTblIdxKey key = schema.getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );

		if( dictByContTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelTopDepBuff > subdictContTblIdx
				= dictByContTblIdx.get( key );
			cursor = new CFBamRamDelTopDepCursor( Authorization,
				schema,
				subdictContTblIdx.values() );
		}
		else {
			cursor = new CFBamRamDelTopDepCursor( Authorization,
				schema,
				new ArrayList< CFBamDelTopDepBuff >() );
		}
		return( cursor );
	}

	public void closeDelTopDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDelTopDepBuff nextDelTopDepCursor( CFBamCursor Cursor ) {
		CFBamRamDelTopDepCursor cursor = (CFBamRamDelTopDepCursor)Cursor;
		CFBamDelTopDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDelTopDepBuff prevDelTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDelTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelTopDepBuff firstDelTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDelTopDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelTopDepBuff lastDelTopDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDelTopDepCursor" );
	}

	public CFBamDelTopDepBuff nthDelTopDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDelTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelTopDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
