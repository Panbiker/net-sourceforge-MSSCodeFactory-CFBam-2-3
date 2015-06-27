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

public class CFBamMinorVersionTableObj
	implements ICFBamMinorVersionTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> members;
	private Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> allMinorVersion;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > > indexByTenantIdx;
	private Map< CFBamMinorVersionByMajorIdxKey,
		Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > > indexByMajorIdx;
	private Map< CFBamMinorVersionByNameIdxKey,
		ICFBamMinorVersionObj > indexByNameIdx;
	public static String TABLE_NAME = "MinorVersion";
	public static String TABLE_DBNAME = "mnverdef";

	public CFBamMinorVersionTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamMinorVersionObj>();
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorIdx = null;
		indexByNameIdx = null;
	}

	public CFBamMinorVersionTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamMinorVersionObj>();
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorIdx = null;
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
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMinorVersionObj.
	 */
	public ICFBamMinorVersionObj newInstance() {
		ICFBamMinorVersionObj inst = new CFBamMinorVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMinorVersionObj.
	 */
	public ICFBamMinorVersionEditObj newEditInstance( ICFBamMinorVersionObj orig ) {
		ICFBamMinorVersionEditObj edit = new CFBamMinorVersionEditObj( orig );
		return( edit );
	}

	public ICFBamMinorVersionObj realizeMinorVersion( ICFBamMinorVersionObj Obj ) {
		ICFBamMinorVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamMinorVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamMinorVersionObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByMajorIdx != null ) {
				CFBamMinorVersionByMajorIdxKey keyMajorIdx =
					schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
				keyMajorIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMajorIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapMajorIdx = indexByMajorIdx.get( keyMajorIdx );
				if( mapMajorIdx != null ) {
					mapMajorIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMinorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamMinorVersionObj)schema.getVersionTableObj().realizeVersion( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMajorIdx != null ) {
				CFBamMinorVersionByMajorIdxKey keyMajorIdx =
					schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
				keyMajorIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMajorIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapMajorIdx = indexByMajorIdx.get( keyMajorIdx );
				if( mapMajorIdx != null ) {
					mapMajorIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMinorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allMinorVersion != null ) {
				allMinorVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamMinorVersionObj)schema.getVersionTableObj().realizeVersion( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMinorVersion != null ) {
				allMinorVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMajorIdx != null ) {
				CFBamMinorVersionByMajorIdxKey keyMajorIdx =
					schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
				keyMajorIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMajorIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapMajorIdx = indexByMajorIdx.get( keyMajorIdx );
				if( mapMajorIdx != null ) {
					mapMajorIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMinorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetMinorVersion( ICFBamMinorVersionObj Obj ) {
		forgetMinorVersion( Obj, false );
	}

	public void forgetMinorVersion( ICFBamMinorVersionObj Obj, boolean forgetSubObjects ) {
		ICFBamMinorVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamMinorVersionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByMajorIdx != null ) {
				CFBamMinorVersionByMajorIdxKey keyMajorIdx =
					schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
				keyMajorIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMajorIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapMajorIdx = indexByMajorIdx.get( keyMajorIdx );
				if( mapMajorIdx != null ) {
					mapMajorIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMinorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredMajorId( keepObj.getRequiredMajorId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allMinorVersion != null ) {
				allMinorVersion.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getVersionTableObj().forgetVersion( obj );
	}

	public void forgetMinorVersionByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamMinorVersionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetMinorVersionByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamMinorVersionObj> toForget = new LinkedList<ICFBamMinorVersionObj>();
				ICFBamMinorVersionObj cur = null;
				Iterator<ICFBamMinorVersionObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetMinorVersionByMajorIdx( long TenantId,
		long MajorId )
	{
		if( indexByMajorIdx == null ) {
			return;
		}
		CFBamMinorVersionByMajorIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		if( indexByMajorIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMinorVersionObj > mapMajorIdx = indexByMajorIdx.get( key );
			if( mapMajorIdx != null ) {
				List<ICFBamMinorVersionObj> toForget = new LinkedList<ICFBamMinorVersionObj>();
				ICFBamMinorVersionObj cur = null;
				Iterator<ICFBamMinorVersionObj> iter = mapMajorIdx.values().iterator();
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

			indexByMajorIdx.remove( key );
		}
	}

	public void forgetMinorVersionByNameIdx( long TenantId,
		long MajorId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamMinorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamMinorVersionObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamMinorVersionObj createMinorVersion( ICFBamMinorVersionObj Obj ) {
		ICFBamMinorVersionObj obj = Obj;
		CFBamMinorVersionBuff buff = obj.getMinorVersionBuff();
		schema.getBackingStore().getTableMinorVersion().createMinorVersion(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "MNVR" ) ) {
			obj = (ICFBamMinorVersionObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamMinorVersionObj readMinorVersion( CFBamDomainBasePKey pkey ) {
		return( readMinorVersion( pkey, false ) );
	}

	public ICFBamMinorVersionObj readMinorVersion( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamMinorVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamMinorVersionBuff readBuff = schema.getBackingStore().getTableMinorVersion().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamMinorVersionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamMinorVersionObj lockMinorVersion( CFBamDomainBasePKey pkey ) {
		ICFBamMinorVersionObj locked = null;
		CFBamMinorVersionBuff lockBuff = schema.getBackingStore().getTableMinorVersion().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamMinorVersionObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockMinorVersion", pkey );
		}
		return( locked );
	}

	public List<ICFBamMinorVersionObj> readAllMinorVersion() {
		return( readAllMinorVersion( false ) );
	}

	public List<ICFBamMinorVersionObj> readAllMinorVersion( boolean forceRead ) {
		final String S_ProcName = "readAllMinorVersion";
		if( ( allMinorVersion == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> map = new HashMap<CFBamDomainBasePKey,ICFBamMinorVersionObj>();
			allMinorVersion = map;
			CFBamMinorVersionBuff[] buffList = schema.getBackingStore().getTableMinorVersion().readAllDerived( schema.getAuthorization() );
			CFBamMinorVersionBuff buff;
			ICFBamMinorVersionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMinorVersionObj realized = (ICFBamMinorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMinorVersionObj> cmp = new Comparator<ICFBamMinorVersionObj>() {
			public int compare( ICFBamMinorVersionObj lhs, ICFBamMinorVersionObj rhs ) {
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
		int len = allMinorVersion.size();
		ICFBamMinorVersionObj arr[] = new ICFBamMinorVersionObj[len];
		Iterator<ICFBamMinorVersionObj> valIter = allMinorVersion.values().iterator();
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
		ArrayList<ICFBamMinorVersionObj> arrayList = new ArrayList<ICFBamMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamMinorVersionObj readMinorVersionByIdIdx( long TenantId,
		long Id )
	{
		return( readMinorVersionByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamMinorVersionObj readMinorVersionByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamMinorVersionObj obj = readMinorVersion( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamMinorVersionObj> readMinorVersionByTenantIdx( long TenantId )
	{
		return( readMinorVersionByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamMinorVersionObj> readMinorVersionByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readMinorVersionByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMinorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamMinorVersionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMinorVersionObj realized = (ICFBamMinorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMinorVersionObj> cmp = new Comparator<ICFBamMinorVersionObj>() {
			public int compare( ICFBamMinorVersionObj lhs, ICFBamMinorVersionObj rhs ) {
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
		ICFBamMinorVersionObj arr[] = new ICFBamMinorVersionObj[len];
		Iterator<ICFBamMinorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamMinorVersionObj> arrayList = new ArrayList<ICFBamMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamMinorVersionObj> readMinorVersionByMajorIdx( long TenantId,
		long MajorId )
	{
		return( readMinorVersionByMajorIdx( TenantId,
			MajorId,
			false ) );
	}

	public List<ICFBamMinorVersionObj> readMinorVersionByMajorIdx( long TenantId,
		long MajorId,
		boolean forceRead )
	{
		final String S_ProcName = "readMinorVersionByMajorIdx";
		CFBamMinorVersionByMajorIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> dict;
		if( indexByMajorIdx == null ) {
			indexByMajorIdx = new HashMap< CFBamMinorVersionByMajorIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMinorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByMajorIdx.containsKey( key ) ) {
			dict = indexByMajorIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamMinorVersionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByMajorIdx.put( key, dict );
			ICFBamMinorVersionObj obj;
			CFBamMinorVersionBuff[] buffList = schema.getBackingStore().getTableMinorVersion().readDerivedByMajorIdx( schema.getAuthorization(),
				TenantId,
				MajorId );
			CFBamMinorVersionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMinorVersionObj realized = (ICFBamMinorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMinorVersionObj> cmp = new Comparator<ICFBamMinorVersionObj>() {
			public int compare( ICFBamMinorVersionObj lhs, ICFBamMinorVersionObj rhs ) {
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
		ICFBamMinorVersionObj arr[] = new ICFBamMinorVersionObj[len];
		Iterator<ICFBamMinorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamMinorVersionObj> arrayList = new ArrayList<ICFBamMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamMinorVersionObj readMinorVersionByNameIdx( long TenantId,
		long MajorId,
		String Name )
	{
		return( readMinorVersionByNameIdx( TenantId,
			MajorId,
			Name,
			false ) );
	}

	public ICFBamMinorVersionObj readMinorVersionByNameIdx( long TenantId,
		long MajorId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamMinorVersionByNameIdxKey,
				ICFBamMinorVersionObj >();
		}
		CFBamMinorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		key.setRequiredName( Name );
		ICFBamMinorVersionObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamMinorVersionBuff buff = schema.getBackingStore().getTableMinorVersion().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				MajorId,
				Name );
			if( buff != null ) {
				obj = (ICFBamMinorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamMinorVersionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamMinorVersionObj updateMinorVersion( ICFBamMinorVersionObj Obj ) {
		ICFBamMinorVersionObj obj = Obj;
		schema.getBackingStore().getTableMinorVersion().updateMinorVersion( schema.getAuthorization(),
			Obj.getMinorVersionBuff() );
		if( Obj.getClassCode().equals( "MNVR" ) ) {
			obj = (ICFBamMinorVersionObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteMinorVersion( ICFBamMinorVersionObj Obj ) {
		ICFBamMinorVersionObj obj = Obj;
		schema.getBackingStore().getTableMinorVersion().deleteMinorVersion( schema.getAuthorization(),
			obj.getMinorVersionBuff() );
		obj.forget( true );
	}

	public void deleteMinorVersionByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readMinorVersion( pkey );
		if( obj != null ) {
			ICFBamMinorVersionEditObj editObj = (ICFBamMinorVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamMinorVersionEditObj)obj.beginEdit();
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

	public void deleteMinorVersionByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMinorVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamMinorVersionObj> iter = dict.values().iterator();
			ICFBamMinorVersionObj obj;
			List<ICFBamMinorVersionObj> toForget = new LinkedList<ICFBamMinorVersionObj>();
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
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteMinorVersionByMajorIdx( long TenantId,
		long MajorId )
	{
		CFBamMinorVersionByMajorIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		if( indexByMajorIdx == null ) {
			indexByMajorIdx = new HashMap< CFBamMinorVersionByMajorIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMinorVersionObj > >();
		}
		if( indexByMajorIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMinorVersionObj> dict = indexByMajorIdx.get( key );
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByMajorIdx( schema.getAuthorization(),
				TenantId,
				MajorId );
			Iterator<ICFBamMinorVersionObj> iter = dict.values().iterator();
			ICFBamMinorVersionObj obj;
			List<ICFBamMinorVersionObj> toForget = new LinkedList<ICFBamMinorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByMajorIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByMajorIdx( schema.getAuthorization(),
				TenantId,
				MajorId );
		}
	}

	public void deleteMinorVersionByNameIdx( long TenantId,
		long MajorId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamMinorVersionByNameIdxKey,
				ICFBamMinorVersionObj >();
		}
		CFBamMinorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMinorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		key.setRequiredName( Name );
		ICFBamMinorVersionObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				MajorId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableMinorVersion().deleteMinorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				MajorId,
				Name );
		}
	}
}
