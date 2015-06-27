
// Description: Java7 in-memory RAM DbIO implementation for SecGroupInclude.

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
 *	CFBamRamSecGroupIncludeTable in-memory RAM DbIO implementation
 *	for SecGroupInclude.
 */
public class CFBamRamSecGroupIncludeTable
	implements ICFBamSecGroupIncludeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecGroupIncludePKey,
				CFBamSecGroupIncludeBuff > dictByPKey
		= new HashMap< CFBamSecGroupIncludePKey,
				CFBamSecGroupIncludeBuff >();
	private Map< CFBamSecGroupIncludeByClusterIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >> dictByClusterIdx
		= new HashMap< CFBamSecGroupIncludeByClusterIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >>();
	private Map< CFBamSecGroupIncludeByGroupIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >> dictByGroupIdx
		= new HashMap< CFBamSecGroupIncludeByGroupIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >>();
	private Map< CFBamSecGroupIncludeByIncludeIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >> dictByIncludeIdx
		= new HashMap< CFBamSecGroupIncludeByIncludeIdxKey,
				Map< CFBamSecGroupIncludePKey,
					CFBamSecGroupIncludeBuff >>();
	private Map< CFBamSecGroupIncludeByUIncludeIdxKey,
			CFBamSecGroupIncludeBuff > dictByUIncludeIdx
		= new HashMap< CFBamSecGroupIncludeByUIncludeIdxKey,
			CFBamSecGroupIncludeBuff >();

	public CFBamRamSecGroupIncludeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff )
	{
		final String S_ProcName = "createSecGroupInclude";
		CFBamSecGroupIncludePKey pkey = schema.getFactorySecGroupInclude().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupIncludeId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecGroupIncludeIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupIncludeId( pkey.getRequiredSecGroupIncludeId() );
		CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupInclude().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupInclude().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		keyIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUIncludeIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUIncludeIdx.containsKey( keyUIncludeIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupIncludeUIncludeIdx",
				keyUIncludeIdx );
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
						"SecGroupIncludeCluster",
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
						"SecGroupIncludeGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictIncludeIdx;
		if( dictByIncludeIdx.containsKey( keyIncludeIdx ) ) {
			subdictIncludeIdx = dictByIncludeIdx.get( keyIncludeIdx );
		}
		else {
			subdictIncludeIdx = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByIncludeIdx.put( keyIncludeIdx, subdictIncludeIdx );
		}
		subdictIncludeIdx.put( pkey, Buff );

		dictByUIncludeIdx.put( keyUIncludeIdx, Buff );

	}

	public CFBamSecGroupIncludeBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerived() ";
		CFBamSecGroupIncludePKey key = schema.getFactorySecGroupInclude().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupIncludeId( PKey.getRequiredSecGroupIncludeId() );
		CFBamSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerived() ";
		CFBamSecGroupIncludePKey key = schema.getFactorySecGroupInclude().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupIncludeId( PKey.getRequiredSecGroupIncludeId() );
		CFBamSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecGroupInclude.readAllDerived() ";
		CFBamSecGroupIncludeBuff[] retList = new CFBamSecGroupIncludeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecGroupIncludeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecGroupIncludeBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerivedByClusterIdx() ";
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecGroupIncludeBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecGroupIncludeBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecGroupIncludeBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictClusterIdx
				= new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupIncludeBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerivedByGroupIdx() ";
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFBamSecGroupIncludeBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFBamSecGroupIncludeBuff[ subdictGroupIdx.size() ];
			Iterator< CFBamSecGroupIncludeBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictGroupIdx
				= new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFBamSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupIncludeBuff[] readDerivedByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerivedByIncludeIdx() ";
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFBamSecGroupIncludeBuff[] recArray;
		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			recArray = new CFBamSecGroupIncludeBuff[ subdictIncludeIdx.size() ];
			Iterator< CFBamSecGroupIncludeBuff > iter = subdictIncludeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictIncludeIdx
				= new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByIncludeIdx.put( key, subdictIncludeIdx );
			recArray = new CFBamSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupIncludeBuff readDerivedByUIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerivedByUIncludeIdx() ";
		CFBamSecGroupIncludeByUIncludeIdxKey key = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFBamSecGroupIncludeBuff buff;
		if( dictByUIncludeIdx.containsKey( key ) ) {
			buff = dictByUIncludeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupIncludeId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readDerivedByIdIdx() ";
		CFBamSecGroupIncludePKey key = schema.getFactorySecGroupInclude().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupIncludeId( SecGroupIncludeId );

		CFBamSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuff() ";
		CFBamSecGroupIncludeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuff() ";
		CFBamSecGroupIncludeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupIncludeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readAllBuff() ";
		CFBamSecGroupIncludeBuff buff;
		ArrayList<CFBamSecGroupIncludeBuff> filteredList = new ArrayList<CFBamSecGroupIncludeBuff>();
		CFBamSecGroupIncludeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupIncludeBuff[0] ) );
	}

	public CFBamSecGroupIncludeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupIncludeId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuffByIdIdx() ";
		CFBamSecGroupIncludeBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupIncludeId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
			return( (CFBamSecGroupIncludeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecGroupIncludeBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuffByClusterIdx() ";
		CFBamSecGroupIncludeBuff buff;
		ArrayList<CFBamSecGroupIncludeBuff> filteredList = new ArrayList<CFBamSecGroupIncludeBuff>();
		CFBamSecGroupIncludeBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFBamSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupIncludeBuff[0] ) );
	}

	public CFBamSecGroupIncludeBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuffByGroupIdx() ";
		CFBamSecGroupIncludeBuff buff;
		ArrayList<CFBamSecGroupIncludeBuff> filteredList = new ArrayList<CFBamSecGroupIncludeBuff>();
		CFBamSecGroupIncludeBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFBamSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupIncludeBuff[0] ) );
	}

	public CFBamSecGroupIncludeBuff[] readBuffByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuffByIncludeIdx() ";
		CFBamSecGroupIncludeBuff buff;
		ArrayList<CFBamSecGroupIncludeBuff> filteredList = new ArrayList<CFBamSecGroupIncludeBuff>();
		CFBamSecGroupIncludeBuff[] buffList = readDerivedByIncludeIdx( Authorization,
			ClusterId,
			IncludeGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFBamSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupIncludeBuff[0] ) );
	}

	public CFBamSecGroupIncludeBuff readBuffByUIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupInclude.readBuffByUIncludeIdx() ";
		CFBamSecGroupIncludeBuff buff = readDerivedByUIncludeIdx( Authorization,
			ClusterId,
			SecGroupId,
			IncludeGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
			return( (CFBamSecGroupIncludeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff )
	{
		CFBamSecGroupIncludePKey pkey = schema.getFactorySecGroupInclude().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupIncludeId( Buff.getRequiredSecGroupIncludeId() );
		CFBamSecGroupIncludeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecGroupInclude",
				"Existing record not found",
				"SecGroupInclude",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecGroupInclude",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecGroupIncludeByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroupInclude().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupIncludeByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroupInclude().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupIncludeByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGroupInclude().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupIncludeByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGroupInclude().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupIncludeByIncludeIdxKey existingKeyIncludeIdx = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		existingKeyIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamSecGroupIncludeByIncludeIdxKey newKeyIncludeIdx = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		newKeyIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFBamSecGroupIncludeByUIncludeIdxKey existingKeyUIncludeIdx = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		existingKeyUIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUIncludeIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamSecGroupIncludeByUIncludeIdxKey newKeyUIncludeIdx = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		newKeyUIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUIncludeIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Check unique indexes

		if( ! existingKeyUIncludeIdx.equals( newKeyUIncludeIdx ) ) {
			if( dictByUIncludeIdx.containsKey( newKeyUIncludeIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecGroupInclude",
					"SecGroupIncludeUIncludeIdx",
					newKeyUIncludeIdx );
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
						"updateSecGroupInclude",
						"Owner",
						"SecGroupIncludeCluster",
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
						"updateSecGroupInclude",
						"Container",
						"SecGroupIncludeGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdict;

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
			subdict = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
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
			subdict = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIncludeIdx.get( existingKeyIncludeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIncludeIdx.containsKey( newKeyIncludeIdx ) ) {
			subdict = dictByIncludeIdx.get( newKeyIncludeIdx );
		}
		else {
			subdict = new HashMap< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff >();
			dictByIncludeIdx.put( newKeyIncludeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUIncludeIdx.remove( existingKeyUIncludeIdx );
		dictByUIncludeIdx.put( newKeyUIncludeIdx, Buff );

	}

	public void deleteSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecGroupIncludeTable.deleteSecGroupInclude() ";
		CFBamSecGroupIncludePKey pkey = schema.getFactorySecGroupInclude().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupIncludeId( Buff.getRequiredSecGroupIncludeId() );
		CFBamSecGroupIncludeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecGroupInclude",
				pkey );
		}
		CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupInclude().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupInclude().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		keyIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUIncludeIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByIncludeIdx.get( keyIncludeIdx );
		subdict.remove( pkey );

		dictByUIncludeIdx.remove( keyUIncludeIdx );

	}

	public void deleteSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupIncludeId )
	{
		CFBamSecGroupIncludePKey key = schema.getFactorySecGroupInclude().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupIncludeId( argSecGroupIncludeId );
		deleteSecGroupIncludeByIdIdx( Authorization, key );
	}

	public void deleteSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey argKey )
	{
		CFBamSecGroupIncludeBuff cur;
		LinkedList<CFBamSecGroupIncludeBuff> matchSet = new LinkedList<CFBamSecGroupIncludeBuff>();
		Iterator<CFBamSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteSecGroupIncludeByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupIncludeByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupIncludeByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByClusterIdxKey argKey )
	{
		CFBamSecGroupIncludeBuff cur;
		LinkedList<CFBamSecGroupIncludeBuff> matchSet = new LinkedList<CFBamSecGroupIncludeBuff>();
		Iterator<CFBamSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupIncludeByGroupIdx( Authorization, key );
	}

	public void deleteSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByGroupIdxKey argKey )
	{
		CFBamSecGroupIncludeBuff cur;
		LinkedList<CFBamSecGroupIncludeBuff> matchSet = new LinkedList<CFBamSecGroupIncludeBuff>();
		Iterator<CFBamSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argIncludeGroupId )
	{
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteSecGroupIncludeByIncludeIdx( Authorization, key );
	}

	public void deleteSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByIncludeIdxKey argKey )
	{
		CFBamSecGroupIncludeBuff cur;
		LinkedList<CFBamSecGroupIncludeBuff> matchSet = new LinkedList<CFBamSecGroupIncludeBuff>();
		Iterator<CFBamSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argIncludeGroupId )
	{
		CFBamSecGroupIncludeByUIncludeIdxKey key = schema.getFactorySecGroupInclude().newUIncludeIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteSecGroupIncludeByUIncludeIdx( Authorization, key );
	}

	public void deleteSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByUIncludeIdxKey argKey )
	{
		CFBamSecGroupIncludeBuff cur;
		LinkedList<CFBamSecGroupIncludeBuff> matchSet = new LinkedList<CFBamSecGroupIncludeBuff>();
		Iterator<CFBamSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupInclude( Authorization, cur );
		}
	}

	public CFBamCursor openSecGroupIncludeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecGroupIncludeCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupIncludeCursorByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		CFBamCursor cursor;
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				subdictGroupIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupIncludeCursorByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId )
	{
		CFBamCursor cursor;
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				subdictIncludeIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public void closeSecGroupIncludeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecGroupIncludeBuff nextSecGroupIncludeCursor( CFBamCursor Cursor ) {
		CFBamRamSecGroupIncludeCursor cursor = (CFBamRamSecGroupIncludeCursor)Cursor;
		CFBamSecGroupIncludeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecGroupIncludeBuff prevSecGroupIncludeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecGroupIncludeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupIncludeBuff firstSecGroupIncludeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecGroupIncludeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupIncludeBuff lastSecGroupIncludeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecGroupIncludeCursor" );
	}

	public CFBamSecGroupIncludeBuff nthSecGroupIncludeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecGroupIncludeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
