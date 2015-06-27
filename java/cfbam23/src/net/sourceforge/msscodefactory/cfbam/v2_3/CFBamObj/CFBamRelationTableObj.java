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

public class CFBamRelationTableObj
	implements ICFBamRelationTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamRelationObj> members;
	private Map<CFBamScopePKey, ICFBamRelationObj> allRelation;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByTenantIdx;
	private Map< CFBamRelationByUNameIdxKey,
		ICFBamRelationObj > indexByUNameIdx;
	private Map< CFBamRelationByRelnTenantIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByRelnTenantIdx;
	private Map< CFBamRelationByTableIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByTableIdx;
	private Map< CFBamRelationByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByDefSchemaIdx;
	private Map< CFBamRelationByRTypeKeyIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByRTypeKeyIdx;
	private Map< CFBamRelationByFromKeyIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByFromKeyIdx;
	private Map< CFBamRelationByToTblIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByToTblIdx;
	private Map< CFBamRelationByToKeyIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByToKeyIdx;
	private Map< CFBamRelationByNarrowedIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByNarrowedIdx;
	public static String TABLE_NAME = "Relation";
	public static String TABLE_DBNAME = "reldef";

	public CFBamRelationTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRTypeKeyIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}

	public CFBamRelationTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRTypeKeyIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
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
		return( ICFBamSchemaDefObj.class );
	}


	public void minimizeMemory() {
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRTypeKeyIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationObj.
	 */
	public ICFBamRelationObj newInstance() {
		ICFBamRelationObj inst = new CFBamRelationObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationObj.
	 */
	public ICFBamRelationEditObj newEditInstance( ICFBamRelationObj orig ) {
		ICFBamRelationEditObj edit = new CFBamRelationEditObj( orig );
		return( edit );
	}

	public ICFBamRelationObj realizeRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamRelationObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamRelationObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamRelationByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryRelation().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByRTypeKeyIdx != null ) {
				CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx =
					schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
				keyRTypeKeyIdx.setRequiredRelationTypeId( keepObj.getRequiredRelationTypeId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRTypeKeyIdx = indexByRTypeKeyIdx.get( keyRTypeKeyIdx );
				if( mapRTypeKeyIdx != null ) {
					mapRTypeKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamRelationObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamRelationByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryRelation().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRTypeKeyIdx != null ) {
				CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx =
					schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
				keyRTypeKeyIdx.setRequiredRelationTypeId( keepObj.getRequiredRelationTypeId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRTypeKeyIdx = indexByRTypeKeyIdx.get( keyRTypeKeyIdx );
				if( mapRTypeKeyIdx != null ) {
					mapRTypeKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamRelationObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamRelationByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryRelation().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRTypeKeyIdx != null ) {
				CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx =
					schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
				keyRTypeKeyIdx.setRequiredRelationTypeId( keepObj.getRequiredRelationTypeId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRTypeKeyIdx = indexByRTypeKeyIdx.get( keyRTypeKeyIdx );
				if( mapRTypeKeyIdx != null ) {
					mapRTypeKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetRelation( ICFBamRelationObj Obj ) {
		forgetRelation( Obj, false );
	}

	public void forgetRelation( ICFBamRelationObj Obj, boolean forgetSubObjects ) {
		ICFBamRelationObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamRelationObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamRelationByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryRelation().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByRTypeKeyIdx != null ) {
				CFBamRelationByRTypeKeyIdxKey keyRTypeKeyIdx =
					schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
				keyRTypeKeyIdx.setRequiredRelationTypeId( keepObj.getRequiredRelationTypeId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRTypeKeyIdx = indexByRTypeKeyIdx.get( keyRTypeKeyIdx );
				if( mapRTypeKeyIdx != null ) {
					mapRTypeKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.remove( keepObj.getPKey() );
				}
			}

			if( allRelation != null ) {
				allRelation.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getRelationColTableObj().forgetRelationColByRelationIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getPopTopDepTableObj().forgetPopTopDepByContRelIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetRelationByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamRelationObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetRelationByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamRelationByUNameIdxKey key = schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamRelationObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetRelationByRelnTenantIdx( long TenantId )
	{
		if( indexByRelnTenantIdx == null ) {
			return;
		}
		CFBamRelationByRelnTenantIdxKey key = schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelnTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( key );
			if( mapRelnTenantIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapRelnTenantIdx.values().iterator();
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

			indexByRelnTenantIdx.remove( key );
		}
	}

	public void forgetRelationByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamRelationByTableIdxKey key = schema.getBackingStore().getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapTableIdx.values().iterator();
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

	public void forgetRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamRelationByDefSchemaIdxKey key = schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetRelationByRTypeKeyIdx( short RelationTypeId )
	{
		if( indexByRTypeKeyIdx == null ) {
			return;
		}
		CFBamRelationByRTypeKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( RelationTypeId );
		if( indexByRTypeKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapRTypeKeyIdx = indexByRTypeKeyIdx.get( key );
			if( mapRTypeKeyIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapRTypeKeyIdx.values().iterator();
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

			indexByRTypeKeyIdx.remove( key );
		}
	}

	public void forgetRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		if( indexByFromKeyIdx == null ) {
			return;
		}
		CFBamRelationByFromKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		if( indexByFromKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( key );
			if( mapFromKeyIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapFromKeyIdx.values().iterator();
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

			indexByFromKeyIdx.remove( key );
		}
	}

	public void forgetRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		if( indexByToTblIdx == null ) {
			return;
		}
		CFBamRelationByToTblIdxKey key = schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		if( indexByToTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( key );
			if( mapToTblIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapToTblIdx.values().iterator();
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

			indexByToTblIdx.remove( key );
		}
	}

	public void forgetRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		if( indexByToKeyIdx == null ) {
			return;
		}
		CFBamRelationByToKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		if( indexByToKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( key );
			if( mapToKeyIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapToKeyIdx.values().iterator();
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

			indexByToKeyIdx.remove( key );
		}
	}

	public void forgetRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		if( indexByNarrowedIdx == null ) {
			return;
		}
		CFBamRelationByNarrowedIdxKey key = schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		if( indexByNarrowedIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( key );
			if( mapNarrowedIdx != null ) {
				List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
				ICFBamRelationObj cur = null;
				Iterator<ICFBamRelationObj> iter = mapNarrowedIdx.values().iterator();
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

			indexByNarrowedIdx.remove( key );
		}
	}

	public ICFBamRelationObj createRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		CFBamRelationBuff buff = obj.getRelationBuff();
		schema.getBackingStore().getTableRelation().createRelation(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "RELD" ) ) {
			obj = (ICFBamRelationObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamRelationObj readRelation( CFBamScopePKey pkey ) {
		return( readRelation( pkey, false ) );
	}

	public ICFBamRelationObj readRelation( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamRelationObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamRelationBuff readBuff = schema.getBackingStore().getTableRelation().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamRelationObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamRelationObj lockRelation( CFBamScopePKey pkey ) {
		ICFBamRelationObj locked = null;
		CFBamRelationBuff lockBuff = schema.getBackingStore().getTableRelation().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamRelationObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockRelation", pkey );
		}
		return( locked );
	}

	public List<ICFBamRelationObj> readAllRelation() {
		return( readAllRelation( false ) );
	}

	public List<ICFBamRelationObj> readAllRelation( boolean forceRead ) {
		final String S_ProcName = "readAllRelation";
		if( ( allRelation == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamRelationObj> map = new HashMap<CFBamScopePKey,ICFBamRelationObj>();
			allRelation = map;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readAllDerived( schema.getAuthorization() );
			CFBamRelationBuff buff;
			ICFBamRelationObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		int len = allRelation.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = allRelation.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id )
	{
		return( readRelationByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamRelationObj obj = readRelation( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId )
	{
		return( readRelationByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj readRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readRelationByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamRelationObj readRelationByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationByUNameIdxKey,
				ICFBamRelationObj >();
		}
		CFBamRelationByUNameIdxKey key = schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamRelationObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamRelationBuff buff = schema.getBackingStore().getTableRelation().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamRelationObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId )
	{
		return( readRelationByRelnTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelnTenantIdx";
		CFBamRelationByRelnTenantIdxKey key = schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByRelnTenantIdx == null ) {
			indexByRelnTenantIdx = new HashMap< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelnTenantIdx.containsKey( key ) ) {
			dict = indexByRelnTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByRelnTenantIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByTableIdx( long TenantId,
		long TableId )
	{
		return( readRelationByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByTableIdx";
		CFBamRelationByTableIdxKey key = schema.getBackingStore().getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamRelationByTableIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readRelationByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByDefSchemaIdx";
		CFBamRelationByDefSchemaIdxKey key = schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByRTypeKeyIdx( short RelationTypeId )
	{
		return( readRelationByRTypeKeyIdx( RelationTypeId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByRTypeKeyIdx( short RelationTypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRTypeKeyIdx";
		CFBamRelationByRTypeKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( RelationTypeId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByRTypeKeyIdx == null ) {
			indexByRTypeKeyIdx = new HashMap< CFBamRelationByRTypeKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRTypeKeyIdx.containsKey( key ) ) {
			dict = indexByRTypeKeyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByRTypeKeyIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByRTypeKeyIdx( schema.getAuthorization(),
				RelationTypeId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		return( readRelationByFromKeyIdx( TenantId,
			FromIndexId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByFromKeyIdx";
		CFBamRelationByFromKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByFromKeyIdx.containsKey( key ) ) {
			dict = indexByFromKeyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByFromKeyIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		return( readRelationByToTblIdx( TenantId,
			ToTableId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToTblIdx";
		CFBamRelationByToTblIdxKey key = schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToTblIdx.containsKey( key ) ) {
			dict = indexByToTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByToTblIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		return( readRelationByToKeyIdx( TenantId,
			ToIndexId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToKeyIdx";
		CFBamRelationByToKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToKeyIdx.containsKey( key ) ) {
			dict = indexByToKeyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByToKeyIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		return( readRelationByNarrowedIdx( NarrowedTenantId,
			NarrowedId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByNarrowedIdx";
		CFBamRelationByNarrowedIdxKey key = schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByNarrowedIdx.containsKey( key ) ) {
			dict = indexByNarrowedIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNarrowedIdx.put( key, dict );
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = schema.getBackingStore().getTableRelation().readDerivedByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realized = (ICFBamRelationObj)obj.realize();
			}
		}
		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj updateRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		schema.getBackingStore().getTableRelation().updateRelation( schema.getAuthorization(),
			Obj.getRelationBuff() );
		if( Obj.getClassCode().equals( "RELD" ) ) {
			obj = (ICFBamRelationObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		schema.getBackingStore().getTableRelation().deleteRelation( schema.getAuthorization(),
			obj.getRelationBuff() );
		obj.forget( true );
	}

	public void deleteRelationByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readRelation( pkey );
		if( obj != null ) {
			ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamRelationEditObj)obj.beginEdit();
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

	public void deleteRelationByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
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
			schema.getBackingStore().getTableRelation().deleteRelationByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationByUNameIdxKey,
				ICFBamRelationObj >();
		}
		CFBamRelationByUNameIdxKey key = schema.getBackingStore().getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamRelationObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteRelationByRelnTenantIdx( long TenantId )
	{
		CFBamRelationByRelnTenantIdxKey key = schema.getBackingStore().getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelnTenantIdx == null ) {
			indexByRelnTenantIdx = new HashMap< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByRelnTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByRelnTenantIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelnTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteRelationByTableIdx( long TenantId,
		long TableId )
	{
		CFBamRelationByTableIdxKey key = schema.getBackingStore().getFactoryRelation().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamRelationByTableIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
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
			schema.getBackingStore().getTableRelation().deleteRelationByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamRelationByDefSchemaIdxKey key = schema.getBackingStore().getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
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
			schema.getBackingStore().getTableRelation().deleteRelationByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteRelationByRTypeKeyIdx( short RelationTypeId )
	{
		CFBamRelationByRTypeKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newRTypeKeyIdxKey();
		key.setRequiredRelationTypeId( RelationTypeId );
		if( indexByRTypeKeyIdx == null ) {
			indexByRTypeKeyIdx = new HashMap< CFBamRelationByRTypeKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByRTypeKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByRTypeKeyIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByRTypeKeyIdx( schema.getAuthorization(),
				RelationTypeId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRTypeKeyIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByRTypeKeyIdx( schema.getAuthorization(),
				RelationTypeId );
		}
	}

	public void deleteRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		CFBamRelationByFromKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByFromKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByFromKeyIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFromKeyIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
		}
	}

	public void deleteRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		CFBamRelationByToTblIdxKey key = schema.getBackingStore().getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByToTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByToTblIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToTblIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
		}
	}

	public void deleteRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		CFBamRelationByToKeyIdxKey key = schema.getBackingStore().getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByToKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByToKeyIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToKeyIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
		}
	}

	public void deleteRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		CFBamRelationByNarrowedIdxKey key = schema.getBackingStore().getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByNarrowedIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByNarrowedIdx.get( key );
			schema.getBackingStore().getTableRelation().deleteRelationByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNarrowedIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableRelation().deleteRelationByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
		}
	}
}
