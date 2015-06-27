
// Description: Java7 in-memory RAM DbIO implementation for Scope.

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
 *	CFBamRamScopeTable in-memory RAM DbIO implementation
 *	for Scope.
 */
public class CFBamRamScopeTable
	implements ICFBamScopeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamScopeBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamScopeBuff >();
	private Map< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamScopeBuff >> dictByTenantIdx
		= new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey,
					CFBamScopeBuff >>();

	public CFBamRamScopeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createScope( CFBamAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		final String S_ProcName = "createScope";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextScopeIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamScopeByTenantIdxKey keyTenantIdx = schema.getFactoryScope().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamScopeBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamScopePKey, CFBamScopeBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

	}

	public CFBamScopeBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamScope.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamScopeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamScope.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamScopeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamScope.readAllDerived() ";
		CFBamScopeBuff[] retList = new CFBamScopeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamScopeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamScopeBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByTenantIdx() ";
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamScopeBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamScopeBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamScopeBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamScopeBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamScopeBuff > subdictTenantIdx
				= new HashMap< CFBamScopePKey, CFBamScopeBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamScopeBuff[0];
		}
		return( recArray );
	}

	public CFBamScopeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamScopeBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamScope.readBuff() ";
		CFBamScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCOP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamScopeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamScope.readBuff() ";
		CFBamScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCOP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamScopeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamScope.readAllBuff() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamScopeBuff> filteredList = new ArrayList<CFBamScopeBuff>();
		CFBamScopeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamScopeBuff[0] ) );
	}

	public CFBamScopeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamScopeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamScopeBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamScopeBuff> filteredList = new ArrayList<CFBamScopeBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamScopeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamScopeBuff[0] ) );
	}

	public void updateScope( CFBamAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateScope",
				"Existing record not found",
				"Scope",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateScope",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamScopeByTenantIdxKey existingKeyTenantIdx = schema.getFactoryScope().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamScopeByTenantIdxKey newKeyTenantIdx = schema.getFactoryScope().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateScope",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamScopeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamScopeBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteScope( CFBamAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		final String S_ProcName = "CFBamRamScopeTable.deleteScope() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteScope",
				pkey );
		}
		CFBamScopeByTenantIdxKey keyTenantIdx = schema.getFactoryScope().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );


		// Validate reverse foreign keys

		if( schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"SchemaDef",
				pkey );
		}

		if( schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"SchemaRef",
				pkey );
		}

		if( schema.getTableTable().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"Table",
				pkey );
		}

		if( schema.getTableDelDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"DelDep",
				pkey );
		}

		if( schema.getTableIndex().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"Index",
				pkey );
		}

		if( schema.getTableRelation().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"Relation",
				pkey );
		}

		if( schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"ServerMethod",
				pkey );
		}

		if( schema.getTablePopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"PopDep",
				pkey );
		}

		if( schema.getTableClearDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"SuperClass",
				"ClearDep",
				pkey );
		}

		// Delete is valid

		Map< CFBamScopePKey, CFBamScopeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

	}

	public void deleteScopeByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteScopeByIdIdx( Authorization, key );
	}

	public void deleteScopeByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		final String S_ProcName = "deleteScopeByIdIdx";
		CFBamScopeBuff cur;
		LinkedList<CFBamScopeBuff> matchSet = new LinkedList<CFBamScopeBuff>();
		Iterator<CFBamScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SCOP".equals( subClassCode ) ) {
				schema.getTableScope().deleteScope( Authorization, cur );
			}
			else if( "SCHM".equals( subClassCode ) ) {
				schema.getTableSchemaDef().deleteSchemaDef( Authorization, (CFBamSchemaDefBuff)cur );
			}
			else if( "SCRF".equals( subClassCode ) ) {
				schema.getTableSchemaRef().deleteSchemaRef( Authorization, (CFBamSchemaRefBuff)cur );
			}
			else if( "TBLD".equals( subClassCode ) ) {
				schema.getTableTable().deleteTable( Authorization, (CFBamTableBuff)cur );
			}
			else if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, (CFBamDelDepBuff)cur );
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
			else if( "IDXD".equals( subClassCode ) ) {
				schema.getTableIndex().deleteIndex( Authorization, (CFBamIndexBuff)cur );
			}
			else if( "RELD".equals( subClassCode ) ) {
				schema.getTableRelation().deleteRelation( Authorization, (CFBamRelationBuff)cur );
			}
			else if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, (CFBamServerMethodBuff)cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, (CFBamPopDepBuff)cur );
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
			else if( "CLRD".equals( subClassCode ) ) {
				schema.getTableClearDep().deleteClearDep( Authorization, (CFBamClearDepBuff)cur );
			}
			else if( "CLRT".equals( subClassCode ) ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (CFBamClearTopDepBuff)cur );
			}
			else if( "CLR1".equals( subClassCode ) ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (CFBamClearSubDep1Buff)cur );
			}
			else if( "CLR2".equals( subClassCode ) ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (CFBamClearSubDep2Buff)cur );
			}
			else if( "CLR3".equals( subClassCode ) ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (CFBamClearSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Scope must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteScopeByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteScopeByTenantIdx( Authorization, key );
	}

	public void deleteScopeByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteScopeByTenantIdx";
		CFBamScopeBuff cur;
		LinkedList<CFBamScopeBuff> matchSet = new LinkedList<CFBamScopeBuff>();
		Iterator<CFBamScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "SCOP".equals( subClassCode ) ) {
				schema.getTableScope().deleteScope( Authorization, cur );
			}
			else if( "SCHM".equals( subClassCode ) ) {
				schema.getTableSchemaDef().deleteSchemaDef( Authorization, (CFBamSchemaDefBuff)cur );
			}
			else if( "SCRF".equals( subClassCode ) ) {
				schema.getTableSchemaRef().deleteSchemaRef( Authorization, (CFBamSchemaRefBuff)cur );
			}
			else if( "TBLD".equals( subClassCode ) ) {
				schema.getTableTable().deleteTable( Authorization, (CFBamTableBuff)cur );
			}
			else if( "DELD".equals( subClassCode ) ) {
				schema.getTableDelDep().deleteDelDep( Authorization, (CFBamDelDepBuff)cur );
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
			else if( "IDXD".equals( subClassCode ) ) {
				schema.getTableIndex().deleteIndex( Authorization, (CFBamIndexBuff)cur );
			}
			else if( "RELD".equals( subClassCode ) ) {
				schema.getTableRelation().deleteRelation( Authorization, (CFBamRelationBuff)cur );
			}
			else if( "SRVM".equals( subClassCode ) ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, (CFBamServerMethodBuff)cur );
			}
			else if( "SRVP".equals( subClassCode ) ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (CFBamServerProcBuff)cur );
			}
			else if( "SRVO".equals( subClassCode ) ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (CFBamServerObjFuncBuff)cur );
			}
			else if( "SRVL".equals( subClassCode ) ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (CFBamServerListFuncBuff)cur );
			}
			else if( "POPD".equals( subClassCode ) ) {
				schema.getTablePopDep().deletePopDep( Authorization, (CFBamPopDepBuff)cur );
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
			else if( "CLRD".equals( subClassCode ) ) {
				schema.getTableClearDep().deleteClearDep( Authorization, (CFBamClearDepBuff)cur );
			}
			else if( "CLRT".equals( subClassCode ) ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (CFBamClearTopDepBuff)cur );
			}
			else if( "CLR1".equals( subClassCode ) ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (CFBamClearSubDep1Buff)cur );
			}
			else if( "CLR2".equals( subClassCode ) ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (CFBamClearSubDep2Buff)cur );
			}
			else if( "CLR3".equals( subClassCode ) ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (CFBamClearSubDep3Buff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Scope must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openScopeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamScopeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openScopeCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamScopeBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamScopeCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamScopeCursor( Authorization,
				schema,
				new ArrayList< CFBamScopeBuff >() );
		}
		return( cursor );
	}

	public void closeScopeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamScopeBuff nextScopeCursor( CFBamCursor Cursor ) {
		CFBamRamScopeCursor cursor = (CFBamRamScopeCursor)Cursor;
		CFBamScopeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamScopeBuff prevScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamScopeBuff firstScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamScopeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamScopeBuff lastScopeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastScopeCursor" );
	}

	public CFBamScopeBuff nthScopeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextScopeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
