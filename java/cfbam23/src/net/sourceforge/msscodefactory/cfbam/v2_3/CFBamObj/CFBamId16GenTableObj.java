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

public class CFBamId16GenTableObj
	implements ICFBamId16GenTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamId16GenObj> members;
	private Map<CFBamValuePKey, ICFBamId16GenObj> allId16Gen;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamId16GenObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByDataScopeIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByDataScopeIdx;
	private Map< CFBamValueByVAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByVAccSecIdx;
	private Map< CFBamValueByVAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByVAccFreqIdx;
	private Map< CFBamValueByEAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByEAccSecIdx;
	private Map< CFBamValueByEAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByEAccFreqIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByContNextIdx;
	private Map< CFBamInt16TypeBySchemaIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexBySchemaIdx;
	private Map< CFBamId16GenByDispIdxKey,
		Map<CFBamValuePKey, ICFBamId16GenObj > > indexByDispIdx;
	public static String TABLE_NAME = "Id16Gen";
	public static String TABLE_DBNAME = "idg16";

	public CFBamId16GenTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
		allId16Gen = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		indexByDispIdx = null;
	}

	public CFBamId16GenTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
		allId16Gen = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		indexByDispIdx = null;
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
		allId16Gen = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		indexByDispIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamId16GenObj.
	 */
	public ICFBamId16GenObj newInstance() {
		ICFBamId16GenObj inst = new CFBamId16GenObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamId16GenObj.
	 */
	public ICFBamId16GenEditObj newEditInstance( ICFBamId16GenObj orig ) {
		ICFBamId16GenEditObj edit = new CFBamId16GenEditObj( orig );
		return( edit );
	}

	public ICFBamId16GenObj realizeId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamId16GenObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamId16GenObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}

			if( indexByDispIdx != null ) {
				CFBamId16GenByDispIdxKey keyDispIdx =
					schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
				keyDispIdx.setOptionalDispenserTenantId( keepObj.getOptionalDispenserTenantId() );
				keyDispIdx.setOptionalDispenserId( keepObj.getOptionalDispenserId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDispIdx = indexByDispIdx.get( keyDispIdx );
				if( mapDispIdx != null ) {
					mapDispIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamId16GenObj)schema.getInt16TypeTableObj().realizeInt16Type( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDispIdx != null ) {
				CFBamId16GenByDispIdxKey keyDispIdx =
					schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
				keyDispIdx.setOptionalDispenserTenantId( keepObj.getOptionalDispenserTenantId() );
				keyDispIdx.setOptionalDispenserId( keepObj.getOptionalDispenserId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDispIdx = indexByDispIdx.get( keyDispIdx );
				if( mapDispIdx != null ) {
					mapDispIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allId16Gen != null ) {
				allId16Gen.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamId16GenObj)schema.getInt16TypeTableObj().realizeInt16Type( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allId16Gen != null ) {
				allId16Gen.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDispIdx != null ) {
				CFBamId16GenByDispIdxKey keyDispIdx =
					schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
				keyDispIdx.setOptionalDispenserTenantId( keepObj.getOptionalDispenserTenantId() );
				keyDispIdx.setOptionalDispenserId( keepObj.getOptionalDispenserId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDispIdx = indexByDispIdx.get( keyDispIdx );
				if( mapDispIdx != null ) {
					mapDispIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetId16Gen( ICFBamId16GenObj Obj ) {
		forgetId16Gen( Obj, false );
	}

	public void forgetId16Gen( ICFBamId16GenObj Obj, boolean forgetSubObjects ) {
		ICFBamId16GenObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamId16GenObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}

			if( indexByDispIdx != null ) {
				CFBamId16GenByDispIdxKey keyDispIdx =
					schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
				keyDispIdx.setOptionalDispenserTenantId( keepObj.getOptionalDispenserTenantId() );
				keyDispIdx.setOptionalDispenserId( keepObj.getOptionalDispenserId() );
				Map<CFBamValuePKey, ICFBamId16GenObj > mapDispIdx = indexByDispIdx.get( keyDispIdx );
				if( mapDispIdx != null ) {
					mapDispIdx.remove( keepObj.getPKey() );
				}
			}

			if( allId16Gen != null ) {
				allId16Gen.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getInt16TypeTableObj().forgetInt16Type( obj );
	}

	public void forgetId16GenByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = schema.getBackingStore().getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamId16GenObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetId16GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamId16GenObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetId16GenByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapValTentIdx.values().iterator();
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

			indexByValTentIdx.remove( key );
		}
	}

	public void forgetId16GenByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapScopeIdx.values().iterator();
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

			indexByScopeIdx.remove( key );
		}
	}

	public void forgetId16GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetId16GenByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapDataScopeIdx.values().iterator();
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

	public void forgetId16GenByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapVAccSecIdx.values().iterator();
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

	public void forgetId16GenByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapVAccFreqIdx.values().iterator();
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

	public void forgetId16GenByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapEAccSecIdx.values().iterator();
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

	public void forgetId16GenByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapEAccFreqIdx.values().iterator();
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

	public void forgetId16GenByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapPrevIdx.values().iterator();
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

			indexByPrevIdx.remove( key );
		}
	}

	public void forgetId16GenByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapNextIdx.values().iterator();
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

			indexByNextIdx.remove( key );
		}
	}

	public void forgetId16GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapContPrevIdx.values().iterator();
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

			indexByContPrevIdx.remove( key );
		}
	}

	public void forgetId16GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapContNextIdx.values().iterator();
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

			indexByContNextIdx.remove( key );
		}
	}

	public void forgetId16GenBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		if( indexBySchemaIdx == null ) {
			return;
		}
		CFBamInt16TypeBySchemaIdxKey key = schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapSchemaIdx = indexBySchemaIdx.get( key );
			if( mapSchemaIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapSchemaIdx.values().iterator();
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

			indexBySchemaIdx.remove( key );
		}
	}

	public void forgetId16GenByDispIdx( Long DispenserTenantId,
		Long DispenserId )
	{
		if( indexByDispIdx == null ) {
			return;
		}
		CFBamId16GenByDispIdxKey key = schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
		key.setOptionalDispenserTenantId( DispenserTenantId );
		key.setOptionalDispenserId( DispenserId );
		if( indexByDispIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj > mapDispIdx = indexByDispIdx.get( key );
			if( mapDispIdx != null ) {
				List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
				ICFBamId16GenObj cur = null;
				Iterator<ICFBamId16GenObj> iter = mapDispIdx.values().iterator();
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

			indexByDispIdx.remove( key );
		}
	}

	public ICFBamId16GenObj createId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = Obj;
		CFBamId16GenBuff buff = obj.getId16GenBuff();
		schema.getBackingStore().getTableId16Gen().createId16Gen(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "IG16" ) ) {
			obj = (ICFBamId16GenObj)(obj.realize());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamId16GenObj readId16Gen( CFBamValuePKey pkey ) {
		return( readId16Gen( pkey, false ) );
	}

	public ICFBamId16GenObj readId16Gen( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamId16GenObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamId16GenBuff readBuff = schema.getBackingStore().getTableId16Gen().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamId16GenObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamId16GenObj lockId16Gen( CFBamValuePKey pkey ) {
		ICFBamId16GenObj locked = null;
		CFBamId16GenBuff lockBuff = schema.getBackingStore().getTableId16Gen().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamId16GenObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockId16Gen", pkey );
		}
		return( locked );
	}

	public List<ICFBamId16GenObj> readAllId16Gen() {
		return( readAllId16Gen( false ) );
	}

	public List<ICFBamId16GenObj> readAllId16Gen( boolean forceRead ) {
		final String S_ProcName = "readAllId16Gen";
		if( ( allId16Gen == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> map = new HashMap<CFBamValuePKey,ICFBamId16GenObj>();
			allId16Gen = map;
			CFBamId16GenBuff[] buffList = schema.getBackingStore().getTableId16Gen().readAllDerived( schema.getAuthorization() );
			CFBamId16GenBuff buff;
			ICFBamId16GenObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allId16Gen.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = allId16Gen.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamId16GenObj readId16GenByIdIdx( long TenantId,
		long Id )
	{
		return( readId16GenByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamId16GenObj readId16GenByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamId16GenObj obj = readId16Gen( pkey, forceRead );
		return( obj );
	}

	public ICFBamId16GenObj readId16GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readId16GenByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamId16GenObj readId16GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamId16GenObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamId16GenObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = schema.getBackingStore().getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamId16GenObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamId16GenObj> readId16GenByValTentIdx( long TenantId )
	{
		return( readId16GenByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByValTentIdx";
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByValTentIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readId16GenByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByScopeIdx";
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readId16GenByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByDataScopeIdx( Short DataScopeId )
	{
		return( readId16GenByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByDataScopeIdx";
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readId16GenByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByVAccSecIdx";
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readId16GenByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByVAccFreqIdx";
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readId16GenByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByEAccSecIdx";
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readId16GenByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByEAccFreqIdx";
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readId16GenByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByPrevIdx";
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readId16GenByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByNextIdx";
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readId16GenByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByContPrevIdx";
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContPrevIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readId16GenByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByContNextIdx";
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContNextIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		return( readId16GenBySchemaIdx( TenantId,
			SchemaDefId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenBySchemaIdx";
		CFBamInt16TypeBySchemaIdxKey key = schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamInt16TypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySchemaIdx.put( key, dict );
			ICFBamInt16TypeObj obj;
			CFBamInt16TypeBuff[] buffList = schema.getBackingStore().getTableInt16Type().readDerivedBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			CFBamInt16TypeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamId16GenObj> readId16GenByDispIdx( Long DispenserTenantId,
		Long DispenserId )
	{
		return( readId16GenByDispIdx( DispenserTenantId,
			DispenserId,
			false ) );
	}

	public List<ICFBamId16GenObj> readId16GenByDispIdx( Long DispenserTenantId,
		Long DispenserId,
		boolean forceRead )
	{
		final String S_ProcName = "readId16GenByDispIdx";
		CFBamId16GenByDispIdxKey key = schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
		key.setOptionalDispenserTenantId( DispenserTenantId );
		key.setOptionalDispenserId( DispenserId );
		Map<CFBamValuePKey, ICFBamId16GenObj> dict;
		if( indexByDispIdx == null ) {
			indexByDispIdx = new HashMap< CFBamId16GenByDispIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( ( ! forceRead ) && indexByDispIdx.containsKey( key ) ) {
			dict = indexByDispIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamId16GenObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDispIdx.put( key, dict );
			ICFBamId16GenObj obj;
			CFBamId16GenBuff[] buffList = schema.getBackingStore().getTableId16Gen().readDerivedByDispIdx( schema.getAuthorization(),
				DispenserTenantId,
				DispenserId );
			CFBamId16GenBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamId16GenObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamId16GenObj realized = (ICFBamId16GenObj)obj.realize();
			}
		}
		Comparator<ICFBamId16GenObj> cmp = new Comparator<ICFBamId16GenObj>() {
			public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamId16GenObj arr[] = new ICFBamId16GenObj[len];
		Iterator<ICFBamId16GenObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamId16GenObj> arrayList = new ArrayList<ICFBamId16GenObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamId16GenObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamId16GenObj updateId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = Obj;
		schema.getBackingStore().getTableId16Gen().updateId16Gen( schema.getAuthorization(),
			Obj.getId16GenBuff() );
		if( Obj.getClassCode().equals( "IG16" ) ) {
			obj = (ICFBamId16GenObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableId16Gen().deleteId16Gen( schema.getAuthorization(),
			obj.getId16GenBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteId16GenByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamValueObj obj = readId16Gen( pkey );
		if( obj != null ) {
			ICFBamId16GenEditObj editObj = (ICFBamId16GenEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamId16GenEditObj)obj.beginEdit();
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

	public void deleteId16GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamId16GenObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamId16GenObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteId16GenByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByValTentIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByValTentIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteId16GenByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByScopeIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByScopeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteId16GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteId16GenByDataScopeIdx( Short DataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteId16GenByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteId16GenByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteId16GenByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteId16GenByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
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
			schema.getBackingStore().getTableId16Gen().deleteId16GenByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}

	public void deleteId16GenByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteId16GenByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteId16GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByContPrevIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContPrevIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteId16GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByContNextIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContNextIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteId16GenBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		CFBamInt16TypeBySchemaIdxKey key = schema.getBackingStore().getFactoryInt16Type().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamInt16TypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexBySchemaIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySchemaIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
		}
	}

	public void deleteId16GenByDispIdx( Long DispenserTenantId,
		Long DispenserId )
	{
		CFBamId16GenByDispIdxKey key = schema.getBackingStore().getFactoryId16Gen().newDispIdxKey();
		key.setOptionalDispenserTenantId( DispenserTenantId );
		key.setOptionalDispenserId( DispenserId );
		if( indexByDispIdx == null ) {
			indexByDispIdx = new HashMap< CFBamId16GenByDispIdxKey,
				Map< CFBamValuePKey, ICFBamId16GenObj > >();
		}
		if( indexByDispIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamId16GenObj> dict = indexByDispIdx.get( key );
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDispIdx( schema.getAuthorization(),
				DispenserTenantId,
				DispenserId );
			Iterator<ICFBamId16GenObj> iter = dict.values().iterator();
			ICFBamId16GenObj obj;
			List<ICFBamId16GenObj> toForget = new LinkedList<ICFBamId16GenObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDispIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableId16Gen().deleteId16GenByDispIdx( schema.getAuthorization(),
				DispenserTenantId,
				DispenserId );
		}
	}

	/**
	 *	Move the CFBamId16GenObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId16GenObj refreshed cache instance.
	 */
	public ICFBamId16GenObj moveUpId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpId16Gen",
				"You cannot move an object that is being edited" );
		}
		CFBamId16GenBuff buff = schema.getBackingStore().getTableId16Gen().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getId16GenTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamId16GenObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamId16GenObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId16GenObj refreshed cache instance.
	 */
	public ICFBamId16GenObj moveDownId16Gen( ICFBamId16GenObj Obj ) {
		ICFBamId16GenObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownId16Gen",
				"You cannot move an object that is being edited" );
		}
		CFBamId16GenBuff buff = schema.getBackingStore().getTableId16Gen().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getId16GenTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamId16GenObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
