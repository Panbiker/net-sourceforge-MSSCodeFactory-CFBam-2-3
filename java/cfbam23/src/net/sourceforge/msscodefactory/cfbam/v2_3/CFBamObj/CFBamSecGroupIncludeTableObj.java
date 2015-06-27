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

public class CFBamSecGroupIncludeTableObj
	implements ICFBamSecGroupIncludeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> members;
	private Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> allSecGroupInclude;
	private Map< CFBamSecGroupIncludeByClusterIdxKey,
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > > indexByClusterIdx;
	private Map< CFBamSecGroupIncludeByGroupIdxKey,
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > > indexByGroupIdx;
	private Map< CFBamSecGroupIncludeByIncludeIdxKey,
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > > indexByIncludeIdx;
	private Map< CFBamSecGroupIncludeByUIncludeIdxKey,
		ICFBamSecGroupIncludeObj > indexByUIncludeIdx;
	public static String TABLE_NAME = "SecGroupInclude";
	public static String TABLE_DBNAME = "secinc";

	public CFBamSecGroupIncludeTableObj() {
		schema = null;
		members = new HashMap<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj>();
		allSecGroupInclude = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
	}

	public CFBamSecGroupIncludeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj>();
		allSecGroupInclude = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
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
		allSecGroupInclude = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
		List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
		ICFBamSecGroupIncludeObj cur = null;
		Iterator<ICFBamSecGroupIncludeObj> iter = members.values().iterator();
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
	 *	CFBamSecGroupIncludeObj.
	 */
	public ICFBamSecGroupIncludeObj newInstance() {
		ICFBamSecGroupIncludeObj inst = new CFBamSecGroupIncludeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecGroupIncludeObj.
	 */
	public ICFBamSecGroupIncludeEditObj newEditInstance( ICFBamSecGroupIncludeObj orig ) {
		ICFBamSecGroupIncludeEditObj edit = new CFBamSecGroupIncludeEditObj( orig );
		return( edit );
	}

	public ICFBamSecGroupIncludeObj realizeSecGroupInclude( ICFBamSecGroupIncludeObj Obj ) {
		ICFBamSecGroupIncludeObj obj = Obj;
		CFBamSecGroupIncludePKey pkey = obj.getPKey();
		ICFBamSecGroupIncludeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecGroupIncludeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}
			if( allSecGroupInclude != null ) {
				allSecGroupInclude.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroupInclude != null ) {
				allSecGroupInclude.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecGroupInclude( ICFBamSecGroupIncludeObj Obj ) {
		forgetSecGroupInclude( Obj, false );
	}

	public void forgetSecGroupInclude( ICFBamSecGroupIncludeObj Obj, boolean forgetSubObjects ) {
		ICFBamSecGroupIncludeObj obj = Obj;
		CFBamSecGroupIncludePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecGroupIncludeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecGroupIncludeByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			if( allSecGroupInclude != null ) {
				allSecGroupInclude.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecGroupIncludePKey key = schema.getBackingStore().getFactorySecGroupInclude().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupIncludeId( SecGroupIncludeId );
		if( members.containsKey( key ) ) {
			ICFBamSecGroupIncludeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupIncludeByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
				ICFBamSecGroupIncludeObj cur = null;
				Iterator<ICFBamSecGroupIncludeObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
				ICFBamSecGroupIncludeObj cur = null;
				Iterator<ICFBamSecGroupIncludeObj> iter = mapGroupIdx.values().iterator();
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

			indexByGroupIdx.remove( key );
		}
	}

	public void forgetSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		if( indexByIncludeIdx == null ) {
			return;
		}
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( key );
			if( mapIncludeIdx != null ) {
				List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
				ICFBamSecGroupIncludeObj cur = null;
				Iterator<ICFBamSecGroupIncludeObj> iter = mapIncludeIdx.values().iterator();
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

			indexByIncludeIdx.remove( key );
		}
	}

	public void forgetSecGroupIncludeByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			return;
		}
		CFBamSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByUIncludeIdx.containsKey( key ) ) {
			ICFBamSecGroupIncludeObj probed = indexByUIncludeIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUIncludeIdx.remove( key );
		}
	}

	public ICFBamSecGroupIncludeObj createSecGroupInclude( ICFBamSecGroupIncludeObj Obj ) {
		ICFBamSecGroupIncludeObj obj = Obj;
		CFBamSecGroupIncludeBuff buff = obj.getSecGroupIncludeBuff();
		schema.getBackingStore().getTableSecGroupInclude().createSecGroupInclude(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecGroupIncludeObj readSecGroupInclude( CFBamSecGroupIncludePKey pkey ) {
		return( readSecGroupInclude( pkey, false ) );
	}

	public ICFBamSecGroupIncludeObj readSecGroupInclude( CFBamSecGroupIncludePKey pkey, boolean forceRead ) {
		ICFBamSecGroupIncludeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecGroupIncludeBuff readBuff = schema.getBackingStore().getTableSecGroupInclude().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupIncludeId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecGroupIncludeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupIncludeObj lockSecGroupInclude( CFBamSecGroupIncludePKey pkey ) {
		ICFBamSecGroupIncludeObj locked = null;
		CFBamSecGroupIncludeBuff lockBuff = schema.getBackingStore().getTableSecGroupInclude().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupIncludeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecGroupIncludeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecGroupInclude", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecGroupIncludeObj> readAllSecGroupInclude() {
		return( readAllSecGroupInclude( false ) );
	}

	public List<ICFBamSecGroupIncludeObj> readAllSecGroupInclude( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroupInclude";
		if( ( allSecGroupInclude == null ) || forceRead ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> map = new HashMap<CFBamSecGroupIncludePKey,ICFBamSecGroupIncludeObj>();
			allSecGroupInclude = map;
			CFBamSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableSecGroupInclude().readAllDerived( schema.getAuthorization() );
			CFBamSecGroupIncludeBuff buff;
			ICFBamSecGroupIncludeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupIncludeObj realized = (ICFBamSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupIncludeObj> cmp = new Comparator<ICFBamSecGroupIncludeObj>() {
			public int compare( ICFBamSecGroupIncludeObj lhs, ICFBamSecGroupIncludeObj rhs ) {
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
					CFBamSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecGroupInclude.size();
		ICFBamSecGroupIncludeObj arr[] = new ICFBamSecGroupIncludeObj[len];
		Iterator<ICFBamSecGroupIncludeObj> valIter = allSecGroupInclude.values().iterator();
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
		ArrayList<ICFBamSecGroupIncludeObj> arrayList = new ArrayList<ICFBamSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupIncludeObj readSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId )
	{
		return( readSecGroupIncludeByIdIdx( ClusterId,
			SecGroupIncludeId,
			false ) );
	}

	public ICFBamSecGroupIncludeObj readSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId, boolean forceRead )
	{
		CFBamSecGroupIncludePKey pkey = schema.getBackingStore().getFactorySecGroupInclude().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupIncludeId( SecGroupIncludeId );
		ICFBamSecGroupIncludeObj obj = readSecGroupInclude( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByClusterIdx( long ClusterId )
	{
		return( readSecGroupIncludeByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupIncludeByClusterIdx";
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupIncludeByClusterIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecGroupIncludeObj obj;
			CFBamSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableSecGroupInclude().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupIncludeObj realized = (ICFBamSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupIncludeObj> cmp = new Comparator<ICFBamSecGroupIncludeObj>() {
			public int compare( ICFBamSecGroupIncludeObj lhs, ICFBamSecGroupIncludeObj rhs ) {
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
					CFBamSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupIncludeObj arr[] = new ICFBamSecGroupIncludeObj[len];
		Iterator<ICFBamSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupIncludeObj> arrayList = new ArrayList<ICFBamSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupIncludeByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupIncludeByGroupIdx";
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupIncludeByGroupIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByGroupIdx.put( key, dict );
			ICFBamSecGroupIncludeObj obj;
			CFBamSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableSecGroupInclude().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFBamSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupIncludeObj realized = (ICFBamSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupIncludeObj> cmp = new Comparator<ICFBamSecGroupIncludeObj>() {
			public int compare( ICFBamSecGroupIncludeObj lhs, ICFBamSecGroupIncludeObj rhs ) {
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
					CFBamSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupIncludeObj arr[] = new ICFBamSecGroupIncludeObj[len];
		Iterator<ICFBamSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupIncludeObj> arrayList = new ArrayList<ICFBamSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		return( readSecGroupIncludeByIncludeIdx( ClusterId,
			IncludeGroupId,
			false ) );
	}

	public List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupIncludeByIncludeIdx";
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict;
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFBamSecGroupIncludeByIncludeIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByIncludeIdx.containsKey( key ) ) {
			dict = indexByIncludeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIncludeIdx.put( key, dict );
			ICFBamSecGroupIncludeObj obj;
			CFBamSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableSecGroupInclude().readDerivedByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
			CFBamSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupIncludeObj realized = (ICFBamSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupIncludeObj> cmp = new Comparator<ICFBamSecGroupIncludeObj>() {
			public int compare( ICFBamSecGroupIncludeObj lhs, ICFBamSecGroupIncludeObj rhs ) {
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
					CFBamSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupIncludeObj arr[] = new ICFBamSecGroupIncludeObj[len];
		Iterator<ICFBamSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupIncludeObj> arrayList = new ArrayList<ICFBamSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupIncludeObj readSecGroupIncludeByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		return( readSecGroupIncludeByUIncludeIdx( ClusterId,
			SecGroupId,
			IncludeGroupId,
			false ) );
	}

	public ICFBamSecGroupIncludeObj readSecGroupIncludeByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId, boolean forceRead )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFBamSecGroupIncludeByUIncludeIdxKey,
				ICFBamSecGroupIncludeObj >();
		}
		CFBamSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFBamSecGroupIncludeObj obj = null;
		if( ( ! forceRead ) && indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
		}
		else {
			CFBamSecGroupIncludeBuff buff = schema.getBackingStore().getTableSecGroupInclude().readDerivedByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
			if( buff != null ) {
				obj = schema.getSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupInclude().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecGroupIncludeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUIncludeIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupIncludeObj updateSecGroupInclude( ICFBamSecGroupIncludeObj Obj ) {
		ICFBamSecGroupIncludeObj obj = Obj;
		schema.getBackingStore().getTableSecGroupInclude().updateSecGroupInclude( schema.getAuthorization(),
			Obj.getSecGroupIncludeBuff() );
		obj = (ICFBamSecGroupIncludeObj)Obj.realize();
		return( obj );
	}

	public void deleteSecGroupInclude( ICFBamSecGroupIncludeObj Obj ) {
		ICFBamSecGroupIncludeObj obj = Obj;
		schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupInclude( schema.getAuthorization(),
			obj.getSecGroupIncludeBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId )
	{
		CFBamSecGroupIncludePKey pkey = schema.getBackingStore().getFactorySecGroupInclude().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupIncludeId( SecGroupIncludeId );
		ICFBamSecGroupIncludeObj obj = readSecGroupInclude( pkey );
		if( obj != null ) {
			ICFBamSecGroupIncludeEditObj editObj = (ICFBamSecGroupIncludeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecGroupIncludeEditObj)obj.beginEdit();
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

	public void deleteSecGroupIncludeByClusterIdx( long ClusterId )
	{
		CFBamSecGroupIncludeByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupIncludeByClusterIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamSecGroupIncludeObj obj;
			List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
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
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFBamSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupIncludeByGroupIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict = indexByGroupIdx.get( key );
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFBamSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamSecGroupIncludeObj obj;
			List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGroupIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		CFBamSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFBamSecGroupIncludeByIncludeIdxKey,
				Map< CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj > >();
		}
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFBamSecGroupIncludePKey, ICFBamSecGroupIncludeObj> dict = indexByIncludeIdx.get( key );
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
			Iterator<ICFBamSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamSecGroupIncludeObj obj;
			List<ICFBamSecGroupIncludeObj> toForget = new LinkedList<ICFBamSecGroupIncludeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIncludeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
		}
	}

	public void deleteSecGroupIncludeByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFBamSecGroupIncludeByUIncludeIdxKey,
				ICFBamSecGroupIncludeObj >();
		}
		CFBamSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactorySecGroupInclude().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFBamSecGroupIncludeObj obj = null;
		if( indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecGroupInclude().deleteSecGroupIncludeByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
		}
	}
}
