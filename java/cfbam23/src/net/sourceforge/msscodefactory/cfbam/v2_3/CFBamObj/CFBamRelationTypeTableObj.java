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

public class CFBamRelationTypeTableObj
	implements ICFBamRelationTypeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamRelationTypePKey, ICFBamRelationTypeObj> members;
	private Map<CFBamRelationTypePKey, ICFBamRelationTypeObj> allRelationType;
	private Map< CFBamRelationTypeByUTagIdxKey,
		ICFBamRelationTypeObj > indexByUTagIdx;
	public static String TABLE_NAME = "RelationType";
	public static String TABLE_DBNAME = "rel_type";

	public CFBamRelationTypeTableObj() {
		schema = null;
		members = new HashMap<CFBamRelationTypePKey, ICFBamRelationTypeObj>();
		allRelationType = null;
		indexByUTagIdx = null;
	}

	public CFBamRelationTypeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamRelationTypePKey, ICFBamRelationTypeObj>();
		allRelationType = null;
		indexByUTagIdx = null;
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
		allRelationType = null;
		indexByUTagIdx = null;
		List<ICFBamRelationTypeObj> toForget = new LinkedList<ICFBamRelationTypeObj>();
		ICFBamRelationTypeObj cur = null;
		Iterator<ICFBamRelationTypeObj> iter = members.values().iterator();
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
	 *	CFBamRelationTypeObj.
	 */
	public ICFBamRelationTypeObj newInstance() {
		ICFBamRelationTypeObj inst = new CFBamRelationTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationTypeObj.
	 */
	public ICFBamRelationTypeEditObj newEditInstance( ICFBamRelationTypeObj orig ) {
		ICFBamRelationTypeEditObj edit = new CFBamRelationTypeEditObj( orig );
		return( edit );
	}

	public ICFBamRelationTypeObj realizeRelationType( ICFBamRelationTypeObj Obj ) {
		ICFBamRelationTypeObj obj = Obj;
		CFBamRelationTypePKey pkey = obj.getPKey();
		ICFBamRelationTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamRelationTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUTagIdx != null ) {
				CFBamRelationTypeByUTagIdxKey keyUTagIdx =
					schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
				keyUTagIdx.setRequiredTag( keepObj.getRequiredTag() );
				indexByUTagIdx.remove( keyUTagIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUTagIdx != null ) {
				CFBamRelationTypeByUTagIdxKey keyUTagIdx =
					schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
				keyUTagIdx.setRequiredTag( keepObj.getRequiredTag() );
				indexByUTagIdx.put( keyUTagIdx, keepObj );
			}
			if( allRelationType != null ) {
				allRelationType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRelationType != null ) {
				allRelationType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUTagIdx != null ) {
				CFBamRelationTypeByUTagIdxKey keyUTagIdx =
					schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
				keyUTagIdx.setRequiredTag( keepObj.getRequiredTag() );
				indexByUTagIdx.put( keyUTagIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetRelationType( ICFBamRelationTypeObj Obj ) {
		forgetRelationType( Obj, false );
	}

	public void forgetRelationType( ICFBamRelationTypeObj Obj, boolean forgetSubObjects ) {
		ICFBamRelationTypeObj obj = Obj;
		CFBamRelationTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamRelationTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUTagIdx != null ) {
				CFBamRelationTypeByUTagIdxKey keyUTagIdx =
					schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
				keyUTagIdx.setRequiredTag( keepObj.getRequiredTag() );
				indexByUTagIdx.remove( keyUTagIdx );
			}

			if( allRelationType != null ) {
				allRelationType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetRelationTypeByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamRelationTypePKey key = schema.getBackingStore().getFactoryRelationType().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamRelationTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetRelationTypeByUTagIdx( String Tag )
	{
		if( indexByUTagIdx == null ) {
			return;
		}
		CFBamRelationTypeByUTagIdxKey key = schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
		key.setRequiredTag( Tag );
		if( indexByUTagIdx.containsKey( key ) ) {
			ICFBamRelationTypeObj probed = indexByUTagIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUTagIdx.remove( key );
		}
	}

	public ICFBamRelationTypeObj createRelationType( ICFBamRelationTypeObj Obj ) {
		ICFBamRelationTypeObj obj = Obj;
		CFBamRelationTypeBuff buff = obj.getRelationTypeBuff();
		schema.getBackingStore().getTableRelationType().createRelationType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamRelationTypeObj readRelationType( CFBamRelationTypePKey pkey ) {
		return( readRelationType( pkey, false ) );
	}

	public ICFBamRelationTypeObj readRelationType( CFBamRelationTypePKey pkey, boolean forceRead ) {
		ICFBamRelationTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamRelationTypeBuff readBuff = schema.getBackingStore().getTableRelationType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getRelationTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryRelationType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamRelationTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamRelationTypeObj lockRelationType( CFBamRelationTypePKey pkey ) {
		ICFBamRelationTypeObj locked = null;
		CFBamRelationTypeBuff lockBuff = schema.getBackingStore().getTableRelationType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getRelationTypeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryRelationType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamRelationTypeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockRelationType", pkey );
		}
		return( locked );
	}

	public List<ICFBamRelationTypeObj> readAllRelationType() {
		return( readAllRelationType( false ) );
	}

	public List<ICFBamRelationTypeObj> readAllRelationType( boolean forceRead ) {
		final String S_ProcName = "readAllRelationType";
		if( ( allRelationType == null ) || forceRead ) {
			Map<CFBamRelationTypePKey, ICFBamRelationTypeObj> map = new HashMap<CFBamRelationTypePKey,ICFBamRelationTypeObj>();
			allRelationType = map;
			CFBamRelationTypeBuff[] buffList = schema.getBackingStore().getTableRelationType().readAllDerived( schema.getAuthorization() );
			CFBamRelationTypeBuff buff;
			ICFBamRelationTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryRelationType().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationTypeObj realized = (ICFBamRelationTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationTypeObj> cmp = new Comparator<ICFBamRelationTypeObj>() {
			public int compare( ICFBamRelationTypeObj lhs, ICFBamRelationTypeObj rhs ) {
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
					CFBamRelationTypePKey lhsPKey = lhs.getPKey();
					CFBamRelationTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allRelationType.size();
		ICFBamRelationTypeObj arr[] = new ICFBamRelationTypeObj[len];
		Iterator<ICFBamRelationTypeObj> valIter = allRelationType.values().iterator();
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
		ArrayList<ICFBamRelationTypeObj> arrayList = new ArrayList<ICFBamRelationTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationTypeObj readRelationTypeByIdIdx( short Id )
	{
		return( readRelationTypeByIdIdx( Id,
			false ) );
	}

	public ICFBamRelationTypeObj readRelationTypeByIdIdx( short Id, boolean forceRead )
	{
		CFBamRelationTypePKey pkey = schema.getBackingStore().getFactoryRelationType().newPKey();
		pkey.setRequiredId( Id );
		ICFBamRelationTypeObj obj = readRelationType( pkey, forceRead );
		return( obj );
	}

	public ICFBamRelationTypeObj readRelationTypeByUTagIdx( String Tag )
	{
		return( readRelationTypeByUTagIdx( Tag,
			false ) );
	}

	public ICFBamRelationTypeObj readRelationTypeByUTagIdx( String Tag, boolean forceRead )
	{
		if( indexByUTagIdx == null ) {
			indexByUTagIdx = new HashMap< CFBamRelationTypeByUTagIdxKey,
				ICFBamRelationTypeObj >();
		}
		CFBamRelationTypeByUTagIdxKey key = schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
		key.setRequiredTag( Tag );
		ICFBamRelationTypeObj obj = null;
		if( ( ! forceRead ) && indexByUTagIdx.containsKey( key ) ) {
			obj = indexByUTagIdx.get( key );
		}
		else {
			CFBamRelationTypeBuff buff = schema.getBackingStore().getTableRelationType().readDerivedByUTagIdx( schema.getAuthorization(),
				Tag );
			if( buff != null ) {
				obj = schema.getRelationTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryRelationType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamRelationTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUTagIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamRelationTypeObj updateRelationType( ICFBamRelationTypeObj Obj ) {
		ICFBamRelationTypeObj obj = Obj;
		schema.getBackingStore().getTableRelationType().updateRelationType( schema.getAuthorization(),
			Obj.getRelationTypeBuff() );
		obj = (ICFBamRelationTypeObj)Obj.realize();
		return( obj );
	}

	public void deleteRelationType( ICFBamRelationTypeObj Obj ) {
		ICFBamRelationTypeObj obj = Obj;
		schema.getBackingStore().getTableRelationType().deleteRelationType( schema.getAuthorization(),
			obj.getRelationTypeBuff() );
		obj.forget( true );
	}

	public void deleteRelationTypeByIdIdx( short Id )
	{
		CFBamRelationTypePKey pkey = schema.getBackingStore().getFactoryRelationType().newPKey();
		pkey.setRequiredId( Id );
		ICFBamRelationTypeObj obj = readRelationType( pkey );
		if( obj != null ) {
			ICFBamRelationTypeEditObj editObj = (ICFBamRelationTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamRelationTypeEditObj)obj.beginEdit();
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

	public void deleteRelationTypeByUTagIdx( String Tag )
	{
		if( indexByUTagIdx == null ) {
			indexByUTagIdx = new HashMap< CFBamRelationTypeByUTagIdxKey,
				ICFBamRelationTypeObj >();
		}
		CFBamRelationTypeByUTagIdxKey key = schema.getBackingStore().getFactoryRelationType().newUTagIdxKey();
		key.setRequiredTag( Tag );
		ICFBamRelationTypeObj obj = null;
		if( indexByUTagIdx.containsKey( key ) ) {
			obj = indexByUTagIdx.get( key );
			schema.getBackingStore().getTableRelationType().deleteRelationTypeByUTagIdx( schema.getAuthorization(),
				Tag );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableRelationType().deleteRelationTypeByUTagIdx( schema.getAuthorization(),
				Tag );
		}
	}
}
