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

public class CFBamPopSubDep1TableObj
	implements ICFBamPopSubDep1TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopSubDep1Obj> members;
	private Map<CFBamScopePKey, ICFBamPopSubDep1Obj> allPopSubDep1;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByDefSchemaIdx;
	private Map< CFBamPopSubDep1ByContPopTopIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByContPopTopIdx;
	private Map< CFBamPopSubDep1ByUNameIdxKey,
		ICFBamPopSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep1";
	public static String TABLE_DBNAME = "popsubdep1";

	public CFBamPopSubDep1TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopTopIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopSubDep1TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopTopIdx = null;
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
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContPopTopIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep1Obj.
	 */
	public ICFBamPopSubDep1Obj newInstance() {
		ICFBamPopSubDep1Obj inst = new CFBamPopSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep1Obj.
	 */
	public ICFBamPopSubDep1EditObj newEditInstance( ICFBamPopSubDep1Obj orig ) {
		ICFBamPopSubDep1EditObj edit = new CFBamPopSubDep1EditObj( orig );
		return( edit );
	}

	public ICFBamPopSubDep1Obj realizePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopSubDep1Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopTopIdx != null ) {
				CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
				keyContPopTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopTopIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapContPopTopIdx = indexByContPopTopIdx.get( keyContPopTopIdx );
				if( mapContPopTopIdx != null ) {
					mapContPopTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopSubDep1Obj)schema.getPopDepTableObj().realizePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopTopIdx != null ) {
				CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
				keyContPopTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopTopIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapContPopTopIdx = indexByContPopTopIdx.get( keyContPopTopIdx );
				if( mapContPopTopIdx != null ) {
					mapContPopTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopSubDep1Obj)schema.getPopDepTableObj().realizePopDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPopTopIdx != null ) {
				CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
				keyContPopTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopTopIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapContPopTopIdx = indexByContPopTopIdx.get( keyContPopTopIdx );
				if( mapContPopTopIdx != null ) {
					mapContPopTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		forgetPopSubDep1( Obj, false );
	}

	public void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj, boolean forgetSubObjects ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopSubDep1Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContPopTopIdx != null ) {
				CFBamPopSubDep1ByContPopTopIdxKey keyContPopTopIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
				keyContPopTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContPopTopIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapContPopTopIdx = indexByContPopTopIdx.get( keyContPopTopIdx );
				if( mapContPopTopIdx != null ) {
					mapContPopTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContPopTopDepId( keepObj.getRequiredContPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopSubDep1 != null ) {
				allPopSubDep1.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getPopSubDep2TableObj().forgetPopSubDep2ByContPopDep1Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopSubDep1Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopSubDep1ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
				ICFBamPopSubDep1Obj cur = null;
				Iterator<ICFBamPopSubDep1Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
				ICFBamPopSubDep1Obj cur = null;
				Iterator<ICFBamPopSubDep1Obj> iter = mapRelationIdx.values().iterator();
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

	public void forgetPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
				ICFBamPopSubDep1Obj cur = null;
				Iterator<ICFBamPopSubDep1Obj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetPopSubDep1ByContPopTopIdx( long ContTenantId,
		long ContPopTopDepId )
	{
		if( indexByContPopTopIdx == null ) {
			return;
		}
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		if( indexByContPopTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapContPopTopIdx = indexByContPopTopIdx.get( key );
			if( mapContPopTopIdx != null ) {
				List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
				ICFBamPopSubDep1Obj cur = null;
				Iterator<ICFBamPopSubDep1Obj> iter = mapContPopTopIdx.values().iterator();
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

			indexByContPopTopIdx.remove( key );
		}
	}

	public void forgetPopSubDep1ByUNameIdx( long ContTenantId,
		long ContPopTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamPopSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamPopSubDep1Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamPopSubDep1Obj createPopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamPopSubDep1Buff buff = obj.getPopSubDep1Buff();
		schema.getBackingStore().getTablePopSubDep1().createPopSubDep1(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POP1" ) ) {
			obj = (ICFBamPopSubDep1Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey ) {
		return( readPopSubDep1( pkey, false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopSubDep1Buff readBuff = schema.getBackingStore().getTablePopSubDep1().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep1Obj lockPopSubDep1( CFBamScopePKey pkey ) {
		ICFBamPopSubDep1Obj locked = null;
		CFBamPopSubDep1Buff lockBuff = schema.getBackingStore().getTablePopSubDep1().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopSubDep1Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockPopSubDep1", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopSubDep1Obj> readAllPopSubDep1() {
		return( readAllPopSubDep1( false ) );
	}

	public List<ICFBamPopSubDep1Obj> readAllPopSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep1";
		if( ( allPopSubDep1 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> map = new HashMap<CFBamScopePKey,ICFBamPopSubDep1Obj>();
			allPopSubDep1 = map;
			CFBamPopSubDep1Buff[] buffList = schema.getBackingStore().getTablePopSubDep1().readAllDerived( schema.getAuthorization() );
			CFBamPopSubDep1Buff buff;
			ICFBamPopSubDep1Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realized = (ICFBamPopSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		int len = allPopSubDep1.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = allPopSubDep1.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		return( readPopSubDep1ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep1Obj obj = readPopSubDep1( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId )
	{
		return( readPopSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realized = (ICFBamPopSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopSubDep1ByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByRelationIdx";
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByRelationIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realized = (ICFBamPopSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopSubDep1ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realized = (ICFBamPopSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByContPopTopIdx( long ContTenantId,
		long ContPopTopDepId )
	{
		return( readPopSubDep1ByContPopTopIdx( ContTenantId,
			ContPopTopDepId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByContPopTopIdx( long ContTenantId,
		long ContPopTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByContPopTopIdx";
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByContPopTopIdx == null ) {
			indexByContPopTopIdx = new HashMap< CFBamPopSubDep1ByContPopTopIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByContPopTopIdx.containsKey( key ) ) {
			dict = indexByContPopTopIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContPopTopIdx.put( key, dict );
			ICFBamPopSubDep1Obj obj;
			CFBamPopSubDep1Buff[] buffList = schema.getBackingStore().getTablePopSubDep1().readDerivedByContPopTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId );
			CFBamPopSubDep1Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realized = (ICFBamPopSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx( long ContTenantId,
		long ContPopTopDepId,
		String Name )
	{
		return( readPopSubDep1ByUNameIdx( ContTenantId,
			ContPopTopDepId,
			Name,
			false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx( long ContTenantId,
		long ContPopTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep1ByUNameIdxKey,
				ICFBamPopSubDep1Obj >();
		}
		CFBamPopSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		key.setRequiredName( Name );
		ICFBamPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopSubDep1Buff buff = schema.getBackingStore().getTablePopSubDep1().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep1Obj updatePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep1().updatePopSubDep1( schema.getAuthorization(),
			Obj.getPopSubDep1Buff() );
		if( Obj.getClassCode().equals( "POP1" ) ) {
			obj = (ICFBamPopSubDep1Obj)Obj.realize();
		}
		return( obj );
	}

	public void deletePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1( schema.getAuthorization(),
			obj.getPopSubDep1Buff() );
		obj.forget( true );
	}

	public void deletePopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readPopSubDep1( pkey );
		if( obj != null ) {
			ICFBamPopSubDep1EditObj editObj = (ICFBamPopSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopSubDep1EditObj)obj.beginEdit();
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

	public void deletePopSubDep1ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByRelationIdx.get( key );
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopSubDep1ByContPopTopIdx( long ContTenantId,
		long ContPopTopDepId )
	{
		CFBamPopSubDep1ByContPopTopIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newContPopTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		if( indexByContPopTopIdx == null ) {
			indexByContPopTopIdx = new HashMap< CFBamPopSubDep1ByContPopTopIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByContPopTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByContPopTopIdx.get( key );
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByContPopTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContPopTopIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByContPopTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId );
		}
	}

	public void deletePopSubDep1ByUNameIdx( long ContTenantId,
		long ContPopTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep1ByUNameIdxKey,
				ICFBamPopSubDep1Obj >();
		}
		CFBamPopSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContPopTopDepId( ContPopTopDepId );
		key.setRequiredName( Name );
		ICFBamPopSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTablePopSubDep1().deletePopSubDep1ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContPopTopDepId,
				Name );
		}
	}
}
