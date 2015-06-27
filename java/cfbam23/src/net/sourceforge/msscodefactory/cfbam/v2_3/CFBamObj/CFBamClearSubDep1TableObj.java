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

public class CFBamClearSubDep1TableObj
	implements ICFBamClearSubDep1TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep1Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep1Obj> allClearSubDep1;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByTableIdx;
	private Map< CFBamClearSubDep1ByContClearTopIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByContClearTopIdx;
	private Map< CFBamClearSubDep1ByUNameIdxKey,
		ICFBamClearSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep1";
	public static String TABLE_DBNAME = "clrsubdep1";

	public CFBamClearSubDep1TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearTopIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep1TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearTopIdx = null;
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
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearTopIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep1Obj.
	 */
	public ICFBamClearSubDep1Obj newInstance() {
		ICFBamClearSubDep1Obj inst = new CFBamClearSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep1Obj.
	 */
	public ICFBamClearSubDep1EditObj newEditInstance( ICFBamClearSubDep1Obj orig ) {
		ICFBamClearSubDep1EditObj edit = new CFBamClearSubDep1EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep1Obj realizeClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep1Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearTopIdx != null ) {
				CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
				keyContClearTopIdx.setRequiredContClearTopDepTenantId( keepObj.getRequiredContClearTopDepTenantId() );
				keyContClearTopIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapContClearTopIdx = indexByContClearTopIdx.get( keyContClearTopIdx );
				if( mapContClearTopIdx != null ) {
					mapContClearTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep1Obj)schema.getClearDepTableObj().realizeClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearTopIdx != null ) {
				CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
				keyContClearTopIdx.setRequiredContClearTopDepTenantId( keepObj.getRequiredContClearTopDepTenantId() );
				keyContClearTopIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapContClearTopIdx = indexByContClearTopIdx.get( keyContClearTopIdx );
				if( mapContClearTopIdx != null ) {
					mapContClearTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allClearSubDep1 != null ) {
				allClearSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep1Obj)schema.getClearDepTableObj().realizeClearDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep1 != null ) {
				allClearSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearTopIdx != null ) {
				CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
				keyContClearTopIdx.setRequiredContClearTopDepTenantId( keepObj.getRequiredContClearTopDepTenantId() );
				keyContClearTopIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapContClearTopIdx = indexByContClearTopIdx.get( keyContClearTopIdx );
				if( mapContClearTopIdx != null ) {
					mapContClearTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		forgetClearSubDep1( Obj, false );
	}

	public void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep1Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearTopIdx != null ) {
				CFBamClearSubDep1ByContClearTopIdxKey keyContClearTopIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
				keyContClearTopIdx.setRequiredContClearTopDepTenantId( keepObj.getRequiredContClearTopDepTenantId() );
				keyContClearTopIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapContClearTopIdx = indexByContClearTopIdx.get( keyContClearTopIdx );
				if( mapContClearTopIdx != null ) {
					mapContClearTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearTopDepId( keepObj.getRequiredContClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep1 != null ) {
				allClearSubDep1.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getClearSubDep2TableObj().forgetClearSubDep2ByContClearDep1Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep1Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep1ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
				ICFBamClearSubDep1Obj cur = null;
				Iterator<ICFBamClearSubDep1Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetClearSubDep1ByTableIdx( long TenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
				ICFBamClearSubDep1Obj cur = null;
				Iterator<ICFBamClearSubDep1Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetClearSubDep1ByContClearTopIdx( long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		if( indexByContClearTopIdx == null ) {
			return;
		}
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( ContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		if( indexByContClearTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapContClearTopIdx = indexByContClearTopIdx.get( key );
			if( mapContClearTopIdx != null ) {
				List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
				ICFBamClearSubDep1Obj cur = null;
				Iterator<ICFBamClearSubDep1Obj> iter = mapContClearTopIdx.values().iterator();
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

			indexByContClearTopIdx.remove( key );
		}
	}

	public void forgetClearSubDep1ByUNameIdx( long TenantId,
		long ContClearTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamClearSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamClearSubDep1Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamClearSubDep1Obj createClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamClearSubDep1Buff buff = obj.getClearSubDep1Buff();
		schema.getBackingStore().getTableClearSubDep1().createClearSubDep1(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR1" ) ) {
			obj = (ICFBamClearSubDep1Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey ) {
		return( readClearSubDep1( pkey, false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep1Buff readBuff = schema.getBackingStore().getTableClearSubDep1().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep1Obj lockClearSubDep1( CFBamScopePKey pkey ) {
		ICFBamClearSubDep1Obj locked = null;
		CFBamClearSubDep1Buff lockBuff = schema.getBackingStore().getTableClearSubDep1().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep1Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockClearSubDep1", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep1Obj> readAllClearSubDep1() {
		return( readAllClearSubDep1( false ) );
	}

	public List<ICFBamClearSubDep1Obj> readAllClearSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep1";
		if( ( allClearSubDep1 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep1Obj>();
			allClearSubDep1 = map;
			CFBamClearSubDep1Buff[] buffList = schema.getBackingStore().getTableClearSubDep1().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep1Buff buff;
			ICFBamClearSubDep1Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realized = (ICFBamClearSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		int len = allClearSubDep1.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = allClearSubDep1.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep1ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep1Obj obj = readClearSubDep1( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId )
	{
		return( readClearSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realized = (ICFBamClearSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTableIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep1ByTableIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByTableIdx";
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realized = (ICFBamClearSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByContClearTopIdx( long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		return( readClearSubDep1ByContClearTopIdx( ContClearTopDepTenantId,
			ContClearTopDepId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByContClearTopIdx( long ContClearTopDepTenantId,
		long ContClearTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByContClearTopIdx";
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( ContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByContClearTopIdx == null ) {
			indexByContClearTopIdx = new HashMap< CFBamClearSubDep1ByContClearTopIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByContClearTopIdx.containsKey( key ) ) {
			dict = indexByContClearTopIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContClearTopIdx.put( key, dict );
			ICFBamClearSubDep1Obj obj;
			CFBamClearSubDep1Buff[] buffList = schema.getBackingStore().getTableClearSubDep1().readDerivedByContClearTopIdx( schema.getAuthorization(),
				ContClearTopDepTenantId,
				ContClearTopDepId );
			CFBamClearSubDep1Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realized = (ICFBamClearSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx( long TenantId,
		long ContClearTopDepId,
		String Name )
	{
		return( readClearSubDep1ByUNameIdx( TenantId,
			ContClearTopDepId,
			Name,
			false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx( long TenantId,
		long ContClearTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep1ByUNameIdxKey,
				ICFBamClearSubDep1Obj >();
		}
		CFBamClearSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		key.setRequiredName( Name );
		ICFBamClearSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep1Buff buff = schema.getBackingStore().getTableClearSubDep1().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearTopDepId,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep1Obj updateClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep1().updateClearSubDep1( schema.getAuthorization(),
			Obj.getClearSubDep1Buff() );
		if( Obj.getClassCode().equals( "CLR1" ) ) {
			obj = (ICFBamClearSubDep1Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1( schema.getAuthorization(),
			obj.getClearSubDep1Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readClearSubDep1( pkey );
		if( obj != null ) {
			ICFBamClearSubDep1EditObj editObj = (ICFBamClearSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep1EditObj)obj.beginEdit();
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

	public void deleteClearSubDep1ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
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
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep1ByTableIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
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
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep1ByContClearTopIdx( long ContClearTopDepTenantId,
		long ContClearTopDepId )
	{
		CFBamClearSubDep1ByContClearTopIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newContClearTopIdxKey();
		key.setRequiredContClearTopDepTenantId( ContClearTopDepTenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		if( indexByContClearTopIdx == null ) {
			indexByContClearTopIdx = new HashMap< CFBamClearSubDep1ByContClearTopIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByContClearTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByContClearTopIdx.get( key );
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByContClearTopIdx( schema.getAuthorization(),
				ContClearTopDepTenantId,
				ContClearTopDepId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContClearTopIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByContClearTopIdx( schema.getAuthorization(),
				ContClearTopDepTenantId,
				ContClearTopDepId );
		}
	}

	public void deleteClearSubDep1ByUNameIdx( long TenantId,
		long ContClearTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep1ByUNameIdxKey,
				ICFBamClearSubDep1Obj >();
		}
		CFBamClearSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearTopDepId( ContClearTopDepId );
		key.setRequiredName( Name );
		ICFBamClearSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearTopDepId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableClearSubDep1().deleteClearSubDep1ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearTopDepId,
				Name );
		}
	}
}
