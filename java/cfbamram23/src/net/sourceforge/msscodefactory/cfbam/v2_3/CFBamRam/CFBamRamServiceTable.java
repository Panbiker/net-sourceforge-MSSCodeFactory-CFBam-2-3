
// Description: Java7 in-memory RAM DbIO implementation for Service.

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
 *	CFBamRamServiceTable in-memory RAM DbIO implementation
 *	for Service.
 */
public class CFBamRamServiceTable
	implements ICFBamServiceTable
{
	private CFBamRamSchema schema;
	private Map< CFBamServicePKey,
				CFBamServiceBuff > dictByPKey
		= new HashMap< CFBamServicePKey,
				CFBamServiceBuff >();
	private Map< CFBamServiceByClusterIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >> dictByClusterIdx
		= new HashMap< CFBamServiceByClusterIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >>();
	private Map< CFBamServiceByHostIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >> dictByHostIdx
		= new HashMap< CFBamServiceByHostIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >>();
	private Map< CFBamServiceByTypeIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >> dictByTypeIdx
		= new HashMap< CFBamServiceByTypeIdxKey,
				Map< CFBamServicePKey,
					CFBamServiceBuff >>();
	private Map< CFBamServiceByUTypeIdxKey,
			CFBamServiceBuff > dictByUTypeIdx
		= new HashMap< CFBamServiceByUTypeIdxKey,
			CFBamServiceBuff >();
	private Map< CFBamServiceByUHostPortIdxKey,
			CFBamServiceBuff > dictByUHostPortIdx
		= new HashMap< CFBamServiceByUHostPortIdxKey,
			CFBamServiceBuff >();

	public CFBamRamServiceTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		final String S_ProcName = "createService";
		CFBamServicePKey pkey = schema.getFactoryService().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredServiceId( ((CFBamRamClusterTable)schema.getTableCluster()).nextServiceIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredServiceId( pkey.getRequiredServiceId() );
		CFBamServiceByClusterIdxKey keyClusterIdx = schema.getFactoryService().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamServiceByHostIdxKey keyHostIdx = schema.getFactoryService().newHostIdxKey();
		keyHostIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyHostIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );

		CFBamServiceByTypeIdxKey keyTypeIdx = schema.getFactoryService().newTypeIdxKey();
		keyTypeIdx.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );

		CFBamServiceByUTypeIdxKey keyUTypeIdx = schema.getFactoryService().newUTypeIdxKey();
		keyUTypeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUTypeIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		keyUTypeIdx.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );

		CFBamServiceByUHostPortIdxKey keyUHostPortIdx = schema.getFactoryService().newUHostPortIdxKey();
		keyUHostPortIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUHostPortIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		keyUHostPortIdx.setRequiredHostPort( Buff.getRequiredHostPort() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUTypeIdx.containsKey( keyUTypeIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ServiceUTypeIdx",
				keyUTypeIdx );
		}

		if( dictByUHostPortIdx.containsKey( keyUHostPortIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ServiceUHostPort",
				keyUHostPortIdx );
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
						"Owner",
						"ServiceCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamServicePKey, CFBamServiceBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFBamServicePKey, CFBamServiceBuff > subdictHostIdx;
		if( dictByHostIdx.containsKey( keyHostIdx ) ) {
			subdictHostIdx = dictByHostIdx.get( keyHostIdx );
		}
		else {
			subdictHostIdx = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByHostIdx.put( keyHostIdx, subdictHostIdx );
		}
		subdictHostIdx.put( pkey, Buff );

		Map< CFBamServicePKey, CFBamServiceBuff > subdictTypeIdx;
		if( dictByTypeIdx.containsKey( keyTypeIdx ) ) {
			subdictTypeIdx = dictByTypeIdx.get( keyTypeIdx );
		}
		else {
			subdictTypeIdx = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByTypeIdx.put( keyTypeIdx, subdictTypeIdx );
		}
		subdictTypeIdx.put( pkey, Buff );

		dictByUTypeIdx.put( keyUTypeIdx, Buff );

		dictByUHostPortIdx.put( keyUHostPortIdx, Buff );

	}

	public CFBamServiceBuff readDerived( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "CFBamRamService.readDerived() ";
		CFBamServicePKey key = schema.getFactoryService().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredServiceId( PKey.getRequiredServiceId() );
		CFBamServiceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff lockDerived( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "CFBamRamService.readDerived() ";
		CFBamServicePKey key = schema.getFactoryService().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredServiceId( PKey.getRequiredServiceId() );
		CFBamServiceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamService.readAllDerived() ";
		CFBamServiceBuff[] retList = new CFBamServiceBuff[ dictByPKey.values().size() ];
		Iterator< CFBamServiceBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamServiceBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByClusterIdx() ";
		CFBamServiceByClusterIdxKey key = schema.getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFBamServiceBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFBamServiceBuff[ subdictClusterIdx.size() ];
			Iterator< CFBamServiceBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictClusterIdx
				= new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFBamServiceBuff[0];
		}
		return( recArray );
	}

	public CFBamServiceBuff[] readDerivedByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByHostIdx() ";
		CFBamServiceByHostIdxKey key = schema.getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );

		CFBamServiceBuff[] recArray;
		if( dictByHostIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictHostIdx
				= dictByHostIdx.get( key );
			recArray = new CFBamServiceBuff[ subdictHostIdx.size() ];
			Iterator< CFBamServiceBuff > iter = subdictHostIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictHostIdx
				= new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByHostIdx.put( key, subdictHostIdx );
			recArray = new CFBamServiceBuff[0];
		}
		return( recArray );
	}

	public CFBamServiceBuff[] readDerivedByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByTypeIdx() ";
		CFBamServiceByTypeIdxKey key = schema.getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( ServiceTypeId );

		CFBamServiceBuff[] recArray;
		if( dictByTypeIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictTypeIdx
				= dictByTypeIdx.get( key );
			recArray = new CFBamServiceBuff[ subdictTypeIdx.size() ];
			Iterator< CFBamServiceBuff > iter = subdictTypeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictTypeIdx
				= new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByTypeIdx.put( key, subdictTypeIdx );
			recArray = new CFBamServiceBuff[0];
		}
		return( recArray );
	}

	public CFBamServiceBuff readDerivedByUTypeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByUTypeIdx() ";
		CFBamServiceByUTypeIdxKey key = schema.getFactoryService().newUTypeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredServiceTypeId( ServiceTypeId );

		CFBamServiceBuff buff;
		if( dictByUTypeIdx.containsKey( key ) ) {
			buff = dictByUTypeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff readDerivedByUHostPortIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByUHostPortIdx() ";
		CFBamServiceByUHostPortIdxKey key = schema.getFactoryService().newUHostPortIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredHostPort( HostPort );

		CFBamServiceBuff buff;
		if( dictByUHostPortIdx.containsKey( key ) ) {
			buff = dictByUHostPortIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long ServiceId )
	{
		final String S_ProcName = "CFBamRamService.readDerivedByIdIdx() ";
		CFBamServicePKey key = schema.getFactoryService().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredServiceId( ServiceId );

		CFBamServiceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff readBuff( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "CFBamRamService.readBuff() ";
		CFBamServiceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSVC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff lockBuff( CFBamAuthorization Authorization,
		CFBamServicePKey PKey )
	{
		final String S_ProcName = "CFBamRamService.readBuff() ";
		CFBamServiceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSVC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamServiceBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamService.readAllBuff() ";
		CFBamServiceBuff buff;
		ArrayList<CFBamServiceBuff> filteredList = new ArrayList<CFBamServiceBuff>();
		CFBamServiceBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamServiceBuff[0] ) );
	}

	public CFBamServiceBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long ServiceId )
	{
		final String S_ProcName = "CFBamRamService.readBuffByIdIdx() ";
		CFBamServiceBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			ServiceId );
		if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
			return( (CFBamServiceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServiceBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFBamRamService.readBuffByClusterIdx() ";
		CFBamServiceBuff buff;
		ArrayList<CFBamServiceBuff> filteredList = new ArrayList<CFBamServiceBuff>();
		CFBamServiceBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
				filteredList.add( (CFBamServiceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServiceBuff[0] ) );
	}

	public CFBamServiceBuff[] readBuffByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFBamRamService.readBuffByHostIdx() ";
		CFBamServiceBuff buff;
		ArrayList<CFBamServiceBuff> filteredList = new ArrayList<CFBamServiceBuff>();
		CFBamServiceBuff[] buffList = readDerivedByHostIdx( Authorization,
			ClusterId,
			HostNodeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
				filteredList.add( (CFBamServiceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServiceBuff[0] ) );
	}

	public CFBamServiceBuff[] readBuffByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamService.readBuffByTypeIdx() ";
		CFBamServiceBuff buff;
		ArrayList<CFBamServiceBuff> filteredList = new ArrayList<CFBamServiceBuff>();
		CFBamServiceBuff[] buffList = readDerivedByTypeIdx( Authorization,
			ServiceTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
				filteredList.add( (CFBamServiceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamServiceBuff[0] ) );
	}

	public CFBamServiceBuff readBuffByUTypeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		final String S_ProcName = "CFBamRamService.readBuffByUTypeIdx() ";
		CFBamServiceBuff buff = readDerivedByUTypeIdx( Authorization,
			ClusterId,
			HostNodeId,
			ServiceTypeId );
		if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
			return( (CFBamServiceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamServiceBuff readBuffByUHostPortIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		final String S_ProcName = "CFBamRamService.readBuffByUHostPortIdx() ";
		CFBamServiceBuff buff = readDerivedByUHostPortIdx( Authorization,
			ClusterId,
			HostNodeId,
			HostPort );
		if( ( buff != null ) && buff.getClassCode().equals( "HSVC" ) ) {
			return( (CFBamServiceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		CFBamServicePKey pkey = schema.getFactoryService().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredServiceId( Buff.getRequiredServiceId() );
		CFBamServiceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateService",
				"Existing record not found",
				"Service",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateService",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamServiceByClusterIdxKey existingKeyClusterIdx = schema.getFactoryService().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamServiceByClusterIdxKey newKeyClusterIdx = schema.getFactoryService().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFBamServiceByHostIdxKey existingKeyHostIdx = schema.getFactoryService().newHostIdxKey();
		existingKeyHostIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyHostIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );

		CFBamServiceByHostIdxKey newKeyHostIdx = schema.getFactoryService().newHostIdxKey();
		newKeyHostIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyHostIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );

		CFBamServiceByTypeIdxKey existingKeyTypeIdx = schema.getFactoryService().newTypeIdxKey();
		existingKeyTypeIdx.setRequiredServiceTypeId( existing.getRequiredServiceTypeId() );

		CFBamServiceByTypeIdxKey newKeyTypeIdx = schema.getFactoryService().newTypeIdxKey();
		newKeyTypeIdx.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );

		CFBamServiceByUTypeIdxKey existingKeyUTypeIdx = schema.getFactoryService().newUTypeIdxKey();
		existingKeyUTypeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUTypeIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );
		existingKeyUTypeIdx.setRequiredServiceTypeId( existing.getRequiredServiceTypeId() );

		CFBamServiceByUTypeIdxKey newKeyUTypeIdx = schema.getFactoryService().newUTypeIdxKey();
		newKeyUTypeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUTypeIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		newKeyUTypeIdx.setRequiredServiceTypeId( Buff.getRequiredServiceTypeId() );

		CFBamServiceByUHostPortIdxKey existingKeyUHostPortIdx = schema.getFactoryService().newUHostPortIdxKey();
		existingKeyUHostPortIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUHostPortIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );
		existingKeyUHostPortIdx.setRequiredHostPort( existing.getRequiredHostPort() );

		CFBamServiceByUHostPortIdxKey newKeyUHostPortIdx = schema.getFactoryService().newUHostPortIdxKey();
		newKeyUHostPortIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUHostPortIdx.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		newKeyUHostPortIdx.setRequiredHostPort( Buff.getRequiredHostPort() );

		// Check unique indexes

		if( ! existingKeyUTypeIdx.equals( newKeyUTypeIdx ) ) {
			if( dictByUTypeIdx.containsKey( newKeyUTypeIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateService",
					"ServiceUTypeIdx",
					newKeyUTypeIdx );
			}
		}

		if( ! existingKeyUHostPortIdx.equals( newKeyUHostPortIdx ) ) {
			if( dictByUHostPortIdx.containsKey( newKeyUHostPortIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateService",
					"ServiceUHostPort",
					newKeyUHostPortIdx );
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
						"updateService",
						"Owner",
						"ServiceCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamServicePKey, CFBamServiceBuff > subdict;

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
			subdict = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByHostIdx.get( existingKeyHostIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByHostIdx.containsKey( newKeyHostIdx ) ) {
			subdict = dictByHostIdx.get( newKeyHostIdx );
		}
		else {
			subdict = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByHostIdx.put( newKeyHostIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTypeIdx.get( existingKeyTypeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTypeIdx.containsKey( newKeyTypeIdx ) ) {
			subdict = dictByTypeIdx.get( newKeyTypeIdx );
		}
		else {
			subdict = new HashMap< CFBamServicePKey, CFBamServiceBuff >();
			dictByTypeIdx.put( newKeyTypeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUTypeIdx.remove( existingKeyUTypeIdx );
		dictByUTypeIdx.put( newKeyUTypeIdx, Buff );

		dictByUHostPortIdx.remove( existingKeyUHostPortIdx );
		dictByUHostPortIdx.put( newKeyUHostPortIdx, Buff );

	}

	public void deleteService( CFBamAuthorization Authorization,
		CFBamServiceBuff Buff )
	{
		final String S_ProcName = "CFBamRamServiceTable.deleteService() ";
		CFBamServicePKey pkey = schema.getFactoryService().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredServiceId( Buff.getRequiredServiceId() );
		CFBamServiceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteService",
				pkey );
		}
		CFBamServiceByClusterIdxKey keyClusterIdx = schema.getFactoryService().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFBamServiceByHostIdxKey keyHostIdx = schema.getFactoryService().newHostIdxKey();
		keyHostIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyHostIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );

		CFBamServiceByTypeIdxKey keyTypeIdx = schema.getFactoryService().newTypeIdxKey();
		keyTypeIdx.setRequiredServiceTypeId( existing.getRequiredServiceTypeId() );

		CFBamServiceByUTypeIdxKey keyUTypeIdx = schema.getFactoryService().newUTypeIdxKey();
		keyUTypeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUTypeIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );
		keyUTypeIdx.setRequiredServiceTypeId( existing.getRequiredServiceTypeId() );

		CFBamServiceByUHostPortIdxKey keyUHostPortIdx = schema.getFactoryService().newUHostPortIdxKey();
		keyUHostPortIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUHostPortIdx.setRequiredHostNodeId( existing.getRequiredHostNodeId() );
		keyUHostPortIdx.setRequiredHostPort( existing.getRequiredHostPort() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamServicePKey, CFBamServiceBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByHostIdx.get( keyHostIdx );
		subdict.remove( pkey );

		subdict = dictByTypeIdx.get( keyTypeIdx );
		subdict.remove( pkey );

		dictByUTypeIdx.remove( keyUTypeIdx );

		dictByUHostPortIdx.remove( keyUHostPortIdx );

	}

	public void deleteServiceByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argServiceId )
	{
		CFBamServicePKey key = schema.getFactoryService().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredServiceId( argServiceId );
		deleteServiceByIdIdx( Authorization, key );
	}

	public void deleteServiceByIdIdx( CFBamAuthorization Authorization,
		CFBamServicePKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public void deleteServiceByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		CFBamServiceByClusterIdxKey key = schema.getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteServiceByClusterIdx( Authorization, key );
	}

	public void deleteServiceByClusterIdx( CFBamAuthorization Authorization,
		CFBamServiceByClusterIdxKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public void deleteServiceByHostIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId )
	{
		CFBamServiceByHostIdxKey key = schema.getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostNodeId( argHostNodeId );
		deleteServiceByHostIdx( Authorization, key );
	}

	public void deleteServiceByHostIdx( CFBamAuthorization Authorization,
		CFBamServiceByHostIdxKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public void deleteServiceByTypeIdx( CFBamAuthorization Authorization,
		int argServiceTypeId )
	{
		CFBamServiceByTypeIdxKey key = schema.getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( argServiceTypeId );
		deleteServiceByTypeIdx( Authorization, key );
	}

	public void deleteServiceByTypeIdx( CFBamAuthorization Authorization,
		CFBamServiceByTypeIdxKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public void deleteServiceByUTypeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId,
		int argServiceTypeId )
	{
		CFBamServiceByUTypeIdxKey key = schema.getFactoryService().newUTypeIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostNodeId( argHostNodeId );
		key.setRequiredServiceTypeId( argServiceTypeId );
		deleteServiceByUTypeIdx( Authorization, key );
	}

	public void deleteServiceByUTypeIdx( CFBamAuthorization Authorization,
		CFBamServiceByUTypeIdxKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public void deleteServiceByUHostPortIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argHostNodeId,
		short argHostPort )
	{
		CFBamServiceByUHostPortIdxKey key = schema.getFactoryService().newUHostPortIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostNodeId( argHostNodeId );
		key.setRequiredHostPort( argHostPort );
		deleteServiceByUHostPortIdx( Authorization, key );
	}

	public void deleteServiceByUHostPortIdx( CFBamAuthorization Authorization,
		CFBamServiceByUHostPortIdxKey argKey )
	{
		CFBamServiceBuff cur;
		LinkedList<CFBamServiceBuff> matchSet = new LinkedList<CFBamServiceBuff>();
		Iterator<CFBamServiceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamServiceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteService( Authorization, cur );
		}
	}

	public CFBamCursor openServiceCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamServiceCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openServiceCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId )
	{
		CFBamCursor cursor;
		CFBamServiceByClusterIdxKey key = schema.getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				subdictClusterIdx.values() );
		}
		else {
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				new ArrayList< CFBamServiceBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openServiceCursorByHostIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		CFBamCursor cursor;
		CFBamServiceByHostIdxKey key = schema.getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );

		if( dictByHostIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictHostIdx
				= dictByHostIdx.get( key );
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				subdictHostIdx.values() );
		}
		else {
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				new ArrayList< CFBamServiceBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openServiceCursorByTypeIdx( CFBamAuthorization Authorization,
		int ServiceTypeId )
	{
		CFBamCursor cursor;
		CFBamServiceByTypeIdxKey key = schema.getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( ServiceTypeId );

		if( dictByTypeIdx.containsKey( key ) ) {
			Map< CFBamServicePKey, CFBamServiceBuff > subdictTypeIdx
				= dictByTypeIdx.get( key );
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				subdictTypeIdx.values() );
		}
		else {
			cursor = new CFBamRamServiceCursor( Authorization,
				schema,
				new ArrayList< CFBamServiceBuff >() );
		}
		return( cursor );
	}

	public void closeServiceCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamServiceBuff nextServiceCursor( CFBamCursor Cursor ) {
		CFBamRamServiceCursor cursor = (CFBamRamServiceCursor)Cursor;
		CFBamServiceBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamServiceBuff prevServiceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamServiceBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServiceBuff firstServiceCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamServiceBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceCursor( Cursor );
		}
		return( rec );
	}

	public CFBamServiceBuff lastServiceCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastServiceCursor" );
	}

	public CFBamServiceBuff nthServiceCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamServiceBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextServiceCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
