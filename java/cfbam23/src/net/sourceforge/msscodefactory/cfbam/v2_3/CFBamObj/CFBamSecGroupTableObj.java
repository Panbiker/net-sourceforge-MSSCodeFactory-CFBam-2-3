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

public class CFBamSecGroupTableObj
	implements ICFBamSecGroupTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecGroupPKey, ICFBamSecGroupObj> members;
	private Map<CFBamSecGroupPKey, ICFBamSecGroupObj> allSecGroup;
	private Map< CFBamSecGroupByClusterIdxKey,
		Map<CFBamSecGroupPKey, ICFBamSecGroupObj > > indexByClusterIdx;
	private Map< CFBamSecGroupByUNameIdxKey,
		ICFBamSecGroupObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecGroup";
	public static String TABLE_DBNAME = "secgrp";

	public CFBamSecGroupTableObj() {
		schema = null;
		members = new HashMap<CFBamSecGroupPKey, ICFBamSecGroupObj>();
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamSecGroupTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecGroupPKey, ICFBamSecGroupObj>();
		allSecGroup = null;
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
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
		List<ICFBamSecGroupObj> toForget = new LinkedList<ICFBamSecGroupObj>();
		ICFBamSecGroupObj cur = null;
		Iterator<ICFBamSecGroupObj> iter = members.values().iterator();
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
	 *	CFBamSecGroupObj.
	 */
	public ICFBamSecGroupObj newInstance() {
		ICFBamSecGroupObj inst = new CFBamSecGroupObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecGroupObj.
	 */
	public ICFBamSecGroupEditObj newEditInstance( ICFBamSecGroupObj orig ) {
		ICFBamSecGroupEditObj edit = new CFBamSecGroupEditObj( orig );
		return( edit );
	}

	public ICFBamSecGroupObj realizeSecGroup( ICFBamSecGroupObj Obj ) {
		ICFBamSecGroupObj obj = Obj;
		CFBamSecGroupPKey pkey = obj.getPKey();
		ICFBamSecGroupObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecGroupObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecGroupByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupPKey, ICFBamSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecGroupByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupPKey, ICFBamSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allSecGroup != null ) {
				allSecGroup.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroup != null ) {
				allSecGroup.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecGroupByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupPKey, ICFBamSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecGroup( ICFBamSecGroupObj Obj ) {
		forgetSecGroup( Obj, false );
	}

	public void forgetSecGroup( ICFBamSecGroupObj Obj, boolean forgetSubObjects ) {
		ICFBamSecGroupObj obj = Obj;
		CFBamSecGroupPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecGroupObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecGroupByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupPKey, ICFBamSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allSecGroup != null ) {
				allSecGroup.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getSecGroupIncludeTableObj().forgetSecGroupIncludeByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				schema.getSecGroupMemberTableObj().forgetSecGroupMemberByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				schema.getSecGroupIncludeTableObj().forgetSecGroupIncludeByIncludeIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				schema.getSecGroupFormTableObj().forgetSecGroupFormByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
			}
		}
	}

	public void forgetSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecGroupPKey key = schema.getBackingStore().getFactorySecGroup().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( members.containsKey( key ) ) {
			ICFBamSecGroupObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecGroupByClusterIdxKey key = schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupPKey, ICFBamSecGroupObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecGroupObj> toForget = new LinkedList<ICFBamSecGroupObj>();
				ICFBamSecGroupObj cur = null;
				Iterator<ICFBamSecGroupObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamSecGroupByUNameIdxKey key = schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamSecGroupObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamSecGroupObj createSecGroup( ICFBamSecGroupObj Obj ) {
		ICFBamSecGroupObj obj = Obj;
		CFBamSecGroupBuff buff = obj.getSecGroupBuff();
		schema.getBackingStore().getTableSecGroup().createSecGroup(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecGroupObj readSecGroup( CFBamSecGroupPKey pkey ) {
		return( readSecGroup( pkey, false ) );
	}

	public ICFBamSecGroupObj readSecGroup( CFBamSecGroupPKey pkey, boolean forceRead ) {
		ICFBamSecGroupObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecGroupBuff readBuff = schema.getBackingStore().getTableSecGroup().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroup().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecGroupObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupObj lockSecGroup( CFBamSecGroupPKey pkey ) {
		ICFBamSecGroupObj locked = null;
		CFBamSecGroupBuff lockBuff = schema.getBackingStore().getTableSecGroup().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecGroup().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecGroupObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecGroup", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecGroupObj> readAllSecGroup() {
		return( readAllSecGroup( false ) );
	}

	public List<ICFBamSecGroupObj> readAllSecGroup( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroup";
		if( ( allSecGroup == null ) || forceRead ) {
			Map<CFBamSecGroupPKey, ICFBamSecGroupObj> map = new HashMap<CFBamSecGroupPKey,ICFBamSecGroupObj>();
			allSecGroup = map;
			CFBamSecGroupBuff[] buffList = schema.getBackingStore().getTableSecGroup().readAllDerived( schema.getAuthorization() );
			CFBamSecGroupBuff buff;
			ICFBamSecGroupObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupObj realized = (ICFBamSecGroupObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupObj> cmp = new Comparator<ICFBamSecGroupObj>() {
			public int compare( ICFBamSecGroupObj lhs, ICFBamSecGroupObj rhs ) {
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
					CFBamSecGroupPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecGroup.size();
		ICFBamSecGroupObj arr[] = new ICFBamSecGroupObj[len];
		Iterator<ICFBamSecGroupObj> valIter = allSecGroup.values().iterator();
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
		ArrayList<ICFBamSecGroupObj> arrayList = new ArrayList<ICFBamSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupByIdIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public ICFBamSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId, boolean forceRead )
	{
		CFBamSecGroupPKey pkey = schema.getBackingStore().getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFBamSecGroupObj obj = readSecGroup( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecGroupObj> readSecGroupByClusterIdx( long ClusterId )
	{
		return( readSecGroupByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecGroupObj> readSecGroupByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupByClusterIdx";
		CFBamSecGroupByClusterIdxKey key = schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecGroupPKey, ICFBamSecGroupObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupByClusterIdxKey,
				Map< CFBamSecGroupPKey, ICFBamSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupPKey, ICFBamSecGroupObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecGroupObj obj;
			CFBamSecGroupBuff[] buffList = schema.getBackingStore().getTableSecGroup().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupObj realized = (ICFBamSecGroupObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupObj> cmp = new Comparator<ICFBamSecGroupObj>() {
			public int compare( ICFBamSecGroupObj lhs, ICFBamSecGroupObj rhs ) {
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
					CFBamSecGroupPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupObj arr[] = new ICFBamSecGroupObj[len];
		Iterator<ICFBamSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupObj> arrayList = new ArrayList<ICFBamSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		return( readSecGroupByUNameIdx( ClusterId,
			Name,
			false ) );
	}

	public ICFBamSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSecGroupByUNameIdxKey,
				ICFBamSecGroupObj >();
		}
		CFBamSecGroupByUNameIdxKey key = schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFBamSecGroupObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSecGroupBuff buff = schema.getBackingStore().getTableSecGroup().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			if( buff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecGroupObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupObj updateSecGroup( ICFBamSecGroupObj Obj ) {
		ICFBamSecGroupObj obj = Obj;
		schema.getBackingStore().getTableSecGroup().updateSecGroup( schema.getAuthorization(),
			Obj.getSecGroupBuff() );
		obj = (ICFBamSecGroupObj)Obj.realize();
		return( obj );
	}

	public void deleteSecGroup( ICFBamSecGroupObj Obj ) {
		ICFBamSecGroupObj obj = Obj;
		schema.getBackingStore().getTableSecGroup().deleteSecGroup( schema.getAuthorization(),
			obj.getSecGroupBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		CFBamSecGroupPKey pkey = schema.getBackingStore().getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFBamSecGroupObj obj = readSecGroup( pkey );
		if( obj != null ) {
			ICFBamSecGroupEditObj editObj = (ICFBamSecGroupEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecGroupEditObj)obj.beginEdit();
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

	public void deleteSecGroupByClusterIdx( long ClusterId )
	{
		CFBamSecGroupByClusterIdxKey key = schema.getBackingStore().getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupByClusterIdxKey,
				Map< CFBamSecGroupPKey, ICFBamSecGroupObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupPKey, ICFBamSecGroupObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecGroupObj> iter = dict.values().iterator();
			ICFBamSecGroupObj obj;
			List<ICFBamSecGroupObj> toForget = new LinkedList<ICFBamSecGroupObj>();
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
			schema.getBackingStore().getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSecGroupByUNameIdxKey,
				ICFBamSecGroupObj >();
		}
		CFBamSecGroupByUNameIdxKey key = schema.getBackingStore().getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFBamSecGroupObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
		}
	}
}
