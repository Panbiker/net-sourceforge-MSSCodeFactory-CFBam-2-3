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

public class CFBamTSecGroupIncludeTableObj
	implements ICFBamTSecGroupIncludeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> members;
	private Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> allTSecGroupInclude;
	private Map< CFBamTSecGroupIncludeByTenantIdxKey,
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > > indexByTenantIdx;
	private Map< CFBamTSecGroupIncludeByGroupIdxKey,
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > > indexByGroupIdx;
	private Map< CFBamTSecGroupIncludeByIncludeIdxKey,
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > > indexByIncludeIdx;
	private Map< CFBamTSecGroupIncludeByUIncludeIdxKey,
		ICFBamTSecGroupIncludeObj > indexByUIncludeIdx;
	public static String TABLE_NAME = "TSecGroupInclude";
	public static String TABLE_DBNAME = "tsecinc";

	public CFBamTSecGroupIncludeTableObj() {
		schema = null;
		members = new HashMap<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj>();
		allTSecGroupInclude = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
	}

	public CFBamTSecGroupIncludeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj>();
		allTSecGroupInclude = null;
		indexByTenantIdx = null;
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
		allTSecGroupInclude = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
		List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
		ICFBamTSecGroupIncludeObj cur = null;
		Iterator<ICFBamTSecGroupIncludeObj> iter = members.values().iterator();
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
	 *	CFBamTSecGroupIncludeObj.
	 */
	public ICFBamTSecGroupIncludeObj newInstance() {
		ICFBamTSecGroupIncludeObj inst = new CFBamTSecGroupIncludeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTSecGroupIncludeObj.
	 */
	public ICFBamTSecGroupIncludeEditObj newEditInstance( ICFBamTSecGroupIncludeObj orig ) {
		ICFBamTSecGroupIncludeEditObj edit = new CFBamTSecGroupIncludeEditObj( orig );
		return( edit );
	}

	public ICFBamTSecGroupIncludeObj realizeTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj ) {
		ICFBamTSecGroupIncludeObj obj = Obj;
		CFBamTSecGroupIncludePKey pkey = obj.getPKey();
		ICFBamTSecGroupIncludeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTSecGroupIncludeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}
			if( allTSecGroupInclude != null ) {
				allTSecGroupInclude.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGroupInclude != null ) {
				allTSecGroupInclude.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj ) {
		forgetTSecGroupInclude( Obj, false );
	}

	public void forgetTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj, boolean forgetSubObjects ) {
		ICFBamTSecGroupIncludeObj obj = Obj;
		CFBamTSecGroupIncludePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTSecGroupIncludeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupIncludeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupIncludeByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFBamTSecGroupIncludeByIncludeIdxKey keyIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFBamTSecGroupIncludeByUIncludeIdxKey keyUIncludeIdx =
					schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			if( allTSecGroupInclude != null ) {
				allTSecGroupInclude.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId )
	{
		if( members == null ) {
			return;
		}
		CFBamTSecGroupIncludePKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupIncludeId( TSecGroupIncludeId );
		if( members.containsKey( key ) ) {
			ICFBamTSecGroupIncludeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGroupIncludeByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
				ICFBamTSecGroupIncludeObj cur = null;
				Iterator<ICFBamTSecGroupIncludeObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
				ICFBamTSecGroupIncludeObj cur = null;
				Iterator<ICFBamTSecGroupIncludeObj> iter = mapGroupIdx.values().iterator();
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

	public void forgetTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		if( indexByIncludeIdx == null ) {
			return;
		}
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > mapIncludeIdx = indexByIncludeIdx.get( key );
			if( mapIncludeIdx != null ) {
				List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
				ICFBamTSecGroupIncludeObj cur = null;
				Iterator<ICFBamTSecGroupIncludeObj> iter = mapIncludeIdx.values().iterator();
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

	public void forgetTSecGroupIncludeByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			return;
		}
		CFBamTSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByUIncludeIdx.containsKey( key ) ) {
			ICFBamTSecGroupIncludeObj probed = indexByUIncludeIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUIncludeIdx.remove( key );
		}
	}

	public ICFBamTSecGroupIncludeObj createTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj ) {
		ICFBamTSecGroupIncludeObj obj = Obj;
		CFBamTSecGroupIncludeBuff buff = obj.getTSecGroupIncludeBuff();
		schema.getBackingStore().getTableTSecGroupInclude().createTSecGroupInclude(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupInclude( CFBamTSecGroupIncludePKey pkey ) {
		return( readTSecGroupInclude( pkey, false ) );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupInclude( CFBamTSecGroupIncludePKey pkey, boolean forceRead ) {
		ICFBamTSecGroupIncludeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTSecGroupIncludeBuff readBuff = schema.getBackingStore().getTableTSecGroupInclude().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGroupIncludeId() );
			if( readBuff != null ) {
				obj = schema.getTSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupIncludeObj lockTSecGroupInclude( CFBamTSecGroupIncludePKey pkey ) {
		ICFBamTSecGroupIncludeObj locked = null;
		CFBamTSecGroupIncludeBuff lockBuff = schema.getBackingStore().getTableTSecGroupInclude().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGroupIncludeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTSecGroupIncludeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTSecGroupInclude", pkey );
		}
		return( locked );
	}

	public List<ICFBamTSecGroupIncludeObj> readAllTSecGroupInclude() {
		return( readAllTSecGroupInclude( false ) );
	}

	public List<ICFBamTSecGroupIncludeObj> readAllTSecGroupInclude( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGroupInclude";
		if( ( allTSecGroupInclude == null ) || forceRead ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> map = new HashMap<CFBamTSecGroupIncludePKey,ICFBamTSecGroupIncludeObj>();
			allTSecGroupInclude = map;
			CFBamTSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableTSecGroupInclude().readAllDerived( schema.getAuthorization() );
			CFBamTSecGroupIncludeBuff buff;
			ICFBamTSecGroupIncludeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupIncludeObj realized = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupIncludeObj> cmp = new Comparator<ICFBamTSecGroupIncludeObj>() {
			public int compare( ICFBamTSecGroupIncludeObj lhs, ICFBamTSecGroupIncludeObj rhs ) {
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
					CFBamTSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTSecGroupInclude.size();
		ICFBamTSecGroupIncludeObj arr[] = new ICFBamTSecGroupIncludeObj[len];
		Iterator<ICFBamTSecGroupIncludeObj> valIter = allTSecGroupInclude.values().iterator();
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
		ArrayList<ICFBamTSecGroupIncludeObj> arrayList = new ArrayList<ICFBamTSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId )
	{
		return( readTSecGroupIncludeByIdIdx( TenantId,
			TSecGroupIncludeId,
			false ) );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId, boolean forceRead )
	{
		CFBamTSecGroupIncludePKey pkey = schema.getBackingStore().getFactoryTSecGroupInclude().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupIncludeId( TSecGroupIncludeId );
		ICFBamTSecGroupIncludeObj obj = readTSecGroupInclude( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByTenantIdx( long TenantId )
	{
		return( readTSecGroupIncludeByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupIncludeByTenantIdx";
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupIncludeByTenantIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamTSecGroupIncludeObj obj;
			CFBamTSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableTSecGroupInclude().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamTSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupIncludeObj realized = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupIncludeObj> cmp = new Comparator<ICFBamTSecGroupIncludeObj>() {
			public int compare( ICFBamTSecGroupIncludeObj lhs, ICFBamTSecGroupIncludeObj rhs ) {
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
					CFBamTSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupIncludeObj arr[] = new ICFBamTSecGroupIncludeObj[len];
		Iterator<ICFBamTSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupIncludeObj> arrayList = new ArrayList<ICFBamTSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGroupIncludeByGroupIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupIncludeByGroupIdx";
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamTSecGroupIncludeByGroupIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByGroupIdx.put( key, dict );
			ICFBamTSecGroupIncludeObj obj;
			CFBamTSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableTSecGroupInclude().readDerivedByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			CFBamTSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupIncludeObj realized = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupIncludeObj> cmp = new Comparator<ICFBamTSecGroupIncludeObj>() {
			public int compare( ICFBamTSecGroupIncludeObj lhs, ICFBamTSecGroupIncludeObj rhs ) {
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
					CFBamTSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupIncludeObj arr[] = new ICFBamTSecGroupIncludeObj[len];
		Iterator<ICFBamTSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupIncludeObj> arrayList = new ArrayList<ICFBamTSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		return( readTSecGroupIncludeByIncludeIdx( TenantId,
			IncludeGroupId,
			false ) );
	}

	public List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupIncludeByIncludeIdx";
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict;
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFBamTSecGroupIncludeByIncludeIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( ( ! forceRead ) && indexByIncludeIdx.containsKey( key ) ) {
			dict = indexByIncludeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIncludeIdx.put( key, dict );
			ICFBamTSecGroupIncludeObj obj;
			CFBamTSecGroupIncludeBuff[] buffList = schema.getBackingStore().getTableTSecGroupInclude().readDerivedByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
			CFBamTSecGroupIncludeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupIncludeObj realized = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupIncludeObj> cmp = new Comparator<ICFBamTSecGroupIncludeObj>() {
			public int compare( ICFBamTSecGroupIncludeObj lhs, ICFBamTSecGroupIncludeObj rhs ) {
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
					CFBamTSecGroupIncludePKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupIncludePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupIncludeObj arr[] = new ICFBamTSecGroupIncludeObj[len];
		Iterator<ICFBamTSecGroupIncludeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupIncludeObj> arrayList = new ArrayList<ICFBamTSecGroupIncludeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupIncludeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupIncludeByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		return( readTSecGroupIncludeByUIncludeIdx( TenantId,
			TSecGroupId,
			IncludeGroupId,
			false ) );
	}

	public ICFBamTSecGroupIncludeObj readTSecGroupIncludeByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId, boolean forceRead )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFBamTSecGroupIncludeByUIncludeIdxKey,
				ICFBamTSecGroupIncludeObj >();
		}
		CFBamTSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFBamTSecGroupIncludeObj obj = null;
		if( ( ! forceRead ) && indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
		}
		else {
			CFBamTSecGroupIncludeBuff buff = schema.getBackingStore().getTableTSecGroupInclude().readDerivedByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
			if( buff != null ) {
				obj = schema.getTSecGroupIncludeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupInclude().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTSecGroupIncludeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUIncludeIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupIncludeObj updateTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj ) {
		ICFBamTSecGroupIncludeObj obj = Obj;
		schema.getBackingStore().getTableTSecGroupInclude().updateTSecGroupInclude( schema.getAuthorization(),
			Obj.getTSecGroupIncludeBuff() );
		obj = (ICFBamTSecGroupIncludeObj)Obj.realize();
		return( obj );
	}

	public void deleteTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj ) {
		ICFBamTSecGroupIncludeObj obj = Obj;
		schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupInclude( schema.getAuthorization(),
			obj.getTSecGroupIncludeBuff() );
		obj.forget( true );
	}

	public void deleteTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId )
	{
		CFBamTSecGroupIncludePKey pkey = schema.getBackingStore().getFactoryTSecGroupInclude().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupIncludeId( TSecGroupIncludeId );
		ICFBamTSecGroupIncludeObj obj = readTSecGroupInclude( pkey );
		if( obj != null ) {
			ICFBamTSecGroupIncludeEditObj editObj = (ICFBamTSecGroupIncludeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTSecGroupIncludeEditObj)obj.beginEdit();
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

	public void deleteTSecGroupIncludeByTenantIdx( long TenantId )
	{
		CFBamTSecGroupIncludeByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupIncludeByTenantIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamTSecGroupIncludeObj obj;
			List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
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
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		CFBamTSecGroupIncludeByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamTSecGroupIncludeByGroupIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict = indexByGroupIdx.get( key );
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			Iterator<ICFBamTSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamTSecGroupIncludeObj obj;
			List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
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
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
		}
	}

	public void deleteTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		CFBamTSecGroupIncludeByIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFBamTSecGroupIncludeByIncludeIdxKey,
				Map< CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj > >();
		}
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupIncludePKey, ICFBamTSecGroupIncludeObj> dict = indexByIncludeIdx.get( key );
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
			Iterator<ICFBamTSecGroupIncludeObj> iter = dict.values().iterator();
			ICFBamTSecGroupIncludeObj obj;
			List<ICFBamTSecGroupIncludeObj> toForget = new LinkedList<ICFBamTSecGroupIncludeObj>();
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
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
		}
	}

	public void deleteTSecGroupIncludeByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFBamTSecGroupIncludeByUIncludeIdxKey,
				ICFBamTSecGroupIncludeObj >();
		}
		CFBamTSecGroupIncludeByUIncludeIdxKey key = schema.getBackingStore().getFactoryTSecGroupInclude().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFBamTSecGroupIncludeObj obj = null;
		if( indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTSecGroupInclude().deleteTSecGroupIncludeByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
		}
	}
}
