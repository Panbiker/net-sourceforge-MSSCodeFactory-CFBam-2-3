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

public class CFBamTZTimestampTypeTableObj
	implements ICFBamTZTimestampTypeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> members;
	private Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> allTZTimestampType;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamTZTimestampTypeObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByDataScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByDataScopeIdx;
	private Map< CFBamValueByVAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByVAccSecIdx;
	private Map< CFBamValueByVAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByVAccFreqIdx;
	private Map< CFBamValueByEAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByEAccSecIdx;
	private Map< CFBamValueByEAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByEAccFreqIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByContNextIdx;
	private Map< CFBamTZTimestampTypeBySchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "TZTimestampType";
	public static String TABLE_DBNAME = "zstyp";

	public CFBamTZTimestampTypeTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
		allTZTimestampType = null;
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
	}

	public CFBamTZTimestampTypeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
		allTZTimestampType = null;
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
		allTZTimestampType = null;
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
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampTypeObj.
	 */
	public ICFBamTZTimestampTypeObj newInstance() {
		ICFBamTZTimestampTypeObj inst = new CFBamTZTimestampTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampTypeObj.
	 */
	public ICFBamTZTimestampTypeEditObj newEditInstance( ICFBamTZTimestampTypeObj orig ) {
		ICFBamTZTimestampTypeEditObj edit = new CFBamTZTimestampTypeEditObj( orig );
		return( edit );
	}

	public ICFBamTZTimestampTypeObj realizeTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamTZTimestampTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTZTimestampTypeObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTZTimestampTypeObj)schema.getTZTimestampDefTableObj().realizeTZTimestampDef( Obj );

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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allTZTimestampType != null ) {
				allTZTimestampType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTZTimestampTypeObj)schema.getTZTimestampDefTableObj().realizeTZTimestampDef( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTZTimestampType != null ) {
				allTZTimestampType.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		forgetTZTimestampType( Obj, false );
	}

	public void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj, boolean forgetSubObjects ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTZTimestampTypeObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( allTZTimestampType != null ) {
				allTZTimestampType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTableColTableObj().forgetTableColByDataIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getTZTimestampDefTableObj().forgetTZTimestampDef( obj );
	}

	public void forgetTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = schema.getBackingStore().getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTZTimestampTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTZTimestampTypeByUNameIdx( long TenantId,
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
			ICFBamTZTimestampTypeObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetTZTimestampTypeByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapValTentIdx.values().iterator();
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

	public void forgetTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapScopeIdx.values().iterator();
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

	public void forgetTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetTZTimestampTypeByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapDataScopeIdx.values().iterator();
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

	public void forgetTZTimestampTypeByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapVAccSecIdx.values().iterator();
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

	public void forgetTZTimestampTypeByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapVAccFreqIdx.values().iterator();
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

	public void forgetTZTimestampTypeByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapEAccSecIdx.values().iterator();
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

	public void forgetTZTimestampTypeByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapEAccFreqIdx.values().iterator();
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

	public void forgetTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapPrevIdx.values().iterator();
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

	public void forgetTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapNextIdx.values().iterator();
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

	public void forgetTZTimestampTypeByContPrevIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapContPrevIdx.values().iterator();
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

	public void forgetTZTimestampTypeByContNextIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapContNextIdx.values().iterator();
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

	public void forgetTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		if( indexBySchemaIdx == null ) {
			return;
		}
		CFBamTZTimestampTypeBySchemaIdxKey key = schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( key );
			if( mapSchemaIdx != null ) {
				List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
				ICFBamTZTimestampTypeObj cur = null;
				Iterator<ICFBamTZTimestampTypeObj> iter = mapSchemaIdx.values().iterator();
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

	public ICFBamTZTimestampTypeObj createTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamTZTimestampTypeBuff buff = obj.getTZTimestampTypeBuff();
		schema.getBackingStore().getTableTZTimestampType().createTZTimestampType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "ZSTT" ) ) {
			obj = (ICFBamTZTimestampTypeObj)(obj.realize());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey ) {
		return( readTZTimestampType( pkey, false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTZTimestampTypeBuff readBuff = schema.getBackingStore().getTableTZTimestampType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTZTimestampTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTZTimestampTypeObj lockTZTimestampType( CFBamValuePKey pkey ) {
		ICFBamTZTimestampTypeObj locked = null;
		CFBamTZTimestampTypeBuff lockBuff = schema.getBackingStore().getTableTZTimestampType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTZTimestampTypeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTZTimestampType", pkey );
		}
		return( locked );
	}

	public List<ICFBamTZTimestampTypeObj> readAllTZTimestampType() {
		return( readAllTZTimestampType( false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readAllTZTimestampType( boolean forceRead ) {
		final String S_ProcName = "readAllTZTimestampType";
		if( ( allTZTimestampType == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> map = new HashMap<CFBamValuePKey,ICFBamTZTimestampTypeObj>();
			allTZTimestampType = map;
			CFBamTZTimestampTypeBuff[] buffList = schema.getBackingStore().getTableTZTimestampType().readAllDerived( schema.getAuthorization() );
			CFBamTZTimestampTypeBuff buff;
			ICFBamTZTimestampTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		int len = allTZTimestampType.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = allTZTimestampType.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		return( readTZTimestampTypeByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTZTimestampTypeObj obj = readTZTimestampType( pkey, forceRead );
		return( obj );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readTZTimestampTypeByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampTypeObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = schema.getBackingStore().getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTZTimestampTypeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId )
	{
		return( readTZTimestampTypeByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByValTentIdx";
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByValTentIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readTZTimestampTypeByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByScopeIdx";
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTZTimestampTypeByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDataScopeIdx( Short DataScopeId )
	{
		return( readTZTimestampTypeByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByDataScopeIdx";
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readTZTimestampTypeByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByVAccSecIdx";
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readTZTimestampTypeByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByVAccFreqIdx";
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readTZTimestampTypeByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByEAccSecIdx";
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readTZTimestampTypeByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByEAccFreqIdx";
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readTZTimestampTypeByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByPrevIdx";
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readTZTimestampTypeByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByNextIdx";
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readTZTimestampTypeByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByContPrevIdx";
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
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
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readTZTimestampTypeByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByContNextIdx";
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
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
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		return( readTZTimestampTypeBySchemaIdx( TenantId,
			SchemaDefId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeBySchemaIdx";
		CFBamTZTimestampTypeBySchemaIdxKey key = schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamTZTimestampTypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySchemaIdx.put( key, dict );
			ICFBamTZTimestampTypeObj obj;
			CFBamTZTimestampTypeBuff[] buffList = schema.getBackingStore().getTableTZTimestampType().readDerivedBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			CFBamTZTimestampTypeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realized = (ICFBamTZTimestampTypeObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampTypeObj updateTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		schema.getBackingStore().getTableTZTimestampType().updateTZTimestampType( schema.getAuthorization(),
			Obj.getTZTimestampTypeBuff() );
		if( Obj.getClassCode().equals( "ZSTT" ) ) {
			obj = (ICFBamTZTimestampTypeObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampType( schema.getAuthorization(),
			obj.getTZTimestampTypeBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamValueObj obj = readTZTimestampType( pkey );
		if( obj != null ) {
			ICFBamTZTimestampTypeEditObj editObj = (ICFBamTZTimestampTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTZTimestampTypeEditObj)obj.beginEdit();
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

	public void deleteTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampTypeObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteTZTimestampTypeByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByValTentIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByScopeIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTZTimestampTypeByDataScopeIdx( Short DataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteTZTimestampTypeByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteTZTimestampTypeByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteTZTimestampTypeByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteTZTimestampTypeByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}

	public void deleteTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByContPrevIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByContNextIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		CFBamTZTimestampTypeBySchemaIdxKey key = schema.getBackingStore().getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamTZTimestampTypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexBySchemaIdx.get( key );
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			schema.getBackingStore().getTableTZTimestampType().deleteTZTimestampTypeBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
		}
	}

	/**
	 *	Move the CFBamTZTimestampTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	public ICFBamTZTimestampTypeObj moveUpTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpTZTimestampType",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampTypeBuff buff = schema.getBackingStore().getTableTZTimestampType().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampTypeTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampTypeObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamTZTimestampTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	public ICFBamTZTimestampTypeObj moveDownTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownTZTimestampType",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampTypeBuff buff = schema.getBackingStore().getTableTZTimestampType().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampTypeTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampTypeObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
