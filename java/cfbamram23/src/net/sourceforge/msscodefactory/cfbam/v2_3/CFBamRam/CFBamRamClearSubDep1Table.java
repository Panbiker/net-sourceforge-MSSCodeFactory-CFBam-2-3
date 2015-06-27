
// Description: Java7 in-memory RAM DbIO implementation for ClearSubDep1.

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
 *	CFBamRamClearSubDep1Table in-memory RAM DbIO implementation
 *	for ClearSubDep1.
 */
public class CFBamRamClearSubDep1Table
	implements ICFBamClearSubDep1Table
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamClearSubDep1Buff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamClearSubDep1Buff >();
	private Map< CFBamClearSubDep1ByContClearTopIdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep1Buff >> dictByContClearTopIdx
		= new HashMap< CFBamClearSubDep1ByContClearTopIdxKey,
				Map< CFBamScopePKey,
					CFBamClearSubDep1Buff >>();
	private Map< CFBamClearSubDep1ByUNameIdxKey,
			CFBamClearSubDep1Buff > dictByUNameIdx
		= new HashMap< CFBamClearSubDep1ByUNameIdxKey,
			CFBamClearSubDep1Buff >();

	public CFBamRamClearSubDep1Table( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearSubDep1( CFBamAuthorization Authorization,
		CFBamClearSubDep1Buff Buff )
	{
		final String S_ProcName = "createClearSubDep1";
		schema.getTableClearDep().createClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		keyContClearTopIdx.setRequiredContClearTopDepTenantId( Buff.getRequiredContClearTopDepTenantId() );
		keyContClearTopIdx.setRequiredContClearTopDepId( Buff.getRequiredContClearTopDepId() );

		CFBamClearSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearTopDepId( Buff.getRequiredContClearTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep1UNameIdx",
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
				if( null == schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearTopDepTenantId(),
						Buff.getRequiredContClearTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ContClearTopDep",
						"ClearTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdictContClearTopIdx;
		if( dictByContClearTopIdx.containsKey( keyContClearTopIdx ) ) {
			subdictContClearTopIdx = dictByContClearTopIdx.get( keyContClearTopIdx );
		}
		else {
			subdictContClearTopIdx = new HashMap< CFBamScopePKey, CFBamClearSubDep1Buff >();
			dictByContClearTopIdx.put( keyContClearTopIdx, subdictContClearTopIdx );
		}
		subdictContClearTopIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamClearSubDep1Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClearSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamClearSubDep1.readAllDerived() ";
		CFBamClearSubDep1Buff[] retList = new CFBamClearSubDep1Buff[ dictByPKey.values().size() ];
		Iterator< CFBamClearSubDep1Buff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClearSubDep1Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep1Buff ) ) {
					filteredList.add( (CFBamClearSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
		}
	}

	public CFBamClearSubDep1Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamClearSubDep1Buff ) ) {
					filteredList.add( (CFBamClearSubDep1Buff)buff );
				}
			}
			return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
		}
	}

	public CFBamClearSubDep1Buff[] readDerivedByContClearTopIdx( CFBamAuthorization Authorization,
		long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readDerivedByContClearTopIdx() ";
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( ContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );

		CFBamClearSubDep1Buff[] recArray;
		if( dictByContClearTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdictContClearTopIdx
				= dictByContClearTopIdx.get( key );
			recArray = new CFBamClearSubDep1Buff[ subdictContClearTopIdx.size() ];
			Iterator< CFBamClearSubDep1Buff > iter = subdictContClearTopIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdictContClearTopIdx
				= new HashMap< CFBamScopePKey, CFBamClearSubDep1Buff >();
			dictByContClearTopIdx.put( key, subdictContClearTopIdx );
			recArray = new CFBamClearSubDep1Buff[0];
		}
		return( recArray );
	}

	public CFBamClearSubDep1Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readDerivedByUNameIdx() ";
		CFBamClearSubDep1ByUNameIdxKey key = schema.getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		key.setRequiredName( Name );

		CFBamClearSubDep1Buff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamClearSubDep1Buff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readBuff() ";
		CFBamClearSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readBuff() ";
		CFBamClearSubDep1Buff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLR1" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClearSubDep1Buff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readAllBuff() ";
		CFBamClearSubDep1Buff buff;
		ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
		CFBamClearSubDep1Buff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR1" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
	}

	public CFBamClearSubDep1Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamClearSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClearSubDep1Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamClearSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
	}

	public CFBamClearSubDep1Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "CFBamRamClearDep.readBuffByTableIdx() ";
		CFBamClearDepBuff buff;
		ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
		CFBamClearDepBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLRD" ) ) {
				filteredList.add( (CFBamClearSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
	}

	public CFBamClearSubDep1Buff[] readBuffByContClearTopIdx( CFBamAuthorization Authorization,
		long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readBuffByContClearTopIdx() ";
		CFBamClearSubDep1Buff buff;
		ArrayList<CFBamClearSubDep1Buff> filteredList = new ArrayList<CFBamClearSubDep1Buff>();
		CFBamClearSubDep1Buff[] buffList = readDerivedByContClearTopIdx( Authorization,
			ContClearTopDepTenantId,
			ContClearTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLR1" ) ) {
				filteredList.add( (CFBamClearSubDep1Buff)buff );
			}
		}
		return( filteredList.toArray( new CFBamClearSubDep1Buff[0] ) );
	}

	public CFBamClearSubDep1Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearTopDepId,
		String Name )
	{
		final String S_ProcName = "CFBamRamClearSubDep1.readBuffByUNameIdx() ";
		CFBamClearSubDep1Buff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ContClearTopDepId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "CLR1" ) ) {
			return( (CFBamClearSubDep1Buff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateClearSubDep1( CFBamAuthorization Authorization,
		CFBamClearSubDep1Buff Buff )
	{
		schema.getTableClearDep().updateClearDep( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateClearSubDep1",
				"Existing record not found",
				"ClearSubDep1",
				pkey );
		}
		CFBamClearSubDep1ByContClearTopIdxKey existingKeyContClearTopIdx = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		existingKeyContClearTopIdx.setRequiredContClearTopDepTenantId( existing.getRequiredContClearTopDepTenantId() );
		existingKeyContClearTopIdx.setRequiredContClearTopDepId( existing.getRequiredContClearTopDepId() );

		CFBamClearSubDep1ByContClearTopIdxKey newKeyContClearTopIdx = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		newKeyContClearTopIdx.setRequiredContClearTopDepTenantId( Buff.getRequiredContClearTopDepTenantId() );
		newKeyContClearTopIdx.setRequiredContClearTopDepId( Buff.getRequiredContClearTopDepId() );

		CFBamClearSubDep1ByUNameIdxKey existingKeyUNameIdx = schema.getFactoryClearSubDep1().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredContClearTopDepId( existing.getRequiredContClearTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamClearSubDep1ByUNameIdxKey newKeyUNameIdx = schema.getFactoryClearSubDep1().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredContClearTopDepId( Buff.getRequiredContClearTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateClearSubDep1",
					"ClearSubDep1UNameIdx",
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
						"updateClearSubDep1",
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
				if( null == schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContClearTopDepTenantId(),
						Buff.getRequiredContClearTopDepId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateClearSubDep1",
						"Container",
						"ContClearTopDep",
						"ClearTopDep",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContClearTopIdx.get( existingKeyContClearTopIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContClearTopIdx.containsKey( newKeyContClearTopIdx ) ) {
			subdict = dictByContClearTopIdx.get( newKeyContClearTopIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamClearSubDep1Buff >();
			dictByContClearTopIdx.put( newKeyContClearTopIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteClearSubDep1( CFBamAuthorization Authorization,
		CFBamClearSubDep1Buff Buff )
	{
		final String S_ProcName = "CFBamRamClearSubDep1Table.deleteClearSubDep1() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClearSubDep1Buff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteClearSubDep1",
				pkey );
		}
		CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		keyContClearTopIdx.setRequiredContClearTopDepTenantId( existing.getRequiredContClearTopDepTenantId() );
		keyContClearTopIdx.setRequiredContClearTopDepId( existing.getRequiredContClearTopDepId() );

		CFBamClearSubDep1ByUNameIdxKey keyUNameIdx = schema.getFactoryClearSubDep1().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredContClearTopDepId( existing.getRequiredContClearTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableClearSubDep2().deleteClearSubDep2ByContClearDep1Idx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContClearTopIdx.get( keyContClearTopIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}

	public void deleteClearSubDep1ByContClearTopIdx( CFBamAuthorization Authorization,
		long argContClearTopDepTenantId,
		long argContClearTopDepId )
	{
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( argContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( argContClearTopDepId );
		deleteClearSubDep1ByContClearTopIdx( Authorization, key );
	}

	public void deleteClearSubDep1ByContClearTopIdx( CFBamAuthorization Authorization,
		CFBamClearSubDep1ByContClearTopIdxKey argKey )
	{
		CFBamClearSubDep1Buff cur;
		LinkedList<CFBamClearSubDep1Buff> matchSet = new LinkedList<CFBamClearSubDep1Buff>();
		Iterator<CFBamClearSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep1( Authorization, cur );
		}
	}

	public void deleteClearSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContClearTopDepId,
		String argName )
	{
		CFBamClearSubDep1ByUNameIdxKey key = schema.getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredContClearTopDepId( argContClearTopDepId );
		key.setRequiredName( argName );
		deleteClearSubDep1ByUNameIdx( Authorization, key );
	}

	public void deleteClearSubDep1ByUNameIdx( CFBamAuthorization Authorization,
		CFBamClearSubDep1ByUNameIdxKey argKey )
	{
		CFBamClearSubDep1Buff cur;
		LinkedList<CFBamClearSubDep1Buff> matchSet = new LinkedList<CFBamClearSubDep1Buff>();
		Iterator<CFBamClearSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep1( Authorization, cur );
		}
	}

	public void deleteClearSubDep1ByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep1ByTableIdx( Authorization, key );
	}

	public void deleteClearSubDep1ByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey )
	{
		CFBamClearSubDep1Buff cur;
		LinkedList<CFBamClearSubDep1Buff> matchSet = new LinkedList<CFBamClearSubDep1Buff>();
		Iterator<CFBamClearSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep1( Authorization, cur );
		}
	}

	public void deleteClearSubDep1ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteClearSubDep1ByIdIdx( Authorization, key );
	}

	public void deleteClearSubDep1ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamClearSubDep1Buff cur;
		LinkedList<CFBamClearSubDep1Buff> matchSet = new LinkedList<CFBamClearSubDep1Buff>();
		Iterator<CFBamClearSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep1( Authorization, cur );
		}
	}

	public void deleteClearSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep1ByTenantIdx( Authorization, key );
	}

	public void deleteClearSubDep1ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamClearSubDep1Buff cur;
		LinkedList<CFBamClearSubDep1Buff> matchSet = new LinkedList<CFBamClearSubDep1Buff>();
		Iterator<CFBamClearSubDep1Buff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClearSubDep1Buff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteClearSubDep1( Authorization, cur );
		}
	}

	public CFBamCursor openClearSubDep1CursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClearSubDep1Cursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openClearSubDep1CursorByContClearTopIdx( CFBamAuthorization Authorization,
		long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		CFBamCursor cursor;
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( ContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );

		if( dictByContClearTopIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamClearSubDep1Buff > subdictContClearTopIdx
				= dictByContClearTopIdx.get( key );
			cursor = new CFBamRamClearSubDep1Cursor( Authorization,
				schema,
				subdictContClearTopIdx.values() );
		}
		else {
			cursor = new CFBamRamClearSubDep1Cursor( Authorization,
				schema,
				new ArrayList< CFBamClearSubDep1Buff >() );
		}
		return( cursor );
	}

	public void closeClearSubDep1Cursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClearSubDep1Buff nextClearSubDep1Cursor( CFBamCursor Cursor ) {
		CFBamRamClearSubDep1Cursor cursor = (CFBamRamClearSubDep1Cursor)Cursor;
		CFBamClearSubDep1Buff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClearSubDep1Buff prevClearSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClearSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep1Buff firstClearSubDep1Cursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClearSubDep1Buff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public CFBamClearSubDep1Buff lastClearSubDep1Cursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClearSubDep1Cursor" );
	}

	public CFBamClearSubDep1Buff nthClearSubDep1Cursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClearSubDep1Buff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClearSubDep1Cursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
