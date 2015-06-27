
// Description: Java7 in-memory RAM DbIO implementation for SecForm.

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
 *	CFBamRamSecFormTable in-memory RAM DbIO implementation
 *	for SecForm.
 */
public class CFBamRamSecFormTable
	implements ICFBamSecFormTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecFormPKey,
				CFBamSecFormBuff > dictByPKey
		= new HashMap< CFBamSecFormPKey,
				CFBamSecFormBuff >();
	private Map< CFBamSecFormByClusterIdxKey,
				Map< CFBamSecFormPKey,
					CFBamSecFormBuff >> dictByClusterIdx
		= new HashMap< CFBamSecFormByClusterIdxKey,
				Map< CFBamSecFormPKey,
					CFBamSecFormBuff >>();
	private Map< CFBamSecFormBySecAppIdxKey,
				Map< CFBamSecFormPKey,
					CFBamSecFormBuff >> dictBySecAppIdx
		= new HashMap< CFBamSecFormBySecAppIdxKey,
				Map< CFBamSecFormPKey,
					CFBamSecFormBuff >>();
	private Map< CFBamSecFormByUJEEServletIdxKey,
			CFBamSecFormBuff > dictByUJEEServletIdx
		= new HashMap< CFBamSecFormByUJEEServletIdxKey,
			CFBamSecFormBuff >();

	public CFBamRamSecFormTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecForm( CFBamAuthorization Authorization,
		CFBamSecFormBuff Buff )
	{
		final String S_ProcName = "createSecForm";
		CFBamSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( ((CFBamRamClusterTable)schema.getTableCluster()).nextSecFormIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecFormId( pkey.getRequiredSecFormId() );
		CFBamSecFormByClusterIdxKey keyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecFormBySecAppIdxKey keySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		keySecAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keySecAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		keyUJEEServletIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUJEEServletIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		keyUJEEServletIdx.setRequiredJEEServletMapName( Buff.getRequiredJEEServletMapName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUJEEServletIdx.containsKey( keyUJEEServletIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecFormUJEEServletIdx",
				keyUJEEServletIdx );
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
						"SecFormCluster",
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
				if( null == schema.getTableSecApp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecAppId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecFormApplication",
						"SecApp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictSecAppIdx;
		if( dictBySecAppIdx.containsKey( keySecAppIdx ) ) {
			subdictSecAppIdx = dictBySecAppIdx.get( keySecAppIdx );
		}
		else {
			subdictSecAppIdx = new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictBySecAppIdx.put( keySecAppIdx, subdictSecAppIdx );
		}
		subdictSecAppIdx.put( pkey, Buff );

		dictByUJEEServletIdx.put( keyUJEEServletIdx, Buff );

	}

	public CFBamSecFormBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerived() ";
		CFBamSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecFormId( PKey.getRequiredSecFormId() );
		CFBamSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerived() ";
		CFBamSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecFormId( PKey.getRequiredSecFormId() );
		CFBamSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecForm.readAllDerived() ";
		CFBamSecFormBuff[] retList = new CFBamSecFormBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecFormBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecFormBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerivedByClusterIdx() ";
		CFBamSecFormByClusterIdxKey key = schema.getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamSecFormBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamSecFormBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamSecFormBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictClusterIdx
				= new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamSecFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecFormBuff[] readDerivedBySecAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerivedBySecAppIdx() ";
		CFBamSecFormBySecAppIdxKey key = schema.getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFBamSecFormBuff[] recArray;
		if( dictBySecAppIdx.containsKey( key ) ) {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictSecAppIdx
				= dictBySecAppIdx.get( key );
			recArray = new CFBamSecFormBuff[ subdictSecAppIdx.size() ];
			Iterator< CFBamSecFormBuff > iter = subdictSecAppIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictSecAppIdx
				= new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictBySecAppIdx.put( key, subdictSecAppIdx );
			recArray = new CFBamSecFormBuff[0];
		}
		return( recArray );
	}

	public CFBamSecFormBuff readDerivedByUJEEServletIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerivedByUJEEServletIdx() ";
		CFBamSecFormByUJEEServletIdxKey key = schema.getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );

		CFBamSecFormBuff buff;
		if( dictByUJEEServletIdx.containsKey( key ) ) {
			buff = dictByUJEEServletIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecForm.readDerivedByIdIdx() ";
		CFBamSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );

		CFBamSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuff() ";
		CFBamSecFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SFRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecFormPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuff() ";
		CFBamSecFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SFRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecFormBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecForm.readAllBuff() ";
		CFBamSecFormBuff buff;
		ArrayList<CFBamSecFormBuff> filteredList = new ArrayList<CFBamSecFormBuff>();
		CFBamSecFormBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecFormBuff[0] ) );
	}

	public CFBamSecFormBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuffByIdIdx() ";
		CFBamSecFormBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
			return( (CFBamSecFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecFormBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuffByClusterIdx() ";
		CFBamSecFormBuff buff;
		ArrayList<CFBamSecFormBuff> filteredList = new ArrayList<CFBamSecFormBuff>();
		CFBamSecFormBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( (CFBamSecFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecFormBuff[0] ) );
	}

	public CFBamSecFormBuff[] readBuffBySecAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuffBySecAppIdx() ";
		CFBamSecFormBuff buff;
		ArrayList<CFBamSecFormBuff> filteredList = new ArrayList<CFBamSecFormBuff>();
		CFBamSecFormBuff[] buffList = readDerivedBySecAppIdx( Authorization,
			ClusterId,
			SecAppId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( (CFBamSecFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecFormBuff[0] ) );
	}

	public CFBamSecFormBuff readBuffByUJEEServletIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		final String S_ProcName = "CFBamRamSecForm.readBuffByUJEEServletIdx() ";
		CFBamSecFormBuff buff = readDerivedByUJEEServletIdx( Authorization,
			ClusterId,
			SecAppId,
			JEEServletMapName );
		if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
			return( (CFBamSecFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecForm( CFBamAuthorization Authorization,
		CFBamSecFormBuff Buff )
	{
		CFBamSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( Buff.getRequiredSecFormId() );
		CFBamSecFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecForm",
				"Existing record not found",
				"SecForm",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecForm",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecFormByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecFormByClusterIdxKey newKeyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamSecFormBySecAppIdxKey existingKeySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		existingKeySecAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeySecAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFBamSecFormBySecAppIdxKey newKeySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		newKeySecAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeySecAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFBamSecFormByUJEEServletIdxKey existingKeyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		existingKeyUJEEServletIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUJEEServletIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );
		existingKeyUJEEServletIdx.setRequiredJEEServletMapName( existing.getRequiredJEEServletMapName() );

		CFBamSecFormByUJEEServletIdxKey newKeyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		newKeyUJEEServletIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUJEEServletIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		newKeyUJEEServletIdx.setRequiredJEEServletMapName( Buff.getRequiredJEEServletMapName() );

		// Check unique indexes

		if( ! existingKeyUJEEServletIdx.equals( newKeyUJEEServletIdx ) ) {
			if( dictByUJEEServletIdx.containsKey( newKeyUJEEServletIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecForm",
					"SecFormUJEEServletIdx",
					newKeyUJEEServletIdx );
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
						"updateSecForm",
						"Owner",
						"SecFormCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecApp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecAppId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecForm",
						"Container",
						"SecFormApplication",
						"SecApp",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecFormPKey, CFBamSecFormBuff > subdict;

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
			subdict = new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecAppIdx.get( existingKeySecAppIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecAppIdx.containsKey( newKeySecAppIdx ) ) {
			subdict = dictBySecAppIdx.get( newKeySecAppIdx );
		}
		else {
			subdict = new HashMap< CFBamSecFormPKey, CFBamSecFormBuff >();
			dictBySecAppIdx.put( newKeySecAppIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUJEEServletIdx.remove( existingKeyUJEEServletIdx );
		dictByUJEEServletIdx.put( newKeyUJEEServletIdx, Buff );

	}

	public void deleteSecForm( CFBamAuthorization Authorization,
		CFBamSecFormBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecFormTable.deleteSecForm() ";
		CFBamSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( Buff.getRequiredSecFormId() );
		CFBamSecFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecForm",
				pkey );
		}
		CFBamSecFormByClusterIdxKey keyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamSecFormBySecAppIdxKey keySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		keySecAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keySecAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		keyUJEEServletIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUJEEServletIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );
		keyUJEEServletIdx.setRequiredJEEServletMapName( existing.getRequiredJEEServletMapName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecFormPKey, CFBamSecFormBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictBySecAppIdx.get( keySecAppIdx );
		subdict.remove( pkey );

		dictByUJEEServletIdx.remove( keyUJEEServletIdx );

	}

	public void deleteSecFormByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		CFBamSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecFormByIdIdx( Authorization, key );
	}

	public void deleteSecFormByIdIdx( CFBamAuthorization Authorization,
		CFBamSecFormPKey argKey )
	{
		CFBamSecFormBuff cur;
		LinkedList<CFBamSecFormBuff> matchSet = new LinkedList<CFBamSecFormBuff>();
		Iterator<CFBamSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamSecFormByClusterIdxKey key = schema.getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecFormByClusterIdx( Authorization, key );
	}

	public void deleteSecFormByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecFormByClusterIdxKey argKey )
	{
		CFBamSecFormBuff cur;
		LinkedList<CFBamSecFormBuff> matchSet = new LinkedList<CFBamSecFormBuff>();
		Iterator<CFBamSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormBySecAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFBamSecFormBySecAppIdxKey key = schema.getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecFormBySecAppIdx( Authorization, key );
	}

	public void deleteSecFormBySecAppIdx( CFBamAuthorization Authorization,
		CFBamSecFormBySecAppIdxKey argKey )
	{
		CFBamSecFormBuff cur;
		LinkedList<CFBamSecFormBuff> matchSet = new LinkedList<CFBamSecFormBuff>();
		Iterator<CFBamSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormByUJEEServletIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId,
		String argJEEServletMapName )
	{
		CFBamSecFormByUJEEServletIdxKey key = schema.getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		key.setRequiredJEEServletMapName( argJEEServletMapName );
		deleteSecFormByUJEEServletIdx( Authorization, key );
	}

	public void deleteSecFormByUJEEServletIdx( CFBamAuthorization Authorization,
		CFBamSecFormByUJEEServletIdxKey argKey )
	{
		CFBamSecFormBuff cur;
		LinkedList<CFBamSecFormBuff> matchSet = new LinkedList<CFBamSecFormBuff>();
		Iterator<CFBamSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecForm( Authorization, cur );
		}
	}

	public CFBamCursor openSecFormCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecFormCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecFormCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamSecFormByClusterIdxKey key = schema.getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamSecFormCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamSecFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecFormBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecFormCursorBySecAppIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		CFBamCursor cursor;
		CFBamSecFormBySecAppIdxKey key = schema.getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		if( dictBySecAppIdx.containsKey( key ) ) {
			Map< CFBamSecFormPKey, CFBamSecFormBuff > subdictSecAppIdx
				= dictBySecAppIdx.get( key );
			cursor = new CFBamRamSecFormCursor( Authorization,
				schema,
				subdictSecAppIdx.values() );
		}
		else {
			cursor = new CFBamRamSecFormCursor( Authorization,
				schema,
				new ArrayList< CFBamSecFormBuff >() );
		}
		return( cursor );
	}

	public void closeSecFormCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecFormBuff nextSecFormCursor( CFBamCursor Cursor ) {
		CFBamRamSecFormCursor cursor = (CFBamRamSecFormCursor)Cursor;
		CFBamSecFormBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecFormBuff prevSecFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecFormBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecFormCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecFormBuff firstSecFormCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecFormBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecFormCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecFormBuff lastSecFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecFormCursor" );
	}

	public CFBamSecFormBuff nthSecFormCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecFormBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecFormCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
