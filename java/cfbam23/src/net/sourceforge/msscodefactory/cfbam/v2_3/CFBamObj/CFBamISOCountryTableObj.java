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

public class CFBamISOCountryTableObj
	implements ICFBamISOCountryTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOCountryPKey, ICFBamISOCountryObj> members;
	private Map<CFBamISOCountryPKey, ICFBamISOCountryObj> allISOCountry;
	private Map< CFBamISOCountryByISOCodeIdxKey,
		ICFBamISOCountryObj > indexByISOCodeIdx;
	private Map< CFBamISOCountryByNameIdxKey,
		ICFBamISOCountryObj > indexByNameIdx;
	public static String TABLE_NAME = "ISOCountry";
	public static String TABLE_DBNAME = "iso_cntry";

	public CFBamISOCountryTableObj() {
		schema = null;
		members = new HashMap<CFBamISOCountryPKey, ICFBamISOCountryObj>();
		allISOCountry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
	}

	public CFBamISOCountryTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOCountryPKey, ICFBamISOCountryObj>();
		allISOCountry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
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
		allISOCountry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
		List<ICFBamISOCountryObj> toForget = new LinkedList<ICFBamISOCountryObj>();
		ICFBamISOCountryObj cur = null;
		Iterator<ICFBamISOCountryObj> iter = members.values().iterator();
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
	 *	CFBamISOCountryObj.
	 */
	public ICFBamISOCountryObj newInstance() {
		ICFBamISOCountryObj inst = new CFBamISOCountryObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCountryObj.
	 */
	public ICFBamISOCountryEditObj newEditInstance( ICFBamISOCountryObj orig ) {
		ICFBamISOCountryEditObj edit = new CFBamISOCountryEditObj( orig );
		return( edit );
	}

	public ICFBamISOCountryObj realizeISOCountry( ICFBamISOCountryObj Obj ) {
		ICFBamISOCountryObj obj = Obj;
		CFBamISOCountryPKey pkey = obj.getPKey();
		ICFBamISOCountryObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOCountryObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByISOCodeIdx != null ) {
				CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx =
					schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.remove( keyISOCodeIdx );
			}

			if( indexByNameIdx != null ) {
				CFBamISOCountryByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByISOCodeIdx != null ) {
				CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx =
					schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				CFBamISOCountryByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allISOCountry != null ) {
				allISOCountry.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCountry != null ) {
				allISOCountry.put( keepObj.getPKey(), keepObj );
			}

			if( indexByISOCodeIdx != null ) {
				CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx =
					schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				CFBamISOCountryByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetISOCountry( ICFBamISOCountryObj Obj ) {
		forgetISOCountry( Obj, false );
	}

	public void forgetISOCountry( ICFBamISOCountryObj Obj, boolean forgetSubObjects ) {
		ICFBamISOCountryObj obj = Obj;
		CFBamISOCountryPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOCountryObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByISOCodeIdx != null ) {
				CFBamISOCountryByISOCodeIdxKey keyISOCodeIdx =
					schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.remove( keyISOCodeIdx );
			}

			if( indexByNameIdx != null ) {
				CFBamISOCountryByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allISOCountry != null ) {
				allISOCountry.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getISOCountryCurrencyTableObj().forgetISOCountryCurrencyByCountryIdx( keepObj.getRequiredId() );
				schema.getISOCountryLanguageTableObj().forgetISOCountryLanguageByCountryIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetISOCountryByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamISOCountryPKey key = schema.getBackingStore().getFactoryISOCountry().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamISOCountryObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCountryByISOCodeIdx( String ISOCode )
	{
		if( indexByISOCodeIdx == null ) {
			return;
		}
		CFBamISOCountryByISOCodeIdxKey key = schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByISOCodeIdx.containsKey( key ) ) {
			ICFBamISOCountryObj probed = indexByISOCodeIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByISOCodeIdx.remove( key );
		}
	}

	public void forgetISOCountryByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamISOCountryByNameIdxKey key = schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamISOCountryObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamISOCountryObj createISOCountry( ICFBamISOCountryObj Obj ) {
		ICFBamISOCountryObj obj = Obj;
		CFBamISOCountryBuff buff = obj.getISOCountryBuff();
		schema.getBackingStore().getTableISOCountry().createISOCountry(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOCountryObj readISOCountry( CFBamISOCountryPKey pkey ) {
		return( readISOCountry( pkey, false ) );
	}

	public ICFBamISOCountryObj readISOCountry( CFBamISOCountryPKey pkey, boolean forceRead ) {
		ICFBamISOCountryObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOCountryBuff readBuff = schema.getBackingStore().getTableISOCountry().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getISOCountryTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountry().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOCountryObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCountryObj lockISOCountry( CFBamISOCountryPKey pkey ) {
		ICFBamISOCountryObj locked = null;
		CFBamISOCountryBuff lockBuff = schema.getBackingStore().getTableISOCountry().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCountryTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOCountry().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOCountryObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOCountry", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOCountryObj> readAllISOCountry() {
		return( readAllISOCountry( false ) );
	}

	public List<ICFBamISOCountryObj> readAllISOCountry( boolean forceRead ) {
		final String S_ProcName = "readAllISOCountry";
		if( ( allISOCountry == null ) || forceRead ) {
			Map<CFBamISOCountryPKey, ICFBamISOCountryObj> map = new HashMap<CFBamISOCountryPKey,ICFBamISOCountryObj>();
			allISOCountry = map;
			CFBamISOCountryBuff[] buffList = schema.getBackingStore().getTableISOCountry().readAllDerived( schema.getAuthorization() );
			CFBamISOCountryBuff buff;
			ICFBamISOCountryObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountry().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCountryObj realized = (ICFBamISOCountryObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCountryObj> cmp = new Comparator<ICFBamISOCountryObj>() {
			public int compare( ICFBamISOCountryObj lhs, ICFBamISOCountryObj rhs ) {
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
					CFBamISOCountryPKey lhsPKey = lhs.getPKey();
					CFBamISOCountryPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOCountry.size();
		ICFBamISOCountryObj arr[] = new ICFBamISOCountryObj[len];
		Iterator<ICFBamISOCountryObj> valIter = allISOCountry.values().iterator();
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
		ArrayList<ICFBamISOCountryObj> arrayList = new ArrayList<ICFBamISOCountryObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCountryObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCountryObj readISOCountryByIdIdx( short Id )
	{
		return( readISOCountryByIdIdx( Id,
			false ) );
	}

	public ICFBamISOCountryObj readISOCountryByIdIdx( short Id, boolean forceRead )
	{
		CFBamISOCountryPKey pkey = schema.getBackingStore().getFactoryISOCountry().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOCountryObj obj = readISOCountry( pkey, forceRead );
		return( obj );
	}

	public ICFBamISOCountryObj readISOCountryByISOCodeIdx( String ISOCode )
	{
		return( readISOCountryByISOCodeIdx( ISOCode,
			false ) );
	}

	public ICFBamISOCountryObj readISOCountryByISOCodeIdx( String ISOCode, boolean forceRead )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< CFBamISOCountryByISOCodeIdxKey,
				ICFBamISOCountryObj >();
		}
		CFBamISOCountryByISOCodeIdxKey key = schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOCountryObj obj = null;
		if( ( ! forceRead ) && indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
		}
		else {
			CFBamISOCountryBuff buff = schema.getBackingStore().getTableISOCountry().readDerivedByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
			if( buff != null ) {
				obj = schema.getISOCountryTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountry().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOCountryObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByISOCodeIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCountryObj readISOCountryByNameIdx( String Name )
	{
		return( readISOCountryByNameIdx( Name,
			false ) );
	}

	public ICFBamISOCountryObj readISOCountryByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamISOCountryByNameIdxKey,
				ICFBamISOCountryObj >();
		}
		CFBamISOCountryByNameIdxKey key = schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
		key.setRequiredName( Name );
		ICFBamISOCountryObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamISOCountryBuff buff = schema.getBackingStore().getTableISOCountry().readDerivedByNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getISOCountryTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCountry().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOCountryObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCountryObj updateISOCountry( ICFBamISOCountryObj Obj ) {
		ICFBamISOCountryObj obj = Obj;
		schema.getBackingStore().getTableISOCountry().updateISOCountry( schema.getAuthorization(),
			Obj.getISOCountryBuff() );
		obj = (ICFBamISOCountryObj)Obj.realize();
		return( obj );
	}

	public void deleteISOCountry( ICFBamISOCountryObj Obj ) {
		ICFBamISOCountryObj obj = Obj;
		schema.getBackingStore().getTableISOCountry().deleteISOCountry( schema.getAuthorization(),
			obj.getISOCountryBuff() );
		obj.forget( true );
	}

	public void deleteISOCountryByIdIdx( short Id )
	{
		CFBamISOCountryPKey pkey = schema.getBackingStore().getFactoryISOCountry().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOCountryObj obj = readISOCountry( pkey );
		if( obj != null ) {
			ICFBamISOCountryEditObj editObj = (ICFBamISOCountryEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOCountryEditObj)obj.beginEdit();
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

	public void deleteISOCountryByISOCodeIdx( String ISOCode )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< CFBamISOCountryByISOCodeIdxKey,
				ICFBamISOCountryObj >();
		}
		CFBamISOCountryByISOCodeIdxKey key = schema.getBackingStore().getFactoryISOCountry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOCountryObj obj = null;
		if( indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
			schema.getBackingStore().getTableISOCountry().deleteISOCountryByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOCountry().deleteISOCountryByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
		}
	}

	public void deleteISOCountryByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamISOCountryByNameIdxKey,
				ICFBamISOCountryObj >();
		}
		CFBamISOCountryByNameIdxKey key = schema.getBackingStore().getFactoryISOCountry().newNameIdxKey();
		key.setRequiredName( Name );
		ICFBamISOCountryObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableISOCountry().deleteISOCountryByNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOCountry().deleteISOCountryByNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
