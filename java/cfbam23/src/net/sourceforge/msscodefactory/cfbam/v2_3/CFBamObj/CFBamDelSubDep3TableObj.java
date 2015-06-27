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

public class CFBamDelSubDep3TableObj
	implements ICFBamDelSubDep3TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelSubDep3Obj> members;
	private Map<CFBamScopePKey, ICFBamDelSubDep3Obj> allDelSubDep3;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj > > indexByTableIdx;
	private Map< CFBamDelSubDep3ByContDelDep2IdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj > > indexByContDelDep2Idx;
	private Map< CFBamDelSubDep3ByUNameIdxKey,
		ICFBamDelSubDep3Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep3";
	public static String TABLE_DBNAME = "delsubdep3";

	public CFBamDelSubDep3TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
		allDelSubDep3 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep2Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamDelSubDep3TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
		allDelSubDep3 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep2Idx = null;
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
		allDelSubDep3 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelDep2Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep3Obj.
	 */
	public ICFBamDelSubDep3Obj newInstance() {
		ICFBamDelSubDep3Obj inst = new CFBamDelSubDep3Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep3Obj.
	 */
	public ICFBamDelSubDep3EditObj newEditInstance( ICFBamDelSubDep3Obj orig ) {
		ICFBamDelSubDep3EditObj edit = new CFBamDelSubDep3EditObj( orig );
		return( edit );
	}

	public ICFBamDelSubDep3Obj realizeDelSubDep3( ICFBamDelSubDep3Obj Obj ) {
		ICFBamDelSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelSubDep3Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelSubDep3Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelDep2Idx != null ) {
				CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx =
					schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
				keyContDelDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep2Idx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapContDelDep2Idx = indexByContDelDep2Idx.get( keyContDelDep2Idx );
				if( mapContDelDep2Idx != null ) {
					mapContDelDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelSubDep3Obj)schema.getDelDepTableObj().realizeDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep2Idx != null ) {
				CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx =
					schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
				keyContDelDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep2Idx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapContDelDep2Idx = indexByContDelDep2Idx.get( keyContDelDep2Idx );
				if( mapContDelDep2Idx != null ) {
					mapContDelDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allDelSubDep3 != null ) {
				allDelSubDep3.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelSubDep3Obj)schema.getDelDepTableObj().realizeDelDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep3 != null ) {
				allDelSubDep3.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep2Idx != null ) {
				CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx =
					schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
				keyContDelDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep2Idx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapContDelDep2Idx = indexByContDelDep2Idx.get( keyContDelDep2Idx );
				if( mapContDelDep2Idx != null ) {
					mapContDelDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDelSubDep3( ICFBamDelSubDep3Obj Obj ) {
		forgetDelSubDep3( Obj, false );
	}

	public void forgetDelSubDep3( ICFBamDelSubDep3Obj Obj, boolean forgetSubObjects ) {
		ICFBamDelSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelSubDep3Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelDep2Idx != null ) {
				CFBamDelSubDep3ByContDelDep2IdxKey keyContDelDep2Idx =
					schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
				keyContDelDep2Idx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelDep2Idx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapContDelDep2Idx = indexByContDelDep2Idx.get( keyContDelDep2Idx );
				if( mapContDelDep2Idx != null ) {
					mapContDelDep2Idx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelDep2Id( keepObj.getRequiredContDelDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDelSubDep3 != null ) {
				allDelSubDep3.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelSubDep3Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelSubDep3ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
				ICFBamDelSubDep3Obj cur = null;
				Iterator<ICFBamDelSubDep3Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
				ICFBamDelSubDep3Obj cur = null;
				Iterator<ICFBamDelSubDep3Obj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetDelSubDep3ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
				ICFBamDelSubDep3Obj cur = null;
				Iterator<ICFBamDelSubDep3Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetDelSubDep3ByContDelDep2Idx( long ContTenantId,
		long ContDelDep2Id )
	{
		if( indexByContDelDep2Idx == null ) {
			return;
		}
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		if( indexByContDelDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj > mapContDelDep2Idx = indexByContDelDep2Idx.get( key );
			if( mapContDelDep2Idx != null ) {
				List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
				ICFBamDelSubDep3Obj cur = null;
				Iterator<ICFBamDelSubDep3Obj> iter = mapContDelDep2Idx.values().iterator();
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

			indexByContDelDep2Idx.remove( key );
		}
	}

	public void forgetDelSubDep3ByUNameIdx( long ContTenantId,
		long ContDelDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamDelSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamDelSubDep3Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamDelSubDep3Obj createDelSubDep3( ICFBamDelSubDep3Obj Obj ) {
		ICFBamDelSubDep3Obj obj = Obj;
		CFBamDelSubDep3Buff buff = obj.getDelSubDep3Buff();
		schema.getBackingStore().getTableDelSubDep3().createDelSubDep3(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DEL3" ) ) {
			obj = (ICFBamDelSubDep3Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3( CFBamScopePKey pkey ) {
		return( readDelSubDep3( pkey, false ) );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelSubDep3Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelSubDep3Buff readBuff = schema.getBackingStore().getTableDelSubDep3().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep3Obj lockDelSubDep3( CFBamScopePKey pkey ) {
		ICFBamDelSubDep3Obj locked = null;
		CFBamDelSubDep3Buff lockBuff = schema.getBackingStore().getTableDelSubDep3().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelSubDep3Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDelSubDep3", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelSubDep3Obj> readAllDelSubDep3() {
		return( readAllDelSubDep3( false ) );
	}

	public List<ICFBamDelSubDep3Obj> readAllDelSubDep3( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep3";
		if( ( allDelSubDep3 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj> map = new HashMap<CFBamScopePKey,ICFBamDelSubDep3Obj>();
			allDelSubDep3 = map;
			CFBamDelSubDep3Buff[] buffList = schema.getBackingStore().getTableDelSubDep3().readAllDerived( schema.getAuthorization() );
			CFBamDelSubDep3Buff buff;
			ICFBamDelSubDep3Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep3Obj realized = (ICFBamDelSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep3Obj> cmp = new Comparator<ICFBamDelSubDep3Obj>() {
			public int compare( ICFBamDelSubDep3Obj lhs, ICFBamDelSubDep3Obj rhs ) {
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
		int len = allDelSubDep3.size();
		ICFBamDelSubDep3Obj arr[] = new ICFBamDelSubDep3Obj[len];
		Iterator<ICFBamDelSubDep3Obj> valIter = allDelSubDep3.values().iterator();
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
		ArrayList<ICFBamDelSubDep3Obj> arrayList = new ArrayList<ICFBamDelSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		return( readDelSubDep3ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelSubDep3Obj obj = readDelSubDep3( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByTenantIdx( long TenantId )
	{
		return( readDelSubDep3ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep3ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep3Obj realized = (ICFBamDelSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep3Obj> cmp = new Comparator<ICFBamDelSubDep3Obj>() {
			public int compare( ICFBamDelSubDep3Obj lhs, ICFBamDelSubDep3Obj rhs ) {
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
		ICFBamDelSubDep3Obj arr[] = new ICFBamDelSubDep3Obj[len];
		Iterator<ICFBamDelSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep3Obj> arrayList = new ArrayList<ICFBamDelSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelSubDep3ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep3ByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep3Obj realized = (ICFBamDelSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep3Obj> cmp = new Comparator<ICFBamDelSubDep3Obj>() {
			public int compare( ICFBamDelSubDep3Obj lhs, ICFBamDelSubDep3Obj rhs ) {
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
		ICFBamDelSubDep3Obj arr[] = new ICFBamDelSubDep3Obj[len];
		Iterator<ICFBamDelSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep3Obj> arrayList = new ArrayList<ICFBamDelSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelSubDep3ByTableIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByTableIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep3ByTableIdx";
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep3Obj realized = (ICFBamDelSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep3Obj> cmp = new Comparator<ICFBamDelSubDep3Obj>() {
			public int compare( ICFBamDelSubDep3Obj lhs, ICFBamDelSubDep3Obj rhs ) {
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
		ICFBamDelSubDep3Obj arr[] = new ICFBamDelSubDep3Obj[len];
		Iterator<ICFBamDelSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep3Obj> arrayList = new ArrayList<ICFBamDelSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByContDelDep2Idx( long ContTenantId,
		long ContDelDep2Id )
	{
		return( readDelSubDep3ByContDelDep2Idx( ContTenantId,
			ContDelDep2Id,
			false ) );
	}

	public List<ICFBamDelSubDep3Obj> readDelSubDep3ByContDelDep2Idx( long ContTenantId,
		long ContDelDep2Id,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep3ByContDelDep2Idx";
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict;
		if( indexByContDelDep2Idx == null ) {
			indexByContDelDep2Idx = new HashMap< CFBamDelSubDep3ByContDelDep2IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByContDelDep2Idx.containsKey( key ) ) {
			dict = indexByContDelDep2Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep3Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContDelDep2Idx.put( key, dict );
			ICFBamDelSubDep3Obj obj;
			CFBamDelSubDep3Buff[] buffList = schema.getBackingStore().getTableDelSubDep3().readDerivedByContDelDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id );
			CFBamDelSubDep3Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep3Obj realized = (ICFBamDelSubDep3Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep3Obj> cmp = new Comparator<ICFBamDelSubDep3Obj>() {
			public int compare( ICFBamDelSubDep3Obj lhs, ICFBamDelSubDep3Obj rhs ) {
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
		ICFBamDelSubDep3Obj arr[] = new ICFBamDelSubDep3Obj[len];
		Iterator<ICFBamDelSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep3Obj> arrayList = new ArrayList<ICFBamDelSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3ByUNameIdx( long ContTenantId,
		long ContDelDep2Id,
		String Name )
	{
		return( readDelSubDep3ByUNameIdx( ContTenantId,
			ContDelDep2Id,
			Name,
			false ) );
	}

	public ICFBamDelSubDep3Obj readDelSubDep3ByUNameIdx( long ContTenantId,
		long ContDelDep2Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep3ByUNameIdxKey,
				ICFBamDelSubDep3Obj >();
		}
		CFBamDelSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep3Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelSubDep3Buff buff = schema.getBackingStore().getTableDelSubDep3().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelSubDep3Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep3Obj updateDelSubDep3( ICFBamDelSubDep3Obj Obj ) {
		ICFBamDelSubDep3Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep3().updateDelSubDep3( schema.getAuthorization(),
			Obj.getDelSubDep3Buff() );
		if( Obj.getClassCode().equals( "DEL3" ) ) {
			obj = (ICFBamDelSubDep3Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDelSubDep3( ICFBamDelSubDep3Obj Obj ) {
		ICFBamDelSubDep3Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3( schema.getAuthorization(),
			obj.getDelSubDep3Buff() );
		obj.forget( true );
	}

	public void deleteDelSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readDelSubDep3( pkey );
		if( obj != null ) {
			ICFBamDelSubDep3EditObj editObj = (ICFBamDelSubDep3EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelSubDep3EditObj)obj.beginEdit();
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

	public void deleteDelSubDep3ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelSubDep3Obj> iter = dict.values().iterator();
			ICFBamDelSubDep3Obj obj;
			List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
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
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelSubDep3Obj> iter = dict.values().iterator();
			ICFBamDelSubDep3Obj obj;
			List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
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
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelSubDep3ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelSubDep3Obj> iter = dict.values().iterator();
			ICFBamDelSubDep3Obj obj;
			List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
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
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelSubDep3ByContDelDep2Idx( long ContTenantId,
		long ContDelDep2Id )
	{
		CFBamDelSubDep3ByContDelDep2IdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newContDelDep2IdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		if( indexByContDelDep2Idx == null ) {
			indexByContDelDep2Idx = new HashMap< CFBamDelSubDep3ByContDelDep2IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep3Obj > >();
		}
		if( indexByContDelDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep3Obj> dict = indexByContDelDep2Idx.get( key );
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByContDelDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id );
			Iterator<ICFBamDelSubDep3Obj> iter = dict.values().iterator();
			ICFBamDelSubDep3Obj obj;
			List<ICFBamDelSubDep3Obj> toForget = new LinkedList<ICFBamDelSubDep3Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContDelDep2Idx.remove( key );
		}
		else {
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByContDelDep2Idx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id );
		}
	}

	public void deleteDelSubDep3ByUNameIdx( long ContTenantId,
		long ContDelDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep3ByUNameIdxKey,
				ICFBamDelSubDep3Obj >();
		}
		CFBamDelSubDep3ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep3().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelDep2Id( ContDelDep2Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep3Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDelSubDep3().deleteDelSubDep3ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelDep2Id,
				Name );
		}
	}
}
