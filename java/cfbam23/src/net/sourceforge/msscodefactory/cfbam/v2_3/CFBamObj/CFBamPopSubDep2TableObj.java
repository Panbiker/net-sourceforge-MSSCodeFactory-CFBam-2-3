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

public class CFBamPopSubDep2TableObj
	implements ICFBamPopSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamPopSubDep2Obj> allPopSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByDefSchemaIdx;
	private Map< CFBamPopSubDep2ByContPopDep1IdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByContPopDep1Idx;
	private Map< CFBamPopSubDep2ByUNameIdxKey,
		ICFBamPopSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep2";
	public static String TABLE_DBNAME = "popsubdep2";

	public CFBamPopSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep1Idx = null;
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
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep2Obj.
	 */
	public ICFBamPopSubDep2Obj newInstance() {
		ICFBamPopSubDep2Obj inst = new CFBamPopSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep2Obj.
	 */
	public ICFBamPopSubDep2EditObj newEditInstance( ICFBamPopSubDep2Obj orig ) {
		ICFBamPopSubDep2EditObj edit = new CFBamPopSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamPopSubDep2Obj realizePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopDep1Idx != null ) {
				CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx =
					schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
				keyContPopDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep1Idx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapContPopDep1Idx = indexByContPopDep1Idx.get( keyContPopDep1Idx );
				if( mapContPopDep1Idx != null ) {
					mapContPopDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopSubDep2Obj)schema.getPopDepTableObj().realizePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopDep1Idx != null ) {
				CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx =
					schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
				keyContPopDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep1Idx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapContPopDep1Idx = indexByContPopDep1Idx.get( keyContPopDep1Idx );
				if( mapContPopDep1Idx != null ) {
					mapContPopDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopSubDep2Obj)schema.getPopDepTableObj().realizePopDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopDep1Idx != null ) {
				CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx =
					schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
				keyContPopDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep1Idx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapContPopDep1Idx = indexByContPopDep1Idx.get( keyContPopDep1Idx );
				if( mapContPopDep1Idx != null ) {
					mapContPopDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		forgetPopSubDep2( Obj, false );
	}

	public void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopDep1Idx != null ) {
				CFBamPopSubDep2ByContPopDep1IdxKey keyContPopDep1Idx =
					schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
				keyContPopDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep1Idx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapContPopDep1Idx = indexByContPopDep1Idx.get( keyContPopDep1Idx );
				if( mapContPopDep1Idx != null ) {
					mapContPopDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep1Id( keepObj.getRequiredContPopDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopSubDep2 != null ) {
				allPopSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getPopSubDep3TableObj().forgetPopSubDep3ByContPopDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
				ICFBamPopSubDep2Obj cur = null;
				Iterator<ICFBamPopSubDep2Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
				ICFBamPopSubDep2Obj cur = null;
				Iterator<ICFBamPopSubDep2Obj> iter = mapRelationIdx.values().iterator();
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

			indexByRelationIdx.remove( key );
		}
	}

	public void forgetPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
				ICFBamPopSubDep2Obj cur = null;
				Iterator<ICFBamPopSubDep2Obj> iter = mapDefSchemaIdx.values().iterator();
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

			indexByDefSchemaIdx.remove( key );
		}
	}

	public void forgetPopSubDep2ByContPopDep1Idx( long ContTenantId,
		long ContPopDep1Id )
	{
		if( indexByContPopDep1Idx == null ) {
			return;
		}
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		if( indexByContPopDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapContPopDep1Idx = indexByContPopDep1Idx.get( key );
			if( mapContPopDep1Idx != null ) {
				List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
				ICFBamPopSubDep2Obj cur = null;
				Iterator<ICFBamPopSubDep2Obj> iter = mapContPopDep1Idx.values().iterator();
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

			indexByContPopDep1Idx.remove( key );
		}
	}

	public void forgetPopSubDep2ByUNameIdx( long ContTenantId,
		long ContPopDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamPopSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamPopSubDep2Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamPopSubDep2Obj createPopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamPopSubDep2Buff buff = obj.getPopSubDep2Buff();
		schema.getBackingStore().getTablePopSubDep2().createPopSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POP2" ) ) {
			obj = (ICFBamPopSubDep2Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey ) {
		return( readPopSubDep2( pkey, false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopSubDep2Buff readBuff = schema.getBackingStore().getTablePopSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep2Obj lockPopSubDep2( CFBamScopePKey pkey ) {
		ICFBamPopSubDep2Obj locked = null;
		CFBamPopSubDep2Buff lockBuff = schema.getBackingStore().getTablePopSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopSubDep2Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockPopSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopSubDep2Obj> readAllPopSubDep2() {
		return( readAllPopSubDep2( false ) );
	}

	public List<ICFBamPopSubDep2Obj> readAllPopSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep2";
		if( ( allPopSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamPopSubDep2Obj>();
			allPopSubDep2 = map;
			CFBamPopSubDep2Buff[] buffList = schema.getBackingStore().getTablePopSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamPopSubDep2Buff buff;
			ICFBamPopSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realized = (ICFBamPopSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		int len = allPopSubDep2.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = allPopSubDep2.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readPopSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep2Obj obj = readPopSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId )
	{
		return( readPopSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realized = (ICFBamPopSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopSubDep2ByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByRelationIdx";
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByRelationIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realized = (ICFBamPopSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopSubDep2ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realized = (ICFBamPopSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByContPopDep1Idx( long ContTenantId,
		long ContPopDep1Id )
	{
		return( readPopSubDep2ByContPopDep1Idx( ContTenantId,
			ContPopDep1Id,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByContPopDep1Idx( long ContTenantId,
		long ContPopDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByContPopDep1Idx";
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByContPopDep1Idx == null ) {
			indexByContPopDep1Idx = new HashMap< CFBamPopSubDep2ByContPopDep1IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByContPopDep1Idx.containsKey( key ) ) {
			dict = indexByContPopDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContPopDep1Idx.put( key, dict );
			ICFBamPopSubDep2Obj obj;
			CFBamPopSubDep2Buff[] buffList = schema.getBackingStore().getTablePopSubDep2().readDerivedByContPopDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id );
			CFBamPopSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realized = (ICFBamPopSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx( long ContTenantId,
		long ContPopDep1Id,
		String Name )
	{
		return( readPopSubDep2ByUNameIdx( ContTenantId,
			ContPopDep1Id,
			Name,
			false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx( long ContTenantId,
		long ContPopDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep2ByUNameIdxKey,
				ICFBamPopSubDep2Obj >();
		}
		CFBamPopSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopSubDep2Buff buff = schema.getBackingStore().getTablePopSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep2Obj updatePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep2().updatePopSubDep2( schema.getAuthorization(),
			Obj.getPopSubDep2Buff() );
		if( Obj.getClassCode().equals( "POP2" ) ) {
			obj = (ICFBamPopSubDep2Obj)Obj.realize();
		}
		return( obj );
	}

	public void deletePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2( schema.getAuthorization(),
			obj.getPopSubDep2Buff() );
		obj.forget( true );
	}

	public void deletePopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readPopSubDep2( pkey );
		if( obj != null ) {
			ICFBamPopSubDep2EditObj editObj = (ICFBamPopSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopSubDep2EditObj)obj.beginEdit();
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

	public void deletePopSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
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
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByRelationIdx.get( key );
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelationIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopSubDep2ByContPopDep1Idx( long ContTenantId,
		long ContPopDep1Id )
	{
		CFBamPopSubDep2ByContPopDep1IdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newContPopDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		if( indexByContPopDep1Idx == null ) {
			indexByContPopDep1Idx = new HashMap< CFBamPopSubDep2ByContPopDep1IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByContPopDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByContPopDep1Idx.get( key );
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByContPopDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContPopDep1Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByContPopDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id );
		}
	}

	public void deletePopSubDep2ByUNameIdx( long ContTenantId,
		long ContPopDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep2ByUNameIdxKey,
				ICFBamPopSubDep2Obj >();
		}
		CFBamPopSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep1Id( ContPopDep1Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTablePopSubDep2().deletePopSubDep2ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep1Id,
				Name );
		}
	}
}
