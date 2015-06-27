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

public class CFBamAccessFrequencyTableObj
	implements ICFBamAccessFrequencyTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamAccessFrequencyPKey, ICFBamAccessFrequencyObj> members;
	private Map<CFBamAccessFrequencyPKey, ICFBamAccessFrequencyObj> allAccessFrequency;
	private Map< CFBamAccessFrequencyByUNameIdxKey,
		ICFBamAccessFrequencyObj > indexByUNameIdx;
	public static String TABLE_NAME = "AccessFrequency";
	public static String TABLE_DBNAME = "accfreq";

	public CFBamAccessFrequencyTableObj() {
		schema = null;
		members = new HashMap<CFBamAccessFrequencyPKey, ICFBamAccessFrequencyObj>();
		allAccessFrequency = null;
		indexByUNameIdx = null;
	}

	public CFBamAccessFrequencyTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamAccessFrequencyPKey, ICFBamAccessFrequencyObj>();
		allAccessFrequency = null;
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
		allAccessFrequency = null;
		indexByUNameIdx = null;
		List<ICFBamAccessFrequencyObj> toForget = new LinkedList<ICFBamAccessFrequencyObj>();
		ICFBamAccessFrequencyObj cur = null;
		Iterator<ICFBamAccessFrequencyObj> iter = members.values().iterator();
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
	 *	CFBamAccessFrequencyObj.
	 */
	public ICFBamAccessFrequencyObj newInstance() {
		ICFBamAccessFrequencyObj inst = new CFBamAccessFrequencyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamAccessFrequencyObj.
	 */
	public ICFBamAccessFrequencyEditObj newEditInstance( ICFBamAccessFrequencyObj orig ) {
		ICFBamAccessFrequencyEditObj edit = new CFBamAccessFrequencyEditObj( orig );
		return( edit );
	}

	public ICFBamAccessFrequencyObj realizeAccessFrequency( ICFBamAccessFrequencyObj Obj ) {
		ICFBamAccessFrequencyObj obj = Obj;
		CFBamAccessFrequencyPKey pkey = obj.getPKey();
		ICFBamAccessFrequencyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamAccessFrequencyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamAccessFrequencyByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamAccessFrequencyByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allAccessFrequency != null ) {
				allAccessFrequency.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allAccessFrequency != null ) {
				allAccessFrequency.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamAccessFrequencyByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetAccessFrequency( ICFBamAccessFrequencyObj Obj ) {
		forgetAccessFrequency( Obj, false );
	}

	public void forgetAccessFrequency( ICFBamAccessFrequencyObj Obj, boolean forgetSubObjects ) {
		ICFBamAccessFrequencyObj obj = Obj;
		CFBamAccessFrequencyPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamAccessFrequencyObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamAccessFrequencyByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allAccessFrequency != null ) {
				allAccessFrequency.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetAccessFrequencyByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamAccessFrequencyPKey key = schema.getBackingStore().getFactoryAccessFrequency().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamAccessFrequencyObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetAccessFrequencyByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamAccessFrequencyByUNameIdxKey key = schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamAccessFrequencyObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamAccessFrequencyObj createAccessFrequency( ICFBamAccessFrequencyObj Obj ) {
		ICFBamAccessFrequencyObj obj = Obj;
		CFBamAccessFrequencyBuff buff = obj.getAccessFrequencyBuff();
		schema.getBackingStore().getTableAccessFrequency().createAccessFrequency(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamAccessFrequencyObj readAccessFrequency( CFBamAccessFrequencyPKey pkey ) {
		return( readAccessFrequency( pkey, false ) );
	}

	public ICFBamAccessFrequencyObj readAccessFrequency( CFBamAccessFrequencyPKey pkey, boolean forceRead ) {
		ICFBamAccessFrequencyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamAccessFrequencyBuff readBuff = schema.getBackingStore().getTableAccessFrequency().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getAccessFrequencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessFrequency().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamAccessFrequencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamAccessFrequencyObj lockAccessFrequency( CFBamAccessFrequencyPKey pkey ) {
		ICFBamAccessFrequencyObj locked = null;
		CFBamAccessFrequencyBuff lockBuff = schema.getBackingStore().getTableAccessFrequency().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getAccessFrequencyTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryAccessFrequency().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamAccessFrequencyObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockAccessFrequency", pkey );
		}
		return( locked );
	}

	public List<ICFBamAccessFrequencyObj> readAllAccessFrequency() {
		return( readAllAccessFrequency( false ) );
	}

	public List<ICFBamAccessFrequencyObj> readAllAccessFrequency( boolean forceRead ) {
		final String S_ProcName = "readAllAccessFrequency";
		if( ( allAccessFrequency == null ) || forceRead ) {
			Map<CFBamAccessFrequencyPKey, ICFBamAccessFrequencyObj> map = new HashMap<CFBamAccessFrequencyPKey,ICFBamAccessFrequencyObj>();
			allAccessFrequency = map;
			CFBamAccessFrequencyBuff[] buffList = schema.getBackingStore().getTableAccessFrequency().readAllDerived( schema.getAuthorization() );
			CFBamAccessFrequencyBuff buff;
			ICFBamAccessFrequencyObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessFrequency().newPKey() );
				obj.setBuff( buff );
				ICFBamAccessFrequencyObj realized = (ICFBamAccessFrequencyObj)obj.realize();
			}
		}
		Comparator<ICFBamAccessFrequencyObj> cmp = new Comparator<ICFBamAccessFrequencyObj>() {
			public int compare( ICFBamAccessFrequencyObj lhs, ICFBamAccessFrequencyObj rhs ) {
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
					CFBamAccessFrequencyPKey lhsPKey = lhs.getPKey();
					CFBamAccessFrequencyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allAccessFrequency.size();
		ICFBamAccessFrequencyObj arr[] = new ICFBamAccessFrequencyObj[len];
		Iterator<ICFBamAccessFrequencyObj> valIter = allAccessFrequency.values().iterator();
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
		ArrayList<ICFBamAccessFrequencyObj> arrayList = new ArrayList<ICFBamAccessFrequencyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamAccessFrequencyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamAccessFrequencyObj readAccessFrequencyByIdIdx( short Id )
	{
		return( readAccessFrequencyByIdIdx( Id,
			false ) );
	}

	public ICFBamAccessFrequencyObj readAccessFrequencyByIdIdx( short Id, boolean forceRead )
	{
		CFBamAccessFrequencyPKey pkey = schema.getBackingStore().getFactoryAccessFrequency().newPKey();
		pkey.setRequiredId( Id );
		ICFBamAccessFrequencyObj obj = readAccessFrequency( pkey, forceRead );
		return( obj );
	}

	public ICFBamAccessFrequencyObj readAccessFrequencyByUNameIdx( String Name )
	{
		return( readAccessFrequencyByUNameIdx( Name,
			false ) );
	}

	public ICFBamAccessFrequencyObj readAccessFrequencyByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamAccessFrequencyByUNameIdxKey,
				ICFBamAccessFrequencyObj >();
		}
		CFBamAccessFrequencyByUNameIdxKey key = schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamAccessFrequencyObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamAccessFrequencyBuff buff = schema.getBackingStore().getTableAccessFrequency().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getAccessFrequencyTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAccessFrequency().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamAccessFrequencyObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamAccessFrequencyObj updateAccessFrequency( ICFBamAccessFrequencyObj Obj ) {
		ICFBamAccessFrequencyObj obj = Obj;
		schema.getBackingStore().getTableAccessFrequency().updateAccessFrequency( schema.getAuthorization(),
			Obj.getAccessFrequencyBuff() );
		obj = (ICFBamAccessFrequencyObj)Obj.realize();
		return( obj );
	}

	public void deleteAccessFrequency( ICFBamAccessFrequencyObj Obj ) {
		ICFBamAccessFrequencyObj obj = Obj;
		schema.getBackingStore().getTableAccessFrequency().deleteAccessFrequency( schema.getAuthorization(),
			obj.getAccessFrequencyBuff() );
		obj.forget( true );
	}

	public void deleteAccessFrequencyByIdIdx( short Id )
	{
		CFBamAccessFrequencyPKey pkey = schema.getBackingStore().getFactoryAccessFrequency().newPKey();
		pkey.setRequiredId( Id );
		ICFBamAccessFrequencyObj obj = readAccessFrequency( pkey );
		if( obj != null ) {
			ICFBamAccessFrequencyEditObj editObj = (ICFBamAccessFrequencyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamAccessFrequencyEditObj)obj.beginEdit();
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

	public void deleteAccessFrequencyByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamAccessFrequencyByUNameIdxKey,
				ICFBamAccessFrequencyObj >();
		}
		CFBamAccessFrequencyByUNameIdxKey key = schema.getBackingStore().getFactoryAccessFrequency().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamAccessFrequencyObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableAccessFrequency().deleteAccessFrequencyByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableAccessFrequency().deleteAccessFrequencyByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
