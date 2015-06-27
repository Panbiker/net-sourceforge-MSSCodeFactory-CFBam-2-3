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

public class CFBamLoaderBehaviourTableObj
	implements ICFBamLoaderBehaviourTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamLoaderBehaviourPKey, ICFBamLoaderBehaviourObj> members;
	private Map<CFBamLoaderBehaviourPKey, ICFBamLoaderBehaviourObj> allLoaderBehaviour;
	private Map< CFBamLoaderBehaviourByUNameIdxKey,
		ICFBamLoaderBehaviourObj > indexByUNameIdx;
	public static String TABLE_NAME = "LoaderBehaviour";
	public static String TABLE_DBNAME = "loadbehav";

	public CFBamLoaderBehaviourTableObj() {
		schema = null;
		members = new HashMap<CFBamLoaderBehaviourPKey, ICFBamLoaderBehaviourObj>();
		allLoaderBehaviour = null;
		indexByUNameIdx = null;
	}

	public CFBamLoaderBehaviourTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamLoaderBehaviourPKey, ICFBamLoaderBehaviourObj>();
		allLoaderBehaviour = null;
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
		allLoaderBehaviour = null;
		indexByUNameIdx = null;
		List<ICFBamLoaderBehaviourObj> toForget = new LinkedList<ICFBamLoaderBehaviourObj>();
		ICFBamLoaderBehaviourObj cur = null;
		Iterator<ICFBamLoaderBehaviourObj> iter = members.values().iterator();
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
	 *	CFBamLoaderBehaviourObj.
	 */
	public ICFBamLoaderBehaviourObj newInstance() {
		ICFBamLoaderBehaviourObj inst = new CFBamLoaderBehaviourObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamLoaderBehaviourObj.
	 */
	public ICFBamLoaderBehaviourEditObj newEditInstance( ICFBamLoaderBehaviourObj orig ) {
		ICFBamLoaderBehaviourEditObj edit = new CFBamLoaderBehaviourEditObj( orig );
		return( edit );
	}

	public ICFBamLoaderBehaviourObj realizeLoaderBehaviour( ICFBamLoaderBehaviourObj Obj ) {
		ICFBamLoaderBehaviourObj obj = Obj;
		CFBamLoaderBehaviourPKey pkey = obj.getPKey();
		ICFBamLoaderBehaviourObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamLoaderBehaviourObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allLoaderBehaviour != null ) {
				allLoaderBehaviour.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allLoaderBehaviour != null ) {
				allLoaderBehaviour.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetLoaderBehaviour( ICFBamLoaderBehaviourObj Obj ) {
		forgetLoaderBehaviour( Obj, false );
	}

	public void forgetLoaderBehaviour( ICFBamLoaderBehaviourObj Obj, boolean forgetSubObjects ) {
		ICFBamLoaderBehaviourObj obj = Obj;
		CFBamLoaderBehaviourPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamLoaderBehaviourObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamLoaderBehaviourByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allLoaderBehaviour != null ) {
				allLoaderBehaviour.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetLoaderBehaviourByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFBamLoaderBehaviourPKey key = schema.getBackingStore().getFactoryLoaderBehaviour().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamLoaderBehaviourObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetLoaderBehaviourByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamLoaderBehaviourByUNameIdxKey key = schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamLoaderBehaviourObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamLoaderBehaviourObj createLoaderBehaviour( ICFBamLoaderBehaviourObj Obj ) {
		ICFBamLoaderBehaviourObj obj = Obj;
		CFBamLoaderBehaviourBuff buff = obj.getLoaderBehaviourBuff();
		schema.getBackingStore().getTableLoaderBehaviour().createLoaderBehaviour(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviour( CFBamLoaderBehaviourPKey pkey ) {
		return( readLoaderBehaviour( pkey, false ) );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviour( CFBamLoaderBehaviourPKey pkey, boolean forceRead ) {
		ICFBamLoaderBehaviourObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamLoaderBehaviourBuff readBuff = schema.getBackingStore().getTableLoaderBehaviour().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getLoaderBehaviourTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLoaderBehaviour().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamLoaderBehaviourObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamLoaderBehaviourObj lockLoaderBehaviour( CFBamLoaderBehaviourPKey pkey ) {
		ICFBamLoaderBehaviourObj locked = null;
		CFBamLoaderBehaviourBuff lockBuff = schema.getBackingStore().getTableLoaderBehaviour().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getLoaderBehaviourTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryLoaderBehaviour().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamLoaderBehaviourObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockLoaderBehaviour", pkey );
		}
		return( locked );
	}

	public List<ICFBamLoaderBehaviourObj> readAllLoaderBehaviour() {
		return( readAllLoaderBehaviour( false ) );
	}

	public List<ICFBamLoaderBehaviourObj> readAllLoaderBehaviour( boolean forceRead ) {
		final String S_ProcName = "readAllLoaderBehaviour";
		if( ( allLoaderBehaviour == null ) || forceRead ) {
			Map<CFBamLoaderBehaviourPKey, ICFBamLoaderBehaviourObj> map = new HashMap<CFBamLoaderBehaviourPKey,ICFBamLoaderBehaviourObj>();
			allLoaderBehaviour = map;
			CFBamLoaderBehaviourBuff[] buffList = schema.getBackingStore().getTableLoaderBehaviour().readAllDerived( schema.getAuthorization() );
			CFBamLoaderBehaviourBuff buff;
			ICFBamLoaderBehaviourObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLoaderBehaviour().newPKey() );
				obj.setBuff( buff );
				ICFBamLoaderBehaviourObj realized = (ICFBamLoaderBehaviourObj)obj.realize();
			}
		}
		Comparator<ICFBamLoaderBehaviourObj> cmp = new Comparator<ICFBamLoaderBehaviourObj>() {
			public int compare( ICFBamLoaderBehaviourObj lhs, ICFBamLoaderBehaviourObj rhs ) {
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
					CFBamLoaderBehaviourPKey lhsPKey = lhs.getPKey();
					CFBamLoaderBehaviourPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allLoaderBehaviour.size();
		ICFBamLoaderBehaviourObj arr[] = new ICFBamLoaderBehaviourObj[len];
		Iterator<ICFBamLoaderBehaviourObj> valIter = allLoaderBehaviour.values().iterator();
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
		ArrayList<ICFBamLoaderBehaviourObj> arrayList = new ArrayList<ICFBamLoaderBehaviourObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamLoaderBehaviourObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviourByIdIdx( short Id )
	{
		return( readLoaderBehaviourByIdIdx( Id,
			false ) );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviourByIdIdx( short Id, boolean forceRead )
	{
		CFBamLoaderBehaviourPKey pkey = schema.getBackingStore().getFactoryLoaderBehaviour().newPKey();
		pkey.setRequiredId( Id );
		ICFBamLoaderBehaviourObj obj = readLoaderBehaviour( pkey, forceRead );
		return( obj );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviourByUNameIdx( String Name )
	{
		return( readLoaderBehaviourByUNameIdx( Name,
			false ) );
	}

	public ICFBamLoaderBehaviourObj readLoaderBehaviourByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamLoaderBehaviourByUNameIdxKey,
				ICFBamLoaderBehaviourObj >();
		}
		CFBamLoaderBehaviourByUNameIdxKey key = schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamLoaderBehaviourObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamLoaderBehaviourBuff buff = schema.getBackingStore().getTableLoaderBehaviour().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getLoaderBehaviourTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLoaderBehaviour().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamLoaderBehaviourObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamLoaderBehaviourObj updateLoaderBehaviour( ICFBamLoaderBehaviourObj Obj ) {
		ICFBamLoaderBehaviourObj obj = Obj;
		schema.getBackingStore().getTableLoaderBehaviour().updateLoaderBehaviour( schema.getAuthorization(),
			Obj.getLoaderBehaviourBuff() );
		obj = (ICFBamLoaderBehaviourObj)Obj.realize();
		return( obj );
	}

	public void deleteLoaderBehaviour( ICFBamLoaderBehaviourObj Obj ) {
		ICFBamLoaderBehaviourObj obj = Obj;
		schema.getBackingStore().getTableLoaderBehaviour().deleteLoaderBehaviour( schema.getAuthorization(),
			obj.getLoaderBehaviourBuff() );
		obj.forget( true );
	}

	public void deleteLoaderBehaviourByIdIdx( short Id )
	{
		CFBamLoaderBehaviourPKey pkey = schema.getBackingStore().getFactoryLoaderBehaviour().newPKey();
		pkey.setRequiredId( Id );
		ICFBamLoaderBehaviourObj obj = readLoaderBehaviour( pkey );
		if( obj != null ) {
			ICFBamLoaderBehaviourEditObj editObj = (ICFBamLoaderBehaviourEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamLoaderBehaviourEditObj)obj.beginEdit();
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

	public void deleteLoaderBehaviourByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamLoaderBehaviourByUNameIdxKey,
				ICFBamLoaderBehaviourObj >();
		}
		CFBamLoaderBehaviourByUNameIdxKey key = schema.getBackingStore().getFactoryLoaderBehaviour().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFBamLoaderBehaviourObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableLoaderBehaviour().deleteLoaderBehaviourByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableLoaderBehaviour().deleteLoaderBehaviourByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
