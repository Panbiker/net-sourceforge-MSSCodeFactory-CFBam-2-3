
// Description: Java7 in-memory RAM DbIO implementation for AccessSecurity.

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
 *	CFBamRamAccessSecurityTable in-memory RAM DbIO implementation
 *	for AccessSecurity.
 */
public class CFBamRamAccessSecurityTable
	implements ICFBamAccessSecurityTable
{
	private CFBamRamSchema schema;
	private Map< CFBamAccessSecurityPKey,
				CFBamAccessSecurityBuff > dictByPKey
		= new HashMap< CFBamAccessSecurityPKey,
				CFBamAccessSecurityBuff >();
	private Map< CFBamAccessSecurityByUNameIdxKey,
			CFBamAccessSecurityBuff > dictByUNameIdx
		= new HashMap< CFBamAccessSecurityByUNameIdxKey,
			CFBamAccessSecurityBuff >();

	public CFBamRamAccessSecurityTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createAccessSecurity( CFBamAuthorization Authorization,
		CFBamAccessSecurityBuff Buff )
	{
		final String S_ProcName = "createAccessSecurity";
		CFBamAccessSecurityPKey pkey = schema.getFactoryAccessSecurity().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamAccessSecurityByUNameIdxKey keyUNameIdx = schema.getFactoryAccessSecurity().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"AccessSecurityUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamAccessSecurityBuff readDerived( CFBamAuthorization Authorization,
		CFBamAccessSecurityPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readDerived() ";
		CFBamAccessSecurityPKey key = schema.getFactoryAccessSecurity().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAccessSecurityBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff lockDerived( CFBamAuthorization Authorization,
		CFBamAccessSecurityPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readDerived() ";
		CFBamAccessSecurityPKey key = schema.getFactoryAccessSecurity().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAccessSecurityBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamAccessSecurity.readAllDerived() ";
		CFBamAccessSecurityBuff[] retList = new CFBamAccessSecurityBuff[ dictByPKey.values().size() ];
		Iterator< CFBamAccessSecurityBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamAccessSecurityBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readDerivedByUNameIdx() ";
		CFBamAccessSecurityByUNameIdxKey key = schema.getFactoryAccessSecurity().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamAccessSecurityBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readDerivedByIdIdx() ";
		CFBamAccessSecurityPKey key = schema.getFactoryAccessSecurity().newPKey();
		key.setRequiredId( Id );

		CFBamAccessSecurityBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff readBuff( CFBamAuthorization Authorization,
		CFBamAccessSecurityPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readBuff() ";
		CFBamAccessSecurityBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ASEC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff lockBuff( CFBamAuthorization Authorization,
		CFBamAccessSecurityPKey PKey )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readBuff() ";
		CFBamAccessSecurityBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ASEC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAccessSecurityBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readAllBuff() ";
		CFBamAccessSecurityBuff buff;
		ArrayList<CFBamAccessSecurityBuff> filteredList = new ArrayList<CFBamAccessSecurityBuff>();
		CFBamAccessSecurityBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ASEC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamAccessSecurityBuff[0] ) );
	}

	public CFBamAccessSecurityBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readBuffByIdIdx() ";
		CFBamAccessSecurityBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "ASEC" ) ) {
			return( (CFBamAccessSecurityBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAccessSecurityBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamAccessSecurity.readBuffByUNameIdx() ";
		CFBamAccessSecurityBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "ASEC" ) ) {
			return( (CFBamAccessSecurityBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateAccessSecurity( CFBamAuthorization Authorization,
		CFBamAccessSecurityBuff Buff )
	{
		CFBamAccessSecurityPKey pkey = schema.getFactoryAccessSecurity().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAccessSecurityBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateAccessSecurity",
				"Existing record not found",
				"AccessSecurity",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateAccessSecurity",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamAccessSecurityByUNameIdxKey existingKeyUNameIdx = schema.getFactoryAccessSecurity().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamAccessSecurityByUNameIdxKey newKeyUNameIdx = schema.getFactoryAccessSecurity().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateAccessSecurity",
					"AccessSecurityUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamAccessSecurityPKey, CFBamAccessSecurityBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteAccessSecurity( CFBamAuthorization Authorization,
		CFBamAccessSecurityBuff Buff )
	{
		final String S_ProcName = "CFBamRamAccessSecurityTable.deleteAccessSecurity() ";
		CFBamAccessSecurityPKey pkey = schema.getFactoryAccessSecurity().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAccessSecurityBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteAccessSecurity",
				pkey );
		}
		CFBamAccessSecurityByUNameIdxKey keyUNameIdx = schema.getFactoryAccessSecurity().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamAccessSecurityPKey, CFBamAccessSecurityBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteAccessSecurityByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamAccessSecurityPKey key = schema.getFactoryAccessSecurity().newPKey();
		key.setRequiredId( argId );
		deleteAccessSecurityByIdIdx( Authorization, key );
	}

	public void deleteAccessSecurityByIdIdx( CFBamAuthorization Authorization,
		CFBamAccessSecurityPKey argKey )
	{
		CFBamAccessSecurityBuff cur;
		LinkedList<CFBamAccessSecurityBuff> matchSet = new LinkedList<CFBamAccessSecurityBuff>();
		Iterator<CFBamAccessSecurityBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAccessSecurityBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAccessSecurity( Authorization, cur );
		}
	}

	public void deleteAccessSecurityByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamAccessSecurityByUNameIdxKey key = schema.getFactoryAccessSecurity().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteAccessSecurityByUNameIdx( Authorization, key );
	}

	public void deleteAccessSecurityByUNameIdx( CFBamAuthorization Authorization,
		CFBamAccessSecurityByUNameIdxKey argKey )
	{
		CFBamAccessSecurityBuff cur;
		LinkedList<CFBamAccessSecurityBuff> matchSet = new LinkedList<CFBamAccessSecurityBuff>();
		Iterator<CFBamAccessSecurityBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAccessSecurityBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAccessSecurity( Authorization, cur );
		}
	}

	public CFBamCursor openAccessSecurityCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamAccessSecurityCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeAccessSecurityCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamAccessSecurityBuff nextAccessSecurityCursor( CFBamCursor Cursor ) {
		CFBamRamAccessSecurityCursor cursor = (CFBamRamAccessSecurityCursor)Cursor;
		CFBamAccessSecurityBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamAccessSecurityBuff prevAccessSecurityCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamAccessSecurityBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessSecurityCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAccessSecurityBuff firstAccessSecurityCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamAccessSecurityBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessSecurityCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAccessSecurityBuff lastAccessSecurityCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastAccessSecurityCursor" );
	}

	public CFBamAccessSecurityBuff nthAccessSecurityCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamAccessSecurityBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAccessSecurityCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
