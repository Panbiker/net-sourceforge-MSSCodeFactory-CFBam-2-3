
// Description: Java7 in-memory RAM DbIO implementation for Cluster.

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
 *	CFBamRamClusterTable in-memory RAM DbIO implementation
 *	for Cluster.
 */
public class CFBamRamClusterTable
	implements ICFBamClusterTable
{
	private CFBamRamSchema schema;
	private Map< CFBamClusterPKey,
				CFBamClusterBuff > dictByPKey
		= new HashMap< CFBamClusterPKey,
				CFBamClusterBuff >();
	private Map< CFBamClusterByUDomainNameIdxKey,
			CFBamClusterBuff > dictByUDomainNameIdx
		= new HashMap< CFBamClusterByUDomainNameIdxKey,
			CFBamClusterBuff >();
	private Map< CFBamClusterByUDescrIdxKey,
			CFBamClusterBuff > dictByUDescrIdx
		= new HashMap< CFBamClusterByUDescrIdxKey,
			CFBamClusterBuff >();
	private Map< CFBamRamClusterId32Gen,
				CFBamRamClusterId32Gen > id32Generator
		= new HashMap< CFBamRamClusterId32Gen,
				CFBamRamClusterId32Gen >();
	private Map< CFBamRamClusterId64Gen,
				CFBamRamClusterId64Gen > id64Generator
		= new HashMap< CFBamRamClusterId64Gen,
				CFBamRamClusterId64Gen >();

	public CFBamRamClusterTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	protected int generateNextId32( long argId,
		short argSliceId )
	{
		CFBamRamClusterId32Gen key = new CFBamRamClusterId32Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFBamRamClusterId32Gen useGen = id32Generator.get( key );
		if( useGen == null ) {
			id32Generator.put( key, key );
			useGen = key;
		}

		int retNext = useGen.getNextId();

		return( retNext );
	}

	protected long generateNextId64( long argId,
		short argSliceId )
	{
		CFBamRamClusterId64Gen key = new CFBamRamClusterId64Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFBamRamClusterId64Gen useGen = id64Generator.get( key );
		if( useGen == null ) {
			id64Generator.put( key, key );
			useGen = key;
		}

		long retNext = useGen.getNextId();

		return( retNext );
	}

	public int nextSecAppIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		int retval = nextSecAppIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecAppIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)103 );
		return( retNext );
	}

	public int nextSecFormIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		int retval = nextSecFormIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecFormIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)104 );
		return( retNext );
	}

	public int nextSecGroupIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		int retval = nextSecGroupIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecGroupIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)105 );
		return( retNext );
	}

	public long nextSecGroupMemberIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		long retval = nextSecGroupMemberIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGroupMemberIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)106 );
		return( retNext );
	}

	public long nextSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		long retval = nextSecGroupIncludeIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGroupIncludeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)107 );
		return( retNext );
	}

	public long nextSecGroupFormIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		long retval = nextSecGroupFormIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGroupFormIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)108 );
		return( retNext );
	}

	public long nextServiceIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		long retval = nextServiceIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextServiceIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)111 );
		return( retNext );
	}

	public long nextHostNodeIdGen( CFBamAuthorization Authorization,
		CFBamClusterPKey pkey )
	{
		long retval = nextHostNodeIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextHostNodeIdGen( CFBamAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)112 );
		return( retNext );
	}

	public void createCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		final String S_ProcName = "createCluster";
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( schema.nextClusterIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx = schema.getFactoryCluster().newUDomainNameIdxKey();
		keyUDomainNameIdx.setRequiredFullDomainName( Buff.getRequiredFullDomainName() );

		CFBamClusterByUDescrIdxKey keyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDomainNameIdx.containsKey( keyUDomainNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClusterUDomainNameIdx",
				keyUDomainNameIdx );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClusterUDescrNameIdx",
				keyUDescrIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUDomainNameIdx.put( keyUDomainNameIdx, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

	}

	public CFBamClusterBuff readDerived( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamCluster.readDerived() ";
		CFBamClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff lockDerived( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamCluster.readDerived() ";
		CFBamClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFBamClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamCluster.readAllDerived() ";
		CFBamClusterBuff[] retList = new CFBamClusterBuff[ dictByPKey.values().size() ];
		Iterator< CFBamClusterBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamClusterBuff readDerivedByUDomainNameIdx( CFBamAuthorization Authorization,
		String FullDomainName )
	{
		final String S_ProcName = "CFBamRamCluster.readDerivedByUDomainNameIdx() ";
		CFBamClusterByUDomainNameIdxKey key = schema.getFactoryCluster().newUDomainNameIdxKey();
		key.setRequiredFullDomainName( FullDomainName );

		CFBamClusterBuff buff;
		if( dictByUDomainNameIdx.containsKey( key ) ) {
			buff = dictByUDomainNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff readDerivedByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamCluster.readDerivedByUDescrIdx() ";
		CFBamClusterByUDescrIdxKey key = schema.getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );

		CFBamClusterBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamRamCluster.readDerivedByIdIdx() ";
		CFBamClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( Id );

		CFBamClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff readBuff( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamCluster.readBuff() ";
		CFBamClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLUS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff lockBuff( CFBamAuthorization Authorization,
		CFBamClusterPKey PKey )
	{
		final String S_ProcName = "CFBamRamCluster.readBuff() ";
		CFBamClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLUS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamClusterBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamCluster.readAllBuff() ";
		CFBamClusterBuff buff;
		ArrayList<CFBamClusterBuff> filteredList = new ArrayList<CFBamClusterBuff>();
		CFBamClusterBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamClusterBuff[0] ) );
	}

	public CFBamClusterBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamRamCluster.readBuffByIdIdx() ";
		CFBamClusterBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFBamClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClusterBuff readBuffByUDomainNameIdx( CFBamAuthorization Authorization,
		String FullDomainName )
	{
		final String S_ProcName = "CFBamRamCluster.readBuffByUDomainNameIdx() ";
		CFBamClusterBuff buff = readDerivedByUDomainNameIdx( Authorization,
			FullDomainName );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFBamClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamClusterBuff readBuffByUDescrIdx( CFBamAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFBamRamCluster.readBuffByUDescrIdx() ";
		CFBamClusterBuff buff = readDerivedByUDescrIdx( Authorization,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFBamClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateCluster",
				"Existing record not found",
				"Cluster",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateCluster",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamClusterByUDomainNameIdxKey existingKeyUDomainNameIdx = schema.getFactoryCluster().newUDomainNameIdxKey();
		existingKeyUDomainNameIdx.setRequiredFullDomainName( existing.getRequiredFullDomainName() );

		CFBamClusterByUDomainNameIdxKey newKeyUDomainNameIdx = schema.getFactoryCluster().newUDomainNameIdxKey();
		newKeyUDomainNameIdx.setRequiredFullDomainName( Buff.getRequiredFullDomainName() );

		CFBamClusterByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFBamClusterByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Check unique indexes

		if( ! existingKeyUDomainNameIdx.equals( newKeyUDomainNameIdx ) ) {
			if( dictByUDomainNameIdx.containsKey( newKeyUDomainNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateCluster",
					"ClusterUDomainNameIdx",
					newKeyUDomainNameIdx );
			}
		}

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateCluster",
					"ClusterUDescrNameIdx",
					newKeyUDescrIdx );
			}
		}

		// Validate foreign keys

		// Update is valid
			
		Map< CFBamClusterPKey, CFBamClusterBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUDomainNameIdx.remove( existingKeyUDomainNameIdx );
		dictByUDomainNameIdx.put( newKeyUDomainNameIdx, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

	}

	public void deleteCluster( CFBamAuthorization Authorization,
		CFBamClusterBuff Buff )
	{
		final String S_ProcName = "CFBamRamClusterTable.deleteCluster() ";
		CFBamClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteCluster",
				pkey );
		}
		CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx = schema.getFactoryCluster().newUDomainNameIdxKey();
		keyUDomainNameIdx.setRequiredFullDomainName( existing.getRequiredFullDomainName() );

		CFBamClusterByUDescrIdxKey keyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableHostNode().deleteHostNodeByClusterIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableTenant().deleteTenantByClusterIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableSecApp().deleteSecAppByClusterIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableSecGroup().deleteSecGroupByClusterIdx( Authorization,
			Buff.getRequiredId() );
		schema.getTableSysCluster().deleteSysClusterByClusterIdx( Authorization,
			Buff.getRequiredId() );
		Map< CFBamClusterPKey, CFBamClusterBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUDomainNameIdx.remove( keyUDomainNameIdx );

		dictByUDescrIdx.remove( keyUDescrIdx );

	}

	public void deleteClusterByIdIdx( CFBamAuthorization Authorization,
		long argId )
	{
		CFBamClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( argId );
		deleteClusterByIdIdx( Authorization, key );
	}

	public void deleteClusterByIdIdx( CFBamAuthorization Authorization,
		CFBamClusterPKey argKey )
	{
		CFBamClusterBuff cur;
		LinkedList<CFBamClusterBuff> matchSet = new LinkedList<CFBamClusterBuff>();
		Iterator<CFBamClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteCluster( Authorization, cur );
		}
	}

	public void deleteClusterByUDomainNameIdx( CFBamAuthorization Authorization,
		String argFullDomainName )
	{
		CFBamClusterByUDomainNameIdxKey key = schema.getFactoryCluster().newUDomainNameIdxKey();
		key.setRequiredFullDomainName( argFullDomainName );
		deleteClusterByUDomainNameIdx( Authorization, key );
	}

	public void deleteClusterByUDomainNameIdx( CFBamAuthorization Authorization,
		CFBamClusterByUDomainNameIdxKey argKey )
	{
		CFBamClusterBuff cur;
		LinkedList<CFBamClusterBuff> matchSet = new LinkedList<CFBamClusterBuff>();
		Iterator<CFBamClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteCluster( Authorization, cur );
		}
	}

	public void deleteClusterByUDescrIdx( CFBamAuthorization Authorization,
		String argDescription )
	{
		CFBamClusterByUDescrIdxKey key = schema.getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( argDescription );
		deleteClusterByUDescrIdx( Authorization, key );
	}

	public void deleteClusterByUDescrIdx( CFBamAuthorization Authorization,
		CFBamClusterByUDescrIdxKey argKey )
	{
		CFBamClusterBuff cur;
		LinkedList<CFBamClusterBuff> matchSet = new LinkedList<CFBamClusterBuff>();
		Iterator<CFBamClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteCluster( Authorization, cur );
		}
	}

	public CFBamCursor openClusterCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamClusterCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeClusterCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamClusterBuff nextClusterCursor( CFBamCursor Cursor ) {
		CFBamRamClusterCursor cursor = (CFBamRamClusterCursor)Cursor;
		CFBamClusterBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamClusterBuff prevClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamClusterBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClusterCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClusterBuff firstClusterCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamClusterBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClusterCursor( Cursor );
		}
		return( rec );
	}

	public CFBamClusterBuff lastClusterCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastClusterCursor" );
	}

	public CFBamClusterBuff nthClusterCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamClusterBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextClusterCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
