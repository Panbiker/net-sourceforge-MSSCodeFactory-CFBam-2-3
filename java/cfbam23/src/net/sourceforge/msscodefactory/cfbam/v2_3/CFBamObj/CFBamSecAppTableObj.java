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

public class CFBamSecAppTableObj
	implements ICFBamSecAppTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecAppPKey, ICFBamSecAppObj> members;
	private Map<CFBamSecAppPKey, ICFBamSecAppObj> allSecApp;
	private Map< CFBamSecAppByClusterIdxKey,
		Map<CFBamSecAppPKey, ICFBamSecAppObj > > indexByClusterIdx;
	private Map< CFBamSecAppByUJEEMountIdxKey,
		ICFBamSecAppObj > indexByUJEEMountIdx;
	public static String TABLE_NAME = "SecApp";
	public static String TABLE_DBNAME = "secapp";

	public CFBamSecAppTableObj() {
		schema = null;
		members = new HashMap<CFBamSecAppPKey, ICFBamSecAppObj>();
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
	}

	public CFBamSecAppTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecAppPKey, ICFBamSecAppObj>();
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
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
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
		List<ICFBamSecAppObj> toForget = new LinkedList<ICFBamSecAppObj>();
		ICFBamSecAppObj cur = null;
		Iterator<ICFBamSecAppObj> iter = members.values().iterator();
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
	 *	CFBamSecAppObj.
	 */
	public ICFBamSecAppObj newInstance() {
		ICFBamSecAppObj inst = new CFBamSecAppObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecAppObj.
	 */
	public ICFBamSecAppEditObj newEditInstance( ICFBamSecAppObj orig ) {
		ICFBamSecAppEditObj edit = new CFBamSecAppEditObj( orig );
		return( edit );
	}

	public ICFBamSecAppObj realizeSecApp( ICFBamSecAppObj Obj ) {
		ICFBamSecAppObj obj = Obj;
		CFBamSecAppPKey pkey = obj.getPKey();
		ICFBamSecAppObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecAppObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecAppByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecAppPKey, ICFBamSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.remove( keyUJEEMountIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecAppByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecAppPKey, ICFBamSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.put( keyUJEEMountIdx, keepObj );
			}
			if( allSecApp != null ) {
				allSecApp.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecApp != null ) {
				allSecApp.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecAppByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecAppPKey, ICFBamSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.put( keyUJEEMountIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecApp( ICFBamSecAppObj Obj ) {
		forgetSecApp( Obj, false );
	}

	public void forgetSecApp( ICFBamSecAppObj Obj, boolean forgetSubObjects ) {
		ICFBamSecAppObj obj = Obj;
		CFBamSecAppPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecAppObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecAppByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecAppPKey, ICFBamSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFBamSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.remove( keyUJEEMountIdx );
			}

			if( allSecApp != null ) {
				allSecApp.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getSecFormTableObj().forgetSecFormBySecAppIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecAppId() );
			}
		}
	}

	public void forgetSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecAppPKey key = schema.getBackingStore().getFactorySecApp().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( members.containsKey( key ) ) {
			ICFBamSecAppObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecAppByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecAppByClusterIdxKey key = schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecAppPKey, ICFBamSecAppObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecAppObj> toForget = new LinkedList<ICFBamSecAppObj>();
				ICFBamSecAppObj cur = null;
				Iterator<ICFBamSecAppObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		if( indexByUJEEMountIdx == null ) {
			return;
		}
		CFBamSecAppByUJEEMountIdxKey key = schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		if( indexByUJEEMountIdx.containsKey( key ) ) {
			ICFBamSecAppObj probed = indexByUJEEMountIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUJEEMountIdx.remove( key );
		}
	}

	public ICFBamSecAppObj createSecApp( ICFBamSecAppObj Obj ) {
		ICFBamSecAppObj obj = Obj;
		CFBamSecAppBuff buff = obj.getSecAppBuff();
		schema.getBackingStore().getTableSecApp().createSecApp(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecAppObj readSecApp( CFBamSecAppPKey pkey ) {
		return( readSecApp( pkey, false ) );
	}

	public ICFBamSecAppObj readSecApp( CFBamSecAppPKey pkey, boolean forceRead ) {
		ICFBamSecAppObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecAppBuff readBuff = schema.getBackingStore().getTableSecApp().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecAppId() );
			if( readBuff != null ) {
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecApp().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecAppObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecAppObj lockSecApp( CFBamSecAppPKey pkey ) {
		ICFBamSecAppObj locked = null;
		CFBamSecAppBuff lockBuff = schema.getBackingStore().getTableSecApp().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecAppTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecApp().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecAppObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecApp", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecAppObj> readAllSecApp() {
		return( readAllSecApp( false ) );
	}

	public List<ICFBamSecAppObj> readAllSecApp( boolean forceRead ) {
		final String S_ProcName = "readAllSecApp";
		if( ( allSecApp == null ) || forceRead ) {
			Map<CFBamSecAppPKey, ICFBamSecAppObj> map = new HashMap<CFBamSecAppPKey,ICFBamSecAppObj>();
			allSecApp = map;
			CFBamSecAppBuff[] buffList = schema.getBackingStore().getTableSecApp().readAllDerived( schema.getAuthorization() );
			CFBamSecAppBuff buff;
			ICFBamSecAppObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				ICFBamSecAppObj realized = (ICFBamSecAppObj)obj.realize();
			}
		}
		Comparator<ICFBamSecAppObj> cmp = new Comparator<ICFBamSecAppObj>() {
			public int compare( ICFBamSecAppObj lhs, ICFBamSecAppObj rhs ) {
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
					CFBamSecAppPKey lhsPKey = lhs.getPKey();
					CFBamSecAppPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecApp.size();
		ICFBamSecAppObj arr[] = new ICFBamSecAppObj[len];
		Iterator<ICFBamSecAppObj> valIter = allSecApp.values().iterator();
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
		ArrayList<ICFBamSecAppObj> arrayList = new ArrayList<ICFBamSecAppObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecAppObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecAppByIdIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public ICFBamSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId, boolean forceRead )
	{
		CFBamSecAppPKey pkey = schema.getBackingStore().getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecAppId( SecAppId );
		ICFBamSecAppObj obj = readSecApp( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecAppObj> readSecAppByClusterIdx( long ClusterId )
	{
		return( readSecAppByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecAppObj> readSecAppByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecAppByClusterIdx";
		CFBamSecAppByClusterIdxKey key = schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecAppPKey, ICFBamSecAppObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecAppByClusterIdxKey,
				Map< CFBamSecAppPKey, ICFBamSecAppObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecAppPKey, ICFBamSecAppObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecAppObj obj;
			CFBamSecAppBuff[] buffList = schema.getBackingStore().getTableSecApp().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecAppBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				ICFBamSecAppObj realized = (ICFBamSecAppObj)obj.realize();
			}
		}
		Comparator<ICFBamSecAppObj> cmp = new Comparator<ICFBamSecAppObj>() {
			public int compare( ICFBamSecAppObj lhs, ICFBamSecAppObj rhs ) {
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
					CFBamSecAppPKey lhsPKey = lhs.getPKey();
					CFBamSecAppPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecAppObj arr[] = new ICFBamSecAppObj[len];
		Iterator<ICFBamSecAppObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecAppObj> arrayList = new ArrayList<ICFBamSecAppObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecAppObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecAppObj readSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		return( readSecAppByUJEEMountIdx( ClusterId,
			JEEMountName,
			false ) );
	}

	public ICFBamSecAppObj readSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName, boolean forceRead )
	{
		if( indexByUJEEMountIdx == null ) {
			indexByUJEEMountIdx = new HashMap< CFBamSecAppByUJEEMountIdxKey,
				ICFBamSecAppObj >();
		}
		CFBamSecAppByUJEEMountIdxKey key = schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		ICFBamSecAppObj obj = null;
		if( ( ! forceRead ) && indexByUJEEMountIdx.containsKey( key ) ) {
			obj = indexByUJEEMountIdx.get( key );
		}
		else {
			CFBamSecAppBuff buff = schema.getBackingStore().getTableSecApp().readDerivedByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
			if( buff != null ) {
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecAppObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUJEEMountIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecAppObj updateSecApp( ICFBamSecAppObj Obj ) {
		ICFBamSecAppObj obj = Obj;
		schema.getBackingStore().getTableSecApp().updateSecApp( schema.getAuthorization(),
			Obj.getSecAppBuff() );
		obj = (ICFBamSecAppObj)Obj.realize();
		return( obj );
	}

	public void deleteSecApp( ICFBamSecAppObj Obj ) {
		ICFBamSecAppObj obj = Obj;
		schema.getBackingStore().getTableSecApp().deleteSecApp( schema.getAuthorization(),
			obj.getSecAppBuff() );
		obj.forget( true );
	}

	public void deleteSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		CFBamSecAppPKey pkey = schema.getBackingStore().getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecAppId( SecAppId );
		ICFBamSecAppObj obj = readSecApp( pkey );
		if( obj != null ) {
			ICFBamSecAppEditObj editObj = (ICFBamSecAppEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecAppEditObj)obj.beginEdit();
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

	public void deleteSecAppByClusterIdx( long ClusterId )
	{
		CFBamSecAppByClusterIdxKey key = schema.getBackingStore().getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecAppByClusterIdxKey,
				Map< CFBamSecAppPKey, ICFBamSecAppObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecAppPKey, ICFBamSecAppObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecApp().deleteSecAppByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecAppObj> iter = dict.values().iterator();
			ICFBamSecAppObj obj;
			List<ICFBamSecAppObj> toForget = new LinkedList<ICFBamSecAppObj>();
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
			schema.getBackingStore().getTableSecApp().deleteSecAppByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		if( indexByUJEEMountIdx == null ) {
			indexByUJEEMountIdx = new HashMap< CFBamSecAppByUJEEMountIdxKey,
				ICFBamSecAppObj >();
		}
		CFBamSecAppByUJEEMountIdxKey key = schema.getBackingStore().getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		ICFBamSecAppObj obj = null;
		if( indexByUJEEMountIdx.containsKey( key ) ) {
			obj = indexByUJEEMountIdx.get( key );
			schema.getBackingStore().getTableSecApp().deleteSecAppByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecApp().deleteSecAppByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
		}
	}
}
