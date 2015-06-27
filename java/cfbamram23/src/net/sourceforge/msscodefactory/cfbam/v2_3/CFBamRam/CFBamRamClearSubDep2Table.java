
// Description: Java7 in-memory RAM DbIO implementation for ClearSubDep2.

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
 *	CFBamRamClearSubDep2Table in-memory RAM DbIO implementation
 *	for ClearSubDep2.
 */
public class CFBamRamClearSubDep2Table
	implements ICFBamClearSubDep2Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamClearSubDep2Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamClearSubDep2Buff >();
	private Map< CFBamClearSubDep2ByContClearDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep2Buff >> dictByContClearDep1Idx
		= new HashMap< CFBamClearSubDep2ByContClearDep1IdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep2Buff >>();
	private Map< CFBamClearSubDep2ByUNameIdxKey,
			CFBamClearSubDep2Buff > dictByUNameIdx
		= new HashMap< CFBamClearSubDep2ByUNameIdxKey,
			CFBamClearSubDep2Buff >();

	public CFBamRamClearSubDep2Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff )
	{
		final String S_ProcName = "createClearSubDep2";
		schema.getTableClearDep().createClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		keyContClearDep1Idx.setRequiredContClearDep1TenantId( Buff.getRequiredContClearDep1TenantId() );
		keyContClearDep1Idx.setRequiredContClearDep1Id( Buff.getRequiredContClearDep1Id() );

		CFBamClearSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearDep1Id( Buff.getRequiredContClearDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep2UNameIdx",
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
				if( null == schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearDep1TenantId(),
						Buff.getRequiredContClearDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContClearSubDep1",
						"ClearSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdictContClearDep1Idx;
		if( dictByContClearDep1Idx.containsKey( keyContClearDep1Idx ) ) {
			subdictContClearDep1Idx = dictByContClearDep1Idx.get( keyContClearDep1Idx );
		}
		else {
			subdictContClearDep1Idx = new HashMap< CFBamScopePKey, CFBamClearSubDep2Buff >();
			dictByContClearDep1Idx.put( keyContClearDep1Idx, subdictContClearDep1Idx );
		}
		subdictContClearDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamClearSubDep2Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamClearSubDep2.readAllDerived() ";
		CFBamClearSubDep2Buff[] retList = new CFBamClearSubDep2Buff[ dictByPKey.values().size() ];
		Iterator< CFBamClearSubDep2Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClearSubDep2Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep2Buff ) ) {
					filteredList.add( (CFBamClearSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
		}
	}

	public CFBamClearSubDep2Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep2Buff ) ) {
					filteredList.add( (CFBamClearSubDep2Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
		}
	}

	public CFBamClearSubDep2Buff[] readDerivedByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readDerivedByContClearDep1Idx() ";
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( ContClearDep1TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );

		CFBamClearSubDep2Buff[] recArray;
		if( dictByContClearDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdictContClearDep1Idx
				= dictByContClearDep1Idx.get( key );
			recArray = new CFBamClearSubDep2Buff[ subdictContClearDep1Idx.size() ];
			Iterator< CFBamClearSubDep2Buff > iter = subdictContClearDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdictContClearDep1Idx
				= new HashMap< CFBamScopePKey, CFBamClearSubDep2Buff >();
			dictByContClearDep1Idx.put( key, subdictContClearDep1Idx );
			recArray = new CFBamClearSubDep2Buff[0];
		}
		return( recArray );
	}

	public CFBamClearSubDep2Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readDerivedByUNameIdx() ";
		CFBamClearSubDep2ByUNameIdxKey key = schema.getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		key.setRequiredName( Name );

		CFBamClearSubDep2Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamClearSubDep2Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readBuff() ";
		CFBamClearSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readBuff() ";
		CFBamClearSubDep2Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR2" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep2Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readAllBuff() ";
		CFBamClearSubDep2Buff buff;
		ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
		CFBamClearSubDep2Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR2" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
	}

	public CFBamClearSubDep2Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamClearSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClearSubDep2Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamClearSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
	}

	public CFBamClearSubDep2Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuffByTableIdx() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
		CFBamClearDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( (CFBamClearSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
	}

	public CFBamClearSubDep2Buff[] readBuffByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readBuffByContClearDep1Idx() ";
		CFBamClearSubDep2Buff buff;
		ArrayList<CFBamClearSubDep2Buff> filteredList = new ArrayList<CFBamClearSubDep2Buff>();
		CFBamClearSubDep2Buff[] buffList = readDerivedByContClearDep1Idx( Authorization,
			ContClearDep1TenantId,
			ContClearDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR2" ) ) {
				filteredList.add( (CFBamClearSubDep2Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep2Buff[0] ) );
	}

	public CFBamClearSubDep2Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep1Id,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep2.readBuffByUNameIdx() ";
		CFBamClearSubDep2Buff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ContClearDep1Id,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "CLR2" ) ) {
			return( (CFBamClearSubDep2Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff )
	{
		schema.getTableClearDep().updateClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateClearSubDep2",
				"Existing record not found",
				"ClearSubDep2",
				pkey );
		}
		CFBamClearSubDep2ByContClearDep1IdxKey existingKeyContClearDep1Idx = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		existingKeyContClearDep1Idx.setRequiredContClearDep1TenantId( existing.getRequiredContClearDep1TenantId() );
		existingKeyContClearDep1Idx.setRequiredContClearDep1Id( existing.getRequiredContClearDep1Id() );

		CFBamClearSubDep2ByContClearDep1IdxKey newKeyContClearDep1Idx = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		newKeyContClearDep1Idx.setRequiredContClearDep1TenantId( Buff.getRequiredContClearDep1TenantId() );
		newKeyContClearDep1Idx.setRequiredContClearDep1Id( Buff.getRequiredContClearDep1Id() );

		CFBamClearSubDep2ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryClearSubDep2().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredContClearDep1Id( existing.getRequiredContClearDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamClearSubDep2ByUNameIdxKey newKeyUNameIdx = schema.getFactoryClearSubDep2().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredContClearDep1Id( Buff.getRequiredContClearDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateClearSubDep2",
					"ClearSubDep2UNameIdx",
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
						"updateClearSubDep2",
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
				if( null == schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearDep1TenantId(),
						Buff.getRequiredContClearDep1Id() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearSubDep2",
						"Container",
						"ContClearSubDep1",
						"ClearSubDep1",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContClearDep1Idx.get( existingKeyContClearDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContClearDep1Idx.containsKey( newKeyContClearDep1Idx ) ) {
			subdict = dictByContClearDep1Idx.get( newKeyContClearDep1Idx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamClearSubDep2Buff >();
			dictByContClearDep1Idx.put( newKeyContClearDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff )
	{
		final String S_ProcName = "CFBamRamClearSubDep2Table.deleteClearSubDep2() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep2Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteClearSubDep2",
				pkey );
		}
		CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		keyContClearDep1Idx.setRequiredContClearDep1TenantId( existing.getRequiredContClearDep1TenantId() );
		keyContClearDep1Idx.setRequiredContClearDep1Id( existing.getRequiredContClearDep1Id() );

		CFBamClearSubDep2ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep2().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearDep1Id( existing.getRequiredContClearDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableClearSubDep3().deleteClearSubDep3ByContClearDep2Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContClearDep1Idx.get( keyContClearDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}

	public void deleteClearSubDep2ByContClearDep1Idx( CFBamAuthorization Authorization,
		long argContClearDep1TenantId,
		long argContClearDep1Id )
	{
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( argContClearDep1TenantId );
		key.setRequiredContClearDep1Id( argContClearDep1Id );
		deleteClearSubDep2ByContClearDep1Idx( Authorization, key );
	}

	public void deleteClearSubDep2ByContClearDep1Idx( CFBamAuthorization Authorization,
		CFBamClearSubDep2ByContClearDep1IdxKey argKey )
	{
		CFBamClearSubDep2Buff cur;
		LinkedList<CFBamClearSubDep2Buff> matchSet = new LinkedList<CFBamClearSubDep2Buff>();
		Iterator<CFBamClearSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep2( Authorization, cur );
		}
	}

	public void deleteClearSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContClearDep1Id,
		String argName )
	{
		CFBamClearSubDep2ByUNameIdxKey key = schema.getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredContClearDep1Id( argContClearDep1Id );
		key.setRequiredName( argName );
		deleteClearSubDep2ByUNameIdx( Authorization, key );
	}

	public void deleteClearSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		CFBamClearSubDep2ByUNameIdxKey argKey )
	{
		CFBamClearSubDep2Buff cur;
		LinkedList<CFBamClearSubDep2Buff> matchSet = new LinkedList<CFBamClearSubDep2Buff>();
		Iterator<CFBamClearSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep2( Authorization, cur );
		}
	}

	public void deleteClearSubDep2ByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep2ByTableIdx( Authorization, key );
	}

	public void deleteClearSubDep2ByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey )
	{
		CFBamClearSubDep2Buff cur;
		LinkedList<CFBamClearSubDep2Buff> matchSet = new LinkedList<CFBamClearSubDep2Buff>();
		Iterator<CFBamClearSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep2( Authorization, cur );
		}
	}

	public void deleteClearSubDep2ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteClearSubDep2ByIdIdx( Authorization, key );
	}

	public void deleteClearSubDep2ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamClearSubDep2Buff cur;
		LinkedList<CFBamClearSubDep2Buff> matchSet = new LinkedList<CFBamClearSubDep2Buff>();
		Iterator<CFBamClearSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep2( Authorization, cur );
		}
	}

	public void deleteClearSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep2ByTenantIdx( Authorization, key );
	}

	public void deleteClearSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamClearSubDep2Buff cur;
		LinkedList<CFBamClearSubDep2Buff> matchSet = new LinkedList<CFBamClearSubDep2Buff>();
		Iterator<CFBamClearSubDep2Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep2Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep2( Authorization, cur );
		}
	}

	public CFBamCursor openClearSubDep2CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClearSubDep2Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openClearSubDep2CursorByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		CFBamCursor cursor;
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( ContClearDep1TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );

		if( dictByContClearDep1Idx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep2Buff > subdictContClearDep1Idx
				= dictByContClearDep1Idx.get( key );
			cursor = new CFBamRamClearSubDep2Cursor( Authorization,
				schema,
				subdictContClearDep1Idx.values() );
		}
		else {
			cursor = new CFBamRamClearSubDep2Cursor( Authorization,
				schema,
				new ArrayList< CFBamClearSubDep2Buff >() );
		}
		return( cursor );
	}

	public void closeClearSubDep2Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClearSubDep2Buff nextClearSubDep2Cursor( CFBamCursor Cursor ) {
		CFBamRamClearSubDep2Cursor cursor = (CFBamRamClearSubDep2Cursor)Cursor;
		CFBamClearSubDep2Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClearSubDep2Buff prevClearSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClearSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep2Buff firstClearSubDep2Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClearSubDep2Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep2Buff lastClearSubDep2Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClearSubDep2Cursor" );
	}

	public CFBamClearSubDep2Buff nthClearSubDep2Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClearSubDep2Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep2Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
