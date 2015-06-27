
// Description: Java7 in-memory RAM DbIO implementation for SecurityScope.

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
 *	CFBamRamSecurityScopeTable in-memory RAM DbIO implementation
 *	for SecurityScope.
 */
public class CFBamRamSecurityScopeTable
	implements ICFBamSecurityScopeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamSecurityScopePKey,
				CFBamSecurityScopeBuff > dictByPKey
		= new HashMap< CFBamSecurityScopePKey,
				CFBamSecurityScopeBuff >();
	private Map< CFBamSecurityScopeByUNameIdxKey,
			CFBamSecurityScopeBuff > dictByUNameIdx
		= new HashMap< CFBamSecurityScopeByUNameIdxKey,
			CFBamSecurityScopeBuff >();

	public CFBamRamSecurityScopeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecurityScope( CFBamAuthorization Authorization,
		CFBamSecurityScopeBuff Buff )
	{
		final String S_ProcName = "createSecurityScope";
		CFBamSecurityScopePKey pkey = schema.getFactorySecurityScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamSecurityScopeByUNameIdxKey keyUNameIdx = schema.getFactorySecurityScope().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecurityScopeUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamSecurityScopeBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecurityScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readDerived() ";
		CFBamSecurityScopePKey key = schema.getFactorySecurityScope().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSecurityScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecurityScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readDerived() ";
		CFBamSecurityScopePKey key = schema.getFactorySecurityScope().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSecurityScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSecurityScope.readAllDerived() ";
		CFBamSecurityScopeBuff[] retList = new CFBamSecurityScopeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSecurityScopeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSecurityScopeBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readDerivedByUNameIdx() ";
		CFBamSecurityScopeByUNameIdxKey key = schema.getFactorySecurityScope().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamSecurityScopeBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readDerivedByIdIdx() ";
		CFBamSecurityScopePKey key = schema.getFactorySecurityScope().newPKey();
		key.setRequiredId( Id );

		CFBamSecurityScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecurityScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readBuff() ";
		CFBamSecurityScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCSP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecurityScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readBuff() ";
		CFBamSecurityScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SCSP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSecurityScopeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readAllBuff() ";
		CFBamSecurityScopeBuff buff;
		ArrayList<CFBamSecurityScopeBuff> filteredList = new ArrayList<CFBamSecurityScopeBuff>();
		CFBamSecurityScopeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCSP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSecurityScopeBuff[0] ) );
	}

	public CFBamSecurityScopeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readBuffByIdIdx() ";
		CFBamSecurityScopeBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCSP" ) ) {
			return( (CFBamSecurityScopeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSecurityScopeBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamSecurityScope.readBuffByUNameIdx() ";
		CFBamSecurityScopeBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SCSP" ) ) {
			return( (CFBamSecurityScopeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecurityScope( CFBamAuthorization Authorization,
		CFBamSecurityScopeBuff Buff )
	{
		CFBamSecurityScopePKey pkey = schema.getFactorySecurityScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSecurityScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSecurityScope",
				"Existing record not found",
				"SecurityScope",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateSecurityScope",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamSecurityScopeByUNameIdxKey existingKeyUNameIdx = schema.getFactorySecurityScope().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSecurityScopeByUNameIdxKey newKeyUNameIdx = schema.getFactorySecurityScope().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSecurityScope",
					"SecurityScopeUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamSecurityScopePKey, CFBamSecurityScopeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteSecurityScope( CFBamAuthorization Authorization,
		CFBamSecurityScopeBuff Buff )
	{
		final String S_ProcName = "CFBamRamSecurityScopeTable.deleteSecurityScope() ";
		CFBamSecurityScopePKey pkey = schema.getFactorySecurityScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSecurityScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSecurityScope",
				pkey );
		}
		CFBamSecurityScopeByUNameIdxKey keyUNameIdx = schema.getFactorySecurityScope().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		if( schema.getTableTable().readDerivedBySecScopeIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteSecurityScope",
				"Lookup",
				"SecurityScope",
				"Table",
				pkey );
		}

		// Delete is valid

		Map< CFBamSecurityScopePKey, CFBamSecurityScopeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteSecurityScopeByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamSecurityScopePKey key = schema.getFactorySecurityScope().newPKey();
		key.setRequiredId( argId );
		deleteSecurityScopeByIdIdx( Authorization, key );
	}

	public void deleteSecurityScopeByIdIdx( CFBamAuthorization Authorization,
		CFBamSecurityScopePKey argKey )
	{
		CFBamSecurityScopeBuff cur;
		LinkedList<CFBamSecurityScopeBuff> matchSet = new LinkedList<CFBamSecurityScopeBuff>();
		Iterator<CFBamSecurityScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecurityScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecurityScope( Authorization, cur );
		}
	}

	public void deleteSecurityScopeByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamSecurityScopeByUNameIdxKey key = schema.getFactorySecurityScope().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteSecurityScopeByUNameIdx( Authorization, key );
	}

	public void deleteSecurityScopeByUNameIdx( CFBamAuthorization Authorization,
		CFBamSecurityScopeByUNameIdxKey argKey )
	{
		CFBamSecurityScopeBuff cur;
		LinkedList<CFBamSecurityScopeBuff> matchSet = new LinkedList<CFBamSecurityScopeBuff>();
		Iterator<CFBamSecurityScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSecurityScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSecurityScope( Authorization, cur );
		}
	}

	public CFBamCursor openSecurityScopeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSecurityScopeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeSecurityScopeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSecurityScopeBuff nextSecurityScopeCursor( CFBamCursor Cursor ) {
		CFBamRamSecurityScopeCursor cursor = (CFBamRamSecurityScopeCursor)Cursor;
		CFBamSecurityScopeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSecurityScopeBuff prevSecurityScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSecurityScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecurityScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecurityScopeBuff firstSecurityScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSecurityScopeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecurityScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSecurityScopeBuff lastSecurityScopeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSecurityScopeCursor" );
	}

	public CFBamSecurityScopeBuff nthSecurityScopeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSecurityScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSecurityScopeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
