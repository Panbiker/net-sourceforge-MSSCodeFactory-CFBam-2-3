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

public class CFBamSecGroupMemberTableObj
	implements ICFBamSecGroupMemberTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> members;
	private Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> allSecGroupMember;
	private Map< CFBamSecGroupMemberByClusterIdxKey,
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > > indexByClusterIdx;
	private Map< CFBamSecGroupMemberByGroupIdxKey,
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > > indexByGroupIdx;
	private Map< CFBamSecGroupMemberByUserIdxKey,
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > > indexByUserIdx;
	private Map< CFBamSecGroupMemberByUUserIdxKey,
		ICFBamSecGroupMemberObj > indexByUUserIdx;
	public static String TABLE_NAME = "SecGroupMember";
	public static String TABLE_DBNAME = "secmemb";

	public CFBamSecGroupMemberTableObj() {
		schema = null;
		members = new HashMap<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj>();
		allSecGroupMember = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFBamSecGroupMemberTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj>();
		allSecGroupMember = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
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
		allSecGroupMember = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
		ICFBamSecGroupMemberObj cur = null;
		Iterator<ICFBamSecGroupMemberObj> iter = members.values().iterator();
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
	 *	CFBamSecGroupMemberObj.
	 */
	public ICFBamSecGroupMemberObj newInstance() {
		ICFBamSecGroupMemberObj inst = new CFBamSecGroupMemberObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecGroupMemberObj.
	 */
	public ICFBamSecGroupMemberEditObj newEditInstance( ICFBamSecGroupMemberObj orig ) {
		ICFBamSecGroupMemberEditObj edit = new CFBamSecGroupMemberEditObj( orig );
		return( edit );
	}

	public ICFBamSecGroupMemberObj realizeSecGroupMember( ICFBamSecGroupMemberObj Obj ) {
		ICFBamSecGroupMemberObj obj = Obj;
		CFBamSecGroupMemberPKey pkey = obj.getPKey();
		ICFBamSecGroupMemberObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecGroupMemberObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecGroupMemberByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecGroupMemberByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}
			if( allSecGroupMember != null ) {
				allSecGroupMember.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroupMember != null ) {
				allSecGroupMember.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecGroupMemberByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecGroupMember( ICFBamSecGroupMemberObj Obj ) {
		forgetSecGroupMember( Obj, false );
	}

	public void forgetSecGroupMember( ICFBamSecGroupMemberObj Obj, boolean forgetSubObjects ) {
		ICFBamSecGroupMemberObj obj = Obj;
		CFBamSecGroupMemberPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecGroupMemberObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecGroupMemberByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			if( allSecGroupMember != null ) {
				allSecGroupMember.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecGroupMemberPKey key = schema.getBackingStore().getFactorySecGroupMember().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupMemberId( SecGroupMemberId );
		if( members.containsKey( key ) ) {
			ICFBamSecGroupMemberObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupMemberByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecGroupMemberByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
				ICFBamSecGroupMemberObj cur = null;
				Iterator<ICFBamSecGroupMemberObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		CFBamSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
				ICFBamSecGroupMemberObj cur = null;
				Iterator<ICFBamSecGroupMemberObj> iter = mapGroupIdx.values().iterator();
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

	public void forgetSecGroupMemberByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		CFBamSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
				ICFBamSecGroupMemberObj cur = null;
				Iterator<ICFBamSecGroupMemberObj> iter = mapUserIdx.values().iterator();
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

			indexByUserIdx.remove( key );
		}
	}

	public void forgetSecGroupMemberByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			return;
		}
		CFBamSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			ICFBamSecGroupMemberObj probed = indexByUUserIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUUserIdx.remove( key );
		}
	}

	public ICFBamSecGroupMemberObj createSecGroupMember( ICFBamSecGroupMemberObj Obj ) {
		ICFBamSecGroupMemberObj obj = Obj;
		CFBamSecGroupMemberBuff buff = obj.getSecGroupMemberBuff();
		schema.getBackingStore().getTableSecGroupMember().createSecGroupMember(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecGroupMemberObj readSecGroupMember( CFBamSecGroupMemberPKey pkey ) {
		return( readSecGroupMember( pkey, false ) );
	}

	public ICFBamSecGroupMemberObj readSecGroupMember( CFBamSecGroupMemberPKey pkey, boolean forceRead ) {
		ICFBamSecGroupMemberObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecGroupMemberBuff readBuff = schema.getBackingStore().getTableSecGroupMember().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupMemberId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecGroupMemberObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupMemberObj lockSecGroupMember( CFBamSecGroupMemberPKey pkey ) {
		ICFBamSecGroupMemberObj locked = null;
		CFBamSecGroupMemberBuff lockBuff = schema.getBackingStore().getTableSecGroupMember().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupMemberTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecGroupMemberObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecGroupMember", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecGroupMemberObj> readAllSecGroupMember() {
		return( readAllSecGroupMember( false ) );
	}

	public List<ICFBamSecGroupMemberObj> readAllSecGroupMember( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroupMember";
		if( ( allSecGroupMember == null ) || forceRead ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> map = new HashMap<CFBamSecGroupMemberPKey,ICFBamSecGroupMemberObj>();
			allSecGroupMember = map;
			CFBamSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableSecGroupMember().readAllDerived( schema.getAuthorization() );
			CFBamSecGroupMemberBuff buff;
			ICFBamSecGroupMemberObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupMemberObj realized = (ICFBamSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupMemberObj> cmp = new Comparator<ICFBamSecGroupMemberObj>() {
			public int compare( ICFBamSecGroupMemberObj lhs, ICFBamSecGroupMemberObj rhs ) {
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
					CFBamSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecGroupMember.size();
		ICFBamSecGroupMemberObj arr[] = new ICFBamSecGroupMemberObj[len];
		Iterator<ICFBamSecGroupMemberObj> valIter = allSecGroupMember.values().iterator();
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
		ArrayList<ICFBamSecGroupMemberObj> arrayList = new ArrayList<ICFBamSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupMemberObj readSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId )
	{
		return( readSecGroupMemberByIdIdx( ClusterId,
			SecGroupMemberId,
			false ) );
	}

	public ICFBamSecGroupMemberObj readSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId, boolean forceRead )
	{
		CFBamSecGroupMemberPKey pkey = schema.getBackingStore().getFactorySecGroupMember().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupMemberId( SecGroupMemberId );
		ICFBamSecGroupMemberObj obj = readSecGroupMember( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByClusterIdx( long ClusterId )
	{
		return( readSecGroupMemberByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupMemberByClusterIdx";
		CFBamSecGroupMemberByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupMemberByClusterIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecGroupMemberObj obj;
			CFBamSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableSecGroupMember().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupMemberObj realized = (ICFBamSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupMemberObj> cmp = new Comparator<ICFBamSecGroupMemberObj>() {
			public int compare( ICFBamSecGroupMemberObj lhs, ICFBamSecGroupMemberObj rhs ) {
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
					CFBamSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupMemberObj arr[] = new ICFBamSecGroupMemberObj[len];
		Iterator<ICFBamSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupMemberObj> arrayList = new ArrayList<ICFBamSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupMemberByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupMemberByGroupIdx";
		CFBamSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupMemberByGroupIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByGroupIdx.put( key, dict );
			ICFBamSecGroupMemberObj obj;
			CFBamSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableSecGroupMember().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFBamSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupMemberObj realized = (ICFBamSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupMemberObj> cmp = new Comparator<ICFBamSecGroupMemberObj>() {
			public int compare( ICFBamSecGroupMemberObj lhs, ICFBamSecGroupMemberObj rhs ) {
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
					CFBamSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupMemberObj arr[] = new ICFBamSecGroupMemberObj[len];
		Iterator<ICFBamSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupMemberObj> arrayList = new ArrayList<ICFBamSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByUserIdx( UUID SecUserId )
	{
		return( readSecGroupMemberByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFBamSecGroupMemberObj> readSecGroupMemberByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupMemberByUserIdx";
		CFBamSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamSecGroupMemberByUserIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByUserIdx.put( key, dict );
			ICFBamSecGroupMemberObj obj;
			CFBamSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableSecGroupMember().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFBamSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupMemberObj realized = (ICFBamSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupMemberObj> cmp = new Comparator<ICFBamSecGroupMemberObj>() {
			public int compare( ICFBamSecGroupMemberObj lhs, ICFBamSecGroupMemberObj rhs ) {
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
					CFBamSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupMemberObj arr[] = new ICFBamSecGroupMemberObj[len];
		Iterator<ICFBamSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupMemberObj> arrayList = new ArrayList<ICFBamSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupMemberObj readSecGroupMemberByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		return( readSecGroupMemberByUUserIdx( ClusterId,
			SecGroupId,
			SecUserId,
			false ) );
	}

	public ICFBamSecGroupMemberObj readSecGroupMemberByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFBamSecGroupMemberByUUserIdxKey,
				ICFBamSecGroupMemberObj >();
		}
		CFBamSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFBamSecGroupMemberObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFBamSecGroupMemberBuff buff = schema.getBackingStore().getTableSecGroupMember().readDerivedByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupMember().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecGroupMemberObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUUserIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupMemberObj updateSecGroupMember( ICFBamSecGroupMemberObj Obj ) {
		ICFBamSecGroupMemberObj obj = Obj;
		schema.getBackingStore().getTableSecGroupMember().updateSecGroupMember( schema.getAuthorization(),
			Obj.getSecGroupMemberBuff() );
		obj = (ICFBamSecGroupMemberObj)Obj.realize();
		return( obj );
	}

	public void deleteSecGroupMember( ICFBamSecGroupMemberObj Obj ) {
		ICFBamSecGroupMemberObj obj = Obj;
		schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMember( schema.getAuthorization(),
			obj.getSecGroupMemberBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId )
	{
		CFBamSecGroupMemberPKey pkey = schema.getBackingStore().getFactorySecGroupMember().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupMemberId( SecGroupMemberId );
		ICFBamSecGroupMemberObj obj = readSecGroupMember( pkey );
		if( obj != null ) {
			ICFBamSecGroupMemberEditObj editObj = (ICFBamSecGroupMemberEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecGroupMemberEditObj)obj.beginEdit();
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

	public void deleteSecGroupMemberByClusterIdx( long ClusterId )
	{
		CFBamSecGroupMemberByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupMemberByClusterIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamSecGroupMemberObj obj;
			List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
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
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFBamSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupMemberByGroupIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict = indexByGroupIdx.get( key );
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFBamSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamSecGroupMemberObj obj;
			List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
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
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGroupMemberByUserIdx( UUID SecUserId )
	{
		CFBamSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamSecGroupMemberByUserIdxKey,
				Map< CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamSecGroupMemberPKey, ICFBamSecGroupMemberObj> dict = indexByUserIdx.get( key );
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFBamSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamSecGroupMemberObj obj;
			List<ICFBamSecGroupMemberObj> toForget = new LinkedList<ICFBamSecGroupMemberObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByUserIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteSecGroupMemberByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFBamSecGroupMemberByUUserIdxKey,
				ICFBamSecGroupMemberObj >();
		}
		CFBamSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactorySecGroupMember().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFBamSecGroupMemberObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecGroupMember().deleteSecGroupMemberByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
		}
	}
}
