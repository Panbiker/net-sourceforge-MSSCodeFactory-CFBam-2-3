
// Description: Java7 in-memory RAM DbIO implementation for HostNode.

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
 *	CFBamRamHostNodeTable in-memory RAM DbIO implementation
 *	for HostNode.
 */
public class CFBamRamHostNodeTable
	implements ICFBamHostNodeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamHostNodePKey,
				CFBamHostNodeBuff > dictByPKey
		= new HashMap< CFBamHostNodePKey,
				CFBamHostNodeBuff >();
	private Map< CFBamHostNodeByClusterIdxKey,
				Map< CFBamHostNodePKey,
					CFBamHostNodeBuff >> dictByClusterIdx
		= new HashMap< CFBamHostNodeByClusterIdxKey,
				Map< CFBamHostNodePKey,
					CFBamHostNodeBuff >>();
	private Map< CFBamHostNodeByUDescrIdxKey,
			CFBamHostNodeBuff > dictByUDescrIdx
		= new HashMap< CFBamHostNodeByUDescrIdxKey,
			CFBamHostNodeBuff >();
	private Map< CFBamHostNodeByHostNameIdxKey,
			CFBamHostNodeBuff > dictByHostNameIdx
		= new HashMap< CFBamHostNodeByHostNameIdxKey,
			CFBamHostNodeBuff >();

	public CFBamRamHostNodeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createHostNode( CFBamAuthorization Authorization,
		CFBamHostNodeBuff Buff )
	{
		final String S_ProcName = "createHostNode";
		CFBamHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( ((CFBamRamClusterTable)schema.getTableCluster()).nextHostNodeIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredHostNodeId( pkey.getRequiredHostNodeId() );
		CFBamHostNodeByClusterIdxKey keyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamHostNodeByUDescrIdxKey keyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		keyUDescrIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		CFBamHostNodeByHostNameIdxKey keyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		keyHostNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyHostNameIdx.setRequiredHostName( Buff.getRequiredHostName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"HostNodeUDescrIdx",
				keyUDescrIdx );
		}

		if( dictByHostNameIdx.containsKey( keyHostNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"HostNodeUHostNameIdx",
				keyHostNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"HostNodeCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamHostNodePKey, CFBamHostNodeBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

		dictByHostNameIdx.put( keyHostNameIdx, Buff );

	}

	public CFBamHostNodeBuff readDerived( CFBamAuthorization Authorization,
		CFBamHostNodePKey PKey )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerived() ";
		CFBamHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredHostNodeId( PKey.getRequiredHostNodeId() );
		CFBamHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamHostNodePKey PKey )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerived() ";
		CFBamHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredHostNodeId( PKey.getRequiredHostNodeId() );
		CFBamHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamHostNode.readAllDerived() ";
		CFBamHostNodeBuff[] retList = new CFBamHostNodeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamHostNodeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamHostNodeBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerivedByClusterIdx() ";
		CFBamHostNodeByClusterIdxKey key = schema.getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamHostNodeBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamHostNodeBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamHostNodeBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdictClusterIdx
				= new HashMap< CFBamHostNodePKey, CFBamHostNodeBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamHostNodeBuff[0];
		}
		return( recArray );
	}

	public CFBamHostNodeBuff readDerivedByUDescrIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String Description )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerivedByUDescrIdx() ";
		CFBamHostNodeByUDescrIdxKey key = schema.getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );

		CFBamHostNodeBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff readDerivedByHostNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String HostName )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerivedByHostNameIdx() ";
		CFBamHostNodeByHostNameIdxKey key = schema.getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );

		CFBamHostNodeBuff buff;
		if( dictByHostNameIdx.containsKey( key ) ) {
			buff = dictByHostNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFBamRamHostNode.readDerivedByIdIdx() ";
		CFBamHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );

		CFBamHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff readBuff( CFBamAuthorization Authorization,
		CFBamHostNodePKey PKey )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuff() ";
		CFBamHostNodeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamHostNodePKey PKey )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuff() ";
		CFBamHostNodeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamHostNodeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamHostNode.readAllBuff() ";
		CFBamHostNodeBuff buff;
		ArrayList<CFBamHostNodeBuff> filteredList = new ArrayList<CFBamHostNodeBuff>();
		CFBamHostNodeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamHostNodeBuff[0] ) );
	}

	public CFBamHostNodeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuffByIdIdx() ";
		CFBamHostNodeBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			HostNodeId );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFBamHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamHostNodeBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuffByClusterIdx() ";
		CFBamHostNodeBuff buff;
		ArrayList<CFBamHostNodeBuff> filteredList = new ArrayList<CFBamHostNodeBuff>();
		CFBamHostNodeBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
				filteredList.add( (CFBamHostNodeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamHostNodeBuff[0] ) );
	}

	public CFBamHostNodeBuff readBuffByUDescrIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String Description )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuffByUDescrIdx() ";
		CFBamHostNodeBuff buff = readDerivedByUDescrIdx( Authorization,
			ClusterId,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFBamHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamHostNodeBuff readBuffByHostNameIdx( CFBamAuthorization Authorization,
		long ClusterId,
		String HostName )
	{
		final String S_ProcName = "CFBamRamHostNode.readBuffByHostNameIdx() ";
		CFBamHostNodeBuff buff = readDerivedByHostNameIdx( Authorization,
			ClusterId,
			HostName );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFBamHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateHostNode( CFBamAuthorization Authorization,
		CFBamHostNodeBuff Buff )
	{
		CFBamHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		CFBamHostNodeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateHostNode",
				"Existing record not found",
				"HostNode",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateHostNode",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamHostNodeByClusterIdxKey existingKeyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamHostNodeByClusterIdxKey newKeyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamHostNodeByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFBamHostNodeByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		CFBamHostNodeByHostNameIdxKey existingKeyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		existingKeyHostNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyHostNameIdx.setRequiredHostName( existing.getRequiredHostName() );

		CFBamHostNodeByHostNameIdxKey newKeyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		newKeyHostNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyHostNameIdx.setRequiredHostName( Buff.getRequiredHostName() );

		// Check unique indexes

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateHostNode",
					"HostNodeUDescrIdx",
					newKeyUDescrIdx );
			}
		}

		if( ! existingKeyHostNameIdx.equals( newKeyHostNameIdx ) ) {
			if( dictByHostNameIdx.containsKey( newKeyHostNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateHostNode",
					"HostNodeUHostNameIdx",
					newKeyHostNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateHostNode",
						"Container",
						"HostNodeCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFBamHostNodePKey, CFBamHostNodeBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

		dictByHostNameIdx.remove( existingKeyHostNameIdx );
		dictByHostNameIdx.put( newKeyHostNameIdx, Buff );

	}

	public void deleteHostNode( CFBamAuthorization Authorization,
		CFBamHostNodeBuff Buff )
	{
		final String S_ProcName = "CFBamRamHostNodeTable.deleteHostNode() ";
		CFBamHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		CFBamHostNodeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteHostNode",
				pkey );
		}
		CFBamHostNodeByClusterIdxKey keyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamHostNodeByUDescrIdxKey keyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		keyUDescrIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFBamHostNodeByHostNameIdxKey keyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		keyHostNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyHostNameIdx.setRequiredHostName( existing.getRequiredHostName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableService().deleteServiceByHostIdx( Authorization,
			Buff.getRequiredClusterId(),
			Buff.getRequiredHostNodeId() );
		Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUDescrIdx.remove( keyUDescrIdx );

		dictByHostNameIdx.remove( keyHostNameIdx );

	}

	public void deleteHostNodeByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId )
	{
		CFBamHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostNodeId( argHostNodeId );
		deleteHostNodeByIdIdx( Authorization, key );
	}

	public void deleteHostNodeByIdIdx( CFBamAuthorization Authorization,
		CFBamHostNodePKey argKey )
	{
		CFBamHostNodeBuff cur;
		LinkedList<CFBamHostNodeBuff> matchSet = new LinkedList<CFBamHostNodeBuff>();
		Iterator<CFBamHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamHostNodeByClusterIdxKey key = schema.getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteHostNodeByClusterIdx( Authorization, key );
	}

	public void deleteHostNodeByClusterIdx( CFBamAuthorization Authorization,
		CFBamHostNodeByClusterIdxKey argKey )
	{
		CFBamHostNodeBuff cur;
		LinkedList<CFBamHostNodeBuff> matchSet = new LinkedList<CFBamHostNodeBuff>();
		Iterator<CFBamHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByUDescrIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argDescription )
	{
		CFBamHostNodeByUDescrIdxKey key = schema.getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredDescription( argDescription );
		deleteHostNodeByUDescrIdx( Authorization, key );
	}

	public void deleteHostNodeByUDescrIdx( CFBamAuthorization Authorization,
		CFBamHostNodeByUDescrIdxKey argKey )
	{
		CFBamHostNodeBuff cur;
		LinkedList<CFBamHostNodeBuff> matchSet = new LinkedList<CFBamHostNodeBuff>();
		Iterator<CFBamHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByHostNameIdx( CFBamAuthorization Authorization,
		long argClusterId,
		String argHostName )
	{
		CFBamHostNodeByHostNameIdxKey key = schema.getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostName( argHostName );
		deleteHostNodeByHostNameIdx( Authorization, key );
	}

	public void deleteHostNodeByHostNameIdx( CFBamAuthorization Authorization,
		CFBamHostNodeByHostNameIdxKey argKey )
	{
		CFBamHostNodeBuff cur;
		LinkedList<CFBamHostNodeBuff> matchSet = new LinkedList<CFBamHostNodeBuff>();
		Iterator<CFBamHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteHostNode( Authorization, cur );
		}
	}

	public CFBamCursor openHostNodeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamHostNodeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openHostNodeCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamHostNodeByClusterIdxKey key = schema.getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamHostNodePKey, CFBamHostNodeBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamHostNodeCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamHostNodeCursor( Authorization,
				schema,
				new ArrayList< CFBamHostNodeBuff >() );
		}
		return( cursor );
	}

	public void closeHostNodeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamHostNodeBuff nextHostNodeCursor( CFBamCursor Cursor ) {
		CFBamRamHostNodeCursor cursor = (CFBamRamHostNodeCursor)Cursor;
		CFBamHostNodeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamHostNodeBuff prevHostNodeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamHostNodeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextHostNodeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamHostNodeBuff firstHostNodeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamHostNodeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextHostNodeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamHostNodeBuff lastHostNodeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastHostNodeCursor" );
	}

	public CFBamHostNodeBuff nthHostNodeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamHostNodeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextHostNodeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
