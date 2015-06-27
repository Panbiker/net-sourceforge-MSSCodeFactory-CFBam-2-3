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

public class CFBamSysClusterTableObj
	implements ICFBamSysClusterTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSysClusterPKey, ICFBamSysClusterObj> members;
	private Map<CFBamSysClusterPKey, ICFBamSysClusterObj> allSysCluster;
	private Map< CFBamSysClusterByClusterIdxKey,
		Map<CFBamSysClusterPKey, ICFBamSysClusterObj > > indexByClusterIdx;
	public static String TABLE_NAME = "SysCluster";
	public static String TABLE_DBNAME = "sysclus";

	public CFBamSysClusterTableObj() {
		schema = null;
		members = new HashMap<CFBamSysClusterPKey, ICFBamSysClusterObj>();
		allSysCluster = null;
		indexByClusterIdx = null;
	}

	public CFBamSysClusterTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSysClusterPKey, ICFBamSysClusterObj>();
		allSysCluster = null;
		indexByClusterIdx = null;
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
		allSysCluster = null;
		indexByClusterIdx = null;
		List<ICFBamSysClusterObj> toForget = new LinkedList<ICFBamSysClusterObj>();
		ICFBamSysClusterObj cur = null;
		Iterator<ICFBamSysClusterObj> iter = members.values().iterator();
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
	 *	CFBamSysClusterObj.
	 */
	public ICFBamSysClusterObj newInstance() {
		ICFBamSysClusterObj inst = new CFBamSysClusterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSysClusterObj.
	 */
	public ICFBamSysClusterEditObj newEditInstance( ICFBamSysClusterObj orig ) {
		ICFBamSysClusterEditObj edit = new CFBamSysClusterEditObj( orig );
		return( edit );
	}

	public ICFBamSysClusterObj realizeSysCluster( ICFBamSysClusterObj Obj ) {
		ICFBamSysClusterObj obj = Obj;
		CFBamSysClusterPKey pkey = obj.getPKey();
		ICFBamSysClusterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSysClusterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSysClusterByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSysClusterPKey, ICFBamSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSysClusterByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSysClusterPKey, ICFBamSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allSysCluster != null ) {
				allSysCluster.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSysCluster != null ) {
				allSysCluster.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSysClusterByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSysClusterPKey, ICFBamSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetSysCluster( ICFBamSysClusterObj Obj ) {
		forgetSysCluster( Obj, false );
	}

	public void forgetSysCluster( ICFBamSysClusterObj Obj, boolean forgetSubObjects ) {
		ICFBamSysClusterObj obj = Obj;
		CFBamSysClusterPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSysClusterObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSysClusterByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSysClusterPKey, ICFBamSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( allSysCluster != null ) {
				allSysCluster.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSysClusterByIdIdx( int SingletonId )
	{
		if( members == null ) {
			return;
		}
		CFBamSysClusterPKey key = schema.getBackingStore().getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( SingletonId );
		if( members.containsKey( key ) ) {
			ICFBamSysClusterObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSysClusterByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSysClusterByClusterIdxKey key = schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSysClusterPKey, ICFBamSysClusterObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSysClusterObj> toForget = new LinkedList<ICFBamSysClusterObj>();
				ICFBamSysClusterObj cur = null;
				Iterator<ICFBamSysClusterObj> iter = mapClusterIdx.values().iterator();
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

	public ICFBamSysClusterObj createSysCluster( ICFBamSysClusterObj Obj ) {
		ICFBamSysClusterObj obj = Obj;
		CFBamSysClusterBuff buff = obj.getSysClusterBuff();
		schema.getBackingStore().getTableSysCluster().createSysCluster(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSysClusterObj readSysCluster( CFBamSysClusterPKey pkey ) {
		return( readSysCluster( pkey, false ) );
	}

	public ICFBamSysClusterObj readSysCluster( CFBamSysClusterPKey pkey, boolean forceRead ) {
		ICFBamSysClusterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSysClusterBuff readBuff = schema.getBackingStore().getTableSysCluster().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSingletonId() );
			if( readBuff != null ) {
				obj = schema.getSysClusterTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySysCluster().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSysClusterObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSysClusterObj lockSysCluster( CFBamSysClusterPKey pkey ) {
		ICFBamSysClusterObj locked = null;
		CFBamSysClusterBuff lockBuff = schema.getBackingStore().getTableSysCluster().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSysClusterTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySysCluster().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSysClusterObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSysCluster", pkey );
		}
		return( locked );
	}

	public List<ICFBamSysClusterObj> readAllSysCluster() {
		return( readAllSysCluster( false ) );
	}

	public List<ICFBamSysClusterObj> readAllSysCluster( boolean forceRead ) {
		final String S_ProcName = "readAllSysCluster";
		if( ( allSysCluster == null ) || forceRead ) {
			Map<CFBamSysClusterPKey, ICFBamSysClusterObj> map = new HashMap<CFBamSysClusterPKey,ICFBamSysClusterObj>();
			allSysCluster = map;
			CFBamSysClusterBuff[] buffList = schema.getBackingStore().getTableSysCluster().readAllDerived( schema.getAuthorization() );
			CFBamSysClusterBuff buff;
			ICFBamSysClusterObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySysCluster().newPKey() );
				obj.setBuff( buff );
				ICFBamSysClusterObj realized = (ICFBamSysClusterObj)obj.realize();
			}
		}
		Comparator<ICFBamSysClusterObj> cmp = new Comparator<ICFBamSysClusterObj>() {
			public int compare( ICFBamSysClusterObj lhs, ICFBamSysClusterObj rhs ) {
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
					CFBamSysClusterPKey lhsPKey = lhs.getPKey();
					CFBamSysClusterPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSysCluster.size();
		ICFBamSysClusterObj arr[] = new ICFBamSysClusterObj[len];
		Iterator<ICFBamSysClusterObj> valIter = allSysCluster.values().iterator();
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
		ArrayList<ICFBamSysClusterObj> arrayList = new ArrayList<ICFBamSysClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSysClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSysClusterObj readSysClusterByIdIdx( int SingletonId )
	{
		return( readSysClusterByIdIdx( SingletonId,
			false ) );
	}

	public ICFBamSysClusterObj readSysClusterByIdIdx( int SingletonId, boolean forceRead )
	{
		CFBamSysClusterPKey pkey = schema.getBackingStore().getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( SingletonId );
		ICFBamSysClusterObj obj = readSysCluster( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSysClusterObj> readSysClusterByClusterIdx( long ClusterId )
	{
		return( readSysClusterByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSysClusterObj> readSysClusterByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSysClusterByClusterIdx";
		CFBamSysClusterByClusterIdxKey key = schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSysClusterPKey, ICFBamSysClusterObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSysClusterByClusterIdxKey,
				Map< CFBamSysClusterPKey, ICFBamSysClusterObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSysClusterPKey, ICFBamSysClusterObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSysClusterObj obj;
			CFBamSysClusterBuff[] buffList = schema.getBackingStore().getTableSysCluster().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSysClusterBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSysClusterTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySysCluster().newPKey() );
				obj.setBuff( buff );
				ICFBamSysClusterObj realized = (ICFBamSysClusterObj)obj.realize();
			}
		}
		Comparator<ICFBamSysClusterObj> cmp = new Comparator<ICFBamSysClusterObj>() {
			public int compare( ICFBamSysClusterObj lhs, ICFBamSysClusterObj rhs ) {
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
					CFBamSysClusterPKey lhsPKey = lhs.getPKey();
					CFBamSysClusterPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSysClusterObj arr[] = new ICFBamSysClusterObj[len];
		Iterator<ICFBamSysClusterObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSysClusterObj> arrayList = new ArrayList<ICFBamSysClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSysClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSysClusterObj updateSysCluster( ICFBamSysClusterObj Obj ) {
		ICFBamSysClusterObj obj = Obj;
		schema.getBackingStore().getTableSysCluster().updateSysCluster( schema.getAuthorization(),
			Obj.getSysClusterBuff() );
		obj = (ICFBamSysClusterObj)Obj.realize();
		return( obj );
	}

	public void deleteSysCluster( ICFBamSysClusterObj Obj ) {
		ICFBamSysClusterObj obj = Obj;
		schema.getBackingStore().getTableSysCluster().deleteSysCluster( schema.getAuthorization(),
			obj.getSysClusterBuff() );
		obj.forget( true );
	}

	public void deleteSysClusterByIdIdx( int SingletonId )
	{
		CFBamSysClusterPKey pkey = schema.getBackingStore().getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( SingletonId );
		ICFBamSysClusterObj obj = readSysCluster( pkey );
		if( obj != null ) {
			ICFBamSysClusterEditObj editObj = (ICFBamSysClusterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSysClusterEditObj)obj.beginEdit();
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

	public void deleteSysClusterByClusterIdx( long ClusterId )
	{
		CFBamSysClusterByClusterIdxKey key = schema.getBackingStore().getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSysClusterByClusterIdxKey,
				Map< CFBamSysClusterPKey, ICFBamSysClusterObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSysClusterPKey, ICFBamSysClusterObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSysCluster().deleteSysClusterByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSysClusterObj> iter = dict.values().iterator();
			ICFBamSysClusterObj obj;
			List<ICFBamSysClusterObj> toForget = new LinkedList<ICFBamSysClusterObj>();
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
			schema.getBackingStore().getTableSysCluster().deleteSysClusterByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}
}
