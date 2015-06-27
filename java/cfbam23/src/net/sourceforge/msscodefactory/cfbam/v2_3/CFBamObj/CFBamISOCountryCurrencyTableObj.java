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

public class CFBamISOCountryCurrencyTableObj
	implements ICFBamISOCountryCurrencyTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> members;
	private Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> allISOCountryCurrency;
	private Map< CFBamISOCountryCurrencyByCountryIdxKey,
		Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > > indexByCountryIdx;
	private Map< CFBamISOCountryCurrencyByCurrencyIdxKey,
		Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > > indexByCurrencyIdx;
	public static String TABLE_NAME = "ISOCountryCurrency";
	public static String TABLE_DBNAME = "iso_cntryccy";

	public CFBamISOCountryCurrencyTableObj() {
		schema = null;
		members = new HashMap<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj>();
		allISOCountryCurrency = null;
		indexByCountryIdx = null;
		indexByCurrencyIdx = null;
	}

	public CFBamISOCountryCurrencyTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj>();
		allISOCountryCurrency = null;
		indexByCountryIdx = null;
		indexByCurrencyIdx = null;
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
		allISOCountryCurrency = null;
		indexByCountryIdx = null;
		indexByCurrencyIdx = null;
		List<ICFBamISOCountryCurrencyObj> toForget = new LinkedList<ICFBamISOCountryCurrencyObj>();
		ICFBamISOCountryCurrencyObj cur = null;
		Iterator<ICFBamISOCountryCurrencyObj> iter = members.values().iterator();
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
	 *	CFBamISOCountryCurrencyObj.
	 */
	public ICFBamISOCountryCurrencyObj newInstance() {
		ICFBamISOCountryCurrencyObj inst = new CFBamISOCountryCurrencyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCountryCurrencyObj.
	 */
	public ICFBamISOCountryCurrencyEditObj newEditInstance( ICFBamISOCountryCurrencyObj orig ) {
		ICFBamISOCountryCurrencyEditObj edit = new CFBamISOCountryCurrencyEditObj( orig );
		return( edit );
	}

	public ICFBamISOCountryCurrencyObj realizeISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj ) {
		ICFBamISOCountryCurrencyObj obj = Obj;
		CFBamISOCountryCurrencyPKey pkey = obj.getPKey();
		ICFBamISOCountryCurrencyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOCountryCurrencyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCountryIdx != null ) {
				CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCurrencyIdx != null ) {
				CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
				keyCurrencyIdx.setRequiredISOCurrencyId( keepObj.getRequiredISOCurrencyId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCurrencyIdx = indexByCurrencyIdx.get( keyCurrencyIdx );
				if( mapCurrencyIdx != null ) {
					mapCurrencyIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCountryIdx != null ) {
				CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCurrencyIdx != null ) {
				CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
				keyCurrencyIdx.setRequiredISOCurrencyId( keepObj.getRequiredISOCurrencyId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCurrencyIdx = indexByCurrencyIdx.get( keyCurrencyIdx );
				if( mapCurrencyIdx != null ) {
					mapCurrencyIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allISOCountryCurrency != null ) {
				allISOCountryCurrency.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCountryCurrency != null ) {
				allISOCountryCurrency.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCountryIdx != null ) {
				CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCurrencyIdx != null ) {
				CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
				keyCurrencyIdx.setRequiredISOCurrencyId( keepObj.getRequiredISOCurrencyId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCurrencyIdx = indexByCurrencyIdx.get( keyCurrencyIdx );
				if( mapCurrencyIdx != null ) {
					mapCurrencyIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj ) {
		forgetISOCountryCurrency( Obj, false );
	}

	public void forgetISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj, boolean forgetSubObjects ) {
		ICFBamISOCountryCurrencyObj obj = Obj;
		CFBamISOCountryCurrencyPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOCountryCurrencyObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCountryIdx != null ) {
				CFBamISOCountryCurrencyByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCurrencyIdx != null ) {
				CFBamISOCountryCurrencyByCurrencyIdxKey keyCurrencyIdx =
					schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
				keyCurrencyIdx.setRequiredISOCurrencyId( keepObj.getRequiredISOCurrencyId() );
				Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCurrencyIdx = indexByCurrencyIdx.get( keyCurrencyIdx );
				if( mapCurrencyIdx != null ) {
					mapCurrencyIdx.remove( keepObj.getPKey() );
				}
			}

			if( allISOCountryCurrency != null ) {
				allISOCountryCurrency.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId )
	{
		if( members == null ) {
			return;
		}
		CFBamISOCountryCurrencyPKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newPKey();
		key.setRequiredISOCountryId( ISOCountryId );
		key.setRequiredISOCurrencyId( ISOCurrencyId );
		if( members.containsKey( key ) ) {
			ICFBamISOCountryCurrencyObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCountryCurrencyByCountryIdx( short ISOCountryId )
	{
		if( indexByCountryIdx == null ) {
			return;
		}
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCountryIdx = indexByCountryIdx.get( key );
			if( mapCountryIdx != null ) {
				List<ICFBamISOCountryCurrencyObj> toForget = new LinkedList<ICFBamISOCountryCurrencyObj>();
				ICFBamISOCountryCurrencyObj cur = null;
				Iterator<ICFBamISOCountryCurrencyObj> iter = mapCountryIdx.values().iterator();
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

			indexByCountryIdx.remove( key );
		}
	}

	public void forgetISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId )
	{
		if( indexByCurrencyIdx == null ) {
			return;
		}
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( ISOCurrencyId );
		if( indexByCurrencyIdx.containsKey( key ) ) {
			Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > mapCurrencyIdx = indexByCurrencyIdx.get( key );
			if( mapCurrencyIdx != null ) {
				List<ICFBamISOCountryCurrencyObj> toForget = new LinkedList<ICFBamISOCountryCurrencyObj>();
				ICFBamISOCountryCurrencyObj cur = null;
				Iterator<ICFBamISOCountryCurrencyObj> iter = mapCurrencyIdx.values().iterator();
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

			indexByCurrencyIdx.remove( key );
		}
	}

	public ICFBamISOCountryCurrencyObj createISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj ) {
		ICFBamISOCountryCurrencyObj obj = Obj;
		CFBamISOCountryCurrencyBuff buff = obj.getISOCountryCurrencyBuff();
		schema.getBackingStore().getTableISOCountryCurrency().createISOCountryCurrency(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOCountryCurrencyObj readISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey ) {
		return( readISOCountryCurrency( pkey, false ) );
	}

	public ICFBamISOCountryCurrencyObj readISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey, boolean forceRead ) {
		ICFBamISOCountryCurrencyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOCountryCurrencyBuff readBuff = schema.getBackingStore().getTableISOCountryCurrency().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCountryId(),
				pkey.getRequiredISOCurrencyId() );
			if( readBuff != null ) {
				obj = schema.getISOCountryCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryCurrency().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOCountryCurrencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCountryCurrencyObj lockISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey ) {
		ICFBamISOCountryCurrencyObj locked = null;
		CFBamISOCountryCurrencyBuff lockBuff = schema.getBackingStore().getTableISOCountryCurrency().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCountryCurrencyTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOCountryCurrency().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOCountryCurrencyObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOCountryCurrency", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOCountryCurrencyObj> readAllISOCountryCurrency() {
		return( readAllISOCountryCurrency( false ) );
	}

	public List<ICFBamISOCountryCurrencyObj> readAllISOCountryCurrency( boolean forceRead ) {
		final String S_ProcName = "readAllISOCountryCurrency";
		if( ( allISOCountryCurrency == null ) || forceRead ) {
			Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> map = new HashMap<CFBamISOCountryCurrencyPKey,ICFBamISOCountryCurrencyObj>();
			allISOCountryCurrency = map;
			CFBamISOCountryCurrencyBuff[] buffList = schema.getBackingStore().getTableISOCountryCurrency().readAllDerived( schema.getAuthorization() );
			CFBamISOCountryCurrencyBuff buff;
			ICFBamISOCountryCurrencyObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryCurrency().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryCurrencyObj realized = (ICFBamISOCountryCurrencyObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryCurrencyObj> cmp = new Comparator<ICFBamISOCountryCurrencyObj>() {
			public int compare( ICFBamISOCountryCurrencyObj lhs, ICFBamISOCountryCurrencyObj rhs ) {
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
					CFBamISOCountryCurrencyPKey lhsPKey = lhs.getPKey();
					CFBamISOCountryCurrencyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOCountryCurrency.size();
		ICFBamISOCountryCurrencyObj arr[] = new ICFBamISOCountryCurrencyObj[len];
		Iterator<ICFBamISOCountryCurrencyObj> valIter = allISOCountryCurrency.values().iterator();
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
		ArrayList<ICFBamISOCountryCurrencyObj> arrayList = new ArrayList<ICFBamISOCountryCurrencyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryCurrencyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCountryCurrencyObj readISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId )
	{
		return( readISOCountryCurrencyByIdIdx( ISOCountryId,
			ISOCurrencyId,
			false ) );
	}

	public ICFBamISOCountryCurrencyObj readISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId, boolean forceRead )
	{
		CFBamISOCountryCurrencyPKey pkey = schema.getBackingStore().getFactoryISOCountryCurrency().newPKey();
		pkey.setRequiredISOCountryId( ISOCountryId );
		pkey.setRequiredISOCurrencyId( ISOCurrencyId );
		ICFBamISOCountryCurrencyObj obj = readISOCountryCurrency( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCountryIdx( short ISOCountryId )
	{
		return( readISOCountryCurrencyByCountryIdx( ISOCountryId,
			false ) );
	}

	public List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCountryIdx( short ISOCountryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCountryCurrencyByCountryIdx";
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> dict;
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOCountryCurrencyByCountryIdxKey,
				Map< CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > >();
		}
		if( ( ! forceRead ) && indexByCountryIdx.containsKey( key ) ) {
			dict = indexByCountryIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj>();
			// Allow other threads to dirty-read while we're loading
			indexByCountryIdx.put( key, dict );
			ICFBamISOCountryCurrencyObj obj;
			CFBamISOCountryCurrencyBuff[] buffList = schema.getBackingStore().getTableISOCountryCurrency().readDerivedByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			CFBamISOCountryCurrencyBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCountryCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryCurrency().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryCurrencyObj realized = (ICFBamISOCountryCurrencyObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryCurrencyObj> cmp = new Comparator<ICFBamISOCountryCurrencyObj>() {
			public int compare( ICFBamISOCountryCurrencyObj lhs, ICFBamISOCountryCurrencyObj rhs ) {
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
					CFBamISOCountryCurrencyPKey lhsPKey = lhs.getPKey();
					CFBamISOCountryCurrencyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOCountryCurrencyObj arr[] = new ICFBamISOCountryCurrencyObj[len];
		Iterator<ICFBamISOCountryCurrencyObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOCountryCurrencyObj> arrayList = new ArrayList<ICFBamISOCountryCurrencyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryCurrencyObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId )
	{
		return( readISOCountryCurrencyByCurrencyIdx( ISOCurrencyId,
			false ) );
	}

	public List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCountryCurrencyByCurrencyIdx";
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( ISOCurrencyId );
		Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> dict;
		if( indexByCurrencyIdx == null ) {
			indexByCurrencyIdx = new HashMap< CFBamISOCountryCurrencyByCurrencyIdxKey,
				Map< CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > >();
		}
		if( ( ! forceRead ) && indexByCurrencyIdx.containsKey( key ) ) {
			dict = indexByCurrencyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj>();
			// Allow other threads to dirty-read while we're loading
			indexByCurrencyIdx.put( key, dict );
			ICFBamISOCountryCurrencyObj obj;
			CFBamISOCountryCurrencyBuff[] buffList = schema.getBackingStore().getTableISOCountryCurrency().readDerivedByCurrencyIdx( schema.getAuthorization(),
				ISOCurrencyId );
			CFBamISOCountryCurrencyBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCountryCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryCurrency().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryCurrencyObj realized = (ICFBamISOCountryCurrencyObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryCurrencyObj> cmp = new Comparator<ICFBamISOCountryCurrencyObj>() {
			public int compare( ICFBamISOCountryCurrencyObj lhs, ICFBamISOCountryCurrencyObj rhs ) {
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
					CFBamISOCountryCurrencyPKey lhsPKey = lhs.getPKey();
					CFBamISOCountryCurrencyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOCountryCurrencyObj arr[] = new ICFBamISOCountryCurrencyObj[len];
		Iterator<ICFBamISOCountryCurrencyObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOCountryCurrencyObj> arrayList = new ArrayList<ICFBamISOCountryCurrencyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryCurrencyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCountryCurrencyObj updateISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj ) {
		ICFBamISOCountryCurrencyObj obj = Obj;
		schema.getBackingStore().getTableISOCountryCurrency().updateISOCountryCurrency( schema.getAuthorization(),
			Obj.getISOCountryCurrencyBuff() );
		obj = (ICFBamISOCountryCurrencyObj)Obj.realize();
		return( obj );
	}

	public void deleteISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj ) {
		ICFBamISOCountryCurrencyObj obj = Obj;
		schema.getBackingStore().getTableISOCountryCurrency().deleteISOCountryCurrency( schema.getAuthorization(),
			obj.getISOCountryCurrencyBuff() );
		obj.forget( true );
	}

	public void deleteISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId )
	{
		CFBamISOCountryCurrencyPKey pkey = schema.getBackingStore().getFactoryISOCountryCurrency().newPKey();
		pkey.setRequiredISOCountryId( ISOCountryId );
		pkey.setRequiredISOCurrencyId( ISOCurrencyId );
		ICFBamISOCountryCurrencyObj obj = readISOCountryCurrency( pkey );
		if( obj != null ) {
			ICFBamISOCountryCurrencyEditObj editObj = (ICFBamISOCountryCurrencyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOCountryCurrencyEditObj)obj.beginEdit();
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

	public void deleteISOCountryCurrencyByCountryIdx( short ISOCountryId )
	{
		CFBamISOCountryCurrencyByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOCountryCurrencyByCountryIdxKey,
				Map< CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > >();
		}
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> dict = indexByCountryIdx.get( key );
			schema.getBackingStore().getTableISOCountryCurrency().deleteISOCountryCurrencyByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			Iterator<ICFBamISOCountryCurrencyObj> iter = dict.values().iterator();
			ICFBamISOCountryCurrencyObj obj;
			List<ICFBamISOCountryCurrencyObj> toForget = new LinkedList<ICFBamISOCountryCurrencyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCountryIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOCountryCurrency().deleteISOCountryCurrencyByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
		}
	}

	public void deleteISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId )
	{
		CFBamISOCountryCurrencyByCurrencyIdxKey key = schema.getBackingStore().getFactoryISOCountryCurrency().newCurrencyIdxKey();
		key.setRequiredISOCurrencyId( ISOCurrencyId );
		if( indexByCurrencyIdx == null ) {
			indexByCurrencyIdx = new HashMap< CFBamISOCountryCurrencyByCurrencyIdxKey,
				Map< CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj > >();
		}
		if( indexByCurrencyIdx.containsKey( key ) ) {
			Map<CFBamISOCountryCurrencyPKey, ICFBamISOCountryCurrencyObj> dict = indexByCurrencyIdx.get( key );
			schema.getBackingStore().getTableISOCountryCurrency().deleteISOCountryCurrencyByCurrencyIdx( schema.getAuthorization(),
				ISOCurrencyId );
			Iterator<ICFBamISOCountryCurrencyObj> iter = dict.values().iterator();
			ICFBamISOCountryCurrencyObj obj;
			List<ICFBamISOCountryCurrencyObj> toForget = new LinkedList<ICFBamISOCountryCurrencyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCurrencyIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOCountryCurrency().deleteISOCountryCurrencyByCurrencyIdx( schema.getAuthorization(),
				ISOCurrencyId );
		}
	}
}
