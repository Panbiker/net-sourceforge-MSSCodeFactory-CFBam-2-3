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

public class CFBamSecSessionTableObj
	implements ICFBamSecSessionTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecSessionPKey, ICFBamSecSessionObj> members;
	private Map<CFBamSecSessionPKey, ICFBamSecSessionObj> allSecSession;
	private Map< CFBamSecSessionBySecUserIdxKey,
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj > > indexBySecUserIdx;
	private Map< CFBamSecSessionBySecDevIdxKey,
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj > > indexBySecDevIdx;
	private Map< CFBamSecSessionByStartIdxKey,
		ICFBamSecSessionObj > indexByStartIdx;
	private Map< CFBamSecSessionByFinishIdxKey,
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj > > indexByFinishIdx;
	private Map< CFBamSecSessionBySecProxyIdxKey,
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj > > indexBySecProxyIdx;
	public static String TABLE_NAME = "SecSession";
	public static String TABLE_DBNAME = "secsess";

	public CFBamSecSessionTableObj() {
		schema = null;
		members = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
	}

	public CFBamSecSessionTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
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
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
		List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
		ICFBamSecSessionObj cur = null;
		Iterator<ICFBamSecSessionObj> iter = members.values().iterator();
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
	 *	CFBamSecSessionObj.
	 */
	public ICFBamSecSessionObj newInstance() {
		ICFBamSecSessionObj inst = new CFBamSecSessionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecSessionObj.
	 */
	public ICFBamSecSessionEditObj newEditInstance( ICFBamSecSessionObj orig ) {
		ICFBamSecSessionEditObj edit = new CFBamSecSessionEditObj( orig );
		return( edit );
	}

	public ICFBamSecSessionObj realizeSecSession( ICFBamSecSessionObj Obj ) {
		ICFBamSecSessionObj obj = Obj;
		CFBamSecSessionPKey pkey = obj.getPKey();
		ICFBamSecSessionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecSessionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySecUserIdx != null ) {
				CFBamSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFBamSecSessionBySecDevIdxKey keySecDevIdx =
					schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByStartIdx != null ) {
				CFBamSecSessionByStartIdxKey keyStartIdx =
					schema.getBackingStore().getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.remove( keyStartIdx );
			}

			if( indexByFinishIdx != null ) {
				CFBamSecSessionByFinishIdxKey keyFinishIdx =
					schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFBamSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySecUserIdx != null ) {
				CFBamSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFBamSecSessionBySecDevIdxKey keySecDevIdx =
					schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				CFBamSecSessionByStartIdxKey keyStartIdx =
					schema.getBackingStore().getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				CFBamSecSessionByFinishIdxKey keyFinishIdx =
					schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFBamSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySecUserIdx != null ) {
				CFBamSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFBamSecSessionBySecDevIdxKey keySecDevIdx =
					schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				CFBamSecSessionByStartIdxKey keyStartIdx =
					schema.getBackingStore().getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				CFBamSecSessionByFinishIdxKey keyFinishIdx =
					schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFBamSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetSecSession( ICFBamSecSessionObj Obj ) {
		forgetSecSession( Obj, false );
	}

	public void forgetSecSession( ICFBamSecSessionObj Obj, boolean forgetSubObjects ) {
		ICFBamSecSessionObj obj = Obj;
		CFBamSecSessionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecSessionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexBySecUserIdx != null ) {
				CFBamSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFBamSecSessionBySecDevIdxKey keySecDevIdx =
					schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByStartIdx != null ) {
				CFBamSecSessionByStartIdxKey keyStartIdx =
					schema.getBackingStore().getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.remove( keyStartIdx );
			}

			if( indexByFinishIdx != null ) {
				CFBamSecSessionByFinishIdxKey keyFinishIdx =
					schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFBamSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.remove( keepObj.getPKey() );
				}
			}

			if( allSecSession != null ) {
				allSecSession.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecSessionByIdIdx( UUID SecSessionId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecSessionPKey key = schema.getBackingStore().getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( SecSessionId );
		if( members.containsKey( key ) ) {
			ICFBamSecSessionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecSessionBySecUserIdx( UUID SecUserId )
	{
		if( indexBySecUserIdx == null ) {
			return;
		}
		CFBamSecSessionBySecUserIdxKey key = schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexBySecUserIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( key );
			if( mapSecUserIdx != null ) {
				List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
				ICFBamSecSessionObj cur = null;
				Iterator<ICFBamSecSessionObj> iter = mapSecUserIdx.values().iterator();
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

			indexBySecUserIdx.remove( key );
		}
	}

	public void forgetSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		if( indexBySecDevIdx == null ) {
			return;
		}
		CFBamSecSessionBySecDevIdxKey key = schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		if( indexBySecDevIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( key );
			if( mapSecDevIdx != null ) {
				List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
				ICFBamSecSessionObj cur = null;
				Iterator<ICFBamSecSessionObj> iter = mapSecDevIdx.values().iterator();
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

			indexBySecDevIdx.remove( key );
		}
	}

	public void forgetSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		if( indexByStartIdx == null ) {
			return;
		}
		CFBamSecSessionByStartIdxKey key = schema.getBackingStore().getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		if( indexByStartIdx.containsKey( key ) ) {
			ICFBamSecSessionObj probed = indexByStartIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByStartIdx.remove( key );
		}
	}

	public void forgetSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		if( indexByFinishIdx == null ) {
			return;
		}
		CFBamSecSessionByFinishIdxKey key = schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		if( indexByFinishIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapFinishIdx = indexByFinishIdx.get( key );
			if( mapFinishIdx != null ) {
				List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
				ICFBamSecSessionObj cur = null;
				Iterator<ICFBamSecSessionObj> iter = mapFinishIdx.values().iterator();
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

			indexByFinishIdx.remove( key );
		}
	}

	public void forgetSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		if( indexBySecProxyIdx == null ) {
			return;
		}
		CFBamSecSessionBySecProxyIdxKey key = schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		if( indexBySecProxyIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( key );
			if( mapSecProxyIdx != null ) {
				List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
				ICFBamSecSessionObj cur = null;
				Iterator<ICFBamSecSessionObj> iter = mapSecProxyIdx.values().iterator();
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

			indexBySecProxyIdx.remove( key );
		}
	}

	public ICFBamSecSessionObj createSecSession( ICFBamSecSessionObj Obj ) {
		ICFBamSecSessionObj obj = Obj;
		CFBamSecSessionBuff buff = obj.getSecSessionBuff();
		schema.getBackingStore().getTableSecSession().createSecSession(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecSessionObj readSecSession( CFBamSecSessionPKey pkey ) {
		return( readSecSession( pkey, false ) );
	}

	public ICFBamSecSessionObj readSecSession( CFBamSecSessionPKey pkey, boolean forceRead ) {
		ICFBamSecSessionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecSessionBuff readBuff = schema.getBackingStore().getTableSecSession().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecSessionId() );
			if( readBuff != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecSessionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecSessionObj lockSecSession( CFBamSecSessionPKey pkey ) {
		ICFBamSecSessionObj locked = null;
		CFBamSecSessionBuff lockBuff = schema.getBackingStore().getTableSecSession().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecSessionTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecSessionObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecSession", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecSessionObj> readAllSecSession() {
		return( readAllSecSession( false ) );
	}

	public List<ICFBamSecSessionObj> readAllSecSession( boolean forceRead ) {
		final String S_ProcName = "readAllSecSession";
		if( ( allSecSession == null ) || forceRead ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj> map = new HashMap<CFBamSecSessionPKey,ICFBamSecSessionObj>();
			allSecSession = map;
			CFBamSecSessionBuff[] buffList = schema.getBackingStore().getTableSecSession().readAllDerived( schema.getAuthorization() );
			CFBamSecSessionBuff buff;
			ICFBamSecSessionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFBamSecSessionObj realized = (ICFBamSecSessionObj)obj.realize();
			}
		}
		Comparator<ICFBamSecSessionObj> cmp = new Comparator<ICFBamSecSessionObj>() {
			public int compare( ICFBamSecSessionObj lhs, ICFBamSecSessionObj rhs ) {
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
					CFBamSecSessionPKey lhsPKey = lhs.getPKey();
					CFBamSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecSession.size();
		ICFBamSecSessionObj arr[] = new ICFBamSecSessionObj[len];
		Iterator<ICFBamSecSessionObj> valIter = allSecSession.values().iterator();
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
		ArrayList<ICFBamSecSessionObj> arrayList = new ArrayList<ICFBamSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecSessionObj readSecSessionByIdIdx( UUID SecSessionId )
	{
		return( readSecSessionByIdIdx( SecSessionId,
			false ) );
	}

	public ICFBamSecSessionObj readSecSessionByIdIdx( UUID SecSessionId, boolean forceRead )
	{
		CFBamSecSessionPKey pkey = schema.getBackingStore().getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( SecSessionId );
		ICFBamSecSessionObj obj = readSecSession( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId )
	{
		return( readSecSessionBySecUserIdx( SecUserId,
			false ) );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecUserIdx";
		CFBamSecSessionBySecUserIdxKey key = schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict;
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< CFBamSecSessionBySecUserIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecUserIdx.containsKey( key ) ) {
			dict = indexBySecUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySecUserIdx.put( key, dict );
			ICFBamSecSessionObj obj;
			CFBamSecSessionBuff[] buffList = schema.getBackingStore().getTableSecSession().readDerivedBySecUserIdx( schema.getAuthorization(),
				SecUserId );
			CFBamSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFBamSecSessionObj realized = (ICFBamSecSessionObj)obj.realize();
			}
		}
		Comparator<ICFBamSecSessionObj> cmp = new Comparator<ICFBamSecSessionObj>() {
			public int compare( ICFBamSecSessionObj lhs, ICFBamSecSessionObj rhs ) {
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
					CFBamSecSessionPKey lhsPKey = lhs.getPKey();
					CFBamSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecSessionObj arr[] = new ICFBamSecSessionObj[len];
		Iterator<ICFBamSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecSessionObj> arrayList = new ArrayList<ICFBamSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		return( readSecSessionBySecDevIdx( SecUserId,
			SecDevName,
			false ) );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecDevIdx";
		CFBamSecSessionBySecDevIdxKey key = schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict;
		if( indexBySecDevIdx == null ) {
			indexBySecDevIdx = new HashMap< CFBamSecSessionBySecDevIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecDevIdx.containsKey( key ) ) {
			dict = indexBySecDevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySecDevIdx.put( key, dict );
			ICFBamSecSessionObj obj;
			CFBamSecSessionBuff[] buffList = schema.getBackingStore().getTableSecSession().readDerivedBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
			CFBamSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFBamSecSessionObj realized = (ICFBamSecSessionObj)obj.realize();
			}
		}
		Comparator<ICFBamSecSessionObj> cmp = new Comparator<ICFBamSecSessionObj>() {
			public int compare( ICFBamSecSessionObj lhs, ICFBamSecSessionObj rhs ) {
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
					CFBamSecSessionPKey lhsPKey = lhs.getPKey();
					CFBamSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecSessionObj arr[] = new ICFBamSecSessionObj[len];
		Iterator<ICFBamSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecSessionObj> arrayList = new ArrayList<ICFBamSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecSessionObj readSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		return( readSecSessionByStartIdx( SecUserId,
			Start,
			false ) );
	}

	public ICFBamSecSessionObj readSecSessionByStartIdx( UUID SecUserId,
		Calendar Start, boolean forceRead )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< CFBamSecSessionByStartIdxKey,
				ICFBamSecSessionObj >();
		}
		CFBamSecSessionByStartIdxKey key = schema.getBackingStore().getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ICFBamSecSessionObj obj = null;
		if( ( ! forceRead ) && indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
		}
		else {
			CFBamSecSessionBuff buff = schema.getBackingStore().getTableSecSession().readDerivedByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
			if( buff != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecSessionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByStartIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		return( readSecSessionByFinishIdx( SecUserId,
			Finish,
			false ) );
	}

	public List<ICFBamSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionByFinishIdx";
		CFBamSecSessionByFinishIdxKey key = schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict;
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< CFBamSecSessionByFinishIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexByFinishIdx.containsKey( key ) ) {
			dict = indexByFinishIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByFinishIdx.put( key, dict );
			ICFBamSecSessionObj obj;
			CFBamSecSessionBuff[] buffList = schema.getBackingStore().getTableSecSession().readDerivedByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
			CFBamSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFBamSecSessionObj realized = (ICFBamSecSessionObj)obj.realize();
			}
		}
		Comparator<ICFBamSecSessionObj> cmp = new Comparator<ICFBamSecSessionObj>() {
			public int compare( ICFBamSecSessionObj lhs, ICFBamSecSessionObj rhs ) {
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
					CFBamSecSessionPKey lhsPKey = lhs.getPKey();
					CFBamSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecSessionObj arr[] = new ICFBamSecSessionObj[len];
		Iterator<ICFBamSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecSessionObj> arrayList = new ArrayList<ICFBamSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		return( readSecSessionBySecProxyIdx( SecProxyId,
			false ) );
	}

	public List<ICFBamSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecProxyIdx";
		CFBamSecSessionBySecProxyIdxKey key = schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict;
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< CFBamSecSessionBySecProxyIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecProxyIdx.containsKey( key ) ) {
			dict = indexBySecProxyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecSessionPKey, ICFBamSecSessionObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySecProxyIdx.put( key, dict );
			ICFBamSecSessionObj obj;
			CFBamSecSessionBuff[] buffList = schema.getBackingStore().getTableSecSession().readDerivedBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
			CFBamSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFBamSecSessionObj realized = (ICFBamSecSessionObj)obj.realize();
			}
		}
		Comparator<ICFBamSecSessionObj> cmp = new Comparator<ICFBamSecSessionObj>() {
			public int compare( ICFBamSecSessionObj lhs, ICFBamSecSessionObj rhs ) {
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
					CFBamSecSessionPKey lhsPKey = lhs.getPKey();
					CFBamSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecSessionObj arr[] = new ICFBamSecSessionObj[len];
		Iterator<ICFBamSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecSessionObj> arrayList = new ArrayList<ICFBamSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecSessionObj updateSecSession( ICFBamSecSessionObj Obj ) {
		ICFBamSecSessionObj obj = Obj;
		schema.getBackingStore().getTableSecSession().updateSecSession( schema.getAuthorization(),
			Obj.getSecSessionBuff() );
		obj = (ICFBamSecSessionObj)Obj.realize();
		return( obj );
	}

	public void deleteSecSession( ICFBamSecSessionObj Obj ) {
		ICFBamSecSessionObj obj = Obj;
		schema.getBackingStore().getTableSecSession().deleteSecSession( schema.getAuthorization(),
			obj.getSecSessionBuff() );
		obj.forget( true );
	}

	public void deleteSecSessionByIdIdx( UUID SecSessionId )
	{
		CFBamSecSessionPKey pkey = schema.getBackingStore().getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( SecSessionId );
		ICFBamSecSessionObj obj = readSecSession( pkey );
		if( obj != null ) {
			ICFBamSecSessionEditObj editObj = (ICFBamSecSessionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecSessionEditObj)obj.beginEdit();
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

	public void deleteSecSessionBySecUserIdx( UUID SecUserId )
	{
		CFBamSecSessionBySecUserIdxKey key = schema.getBackingStore().getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< CFBamSecSessionBySecUserIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( indexBySecUserIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict = indexBySecUserIdx.get( key );
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFBamSecSessionObj> iter = dict.values().iterator();
			ICFBamSecSessionObj obj;
			List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecUserIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		CFBamSecSessionBySecDevIdxKey key = schema.getBackingStore().getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		if( indexBySecDevIdx == null ) {
			indexBySecDevIdx = new HashMap< CFBamSecSessionBySecDevIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( indexBySecDevIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict = indexBySecDevIdx.get( key );
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
			Iterator<ICFBamSecSessionObj> iter = dict.values().iterator();
			ICFBamSecSessionObj obj;
			List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecDevIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
		}
	}

	public void deleteSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< CFBamSecSessionByStartIdxKey,
				ICFBamSecSessionObj >();
		}
		CFBamSecSessionByStartIdxKey key = schema.getBackingStore().getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ICFBamSecSessionObj obj = null;
		if( indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
			schema.getBackingStore().getTableSecSession().deleteSecSessionByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecSession().deleteSecSessionByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
		}
	}

	public void deleteSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		CFBamSecSessionByFinishIdxKey key = schema.getBackingStore().getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< CFBamSecSessionByFinishIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( indexByFinishIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict = indexByFinishIdx.get( key );
			schema.getBackingStore().getTableSecSession().deleteSecSessionByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
			Iterator<ICFBamSecSessionObj> iter = dict.values().iterator();
			ICFBamSecSessionObj obj;
			List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFinishIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecSession().deleteSecSessionByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
		}
	}

	public void deleteSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		CFBamSecSessionBySecProxyIdxKey key = schema.getBackingStore().getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< CFBamSecSessionBySecProxyIdxKey,
				Map< CFBamSecSessionPKey, ICFBamSecSessionObj > >();
		}
		if( indexBySecProxyIdx.containsKey( key ) ) {
			Map<CFBamSecSessionPKey, ICFBamSecSessionObj> dict = indexBySecProxyIdx.get( key );
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
			Iterator<ICFBamSecSessionObj> iter = dict.values().iterator();
			ICFBamSecSessionObj obj;
			List<ICFBamSecSessionObj> toForget = new LinkedList<ICFBamSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecProxyIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecSession().deleteSecSessionBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
		}
	}

	public ICFBamSecSessionObj getSystemSession() {
		boolean transactionStarted = schema.beginTransaction();
		ICFBamSecUserObj userObj;
		ICFBamSecSessionObj sessionObj;
		try {
			userObj = schema.getSecUserTableObj().getSystemUser();
			sessionObj = readSecSessionByStartIdx( userObj.getRequiredSecUserId(),
				Calendar.getInstance() );
			if( sessionObj == null ) {
				sessionObj = newInstance();
				ICFBamSecSessionEditObj sessionEdit = sessionObj.beginEdit();
				sessionEdit.setRequiredContainerSecUser( userObj );
				sessionEdit.setRequiredStart( Calendar.getInstance() );
				sessionEdit.setOptionalFinish( null );
				sessionObj = sessionEdit.create();
				sessionEdit.endEdit();
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
		return( sessionObj );
	}
}
