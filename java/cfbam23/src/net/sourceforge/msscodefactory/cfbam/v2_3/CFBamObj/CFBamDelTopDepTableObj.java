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

public class CFBamDelTopDepTableObj
	implements ICFBamDelTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamDelTopDepObj> allDelTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByTableIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByTableIdx;
	private Map< CFBamDelTopDepByContTblIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByContTblIdx;
	private Map< CFBamDelTopDepByUNameIdxKey,
		ICFBamDelTopDepObj > indexByUNameIdx;
	public static String TABLE_NAME = "DelTopDep";
	public static String TABLE_DBNAME = "del_topdep";

	public CFBamDelTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByTableIdx = null;
		indexByContTblIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamDelTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
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
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
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
	 *	CFBamDelTopDepObj.
	 */
	public ICFBamDelTopDepObj newInstance() {
		ICFBamDelTopDepObj inst = new CFBamDelTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelTopDepObj.
	 */
	public ICFBamDelTopDepEditObj newEditInstance( ICFBamDelTopDepObj orig ) {
		ICFBamDelTopDepEditObj edit = new CFBamDelTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamDelTopDepObj realizeDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelTopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamDelTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelTopDepObj)schema.getDelDepTableObj().realizeDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamDelTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelTopDepObj)schema.getDelDepTableObj().realizeDelDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamDelTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetDelTopDep( ICFBamDelTopDepObj Obj ) {
		forgetDelTopDep( Obj, false );
	}

	public void forgetDelTopDep( ICFBamDelTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamDelDepByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
				keyTableIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyTableIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByContTblIdx != null ) {
				CFBamDelTopDepByContTblIdxKey keyContTblIdx =
					schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
				keyContTblIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContTblIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapContTblIdx = indexByContTblIdx.get( keyContTblIdx );
				if( mapContTblIdx != null ) {
					mapContTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContTableId( keepObj.getRequiredContTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDelTopDep != null ) {
				allDelTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getDelSubDep1TableObj().forgetDelSubDep1ByContDelTopIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
				ICFBamDelTopDepObj cur = null;
				Iterator<ICFBamDelTopDepObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
				ICFBamDelTopDepObj cur = null;
				Iterator<ICFBamDelTopDepObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetDelTopDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
				ICFBamDelTopDepObj cur = null;
				Iterator<ICFBamDelTopDepObj> iter = mapTableIdx.values().iterator();
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

	public void forgetDelTopDepByContTblIdx( long ContTenantId,
		long ContTableId )
	{
		if( indexByContTblIdx == null ) {
			return;
		}
		CFBamDelTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		if( indexByContTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapContTblIdx = indexByContTblIdx.get( key );
			if( mapContTblIdx != null ) {
				List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
				ICFBamDelTopDepObj cur = null;
				Iterator<ICFBamDelTopDepObj> iter = mapContTblIdx.values().iterator();
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

	public void forgetDelTopDepByUNameIdx( long ContTenantId,
		long ContTableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamDelTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamDelTopDepObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamDelTopDepObj createDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamDelTopDepBuff buff = obj.getDelTopDepBuff();
		schema.getBackingStore().getTableDelTopDep().createDelTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DELT" ) ) {
			obj = (ICFBamDelTopDepObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey ) {
		return( readDelTopDep( pkey, false ) );
	}

	public ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelTopDepBuff readBuff = schema.getBackingStore().getTableDelTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDelTopDepObj lockDelTopDep( CFBamScopePKey pkey ) {
		ICFBamDelTopDepObj locked = null;
		CFBamDelTopDepBuff lockBuff = schema.getBackingStore().getTableDelTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelTopDepObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDelTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelTopDepObj> readAllDelTopDep() {
		return( readAllDelTopDep( false ) );
	}

	public List<ICFBamDelTopDepObj> readAllDelTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelTopDep";
		if( ( allDelTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamDelTopDepObj>();
			allDelTopDep = map;
			CFBamDelTopDepBuff[] buffList = schema.getBackingStore().getTableDelTopDep().readAllDerived( schema.getAuthorization() );
			CFBamDelTopDepBuff buff;
			ICFBamDelTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realized = (ICFBamDelTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		int len = allDelTopDep.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = allDelTopDep.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readDelTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelTopDepObj obj = readDelTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId )
	{
		return( readDelTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realized = (ICFBamDelTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelTopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realized = (ICFBamDelTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelTopDepByTableIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTableIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByTableIdx";
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = schema.getBackingStore().getTableDelDep().readDerivedByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realized = (ICFBamDelTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByContTblIdx( long ContTenantId,
		long ContTableId )
	{
		return( readDelTopDepByContTblIdx( ContTenantId,
			ContTableId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByContTblIdx( long ContTenantId,
		long ContTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByContTblIdx";
		CFBamDelTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByContTblIdx == null ) {
			indexByContTblIdx = new HashMap< CFBamDelTopDepByContTblIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByContTblIdx.containsKey( key ) ) {
			dict = indexByContTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContTblIdx.put( key, dict );
			ICFBamDelTopDepObj obj;
			CFBamDelTopDepBuff[] buffList = schema.getBackingStore().getTableDelTopDep().readDerivedByContTblIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId );
			CFBamDelTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realized = (ICFBamDelTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelTopDepObj readDelTopDepByUNameIdx( long ContTenantId,
		long ContTableId,
		String Name )
	{
		return( readDelTopDepByUNameIdx( ContTenantId,
			ContTableId,
			Name,
			false ) );
	}

	public ICFBamDelTopDepObj readDelTopDepByUNameIdx( long ContTenantId,
		long ContTableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelTopDepByUNameIdxKey,
				ICFBamDelTopDepObj >();
		}
		CFBamDelTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		ICFBamDelTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelTopDepBuff buff = schema.getBackingStore().getTableDelTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamDelTopDepObj updateDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		schema.getBackingStore().getTableDelTopDep().updateDelTopDep( schema.getAuthorization(),
			Obj.getDelTopDepBuff() );
		if( Obj.getClassCode().equals( "DELT" ) ) {
			obj = (ICFBamDelTopDepObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		schema.getBackingStore().getTableDelTopDep().deleteDelTopDep( schema.getAuthorization(),
			obj.getDelTopDepBuff() );
		obj.forget( true );
	}

	public void deleteDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readDelTopDep( pkey );
		if( obj != null ) {
			ICFBamDelTopDepEditObj editObj = (ICFBamDelTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelTopDepEditObj)obj.beginEdit();
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

	public void deleteDelTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelTopDepByTableIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByTableIdxKey key = schema.getBackingStore().getFactoryDelDep().newTableIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamDelDepByTableIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByTableIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelTopDepByContTblIdx( long ContTenantId,
		long ContTableId )
	{
		CFBamDelTopDepByContTblIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newContTblIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		if( indexByContTblIdx == null ) {
			indexByContTblIdx = new HashMap< CFBamDelTopDepByContTblIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByContTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByContTblIdx.get( key );
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByContTblIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByContTblIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId );
		}
	}

	public void deleteDelTopDepByUNameIdx( long ContTenantId,
		long ContTableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelTopDepByUNameIdxKey,
				ICFBamDelTopDepObj >();
		}
		CFBamDelTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContTableId( ContTableId );
		key.setRequiredName( Name );
		ICFBamDelTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableDelTopDep().deleteDelTopDepByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContTableId,
				Name );
		}
	}
}
