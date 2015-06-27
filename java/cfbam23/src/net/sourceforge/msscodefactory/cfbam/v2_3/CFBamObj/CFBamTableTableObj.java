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

public class CFBamTableTableObj
	implements ICFBamTableTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamTableObj> members;
	private Map<CFBamScopePKey, ICFBamTableObj> allTable;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByTenantIdx;
	private Map< CFBamTableBySchemaDefIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexBySchemaDefIdx;
	private Map< CFBamTableByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByDefSchemaIdx;
	private Map< CFBamTableByUNameIdxKey,
		ICFBamTableObj > indexByUNameIdx;
	private Map< CFBamTableBySchemaCdIdxKey,
		ICFBamTableObj > indexBySchemaCdIdx;
	private Map< CFBamTableByPrimaryIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByPrimaryIndexIdx;
	private Map< CFBamTableByLookupIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByLookupIndexIdx;
	private Map< CFBamTableByAltIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByAltIndexIdx;
	private Map< CFBamTableByQualTableIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByQualTableIdx;
	private Map< CFBamTableByLoadBehaveIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByLoadBehaveIdx;
	private Map< CFBamTableByDataScopeIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByDataScopeIdx;
	private Map< CFBamTableBySecScopeIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexBySecScopeIdx;
	private Map< CFBamTableByVAccSecIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByVAccSecIdx;
	private Map< CFBamTableByVAccFreqIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByVAccFreqIdx;
	private Map< CFBamTableByEAccSecIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByEAccSecIdx;
	private Map< CFBamTableByEAccFreqIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByEAccFreqIdx;
	public static String TABLE_NAME = "Table";
	public static String TABLE_DBNAME = "tbldef";

	public CFBamTableTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
		indexByLoadBehaveIdx = null;
		indexByDataScopeIdx = null;
		indexBySecScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
	}

	public CFBamTableTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
		indexByLoadBehaveIdx = null;
		indexByDataScopeIdx = null;
		indexBySecScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
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
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
		indexByLoadBehaveIdx = null;
		indexByDataScopeIdx = null;
		indexBySecScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableObj.
	 */
	public ICFBamTableObj newInstance() {
		ICFBamTableObj inst = new CFBamTableObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableObj.
	 */
	public ICFBamTableEditObj newEditInstance( ICFBamTableObj orig ) {
		ICFBamTableEditObj edit = new CFBamTableEditObj( orig );
		return( edit );
	}

	public ICFBamTableObj realizeTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamTableObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTableObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.remove( keySchemaCdIdx );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLoadBehaveIdx != null ) {
				CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx =
					schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
				keyLoadBehaveIdx.setRequiredLoaderBehaviourId( keepObj.getRequiredLoaderBehaviourId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLoadBehaveIdx = indexByLoadBehaveIdx.get( keyLoadBehaveIdx );
				if( mapLoadBehaveIdx != null ) {
					mapLoadBehaveIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamTableByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecScopeIdx != null ) {
				CFBamTableBySecScopeIdxKey keySecScopeIdx =
					schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
				keySecScopeIdx.setRequiredSecurityScopeId( keepObj.getRequiredSecurityScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSecScopeIdx = indexBySecScopeIdx.get( keySecScopeIdx );
				if( mapSecScopeIdx != null ) {
					mapSecScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamTableByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamTableByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamTableByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamTableByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTableObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoadBehaveIdx != null ) {
				CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx =
					schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
				keyLoadBehaveIdx.setRequiredLoaderBehaviourId( keepObj.getRequiredLoaderBehaviourId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLoadBehaveIdx = indexByLoadBehaveIdx.get( keyLoadBehaveIdx );
				if( mapLoadBehaveIdx != null ) {
					mapLoadBehaveIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamTableByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecScopeIdx != null ) {
				CFBamTableBySecScopeIdxKey keySecScopeIdx =
					schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
				keySecScopeIdx.setRequiredSecurityScopeId( keepObj.getRequiredSecurityScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSecScopeIdx = indexBySecScopeIdx.get( keySecScopeIdx );
				if( mapSecScopeIdx != null ) {
					mapSecScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamTableByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamTableByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamTableByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamTableByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTableObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoadBehaveIdx != null ) {
				CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx =
					schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
				keyLoadBehaveIdx.setRequiredLoaderBehaviourId( keepObj.getRequiredLoaderBehaviourId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLoadBehaveIdx = indexByLoadBehaveIdx.get( keyLoadBehaveIdx );
				if( mapLoadBehaveIdx != null ) {
					mapLoadBehaveIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamTableByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecScopeIdx != null ) {
				CFBamTableBySecScopeIdxKey keySecScopeIdx =
					schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
				keySecScopeIdx.setRequiredSecurityScopeId( keepObj.getRequiredSecurityScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSecScopeIdx = indexBySecScopeIdx.get( keySecScopeIdx );
				if( mapSecScopeIdx != null ) {
					mapSecScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamTableByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamTableByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamTableByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamTableByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetTable( ICFBamTableObj Obj ) {
		forgetTable( Obj, false );
	}

	public void forgetTable( ICFBamTableObj Obj, boolean forgetSubObjects ) {
		ICFBamTableObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTableObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.remove( keySchemaCdIdx );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByLoadBehaveIdx != null ) {
				CFBamTableByLoadBehaveIdxKey keyLoadBehaveIdx =
					schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
				keyLoadBehaveIdx.setRequiredLoaderBehaviourId( keepObj.getRequiredLoaderBehaviourId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLoadBehaveIdx = indexByLoadBehaveIdx.get( keyLoadBehaveIdx );
				if( mapLoadBehaveIdx != null ) {
					mapLoadBehaveIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamTableByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexBySecScopeIdx != null ) {
				CFBamTableBySecScopeIdxKey keySecScopeIdx =
					schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
				keySecScopeIdx.setRequiredSecurityScopeId( keepObj.getRequiredSecurityScopeId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSecScopeIdx = indexBySecScopeIdx.get( keySecScopeIdx );
				if( mapSecScopeIdx != null ) {
					mapSecScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamTableByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamTableByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamTableByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamTableByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( allTable != null ) {
				allTable.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getRelationTableObj().forgetRelationByTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getIndexTableObj().forgetIndexByTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getValueTableObj().forgetValueByScopeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getRelationTableObj().forgetRelationByToTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getChainTableObj().forgetChainByTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getDelTopDepTableObj().forgetDelTopDepByContTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getClearTopDepTableObj().forgetClearTopDepByContTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getId16GenTableObj().forgetId16GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getId32GenTableObj().forgetId32GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getId64GenTableObj().forgetId64GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getServerMethodTableObj().forgetServerMethodByTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetTableByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTableObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTableByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		if( indexBySchemaDefIdx == null ) {
			return;
		}
		CFBamTableBySchemaDefIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaDefIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( key );
			if( mapSchemaDefIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapSchemaDefIdx.values().iterator();
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

			indexBySchemaDefIdx.remove( key );
		}
	}

	public void forgetTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamTableByDefSchemaIdxKey key = schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamTableByUNameIdxKey key = schema.getBackingStore().getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamTableObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		if( indexBySchemaCdIdx == null ) {
			return;
		}
		CFBamTableBySchemaCdIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		if( indexBySchemaCdIdx.containsKey( key ) ) {
			ICFBamTableObj probed = indexBySchemaCdIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexBySchemaCdIdx.remove( key );
		}
	}

	public void forgetTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		if( indexByPrimaryIndexIdx == null ) {
			return;
		}
		CFBamTableByPrimaryIndexIdxKey key = schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		if( indexByPrimaryIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( key );
			if( mapPrimaryIndexIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapPrimaryIndexIdx.values().iterator();
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

			indexByPrimaryIndexIdx.remove( key );
		}
	}

	public void forgetTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		if( indexByLookupIndexIdx == null ) {
			return;
		}
		CFBamTableByLookupIndexIdxKey key = schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		if( indexByLookupIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( key );
			if( mapLookupIndexIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapLookupIndexIdx.values().iterator();
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

			indexByLookupIndexIdx.remove( key );
		}
	}

	public void forgetTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		if( indexByAltIndexIdx == null ) {
			return;
		}
		CFBamTableByAltIndexIdxKey key = schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		if( indexByAltIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( key );
			if( mapAltIndexIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapAltIndexIdx.values().iterator();
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

			indexByAltIndexIdx.remove( key );
		}
	}

	public void forgetTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		if( indexByQualTableIdx == null ) {
			return;
		}
		CFBamTableByQualTableIdxKey key = schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		if( indexByQualTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( key );
			if( mapQualTableIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapQualTableIdx.values().iterator();
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

			indexByQualTableIdx.remove( key );
		}
	}

	public void forgetTableByLoadBehaveIdx( short LoaderBehaviourId )
	{
		if( indexByLoadBehaveIdx == null ) {
			return;
		}
		CFBamTableByLoadBehaveIdxKey key = schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( LoaderBehaviourId );
		if( indexByLoadBehaveIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapLoadBehaveIdx = indexByLoadBehaveIdx.get( key );
			if( mapLoadBehaveIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapLoadBehaveIdx.values().iterator();
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

			indexByLoadBehaveIdx.remove( key );
		}
	}

	public void forgetTableByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamTableByDataScopeIdxKey key = schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapDataScopeIdx.values().iterator();
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

			indexByDataScopeIdx.remove( key );
		}
	}

	public void forgetTableBySecScopeIdx( short SecurityScopeId )
	{
		if( indexBySecScopeIdx == null ) {
			return;
		}
		CFBamTableBySecScopeIdxKey key = schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( SecurityScopeId );
		if( indexBySecScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapSecScopeIdx = indexBySecScopeIdx.get( key );
			if( mapSecScopeIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapSecScopeIdx.values().iterator();
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

			indexBySecScopeIdx.remove( key );
		}
	}

	public void forgetTableByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamTableByVAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapVAccSecIdx.values().iterator();
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

			indexByVAccSecIdx.remove( key );
		}
	}

	public void forgetTableByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamTableByVAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapVAccFreqIdx.values().iterator();
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

			indexByVAccFreqIdx.remove( key );
		}
	}

	public void forgetTableByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamTableByEAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapEAccSecIdx.values().iterator();
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

			indexByEAccSecIdx.remove( key );
		}
	}

	public void forgetTableByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamTableByEAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
				ICFBamTableObj cur = null;
				Iterator<ICFBamTableObj> iter = mapEAccFreqIdx.values().iterator();
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

			indexByEAccFreqIdx.remove( key );
		}
	}

	public ICFBamTableObj createTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		CFBamTableBuff buff = obj.getTableBuff();
		schema.getBackingStore().getTableTable().createTable(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "TBLD" ) ) {
			obj = (ICFBamTableObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamTableObj readTable( CFBamScopePKey pkey ) {
		return( readTable( pkey, false ) );
	}

	public ICFBamTableObj readTable( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTableBuff readBuff = schema.getBackingStore().getTableTable().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTableObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTableObj lockTable( CFBamScopePKey pkey ) {
		ICFBamTableObj locked = null;
		CFBamTableBuff lockBuff = schema.getBackingStore().getTableTable().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTableObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTable", pkey );
		}
		return( locked );
	}

	public List<ICFBamTableObj> readAllTable() {
		return( readAllTable( false ) );
	}

	public List<ICFBamTableObj> readAllTable( boolean forceRead ) {
		final String S_ProcName = "readAllTable";
		if( ( allTable == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamTableObj> map = new HashMap<CFBamScopePKey,ICFBamTableObj>();
			allTable = map;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readAllDerived( schema.getAuthorization() );
			CFBamTableBuff buff;
			ICFBamTableObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		int len = allTable.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = allTable.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id )
	{
		return( readTableByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTableObj obj = readTable( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTableObj> readTableByTenantIdx( long TenantId )
	{
		return( readTableByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		return( readTableBySchemaDefIdx( TenantId,
			SchemaDefId,
			false ) );
	}

	public List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableBySchemaDefIdx";
		CFBamTableBySchemaDefIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaDefIdx.containsKey( key ) ) {
			dict = indexBySchemaDefIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySchemaDefIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTableByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByDefSchemaIdx";
		CFBamTableByDefSchemaIdxKey key = schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj readTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		return( readTableByUNameIdx( TenantId,
			SchemaDefId,
			Name,
			false ) );
	}

	public ICFBamTableObj readTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTableByUNameIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableByUNameIdxKey key = schema.getBackingStore().getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamTableBuff buff = schema.getBackingStore().getTableTable().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTableObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTableObj readTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		return( readTableBySchemaCdIdx( TenantId,
			SchemaDefId,
			TableClassCode,
			false ) );
	}

	public ICFBamTableObj readTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode, boolean forceRead )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< CFBamTableBySchemaCdIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableBySchemaCdIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
		}
		else {
			CFBamTableBuff buff = schema.getBackingStore().getTableTable().readDerivedBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
			if( buff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTableObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexBySchemaCdIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		return( readTableByPrimaryIndexIdx( PrimaryIndexTenantId,
			PrimaryIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByPrimaryIndexIdx";
		CFBamTableByPrimaryIndexIdxKey key = schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByPrimaryIndexIdx.containsKey( key ) ) {
			dict = indexByPrimaryIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrimaryIndexIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		return( readTableByLookupIndexIdx( LookupIndexTenantId,
			LookupIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByLookupIndexIdx";
		CFBamTableByLookupIndexIdxKey key = schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByLookupIndexIdx.containsKey( key ) ) {
			dict = indexByLookupIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByLookupIndexIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		return( readTableByAltIndexIdx( AltIndexTenantId,
			AltIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByAltIndexIdx";
		CFBamTableByAltIndexIdxKey key = schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByAltIndexIdx.containsKey( key ) ) {
			dict = indexByAltIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByAltIndexIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		return( readTableByQualTableIdx( QualifyingTenantId,
			QualifyingTableId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByQualTableIdx";
		CFBamTableByQualTableIdxKey key = schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByQualTableIdx.containsKey( key ) ) {
			dict = indexByQualTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByQualTableIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByLoadBehaveIdx( short LoaderBehaviourId )
	{
		return( readTableByLoadBehaveIdx( LoaderBehaviourId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByLoadBehaveIdx( short LoaderBehaviourId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByLoadBehaveIdx";
		CFBamTableByLoadBehaveIdxKey key = schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( LoaderBehaviourId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByLoadBehaveIdx == null ) {
			indexByLoadBehaveIdx = new HashMap< CFBamTableByLoadBehaveIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByLoadBehaveIdx.containsKey( key ) ) {
			dict = indexByLoadBehaveIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByLoadBehaveIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByLoadBehaveIdx( schema.getAuthorization(),
				LoaderBehaviourId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByDataScopeIdx( Short DataScopeId )
	{
		return( readTableByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByDataScopeIdx";
		CFBamTableByDataScopeIdxKey key = schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamTableByDataScopeIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableBySecScopeIdx( short SecurityScopeId )
	{
		return( readTableBySecScopeIdx( SecurityScopeId,
			false ) );
	}

	public List<ICFBamTableObj> readTableBySecScopeIdx( short SecurityScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableBySecScopeIdx";
		CFBamTableBySecScopeIdxKey key = schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( SecurityScopeId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexBySecScopeIdx == null ) {
			indexBySecScopeIdx = new HashMap< CFBamTableBySecScopeIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexBySecScopeIdx.containsKey( key ) ) {
			dict = indexBySecScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySecScopeIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedBySecScopeIdx( schema.getAuthorization(),
				SecurityScopeId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readTableByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByVAccSecIdx";
		CFBamTableByVAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamTableByVAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readTableByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByVAccFreqIdx";
		CFBamTableByVAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamTableByVAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readTableByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByEAccSecIdx";
		CFBamTableByEAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamTableByEAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readTableByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByEAccFreqIdx";
		CFBamTableByEAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamTableByEAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = schema.getBackingStore().getTableTable().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
			}
		}
		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj updateTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		schema.getBackingStore().getTableTable().updateTable( schema.getAuthorization(),
			Obj.getTableBuff() );
		if( Obj.getClassCode().equals( "TBLD" ) ) {
			obj = (ICFBamTableObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		schema.getBackingStore().getTableTable().deleteTable( schema.getAuthorization(),
			obj.getTableBuff() );
		obj.forget( true );
	}

	public void deleteTableByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readTable( pkey );
		if( obj != null ) {
			ICFBamTableEditObj editObj = (ICFBamTableEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTableEditObj)obj.beginEdit();
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

	public void deleteTableByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
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
			schema.getBackingStore().getTableTable().deleteTableByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		CFBamTableBySchemaDefIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexBySchemaDefIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexBySchemaDefIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySchemaDefIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
		}
	}

	public void deleteTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamTableByDefSchemaIdxKey key = schema.getBackingStore().getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
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
			schema.getBackingStore().getTableTable().deleteTableByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTableByUNameIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableByUNameIdxKey key = schema.getBackingStore().getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		ICFBamTableObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
		}
	}

	public void deleteTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< CFBamTableBySchemaCdIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableBySchemaCdIdxKey key = schema.getBackingStore().getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		ICFBamTableObj obj = null;
		if( indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
		}
	}

	public void deleteTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		CFBamTableByPrimaryIndexIdxKey key = schema.getBackingStore().getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByPrimaryIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByPrimaryIndexIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrimaryIndexIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
		}
	}

	public void deleteTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		CFBamTableByLookupIndexIdxKey key = schema.getBackingStore().getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByLookupIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByLookupIndexIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLookupIndexIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
		}
	}

	public void deleteTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		CFBamTableByAltIndexIdxKey key = schema.getBackingStore().getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByAltIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByAltIndexIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByAltIndexIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
		}
	}

	public void deleteTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		CFBamTableByQualTableIdxKey key = schema.getBackingStore().getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByQualTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByQualTableIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByQualTableIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
		}
	}

	public void deleteTableByLoadBehaveIdx( short LoaderBehaviourId )
	{
		CFBamTableByLoadBehaveIdxKey key = schema.getBackingStore().getFactoryTable().newLoadBehaveIdxKey();
		key.setRequiredLoaderBehaviourId( LoaderBehaviourId );
		if( indexByLoadBehaveIdx == null ) {
			indexByLoadBehaveIdx = new HashMap< CFBamTableByLoadBehaveIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByLoadBehaveIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByLoadBehaveIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByLoadBehaveIdx( schema.getAuthorization(),
				LoaderBehaviourId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLoadBehaveIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByLoadBehaveIdx( schema.getAuthorization(),
				LoaderBehaviourId );
		}
	}

	public void deleteTableByDataScopeIdx( Short DataScopeId )
	{
		CFBamTableByDataScopeIdxKey key = schema.getBackingStore().getFactoryTable().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamTableByDataScopeIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDataScopeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteTableBySecScopeIdx( short SecurityScopeId )
	{
		CFBamTableBySecScopeIdxKey key = schema.getBackingStore().getFactoryTable().newSecScopeIdxKey();
		key.setRequiredSecurityScopeId( SecurityScopeId );
		if( indexBySecScopeIdx == null ) {
			indexBySecScopeIdx = new HashMap< CFBamTableBySecScopeIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexBySecScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexBySecScopeIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableBySecScopeIdx( schema.getAuthorization(),
				SecurityScopeId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecScopeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableBySecScopeIdx( schema.getAuthorization(),
				SecurityScopeId );
		}
	}

	public void deleteTableByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamTableByVAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamTableByVAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByVAccSecIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteTableByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamTableByVAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamTableByVAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByVAccFreqIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteTableByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamTableByEAccSecIdxKey key = schema.getBackingStore().getFactoryTable().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamTableByEAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEAccSecIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteTableByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamTableByEAccFreqIdxKey key = schema.getBackingStore().getFactoryTable().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamTableByEAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableTable().deleteTableByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEAccFreqIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableTable().deleteTableByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}
}
