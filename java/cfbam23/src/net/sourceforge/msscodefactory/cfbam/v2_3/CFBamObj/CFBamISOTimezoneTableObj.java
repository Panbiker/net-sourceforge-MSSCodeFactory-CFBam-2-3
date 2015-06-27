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

public class CFBamISOTimezoneTableObj
	implements ICFBamISOTimezoneTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> members;
	private Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> allISOTimezone;
	private Map< CFBamISOTimezoneByOffsetIdxKey,
		Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > > indexByOffsetIdx;
	private Map< CFBamISOTimezoneByUTZNameIdxKey,
		ICFBamISOTimezoneObj > indexByUTZNameIdx;
	private Map< CFBamISOTimezoneByIso8601IdxKey,
		Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > > indexByIso8601Idx;
	public static String TABLE_NAME = "ISOTimezone";
	public static String TABLE_DBNAME = "isotz";

	public CFBamISOTimezoneTableObj() {
		schema = null;
		members = new HashMap<CFBamISOTimezonePKey, ICFBamISOTimezoneObj>();
		allISOTimezone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
	}

	public CFBamISOTimezoneTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOTimezonePKey, ICFBamISOTimezoneObj>();
		allISOTimezone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
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
		allISOTimezone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
		List<ICFBamISOTimezoneObj> toForget = new LinkedList<ICFBamISOTimezoneObj>();
		ICFBamISOTimezoneObj cur = null;
		Iterator<ICFBamISOTimezoneObj> iter = members.values().iterator();
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
	 *	CFBamISOTimezoneObj.
	 */
	public ICFBamISOTimezoneObj newInstance() {
		ICFBamISOTimezoneObj inst = new CFBamISOTimezoneObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOTimezoneObj.
	 */
	public ICFBamISOTimezoneEditObj newEditInstance( ICFBamISOTimezoneObj orig ) {
		ICFBamISOTimezoneEditObj edit = new CFBamISOTimezoneEditObj( orig );
		return( edit );
	}

	public ICFBamISOTimezoneObj realizeISOTimezone( ICFBamISOTimezoneObj Obj ) {
		ICFBamISOTimezoneObj obj = Obj;
		CFBamISOTimezonePKey pkey = obj.getPKey();
		ICFBamISOTimezoneObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOTimezoneObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByOffsetIdx != null ) {
				CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx =
					schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.remove( keyUTZNameIdx );
			}

			if( indexByIso8601Idx != null ) {
				CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx =
					schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByOffsetIdx != null ) {
				CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx =
					schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx =
					schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allISOTimezone != null ) {
				allISOTimezone.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOTimezone != null ) {
				allISOTimezone.put( keepObj.getPKey(), keepObj );
			}

			if( indexByOffsetIdx != null ) {
				CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx =
					schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx =
					schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetISOTimezone( ICFBamISOTimezoneObj Obj ) {
		forgetISOTimezone( Obj, false );
	}

	public void forgetISOTimezone( ICFBamISOTimezoneObj Obj, boolean forgetSubObjects ) {
		ICFBamISOTimezoneObj obj = Obj;
		CFBamISOTimezonePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOTimezoneObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByOffsetIdx != null ) {
				CFBamISOTimezoneByOffsetIdxKey keyOffsetIdx =
					schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFBamISOTimezoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.remove( keyUTZNameIdx );
			}

			if( indexByIso8601Idx != null ) {
				CFBamISOTimezoneByIso8601IdxKey keyIso8601Idx =
					schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.remove( keepObj.getPKey() );
				}
			}

			if( allISOTimezone != null ) {
				allISOTimezone.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOTimezoneByIdIdx( short ISOTimezoneId )
	{
		if( members == null ) {
			return;
		}
		CFBamISOTimezonePKey key = schema.getBackingStore().getFactoryISOTimezone().newPKey();
		key.setRequiredISOTimezoneId( ISOTimezoneId );
		if( members.containsKey( key ) ) {
			ICFBamISOTimezoneObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOTimezoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		if( indexByOffsetIdx == null ) {
			return;
		}
		CFBamISOTimezoneByOffsetIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		if( indexByOffsetIdx.containsKey( key ) ) {
			Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapOffsetIdx = indexByOffsetIdx.get( key );
			if( mapOffsetIdx != null ) {
				List<ICFBamISOTimezoneObj> toForget = new LinkedList<ICFBamISOTimezoneObj>();
				ICFBamISOTimezoneObj cur = null;
				Iterator<ICFBamISOTimezoneObj> iter = mapOffsetIdx.values().iterator();
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

			indexByOffsetIdx.remove( key );
		}
	}

	public void forgetISOTimezoneByUTZNameIdx( String TZName )
	{
		if( indexByUTZNameIdx == null ) {
			return;
		}
		CFBamISOTimezoneByUTZNameIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		if( indexByUTZNameIdx.containsKey( key ) ) {
			ICFBamISOTimezoneObj probed = indexByUTZNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUTZNameIdx.remove( key );
		}
	}

	public void forgetISOTimezoneByIso8601Idx( String Iso8601 )
	{
		if( indexByIso8601Idx == null ) {
			return;
		}
		CFBamISOTimezoneByIso8601IdxKey key = schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		if( indexByIso8601Idx.containsKey( key ) ) {
			Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj > mapIso8601Idx = indexByIso8601Idx.get( key );
			if( mapIso8601Idx != null ) {
				List<ICFBamISOTimezoneObj> toForget = new LinkedList<ICFBamISOTimezoneObj>();
				ICFBamISOTimezoneObj cur = null;
				Iterator<ICFBamISOTimezoneObj> iter = mapIso8601Idx.values().iterator();
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

			indexByIso8601Idx.remove( key );
		}
	}

	public ICFBamISOTimezoneObj createISOTimezone( ICFBamISOTimezoneObj Obj ) {
		ICFBamISOTimezoneObj obj = Obj;
		CFBamISOTimezoneBuff buff = obj.getISOTimezoneBuff();
		schema.getBackingStore().getTableISOTimezone().createISOTimezone(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOTimezoneObj readISOTimezone( CFBamISOTimezonePKey pkey ) {
		return( readISOTimezone( pkey, false ) );
	}

	public ICFBamISOTimezoneObj readISOTimezone( CFBamISOTimezonePKey pkey, boolean forceRead ) {
		ICFBamISOTimezoneObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOTimezoneBuff readBuff = schema.getBackingStore().getTableISOTimezone().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOTimezoneId() );
			if( readBuff != null ) {
				obj = schema.getISOTimezoneTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOTimezoneObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOTimezoneObj lockISOTimezone( CFBamISOTimezonePKey pkey ) {
		ICFBamISOTimezoneObj locked = null;
		CFBamISOTimezoneBuff lockBuff = schema.getBackingStore().getTableISOTimezone().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOTimezoneTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOTimezoneObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOTimezone", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOTimezoneObj> readAllISOTimezone() {
		return( readAllISOTimezone( false ) );
	}

	public List<ICFBamISOTimezoneObj> readAllISOTimezone( boolean forceRead ) {
		final String S_ProcName = "readAllISOTimezone";
		if( ( allISOTimezone == null ) || forceRead ) {
			Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> map = new HashMap<CFBamISOTimezonePKey,ICFBamISOTimezoneObj>();
			allISOTimezone = map;
			CFBamISOTimezoneBuff[] buffList = schema.getBackingStore().getTableISOTimezone().readAllDerived( schema.getAuthorization() );
			CFBamISOTimezoneBuff buff;
			ICFBamISOTimezoneObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
				obj.setBuff( buff );
				ICFBamISOTimezoneObj realized = (ICFBamISOTimezoneObj)obj.realize();
			}
		}
		Comparator<ICFBamISOTimezoneObj> cmp = new Comparator<ICFBamISOTimezoneObj>() {
			public int compare( ICFBamISOTimezoneObj lhs, ICFBamISOTimezoneObj rhs ) {
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
					CFBamISOTimezonePKey lhsPKey = lhs.getPKey();
					CFBamISOTimezonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOTimezone.size();
		ICFBamISOTimezoneObj arr[] = new ICFBamISOTimezoneObj[len];
		Iterator<ICFBamISOTimezoneObj> valIter = allISOTimezone.values().iterator();
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
		ArrayList<ICFBamISOTimezoneObj> arrayList = new ArrayList<ICFBamISOTimezoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOTimezoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOTimezoneObj readISOTimezoneByIdIdx( short ISOTimezoneId )
	{
		return( readISOTimezoneByIdIdx( ISOTimezoneId,
			false ) );
	}

	public ICFBamISOTimezoneObj readISOTimezoneByIdIdx( short ISOTimezoneId, boolean forceRead )
	{
		CFBamISOTimezonePKey pkey = schema.getBackingStore().getFactoryISOTimezone().newPKey();
		pkey.setRequiredISOTimezoneId( ISOTimezoneId );
		ICFBamISOTimezoneObj obj = readISOTimezone( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamISOTimezoneObj> readISOTimezoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		return( readISOTimezoneByOffsetIdx( TZHourOffset,
			TZMinOffset,
			false ) );
	}

	public List<ICFBamISOTimezoneObj> readISOTimezoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTimezoneByOffsetIdx";
		CFBamISOTimezoneByOffsetIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> dict;
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< CFBamISOTimezoneByOffsetIdxKey,
				Map< CFBamISOTimezonePKey, ICFBamISOTimezoneObj > >();
		}
		if( ( ! forceRead ) && indexByOffsetIdx.containsKey( key ) ) {
			dict = indexByOffsetIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOTimezonePKey, ICFBamISOTimezoneObj>();
			// Allow other threads to dirty-read while we're loading
			indexByOffsetIdx.put( key, dict );
			ICFBamISOTimezoneObj obj;
			CFBamISOTimezoneBuff[] buffList = schema.getBackingStore().getTableISOTimezone().readDerivedByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
			CFBamISOTimezoneBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOTimezoneTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
				obj.setBuff( buff );
				ICFBamISOTimezoneObj realized = (ICFBamISOTimezoneObj)obj.realize();
			}
		}
		Comparator<ICFBamISOTimezoneObj> cmp = new Comparator<ICFBamISOTimezoneObj>() {
			public int compare( ICFBamISOTimezoneObj lhs, ICFBamISOTimezoneObj rhs ) {
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
					CFBamISOTimezonePKey lhsPKey = lhs.getPKey();
					CFBamISOTimezonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOTimezoneObj arr[] = new ICFBamISOTimezoneObj[len];
		Iterator<ICFBamISOTimezoneObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOTimezoneObj> arrayList = new ArrayList<ICFBamISOTimezoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOTimezoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOTimezoneObj readISOTimezoneByUTZNameIdx( String TZName )
	{
		return( readISOTimezoneByUTZNameIdx( TZName,
			false ) );
	}

	public ICFBamISOTimezoneObj readISOTimezoneByUTZNameIdx( String TZName, boolean forceRead )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< CFBamISOTimezoneByUTZNameIdxKey,
				ICFBamISOTimezoneObj >();
		}
		CFBamISOTimezoneByUTZNameIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ICFBamISOTimezoneObj obj = null;
		if( ( ! forceRead ) && indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
		}
		else {
			CFBamISOTimezoneBuff buff = schema.getBackingStore().getTableISOTimezone().readDerivedByUTZNameIdx( schema.getAuthorization(),
				TZName );
			if( buff != null ) {
				obj = schema.getISOTimezoneTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOTimezoneObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUTZNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamISOTimezoneObj> readISOTimezoneByIso8601Idx( String Iso8601 )
	{
		return( readISOTimezoneByIso8601Idx( Iso8601,
			false ) );
	}

	public List<ICFBamISOTimezoneObj> readISOTimezoneByIso8601Idx( String Iso8601,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTimezoneByIso8601Idx";
		CFBamISOTimezoneByIso8601IdxKey key = schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> dict;
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< CFBamISOTimezoneByIso8601IdxKey,
				Map< CFBamISOTimezonePKey, ICFBamISOTimezoneObj > >();
		}
		if( ( ! forceRead ) && indexByIso8601Idx.containsKey( key ) ) {
			dict = indexByIso8601Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOTimezonePKey, ICFBamISOTimezoneObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIso8601Idx.put( key, dict );
			ICFBamISOTimezoneObj obj;
			CFBamISOTimezoneBuff[] buffList = schema.getBackingStore().getTableISOTimezone().readDerivedByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
			CFBamISOTimezoneBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOTimezoneTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOTimezone().newPKey() );
				obj.setBuff( buff );
				ICFBamISOTimezoneObj realized = (ICFBamISOTimezoneObj)obj.realize();
			}
		}
		Comparator<ICFBamISOTimezoneObj> cmp = new Comparator<ICFBamISOTimezoneObj>() {
			public int compare( ICFBamISOTimezoneObj lhs, ICFBamISOTimezoneObj rhs ) {
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
					CFBamISOTimezonePKey lhsPKey = lhs.getPKey();
					CFBamISOTimezonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOTimezoneObj arr[] = new ICFBamISOTimezoneObj[len];
		Iterator<ICFBamISOTimezoneObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOTimezoneObj> arrayList = new ArrayList<ICFBamISOTimezoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOTimezoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOTimezoneObj updateISOTimezone( ICFBamISOTimezoneObj Obj ) {
		ICFBamISOTimezoneObj obj = Obj;
		schema.getBackingStore().getTableISOTimezone().updateISOTimezone( schema.getAuthorization(),
			Obj.getISOTimezoneBuff() );
		obj = (ICFBamISOTimezoneObj)Obj.realize();
		return( obj );
	}

	public void deleteISOTimezone( ICFBamISOTimezoneObj Obj ) {
		ICFBamISOTimezoneObj obj = Obj;
		schema.getBackingStore().getTableISOTimezone().deleteISOTimezone( schema.getAuthorization(),
			obj.getISOTimezoneBuff() );
		obj.forget( true );
	}

	public void deleteISOTimezoneByIdIdx( short ISOTimezoneId )
	{
		CFBamISOTimezonePKey pkey = schema.getBackingStore().getFactoryISOTimezone().newPKey();
		pkey.setRequiredISOTimezoneId( ISOTimezoneId );
		ICFBamISOTimezoneObj obj = readISOTimezone( pkey );
		if( obj != null ) {
			ICFBamISOTimezoneEditObj editObj = (ICFBamISOTimezoneEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOTimezoneEditObj)obj.beginEdit();
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

	public void deleteISOTimezoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		CFBamISOTimezoneByOffsetIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< CFBamISOTimezoneByOffsetIdxKey,
				Map< CFBamISOTimezonePKey, ICFBamISOTimezoneObj > >();
		}
		if( indexByOffsetIdx.containsKey( key ) ) {
			Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> dict = indexByOffsetIdx.get( key );
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
			Iterator<ICFBamISOTimezoneObj> iter = dict.values().iterator();
			ICFBamISOTimezoneObj obj;
			List<ICFBamISOTimezoneObj> toForget = new LinkedList<ICFBamISOTimezoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByOffsetIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
		}
	}

	public void deleteISOTimezoneByUTZNameIdx( String TZName )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< CFBamISOTimezoneByUTZNameIdxKey,
				ICFBamISOTimezoneObj >();
		}
		CFBamISOTimezoneByUTZNameIdxKey key = schema.getBackingStore().getFactoryISOTimezone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ICFBamISOTimezoneObj obj = null;
		if( indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByUTZNameIdx( schema.getAuthorization(),
				TZName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByUTZNameIdx( schema.getAuthorization(),
				TZName );
		}
	}

	public void deleteISOTimezoneByIso8601Idx( String Iso8601 )
	{
		CFBamISOTimezoneByIso8601IdxKey key = schema.getBackingStore().getFactoryISOTimezone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< CFBamISOTimezoneByIso8601IdxKey,
				Map< CFBamISOTimezonePKey, ICFBamISOTimezoneObj > >();
		}
		if( indexByIso8601Idx.containsKey( key ) ) {
			Map<CFBamISOTimezonePKey, ICFBamISOTimezoneObj> dict = indexByIso8601Idx.get( key );
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
			Iterator<ICFBamISOTimezoneObj> iter = dict.values().iterator();
			ICFBamISOTimezoneObj obj;
			List<ICFBamISOTimezoneObj> toForget = new LinkedList<ICFBamISOTimezoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIso8601Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOTimezone().deleteISOTimezoneByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
		}
	}
}
