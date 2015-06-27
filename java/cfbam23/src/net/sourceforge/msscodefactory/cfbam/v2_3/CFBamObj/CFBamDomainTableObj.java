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

public class CFBamDomainTableObj
	implements ICFBamDomainTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamDomainObj> members;
	private Map<CFBamDomainBasePKey, ICFBamDomainObj> allDomain;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamDomainObj > > indexByTenantIdx;
	private Map< CFBamDomainBySubDomIdxKey,
		Map<CFBamDomainBasePKey, ICFBamDomainObj > > indexBySubDomIdx;
	private Map< CFBamDomainByNameIdxKey,
		ICFBamDomainObj > indexByNameIdx;
	public static String TABLE_NAME = "Domain";
	public static String TABLE_DBNAME = "domdef";

	public CFBamDomainTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamDomainObj>();
		allDomain = null;
		indexByTenantIdx = null;
		indexBySubDomIdx = null;
		indexByNameIdx = null;
	}

	public CFBamDomainTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamDomainObj>();
		allDomain = null;
		indexByTenantIdx = null;
		indexBySubDomIdx = null;
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
		allDomain = null;
		indexByTenantIdx = null;
		indexBySubDomIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDomainObj.
	 */
	public ICFBamDomainObj newInstance() {
		ICFBamDomainObj inst = new CFBamDomainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDomainObj.
	 */
	public ICFBamDomainEditObj newEditInstance( ICFBamDomainObj orig ) {
		ICFBamDomainEditObj edit = new CFBamDomainEditObj( orig );
		return( edit );
	}

	public ICFBamDomainObj realizeDomain( ICFBamDomainObj Obj ) {
		ICFBamDomainObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamDomainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDomainObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySubDomIdx != null ) {
				CFBamDomainBySubDomIdxKey keySubDomIdx =
					schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
				keySubDomIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubDomIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapSubDomIdx = indexBySubDomIdx.get( keySubDomIdx );
				if( mapSubDomIdx != null ) {
					mapSubDomIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDomainObj)schema.getDomainBaseTableObj().realizeDomainBase( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubDomIdx != null ) {
				CFBamDomainBySubDomIdxKey keySubDomIdx =
					schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
				keySubDomIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubDomIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapSubDomIdx = indexBySubDomIdx.get( keySubDomIdx );
				if( mapSubDomIdx != null ) {
					mapSubDomIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allDomain != null ) {
				allDomain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDomainObj)schema.getDomainBaseTableObj().realizeDomainBase( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDomain != null ) {
				allDomain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubDomIdx != null ) {
				CFBamDomainBySubDomIdxKey keySubDomIdx =
					schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
				keySubDomIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubDomIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapSubDomIdx = indexBySubDomIdx.get( keySubDomIdx );
				if( mapSubDomIdx != null ) {
					mapSubDomIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDomain( ICFBamDomainObj Obj ) {
		forgetDomain( Obj, false );
	}

	public void forgetDomain( ICFBamDomainObj Obj, boolean forgetSubObjects ) {
		ICFBamDomainObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDomainObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySubDomIdx != null ) {
				CFBamDomainBySubDomIdxKey keySubDomIdx =
					schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
				keySubDomIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubDomIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				Map<CFBamDomainBasePKey, ICFBamDomainObj > mapSubDomIdx = indexBySubDomIdx.get( keySubDomIdx );
				if( mapSubDomIdx != null ) {
					mapSubDomIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubDomainOfId( keepObj.getRequiredSubDomainOfId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allDomain != null ) {
				allDomain.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTopProjectTableObj().forgetTopProjectByDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getDomainBaseTableObj().forgetDomainBase( obj );
	}

	public void forgetDomainByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDomainObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDomainByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDomainObj> toForget = new LinkedList<ICFBamDomainObj>();
				ICFBamDomainObj cur = null;
				Iterator<ICFBamDomainObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDomainBySubDomIdx( long TenantId,
		long SubDomainOfId )
	{
		if( indexBySubDomIdx == null ) {
			return;
		}
		CFBamDomainBySubDomIdxKey key = schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		if( indexBySubDomIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainObj > mapSubDomIdx = indexBySubDomIdx.get( key );
			if( mapSubDomIdx != null ) {
				List<ICFBamDomainObj> toForget = new LinkedList<ICFBamDomainObj>();
				ICFBamDomainObj cur = null;
				Iterator<ICFBamDomainObj> iter = mapSubDomIdx.values().iterator();
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

			indexBySubDomIdx.remove( key );
		}
	}

	public void forgetDomainByNameIdx( long TenantId,
		long SubDomainOfId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamDomainByNameIdxKey key = schema.getBackingStore().getFactoryDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamDomainObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamDomainObj createDomain( ICFBamDomainObj Obj ) {
		ICFBamDomainObj obj = Obj;
		CFBamDomainBuff buff = obj.getDomainBuff();
		schema.getBackingStore().getTableDomain().createDomain(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DOMN" ) ) {
			obj = (ICFBamDomainObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDomainObj readDomain( CFBamDomainBasePKey pkey ) {
		return( readDomain( pkey, false ) );
	}

	public ICFBamDomainObj readDomain( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamDomainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDomainBuff readBuff = schema.getBackingStore().getTableDomain().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDomainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDomainObj lockDomain( CFBamDomainBasePKey pkey ) {
		ICFBamDomainObj locked = null;
		CFBamDomainBuff lockBuff = schema.getBackingStore().getTableDomain().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDomainObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDomain", pkey );
		}
		return( locked );
	}

	public List<ICFBamDomainObj> readAllDomain() {
		return( readAllDomain( false ) );
	}

	public List<ICFBamDomainObj> readAllDomain( boolean forceRead ) {
		final String S_ProcName = "readAllDomain";
		if( ( allDomain == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamDomainObj> map = new HashMap<CFBamDomainBasePKey,ICFBamDomainObj>();
			allDomain = map;
			CFBamDomainBuff[] buffList = schema.getBackingStore().getTableDomain().readAllDerived( schema.getAuthorization() );
			CFBamDomainBuff buff;
			ICFBamDomainObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamDomainObj realized = (ICFBamDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamDomainObj> cmp = new Comparator<ICFBamDomainObj>() {
			public int compare( ICFBamDomainObj lhs, ICFBamDomainObj rhs ) {
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
		int len = allDomain.size();
		ICFBamDomainObj arr[] = new ICFBamDomainObj[len];
		Iterator<ICFBamDomainObj> valIter = allDomain.values().iterator();
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
		ArrayList<ICFBamDomainObj> arrayList = new ArrayList<ICFBamDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDomainObj readDomainByIdIdx( long TenantId,
		long Id )
	{
		return( readDomainByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDomainObj readDomainByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainObj obj = readDomain( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDomainObj> readDomainByTenantIdx( long TenantId )
	{
		return( readDomainByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDomainObj> readDomainByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDomainByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamDomainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamDomainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamDomainObj realized = (ICFBamDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamDomainObj> cmp = new Comparator<ICFBamDomainObj>() {
			public int compare( ICFBamDomainObj lhs, ICFBamDomainObj rhs ) {
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
		ICFBamDomainObj arr[] = new ICFBamDomainObj[len];
		Iterator<ICFBamDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDomainObj> arrayList = new ArrayList<ICFBamDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDomainObj> readDomainBySubDomIdx( long TenantId,
		long SubDomainOfId )
	{
		return( readDomainBySubDomIdx( TenantId,
			SubDomainOfId,
			false ) );
	}

	public List<ICFBamDomainObj> readDomainBySubDomIdx( long TenantId,
		long SubDomainOfId,
		boolean forceRead )
	{
		final String S_ProcName = "readDomainBySubDomIdx";
		CFBamDomainBySubDomIdxKey key = schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		Map<CFBamDomainBasePKey, ICFBamDomainObj> dict;
		if( indexBySubDomIdx == null ) {
			indexBySubDomIdx = new HashMap< CFBamDomainBySubDomIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainObj > >();
		}
		if( ( ! forceRead ) && indexBySubDomIdx.containsKey( key ) ) {
			dict = indexBySubDomIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamDomainObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySubDomIdx.put( key, dict );
			ICFBamDomainObj obj;
			CFBamDomainBuff[] buffList = schema.getBackingStore().getTableDomain().readDerivedBySubDomIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId );
			CFBamDomainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamDomainObj realized = (ICFBamDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamDomainObj> cmp = new Comparator<ICFBamDomainObj>() {
			public int compare( ICFBamDomainObj lhs, ICFBamDomainObj rhs ) {
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
		ICFBamDomainObj arr[] = new ICFBamDomainObj[len];
		Iterator<ICFBamDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDomainObj> arrayList = new ArrayList<ICFBamDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDomainObj readDomainByNameIdx( long TenantId,
		long SubDomainOfId,
		String Name )
	{
		return( readDomainByNameIdx( TenantId,
			SubDomainOfId,
			Name,
			false ) );
	}

	public ICFBamDomainObj readDomainByNameIdx( long TenantId,
		long SubDomainOfId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamDomainByNameIdxKey,
				ICFBamDomainObj >();
		}
		CFBamDomainByNameIdxKey key = schema.getBackingStore().getFactoryDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		key.setRequiredName( Name );
		ICFBamDomainObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamDomainBuff buff = schema.getBackingStore().getTableDomain().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId,
				Name );
			if( buff != null ) {
				obj = (ICFBamDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDomainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDomainObj updateDomain( ICFBamDomainObj Obj ) {
		ICFBamDomainObj obj = Obj;
		schema.getBackingStore().getTableDomain().updateDomain( schema.getAuthorization(),
			Obj.getDomainBuff() );
		if( Obj.getClassCode().equals( "DOMN" ) ) {
			obj = (ICFBamDomainObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDomain( ICFBamDomainObj Obj ) {
		ICFBamDomainObj obj = Obj;
		schema.getBackingStore().getTableDomain().deleteDomain( schema.getAuthorization(),
			obj.getDomainBuff() );
		obj.forget( true );
	}

	public void deleteDomainByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readDomain( pkey );
		if( obj != null ) {
			ICFBamDomainEditObj editObj = (ICFBamDomainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDomainEditObj)obj.beginEdit();
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

	public void deleteDomainByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDomain().deleteDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDomainObj> iter = dict.values().iterator();
			ICFBamDomainObj obj;
			List<ICFBamDomainObj> toForget = new LinkedList<ICFBamDomainObj>();
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
			schema.getBackingStore().getTableDomain().deleteDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDomainBySubDomIdx( long TenantId,
		long SubDomainOfId )
	{
		CFBamDomainBySubDomIdxKey key = schema.getBackingStore().getFactoryDomain().newSubDomIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		if( indexBySubDomIdx == null ) {
			indexBySubDomIdx = new HashMap< CFBamDomainBySubDomIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainObj > >();
		}
		if( indexBySubDomIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainObj> dict = indexBySubDomIdx.get( key );
			schema.getBackingStore().getTableDomain().deleteDomainBySubDomIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId );
			Iterator<ICFBamDomainObj> iter = dict.values().iterator();
			ICFBamDomainObj obj;
			List<ICFBamDomainObj> toForget = new LinkedList<ICFBamDomainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySubDomIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableDomain().deleteDomainBySubDomIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId );
		}
	}

	public void deleteDomainByNameIdx( long TenantId,
		long SubDomainOfId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamDomainByNameIdxKey,
				ICFBamDomainObj >();
		}
		CFBamDomainByNameIdxKey key = schema.getBackingStore().getFactoryDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubDomainOfId( SubDomainOfId );
		key.setRequiredName( Name );
		ICFBamDomainObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableDomain().deleteDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDomain().deleteDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				SubDomainOfId,
				Name );
		}
	}
}
