// Description: Java7 Table Object implementation for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public class CFBamHostNodeTableObj
	implements ICFBamHostNodeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamHostNodePKey, ICFBamHostNodeObj> members;
	private Map<CFBamHostNodePKey, ICFBamHostNodeObj> allHostNode;
	private Map< CFBamHostNodeByClusterIdxKey,
		Map<CFBamHostNodePKey, ICFBamHostNodeObj > > indexByClusterIdx;
	private Map< CFBamHostNodeByUDescrIdxKey,
		ICFBamHostNodeObj > indexByUDescrIdx;
	private Map< CFBamHostNodeByHostNameIdxKey,
		ICFBamHostNodeObj > indexByHostNameIdx;
	public static String TABLE_NAME = "HostNode";
	public static String TABLE_DBNAME = "hostnode";

	public CFBamHostNodeTableObj() {
		schema = null;
		members = new HashMap<CFBamHostNodePKey, ICFBamHostNodeObj>();
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
	}

	public CFBamHostNodeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamHostNodePKey, ICFBamHostNodeObj>();
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( null );
	}


	public void minimizeMemory() {
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
		List<ICFBamHostNodeObj> toForget = new LinkedList<ICFBamHostNodeObj>();
		ICFBamHostNodeObj cur = null;
		Iterator<ICFBamHostNodeObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			if( cur.getEdit() == null ) {
				toForget.add( cur );
			}
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamHostNodeObj.
	 */
	public ICFBamHostNodeObj newInstance() {
		ICFBamHostNodeObj inst = new CFBamHostNodeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamHostNodeObj.
	 */
	public ICFBamHostNodeEditObj newEditInstance( ICFBamHostNodeObj orig ) {
		ICFBamHostNodeEditObj edit = new CFBamHostNodeEditObj( orig );
		return( edit );
	}

	public ICFBamHostNodeObj realizeHostNode( ICFBamHostNodeObj Obj ) {
		ICFBamHostNodeObj obj = Obj;
		CFBamHostNodePKey pkey = obj.getPKey();
		ICFBamHostNodeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamHostNodeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamHostNodeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamHostNodePKey, ICFBamHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFBamHostNodeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( indexByHostNameIdx != null ) {
				CFBamHostNodeByHostNameIdxKey keyHostNameIdx =
					schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.remove( keyHostNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamHostNodeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamHostNodePKey, ICFBamHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFBamHostNodeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( indexByHostNameIdx != null ) {
				CFBamHostNodeByHostNameIdxKey keyHostNameIdx =
					schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.put( keyHostNameIdx, keepObj );
			}
			if( allHostNode != null ) {
				allHostNode.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allHostNode != null ) {
				allHostNode.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamHostNodeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamHostNodePKey, ICFBamHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFBamHostNodeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( indexByHostNameIdx != null ) {
				CFBamHostNodeByHostNameIdxKey keyHostNameIdx =
					schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.put( keyHostNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetHostNode( ICFBamHostNodeObj Obj ) {
		forgetHostNode( Obj, false );
	}

	public void forgetHostNode( ICFBamHostNodeObj Obj, boolean forgetSubObjects ) {
		ICFBamHostNodeObj obj = Obj;
		CFBamHostNodePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamHostNodeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamHostNodeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamHostNodePKey, ICFBamHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFBamHostNodeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( indexByHostNameIdx != null ) {
				CFBamHostNodeByHostNameIdxKey keyHostNameIdx =
					schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.remove( keyHostNameIdx );
			}

			if( allHostNode != null ) {
				allHostNode.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getServiceTableObj().forgetServiceByHostIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredHostNodeId() );
			}
		}
	}

	public void forgetHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		if( members == null ) {
			return;
		}
		CFBamHostNodePKey key = schema.getBackingStore().getFactoryHostNode().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		if( members.containsKey( key ) ) {
			ICFBamHostNodeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetHostNodeByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamHostNodeByClusterIdxKey key = schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamHostNodePKey, ICFBamHostNodeObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamHostNodeObj> toForget = new LinkedList<ICFBamHostNodeObj>();
				ICFBamHostNodeObj cur = null;
				Iterator<ICFBamHostNodeObj> iter = mapClusterIdx.values().iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					toForget.add( cur );
				}
				iter = toForget.iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					cur.forget( true );
				}
			}

			indexByClusterIdx.remove( key );
		}
	}

	public void forgetHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		CFBamHostNodeByUDescrIdxKey key = schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			ICFBamHostNodeObj probed = indexByUDescrIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUDescrIdx.remove( key );
		}
	}

	public void forgetHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		if( indexByHostNameIdx == null ) {
			return;
		}
		CFBamHostNodeByHostNameIdxKey key = schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		if( indexByHostNameIdx.containsKey( key ) ) {
			ICFBamHostNodeObj probed = indexByHostNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByHostNameIdx.remove( key );
		}
	}

	public ICFBamHostNodeObj createHostNode( ICFBamHostNodeObj Obj ) {
		ICFBamHostNodeObj obj = Obj;
		CFBamHostNodeBuff buff = obj.getHostNodeBuff();
		schema.getBackingStore().getTableHostNode().createHostNode(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamHostNodeObj readHostNode( CFBamHostNodePKey pkey ) {
		return( readHostNode( pkey, false ) );
	}

	public ICFBamHostNodeObj readHostNode( CFBamHostNodePKey pkey, boolean forceRead ) {
		ICFBamHostNodeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamHostNodeBuff readBuff = schema.getBackingStore().getTableHostNode().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredHostNodeId() );
			if( readBuff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamHostNodeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamHostNodeObj lockHostNode( CFBamHostNodePKey pkey ) {
		ICFBamHostNodeObj locked = null;
		CFBamHostNodeBuff lockBuff = schema.getBackingStore().getTableHostNode().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getHostNodeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamHostNodeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockHostNode", pkey );
		}
		return( locked );
	}

	public List<ICFBamHostNodeObj> readAllHostNode() {
		return( readAllHostNode( false ) );
	}

	public List<ICFBamHostNodeObj> readAllHostNode( boolean forceRead ) {
		final String S_ProcName = "readAllHostNode";
		if( ( allHostNode == null ) || forceRead ) {
			Map<CFBamHostNodePKey, ICFBamHostNodeObj> map = new HashMap<CFBamHostNodePKey,ICFBamHostNodeObj>();
			allHostNode = map;
			CFBamHostNodeBuff[] buffList = schema.getBackingStore().getTableHostNode().readAllDerived( schema.getAuthorization() );
			CFBamHostNodeBuff buff;
			ICFBamHostNodeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				ICFBamHostNodeObj realized = (ICFBamHostNodeObj)obj.realize();
			}
		}
		Comparator<ICFBamHostNodeObj> cmp = new Comparator<ICFBamHostNodeObj>() {
			public int compare( ICFBamHostNodeObj lhs, ICFBamHostNodeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					CFBamHostNodePKey lhsPKey = lhs.getPKey();
					CFBamHostNodePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allHostNode.size();
		ICFBamHostNodeObj arr[] = new ICFBamHostNodeObj[len];
		Iterator<ICFBamHostNodeObj> valIter = allHostNode.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		Arrays.sort( arr, cmp );
		ArrayList<ICFBamHostNodeObj> arrayList = new ArrayList<ICFBamHostNodeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamHostNodeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		return( readHostNodeByIdIdx( ClusterId,
			HostNodeId,
			false ) );
	}

	public ICFBamHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId, boolean forceRead )
	{
		CFBamHostNodePKey pkey = schema.getBackingStore().getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredHostNodeId( HostNodeId );
		ICFBamHostNodeObj obj = readHostNode( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamHostNodeObj> readHostNodeByClusterIdx( long ClusterId )
	{
		return( readHostNodeByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamHostNodeObj> readHostNodeByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readHostNodeByClusterIdx";
		CFBamHostNodeByClusterIdxKey key = schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamHostNodePKey, ICFBamHostNodeObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamHostNodeByClusterIdxKey,
				Map< CFBamHostNodePKey, ICFBamHostNodeObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamHostNodePKey, ICFBamHostNodeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamHostNodeObj obj;
			CFBamHostNodeBuff[] buffList = schema.getBackingStore().getTableHostNode().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamHostNodeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				ICFBamHostNodeObj realized = (ICFBamHostNodeObj)obj.realize();
			}
		}
		Comparator<ICFBamHostNodeObj> cmp = new Comparator<ICFBamHostNodeObj>() {
			public int compare( ICFBamHostNodeObj lhs, ICFBamHostNodeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					CFBamHostNodePKey lhsPKey = lhs.getPKey();
					CFBamHostNodePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamHostNodeObj arr[] = new ICFBamHostNodeObj[len];
		Iterator<ICFBamHostNodeObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		Arrays.sort( arr, cmp );
		ArrayList<ICFBamHostNodeObj> arrayList = new ArrayList<ICFBamHostNodeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamHostNodeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamHostNodeObj readHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		return( readHostNodeByUDescrIdx( ClusterId,
			Description,
			false ) );
	}

	public ICFBamHostNodeObj readHostNodeByUDescrIdx( long ClusterId,
		String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamHostNodeByUDescrIdxKey,
				ICFBamHostNodeObj >();
		}
		CFBamHostNodeByUDescrIdxKey key = schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		ICFBamHostNodeObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFBamHostNodeBuff buff = schema.getBackingStore().getTableHostNode().readDerivedByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
			if( buff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamHostNodeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUDescrIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamHostNodeObj readHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		return( readHostNodeByHostNameIdx( ClusterId,
			HostName,
			false ) );
	}

	public ICFBamHostNodeObj readHostNodeByHostNameIdx( long ClusterId,
		String HostName, boolean forceRead )
	{
		if( indexByHostNameIdx == null ) {
			indexByHostNameIdx = new HashMap< CFBamHostNodeByHostNameIdxKey,
				ICFBamHostNodeObj >();
		}
		CFBamHostNodeByHostNameIdxKey key = schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		ICFBamHostNodeObj obj = null;
		if( ( ! forceRead ) && indexByHostNameIdx.containsKey( key ) ) {
			obj = indexByHostNameIdx.get( key );
		}
		else {
			CFBamHostNodeBuff buff = schema.getBackingStore().getTableHostNode().readDerivedByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
			if( buff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamHostNodeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByHostNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamHostNodeObj updateHostNode( ICFBamHostNodeObj Obj ) {
		ICFBamHostNodeObj obj = Obj;
		schema.getBackingStore().getTableHostNode().updateHostNode( schema.getAuthorization(),
			Obj.getHostNodeBuff() );
		obj = (ICFBamHostNodeObj)Obj.realize();
		return( obj );
	}

	public void deleteHostNode( ICFBamHostNodeObj Obj ) {
		ICFBamHostNodeObj obj = Obj;
		schema.getBackingStore().getTableHostNode().deleteHostNode( schema.getAuthorization(),
			obj.getHostNodeBuff() );
		obj.forget( true );
	}

	public void deleteHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		CFBamHostNodePKey pkey = schema.getBackingStore().getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredHostNodeId( HostNodeId );
		ICFBamHostNodeObj obj = readHostNode( pkey );
		if( obj != null ) {
			ICFBamHostNodeEditObj editObj = (ICFBamHostNodeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamHostNodeEditObj)obj.beginEdit();
				if( editObj != null ) {
					editStarted = true;
				}
				else {
					editStarted = false;
				}
			}
			else {
				editStarted = false;
			}
			if( editObj != null ) {
				editObj.delete();
				if( editStarted ) {
					editObj.endEdit();
				}
			}
			obj.forget( true );
		}
	}

	public void deleteHostNodeByClusterIdx( long ClusterId )
	{
		CFBamHostNodeByClusterIdxKey key = schema.getBackingStore().getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamHostNodeByClusterIdxKey,
				Map< CFBamHostNodePKey, ICFBamHostNodeObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamHostNodePKey, ICFBamHostNodeObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableHostNode().deleteHostNodeByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamHostNodeObj> iter = dict.values().iterator();
			ICFBamHostNodeObj obj;
			List<ICFBamHostNodeObj> toForget = new LinkedList<ICFBamHostNodeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClusterIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableHostNode().deleteHostNodeByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamHostNodeByUDescrIdxKey,
				ICFBamHostNodeObj >();
		}
		CFBamHostNodeByUDescrIdxKey key = schema.getBackingStore().getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		ICFBamHostNodeObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			schema.getBackingStore().getTableHostNode().deleteHostNodeByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableHostNode().deleteHostNodeByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
		}
	}

	public void deleteHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		if( indexByHostNameIdx == null ) {
			indexByHostNameIdx = new HashMap< CFBamHostNodeByHostNameIdxKey,
				ICFBamHostNodeObj >();
		}
		CFBamHostNodeByHostNameIdxKey key = schema.getBackingStore().getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		ICFBamHostNodeObj obj = null;
		if( indexByHostNameIdx.containsKey( key ) ) {
			obj = indexByHostNameIdx.get( key );
			schema.getBackingStore().getTableHostNode().deleteHostNodeByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableHostNode().deleteHostNodeByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
		}
	}
}
