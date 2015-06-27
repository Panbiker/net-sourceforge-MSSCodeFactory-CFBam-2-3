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

public class CFBamTSecGroupTableObj
	implements ICFBamTSecGroupTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj> members;
	private Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj> allTSecGroup;
	private Map< CFBamTSecGroupByTenantIdxKey,
		Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > > indexByTenantIdx;
	private Map< CFBamTSecGroupByUNameIdxKey,
		ICFBamTSecGroupObj > indexByUNameIdx;
	public static String TABLE_NAME = "TSecGroup";
	public static String TABLE_DBNAME = "tsecgrp";

	public CFBamTSecGroupTableObj() {
		schema = null;
		members = new HashMap<CFBamTSecGroupPKey, ICFBamTSecGroupObj>();
		allTSecGroup = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamTSecGroupTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamTSecGroupPKey, ICFBamTSecGroupObj>();
		allTSecGroup = null;
		indexByTenantIdx = null;
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
		allTSecGroup = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		List<ICFBamTSecGroupObj> toForget = new LinkedList<ICFBamTSecGroupObj>();
		ICFBamTSecGroupObj cur = null;
		Iterator<ICFBamTSecGroupObj> iter = members.values().iterator();
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
	 *	CFBamTSecGroupObj.
	 */
	public ICFBamTSecGroupObj newInstance() {
		ICFBamTSecGroupObj inst = new CFBamTSecGroupObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTSecGroupObj.
	 */
	public ICFBamTSecGroupEditObj newEditInstance( ICFBamTSecGroupObj orig ) {
		ICFBamTSecGroupEditObj edit = new CFBamTSecGroupEditObj( orig );
		return( edit );
	}

	public ICFBamTSecGroupObj realizeTSecGroup( ICFBamTSecGroupObj Obj ) {
		ICFBamTSecGroupObj obj = Obj;
		CFBamTSecGroupPKey pkey = obj.getPKey();
		ICFBamTSecGroupObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTSecGroupObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allTSecGroup != null ) {
				allTSecGroup.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGroup != null ) {
				allTSecGroup.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTSecGroup( ICFBamTSecGroupObj Obj ) {
		forgetTSecGroup( Obj, false );
	}

	public void forgetTSecGroup( ICFBamTSecGroupObj Obj, boolean forgetSubObjects ) {
		ICFBamTSecGroupObj obj = Obj;
		CFBamTSecGroupPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTSecGroupObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTSecGroupByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allTSecGroup != null ) {
				allTSecGroup.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTSecGroupIncludeTableObj().forgetTSecGroupIncludeByGroupIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
				schema.getTSecGroupMemberTableObj().forgetTSecGroupMemberByGroupIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
				schema.getTSecGroupIncludeTableObj().forgetTSecGroupIncludeByIncludeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
			}
		}
	}

	public void forgetTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		if( members == null ) {
			return;
		}
		CFBamTSecGroupPKey key = schema.getBackingStore().getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( members.containsKey( key ) ) {
			ICFBamTSecGroupObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGroupByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamTSecGroupByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTSecGroupObj> toForget = new LinkedList<ICFBamTSecGroupObj>();
				ICFBamTSecGroupObj cur = null;
				Iterator<ICFBamTSecGroupObj> iter = mapTenantIdx.values().iterator();
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

			indexByTenantIdx.remove( key );
		}
	}

	public void forgetTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamTSecGroupByUNameIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamTSecGroupObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamTSecGroupObj createTSecGroup( ICFBamTSecGroupObj Obj ) {
		ICFBamTSecGroupObj obj = Obj;
		CFBamTSecGroupBuff buff = obj.getTSecGroupBuff();
		schema.getBackingStore().getTableTSecGroup().createTSecGroup(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamTSecGroupObj readTSecGroup( CFBamTSecGroupPKey pkey ) {
		return( readTSecGroup( pkey, false ) );
	}

	public ICFBamTSecGroupObj readTSecGroup( CFBamTSecGroupPKey pkey, boolean forceRead ) {
		ICFBamTSecGroupObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTSecGroupBuff readBuff = schema.getBackingStore().getTableTSecGroup().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGroupId() );
			if( readBuff != null ) {
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroup().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTSecGroupObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupObj lockTSecGroup( CFBamTSecGroupPKey pkey ) {
		ICFBamTSecGroupObj locked = null;
		CFBamTSecGroupBuff lockBuff = schema.getBackingStore().getTableTSecGroup().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGroupTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryTSecGroup().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTSecGroupObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTSecGroup", pkey );
		}
		return( locked );
	}

	public List<ICFBamTSecGroupObj> readAllTSecGroup() {
		return( readAllTSecGroup( false ) );
	}

	public List<ICFBamTSecGroupObj> readAllTSecGroup( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGroup";
		if( ( allTSecGroup == null ) || forceRead ) {
			Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj> map = new HashMap<CFBamTSecGroupPKey,ICFBamTSecGroupObj>();
			allTSecGroup = map;
			CFBamTSecGroupBuff[] buffList = schema.getBackingStore().getTableTSecGroup().readAllDerived( schema.getAuthorization() );
			CFBamTSecGroupBuff buff;
			ICFBamTSecGroupObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupObj realized = (ICFBamTSecGroupObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupObj> cmp = new Comparator<ICFBamTSecGroupObj>() {
			public int compare( ICFBamTSecGroupObj lhs, ICFBamTSecGroupObj rhs ) {
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
					CFBamTSecGroupPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTSecGroup.size();
		ICFBamTSecGroupObj arr[] = new ICFBamTSecGroupObj[len];
		Iterator<ICFBamTSecGroupObj> valIter = allTSecGroup.values().iterator();
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
		ArrayList<ICFBamTSecGroupObj> arrayList = new ArrayList<ICFBamTSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupObj readTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGroupByIdIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public ICFBamTSecGroupObj readTSecGroupByIdIdx( long TenantId,
		int TSecGroupId, boolean forceRead )
	{
		CFBamTSecGroupPKey pkey = schema.getBackingStore().getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupId( TSecGroupId );
		ICFBamTSecGroupObj obj = readTSecGroup( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTSecGroupObj> readTSecGroupByTenantIdx( long TenantId )
	{
		return( readTSecGroupByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTSecGroupObj> readTSecGroupByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupByTenantIdx";
		CFBamTSecGroupByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupByTenantIdxKey,
				Map< CFBamTSecGroupPKey, ICFBamTSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupPKey, ICFBamTSecGroupObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamTSecGroupObj obj;
			CFBamTSecGroupBuff[] buffList = schema.getBackingStore().getTableTSecGroup().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamTSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupObj realized = (ICFBamTSecGroupObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupObj> cmp = new Comparator<ICFBamTSecGroupObj>() {
			public int compare( ICFBamTSecGroupObj lhs, ICFBamTSecGroupObj rhs ) {
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
					CFBamTSecGroupPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupObj arr[] = new ICFBamTSecGroupObj[len];
		Iterator<ICFBamTSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupObj> arrayList = new ArrayList<ICFBamTSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupObj readTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		return( readTSecGroupByUNameIdx( TenantId,
			Name,
			false ) );
	}

	public ICFBamTSecGroupObj readTSecGroupByUNameIdx( long TenantId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTSecGroupByUNameIdxKey,
				ICFBamTSecGroupObj >();
		}
		CFBamTSecGroupByUNameIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFBamTSecGroupObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamTSecGroupBuff buff = schema.getBackingStore().getTableTSecGroup().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			if( buff != null ) {
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTSecGroupObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupObj updateTSecGroup( ICFBamTSecGroupObj Obj ) {
		ICFBamTSecGroupObj obj = Obj;
		schema.getBackingStore().getTableTSecGroup().updateTSecGroup( schema.getAuthorization(),
			Obj.getTSecGroupBuff() );
		obj = (ICFBamTSecGroupObj)Obj.realize();
		return( obj );
	}

	public void deleteTSecGroup( ICFBamTSecGroupObj Obj ) {
		ICFBamTSecGroupObj obj = Obj;
		schema.getBackingStore().getTableTSecGroup().deleteTSecGroup( schema.getAuthorization(),
			obj.getTSecGroupBuff() );
		obj.forget( true );
	}

	public void deleteTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		CFBamTSecGroupPKey pkey = schema.getBackingStore().getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupId( TSecGroupId );
		ICFBamTSecGroupObj obj = readTSecGroup( pkey );
		if( obj != null ) {
			ICFBamTSecGroupEditObj editObj = (ICFBamTSecGroupEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTSecGroupEditObj)obj.beginEdit();
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

	public void deleteTSecGroupByTenantIdx( long TenantId )
	{
		CFBamTSecGroupByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupByTenantIdxKey,
				Map< CFBamTSecGroupPKey, ICFBamTSecGroupObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupPKey, ICFBamTSecGroupObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTSecGroup().deleteTSecGroupByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTSecGroupObj> iter = dict.values().iterator();
			ICFBamTSecGroupObj obj;
			List<ICFBamTSecGroupObj> toForget = new LinkedList<ICFBamTSecGroupObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTSecGroup().deleteTSecGroupByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTSecGroupByUNameIdxKey,
				ICFBamTSecGroupObj >();
		}
		CFBamTSecGroupByUNameIdxKey key = schema.getBackingStore().getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFBamTSecGroupObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTSecGroup().deleteTSecGroupByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTSecGroup().deleteTSecGroupByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
		}
	}
}
