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

public class CFBamVersionTableObj
	implements ICFBamVersionTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamVersionObj> members;
	private Map<CFBamDomainBasePKey, ICFBamVersionObj> allVersion;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamVersionObj > > indexByTenantIdx;
	public static String TABLE_NAME = "Version";
	public static String TABLE_DBNAME = "verndef";

	public CFBamVersionTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamVersionObj>();
		allVersion = null;
		indexByTenantIdx = null;
	}

	public CFBamVersionTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamVersionObj>();
		allVersion = null;
		indexByTenantIdx = null;
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
		allVersion = null;
		indexByTenantIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamVersionObj.
	 */
	public ICFBamVersionObj newInstance() {
		ICFBamVersionObj inst = new CFBamVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamVersionObj.
	 */
	public ICFBamVersionEditObj newEditInstance( ICFBamVersionObj orig ) {
		ICFBamVersionEditObj edit = new CFBamVersionEditObj( orig );
		return( edit );
	}

	public ICFBamVersionObj realizeVersion( ICFBamVersionObj Obj ) {
		ICFBamVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamVersionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamVersionObj)schema.getProjectBaseTableObj().realizeProjectBase( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allVersion != null ) {
				allVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamVersionObj)schema.getProjectBaseTableObj().realizeProjectBase( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allVersion != null ) {
				allVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetVersion( ICFBamVersionObj Obj ) {
		forgetVersion( Obj, false );
	}

	public void forgetVersion( ICFBamVersionObj Obj, boolean forgetSubObjects ) {
		ICFBamVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamVersionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( allVersion != null ) {
				allVersion.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getProjectBaseTableObj().forgetProjectBase( obj );
	}

	public void forgetVersionByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamVersionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetVersionByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamVersionObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamVersionObj> toForget = new LinkedList<ICFBamVersionObj>();
				ICFBamVersionObj cur = null;
				Iterator<ICFBamVersionObj> iter = mapTenantIdx.values().iterator();
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

	public ICFBamVersionObj createVersion( ICFBamVersionObj Obj ) {
		ICFBamVersionObj obj = Obj;
		CFBamVersionBuff buff = obj.getVersionBuff();
		schema.getBackingStore().getTableVersion().createVersion(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "VERN" ) ) {
			obj = (ICFBamVersionObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamVersionObj readVersion( CFBamDomainBasePKey pkey ) {
		return( readVersion( pkey, false ) );
	}

	public ICFBamVersionObj readVersion( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamVersionBuff readBuff = schema.getBackingStore().getTableVersion().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamVersionObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamVersionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamVersionObj lockVersion( CFBamDomainBasePKey pkey ) {
		ICFBamVersionObj locked = null;
		CFBamVersionBuff lockBuff = schema.getBackingStore().getTableVersion().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamVersionObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamVersionObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockVersion", pkey );
		}
		return( locked );
	}

	public List<ICFBamVersionObj> readAllVersion() {
		return( readAllVersion( false ) );
	}

	public List<ICFBamVersionObj> readAllVersion( boolean forceRead ) {
		final String S_ProcName = "readAllVersion";
		if( ( allVersion == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamVersionObj> map = new HashMap<CFBamDomainBasePKey,ICFBamVersionObj>();
			allVersion = map;
			CFBamVersionBuff[] buffList = schema.getBackingStore().getTableVersion().readAllDerived( schema.getAuthorization() );
			CFBamVersionBuff buff;
			ICFBamVersionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamVersionObj realized = (ICFBamVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamVersionObj> cmp = new Comparator<ICFBamVersionObj>() {
			public int compare( ICFBamVersionObj lhs, ICFBamVersionObj rhs ) {
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
					CFBamDomainBasePKey lhsPKey = lhs.getPKey();
					CFBamDomainBasePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allVersion.size();
		ICFBamVersionObj arr[] = new ICFBamVersionObj[len];
		Iterator<ICFBamVersionObj> valIter = allVersion.values().iterator();
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
		ArrayList<ICFBamVersionObj> arrayList = new ArrayList<ICFBamVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamVersionObj readVersionByIdIdx( long TenantId,
		long Id )
	{
		return( readVersionByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamVersionObj readVersionByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamVersionObj obj = readVersion( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamVersionObj> readVersionByTenantIdx( long TenantId )
	{
		return( readVersionByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamVersionObj> readVersionByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readVersionByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamVersionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamVersionObj realized = (ICFBamVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamVersionObj> cmp = new Comparator<ICFBamVersionObj>() {
			public int compare( ICFBamVersionObj lhs, ICFBamVersionObj rhs ) {
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
					CFBamDomainBasePKey lhsPKey = lhs.getPKey();
					CFBamDomainBasePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamVersionObj arr[] = new ICFBamVersionObj[len];
		Iterator<ICFBamVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamVersionObj> arrayList = new ArrayList<ICFBamVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamVersionObj updateVersion( ICFBamVersionObj Obj ) {
		ICFBamVersionObj obj = Obj;
		schema.getBackingStore().getTableVersion().updateVersion( schema.getAuthorization(),
			Obj.getVersionBuff() );
		if( Obj.getClassCode().equals( "VERN" ) ) {
			obj = (ICFBamVersionObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteVersion( ICFBamVersionObj Obj ) {
		ICFBamVersionObj obj = Obj;
		schema.getBackingStore().getTableVersion().deleteVersion( schema.getAuthorization(),
			obj.getVersionBuff() );
		obj.forget( true );
	}

	public void deleteVersionByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readVersion( pkey );
		if( obj != null ) {
			ICFBamVersionEditObj editObj = (ICFBamVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamVersionEditObj)obj.beginEdit();
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

	public void deleteVersionByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamVersionObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableVersion().deleteVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamVersionObj> iter = dict.values().iterator();
			ICFBamVersionObj obj;
			List<ICFBamVersionObj> toForget = new LinkedList<ICFBamVersionObj>();
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
			schema.getBackingStore().getTableVersion().deleteVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}
}
