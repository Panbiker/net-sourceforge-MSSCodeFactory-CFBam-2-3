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

public class CFBamTopDomainTableObj
	implements ICFBamTopDomainTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamTopDomainObj> members;
	private Map<CFBamDomainBasePKey, ICFBamTopDomainObj> allTopDomain;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamTopDomainObj > > indexByTenantIdx;
	private Map< CFBamTopDomainByTldIdxKey,
		Map<CFBamDomainBasePKey, ICFBamTopDomainObj > > indexByTldIdx;
	private Map< CFBamTopDomainByNameIdxKey,
		ICFBamTopDomainObj > indexByNameIdx;
	public static String TABLE_NAME = "TopDomain";
	public static String TABLE_DBNAME = "tdomdef";

	public CFBamTopDomainTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
	}

	public CFBamTopDomainTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
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
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTopDomainObj.
	 */
	public ICFBamTopDomainObj newInstance() {
		ICFBamTopDomainObj inst = new CFBamTopDomainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTopDomainObj.
	 */
	public ICFBamTopDomainEditObj newEditInstance( ICFBamTopDomainObj orig ) {
		ICFBamTopDomainEditObj edit = new CFBamTopDomainEditObj( orig );
		return( edit );
	}

	public ICFBamTopDomainObj realizeTopDomain( ICFBamTopDomainObj Obj ) {
		ICFBamTopDomainObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamTopDomainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTopDomainObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTldIdx != null ) {
				CFBamTopDomainByTldIdxKey keyTldIdx =
					schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().realizeDomainBase( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				CFBamTopDomainByTldIdxKey keyTldIdx =
					schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().realizeDomainBase( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				CFBamTopDomainByTldIdxKey keyTldIdx =
					schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTopDomain( ICFBamTopDomainObj Obj ) {
		forgetTopDomain( Obj, false );
	}

	public void forgetTopDomain( ICFBamTopDomainObj Obj, boolean forgetSubObjects ) {
		ICFBamTopDomainObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTopDomainObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTldIdx != null ) {
				CFBamTopDomainByTldIdxKey keyTldIdx =
					schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopDomainByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTopDomain != null ) {
				allTopDomain.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getDomainTableObj().forgetDomainBySubDomIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getTopProjectTableObj().forgetTopProjectByDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getDomainBaseTableObj().forgetDomainBase( obj );
	}

	public void forgetTopDomainByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTopDomainObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTopDomainByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTopDomainObj> toForget = new LinkedList<ICFBamTopDomainObj>();
				ICFBamTopDomainObj cur = null;
				Iterator<ICFBamTopDomainObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		if( indexByTldIdx == null ) {
			return;
		}
		CFBamTopDomainByTldIdxKey key = schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		if( indexByTldIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopDomainObj > mapTldIdx = indexByTldIdx.get( key );
			if( mapTldIdx != null ) {
				List<ICFBamTopDomainObj> toForget = new LinkedList<ICFBamTopDomainObj>();
				ICFBamTopDomainObj cur = null;
				Iterator<ICFBamTopDomainObj> iter = mapTldIdx.values().iterator();
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

			indexByTldIdx.remove( key );
		}
	}

	public void forgetTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamTopDomainByNameIdxKey key = schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamTopDomainObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamTopDomainObj createTopDomain( ICFBamTopDomainObj Obj ) {
		ICFBamTopDomainObj obj = Obj;
		CFBamTopDomainBuff buff = obj.getTopDomainBuff();
		schema.getBackingStore().getTableTopDomain().createTopDomain(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "TDOM" ) ) {
			obj = (ICFBamTopDomainObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamTopDomainObj readTopDomain( CFBamDomainBasePKey pkey ) {
		return( readTopDomain( pkey, false ) );
	}

	public ICFBamTopDomainObj readTopDomain( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamTopDomainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTopDomainBuff readBuff = schema.getBackingStore().getTableTopDomain().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTopDomainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTopDomainObj lockTopDomain( CFBamDomainBasePKey pkey ) {
		ICFBamTopDomainObj locked = null;
		CFBamTopDomainBuff lockBuff = schema.getBackingStore().getTableTopDomain().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTopDomainObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTopDomain", pkey );
		}
		return( locked );
	}

	public List<ICFBamTopDomainObj> readAllTopDomain() {
		return( readAllTopDomain( false ) );
	}

	public List<ICFBamTopDomainObj> readAllTopDomain( boolean forceRead ) {
		final String S_ProcName = "readAllTopDomain";
		if( ( allTopDomain == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamTopDomainObj> map = new HashMap<CFBamDomainBasePKey,ICFBamTopDomainObj>();
			allTopDomain = map;
			CFBamTopDomainBuff[] buffList = schema.getBackingStore().getTableTopDomain().readAllDerived( schema.getAuthorization() );
			CFBamTopDomainBuff buff;
			ICFBamTopDomainObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopDomainObj realized = (ICFBamTopDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamTopDomainObj> cmp = new Comparator<ICFBamTopDomainObj>() {
			public int compare( ICFBamTopDomainObj lhs, ICFBamTopDomainObj rhs ) {
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
		int len = allTopDomain.size();
		ICFBamTopDomainObj arr[] = new ICFBamTopDomainObj[len];
		Iterator<ICFBamTopDomainObj> valIter = allTopDomain.values().iterator();
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
		ArrayList<ICFBamTopDomainObj> arrayList = new ArrayList<ICFBamTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id )
	{
		return( readTopDomainByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTopDomainObj obj = readTopDomain( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTopDomainObj> readTopDomainByTenantIdx( long TenantId )
	{
		return( readTopDomainByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTopDomainObj> readTopDomainByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamTopDomainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamTopDomainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopDomainObj realized = (ICFBamTopDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamTopDomainObj> cmp = new Comparator<ICFBamTopDomainObj>() {
			public int compare( ICFBamTopDomainObj lhs, ICFBamTopDomainObj rhs ) {
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
		ICFBamTopDomainObj arr[] = new ICFBamTopDomainObj[len];
		Iterator<ICFBamTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTopDomainObj> arrayList = new ArrayList<ICFBamTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		return( readTopDomainByTldIdx( TenantId,
			TldId,
			false ) );
	}

	public List<ICFBamTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTldIdx";
		CFBamTopDomainByTldIdxKey key = schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		Map<CFBamDomainBasePKey, ICFBamTopDomainObj> dict;
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< CFBamTopDomainByTldIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTldIdx.containsKey( key ) ) {
			dict = indexByTldIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamTopDomainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTldIdx.put( key, dict );
			ICFBamTopDomainObj obj;
			CFBamTopDomainBuff[] buffList = schema.getBackingStore().getTableTopDomain().readDerivedByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
			CFBamTopDomainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopDomainObj realized = (ICFBamTopDomainObj)obj.realize();
			}
		}
		Comparator<ICFBamTopDomainObj> cmp = new Comparator<ICFBamTopDomainObj>() {
			public int compare( ICFBamTopDomainObj lhs, ICFBamTopDomainObj rhs ) {
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
		ICFBamTopDomainObj arr[] = new ICFBamTopDomainObj[len];
		Iterator<ICFBamTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTopDomainObj> arrayList = new ArrayList<ICFBamTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTopDomainObj readTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		return( readTopDomainByNameIdx( TenantId,
			TldId,
			Name,
			false ) );
	}

	public ICFBamTopDomainObj readTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTopDomainByNameIdxKey,
				ICFBamTopDomainObj >();
		}
		CFBamTopDomainByNameIdxKey key = schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		ICFBamTopDomainObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamTopDomainBuff buff = schema.getBackingStore().getTableTopDomain().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTopDomainObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTopDomainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTopDomainObj updateTopDomain( ICFBamTopDomainObj Obj ) {
		ICFBamTopDomainObj obj = Obj;
		schema.getBackingStore().getTableTopDomain().updateTopDomain( schema.getAuthorization(),
			Obj.getTopDomainBuff() );
		if( Obj.getClassCode().equals( "TDOM" ) ) {
			obj = (ICFBamTopDomainObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTopDomain( ICFBamTopDomainObj Obj ) {
		ICFBamTopDomainObj obj = Obj;
		schema.getBackingStore().getTableTopDomain().deleteTopDomain( schema.getAuthorization(),
			obj.getTopDomainBuff() );
		obj.forget( true );
	}

	public void deleteTopDomainByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readTopDomain( pkey );
		if( obj != null ) {
			ICFBamTopDomainEditObj editObj = (ICFBamTopDomainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTopDomainEditObj)obj.beginEdit();
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

	public void deleteTopDomainByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopDomainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopDomainObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTopDomainObj> iter = dict.values().iterator();
			ICFBamTopDomainObj obj;
			List<ICFBamTopDomainObj> toForget = new LinkedList<ICFBamTopDomainObj>();
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
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		CFBamTopDomainByTldIdxKey key = schema.getBackingStore().getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< CFBamTopDomainByTldIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopDomainObj > >();
		}
		if( indexByTldIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopDomainObj> dict = indexByTldIdx.get( key );
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
			Iterator<ICFBamTopDomainObj> iter = dict.values().iterator();
			ICFBamTopDomainObj obj;
			List<ICFBamTopDomainObj> toForget = new LinkedList<ICFBamTopDomainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTldIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
		}
	}

	public void deleteTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTopDomainByNameIdxKey,
				ICFBamTopDomainObj >();
		}
		CFBamTopDomainByNameIdxKey key = schema.getBackingStore().getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		ICFBamTopDomainObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTopDomain().deleteTopDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
		}
	}
}
