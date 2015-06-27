
// Description: Java7 in-memory RAM DbIO implementation for URLProtocol.

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
 *	CFBamRamURLProtocolTable in-memory RAM DbIO implementation
 *	for URLProtocol.
 */
public class CFBamRamURLProtocolTable
	implements ICFBamURLProtocolTable
{
	private CFBamRamSchema schema;
	private Map< CFBamURLProtocolPKey,
				CFBamURLProtocolBuff > dictByPKey
		= new HashMap< CFBamURLProtocolPKey,
				CFBamURLProtocolBuff >();
	private Map< CFBamURLProtocolByUNameIdxKey,
			CFBamURLProtocolBuff > dictByUNameIdx
		= new HashMap< CFBamURLProtocolByUNameIdxKey,
			CFBamURLProtocolBuff >();
	private Map< CFBamURLProtocolByIsSecureIdxKey,
				Map< CFBamURLProtocolPKey,
					CFBamURLProtocolBuff >> dictByIsSecureIdx
		= new HashMap< CFBamURLProtocolByIsSecureIdxKey,
				Map< CFBamURLProtocolPKey,
					CFBamURLProtocolBuff >>();

	public CFBamRamURLProtocolTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createURLProtocol( CFBamAuthorization Authorization,
		CFBamURLProtocolBuff Buff )
	{
		final String S_ProcName = "createURLProtocol";
		CFBamURLProtocolPKey pkey = schema.getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( Buff.getRequiredURLProtocolId() );
		Buff.setRequiredURLProtocolId( pkey.getRequiredURLProtocolId() );
		CFBamURLProtocolByUNameIdxKey keyUNameIdx = schema.getFactoryURLProtocol().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		keyIsSecureIdx.setRequiredIsSecure( Buff.getRequiredIsSecure() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"URLProtocolUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdictIsSecureIdx;
		if( dictByIsSecureIdx.containsKey( keyIsSecureIdx ) ) {
			subdictIsSecureIdx = dictByIsSecureIdx.get( keyIsSecureIdx );
		}
		else {
			subdictIsSecureIdx = new HashMap< CFBamURLProtocolPKey, CFBamURLProtocolBuff >();
			dictByIsSecureIdx.put( keyIsSecureIdx, subdictIsSecureIdx );
		}
		subdictIsSecureIdx.put( pkey, Buff );

	}

	public CFBamURLProtocolBuff readDerived( CFBamAuthorization Authorization,
		CFBamURLProtocolPKey PKey )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readDerived() ";
		CFBamURLProtocolPKey key = schema.getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( PKey.getRequiredURLProtocolId() );
		CFBamURLProtocolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff lockDerived( CFBamAuthorization Authorization,
		CFBamURLProtocolPKey PKey )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readDerived() ";
		CFBamURLProtocolPKey key = schema.getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( PKey.getRequiredURLProtocolId() );
		CFBamURLProtocolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamURLProtocol.readAllDerived() ";
		CFBamURLProtocolBuff[] retList = new CFBamURLProtocolBuff[ dictByPKey.values().size() ];
		Iterator< CFBamURLProtocolBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamURLProtocolBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readDerivedByUNameIdx() ";
		CFBamURLProtocolByUNameIdxKey key = schema.getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamURLProtocolBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff[] readDerivedByIsSecureIdx( CFBamAuthorization Authorization,
		boolean IsSecure )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readDerivedByIsSecureIdx() ";
		CFBamURLProtocolByIsSecureIdxKey key = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );

		CFBamURLProtocolBuff[] recArray;
		if( dictByIsSecureIdx.containsKey( key ) ) {
			Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdictIsSecureIdx
				= dictByIsSecureIdx.get( key );
			recArray = new CFBamURLProtocolBuff[ subdictIsSecureIdx.size() ];
			Iterator< CFBamURLProtocolBuff > iter = subdictIsSecureIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdictIsSecureIdx
				= new HashMap< CFBamURLProtocolPKey, CFBamURLProtocolBuff >();
			dictByIsSecureIdx.put( key, subdictIsSecureIdx );
			recArray = new CFBamURLProtocolBuff[0];
		}
		return( recArray );
	}

	public CFBamURLProtocolBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short URLProtocolId )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readDerivedByIdIdx() ";
		CFBamURLProtocolPKey key = schema.getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( URLProtocolId );

		CFBamURLProtocolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff readBuff( CFBamAuthorization Authorization,
		CFBamURLProtocolPKey PKey )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readBuff() ";
		CFBamURLProtocolBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "UPRT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff lockBuff( CFBamAuthorization Authorization,
		CFBamURLProtocolPKey PKey )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readBuff() ";
		CFBamURLProtocolBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "UPRT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamURLProtocolBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readAllBuff() ";
		CFBamURLProtocolBuff buff;
		ArrayList<CFBamURLProtocolBuff> filteredList = new ArrayList<CFBamURLProtocolBuff>();
		CFBamURLProtocolBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "UPRT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamURLProtocolBuff[0] ) );
	}

	public CFBamURLProtocolBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short URLProtocolId )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readBuffByIdIdx() ";
		CFBamURLProtocolBuff buff = readDerivedByIdIdx( Authorization,
			URLProtocolId );
		if( ( buff != null ) && buff.getClassCode().equals( "UPRT" ) ) {
			return( (CFBamURLProtocolBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamURLProtocolBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readBuffByUNameIdx() ";
		CFBamURLProtocolBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "UPRT" ) ) {
			return( (CFBamURLProtocolBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamURLProtocolBuff[] readBuffByIsSecureIdx( CFBamAuthorization Authorization,
		boolean IsSecure )
	{
		final String S_ProcName = "CFBamRamURLProtocol.readBuffByIsSecureIdx() ";
		CFBamURLProtocolBuff buff;
		ArrayList<CFBamURLProtocolBuff> filteredList = new ArrayList<CFBamURLProtocolBuff>();
		CFBamURLProtocolBuff[] buffList = readDerivedByIsSecureIdx( Authorization,
			IsSecure );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "UPRT" ) ) {
				filteredList.add( (CFBamURLProtocolBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamURLProtocolBuff[0] ) );
	}

	public void updateURLProtocol( CFBamAuthorization Authorization,
		CFBamURLProtocolBuff Buff )
	{
		CFBamURLProtocolPKey pkey = schema.getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( Buff.getRequiredURLProtocolId() );
		CFBamURLProtocolBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateURLProtocol",
				"Existing record not found",
				"URLProtocol",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateURLProtocol",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamURLProtocolByUNameIdxKey existingKeyUNameIdx = schema.getFactoryURLProtocol().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamURLProtocolByUNameIdxKey newKeyUNameIdx = schema.getFactoryURLProtocol().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamURLProtocolByIsSecureIdxKey existingKeyIsSecureIdx = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		existingKeyIsSecureIdx.setRequiredIsSecure( existing.getRequiredIsSecure() );

		CFBamURLProtocolByIsSecureIdxKey newKeyIsSecureIdx = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		newKeyIsSecureIdx.setRequiredIsSecure( Buff.getRequiredIsSecure() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateURLProtocol",
					"URLProtocolUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByIsSecureIdx.get( existingKeyIsSecureIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIsSecureIdx.containsKey( newKeyIsSecureIdx ) ) {
			subdict = dictByIsSecureIdx.get( newKeyIsSecureIdx );
		}
		else {
			subdict = new HashMap< CFBamURLProtocolPKey, CFBamURLProtocolBuff >();
			dictByIsSecureIdx.put( newKeyIsSecureIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteURLProtocol( CFBamAuthorization Authorization,
		CFBamURLProtocolBuff Buff )
	{
		final String S_ProcName = "CFBamRamURLProtocolTable.deleteURLProtocol() ";
		CFBamURLProtocolPKey pkey = schema.getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( Buff.getRequiredURLProtocolId() );
		CFBamURLProtocolBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteURLProtocol",
				pkey );
		}
		CFBamURLProtocolByUNameIdxKey keyUNameIdx = schema.getFactoryURLProtocol().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		keyIsSecureIdx.setRequiredIsSecure( existing.getRequiredIsSecure() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByIsSecureIdx.get( keyIsSecureIdx );
		subdict.remove( pkey );

	}

	public void deleteURLProtocolByIdIdx( CFBamAuthorization Authorization,
		short argURLProtocolId )
	{
		CFBamURLProtocolPKey key = schema.getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( argURLProtocolId );
		deleteURLProtocolByIdIdx( Authorization, key );
	}

	public void deleteURLProtocolByIdIdx( CFBamAuthorization Authorization,
		CFBamURLProtocolPKey argKey )
	{
		CFBamURLProtocolBuff cur;
		LinkedList<CFBamURLProtocolBuff> matchSet = new LinkedList<CFBamURLProtocolBuff>();
		Iterator<CFBamURLProtocolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamURLProtocolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteURLProtocol( Authorization, cur );
		}
	}

	public void deleteURLProtocolByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamURLProtocolByUNameIdxKey key = schema.getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteURLProtocolByUNameIdx( Authorization, key );
	}

	public void deleteURLProtocolByUNameIdx( CFBamAuthorization Authorization,
		CFBamURLProtocolByUNameIdxKey argKey )
	{
		CFBamURLProtocolBuff cur;
		LinkedList<CFBamURLProtocolBuff> matchSet = new LinkedList<CFBamURLProtocolBuff>();
		Iterator<CFBamURLProtocolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamURLProtocolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteURLProtocol( Authorization, cur );
		}
	}

	public void deleteURLProtocolByIsSecureIdx( CFBamAuthorization Authorization,
		boolean argIsSecure )
	{
		CFBamURLProtocolByIsSecureIdxKey key = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( argIsSecure );
		deleteURLProtocolByIsSecureIdx( Authorization, key );
	}

	public void deleteURLProtocolByIsSecureIdx( CFBamAuthorization Authorization,
		CFBamURLProtocolByIsSecureIdxKey argKey )
	{
		CFBamURLProtocolBuff cur;
		LinkedList<CFBamURLProtocolBuff> matchSet = new LinkedList<CFBamURLProtocolBuff>();
		Iterator<CFBamURLProtocolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamURLProtocolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteURLProtocol( Authorization, cur );
		}
	}

	public CFBamCursor openURLProtocolCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamURLProtocolCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openURLProtocolCursorByIsSecureIdx( CFBamAuthorization Authorization,
		boolean IsSecure )
	{
		CFBamCursor cursor;
		CFBamURLProtocolByIsSecureIdxKey key = schema.getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );

		if( dictByIsSecureIdx.containsKey( key ) ) {
			Map< CFBamURLProtocolPKey, CFBamURLProtocolBuff > subdictIsSecureIdx
				= dictByIsSecureIdx.get( key );
			cursor = new CFBamRamURLProtocolCursor( Authorization,
				schema,
				subdictIsSecureIdx.values() );
		}
		else {
			cursor = new CFBamRamURLProtocolCursor( Authorization,
				schema,
				new ArrayList< CFBamURLProtocolBuff >() );
		}
		return( cursor );
	}

	public void closeURLProtocolCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamURLProtocolBuff nextURLProtocolCursor( CFBamCursor Cursor ) {
		CFBamRamURLProtocolCursor cursor = (CFBamRamURLProtocolCursor)Cursor;
		CFBamURLProtocolBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamURLProtocolBuff prevURLProtocolCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamURLProtocolBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextURLProtocolCursor( Cursor );
		}
		return( rec );
	}

	public CFBamURLProtocolBuff firstURLProtocolCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamURLProtocolBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextURLProtocolCursor( Cursor );
		}
		return( rec );
	}

	public CFBamURLProtocolBuff lastURLProtocolCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastURLProtocolCursor" );
	}

	public CFBamURLProtocolBuff nthURLProtocolCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamURLProtocolBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextURLProtocolCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
