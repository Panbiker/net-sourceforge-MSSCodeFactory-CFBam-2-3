
// Description: Java7 in-memory RAM DbIO implementation for ServerProc.

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
 *	CFBamRamServerProcTable in-memory RAM DbIO implementation
 *	for ServerProc.
 */
public class CFBamRamServerProcTable
	implements ICFBamServerProcTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamServerProcBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamServerProcBuff >();

	public CFBamRamServerProcTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createServerProc( CFBamAuthorization Authorization,
		CFBamServerProcBuff Buff )
	{
		final String S_ProcName = "createServerProc";
		schema.getTableServerMethod().createServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"ServerMethod",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamServerProcBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerProc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerProcBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerProcBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerProc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerProcBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerProcBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamServerProc.readAllDerived() ";
		CFBamServerProcBuff[] retList = new CFBamServerProcBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServerProcBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServerProcBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByTenantIdx() ";
		CFBamScopeBuff buffList[] = schema.getTableScope().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamScopeBuff buff;
			ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerProcBuff ) ) {
					filteredList.add( (CFBamServerProcBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
		}
	}

	public CFBamServerProcBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByUNameIdx() ";
		CFBamServerMethodBuff buff = schema.getTableServerMethod().readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFBamServerProcBuff ) {
			return( (CFBamServerProcBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerProcBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByTableIdx() ";
		CFBamServerMethodBuff buffList[] = schema.getTableServerMethod().readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamServerMethodBuff buff;
			ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerProcBuff ) ) {
					filteredList.add( (CFBamServerProcBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
		}
	}

	public CFBamServerProcBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readDerivedByDefSchemaIdx() ";
		CFBamServerMethodBuff buffList[] = schema.getTableServerMethod().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamServerMethodBuff buff;
			ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerProcBuff ) ) {
					filteredList.add( (CFBamServerProcBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
		}
	}

	public CFBamServerProcBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamServerProcBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerProcBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerProc.readBuff() ";
		CFBamServerProcBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerProcBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerProc.readBuff() ";
		CFBamServerProcBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerProcBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamServerProc.readAllBuff() ";
		CFBamServerProcBuff buff;
		ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
		CFBamServerProcBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
	}

	public CFBamServerProcBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamServerProcBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerProcBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamServerProcBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
	}

	public CFBamServerProcBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByUNameIdx() ";
		CFBamServerMethodBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			TableId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
			return( (CFBamServerProcBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerProcBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByTableIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerProcBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
	}

	public CFBamServerProcBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByDefSchemaIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerProcBuff> filteredList = new ArrayList<CFBamServerProcBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerProcBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerProcBuff[0] ) );
	}

	public void updateServerProc( CFBamAuthorization Authorization,
		CFBamServerProcBuff Buff )
	{
		schema.getTableServerMethod().updateServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerProcBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateServerProc",
				"Existing record not found",
				"ServerProc",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateServerProc",
						"Superclass",
						"SuperClass",
						"ServerMethod",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamServerProcBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteServerProc( CFBamAuthorization Authorization,
		CFBamServerProcBuff Buff )
	{
		final String S_ProcName = "CFBamRamServerProcTable.deleteServerProc() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerProcBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteServerProc",
				pkey );
		}

		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamServerProcBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}

	public void deleteServerProcByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamServerMethodByUNameIdxKey key = schema.getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerProcByUNameIdx( Authorization, key );
	}

	public void deleteServerProcByUNameIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey )
	{
		CFBamServerProcBuff cur;
		LinkedList<CFBamServerProcBuff> matchSet = new LinkedList<CFBamServerProcBuff>();
		Iterator<CFBamServerProcBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerProcBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerProc( Authorization, cur );
		}
	}

	public void deleteServerProcByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteServerProcByTableIdx( Authorization, key );
	}

	public void deleteServerProcByTableIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByTableIdxKey argKey )
	{
		CFBamServerProcBuff cur;
		LinkedList<CFBamServerProcBuff> matchSet = new LinkedList<CFBamServerProcBuff>();
		Iterator<CFBamServerProcBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerProcBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerProc( Authorization, cur );
		}
	}

	public void deleteServerProcByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerProcByDefSchemaIdx( Authorization, key );
	}

	public void deleteServerProcByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey )
	{
		CFBamServerProcBuff cur;
		LinkedList<CFBamServerProcBuff> matchSet = new LinkedList<CFBamServerProcBuff>();
		Iterator<CFBamServerProcBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerProcBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerProc( Authorization, cur );
		}
	}

	public void deleteServerProcByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteServerProcByIdIdx( Authorization, key );
	}

	public void deleteServerProcByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamServerProcBuff cur;
		LinkedList<CFBamServerProcBuff> matchSet = new LinkedList<CFBamServerProcBuff>();
		Iterator<CFBamServerProcBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerProcBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerProc( Authorization, cur );
		}
	}

	public void deleteServerProcByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerProcByTenantIdx( Authorization, key );
	}

	public void deleteServerProcByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamServerProcBuff cur;
		LinkedList<CFBamServerProcBuff> matchSet = new LinkedList<CFBamServerProcBuff>();
		Iterator<CFBamServerProcBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerProcBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerProc( Authorization, cur );
		}
	}

	public CFBamCursor openServerProcCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServerProcCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeServerProcCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServerProcBuff nextServerProcCursor( CFBamCursor Cursor ) {
		CFBamRamServerProcCursor cursor = (CFBamRamServerProcCursor)Cursor;
		CFBamServerProcBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServerProcBuff prevServerProcCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServerProcBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerProcCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerProcBuff firstServerProcCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServerProcBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerProcCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerProcBuff lastServerProcCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServerProcCursor" );
	}

	public CFBamServerProcBuff nthServerProcCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServerProcBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerProcCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
