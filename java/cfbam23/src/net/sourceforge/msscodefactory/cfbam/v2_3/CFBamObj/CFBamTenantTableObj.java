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

public class CFBamTenantTableObj
	implements ICFBamTenantTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamTenantPKey, ICFBamTenantObj> members;
	private Map<CFBamTenantPKey, ICFBamTenantObj> allTenant;
	private Map< CFBamTenantByClusterIdxKey,
		Map<CFBamTenantPKey, ICFBamTenantObj > > indexByClusterIdx;
	private Map< CFBamTenantByUNameIdxKey,
		ICFBamTenantObj > indexByUNameIdx;
	public static String TABLE_NAME = "Tenant";
	public static String TABLE_DBNAME = "tenant";

	public CFBamTenantTableObj() {
		schema = null;
		members = new HashMap<CFBamTenantPKey, ICFBamTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamTenantTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamTenantPKey, ICFBamTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
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
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
		List<ICFBamTenantObj> toForget = new LinkedList<ICFBamTenantObj>();
		ICFBamTenantObj cur = null;
		Iterator<ICFBamTenantObj> iter = members.values().iterator();
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
	 *	CFBamTenantObj.
	 */
	public ICFBamTenantObj newInstance() {
		ICFBamTenantObj inst = new CFBamTenantObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTenantObj.
	 */
	public ICFBamTenantEditObj newEditInstance( ICFBamTenantObj orig ) {
		ICFBamTenantEditObj edit = new CFBamTenantEditObj( orig );
		return( edit );
	}

	public ICFBamTenantObj realizeTenant( ICFBamTenantObj Obj ) {
		ICFBamTenantObj obj = Obj;
		CFBamTenantPKey pkey = obj.getPKey();
		ICFBamTenantObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTenantObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamTenantByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamTenantPKey, ICFBamTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTenantByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamTenantByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamTenantPKey, ICFBamTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTenantByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allTenant != null ) {
				allTenant.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTenant != null ) {
				allTenant.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamTenantByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamTenantPKey, ICFBamTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTenantByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTenant( ICFBamTenantObj Obj ) {
		forgetTenant( Obj, false );
	}

	public void forgetTenant( ICFBamTenantObj Obj, boolean forgetSubObjects ) {
		ICFBamTenantObj obj = Obj;
		CFBamTenantPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTenantObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamTenantByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamTenantPKey, ICFBamTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTenantByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allTenant != null ) {
				allTenant.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTSecGroupTableObj().forgetTSecGroupByTenantIdx( keepObj.getRequiredId() );
				schema.getDomainBaseTableObj().forgetDomainBaseByTenantIdx( keepObj.getRequiredId() );
				schema.getTldTableObj().forgetTldByTenantIdx( keepObj.getRequiredId() );
				schema.getSchemaDefTableObj().forgetSchemaDefByCTenantIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTenantByIdIdx( long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamTenantPKey key = schema.getBackingStore().getFactoryTenant().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTenantObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTenantByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamTenantByClusterIdxKey key = schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamTenantPKey, ICFBamTenantObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamTenantObj> toForget = new LinkedList<ICFBamTenantObj>();
				ICFBamTenantObj cur = null;
				Iterator<ICFBamTenantObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamTenantByUNameIdxKey key = schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamTenantObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamTenantObj createTenant( ICFBamTenantObj Obj ) {
		ICFBamTenantObj obj = Obj;
		CFBamTenantBuff buff = obj.getTenantBuff();
		schema.getBackingStore().getTableTenant().createTenant(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamTenantObj readTenant( CFBamTenantPKey pkey ) {
		return( readTenant( pkey, false ) );
	}

	public ICFBamTenantObj readTenant( CFBamTenantPKey pkey, boolean forceRead ) {
		ICFBamTenantObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTenantBuff readBuff = schema.getBackingStore().getTableTenant().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTenant().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTenantObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTenantObj lockTenant( CFBamTenantPKey pkey ) {
		ICFBamTenantObj locked = null;
		CFBamTenantBuff lockBuff = schema.getBackingStore().getTableTenant().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTenantTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryTenant().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTenantObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTenant", pkey );
		}
		return( locked );
	}

	public List<ICFBamTenantObj> readAllTenant() {
		return( readAllTenant( false ) );
	}

	public List<ICFBamTenantObj> readAllTenant( boolean forceRead ) {
		final String S_ProcName = "readAllTenant";
		if( ( allTenant == null ) || forceRead ) {
			Map<CFBamTenantPKey, ICFBamTenantObj> map = new HashMap<CFBamTenantPKey,ICFBamTenantObj>();
			allTenant = map;
			CFBamTenantBuff[] buffList = schema.getBackingStore().getTableTenant().readAllDerived( schema.getAuthorization() );
			CFBamTenantBuff buff;
			ICFBamTenantObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFBamTenantObj realized = (ICFBamTenantObj)obj.realize();
			}
		}
		Comparator<ICFBamTenantObj> cmp = new Comparator<ICFBamTenantObj>() {
			public int compare( ICFBamTenantObj lhs, ICFBamTenantObj rhs ) {
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
					CFBamTenantPKey lhsPKey = lhs.getPKey();
					CFBamTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTenant.size();
		ICFBamTenantObj arr[] = new ICFBamTenantObj[len];
		Iterator<ICFBamTenantObj> valIter = allTenant.values().iterator();
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
		ArrayList<ICFBamTenantObj> arrayList = new ArrayList<ICFBamTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTenantObj readTenantByIdIdx( long Id )
	{
		return( readTenantByIdIdx( Id,
			false ) );
	}

	public ICFBamTenantObj readTenantByIdIdx( long Id, boolean forceRead )
	{
		CFBamTenantPKey pkey = schema.getBackingStore().getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFBamTenantObj obj = readTenant( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTenantObj> readTenantByClusterIdx( long ClusterId )
	{
		return( readTenantByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamTenantObj> readTenantByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readTenantByClusterIdx";
		CFBamTenantByClusterIdxKey key = schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamTenantPKey, ICFBamTenantObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamTenantByClusterIdxKey,
				Map< CFBamTenantPKey, ICFBamTenantObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTenantPKey, ICFBamTenantObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamTenantObj obj;
			CFBamTenantBuff[] buffList = schema.getBackingStore().getTableTenant().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamTenantBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFBamTenantObj realized = (ICFBamTenantObj)obj.realize();
			}
		}
		Comparator<ICFBamTenantObj> cmp = new Comparator<ICFBamTenantObj>() {
			public int compare( ICFBamTenantObj lhs, ICFBamTenantObj rhs ) {
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
					CFBamTenantPKey lhsPKey = lhs.getPKey();
					CFBamTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTenantObj arr[] = new ICFBamTenantObj[len];
		Iterator<ICFBamTenantObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTenantObj> arrayList = new ArrayList<ICFBamTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		return( readTenantByUNameIdx( ClusterId,
			TenantName,
			false ) );
	}

	public ICFBamTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTenantByUNameIdxKey,
				ICFBamTenantObj >();
		}
		CFBamTenantByUNameIdxKey key = schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFBamTenantObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamTenantBuff buff = schema.getBackingStore().getTableTenant().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			if( buff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTenantObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTenantObj updateTenant( ICFBamTenantObj Obj ) {
		ICFBamTenantObj obj = Obj;
		schema.getBackingStore().getTableTenant().updateTenant( schema.getAuthorization(),
			Obj.getTenantBuff() );
		obj = (ICFBamTenantObj)Obj.realize();
		return( obj );
	}

	public void deleteTenant( ICFBamTenantObj Obj ) {
		ICFBamTenantObj obj = Obj;
		schema.getBackingStore().getTableTenant().deleteTenant( schema.getAuthorization(),
			obj.getTenantBuff() );
		obj.forget( true );
	}

	public void deleteTenantByIdIdx( long Id )
	{
		CFBamTenantPKey pkey = schema.getBackingStore().getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFBamTenantObj obj = readTenant( pkey );
		if( obj != null ) {
			ICFBamTenantEditObj editObj = (ICFBamTenantEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTenantEditObj)obj.beginEdit();
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

	public void deleteTenantByClusterIdx( long ClusterId )
	{
		CFBamTenantByClusterIdxKey key = schema.getBackingStore().getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamTenantByClusterIdxKey,
				Map< CFBamTenantPKey, ICFBamTenantObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamTenantPKey, ICFBamTenantObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamTenantObj> iter = dict.values().iterator();
			ICFBamTenantObj obj;
			List<ICFBamTenantObj> toForget = new LinkedList<ICFBamTenantObj>();
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
			schema.getBackingStore().getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTenantByUNameIdxKey,
				ICFBamTenantObj >();
		}
		CFBamTenantByUNameIdxKey key = schema.getBackingStore().getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFBamTenantObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
		}
	}

	public ICFBamTenantObj getSystemTenant() {
		boolean transactionStarted = schema.beginTransaction();
		ICFBamTenantObj tenantObj;
		try {
			schema.getAuditActionTableObj().bootstrapAuditActions();
			ICFBamClusterObj clusterObj = schema.getClusterTableObj().getSystemCluster();
			tenantObj = readTenantByUNameIdx( clusterObj.getRequiredId(), "system" );
			if( tenantObj == null ) {
				tenantObj = newInstance();
				ICFBamTenantEditObj tenantEdit = tenantObj.beginEdit();
				tenantEdit.setRequiredContainerCluster( clusterObj );
				tenantEdit.setRequiredTenantName( "system" );
				tenantObj = tenantEdit.create();
				tenantEdit.endEdit();
			}
			if( transactionStarted ) {
				schema.commit();
			}
		}
		catch( RuntimeException e ) {
			if( transactionStarted ) {
				try {
					schema.rollback();
				}
				catch( Exception e2 ) {
				}
			}
			throw e;
		}
		return( tenantObj );
	}
}
