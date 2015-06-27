
// Description: Java7 in-memory RAM DbIO implementation for ServerListFunc.

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
 *	CFBamRamServerListFuncTable in-memory RAM DbIO implementation
 *	for ServerListFunc.
 */
public class CFBamRamServerListFuncTable
	implements ICFBamServerListFuncTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamServerListFuncBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamServerListFuncBuff >();
	private Map< CFBamServerListFuncByRetTblIdxKey,
				Map< CFBamScopePKey,
					CFBamServerListFuncBuff >> dictByRetTblIdx
		= new HashMap< CFBamServerListFuncByRetTblIdxKey,
				Map< CFBamScopePKey,
					CFBamServerListFuncBuff >>();

	public CFBamRamServerListFuncTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createServerListFunc( CFBamAuthorization Authorization,
		CFBamServerListFuncBuff Buff )
	{
		final String S_ProcName = "createServerListFunc";
		schema.getTableServerMethod().createServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerListFuncByRetTblIdxKey keyRetTblIdx = schema.getFactoryServerListFunc().newRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTenantId( Buff.getOptionalRetTenantId() );
		keyRetTblIdx.setOptionalRetTableId( Buff.getOptionalRetTableId() );

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

		Map< CFBamScopePKey, CFBamServerListFuncBuff > subdictRetTblIdx;
		if( dictByRetTblIdx.containsKey( keyRetTblIdx ) ) {
			subdictRetTblIdx = dictByRetTblIdx.get( keyRetTblIdx );
		}
		else {
			subdictRetTblIdx = new HashMap< CFBamScopePKey, CFBamServerListFuncBuff >();
			dictByRetTblIdx.put( keyRetTblIdx, subdictRetTblIdx );
		}
		subdictRetTblIdx.put( pkey, Buff );

	}

	public CFBamServerListFuncBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerListFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerListFuncBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerListFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerListFuncBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamServerListFunc.readAllDerived() ";
		CFBamServerListFuncBuff[] retList = new CFBamServerListFuncBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServerListFuncBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServerListFuncBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerListFuncBuff ) ) {
					filteredList.add( (CFBamServerListFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
		}
	}

	public CFBamServerListFuncBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamServerListFuncBuff ) {
			return( (CFBamServerListFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerListFuncBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerListFuncBuff ) ) {
					filteredList.add( (CFBamServerListFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
		}
	}

	public CFBamServerListFuncBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerListFuncBuff ) ) {
					filteredList.add( (CFBamServerListFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
		}
	}

	public CFBamServerListFuncBuff[] readDerivedByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readDerivedByRetTblIdx() ";
		CFBamServerListFuncByRetTblIdxKey key = schema.getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );

		CFBamServerListFuncBuff[] recArray;
		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerListFuncBuff > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			recArray = new CFBamServerListFuncBuff[ subdictRetTblIdx.size() ];
			Iterator< CFBamServerListFuncBuff > iter = subdictRetTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamServerListFuncBuff > subdictRetTblIdx
				= new HashMap< CFBamScopePKey, CFBamServerListFuncBuff >();
			dictByRetTblIdx.put( key, subdictRetTblIdx );
			recArray = new CFBamServerListFuncBuff[0];
		}
		return( recArray );
	}

	public CFBamServerListFuncBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamServerListFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerListFuncBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readBuff() ";
		CFBamServerListFuncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerListFuncBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readBuff() ";
		CFBamServerListFuncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerListFuncBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readAllBuff() ";
		CFBamServerListFuncBuff buff;
		ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
		CFBamServerListFuncBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
	}

	public CFBamServerListFuncBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamServerListFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerListFuncBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamServerListFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
	}

	public CFBamServerListFuncBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamServerListFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerListFuncBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByTableIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerListFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
	}

	public CFBamServerListFuncBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByDefSchemaIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerListFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
	}

	public CFBamServerListFuncBuff[] readBuffByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "CFBamRamServerListFunc.readBuffByRetTblIdx() ";
		CFBamServerListFuncBuff buff;
		ArrayList<CFBamServerListFuncBuff> filteredList = new ArrayList<CFBamServerListFuncBuff>();
		CFBamServerListFuncBuff[] buffList = readDerivedByRetTblIdx( Authorization,
			RetTenantId,
			RetTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVL" ) ) {
				filteredList.add( (CFBamServerListFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerListFuncBuff[0] ) );
	}

	public void updateServerListFunc( CFBamAuthorization Authorization,
		CFBamServerListFuncBuff Buff )
	{
		schema.getTableServerMethod().updateServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerListFuncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateServerListFunc",
				"Existing record not found",
				"ServerListFunc",
				pkey );
		}
		CFBamServerListFuncByRetTblIdxKey existingKeyRetTblIdx = schema.getFactoryServerListFunc().newRetTblIdxKey();
		existingKeyRetTblIdx.setOptionalRetTenantId( existing.getOptionalRetTenantId() );
		existingKeyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		CFBamServerListFuncByRetTblIdxKey newKeyRetTblIdx = schema.getFactoryServerListFunc().newRetTblIdxKey();
		newKeyRetTblIdx.setOptionalRetTenantId( Buff.getOptionalRetTenantId() );
		newKeyRetTblIdx.setOptionalRetTableId( Buff.getOptionalRetTableId() );

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
						"updateServerListFunc",
						"Superclass",
						"SuperClass",
						"ServerMethod",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamServerListFuncBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByRetTblIdx.get( existingKeyRetTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRetTblIdx.containsKey( newKeyRetTblIdx ) ) {
			subdict = dictByRetTblIdx.get( newKeyRetTblIdx );
		}
		else {
			subdict = new HashMap< CFBamScopePKey, CFBamServerListFuncBuff >();
			dictByRetTblIdx.put( newKeyRetTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteServerListFunc( CFBamAuthorization Authorization,
		CFBamServerListFuncBuff Buff )
	{
		final String S_ProcName = "CFBamRamServerListFuncTable.deleteServerListFunc() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerListFuncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteServerListFunc",
				pkey );
		}
		CFBamServerListFuncByRetTblIdxKey keyRetTblIdx = schema.getFactoryServerListFunc().newRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTenantId( existing.getOptionalRetTenantId() );
		keyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamServerListFuncBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRetTblIdx.get( keyRetTblIdx );
		subdict.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}

	public void deleteServerListFuncByRetTblIdx( CFBamAuthorization Authorization,
		Long argRetTenantId,
		Long argRetTableId )
	{
		CFBamServerListFuncByRetTblIdxKey key = schema.getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( argRetTenantId );
		key.setOptionalRetTableId( argRetTableId );
		deleteServerListFuncByRetTblIdx( Authorization, key );
	}

	public void deleteServerListFuncByRetTblIdx( CFBamAuthorization Authorization,
		CFBamServerListFuncByRetTblIdxKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public void deleteServerListFuncByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamServerMethodByUNameIdxKey key = schema.getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerListFuncByUNameIdx( Authorization, key );
	}

	public void deleteServerListFuncByUNameIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public void deleteServerListFuncByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteServerListFuncByTableIdx( Authorization, key );
	}

	public void deleteServerListFuncByTableIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByTableIdxKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public void deleteServerListFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerListFuncByDefSchemaIdx( Authorization, key );
	}

	public void deleteServerListFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public void deleteServerListFuncByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteServerListFuncByIdIdx( Authorization, key );
	}

	public void deleteServerListFuncByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public void deleteServerListFuncByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerListFuncByTenantIdx( Authorization, key );
	}

	public void deleteServerListFuncByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamServerListFuncBuff cur;
		LinkedList<CFBamServerListFuncBuff> matchSet = new LinkedList<CFBamServerListFuncBuff>();
		Iterator<CFBamServerListFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerListFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerListFunc( Authorization, cur );
		}
	}

	public CFBamCursor openServerListFuncCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServerListFuncCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openServerListFuncCursorByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		CFBamCursor cursor;
		CFBamServerListFuncByRetTblIdxKey key = schema.getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );

		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerListFuncBuff > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			cursor = new CFBamRamServerListFuncCursor( Authorization,
				schema,
				subdictRetTblIdx.values() );
		}
		else {
			cursor = new CFBamRamServerListFuncCursor( Authorization,
				schema,
				new ArrayList< CFBamServerListFuncBuff >() );
		}
		return( cursor );
	}

	public void closeServerListFuncCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServerListFuncBuff nextServerListFuncCursor( CFBamCursor Cursor ) {
		CFBamRamServerListFuncCursor cursor = (CFBamRamServerListFuncCursor)Cursor;
		CFBamServerListFuncBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServerListFuncBuff prevServerListFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServerListFuncBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerListFuncCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerListFuncBuff firstServerListFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServerListFuncBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerListFuncCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerListFuncBuff lastServerListFuncCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServerListFuncCursor" );
	}

	public CFBamServerListFuncBuff nthServerListFuncCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServerListFuncBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerListFuncCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
