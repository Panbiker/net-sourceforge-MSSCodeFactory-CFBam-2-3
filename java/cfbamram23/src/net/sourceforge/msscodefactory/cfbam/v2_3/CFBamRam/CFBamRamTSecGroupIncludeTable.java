
// Description: Java7 in-memory RAM DbIO implementation for TSecGroupInclude.

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
 *	CFBamRamTSecGroupIncludeTable in-memory RAM DbIO implementation
 *	for TSecGroupInclude.
 */
public class CFBamRamTSecGroupIncludeTable
	implements ICFBamTSecGroupIncludeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamTSecGroupIncludePKey,
				CFBamTSecGroupIncludeBuff > dictByPKey
		= new HashMap< CFBamTSecGroupIncludePKey,
				CFBamTSecGroupIncludeBuff >();
	private Map< CFBamTSecGroupIncludeByTenantIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >> dictByTenantIdx
		= new HashMap< CFBamTSecGroupIncludeByTenantIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >>();
	private Map< CFBamTSecGroupIncludeByGroupIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >> dictByGroupIdx
		= new HashMap< CFBamTSecGroupIncludeByGroupIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >>();
	private Map< CFBamTSecGroupIncludeByIncludeIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >> dictByIncludeIdx
		= new HashMap< CFBamTSecGroupIncludeByIncludeIdxKey,
				Map< CFBamTSecGroupIncludePKey,
					CFBamTSecGroupIncludeBuff >>();
	private Map< CFBamTSecGroupIncludeByUIncludeIdxKey,
			CFBamTSecGroupIncludeBuff > dictByUIncludeIdx
		= new HashMap< CFBamTSecGroupIncludeByUIncludeIdxKey,
			CFBamTSecGroupIncludeBuff >();

	public CFBamRamTSecGroupIncludeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGroupInclude( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeBuff Buff )
	{
		final String S_ProcName = "createTSecGroupInclude";
		CFBamTSecGroupIncludePKey pkey = schema.getFactoryTSecGroupInclude().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupIncludeId( ((CFBamRamTenantTable)schema.getTableTenant()).nextTSecGroupIncludeIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGroupIncludeId( pkey.getRequiredTSecGroupIncludeId() );
		CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		keyIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUIncludeIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUIncludeIdx.containsKey( keyUIncludeIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGroupIncludeUIncludeIdx",
				keyUIncludeIdx );
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
						"TSecGroupIncludeTenant",
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
						"TSecGroupIncludeGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictIncludeIdx;
		if( dictByIncludeIdx.containsKey( keyIncludeIdx ) ) {
			subdictIncludeIdx = dictByIncludeIdx.get( keyIncludeIdx );
		}
		else {
			subdictIncludeIdx = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByIncludeIdx.put( keyIncludeIdx, subdictIncludeIdx );
		}
		subdictIncludeIdx.put( pkey, Buff );

		dictByUIncludeIdx.put( keyUIncludeIdx, Buff );

	}

	public CFBamTSecGroupIncludeBuff readDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerived() ";
		CFBamTSecGroupIncludePKey key = schema.getFactoryTSecGroupInclude().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupIncludeId( PKey.getRequiredTSecGroupIncludeId() );
		CFBamTSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerived() ";
		CFBamTSecGroupIncludePKey key = schema.getFactoryTSecGroupInclude().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupIncludeId( PKey.getRequiredTSecGroupIncludeId() );
		CFBamTSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTSecGroupInclude.readAllDerived() ";
		CFBamTSecGroupIncludeBuff[] retList = new CFBamTSecGroupIncludeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTSecGroupIncludeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTSecGroupIncludeBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerivedByTenantIdx() ";
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamTSecGroupIncludeBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamTSecGroupIncludeBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamTSecGroupIncludeBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictTenantIdx
				= new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamTSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupIncludeBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerivedByGroupIdx() ";
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFBamTSecGroupIncludeBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFBamTSecGroupIncludeBuff[ subdictGroupIdx.size() ];
			Iterator< CFBamTSecGroupIncludeBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictGroupIdx
				= new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFBamTSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupIncludeBuff[] readDerivedByIncludeIdx( CFBamAuthorization Authorization,
		long TenantId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerivedByIncludeIdx() ";
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFBamTSecGroupIncludeBuff[] recArray;
		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			recArray = new CFBamTSecGroupIncludeBuff[ subdictIncludeIdx.size() ];
			Iterator< CFBamTSecGroupIncludeBuff > iter = subdictIncludeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictIncludeIdx
				= new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByIncludeIdx.put( key, subdictIncludeIdx );
			recArray = new CFBamTSecGroupIncludeBuff[0];
		}
		return( recArray );
	}

	public CFBamTSecGroupIncludeBuff readDerivedByUIncludeIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerivedByUIncludeIdx() ";
		CFBamTSecGroupIncludeByUIncludeIdxKey key = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFBamTSecGroupIncludeBuff buff;
		if( dictByUIncludeIdx.containsKey( key ) ) {
			buff = dictByUIncludeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupIncludeId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readDerivedByIdIdx() ";
		CFBamTSecGroupIncludePKey key = schema.getFactoryTSecGroupInclude().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupIncludeId( TSecGroupIncludeId );

		CFBamTSecGroupIncludeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff readBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuff() ";
		CFBamTSecGroupIncludeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludePKey PKey )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuff() ";
		CFBamTSecGroupIncludeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTSecGroupIncludeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readAllBuff() ";
		CFBamTSecGroupIncludeBuff buff;
		ArrayList<CFBamTSecGroupIncludeBuff> filteredList = new ArrayList<CFBamTSecGroupIncludeBuff>();
		CFBamTSecGroupIncludeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupIncludeBuff[0] ) );
	}

	public CFBamTSecGroupIncludeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupIncludeId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuffByIdIdx() ";
		CFBamTSecGroupIncludeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGroupIncludeId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
			return( (CFBamTSecGroupIncludeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTSecGroupIncludeBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuffByTenantIdx() ";
		CFBamTSecGroupIncludeBuff buff;
		ArrayList<CFBamTSecGroupIncludeBuff> filteredList = new ArrayList<CFBamTSecGroupIncludeBuff>();
		CFBamTSecGroupIncludeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFBamTSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupIncludeBuff[0] ) );
	}

	public CFBamTSecGroupIncludeBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuffByGroupIdx() ";
		CFBamTSecGroupIncludeBuff buff;
		ArrayList<CFBamTSecGroupIncludeBuff> filteredList = new ArrayList<CFBamTSecGroupIncludeBuff>();
		CFBamTSecGroupIncludeBuff[] buffList = readDerivedByGroupIdx( Authorization,
			TenantId,
			TSecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFBamTSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupIncludeBuff[0] ) );
	}

	public CFBamTSecGroupIncludeBuff[] readBuffByIncludeIdx( CFBamAuthorization Authorization,
		long TenantId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuffByIncludeIdx() ";
		CFBamTSecGroupIncludeBuff buff;
		ArrayList<CFBamTSecGroupIncludeBuff> filteredList = new ArrayList<CFBamTSecGroupIncludeBuff>();
		CFBamTSecGroupIncludeBuff[] buffList = readDerivedByIncludeIdx( Authorization,
			TenantId,
			IncludeGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFBamTSecGroupIncludeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTSecGroupIncludeBuff[0] ) );
	}

	public CFBamTSecGroupIncludeBuff readBuffByUIncludeIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFBamRamTSecGroupInclude.readBuffByUIncludeIdx() ";
		CFBamTSecGroupIncludeBuff buff = readDerivedByUIncludeIdx( Authorization,
			TenantId,
			TSecGroupId,
			IncludeGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
			return( (CFBamTSecGroupIncludeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTSecGroupInclude( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeBuff Buff )
	{
		CFBamTSecGroupIncludePKey pkey = schema.getFactoryTSecGroupInclude().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupIncludeId( Buff.getRequiredTSecGroupIncludeId() );
		CFBamTSecGroupIncludeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTSecGroupInclude",
				"Existing record not found",
				"TSecGroupInclude",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateTSecGroupInclude",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamTSecGroupIncludeByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupIncludeByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamTSecGroupIncludeByGroupIdxKey existingKeyGroupIdx = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFBamTSecGroupIncludeByGroupIdxKey newKeyGroupIdx = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		newKeyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFBamTSecGroupIncludeByIncludeIdxKey existingKeyIncludeIdx = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		existingKeyIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamTSecGroupIncludeByIncludeIdxKey newKeyIncludeIdx = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		newKeyIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFBamTSecGroupIncludeByUIncludeIdxKey existingKeyUIncludeIdx = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		existingKeyUIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUIncludeIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		existingKeyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamTSecGroupIncludeByUIncludeIdxKey newKeyUIncludeIdx = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		newKeyUIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUIncludeIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		newKeyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Check unique indexes

		if( ! existingKeyUIncludeIdx.equals( newKeyUIncludeIdx ) ) {
			if( dictByUIncludeIdx.containsKey( newKeyUIncludeIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTSecGroupInclude",
					"TSecGroupIncludeUIncludeIdx",
					newKeyUIncludeIdx );
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
						"updateTSecGroupInclude",
						"Owner",
						"TSecGroupIncludeTenant",
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
						"updateTSecGroupInclude",
						"Container",
						"TSecGroupIncludeGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdict;

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
			subdict = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
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
			subdict = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
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
			subdict = new HashMap< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff >();
			dictByIncludeIdx.put( newKeyIncludeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUIncludeIdx.remove( existingKeyUIncludeIdx );
		dictByUIncludeIdx.put( newKeyUIncludeIdx, Buff );

	}

	public void deleteTSecGroupInclude( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeBuff Buff )
	{
		final String S_ProcName = "CFBamRamTSecGroupIncludeTable.deleteTSecGroupInclude() ";
		CFBamTSecGroupIncludePKey pkey = schema.getFactoryTSecGroupInclude().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupIncludeId( Buff.getRequiredTSecGroupIncludeId() );
		CFBamTSecGroupIncludeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTSecGroupInclude",
				pkey );
		}
		CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		keyIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUIncludeIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByIncludeIdx.get( keyIncludeIdx );
		subdict.remove( pkey );

		dictByUIncludeIdx.remove( keyUIncludeIdx );

	}

	public void deleteTSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTSecGroupIncludeId )
	{
		CFBamTSecGroupIncludePKey key = schema.getFactoryTSecGroupInclude().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupIncludeId( argTSecGroupIncludeId );
		deleteTSecGroupIncludeByIdIdx( Authorization, key );
	}

	public void deleteTSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludePKey argKey )
	{
		CFBamTSecGroupIncludeBuff cur;
		LinkedList<CFBamTSecGroupIncludeBuff> matchSet = new LinkedList<CFBamTSecGroupIncludeBuff>();
		Iterator<CFBamTSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteTSecGroupIncludeByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGroupIncludeByTenantIdx( Authorization, key );
	}

	public void deleteTSecGroupIncludeByTenantIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeByTenantIdxKey argKey )
	{
		CFBamTSecGroupIncludeBuff cur;
		LinkedList<CFBamTSecGroupIncludeBuff> matchSet = new LinkedList<CFBamTSecGroupIncludeBuff>();
		Iterator<CFBamTSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteTSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGroupIncludeByGroupIdx( Authorization, key );
	}

	public void deleteTSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeByGroupIdxKey argKey )
	{
		CFBamTSecGroupIncludeBuff cur;
		LinkedList<CFBamTSecGroupIncludeBuff> matchSet = new LinkedList<CFBamTSecGroupIncludeBuff>();
		Iterator<CFBamTSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteTSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argIncludeGroupId )
	{
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteTSecGroupIncludeByIncludeIdx( Authorization, key );
	}

	public void deleteTSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeByIncludeIdxKey argKey )
	{
		CFBamTSecGroupIncludeBuff cur;
		LinkedList<CFBamTSecGroupIncludeBuff> matchSet = new LinkedList<CFBamTSecGroupIncludeBuff>();
		Iterator<CFBamTSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupInclude( Authorization, cur );
		}
	}

	public void deleteTSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId,
		int argIncludeGroupId )
	{
		CFBamTSecGroupIncludeByUIncludeIdxKey key = schema.getFactoryTSecGroupInclude().newUIncludeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteTSecGroupIncludeByUIncludeIdx( Authorization, key );
	}

	public void deleteTSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupIncludeByUIncludeIdxKey argKey )
	{
		CFBamTSecGroupIncludeBuff cur;
		LinkedList<CFBamTSecGroupIncludeBuff> matchSet = new LinkedList<CFBamTSecGroupIncludeBuff>();
		Iterator<CFBamTSecGroupIncludeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTSecGroupIncludeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTSecGroupInclude( Authorization, cur );
		}
	}

	public CFBamCursor openTSecGroupIncludeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTSecGroupIncludeCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTSecGroupIncludeCursorByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				subdictGroupIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openTSecGroupIncludeCursorByIncludeIdx( CFBamAuthorization Authorization,
		long TenantId,
		int IncludeGroupId )
	{
		CFBamCursor cursor;
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFBamTSecGroupIncludePKey, CFBamTSecGroupIncludeBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				subdictIncludeIdx.values() );
		}
		else {
			cursor = new CFBamRamTSecGroupIncludeCursor( Authorization,
				schema,
				new ArrayList< CFBamTSecGroupIncludeBuff >() );
		}
		return( cursor );
	}

	public void closeTSecGroupIncludeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTSecGroupIncludeBuff nextTSecGroupIncludeCursor( CFBamCursor Cursor ) {
		CFBamRamTSecGroupIncludeCursor cursor = (CFBamRamTSecGroupIncludeCursor)Cursor;
		CFBamTSecGroupIncludeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTSecGroupIncludeBuff prevTSecGroupIncludeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTSecGroupIncludeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupIncludeBuff firstTSecGroupIncludeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTSecGroupIncludeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTSecGroupIncludeBuff lastTSecGroupIncludeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTSecGroupIncludeCursor" );
	}

	public CFBamTSecGroupIncludeBuff nthTSecGroupIncludeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTSecGroupIncludeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTSecGroupIncludeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
