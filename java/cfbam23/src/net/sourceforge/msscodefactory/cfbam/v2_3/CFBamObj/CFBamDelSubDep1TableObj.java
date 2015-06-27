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

public class CFBamDelSubDep1TableObj
	implements ICFBamDelSubDep1TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelSubDep1Obj> members;
	private Map<CFBamScopePKey, ICFBamDelSubDep1Obj> allDelSubDep1;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj > > indexByTableIdx;
	private Map< CFBamDelSubDep1ByContDelTopIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj > > indexByContDelTopIdx;
	private Map< CFBamDelSubDep1ByUNameIdxKey,
		ICFBamDelSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep1";
	public static String TABLE_DBNAME = "delsubdep1";

	public CFBamDelSubDep1TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelTopIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamDelSubDep1TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelTopIdx = null;
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
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContDelTopIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep1Obj.
	 */
	public ICFBamDelSubDep1Obj newInstance() {
		ICFBamDelSubDep1Obj inst = new CFBamDelSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep1Obj.
	 */
	public ICFBamDelSubDep1EditObj newEditInstance( ICFBamDelSubDep1Obj orig ) {
		ICFBamDelSubDep1EditObj edit = new CFBamDelSubDep1EditObj( orig );
		return( edit );
	}

	public ICFBamDelSubDep1Obj realizeDelSubDep1( ICFBamDelSubDep1Obj Obj ) {
		ICFBamDelSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelSubDep1Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelTopIdx != null ) {
				CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
				keyContDelTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelTopIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapContDelTopIdx = indexByContDelTopIdx.get( keyContDelTopIdx );
				if( mapContDelTopIdx != null ) {
					mapContDelTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelSubDep1Obj)schema.getDelDepTableObj().realizeDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelTopIdx != null ) {
				CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
				keyContDelTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelTopIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapContDelTopIdx = indexByContDelTopIdx.get( keyContDelTopIdx );
				if( mapContDelTopIdx != null ) {
					mapContDelTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allDelSubDep1 != null ) {
				allDelSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelSubDep1Obj)schema.getDelDepTableObj().realizeDelDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep1 != null ) {
				allDelSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelTopIdx != null ) {
				CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
				keyContDelTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelTopIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapContDelTopIdx = indexByContDelTopIdx.get( keyContDelTopIdx );
				if( mapContDelTopIdx != null ) {
					mapContDelTopIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDelSubDep1( ICFBamDelSubDep1Obj Obj ) {
		forgetDelSubDep1( Obj, false );
	}

	public void forgetDelSubDep1( ICFBamDelSubDep1Obj Obj, boolean forgetSubObjects ) {
		ICFBamDelSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelSubDep1Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContDelTopIdx != null ) {
				CFBamDelSubDep1ByContDelTopIdxKey keyContDelTopIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
				keyContDelTopIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContDelTopIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapContDelTopIdx = indexByContDelTopIdx.get( keyContDelTopIdx );
				if( mapContDelTopIdx != null ) {
					mapContDelTopIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContDelTopDepId( keepObj.getRequiredContDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDelSubDep1 != null ) {
				allDelSubDep1.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getDelSubDep2TableObj().forgetDelSubDep2ByContDelDep1Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelSubDep1Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelSubDep1ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
				ICFBamDelSubDep1Obj cur = null;
				Iterator<ICFBamDelSubDep1Obj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDelSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
				ICFBamDelSubDep1Obj cur = null;
				Iterator<ICFBamDelSubDep1Obj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetDelSubDep1ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
				ICFBamDelSubDep1Obj cur = null;
				Iterator<ICFBamDelSubDep1Obj> iter = mapTableIdx.values().iterator();
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

	public void forgetDelSubDep1ByContDelTopIdx( long ContTenantId,
		long ContDelTopDepId )
	{
		if( indexByContDelTopIdx == null ) {
			return;
		}
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		if( indexByContDelTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj > mapContDelTopIdx = indexByContDelTopIdx.get( key );
			if( mapContDelTopIdx != null ) {
				List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
				ICFBamDelSubDep1Obj cur = null;
				Iterator<ICFBamDelSubDep1Obj> iter = mapContDelTopIdx.values().iterator();
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

			indexByContDelTopIdx.remove( key );
		}
	}

	public void forgetDelSubDep1ByUNameIdx( long ContTenantId,
		long ContDelTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamDelSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamDelSubDep1Obj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamDelSubDep1Obj createDelSubDep1( ICFBamDelSubDep1Obj Obj ) {
		ICFBamDelSubDep1Obj obj = Obj;
		CFBamDelSubDep1Buff buff = obj.getDelSubDep1Buff();
		schema.getBackingStore().getTableDelSubDep1().createDelSubDep1(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DEL1" ) ) {
			obj = (ICFBamDelSubDep1Obj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1( CFBamScopePKey pkey ) {
		return( readDelSubDep1( pkey, false ) );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelSubDep1Buff readBuff = schema.getBackingStore().getTableDelSubDep1().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep1Obj lockDelSubDep1( CFBamScopePKey pkey ) {
		ICFBamDelSubDep1Obj locked = null;
		CFBamDelSubDep1Buff lockBuff = schema.getBackingStore().getTableDelSubDep1().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelSubDep1Obj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDelSubDep1", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelSubDep1Obj> readAllDelSubDep1() {
		return( readAllDelSubDep1( false ) );
	}

	public List<ICFBamDelSubDep1Obj> readAllDelSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep1";
		if( ( allDelSubDep1 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj> map = new HashMap<CFBamScopePKey,ICFBamDelSubDep1Obj>();
			allDelSubDep1 = map;
			CFBamDelSubDep1Buff[] buffList = schema.getBackingStore().getTableDelSubDep1().readAllDerived( schema.getAuthorization() );
			CFBamDelSubDep1Buff buff;
			ICFBamDelSubDep1Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep1Obj realized = (ICFBamDelSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep1Obj> cmp = new Comparator<ICFBamDelSubDep1Obj>() {
			public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
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
		int len = allDelSubDep1.size();
		ICFBamDelSubDep1Obj arr[] = new ICFBamDelSubDep1Obj[len];
		Iterator<ICFBamDelSubDep1Obj> valIter = allDelSubDep1.values().iterator();
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
		ArrayList<ICFBamDelSubDep1Obj> arrayList = new ArrayList<ICFBamDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		return( readDelSubDep1ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelSubDep1Obj obj = readDelSubDep1( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByTenantIdx( long TenantId )
	{
		return( readDelSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep1Obj realized = (ICFBamDelSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep1Obj> cmp = new Comparator<ICFBamDelSubDep1Obj>() {
			public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
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
		ICFBamDelSubDep1Obj arr[] = new ICFBamDelSubDep1Obj[len];
		Iterator<ICFBamDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep1Obj> arrayList = new ArrayList<ICFBamDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelSubDep1ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep1Obj realized = (ICFBamDelSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep1Obj> cmp = new Comparator<ICFBamDelSubDep1Obj>() {
			public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
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
		ICFBamDelSubDep1Obj arr[] = new ICFBamDelSubDep1Obj[len];
		Iterator<ICFBamDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep1Obj> arrayList = new ArrayList<ICFBamDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelSubDep1ByTableIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByTableIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByTableIdx";
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep1Obj realized = (ICFBamDelSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep1Obj> cmp = new Comparator<ICFBamDelSubDep1Obj>() {
			public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
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
		ICFBamDelSubDep1Obj arr[] = new ICFBamDelSubDep1Obj[len];
		Iterator<ICFBamDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep1Obj> arrayList = new ArrayList<ICFBamDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByContDelTopIdx( long ContTenantId,
		long ContDelTopDepId )
	{
		return( readDelSubDep1ByContDelTopIdx( ContTenantId,
			ContDelTopDepId,
			false ) );
	}

	public List<ICFBamDelSubDep1Obj> readDelSubDep1ByContDelTopIdx( long ContTenantId,
		long ContDelTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByContDelTopIdx";
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict;
		if( indexByContDelTopIdx == null ) {
			indexByContDelTopIdx = new HashMap< CFBamDelSubDep1ByContDelTopIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByContDelTopIdx.containsKey( key ) ) {
			dict = indexByContDelTopIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep1Obj>();
			// Allow other threads to dirty-read while we're loading
			indexByContDelTopIdx.put( key, dict );
			ICFBamDelSubDep1Obj obj;
			CFBamDelSubDep1Buff[] buffList = schema.getBackingStore().getTableDelSubDep1().readDerivedByContDelTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId );
			CFBamDelSubDep1Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep1Obj realized = (ICFBamDelSubDep1Obj)obj.realize();
			}
		}
		Comparator<ICFBamDelSubDep1Obj> cmp = new Comparator<ICFBamDelSubDep1Obj>() {
			public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
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
		ICFBamDelSubDep1Obj arr[] = new ICFBamDelSubDep1Obj[len];
		Iterator<ICFBamDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep1Obj> arrayList = new ArrayList<ICFBamDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1ByUNameIdx( long ContTenantId,
		long ContDelTopDepId,
		String Name )
	{
		return( readDelSubDep1ByUNameIdx( ContTenantId,
			ContDelTopDepId,
			Name,
			false ) );
	}

	public ICFBamDelSubDep1Obj readDelSubDep1ByUNameIdx( long ContTenantId,
		long ContDelTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep1ByUNameIdxKey,
				ICFBamDelSubDep1Obj >();
		}
		CFBamDelSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		key.setRequiredName( Name );
		ICFBamDelSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelSubDep1Buff buff = schema.getBackingStore().getTableDelSubDep1().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelSubDep1Obj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep1Obj updateDelSubDep1( ICFBamDelSubDep1Obj Obj ) {
		ICFBamDelSubDep1Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep1().updateDelSubDep1( schema.getAuthorization(),
			Obj.getDelSubDep1Buff() );
		if( Obj.getClassCode().equals( "DEL1" ) ) {
			obj = (ICFBamDelSubDep1Obj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDelSubDep1( ICFBamDelSubDep1Obj Obj ) {
		ICFBamDelSubDep1Obj obj = Obj;
		schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1( schema.getAuthorization(),
			obj.getDelSubDep1Buff() );
		obj.forget( true );
	}

	public void deleteDelSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readDelSubDep1( pkey );
		if( obj != null ) {
			ICFBamDelSubDep1EditObj editObj = (ICFBamDelSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelSubDep1EditObj)obj.beginEdit();
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

	public void deleteDelSubDep1ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelSubDep1Obj> iter = dict.values().iterator();
			ICFBamDelSubDep1Obj obj;
			List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
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
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelSubDep1Obj> iter = dict.values().iterator();
			ICFBamDelSubDep1Obj obj;
			List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
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
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelSubDep1ByTableIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelSubDep1Obj> iter = dict.values().iterator();
			ICFBamDelSubDep1Obj obj;
			List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
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
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelSubDep1ByContDelTopIdx( long ContTenantId,
		long ContDelTopDepId )
	{
		CFBamDelSubDep1ByContDelTopIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newContDelTopIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		if( indexByContDelTopIdx == null ) {
			indexByContDelTopIdx = new HashMap< CFBamDelSubDep1ByContDelTopIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep1Obj > >();
		}
		if( indexByContDelTopIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep1Obj> dict = indexByContDelTopIdx.get( key );
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByContDelTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId );
			Iterator<ICFBamDelSubDep1Obj> iter = dict.values().iterator();
			ICFBamDelSubDep1Obj obj;
			List<ICFBamDelSubDep1Obj> toForget = new LinkedList<ICFBamDelSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContDelTopIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByContDelTopIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId );
		}
	}

	public void deleteDelSubDep1ByUNameIdx( long ContTenantId,
		long ContDelTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep1ByUNameIdxKey,
				ICFBamDelSubDep1Obj >();
		}
		CFBamDelSubDep1ByUNameIdxKey key = schema.getBackingStore().getFactoryDelSubDep1().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContDelTopDepId( ContDelTopDepId );
		key.setRequiredName( Name );
		ICFBamDelSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDelSubDep1().deleteDelSubDep1ByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContDelTopDepId,
				Name );
		}
	}
}
