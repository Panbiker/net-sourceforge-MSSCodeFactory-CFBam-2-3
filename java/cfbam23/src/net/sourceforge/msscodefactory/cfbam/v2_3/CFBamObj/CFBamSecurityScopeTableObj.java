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

public class CFBamSecurityScopeTableObj
	implements ICFBamSecurityScopeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecurityScopePKey, ICFBamSecurityScopeObj> members;
	private Map<CFBamSecurityScopePKey, ICFBamSecurityScopeObj> allSecurityScope;
	private Map< CFBamSecurityScopeByUNameIdxKey,
		ICFBamSecurityScopeObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecurityScope";
	public static String TABLE_DBNAME = "secscope";

	public CFBamSecurityScopeTableObj() {
		schema = null;
		members = new HashMap<CFBamSecurityScopePKey, ICFBamSecurityScopeObj>();
		allSecurityScope = null;
		indexByUNameIdx = null;
	}

	public CFBamSecurityScopeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecurityScopePKey, ICFBamSecurityScopeObj>();
		allSecurityScope = null;
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
		allSecurityScope = null;
		indexByUNameIdx = null;
		List<ICFBamSecurityScopeObj> toForget = new LinkedList<ICFBamSecurityScopeObj>();
		ICFBamSecurityScopeObj cur = null;
		Iterator<ICFBamSecurityScopeObj> iter = members.values().iterator();
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
	 *	CFBamSecurityScopeObj.
	 */
	public ICFBamSecurityScopeObj newInstance() {
		ICFBamSecurityScopeObj inst = new CFBamSecurityScopeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecurityScopeObj.
	 */
	public ICFBamSecurityScopeEditObj newEditInstance( ICFBamSecurityScopeObj orig ) {
		ICFBamSecurityScopeEditObj edit = new CFBamSecurityScopeEditObj( orig );
		return( edit );
	}

	public ICFBamSecurityScopeObj realizeSecurityScope( ICFBamSecurityScopeObj Obj ) {
		ICFBamSecurityScopeObj obj = Obj;
		CFBamSecurityScopePKey pkey = obj.getPKey();
		ICFBamSecurityScopeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecurityScopeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamSecurityScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamSecurityScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allSecurityScope != null ) {
				allSecurityScope.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecurityScope != null ) {
				allSecurityScope.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamSecurityScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecurityScope( ICFBamSecurityScopeObj Obj ) {
		forgetSecurityScope( Obj, false );
	}

	public void forgetSecurityScope( ICFBamSecurityScopeObj Obj, boolean forgetSubObjects ) {
		ICFBamSecurityScopeObj obj = Obj;
		CFBamSecurityScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecurityScopeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamSecurityScopeByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allSecurityScope != null ) {
				allSecurityScope.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecurityScopeByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamSecurityScopePKey key = schema.getBackingStore().getFactorySecurityScope().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSecurityScopeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecurityScopeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamSecurityScopeByUNameIdxKey key = schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamSecurityScopeObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamSecurityScopeObj createSecurityScope( ICFBamSecurityScopeObj Obj ) {
		ICFBamSecurityScopeObj obj = Obj;
		CFBamSecurityScopeBuff buff = obj.getSecurityScopeBuff();
		schema.getBackingStore().getTableSecurityScope().createSecurityScope(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecurityScopeObj readSecurityScope( CFBamSecurityScopePKey pkey ) {
		return( readSecurityScope( pkey, false ) );
	}

	public ICFBamSecurityScopeObj readSecurityScope( CFBamSecurityScopePKey pkey, boolean forceRead ) {
		ICFBamSecurityScopeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecurityScopeBuff readBuff = schema.getBackingStore().getTableSecurityScope().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getSecurityScopeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecurityScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecurityScopeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecurityScopeObj lockSecurityScope( CFBamSecurityScopePKey pkey ) {
		ICFBamSecurityScopeObj locked = null;
		CFBamSecurityScopeBuff lockBuff = schema.getBackingStore().getTableSecurityScope().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecurityScopeTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecurityScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecurityScopeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecurityScope", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecurityScopeObj> readAllSecurityScope() {
		return( readAllSecurityScope( false ) );
	}

	public List<ICFBamSecurityScopeObj> readAllSecurityScope( boolean forceRead ) {
		final String S_ProcName = "readAllSecurityScope";
		if( ( allSecurityScope == null ) || forceRead ) {
			Map<CFBamSecurityScopePKey, ICFBamSecurityScopeObj> map = new HashMap<CFBamSecurityScopePKey,ICFBamSecurityScopeObj>();
			allSecurityScope = map;
			CFBamSecurityScopeBuff[] buffList = schema.getBackingStore().getTableSecurityScope().readAllDerived( schema.getAuthorization() );
			CFBamSecurityScopeBuff buff;
			ICFBamSecurityScopeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecurityScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSecurityScopeObj realized = (ICFBamSecurityScopeObj)obj.realize();
			}
		}
		Comparator<ICFBamSecurityScopeObj> cmp = new Comparator<ICFBamSecurityScopeObj>() {
			public int compare( ICFBamSecurityScopeObj lhs, ICFBamSecurityScopeObj rhs ) {
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
					CFBamSecurityScopePKey lhsPKey = lhs.getPKey();
					CFBamSecurityScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecurityScope.size();
		ICFBamSecurityScopeObj arr[] = new ICFBamSecurityScopeObj[len];
		Iterator<ICFBamSecurityScopeObj> valIter = allSecurityScope.values().iterator();
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
		ArrayList<ICFBamSecurityScopeObj> arrayList = new ArrayList<ICFBamSecurityScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecurityScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecurityScopeObj readSecurityScopeByIdIdx( short Id )
	{
		return( readSecurityScopeByIdIdx( Id,
			false ) );
	}

	public ICFBamSecurityScopeObj readSecurityScopeByIdIdx( short Id, boolean forceRead )
	{
		CFBamSecurityScopePKey pkey = schema.getBackingStore().getFactorySecurityScope().newPKey();
		pkey.setRequiredId( Id );
		ICFBamSecurityScopeObj obj = readSecurityScope( pkey, forceRead );
		return( obj );
	}

	public ICFBamSecurityScopeObj readSecurityScopeByUNameIdx( String Name )
	{
		return( readSecurityScopeByUNameIdx( Name,
			false ) );
	}

	public ICFBamSecurityScopeObj readSecurityScopeByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSecurityScopeByUNameIdxKey,
				ICFBamSecurityScopeObj >();
		}
		CFBamSecurityScopeByUNameIdxKey key = schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamSecurityScopeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSecurityScopeBuff buff = schema.getBackingStore().getTableSecurityScope().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getSecurityScopeTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecurityScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecurityScopeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecurityScopeObj updateSecurityScope( ICFBamSecurityScopeObj Obj ) {
		ICFBamSecurityScopeObj obj = Obj;
		schema.getBackingStore().getTableSecurityScope().updateSecurityScope( schema.getAuthorization(),
			Obj.getSecurityScopeBuff() );
		obj = (ICFBamSecurityScopeObj)Obj.realize();
		return( obj );
	}

	public void deleteSecurityScope( ICFBamSecurityScopeObj Obj ) {
		ICFBamSecurityScopeObj obj = Obj;
		schema.getBackingStore().getTableSecurityScope().deleteSecurityScope( schema.getAuthorization(),
			obj.getSecurityScopeBuff() );
		obj.forget( true );
	}

	public void deleteSecurityScopeByIdIdx( short Id )
	{
		CFBamSecurityScopePKey pkey = schema.getBackingStore().getFactorySecurityScope().newPKey();
		pkey.setRequiredId( Id );
		ICFBamSecurityScopeObj obj = readSecurityScope( pkey );
		if( obj != null ) {
			ICFBamSecurityScopeEditObj editObj = (ICFBamSecurityScopeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecurityScopeEditObj)obj.beginEdit();
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

	public void deleteSecurityScopeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSecurityScopeByUNameIdxKey,
				ICFBamSecurityScopeObj >();
		}
		CFBamSecurityScopeByUNameIdxKey key = schema.getBackingStore().getFactorySecurityScope().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamSecurityScopeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableSecurityScope().deleteSecurityScopeByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecurityScope().deleteSecurityScopeByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
