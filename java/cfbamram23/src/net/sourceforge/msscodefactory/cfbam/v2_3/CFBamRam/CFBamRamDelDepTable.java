
// Description: Java7 in-memory RAM DbIO implementation for DelDep.

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
 *	CFBamRamDelDepTable in-memory RAM DbIO implementation
 *	for DelDep.
 */
public class CFBamRamDelDepTable
	implements ICFBamDelDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamDelDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamDelDepBuff >();
	private Map< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamDelDepBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamDelDepBuff >>();
	private Map< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamDelDepBuff >> dictByTableIdx
		= new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamDelDepBuff >>();

	public CFBamRamDelDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDelDep( CFBamAuthorization Authorization,
		CFBamDelDepBuff Buff )
	{
		final String S_ProcName = "createDelDep";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryDelDep().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamDelDepByTableIdxKey keyTableIdx = schema.getFactoryDelDep().newTableIdxKey();
		keyTableIdx.setRequiredRelationTenantId( Buff.getRequiredRelationTenantId() );
		keyTableIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationTenantId(),
						Buff.getRequiredRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelDepBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamDelDepBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

	}

	public CFBamDelDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDelDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDelDep.readAllDerived() ";
		CFBamDelDepBuff[] retList = new CFBamDelDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDelDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDelDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDelDepBuff> filteredList = new ArrayList<CFBamDelDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDelDepBuff ) ) {
					filteredList.add( (CFBamDelDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDelDepBuff[0] ) );
		}
	}

	public CFBamDelDepBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerivedByDefSchemaIdx() ";
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamDelDepBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamDelDepBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamDelDepBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamDelDepBuff[0];
		}
		return( recArray );
	}

	public CFBamDelDepBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readDerivedByTableIdx() ";
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );

		CFBamDelDepBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamDelDepBuff[ subdictTableIdx.size() ];
			Iterator< CFBamDelDepBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictTableIdx
				= new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamDelDepBuff[0];
		}
		return( recArray );
	}

	public CFBamDelDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDelDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuff() ";
		CFBamDelDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DELD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuff() ";
		CFBamDelDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DELD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDelDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDelDep.readAllBuff() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelDepBuff> filteredList = new ArrayList<CFBamDelDepBuff>();
		CFBamDelDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDelDepBuff[0] ) );
	}

	public CFBamDelDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamDelDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDelDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamDelDepBuff> filteredList = new ArrayList<CFBamDelDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamDelDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelDepBuff[0] ) );
	}

	public CFBamDelDepBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByDefSchemaIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelDepBuff> filteredList = new ArrayList<CFBamDelDepBuff>();
		CFBamDelDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelDepBuff[0] ) );
	}

	public CFBamDelDepBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamDelDep.readBuffByTableIdx() ";
		CFBamDelDepBuff buff;
		ArrayList<CFBamDelDepBuff> filteredList = new ArrayList<CFBamDelDepBuff>();
		CFBamDelDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DELD" ) ) {
				filteredList.add( (CFBamDelDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDelDepBuff[0] ) );
	}

	public void updateDelDep( CFBamAuthorization Authorization,
		CFBamDelDepBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDelDep",
				"Existing record not found",
				"DelDep",
				pkey );
		}
		CFBamDelDepByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryDelDep().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamDelDepByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryDelDep().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamDelDepByTableIdxKey existingKeyTableIdx = schema.getFactoryDelDep().newTableIdxKey();
		existingKeyTableIdx.setRequiredRelationTenantId( existing.getRequiredRelationTenantId() );
		existingKeyTableIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamDelDepByTableIdxKey newKeyTableIdx = schema.getFactoryDelDep().newTableIdxKey();
		newKeyTableIdx.setRequiredRelationTenantId( Buff.getRequiredRelationTenantId() );
		newKeyTableIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelDep",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationTenantId(),
						Buff.getRequiredRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDelDep",
						"Lookup",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamDelDepBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamDelDepBuff >();
			dictByTableIdx.put( newKeyTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteDelDep( CFBamAuthorization Authorization,
		CFBamDelDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamDelDepTable.deleteDelDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDelDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDelDep",
				pkey );
		}
		CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryDelDep().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamDelDepByTableIdxKey keyTableIdx = schema.getFactoryDelDep().newTableIdxKey();
		keyTableIdx.setRequiredRelationTenantId( existing.getRequiredRelationTenantId() );
		keyTableIdx.setRequiredRelationId( existing.getRequiredRelationId() );


		// Validate reverse foreign keys

		if( schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"SuperClass",
				"DelTopDep",
				pkey );
		}

		if( schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"SuperClass",
				"DelSubDep1",
				pkey );
		}

		if( schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"SuperClass",
				"DelSubDep2",
				pkey );
		}

		if( schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"SuperClass",
				"DelSubDep3",
				pkey );
		}

		// Delete is valid

		Map< CFBamScopePKey, CFBamDelDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteDelDepByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelDepByDefSchemaIdx( Authorization, key );
	}

	public void deleteDelDepByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByDefSchemaIdx";
		CFBamDelDepBuff cur;
		LinkedList<CFBamDelDepBuff> matchSet = new LinkedList<CFBamDelDepBuff>();
		Iterator<CFBamDelDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
			}
			else if( "DELT".equals( subClassCode ) ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (CFBamDelTopDepBuff)cur );
			}
			else if( "DEL1".equals( subClassCode ) ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (CFBamDelSubDep1Buff)cur );
			}
			else if( "DEL2".equals( subClassCode ) ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (CFBamDelSubDep2Buff)cur );
			}
			else if( "DEL3".equals( subClassCode ) ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (CFBamDelSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DelDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDelDepByTableIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteDelDepByTableIdx( Authorization, key );
	}

	public void deleteDelDepByTableIdx( CFBamAuthorization Authorization,
		CFBamDelDepByTableIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByTableIdx";
		CFBamDelDepBuff cur;
		LinkedList<CFBamDelDepBuff> matchSet = new LinkedList<CFBamDelDepBuff>();
		Iterator<CFBamDelDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
			}
			else if( "DELT".equals( subClassCode ) ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (CFBamDelTopDepBuff)cur );
			}
			else if( "DEL1".equals( subClassCode ) ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (CFBamDelSubDep1Buff)cur );
			}
			else if( "DEL2".equals( subClassCode ) ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (CFBamDelSubDep2Buff)cur );
			}
			else if( "DEL3".equals( subClassCode ) ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (CFBamDelSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DelDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDelDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDelDepByIdIdx( Authorization, key );
	}

	public void deleteDelDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		final String S_ProcName = "deleteDelDepByIdIdx";
		CFBamDelDepBuff cur;
		LinkedList<CFBamDelDepBuff> matchSet = new LinkedList<CFBamDelDepBuff>();
		Iterator<CFBamDelDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
			}
			else if( "DELT".equals( subClassCode ) ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (CFBamDelTopDepBuff)cur );
			}
			else if( "DEL1".equals( subClassCode ) ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (CFBamDelSubDep1Buff)cur );
			}
			else if( "DEL2".equals( subClassCode ) ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (CFBamDelSubDep2Buff)cur );
			}
			else if( "DEL3".equals( subClassCode ) ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (CFBamDelSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DelDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDelDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelDepByTenantIdx( Authorization, key );
	}

	public void deleteDelDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByTenantIdx";
		CFBamDelDepBuff cur;
		LinkedList<CFBamDelDepBuff> matchSet = new LinkedList<CFBamDelDepBuff>();
		Iterator<CFBamDelDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDelDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
			}
			else if( "DELT".equals( subClassCode ) ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (CFBamDelTopDepBuff)cur );
			}
			else if( "DEL1".equals( subClassCode ) ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (CFBamDelSubDep1Buff)cur );
			}
			else if( "DEL2".equals( subClassCode ) ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (CFBamDelSubDep2Buff)cur );
			}
			else if( "DEL3".equals( subClassCode ) ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (CFBamDelSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DelDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openDelDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDelDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDelDepCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamDelDepByDefSchemaIdxKey key = schema.getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamDelDepCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamDelDepCursor( Authorization,
				schema,
				new ArrayList< CFBamDelDepBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openDelDepCursorByTableIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		CFBamCursor cursor;
		CFBamDelDepByTableIdxKey key = schema.getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamDelDepBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamDelDepCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamDelDepCursor( Authorization,
				schema,
				new ArrayList< CFBamDelDepBuff >() );
		}
		return( cursor );
	}

	public void closeDelDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDelDepBuff nextDelDepCursor( CFBamCursor Cursor ) {
		CFBamRamDelDepCursor cursor = (CFBamRamDelDepCursor)Cursor;
		CFBamDelDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDelDepBuff prevDelDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDelDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelDepBuff firstDelDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDelDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDelDepBuff lastDelDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDelDepCursor" );
	}

	public CFBamDelDepBuff nthDelDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDelDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDelDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
