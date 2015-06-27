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

public class CFBamTldTableObj
	implements ICFBamTldTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamTldPKey, ICFBamTldObj> members;
	private Map<CFBamTldPKey, ICFBamTldObj> allTld;
	private Map< CFBamTldByTenantIdxKey,
		Map<CFBamTldPKey, ICFBamTldObj > > indexByTenantIdx;
	private Map< CFBamTldByNameIdxKey,
		ICFBamTldObj > indexByNameIdx;
	public static String TABLE_NAME = "Tld";
	public static String TABLE_DBNAME = "tlddef";

	public CFBamTldTableObj() {
		schema = null;
		members = new HashMap<CFBamTldPKey, ICFBamTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
	}

	public CFBamTldTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamTldPKey, ICFBamTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
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
		return( ICFBamTenantObj.class );
	}


	public void minimizeMemory() {
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		List<ICFBamTldObj> toForget = new LinkedList<ICFBamTldObj>();
		ICFBamTldObj cur = null;
		Iterator<ICFBamTldObj> iter = members.values().iterator();
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
	 *	CFBamTldObj.
	 */
	public ICFBamTldObj newInstance() {
		ICFBamTldObj inst = new CFBamTldObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTldObj.
	 */
	public ICFBamTldEditObj newEditInstance( ICFBamTldObj orig ) {
		ICFBamTldEditObj edit = new CFBamTldEditObj( orig );
		return( edit );
	}

	public ICFBamTldObj realizeTld( ICFBamTldObj Obj ) {
		ICFBamTldObj obj = Obj;
		CFBamTldPKey pkey = obj.getPKey();
		ICFBamTldObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTldObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamTldByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTldPKey, ICFBamTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTldByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamTldByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTldPKey, ICFBamTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTldByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamTldByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTldPKey, ICFBamTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTldByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTld( ICFBamTldObj Obj ) {
		forgetTld( Obj, false );
	}

	public void forgetTld( ICFBamTldObj Obj, boolean forgetSubObjects ) {
		ICFBamTldObj obj = Obj;
		CFBamTldPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTldObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamTldByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTldPKey, ICFBamTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTldByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTld != null ) {
				allTld.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTopDomainTableObj().forgetTopDomainByTldIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTldId() );
			}
		}
	}

	public void forgetTldByIdIdx( long TenantId,
		long TldId )
	{
		if( members == null ) {
			return;
		}
		CFBamTldPKey key = schema.getBackingStore().getFactoryTld().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		if( members.containsKey( key ) ) {
			ICFBamTldObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTldByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamTldByTenantIdxKey key = schema.getBackingStore().getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTldPKey, ICFBamTldObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTldObj> toForget = new LinkedList<ICFBamTldObj>();
				ICFBamTldObj cur = null;
				Iterator<ICFBamTldObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTldByNameIdx( long TenantId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamTldByNameIdxKey key = schema.getBackingStore().getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamTldObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamTldObj createTld( ICFBamTldObj Obj ) {
		ICFBamTldObj obj = Obj;
		CFBamTldBuff buff = obj.getTldBuff();
		schema.getBackingStore().getTableTld().createTld(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamTldObj readTld( CFBamTldPKey pkey ) {
		return( readTld( pkey, false ) );
	}

	public ICFBamTldObj readTld( CFBamTldPKey pkey, boolean forceRead ) {
		ICFBamTldObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTldBuff readBuff = schema.getBackingStore().getTableTld().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTldId() );
			if( readBuff != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTld().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTldObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTldObj lockTld( CFBamTldPKey pkey ) {
		ICFBamTldObj locked = null;
		CFBamTldBuff lockBuff = schema.getBackingStore().getTableTld().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTldTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryTld().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTldObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTld", pkey );
		}
		return( locked );
	}

	public List<ICFBamTldObj> readAllTld() {
		return( readAllTld( false ) );
	}

	public List<ICFBamTldObj> readAllTld( boolean forceRead ) {
		final String S_ProcName = "readAllTld";
		if( ( allTld == null ) || forceRead ) {
			Map<CFBamTldPKey, ICFBamTldObj> map = new HashMap<CFBamTldPKey,ICFBamTldObj>();
			allTld = map;
			CFBamTldBuff[] buffList = schema.getBackingStore().getTableTld().readAllDerived( schema.getAuthorization() );
			CFBamTldBuff buff;
			ICFBamTldObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTld().newPKey() );
				obj.setBuff( buff );
				ICFBamTldObj realized = (ICFBamTldObj)obj.realize();
			}
		}
		Comparator<ICFBamTldObj> cmp = new Comparator<ICFBamTldObj>() {
			public int compare( ICFBamTldObj lhs, ICFBamTldObj rhs ) {
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
					CFBamTldPKey lhsPKey = lhs.getPKey();
					CFBamTldPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTld.size();
		ICFBamTldObj arr[] = new ICFBamTldObj[len];
		Iterator<ICFBamTldObj> valIter = allTld.values().iterator();
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
		ArrayList<ICFBamTldObj> arrayList = new ArrayList<ICFBamTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTldObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTldObj readTldByIdIdx( long TenantId,
		long TldId )
	{
		return( readTldByIdIdx( TenantId,
			TldId,
			false ) );
	}

	public ICFBamTldObj readTldByIdIdx( long TenantId,
		long TldId, boolean forceRead )
	{
		CFBamTldPKey pkey = schema.getBackingStore().getFactoryTld().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTldId( TldId );
		ICFBamTldObj obj = readTld( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTldObj> readTldByTenantIdx( long TenantId )
	{
		return( readTldByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTldObj> readTldByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTldByTenantIdx";
		CFBamTldByTenantIdxKey key = schema.getBackingStore().getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamTldPKey, ICFBamTldObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTldByTenantIdxKey,
				Map< CFBamTldPKey, ICFBamTldObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTldPKey, ICFBamTldObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamTldObj obj;
			CFBamTldBuff[] buffList = schema.getBackingStore().getTableTld().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamTldBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTld().newPKey() );
				obj.setBuff( buff );
				ICFBamTldObj realized = (ICFBamTldObj)obj.realize();
			}
		}
		Comparator<ICFBamTldObj> cmp = new Comparator<ICFBamTldObj>() {
			public int compare( ICFBamTldObj lhs, ICFBamTldObj rhs ) {
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
					CFBamTldPKey lhsPKey = lhs.getPKey();
					CFBamTldPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTldObj arr[] = new ICFBamTldObj[len];
		Iterator<ICFBamTldObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTldObj> arrayList = new ArrayList<ICFBamTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTldObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTldObj readTldByNameIdx( long TenantId,
		String Name )
	{
		return( readTldByNameIdx( TenantId,
			Name,
			false ) );
	}

	public ICFBamTldObj readTldByNameIdx( long TenantId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTldByNameIdxKey,
				ICFBamTldObj >();
		}
		CFBamTldByNameIdxKey key = schema.getBackingStore().getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFBamTldObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamTldBuff buff = schema.getBackingStore().getTableTld().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			if( buff != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTld().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTldObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTldObj updateTld( ICFBamTldObj Obj ) {
		ICFBamTldObj obj = Obj;
		schema.getBackingStore().getTableTld().updateTld( schema.getAuthorization(),
			Obj.getTldBuff() );
		obj = (ICFBamTldObj)Obj.realize();
		return( obj );
	}

	public void deleteTld( ICFBamTldObj Obj ) {
		ICFBamTldObj obj = Obj;
		schema.getBackingStore().getTableTld().deleteTld( schema.getAuthorization(),
			obj.getTldBuff() );
		obj.forget( true );
	}

	public void deleteTldByIdIdx( long TenantId,
		long TldId )
	{
		CFBamTldPKey pkey = schema.getBackingStore().getFactoryTld().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTldId( TldId );
		ICFBamTldObj obj = readTld( pkey );
		if( obj != null ) {
			ICFBamTldEditObj editObj = (ICFBamTldEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTldEditObj)obj.beginEdit();
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

	public void deleteTldByTenantIdx( long TenantId )
	{
		CFBamTldByTenantIdxKey key = schema.getBackingStore().getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTldByTenantIdxKey,
				Map< CFBamTldPKey, ICFBamTldObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTldPKey, ICFBamTldObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTld().deleteTldByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTldObj> iter = dict.values().iterator();
			ICFBamTldObj obj;
			List<ICFBamTldObj> toForget = new LinkedList<ICFBamTldObj>();
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
			schema.getBackingStore().getTableTld().deleteTldByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTldByNameIdx( long TenantId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTldByNameIdxKey,
				ICFBamTldObj >();
		}
		CFBamTldByNameIdxKey key = schema.getBackingStore().getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFBamTldObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableTld().deleteTldByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTld().deleteTldByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
		}
	}
}
