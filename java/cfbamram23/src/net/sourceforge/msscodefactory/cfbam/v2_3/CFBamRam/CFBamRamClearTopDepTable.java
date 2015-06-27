
// Description: Java7 in-memory RAM DbIO implementation for ClearTopDep.

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
 *	CFBamRamClearTopDepTable in-memory RAM DbIO implementation
 *	for ClearTopDep.
 */
public class CFBamRamClearTopDepTable
	implements ICFBamClearTopDepTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamClearTopDepBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamClearTopDepBuff >();
	private Map< CFBamClearTopDepByContTblIdxKey,
				Map< CFBamScopePKey,
					CFBamClearTopDepBuff >> dictByContTblIdx
		= new HashMap< CFBamClearTopDepByContTblIdxKey,
				Map< CFBamScopePKey,
					CFBamClearTopDepBuff >>();
	private Map< CFBamClearTopDepByUNameIdxKey,
			CFBamClearTopDepBuff > dictByUNameIdx
		= new HashMap< CFBamClearTopDepByUNameIdxKey,
			CFBamClearTopDepBuff >();

	public CFBamRamClearTopDepTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearTopDep( CFBamAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		final String S_ProcName = "createClearTopDep";
		schema.getTableClearDep().createClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearTopDepByContTblIdxKey keyContTblIdx = schema.getFactoryClearTopDep().newContTblIdxKey();
		keyContTblIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyContTblIdx.setRequiredContTableId( Buff.getRequiredContTableId() );

		CFBamClearTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryClearTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredContTableId( Buff.getRequiredContTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearTopDepUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"ClearDep",
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
						Buff.getRequiredTenantId(),
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

		Map< CFBamScopePKey, CFBamClearTopDepBuff > subdictContTblIdx;
		if( dictByContTblIdx.containsKey( keyContTblIdx ) ) {
			subdictContTblIdx = dictByContTblIdx.get( keyContTblIdx );
		}
		else {
			subdictContTblIdx = new HashMap< CFBamScopePKey, CFBamClearTopDepBuff >();
			dictByContTblIdx.put( keyContTblIdx, subdictContTblIdx );
		}
		subdictContTblIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamClearTopDepBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamClearTopDep.readAllDerived() ";
		CFBamClearTopDepBuff[] retList = new CFBamClearTopDepBuff[ dictByPKey.values().size() ];
		Iterator< CFBamClearTopDepBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClearTopDepBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearTopDepBuff ) ) {
					filteredList.add( (CFBamClearTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
		}
	}

	public CFBamClearTopDepBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readDerivedByTableIdx() ";
		CFBamClearDepBuff buffList[] = schema.getTableClearDep().readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamClearDepBuff buff;
			ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearTopDepBuff ) ) {
					filteredList.add( (CFBamClearTopDepBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
		}
	}

	public CFBamClearTopDepBuff[] readDerivedByContTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContTableId )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readDerivedByContTblIdx() ";
		CFBamClearTopDepByContTblIdxKey key = schema.getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );

		CFBamClearTopDepBuff[] recArray;
		if( dictByContTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearTopDepBuff > subdictContTblIdx
				= dictByContTblIdx.get( key );
			recArray = new CFBamClearTopDepBuff[ subdictContTblIdx.size() ];
			Iterator< CFBamClearTopDepBuff > iter = subdictContTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamClearTopDepBuff > subdictContTblIdx
				= new HashMap< CFBamScopePKey, CFBamClearTopDepBuff >();
			dictByContTblIdx.put( key, subdictContTblIdx );
			recArray = new CFBamClearTopDepBuff[0];
		}
		return( recArray );
	}

	public CFBamClearTopDepBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContTableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readDerivedByUNameIdx() ";
		CFBamClearTopDepByUNameIdxKey key = schema.getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );

		CFBamClearTopDepBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamClearTopDepBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readBuff() ";
		CFBamClearTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLRT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readBuff() ";
		CFBamClearTopDepBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLRT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearTopDepBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readAllBuff() ";
		CFBamClearTopDepBuff buff;
		ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
		CFBamClearTopDepBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
	}

	public CFBamClearTopDepBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamClearTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClearTopDepBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamClearTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
	}

	public CFBamClearTopDepBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuffByTableIdx() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
		CFBamClearDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( (CFBamClearTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
	}

	public CFBamClearTopDepBuff[] readBuffByContTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContTableId )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readBuffByContTblIdx() ";
		CFBamClearTopDepBuff buff;
		ArrayList<CFBamClearTopDepBuff> filteredList = new ArrayList<CFBamClearTopDepBuff>();
		CFBamClearTopDepBuff[] buffList = readDerivedByContTblIdx( Authorization,
			TenantId,
			ContTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRT" ) ) {
				filteredList.add( (CFBamClearTopDepBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearTopDepBuff[0] ) );
	}

	public CFBamClearTopDepBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContTableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearTopDep.readBuffByUNameIdx() ";
		CFBamClearTopDepBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ContTableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "CLRT" ) ) {
			return( (CFBamClearTopDepBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateClearTopDep( CFBamAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		schema.getTableClearDep().updateClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateClearTopDep",
				"Existing record not found",
				"ClearTopDep",
				pkey );
		}
		CFBamClearTopDepByContTblIdxKey existingKeyContTblIdx = schema.getFactoryClearTopDep().newContTblIdxKey();
		existingKeyContTblIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyContTblIdx.setRequiredContTableId( existing.getRequiredContTableId() );

		CFBamClearTopDepByContTblIdxKey newKeyContTblIdx = schema.getFactoryClearTopDep().newContTblIdxKey();
		newKeyContTblIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyContTblIdx.setRequiredContTableId( Buff.getRequiredContTableId() );

		CFBamClearTopDepByUNameIdxKey existingKeyUNameIdx = schema.getFactoryClearTopDep().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredContTableId( existing.getRequiredContTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamClearTopDepByUNameIdxKey newKeyUNameIdx = schema.getFactoryClearTopDep().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredContTableId( Buff.getRequiredContTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateClearTopDep",
					"ClearTopDepUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearTopDep",
						"Superclass",
						"SuperClass",
						"ClearDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredContTableId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearTopDep",
						"Container",
						"ContTable",
						"Table",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamClearTopDepBuff > subdict;

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
			subdict = new HashMap< CFBamScopePKey, CFBamClearTopDepBuff >();
			dictByContTblIdx.put( newKeyContTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteClearTopDep( CFBamAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		final String S_ProcName = "CFBamRamClearTopDepTable.deleteClearTopDep() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearTopDepBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteClearTopDep",
				pkey );
		}
		CFBamClearTopDepByContTblIdxKey keyContTblIdx = schema.getFactoryClearTopDep().newContTblIdxKey();
		keyContTblIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyContTblIdx.setRequiredContTableId( existing.getRequiredContTableId() );

		CFBamClearTopDepByUNameIdxKey keyUNameIdx = schema.getFactoryClearTopDep().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredContTableId( existing.getRequiredContTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableClearSubDep1().deleteClearSubDep1ByContClearTopIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamClearTopDepBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContTblIdx.get( keyContTblIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}

	public void deleteClearTopDepByContTblIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContTableId )
	{
		CFBamClearTopDepByContTblIdxKey key = schema.getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredContTableId( argContTableId );
		deleteClearTopDepByContTblIdx( Authorization, key );
	}

	public void deleteClearTopDepByContTblIdx( CFBamAuthorization Authorization,
		CFBamClearTopDepByContTblIdxKey argKey )
	{
		CFBamClearTopDepBuff cur;
		LinkedList<CFBamClearTopDepBuff> matchSet = new LinkedList<CFBamClearTopDepBuff>();
		Iterator<CFBamClearTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearTopDep( Authorization, cur );
		}
	}

	public void deleteClearTopDepByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContTableId,
		String argName )
	{
		CFBamClearTopDepByUNameIdxKey key = schema.getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredContTableId( argContTableId );
		key.setRequiredName( argName );
		deleteClearTopDepByUNameIdx( Authorization, key );
	}

	public void deleteClearTopDepByUNameIdx( CFBamAuthorization Authorization,
		CFBamClearTopDepByUNameIdxKey argKey )
	{
		CFBamClearTopDepBuff cur;
		LinkedList<CFBamClearTopDepBuff> matchSet = new LinkedList<CFBamClearTopDepBuff>();
		Iterator<CFBamClearTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearTopDep( Authorization, cur );
		}
	}

	public void deleteClearTopDepByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteClearTopDepByTableIdx( Authorization, key );
	}

	public void deleteClearTopDepByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey )
	{
		CFBamClearTopDepBuff cur;
		LinkedList<CFBamClearTopDepBuff> matchSet = new LinkedList<CFBamClearTopDepBuff>();
		Iterator<CFBamClearTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearTopDep( Authorization, cur );
		}
	}

	public void deleteClearTopDepByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteClearTopDepByIdIdx( Authorization, key );
	}

	public void deleteClearTopDepByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamClearTopDepBuff cur;
		LinkedList<CFBamClearTopDepBuff> matchSet = new LinkedList<CFBamClearTopDepBuff>();
		Iterator<CFBamClearTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearTopDep( Authorization, cur );
		}
	}

	public void deleteClearTopDepByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearTopDepByTenantIdx( Authorization, key );
	}

	public void deleteClearTopDepByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamClearTopDepBuff cur;
		LinkedList<CFBamClearTopDepBuff> matchSet = new LinkedList<CFBamClearTopDepBuff>();
		Iterator<CFBamClearTopDepBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearTopDepBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearTopDep( Authorization, cur );
		}
	}

	public CFBamCursor openClearTopDepCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClearTopDepCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openClearTopDepCursorByContTblIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContTableId )
	{
		CFBamCursor cursor;
		CFBamClearTopDepByContTblIdxKey key = schema.getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );

		if( dictByContTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearTopDepBuff > subdictContTblIdx
				= dictByContTblIdx.get( key );
			cursor = new CFBamRamClearTopDepCursor( Authorization,
				schema,
				subdictContTblIdx.values() );
		}
		else {
			cursor = new CFBamRamClearTopDepCursor( Authorization,
				schema,
				new ArrayList< CFBamClearTopDepBuff >() );
		}
		return( cursor );
	}

	public void closeClearTopDepCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClearTopDepBuff nextClearTopDepCursor( CFBamCursor Cursor ) {
		CFBamRamClearTopDepCursor cursor = (CFBamRamClearTopDepCursor)Cursor;
		CFBamClearTopDepBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClearTopDepBuff prevClearTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClearTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearTopDepBuff firstClearTopDepCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClearTopDepBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearTopDepCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearTopDepBuff lastClearTopDepCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClearTopDepCursor" );
	}

	public CFBamClearTopDepBuff nthClearTopDepCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClearTopDepBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearTopDepCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
