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

public class CFBamClearDepTableObj
	implements ICFBamClearDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearDepObj> members;
	private Map<CFBamScopePKey, ICFBamClearDepObj> allClearDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearDepObj > > indexByTenantIdx;
	private Map< CFBamClearDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamClearDepObj > > indexByTableIdx;
	public static String TABLE_NAME = "ClearDep";
	public static String TABLE_DBNAME = "clr_dep";

	public CFBamClearDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
	}

	public CFBamClearDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
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
		allClearDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearDepObj.
	 */
	public ICFBamClearDepObj newInstance() {
		ICFBamClearDepObj inst = new CFBamClearDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearDepObj.
	 */
	public ICFBamClearDepEditObj newEditInstance( ICFBamClearDepObj orig ) {
		ICFBamClearDepEditObj edit = new CFBamClearDepEditObj( orig );
		return( edit );
	}

	public ICFBamClearDepObj realizeClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearDepObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearDepObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearDepObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetClearDep( ICFBamClearDepObj Obj ) {
		forgetClearDep( Obj, false );
	}

	public void forgetClearDep( ICFBamClearDepObj Obj, boolean forgetSubObjects ) {
		ICFBamClearDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( allClearDep != null ) {
				allClearDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetClearDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
				ICFBamClearDepObj cur = null;
				Iterator<ICFBamClearDepObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetClearDepByTableIdx( long TenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
				ICFBamClearDepObj cur = null;
				Iterator<ICFBamClearDepObj> iter = mapTableIdx.values().iterator();
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

			indexByTableIdx.remove( key );
		}
	}

	public ICFBamClearDepObj createClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		CFBamClearDepBuff buff = obj.getClearDepBuff();
		schema.getBackingStore().getTableClearDep().createClearDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLRD" ) ) {
			obj = (ICFBamClearDepObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamClearDepObj readClearDep( CFBamScopePKey pkey ) {
		return( readClearDep( pkey, false ) );
	}

	public ICFBamClearDepObj readClearDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearDepBuff readBuff = schema.getBackingStore().getTableClearDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClearDepObj lockClearDep( CFBamScopePKey pkey ) {
		ICFBamClearDepObj locked = null;
		CFBamClearDepBuff lockBuff = schema.getBackingStore().getTableClearDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearDepObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockClearDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearDepObj> readAllClearDep() {
		return( readAllClearDep( false ) );
	}

	public List<ICFBamClearDepObj> readAllClearDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearDep";
		if( ( allClearDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> map = new HashMap<CFBamScopePKey,ICFBamClearDepObj>();
			allClearDep = map;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readAllDerived( schema.getAuthorization() );
			CFBamClearDepBuff buff;
			ICFBamClearDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realized = (ICFBamClearDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allClearDep.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = allClearDep.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id )
	{
		return( readClearDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearDepObj obj = readClearDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId )
	{
		return( readClearDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realized = (ICFBamClearDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearDepObj> readClearDepByTableIdx( long TenantId,
		long RelationId )
	{
		return( readClearDepByTableIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearDepObj> readClearDepByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByTableIdx";
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearDepObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realized = (ICFBamClearDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearDepObj updateClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		schema.getBackingStore().getTableClearDep().updateClearDep( schema.getAuthorization(),
			Obj.getClearDepBuff() );
		if( Obj.getClassCode().equals( "CLRD" ) ) {
			obj = (ICFBamClearDepObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		schema.getBackingStore().getTableClearDep().deleteClearDep( schema.getAuthorization(),
			obj.getClearDepBuff() );
		obj.forget( true );
	}

	public void deleteClearDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readClearDep( pkey );
		if( obj != null ) {
			ICFBamClearDepEditObj editObj = (ICFBamClearDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearDepEditObj)obj.beginEdit();
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

	public void deleteClearDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableClearDep().deleteClearDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearDepObj> iter = dict.values().iterator();
			ICFBamClearDepObj obj;
			List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
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
			schema.getBackingStore().getTableClearDep().deleteClearDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearDepByTableIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableClearDep().deleteClearDepByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearDepObj> iter = dict.values().iterator();
			ICFBamClearDepObj obj;
			List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTableIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearDep().deleteClearDepByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}
}
