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

public class CFBamSecFormTableObj
	implements ICFBamSecFormTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecFormPKey, ICFBamSecFormObj> members;
	private Map<CFBamSecFormPKey, ICFBamSecFormObj> allSecForm;
	private Map< CFBamSecFormByClusterIdxKey,
		Map<CFBamSecFormPKey, ICFBamSecFormObj > > indexByClusterIdx;
	private Map< CFBamSecFormBySecAppIdxKey,
		Map<CFBamSecFormPKey, ICFBamSecFormObj > > indexBySecAppIdx;
	private Map< CFBamSecFormByUJEEServletIdxKey,
		ICFBamSecFormObj > indexByUJEEServletIdx;
	public static String TABLE_NAME = "SecForm";
	public static String TABLE_DBNAME = "secform";

	public CFBamSecFormTableObj() {
		schema = null;
		members = new HashMap<CFBamSecFormPKey, ICFBamSecFormObj>();
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
	}

	public CFBamSecFormTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecFormPKey, ICFBamSecFormObj>();
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
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
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
		List<ICFBamSecFormObj> toForget = new LinkedList<ICFBamSecFormObj>();
		ICFBamSecFormObj cur = null;
		Iterator<ICFBamSecFormObj> iter = members.values().iterator();
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
	 *	CFBamSecFormObj.
	 */
	public ICFBamSecFormObj newInstance() {
		ICFBamSecFormObj inst = new CFBamSecFormObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecFormObj.
	 */
	public ICFBamSecFormEditObj newEditInstance( ICFBamSecFormObj orig ) {
		ICFBamSecFormEditObj edit = new CFBamSecFormEditObj( orig );
		return( edit );
	}

	public ICFBamSecFormObj realizeSecForm( ICFBamSecFormObj Obj ) {
		ICFBamSecFormObj obj = Obj;
		CFBamSecFormPKey pkey = obj.getPKey();
		ICFBamSecFormObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecFormObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFBamSecFormBySecAppIdxKey keySecAppIdx =
					schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.remove( keyUJEEServletIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFBamSecFormBySecAppIdxKey keySecAppIdx =
					schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.put( keyUJEEServletIdx, keepObj );
			}
			if( allSecForm != null ) {
				allSecForm.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecForm != null ) {
				allSecForm.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFBamSecFormBySecAppIdxKey keySecAppIdx =
					schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.put( keyUJEEServletIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecForm( ICFBamSecFormObj Obj ) {
		forgetSecForm( Obj, false );
	}

	public void forgetSecForm( ICFBamSecFormObj Obj, boolean forgetSubObjects ) {
		ICFBamSecFormObj obj = Obj;
		CFBamSecFormPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecFormObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFBamSecFormBySecAppIdxKey keySecAppIdx =
					schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecFormPKey, ICFBamSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFBamSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.remove( keyUJEEServletIdx );
			}

			if( allSecForm != null ) {
				allSecForm.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecFormPKey key = schema.getBackingStore().getFactorySecForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( members.containsKey( key ) ) {
			ICFBamSecFormObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecFormByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecFormByClusterIdxKey key = schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecFormPKey, ICFBamSecFormObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecFormObj> toForget = new LinkedList<ICFBamSecFormObj>();
				ICFBamSecFormObj cur = null;
				Iterator<ICFBamSecFormObj> iter = mapClusterIdx.values().iterator();
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

	public void forgetSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		if( indexBySecAppIdx == null ) {
			return;
		}
		CFBamSecFormBySecAppIdxKey key = schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexBySecAppIdx.containsKey( key ) ) {
			Map<CFBamSecFormPKey, ICFBamSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( key );
			if( mapSecAppIdx != null ) {
				List<ICFBamSecFormObj> toForget = new LinkedList<ICFBamSecFormObj>();
				ICFBamSecFormObj cur = null;
				Iterator<ICFBamSecFormObj> iter = mapSecAppIdx.values().iterator();
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

			indexBySecAppIdx.remove( key );
		}
	}

	public void forgetSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		if( indexByUJEEServletIdx == null ) {
			return;
		}
		CFBamSecFormByUJEEServletIdxKey key = schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		if( indexByUJEEServletIdx.containsKey( key ) ) {
			ICFBamSecFormObj probed = indexByUJEEServletIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUJEEServletIdx.remove( key );
		}
	}

	public ICFBamSecFormObj createSecForm( ICFBamSecFormObj Obj ) {
		ICFBamSecFormObj obj = Obj;
		CFBamSecFormBuff buff = obj.getSecFormBuff();
		schema.getBackingStore().getTableSecForm().createSecForm(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecFormObj readSecForm( CFBamSecFormPKey pkey ) {
		return( readSecForm( pkey, false ) );
	}

	public ICFBamSecFormObj readSecForm( CFBamSecFormPKey pkey, boolean forceRead ) {
		ICFBamSecFormObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecFormBuff readBuff = schema.getBackingStore().getTableSecForm().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecFormId() );
			if( readBuff != null ) {
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecFormObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecFormObj lockSecForm( CFBamSecFormPKey pkey ) {
		ICFBamSecFormObj locked = null;
		CFBamSecFormBuff lockBuff = schema.getBackingStore().getTableSecForm().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecFormTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecFormObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecForm", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecFormObj> readAllSecForm() {
		return( readAllSecForm( false ) );
	}

	public List<ICFBamSecFormObj> readAllSecForm( boolean forceRead ) {
		final String S_ProcName = "readAllSecForm";
		if( ( allSecForm == null ) || forceRead ) {
			Map<CFBamSecFormPKey, ICFBamSecFormObj> map = new HashMap<CFBamSecFormPKey,ICFBamSecFormObj>();
			allSecForm = map;
			CFBamSecFormBuff[] buffList = schema.getBackingStore().getTableSecForm().readAllDerived( schema.getAuthorization() );
			CFBamSecFormBuff buff;
			ICFBamSecFormObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecFormObj realized = (ICFBamSecFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecFormObj> cmp = new Comparator<ICFBamSecFormObj>() {
			public int compare( ICFBamSecFormObj lhs, ICFBamSecFormObj rhs ) {
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
					CFBamSecFormPKey lhsPKey = lhs.getPKey();
					CFBamSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecForm.size();
		ICFBamSecFormObj arr[] = new ICFBamSecFormObj[len];
		Iterator<ICFBamSecFormObj> valIter = allSecForm.values().iterator();
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
		ArrayList<ICFBamSecFormObj> arrayList = new ArrayList<ICFBamSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecFormObj readSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		return( readSecFormByIdIdx( ClusterId,
			SecFormId,
			false ) );
	}

	public ICFBamSecFormObj readSecFormByIdIdx( long ClusterId,
		int SecFormId, boolean forceRead )
	{
		CFBamSecFormPKey pkey = schema.getBackingStore().getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecFormId( SecFormId );
		ICFBamSecFormObj obj = readSecForm( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecFormObj> readSecFormByClusterIdx( long ClusterId )
	{
		return( readSecFormByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecFormObj> readSecFormByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecFormByClusterIdx";
		CFBamSecFormByClusterIdxKey key = schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecFormPKey, ICFBamSecFormObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecFormByClusterIdxKey,
				Map< CFBamSecFormPKey, ICFBamSecFormObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecFormPKey, ICFBamSecFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecFormObj obj;
			CFBamSecFormBuff[] buffList = schema.getBackingStore().getTableSecForm().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecFormObj realized = (ICFBamSecFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecFormObj> cmp = new Comparator<ICFBamSecFormObj>() {
			public int compare( ICFBamSecFormObj lhs, ICFBamSecFormObj rhs ) {
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
					CFBamSecFormPKey lhsPKey = lhs.getPKey();
					CFBamSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecFormObj arr[] = new ICFBamSecFormObj[len];
		Iterator<ICFBamSecFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecFormObj> arrayList = new ArrayList<ICFBamSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecFormObj> readSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecFormBySecAppIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public List<ICFBamSecFormObj> readSecFormBySecAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecFormBySecAppIdx";
		CFBamSecFormBySecAppIdxKey key = schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		Map<CFBamSecFormPKey, ICFBamSecFormObj> dict;
		if( indexBySecAppIdx == null ) {
			indexBySecAppIdx = new HashMap< CFBamSecFormBySecAppIdxKey,
				Map< CFBamSecFormPKey, ICFBamSecFormObj > >();
		}
		if( ( ! forceRead ) && indexBySecAppIdx.containsKey( key ) ) {
			dict = indexBySecAppIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecFormPKey, ICFBamSecFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySecAppIdx.put( key, dict );
			ICFBamSecFormObj obj;
			CFBamSecFormBuff[] buffList = schema.getBackingStore().getTableSecForm().readDerivedBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			CFBamSecFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecFormObj realized = (ICFBamSecFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecFormObj> cmp = new Comparator<ICFBamSecFormObj>() {
			public int compare( ICFBamSecFormObj lhs, ICFBamSecFormObj rhs ) {
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
					CFBamSecFormPKey lhsPKey = lhs.getPKey();
					CFBamSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecFormObj arr[] = new ICFBamSecFormObj[len];
		Iterator<ICFBamSecFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecFormObj> arrayList = new ArrayList<ICFBamSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecFormObj readSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		return( readSecFormByUJEEServletIdx( ClusterId,
			SecAppId,
			JEEServletMapName,
			false ) );
	}

	public ICFBamSecFormObj readSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName, boolean forceRead )
	{
		if( indexByUJEEServletIdx == null ) {
			indexByUJEEServletIdx = new HashMap< CFBamSecFormByUJEEServletIdxKey,
				ICFBamSecFormObj >();
		}
		CFBamSecFormByUJEEServletIdxKey key = schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		ICFBamSecFormObj obj = null;
		if( ( ! forceRead ) && indexByUJEEServletIdx.containsKey( key ) ) {
			obj = indexByUJEEServletIdx.get( key );
		}
		else {
			CFBamSecFormBuff buff = schema.getBackingStore().getTableSecForm().readDerivedByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
			if( buff != null ) {
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecFormObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUJEEServletIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecFormObj updateSecForm( ICFBamSecFormObj Obj ) {
		ICFBamSecFormObj obj = Obj;
		schema.getBackingStore().getTableSecForm().updateSecForm( schema.getAuthorization(),
			Obj.getSecFormBuff() );
		obj = (ICFBamSecFormObj)Obj.realize();
		return( obj );
	}

	public void deleteSecForm( ICFBamSecFormObj Obj ) {
		ICFBamSecFormObj obj = Obj;
		schema.getBackingStore().getTableSecForm().deleteSecForm( schema.getAuthorization(),
			obj.getSecFormBuff() );
		obj.forget( true );
	}

	public void deleteSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		CFBamSecFormPKey pkey = schema.getBackingStore().getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecFormId( SecFormId );
		ICFBamSecFormObj obj = readSecForm( pkey );
		if( obj != null ) {
			ICFBamSecFormEditObj editObj = (ICFBamSecFormEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecFormEditObj)obj.beginEdit();
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

	public void deleteSecFormByClusterIdx( long ClusterId )
	{
		CFBamSecFormByClusterIdxKey key = schema.getBackingStore().getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecFormByClusterIdxKey,
				Map< CFBamSecFormPKey, ICFBamSecFormObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecFormPKey, ICFBamSecFormObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecForm().deleteSecFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecFormObj> iter = dict.values().iterator();
			ICFBamSecFormObj obj;
			List<ICFBamSecFormObj> toForget = new LinkedList<ICFBamSecFormObj>();
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
			schema.getBackingStore().getTableSecForm().deleteSecFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		CFBamSecFormBySecAppIdxKey key = schema.getBackingStore().getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexBySecAppIdx == null ) {
			indexBySecAppIdx = new HashMap< CFBamSecFormBySecAppIdxKey,
				Map< CFBamSecFormPKey, ICFBamSecFormObj > >();
		}
		if( indexBySecAppIdx.containsKey( key ) ) {
			Map<CFBamSecFormPKey, ICFBamSecFormObj> dict = indexBySecAppIdx.get( key );
			schema.getBackingStore().getTableSecForm().deleteSecFormBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			Iterator<ICFBamSecFormObj> iter = dict.values().iterator();
			ICFBamSecFormObj obj;
			List<ICFBamSecFormObj> toForget = new LinkedList<ICFBamSecFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecAppIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecForm().deleteSecFormBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
		}
	}

	public void deleteSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		if( indexByUJEEServletIdx == null ) {
			indexByUJEEServletIdx = new HashMap< CFBamSecFormByUJEEServletIdxKey,
				ICFBamSecFormObj >();
		}
		CFBamSecFormByUJEEServletIdxKey key = schema.getBackingStore().getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		ICFBamSecFormObj obj = null;
		if( indexByUJEEServletIdx.containsKey( key ) ) {
			obj = indexByUJEEServletIdx.get( key );
			schema.getBackingStore().getTableSecForm().deleteSecFormByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecForm().deleteSecFormByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
		}
	}
}
