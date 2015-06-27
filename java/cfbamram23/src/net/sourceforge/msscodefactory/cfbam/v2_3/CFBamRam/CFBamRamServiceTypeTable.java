
// Description: Java7 in-memory RAM DbIO implementation for ServiceType.

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
 *	CFBamRamServiceTypeTable in-memory RAM DbIO implementation
 *	for ServiceType.
 */
public class CFBamRamServiceTypeTable
	implements ICFBamServiceTypeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamServiceTypePKey,
				CFBamServiceTypeBuff > dictByPKey
		= new HashMap< CFBamServiceTypePKey,
				CFBamServiceTypeBuff >();
	private Map< CFBamServiceTypeByUDescrIdxKey,
			CFBamServiceTypeBuff > dictByUDescrIdx
		= new HashMap< CFBamServiceTypeByUDescrIdxKey,
			CFBamServiceTypeBuff >();

	public CFBamRamServiceTypeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createServiceType( CFBamAuthorization Authorization,
		CFBamServiceTypeBuff Buff )
	{
		final String S_ProcName = "createServiceType";
		CFBamServiceTypePKey pkey = schema.getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( schema.nextServiceTypeIdGen() );
		Buff.setRequiredServiceTypeId( pkey.getRequiredServiceTypeId() );
		CFBamServiceTypeByUDescrIdxKey keyUDescrIdx = schema.getFactoryServiceType().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ServiceTypeUDescrIdx",
				keyUDescrIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

	}

	public CFBamServiceTypeBuff readDerived( CFBamAuthorization Authorization,
		CFBamServiceTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamServiceType.readDerived() ";
		CFBamServiceTypePKey key = schema.getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( PKey.getRequiredServiceTypeId() );
		CFBamServiceTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamServiceTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamServiceType.readDerived() ";
		CFBamServiceTypePKey key = schema.getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( PKey.getRequiredServiceTypeId() );
		CFBamServiceTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamServiceType.readAllDerived() ";
		CFBamServiceTypeBuff[] retList = new CFBamServiceTypeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServiceTypeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServiceTypeBuff readDerivedByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamServiceType.readDerivedByUDescrIdx() ";
		CFBamServiceTypeByUDescrIdxKey key = schema.getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );

		CFBamServiceTypeBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamServiceType.readDerivedByIdIdx() ";
		CFBamServiceTypePKey key = schema.getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( ServiceTypeId );

		CFBamServiceTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff readBuff( CFBamAuthorization Authorization,
		CFBamServiceTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamServiceType.readBuff() ";
		CFBamServiceTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SVCT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamServiceTypePKey PKey )
	{
		final String S_ProcName = "CFBamRamServiceType.readBuff() ";
		CFBamServiceTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SVCT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceTypeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamServiceType.readAllBuff() ";
		CFBamServiceTypeBuff buff;
		ArrayList<CFBamServiceTypeBuff> filteredList = new ArrayList<CFBamServiceTypeBuff>();
		CFBamServiceTypeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SVCT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServiceTypeBuff[0] ) );
	}

	public CFBamServiceTypeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamServiceType.readBuffByIdIdx() ";
		CFBamServiceTypeBuff buff = readDerivedByIdIdx( Authorization,
			ServiceTypeId );
		if( ( buff != null ) && buff.getClassCode().equals( "SVCT" ) ) {
			return( (CFBamServiceTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServiceTypeBuff readBuffByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamServiceType.readBuffByUDescrIdx() ";
		CFBamServiceTypeBuff buff = readDerivedByUDescrIdx( Authorization,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "SVCT" ) ) {
			return( (CFBamServiceTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateServiceType( CFBamAuthorization Authorization,
		CFBamServiceTypeBuff Buff )
	{
		CFBamServiceTypePKey pkey = schema.getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );
		CFBamServiceTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateServiceType",
				"Existing record not found",
				"ServiceType",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateServiceType",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamServiceTypeByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryServiceType().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFBamServiceTypeByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryServiceType().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Check unique indexes

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateServiceType",
					"ServiceTypeUDescrIdx",
					newKeyUDescrIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamServiceTypePKey, CFBamServiceTypeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

	}

	public void deleteServiceType( CFBamAuthorization Authorization,
		CFBamServiceTypeBuff Buff )
	{
		final String S_ProcName = "CFBamRamServiceTypeTable.deleteServiceType() ";
		CFBamServiceTypePKey pkey = schema.getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );
		CFBamServiceTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteServiceType",
				pkey );
		}
		CFBamServiceTypeByUDescrIdxKey keyUDescrIdx = schema.getFactoryServiceType().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableService().deleteServiceByTypeIdx( Authorization,
			Buff.getRequiredServiceTypeId() );
		Map< CFBamServiceTypePKey, CFBamServiceTypeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUDescrIdx.remove( keyUDescrIdx );

	}

	public void deleteServiceTypeByIdIdx( CFBamAuthorization Authorization,
		int argServiceTypeId )
	{
		CFBamServiceTypePKey key = schema.getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( argServiceTypeId );
		deleteServiceTypeByIdIdx( Authorization, key );
	}

	public void deleteServiceTypeByIdIdx( CFBamAuthorization Authorization,
		CFBamServiceTypePKey argKey )
	{
		CFBamServiceTypeBuff cur;
		LinkedList<CFBamServiceTypeBuff> matchSet = new LinkedList<CFBamServiceTypeBuff>();
		Iterator<CFBamServiceTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServiceType( Authorization, cur );
		}
	}

	public void deleteServiceTypeByUDescrIdx( CFBamAuthorization Authorization,
		String argDescription )
	{
		CFBamServiceTypeByUDescrIdxKey key = schema.getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( argDescription );
		deleteServiceTypeByUDescrIdx( Authorization, key );
	}

	public void deleteServiceTypeByUDescrIdx( CFBamAuthorization Authorization,
		CFBamServiceTypeByUDescrIdxKey argKey )
	{
		CFBamServiceTypeBuff cur;
		LinkedList<CFBamServiceTypeBuff> matchSet = new LinkedList<CFBamServiceTypeBuff>();
		Iterator<CFBamServiceTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServiceType( Authorization, cur );
		}
	}

	public CFBamCursor openServiceTypeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServiceTypeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeServiceTypeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServiceTypeBuff nextServiceTypeCursor( CFBamCursor Cursor ) {
		CFBamRamServiceTypeCursor cursor = (CFBamRamServiceTypeCursor)Cursor;
		CFBamServiceTypeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServiceTypeBuff prevServiceTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServiceTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServiceTypeBuff firstServiceTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServiceTypeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServiceTypeBuff lastServiceTypeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServiceTypeCursor" );
	}

	public CFBamServiceTypeBuff nthServiceTypeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServiceTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceTypeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
