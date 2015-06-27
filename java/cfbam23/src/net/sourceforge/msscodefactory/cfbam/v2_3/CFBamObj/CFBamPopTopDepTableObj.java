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

public class CFBamPopTopDepTableObj
	implements ICFBamPopTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamPopTopDepObj> allPopTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByDefSchemaIdx;
	private Map< CFBamPopTopDepByContRelIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByContRelIdx;
	private Map< CFBamPopTopDepByUNameIdxKey,
		ICFBamPopTopDepObj > indexByUNameIdx;
	public static String TABLE_NAME = "PopTopDep";
	public static String TABLE_DBNAME = "pop_topdep";

	public CFBamPopTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
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
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopTopDepObj.
	 */
	public ICFBamPopTopDepObj newInstance() {
		ICFBamPopTopDepObj inst = new CFBamPopTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopTopDepObj.
	 */
	public ICFBamPopTopDepEditObj newEditInstance( ICFBamPopTopDepObj orig ) {
		ICFBamPopTopDepEditObj edit = new CFBamPopTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamPopTopDepObj realizePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopTopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopTopDepObj)schema.getPopDepTableObj().realizePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopTopDepObj)schema.getPopDepTableObj().realizePopDep( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetPopTopDep( ICFBamPopTopDepObj Obj ) {
		forgetPopTopDep( Obj, false );
	}

	public void forgetPopTopDep( ICFBamPopTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContTenantId( keepObj.getRequiredContTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopTopDep != null ) {
				allPopTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getPopSubDep1TableObj().forgetPopSubDep1ByContPopTopIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
				ICFBamPopTopDepObj cur = null;
				Iterator<ICFBamPopTopDepObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
				ICFBamPopTopDepObj cur = null;
				Iterator<ICFBamPopTopDepObj> iter = mapRelationIdx.values().iterator();
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

	public void forgetPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
				ICFBamPopTopDepObj cur = null;
				Iterator<ICFBamPopTopDepObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetPopTopDepByContRelIdx( long ContTenantId,
		long ContRelationId )
	{
		if( indexByContRelIdx == null ) {
			return;
		}
		CFBamPopTopDepByContRelIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		if( indexByContRelIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( key );
			if( mapContRelIdx != null ) {
				List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
				ICFBamPopTopDepObj cur = null;
				Iterator<ICFBamPopTopDepObj> iter = mapContRelIdx.values().iterator();
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

			indexByContRelIdx.remove( key );
		}
	}

	public void forgetPopTopDepByUNameIdx( long ContTenantId,
		long ContRelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamPopTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamPopTopDepObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamPopTopDepObj createPopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamPopTopDepBuff buff = obj.getPopTopDepBuff();
		schema.getBackingStore().getTablePopTopDep().createPopTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POPT" ) ) {
			obj = (ICFBamPopTopDepObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey ) {
		return( readPopTopDep( pkey, false ) );
	}

	public ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopTopDepBuff readBuff = schema.getBackingStore().getTablePopTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamPopTopDepObj lockPopTopDep( CFBamScopePKey pkey ) {
		ICFBamPopTopDepObj locked = null;
		CFBamPopTopDepBuff lockBuff = schema.getBackingStore().getTablePopTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopTopDepObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockPopTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopTopDepObj> readAllPopTopDep() {
		return( readAllPopTopDep( false ) );
	}

	public List<ICFBamPopTopDepObj> readAllPopTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllPopTopDep";
		if( ( allPopTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamPopTopDepObj>();
			allPopTopDep = map;
			CFBamPopTopDepBuff[] buffList = schema.getBackingStore().getTablePopTopDep().readAllDerived( schema.getAuthorization() );
			CFBamPopTopDepBuff buff;
			ICFBamPopTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realized = (ICFBamPopTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		int len = allPopTopDep.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = allPopTopDep.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readPopTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopTopDepObj obj = readPopTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId )
	{
		return( readPopTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realized = (ICFBamPopTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopTopDepByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByRelationIdx";
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByRelationIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realized = (ICFBamPopTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopTopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = schema.getBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realized = (ICFBamPopTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContTenantId,
		long ContRelationId )
	{
		return( readPopTopDepByContRelIdx( ContTenantId,
			ContRelationId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContTenantId,
		long ContRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByContRelIdx";
		CFBamPopTopDepByContRelIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByContRelIdx.containsKey( key ) ) {
			dict = indexByContRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContRelIdx.put( key, dict );
			ICFBamPopTopDepObj obj;
			CFBamPopTopDepBuff[] buffList = schema.getBackingStore().getTablePopTopDep().readDerivedByContRelIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId );
			CFBamPopTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realized = (ICFBamPopTopDepObj)obj.realize();
			}
		}
		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopTopDepObj readPopTopDepByUNameIdx( long ContTenantId,
		long ContRelationId,
		String Name )
	{
		return( readPopTopDepByUNameIdx( ContTenantId,
			ContRelationId,
			Name,
			false ) );
	}

	public ICFBamPopTopDepObj readPopTopDepByUNameIdx( long ContTenantId,
		long ContRelationId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopTopDepByUNameIdxKey,
				ICFBamPopTopDepObj >();
		}
		CFBamPopTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		ICFBamPopTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopTopDepBuff buff = schema.getBackingStore().getTablePopTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopTopDepObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamPopTopDepObj updatePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		schema.getBackingStore().getTablePopTopDep().updatePopTopDep( schema.getAuthorization(),
			Obj.getPopTopDepBuff() );
		if( Obj.getClassCode().equals( "POPT" ) ) {
			obj = (ICFBamPopTopDepObj)Obj.realize();
		}
		return( obj );
	}

	public void deletePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		schema.getBackingStore().getTablePopTopDep().deletePopTopDep( schema.getAuthorization(),
			obj.getPopTopDepBuff() );
		obj.forget( true );
	}

	public void deletePopTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readPopTopDep( pkey );
		if( obj != null ) {
			ICFBamPopTopDepEditObj editObj = (ICFBamPopTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopTopDepEditObj)obj.beginEdit();
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

	public void deletePopTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = schema.getBackingStore().getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByRelationIdx.get( key );
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = schema.getBackingStore().getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopTopDepByContRelIdx( long ContTenantId,
		long ContRelationId )
	{
		CFBamPopTopDepByContRelIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByContRelIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByContRelIdx.get( key );
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByContRelIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContRelIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByContRelIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId );
		}
	}

	public void deletePopTopDepByUNameIdx( long ContTenantId,
		long ContRelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopTopDepByUNameIdxKey,
				ICFBamPopTopDepObj >();
		}
		CFBamPopTopDepByUNameIdxKey key = schema.getBackingStore().getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContTenantId( ContTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		ICFBamPopTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTablePopTopDep().deletePopTopDepByUNameIdx( schema.getAuthorization(),
				ContTenantId,
				ContRelationId,
				Name );
		}
	}
}
