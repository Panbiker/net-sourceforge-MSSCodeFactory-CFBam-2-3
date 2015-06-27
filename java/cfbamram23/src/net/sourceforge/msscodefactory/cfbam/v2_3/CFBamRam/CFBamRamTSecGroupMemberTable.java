
// Description: Java7 in-memory RAM DbIO implementation for TSecGroupMember.

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
 *	CFBamRamTSecGroupMemberTable in-memory RAM DbIO implementation
 *	for TSecGroupMember.
 */
public class CFBamRamTSecGroupMemberTable
	implements ICFBamTSecGroupMemberTable
{
	private CFBamRamSchema schema;
	private Map< CFBamTSecGroupMemberPKey,
				CFBamTSecGroupMemberBuff > dictByPKey
		= new HashMap< CFBamTSecGroupMemberPKey,
				CFBamTSecGroupMemberBuff >();
	private Map< CFBamTSecGroupMemberByTenantIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >> dictByTenantIdx
		= new HashMap< CFBamTSecGroupMemberByTenantIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >>();
	private Map< CFBamTSecGroupMemberByGroupIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >> dictByGroupIdx
		= new HashMap< CFBamTSecGroupMemberByGroupIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >>();
	private Map< CFBamTSecGroupMemberByUserIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >> dictByUserIdx
		= new HashMap< CFBamTSecGroupMemberByUserIdxKey,
				Map< CFBamTSecGroupMemberPKey,
					CFBamTSecGroupMemberBuff >>();
	private Map< CFBamTSecGroupMemberByUUserIdxKey,
			CFBamTSecGroupMemberBuff > dictByUUserIdx
		= new HashMap< CFBamTSecGroupMemberByUUserIdxKey,
			CFBamTSecGroupMemberBuff >();

	public CFBamRamTSecGroupMemberTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff )
	{
		final String S_ProcName = "createTSecGroupMember";
		CFBamTSecGroupMemberPKey pkey = schema.getFactoryTSecGroupMember().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupMemberId( ((CFBamRamTenantTable)schema.getTableTenant()).nextTSecGroupMemberIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGroupMemberId( pkey.getRequiredTSecGroupMemberId() );
		CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFBamTSecGroupMemberByUserIdxKey keyUserIdx = schema.getFactoryTSecGroupMember().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		keyUUserIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUUserIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUserIdx.containsKey( keyUUserIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGroupMemberUUserIdx",
				keyUUserIdx );
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
						"TSecGroupMemberTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTSecGroupId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"TSecGroupMemberGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		dictByUUserIdx.put( keyUUserIdx, Buff );

	}

	public CFBamTSecGroupMemberBuff readDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerived() ";
		CFBamTSecGroupMemberPKey key = schema.getFactoryTSecGroupMember().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupMemberId( PKey.getRequiredTSecGroupMemberId() );
		CFBamTSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerived() ";
		CFBamTSecGroupMemberPKey key = schema.getFactoryTSecGroupMember().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupMemberId( PKey.getRequiredTSecGroupMemberId() );
		CFBamTSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTSecGroupMember.readAllDerived() ";
		CFBamTSecGroupMemberBuff[] retList = new CFBamTSecGroupMemberBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTSecGroupMemberBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTSecGroupMemberBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerivedByTenantIdx() ";
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamTSecGroupMemberBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamTSecGroupMemberBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamTSecGroupMemberBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictTenantIdx
				= new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamTSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupMemberBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerivedByGroupIdx() ";
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFBamTSecGroupMemberBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFBamTSecGroupMemberBuff[ subdictGroupIdx.size() ];
			Iterator< CFBamTSecGroupMemberBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictGroupIdx
				= new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFBamTSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupMemberBuff[] readDerivedByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerivedByUserIdx() ";
		CFBamTSecGroupMemberByUserIdxKey key = schema.getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFBamTSecGroupMemberBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFBamTSecGroupMemberBuff[ subdictUserIdx.size() ];
			Iterator< CFBamTSecGroupMemberBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictUserIdx
				= new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFBamTSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupMemberBuff readDerivedByUUserIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerivedByUUserIdx() ";
		CFBamTSecGroupMemberByUUserIdxKey key = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );

		CFBamTSecGroupMemberBuff buff;
		if( dictByUUserIdx.containsKey( key ) ) {
			buff = dictByUUserIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupMemberId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readDerivedByIdIdx() ";
		CFBamTSecGroupMemberPKey key = schema.getFactoryTSecGroupMember().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupMemberId( TSecGroupMemberId );

		CFBamTSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff readBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuff() ";
		CFBamTSecGroupMemberBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuff() ";
		CFBamTSecGroupMemberBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupMemberBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readAllBuff() ";
		CFBamTSecGroupMemberBuff buff;
		ArrayList<CFBamTSecGroupMemberBuff> filteredList = new ArrayList<CFBamTSecGroupMemberBuff>();
		CFBamTSecGroupMemberBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupMemberBuff[0] ) );
	}

	public CFBamTSecGroupMemberBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupMemberId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuffByIdIdx() ";
		CFBamTSecGroupMemberBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGroupMemberId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
			return( (CFBamTSecGroupMemberBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTSecGroupMemberBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuffByTenantIdx() ";
		CFBamTSecGroupMemberBuff buff;
		ArrayList<CFBamTSecGroupMemberBuff> filteredList = new ArrayList<CFBamTSecGroupMemberBuff>();
		CFBamTSecGroupMemberBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFBamTSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupMemberBuff[0] ) );
	}

	public CFBamTSecGroupMemberBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuffByGroupIdx() ";
		CFBamTSecGroupMemberBuff buff;
		ArrayList<CFBamTSecGroupMemberBuff> filteredList = new ArrayList<CFBamTSecGroupMemberBuff>();
		CFBamTSecGroupMemberBuff[] buffList = readDerivedByGroupIdx( Authorization,
			TenantId,
			TSecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFBamTSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupMemberBuff[0] ) );
	}

	public CFBamTSecGroupMemberBuff[] readBuffByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuffByUserIdx() ";
		CFBamTSecGroupMemberBuff buff;
		ArrayList<CFBamTSecGroupMemberBuff> filteredList = new ArrayList<CFBamTSecGroupMemberBuff>();
		CFBamTSecGroupMemberBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFBamTSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupMemberBuff[0] ) );
	}

	public CFBamTSecGroupMemberBuff readBuffByUUserIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamTSecGroupMember.readBuffByUUserIdx() ";
		CFBamTSecGroupMemberBuff buff = readDerivedByUUserIdx( Authorization,
			TenantId,
			TSecGroupId,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
			return( (CFBamTSecGroupMemberBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff )
	{
		CFBamTSecGroupMemberPKey pkey = schema.getFactoryTSecGroupMember().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupMemberId( Buff.getRequiredTSecGroupMemberId() );
		CFBamTSecGroupMemberBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTSecGroupMember",
				"Existing record not found",
				"TSecGroupMember",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateTSecGroupMember",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamTSecGroupMemberByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupMemberByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupMemberByGroupIdxKey existingKeyGroupIdx = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFBamTSecGroupMemberByGroupIdxKey newKeyGroupIdx = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		newKeyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFBamTSecGroupMemberByUserIdxKey existingKeyUserIdx = schema.getFactoryTSecGroupMember().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamTSecGroupMemberByUserIdxKey newKeyUserIdx = schema.getFactoryTSecGroupMember().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamTSecGroupMemberByUUserIdxKey existingKeyUUserIdx = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		existingKeyUUserIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUUserIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		existingKeyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamTSecGroupMemberByUUserIdxKey newKeyUUserIdx = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		newKeyUUserIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUUserIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		newKeyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		if( ! existingKeyUUserIdx.equals( newKeyUUserIdx ) ) {
			if( dictByUUserIdx.containsKey( newKeyUUserIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTSecGroupMember",
					"TSecGroupMemberUUserIdx",
					newKeyUUserIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTSecGroupMember",
						"Owner",
						"TSecGroupMemberTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTSecGroupId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTSecGroupMember",
						"Container",
						"TSecGroupMemberGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdict;

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
			subdict = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByGroupIdx.get( existingKeyGroupIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGroupIdx.containsKey( newKeyGroupIdx ) ) {
			subdict = dictByGroupIdx.get( newKeyGroupIdx );
		}
		else {
			subdict = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByUserIdx.get( existingKeyUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
			subdict = dictByUserIdx.get( newKeyUserIdx );
		}
		else {
			subdict = new HashMap< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUUserIdx.remove( existingKeyUUserIdx );
		dictByUUserIdx.put( newKeyUUserIdx, Buff );

	}

	public void deleteTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff )
	{
		final String S_ProcName = "CFBamRamTSecGroupMemberTable.deleteTSecGroupMember() ";
		CFBamTSecGroupMemberPKey pkey = schema.getFactoryTSecGroupMember().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupMemberId( Buff.getRequiredTSecGroupMemberId() );
		CFBamTSecGroupMemberBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTSecGroupMember",
				pkey );
		}
		CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFBamTSecGroupMemberByUserIdxKey keyUserIdx = schema.getFactoryTSecGroupMember().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		keyUUserIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUUserIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

		dictByUUserIdx.remove( keyUUserIdx );

	}

	public void deleteTSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTSecGroupMemberId )
	{
		CFBamTSecGroupMemberPKey key = schema.getFactoryTSecGroupMember().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupMemberId( argTSecGroupMemberId );
		deleteTSecGroupMemberByIdIdx( Authorization, key );
	}

	public void deleteTSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey argKey )
	{
		CFBamTSecGroupMemberBuff cur;
		LinkedList<CFBamTSecGroupMemberBuff> matchSet = new LinkedList<CFBamTSecGroupMemberBuff>();
		Iterator<CFBamTSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupMember( Authorization, cur );
		}
	}

	public void deleteTSecGroupMemberByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGroupMemberByTenantIdx( Authorization, key );
	}

	public void deleteTSecGroupMemberByTenantIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByTenantIdxKey argKey )
	{
		CFBamTSecGroupMemberBuff cur;
		LinkedList<CFBamTSecGroupMemberBuff> matchSet = new LinkedList<CFBamTSecGroupMemberBuff>();
		Iterator<CFBamTSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupMember( Authorization, cur );
		}
	}

	public void deleteTSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGroupMemberByGroupIdx( Authorization, key );
	}

	public void deleteTSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByGroupIdxKey argKey )
	{
		CFBamTSecGroupMemberBuff cur;
		LinkedList<CFBamTSecGroupMemberBuff> matchSet = new LinkedList<CFBamTSecGroupMemberBuff>();
		Iterator<CFBamTSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupMember( Authorization, cur );
		}
	}

	public void deleteTSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		CFBamTSecGroupMemberByUserIdxKey key = schema.getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteTSecGroupMemberByUserIdx( Authorization, key );
	}

	public void deleteTSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByUserIdxKey argKey )
	{
		CFBamTSecGroupMemberBuff cur;
		LinkedList<CFBamTSecGroupMemberBuff> matchSet = new LinkedList<CFBamTSecGroupMemberBuff>();
		Iterator<CFBamTSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupMember( Authorization, cur );
		}
	}

	public void deleteTSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId,
		UUID argSecUserId )
	{
		CFBamTSecGroupMemberByUUserIdxKey key = schema.getFactoryTSecGroupMember().newUUserIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		key.setRequiredSecUserId( argSecUserId );
		deleteTSecGroupMemberByUUserIdx( Authorization, key );
	}

	public void deleteTSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByUUserIdxKey argKey )
	{
		CFBamTSecGroupMemberBuff cur;
		LinkedList<CFBamTSecGroupMemberBuff> matchSet = new LinkedList<CFBamTSecGroupMemberBuff>();
		Iterator<CFBamTSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupMember( Authorization, cur );
		}
	}

	public CFBamCursor openTSecGroupMemberCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTSecGroupMemberCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTSecGroupMemberCursorByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				subdictGroupIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTSecGroupMemberCursorByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupMemberByUserIdxKey key = schema.getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupMemberPKey, CFBamTSecGroupMemberBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				subdictUserIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public void closeTSecGroupMemberCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTSecGroupMemberBuff nextTSecGroupMemberCursor( CFBamCursor Cursor ) {
		CFBamRamTSecGroupMemberCursor cursor = (CFBamRamTSecGroupMemberCursor)Cursor;
		CFBamTSecGroupMemberBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTSecGroupMemberBuff prevTSecGroupMemberCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTSecGroupMemberBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupMemberBuff firstTSecGroupMemberCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTSecGroupMemberBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupMemberBuff lastTSecGroupMemberCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTSecGroupMemberCursor" );
	}

	public CFBamTSecGroupMemberBuff nthTSecGroupMemberCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTSecGroupMemberBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
