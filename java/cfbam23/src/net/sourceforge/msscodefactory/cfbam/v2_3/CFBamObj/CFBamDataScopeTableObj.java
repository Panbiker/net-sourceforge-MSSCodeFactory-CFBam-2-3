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

public class CFBamDataScopeTableObj
	implements ICFBamDataScopeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDataScopePKey, ICFBamDataScopeObj> members;
	private Map<CFBamDataScopePKey, ICFBamDataScopeObj> allDataScope;
	private Map< CFBamDataScopeByUNameIdxKey,
		ICFBamDataScopeObj > indexByUNameIdx;
	public static String TABLE_NAME = "DataScope";
	public static String TABLE_DBNAME = "datascope";

	public CFBamDataScopeTableObj() {
		schema = null;
		members = new HashMap<CFBamDataScopePKey, ICFBamDataScopeObj>();
		allDataScope = null;
		indexByUNameIdx = null;
	}

	public CFBamDataScopeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDataScopePKey, ICFBamDataScopeObj>();
		allDataScope = null;
		indexByUNameIdx = null;
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
		allDataScope = null;
		indexByUNameIdx = null;
		List<ICFBamDataScopeObj> toForget = new LinkedList<ICFBamDataScopeObj>();
		ICFBamDataScopeObj cur = null;
		Iterator<ICFBamDataScopeObj> iter = members.values().iterator();
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
	 *	CFBamDataScopeObj.
	 */
	public ICFBamDataScopeObj newInstance() {
		ICFBamDataScopeObj inst = new CFBamDataScopeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDataScopeObj.
	 */
	public ICFBamDataScopeEditObj newEditInstance( ICFBamDataScopeObj orig ) {
		ICFBamDataScopeEditObj edit = new CFBamDataScopeEditObj( orig );
		return( edit );
	}

	public ICFBamDataScopeObj realizeDataScope( ICFBamDataScopeObj Obj ) {
		ICFBamDataScopeObj obj = Obj;
		CFBamDataScopePKey pkey = obj.getPKey();
		ICFBamDataScopeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDataScopeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamDataScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamDataScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allDataScope != null ) {
				allDataScope.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDataScope != null ) {
				allDataScope.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamDataScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDataScope( ICFBamDataScopeObj Obj ) {
		forgetDataScope( Obj, false );
	}

	public void forgetDataScope( ICFBamDataScopeObj Obj, boolean forgetSubObjects ) {
		ICFBamDataScopeObj obj = Obj;
		CFBamDataScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDataScopeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamDataScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDataScope != null ) {
				allDataScope.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetDataScopeByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDataScopePKey key = schema.getBackingStore().getFactoryDataScope().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDataScopeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDataScopeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamDataScopeByUNameIdxKey key = schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamDataScopeObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamDataScopeObj createDataScope( ICFBamDataScopeObj Obj ) {
		ICFBamDataScopeObj obj = Obj;
		CFBamDataScopeBuff buff = obj.getDataScopeBuff();
		schema.getBackingStore().getTableDataScope().createDataScope(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamDataScopeObj readDataScope( CFBamDataScopePKey pkey ) {
		return( readDataScope( pkey, false ) );
	}

	public ICFBamDataScopeObj readDataScope( CFBamDataScopePKey pkey, boolean forceRead ) {
		ICFBamDataScopeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDataScopeBuff readBuff = schema.getBackingStore().getTableDataScope().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getDataScopeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryDataScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDataScopeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDataScopeObj lockDataScope( CFBamDataScopePKey pkey ) {
		ICFBamDataScopeObj locked = null;
		CFBamDataScopeBuff lockBuff = schema.getBackingStore().getTableDataScope().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getDataScopeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryDataScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDataScopeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDataScope", pkey );
		}
		return( locked );
	}

	public List<ICFBamDataScopeObj> readAllDataScope() {
		return( readAllDataScope( false ) );
	}

	public List<ICFBamDataScopeObj> readAllDataScope( boolean forceRead ) {
		final String S_ProcName = "readAllDataScope";
		if( ( allDataScope == null ) || forceRead ) {
			Map<CFBamDataScopePKey, ICFBamDataScopeObj> map = new HashMap<CFBamDataScopePKey,ICFBamDataScopeObj>();
			allDataScope = map;
			CFBamDataScopeBuff[] buffList = schema.getBackingStore().getTableDataScope().readAllDerived( schema.getAuthorization() );
			CFBamDataScopeBuff buff;
			ICFBamDataScopeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryDataScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDataScopeObj realized = (ICFBamDataScopeObj)obj.realize();
			}
		}
		Comparator<ICFBamDataScopeObj> cmp = new Comparator<ICFBamDataScopeObj>() {
			public int compare( ICFBamDataScopeObj lhs, ICFBamDataScopeObj rhs ) {
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
					CFBamDataScopePKey lhsPKey = lhs.getPKey();
					CFBamDataScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allDataScope.size();
		ICFBamDataScopeObj arr[] = new ICFBamDataScopeObj[len];
		Iterator<ICFBamDataScopeObj> valIter = allDataScope.values().iterator();
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
		ArrayList<ICFBamDataScopeObj> arrayList = new ArrayList<ICFBamDataScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDataScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDataScopeObj readDataScopeByIdIdx( short Id )
	{
		return( readDataScopeByIdIdx( Id,
			false ) );
	}

	public ICFBamDataScopeObj readDataScopeByIdIdx( short Id, boolean forceRead )
	{
		CFBamDataScopePKey pkey = schema.getBackingStore().getFactoryDataScope().newPKey();
		pkey.setRequiredId( Id );
		ICFBamDataScopeObj obj = readDataScope( pkey, forceRead );
		return( obj );
	}

	public ICFBamDataScopeObj readDataScopeByUNameIdx( String Name )
	{
		return( readDataScopeByUNameIdx( Name,
			false ) );
	}

	public ICFBamDataScopeObj readDataScopeByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDataScopeByUNameIdxKey,
				ICFBamDataScopeObj >();
		}
		CFBamDataScopeByUNameIdxKey key = schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamDataScopeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDataScopeBuff buff = schema.getBackingStore().getTableDataScope().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getDataScopeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryDataScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDataScopeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDataScopeObj updateDataScope( ICFBamDataScopeObj Obj ) {
		ICFBamDataScopeObj obj = Obj;
		schema.getBackingStore().getTableDataScope().updateDataScope( schema.getAuthorization(),
			Obj.getDataScopeBuff() );
		obj = (ICFBamDataScopeObj)Obj.realize();
		return( obj );
	}

	public void deleteDataScope( ICFBamDataScopeObj Obj ) {
		ICFBamDataScopeObj obj = Obj;
		schema.getBackingStore().getTableDataScope().deleteDataScope( schema.getAuthorization(),
			obj.getDataScopeBuff() );
		obj.forget( true );
	}

	public void deleteDataScopeByIdIdx( short Id )
	{
		CFBamDataScopePKey pkey = schema.getBackingStore().getFactoryDataScope().newPKey();
		pkey.setRequiredId( Id );
		ICFBamDataScopeObj obj = readDataScope( pkey );
		if( obj != null ) {
			ICFBamDataScopeEditObj editObj = (ICFBamDataScopeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDataScopeEditObj)obj.beginEdit();
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

	public void deleteDataScopeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDataScopeByUNameIdxKey,
				ICFBamDataScopeObj >();
		}
		CFBamDataScopeByUNameIdxKey key = schema.getBackingStore().getFactoryDataScope().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamDataScopeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableDataScope().deleteDataScopeByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDataScope().deleteDataScopeByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
