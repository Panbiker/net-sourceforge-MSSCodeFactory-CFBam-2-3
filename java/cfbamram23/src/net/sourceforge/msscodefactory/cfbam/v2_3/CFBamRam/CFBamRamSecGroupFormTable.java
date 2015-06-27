
// Description: Java7 in-memory RAM DbIO implementation for SecGroupForm.

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
 *	CFBamRamSecGroupFormTable in-memory RAM DbIO implementation
 *	for SecGroupForm.
 */
public class CFBamRamSecGroupFormTable
	implements ICFBamSecGroupFormTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecGroupFormPKey,
				CFBamSecGroupFormBuff > dictByPKey
		= new HashMap< CFBamSecGroupFormPKey,
				CFBamSecGroupFormBuff >();
	private Map< CFBamSecGroupFormByClusterIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >> dictByClusterIdx
		= new HashMap< CFBamSecGroupFormByClusterIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >>();
	private Map< CFBamSecGroupFormByGroupIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >> dictByGroupIdx
		= new HashMap< CFBamSecGroupFormByGroupIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >>();
	private Map< CFBamSecGroupFormByAppIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >> dictByAppIdx
		= new HashMap< CFBamSecGroupFormByAppIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >>();
	private Map< CFBamSecGroupFormByFormIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >> dictByFormIdx
		= new HashMap< CFBamSecGroupFormByFormIdxKey,
				Map< CFBamSecGroupFormPKey,
					CFBamSecGroupFormBuff >>();
	private Map< CFBamSecGroupFormByUFormIdxKey,
			CFBamSecGroupFormBuff > dictByUFormIdx
		= new HashMap< CFBamSecGroupFormByUFormIdxKey,
			CFBamSecGroupFormBuff >();

	public CFBamRamSecGroupFormTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "createSecGroupForm";
		CFBamSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecGroupFormIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupFormId( pkey.getRequiredSecGroupFormId() );
		CFBamSecGroupFormByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupFormByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupFormByAppIdxKey keyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		keyAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFBamSecGroupFormByFormIdxKey keyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		keyFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		CFBamSecGroupFormByUFormIdxKey keyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		keyUFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUFormIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUFormIdx.containsKey( keyUFormIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupFormUFormIdx",
				keyUFormIdx );
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
						"SecGroupFormCluster",
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
						"SecGroupFormGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictAppIdx;
		if( dictByAppIdx.containsKey( keyAppIdx ) ) {
			subdictAppIdx = dictByAppIdx.get( keyAppIdx );
		}
		else {
			subdictAppIdx = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByAppIdx.put( keyAppIdx, subdictAppIdx );
		}
		subdictAppIdx.put( pkey, Buff );

		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictFormIdx;
		if( dictByFormIdx.containsKey( keyFormIdx ) ) {
			subdictFormIdx = dictByFormIdx.get( keyFormIdx );
		}
		else {
			subdictFormIdx = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByFormIdx.put( keyFormIdx, subdictFormIdx );
		}
		subdictFormIdx.put( pkey, Buff );

		dictByUFormIdx.put( keyUFormIdx, Buff );

	}

	public CFBamSecGroupFormBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerived() ";
		CFBamSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupFormId( PKey.getRequiredSecGroupFormId() );
		CFBamSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerived() ";
		CFBamSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupFormId( PKey.getRequiredSecGroupFormId() );
		CFBamSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecGroupForm.readAllDerived() ";
		CFBamSecGroupFormBuff[] retList = new CFBamSecGroupFormBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecGroupFormBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecGroupFormBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByClusterIdx() ";
		CFBamSecGroupFormByClusterIdxKey key = schema.getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecGroupFormBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecGroupFormBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecGroupFormBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictClusterIdx
				= new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupFormBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByGroupIdx() ";
		CFBamSecGroupFormByGroupIdxKey key = schema.getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFBamSecGroupFormBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFBamSecGroupFormBuff[ subdictGroupIdx.size() ];
			Iterator< CFBamSecGroupFormBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictGroupIdx
				= new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFBamSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupFormBuff[] readDerivedByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByAppIdx() ";
		CFBamSecGroupFormByAppIdxKey key = schema.getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFBamSecGroupFormBuff[] recArray;
		if( dictByAppIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictAppIdx
				= dictByAppIdx.get( key );
			recArray = new CFBamSecGroupFormBuff[ subdictAppIdx.size() ];
			Iterator< CFBamSecGroupFormBuff > iter = subdictAppIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictAppIdx
				= new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByAppIdx.put( key, subdictAppIdx );
			recArray = new CFBamSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupFormBuff[] readDerivedByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByFormIdx() ";
		CFBamSecGroupFormByFormIdxKey key = schema.getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );

		CFBamSecGroupFormBuff[] recArray;
		if( dictByFormIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictFormIdx
				= dictByFormIdx.get( key );
			recArray = new CFBamSecGroupFormBuff[ subdictFormIdx.size() ];
			Iterator< CFBamSecGroupFormBuff > iter = subdictFormIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictFormIdx
				= new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByFormIdx.put( key, subdictFormIdx );
			recArray = new CFBamSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecGroupFormBuff readDerivedByUFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByUFormIdx() ";
		CFBamSecGroupFormByUFormIdxKey key = schema.getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );

		CFBamSecGroupFormBuff buff;
		if( dictByUFormIdx.containsKey( key ) ) {
			buff = dictByUFormIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readDerivedByIdIdx() ";
		CFBamSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupFormId( SecGroupFormId );

		CFBamSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuff() ";
		CFBamSecGroupFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGFM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuff() ";
		CFBamSecGroupFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGFM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readAllBuff() ";
		CFBamSecGroupFormBuff buff;
		ArrayList<CFBamSecGroupFormBuff> filteredList = new ArrayList<CFBamSecGroupFormBuff>();
		CFBamSecGroupFormBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupFormBuff[0] ) );
	}

	public CFBamSecGroupFormBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByIdIdx() ";
		CFBamSecGroupFormBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
			return( (CFBamSecGroupFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecGroupFormBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByClusterIdx() ";
		CFBamSecGroupFormBuff buff;
		ArrayList<CFBamSecGroupFormBuff> filteredList = new ArrayList<CFBamSecGroupFormBuff>();
		CFBamSecGroupFormBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFBamSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupFormBuff[0] ) );
	}

	public CFBamSecGroupFormBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByGroupIdx() ";
		CFBamSecGroupFormBuff buff;
		ArrayList<CFBamSecGroupFormBuff> filteredList = new ArrayList<CFBamSecGroupFormBuff>();
		CFBamSecGroupFormBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFBamSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupFormBuff[0] ) );
	}

	public CFBamSecGroupFormBuff[] readBuffByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByAppIdx() ";
		CFBamSecGroupFormBuff buff;
		ArrayList<CFBamSecGroupFormBuff> filteredList = new ArrayList<CFBamSecGroupFormBuff>();
		CFBamSecGroupFormBuff[] buffList = readDerivedByAppIdx( Authorization,
			ClusterId,
			SecAppId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFBamSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupFormBuff[0] ) );
	}

	public CFBamSecGroupFormBuff[] readBuffByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByFormIdx() ";
		CFBamSecGroupFormBuff buff;
		ArrayList<CFBamSecGroupFormBuff> filteredList = new ArrayList<CFBamSecGroupFormBuff>();
		CFBamSecGroupFormBuff[] buffList = readDerivedByFormIdx( Authorization,
			ClusterId,
			SecFormId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFBamSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecGroupFormBuff[0] ) );
	}

	public CFBamSecGroupFormBuff readBuffByUFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecGroupForm.readBuffByUFormIdx() ";
		CFBamSecGroupFormBuff buff = readDerivedByUFormIdx( Authorization,
			ClusterId,
			SecGroupId,
			SecFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
			return( (CFBamSecGroupFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		CFBamSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( Buff.getRequiredSecGroupFormId() );
		CFBamSecGroupFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecGroupForm",
				"Existing record not found",
				"SecGroupForm",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecGroupForm",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecGroupFormByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupFormByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecGroupFormByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupFormByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFBamSecGroupFormByAppIdxKey existingKeyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		existingKeyAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFBamSecGroupFormByAppIdxKey newKeyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		newKeyAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFBamSecGroupFormByFormIdxKey existingKeyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		existingKeyFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFBamSecGroupFormByFormIdxKey newKeyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		newKeyFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		CFBamSecGroupFormByUFormIdxKey existingKeyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		existingKeyUFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUFormIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFBamSecGroupFormByUFormIdxKey newKeyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		newKeyUFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUFormIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		// Check unique indexes

		if( ! existingKeyUFormIdx.equals( newKeyUFormIdx ) ) {
			if( dictByUFormIdx.containsKey( newKeyUFormIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecGroupForm",
					"SecGroupFormUFormIdx",
					newKeyUFormIdx );
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
						"updateSecGroupForm",
						"Owner",
						"SecGroupFormCluster",
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
						"updateSecGroupForm",
						"Container",
						"SecGroupFormGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdict;

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
			subdict = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
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
			subdict = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByAppIdx.get( existingKeyAppIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByAppIdx.containsKey( newKeyAppIdx ) ) {
			subdict = dictByAppIdx.get( newKeyAppIdx );
		}
		else {
			subdict = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByAppIdx.put( newKeyAppIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFormIdx.get( existingKeyFormIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFormIdx.containsKey( newKeyFormIdx ) ) {
			subdict = dictByFormIdx.get( newKeyFormIdx );
		}
		else {
			subdict = new HashMap< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff >();
			dictByFormIdx.put( newKeyFormIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUFormIdx.remove( existingKeyUFormIdx );
		dictByUFormIdx.put( newKeyUFormIdx, Buff );

	}

	public void deleteSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecGroupFormTable.deleteSecGroupForm() ";
		CFBamSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( Buff.getRequiredSecGroupFormId() );
		CFBamSecGroupFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecGroupForm",
				pkey );
		}
		CFBamSecGroupFormByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecGroupFormByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFBamSecGroupFormByAppIdxKey keyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		keyAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFBamSecGroupFormByFormIdxKey keyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		keyFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFBamSecGroupFormByUFormIdxKey keyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		keyUFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUFormIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByAppIdx.get( keyAppIdx );
		subdict.remove( pkey );

		subdict = dictByFormIdx.get( keyFormIdx );
		subdict.remove( pkey );

		dictByUFormIdx.remove( keyUFormIdx );

	}

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		CFBamSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupFormId( argSecGroupFormId );
		deleteSecGroupFormByIdIdx( Authorization, key );
	}

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecGroupFormByClusterIdxKey key = schema.getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupFormByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByClusterIdxKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFBamSecGroupFormByGroupIdxKey key = schema.getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupFormByGroupIdx( Authorization, key );
	}

	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByGroupIdxKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFBamSecGroupFormByAppIdxKey key = schema.getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecGroupFormByAppIdx( Authorization, key );
	}

	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByAppIdxKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		CFBamSecGroupFormByFormIdxKey key = schema.getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecGroupFormByFormIdx( Authorization, key );
	}

	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByFormIdxKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		CFBamSecGroupFormByUFormIdxKey key = schema.getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecGroupFormByUFormIdx( Authorization, key );
	}

	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByUFormIdxKey argKey )
	{
		CFBamSecGroupFormBuff cur;
		LinkedList<CFBamSecGroupFormBuff> matchSet = new LinkedList<CFBamSecGroupFormBuff>();
		Iterator<CFBamSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public CFBamCursor openSecGroupFormCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecGroupFormCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecGroupFormByClusterIdxKey key = schema.getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupFormBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		CFBamCursor cursor;
		CFBamSecGroupFormByGroupIdxKey key = schema.getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				subdictGroupIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupFormBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		CFBamCursor cursor;
		CFBamSecGroupFormByAppIdxKey key = schema.getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		if( dictByAppIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictAppIdx
				= dictByAppIdx.get( key );
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				subdictAppIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupFormBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecGroupFormCursorByFormIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		CFBamCursor cursor;
		CFBamSecGroupFormByFormIdxKey key = schema.getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );

		if( dictByFormIdx.containsKey( key ) ) {
			Map< CFBamSecGroupFormPKey, CFBamSecGroupFormBuff > subdictFormIdx
				= dictByFormIdx.get( key );
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				subdictFormIdx.values() );
		}
		else {
			cursor = new CFBamRamSecGroupFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecGroupFormBuff >() );
		}
		return( cursor );
	}

	public void closeSecGroupFormCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecGroupFormBuff nextSecGroupFormCursor( CFBamCursor Cursor ) {
		CFBamRamSecGroupFormCursor cursor = (CFBamRamSecGroupFormCursor)Cursor;
		CFBamSecGroupFormBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecGroupFormBuff prevSecGroupFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecGroupFormBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupFormCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupFormBuff firstSecGroupFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecGroupFormBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupFormCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecGroupFormBuff lastSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff nthSecGroupFormCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecGroupFormBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecGroupFormCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
