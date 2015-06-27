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

public class CFBamSecDeviceTableObj
	implements ICFBamSecDeviceTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecDevicePKey, ICFBamSecDeviceObj> members;
	private Map<CFBamSecDevicePKey, ICFBamSecDeviceObj> allSecDevice;
	private Map< CFBamSecDeviceByUserIdxKey,
		Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > > indexByUserIdx;
	public static String TABLE_NAME = "SecDevice";
	public static String TABLE_DBNAME = "secdev";

	public CFBamSecDeviceTableObj() {
		schema = null;
		members = new HashMap<CFBamSecDevicePKey, ICFBamSecDeviceObj>();
		allSecDevice = null;
		indexByUserIdx = null;
	}

	public CFBamSecDeviceTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecDevicePKey, ICFBamSecDeviceObj>();
		allSecDevice = null;
		indexByUserIdx = null;
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
		allSecDevice = null;
		indexByUserIdx = null;
		List<ICFBamSecDeviceObj> toForget = new LinkedList<ICFBamSecDeviceObj>();
		ICFBamSecDeviceObj cur = null;
		Iterator<ICFBamSecDeviceObj> iter = members.values().iterator();
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
	 *	CFBamSecDeviceObj.
	 */
	public ICFBamSecDeviceObj newInstance() {
		ICFBamSecDeviceObj inst = new CFBamSecDeviceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecDeviceObj.
	 */
	public ICFBamSecDeviceEditObj newEditInstance( ICFBamSecDeviceObj orig ) {
		ICFBamSecDeviceEditObj edit = new CFBamSecDeviceEditObj( orig );
		return( edit );
	}

	public ICFBamSecDeviceObj realizeSecDevice( ICFBamSecDeviceObj Obj ) {
		ICFBamSecDeviceObj obj = Obj;
		CFBamSecDevicePKey pkey = obj.getPKey();
		ICFBamSecDeviceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecDeviceObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUserIdx != null ) {
				CFBamSecDeviceByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUserIdx != null ) {
				CFBamSecDeviceByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allSecDevice != null ) {
				allSecDevice.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecDevice != null ) {
				allSecDevice.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUserIdx != null ) {
				CFBamSecDeviceByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetSecDevice( ICFBamSecDeviceObj Obj ) {
		forgetSecDevice( Obj, false );
	}

	public void forgetSecDevice( ICFBamSecDeviceObj Obj, boolean forgetSubObjects ) {
		ICFBamSecDeviceObj obj = Obj;
		CFBamSecDevicePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecDeviceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUserIdx != null ) {
				CFBamSecDeviceByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( allSecDevice != null ) {
				allSecDevice.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		if( members == null ) {
			return;
		}
		CFBamSecDevicePKey key = schema.getBackingStore().getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );
		if( members.containsKey( key ) ) {
			ICFBamSecDeviceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecDeviceByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		CFBamSecDeviceByUserIdxKey key = schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamSecDevicePKey, ICFBamSecDeviceObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				List<ICFBamSecDeviceObj> toForget = new LinkedList<ICFBamSecDeviceObj>();
				ICFBamSecDeviceObj cur = null;
				Iterator<ICFBamSecDeviceObj> iter = mapUserIdx.values().iterator();
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

			indexByUserIdx.remove( key );
		}
	}

	public ICFBamSecDeviceObj createSecDevice( ICFBamSecDeviceObj Obj ) {
		ICFBamSecDeviceObj obj = Obj;
		CFBamSecDeviceBuff buff = obj.getSecDeviceBuff();
		schema.getBackingStore().getTableSecDevice().createSecDevice(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecDeviceObj readSecDevice( CFBamSecDevicePKey pkey ) {
		return( readSecDevice( pkey, false ) );
	}

	public ICFBamSecDeviceObj readSecDevice( CFBamSecDevicePKey pkey, boolean forceRead ) {
		ICFBamSecDeviceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecDeviceBuff readBuff = schema.getBackingStore().getTableSecDevice().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecUserId(),
				pkey.getRequiredDevName() );
			if( readBuff != null ) {
				obj = schema.getSecDeviceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecDevice().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecDeviceObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecDeviceObj lockSecDevice( CFBamSecDevicePKey pkey ) {
		ICFBamSecDeviceObj locked = null;
		CFBamSecDeviceBuff lockBuff = schema.getBackingStore().getTableSecDevice().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecDeviceTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecDevice().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecDeviceObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecDevice", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecDeviceObj> readAllSecDevice() {
		return( readAllSecDevice( false ) );
	}

	public List<ICFBamSecDeviceObj> readAllSecDevice( boolean forceRead ) {
		final String S_ProcName = "readAllSecDevice";
		if( ( allSecDevice == null ) || forceRead ) {
			Map<CFBamSecDevicePKey, ICFBamSecDeviceObj> map = new HashMap<CFBamSecDevicePKey,ICFBamSecDeviceObj>();
			allSecDevice = map;
			CFBamSecDeviceBuff[] buffList = schema.getBackingStore().getTableSecDevice().readAllDerived( schema.getAuthorization() );
			CFBamSecDeviceBuff buff;
			ICFBamSecDeviceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecDevice().newPKey() );
				obj.setBuff( buff );
				ICFBamSecDeviceObj realized = (ICFBamSecDeviceObj)obj.realize();
			}
		}
		Comparator<ICFBamSecDeviceObj> cmp = new Comparator<ICFBamSecDeviceObj>() {
			public int compare( ICFBamSecDeviceObj lhs, ICFBamSecDeviceObj rhs ) {
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
					CFBamSecDevicePKey lhsPKey = lhs.getPKey();
					CFBamSecDevicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecDevice.size();
		ICFBamSecDeviceObj arr[] = new ICFBamSecDeviceObj[len];
		Iterator<ICFBamSecDeviceObj> valIter = allSecDevice.values().iterator();
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
		ArrayList<ICFBamSecDeviceObj> arrayList = new ArrayList<ICFBamSecDeviceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecDeviceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		return( readSecDeviceByIdIdx( SecUserId,
			DevName,
			false ) );
	}

	public ICFBamSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName, boolean forceRead )
	{
		CFBamSecDevicePKey pkey = schema.getBackingStore().getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredDevName( DevName );
		ICFBamSecDeviceObj obj = readSecDevice( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId )
	{
		return( readSecDeviceByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFBamSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecDeviceByUserIdx";
		CFBamSecDeviceByUserIdxKey key = schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFBamSecDevicePKey, ICFBamSecDeviceObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamSecDeviceByUserIdxKey,
				Map< CFBamSecDevicePKey, ICFBamSecDeviceObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecDevicePKey, ICFBamSecDeviceObj>();
			// Allow other threads to dirty-read while we're loading
			indexByUserIdx.put( key, dict );
			ICFBamSecDeviceObj obj;
			CFBamSecDeviceBuff[] buffList = schema.getBackingStore().getTableSecDevice().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFBamSecDeviceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecDeviceTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecDevice().newPKey() );
				obj.setBuff( buff );
				ICFBamSecDeviceObj realized = (ICFBamSecDeviceObj)obj.realize();
			}
		}
		Comparator<ICFBamSecDeviceObj> cmp = new Comparator<ICFBamSecDeviceObj>() {
			public int compare( ICFBamSecDeviceObj lhs, ICFBamSecDeviceObj rhs ) {
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
					CFBamSecDevicePKey lhsPKey = lhs.getPKey();
					CFBamSecDevicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecDeviceObj arr[] = new ICFBamSecDeviceObj[len];
		Iterator<ICFBamSecDeviceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecDeviceObj> arrayList = new ArrayList<ICFBamSecDeviceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecDeviceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecDeviceObj updateSecDevice( ICFBamSecDeviceObj Obj ) {
		ICFBamSecDeviceObj obj = Obj;
		schema.getBackingStore().getTableSecDevice().updateSecDevice( schema.getAuthorization(),
			Obj.getSecDeviceBuff() );
		obj = (ICFBamSecDeviceObj)Obj.realize();
		return( obj );
	}

	public void deleteSecDevice( ICFBamSecDeviceObj Obj ) {
		ICFBamSecDeviceObj obj = Obj;
		schema.getBackingStore().getTableSecDevice().deleteSecDevice( schema.getAuthorization(),
			obj.getSecDeviceBuff() );
		obj.forget( true );
	}

	public void deleteSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		CFBamSecDevicePKey pkey = schema.getBackingStore().getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredDevName( DevName );
		ICFBamSecDeviceObj obj = readSecDevice( pkey );
		if( obj != null ) {
			ICFBamSecDeviceEditObj editObj = (ICFBamSecDeviceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecDeviceEditObj)obj.beginEdit();
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

	public void deleteSecDeviceByUserIdx( UUID SecUserId )
	{
		CFBamSecDeviceByUserIdxKey key = schema.getBackingStore().getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamSecDeviceByUserIdxKey,
				Map< CFBamSecDevicePKey, ICFBamSecDeviceObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamSecDevicePKey, ICFBamSecDeviceObj> dict = indexByUserIdx.get( key );
			schema.getBackingStore().getTableSecDevice().deleteSecDeviceByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFBamSecDeviceObj> iter = dict.values().iterator();
			ICFBamSecDeviceObj obj;
			List<ICFBamSecDeviceObj> toForget = new LinkedList<ICFBamSecDeviceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByUserIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecDevice().deleteSecDeviceByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}
}
