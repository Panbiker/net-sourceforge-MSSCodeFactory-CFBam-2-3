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

public class CFBamClearSubDep2TableObj
	implements ICFBamClearSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep2Obj> allClearSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByTableIdx;
	private Map< CFBamClearSubDep2ByContClearDep1IdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByContClearDep1Idx;
	private Map< CFBamClearSubDep2ByUNameIdxKey,
		ICFBamClearSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep2";
	public static String TABLE_DBNAME = "clrsubdep2";

	public CFBamClearSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep1Idx = null;
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
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByContClearDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep2Obj.
	 */
	public ICFBamClearSubDep2Obj newInstance() {
		ICFBamClearSubDep2Obj inst = new CFBamClearSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep2Obj.
	 */
	public ICFBamClearSubDep2EditObj newEditInstance( ICFBamClearSubDep2Obj orig ) {
		ICFBamClearSubDep2EditObj edit = new CFBamClearSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep2Obj realizeClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearDep1Idx != null ) {
				CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx =
					schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
				keyContClearDep1Idx.setRequiredContClearDep1TenantId( keepObj.getRequiredContClearDep1TenantId() );
				keyContClearDep1Idx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapContClearDep1Idx = indexByContClearDep1Idx.get( keyContClearDep1Idx );
				if( mapContClearDep1Idx != null ) {
					mapContClearDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep2Obj)schema.getClearDepTableObj().realizeClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearDep1Idx != null ) {
				CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx =
					schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
				keyContClearDep1Idx.setRequiredContClearDep1TenantId( keepObj.getRequiredContClearDep1TenantId() );
				keyContClearDep1Idx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapContClearDep1Idx = indexByContClearDep1Idx.get( keyContClearDep1Idx );
				if( mapContClearDep1Idx != null ) {
					mapContClearDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep2Obj)schema.getClearDepTableObj().realizeClearDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContClearDep1Idx != null ) {
				CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx =
					schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
				keyContClearDep1Idx.setRequiredContClearDep1TenantId( keepObj.getRequiredContClearDep1TenantId() );
				keyContClearDep1Idx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapContClearDep1Idx = indexByContClearDep1Idx.get( keyContClearDep1Idx );
				if( mapContClearDep1Idx != null ) {
					mapContClearDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		forgetClearSubDep2( Obj, false );
	}

	public void forgetClearSubDep2( ICFBamClearSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamClearDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContClearDep1Idx != null ) {
				CFBamClearSubDep2ByContClearDep1IdxKey keyContClearDep1Idx =
					schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
				keyContClearDep1Idx.setRequiredContClearDep1TenantId( keepObj.getRequiredContClearDep1TenantId() );
				keyContClearDep1Idx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapContClearDep1Idx = indexByContClearDep1Idx.get( keyContClearDep1Idx );
				if( mapContClearDep1Idx != null ) {
					mapContClearDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredContClearDep1Id( keepObj.getRequiredContClearDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep2 != null ) {
				allClearSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getClearSubDep3TableObj().forgetClearSubDep3ByContClearDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
				ICFBamClearSubDep2Obj cur = null;
				Iterator<ICFBamClearSubDep2Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetClearSubDep2ByTableIdx( long TenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
				ICFBamClearSubDep2Obj cur = null;
				Iterator<ICFBamClearSubDep2Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetClearSubDep2ByContClearDep1Idx( long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		if( indexByContClearDep1Idx == null ) {
			return;
		}
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( ContClearDep1TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		if( indexByContClearDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapContClearDep1Idx = indexByContClearDep1Idx.get( key );
			if( mapContClearDep1Idx != null ) {
				List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
				ICFBamClearSubDep2Obj cur = null;
				Iterator<ICFBamClearSubDep2Obj> iter = mapContClearDep1Idx.values().iterator();
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

			indexByContClearDep1Idx.remove( key );
		}
	}

	public void forgetClearSubDep2ByUNameIdx( long TenantId,
		long ContClearDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamClearSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamClearSubDep2Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamClearSubDep2Obj createClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamClearSubDep2Buff buff = obj.getClearSubDep2Buff();
		schema.getBackingStore().getTableClearSubDep2().createClearSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR2" ) ) {
			obj = (ICFBamClearSubDep2Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2( CFBamScopePKey pkey ) {
		return( readClearSubDep2( pkey, false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep2Buff readBuff = schema.getBackingStore().getTableClearSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep2Obj lockClearSubDep2( CFBamScopePKey pkey ) {
		ICFBamClearSubDep2Obj locked = null;
		CFBamClearSubDep2Buff lockBuff = schema.getBackingStore().getTableClearSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep2Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockClearSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep2Obj> readAllClearSubDep2() {
		return( readAllClearSubDep2( false ) );
	}

	public List<ICFBamClearSubDep2Obj> readAllClearSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep2";
		if( ( allClearSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep2Obj>();
			allClearSubDep2 = map;
			CFBamClearSubDep2Buff[] buffList = schema.getBackingStore().getTableClearSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep2Buff buff;
			ICFBamClearSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realized = (ICFBamClearSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		int len = allClearSubDep2.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = allClearSubDep2.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep2Obj obj = readClearSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTenantIdx( long TenantId )
	{
		return( readClearSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realized = (ICFBamClearSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTableIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep2ByTableIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByTableIdx";
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = schema.getBackingStore().getTableClearDep().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realized = (ICFBamClearSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByContClearDep1Idx( long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		return( readClearSubDep2ByContClearDep1Idx( ContClearDep1TenantId,
			ContClearDep1Id,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByContClearDep1Idx( long ContClearDep1TenantId,
		long ContClearDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByContClearDep1Idx";
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( ContClearDep1TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByContClearDep1Idx == null ) {
			indexByContClearDep1Idx = new HashMap< CFBamClearSubDep2ByContClearDep1IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByContClearDep1Idx.containsKey( key ) ) {
			dict = indexByContClearDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContClearDep1Idx.put( key, dict );
			ICFBamClearSubDep2Obj obj;
			CFBamClearSubDep2Buff[] buffList = schema.getBackingStore().getTableClearSubDep2().readDerivedByContClearDep1Idx( schema.getAuthorization(),
				ContClearDep1TenantId,
				ContClearDep1Id );
			CFBamClearSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realized = (ICFBamClearSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByUNameIdx( long TenantId,
		long ContClearDep1Id,
		String Name )
	{
		return( readClearSubDep2ByUNameIdx( TenantId,
			ContClearDep1Id,
			Name,
			false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByUNameIdx( long TenantId,
		long ContClearDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep2ByUNameIdxKey,
				ICFBamClearSubDep2Obj >();
		}
		CFBamClearSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep2Buff buff = schema.getBackingStore().getTableClearSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep2Obj updateClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep2().updateClearSubDep2( schema.getAuthorization(),
			Obj.getClearSubDep2Buff() );
		if( Obj.getClassCode().equals( "CLR2" ) ) {
			obj = (ICFBamClearSubDep2Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2( schema.getAuthorization(),
			obj.getClearSubDep2Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readClearSubDep2( pkey );
		if( obj != null ) {
			ICFBamClearSubDep2EditObj editObj = (ICFBamClearSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep2EditObj)obj.beginEdit();
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

	public void deleteClearSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
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
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep2ByTableIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByTableIdxKey key = schema.getBackingStore().getFactoryClearDep().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamClearDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
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
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTableIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep2ByContClearDep1Idx( long ContClearDep1TenantId,
		long ContClearDep1Id )
	{
		CFBamClearSubDep2ByContClearDep1IdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newContClearDep1IdxKey();
		key.setRequiredContClearDep1TenantId( ContClearDep1TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		if( indexByContClearDep1Idx == null ) {
			indexByContClearDep1Idx = new HashMap< CFBamClearSubDep2ByContClearDep1IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByContClearDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByContClearDep1Idx.get( key );
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByContClearDep1Idx( schema.getAuthorization(),
				ContClearDep1TenantId,
				ContClearDep1Id );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContClearDep1Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByContClearDep1Idx( schema.getAuthorization(),
				ContClearDep1TenantId,
				ContClearDep1Id );
		}
	}

	public void deleteClearSubDep2ByUNameIdx( long TenantId,
		long ContClearDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep2ByUNameIdxKey,
				ICFBamClearSubDep2Obj >();
		}
		CFBamClearSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredContClearDep1Id( ContClearDep1Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( schema.getAuthorization(),
				TenantId,
				ContClearDep1Id,
				Name );
		}
	}
}
