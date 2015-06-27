
// Description: Java7 in-memory RAM DbIO implementation for MimeType.

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
 *	CFBamRamMimeTypeTable in-memory RAM DbIO implementation
 *	for MimeType.
 */
public class CFBamRamMimeTypeTable
	implements ICFBamMimeTypeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamMimeTypePKey,
				CFBamMimeTypeBuff > dictByPKey
		= new HashMap< CFBamMimeTypePKey,
				CFBamMimeTypeBuff >();
	private Map< CFBamMimeTypeByUNameIdxKey,
			CFBamMimeTypeBuff > dictByUNameIdx
		= new HashMap< CFBamMimeTypeByUNameIdxKey,
			CFBamMimeTypeBuff >();

	public CFBamRamMimeTypeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createMimeType( CFBamAuthorization Authorization,
		CFBamMimeTypeBuff Buff )
	{
		final String S_ProcName = "createMimeType";
		CFBamMimeTypePKey pkey = schema.getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( schema.nextMimeTypeIdGen() );
		Buff.setRequiredMimeTypeId( pkey.getRequiredMimeTypeId() );
		CFBamMimeTypeByUNameIdxKey keyUNameIdx = schema.getFactoryMimeType().newUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MimeTypeUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamMimeTypeBuff readDerived( CFBamAuthorization Authorization,
		CFBamMimeTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamMimeType.readDerived() ";
		CFBamMimeTypePKey key = schema.getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( PKey.getRequiredMimeTypeId() );
		CFBamMimeTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamMimeTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamMimeType.readDerived() ";
		CFBamMimeTypePKey key = schema.getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( PKey.getRequiredMimeTypeId() );
		CFBamMimeTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamMimeType.readAllDerived() ";
		CFBamMimeTypeBuff[] retList = new CFBamMimeTypeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamMimeTypeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamMimeTypeBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamMimeType.readDerivedByUNameIdx() ";
		CFBamMimeTypeByUNameIdxKey key = schema.getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );

		CFBamMimeTypeBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		int MimeTypeId )
	{
		final String S_ProcName = "CFBamRamMimeType.readDerivedByIdIdx() ";
		CFBamMimeTypePKey key = schema.getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( MimeTypeId );

		CFBamMimeTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff readBuff( CFBamAuthorization Authorization,
		CFBamMimeTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamMimeType.readBuff() ";
		CFBamMimeTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MIME" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamMimeTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamMimeType.readBuff() ";
		CFBamMimeTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MIME" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMimeTypeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamMimeType.readAllBuff() ";
		CFBamMimeTypeBuff buff;
		ArrayList<CFBamMimeTypeBuff> filteredList = new ArrayList<CFBamMimeTypeBuff>();
		CFBamMimeTypeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "MIME" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamMimeTypeBuff[0] ) );
	}

	public CFBamMimeTypeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		int MimeTypeId )
	{
		final String S_ProcName = "CFBamRamMimeType.readBuffByIdIdx() ";
		CFBamMimeTypeBuff buff = readDerivedByIdIdx( Authorization,
			MimeTypeId );
		if( ( buff != null ) && buff.getClassCode().equals( "MIME" ) ) {
			return( (CFBamMimeTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamMimeTypeBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFBamRamMimeType.readBuffByUNameIdx() ";
		CFBamMimeTypeBuff buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "MIME" ) ) {
			return( (CFBamMimeTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateMimeType( CFBamAuthorization Authorization,
		CFBamMimeTypeBuff Buff )
	{
		CFBamMimeTypePKey pkey = schema.getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( Buff.getRequiredMimeTypeId() );
		CFBamMimeTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateMimeType",
				"Existing record not found",
				"MimeType",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateMimeType",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamMimeTypeByUNameIdxKey existingKeyUNameIdx = schema.getFactoryMimeType().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamMimeTypeByUNameIdxKey newKeyUNameIdx = schema.getFactoryMimeType().newUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateMimeType",
					"MimeTypeUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamMimeTypePKey, CFBamMimeTypeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteMimeType( CFBamAuthorization Authorization,
		CFBamMimeTypeBuff Buff )
	{
		final String S_ProcName = "CFBamRamMimeTypeTable.deleteMimeType() ";
		CFBamMimeTypePKey pkey = schema.getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( Buff.getRequiredMimeTypeId() );
		CFBamMimeTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteMimeType",
				pkey );
		}
		CFBamMimeTypeByUNameIdxKey keyUNameIdx = schema.getFactoryMimeType().newUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamMimeTypePKey, CFBamMimeTypeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteMimeTypeByIdIdx( CFBamAuthorization Authorization,
		int argMimeTypeId )
	{
		CFBamMimeTypePKey key = schema.getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( argMimeTypeId );
		deleteMimeTypeByIdIdx( Authorization, key );
	}

	public void deleteMimeTypeByIdIdx( CFBamAuthorization Authorization,
		CFBamMimeTypePKey argKey )
	{
		CFBamMimeTypeBuff cur;
		LinkedList<CFBamMimeTypeBuff> matchSet = new LinkedList<CFBamMimeTypeBuff>();
		Iterator<CFBamMimeTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMimeTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMimeType( Authorization, cur );
		}
	}

	public void deleteMimeTypeByUNameIdx( CFBamAuthorization Authorization,
		String argName )
	{
		CFBamMimeTypeByUNameIdxKey key = schema.getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( argName );
		deleteMimeTypeByUNameIdx( Authorization, key );
	}

	public void deleteMimeTypeByUNameIdx( CFBamAuthorization Authorization,
		CFBamMimeTypeByUNameIdxKey argKey )
	{
		CFBamMimeTypeBuff cur;
		LinkedList<CFBamMimeTypeBuff> matchSet = new LinkedList<CFBamMimeTypeBuff>();
		Iterator<CFBamMimeTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMimeTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMimeType( Authorization, cur );
		}
	}

	public CFBamCursor openMimeTypeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamMimeTypeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeMimeTypeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamMimeTypeBuff nextMimeTypeCursor( CFBamCursor Cursor ) {
		CFBamRamMimeTypeCursor cursor = (CFBamRamMimeTypeCursor)Cursor;
		CFBamMimeTypeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamMimeTypeBuff prevMimeTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamMimeTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMimeTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMimeTypeBuff firstMimeTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamMimeTypeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMimeTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMimeTypeBuff lastMimeTypeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastMimeTypeCursor" );
	}

	public CFBamMimeTypeBuff nthMimeTypeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamMimeTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMimeTypeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
