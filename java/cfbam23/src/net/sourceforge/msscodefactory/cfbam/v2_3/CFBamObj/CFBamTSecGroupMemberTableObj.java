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

public class CFBamTSecGroupMemberTableObj
	implements ICFBamTSecGroupMemberTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> members;
	private Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> allTSecGroupMember;
	private Map< CFBamTSecGroupMemberByTenantIdxKey,
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > > indexByTenantIdx;
	private Map< CFBamTSecGroupMemberByGroupIdxKey,
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > > indexByGroupIdx;
	private Map< CFBamTSecGroupMemberByUserIdxKey,
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > > indexByUserIdx;
	private Map< CFBamTSecGroupMemberByUUserIdxKey,
		ICFBamTSecGroupMemberObj > indexByUUserIdx;
	public static String TABLE_NAME = "TSecGroupMember";
	public static String TABLE_DBNAME = "tsecmemb";

	public CFBamTSecGroupMemberTableObj() {
		schema = null;
		members = new HashMap<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj>();
		allTSecGroupMember = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFBamTSecGroupMemberTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj>();
		allTSecGroupMember = null;
		indexByTenantIdx = null;
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
		allTSecGroupMember = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
		ICFBamTSecGroupMemberObj cur = null;
		Iterator<ICFBamTSecGroupMemberObj> iter = members.values().iterator();
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
	 *	CFBamTSecGroupMemberObj.
	 */
	public ICFBamTSecGroupMemberObj newInstance() {
		ICFBamTSecGroupMemberObj inst = new CFBamTSecGroupMemberObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTSecGroupMemberObj.
	 */
	public ICFBamTSecGroupMemberEditObj newEditInstance( ICFBamTSecGroupMemberObj orig ) {
		ICFBamTSecGroupMemberEditObj edit = new CFBamTSecGroupMemberEditObj( orig );
		return( edit );
	}

	public ICFBamTSecGroupMemberObj realizeTSecGroupMember( ICFBamTSecGroupMemberObj Obj ) {
		ICFBamTSecGroupMemberObj obj = Obj;
		CFBamTSecGroupMemberPKey pkey = obj.getPKey();
		ICFBamTSecGroupMemberObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTSecGroupMemberObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamTSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamTSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}
			if( allTSecGroupMember != null ) {
				allTSecGroupMember.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGroupMember != null ) {
				allTSecGroupMember.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamTSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTSecGroupMember( ICFBamTSecGroupMemberObj Obj ) {
		forgetTSecGroupMember( Obj, false );
	}

	public void forgetTSecGroupMember( ICFBamTSecGroupMemberObj Obj, boolean forgetSubObjects ) {
		ICFBamTSecGroupMemberObj obj = Obj;
		CFBamTSecGroupMemberPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTSecGroupMemberObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamTSecGroupMemberByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamTSecGroupMemberByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUserIdx != null ) {
				CFBamTSecGroupMemberByUserIdxKey keyUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUUserIdx != null ) {
				CFBamTSecGroupMemberByUUserIdxKey keyUUserIdx =
					schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			if( allTSecGroupMember != null ) {
				allTSecGroupMember.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId )
	{
		if( members == null ) {
			return;
		}
		CFBamTSecGroupMemberPKey key = schema.getBackingStore().getFactoryTSecGroupMember().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupMemberId( TSecGroupMemberId );
		if( members.containsKey( key ) ) {
			ICFBamTSecGroupMemberObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGroupMemberByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
				ICFBamTSecGroupMemberObj cur = null;
				Iterator<ICFBamTSecGroupMemberObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
				ICFBamTSecGroupMemberObj cur = null;
				Iterator<ICFBamTSecGroupMemberObj> iter = mapGroupIdx.values().iterator();
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

	public void forgetTSecGroupMemberByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		CFBamTSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
				ICFBamTSecGroupMemberObj cur = null;
				Iterator<ICFBamTSecGroupMemberObj> iter = mapUserIdx.values().iterator();
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

	public void forgetTSecGroupMemberByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			return;
		}
		CFBamTSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			ICFBamTSecGroupMemberObj probed = indexByUUserIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUUserIdx.remove( key );
		}
	}

	public ICFBamTSecGroupMemberObj createTSecGroupMember( ICFBamTSecGroupMemberObj Obj ) {
		ICFBamTSecGroupMemberObj obj = Obj;
		CFBamTSecGroupMemberBuff buff = obj.getTSecGroupMemberBuff();
		schema.getBackingStore().getTableTSecGroupMember().createTSecGroupMember(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMember( CFBamTSecGroupMemberPKey pkey ) {
		return( readTSecGroupMember( pkey, false ) );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMember( CFBamTSecGroupMemberPKey pkey, boolean forceRead ) {
		ICFBamTSecGroupMemberObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTSecGroupMemberBuff readBuff = schema.getBackingStore().getTableTSecGroupMember().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGroupMemberId() );
			if( readBuff != null ) {
				obj = schema.getTSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTSecGroupMemberObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupMemberObj lockTSecGroupMember( CFBamTSecGroupMemberPKey pkey ) {
		ICFBamTSecGroupMemberObj locked = null;
		CFBamTSecGroupMemberBuff lockBuff = schema.getBackingStore().getTableTSecGroupMember().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGroupMemberTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTSecGroupMemberObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTSecGroupMember", pkey );
		}
		return( locked );
	}

	public List<ICFBamTSecGroupMemberObj> readAllTSecGroupMember() {
		return( readAllTSecGroupMember( false ) );
	}

	public List<ICFBamTSecGroupMemberObj> readAllTSecGroupMember( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGroupMember";
		if( ( allTSecGroupMember == null ) || forceRead ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> map = new HashMap<CFBamTSecGroupMemberPKey,ICFBamTSecGroupMemberObj>();
			allTSecGroupMember = map;
			CFBamTSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableTSecGroupMember().readAllDerived( schema.getAuthorization() );
			CFBamTSecGroupMemberBuff buff;
			ICFBamTSecGroupMemberObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupMemberObj realized = (ICFBamTSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupMemberObj> cmp = new Comparator<ICFBamTSecGroupMemberObj>() {
			public int compare( ICFBamTSecGroupMemberObj lhs, ICFBamTSecGroupMemberObj rhs ) {
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
					CFBamTSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTSecGroupMember.size();
		ICFBamTSecGroupMemberObj arr[] = new ICFBamTSecGroupMemberObj[len];
		Iterator<ICFBamTSecGroupMemberObj> valIter = allTSecGroupMember.values().iterator();
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
		ArrayList<ICFBamTSecGroupMemberObj> arrayList = new ArrayList<ICFBamTSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId )
	{
		return( readTSecGroupMemberByIdIdx( TenantId,
			TSecGroupMemberId,
			false ) );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId, boolean forceRead )
	{
		CFBamTSecGroupMemberPKey pkey = schema.getBackingStore().getFactoryTSecGroupMember().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupMemberId( TSecGroupMemberId );
		ICFBamTSecGroupMemberObj obj = readTSecGroupMember( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByTenantIdx( long TenantId )
	{
		return( readTSecGroupMemberByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupMemberByTenantIdx";
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupMemberByTenantIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamTSecGroupMemberObj obj;
			CFBamTSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableTSecGroupMember().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamTSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupMemberObj realized = (ICFBamTSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupMemberObj> cmp = new Comparator<ICFBamTSecGroupMemberObj>() {
			public int compare( ICFBamTSecGroupMemberObj lhs, ICFBamTSecGroupMemberObj rhs ) {
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
					CFBamTSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupMemberObj arr[] = new ICFBamTSecGroupMemberObj[len];
		Iterator<ICFBamTSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupMemberObj> arrayList = new ArrayList<ICFBamTSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGroupMemberByGroupIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupMemberByGroupIdx";
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamTSecGroupMemberByGroupIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByGroupIdx.put( key, dict );
			ICFBamTSecGroupMemberObj obj;
			CFBamTSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableTSecGroupMember().readDerivedByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			CFBamTSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupMemberObj realized = (ICFBamTSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupMemberObj> cmp = new Comparator<ICFBamTSecGroupMemberObj>() {
			public int compare( ICFBamTSecGroupMemberObj lhs, ICFBamTSecGroupMemberObj rhs ) {
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
					CFBamTSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupMemberObj arr[] = new ICFBamTSecGroupMemberObj[len];
		Iterator<ICFBamTSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupMemberObj> arrayList = new ArrayList<ICFBamTSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByUserIdx( UUID SecUserId )
	{
		return( readTSecGroupMemberByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupMemberByUserIdx";
		CFBamTSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamTSecGroupMemberByUserIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj>();
			// Allow other threads to dirty-read while we're loading
			indexByUserIdx.put( key, dict );
			ICFBamTSecGroupMemberObj obj;
			CFBamTSecGroupMemberBuff[] buffList = schema.getBackingStore().getTableTSecGroupMember().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFBamTSecGroupMemberBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( buff );
				ICFBamTSecGroupMemberObj realized = (ICFBamTSecGroupMemberObj)obj.realize();
			}
		}
		Comparator<ICFBamTSecGroupMemberObj> cmp = new Comparator<ICFBamTSecGroupMemberObj>() {
			public int compare( ICFBamTSecGroupMemberObj lhs, ICFBamTSecGroupMemberObj rhs ) {
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
					CFBamTSecGroupMemberPKey lhsPKey = lhs.getPKey();
					CFBamTSecGroupMemberPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTSecGroupMemberObj arr[] = new ICFBamTSecGroupMemberObj[len];
		Iterator<ICFBamTSecGroupMemberObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTSecGroupMemberObj> arrayList = new ArrayList<ICFBamTSecGroupMemberObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTSecGroupMemberObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMemberByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		return( readTSecGroupMemberByUUserIdx( TenantId,
			TSecGroupId,
			SecUserId,
			false ) );
	}

	public ICFBamTSecGroupMemberObj readTSecGroupMemberByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFBamTSecGroupMemberByUUserIdxKey,
				ICFBamTSecGroupMemberObj >();
		}
		CFBamTSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFBamTSecGroupMemberObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFBamTSecGroupMemberBuff buff = schema.getBackingStore().getTableTSecGroupMember().readDerivedByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getTSecGroupMemberTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryTSecGroupMember().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTSecGroupMemberObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUUserIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTSecGroupMemberObj updateTSecGroupMember( ICFBamTSecGroupMemberObj Obj ) {
		ICFBamTSecGroupMemberObj obj = Obj;
		schema.getBackingStore().getTableTSecGroupMember().updateTSecGroupMember( schema.getAuthorization(),
			Obj.getTSecGroupMemberBuff() );
		obj = (ICFBamTSecGroupMemberObj)Obj.realize();
		return( obj );
	}

	public void deleteTSecGroupMember( ICFBamTSecGroupMemberObj Obj ) {
		ICFBamTSecGroupMemberObj obj = Obj;
		schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMember( schema.getAuthorization(),
			obj.getTSecGroupMemberBuff() );
		obj.forget( true );
	}

	public void deleteTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId )
	{
		CFBamTSecGroupMemberPKey pkey = schema.getBackingStore().getFactoryTSecGroupMember().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupMemberId( TSecGroupMemberId );
		ICFBamTSecGroupMemberObj obj = readTSecGroupMember( pkey );
		if( obj != null ) {
			ICFBamTSecGroupMemberEditObj editObj = (ICFBamTSecGroupMemberEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTSecGroupMemberEditObj)obj.beginEdit();
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

	public void deleteTSecGroupMemberByTenantIdx( long TenantId )
	{
		CFBamTSecGroupMemberByTenantIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamTSecGroupMemberByTenantIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamTSecGroupMemberObj obj;
			List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
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
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		CFBamTSecGroupMemberByGroupIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamTSecGroupMemberByGroupIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict = indexByGroupIdx.get( key );
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			Iterator<ICFBamTSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamTSecGroupMemberObj obj;
			List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
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
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
		}
	}

	public void deleteTSecGroupMemberByUserIdx( UUID SecUserId )
	{
		CFBamTSecGroupMemberByUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFBamTSecGroupMemberByUserIdxKey,
				Map< CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFBamTSecGroupMemberPKey, ICFBamTSecGroupMemberObj> dict = indexByUserIdx.get( key );
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFBamTSecGroupMemberObj> iter = dict.values().iterator();
			ICFBamTSecGroupMemberObj obj;
			List<ICFBamTSecGroupMemberObj> toForget = new LinkedList<ICFBamTSecGroupMemberObj>();
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
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteTSecGroupMemberByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFBamTSecGroupMemberByUUserIdxKey,
				ICFBamTSecGroupMemberObj >();
		}
		CFBamTSecGroupMemberByUUserIdxKey key = schema.getBackingStore().getFactoryTSecGroupMember().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFBamTSecGroupMemberObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTSecGroupMember().deleteTSecGroupMemberByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
		}
	}
}
