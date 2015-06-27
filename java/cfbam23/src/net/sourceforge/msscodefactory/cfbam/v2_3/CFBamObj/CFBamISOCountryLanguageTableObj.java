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

public class CFBamISOCountryLanguageTableObj
	implements ICFBamISOCountryLanguageTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> members;
	private Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> allISOCountryLanguage;
	private Map< CFBamISOCountryLanguageByCountryIdxKey,
		Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > > indexByCountryIdx;
	private Map< CFBamISOCountryLanguageByLanguageIdxKey,
		Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > > indexByLanguageIdx;
	public static String TABLE_NAME = "ISOCountryLanguage";
	public static String TABLE_DBNAME = "iso_cntrylng";

	public CFBamISOCountryLanguageTableObj() {
		schema = null;
		members = new HashMap<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj>();
		allISOCountryLanguage = null;
		indexByCountryIdx = null;
		indexByLanguageIdx = null;
	}

	public CFBamISOCountryLanguageTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj>();
		allISOCountryLanguage = null;
		indexByCountryIdx = null;
		indexByLanguageIdx = null;
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
		allISOCountryLanguage = null;
		indexByCountryIdx = null;
		indexByLanguageIdx = null;
		List<ICFBamISOCountryLanguageObj> toForget = new LinkedList<ICFBamISOCountryLanguageObj>();
		ICFBamISOCountryLanguageObj cur = null;
		Iterator<ICFBamISOCountryLanguageObj> iter = members.values().iterator();
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
	 *	CFBamISOCountryLanguageObj.
	 */
	public ICFBamISOCountryLanguageObj newInstance() {
		ICFBamISOCountryLanguageObj inst = new CFBamISOCountryLanguageObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCountryLanguageObj.
	 */
	public ICFBamISOCountryLanguageEditObj newEditInstance( ICFBamISOCountryLanguageObj orig ) {
		ICFBamISOCountryLanguageEditObj edit = new CFBamISOCountryLanguageEditObj( orig );
		return( edit );
	}

	public ICFBamISOCountryLanguageObj realizeISOCountryLanguage( ICFBamISOCountryLanguageObj Obj ) {
		ICFBamISOCountryLanguageObj obj = Obj;
		CFBamISOCountryLanguagePKey pkey = obj.getPKey();
		ICFBamISOCountryLanguageObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOCountryLanguageObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCountryIdx != null ) {
				CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLanguageIdx != null ) {
				CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
				keyLanguageIdx.setRequiredISOLanguageId( keepObj.getRequiredISOLanguageId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapLanguageIdx = indexByLanguageIdx.get( keyLanguageIdx );
				if( mapLanguageIdx != null ) {
					mapLanguageIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCountryIdx != null ) {
				CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLanguageIdx != null ) {
				CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
				keyLanguageIdx.setRequiredISOLanguageId( keepObj.getRequiredISOLanguageId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapLanguageIdx = indexByLanguageIdx.get( keyLanguageIdx );
				if( mapLanguageIdx != null ) {
					mapLanguageIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allISOCountryLanguage != null ) {
				allISOCountryLanguage.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCountryLanguage != null ) {
				allISOCountryLanguage.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCountryIdx != null ) {
				CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLanguageIdx != null ) {
				CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
				keyLanguageIdx.setRequiredISOLanguageId( keepObj.getRequiredISOLanguageId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapLanguageIdx = indexByLanguageIdx.get( keyLanguageIdx );
				if( mapLanguageIdx != null ) {
					mapLanguageIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetISOCountryLanguage( ICFBamISOCountryLanguageObj Obj ) {
		forgetISOCountryLanguage( Obj, false );
	}

	public void forgetISOCountryLanguage( ICFBamISOCountryLanguageObj Obj, boolean forgetSubObjects ) {
		ICFBamISOCountryLanguageObj obj = Obj;
		CFBamISOCountryLanguagePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOCountryLanguageObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCountryIdx != null ) {
				CFBamISOCountryLanguageByCountryIdxKey keyCountryIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
				keyCountryIdx.setRequiredISOCountryId( keepObj.getRequiredISOCountryId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapCountryIdx = indexByCountryIdx.get( keyCountryIdx );
				if( mapCountryIdx != null ) {
					mapCountryIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLanguageIdx != null ) {
				CFBamISOCountryLanguageByLanguageIdxKey keyLanguageIdx =
					schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
				keyLanguageIdx.setRequiredISOLanguageId( keepObj.getRequiredISOLanguageId() );
				Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapLanguageIdx = indexByLanguageIdx.get( keyLanguageIdx );
				if( mapLanguageIdx != null ) {
					mapLanguageIdx.remove( keepObj.getPKey() );
				}
			}

			if( allISOCountryLanguage != null ) {
				allISOCountryLanguage.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOCountryLanguageByIdIdx( short ISOCountryId,
		short ISOLanguageId )
	{
		if( members == null ) {
			return;
		}
		CFBamISOCountryLanguagePKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newPKey();
		key.setRequiredISOCountryId( ISOCountryId );
		key.setRequiredISOLanguageId( ISOLanguageId );
		if( members.containsKey( key ) ) {
			ICFBamISOCountryLanguageObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCountryLanguageByCountryIdx( short ISOCountryId )
	{
		if( indexByCountryIdx == null ) {
			return;
		}
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapCountryIdx = indexByCountryIdx.get( key );
			if( mapCountryIdx != null ) {
				List<ICFBamISOCountryLanguageObj> toForget = new LinkedList<ICFBamISOCountryLanguageObj>();
				ICFBamISOCountryLanguageObj cur = null;
				Iterator<ICFBamISOCountryLanguageObj> iter = mapCountryIdx.values().iterator();
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

	public void forgetISOCountryLanguageByLanguageIdx( short ISOLanguageId )
	{
		if( indexByLanguageIdx == null ) {
			return;
		}
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( ISOLanguageId );
		if( indexByLanguageIdx.containsKey( key ) ) {
			Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > mapLanguageIdx = indexByLanguageIdx.get( key );
			if( mapLanguageIdx != null ) {
				List<ICFBamISOCountryLanguageObj> toForget = new LinkedList<ICFBamISOCountryLanguageObj>();
				ICFBamISOCountryLanguageObj cur = null;
				Iterator<ICFBamISOCountryLanguageObj> iter = mapLanguageIdx.values().iterator();
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

			indexByLanguageIdx.remove( key );
		}
	}

	public ICFBamISOCountryLanguageObj createISOCountryLanguage( ICFBamISOCountryLanguageObj Obj ) {
		ICFBamISOCountryLanguageObj obj = Obj;
		CFBamISOCountryLanguageBuff buff = obj.getISOCountryLanguageBuff();
		schema.getBackingStore().getTableISOCountryLanguage().createISOCountryLanguage(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOCountryLanguageObj readISOCountryLanguage( CFBamISOCountryLanguagePKey pkey ) {
		return( readISOCountryLanguage( pkey, false ) );
	}

	public ICFBamISOCountryLanguageObj readISOCountryLanguage( CFBamISOCountryLanguagePKey pkey, boolean forceRead ) {
		ICFBamISOCountryLanguageObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOCountryLanguageBuff readBuff = schema.getBackingStore().getTableISOCountryLanguage().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCountryId(),
				pkey.getRequiredISOLanguageId() );
			if( readBuff != null ) {
				obj = schema.getISOCountryLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryLanguage().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOCountryLanguageObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCountryLanguageObj lockISOCountryLanguage( CFBamISOCountryLanguagePKey pkey ) {
		ICFBamISOCountryLanguageObj locked = null;
		CFBamISOCountryLanguageBuff lockBuff = schema.getBackingStore().getTableISOCountryLanguage().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCountryLanguageTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOCountryLanguage().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOCountryLanguageObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOCountryLanguage", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOCountryLanguageObj> readAllISOCountryLanguage() {
		return( readAllISOCountryLanguage( false ) );
	}

	public List<ICFBamISOCountryLanguageObj> readAllISOCountryLanguage( boolean forceRead ) {
		final String S_ProcName = "readAllISOCountryLanguage";
		if( ( allISOCountryLanguage == null ) || forceRead ) {
			Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> map = new HashMap<CFBamISOCountryLanguagePKey,ICFBamISOCountryLanguageObj>();
			allISOCountryLanguage = map;
			CFBamISOCountryLanguageBuff[] buffList = schema.getBackingStore().getTableISOCountryLanguage().readAllDerived( schema.getAuthorization() );
			CFBamISOCountryLanguageBuff buff;
			ICFBamISOCountryLanguageObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryLanguageObj realized = (ICFBamISOCountryLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryLanguageObj> cmp = new Comparator<ICFBamISOCountryLanguageObj>() {
			public int compare( ICFBamISOCountryLanguageObj lhs, ICFBamISOCountryLanguageObj rhs ) {
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
					CFBamISOCountryLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOCountryLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOCountryLanguage.size();
		ICFBamISOCountryLanguageObj arr[] = new ICFBamISOCountryLanguageObj[len];
		Iterator<ICFBamISOCountryLanguageObj> valIter = allISOCountryLanguage.values().iterator();
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
		ArrayList<ICFBamISOCountryLanguageObj> arrayList = new ArrayList<ICFBamISOCountryLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCountryLanguageObj readISOCountryLanguageByIdIdx( short ISOCountryId,
		short ISOLanguageId )
	{
		return( readISOCountryLanguageByIdIdx( ISOCountryId,
			ISOLanguageId,
			false ) );
	}

	public ICFBamISOCountryLanguageObj readISOCountryLanguageByIdIdx( short ISOCountryId,
		short ISOLanguageId, boolean forceRead )
	{
		CFBamISOCountryLanguagePKey pkey = schema.getBackingStore().getFactoryISOCountryLanguage().newPKey();
		pkey.setRequiredISOCountryId( ISOCountryId );
		pkey.setRequiredISOLanguageId( ISOLanguageId );
		ICFBamISOCountryLanguageObj obj = readISOCountryLanguage( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamISOCountryLanguageObj> readISOCountryLanguageByCountryIdx( short ISOCountryId )
	{
		return( readISOCountryLanguageByCountryIdx( ISOCountryId,
			false ) );
	}

	public List<ICFBamISOCountryLanguageObj> readISOCountryLanguageByCountryIdx( short ISOCountryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCountryLanguageByCountryIdx";
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> dict;
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOCountryLanguageByCountryIdxKey,
				Map< CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > >();
		}
		if( ( ! forceRead ) && indexByCountryIdx.containsKey( key ) ) {
			dict = indexByCountryIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj>();
			// Allow other threads to dirty-read while we're loading
			indexByCountryIdx.put( key, dict );
			ICFBamISOCountryLanguageObj obj;
			CFBamISOCountryLanguageBuff[] buffList = schema.getBackingStore().getTableISOCountryLanguage().readDerivedByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			CFBamISOCountryLanguageBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCountryLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryLanguageObj realized = (ICFBamISOCountryLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryLanguageObj> cmp = new Comparator<ICFBamISOCountryLanguageObj>() {
			public int compare( ICFBamISOCountryLanguageObj lhs, ICFBamISOCountryLanguageObj rhs ) {
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
					CFBamISOCountryLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOCountryLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOCountryLanguageObj arr[] = new ICFBamISOCountryLanguageObj[len];
		Iterator<ICFBamISOCountryLanguageObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOCountryLanguageObj> arrayList = new ArrayList<ICFBamISOCountryLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamISOCountryLanguageObj> readISOCountryLanguageByLanguageIdx( short ISOLanguageId )
	{
		return( readISOCountryLanguageByLanguageIdx( ISOLanguageId,
			false ) );
	}

	public List<ICFBamISOCountryLanguageObj> readISOCountryLanguageByLanguageIdx( short ISOLanguageId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCountryLanguageByLanguageIdx";
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( ISOLanguageId );
		Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> dict;
		if( indexByLanguageIdx == null ) {
			indexByLanguageIdx = new HashMap< CFBamISOCountryLanguageByLanguageIdxKey,
				Map< CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > >();
		}
		if( ( ! forceRead ) && indexByLanguageIdx.containsKey( key ) ) {
			dict = indexByLanguageIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj>();
			// Allow other threads to dirty-read while we're loading
			indexByLanguageIdx.put( key, dict );
			ICFBamISOCountryLanguageObj obj;
			CFBamISOCountryLanguageBuff[] buffList = schema.getBackingStore().getTableISOCountryLanguage().readDerivedByLanguageIdx( schema.getAuthorization(),
				ISOLanguageId );
			CFBamISOCountryLanguageBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCountryLanguageTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountryLanguage().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryLanguageObj realized = (ICFBamISOCountryLanguageObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryLanguageObj> cmp = new Comparator<ICFBamISOCountryLanguageObj>() {
			public int compare( ICFBamISOCountryLanguageObj lhs, ICFBamISOCountryLanguageObj rhs ) {
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
					CFBamISOCountryLanguagePKey lhsPKey = lhs.getPKey();
					CFBamISOCountryLanguagePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamISOCountryLanguageObj arr[] = new ICFBamISOCountryLanguageObj[len];
		Iterator<ICFBamISOCountryLanguageObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamISOCountryLanguageObj> arrayList = new ArrayList<ICFBamISOCountryLanguageObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryLanguageObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCountryLanguageObj updateISOCountryLanguage( ICFBamISOCountryLanguageObj Obj ) {
		ICFBamISOCountryLanguageObj obj = Obj;
		schema.getBackingStore().getTableISOCountryLanguage().updateISOCountryLanguage( schema.getAuthorization(),
			Obj.getISOCountryLanguageBuff() );
		obj = (ICFBamISOCountryLanguageObj)Obj.realize();
		return( obj );
	}

	public void deleteISOCountryLanguage( ICFBamISOCountryLanguageObj Obj ) {
		ICFBamISOCountryLanguageObj obj = Obj;
		schema.getBackingStore().getTableISOCountryLanguage().deleteISOCountryLanguage( schema.getAuthorization(),
			obj.getISOCountryLanguageBuff() );
		obj.forget( true );
	}

	public void deleteISOCountryLanguageByIdIdx( short ISOCountryId,
		short ISOLanguageId )
	{
		CFBamISOCountryLanguagePKey pkey = schema.getBackingStore().getFactoryISOCountryLanguage().newPKey();
		pkey.setRequiredISOCountryId( ISOCountryId );
		pkey.setRequiredISOLanguageId( ISOLanguageId );
		ICFBamISOCountryLanguageObj obj = readISOCountryLanguage( pkey );
		if( obj != null ) {
			ICFBamISOCountryLanguageEditObj editObj = (ICFBamISOCountryLanguageEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOCountryLanguageEditObj)obj.beginEdit();
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

	public void deleteISOCountryLanguageByCountryIdx( short ISOCountryId )
	{
		CFBamISOCountryLanguageByCountryIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newCountryIdxKey();
		key.setRequiredISOCountryId( ISOCountryId );
		if( indexByCountryIdx == null ) {
			indexByCountryIdx = new HashMap< CFBamISOCountryLanguageByCountryIdxKey,
				Map< CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > >();
		}
		if( indexByCountryIdx.containsKey( key ) ) {
			Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> dict = indexByCountryIdx.get( key );
			schema.getBackingStore().getTableISOCountryLanguage().deleteISOCountryLanguageByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
			Iterator<ICFBamISOCountryLanguageObj> iter = dict.values().iterator();
			ICFBamISOCountryLanguageObj obj;
			List<ICFBamISOCountryLanguageObj> toForget = new LinkedList<ICFBamISOCountryLanguageObj>();
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
			schema.getBackingStore().getTableISOCountryLanguage().deleteISOCountryLanguageByCountryIdx( schema.getAuthorization(),
				ISOCountryId );
		}
	}

	public void deleteISOCountryLanguageByLanguageIdx( short ISOLanguageId )
	{
		CFBamISOCountryLanguageByLanguageIdxKey key = schema.getBackingStore().getFactoryISOCountryLanguage().newLanguageIdxKey();
		key.setRequiredISOLanguageId( ISOLanguageId );
		if( indexByLanguageIdx == null ) {
			indexByLanguageIdx = new HashMap< CFBamISOCountryLanguageByLanguageIdxKey,
				Map< CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj > >();
		}
		if( indexByLanguageIdx.containsKey( key ) ) {
			Map<CFBamISOCountryLanguagePKey, ICFBamISOCountryLanguageObj> dict = indexByLanguageIdx.get( key );
			schema.getBackingStore().getTableISOCountryLanguage().deleteISOCountryLanguageByLanguageIdx( schema.getAuthorization(),
				ISOLanguageId );
			Iterator<ICFBamISOCountryLanguageObj> iter = dict.values().iterator();
			ICFBamISOCountryLanguageObj obj;
			List<ICFBamISOCountryLanguageObj> toForget = new LinkedList<ICFBamISOCountryLanguageObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLanguageIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableISOCountryLanguage().deleteISOCountryLanguageByLanguageIdx( schema.getAuthorization(),
				ISOLanguageId );
		}
	}
}
