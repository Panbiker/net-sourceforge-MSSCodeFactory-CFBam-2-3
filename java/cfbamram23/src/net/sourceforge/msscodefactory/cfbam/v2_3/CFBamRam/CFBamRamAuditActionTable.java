
// Description: Java7 in-memory RAM DbIO implementation for AuditAction.

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
 *	CFBamRamAuditActionTable in-memory RAM DbIO implementation
 *	for AuditAction.
 */
public class CFBamRamAuditActionTable
	implements ICFBamAuditActionTable
{
	private CFBamRamSchema schema;
	private Map< CFBamAuditActionPKey,
				CFBamAuditActionBuff > dictByPKey
		= new HashMap< CFBamAuditActionPKey,
				CFBamAuditActionBuff >();
	private Map< CFBamAuditActionByUDescrIdxKey,
			CFBamAuditActionBuff > dictByUDescrIdx
		= new HashMap< CFBamAuditActionByUDescrIdxKey,
			CFBamAuditActionBuff >();

	public CFBamRamAuditActionTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createAuditAction( CFBamAuthorization Authorization,
		CFBamAuditActionBuff Buff )
	{
		final String S_ProcName = "createAuditAction";
		CFBamAuditActionPKey pkey = schema.getFactoryAuditAction().newPKey();
		pkey.setRequiredAuditActionId( Buff.getRequiredAuditActionId() );
		Buff.setRequiredAuditActionId( pkey.getRequiredAuditActionId() );
		CFBamAuditActionByUDescrIdxKey keyUDescrIdx = schema.getFactoryAuditAction().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"AuditActionUDescrIdx",
				keyUDescrIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

	}

	public CFBamAuditActionBuff readDerived( CFBamAuthorization Authorization,
		CFBamAuditActionPKey PKey )
	{
		final String S_ProcName = "CFBamRamAuditAction.readDerived() ";
		CFBamAuditActionPKey key = schema.getFactoryAuditAction().newPKey();
		key.setRequiredAuditActionId( PKey.getRequiredAuditActionId() );
		CFBamAuditActionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamAuditActionPKey PKey )
	{
		final String S_ProcName = "CFBamRamAuditAction.readDerived() ";
		CFBamAuditActionPKey key = schema.getFactoryAuditAction().newPKey();
		key.setRequiredAuditActionId( PKey.getRequiredAuditActionId() );
		CFBamAuditActionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamAuditAction.readAllDerived() ";
		CFBamAuditActionBuff[] retList = new CFBamAuditActionBuff[ dictByPKey.values().size() ];
		Iterator< CFBamAuditActionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamAuditActionBuff readDerivedByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamAuditAction.readDerivedByUDescrIdx() ";
		CFBamAuditActionByUDescrIdxKey key = schema.getFactoryAuditAction().newUDescrIdxKey();
		key.setRequiredDescription( Description );

		CFBamAuditActionBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short AuditActionId )
	{
		final String S_ProcName = "CFBamRamAuditAction.readDerivedByIdIdx() ";
		CFBamAuditActionPKey key = schema.getFactoryAuditAction().newPKey();
		key.setRequiredAuditActionId( AuditActionId );

		CFBamAuditActionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff readBuff( CFBamAuthorization Authorization,
		CFBamAuditActionPKey PKey )
	{
		final String S_ProcName = "CFBamRamAuditAction.readBuff() ";
		CFBamAuditActionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "AUDT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamAuditActionPKey PKey )
	{
		final String S_ProcName = "CFBamRamAuditAction.readBuff() ";
		CFBamAuditActionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "AUDT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAuditActionBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamAuditAction.readAllBuff() ";
		CFBamAuditActionBuff buff;
		ArrayList<CFBamAuditActionBuff> filteredList = new ArrayList<CFBamAuditActionBuff>();
		CFBamAuditActionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "AUDT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamAuditActionBuff[0] ) );
	}

	public CFBamAuditActionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short AuditActionId )
	{
		final String S_ProcName = "CFBamRamAuditAction.readBuffByIdIdx() ";
		CFBamAuditActionBuff buff = readDerivedByIdIdx( Authorization,
			AuditActionId );
		if( ( buff != null ) && buff.getClassCode().equals( "AUDT" ) ) {
			return( (CFBamAuditActionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAuditActionBuff readBuffByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamAuditAction.readBuffByUDescrIdx() ";
		CFBamAuditActionBuff buff = readDerivedByUDescrIdx( Authorization,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "AUDT" ) ) {
			return( (CFBamAuditActionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateAuditAction( CFBamAuthorization Authorization,
		CFBamAuditActionBuff Buff )
	{
		CFBamAuditActionPKey pkey = schema.getFactoryAuditAction().newPKey();
		pkey.setRequiredAuditActionId( Buff.getRequiredAuditActionId() );
		CFBamAuditActionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateAuditAction",
				"Existing record not found",
				"AuditAction",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateAuditAction",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamAuditActionByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryAuditAction().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFBamAuditActionByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryAuditAction().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Check unique indexes

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateAuditAction",
					"AuditActionUDescrIdx",
					newKeyUDescrIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamAuditActionPKey, CFBamAuditActionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

	}

	public void deleteAuditAction( CFBamAuthorization Authorization,
		CFBamAuditActionBuff Buff )
	{
		final String S_ProcName = "CFBamRamAuditActionTable.deleteAuditAction() ";
		CFBamAuditActionPKey pkey = schema.getFactoryAuditAction().newPKey();
		pkey.setRequiredAuditActionId( Buff.getRequiredAuditActionId() );
		CFBamAuditActionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteAuditAction",
				pkey );
		}
		CFBamAuditActionByUDescrIdxKey keyUDescrIdx = schema.getFactoryAuditAction().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamAuditActionPKey, CFBamAuditActionBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUDescrIdx.remove( keyUDescrIdx );

	}

	public void deleteAuditActionByIdIdx( CFBamAuthorization Authorization,
		short argAuditActionId )
	{
		CFBamAuditActionPKey key = schema.getFactoryAuditAction().newPKey();
		key.setRequiredAuditActionId( argAuditActionId );
		deleteAuditActionByIdIdx( Authorization, key );
	}

	public void deleteAuditActionByIdIdx( CFBamAuthorization Authorization,
		CFBamAuditActionPKey argKey )
	{
		CFBamAuditActionBuff cur;
		LinkedList<CFBamAuditActionBuff> matchSet = new LinkedList<CFBamAuditActionBuff>();
		Iterator<CFBamAuditActionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAuditActionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAuditAction( Authorization, cur );
		}
	}

	public void deleteAuditActionByUDescrIdx( CFBamAuthorization Authorization,
		String argDescription )
	{
		CFBamAuditActionByUDescrIdxKey key = schema.getFactoryAuditAction().newUDescrIdxKey();
		key.setRequiredDescription( argDescription );
		deleteAuditActionByUDescrIdx( Authorization, key );
	}

	public void deleteAuditActionByUDescrIdx( CFBamAuthorization Authorization,
		CFBamAuditActionByUDescrIdxKey argKey )
	{
		CFBamAuditActionBuff cur;
		LinkedList<CFBamAuditActionBuff> matchSet = new LinkedList<CFBamAuditActionBuff>();
		Iterator<CFBamAuditActionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAuditActionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteAuditAction( Authorization, cur );
		}
	}

	public CFBamCursor openAuditActionCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamAuditActionCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeAuditActionCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamAuditActionBuff nextAuditActionCursor( CFBamCursor Cursor ) {
		CFBamRamAuditActionCursor cursor = (CFBamRamAuditActionCursor)Cursor;
		CFBamAuditActionBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamAuditActionBuff prevAuditActionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamAuditActionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAuditActionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAuditActionBuff firstAuditActionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamAuditActionBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAuditActionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAuditActionBuff lastAuditActionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastAuditActionCursor" );
	}

	public CFBamAuditActionBuff nthAuditActionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamAuditActionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAuditActionCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
