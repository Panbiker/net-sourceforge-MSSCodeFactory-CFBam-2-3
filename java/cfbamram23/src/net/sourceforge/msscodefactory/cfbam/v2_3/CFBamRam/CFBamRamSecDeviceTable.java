
// Description: Java7 in-memory RAM DbIO implementation for SecDevice.

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
 *	CFBamRamSecDeviceTable in-memory RAM DbIO implementation
 *	for SecDevice.
 */
public class CFBamRamSecDeviceTable
	implements ICFBamSecDeviceTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecDevicePKey,
				CFBamSecDeviceBuff > dictByPKey
		= new HashMap< CFBamSecDevicePKey,
				CFBamSecDeviceBuff >();
	private Map< CFBamSecDeviceByUserIdxKey,
				Map< CFBamSecDevicePKey,
					CFBamSecDeviceBuff >> dictByUserIdx
		= new HashMap< CFBamSecDeviceByUserIdxKey,
				Map< CFBamSecDevicePKey,
					CFBamSecDeviceBuff >>();

	public CFBamRamSecDeviceTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		final String S_ProcName = "createSecDevice";
		CFBamSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		Buff.setRequiredSecUserId( pkey.getRequiredSecUserId() );
		Buff.setRequiredDevName( pkey.getRequiredDevName() );
		CFBamSecDeviceByUserIdxKey keyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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
						"SecDeviceSecUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFBamSecDevicePKey, CFBamSecDeviceBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

	}

	public CFBamSecDeviceBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecDevice.readDerived() ";
		CFBamSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredDevName( PKey.getRequiredDevName() );
		CFBamSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecDeviceBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecDevice.readDerived() ";
		CFBamSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredDevName( PKey.getRequiredDevName() );
		CFBamSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecDeviceBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecDevice.readAllDerived() ";
		CFBamSecDeviceBuff[] retList = new CFBamSecDeviceBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecDeviceBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecDeviceBuff[] readDerivedByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecDevice.readDerivedByUserIdx() ";
		CFBamSecDeviceByUserIdxKey key = schema.getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFBamSecDeviceBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFBamSecDeviceBuff[ subdictUserIdx.size() ];
			Iterator< CFBamSecDeviceBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdictUserIdx
				= new HashMap< CFBamSecDevicePKey, CFBamSecDeviceBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFBamSecDeviceBuff[0];
		}
		return( recArray );
	}

	public CFBamSecDeviceBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFBamRamSecDevice.readDerivedByIdIdx() ";
		CFBamSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );

		CFBamSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecDeviceBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecDevice.readBuff() ";
		CFBamSecDeviceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SDEV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecDeviceBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecDevicePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecDevice.readBuff() ";
		CFBamSecDeviceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SDEV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecDeviceBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecDevice.readAllBuff() ";
		CFBamSecDeviceBuff buff;
		ArrayList<CFBamSecDeviceBuff> filteredList = new ArrayList<CFBamSecDeviceBuff>();
		CFBamSecDeviceBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecDeviceBuff[0] ) );
	}

	public CFBamSecDeviceBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFBamRamSecDevice.readBuffByIdIdx() ";
		CFBamSecDeviceBuff buff = readDerivedByIdIdx( Authorization,
			SecUserId,
			DevName );
		if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
			return( (CFBamSecDeviceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecDeviceBuff[] readBuffByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFBamRamSecDevice.readBuffByUserIdx() ";
		CFBamSecDeviceBuff buff;
		ArrayList<CFBamSecDeviceBuff> filteredList = new ArrayList<CFBamSecDeviceBuff>();
		CFBamSecDeviceBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
				filteredList.add( (CFBamSecDeviceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSecDeviceBuff[0] ) );
	}

	public void updateSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		CFBamSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		CFBamSecDeviceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecDevice",
				"Existing record not found",
				"SecDevice",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecDevice",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecDeviceByUserIdxKey existingKeyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFBamSecDeviceByUserIdxKey newKeyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSecDevice",
						"Container",
						"SecDeviceSecUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByUserIdx.get( existingKeyUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
			subdict = dictByUserIdx.get( newKeyUserIdx );
		}
		else {
			subdict = new HashMap< CFBamSecDevicePKey, CFBamSecDeviceBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSecDevice( CFBamAuthorization Authorization,
		CFBamSecDeviceBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecDeviceTable.deleteSecDevice() ";
		CFBamSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		CFBamSecDeviceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecDevice",
				pkey );
		}
		CFBamSecDeviceByUserIdxKey keyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

	}

	public void deleteSecDeviceByIdIdx( CFBamAuthorization Authorization,
		UUID argSecUserId,
		String argDevName )
	{
		CFBamSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredDevName( argDevName );
		deleteSecDeviceByIdIdx( Authorization, key );
	}

	public void deleteSecDeviceByIdIdx( CFBamAuthorization Authorization,
		CFBamSecDevicePKey argKey )
	{
		CFBamSecDeviceBuff cur;
		LinkedList<CFBamSecDeviceBuff> matchSet = new LinkedList<CFBamSecDeviceBuff>();
		Iterator<CFBamSecDeviceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecDeviceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecDevice( Authorization, cur );
		}
	}

	public void deleteSecDeviceByUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId )
	{
		CFBamSecDeviceByUserIdxKey key = schema.getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecDeviceByUserIdx( Authorization, key );
	}

	public void deleteSecDeviceByUserIdx( CFBamAuthorization Authorization,
		CFBamSecDeviceByUserIdxKey argKey )
	{
		CFBamSecDeviceBuff cur;
		LinkedList<CFBamSecDeviceBuff> matchSet = new LinkedList<CFBamSecDeviceBuff>();
		Iterator<CFBamSecDeviceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecDeviceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecDevice( Authorization, cur );
		}
	}

	public CFBamCursor openSecDeviceCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecDeviceCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSecDeviceCursorByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId )
	{
		CFBamCursor cursor;
		CFBamSecDeviceByUserIdxKey key = schema.getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFBamSecDevicePKey, CFBamSecDeviceBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			cursor = new CFBamRamSecDeviceCursor( Authorization,
				schema,
				subdictUserIdx.values() );
		}
		else {
			cursor = new CFBamRamSecDeviceCursor( Authorization,
				schema,
				new ArrayList< CFBamSecDeviceBuff >() );
		}
		return( cursor );
	}

	public void closeSecDeviceCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecDeviceBuff nextSecDeviceCursor( CFBamCursor Cursor ) {
		CFBamRamSecDeviceCursor cursor = (CFBamRamSecDeviceCursor)Cursor;
		CFBamSecDeviceBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecDeviceBuff prevSecDeviceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecDeviceBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecDeviceCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecDeviceBuff firstSecDeviceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecDeviceBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecDeviceCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecDeviceBuff lastSecDeviceCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecDeviceCursor" );
	}

	public CFBamSecDeviceBuff nthSecDeviceCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecDeviceBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecDeviceCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
