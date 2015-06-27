
// Description: Java7 in-memory RAM DbIO implementation for ClearDep.

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
 *	CFBamRamClearDepTable in-memory RAM DbIO implementation
 *	for ClearDep.
 */
public class CFBamRamClearDepTable
	implements ICFBamClearDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamClearDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamClearDepBuff >();
	private Map< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamClearDepBuff >> dictByTableIdx
		= new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey,
					CFBamClearDepBuff >>();

	public CFBamRamClearDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearDep( CFBamAuthorization Authorization,
		CFBamClearDepBuff Buff )
	{
		final String S_ProcName = "createClearDep";
		schema.getTableScope().createScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearDepByTableIdxKey keyTableIdx = schema.getFactoryClearDep().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
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
						Buff.getRequiredTenantId(),
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

		Map< CFBamScopePKey, CFBamClearDepBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamScopePKey, CFBamClearDepBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

	}

	public CFBamClearDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamClearDep.readAllDerived() ";
		CFBamClearDepBuff[] retList = new CFBamClearDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamClearDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClearDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearDepBuff> filteredList = new ArrayList<CFBamClearDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearDepBuff ) ) {
					filteredList.add( (CFBamClearDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearDepBuff[0] ) );
		}
	}

	public CFBamClearDepBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readDerivedByTableIdx() ";
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );

		CFBamClearDepBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearDepBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamClearDepBuff[ subdictTableIdx.size() ];
			Iterator< CFBamClearDepBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamClearDepBuff > subdictTableIdx
				= new HashMap< CFBamScopePKey, CFBamClearDepBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamClearDepBuff[0];
		}
		return( recArray );
	}

	public CFBamClearDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamClearDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuff() ";
		CFBamClearDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLRD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuff() ";
		CFBamClearDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLRD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamClearDep.readAllBuff() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearDepBuff> filteredList = new ArrayList<CFBamClearDepBuff>();
		CFBamClearDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClearDepBuff[0] ) );
	}

	public CFBamClearDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamClearDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClearDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamClearDepBuff> filteredList = new ArrayList<CFBamClearDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamClearDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearDepBuff[0] ) );
	}

	public CFBamClearDepBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuffByTableIdx() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearDepBuff> filteredList = new ArrayList<CFBamClearDepBuff>();
		CFBamClearDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( (CFBamClearDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearDepBuff[0] ) );
	}

	public void updateClearDep( CFBamAuthorization Authorization,
		CFBamClearDepBuff Buff )
	{
		schema.getTableScope().updateScope( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateClearDep",
				"Existing record not found",
				"ClearDep",
				pkey );
		}
		CFBamClearDepByTableIdxKey existingKeyTableIdx = schema.getFactoryClearDep().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		CFBamClearDepByTableIdxKey newKeyTableIdx = schema.getFactoryClearDep().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
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
						"updateClearDep",
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
						Buff.getRequiredTenantId(),
						Buff.getRequiredRelationId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearDep",
						"Lookup",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamClearDepBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamClearDepBuff >();
			dictByTableIdx.put( newKeyTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteClearDep( CFBamAuthorization Authorization,
		CFBamClearDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamClearDepTable.deleteClearDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteClearDep",
				pkey );
		}
		CFBamClearDepByTableIdxKey keyTableIdx = schema.getFactoryClearDep().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredRelationId( existing.getRequiredRelationId() );


		// Validate reverse foreign keys

		if( schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"SuperClass",
				"ClearTopDep",
				pkey );
		}

		if( schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"SuperClass",
				"ClearSubDep1",
				pkey );
		}

		if( schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"SuperClass",
				"ClearSubDep2",
				pkey );
		}

		if( schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"SuperClass",
				"ClearSubDep3",
				pkey );
		}

		// Delete is valid

		Map< CFBamScopePKey, CFBamClearDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}

	public void deleteClearDepByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteClearDepByTableIdx( Authorization, key );
	}

	public void deleteClearDepByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey )
	{
		final String S_ProcName = "deleteClearDepByTableIdx";
		CFBamClearDepBuff cur;
		LinkedList<CFBamClearDepBuff> matchSet = new LinkedList<CFBamClearDepBuff>();
		Iterator<CFBamClearDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "CLRD".equals( subClassCode ) ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
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
					"Instance of or subclass of ClearDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteClearDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteClearDepByIdIdx( Authorization, key );
	}

	public void deleteClearDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		final String S_ProcName = "deleteClearDepByIdIdx";
		CFBamClearDepBuff cur;
		LinkedList<CFBamClearDepBuff> matchSet = new LinkedList<CFBamClearDepBuff>();
		Iterator<CFBamClearDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "CLRD".equals( subClassCode ) ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
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
					"Instance of or subclass of ClearDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteClearDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearDepByTenantIdx( Authorization, key );
	}

	public void deleteClearDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteClearDepByTenantIdx";
		CFBamClearDepBuff cur;
		LinkedList<CFBamClearDepBuff> matchSet = new LinkedList<CFBamClearDepBuff>();
		Iterator<CFBamClearDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "CLRD".equals( subClassCode ) ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
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
					"Instance of or subclass of ClearDep must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openClearDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClearDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openClearDepCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		CFBamCursor cursor;
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );

		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearDepBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			cursor = new CFBamRamClearDepCursor( Authorization,
				schema,
				subdictTableIdx.values() );
		}
		else {
			cursor = new CFBamRamClearDepCursor( Authorization,
				schema,
				new ArrayList< CFBamClearDepBuff >() );
		}
		return( cursor );
	}

	public void closeClearDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClearDepBuff nextClearDepCursor( CFBamCursor Cursor ) {
		CFBamRamClearDepCursor cursor = (CFBamRamClearDepCursor)Cursor;
		CFBamClearDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClearDepBuff prevClearDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClearDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearDepBuff firstClearDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClearDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearDepBuff lastClearDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClearDepCursor" );
	}

	public CFBamClearDepBuff nthClearDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClearDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
