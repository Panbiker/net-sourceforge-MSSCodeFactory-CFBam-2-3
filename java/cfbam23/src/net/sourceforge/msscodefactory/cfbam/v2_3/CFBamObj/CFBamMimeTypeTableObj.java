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

public class CFBamMimeTypeTableObj
	implements ICFBamMimeTypeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamMimeTypePKey, ICFBamMimeTypeObj> members;
	private Map<CFBamMimeTypePKey, ICFBamMimeTypeObj> allMimeType;
	private Map< CFBamMimeTypeByUNameIdxKey,
		ICFBamMimeTypeObj > indexByUNameIdx;
	public static String TABLE_NAME = "MimeType";
	public static String TABLE_DBNAME = "mimetype";

	public CFBamMimeTypeTableObj() {
		schema = null;
		members = new HashMap<CFBamMimeTypePKey, ICFBamMimeTypeObj>();
		allMimeType = null;
		indexByUNameIdx = null;
	}

	public CFBamMimeTypeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamMimeTypePKey, ICFBamMimeTypeObj>();
		allMimeType = null;
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
		allMimeType = null;
		indexByUNameIdx = null;
		List<ICFBamMimeTypeObj> toForget = new LinkedList<ICFBamMimeTypeObj>();
		ICFBamMimeTypeObj cur = null;
		Iterator<ICFBamMimeTypeObj> iter = members.values().iterator();
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
	 *	CFBamMimeTypeObj.
	 */
	public ICFBamMimeTypeObj newInstance() {
		ICFBamMimeTypeObj inst = new CFBamMimeTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMimeTypeObj.
	 */
	public ICFBamMimeTypeEditObj newEditInstance( ICFBamMimeTypeObj orig ) {
		ICFBamMimeTypeEditObj edit = new CFBamMimeTypeEditObj( orig );
		return( edit );
	}

	public ICFBamMimeTypeObj realizeMimeType( ICFBamMimeTypeObj Obj ) {
		ICFBamMimeTypeObj obj = Obj;
		CFBamMimeTypePKey pkey = obj.getPKey();
		ICFBamMimeTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamMimeTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetMimeType( ICFBamMimeTypeObj Obj ) {
		forgetMimeType( Obj, false );
	}

	public void forgetMimeType( ICFBamMimeTypeObj Obj, boolean forgetSubObjects ) {
		ICFBamMimeTypeObj obj = Obj;
		CFBamMimeTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamMimeTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allMimeType != null ) {
				allMimeType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetMimeTypeByIdIdx( int MimeTypeId )
	{
		if( members == null ) {
			return;
		}
		CFBamMimeTypePKey key = schema.getBackingStore().getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( MimeTypeId );
		if( members.containsKey( key ) ) {
			ICFBamMimeTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetMimeTypeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamMimeTypeByUNameIdxKey key = schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamMimeTypeObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamMimeTypeObj createMimeType( ICFBamMimeTypeObj Obj ) {
		ICFBamMimeTypeObj obj = Obj;
		CFBamMimeTypeBuff buff = obj.getMimeTypeBuff();
		schema.getBackingStore().getTableMimeType().createMimeType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamMimeTypeObj readMimeType( CFBamMimeTypePKey pkey ) {
		return( readMimeType( pkey, false ) );
	}

	public ICFBamMimeTypeObj readMimeType( CFBamMimeTypePKey pkey, boolean forceRead ) {
		ICFBamMimeTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamMimeTypeBuff readBuff = schema.getBackingStore().getTableMimeType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredMimeTypeId() );
			if( readBuff != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryMimeType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamMimeTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamMimeTypeObj lockMimeType( CFBamMimeTypePKey pkey ) {
		ICFBamMimeTypeObj locked = null;
		CFBamMimeTypeBuff lockBuff = schema.getBackingStore().getTableMimeType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getMimeTypeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryMimeType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamMimeTypeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockMimeType", pkey );
		}
		return( locked );
	}

	public List<ICFBamMimeTypeObj> readAllMimeType() {
		return( readAllMimeType( false ) );
	}

	public List<ICFBamMimeTypeObj> readAllMimeType( boolean forceRead ) {
		final String S_ProcName = "readAllMimeType";
		if( ( allMimeType == null ) || forceRead ) {
			Map<CFBamMimeTypePKey, ICFBamMimeTypeObj> map = new HashMap<CFBamMimeTypePKey,ICFBamMimeTypeObj>();
			allMimeType = map;
			CFBamMimeTypeBuff[] buffList = schema.getBackingStore().getTableMimeType().readAllDerived( schema.getAuthorization() );
			CFBamMimeTypeBuff buff;
			ICFBamMimeTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryMimeType().newPKey() );
				obj.setBuff( buff );
				ICFBamMimeTypeObj realized = (ICFBamMimeTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamMimeTypeObj> cmp = new Comparator<ICFBamMimeTypeObj>() {
			public int compare( ICFBamMimeTypeObj lhs, ICFBamMimeTypeObj rhs ) {
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
					CFBamMimeTypePKey lhsPKey = lhs.getPKey();
					CFBamMimeTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allMimeType.size();
		ICFBamMimeTypeObj arr[] = new ICFBamMimeTypeObj[len];
		Iterator<ICFBamMimeTypeObj> valIter = allMimeType.values().iterator();
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
		ArrayList<ICFBamMimeTypeObj> arrayList = new ArrayList<ICFBamMimeTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMimeTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId )
	{
		return( readMimeTypeByIdIdx( MimeTypeId,
			false ) );
	}

	public ICFBamMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId, boolean forceRead )
	{
		CFBamMimeTypePKey pkey = schema.getBackingStore().getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( MimeTypeId );
		ICFBamMimeTypeObj obj = readMimeType( pkey, forceRead );
		return( obj );
	}

	public ICFBamMimeTypeObj readMimeTypeByUNameIdx( String Name )
	{
		return( readMimeTypeByUNameIdx( Name,
			false ) );
	}

	public ICFBamMimeTypeObj readMimeTypeByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamMimeTypeByUNameIdxKey,
				ICFBamMimeTypeObj >();
		}
		CFBamMimeTypeByUNameIdxKey key = schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamMimeTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamMimeTypeBuff buff = schema.getBackingStore().getTableMimeType().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryMimeType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamMimeTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamMimeTypeObj updateMimeType( ICFBamMimeTypeObj Obj ) {
		ICFBamMimeTypeObj obj = Obj;
		schema.getBackingStore().getTableMimeType().updateMimeType( schema.getAuthorization(),
			Obj.getMimeTypeBuff() );
		obj = (ICFBamMimeTypeObj)Obj.realize();
		return( obj );
	}

	public void deleteMimeType( ICFBamMimeTypeObj Obj ) {
		ICFBamMimeTypeObj obj = Obj;
		schema.getBackingStore().getTableMimeType().deleteMimeType( schema.getAuthorization(),
			obj.getMimeTypeBuff() );
		obj.forget( true );
	}

	public void deleteMimeTypeByIdIdx( int MimeTypeId )
	{
		CFBamMimeTypePKey pkey = schema.getBackingStore().getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( MimeTypeId );
		ICFBamMimeTypeObj obj = readMimeType( pkey );
		if( obj != null ) {
			ICFBamMimeTypeEditObj editObj = (ICFBamMimeTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamMimeTypeEditObj)obj.beginEdit();
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

	public void deleteMimeTypeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamMimeTypeByUNameIdxKey,
				ICFBamMimeTypeObj >();
		}
		CFBamMimeTypeByUNameIdxKey key = schema.getBackingStore().getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamMimeTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableMimeType().deleteMimeTypeByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableMimeType().deleteMimeTypeByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
