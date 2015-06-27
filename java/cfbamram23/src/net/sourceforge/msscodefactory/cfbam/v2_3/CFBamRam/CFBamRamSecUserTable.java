
// Description: Java7 in-memory RAM DbIO implementation for SecUser.

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
 *	CFBamRamSecUserTable in-memory RAM DbIO implementation
 *	for SecUser.
 */
public class CFBamRamSecUserTable
	implements ICFBamSecUserTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecUserPKey,
				CFBamSecUserBuff > dictByPKey
		= new HashMap< CFBamSecUserPKey,
				CFBamSecUserBuff >();
	private Map< CFBamSecUserByULoginIdxKey,
			CFBamSecUserBuff > dictByULoginIdx
		= new HashMap< CFBamSecUserByULoginIdxKey,
			CFBamSecUserBuff >();
	private Map< CFBamSecUserByEMConfIdxKey,
				Map< CFBamSecUserPKey,
					CFBamSecUserBuff >> dictByEMConfIdx
		= new HashMap< CFBamSecUserByEMConfIdxKey,
				Map< CFBamSecUserPKey,
					CFBamSecUserBuff >>();
	private Map< CFBamSecUserByPwdResetIdxKey,
				Map< CFBamSecUserPKey,
					CFBamSecUserBuff >> dictByPwdResetIdx
		= new HashMap< CFBamSecUserByPwdResetIdxKey,
				Map< CFBamSecUserPKey,
					CFBamSecUserBuff >>();
	private Map< CFBamSecUserByDefDevIdxKey,
			CFBamSecUserBuff > dictByDefDevIdx
		= new HashMap< CFBamSecUserByDefDevIdxKey,
			CFBamSecUserBuff >();

	public CFBamRamSecUserTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		final String S_ProcName = "createSecUser";
		CFBamSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( schema.nextSecUserIdGen() );
		Buff.setRequiredSecUserId( pkey.getRequiredSecUserId() );
		CFBamSecUserByULoginIdxKey keyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		CFBamSecUserByEMConfIdxKey keyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		keyEMConfIdx.setOptionalEMailConfirmationUuid( Buff.getOptionalEMailConfirmationUuid() );

		CFBamSecUserByPwdResetIdxKey keyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		keyPwdResetIdx.setOptionalPasswordResetUuid( Buff.getOptionalPasswordResetUuid() );

		CFBamSecUserByDefDevIdxKey keyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		keyDefDevIdx.setOptionalDefaultDevSecUserId( Buff.getOptionalDefaultDevSecUserId() );
		keyDefDevIdx.setOptionalDefaultDevName( Buff.getOptionalDefaultDevName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByULoginIdx.containsKey( keyULoginIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserLoginIdx",
				keyULoginIdx );
		}

		if( dictByDefDevIdx.containsKey( keyDefDevIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserDefDevIdx",
				keyDefDevIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.put( keyULoginIdx, Buff );

		Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictEMConfIdx;
		if( dictByEMConfIdx.containsKey( keyEMConfIdx ) ) {
			subdictEMConfIdx = dictByEMConfIdx.get( keyEMConfIdx );
		}
		else {
			subdictEMConfIdx = new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByEMConfIdx.put( keyEMConfIdx, subdictEMConfIdx );
		}
		subdictEMConfIdx.put( pkey, Buff );

		Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictPwdResetIdx;
		if( dictByPwdResetIdx.containsKey( keyPwdResetIdx ) ) {
			subdictPwdResetIdx = dictByPwdResetIdx.get( keyPwdResetIdx );
		}
		else {
			subdictPwdResetIdx = new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByPwdResetIdx.put( keyPwdResetIdx, subdictPwdResetIdx );
		}
		subdictPwdResetIdx.put( pkey, Buff );

		dictByDefDevIdx.put( keyDefDevIdx, Buff );

	}

	public CFBamSecUserBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerived() ";
		CFBamSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		CFBamSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerived() ";
		CFBamSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		CFBamSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecUser.readAllDerived() ";
		CFBamSecUserBuff[] retList = new CFBamSecUserBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecUserBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecUserBuff readDerivedByULoginIdx( CFBamAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerivedByULoginIdx() ";
		CFBamSecUserByULoginIdxKey key = schema.getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );

		CFBamSecUserBuff buff;
		if( dictByULoginIdx.containsKey( key ) ) {
			buff = dictByULoginIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff[] readDerivedByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerivedByEMConfIdx() ";
		CFBamSecUserByEMConfIdxKey key = schema.getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( EMailConfirmationUuid );

		CFBamSecUserBuff[] recArray;
		if( dictByEMConfIdx.containsKey( key ) ) {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictEMConfIdx
				= dictByEMConfIdx.get( key );
			recArray = new CFBamSecUserBuff[ subdictEMConfIdx.size() ];
			Iterator< CFBamSecUserBuff > iter = subdictEMConfIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictEMConfIdx
				= new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByEMConfIdx.put( key, subdictEMConfIdx );
			recArray = new CFBamSecUserBuff[0];
		}
		return( recArray );
	}

	public CFBamSecUserBuff[] readDerivedByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerivedByPwdResetIdx() ";
		CFBamSecUserByPwdResetIdxKey key = schema.getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );

		CFBamSecUserBuff[] recArray;
		if( dictByPwdResetIdx.containsKey( key ) ) {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictPwdResetIdx
				= dictByPwdResetIdx.get( key );
			recArray = new CFBamSecUserBuff[ subdictPwdResetIdx.size() ];
			Iterator< CFBamSecUserBuff > iter = subdictPwdResetIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictPwdResetIdx
				= new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByPwdResetIdx.put( key, subdictPwdResetIdx );
			recArray = new CFBamSecUserBuff[0];
		}
		return( recArray );
	}

	public CFBamSecUserBuff readDerivedByDefDevIdx( CFBamAuthorization Authorization,
		UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerivedByDefDevIdx() ";
		CFBamSecUserByDefDevIdxKey key = schema.getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDefaultDevSecUserId( DefaultDevSecUserId );
		key.setOptionalDefaultDevName( DefaultDevName );

		CFBamSecUserBuff buff;
		if( dictByDefDevIdx.containsKey( key ) ) {
			buff = dictByDefDevIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecUser.readDerivedByIdIdx() ";
		CFBamSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( SecUserId );

		CFBamSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuff() ";
		CFBamSecUserBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SUSR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecUserPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuff() ";
		CFBamSecUserBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SUSR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecUserBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecUser.readAllBuff() ";
		CFBamSecUserBuff buff;
		ArrayList<CFBamSecUserBuff> filteredList = new ArrayList<CFBamSecUserBuff>();
		CFBamSecUserBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecUserBuff[0] ) );
	}

	public CFBamSecUserBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuffByIdIdx() ";
		CFBamSecUserBuff buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
			return( (CFBamSecUserBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecUserBuff readBuffByULoginIdx( CFBamAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuffByULoginIdx() ";
		CFBamSecUserBuff buff = readDerivedByULoginIdx( Authorization,
			LoginId );
		if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
			return( (CFBamSecUserBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecUserBuff[] readBuffByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuffByEMConfIdx() ";
		CFBamSecUserBuff buff;
		ArrayList<CFBamSecUserBuff> filteredList = new ArrayList<CFBamSecUserBuff>();
		CFBamSecUserBuff[] buffList = readDerivedByEMConfIdx( Authorization,
			EMailConfirmationUuid );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( (CFBamSecUserBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecUserBuff[0] ) );
	}

	public CFBamSecUserBuff[] readBuffByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuffByPwdResetIdx() ";
		CFBamSecUserBuff buff;
		ArrayList<CFBamSecUserBuff> filteredList = new ArrayList<CFBamSecUserBuff>();
		CFBamSecUserBuff[] buffList = readDerivedByPwdResetIdx( Authorization,
			PasswordResetUuid );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( (CFBamSecUserBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecUserBuff[0] ) );
	}

	public CFBamSecUserBuff readBuffByDefDevIdx( CFBamAuthorization Authorization,
		UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		final String S_ProcName = "CFBamRamSecUser.readBuffByDefDevIdx() ";
		CFBamSecUserBuff buff = readDerivedByDefDevIdx( Authorization,
			DefaultDevSecUserId,
			DefaultDevName );
		if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
			return( (CFBamSecUserBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		CFBamSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		CFBamSecUserBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecUser",
				"Existing record not found",
				"SecUser",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecUser",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecUserByULoginIdxKey existingKeyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		existingKeyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		CFBamSecUserByULoginIdxKey newKeyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		newKeyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		CFBamSecUserByEMConfIdxKey existingKeyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		existingKeyEMConfIdx.setOptionalEMailConfirmationUuid( existing.getOptionalEMailConfirmationUuid() );

		CFBamSecUserByEMConfIdxKey newKeyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		newKeyEMConfIdx.setOptionalEMailConfirmationUuid( Buff.getOptionalEMailConfirmationUuid() );

		CFBamSecUserByPwdResetIdxKey existingKeyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		existingKeyPwdResetIdx.setOptionalPasswordResetUuid( existing.getOptionalPasswordResetUuid() );

		CFBamSecUserByPwdResetIdxKey newKeyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		newKeyPwdResetIdx.setOptionalPasswordResetUuid( Buff.getOptionalPasswordResetUuid() );

		CFBamSecUserByDefDevIdxKey existingKeyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		existingKeyDefDevIdx.setOptionalDefaultDevSecUserId( existing.getOptionalDefaultDevSecUserId() );
		existingKeyDefDevIdx.setOptionalDefaultDevName( existing.getOptionalDefaultDevName() );

		CFBamSecUserByDefDevIdxKey newKeyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		newKeyDefDevIdx.setOptionalDefaultDevSecUserId( Buff.getOptionalDefaultDevSecUserId() );
		newKeyDefDevIdx.setOptionalDefaultDevName( Buff.getOptionalDefaultDevName() );

		// Check unique indexes

		if( ! existingKeyULoginIdx.equals( newKeyULoginIdx ) ) {
			if( dictByULoginIdx.containsKey( newKeyULoginIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecUser",
					"SecUserLoginIdx",
					newKeyULoginIdx );
			}
		}

		if( ! existingKeyDefDevIdx.equals( newKeyDefDevIdx ) ) {
			if( dictByDefDevIdx.containsKey( newKeyDefDevIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecUser",
					"SecUserDefDevIdx",
					newKeyDefDevIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamSecUserPKey, CFBamSecUserBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.remove( existingKeyULoginIdx );
		dictByULoginIdx.put( newKeyULoginIdx, Buff );

		subdict = dictByEMConfIdx.get( existingKeyEMConfIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEMConfIdx.containsKey( newKeyEMConfIdx ) ) {
			subdict = dictByEMConfIdx.get( newKeyEMConfIdx );
		}
		else {
			subdict = new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByEMConfIdx.put( newKeyEMConfIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPwdResetIdx.get( existingKeyPwdResetIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPwdResetIdx.containsKey( newKeyPwdResetIdx ) ) {
			subdict = dictByPwdResetIdx.get( newKeyPwdResetIdx );
		}
		else {
			subdict = new HashMap< CFBamSecUserPKey, CFBamSecUserBuff >();
			dictByPwdResetIdx.put( newKeyPwdResetIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByDefDevIdx.remove( existingKeyDefDevIdx );
		dictByDefDevIdx.put( newKeyDefDevIdx, Buff );

	}

	public void deleteSecUser( CFBamAuthorization Authorization,
		CFBamSecUserBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecUserTable.deleteSecUser() ";
		CFBamSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		CFBamSecUserBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecUser",
				pkey );
		}
		CFBamSecUserByULoginIdxKey keyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		CFBamSecUserByEMConfIdxKey keyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		keyEMConfIdx.setOptionalEMailConfirmationUuid( existing.getOptionalEMailConfirmationUuid() );

		CFBamSecUserByPwdResetIdxKey keyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		keyPwdResetIdx.setOptionalPasswordResetUuid( existing.getOptionalPasswordResetUuid() );

		CFBamSecUserByDefDevIdxKey keyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		keyDefDevIdx.setOptionalDefaultDevSecUserId( existing.getOptionalDefaultDevSecUserId() );
		keyDefDevIdx.setOptionalDefaultDevName( existing.getOptionalDefaultDevName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableSecDevice().deleteSecDeviceByUserIdx( Authorization,
			Buff.getRequiredSecUserId() );
		schema.getTableSecSession().deleteSecSessionBySecUserIdx( Authorization,
			Buff.getRequiredSecUserId() );
		schema.getTableSecSession().deleteSecSessionBySecProxyIdx( Authorization,
			Buff.getRequiredSecUserId() );
		schema.getTableSecGroupMember().deleteSecGroupMemberByUserIdx( Authorization,
			Buff.getRequiredSecUserId() );
		schema.getTableTSecGroupMember().deleteTSecGroupMemberByUserIdx( Authorization,
			Buff.getRequiredSecUserId() );
		Map< CFBamSecUserPKey, CFBamSecUserBuff > subdict;

		dictByPKey.remove( pkey );

		dictByULoginIdx.remove( keyULoginIdx );

		subdict = dictByEMConfIdx.get( keyEMConfIdx );
		subdict.remove( pkey );

		subdict = dictByPwdResetIdx.get( keyPwdResetIdx );
		subdict.remove( pkey );

		dictByDefDevIdx.remove( keyDefDevIdx );

	}

	public void deleteSecUserByIdIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		CFBamSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecUserByIdIdx( Authorization, key );
	}

	public void deleteSecUserByIdIdx( CFBamAuthorization Authorization,
		CFBamSecUserPKey argKey )
	{
		CFBamSecUserBuff cur;
		LinkedList<CFBamSecUserBuff> matchSet = new LinkedList<CFBamSecUserBuff>();
		Iterator<CFBamSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByULoginIdx( CFBamAuthorization Authorization,
		String argLoginId )
	{
		CFBamSecUserByULoginIdxKey key = schema.getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecUserByULoginIdx( Authorization, key );
	}

	public void deleteSecUserByULoginIdx( CFBamAuthorization Authorization,
		CFBamSecUserByULoginIdxKey argKey )
	{
		CFBamSecUserBuff cur;
		LinkedList<CFBamSecUserBuff> matchSet = new LinkedList<CFBamSecUserBuff>();
		Iterator<CFBamSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByEMConfIdx( CFBamAuthorization Authorization,
		UUID argEMailConfirmationUuid )
	{
		CFBamSecUserByEMConfIdxKey key = schema.getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( argEMailConfirmationUuid );
		deleteSecUserByEMConfIdx( Authorization, key );
	}

	public void deleteSecUserByEMConfIdx( CFBamAuthorization Authorization,
		CFBamSecUserByEMConfIdxKey argKey )
	{
		CFBamSecUserBuff cur;
		LinkedList<CFBamSecUserBuff> matchSet = new LinkedList<CFBamSecUserBuff>();
		Iterator<CFBamSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByPwdResetIdx( CFBamAuthorization Authorization,
		UUID argPasswordResetUuid )
	{
		CFBamSecUserByPwdResetIdxKey key = schema.getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( argPasswordResetUuid );
		deleteSecUserByPwdResetIdx( Authorization, key );
	}

	public void deleteSecUserByPwdResetIdx( CFBamAuthorization Authorization,
		CFBamSecUserByPwdResetIdxKey argKey )
	{
		CFBamSecUserBuff cur;
		LinkedList<CFBamSecUserBuff> matchSet = new LinkedList<CFBamSecUserBuff>();
		Iterator<CFBamSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByDefDevIdx( CFBamAuthorization Authorization,
		UUID argDefaultDevSecUserId,
		String argDefaultDevName )
	{
		CFBamSecUserByDefDevIdxKey key = schema.getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDefaultDevSecUserId( argDefaultDevSecUserId );
		key.setOptionalDefaultDevName( argDefaultDevName );
		deleteSecUserByDefDevIdx( Authorization, key );
	}

	public void deleteSecUserByDefDevIdx( CFBamAuthorization Authorization,
		CFBamSecUserByDefDevIdxKey argKey )
	{
		CFBamSecUserBuff cur;
		LinkedList<CFBamSecUserBuff> matchSet = new LinkedList<CFBamSecUserBuff>();
		Iterator<CFBamSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecUser( Authorization, cur );
		}
	}

	public CFBamCursor openSecUserCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecUserCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecUserCursorByEMConfIdx( CFBamAuthorization Authorization,
		UUID EMailConfirmationUuid )
	{
		CFBamCursor cursor;
		CFBamSecUserByEMConfIdxKey key = schema.getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( EMailConfirmationUuid );

		if( dictByEMConfIdx.containsKey( key ) ) {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictEMConfIdx
				= dictByEMConfIdx.get( key );
			cursor = new CFBamRamSecUserCursor( Authorization,
				schema,
				subdictEMConfIdx.values() );
		}
		else {
			cursor = new CFBamRamSecUserCursor( Authorization,
				schema,
				new ArrayList< CFBamSecUserBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecUserCursorByPwdResetIdx( CFBamAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		CFBamCursor cursor;
		CFBamSecUserByPwdResetIdxKey key = schema.getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );

		if( dictByPwdResetIdx.containsKey( key ) ) {
			Map< CFBamSecUserPKey, CFBamSecUserBuff > subdictPwdResetIdx
				= dictByPwdResetIdx.get( key );
			cursor = new CFBamRamSecUserCursor( Authorization,
				schema,
				subdictPwdResetIdx.values() );
		}
		else {
			cursor = new CFBamRamSecUserCursor( Authorization,
				schema,
				new ArrayList< CFBamSecUserBuff >() );
		}
		return( cursor );
	}

	public void closeSecUserCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecUserBuff nextSecUserCursor( CFBamCursor Cursor ) {
		CFBamRamSecUserCursor cursor = (CFBamRamSecUserCursor)Cursor;
		CFBamSecUserBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecUserBuff prevSecUserCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecUserBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecUserCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecUserBuff firstSecUserCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecUserBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecUserCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecUserBuff lastSecUserCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecUserCursor" );
	}

	public CFBamSecUserBuff nthSecUserCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecUserBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecUserCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
