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

public class CFBamClearTopDepTableObj
	implements ICFBamClearTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamClearTopDepObj> allClearTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByTenantIdx;
	private Map< CFBamClearDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByTableIdx;
	private Map< CFBamClearTopDepByContTblIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByContTblIdx;
	private Map< CFBamClearTopDepByUNameIdxKey,
		ICFBamClearTopDepObj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearTopDep";
	public static String TABLE_DBNAME = "clr_topdep";

	public CFBamClearTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContTblIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContTblIdx = null;
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
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContTblIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearTopDepObj.
	 */
	public ICFBamClearTopDepObj newInstance() {
		ICFBamClearTopDepObj inst = new CFBamClearTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearTopDepObj.
	 */
	public ICFBamClearTopDepEditObj newEditInstance( ICFBamClearTopDepObj orig ) {
		ICFBamClearTopDepEditObj edit = new CFBamClearTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamClearTopDepObj realizeClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearTopDepObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamClearTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearTopDepObj)schema.getClearDepTableObj().realizeClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamClearTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearTopDepObj)schema.getClearDepTableObj().realizeClearDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamClearTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetClearTopDep( ICFBamClearTopDepObj Obj ) {
		forgetClearTopDep( Obj, false );
	}

	public void forgetClearTopDep( ICFBamClearTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamClearTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearTopDep != null ) {
				allClearTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getClearSubDep1TableObj().forgetClearSubDep1ByContClearTopIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
				ICFBamClearTopDepObj cur = null;
				Iterator<ICFBamClearTopDepObj> iter = mapTenantIdx.values().iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					toForget.add( cur );
				}
				iter = toForget.iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					cur.forget( true );
				}
			}

			indexByTenantIdx.remove( key );
		}
	}

	public void forgetClearTopDepByTableIdx( long TenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
				ICFBamClearTopDepObj cur = null;
				Iterator<ICFBamClearTopDepObj> iter = mapTableIdx.values().iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					toForget.add( cur );
				}
				iter = toForget.iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					cur.forget( true );
				}
			}

			indexByTableIdx.remove( key );
		}
	}

	public void forgetClearTopDepByContTblIdx( long TenantId,
		long ContTableId )
	{
		if( indexByContTblIdx == null ) {
			return;
		}
		CFBamClearTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		if( indexByContTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapContTblIdx = indexByContTblIdx.get( key );
			if( mapContTblIdx != null ) {
				List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
				ICFBamClearTopDepObj cur = null;
				Iterator<ICFBamClearTopDepObj> iter = mapContTblIdx.values().iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					toForget.add( cur );
				}
				iter = toForget.iterator();
				while( iter.hasNext() ) {
					cur = iter.next();
					cur.forget( true );
				}
			}

			indexByContTblIdx.remove( key );
		}
	}

	public void forgetClearTopDepByUNameIdx( long TenantId,
		long ContTableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamClearTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamClearTopDepObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamClearTopDepObj createClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamClearTopDepBuff buff = obj.getClearTopDepBuff();
		schema.getBackingStore().getTableClearTopDep().createClearTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLRT" ) ) {
			obj = (ICFBamClearTopDepObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey ) {
		return( readClearTopDep( pkey, false ) );
	}

	public ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearTopDepBuff readBuff = schema.getBackingStore().getTableClearTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClearTopDepObj lockClearTopDep( CFBamScopePKey pkey ) {
		ICFBamClearTopDepObj locked = null;
		CFBamClearTopDepBuff lockBuff = schema.getBackingStore().getTableClearTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearTopDepObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockClearTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearTopDepObj> readAllClearTopDep() {
		return( readAllClearTopDep( false ) );
	}

	public List<ICFBamClearTopDepObj> readAllClearTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearTopDep";
		if( ( allClearTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamClearTopDepObj>();
			allClearTopDep = map;
			CFBamClearTopDepBuff[] buffList = schema.getBackingStore().getTableClearTopDep().readAllDerived( schema.getAuthorization() );
			CFBamClearTopDepBuff buff;
			ICFBamClearTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realized = (ICFBamClearTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allClearTopDep.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = allClearTopDep.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readClearTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearTopDepObj obj = readClearTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId )
	{
		return( readClearTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realized = (ICFBamClearTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTableIdx( long TenantId,
		long RelationId )
	{
		return( readClearTopDepByTableIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByTableIdx";
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realized = (ICFBamClearTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByContTblIdx( long TenantId,
		long ContTableId )
	{
		return( readClearTopDepByContTblIdx( TenantId,
			ContTableId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByContTblIdx( long TenantId,
		long ContTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByContTblIdx";
		CFBamClearTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByContTblIdx == null ) {
			indexByContTblIdx = new HashMap< CFBamClearTopDepByContTblIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByContTblIdx.containsKey( key ) ) {
			dict = indexByContTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContTblIdx.put( key, dict );
			ICFBamClearTopDepObj obj;
			CFBamClearTopDepBuff[] buffList = schema.getBackingStore().getTableClearTopDep().readDerivedByContTblIdx( schema.getAuthorization(),
				TenantId,
				ContTableId );
			CFBamClearTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realized = (ICFBamClearTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearTopDepObj readClearTopDepByUNameIdx( long TenantId,
		long ContTableId,
		String Name )
	{
		return( readClearTopDepByUNameIdx( TenantId,
			ContTableId,
			Name,
			false ) );
	}

	public ICFBamClearTopDepObj readClearTopDepByUNameIdx( long TenantId,
		long ContTableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearTopDepByUNameIdxKey,
				ICFBamClearTopDepObj >();
		}
		CFBamClearTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		ICFBamClearTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearTopDepBuff buff = schema.getBackingStore().getTableClearTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContTableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClearTopDepObj updateClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		schema.getBackingStore().getTableClearTopDep().updateClearTopDep( schema.getAuthorization(),
			Obj.getClearTopDepBuff() );
		if( Obj.getClassCode().equals( "CLRT" ) ) {
			obj = (ICFBamClearTopDepObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		schema.getBackingStore().getTableClearTopDep().deleteClearTopDep( schema.getAuthorization(),
			obj.getClearTopDepBuff() );
		obj.forget( true );
	}

	public void deleteClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readClearTopDep( pkey );
		if( obj != null ) {
			ICFBamClearTopDepEditObj editObj = (ICFBamClearTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearTopDepEditObj)obj.beginEdit();
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

	public void deleteClearTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearTopDepByTableIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTableIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearTopDepByContTblIdx( long TenantId,
		long ContTableId )
	{
		CFBamClearTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newContTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		if( indexByContTblIdx == null ) {
			indexByContTblIdx = new HashMap< CFBamClearTopDepByContTblIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByContTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByContTblIdx.get( key );
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByContTblIdx( schema.getAuthorization(),
				TenantId,
				ContTableId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContTblIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByContTblIdx( schema.getAuthorization(),
				TenantId,
				ContTableId );
		}
	}

	public void deleteClearTopDepByUNameIdx( long TenantId,
		long ContTableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearTopDepByUNameIdxKey,
				ICFBamClearTopDepObj >();
		}
		CFBamClearTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		ICFBamClearTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContTableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableClearTopDep().deleteClearTopDepByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContTableId,
				Name );
		}
	}
}
