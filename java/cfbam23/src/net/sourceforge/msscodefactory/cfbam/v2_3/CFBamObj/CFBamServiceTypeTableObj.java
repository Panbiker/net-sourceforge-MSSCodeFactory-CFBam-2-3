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

public class CFBamServiceTypeTableObj
	implements ICFBamServiceTypeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamServiceTypePKey, ICFBamServiceTypeObj> members;
	private Map<CFBamServiceTypePKey, ICFBamServiceTypeObj> allServiceType;
	private Map< CFBamServiceTypeByUDescrIdxKey,
		ICFBamServiceTypeObj > indexByUDescrIdx;
	public static String TABLE_NAME = "ServiceType";
	public static String TABLE_DBNAME = "svctype";

	public CFBamServiceTypeTableObj() {
		schema = null;
		members = new HashMap<CFBamServiceTypePKey, ICFBamServiceTypeObj>();
		allServiceType = null;
		indexByUDescrIdx = null;
	}

	public CFBamServiceTypeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamServiceTypePKey, ICFBamServiceTypeObj>();
		allServiceType = null;
		indexByUDescrIdx = null;
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
		allServiceType = null;
		indexByUDescrIdx = null;
		List<ICFBamServiceTypeObj> toForget = new LinkedList<ICFBamServiceTypeObj>();
		ICFBamServiceTypeObj cur = null;
		Iterator<ICFBamServiceTypeObj> iter = members.values().iterator();
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
	 *	CFBamServiceTypeObj.
	 */
	public ICFBamServiceTypeObj newInstance() {
		ICFBamServiceTypeObj inst = new CFBamServiceTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServiceTypeObj.
	 */
	public ICFBamServiceTypeEditObj newEditInstance( ICFBamServiceTypeObj orig ) {
		ICFBamServiceTypeEditObj edit = new CFBamServiceTypeEditObj( orig );
		return( edit );
	}

	public ICFBamServiceTypeObj realizeServiceType( ICFBamServiceTypeObj Obj ) {
		ICFBamServiceTypeObj obj = Obj;
		CFBamServiceTypePKey pkey = obj.getPKey();
		ICFBamServiceTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamServiceTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDescrIdx != null ) {
				CFBamServiceTypeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDescrIdx != null ) {
				CFBamServiceTypeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
			if( allServiceType != null ) {
				allServiceType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServiceType != null ) {
				allServiceType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFBamServiceTypeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetServiceType( ICFBamServiceTypeObj Obj ) {
		forgetServiceType( Obj, false );
	}

	public void forgetServiceType( ICFBamServiceTypeObj Obj, boolean forgetSubObjects ) {
		ICFBamServiceTypeObj obj = Obj;
		CFBamServiceTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamServiceTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUDescrIdx != null ) {
				CFBamServiceTypeByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( allServiceType != null ) {
				allServiceType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getServiceTableObj().forgetServiceByTypeIdx( keepObj.getRequiredServiceTypeId() );
			}
		}
	}

	public void forgetServiceTypeByIdIdx( int ServiceTypeId )
	{
		if( members == null ) {
			return;
		}
		CFBamServiceTypePKey key = schema.getBackingStore().getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( ServiceTypeId );
		if( members.containsKey( key ) ) {
			ICFBamServiceTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServiceTypeByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		CFBamServiceTypeByUDescrIdxKey key = schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			ICFBamServiceTypeObj probed = indexByUDescrIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUDescrIdx.remove( key );
		}
	}

	public ICFBamServiceTypeObj createServiceType( ICFBamServiceTypeObj Obj ) {
		ICFBamServiceTypeObj obj = Obj;
		CFBamServiceTypeBuff buff = obj.getServiceTypeBuff();
		schema.getBackingStore().getTableServiceType().createServiceType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamServiceTypeObj readServiceType( CFBamServiceTypePKey pkey ) {
		return( readServiceType( pkey, false ) );
	}

	public ICFBamServiceTypeObj readServiceType( CFBamServiceTypePKey pkey, boolean forceRead ) {
		ICFBamServiceTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamServiceTypeBuff readBuff = schema.getBackingStore().getTableServiceType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredServiceTypeId() );
			if( readBuff != null ) {
				obj = schema.getServiceTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryServiceType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamServiceTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamServiceTypeObj lockServiceType( CFBamServiceTypePKey pkey ) {
		ICFBamServiceTypeObj locked = null;
		CFBamServiceTypeBuff lockBuff = schema.getBackingStore().getTableServiceType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getServiceTypeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryServiceType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamServiceTypeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockServiceType", pkey );
		}
		return( locked );
	}

	public List<ICFBamServiceTypeObj> readAllServiceType() {
		return( readAllServiceType( false ) );
	}

	public List<ICFBamServiceTypeObj> readAllServiceType( boolean forceRead ) {
		final String S_ProcName = "readAllServiceType";
		if( ( allServiceType == null ) || forceRead ) {
			Map<CFBamServiceTypePKey, ICFBamServiceTypeObj> map = new HashMap<CFBamServiceTypePKey,ICFBamServiceTypeObj>();
			allServiceType = map;
			CFBamServiceTypeBuff[] buffList = schema.getBackingStore().getTableServiceType().readAllDerived( schema.getAuthorization() );
			CFBamServiceTypeBuff buff;
			ICFBamServiceTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryServiceType().newPKey() );
				obj.setBuff( buff );
				ICFBamServiceTypeObj realized = (ICFBamServiceTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamServiceTypeObj> cmp = new Comparator<ICFBamServiceTypeObj>() {
			public int compare( ICFBamServiceTypeObj lhs, ICFBamServiceTypeObj rhs ) {
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
					CFBamServiceTypePKey lhsPKey = lhs.getPKey();
					CFBamServiceTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allServiceType.size();
		ICFBamServiceTypeObj arr[] = new ICFBamServiceTypeObj[len];
		Iterator<ICFBamServiceTypeObj> valIter = allServiceType.values().iterator();
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
		ArrayList<ICFBamServiceTypeObj> arrayList = new ArrayList<ICFBamServiceTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServiceTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServiceTypeObj readServiceTypeByIdIdx( int ServiceTypeId )
	{
		return( readServiceTypeByIdIdx( ServiceTypeId,
			false ) );
	}

	public ICFBamServiceTypeObj readServiceTypeByIdIdx( int ServiceTypeId, boolean forceRead )
	{
		CFBamServiceTypePKey pkey = schema.getBackingStore().getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( ServiceTypeId );
		ICFBamServiceTypeObj obj = readServiceType( pkey, forceRead );
		return( obj );
	}

	public ICFBamServiceTypeObj readServiceTypeByUDescrIdx( String Description )
	{
		return( readServiceTypeByUDescrIdx( Description,
			false ) );
	}

	public ICFBamServiceTypeObj readServiceTypeByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamServiceTypeByUDescrIdxKey,
				ICFBamServiceTypeObj >();
		}
		CFBamServiceTypeByUDescrIdxKey key = schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamServiceTypeObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFBamServiceTypeBuff buff = schema.getBackingStore().getTableServiceType().readDerivedByUDescrIdx( schema.getAuthorization(),
				Description );
			if( buff != null ) {
				obj = schema.getServiceTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryServiceType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServiceTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUDescrIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamServiceTypeObj updateServiceType( ICFBamServiceTypeObj Obj ) {
		ICFBamServiceTypeObj obj = Obj;
		schema.getBackingStore().getTableServiceType().updateServiceType( schema.getAuthorization(),
			Obj.getServiceTypeBuff() );
		obj = (ICFBamServiceTypeObj)Obj.realize();
		return( obj );
	}

	public void deleteServiceType( ICFBamServiceTypeObj Obj ) {
		ICFBamServiceTypeObj obj = Obj;
		schema.getBackingStore().getTableServiceType().deleteServiceType( schema.getAuthorization(),
			obj.getServiceTypeBuff() );
		obj.forget( true );
	}

	public void deleteServiceTypeByIdIdx( int ServiceTypeId )
	{
		CFBamServiceTypePKey pkey = schema.getBackingStore().getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( ServiceTypeId );
		ICFBamServiceTypeObj obj = readServiceType( pkey );
		if( obj != null ) {
			ICFBamServiceTypeEditObj editObj = (ICFBamServiceTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamServiceTypeEditObj)obj.beginEdit();
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

	public void deleteServiceTypeByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamServiceTypeByUDescrIdxKey,
				ICFBamServiceTypeObj >();
		}
		CFBamServiceTypeByUDescrIdxKey key = schema.getBackingStore().getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamServiceTypeObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			schema.getBackingStore().getTableServiceType().deleteServiceTypeByUDescrIdx( schema.getAuthorization(),
				Description );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableServiceType().deleteServiceTypeByUDescrIdx( schema.getAuthorization(),
				Description );
		}
	}
}
