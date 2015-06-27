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

public class CFBamDelDepTableObj
	implements ICFBamDelDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelDepObj> members;
	private Map<CFBamScopePKey, ICFBamDelDepObj> allDelDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByTableIdx;
	public static String TABLE_NAME = "DelDep";
	public static String TABLE_DBNAME = "del_dep";

	public CFBamDelDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
	}

	public CFBamDelDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
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
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelDepObj.
	 */
	public ICFBamDelDepObj newInstance() {
		ICFBamDelDepObj inst = new CFBamDelDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelDepObj.
	 */
	public ICFBamDelDepEditObj newEditInstance( ICFBamDelDepObj orig ) {
		ICFBamDelDepEditObj edit = new CFBamDelDepEditObj( orig );
		return( edit );
	}

	public ICFBamDelDepObj realizeDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelDepObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelDepObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetDelDep( ICFBamDelDepObj Obj ) {
		forgetDelDep( Obj, false );
	}

	public void forgetDelDep( ICFBamDelDepObj Obj, boolean forgetSubObjects ) {
		ICFBamDelDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( allDelDep != null ) {
				allDelDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetDelDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
				ICFBamDelDepObj cur = null;
				Iterator<ICFBamDelDepObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
				ICFBamDelDepObj cur = null;
				Iterator<ICFBamDelDepObj> iter = mapDefSchemaIdx.values().iterator();
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

			indexByDefSchemaIdx.remove( key );
		}
	}

	public void forgetDelDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
				ICFBamDelDepObj cur = null;
				Iterator<ICFBamDelDepObj> iter = mapTableIdx.values().iterator();
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

	public ICFBamDelDepObj createDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		CFBamDelDepBuff buff = obj.getDelDepBuff();
		schema.getBackingStore().getTableDelDep().createDelDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DELD" ) ) {
			obj = (ICFBamDelDepObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDelDepObj readDelDep( CFBamScopePKey pkey ) {
		return( readDelDep( pkey, false ) );
	}

	public ICFBamDelDepObj readDelDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelDepBuff readBuff = schema.getBackingStore().getTableDelDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDelDepObj lockDelDep( CFBamScopePKey pkey ) {
		ICFBamDelDepObj locked = null;
		CFBamDelDepBuff lockBuff = schema.getBackingStore().getTableDelDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelDepObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDelDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelDepObj> readAllDelDep() {
		return( readAllDelDep( false ) );
	}

	public List<ICFBamDelDepObj> readAllDelDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelDep";
		if( ( allDelDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> map = new HashMap<CFBamScopePKey,ICFBamDelDepObj>();
			allDelDep = map;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readAllDerived( schema.getAuthorization() );
			CFBamDelDepBuff buff;
			ICFBamDelDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realized = (ICFBamDelDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		int len = allDelDep.size();
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = allDelDep.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id )
	{
		return( readDelDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelDepObj obj = readDelDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId )
	{
		return( readDelDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realized = (ICFBamDelDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realized = (ICFBamDelDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelDepObj> readDelDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelDepByTableIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByTableIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByTableIdx";
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realized = (ICFBamDelDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelDepObj updateDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		schema.getBackingStore().getTableDelDep().updateDelDep( schema.getAuthorization(),
			Obj.getDelDepBuff() );
		if( Obj.getClassCode().equals( "DELD" ) ) {
			obj = (ICFBamDelDepObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		schema.getBackingStore().getTableDelDep().deleteDelDep( schema.getAuthorization(),
			obj.getDelDepBuff() );
		obj.forget( true );
	}

	public void deleteDelDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readDelDep( pkey );
		if( obj != null ) {
			ICFBamDelDepEditObj editObj = (ICFBamDelDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelDepEditObj)obj.beginEdit();
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

	public void deleteDelDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDelDep().deleteDelDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
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
			schema.getBackingStore().getTableDelDep().deleteDelDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableDelDep().deleteDelDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableDelDep().deleteDelDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableDelDep().deleteDelDepByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
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
			schema.getBackingStore().getTableDelDep().deleteDelDepByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}
}
