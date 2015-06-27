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

public class CFBamISOLanguageTableObj
	implements ICFBamISOLanguageTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> members;
	private Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> allISOLanguage;
	private Map< CFBamISOLanguageByBaseIdxKey,
		Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > > indexByBaseIdx;
	private Map< CFBamISOLanguageByCountryIdxKey,
		Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > > indexByCountryIdx;
	private Map< CFBamISOLanguageByCodeIdxKey,
		ICFBamISOLanguageObj > indexByCodeIdx;
	public static String TABLE_NAME = "ISOLanguage";
	public static String TABLE_DBNAME = "iso_lang";

	public CFBamISOLanguageTableObj() {
		schema = null;
		members = new HashMap<CFBamISOLanguagePKey, ICFBamISOLanguageObj>();
		allISOLanguage = null;
		indexByBaseIdx = null;
		indexByCountryIdx = null;
		indexByCodeIdx = null;
	}

	public CFBamISOLanguageTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOLanguagePKey, ICFBamISOLanguageObj>();
		allISOLanguage = null;
		indexByBaseIdx = null;
		indexByCountryIdx = null;
		indexByCodeIdx = null;
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
		allISOLanguage = null;
		indexByBaseIdx = null;
		indexByCountryIdx = null;
		indexByCodeIdx = null;
		List<ICFBamISOLanguageObj> toForget = new LinkedList<ICFBamISOLanguageObj>();
		ICFBamISOLanguageObj cur = null;
		Iterator<ICFBamISOLanguageObj> iter = members.values().iterator();
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
	 *	CFBamISOLanguageObj.
	 */
	public ICFBamISOLanguageObj newInstance() {
		ICFBamISOLanguageObj inst = new CFBamISOLanguageObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOLanguageObj.
	 */
	public ICFBamISOLanguageEditObj newEditInstance( ICFBamISOLanguageObj orig ) {
		ICFBamISOLanguageEditObj edit = new CFBamISOLanguageEditObj( orig );
		return( edit );
	}

	public ICFBamISOLanguageObj realizeISOLanguage( ICFBamISOLanguageObj Obj ) {
		ICFBamISOLanguageObj obj = Obj;
		CFBamISOLanguagePKey pkey = obj.getPKey();
		ICFBamISOLanguageObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOLanguageObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByBaseIdx != null ) {
				CFBamISOLanguageByBaseIdxKey keyBaseIdx =
					schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
				keyBaseIdx.setRequiredBaseLanguageCode( keepObj.getRequiredBaseLanguageCode() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCountryIdx != null ) {
				CFBamISOLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
				keyCountryIdx.setOptionalISOCountryId( keepObj.getOptionalISOCountryId() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCodeIdx != null ) {
				CFBamISOLanguageByCodeIdxKey keyCodeIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
				keyCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCodeIdx.remove( keyCodeIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByBaseIdx != null ) {
				CFBamISOLanguageByBaseIdxKey keyBaseIdx =
					schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
				keyBaseIdx.setRequiredBaseLanguageCode( keepObj.getRequiredBaseLanguageCode() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCountryIdx != null ) {
				CFBamISOLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
				keyCountryIdx.setOptionalISOCountryId( keepObj.getOptionalISOCountryId() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCodeIdx != null ) {
				CFBamISOLanguageByCodeIdxKey keyCodeIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
				keyCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCodeIdx.put( keyCodeIdx, keepObj );
			}
			if( allISOLanguage != null ) {
				allISOLanguage.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOLanguage != null ) {
				allISOLanguage.put( keepObj.getPKey(), keepObj );
			}

			if( indexByBaseIdx != null ) {
				CFBamISOLanguageByBaseIdxKey keyBaseIdx =
					schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
				keyBaseIdx.setRequiredBaseLanguageCode( keepObj.getRequiredBaseLanguageCode() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCountryIdx != null ) {
				CFBamISOLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
				keyCountryIdx.setOptionalISOCountryId( keepObj.getOptionalISOCountryId() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCodeIdx != null ) {
				CFBamISOLanguageByCodeIdxKey keyCodeIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
				keyCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCodeIdx.put( keyCodeIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetISOLanguage( ICFBamISOLanguageObj Obj ) {
		forgetISOLanguage( Obj, false );
	}

	public void forgetISOLanguage( ICFBamISOLanguageObj Obj, boolean forgetSubObjects ) {
		ICFBamISOLanguageObj obj = Obj;
		CFBamISOLanguagePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOLanguageObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByBaseIdx != null ) {
				CFBamISOLanguageByBaseIdxKey keyBaseIdx =
					schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
				keyBaseIdx.setRequiredBaseLanguageCode( keepObj.getRequiredBaseLanguageCode() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCountryIdx != null ) {
				CFBamISOLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
				keyCountryIdx.setOptionalISOCountryId( keepObj.getOptionalISOCountryId() );
				Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByCodeIdx != null ) {
				CFBamISOLanguageByCodeIdxKey keyCodeIdx =
					schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
				keyCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCodeIdx.remove( keyCodeIdx );
			}

			if( allISOLanguage != null ) {
				allISOLanguage.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getISOCountryLanguageTableObj().forgetISOCountryLanguageByLanguageIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetISOLanguageByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamISOLanguagePKey key = schema.getBackingStore().getFactoryISOLanguage().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamISOLanguageObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOLanguageByBaseIdx( String BaseLanguageCode )
	{
		if( indexByBaseIdx == null ) {
			return;
		}
		CFBamISOLanguageByBaseIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( BaseLanguageCode );
		if( indexByBaseIdx.containsKey( key ) ) {
			Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapBaseIdx = indexByBaseIdx.get( key );
			if( mapBaseIdx != null ) {
				List<ICFBamISOLanguageObj> toForget = new LinkedList<ICFBamISOLanguageObj>();
				ICFBamISOLanguageObj cur = null;
				Iterator<ICFBamISOLanguageObj> iter = mapBaseIdx.values().iterator();
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

			indexByBaseIdx.remove( key );
		}
	}

	public void forgetISOLanguageByCountryIdx( Short ISOCountryId )
	{
		if( indexByCountryIdx == null ) {
			return;
		}
		CFBamISOLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( ISOCountryId );
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj > mapCountryIdx = indexByCountryIdx.get( key );
			if( mapCountryIdx != null ) {
				List<ICFBamISOLanguageObj> toForget = new LinkedList<ICFBamISOLanguageObj>();
				ICFBamISOLanguageObj cur = null;
				Iterator<ICFBamISOLanguageObj> iter = mapCountryIdx.values().iterator();
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

	public void forgetISOLanguageByCodeIdx( String ISOCode )
	{
		if( indexByCodeIdx == null ) {
			return;
		}
		CFBamISOLanguageByCodeIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByCodeIdx.containsKey( key ) ) {
			ICFBamISOLanguageObj probed = indexByCodeIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByCodeIdx.remove( key );
		}
	}

	public ICFBamISOLanguageObj createISOLanguage( ICFBamISOLanguageObj Obj ) {
		ICFBamISOLanguageObj obj = Obj;
		CFBamISOLanguageBuff buff = obj.getISOLanguageBuff();
		schema.getBackingStore().getTableISOLanguage().createISOLanguage(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOLanguageObj readISOLanguage( CFBamISOLanguagePKey pkey ) {
		return( readISOLanguage( pkey, false ) );
	}

	public ICFBamISOLanguageObj readISOLanguage( CFBamISOLanguagePKey pkey, boolean forceRead ) {
		ICFBamISOLanguageObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOLanguageBuff readBuff = schema.getBackingStore().getTableISOLanguage().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getISOLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOLanguageObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOLanguageObj lockISOLanguage( CFBamISOLanguagePKey pkey ) {
		ICFBamISOLanguageObj locked = null;
		CFBamISOLanguageBuff lockBuff = schema.getBackingStore().getTableISOLanguage().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOLanguageTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOLanguageObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOLanguage", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOLanguageObj> readAllISOLanguage() {
		return( readAllISOLanguage( false ) );
	}

	public List<ICFBamISOLanguageObj> readAllISOLanguage( boolean forceRead ) {
		final String S_ProcName = "readAllISOLanguage";
		if( ( allISOLanguage == null ) || forceRead ) {
			Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> map = new HashMap<CFBamISOLanguagePKey,ICFBamISOLanguageObj>();
			allISOLanguage = map;
			CFBamISOLanguageBuff[] buffList = schema.getBackingStore().getTableISOLanguage().readAllDerived( schema.getAuthorization() );
			CFBamISOLanguageBuff buff;
			ICFBamISOLanguageObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOLanguageObj realized = (ICFBamISOLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOLanguageObj> cmp = new Comparator<ICFBamISOLanguageObj>() {
			public int compare( ICFBamISOLanguageObj lhs, ICFBamISOLanguageObj rhs ) {
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
					CFBamISOLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOLanguage.size();
		ICFBamISOLanguageObj arr[] = new ICFBamISOLanguageObj[len];
		Iterator<ICFBamISOLanguageObj> valIter = allISOLanguage.values().iterator();
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
		ArrayList<ICFBamISOLanguageObj> arrayList = new ArrayList<ICFBamISOLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOLanguageObj readISOLanguageByIdIdx( short Id )
	{
		return( readISOLanguageByIdIdx( Id,
			false ) );
	}

	public ICFBamISOLanguageObj readISOLanguageByIdIdx( short Id, boolean forceRead )
	{
		CFBamISOLanguagePKey pkey = schema.getBackingStore().getFactoryISOLanguage().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOLanguageObj obj = readISOLanguage( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamISOLanguageObj> readISOLanguageByBaseIdx( String BaseLanguageCode )
	{
		return( readISOLanguageByBaseIdx( BaseLanguageCode,
			false ) );
	}

	public List<ICFBamISOLanguageObj> readISOLanguageByBaseIdx( String BaseLanguageCode,
		boolean forceRead )
	{
		final String S_ProcName = "readISOLanguageByBaseIdx";
		CFBamISOLanguageByBaseIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( BaseLanguageCode );
		Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> dict;
		if( indexByBaseIdx == null ) {
			indexByBaseIdx = new HashMap< CFBamISOLanguageByBaseIdxKey,
				Map< CFBamISOLanguagePKey, ICFBamISOLanguageObj > >();
		}
		if( ( ! forceRead ) && indexByBaseIdx.containsKey( key ) ) {
			dict = indexByBaseIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOLanguagePKey, ICFBamISOLanguageObj>();
			// Allow other threads to dirty-read while we're loading
			indexByBaseIdx.put( key, dict );
			ICFBamISOLanguageObj obj;
			CFBamISOLanguageBuff[] buffList = schema.getBackingStore().getTableISOLanguage().readDerivedByBaseIdx( schema.getAuthorization(),
				BaseLanguageCode );
			CFBamISOLanguageBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOLanguageObj realized = (ICFBamISOLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOLanguageObj> cmp = new Comparator<ICFBamISOLanguageObj>() {
			public int compare( ICFBamISOLanguageObj lhs, ICFBamISOLanguageObj rhs ) {
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
					CFBamISOLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOLanguageObj arr[] = new ICFBamISOLanguageObj[len];
		Iterator<ICFBamISOLanguageObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOLanguageObj> arrayList = new ArrayList<ICFBamISOLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamISOLanguageObj> readISOLanguageByCountryIdx( Short ISOCountryId )
	{
		return( readISOLanguageByCountryIdx( ISOCountryId,
			false ) );
	}

	public List<ICFBamISOLanguageObj> readISOLanguageByCountryIdx( Short ISOCountryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOLanguageByCountryIdx";
		CFBamISOLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( ISOCountryId );
		Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> dict;
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOLanguageByCountryIdxKey,
				Map< CFBamISOLanguagePKey, ICFBamISOLanguageObj > >();
		}
		if( ( ! forceRead ) && indexByCountryIdx.containsKey( key ) ) {
			dict = indexByCountryIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOLanguagePKey, ICFBamISOLanguageObj>();
			// Allow other threads to dirty-read while we're loading
			indexByCountryIdx.put( key, dict );
			ICFBamISOLanguageObj obj;
			CFBamISOLanguageBuff[] buffList = schema.getBackingStore().getTableISOLanguage().readDerivedByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			CFBamISOLanguageBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOLanguageObj realized = (ICFBamISOLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOLanguageObj> cmp = new Comparator<ICFBamISOLanguageObj>() {
			public int compare( ICFBamISOLanguageObj lhs, ICFBamISOLanguageObj rhs ) {
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
					CFBamISOLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOLanguageObj arr[] = new ICFBamISOLanguageObj[len];
		Iterator<ICFBamISOLanguageObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOLanguageObj> arrayList = new ArrayList<ICFBamISOLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOLanguageObj readISOLanguageByCodeIdx( String ISOCode )
	{
		return( readISOLanguageByCodeIdx( ISOCode,
			false ) );
	}

	public ICFBamISOLanguageObj readISOLanguageByCodeIdx( String ISOCode, boolean forceRead )
	{
		if( indexByCodeIdx == null ) {
			indexByCodeIdx = new HashMap< CFBamISOLanguageByCodeIdxKey,
				ICFBamISOLanguageObj >();
		}
		CFBamISOLanguageByCodeIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOLanguageObj obj = null;
		if( ( ! forceRead ) && indexByCodeIdx.containsKey( key ) ) {
			obj = indexByCodeIdx.get( key );
		}
		else {
			CFBamISOLanguageBuff buff = schema.getBackingStore().getTableISOLanguage().readDerivedByCodeIdx( schema.getAuthorization(),
				ISOCode );
			if( buff != null ) {
				obj = schema.getISOLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOLanguage().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOLanguageObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByCodeIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamISOLanguageObj updateISOLanguage( ICFBamISOLanguageObj Obj ) {
		ICFBamISOLanguageObj obj = Obj;
		schema.getBackingStore().getTableISOLanguage().updateISOLanguage( schema.getAuthorization(),
			Obj.getISOLanguageBuff() );
		obj = (ICFBamISOLanguageObj)Obj.realize();
		return( obj );
	}

	public void deleteISOLanguage( ICFBamISOLanguageObj Obj ) {
		ICFBamISOLanguageObj obj = Obj;
		schema.getBackingStore().getTableISOLanguage().deleteISOLanguage( schema.getAuthorization(),
			obj.getISOLanguageBuff() );
		obj.forget( true );
	}

	public void deleteISOLanguageByIdIdx( short Id )
	{
		CFBamISOLanguagePKey pkey = schema.getBackingStore().getFactoryISOLanguage().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOLanguageObj obj = readISOLanguage( pkey );
		if( obj != null ) {
			ICFBamISOLanguageEditObj editObj = (ICFBamISOLanguageEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOLanguageEditObj)obj.beginEdit();
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

	public void deleteISOLanguageByBaseIdx( String BaseLanguageCode )
	{
		CFBamISOLanguageByBaseIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newBaseIdxKey();
		key.setRequiredBaseLanguageCode( BaseLanguageCode );
		if( indexByBaseIdx == null ) {
			indexByBaseIdx = new HashMap< CFBamISOLanguageByBaseIdxKey,
				Map< CFBamISOLanguagePKey, ICFBamISOLanguageObj > >();
		}
		if( indexByBaseIdx.containsKey( key ) ) {
			Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> dict = indexByBaseIdx.get( key );
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByBaseIdx( schema.getAuthorization(),
				BaseLanguageCode );
			Iterator<ICFBamISOLanguageObj> iter = dict.values().iterator();
			ICFBamISOLanguageObj obj;
			List<ICFBamISOLanguageObj> toForget = new LinkedList<ICFBamISOLanguageObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByBaseIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByBaseIdx( schema.getAuthorization(),
				BaseLanguageCode );
		}
	}

	public void deleteISOLanguageByCountryIdx( Short ISOCountryId )
	{
		CFBamISOLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCountryIdxKey();
		key.setOptionalISOCountryId( ISOCountryId );
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOLanguageByCountryIdxKey,
				Map< CFBamISOLanguagePKey, ICFBamISOLanguageObj > >();
		}
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOLanguagePKey, ICFBamISOLanguageObj> dict = indexByCountryIdx.get( key );
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			Iterator<ICFBamISOLanguageObj> iter = dict.values().iterator();
			ICFBamISOLanguageObj obj;
			List<ICFBamISOLanguageObj> toForget = new LinkedList<ICFBamISOLanguageObj>();
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
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
		}
	}

	public void deleteISOLanguageByCodeIdx( String ISOCode )
	{
		if( indexByCodeIdx == null ) {
			indexByCodeIdx = new HashMap< CFBamISOLanguageByCodeIdxKey,
				ICFBamISOLanguageObj >();
		}
		CFBamISOLanguageByCodeIdxKey key = schema.getBackingStore().getFactoryISOLanguage().newCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOLanguageObj obj = null;
		if( indexByCodeIdx.containsKey( key ) ) {
			obj = indexByCodeIdx.get( key );
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByCodeIdx( schema.getAuthorization(),
				ISOCode );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOLanguage().deleteISOLanguageByCodeIdx( schema.getAuthorization(),
				ISOCode );
		}
	}
}
