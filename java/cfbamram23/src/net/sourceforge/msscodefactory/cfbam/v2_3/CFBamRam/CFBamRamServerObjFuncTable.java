
// Description: Java7 in-memory RAM DbIO implementation for ServerObjFunc.

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
 *	CFBamRamServerObjFuncTable in-memory RAM DbIO implementation
 *	for ServerObjFunc.
 */
public class CFBamRamServerObjFuncTable
	implements ICFBamServerObjFuncTable
{
	private CFBamRamSchema schema;
	private Map< CFBamScopePKey,
				CFBamServerObjFuncBuff > dictByPKey
		= new HashMap< CFBamScopePKey,
				CFBamServerObjFuncBuff >();
	private Map< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey,
					CFBamServerObjFuncBuff >> dictByRetTblIdx
		= new HashMap< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey,
					CFBamServerObjFuncBuff >>();

	public CFBamRamServerObjFuncTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		final String S_ProcName = "createServerObjFunc";
		schema.getTableServerMethod().createServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx = schema.getFactoryServerObjFunc().newRetTblIdxKey();
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

		Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdictRetTblIdx;
		if( dictByRetTblIdx.containsKey( keyRetTblIdx ) ) {
			subdictRetTblIdx = dictByRetTblIdx.get( keyRetTblIdx );
		}
		else {
			subdictRetTblIdx = new HashMap< CFBamScopePKey, CFBamServerObjFuncBuff >();
			dictByRetTblIdx.put( keyRetTblIdx, subdictRetTblIdx );
		}
		subdictRetTblIdx.put( pkey, Buff );

	}

	public CFBamServerObjFuncBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerObjFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readDerived() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamServerObjFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamServerObjFunc.readAllDerived() ";
		CFBamServerObjFuncBuff[] retList = new CFBamServerObjFuncBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServerObjFuncBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServerObjFuncBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerObjFuncBuff ) ) {
					filteredList.add( (CFBamServerObjFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
		}
	}

	public CFBamServerObjFuncBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamServerObjFuncBuff ) {
			return( (CFBamServerObjFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerObjFuncBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerObjFuncBuff ) ) {
					filteredList.add( (CFBamServerObjFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
		}
	}

	public CFBamServerObjFuncBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamServerObjFuncBuff ) ) {
					filteredList.add( (CFBamServerObjFuncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
		}
	}

	public CFBamServerObjFuncBuff[] readDerivedByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readDerivedByRetTblIdx() ";
		CFBamServerObjFuncByRetTblIdxKey key = schema.getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );

		CFBamServerObjFuncBuff[] recArray;
		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			recArray = new CFBamServerObjFuncBuff[ subdictRetTblIdx.size() ];
			Iterator< CFBamServerObjFuncBuff > iter = subdictRetTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdictRetTblIdx
				= new HashMap< CFBamScopePKey, CFBamServerObjFuncBuff >();
			dictByRetTblIdx.put( key, subdictRetTblIdx );
			recArray = new CFBamServerObjFuncBuff[0];
		}
		return( recArray );
	}

	public CFBamServerObjFuncBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readDerivedByIdIdx() ";
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamServerObjFuncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readBuff() ";
		CFBamServerObjFuncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVO" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readBuff() ";
		CFBamServerObjFuncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SRVO" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServerObjFuncBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readAllBuff() ";
		CFBamServerObjFuncBuff buff;
		ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
		CFBamServerObjFuncBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVO" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
	}

	public CFBamServerObjFuncBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByIdIdx() ";
		CFBamScopeBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
			return( (CFBamServerObjFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerObjFuncBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamScope.readBuffByTenantIdx() ";
		CFBamScopeBuff buff;
		ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
		CFBamScopeBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SCOP" ) ) {
				filteredList.add( (CFBamServerObjFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
	}

	public CFBamServerObjFuncBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamServerObjFuncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServerObjFuncBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByTableIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerObjFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
	}

	public CFBamServerObjFuncBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamServerMethod.readBuffByDefSchemaIdx() ";
		CFBamServerMethodBuff buff;
		ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
		CFBamServerMethodBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVM" ) ) {
				filteredList.add( (CFBamServerObjFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
	}

	public CFBamServerObjFuncBuff[] readBuffByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		final String S_ProcName = "CFBamRamServerObjFunc.readBuffByRetTblIdx() ";
		CFBamServerObjFuncBuff buff;
		ArrayList<CFBamServerObjFuncBuff> filteredList = new ArrayList<CFBamServerObjFuncBuff>();
		CFBamServerObjFuncBuff[] buffList = readDerivedByRetTblIdx( Authorization,
			RetTenantId,
			RetTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SRVO" ) ) {
				filteredList.add( (CFBamServerObjFuncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServerObjFuncBuff[0] ) );
	}

	public void updateServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		schema.getTableServerMethod().updateServerMethod( Authorization,
			Buff );
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerObjFuncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateServerObjFunc",
				"Existing record not found",
				"ServerObjFunc",
				pkey );
		}
		CFBamServerObjFuncByRetTblIdxKey existingKeyRetTblIdx = schema.getFactoryServerObjFunc().newRetTblIdxKey();
		existingKeyRetTblIdx.setOptionalRetTenantId( existing.getOptionalRetTenantId() );
		existingKeyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		CFBamServerObjFuncByRetTblIdxKey newKeyRetTblIdx = schema.getFactoryServerObjFunc().newRetTblIdxKey();
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
						"updateServerObjFunc",
						"Superclass",
						"SuperClass",
						"ServerMethod",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdict;

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
			subdict = new HashMap< CFBamScopePKey, CFBamServerObjFuncBuff >();
			dictByRetTblIdx.put( newKeyRetTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteServerObjFunc( CFBamAuthorization Authorization,
		CFBamServerObjFuncBuff Buff )
	{
		final String S_ProcName = "CFBamRamServerObjFuncTable.deleteServerObjFunc() ";
		CFBamScopePKey pkey = schema.getFactoryScope().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamServerObjFuncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteServerObjFunc",
				pkey );
		}
		CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx = schema.getFactoryServerObjFunc().newRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTenantId( existing.getOptionalRetTenantId() );
		keyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRetTblIdx.get( keyRetTblIdx );
		subdict.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}

	public void deleteServerObjFuncByRetTblIdx( CFBamAuthorization Authorization,
		Long argRetTenantId,
		Long argRetTableId )
	{
		CFBamServerObjFuncByRetTblIdxKey key = schema.getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( argRetTenantId );
		key.setOptionalRetTableId( argRetTableId );
		deleteServerObjFuncByRetTblIdx( Authorization, key );
	}

	public void deleteServerObjFuncByRetTblIdx( CFBamAuthorization Authorization,
		CFBamServerObjFuncByRetTblIdxKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public void deleteServerObjFuncByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName )
	{
		CFBamServerMethodByUNameIdxKey key = schema.getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerObjFuncByUNameIdx( Authorization, key );
	}

	public void deleteServerObjFuncByUNameIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public void deleteServerObjFuncByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamServerMethodByTableIdxKey key = schema.getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteServerObjFuncByTableIdx( Authorization, key );
	}

	public void deleteServerObjFuncByTableIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByTableIdxKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public void deleteServerObjFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = schema.getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerObjFuncByDefSchemaIdx( Authorization, key );
	}

	public void deleteServerObjFuncByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public void deleteServerObjFuncByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamScopePKey key = schema.getFactoryScope().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteServerObjFuncByIdIdx( Authorization, key );
	}

	public void deleteServerObjFuncByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public void deleteServerObjFuncByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerObjFuncByTenantIdx( Authorization, key );
	}

	public void deleteServerObjFuncByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		CFBamServerObjFuncBuff cur;
		LinkedList<CFBamServerObjFuncBuff> matchSet = new LinkedList<CFBamServerObjFuncBuff>();
		Iterator<CFBamServerObjFuncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServerObjFuncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteServerObjFunc( Authorization, cur );
		}
	}

	public CFBamCursor openServerObjFuncCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServerObjFuncCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openServerObjFuncCursorByRetTblIdx( CFBamAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId )
	{
		CFBamCursor cursor;
		CFBamServerObjFuncByRetTblIdxKey key = schema.getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );

		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< CFBamScopePKey, CFBamServerObjFuncBuff > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			cursor = new CFBamRamServerObjFuncCursor( Authorization,
				schema,
				subdictRetTblIdx.values() );
		}
		else {
			cursor = new CFBamRamServerObjFuncCursor( Authorization,
				schema,
				new ArrayList< CFBamServerObjFuncBuff >() );
		}
		return( cursor );
	}

	public void closeServerObjFuncCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServerObjFuncBuff nextServerObjFuncCursor( CFBamCursor Cursor ) {
		CFBamRamServerObjFuncCursor cursor = (CFBamRamServerObjFuncCursor)Cursor;
		CFBamServerObjFuncBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServerObjFuncBuff prevServerObjFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServerObjFuncBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerObjFuncCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerObjFuncBuff firstServerObjFuncCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServerObjFuncBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerObjFuncCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServerObjFuncBuff lastServerObjFuncCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServerObjFuncCursor" );
	}

	public CFBamServerObjFuncBuff nthServerObjFuncCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServerObjFuncBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServerObjFuncCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
