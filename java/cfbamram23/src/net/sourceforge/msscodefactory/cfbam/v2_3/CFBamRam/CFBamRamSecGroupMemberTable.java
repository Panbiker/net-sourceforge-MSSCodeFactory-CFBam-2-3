
// Description: Java7 in-memory RAM DbIO implementation for SecGroupMember.

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
 *	CFBamRamSecGroupMemberTable in-memory RAM DbIO implementation
 *	for SecGroupMember.
 */
public class CFBamRamSecGroupMemberTable
	implements ICFBamSecGroupMemberTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecGroupMemberPKey,
				CFBamSecGroupMemberBuff > dictByPKey
		= new HashMap< CFBamSecGroupMemberPKey,
				CFBamSecGroupMemberBuff >();
	private Map< CFBamSecGroupMemberByClusterIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >> dictByClusterIdx
		= new HashMap< CFBamSecGroupMemberByClusterIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >>();
	private Map< CFBamSecGroupMemberByGroupIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >> dictByGroupIdx
		= new HashMap< CFBamSecGroupMemberByGroupIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >>();
	private Map< CFBamSecGroupMemberByUserIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >> dictByUserIdx
		= new HashMap< CFBamSecGroupMemberByUserIdxKey,
				Map< CFBamSecGroupMemberPKey,
					CFBamSecGroupMemberBuff >>();
	private Map< CFBamSecGroupMemberByUUserIdxKey,
			CFBamSecGroupMemberBuff > dictByUUserIdx
		= new HashMap< CFBamSecGroupMemberByUUserIdxKey,
			CFBamSecGroupMemberBuff >();

	public CFBamRamSecGroupMemberTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupMember( CFBamAuthorization Authorization,
		CFBamSecGroupMemberBuff Buff )
	{
		final String S_ProcName = "createSecGroupMember";
		CFBamSecGroupMemberPKey pkey = schema.getFactorySecGroupMember().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupMemberId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecGroupMemberIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupMemberId( pkey.getRequiredSecGroupMemberId() );
		CFBamSecGroupMemberByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupMember().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupMemberByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupMember().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupMemberByUserIdxKey keyUserIdx = schema.getFactorySecGroupMember().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamSecGroupMemberByUUserIdxKey keyUUserIdx = schema.getFactorySecGroupMember().newUUserIdxKey();
		keyUUserIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUUserIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUserIdx.containsKey( keyUUserIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupMemberUUserIdx",
				keyUUserIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"SecGroupMemberCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecGroupMemberGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		dictByUUserIdx.put( keyUUserIdx, Buff );

	}

	public CFBamSecGroupMemberBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerived() ";
		CFBamSecGroupMemberPKey key = schema.getFactorySecGroupMember().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupMemberId( PKey.getRequiredSecGroupMemberId() );
		CFBamSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerived() ";
		CFBamSecGroupMemberPKey key = schema.getFactorySecGroupMember().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupMemberId( PKey.getRequiredSecGroupMemberId() );
		CFBamSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecGroupMember.readAllDerived() ";
		CFBamSecGroupMemberBuff[] retList = new CFBamSecGroupMemberBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecGroupMemberBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecGroupMemberBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerivedByClusterIdx() ";
		CFBamSecGroupMemberByClusterIdxKey key = schema.getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecGroupMemberBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecGroupMemberBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecGroupMemberBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictClusterIdx
				= new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupMemberBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerivedByGroupIdx() ";
		CFBamSecGroupMemberByGroupIdxKey key = schema.getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFBamSecGroupMemberBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFBamSecGroupMemberBuff[ subdictGroupIdx.size() ];
			Iterator< CFBamSecGroupMemberBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictGroupIdx
				= new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFBamSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupMemberBuff[] readDerivedByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerivedByUserIdx() ";
		CFBamSecGroupMemberByUserIdxKey key = schema.getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFBamSecGroupMemberBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFBamSecGroupMemberBuff[ subdictUserIdx.size() ];
			Iterator< CFBamSecGroupMemberBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictUserIdx
				= new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFBamSecGroupMemberBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupMemberBuff readDerivedByUUserIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerivedByUUserIdx() ";
		CFBamSecGroupMemberByUUserIdxKey key = schema.getFactorySecGroupMember().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );

		CFBamSecGroupMemberBuff buff;
		if( dictByUUserIdx.containsKey( key ) ) {
			buff = dictByUUserIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupMemberId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readDerivedByIdIdx() ";
		CFBamSecGroupMemberPKey key = schema.getFactorySecGroupMember().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupMemberId( SecGroupMemberId );

		CFBamSecGroupMemberBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuff() ";
		CFBamSecGroupMemberBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupMemberPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuff() ";
		CFBamSecGroupMemberBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupMemberBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readAllBuff() ";
		CFBamSecGroupMemberBuff buff;
		ArrayList<CFBamSecGroupMemberBuff> filteredList = new ArrayList<CFBamSecGroupMemberBuff>();
		CFBamSecGroupMemberBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupMemberBuff[0] ) );
	}

	public CFBamSecGroupMemberBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupMemberId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuffByIdIdx() ";
		CFBamSecGroupMemberBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupMemberId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
			return( (CFBamSecGroupMemberBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecGroupMemberBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuffByClusterIdx() ";
		CFBamSecGroupMemberBuff buff;
		ArrayList<CFBamSecGroupMemberBuff> filteredList = new ArrayList<CFBamSecGroupMemberBuff>();
		CFBamSecGroupMemberBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFBamSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupMemberBuff[0] ) );
	}

	public CFBamSecGroupMemberBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuffByGroupIdx() ";
		CFBamSecGroupMemberBuff buff;
		ArrayList<CFBamSecGroupMemberBuff> filteredList = new ArrayList<CFBamSecGroupMemberBuff>();
		CFBamSecGroupMemberBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFBamSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupMemberBuff[0] ) );
	}

	public CFBamSecGroupMemberBuff[] readBuffByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuffByUserIdx() ";
		CFBamSecGroupMemberBuff buff;
		ArrayList<CFBamSecGroupMemberBuff> filteredList = new ArrayList<CFBamSecGroupMemberBuff>();
		CFBamSecGroupMemberBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFBamSecGroupMemberBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupMemberBuff[0] ) );
	}

	public CFBamSecGroupMemberBuff readBuffByUUserIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecGroupMember.readBuffByUUserIdx() ";
		CFBamSecGroupMemberBuff buff = readDerivedByUUserIdx( Authorization,
			ClusterId,
			SecGroupId,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
			return( (CFBamSecGroupMemberBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecGroupMember( CFBamAuthorization Authorization,
		CFBamSecGroupMemberBuff Buff )
	{
		CFBamSecGroupMemberPKey pkey = schema.getFactorySecGroupMember().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupMemberId( Buff.getRequiredSecGroupMemberId() );
		CFBamSecGroupMemberBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecGroupMember",
				"Existing record not found",
				"SecGroupMember",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecGroupMember",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecGroupMemberByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroupMember().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupMemberByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroupMember().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupMemberByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGroupMember().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupMemberByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGroupMember().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupMemberByUserIdxKey existingKeyUserIdx = schema.getFactorySecGroupMember().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecGroupMemberByUserIdxKey newKeyUserIdx = schema.getFactorySecGroupMember().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamSecGroupMemberByUUserIdxKey existingKeyUUserIdx = schema.getFactorySecGroupMember().newUUserIdxKey();
		existingKeyUUserIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUUserIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecGroupMemberByUUserIdxKey newKeyUUserIdx = schema.getFactorySecGroupMember().newUUserIdxKey();
		newKeyUUserIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUUserIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		if( ! existingKeyUUserIdx.equals( newKeyUUserIdx ) ) {
			if( dictByUUserIdx.containsKey( newKeyUUserIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecGroupMember",
					"SecGroupMemberUUserIdx",
					newKeyUUserIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecGroupMember",
						"Owner",
						"SecGroupMemberCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecGroupMember",
						"Container",
						"SecGroupMemberGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
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
			subdict = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
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
			subdict = new HashMap< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUUserIdx.remove( existingKeyUUserIdx );
		dictByUUserIdx.put( newKeyUUserIdx, Buff );

	}

	public void deleteSecGroupMember( CFBamAuthorization Authorization,
		CFBamSecGroupMemberBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecGroupMemberTable.deleteSecGroupMember() ";
		CFBamSecGroupMemberPKey pkey = schema.getFactorySecGroupMember().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupMemberId( Buff.getRequiredSecGroupMemberId() );
		CFBamSecGroupMemberBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecGroupMember",
				pkey );
		}
		CFBamSecGroupMemberByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupMember().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupMemberByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupMember().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupMemberByUserIdxKey keyUserIdx = schema.getFactorySecGroupMember().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecGroupMemberByUUserIdxKey keyUUserIdx = schema.getFactorySecGroupMember().newUUserIdxKey();
		keyUUserIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUUserIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

		dictByUUserIdx.remove( keyUUserIdx );

	}

	public void deleteSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupMemberId )
	{
		CFBamSecGroupMemberPKey key = schema.getFactorySecGroupMember().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupMemberId( argSecGroupMemberId );
		deleteSecGroupMemberByIdIdx( Authorization, key );
	}

	public void deleteSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupMemberPKey argKey )
	{
		CFBamSecGroupMemberBuff cur;
		LinkedList<CFBamSecGroupMemberBuff> matchSet = new LinkedList<CFBamSecGroupMemberBuff>();
		Iterator<CFBamSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupMember( Authorization, cur );
		}
	}

	public void deleteSecGroupMemberByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecGroupMemberByClusterIdxKey key = schema.getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupMemberByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupMemberByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupMemberByClusterIdxKey argKey )
	{
		CFBamSecGroupMemberBuff cur;
		LinkedList<CFBamSecGroupMemberBuff> matchSet = new LinkedList<CFBamSecGroupMemberBuff>();
		Iterator<CFBamSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupMember( Authorization, cur );
		}
	}

	public void deleteSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFBamSecGroupMemberByGroupIdxKey key = schema.getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupMemberByGroupIdx( Authorization, key );
	}

	public void deleteSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupMemberByGroupIdxKey argKey )
	{
		CFBamSecGroupMemberBuff cur;
		LinkedList<CFBamSecGroupMemberBuff> matchSet = new LinkedList<CFBamSecGroupMemberBuff>();
		Iterator<CFBamSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupMember( Authorization, cur );
		}
	}

	public void deleteSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		CFBamSecGroupMemberByUserIdxKey key = schema.getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecGroupMemberByUserIdx( Authorization, key );
	}

	public void deleteSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		CFBamSecGroupMemberByUserIdxKey argKey )
	{
		CFBamSecGroupMemberBuff cur;
		LinkedList<CFBamSecGroupMemberBuff> matchSet = new LinkedList<CFBamSecGroupMemberBuff>();
		Iterator<CFBamSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupMember( Authorization, cur );
		}
	}

	public void deleteSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		UUID argSecUserId )
	{
		CFBamSecGroupMemberByUUserIdxKey key = schema.getFactorySecGroupMember().newUUserIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredSecUserId( argSecUserId );
		deleteSecGroupMemberByUUserIdx( Authorization, key );
	}

	public void deleteSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		CFBamSecGroupMemberByUUserIdxKey argKey )
	{
		CFBamSecGroupMemberBuff cur;
		LinkedList<CFBamSecGroupMemberBuff> matchSet = new LinkedList<CFBamSecGroupMemberBuff>();
		Iterator<CFBamSecGroupMemberBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupMemberBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupMember( Authorization, cur );
		}
	}

	public CFBamCursor openSecGroupMemberCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecGroupMemberCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecGroupMemberCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecGroupMemberByClusterIdxKey key = schema.getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupMemberCursorByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		CFBamCursor cursor;
		CFBamSecGroupMemberByGroupIdxKey key = schema.getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				subdictGroupIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupMemberCursorByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		CFBamCursor cursor;
		CFBamSecGroupMemberByUserIdxKey key = schema.getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamSecGroupMemberPKey, CFBamSecGroupMemberBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				subdictUserIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupMemberCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupMemberBuff >() );
		}
		return( cursor );
	}

	public void closeSecGroupMemberCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecGroupMemberBuff nextSecGroupMemberCursor( CFBamCursor Cursor ) {
		CFBamRamSecGroupMemberCursor cursor = (CFBamRamSecGroupMemberCursor)Cursor;
		CFBamSecGroupMemberBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecGroupMemberBuff prevSecGroupMemberCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecGroupMemberBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupMemberBuff firstSecGroupMemberCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecGroupMemberBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupMemberBuff lastSecGroupMemberCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecGroupMemberCursor" );
	}

	public CFBamSecGroupMemberBuff nthSecGroupMemberCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecGroupMemberBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupMemberCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
