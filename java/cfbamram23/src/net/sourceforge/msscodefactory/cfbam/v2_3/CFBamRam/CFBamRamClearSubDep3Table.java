
// Description: Java7 in-memory RAM DbIO implementation for ClearSubDep3.

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
 *	CFBamRamClearSubDep3Table in-memory RAM DbIO implementation
 *	for ClearSubDep3.
 */
public class CFBamRamClearSubDep3Table
	implements ICFBamClearSubDep3Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamClearSubDep3Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamClearSubDep3Buff >();
	private Map< CFBamClearSubDep3ByContClearDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep3Buff >> dictByContClearDep2Idx
		= new HashMap< CFBamClearSubDep3ByContClearDep2IdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep3Buff >>();
	private Map< CFBamClearSubDep3ByUNameIdxKey,
			CFBamClearSubDep3Buff > dictByUNameIdx
		= new HashMap< CFBamClearSubDep3ByUNameIdxKey,
			CFBamClearSubDep3Buff >();

	public CFBamRamClearSubDep3Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearSubDep3( CFBamAuthorization Authorization,
		CFBamClearSubDep3Buff Buff )
	{
		final String S_ProcName = "createClearSubDep3";
		schema.getTableClearDep().createClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		keyContClearDep2Idx.setRequiredContClearDep2TenantId( Buff.getRequiredContClearDep2TenantId() );
		keyContClearDep2Idx.setRequiredContClearDep2Id( Buff.getRequiredContClearDep2Id() );

		CFBamClearSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearDep2Id( Buff.getRequiredContClearDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep3UNameIdx",
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
				if( null == schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearDep2TenantId(),
						Buff.getRequiredContClearDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContClearSubDep3",
						"ClearSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdictContClearDep2Idx;
		if( dictByContClearDep2Idx.containsKey( keyContClearDep2Idx ) ) {
			subdictContClearDep2Idx = dictByContClearDep2Idx.get( keyContClearDep2Idx );
		}
		else {
			subdictContClearDep2Idx = new HashMap< CFBamScopePKey, CFBamClearSubDep3Buff >();
			dictByContClearDep2Idx.put( keyContClearDep2Idx, subdictContClearDep2Idx );
		}
		subdictContClearDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamClearSubDep3Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamClearSubDep3.readAllDerived() ";
		CFBamClearSubDep3Buff[] retList = new CFBamClearSubDep3Buff[ dictByPKey.values().size() ];
		Iterator< CFBamClearSubDep3Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClearSubDep3Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep3Buff ) ) {
					filteredList.add( (CFBamClearSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
		}
	}

	public CFBamClearSubDep3Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep3Buff ) ) {
					filteredList.add( (CFBamClearSubDep3Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
		}
	}

	public CFBamClearSubDep3Buff[] readDerivedByContClearDep2Idx( CFBamAuthorization Authorization,
		long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readDerivedByContClearDep2Idx() ";
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( ContClearDep2TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );

		CFBamClearSubDep3Buff[] recArray;
		if( dictByContClearDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdictContClearDep2Idx
				= dictByContClearDep2Idx.get( key );
			recArray = new CFBamClearSubDep3Buff[ subdictContClearDep2Idx.size() ];
			Iterator< CFBamClearSubDep3Buff > iter = subdictContClearDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdictContClearDep2Idx
				= new HashMap< CFBamScopePKey, CFBamClearSubDep3Buff >();
			dictByContClearDep2Idx.put( key, subdictContClearDep2Idx );
			recArray = new CFBamClearSubDep3Buff[0];
		}
		return( recArray );
	}

	public CFBamClearSubDep3Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readDerivedByUNameIdx() ";
		CFBamClearSubDep3ByUNameIdxKey key = schema.getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		key.setRequiredName( Name );

		CFBamClearSubDep3Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamClearSubDep3Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readBuff() ";
		CFBamClearSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readBuff() ";
		CFBamClearSubDep3Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR3" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep3Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readAllBuff() ";
		CFBamClearSubDep3Buff buff;
		ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
		CFBamClearSubDep3Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR3" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
	}

	public CFBamClearSubDep3Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamClearSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClearSubDep3Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamClearSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
	}

	public CFBamClearSubDep3Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuffByTableIdx() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
		CFBamClearDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( (CFBamClearSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
	}

	public CFBamClearSubDep3Buff[] readBuffByContClearDep2Idx( CFBamAuthorization Authorization,
		long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readBuffByContClearDep2Idx() ";
		CFBamClearSubDep3Buff buff;
		ArrayList<CFBamClearSubDep3Buff> filteredList = new ArrayList<CFBamClearSubDep3Buff>();
		CFBamClearSubDep3Buff[] buffList = readDerivedByContClearDep2Idx( Authorization,
			ContClearDep2TenantId,
			ContClearDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR3" ) ) {
				filteredList.add( (CFBamClearSubDep3Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep3Buff[0] ) );
	}

	public CFBamClearSubDep3Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep2Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep3.readBuffByUNameIdx() ";
		CFBamClearSubDep3Buff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ContClearDep2Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "CLR3" ) ) {
			return( (CFBamClearSubDep3Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateClearSubDep3( CFBamAuthorization Authorization,
		CFBamClearSubDep3Buff Buff )
	{
		schema.getTableClearDep().updateClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateClearSubDep3",
				"Existing record not found",
				"ClearSubDep3",
				pkey );
		}
		CFBamClearSubDep3ByContClearDep2IdxKey existingKeyContClearDep2Idx = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		existingKeyContClearDep2Idx.setRequiredContClearDep2TenantId( existing.getRequiredContClearDep2TenantId() );
		existingKeyContClearDep2Idx.setRequiredContClearDep2Id( existing.getRequiredContClearDep2Id() );

		CFBamClearSubDep3ByContClearDep2IdxKey newKeyContClearDep2Idx = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		newKeyContClearDep2Idx.setRequiredContClearDep2TenantId( Buff.getRequiredContClearDep2TenantId() );
		newKeyContClearDep2Idx.setRequiredContClearDep2Id( Buff.getRequiredContClearDep2Id() );

		CFBamClearSubDep3ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryClearSubDep3().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredContClearDep2Id( existing.getRequiredContClearDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamClearSubDep3ByUNameIdxKey newKeyUNameIdx = schema.getFactoryClearSubDep3().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredContClearDep2Id( Buff.getRequiredContClearDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateClearSubDep3",
					"ClearSubDep3UNameIdx",
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
						"updateClearSubDep3",
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
				if( null == schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearDep2TenantId(),
						Buff.getRequiredContClearDep2Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearSubDep3",
						"Container",
						"ContClearSubDep3",
						"ClearSubDep2",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContClearDep2Idx.get( existingKeyContClearDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContClearDep2Idx.containsKey( newKeyContClearDep2Idx ) ) {
			subdict = dictByContClearDep2Idx.get( newKeyContClearDep2Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamClearSubDep3Buff >();
			dictByContClearDep2Idx.put( newKeyContClearDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteClearSubDep3( CFBamAuthorization Authorization,
		CFBamClearSubDep3Buff Buff )
	{
		final String S_ProcName = "CFBamRamClearSubDep3Table.deleteClearSubDep3() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep3Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteClearSubDep3",
				pkey );
		}
		CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		keyContClearDep2Idx.setRequiredContClearDep2TenantId( existing.getRequiredContClearDep2TenantId() );
		keyContClearDep2Idx.setRequiredContClearDep2Id( existing.getRequiredContClearDep2Id() );

		CFBamClearSubDep3ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep3().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearDep2Id( existing.getRequiredContClearDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContClearDep2Idx.get( keyContClearDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}

	public void deleteClearSubDep3ByContClearDep2Idx( CFBamAuthorization Authorization,
		long argContClearDep2TenantId,
		long argContClearDep2Id )
	{
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( argContClearDep2TenantId );
		key.setRequiredContClearDep2Id( argContClearDep2Id );
		deleteClearSubDep3ByContClearDep2Idx( Authorization, key );
	}

	public void deleteClearSubDep3ByContClearDep2Idx( CFBamAuthorization Authorization,
		CFBamClearSubDep3ByContClearDep2IdxKey argKey )
	{
		CFBamClearSubDep3Buff cur;
		LinkedList<CFBamClearSubDep3Buff> matchSet = new LinkedList<CFBamClearSubDep3Buff>();
		Iterator<CFBamClearSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep3( Authorization, cur );
		}
	}

	public void deleteClearSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContClearDep2Id,
		String argName )
	{
		CFBamClearSubDep3ByUNameIdxKey key = schema.getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredContClearDep2Id( argContClearDep2Id );
		key.setRequiredName( argName );
		deleteClearSubDep3ByUNameIdx( Authorization, key );
	}

	public void deleteClearSubDep3ByUNameIdx( CFBamAuthorization Authorization,
		CFBamClearSubDep3ByUNameIdxKey argKey )
	{
		CFBamClearSubDep3Buff cur;
		LinkedList<CFBamClearSubDep3Buff> matchSet = new LinkedList<CFBamClearSubDep3Buff>();
		Iterator<CFBamClearSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep3( Authorization, cur );
		}
	}

	public void deleteClearSubDep3ByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep3ByTableIdx( Authorization, key );
	}

	public void deleteClearSubDep3ByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey )
	{
		CFBamClearSubDep3Buff cur;
		LinkedList<CFBamClearSubDep3Buff> matchSet = new LinkedList<CFBamClearSubDep3Buff>();
		Iterator<CFBamClearSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep3( Authorization, cur );
		}
	}

	public void deleteClearSubDep3ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteClearSubDep3ByIdIdx( Authorization, key );
	}

	public void deleteClearSubDep3ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamClearSubDep3Buff cur;
		LinkedList<CFBamClearSubDep3Buff> matchSet = new LinkedList<CFBamClearSubDep3Buff>();
		Iterator<CFBamClearSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep3( Authorization, cur );
		}
	}

	public void deleteClearSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep3ByTenantIdx( Authorization, key );
	}

	public void deleteClearSubDep3ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamClearSubDep3Buff cur;
		LinkedList<CFBamClearSubDep3Buff> matchSet = new LinkedList<CFBamClearSubDep3Buff>();
		Iterator<CFBamClearSubDep3Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep3Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep3( Authorization, cur );
		}
	}

	public CFBamCursor openClearSubDep3CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClearSubDep3Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openClearSubDep3CursorByContClearDep2Idx( CFBamAuthorization Authorization,
		long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		CFBamCursor cursor;
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( ContClearDep2TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );

		if( dictByContClearDep2Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep3Buff > subdictContClearDep2Idx
				= dictByContClearDep2Idx.get( key );
			cursor = new CFBamRamClearSubDep3Cursor( Authorization,
				schema,
				subdictContClearDep2Idx.values() );
		}
		else {
			cursor = new CFBamRamClearSubDep3Cursor( Authorization,
				schema,
				new ArrayList< CFBamClearSubDep3Buff >() );
		}
		return( cursor );
	}

	public void closeClearSubDep3Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClearSubDep3Buff nextClearSubDep3Cursor( CFBamCursor Cursor ) {
		CFBamRamClearSubDep3Cursor cursor = (CFBamRamClearSubDep3Cursor)Cursor;
		CFBamClearSubDep3Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClearSubDep3Buff prevClearSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClearSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep3Buff firstClearSubDep3Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClearSubDep3Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep3Buff lastClearSubDep3Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClearSubDep3Cursor" );
	}

	public CFBamClearSubDep3Buff nthClearSubDep3Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClearSubDep3Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep3Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
