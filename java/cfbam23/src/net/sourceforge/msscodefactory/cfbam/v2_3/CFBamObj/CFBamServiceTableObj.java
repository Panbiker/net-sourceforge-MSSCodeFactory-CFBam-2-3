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

public class CFBamServiceTableObj
	implements ICFBamServiceTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamServicePKey, ICFBamServiceObj> members;
	private Map<CFBamServicePKey, ICFBamServiceObj> allService;
	private Map< CFBamServiceByClusterIdxKey,
		Map<CFBamServicePKey, ICFBamServiceObj > > indexByClusterIdx;
	private Map< CFBamServiceByHostIdxKey,
		Map<CFBamServicePKey, ICFBamServiceObj > > indexByHostIdx;
	private Map< CFBamServiceByTypeIdxKey,
		Map<CFBamServicePKey, ICFBamServiceObj > > indexByTypeIdx;
	private Map< CFBamServiceByUTypeIdxKey,
		ICFBamServiceObj > indexByUTypeIdx;
	private Map< CFBamServiceByUHostPortIdxKey,
		ICFBamServiceObj > indexByUHostPortIdx;
	public static String TABLE_NAME = "Service";
	public static String TABLE_DBNAME = "hostsvc";

	public CFBamServiceTableObj() {
		schema = null;
		members = new HashMap<CFBamServicePKey, ICFBamServiceObj>();
		allService = null;
		indexByClusterIdx = null;
		indexByHostIdx = null;
		indexByTypeIdx = null;
		indexByUTypeIdx = null;
		indexByUHostPortIdx = null;
	}

	public CFBamServiceTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamServicePKey, ICFBamServiceObj>();
		allService = null;
		indexByClusterIdx = null;
		indexByHostIdx = null;
		indexByTypeIdx = null;
		indexByUTypeIdx = null;
		indexByUHostPortIdx = null;
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
		allService = null;
		indexByClusterIdx = null;
		indexByHostIdx = null;
		indexByTypeIdx = null;
		indexByUTypeIdx = null;
		indexByUHostPortIdx = null;
		List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
		ICFBamServiceObj cur = null;
		Iterator<ICFBamServiceObj> iter = members.values().iterator();
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
	 *	CFBamServiceObj.
	 */
	public ICFBamServiceObj newInstance() {
		ICFBamServiceObj inst = new CFBamServiceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServiceObj.
	 */
	public ICFBamServiceEditObj newEditInstance( ICFBamServiceObj orig ) {
		ICFBamServiceEditObj edit = new CFBamServiceEditObj( orig );
		return( edit );
	}

	public ICFBamServiceObj realizeService( ICFBamServiceObj Obj ) {
		ICFBamServiceObj obj = Obj;
		CFBamServicePKey pkey = obj.getPKey();
		ICFBamServiceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamServiceObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamServiceByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryService().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByHostIdx != null ) {
				CFBamServiceByHostIdxKey keyHostIdx =
					schema.getBackingStore().getFactoryService().newHostIdxKey();
				keyHostIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapHostIdx = indexByHostIdx.get( keyHostIdx );
				if( mapHostIdx != null ) {
					mapHostIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTypeIdx != null ) {
				CFBamServiceByTypeIdxKey keyTypeIdx =
					schema.getBackingStore().getFactoryService().newTypeIdxKey();
				keyTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapTypeIdx = indexByTypeIdx.get( keyTypeIdx );
				if( mapTypeIdx != null ) {
					mapTypeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUTypeIdx != null ) {
				CFBamServiceByUTypeIdxKey keyUTypeIdx =
					schema.getBackingStore().getFactoryService().newUTypeIdxKey();
				keyUTypeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUTypeIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				indexByUTypeIdx.remove( keyUTypeIdx );
			}

			if( indexByUHostPortIdx != null ) {
				CFBamServiceByUHostPortIdxKey keyUHostPortIdx =
					schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
				keyUHostPortIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUHostPortIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUHostPortIdx.setRequiredHostPort( keepObj.getRequiredHostPort() );
				indexByUHostPortIdx.remove( keyUHostPortIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamServiceByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryService().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByHostIdx != null ) {
				CFBamServiceByHostIdxKey keyHostIdx =
					schema.getBackingStore().getFactoryService().newHostIdxKey();
				keyHostIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapHostIdx = indexByHostIdx.get( keyHostIdx );
				if( mapHostIdx != null ) {
					mapHostIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTypeIdx != null ) {
				CFBamServiceByTypeIdxKey keyTypeIdx =
					schema.getBackingStore().getFactoryService().newTypeIdxKey();
				keyTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapTypeIdx = indexByTypeIdx.get( keyTypeIdx );
				if( mapTypeIdx != null ) {
					mapTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTypeIdx != null ) {
				CFBamServiceByUTypeIdxKey keyUTypeIdx =
					schema.getBackingStore().getFactoryService().newUTypeIdxKey();
				keyUTypeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUTypeIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				indexByUTypeIdx.put( keyUTypeIdx, keepObj );
			}

			if( indexByUHostPortIdx != null ) {
				CFBamServiceByUHostPortIdxKey keyUHostPortIdx =
					schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
				keyUHostPortIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUHostPortIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUHostPortIdx.setRequiredHostPort( keepObj.getRequiredHostPort() );
				indexByUHostPortIdx.put( keyUHostPortIdx, keepObj );
			}
			if( allService != null ) {
				allService.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allService != null ) {
				allService.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamServiceByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryService().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByHostIdx != null ) {
				CFBamServiceByHostIdxKey keyHostIdx =
					schema.getBackingStore().getFactoryService().newHostIdxKey();
				keyHostIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapHostIdx = indexByHostIdx.get( keyHostIdx );
				if( mapHostIdx != null ) {
					mapHostIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTypeIdx != null ) {
				CFBamServiceByTypeIdxKey keyTypeIdx =
					schema.getBackingStore().getFactoryService().newTypeIdxKey();
				keyTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapTypeIdx = indexByTypeIdx.get( keyTypeIdx );
				if( mapTypeIdx != null ) {
					mapTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTypeIdx != null ) {
				CFBamServiceByUTypeIdxKey keyUTypeIdx =
					schema.getBackingStore().getFactoryService().newUTypeIdxKey();
				keyUTypeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUTypeIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				indexByUTypeIdx.put( keyUTypeIdx, keepObj );
			}

			if( indexByUHostPortIdx != null ) {
				CFBamServiceByUHostPortIdxKey keyUHostPortIdx =
					schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
				keyUHostPortIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUHostPortIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUHostPortIdx.setRequiredHostPort( keepObj.getRequiredHostPort() );
				indexByUHostPortIdx.put( keyUHostPortIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetService( ICFBamServiceObj Obj ) {
		forgetService( Obj, false );
	}

	public void forgetService( ICFBamServiceObj Obj, boolean forgetSubObjects ) {
		ICFBamServiceObj obj = Obj;
		CFBamServicePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamServiceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamServiceByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryService().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByHostIdx != null ) {
				CFBamServiceByHostIdxKey keyHostIdx =
					schema.getBackingStore().getFactoryService().newHostIdxKey();
				keyHostIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapHostIdx = indexByHostIdx.get( keyHostIdx );
				if( mapHostIdx != null ) {
					mapHostIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTypeIdx != null ) {
				CFBamServiceByTypeIdxKey keyTypeIdx =
					schema.getBackingStore().getFactoryService().newTypeIdxKey();
				keyTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				Map<CFBamServicePKey, ICFBamServiceObj > mapTypeIdx = indexByTypeIdx.get( keyTypeIdx );
				if( mapTypeIdx != null ) {
					mapTypeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUTypeIdx != null ) {
				CFBamServiceByUTypeIdxKey keyUTypeIdx =
					schema.getBackingStore().getFactoryService().newUTypeIdxKey();
				keyUTypeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUTypeIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUTypeIdx.setRequiredServiceTypeId( keepObj.getRequiredServiceTypeId() );
				indexByUTypeIdx.remove( keyUTypeIdx );
			}

			if( indexByUHostPortIdx != null ) {
				CFBamServiceByUHostPortIdxKey keyUHostPortIdx =
					schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
				keyUHostPortIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUHostPortIdx.setRequiredHostNodeId( keepObj.getRequiredHostNodeId() );
				keyUHostPortIdx.setRequiredHostPort( keepObj.getRequiredHostPort() );
				indexByUHostPortIdx.remove( keyUHostPortIdx );
			}

			if( allService != null ) {
				allService.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetServiceByIdIdx( long ClusterId,
		long ServiceId )
	{
		if( members == null ) {
			return;
		}
		CFBamServicePKey key = schema.getBackingStore().getFactoryService().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredServiceId( ServiceId );
		if( members.containsKey( key ) ) {
			ICFBamServiceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServiceByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamServiceByClusterIdxKey key = schema.getBackingStore().getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
				ICFBamServiceObj cur = null;
				Iterator<ICFBamServiceObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetServiceByHostIdx( long ClusterId,
		long HostNodeId )
	{
		if( indexByHostIdx == null ) {
			return;
		}
		CFBamServiceByHostIdxKey key = schema.getBackingStore().getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		if( indexByHostIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj > mapHostIdx = indexByHostIdx.get( key );
			if( mapHostIdx != null ) {
				List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
				ICFBamServiceObj cur = null;
				Iterator<ICFBamServiceObj> iter = mapHostIdx.values().iterator();
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

			indexByHostIdx.remove( key );
		}
	}

	public void forgetServiceByTypeIdx( int ServiceTypeId )
	{
		if( indexByTypeIdx == null ) {
			return;
		}
		CFBamServiceByTypeIdxKey key = schema.getBackingStore().getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( ServiceTypeId );
		if( indexByTypeIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj > mapTypeIdx = indexByTypeIdx.get( key );
			if( mapTypeIdx != null ) {
				List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
				ICFBamServiceObj cur = null;
				Iterator<ICFBamServiceObj> iter = mapTypeIdx.values().iterator();
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

			indexByTypeIdx.remove( key );
		}
	}

	public void forgetServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		if( indexByUTypeIdx == null ) {
			return;
		}
		CFBamServiceByUTypeIdxKey key = schema.getBackingStore().getFactoryService().newUTypeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredServiceTypeId( ServiceTypeId );
		if( indexByUTypeIdx.containsKey( key ) ) {
			ICFBamServiceObj probed = indexByUTypeIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUTypeIdx.remove( key );
		}
	}

	public void forgetServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		if( indexByUHostPortIdx == null ) {
			return;
		}
		CFBamServiceByUHostPortIdxKey key = schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredHostPort( HostPort );
		if( indexByUHostPortIdx.containsKey( key ) ) {
			ICFBamServiceObj probed = indexByUHostPortIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUHostPortIdx.remove( key );
		}
	}

	public ICFBamServiceObj createService( ICFBamServiceObj Obj ) {
		ICFBamServiceObj obj = Obj;
		CFBamServiceBuff buff = obj.getServiceBuff();
		schema.getBackingStore().getTableService().createService(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamServiceObj readService( CFBamServicePKey pkey ) {
		return( readService( pkey, false ) );
	}

	public ICFBamServiceObj readService( CFBamServicePKey pkey, boolean forceRead ) {
		ICFBamServiceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamServiceBuff readBuff = schema.getBackingStore().getTableService().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredServiceId() );
			if( readBuff != null ) {
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamServiceObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamServiceObj lockService( CFBamServicePKey pkey ) {
		ICFBamServiceObj locked = null;
		CFBamServiceBuff lockBuff = schema.getBackingStore().getTableService().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getServiceTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamServiceObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockService", pkey );
		}
		return( locked );
	}

	public List<ICFBamServiceObj> readAllService() {
		return( readAllService( false ) );
	}

	public List<ICFBamServiceObj> readAllService( boolean forceRead ) {
		final String S_ProcName = "readAllService";
		if( ( allService == null ) || forceRead ) {
			Map<CFBamServicePKey, ICFBamServiceObj> map = new HashMap<CFBamServicePKey,ICFBamServiceObj>();
			allService = map;
			CFBamServiceBuff[] buffList = schema.getBackingStore().getTableService().readAllDerived( schema.getAuthorization() );
			CFBamServiceBuff buff;
			ICFBamServiceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				ICFBamServiceObj realized = (ICFBamServiceObj)obj.realize();
			}
		}
		Comparator<ICFBamServiceObj> cmp = new Comparator<ICFBamServiceObj>() {
			public int compare( ICFBamServiceObj lhs, ICFBamServiceObj rhs ) {
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
					CFBamServicePKey lhsPKey = lhs.getPKey();
					CFBamServicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allService.size();
		ICFBamServiceObj arr[] = new ICFBamServiceObj[len];
		Iterator<ICFBamServiceObj> valIter = allService.values().iterator();
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
		ArrayList<ICFBamServiceObj> arrayList = new ArrayList<ICFBamServiceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServiceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId )
	{
		return( readServiceByIdIdx( ClusterId,
			ServiceId,
			false ) );
	}

	public ICFBamServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId, boolean forceRead )
	{
		CFBamServicePKey pkey = schema.getBackingStore().getFactoryService().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredServiceId( ServiceId );
		ICFBamServiceObj obj = readService( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamServiceObj> readServiceByClusterIdx( long ClusterId )
	{
		return( readServiceByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamServiceObj> readServiceByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readServiceByClusterIdx";
		CFBamServiceByClusterIdxKey key = schema.getBackingStore().getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamServicePKey, ICFBamServiceObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamServiceByClusterIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamServicePKey, ICFBamServiceObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamServiceObj obj;
			CFBamServiceBuff[] buffList = schema.getBackingStore().getTableService().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamServiceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				ICFBamServiceObj realized = (ICFBamServiceObj)obj.realize();
			}
		}
		Comparator<ICFBamServiceObj> cmp = new Comparator<ICFBamServiceObj>() {
			public int compare( ICFBamServiceObj lhs, ICFBamServiceObj rhs ) {
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
					CFBamServicePKey lhsPKey = lhs.getPKey();
					CFBamServicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamServiceObj arr[] = new ICFBamServiceObj[len];
		Iterator<ICFBamServiceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServiceObj> arrayList = new ArrayList<ICFBamServiceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServiceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId )
	{
		return( readServiceByHostIdx( ClusterId,
			HostNodeId,
			false ) );
	}

	public List<ICFBamServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId,
		boolean forceRead )
	{
		final String S_ProcName = "readServiceByHostIdx";
		CFBamServiceByHostIdxKey key = schema.getBackingStore().getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		Map<CFBamServicePKey, ICFBamServiceObj> dict;
		if( indexByHostIdx == null ) {
			indexByHostIdx = new HashMap< CFBamServiceByHostIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( ( ! forceRead ) && indexByHostIdx.containsKey( key ) ) {
			dict = indexByHostIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamServicePKey, ICFBamServiceObj>();
			// Allow other threads to dirty-read while we're loading
			indexByHostIdx.put( key, dict );
			ICFBamServiceObj obj;
			CFBamServiceBuff[] buffList = schema.getBackingStore().getTableService().readDerivedByHostIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId );
			CFBamServiceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				ICFBamServiceObj realized = (ICFBamServiceObj)obj.realize();
			}
		}
		Comparator<ICFBamServiceObj> cmp = new Comparator<ICFBamServiceObj>() {
			public int compare( ICFBamServiceObj lhs, ICFBamServiceObj rhs ) {
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
					CFBamServicePKey lhsPKey = lhs.getPKey();
					CFBamServicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamServiceObj arr[] = new ICFBamServiceObj[len];
		Iterator<ICFBamServiceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServiceObj> arrayList = new ArrayList<ICFBamServiceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServiceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServiceObj> readServiceByTypeIdx( int ServiceTypeId )
	{
		return( readServiceByTypeIdx( ServiceTypeId,
			false ) );
	}

	public List<ICFBamServiceObj> readServiceByTypeIdx( int ServiceTypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readServiceByTypeIdx";
		CFBamServiceByTypeIdxKey key = schema.getBackingStore().getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( ServiceTypeId );
		Map<CFBamServicePKey, ICFBamServiceObj> dict;
		if( indexByTypeIdx == null ) {
			indexByTypeIdx = new HashMap< CFBamServiceByTypeIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( ( ! forceRead ) && indexByTypeIdx.containsKey( key ) ) {
			dict = indexByTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamServicePKey, ICFBamServiceObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTypeIdx.put( key, dict );
			ICFBamServiceObj obj;
			CFBamServiceBuff[] buffList = schema.getBackingStore().getTableService().readDerivedByTypeIdx( schema.getAuthorization(),
				ServiceTypeId );
			CFBamServiceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				ICFBamServiceObj realized = (ICFBamServiceObj)obj.realize();
			}
		}
		Comparator<ICFBamServiceObj> cmp = new Comparator<ICFBamServiceObj>() {
			public int compare( ICFBamServiceObj lhs, ICFBamServiceObj rhs ) {
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
					CFBamServicePKey lhsPKey = lhs.getPKey();
					CFBamServicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamServiceObj arr[] = new ICFBamServiceObj[len];
		Iterator<ICFBamServiceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServiceObj> arrayList = new ArrayList<ICFBamServiceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServiceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServiceObj readServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		return( readServiceByUTypeIdx( ClusterId,
			HostNodeId,
			ServiceTypeId,
			false ) );
	}

	public ICFBamServiceObj readServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId, boolean forceRead )
	{
		if( indexByUTypeIdx == null ) {
			indexByUTypeIdx = new HashMap< CFBamServiceByUTypeIdxKey,
				ICFBamServiceObj >();
		}
		CFBamServiceByUTypeIdxKey key = schema.getBackingStore().getFactoryService().newUTypeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredServiceTypeId( ServiceTypeId );
		ICFBamServiceObj obj = null;
		if( ( ! forceRead ) && indexByUTypeIdx.containsKey( key ) ) {
			obj = indexByUTypeIdx.get( key );
		}
		else {
			CFBamServiceBuff buff = schema.getBackingStore().getTableService().readDerivedByUTypeIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				ServiceTypeId );
			if( buff != null ) {
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServiceObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUTypeIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamServiceObj readServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		return( readServiceByUHostPortIdx( ClusterId,
			HostNodeId,
			HostPort,
			false ) );
	}

	public ICFBamServiceObj readServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort, boolean forceRead )
	{
		if( indexByUHostPortIdx == null ) {
			indexByUHostPortIdx = new HashMap< CFBamServiceByUHostPortIdxKey,
				ICFBamServiceObj >();
		}
		CFBamServiceByUHostPortIdxKey key = schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredHostPort( HostPort );
		ICFBamServiceObj obj = null;
		if( ( ! forceRead ) && indexByUHostPortIdx.containsKey( key ) ) {
			obj = indexByUHostPortIdx.get( key );
		}
		else {
			CFBamServiceBuff buff = schema.getBackingStore().getTableService().readDerivedByUHostPortIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				HostPort );
			if( buff != null ) {
				obj = schema.getServiceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryService().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServiceObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUHostPortIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamServiceObj updateService( ICFBamServiceObj Obj ) {
		ICFBamServiceObj obj = Obj;
		schema.getBackingStore().getTableService().updateService( schema.getAuthorization(),
			Obj.getServiceBuff() );
		obj = (ICFBamServiceObj)Obj.realize();
		return( obj );
	}

	public void deleteService( ICFBamServiceObj Obj ) {
		ICFBamServiceObj obj = Obj;
		schema.getBackingStore().getTableService().deleteService( schema.getAuthorization(),
			obj.getServiceBuff() );
		obj.forget( true );
	}

	public void deleteServiceByIdIdx( long ClusterId,
		long ServiceId )
	{
		CFBamServicePKey pkey = schema.getBackingStore().getFactoryService().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredServiceId( ServiceId );
		ICFBamServiceObj obj = readService( pkey );
		if( obj != null ) {
			ICFBamServiceEditObj editObj = (ICFBamServiceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamServiceEditObj)obj.beginEdit();
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

	public void deleteServiceByClusterIdx( long ClusterId )
	{
		CFBamServiceByClusterIdxKey key = schema.getBackingStore().getFactoryService().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamServiceByClusterIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableService().deleteServiceByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamServiceObj> iter = dict.values().iterator();
			ICFBamServiceObj obj;
			List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
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
			schema.getBackingStore().getTableService().deleteServiceByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteServiceByHostIdx( long ClusterId,
		long HostNodeId )
	{
		CFBamServiceByHostIdxKey key = schema.getBackingStore().getFactoryService().newHostIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		if( indexByHostIdx == null ) {
			indexByHostIdx = new HashMap< CFBamServiceByHostIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( indexByHostIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj> dict = indexByHostIdx.get( key );
			schema.getBackingStore().getTableService().deleteServiceByHostIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId );
			Iterator<ICFBamServiceObj> iter = dict.values().iterator();
			ICFBamServiceObj obj;
			List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByHostIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableService().deleteServiceByHostIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId );
		}
	}

	public void deleteServiceByTypeIdx( int ServiceTypeId )
	{
		CFBamServiceByTypeIdxKey key = schema.getBackingStore().getFactoryService().newTypeIdxKey();
		key.setRequiredServiceTypeId( ServiceTypeId );
		if( indexByTypeIdx == null ) {
			indexByTypeIdx = new HashMap< CFBamServiceByTypeIdxKey,
				Map< CFBamServicePKey, ICFBamServiceObj > >();
		}
		if( indexByTypeIdx.containsKey( key ) ) {
			Map<CFBamServicePKey, ICFBamServiceObj> dict = indexByTypeIdx.get( key );
			schema.getBackingStore().getTableService().deleteServiceByTypeIdx( schema.getAuthorization(),
				ServiceTypeId );
			Iterator<ICFBamServiceObj> iter = dict.values().iterator();
			ICFBamServiceObj obj;
			List<ICFBamServiceObj> toForget = new LinkedList<ICFBamServiceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTypeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableService().deleteServiceByTypeIdx( schema.getAuthorization(),
				ServiceTypeId );
		}
	}

	public void deleteServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId )
	{
		if( indexByUTypeIdx == null ) {
			indexByUTypeIdx = new HashMap< CFBamServiceByUTypeIdxKey,
				ICFBamServiceObj >();
		}
		CFBamServiceByUTypeIdxKey key = schema.getBackingStore().getFactoryService().newUTypeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredServiceTypeId( ServiceTypeId );
		ICFBamServiceObj obj = null;
		if( indexByUTypeIdx.containsKey( key ) ) {
			obj = indexByUTypeIdx.get( key );
			schema.getBackingStore().getTableService().deleteServiceByUTypeIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				ServiceTypeId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableService().deleteServiceByUTypeIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				ServiceTypeId );
		}
	}

	public void deleteServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort )
	{
		if( indexByUHostPortIdx == null ) {
			indexByUHostPortIdx = new HashMap< CFBamServiceByUHostPortIdxKey,
				ICFBamServiceObj >();
		}
		CFBamServiceByUHostPortIdxKey key = schema.getBackingStore().getFactoryService().newUHostPortIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		key.setRequiredHostPort( HostPort );
		ICFBamServiceObj obj = null;
		if( indexByUHostPortIdx.containsKey( key ) ) {
			obj = indexByUHostPortIdx.get( key );
			schema.getBackingStore().getTableService().deleteServiceByUHostPortIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				HostPort );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableService().deleteServiceByUHostPortIdx( schema.getAuthorization(),
				ClusterId,
				HostNodeId,
				HostPort );
		}
	}
}
