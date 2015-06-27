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

public class CFBamAccessSecurityTableObj
	implements ICFBamAccessSecurityTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamAccessSecurityPKey, ICFBamAccessSecurityObj> members;
	private Map<CFBamAccessSecurityPKey, ICFBamAccessSecurityObj> allAccessSecurity;
	private Map< CFBamAccessSecurityByUNameIdxKey,
		ICFBamAccessSecurityObj > indexByUNameIdx;
	public static String TABLE_NAME = "AccessSecurity";
	public static String TABLE_DBNAME = "accsec";

	public CFBamAccessSecurityTableObj() {
		schema = null;
		members = new HashMap<CFBamAccessSecurityPKey, ICFBamAccessSecurityObj>();
		allAccessSecurity = null;
		indexByUNameIdx = null;
	}

	public CFBamAccessSecurityTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamAccessSecurityPKey, ICFBamAccessSecurityObj>();
		allAccessSecurity = null;
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
		allAccessSecurity = null;
		indexByUNameIdx = null;
		List<ICFBamAccessSecurityObj> toForget = new LinkedList<ICFBamAccessSecurityObj>();
		ICFBamAccessSecurityObj cur = null;
		Iterator<ICFBamAccessSecurityObj> iter = members.values().iterator();
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
	 *	CFBamAccessSecurityObj.
	 */
	public ICFBamAccessSecurityObj newInstance() {
		ICFBamAccessSecurityObj inst = new CFBamAccessSecurityObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamAccessSecurityObj.
	 */
	public ICFBamAccessSecurityEditObj newEditInstance( ICFBamAccessSecurityObj orig ) {
		ICFBamAccessSecurityEditObj edit = new CFBamAccessSecurityEditObj( orig );
		return( edit );
	}

	public ICFBamAccessSecurityObj realizeAccessSecurity( ICFBamAccessSecurityObj Obj ) {
		ICFBamAccessSecurityObj obj = Obj;
		CFBamAccessSecurityPKey pkey = obj.getPKey();
		ICFBamAccessSecurityObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamAccessSecurityObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamAccessSecurityByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamAccessSecurityByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allAccessSecurity != null ) {
				allAccessSecurity.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allAccessSecurity != null ) {
				allAccessSecurity.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamAccessSecurityByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetAccessSecurity( ICFBamAccessSecurityObj Obj ) {
		forgetAccessSecurity( Obj, false );
	}

	public void forgetAccessSecurity( ICFBamAccessSecurityObj Obj, boolean forgetSubObjects ) {
		ICFBamAccessSecurityObj obj = Obj;
		CFBamAccessSecurityPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamAccessSecurityObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamAccessSecurityByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allAccessSecurity != null ) {
				allAccessSecurity.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetAccessSecurityByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamAccessSecurityPKey key = schema.getBackingStore().getFactoryAccessSecurity().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamAccessSecurityObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetAccessSecurityByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamAccessSecurityByUNameIdxKey key = schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamAccessSecurityObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamAccessSecurityObj createAccessSecurity( ICFBamAccessSecurityObj Obj ) {
		ICFBamAccessSecurityObj obj = Obj;
		CFBamAccessSecurityBuff buff = obj.getAccessSecurityBuff();
		schema.getBackingStore().getTableAccessSecurity().createAccessSecurity(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamAccessSecurityObj readAccessSecurity( CFBamAccessSecurityPKey pkey ) {
		return( readAccessSecurity( pkey, false ) );
	}

	public ICFBamAccessSecurityObj readAccessSecurity( CFBamAccessSecurityPKey pkey, boolean forceRead ) {
		ICFBamAccessSecurityObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamAccessSecurityBuff readBuff = schema.getBackingStore().getTableAccessSecurity().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getAccessSecurityTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessSecurity().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamAccessSecurityObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamAccessSecurityObj lockAccessSecurity( CFBamAccessSecurityPKey pkey ) {
		ICFBamAccessSecurityObj locked = null;
		CFBamAccessSecurityBuff lockBuff = schema.getBackingStore().getTableAccessSecurity().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getAccessSecurityTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryAccessSecurity().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamAccessSecurityObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockAccessSecurity", pkey );
		}
		return( locked );
	}

	public List<ICFBamAccessSecurityObj> readAllAccessSecurity() {
		return( readAllAccessSecurity( false ) );
	}

	public List<ICFBamAccessSecurityObj> readAllAccessSecurity( boolean forceRead ) {
		final String S_ProcName = "readAllAccessSecurity";
		if( ( allAccessSecurity == null ) || forceRead ) {
			Map<CFBamAccessSecurityPKey, ICFBamAccessSecurityObj> map = new HashMap<CFBamAccessSecurityPKey,ICFBamAccessSecurityObj>();
			allAccessSecurity = map;
			CFBamAccessSecurityBuff[] buffList = schema.getBackingStore().getTableAccessSecurity().readAllDerived( schema.getAuthorization() );
			CFBamAccessSecurityBuff buff;
			ICFBamAccessSecurityObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessSecurity().newPKey() );
				obj.setBuff( buff );
				ICFBamAccessSecurityObj realized = (ICFBamAccessSecurityObj)obj.realize();
			}
		}
		Comparator<ICFBamAccessSecurityObj> cmp = new Comparator<ICFBamAccessSecurityObj>() {
			public int compare( ICFBamAccessSecurityObj lhs, ICFBamAccessSecurityObj rhs ) {
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
					CFBamAccessSecurityPKey lhsPKey = lhs.getPKey();
					CFBamAccessSecurityPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allAccessSecurity.size();
		ICFBamAccessSecurityObj arr[] = new ICFBamAccessSecurityObj[len];
		Iterator<ICFBamAccessSecurityObj> valIter = allAccessSecurity.values().iterator();
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
		ArrayList<ICFBamAccessSecurityObj> arrayList = new ArrayList<ICFBamAccessSecurityObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamAccessSecurityObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamAccessSecurityObj readAccessSecurityByIdIdx( short Id )
	{
		return( readAccessSecurityByIdIdx( Id,
			false ) );
	}

	public ICFBamAccessSecurityObj readAccessSecurityByIdIdx( short Id, boolean forceRead )
	{
		CFBamAccessSecurityPKey pkey = schema.getBackingStore().getFactoryAccessSecurity().newPKey();
		pkey.setRequiredId( Id );
		ICFBamAccessSecurityObj obj = readAccessSecurity( pkey, forceRead );
		return( obj );
	}

	public ICFBamAccessSecurityObj readAccessSecurityByUNameIdx( String Name )
	{
		return( readAccessSecurityByUNameIdx( Name,
			false ) );
	}

	public ICFBamAccessSecurityObj readAccessSecurityByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamAccessSecurityByUNameIdxKey,
				ICFBamAccessSecurityObj >();
		}
		CFBamAccessSecurityByUNameIdxKey key = schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamAccessSecurityObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamAccessSecurityBuff buff = schema.getBackingStore().getTableAccessSecurity().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getAccessSecurityTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessSecurity().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamAccessSecurityObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamAccessSecurityObj updateAccessSecurity( ICFBamAccessSecurityObj Obj ) {
		ICFBamAccessSecurityObj obj = Obj;
		schema.getBackingStore().getTableAccessSecurity().updateAccessSecurity( schema.getAuthorization(),
			Obj.getAccessSecurityBuff() );
		obj = (ICFBamAccessSecurityObj)Obj.realize();
		return( obj );
	}

	public void deleteAccessSecurity( ICFBamAccessSecurityObj Obj ) {
		ICFBamAccessSecurityObj obj = Obj;
		schema.getBackingStore().getTableAccessSecurity().deleteAccessSecurity( schema.getAuthorization(),
			obj.getAccessSecurityBuff() );
		obj.forget( true );
	}

	public void deleteAccessSecurityByIdIdx( short Id )
	{
		CFBamAccessSecurityPKey pkey = schema.getBackingStore().getFactoryAccessSecurity().newPKey();
		pkey.setRequiredId( Id );
		ICFBamAccessSecurityObj obj = readAccessSecurity( pkey );
		if( obj != null ) {
			ICFBamAccessSecurityEditObj editObj = (ICFBamAccessSecurityEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamAccessSecurityEditObj)obj.beginEdit();
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

	public void deleteAccessSecurityByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamAccessSecurityByUNameIdxKey,
				ICFBamAccessSecurityObj >();
		}
		CFBamAccessSecurityByUNameIdxKey key = schema.getBackingStore().getFactoryAccessSecurity().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamAccessSecurityObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableAccessSecurity().deleteAccessSecurityByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableAccessSecurity().deleteAccessSecurityByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
