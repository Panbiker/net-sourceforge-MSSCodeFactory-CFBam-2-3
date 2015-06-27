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

public class CFBamClearSubDep3TableObj
	implements ICFBamClearSubDep3TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep3Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep3Obj> allClearSubDep3;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByTableIdx;
	private Map< CFBamClearSubDep3ByContClearDep2IdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByContClearDep2Idx;
	private Map< CFBamClearSubDep3ByUNameIdxKey,
		ICFBamClearSubDep3Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep3";
	public static String TABLE_DBNAME = "clrsubdep3";

	public CFBamClearSubDep3TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep2Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep3TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep2Idx = null;
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
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep2Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep3Obj.
	 */
	public ICFBamClearSubDep3Obj newInstance() {
		ICFBamClearSubDep3Obj inst = new CFBamClearSubDep3Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep3Obj.
	 */
	public ICFBamClearSubDep3EditObj newEditInstance( ICFBamClearSubDep3Obj orig ) {
		ICFBamClearSubDep3EditObj edit = new CFBamClearSubDep3EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep3Obj realizeClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep3Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep3Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearDep2Idx != null ) {
				CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx =
					schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
				keyContClearDep2Idx.setRequiredContClearDep2TenantId( keepObj.getRequiredContClearDep2TenantId() );
				keyContClearDep2Idx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapContClearDep2Idx = indexByContClearDep2Idx.get( keyContClearDep2Idx );
				if( mapContClearDep2Idx != null ) {
					mapContClearDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep3Obj)schema.getClearDepTableObj().realizeClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearDep2Idx != null ) {
				CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx =
					schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
				keyContClearDep2Idx.setRequiredContClearDep2TenantId( keepObj.getRequiredContClearDep2TenantId() );
				keyContClearDep2Idx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapContClearDep2Idx = indexByContClearDep2Idx.get( keyContClearDep2Idx );
				if( mapContClearDep2Idx != null ) {
					mapContClearDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allClearSubDep3 != null ) {
				allClearSubDep3.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep3Obj)schema.getClearDepTableObj().realizeClearDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep3 != null ) {
				allClearSubDep3.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearDep2Idx != null ) {
				CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx =
					schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
				keyContClearDep2Idx.setRequiredContClearDep2TenantId( keepObj.getRequiredContClearDep2TenantId() );
				keyContClearDep2Idx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapContClearDep2Idx = indexByContClearDep2Idx.get( keyContClearDep2Idx );
				if( mapContClearDep2Idx != null ) {
					mapContClearDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		forgetClearSubDep3( Obj, false );
	}

	public void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep3Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearDep2Idx != null ) {
				CFBamClearSubDep3ByContClearDep2IdxKey keyContClearDep2Idx =
					schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
				keyContClearDep2Idx.setRequiredContClearDep2TenantId( keepObj.getRequiredContClearDep2TenantId() );
				keyContClearDep2Idx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapContClearDep2Idx = indexByContClearDep2Idx.get( keyContClearDep2Idx );
				if( mapContClearDep2Idx != null ) {
					mapContClearDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep2Id( keepObj.getRequiredContClearDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep3 != null ) {
				allClearSubDep3.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep3Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep3ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
				ICFBamClearSubDep3Obj cur = null;
				Iterator<ICFBamClearSubDep3Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetClearSubDep3ByTableIdx( long TenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
				ICFBamClearSubDep3Obj cur = null;
				Iterator<ICFBamClearSubDep3Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		if( indexByContClearDep2Idx == null ) {
			return;
		}
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( ContClearDep2TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		if( indexByContClearDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapContClearDep2Idx = indexByContClearDep2Idx.get( key );
			if( mapContClearDep2Idx != null ) {
				List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
				ICFBamClearSubDep3Obj cur = null;
				Iterator<ICFBamClearSubDep3Obj> iter = mapContClearDep2Idx.values().iterator();
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

			indexByContClearDep2Idx.remove( key );
		}
	}

	public void forgetClearSubDep3ByUNameIdx( long TenantId,
		long ContClearDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamClearSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamClearSubDep3Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamClearSubDep3Obj createClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamClearSubDep3Buff buff = obj.getClearSubDep3Buff();
		schema.getBackingStore().getTableClearSubDep3().createClearSubDep3(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR3" ) ) {
			obj = (ICFBamClearSubDep3Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey ) {
		return( readClearSubDep3( pkey, false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep3Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep3Buff readBuff = schema.getBackingStore().getTableClearSubDep3().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep3Obj lockClearSubDep3( CFBamScopePKey pkey ) {
		ICFBamClearSubDep3Obj locked = null;
		CFBamClearSubDep3Buff lockBuff = schema.getBackingStore().getTableClearSubDep3().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep3Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockClearSubDep3", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep3Obj> readAllClearSubDep3() {
		return( readAllClearSubDep3( false ) );
	}

	public List<ICFBamClearSubDep3Obj> readAllClearSubDep3( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep3";
		if( ( allClearSubDep3 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep3Obj>();
			allClearSubDep3 = map;
			CFBamClearSubDep3Buff[] buffList = schema.getBackingStore().getTableClearSubDep3().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep3Buff buff;
			ICFBamClearSubDep3Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realized = (ICFBamClearSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		int len = allClearSubDep3.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = allClearSubDep3.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep3ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep3Obj obj = readClearSubDep3( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId )
	{
		return( readClearSubDep3ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realized = (ICFBamClearSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTableIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep3ByTableIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByTableIdx";
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realized = (ICFBamClearSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		return( readClearSubDep3ByContClearDep2Idx( ContClearDep2TenantId,
			ContClearDep2Id,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByContClearDep2Idx";
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( ContClearDep2TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByContClearDep2Idx == null ) {
			indexByContClearDep2Idx = new HashMap< CFBamClearSubDep3ByContClearDep2IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByContClearDep2Idx.containsKey( key ) ) {
			dict = indexByContClearDep2Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContClearDep2Idx.put( key, dict );
			ICFBamClearSubDep3Obj obj;
			CFBamClearSubDep3Buff[] buffList = schema.getBackingStore().getTableClearSubDep3().readDerivedByContClearDep2Idx( schema.getAuthorization(),
				ContClearDep2TenantId,
				ContClearDep2Id );
			CFBamClearSubDep3Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realized = (ICFBamClearSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx( long TenantId,
		long ContClearDep2Id,
		String Name )
	{
		return( readClearSubDep3ByUNameIdx( TenantId,
			ContClearDep2Id,
			Name,
			false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx( long TenantId,
		long ContClearDep2Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep3ByUNameIdxKey,
				ICFBamClearSubDep3Obj >();
		}
		CFBamClearSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep3Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep3Buff buff = schema.getBackingStore().getTableClearSubDep3().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep2Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep3Obj updateClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep3().updateClearSubDep3( schema.getAuthorization(),
			Obj.getClearSubDep3Buff() );
		if( Obj.getClassCode().equals( "CLR3" ) ) {
			obj = (ICFBamClearSubDep3Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3( schema.getAuthorization(),
			obj.getClearSubDep3Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readClearSubDep3( pkey );
		if( obj != null ) {
			ICFBamClearSubDep3EditObj editObj = (ICFBamClearSubDep3EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep3EditObj)obj.beginEdit();
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

	public void deleteClearSubDep3ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
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
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep3ByTableIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
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
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id )
	{
		CFBamClearSubDep3ByContClearDep2IdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newContClearDep2IdxKey();
		key.setRequiredContClearDep2TenantId( ContClearDep2TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		if( indexByContClearDep2Idx == null ) {
			indexByContClearDep2Idx = new HashMap< CFBamClearSubDep3ByContClearDep2IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByContClearDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByContClearDep2Idx.get( key );
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByContClearDep2Idx( schema.getAuthorization(),
				ContClearDep2TenantId,
				ContClearDep2Id );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContClearDep2Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByContClearDep2Idx( schema.getAuthorization(),
				ContClearDep2TenantId,
				ContClearDep2Id );
		}
	}

	public void deleteClearSubDep3ByUNameIdx( long TenantId,
		long ContClearDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep3ByUNameIdxKey,
				ICFBamClearSubDep3Obj >();
		}
		CFBamClearSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep2Id( ContClearDep2Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep3Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep2Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableClearSubDep3().deleteClearSubDep3ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep2Id,
				Name );
		}
	}
}
