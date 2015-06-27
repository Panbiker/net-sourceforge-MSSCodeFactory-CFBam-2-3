
// Description: Java7 in-memory RAM DbIO implementation for DataScope.

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
 *	CFBamRamDataScopeTable in-memory RAM DbIO implementation
 *	for DataScope.
 */
public class CFBamRamDataScopeTable
	implements ICFBamDataScopeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDataScopePKey,
				CFBamDataScopeBuff > dictByPKey
		= new HashMap< CFBamDataScopePKey,
				CFBamDataScopeBuff >();
	private Map< CFBamDataScopeByUNameIdxKey,
			CFBamDataScopeBuff > dictByUNameIdx
		= new HashMap< CFBamDataScopeByUNameIdxKey,
			CFBamDataScopeBuff >();

	public CFBamRamDataScopeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDataScope( CFBamAuthorization Authorization,
		CFBamDataScopeBuff Buff )
	{
		final String S_ProcName = "createDataScope";
		CFBamDataScopePKey pkey = schema.getFactoryDataScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamDataScopeByUNameIdxKey keyUNameIdx = schema.getFactoryDataScope().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DataScopeUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamDataScopeBuff readDerived( CFBamAuthorization Authorization,
		CFBamDataScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDataScope.readDerived() ";
		CFBamDataScopePKey key = schema.getFactoryDataScope().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDataScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDataScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDataScope.readDerived() ";
		CFBamDataScopePKey key = schema.getFactoryDataScope().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDataScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDataScope.readAllDerived() ";
		CFBamDataScopeBuff[] retList = new CFBamDataScopeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDataScopeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDataScopeBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamDataScope.readDerivedByUNameIdx() ";
		CFBamDataScopeByUNameIdxKey key = schema.getFactoryDataScope().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamDataScopeBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamDataScope.readDerivedByIdIdx() ";
		CFBamDataScopePKey key = schema.getFactoryDataScope().newPKey();
		key.setRequiredId( Id );

		CFBamDataScopeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff readBuff( CFBamAuthorization Authorization,
		CFBamDataScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDataScope.readBuff() ";
		CFBamDataScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DSCP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDataScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamDataScope.readBuff() ";
		CFBamDataScopeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DSCP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDataScopeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDataScope.readAllBuff() ";
		CFBamDataScopeBuff buff;
		ArrayList<CFBamDataScopeBuff> filteredList = new ArrayList<CFBamDataScopeBuff>();
		CFBamDataScopeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DSCP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDataScopeBuff[0] ) );
	}

	public CFBamDataScopeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFBamRamDataScope.readBuffByIdIdx() ";
		CFBamDataScopeBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "DSCP" ) ) {
			return( (CFBamDataScopeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDataScopeBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamDataScope.readBuffByUNameIdx() ";
		CFBamDataScopeBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DSCP" ) ) {
			return( (CFBamDataScopeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateDataScope( CFBamAuthorization Authorization,
		CFBamDataScopeBuff Buff )
	{
		CFBamDataScopePKey pkey = schema.getFactoryDataScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDataScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDataScope",
				"Existing record not found",
				"DataScope",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateDataScope",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamDataScopeByUNameIdxKey existingKeyUNameIdx = schema.getFactoryDataScope().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamDataScopeByUNameIdxKey newKeyUNameIdx = schema.getFactoryDataScope().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateDataScope",
					"DataScopeUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamDataScopePKey, CFBamDataScopeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteDataScope( CFBamAuthorization Authorization,
		CFBamDataScopeBuff Buff )
	{
		final String S_ProcName = "CFBamRamDataScopeTable.deleteDataScope() ";
		CFBamDataScopePKey pkey = schema.getFactoryDataScope().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDataScopeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDataScope",
				pkey );
		}
		CFBamDataScopeByUNameIdxKey keyUNameIdx = schema.getFactoryDataScope().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamDataScopePKey, CFBamDataScopeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteDataScopeByIdIdx( CFBamAuthorization Authorization,
		short argId )
	{
		CFBamDataScopePKey key = schema.getFactoryDataScope().newPKey();
		key.setRequiredId( argId );
		deleteDataScopeByIdIdx( Authorization, key );
	}

	public void deleteDataScopeByIdIdx( CFBamAuthorization Authorization,
		CFBamDataScopePKey argKey )
	{
		CFBamDataScopeBuff cur;
		LinkedList<CFBamDataScopeBuff> matchSet = new LinkedList<CFBamDataScopeBuff>();
		Iterator<CFBamDataScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDataScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDataScope( Authorization, cur );
		}
	}

	public void deleteDataScopeByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamDataScopeByUNameIdxKey key = schema.getFactoryDataScope().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteDataScopeByUNameIdx( Authorization, key );
	}

	public void deleteDataScopeByUNameIdx( CFBamAuthorization Authorization,
		CFBamDataScopeByUNameIdxKey argKey )
	{
		CFBamDataScopeBuff cur;
		LinkedList<CFBamDataScopeBuff> matchSet = new LinkedList<CFBamDataScopeBuff>();
		Iterator<CFBamDataScopeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDataScopeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDataScope( Authorization, cur );
		}
	}

	public CFBamCursor openDataScopeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDataScopeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeDataScopeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDataScopeBuff nextDataScopeCursor( CFBamCursor Cursor ) {
		CFBamRamDataScopeCursor cursor = (CFBamRamDataScopeCursor)Cursor;
		CFBamDataScopeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDataScopeBuff prevDataScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDataScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDataScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDataScopeBuff firstDataScopeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDataScopeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDataScopeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDataScopeBuff lastDataScopeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDataScopeCursor" );
	}

	public CFBamDataScopeBuff nthDataScopeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDataScopeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDataScopeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
