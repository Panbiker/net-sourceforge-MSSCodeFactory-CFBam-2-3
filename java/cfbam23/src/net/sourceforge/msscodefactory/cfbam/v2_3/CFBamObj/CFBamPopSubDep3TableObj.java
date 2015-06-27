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

public class CFBamPopSubDep3TableObj
	implements ICFBamPopSubDep3TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopSubDep3Obj> members;
	private Map<CFBamScopePKey, ICFBamPopSubDep3Obj> allPopSubDep3;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj > > indexByDefSchemaIdx;
	private Map< CFBamPopSubDep3ByContPopDep2IdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj > > indexByContPopDep2Idx;
	private Map< CFBamPopSubDep3ByUNameIdxKey,
		ICFBamPopSubDep3Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep3";
	public static String TABLE_DBNAME = "popsubdep3";

	public CFBamPopSubDep3TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep2Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopSubDep3TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep2Idx = null;
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
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopDep2Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep3Obj.
	 */
	public ICFBamPopSubDep3Obj newInstance() {
		ICFBamPopSubDep3Obj inst = new CFBamPopSubDep3Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep3Obj.
	 */
	public ICFBamPopSubDep3EditObj newEditInstance( ICFBamPopSubDep3Obj orig ) {
		ICFBamPopSubDep3EditObj edit = new CFBamPopSubDep3EditObj( orig );
		return( edit );
	}

	public ICFBamPopSubDep3Obj realizePopSubDep3( ICFBamPopSubDep3Obj Obj ) {
		ICFBamPopSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopSubDep3Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopSubDep3Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopDep2Idx != null ) {
				CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx =
					schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
				keyContPopDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep2Idx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapContPopDep2Idx = indexByContPopDep2Idx.get( keyContPopDep2Idx );
				if( mapContPopDep2Idx != null ) {
					mapContPopDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopSubDep3Obj)schema.getPopDepTableObj().realizePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopDep2Idx != null ) {
				CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx =
					schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
				keyContPopDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep2Idx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapContPopDep2Idx = indexByContPopDep2Idx.get( keyContPopDep2Idx );
				if( mapContPopDep2Idx != null ) {
					mapContPopDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allPopSubDep3 != null ) {
				allPopSubDep3.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopSubDep3Obj)schema.getPopDepTableObj().realizePopDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep3 != null ) {
				allPopSubDep3.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopDep2Idx != null ) {
				CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx =
					schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
				keyContPopDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep2Idx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapContPopDep2Idx = indexByContPopDep2Idx.get( keyContPopDep2Idx );
				if( mapContPopDep2Idx != null ) {
					mapContPopDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetPopSubDep3( ICFBamPopSubDep3Obj Obj ) {
		forgetPopSubDep3( Obj, false );
	}

	public void forgetPopSubDep3( ICFBamPopSubDep3Obj Obj, boolean forgetSubObjects ) {
		ICFBamPopSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopSubDep3Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopDep2Idx != null ) {
				CFBamPopSubDep3ByContPopDep2IdxKey keyContPopDep2Idx =
					schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
				keyContPopDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopDep2Idx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapContPopDep2Idx = indexByContPopDep2Idx.get( keyContPopDep2Idx );
				if( mapContPopDep2Idx != null ) {
					mapContPopDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopDep2Id( keepObj.getRequiredContPopDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopSubDep3 != null ) {
				allPopSubDep3.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopSubDep3Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopSubDep3ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
				ICFBamPopSubDep3Obj cur = null;
				Iterator<ICFBamPopSubDep3Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetPopSubDep3ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
				ICFBamPopSubDep3Obj cur = null;
				Iterator<ICFBamPopSubDep3Obj> iter = mapRelationIdx.values().iterator();
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

	public void forgetPopSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
				ICFBamPopSubDep3Obj cur = null;
				Iterator<ICFBamPopSubDep3Obj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetPopSubDep3ByContPopDep2Idx( long ContTenantId,
		long ContPopDep2Id )
	{
		if( indexByContPopDep2Idx == null ) {
			return;
		}
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		if( indexByContPopDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj > mapContPopDep2Idx = indexByContPopDep2Idx.get( key );
			if( mapContPopDep2Idx != null ) {
				List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
				ICFBamPopSubDep3Obj cur = null;
				Iterator<ICFBamPopSubDep3Obj> iter = mapContPopDep2Idx.values().iterator();
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

			indexByContPopDep2Idx.remove( key );
		}
	}

	public void forgetPopSubDep3ByUNameIdx( long ContTenantId,
		long ContPopDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamPopSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamPopSubDep3Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamPopSubDep3Obj createPopSubDep3( ICFBamPopSubDep3Obj Obj ) {
		ICFBamPopSubDep3Obj obj = Obj;
		CFBamPopSubDep3Buff buff = obj.getPopSubDep3Buff();
		schema.getBackingStore().getTablePopSubDep3().createPopSubDep3(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POP3" ) ) {
			obj = (ICFBamPopSubDep3Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3( CFBamScopePKey pkey ) {
		return( readPopSubDep3( pkey, false ) );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopSubDep3Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopSubDep3Buff readBuff = schema.getBackingStore().getTablePopSubDep3().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep3Obj lockPopSubDep3( CFBamScopePKey pkey ) {
		ICFBamPopSubDep3Obj locked = null;
		CFBamPopSubDep3Buff lockBuff = schema.getBackingStore().getTablePopSubDep3().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopSubDep3Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockPopSubDep3", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopSubDep3Obj> readAllPopSubDep3() {
		return( readAllPopSubDep3( false ) );
	}

	public List<ICFBamPopSubDep3Obj> readAllPopSubDep3( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep3";
		if( ( allPopSubDep3 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj> map = new HashMap<CFBamScopePKey,ICFBamPopSubDep3Obj>();
			allPopSubDep3 = map;
			CFBamPopSubDep3Buff[] buffList = schema.getBackingStore().getTablePopSubDep3().readAllDerived( schema.getAuthorization() );
			CFBamPopSubDep3Buff buff;
			ICFBamPopSubDep3Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep3Obj realized = (ICFBamPopSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep3Obj> cmp = new Comparator<ICFBamPopSubDep3Obj>() {
			public int compare( ICFBamPopSubDep3Obj lhs, ICFBamPopSubDep3Obj rhs ) {
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
		int len = allPopSubDep3.size();
		ICFBamPopSubDep3Obj arr[] = new ICFBamPopSubDep3Obj[len];
		Iterator<ICFBamPopSubDep3Obj> valIter = allPopSubDep3.values().iterator();
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
		ArrayList<ICFBamPopSubDep3Obj> arrayList = new ArrayList<ICFBamPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		return( readPopSubDep3ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep3Obj obj = readPopSubDep3( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByTenantIdx( long TenantId )
	{
		return( readPopSubDep3ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep3Obj realized = (ICFBamPopSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep3Obj> cmp = new Comparator<ICFBamPopSubDep3Obj>() {
			public int compare( ICFBamPopSubDep3Obj lhs, ICFBamPopSubDep3Obj rhs ) {
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
		ICFBamPopSubDep3Obj arr[] = new ICFBamPopSubDep3Obj[len];
		Iterator<ICFBamPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep3Obj> arrayList = new ArrayList<ICFBamPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopSubDep3ByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByRelationIdx";
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByRelationIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep3Obj realized = (ICFBamPopSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep3Obj> cmp = new Comparator<ICFBamPopSubDep3Obj>() {
			public int compare( ICFBamPopSubDep3Obj lhs, ICFBamPopSubDep3Obj rhs ) {
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
		ICFBamPopSubDep3Obj arr[] = new ICFBamPopSubDep3Obj[len];
		Iterator<ICFBamPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep3Obj> arrayList = new ArrayList<ICFBamPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopSubDep3ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep3Obj realized = (ICFBamPopSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep3Obj> cmp = new Comparator<ICFBamPopSubDep3Obj>() {
			public int compare( ICFBamPopSubDep3Obj lhs, ICFBamPopSubDep3Obj rhs ) {
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
		ICFBamPopSubDep3Obj arr[] = new ICFBamPopSubDep3Obj[len];
		Iterator<ICFBamPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep3Obj> arrayList = new ArrayList<ICFBamPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByContPopDep2Idx( long ContTenantId,
		long ContPopDep2Id )
	{
		return( readPopSubDep3ByContPopDep2Idx( ContTenantId,
			ContPopDep2Id,
			false ) );
	}

	public List<ICFBamPopSubDep3Obj> readPopSubDep3ByContPopDep2Idx( long ContTenantId,
		long ContPopDep2Id,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByContPopDep2Idx";
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict;
		if( indexByContPopDep2Idx == null ) {
			indexByContPopDep2Idx = new HashMap< CFBamPopSubDep3ByContPopDep2IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByContPopDep2Idx.containsKey( key ) ) {
			dict = indexByContPopDep2Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContPopDep2Idx.put( key, dict );
			ICFBamPopSubDep3Obj obj;
			CFBamPopSubDep3Buff[] buffList = schema.getBackingStore().getTablePopSubDep3().readDerivedByContPopDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id );
			CFBamPopSubDep3Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep3Obj realized = (ICFBamPopSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep3Obj> cmp = new Comparator<ICFBamPopSubDep3Obj>() {
			public int compare( ICFBamPopSubDep3Obj lhs, ICFBamPopSubDep3Obj rhs ) {
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
		ICFBamPopSubDep3Obj arr[] = new ICFBamPopSubDep3Obj[len];
		Iterator<ICFBamPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep3Obj> arrayList = new ArrayList<ICFBamPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3ByUNameIdx( long ContTenantId,
		long ContPopDep2Id,
		String Name )
	{
		return( readPopSubDep3ByUNameIdx( ContTenantId,
			ContPopDep2Id,
			Name,
			false ) );
	}

	public ICFBamPopSubDep3Obj readPopSubDep3ByUNameIdx( long ContTenantId,
		long ContPopDep2Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep3ByUNameIdxKey,
				ICFBamPopSubDep3Obj >();
		}
		CFBamPopSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep3Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopSubDep3Buff buff = schema.getBackingStore().getTablePopSubDep3().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep3Obj updatePopSubDep3( ICFBamPopSubDep3Obj Obj ) {
		ICFBamPopSubDep3Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep3().updatePopSubDep3( schema.getAuthorization(),
			Obj.getPopSubDep3Buff() );
		if( Obj.getClassCode().equals( "POP3" ) ) {
			obj = (ICFBamPopSubDep3Obj)Obj.realize();
		}
		return( obj );
	}

	public void deletePopSubDep3( ICFBamPopSubDep3Obj Obj ) {
		ICFBamPopSubDep3Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3( schema.getAuthorization(),
			obj.getPopSubDep3Buff() );
		obj.forget( true );
	}

	public void deletePopSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readPopSubDep3( pkey );
		if( obj != null ) {
			ICFBamPopSubDep3EditObj editObj = (ICFBamPopSubDep3EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopSubDep3EditObj)obj.beginEdit();
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

	public void deletePopSubDep3ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopSubDep3Obj> iter = dict.values().iterator();
			ICFBamPopSubDep3Obj obj;
			List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
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
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopSubDep3ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict = indexByRelationIdx.get( key );
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopSubDep3Obj> iter = dict.values().iterator();
			ICFBamPopSubDep3Obj obj;
			List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
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
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopSubDep3Obj> iter = dict.values().iterator();
			ICFBamPopSubDep3Obj obj;
			List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
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
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopSubDep3ByContPopDep2Idx( long ContTenantId,
		long ContPopDep2Id )
	{
		CFBamPopSubDep3ByContPopDep2IdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newContPopDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		if( indexByContPopDep2Idx == null ) {
			indexByContPopDep2Idx = new HashMap< CFBamPopSubDep3ByContPopDep2IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep3Obj > >();
		}
		if( indexByContPopDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep3Obj> dict = indexByContPopDep2Idx.get( key );
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByContPopDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id );
			Iterator<ICFBamPopSubDep3Obj> iter = dict.values().iterator();
			ICFBamPopSubDep3Obj obj;
			List<ICFBamPopSubDep3Obj> toForget = new LinkedList<ICFBamPopSubDep3Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContPopDep2Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByContPopDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id );
		}
	}

	public void deletePopSubDep3ByUNameIdx( long ContTenantId,
		long ContPopDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep3ByUNameIdxKey,
				ICFBamPopSubDep3Obj >();
		}
		CFBamPopSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopDep2Id( ContPopDep2Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep3Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTablePopSubDep3().deletePopSubDep3ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopDep2Id,
				Name );
		}
	}
}
