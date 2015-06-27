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

public class CFBamDelSubDep2TableObj
	implements ICFBamDelSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamDelSubDep2Obj> allDelSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByTableIdx;
	private Map< CFBamDelSubDep2ByContDelDep1IdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByContDelDep1Idx;
	private Map< CFBamDelSubDep2ByUNameIdxKey,
		ICFBamDelSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep2";
	public static String TABLE_DBNAME = "delsubdep2";

	public CFBamDelSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamDelSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep1Idx = null;
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
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep2Obj.
	 */
	public ICFBamDelSubDep2Obj newInstance() {
		ICFBamDelSubDep2Obj inst = new CFBamDelSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep2Obj.
	 */
	public ICFBamDelSubDep2EditObj newEditInstance( ICFBamDelSubDep2Obj orig ) {
		ICFBamDelSubDep2EditObj edit = new CFBamDelSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamDelSubDep2Obj realizeDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep1Idx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelSubDep2Obj)schema.getDelDepTableObj().realizeDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep1Idx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelSubDep2Obj)schema.getDelDepTableObj().realizeDelDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep1Idx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		forgetDelSubDep2( Obj, false );
	}

	public void forgetDelSubDep2( ICFBamDelSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep1Idx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep1Id( keepObj.getRequiredContDelDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDelSubDep2 != null ) {
				allDelSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getDelSubDep3TableObj().forgetDelSubDep3ByContDelDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
				ICFBamDelSubDep2Obj cur = null;
				Iterator<ICFBamDelSubDep2Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
				ICFBamDelSubDep2Obj cur = null;
				Iterator<ICFBamDelSubDep2Obj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetDelSubDep2ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
				ICFBamDelSubDep2Obj cur = null;
				Iterator<ICFBamDelSubDep2Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetDelSubDep2ByContDelDep1Idx( long ContTenantId,
		long ContDelDep1Id )
	{
		if( indexByContDelDep1Idx == null ) {
			return;
		}
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		if( indexByContDelDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( key );
			if( mapContDelDep1Idx != null ) {
				List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
				ICFBamDelSubDep2Obj cur = null;
				Iterator<ICFBamDelSubDep2Obj> iter = mapContDelDep1Idx.values().iterator();
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

			indexByContDelDep1Idx.remove( key );
		}
	}

	public void forgetDelSubDep2ByUNameIdx( long ContTenantId,
		long ContDelDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamDelSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamDelSubDep2Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamDelSubDep2Obj createDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamDelSubDep2Buff buff = obj.getDelSubDep2Buff();
		schema.getBackingStore().getTableDelSubDep2().createDelSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DEL2" ) ) {
			obj = (ICFBamDelSubDep2Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2( CFBamScopePKey pkey ) {
		return( readDelSubDep2( pkey, false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelSubDep2Buff readBuff = schema.getBackingStore().getTableDelSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep2Obj lockDelSubDep2( CFBamScopePKey pkey ) {
		ICFBamDelSubDep2Obj locked = null;
		CFBamDelSubDep2Buff lockBuff = schema.getBackingStore().getTableDelSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelSubDep2Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDelSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelSubDep2Obj> readAllDelSubDep2() {
		return( readAllDelSubDep2( false ) );
	}

	public List<ICFBamDelSubDep2Obj> readAllDelSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep2";
		if( ( allDelSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamDelSubDep2Obj>();
			allDelSubDep2 = map;
			CFBamDelSubDep2Buff[] buffList = schema.getBackingStore().getTableDelSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamDelSubDep2Buff buff;
			ICFBamDelSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realized = (ICFBamDelSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		int len = allDelSubDep2.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = allDelSubDep2.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readDelSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelSubDep2Obj obj = readDelSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTenantIdx( long TenantId )
	{
		return( readDelSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realized = (ICFBamDelSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelSubDep2ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realized = (ICFBamDelSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelSubDep2ByTableIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTableIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByTableIdx";
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realized = (ICFBamDelSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( long ContTenantId,
		long ContDelDep1Id )
	{
		return( readDelSubDep2ByContDelDep1Idx( ContTenantId,
			ContDelDep1Id,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( long ContTenantId,
		long ContDelDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByContDelDep1Idx";
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByContDelDep1Idx.containsKey( key ) ) {
			dict = indexByContDelDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContDelDep1Idx.put( key, dict );
			ICFBamDelSubDep2Obj obj;
			CFBamDelSubDep2Buff[] buffList = schema.getBackingStore().getTableDelSubDep2().readDerivedByContDelDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id );
			CFBamDelSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realized = (ICFBamDelSubDep2Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByUNameIdx( long ContTenantId,
		long ContDelDep1Id,
		String Name )
	{
		return( readDelSubDep2ByUNameIdx( ContTenantId,
			ContDelDep1Id,
			Name,
			false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByUNameIdx( long ContTenantId,
		long ContDelDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep2ByUNameIdxKey,
				ICFBamDelSubDep2Obj >();
		}
		CFBamDelSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelSubDep2Buff buff = schema.getBackingStore().getTableDelSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelSubDep2Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep2Obj updateDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep2().updateDelSubDep2( schema.getAuthorization(),
			Obj.getDelSubDep2Buff() );
		if( Obj.getClassCode().equals( "DEL2" ) ) {
			obj = (ICFBamDelSubDep2Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2( schema.getAuthorization(),
			obj.getDelSubDep2Buff() );
		obj.forget( true );
	}

	public void deleteDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readDelSubDep2( pkey );
		if( obj != null ) {
			ICFBamDelSubDep2EditObj editObj = (ICFBamDelSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelSubDep2EditObj)obj.beginEdit();
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

	public void deleteDelSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelSubDep2ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelSubDep2ByContDelDep1Idx( long ContTenantId,
		long ContDelDep1Id )
	{
		CFBamDelSubDep2ByContDelDep1IdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByContDelDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByContDelDep1Idx.get( key );
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContDelDep1Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id );
		}
	}

	public void deleteDelSubDep2ByUNameIdx( long ContTenantId,
		long ContDelDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep2ByUNameIdxKey,
				ICFBamDelSubDep2Obj >();
		}
		CFBamDelSubDep2ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep1Id( ContDelDep1Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep1Id,
				Name );
		}
	}
}
