
// Description: Java7 in-memory RAM DbIO implementation for PopDep.

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
 *	CFBamRamPopDepTable in-memory RAM DbIO implementation
 *	for PopDep.
 */
public class CFBamRamPopDepTable
	implements ICFBamPopDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamPopDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamPopDepBuff >();
	private Map< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey,
					CFBamPopDepBuff >> dictByRelationIdx
		= new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey,
					CFBamPopDepBuff >>();
	private Map< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamPopDepBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey,
					CFBamPopDepBuff >>();

	public CFBamRamPopDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopDep( CFBamAuthorization Authorization,
		CFBamPopDepBuff Buff )
	{
		final String S_ProcName = "createPopDep";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopDepByRelationIdxKey keyRelationIdx = schema.getFactoryPopDep().newRelationIdxKey();
		keyRelationIdx.setRequiredRelationTenantId( Buff.getRequiredRelationTenantId() );
		keyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryPopDep().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

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

		Map< CFBamScopePKey, CFBamPopDepBuff > subdictRelationIdx;
		if( dictByRelationIdx.containsKey( keyRelationIdx ) ) {
			subdictRelationIdx = dictByRelationIdx.get( keyRelationIdx );
		}
		else {
			subdictRelationIdx = new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByRelationIdx.put( keyRelationIdx, subdictRelationIdx );
		}
		subdictRelationIdx.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamPopDepBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

	}

	public CFBamPopDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamPopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamPopDep.readAllDerived() ";
		CFBamPopDepBuff[] retList = new CFBamPopDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamPopDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamPopDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamPopDepBuff> filteredList = new ArrayList<CFBamPopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamPopDepBuff ) ) {
					filteredList.add( (CFBamPopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamPopDepBuff[0] ) );
		}
	}

	public CFBamPopDepBuff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerivedByRelationIdx() ";
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );

		CFBamPopDepBuff[] recArray;
		if( dictByRelationIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictRelationIdx
				= dictByRelationIdx.get( key );
			recArray = new CFBamPopDepBuff[ subdictRelationIdx.size() ];
			Iterator< CFBamPopDepBuff > iter = subdictRelationIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictRelationIdx
				= new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByRelationIdx.put( key, subdictRelationIdx );
			recArray = new CFBamPopDepBuff[0];
		}
		return( recArray );
	}

	public CFBamPopDepBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readDerivedByDefSchemaIdx() ";
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamPopDepBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamPopDepBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamPopDepBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictDefSchemaIdx
				= new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamPopDepBuff[0];
		}
		return( recArray );
	}

	public CFBamPopDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamPopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuff() ";
		CFBamPopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POPD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuff() ";
		CFBamPopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "POPD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamPopDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamPopDep.readAllBuff() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopDepBuff> filteredList = new ArrayList<CFBamPopDepBuff>();
		CFBamPopDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamPopDepBuff[0] ) );
	}

	public CFBamPopDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamPopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamPopDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamPopDepBuff> filteredList = new ArrayList<CFBamPopDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamPopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopDepBuff[0] ) );
	}

	public CFBamPopDepBuff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByRelationIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopDepBuff> filteredList = new ArrayList<CFBamPopDepBuff>();
		CFBamPopDepBuff[] buffList = readDerivedByRelationIdx( Authorization,
			RelationTenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopDepBuff[0] ) );
	}

	public CFBamPopDepBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamPopDep.readBuffByDefSchemaIdx() ";
		CFBamPopDepBuff buff;
		ArrayList<CFBamPopDepBuff> filteredList = new ArrayList<CFBamPopDepBuff>();
		CFBamPopDepBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "POPD" ) ) {
				filteredList.add( (CFBamPopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamPopDepBuff[0] ) );
	}

	public void updatePopDep( CFBamAuthorization Authorization,
		CFBamPopDepBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updatePopDep",
				"Existing record not found",
				"PopDep",
				pkey );
		}
		CFBamPopDepByRelationIdxKey existingKeyRelationIdx = schema.getFactoryPopDep().newRelationIdxKey();
		existingKeyRelationIdx.setRequiredRelationTenantId( existing.getRequiredRelationTenantId() );
		existingKeyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamPopDepByRelationIdxKey newKeyRelationIdx = schema.getFactoryPopDep().newRelationIdxKey();
		newKeyRelationIdx.setRequiredRelationTenantId( Buff.getRequiredRelationTenantId() );
		newKeyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		CFBamPopDepByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryPopDep().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamPopDepByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryPopDep().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

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
						"updatePopDep",
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
						"updatePopDep",
						"Lookup",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamPopDepBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByRelationIdx.get( existingKeyRelationIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelationIdx.containsKey( newKeyRelationIdx ) ) {
			subdict = dictByRelationIdx.get( newKeyRelationIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByRelationIdx.put( newKeyRelationIdx, subdict );
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
			subdict = new HashMap< CFBamScopePKey, CFBamPopDepBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deletePopDep( CFBamAuthorization Authorization,
		CFBamPopDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamPopDepTable.deletePopDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamPopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deletePopDep",
				pkey );
		}
		CFBamPopDepByRelationIdxKey keyRelationIdx = schema.getFactoryPopDep().newRelationIdxKey();
		keyRelationIdx.setRequiredRelationTenantId( existing.getRequiredRelationTenantId() );
		keyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryPopDep().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );


		// Validate reverse foreign keys

		if( schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deletePopDep",
				"Superclass",
				"SuperClass",
				"PopTopDep",
				pkey );
		}

		if( schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deletePopDep",
				"Superclass",
				"SuperClass",
				"PopSubDep1",
				pkey );
		}

		if( schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deletePopDep",
				"Superclass",
				"SuperClass",
				"PopSubDep2",
				pkey );
		}

		if( schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deletePopDep",
				"Superclass",
				"SuperClass",
				"PopSubDep3",
				pkey );
		}

		// Delete is valid

		Map< CFBamScopePKey, CFBamPopDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRelationIdx.get( keyRelationIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deletePopDepByRelationIdx( CFBamAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( argRelationTenantId );
		key.setRequiredRelationId( argRelationId );
		deletePopDepByRelationIdx( Authorization, key );
	}

	public void deletePopDepByRelationIdx( CFBamAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		final String S_ProcName = "deletePopDepByRelationIdx";
		CFBamPopDepBuff cur;
		LinkedList<CFBamPopDepBuff> matchSet = new LinkedList<CFBamPopDepBuff>();
		Iterator<CFBamPopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, cur );
			}
			else if( "POPT".equals( subClassCode ) ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (CFBamPopTopDepBuff)cur );
			}
			else if( "POP1".equals( subClassCode ) ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (CFBamPopSubDep1Buff)cur );
			}
			else if( "POP2".equals( subClassCode ) ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (CFBamPopSubDep2Buff)cur );
			}
			else if( "POP3".equals( subClassCode ) ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (CFBamPopSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of PopDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deletePopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopDepByDefSchemaIdx( Authorization, key );
	}

	public void deletePopDepByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deletePopDepByDefSchemaIdx";
		CFBamPopDepBuff cur;
		LinkedList<CFBamPopDepBuff> matchSet = new LinkedList<CFBamPopDepBuff>();
		Iterator<CFBamPopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, cur );
			}
			else if( "POPT".equals( subClassCode ) ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (CFBamPopTopDepBuff)cur );
			}
			else if( "POP1".equals( subClassCode ) ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (CFBamPopSubDep1Buff)cur );
			}
			else if( "POP2".equals( subClassCode ) ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (CFBamPopSubDep2Buff)cur );
			}
			else if( "POP3".equals( subClassCode ) ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (CFBamPopSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of PopDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deletePopDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deletePopDepByIdIdx( Authorization, key );
	}

	public void deletePopDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		final String S_ProcName = "deletePopDepByIdIdx";
		CFBamPopDepBuff cur;
		LinkedList<CFBamPopDepBuff> matchSet = new LinkedList<CFBamPopDepBuff>();
		Iterator<CFBamPopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, cur );
			}
			else if( "POPT".equals( subClassCode ) ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (CFBamPopTopDepBuff)cur );
			}
			else if( "POP1".equals( subClassCode ) ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (CFBamPopSubDep1Buff)cur );
			}
			else if( "POP2".equals( subClassCode ) ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (CFBamPopSubDep2Buff)cur );
			}
			else if( "POP3".equals( subClassCode ) ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (CFBamPopSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of PopDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deletePopDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopDepByTenantIdx( Authorization, key );
	}

	public void deletePopDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deletePopDepByTenantIdx";
		CFBamPopDepBuff cur;
		LinkedList<CFBamPopDepBuff> matchSet = new LinkedList<CFBamPopDepBuff>();
		Iterator<CFBamPopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamPopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, cur );
			}
			else if( "POPT".equals( subClassCode ) ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (CFBamPopTopDepBuff)cur );
			}
			else if( "POP1".equals( subClassCode ) ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (CFBamPopSubDep1Buff)cur );
			}
			else if( "POP2".equals( subClassCode ) ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (CFBamPopSubDep2Buff)cur );
			}
			else if( "POP3".equals( subClassCode ) ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (CFBamPopSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of PopDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openPopDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamPopDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openPopDepCursorByRelationIdx( CFBamAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		CFBamCursor cursor;
		CFBamPopDepByRelationIdxKey key = schema.getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );

		if( dictByRelationIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictRelationIdx
				= dictByRelationIdx.get( key );
			cursor = new CFBamRamPopDepCursor( Authorization,
				schema,
				subdictRelationIdx.values() );
		}
		else {
			cursor = new CFBamRamPopDepCursor( Authorization,
				schema,
				new ArrayList< CFBamPopDepBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openPopDepCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamPopDepByDefSchemaIdxKey key = schema.getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamPopDepBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamPopDepCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamPopDepCursor( Authorization,
				schema,
				new ArrayList< CFBamPopDepBuff >() );
		}
		return( cursor );
	}

	public void closePopDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamPopDepBuff nextPopDepCursor( CFBamCursor Cursor ) {
		CFBamRamPopDepCursor cursor = (CFBamRamPopDepCursor)Cursor;
		CFBamPopDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamPopDepBuff prevPopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamPopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopDepBuff firstPopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamPopDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamPopDepBuff lastPopDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastPopDepCursor" );
	}

	public CFBamPopDepBuff nthPopDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamPopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextPopDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
