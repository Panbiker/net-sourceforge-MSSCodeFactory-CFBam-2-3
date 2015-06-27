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

public class CFBamSecUserTableObj
	implements ICFBamSecUserTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecUserPKey, ICFBamSecUserObj> members;
	private Map<CFBamSecUserPKey, ICFBamSecUserObj> allSecUser;
	private Map< CFBamSecUserByULoginIdxKey,
		ICFBamSecUserObj > indexByULoginIdx;
	private Map< CFBamSecUserByEMConfIdxKey,
		Map<CFBamSecUserPKey, ICFBamSecUserObj > > indexByEMConfIdx;
	private Map< CFBamSecUserByPwdResetIdxKey,
		Map<CFBamSecUserPKey, ICFBamSecUserObj > > indexByPwdResetIdx;
	private Map< CFBamSecUserByDefDevIdxKey,
		ICFBamSecUserObj > indexByDefDevIdx;
	public static String TABLE_NAME = "SecUser";
	public static String TABLE_DBNAME = "secuser";

	public CFBamSecUserTableObj() {
		schema = null;
		members = new HashMap<CFBamSecUserPKey, ICFBamSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
	}

	public CFBamSecUserTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecUserPKey, ICFBamSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
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
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
		List<ICFBamSecUserObj> toForget = new LinkedList<ICFBamSecUserObj>();
		ICFBamSecUserObj cur = null;
		Iterator<ICFBamSecUserObj> iter = members.values().iterator();
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
	 *	CFBamSecUserObj.
	 */
	public ICFBamSecUserObj newInstance() {
		ICFBamSecUserObj inst = new CFBamSecUserObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecUserObj.
	 */
	public ICFBamSecUserEditObj newEditInstance( ICFBamSecUserObj orig ) {
		ICFBamSecUserEditObj edit = new CFBamSecUserEditObj( orig );
		return( edit );
	}

	public ICFBamSecUserObj realizeSecUser( ICFBamSecUserObj Obj ) {
		ICFBamSecUserObj obj = Obj;
		CFBamSecUserPKey pkey = obj.getPKey();
		ICFBamSecUserObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecUserObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByULoginIdx != null ) {
				CFBamSecUserByULoginIdxKey keyULoginIdx =
					schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.remove( keyULoginIdx );
			}

			if( indexByEMConfIdx != null ) {
				CFBamSecUserByEMConfIdxKey keyEMConfIdx =
					schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmationUuid( keepObj.getOptionalEMailConfirmationUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFBamSecUserByPwdResetIdxKey keyPwdResetIdx =
					schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFBamSecUserByDefDevIdxKey keyDefDevIdx =
					schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDefaultDevSecUserId( keepObj.getOptionalDefaultDevSecUserId() );
				keyDefDevIdx.setOptionalDefaultDevName( keepObj.getOptionalDefaultDevName() );
				indexByDefDevIdx.remove( keyDefDevIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByULoginIdx != null ) {
				CFBamSecUserByULoginIdxKey keyULoginIdx =
					schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMConfIdx != null ) {
				CFBamSecUserByEMConfIdxKey keyEMConfIdx =
					schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmationUuid( keepObj.getOptionalEMailConfirmationUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFBamSecUserByPwdResetIdxKey keyPwdResetIdx =
					schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFBamSecUserByDefDevIdxKey keyDefDevIdx =
					schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDefaultDevSecUserId( keepObj.getOptionalDefaultDevSecUserId() );
				keyDefDevIdx.setOptionalDefaultDevName( keepObj.getOptionalDefaultDevName() );
				indexByDefDevIdx.put( keyDefDevIdx, keepObj );
			}
			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}

			if( indexByULoginIdx != null ) {
				CFBamSecUserByULoginIdxKey keyULoginIdx =
					schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMConfIdx != null ) {
				CFBamSecUserByEMConfIdxKey keyEMConfIdx =
					schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmationUuid( keepObj.getOptionalEMailConfirmationUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFBamSecUserByPwdResetIdxKey keyPwdResetIdx =
					schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFBamSecUserByDefDevIdxKey keyDefDevIdx =
					schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDefaultDevSecUserId( keepObj.getOptionalDefaultDevSecUserId() );
				keyDefDevIdx.setOptionalDefaultDevName( keepObj.getOptionalDefaultDevName() );
				indexByDefDevIdx.put( keyDefDevIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecUser( ICFBamSecUserObj Obj ) {
		forgetSecUser( Obj, false );
	}

	public void forgetSecUser( ICFBamSecUserObj Obj, boolean forgetSubObjects ) {
		ICFBamSecUserObj obj = Obj;
		CFBamSecUserPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecUserObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByULoginIdx != null ) {
				CFBamSecUserByULoginIdxKey keyULoginIdx =
					schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.remove( keyULoginIdx );
			}

			if( indexByEMConfIdx != null ) {
				CFBamSecUserByEMConfIdxKey keyEMConfIdx =
					schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmationUuid( keepObj.getOptionalEMailConfirmationUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFBamSecUserByPwdResetIdxKey keyPwdResetIdx =
					schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFBamSecUserPKey, ICFBamSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFBamSecUserByDefDevIdxKey keyDefDevIdx =
					schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDefaultDevSecUserId( keepObj.getOptionalDefaultDevSecUserId() );
				keyDefDevIdx.setOptionalDefaultDevName( keepObj.getOptionalDefaultDevName() );
				indexByDefDevIdx.remove( keyDefDevIdx );
			}

			if( allSecUser != null ) {
				allSecUser.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getSecDeviceTableObj().forgetSecDeviceByUserIdx( keepObj.getRequiredSecUserId() );
				schema.getSecSessionTableObj().forgetSecSessionBySecUserIdx( keepObj.getRequiredSecUserId() );
				schema.getSecSessionTableObj().forgetSecSessionBySecProxyIdx( keepObj.getRequiredSecUserId() );
				schema.getSecGroupMemberTableObj().forgetSecGroupMemberByUserIdx( keepObj.getRequiredSecUserId() );
				schema.getTSecGroupMemberTableObj().forgetTSecGroupMemberByUserIdx( keepObj.getRequiredSecUserId() );
			}
		}
	}

	public void forgetSecUserByIdIdx( UUID SecUserId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecUserPKey key = schema.getBackingStore().getFactorySecUser().newPKey();
		key.setRequiredSecUserId( SecUserId );
		if( members.containsKey( key ) ) {
			ICFBamSecUserObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecUserByULoginIdx( String LoginId )
	{
		if( indexByULoginIdx == null ) {
			return;
		}
		CFBamSecUserByULoginIdxKey key = schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByULoginIdx.containsKey( key ) ) {
			ICFBamSecUserObj probed = indexByULoginIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByULoginIdx.remove( key );
		}
	}

	public void forgetSecUserByEMConfIdx( UUID EMailConfirmationUuid )
	{
		if( indexByEMConfIdx == null ) {
			return;
		}
		CFBamSecUserByEMConfIdxKey key = schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( EMailConfirmationUuid );
		if( indexByEMConfIdx.containsKey( key ) ) {
			Map<CFBamSecUserPKey, ICFBamSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( key );
			if( mapEMConfIdx != null ) {
				List<ICFBamSecUserObj> toForget = new LinkedList<ICFBamSecUserObj>();
				ICFBamSecUserObj cur = null;
				Iterator<ICFBamSecUserObj> iter = mapEMConfIdx.values().iterator();
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

			indexByEMConfIdx.remove( key );
		}
	}

	public void forgetSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		if( indexByPwdResetIdx == null ) {
			return;
		}
		CFBamSecUserByPwdResetIdxKey key = schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		if( indexByPwdResetIdx.containsKey( key ) ) {
			Map<CFBamSecUserPKey, ICFBamSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( key );
			if( mapPwdResetIdx != null ) {
				List<ICFBamSecUserObj> toForget = new LinkedList<ICFBamSecUserObj>();
				ICFBamSecUserObj cur = null;
				Iterator<ICFBamSecUserObj> iter = mapPwdResetIdx.values().iterator();
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

			indexByPwdResetIdx.remove( key );
		}
	}

	public void forgetSecUserByDefDevIdx( UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		if( indexByDefDevIdx == null ) {
			return;
		}
		CFBamSecUserByDefDevIdxKey key = schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDefaultDevSecUserId( DefaultDevSecUserId );
		key.setOptionalDefaultDevName( DefaultDevName );
		if( indexByDefDevIdx.containsKey( key ) ) {
			ICFBamSecUserObj probed = indexByDefDevIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByDefDevIdx.remove( key );
		}
	}

	public ICFBamSecUserObj createSecUser( ICFBamSecUserObj Obj ) {
		ICFBamSecUserObj obj = Obj;
		CFBamSecUserBuff buff = obj.getSecUserBuff();
		schema.getBackingStore().getTableSecUser().createSecUser(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecUserObj readSecUser( CFBamSecUserPKey pkey ) {
		return( readSecUser( pkey, false ) );
	}

	public ICFBamSecUserObj readSecUser( CFBamSecUserPKey pkey, boolean forceRead ) {
		ICFBamSecUserObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecUserBuff readBuff = schema.getBackingStore().getTableSecUser().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecUserId() );
			if( readBuff != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecUserObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecUserObj lockSecUser( CFBamSecUserPKey pkey ) {
		ICFBamSecUserObj locked = null;
		CFBamSecUserBuff lockBuff = schema.getBackingStore().getTableSecUser().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecUserTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecUserObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecUser", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecUserObj> readAllSecUser() {
		return( readAllSecUser( false ) );
	}

	public List<ICFBamSecUserObj> readAllSecUser( boolean forceRead ) {
		final String S_ProcName = "readAllSecUser";
		if( ( allSecUser == null ) || forceRead ) {
			Map<CFBamSecUserPKey, ICFBamSecUserObj> map = new HashMap<CFBamSecUserPKey,ICFBamSecUserObj>();
			allSecUser = map;
			CFBamSecUserBuff[] buffList = schema.getBackingStore().getTableSecUser().readAllDerived( schema.getAuthorization() );
			CFBamSecUserBuff buff;
			ICFBamSecUserObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFBamSecUserObj realized = (ICFBamSecUserObj)obj.realize();
			}
		}
		Comparator<ICFBamSecUserObj> cmp = new Comparator<ICFBamSecUserObj>() {
			public int compare( ICFBamSecUserObj lhs, ICFBamSecUserObj rhs ) {
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
					CFBamSecUserPKey lhsPKey = lhs.getPKey();
					CFBamSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecUser.size();
		ICFBamSecUserObj arr[] = new ICFBamSecUserObj[len];
		Iterator<ICFBamSecUserObj> valIter = allSecUser.values().iterator();
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
		ArrayList<ICFBamSecUserObj> arrayList = new ArrayList<ICFBamSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecUserObj readSecUserByIdIdx( UUID SecUserId )
	{
		return( readSecUserByIdIdx( SecUserId,
			false ) );
	}

	public ICFBamSecUserObj readSecUserByIdIdx( UUID SecUserId, boolean forceRead )
	{
		CFBamSecUserPKey pkey = schema.getBackingStore().getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		ICFBamSecUserObj obj = readSecUser( pkey, forceRead );
		return( obj );
	}

	public ICFBamSecUserObj readSecUserByULoginIdx( String LoginId )
	{
		return( readSecUserByULoginIdx( LoginId,
			false ) );
	}

	public ICFBamSecUserObj readSecUserByULoginIdx( String LoginId, boolean forceRead )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< CFBamSecUserByULoginIdxKey,
				ICFBamSecUserObj >();
		}
		CFBamSecUserByULoginIdxKey key = schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ICFBamSecUserObj obj = null;
		if( ( ! forceRead ) && indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
		}
		else {
			CFBamSecUserBuff buff = schema.getBackingStore().getTableSecUser().readDerivedByULoginIdx( schema.getAuthorization(),
				LoginId );
			if( buff != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecUserObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByULoginIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmationUuid )
	{
		return( readSecUserByEMConfIdx( EMailConfirmationUuid,
			false ) );
	}

	public List<ICFBamSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmationUuid,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByEMConfIdx";
		CFBamSecUserByEMConfIdxKey key = schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( EMailConfirmationUuid );
		Map<CFBamSecUserPKey, ICFBamSecUserObj> dict;
		if( indexByEMConfIdx == null ) {
			indexByEMConfIdx = new HashMap< CFBamSecUserByEMConfIdxKey,
				Map< CFBamSecUserPKey, ICFBamSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByEMConfIdx.containsKey( key ) ) {
			dict = indexByEMConfIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecUserPKey, ICFBamSecUserObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEMConfIdx.put( key, dict );
			ICFBamSecUserObj obj;
			CFBamSecUserBuff[] buffList = schema.getBackingStore().getTableSecUser().readDerivedByEMConfIdx( schema.getAuthorization(),
				EMailConfirmationUuid );
			CFBamSecUserBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFBamSecUserObj realized = (ICFBamSecUserObj)obj.realize();
			}
		}
		Comparator<ICFBamSecUserObj> cmp = new Comparator<ICFBamSecUserObj>() {
			public int compare( ICFBamSecUserObj lhs, ICFBamSecUserObj rhs ) {
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
					CFBamSecUserPKey lhsPKey = lhs.getPKey();
					CFBamSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecUserObj arr[] = new ICFBamSecUserObj[len];
		Iterator<ICFBamSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecUserObj> arrayList = new ArrayList<ICFBamSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		return( readSecUserByPwdResetIdx( PasswordResetUuid,
			false ) );
	}

	public List<ICFBamSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByPwdResetIdx";
		CFBamSecUserByPwdResetIdxKey key = schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		Map<CFBamSecUserPKey, ICFBamSecUserObj> dict;
		if( indexByPwdResetIdx == null ) {
			indexByPwdResetIdx = new HashMap< CFBamSecUserByPwdResetIdxKey,
				Map< CFBamSecUserPKey, ICFBamSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByPwdResetIdx.containsKey( key ) ) {
			dict = indexByPwdResetIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecUserPKey, ICFBamSecUserObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPwdResetIdx.put( key, dict );
			ICFBamSecUserObj obj;
			CFBamSecUserBuff[] buffList = schema.getBackingStore().getTableSecUser().readDerivedByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
			CFBamSecUserBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFBamSecUserObj realized = (ICFBamSecUserObj)obj.realize();
			}
		}
		Comparator<ICFBamSecUserObj> cmp = new Comparator<ICFBamSecUserObj>() {
			public int compare( ICFBamSecUserObj lhs, ICFBamSecUserObj rhs ) {
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
					CFBamSecUserPKey lhsPKey = lhs.getPKey();
					CFBamSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecUserObj arr[] = new ICFBamSecUserObj[len];
		Iterator<ICFBamSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecUserObj> arrayList = new ArrayList<ICFBamSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecUserObj readSecUserByDefDevIdx( UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		return( readSecUserByDefDevIdx( DefaultDevSecUserId,
			DefaultDevName,
			false ) );
	}

	public ICFBamSecUserObj readSecUserByDefDevIdx( UUID DefaultDevSecUserId,
		String DefaultDevName, boolean forceRead )
	{
		if( indexByDefDevIdx == null ) {
			indexByDefDevIdx = new HashMap< CFBamSecUserByDefDevIdxKey,
				ICFBamSecUserObj >();
		}
		CFBamSecUserByDefDevIdxKey key = schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDefaultDevSecUserId( DefaultDevSecUserId );
		key.setOptionalDefaultDevName( DefaultDevName );
		ICFBamSecUserObj obj = null;
		if( ( ! forceRead ) && indexByDefDevIdx.containsKey( key ) ) {
			obj = indexByDefDevIdx.get( key );
		}
		else {
			CFBamSecUserBuff buff = schema.getBackingStore().getTableSecUser().readDerivedByDefDevIdx( schema.getAuthorization(),
				DefaultDevSecUserId,
				DefaultDevName );
			if( buff != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecUserObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByDefDevIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecUserObj updateSecUser( ICFBamSecUserObj Obj ) {
		ICFBamSecUserObj obj = Obj;
		schema.getBackingStore().getTableSecUser().updateSecUser( schema.getAuthorization(),
			Obj.getSecUserBuff() );
		obj = (ICFBamSecUserObj)Obj.realize();
		return( obj );
	}

	public void deleteSecUser( ICFBamSecUserObj Obj ) {
		ICFBamSecUserObj obj = Obj;
		schema.getBackingStore().getTableSecUser().deleteSecUser( schema.getAuthorization(),
			obj.getSecUserBuff() );
		obj.forget( true );
	}

	public void deleteSecUserByIdIdx( UUID SecUserId )
	{
		CFBamSecUserPKey pkey = schema.getBackingStore().getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		ICFBamSecUserObj obj = readSecUser( pkey );
		if( obj != null ) {
			ICFBamSecUserEditObj editObj = (ICFBamSecUserEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecUserEditObj)obj.beginEdit();
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

	public void deleteSecUserByULoginIdx( String LoginId )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< CFBamSecUserByULoginIdxKey,
				ICFBamSecUserObj >();
		}
		CFBamSecUserByULoginIdxKey key = schema.getBackingStore().getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ICFBamSecUserObj obj = null;
		if( indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
			schema.getBackingStore().getTableSecUser().deleteSecUserByULoginIdx( schema.getAuthorization(),
				LoginId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecUser().deleteSecUserByULoginIdx( schema.getAuthorization(),
				LoginId );
		}
	}

	public void deleteSecUserByEMConfIdx( UUID EMailConfirmationUuid )
	{
		CFBamSecUserByEMConfIdxKey key = schema.getBackingStore().getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmationUuid( EMailConfirmationUuid );
		if( indexByEMConfIdx == null ) {
			indexByEMConfIdx = new HashMap< CFBamSecUserByEMConfIdxKey,
				Map< CFBamSecUserPKey, ICFBamSecUserObj > >();
		}
		if( indexByEMConfIdx.containsKey( key ) ) {
			Map<CFBamSecUserPKey, ICFBamSecUserObj> dict = indexByEMConfIdx.get( key );
			schema.getBackingStore().getTableSecUser().deleteSecUserByEMConfIdx( schema.getAuthorization(),
				EMailConfirmationUuid );
			Iterator<ICFBamSecUserObj> iter = dict.values().iterator();
			ICFBamSecUserObj obj;
			List<ICFBamSecUserObj> toForget = new LinkedList<ICFBamSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEMConfIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecUser().deleteSecUserByEMConfIdx( schema.getAuthorization(),
				EMailConfirmationUuid );
		}
	}

	public void deleteSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		CFBamSecUserByPwdResetIdxKey key = schema.getBackingStore().getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		if( indexByPwdResetIdx == null ) {
			indexByPwdResetIdx = new HashMap< CFBamSecUserByPwdResetIdxKey,
				Map< CFBamSecUserPKey, ICFBamSecUserObj > >();
		}
		if( indexByPwdResetIdx.containsKey( key ) ) {
			Map<CFBamSecUserPKey, ICFBamSecUserObj> dict = indexByPwdResetIdx.get( key );
			schema.getBackingStore().getTableSecUser().deleteSecUserByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
			Iterator<ICFBamSecUserObj> iter = dict.values().iterator();
			ICFBamSecUserObj obj;
			List<ICFBamSecUserObj> toForget = new LinkedList<ICFBamSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPwdResetIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecUser().deleteSecUserByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
		}
	}

	public void deleteSecUserByDefDevIdx( UUID DefaultDevSecUserId,
		String DefaultDevName )
	{
		if( indexByDefDevIdx == null ) {
			indexByDefDevIdx = new HashMap< CFBamSecUserByDefDevIdxKey,
				ICFBamSecUserObj >();
		}
		CFBamSecUserByDefDevIdxKey key = schema.getBackingStore().getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDefaultDevSecUserId( DefaultDevSecUserId );
		key.setOptionalDefaultDevName( DefaultDevName );
		ICFBamSecUserObj obj = null;
		if( indexByDefDevIdx.containsKey( key ) ) {
			obj = indexByDefDevIdx.get( key );
			schema.getBackingStore().getTableSecUser().deleteSecUserByDefDevIdx( schema.getAuthorization(),
				DefaultDevSecUserId,
				DefaultDevName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecUser().deleteSecUserByDefDevIdx( schema.getAuthorization(),
				DefaultDevSecUserId,
				DefaultDevName );
		}
	}

	public ICFBamSecUserObj getSystemUser() {
		boolean transactionStarted = schema.beginTransaction();
		ICFBamSecUserObj secUserObj;
		try {
			secUserObj = schema.getSecUserTableObj().readSecUserByULoginIdx( "system" );
			if( secUserObj == null ) {
				secUserObj = newInstance();
				ICFBamSecUserEditObj secUserEdit = secUserObj.beginEdit();
				secUserEdit.setRequiredEMailAddress( "system" );
				secUserObj = secUserEdit.create();
				secUserEdit.endEdit();
			}
			if( transactionStarted ) {
				schema.commit();
			}
		}
		catch( RuntimeException e ) {
			if( transactionStarted ) {
				try {
					schema.rollback();
				}
				catch( Exception e2 ) {
				}
			}
			throw e;
		}
		return( secUserObj );
	}
}
