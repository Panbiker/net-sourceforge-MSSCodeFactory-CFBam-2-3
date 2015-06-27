
// Description: Java7 in-memory RAM DbIO implementation for SecSession.

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
 *	CFBamRamSecSessionTable in-memory RAM DbIO implementation
 *	for SecSession.
 */
public class CFBamRamSecSessionTable
	implements ICFBamSecSessionTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecSessionPKey,
				CFBamSecSessionBuff > dictByPKey
		= new HashMap< CFBamSecSessionPKey,
				CFBamSecSessionBuff >();
	private Map< CFBamSecSessionBySecUserIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >> dictBySecUserIdx
		= new HashMap< CFBamSecSessionBySecUserIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >>();
	private Map< CFBamSecSessionBySecDevIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >> dictBySecDevIdx
		= new HashMap< CFBamSecSessionBySecDevIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >>();
	private Map< CFBamSecSessionByStartIdxKey,
			CFBamSecSessionBuff > dictByStartIdx
		= new HashMap< CFBamSecSessionByStartIdxKey,
			CFBamSecSessionBuff >();
	private Map< CFBamSecSessionByFinishIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >> dictByFinishIdx
		= new HashMap< CFBamSecSessionByFinishIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >>();
	private Map< CFBamSecSessionBySecProxyIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >> dictBySecProxyIdx
		= new HashMap< CFBamSecSessionBySecProxyIdxKey,
				Map< CFBamSecSessionPKey,
					CFBamSecSessionBuff >>();

	public CFBamRamSecSessionTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		final String S_ProcName = "createSecSession";
		CFBamSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( schema.nextSecSessionIdGen() );
		Buff.setRequiredSecSessionId( pkey.getRequiredSecSessionId() );
		CFBamSecSessionBySecUserIdxKey keySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamSecSessionBySecDevIdxKey keySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		keySecDevIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keySecDevIdx.setOptionalSecDevName( Buff.getOptionalSecDevName() );

		CFBamSecSessionByStartIdxKey keyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		keyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		CFBamSecSessionByFinishIdxKey keyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		CFBamSecSessionBySecProxyIdxKey keySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByStartIdx.containsKey( keyStartIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SessionStartIdx",
				keyStartIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecSessionUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecUserIdx;
		if( dictBySecUserIdx.containsKey( keySecUserIdx ) ) {
			subdictSecUserIdx = dictBySecUserIdx.get( keySecUserIdx );
		}
		else {
			subdictSecUserIdx = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecUserIdx.put( keySecUserIdx, subdictSecUserIdx );
		}
		subdictSecUserIdx.put( pkey, Buff );

		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecDevIdx;
		if( dictBySecDevIdx.containsKey( keySecDevIdx ) ) {
			subdictSecDevIdx = dictBySecDevIdx.get( keySecDevIdx );
		}
		else {
			subdictSecDevIdx = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecDevIdx.put( keySecDevIdx, subdictSecDevIdx );
		}
		subdictSecDevIdx.put( pkey, Buff );

		dictByStartIdx.put( keyStartIdx, Buff );

		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictFinishIdx;
		if( dictByFinishIdx.containsKey( keyFinishIdx ) ) {
			subdictFinishIdx = dictByFinishIdx.get( keyFinishIdx );
		}
		else {
			subdictFinishIdx = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictByFinishIdx.put( keyFinishIdx, subdictFinishIdx );
		}
		subdictFinishIdx.put( pkey, Buff );

		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecProxyIdx;
		if( dictBySecProxyIdx.containsKey( keySecProxyIdx ) ) {
			subdictSecProxyIdx = dictBySecProxyIdx.get( keySecProxyIdx );
		}
		else {
			subdictSecProxyIdx = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecProxyIdx.put( keySecProxyIdx, subdictSecProxyIdx );
		}
		subdictSecProxyIdx.put( pkey, Buff );

	}

	public CFBamSecSessionBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerived() ";
		CFBamSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( PKey.getRequiredSecSessionId() );
		CFBamSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerived() ";
		CFBamSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( PKey.getRequiredSecSessionId() );
		CFBamSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecSession.readAllDerived() ";
		CFBamSecSessionBuff[] retList = new CFBamSecSessionBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecSessionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecSessionBuff[] readDerivedBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedBySecUserIdx() ";
		CFBamSecSessionBySecUserIdxKey key = schema.getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFBamSecSessionBuff[] recArray;
		if( dictBySecUserIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecUserIdx
				= dictBySecUserIdx.get( key );
			recArray = new CFBamSecSessionBuff[ subdictSecUserIdx.size() ];
			Iterator< CFBamSecSessionBuff > iter = subdictSecUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecUserIdx
				= new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecUserIdx.put( key, subdictSecUserIdx );
			recArray = new CFBamSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFBamSecSessionBuff[] readDerivedBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedBySecDevIdx() ";
		CFBamSecSessionBySecDevIdxKey key = schema.getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );

		CFBamSecSessionBuff[] recArray;
		if( dictBySecDevIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecDevIdx
				= dictBySecDevIdx.get( key );
			recArray = new CFBamSecSessionBuff[ subdictSecDevIdx.size() ];
			Iterator< CFBamSecSessionBuff > iter = subdictSecDevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecDevIdx
				= new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecDevIdx.put( key, subdictSecDevIdx );
			recArray = new CFBamSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFBamSecSessionBuff readDerivedByStartIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedByStartIdx() ";
		CFBamSecSessionByStartIdxKey key = schema.getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );

		CFBamSecSessionBuff buff;
		if( dictByStartIdx.containsKey( key ) ) {
			buff = dictByStartIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff[] readDerivedByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedByFinishIdx() ";
		CFBamSecSessionByFinishIdxKey key = schema.getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );

		CFBamSecSessionBuff[] recArray;
		if( dictByFinishIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictFinishIdx
				= dictByFinishIdx.get( key );
			recArray = new CFBamSecSessionBuff[ subdictFinishIdx.size() ];
			Iterator< CFBamSecSessionBuff > iter = subdictFinishIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictFinishIdx
				= new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictByFinishIdx.put( key, subdictFinishIdx );
			recArray = new CFBamSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFBamSecSessionBuff[] readDerivedBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedBySecProxyIdx() ";
		CFBamSecSessionBySecProxyIdxKey key = schema.getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );

		CFBamSecSessionBuff[] recArray;
		if( dictBySecProxyIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecProxyIdx
				= dictBySecProxyIdx.get( key );
			recArray = new CFBamSecSessionBuff[ subdictSecProxyIdx.size() ];
			Iterator< CFBamSecSessionBuff > iter = subdictSecProxyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecProxyIdx
				= new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecProxyIdx.put( key, subdictSecProxyIdx );
			recArray = new CFBamSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFBamSecSessionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "CFBamRamSecSession.readDerivedByIdIdx() ";
		CFBamSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( SecSessionId );

		CFBamSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuff() ";
		CFBamSecSessionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SESS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecSessionPKey PKey )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuff() ";
		CFBamSecSessionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SESS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecSessionBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecSession.readAllBuff() ";
		CFBamSecSessionBuff buff;
		ArrayList<CFBamSecSessionBuff> filteredList = new ArrayList<CFBamSecSessionBuff>();
		CFBamSecSessionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecSessionBuff[0] ) );
	}

	public CFBamSecSessionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffByIdIdx() ";
		CFBamSecSessionBuff buff = readDerivedByIdIdx( Authorization,
			SecSessionId );
		if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
			return( (CFBamSecSessionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecSessionBuff[] readBuffBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffBySecUserIdx() ";
		CFBamSecSessionBuff buff;
		ArrayList<CFBamSecSessionBuff> filteredList = new ArrayList<CFBamSecSessionBuff>();
		CFBamSecSessionBuff[] buffList = readDerivedBySecUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFBamSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecSessionBuff[0] ) );
	}

	public CFBamSecSessionBuff[] readBuffBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffBySecDevIdx() ";
		CFBamSecSessionBuff buff;
		ArrayList<CFBamSecSessionBuff> filteredList = new ArrayList<CFBamSecSessionBuff>();
		CFBamSecSessionBuff[] buffList = readDerivedBySecDevIdx( Authorization,
			SecUserId,
			SecDevName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFBamSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecSessionBuff[0] ) );
	}

	public CFBamSecSessionBuff readBuffByStartIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffByStartIdx() ";
		CFBamSecSessionBuff buff = readDerivedByStartIdx( Authorization,
			SecUserId,
			Start );
		if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
			return( (CFBamSecSessionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecSessionBuff[] readBuffByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffByFinishIdx() ";
		CFBamSecSessionBuff buff;
		ArrayList<CFBamSecSessionBuff> filteredList = new ArrayList<CFBamSecSessionBuff>();
		CFBamSecSessionBuff[] buffList = readDerivedByFinishIdx( Authorization,
			SecUserId,
			Finish );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFBamSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecSessionBuff[0] ) );
	}

	public CFBamSecSessionBuff[] readBuffBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "CFBamRamSecSession.readBuffBySecProxyIdx() ";
		CFBamSecSessionBuff buff;
		ArrayList<CFBamSecSessionBuff> filteredList = new ArrayList<CFBamSecSessionBuff>();
		CFBamSecSessionBuff[] buffList = readDerivedBySecProxyIdx( Authorization,
			SecProxyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFBamSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecSessionBuff[0] ) );
	}

	public void updateSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		CFBamSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( Buff.getRequiredSecSessionId() );
		CFBamSecSessionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecSession",
				"Existing record not found",
				"SecSession",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecSession",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecSessionBySecUserIdxKey existingKeySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		existingKeySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecSessionBySecUserIdxKey newKeySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		newKeySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFBamSecSessionBySecDevIdxKey existingKeySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		existingKeySecDevIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeySecDevIdx.setOptionalSecDevName( existing.getOptionalSecDevName() );

		CFBamSecSessionBySecDevIdxKey newKeySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		newKeySecDevIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeySecDevIdx.setOptionalSecDevName( Buff.getOptionalSecDevName() );

		CFBamSecSessionByStartIdxKey existingKeyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		existingKeyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyStartIdx.setRequiredStart( existing.getRequiredStart() );

		CFBamSecSessionByStartIdxKey newKeyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		newKeyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		CFBamSecSessionByFinishIdxKey existingKeyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		existingKeyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		CFBamSecSessionByFinishIdxKey newKeyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		newKeyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		CFBamSecSessionBySecProxyIdxKey existingKeySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		existingKeySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );

		CFBamSecSessionBySecProxyIdxKey newKeySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		newKeySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Check unique indexes

		if( ! existingKeyStartIdx.equals( newKeyStartIdx ) ) {
			if( dictByStartIdx.containsKey( newKeyStartIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecSession",
					"SessionStartIdx",
					newKeyStartIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecSession",
						"Container",
						"SecSessionUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySecUserIdx.get( existingKeySecUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecUserIdx.containsKey( newKeySecUserIdx ) ) {
			subdict = dictBySecUserIdx.get( newKeySecUserIdx );
		}
		else {
			subdict = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecUserIdx.put( newKeySecUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecDevIdx.get( existingKeySecDevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecDevIdx.containsKey( newKeySecDevIdx ) ) {
			subdict = dictBySecDevIdx.get( newKeySecDevIdx );
		}
		else {
			subdict = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecDevIdx.put( newKeySecDevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByStartIdx.remove( existingKeyStartIdx );
		dictByStartIdx.put( newKeyStartIdx, Buff );

		subdict = dictByFinishIdx.get( existingKeyFinishIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFinishIdx.containsKey( newKeyFinishIdx ) ) {
			subdict = dictByFinishIdx.get( newKeyFinishIdx );
		}
		else {
			subdict = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictByFinishIdx.put( newKeyFinishIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecProxyIdx.get( existingKeySecProxyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecProxyIdx.containsKey( newKeySecProxyIdx ) ) {
			subdict = dictBySecProxyIdx.get( newKeySecProxyIdx );
		}
		else {
			subdict = new HashMap< CFBamSecSessionPKey, CFBamSecSessionBuff >();
			dictBySecProxyIdx.put( newKeySecProxyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSecSession( CFBamAuthorization Authorization,
		CFBamSecSessionBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecSessionTable.deleteSecSession() ";
		CFBamSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( Buff.getRequiredSecSessionId() );
		CFBamSecSessionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecSession",
				pkey );
		}
		CFBamSecSessionBySecUserIdxKey keySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecSessionBySecDevIdxKey keySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		keySecDevIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keySecDevIdx.setOptionalSecDevName( existing.getOptionalSecDevName() );

		CFBamSecSessionByStartIdxKey keyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		keyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( existing.getRequiredStart() );

		CFBamSecSessionByFinishIdxKey keyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		CFBamSecSessionBySecProxyIdxKey keySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySecUserIdx.get( keySecUserIdx );
		subdict.remove( pkey );

		subdict = dictBySecDevIdx.get( keySecDevIdx );
		subdict.remove( pkey );

		dictByStartIdx.remove( keyStartIdx );

		subdict = dictByFinishIdx.get( keyFinishIdx );
		subdict.remove( pkey );

		subdict = dictBySecProxyIdx.get( keySecProxyIdx );
		subdict.remove( pkey );

	}

	public void deleteSecSessionByIdIdx( CFBamAuthorization Authorization,
		UUID argSecSessionId )
	{
		CFBamSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( argSecSessionId );
		deleteSecSessionByIdIdx( Authorization, key );
	}

	public void deleteSecSessionByIdIdx( CFBamAuthorization Authorization,
		CFBamSecSessionPKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		CFBamSecSessionBySecUserIdxKey key = schema.getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecSessionBySecUserIdx( Authorization, key );
	}

	public void deleteSecSessionBySecUserIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecUserIdxKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecDevIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		String argSecDevName )
	{
		CFBamSecSessionBySecDevIdxKey key = schema.getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setOptionalSecDevName( argSecDevName );
		deleteSecSessionBySecDevIdx( Authorization, key );
	}

	public void deleteSecSessionBySecDevIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecDevIdxKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionByStartIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		Calendar argStart )
	{
		CFBamSecSessionByStartIdxKey key = schema.getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredStart( argStart );
		deleteSecSessionByStartIdx( Authorization, key );
	}

	public void deleteSecSessionByStartIdx( CFBamAuthorization Authorization,
		CFBamSecSessionByStartIdxKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionByFinishIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		Calendar argFinish )
	{
		CFBamSecSessionByFinishIdxKey key = schema.getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setOptionalFinish( argFinish );
		deleteSecSessionByFinishIdx( Authorization, key );
	}

	public void deleteSecSessionByFinishIdx( CFBamAuthorization Authorization,
		CFBamSecSessionByFinishIdxKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecProxyIdx( CFBamAuthorization Authorization,
		UUID argSecProxyId )
	{
		CFBamSecSessionBySecProxyIdxKey key = schema.getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( argSecProxyId );
		deleteSecSessionBySecProxyIdx( Authorization, key );
	}

	public void deleteSecSessionBySecProxyIdx( CFBamAuthorization Authorization,
		CFBamSecSessionBySecProxyIdxKey argKey )
	{
		CFBamSecSessionBuff cur;
		LinkedList<CFBamSecSessionBuff> matchSet = new LinkedList<CFBamSecSessionBuff>();
		Iterator<CFBamSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecSession( Authorization, cur );
		}
	}

	public CFBamCursor openSecSessionCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecSessionCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		CFBamCursor cursor;
		CFBamSecSessionBySecUserIdxKey key = schema.getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		if( dictBySecUserIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecUserIdx
				= dictBySecUserIdx.get( key );
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				subdictSecUserIdx.values() );
		}
		else {
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				new ArrayList< CFBamSecSessionBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecDevIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		CFBamCursor cursor;
		CFBamSecSessionBySecDevIdxKey key = schema.getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );

		if( dictBySecDevIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecDevIdx
				= dictBySecDevIdx.get( key );
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				subdictSecDevIdx.values() );
		}
		else {
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				new ArrayList< CFBamSecSessionBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorByFinishIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		CFBamCursor cursor;
		CFBamSecSessionByFinishIdxKey key = schema.getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );

		if( dictByFinishIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictFinishIdx
				= dictByFinishIdx.get( key );
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				subdictFinishIdx.values() );
		}
		else {
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				new ArrayList< CFBamSecSessionBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openSecSessionCursorBySecProxyIdx( CFBamAuthorization Authorization,
		UUID SecProxyId )
	{
		CFBamCursor cursor;
		CFBamSecSessionBySecProxyIdxKey key = schema.getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );

		if( dictBySecProxyIdx.containsKey( key ) ) {
			Map< CFBamSecSessionPKey, CFBamSecSessionBuff > subdictSecProxyIdx
				= dictBySecProxyIdx.get( key );
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				subdictSecProxyIdx.values() );
		}
		else {
			cursor = new CFBamRamSecSessionCursor( Authorization,
				schema,
				new ArrayList< CFBamSecSessionBuff >() );
		}
		return( cursor );
	}

	public void closeSecSessionCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecSessionBuff nextSecSessionCursor( CFBamCursor Cursor ) {
		CFBamRamSecSessionCursor cursor = (CFBamRamSecSessionCursor)Cursor;
		CFBamSecSessionBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecSessionBuff prevSecSessionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecSessionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecSessionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecSessionBuff firstSecSessionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecSessionBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecSessionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecSessionBuff lastSecSessionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecSessionCursor" );
	}

	public CFBamSecSessionBuff nthSecSessionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecSessionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecSessionCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
