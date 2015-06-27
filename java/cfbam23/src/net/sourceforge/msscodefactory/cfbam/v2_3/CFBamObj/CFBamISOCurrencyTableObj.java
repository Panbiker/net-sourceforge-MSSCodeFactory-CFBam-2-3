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

public class CFBamISOCurrencyTableObj
	implements ICFBamISOCurrencyTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamISOCurrencyPKey, ICFBamISOCurrencyObj> members;
	private Map<CFBamISOCurrencyPKey, ICFBamISOCurrencyObj> allISOCurrency;
	private Map< CFBamISOCurrencyByCcyCdIdxKey,
		ICFBamISOCurrencyObj > indexByCcyCdIdx;
	private Map< CFBamISOCurrencyByCcyNmIdxKey,
		ICFBamISOCurrencyObj > indexByCcyNmIdx;
	public static String TABLE_NAME = "ISOCurrency";
	public static String TABLE_DBNAME = "iso_ccy";

	public CFBamISOCurrencyTableObj() {
		schema = null;
		members = new HashMap<CFBamISOCurrencyPKey, ICFBamISOCurrencyObj>();
		allISOCurrency = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
	}

	public CFBamISOCurrencyTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamISOCurrencyPKey, ICFBamISOCurrencyObj>();
		allISOCurrency = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
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
		allISOCurrency = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
		List<ICFBamISOCurrencyObj> toForget = new LinkedList<ICFBamISOCurrencyObj>();
		ICFBamISOCurrencyObj cur = null;
		Iterator<ICFBamISOCurrencyObj> iter = members.values().iterator();
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
	 *	CFBamISOCurrencyObj.
	 */
	public ICFBamISOCurrencyObj newInstance() {
		ICFBamISOCurrencyObj inst = new CFBamISOCurrencyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCurrencyObj.
	 */
	public ICFBamISOCurrencyEditObj newEditInstance( ICFBamISOCurrencyObj orig ) {
		ICFBamISOCurrencyEditObj edit = new CFBamISOCurrencyEditObj( orig );
		return( edit );
	}

	public ICFBamISOCurrencyObj realizeISOCurrency( ICFBamISOCurrencyObj Obj ) {
		ICFBamISOCurrencyObj obj = Obj;
		CFBamISOCurrencyPKey pkey = obj.getPKey();
		ICFBamISOCurrencyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamISOCurrencyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCcyCdIdx != null ) {
				CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.remove( keyCcyCdIdx );
			}

			if( indexByCcyNmIdx != null ) {
				CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.remove( keyCcyNmIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCcyCdIdx != null ) {
				CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}
			if( allISOCurrency != null ) {
				allISOCurrency.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCurrency != null ) {
				allISOCurrency.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCcyCdIdx != null ) {
				CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetISOCurrency( ICFBamISOCurrencyObj Obj ) {
		forgetISOCurrency( Obj, false );
	}

	public void forgetISOCurrency( ICFBamISOCurrencyObj Obj, boolean forgetSubObjects ) {
		ICFBamISOCurrencyObj obj = Obj;
		CFBamISOCurrencyPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamISOCurrencyObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCcyCdIdx != null ) {
				CFBamISOCurrencyByCcyCdIdxKey keyCcyCdIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.remove( keyCcyCdIdx );
			}

			if( indexByCcyNmIdx != null ) {
				CFBamISOCurrencyByCcyNmIdxKey keyCcyNmIdx =
					schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.remove( keyCcyNmIdx );
			}

			if( allISOCurrency != null ) {
				allISOCurrency.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getISOCountryCurrencyTableObj().forgetISOCountryCurrencyByCurrencyIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetISOCurrencyByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamISOCurrencyPKey key = schema.getBackingStore().getFactoryISOCurrency().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamISOCurrencyObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCurrencyByCcyCdIdx( String ISOCode )
	{
		if( indexByCcyCdIdx == null ) {
			return;
		}
		CFBamISOCurrencyByCcyCdIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByCcyCdIdx.containsKey( key ) ) {
			ICFBamISOCurrencyObj probed = indexByCcyCdIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByCcyCdIdx.remove( key );
		}
	}

	public void forgetISOCurrencyByCcyNmIdx( String Name )
	{
		if( indexByCcyNmIdx == null ) {
			return;
		}
		CFBamISOCurrencyByCcyNmIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
		key.setRequiredName( Name );
		if( indexByCcyNmIdx.containsKey( key ) ) {
			ICFBamISOCurrencyObj probed = indexByCcyNmIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByCcyNmIdx.remove( key );
		}
	}

	public ICFBamISOCurrencyObj createISOCurrency( ICFBamISOCurrencyObj Obj ) {
		ICFBamISOCurrencyObj obj = Obj;
		CFBamISOCurrencyBuff buff = obj.getISOCurrencyBuff();
		schema.getBackingStore().getTableISOCurrency().createISOCurrency(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamISOCurrencyObj readISOCurrency( CFBamISOCurrencyPKey pkey ) {
		return( readISOCurrency( pkey, false ) );
	}

	public ICFBamISOCurrencyObj readISOCurrency( CFBamISOCurrencyPKey pkey, boolean forceRead ) {
		ICFBamISOCurrencyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamISOCurrencyBuff readBuff = schema.getBackingStore().getTableISOCurrency().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getISOCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCurrency().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamISOCurrencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCurrencyObj lockISOCurrency( CFBamISOCurrencyPKey pkey ) {
		ICFBamISOCurrencyObj locked = null;
		CFBamISOCurrencyBuff lockBuff = schema.getBackingStore().getTableISOCurrency().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCurrencyTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryISOCurrency().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamISOCurrencyObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockISOCurrency", pkey );
		}
		return( locked );
	}

	public List<ICFBamISOCurrencyObj> readAllISOCurrency() {
		return( readAllISOCurrency( false ) );
	}

	public List<ICFBamISOCurrencyObj> readAllISOCurrency( boolean forceRead ) {
		final String S_ProcName = "readAllISOCurrency";
		if( ( allISOCurrency == null ) || forceRead ) {
			Map<CFBamISOCurrencyPKey, ICFBamISOCurrencyObj> map = new HashMap<CFBamISOCurrencyPKey,ICFBamISOCurrencyObj>();
			allISOCurrency = map;
			CFBamISOCurrencyBuff[] buffList = schema.getBackingStore().getTableISOCurrency().readAllDerived( schema.getAuthorization() );
			CFBamISOCurrencyBuff buff;
			ICFBamISOCurrencyObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCurrency().newPKey() );
				obj.setBuff( buff );
				ICFBamISOCurrencyObj realized = (ICFBamISOCurrencyObj)obj.realize();
			}
		}
		Comparator<ICFBamISOCurrencyObj> cmp = new Comparator<ICFBamISOCurrencyObj>() {
			public int compare( ICFBamISOCurrencyObj lhs, ICFBamISOCurrencyObj rhs ) {
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
					CFBamISOCurrencyPKey lhsPKey = lhs.getPKey();
					CFBamISOCurrencyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allISOCurrency.size();
		ICFBamISOCurrencyObj arr[] = new ICFBamISOCurrencyObj[len];
		Iterator<ICFBamISOCurrencyObj> valIter = allISOCurrency.values().iterator();
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
		ArrayList<ICFBamISOCurrencyObj> arrayList = new ArrayList<ICFBamISOCurrencyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamISOCurrencyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByIdIdx( short Id )
	{
		return( readISOCurrencyByIdIdx( Id,
			false ) );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByIdIdx( short Id, boolean forceRead )
	{
		CFBamISOCurrencyPKey pkey = schema.getBackingStore().getFactoryISOCurrency().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOCurrencyObj obj = readISOCurrency( pkey, forceRead );
		return( obj );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByCcyCdIdx( String ISOCode )
	{
		return( readISOCurrencyByCcyCdIdx( ISOCode,
			false ) );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByCcyCdIdx( String ISOCode, boolean forceRead )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< CFBamISOCurrencyByCcyCdIdxKey,
				ICFBamISOCurrencyObj >();
		}
		CFBamISOCurrencyByCcyCdIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOCurrencyObj obj = null;
		if( ( ! forceRead ) && indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
		}
		else {
			CFBamISOCurrencyBuff buff = schema.getBackingStore().getTableISOCurrency().readDerivedByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
			if( buff != null ) {
				obj = schema.getISOCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCurrency().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOCurrencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByCcyCdIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByCcyNmIdx( String Name )
	{
		return( readISOCurrencyByCcyNmIdx( Name,
			false ) );
	}

	public ICFBamISOCurrencyObj readISOCurrencyByCcyNmIdx( String Name, boolean forceRead )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< CFBamISOCurrencyByCcyNmIdxKey,
				ICFBamISOCurrencyObj >();
		}
		CFBamISOCurrencyByCcyNmIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
		key.setRequiredName( Name );
		ICFBamISOCurrencyObj obj = null;
		if( ( ! forceRead ) && indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
		}
		else {
			CFBamISOCurrencyBuff buff = schema.getBackingStore().getTableISOCurrency().readDerivedByCcyNmIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getISOCurrencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryISOCurrency().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamISOCurrencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByCcyNmIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamISOCurrencyObj updateISOCurrency( ICFBamISOCurrencyObj Obj ) {
		ICFBamISOCurrencyObj obj = Obj;
		schema.getBackingStore().getTableISOCurrency().updateISOCurrency( schema.getAuthorization(),
			Obj.getISOCurrencyBuff() );
		obj = (ICFBamISOCurrencyObj)Obj.realize();
		return( obj );
	}

	public void deleteISOCurrency( ICFBamISOCurrencyObj Obj ) {
		ICFBamISOCurrencyObj obj = Obj;
		schema.getBackingStore().getTableISOCurrency().deleteISOCurrency( schema.getAuthorization(),
			obj.getISOCurrencyBuff() );
		obj.forget( true );
	}

	public void deleteISOCurrencyByIdIdx( short Id )
	{
		CFBamISOCurrencyPKey pkey = schema.getBackingStore().getFactoryISOCurrency().newPKey();
		pkey.setRequiredId( Id );
		ICFBamISOCurrencyObj obj = readISOCurrency( pkey );
		if( obj != null ) {
			ICFBamISOCurrencyEditObj editObj = (ICFBamISOCurrencyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamISOCurrencyEditObj)obj.beginEdit();
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

	public void deleteISOCurrencyByCcyCdIdx( String ISOCode )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< CFBamISOCurrencyByCcyCdIdxKey,
				ICFBamISOCurrencyObj >();
		}
		CFBamISOCurrencyByCcyCdIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFBamISOCurrencyObj obj = null;
		if( indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
			schema.getBackingStore().getTableISOCurrency().deleteISOCurrencyByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOCurrency().deleteISOCurrencyByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
		}
	}

	public void deleteISOCurrencyByCcyNmIdx( String Name )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< CFBamISOCurrencyByCcyNmIdxKey,
				ICFBamISOCurrencyObj >();
		}
		CFBamISOCurrencyByCcyNmIdxKey key = schema.getBackingStore().getFactoryISOCurrency().newCcyNmIdxKey();
		key.setRequiredName( Name );
		ICFBamISOCurrencyObj obj = null;
		if( indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
			schema.getBackingStore().getTableISOCurrency().deleteISOCurrencyByCcyNmIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableISOCurrency().deleteISOCurrencyByCcyNmIdx( schema.getAuthorization(),
				Name );
		}
	}
}
