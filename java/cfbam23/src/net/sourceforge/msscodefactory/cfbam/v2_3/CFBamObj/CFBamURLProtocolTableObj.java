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

public class CFBamURLProtocolTableObj
	implements ICFBamURLProtocolTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj> members;
	private Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj> allURLProtocol;
	private Map< CFBamURLProtocolByUNameIdxKey,
		ICFBamURLProtocolObj > indexByUNameIdx;
	private Map< CFBamURLProtocolByIsSecureIdxKey,
		Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > > indexByIsSecureIdx;
	public static String TABLE_NAME = "URLProtocol";
	public static String TABLE_DBNAME = "urlproto";

	public CFBamURLProtocolTableObj() {
		schema = null;
		members = new HashMap<CFBamURLProtocolPKey, ICFBamURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
	}

	public CFBamURLProtocolTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamURLProtocolPKey, ICFBamURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
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
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
		List<ICFBamURLProtocolObj> toForget = new LinkedList<ICFBamURLProtocolObj>();
		ICFBamURLProtocolObj cur = null;
		Iterator<ICFBamURLProtocolObj> iter = members.values().iterator();
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
	 *	CFBamURLProtocolObj.
	 */
	public ICFBamURLProtocolObj newInstance() {
		ICFBamURLProtocolObj inst = new CFBamURLProtocolObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamURLProtocolObj.
	 */
	public ICFBamURLProtocolEditObj newEditInstance( ICFBamURLProtocolObj orig ) {
		ICFBamURLProtocolEditObj edit = new CFBamURLProtocolEditObj( orig );
		return( edit );
	}

	public ICFBamURLProtocolObj realizeURLProtocol( ICFBamURLProtocolObj Obj ) {
		ICFBamURLProtocolObj obj = Obj;
		CFBamURLProtocolPKey pkey = obj.getPKey();
		ICFBamURLProtocolObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamURLProtocolObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIsSecureIdx != null ) {
				CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetURLProtocol( ICFBamURLProtocolObj Obj ) {
		forgetURLProtocol( Obj, false );
	}

	public void forgetURLProtocol( ICFBamURLProtocolObj Obj, boolean forgetSubObjects ) {
		ICFBamURLProtocolObj obj = Obj;
		CFBamURLProtocolPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamURLProtocolObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIsSecureIdx != null ) {
				CFBamURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.remove( keepObj.getPKey() );
				}
			}

			if( allURLProtocol != null ) {
				allURLProtocol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetURLProtocolByIdIdx( short URLProtocolId )
	{
		if( members == null ) {
			return;
		}
		CFBamURLProtocolPKey key = schema.getBackingStore().getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( URLProtocolId );
		if( members.containsKey( key ) ) {
			ICFBamURLProtocolObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetURLProtocolByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamURLProtocolByUNameIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamURLProtocolObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		if( indexByIsSecureIdx == null ) {
			return;
		}
		CFBamURLProtocolByIsSecureIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		if( indexByIsSecureIdx.containsKey( key ) ) {
			Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( key );
			if( mapIsSecureIdx != null ) {
				List<ICFBamURLProtocolObj> toForget = new LinkedList<ICFBamURLProtocolObj>();
				ICFBamURLProtocolObj cur = null;
				Iterator<ICFBamURLProtocolObj> iter = mapIsSecureIdx.values().iterator();
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

			indexByIsSecureIdx.remove( key );
		}
	}

	public ICFBamURLProtocolObj createURLProtocol( ICFBamURLProtocolObj Obj ) {
		ICFBamURLProtocolObj obj = Obj;
		CFBamURLProtocolBuff buff = obj.getURLProtocolBuff();
		schema.getBackingStore().getTableURLProtocol().createURLProtocol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamURLProtocolObj readURLProtocol( CFBamURLProtocolPKey pkey ) {
		return( readURLProtocol( pkey, false ) );
	}

	public ICFBamURLProtocolObj readURLProtocol( CFBamURLProtocolPKey pkey, boolean forceRead ) {
		ICFBamURLProtocolObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamURLProtocolBuff readBuff = schema.getBackingStore().getTableURLProtocol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredURLProtocolId() );
			if( readBuff != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryURLProtocol().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamURLProtocolObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamURLProtocolObj lockURLProtocol( CFBamURLProtocolPKey pkey ) {
		ICFBamURLProtocolObj locked = null;
		CFBamURLProtocolBuff lockBuff = schema.getBackingStore().getTableURLProtocol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getURLProtocolTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryURLProtocol().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamURLProtocolObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockURLProtocol", pkey );
		}
		return( locked );
	}

	public List<ICFBamURLProtocolObj> readAllURLProtocol() {
		return( readAllURLProtocol( false ) );
	}

	public List<ICFBamURLProtocolObj> readAllURLProtocol( boolean forceRead ) {
		final String S_ProcName = "readAllURLProtocol";
		if( ( allURLProtocol == null ) || forceRead ) {
			Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj> map = new HashMap<CFBamURLProtocolPKey,ICFBamURLProtocolObj>();
			allURLProtocol = map;
			CFBamURLProtocolBuff[] buffList = schema.getBackingStore().getTableURLProtocol().readAllDerived( schema.getAuthorization() );
			CFBamURLProtocolBuff buff;
			ICFBamURLProtocolObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				ICFBamURLProtocolObj realized = (ICFBamURLProtocolObj)obj.realize();
			}
		}
		Comparator<ICFBamURLProtocolObj> cmp = new Comparator<ICFBamURLProtocolObj>() {
			public int compare( ICFBamURLProtocolObj lhs, ICFBamURLProtocolObj rhs ) {
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
					CFBamURLProtocolPKey lhsPKey = lhs.getPKey();
					CFBamURLProtocolPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allURLProtocol.size();
		ICFBamURLProtocolObj arr[] = new ICFBamURLProtocolObj[len];
		Iterator<ICFBamURLProtocolObj> valIter = allURLProtocol.values().iterator();
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
		ArrayList<ICFBamURLProtocolObj> arrayList = new ArrayList<ICFBamURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamURLProtocolObj readURLProtocolByIdIdx( short URLProtocolId )
	{
		return( readURLProtocolByIdIdx( URLProtocolId,
			false ) );
	}

	public ICFBamURLProtocolObj readURLProtocolByIdIdx( short URLProtocolId, boolean forceRead )
	{
		CFBamURLProtocolPKey pkey = schema.getBackingStore().getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( URLProtocolId );
		ICFBamURLProtocolObj obj = readURLProtocol( pkey, forceRead );
		return( obj );
	}

	public ICFBamURLProtocolObj readURLProtocolByUNameIdx( String Name )
	{
		return( readURLProtocolByUNameIdx( Name,
			false ) );
	}

	public ICFBamURLProtocolObj readURLProtocolByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamURLProtocolByUNameIdxKey,
				ICFBamURLProtocolObj >();
		}
		CFBamURLProtocolByUNameIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamURLProtocolObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamURLProtocolBuff buff = schema.getBackingStore().getTableURLProtocol().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamURLProtocolObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		return( readURLProtocolByIsSecureIdx( IsSecure,
			false ) );
	}

	public List<ICFBamURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure,
		boolean forceRead )
	{
		final String S_ProcName = "readURLProtocolByIsSecureIdx";
		CFBamURLProtocolByIsSecureIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj> dict;
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< CFBamURLProtocolByIsSecureIdxKey,
				Map< CFBamURLProtocolPKey, ICFBamURLProtocolObj > >();
		}
		if( ( ! forceRead ) && indexByIsSecureIdx.containsKey( key ) ) {
			dict = indexByIsSecureIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamURLProtocolPKey, ICFBamURLProtocolObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIsSecureIdx.put( key, dict );
			ICFBamURLProtocolObj obj;
			CFBamURLProtocolBuff[] buffList = schema.getBackingStore().getTableURLProtocol().readDerivedByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
			CFBamURLProtocolBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				ICFBamURLProtocolObj realized = (ICFBamURLProtocolObj)obj.realize();
			}
		}
		Comparator<ICFBamURLProtocolObj> cmp = new Comparator<ICFBamURLProtocolObj>() {
			public int compare( ICFBamURLProtocolObj lhs, ICFBamURLProtocolObj rhs ) {
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
					CFBamURLProtocolPKey lhsPKey = lhs.getPKey();
					CFBamURLProtocolPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamURLProtocolObj arr[] = new ICFBamURLProtocolObj[len];
		Iterator<ICFBamURLProtocolObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamURLProtocolObj> arrayList = new ArrayList<ICFBamURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamURLProtocolObj updateURLProtocol( ICFBamURLProtocolObj Obj ) {
		ICFBamURLProtocolObj obj = Obj;
		schema.getBackingStore().getTableURLProtocol().updateURLProtocol( schema.getAuthorization(),
			Obj.getURLProtocolBuff() );
		obj = (ICFBamURLProtocolObj)Obj.realize();
		return( obj );
	}

	public void deleteURLProtocol( ICFBamURLProtocolObj Obj ) {
		ICFBamURLProtocolObj obj = Obj;
		schema.getBackingStore().getTableURLProtocol().deleteURLProtocol( schema.getAuthorization(),
			obj.getURLProtocolBuff() );
		obj.forget( true );
	}

	public void deleteURLProtocolByIdIdx( short URLProtocolId )
	{
		CFBamURLProtocolPKey pkey = schema.getBackingStore().getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( URLProtocolId );
		ICFBamURLProtocolObj obj = readURLProtocol( pkey );
		if( obj != null ) {
			ICFBamURLProtocolEditObj editObj = (ICFBamURLProtocolEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamURLProtocolEditObj)obj.beginEdit();
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

	public void deleteURLProtocolByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamURLProtocolByUNameIdxKey,
				ICFBamURLProtocolObj >();
		}
		CFBamURLProtocolByUNameIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamURLProtocolObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableURLProtocol().deleteURLProtocolByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableURLProtocol().deleteURLProtocolByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}

	public void deleteURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		CFBamURLProtocolByIsSecureIdxKey key = schema.getBackingStore().getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< CFBamURLProtocolByIsSecureIdxKey,
				Map< CFBamURLProtocolPKey, ICFBamURLProtocolObj > >();
		}
		if( indexByIsSecureIdx.containsKey( key ) ) {
			Map<CFBamURLProtocolPKey, ICFBamURLProtocolObj> dict = indexByIsSecureIdx.get( key );
			schema.getBackingStore().getTableURLProtocol().deleteURLProtocolByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
			Iterator<ICFBamURLProtocolObj> iter = dict.values().iterator();
			ICFBamURLProtocolObj obj;
			List<ICFBamURLProtocolObj> toForget = new LinkedList<ICFBamURLProtocolObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIsSecureIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableURLProtocol().deleteURLProtocolByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
		}
	}
}
